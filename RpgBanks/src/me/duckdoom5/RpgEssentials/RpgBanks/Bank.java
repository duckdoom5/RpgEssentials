package me.duckdoom5.RpgEssentials.RpgBanks;

import java.io.Serializable;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayerBank;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgBanks.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spout.inventory.CustomInventory;
import org.getspout.spoutapi.gui.ScreenType;

public class Bank implements Serializable{
	private static final long serialVersionUID = -7901987279586675508L;
	private RpgPlayerBank owner;
	
	private CustomItemStack[] inventory;
	
	public Bank(RpgPlayerBank owner){
		this.owner = owner;
		this.inventory = new CustomItemStack[9];
	}
	
	/**
	 * Opens the text menu for the player who clicked
	 @param splayer The spout player that clicked the npc.
	 **/
	public void clicked(RpgBanks plugin){
		String [] text = {};
		if(Configuration.config.getBoolean("bank.bankers.openbank")){
			String [] buttons = {"Open bank account", "Buy more room", "Close"};
			TextSelectMenu menu = new TextSelectMenu(plugin, owner.getSpoutPlayer(), "How can I help you ?",text , buttons, EntityType.PLAYER);
		}else{
			String [] buttons = {"Buy more room", "Close"};
			TextSelectMenu menu = new TextSelectMenu(plugin, owner.getSpoutPlayer(), "How can I help you ?",text , buttons, EntityType.PLAYER);
		}
	}
	
	/**
	 * Opens the player's safe
	 @param splayer The spout player that opened the safe.
	 **/
	public void open() {
		if(owner.getSpoutPlayer().getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				owner.getSpoutPlayer().getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		
		CustomInventory inventory = new CustomInventory(getSize(), "Bank");
		inventory.setMaxStackSize(64);
		
		for(int i = 0; i < getSize(); i++){
			if(this.inventory[i] != null){
				inventory.setItem(i, new ItemStack(this.inventory[i].getMaterial(), this.inventory[i].getAmount(), this.inventory[i].getDurability()));
			}
		}
		
		owner.getSpoutPlayer().openInventory(inventory);
	}
	
	/**
	 * Check if the player can and wants to upgrade.
	 @param splayer The spout player that wants to upgrade.
	 **/
	
	public void requestUpgrade(RpgBanks plugin){
		int newsize = getSize() + 9;
		if(newsize > 54){
			String [] buttons = {"Close"};
			String [] text = {"You can't upgrade anymore"};
			TextSelectMenu menu = new TextSelectMenu(plugin, owner.getSpoutPlayer(), "Your bank is on max size !",text , buttons, EntityType.PLAYER);
		}else{
			int price = Configuration.config.getInt("bank.size."+ newsize + ".price");
			double money = PlayerConfig.getMoney(owner.getName());
			if(money < price){
				String [] buttons = {"Close"};
				String [] text = {"You can't buy more room.", "You need to have: " + ChatColor.RED + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency")};
				TextSelectMenu menu = new TextSelectMenu(plugin, owner.getSpoutPlayer(), "Not enough money !",text , buttons, EntityType.PLAYER);
			}else{
				String [] buttons = {"Buy", "Close"};
				String [] text = {"Upgrading to " + newsize + " slots", "Price : " + ChatColor.GREEN + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency")};
				TextSelectMenu menu = new TextSelectMenu(plugin, owner.getSpoutPlayer(), "Are you sure ?",text , buttons, EntityType.PLAYER);
			}
		}
	}
	
	/**
	 * Upgrade the storage room for the player.
	 @param splayer The spout player that gets the upgrade.
	 **/
	public void upgradeSpace(RpgBanks plugin){
		if(owner.getSpoutPlayer().getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				owner.getSpoutPlayer().getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		int newsize = getSize() + 9;
		int price = Configuration.config.getInt("bank.size."+ newsize + ".price");
		double oldmoney = PlayerConfig.getMoney(owner.getName());
		PlayerConfig.setMoney(owner.getName(), oldmoney - price);
		CustomItemStack[] newinventory = new CustomItemStack[newsize];
		System.arraycopy(inventory, 0, newinventory, 0, inventory.length); 
		inventory = newinventory;
		
		owner.getSpoutPlayer().sendMessage(ChatColor.GREEN + "Your bank size has been changed to " + ChatColor.YELLOW + newsize);
		
		RpgEssentials.pm.savePlayer(owner.getName());
	}
	/**
	 * Gets the players current storage room.
	 @param splayer The spout player to get the size from.
	 **/
	public int getSize(){
		return inventory.length;
	}
	
	public void setInventory(CustomItemStack[] inventory) {
		this.inventory = inventory;
	}
	
	public ItemStack[] getInventory() {
		ItemStack[] inv = new ItemStack[inventory.length];
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i] != null){
				inv[i] = new ItemStack(this.inventory[i].getMaterial(), this.inventory[i].getAmount(), this.inventory[i].getDurability());
			}
		}
		
		return inv;
	}
}
