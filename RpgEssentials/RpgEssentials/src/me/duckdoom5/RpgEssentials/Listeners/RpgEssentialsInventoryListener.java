package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.util.FurnaceRecipes;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.GenericSlot;
import org.getspout.spoutapi.gui.Slot;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsInventoryListener implements Listener{

	public static RpgEssentials plugin;
	
	public RpgEssentialsInventoryListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onFurnaceBurn(FurnaceBurnEvent event){
		Furnace furnace = (Furnace) event.getBlock().getState();
		ItemStack smelting = furnace.getInventory().getSmelting();
		ItemStack fuel = furnace.getInventory().getFuel();
		
		if(FurnaceRecipes.customrecipes.containsKey(smelting.getDurability())){
			ItemStack r = FurnaceRecipes.customrecipes.get(smelting.getDurability());
		}else if(smelting.getType().equals(Material.FLINT)){
			if(event.isBurning()){
				event.setBurning(false);
				event.setCancelled(true);
			}else{
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onFurnaceSmelt(FurnaceSmeltEvent event){
		Furnace furnace = (Furnace) event.getBlock().getState();
		ItemStack result = event.getResult();
		ItemStack source = event.getSource();
		
		if(FurnaceRecipes.customrecipes.containsKey(source.getDurability())){
			ItemStack r = FurnaceRecipes.customrecipes.get(source.getDurability());
			event.setResult(r);
		}else if(source.getType().equals(Material.FLINT)){
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		if(event.getInventory().getType().equals(InventoryType.PLAYER)){
			SpoutPlayer splayer = SpoutManager.getPlayer((Player) event.getPlayer());
			Slot slot = new GenericSlot();
			slot.setAnchor(WidgetAnchor.CENTER_RIGHT);
			slot.shiftXPos(-slot.getWidth() - 10);
			splayer.getCurrentScreen().attachWidget(plugin, slot);
		}
	}
}
