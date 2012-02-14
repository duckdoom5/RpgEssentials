package me.duckdoom5.RpgEssentials.banking;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spout.inventory.CustomInventory;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Bank {
	
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		
		if(! Configuration.bank.contains("Bank." + splayer.getName() + ".items")){
			Configuration.bank.set("Bank." + splayer.getName() + ".items", Arrays.asList("0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0"));
			Configuration.bank.set("Bank." + splayer.getName() + ".size", 9);
			try {
				Configuration.bank.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		List list = Configuration.bank.getList("Bank." + splayer.getName() + ".items");
		int size = Configuration.bank.getInt("Bank." + splayer.getName() + ".size");
		
		Iterator keys = list.iterator();
		String [] row;
		int id,amount;
		short data;
		CustomInventory inventory = new CustomInventory(size, "Bank");
		
		for(int count = 0; keys.hasNext(); count++){
			row = keys.next().toString().split(":");
			id = Integer.parseInt(row[0]);
			data = Short.parseShort(row[1]);
			amount = Integer.parseInt(row[2]);
			
			ItemStack material = new ItemStack(Material.getMaterial(id), amount, data);
			
			inventory.addItem(material);
		}
		
		splayer.openInventoryWindow(inventory);
	}
}
