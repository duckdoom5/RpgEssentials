package me.duckdoom5.RpgEssentials.RpgBanks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgBanks.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spout.inventory.CustomInventory;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Bank {
	
	/**
	 * Opens the text menu for the player who clicked
	 @param splayer The spout player that clicked the npc.
	 **/
	public static void Clicked(RpgBanks plugin, SpoutPlayer splayer){
		String [] text = {};
		if(Configuration.config.getBoolean("bank.bankers.openbank")){
			String [] buttons = {"Open bank account", "Buy more room", "Close"};
			new TextSelectMenu(plugin, splayer, "How can I help you ?",text , buttons, EntityType.PLAYER);
		}else{
			String [] buttons = {"Buy more room", "Close"};
			new TextSelectMenu(plugin, splayer, "How can I help you ?",text , buttons, EntityType.PLAYER);
		}
	}
	
	/**
	 * Opens the player's safe
	 @param splayer The spout player that opened the safe.
	 **/
	public static void open(RpgBanks plugin, SpoutPlayer splayer) {
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
		
		List<?> list = Configuration.bank.getList("Bank." + splayer.getName() + ".items");
		int size = Configuration.bank.getInt("Bank." + splayer.getName() + ".size");
		
		Iterator<?> keys = list.iterator();
		String [] row;
		int id,amount;
		short data;
		CustomInventory inventory = new CustomInventory(size, "Bank");
		inventory.setMaxStackSize(64);
		
		for(int count = 0; keys.hasNext(); count++){
			row = keys.next().toString().split(":");
			id = Integer.parseInt(row[0]);
			data = Short.parseShort(row[1]);
			amount = Integer.parseInt(row[2]);
			if(id != 0){
				ItemStack material = new ItemStack(Material.getMaterial(id), amount, data);
				inventory.setItem(count, material);
			}
		}
		
		splayer.openInventory(inventory);
	}
	
	/**
	 * Check if the player can and wants to upgrade.
	 @param splayer The spout player that wants to upgrade.
	 **/
	
	public static void requestUpgrade(RpgBanks plugin, SpoutPlayer splayer){
		if(! Configuration.bank.contains("Bank." + splayer.getName() + ".items")){
			Configuration.bank.set("Bank." + splayer.getName() + ".items", Arrays.asList("0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0","0:-1:0"));
			Configuration.bank.set("Bank." + splayer.getName() + ".size", 9);
			try {
				Configuration.bank.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int newsize = Configuration.bank.getInt("Bank." + splayer.getName() + ".size") + 9;
		if(newsize > 54){
			String [] buttons = {"Close"};
			String [] text = {"You can't upgrade anymore"};
			new TextSelectMenu(plugin, splayer, "Your bank is on max size !",text , buttons, EntityType.PLAYER);
		}else{
			int price = Configuration.config.getInt("bank.size."+ newsize + ".price");
			double money = PlayerConfig.getMoney(splayer.getName());
			if(money < price){
				String [] buttons = {"Close"};
				String [] text = {"You can't buy more room.", "You need to have: " + ChatColor.RED + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency")};
				new TextSelectMenu(plugin, splayer, "Not enough money !",text , buttons, EntityType.PLAYER);
			}else{
				String [] buttons = {"Accept size change", "Close"};
				String [] text = {"Upgrading to " + newsize + " slots", "Price : " + ChatColor.GREEN + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency")};
				new TextSelectMenu(plugin, splayer, "Are you sure ?",text , buttons, EntityType.PLAYER);
			}
		}
	}
	
	/**
	 * Upgrade the storage room for the player.
	 @param splayer The spout player that gets the upgrade.
	 **/
	public static void upgradeSpace(RpgBanks plugin, SpoutPlayer splayer){
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		int newsize = getSize(splayer) + 9;
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
	/**
	 * Gets the players current storage room.
	 @param splayer The spout player to get the size from.
	 **/
	public static int getSize(SpoutPlayer splayer){
		return Configuration.bank.getInt("Bank." + splayer.getName() + ".size");
	}
}
