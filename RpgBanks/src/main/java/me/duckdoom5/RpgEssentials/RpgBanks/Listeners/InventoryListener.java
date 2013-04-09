package me.duckdoom5.RpgEssentials.RpgBanks.Listeners;

import java.io.IOException;
import java.util.Arrays;

import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;

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
			
			ItemStack[] items = inventory.getContents();
			String[] set = new String[items.length];
			
			for(int i = 0; i < items.length; i++){
	    		if(items[i] != null){
	    			int amount = items[i].getAmount();
	    			int id = items[i].getType().getId();
	    			short data = items[i].getDurability();
	    			set[i] = Integer.toString(id) + ":" + Integer.toString(data) + ":" + Integer.toString(amount);
	    		}else{
	    			set[i] = "0:-1:0";
	    		}
	    	}
			
			Configuration.bank.set("Bank." + player.getName() + ".items", Arrays.asList(set));
			
			try {
				Configuration.bank.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			inventory.clear();
		}
	}
}
