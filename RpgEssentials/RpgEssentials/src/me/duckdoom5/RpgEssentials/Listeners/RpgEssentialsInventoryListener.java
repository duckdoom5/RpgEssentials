package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.util.FurnaceRecipes;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.event.screen.ScreenOpenEvent;
import org.getspout.spoutapi.gui.ScreenType;
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
	public void onScreenOpen(ScreenOpenEvent event) {
		SpoutPlayer splayer = event.getPlayer();
		if(event.getScreenType().equals(ScreenType.PLAYER_INVENTORY) && !splayer.getGameMode().equals(GameMode.CREATIVE)){
			//event.setCancelled(true);
			//splayer.sendMessage("true");
			//splayer.getCurrentScreen().attachWidget(plugin, new GenericSlot().setWidth(50).setHeight(50).setX(0).setY(0).setAnchor(WidgetAnchor.TOP_LEFT));
			//splayer.getCurrentScreen().attachWidget(plugin, new GenericButton("test").setWidth(50).setHeight(50).setX(50).setY(0).setAnchor(WidgetAnchor.TOP_LEFT));
			//splayer.getMainScreen.attachPopup(popup);
		}
	}
}
