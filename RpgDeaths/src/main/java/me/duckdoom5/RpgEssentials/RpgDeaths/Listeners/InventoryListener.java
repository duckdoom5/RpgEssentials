package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import me.duckdoom5.RpgEssentials.RpgDeaths.DeathChests;
import me.duckdoom5.RpgEssentials.RpgDeaths.DeathPlayer;
import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.block.Block;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener{
	public static RpgDeaths plugin;
	
	public InventoryListener(RpgDeaths instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();
		if(inventory.getType().equals(InventoryType.CHEST)){
			if(inventory instanceof DoubleChestInventory){
				DoubleChestInventory c = (DoubleChestInventory) inventory;
				DoubleChest chest = c.getHolder();
				Block block = chest.getLocation().getBlock();
				if(BlockListener.protect.containsKey(block.getLocation())){
					if(Methods.isInventoryEmpty(inventory.getContents())){
						DeathPlayer deathplayer = DeathChests.getDeathPlayer(player.getName());
						
						deathplayer.removeChest();
					}
				}
			}
		}
	}
}
