package me.duckdoom5.RpgEssentials.banking;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
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
	
	public static void sure(RpgEssentials plugin, SpoutPlayer splayer){
		int newsize = Configuration.bank.getInt("Bank." + splayer.getName() + ".size") + 9;
		if(newsize > 54){
			String [] buttons = {"Close"};
			String [] text = {"You can't upgrade anymore"};
			TextSelectMenu.open(plugin, splayer, "Your bank is on max size !",text , buttons);
		}else{
			int price = Configuration.config.getInt("bank.size."+ newsize + ".price");
			double money = PlayerConfig.getMoney(splayer.getName());
			if(money < price){
				String [] buttons = {"Close"};
				String [] text = {"You can't buy more room.", "You need to have: " + price + " " + Configuration.config.getString("store.currency")};
				TextSelectMenu.open(plugin, splayer, "Not enough money !",text , buttons);
			}else{
				String [] buttons = {"Accept size change", "Close"};
				String [] text = {"Upgrading to " + newsize + " slots", "Price : " + price + " " + Configuration.config.getString("store.currency")};
				TextSelectMenu.open(plugin, splayer, "Are you sure ?",text , buttons);
			}
		}
	}
	
	public static void change(RpgEssentials plugin, SpoutPlayer splayer){
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		int newsize = Configuration.bank.getInt("Bank." + splayer.getName() + ".size") + 9;
		int price = Configuration.config.getInt("bank.size."+ newsize + ".price");
		double oldmoney = PlayerConfig.getMoney(splayer.getName());
		double money = oldmoney - price;
		PlayerConfig.setMoney(splayer.getName(), money);
		Configuration.bank.set("Bank." + splayer.getName() + ".size", newsize);
		splayer.sendMessage(ChatColor.GREEN + "Your bank size has been changed to " + ChatColor.YELLOW + newsize);
		try {
			Configuration.bank.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
