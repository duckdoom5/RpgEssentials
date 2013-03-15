package me.duckdoom5.RpgEssentials.RpgBanks.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgBanks.CustomItemStack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener{

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();
		if(inventory.getName().equals("Bank")){
			ItemStack[] inv = inventory.getContents();
			CustomItemStack[] cinv = new CustomItemStack[inv.length];
			
			for(int i = 0; i < inv.length; i++){
				if(inv[i] != null){
					cinv[i] = new CustomItemStack(inv[i].getTypeId(), inv[i].getAmount(), inv[i].getDurability());
				}
			}
			
			RpgEssentials.pm.getRpgPlayerBank(player).getBank().setInventory(cinv);
			
			RpgEssentials.pm.savePlayer(player.getName());
			
			inventory.clear();
		}
	}
}
