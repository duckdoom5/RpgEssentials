package me.duckdoom5.RpgEssentials.GUI;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreMethods extends StoreMenu{

	
	public StoreMethods(RpgEssentials instance) {
		super(instance);
	}
	
	static YamlConfiguration storeconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	public static void buyclick(SpoutPlayer splayer, Button button){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		
		int row = (int) ((button.getY() -20) / 20);
		
		GenericLabel page = StoreMenu.pagewidget.get(splayer);
		if(page.getText().equals("2")){
			row = row + 10;
		}else if(page.getText().equals("3")){
			row = row + 20;
		}else if(page.getText().equals("4")){
			row = row + 30;
		}else if(page.getText().equals("5")){
			row = row + 40;
		}else if(page.getText().equals("6")){
			row = row + 50;
		}
		
		GenericButton amount = amountwidget.get(splayer);
		int amount2 = Integer.parseInt(amount.getText());
		
		if(!StoreMenu.custom.isEmpty()){
			for (GenericCustomItem itemcheck:Hashmaps.customitems) {
				if(itemcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = (storeconfig.getInt("Store.custom.Item."+ itemcheck.getName() +".Price")) * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new SpoutItemStack(itemcheck, amount2));
						splayer.sendNotification(amount2 + "x " + itemcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(itemcheck), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (CustomOresDesign blockcheck:Hashmaps.customores) {
				if(blockcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = (storeconfig.getInt("Store.custom.Ores."+ blockcheck.getName() +".Price")) * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new SpoutItemStack(blockcheck, amount2));
						splayer.sendNotification(amount2 + "x " + blockcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(blockcheck), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (GenericCustomTool toolcheck:Hashmaps.customtools) {
				if(toolcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = (storeconfig.getInt("Store.custom.Tools."+ toolcheck.getName() +".Price")) * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new SpoutItemStack(toolcheck, amount2));
						splayer.sendNotification(amount2 + "x " + toolcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(toolcheck), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}else{
			for (Material material:StoreHashmaps.food) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Food", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.tools) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Tools", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.armour) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Armour", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.gardening) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Gardening", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.furniture) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Furniture", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mechanisms) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Mechanisms", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.brewing) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Brewing", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.materials) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.rawmaterials) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Raw Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.minerals) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Minerals", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.misc) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Miscellaneous", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mobdrops) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Mob Drops", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.music) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Music", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.nether) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Nether", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.ores) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Ores", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.painting) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Painting", material, row, amount2, splayer);
				}
			}
		}
	}
	public static void runBuy(String type, Material material, int row, int amount2, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		if(material.toString().toLowerCase().equals("wool") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("ink_sack") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("coal") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Raw Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("log") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("smooth_brick") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("double_step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("sapling") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("long_grass") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else{
			if(material.toString().equals(name.get(row).toString())){
				int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
				int money = playerconfig.getInt("players." + splayer.getName() + ".money");
				price2 = price2 * amount2;
				if(money < price2){
					splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new ItemStack(material, amount2));
					splayer.sendNotification(amount2 + "x " + material.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material), 1000);
					//money min price
					money = money - price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	public static void rundataBuy(String type, Material material, short data, int row, int amount2, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		int money = playerconfig.getInt("players." + splayer.getName() + ".money");
		price2 = price2 * amount2;
		if(money < price2){
			splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
		}else{
			splayer.getInventory().addItem(new ItemStack(material, amount2, data));
			splayer.sendNotification(amount2 + "x " + Methods.getDataName(material, data), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material, amount2, data), 1000);
			//money min price
			money = money - price2;
			playerconfig.set("players." + splayer.getName() + ".money", money);
			try {
				playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void sellclick(SpoutPlayer splayer, Button button){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		int row = (int) ((button.getY() -20) / 20);
		
		GenericLabel page = StoreMenu.pagewidget.get(splayer);
		if(page.getText().equals("2")){
			row = row + 10;
		}else if(page.getText().equals("3")){
			row = row + 20;
		}else if(page.getText().equals("4")){
			row = row + 30;
		}else if(page.getText().equals("5")){
			row = row + 40;
		}else if(page.getText().equals("6")){
			row = row + 50;
		}
		
		GenericButton amount = amountwidget.get(splayer);
		int amount2 = Integer.parseInt(amount.getText());
		
		if(!custom.isEmpty()){
			for (GenericCustomItem itemcheck:Hashmaps.customitems) {
				if(itemcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = ((storeconfig.getInt("Store.custom.Item."+ itemcheck.getName() +".Price")) * amount2) /2;
					splayer.getInventory().removeItem(new SpoutItemStack(itemcheck, amount2));
					splayer.sendNotification(amount2 + "x " + itemcheck.getName(), "Sold for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(itemcheck), 1000);
					//money plus price
					money = money + price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			for (CustomOresDesign blockcheck:Hashmaps.customores) {
				if(blockcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = ((storeconfig.getInt("Store.custom.Ores."+ blockcheck.getName() +".Price")) * amount2) /2;
					splayer.getInventory().removeItem(new SpoutItemStack(blockcheck, amount2));
					splayer.sendNotification(amount2 + "x " + blockcheck.getName(), "Sold for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(blockcheck), 1000);
					//money plus price
					money = money + price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			for (GenericCustomTool toolcheck:Hashmaps.customtools) {
				if(toolcheck.getName().equals(custom.get(row))){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					int price2 = ((storeconfig.getInt("Store.custom.Tools."+ toolcheck.getName() +".Price")) * amount2) /2;
					splayer.getInventory().removeItem(new SpoutItemStack(toolcheck, amount2));
					splayer.sendNotification(amount2 + "x " + toolcheck.getName(), "Sold for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(toolcheck), 1000);
					//money plus price
					money = money + price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			for (Material material:StoreHashmaps.food) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Food", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.tools) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Tools", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.armour) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Armour", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.gardening) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Gardening", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.furniture) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Furniture", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mechanisms) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Mechanisms", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.brewing) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Brewing", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.materials) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.rawmaterials) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Raw Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.minerals) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Minerals", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.misc) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Miscellaneous", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mobdrops) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Mob Drops", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.music) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Music", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.nether) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Nether", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.ores) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Ores", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.painting) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Painting", material, row, amount2, splayer);
				}
			}
		}
	}
	public static void runSell(String type, Material material, int row, int amount2, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		if(material.toString().toLowerCase().equals("wool") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("ink_sack") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("coal") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Raw Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("log") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("smooth_brick") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("double_step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("sapling") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("long_grass") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else{
			if(material.toString().equals(name.get(row).toString())){
				int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
				int money = playerconfig.getInt("players." + splayer.getName() + ".money");
				if(!splayer.getInventory().contains(material)){
					splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Please buy some!", new ItemStack(Material.ARROW), 1000);
				}else{
					if(!splayer.getInventory().contains(material, amount2)){
						splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Change your amount!", new ItemStack(Material.ARROW), 1000);
					}else{
						price2 = (price2 * amount2) / 2;
						
						splayer.getInventory().removeItem(new ItemStack(material, amount2));
						splayer.sendNotification(amount2 + "x " + material.toString().toLowerCase().replace("_", " "), "Sold for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material), 1000);
						//money plus price
						money = money + price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	}
	public static void rundataSell(String type, Material material, short data, int row, int amount2, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
		}
		
		int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		int money = playerconfig.getInt("players." + splayer.getName() + ".money");
		price2 = (price2 * amount2) / 2;
		
		splayer.getInventory().removeItem(new ItemStack(material, amount2, data));
		splayer.sendNotification(amount2 + "x " + Methods.getDataName(material, data), "Sold for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material, amount2, data), 1000);
		//money plus price
		money = money + price2;
		playerconfig.set("players." + splayer.getName() + ".money", money);
		try {
			playerconfig.save("plugins/RpgEssentials/Temp/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void nextclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) + 1;
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 2){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup2.get(splayer));
    	}else if(pagenum == 3){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup3.get(splayer));
    	}else if(pagenum == 4){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup4.get(splayer));
    	}else if(pagenum == 5){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup5.get(splayer));
    	}else if(pagenum == 6){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup6.get(splayer));
    	}
	}
	public static void prevclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) - 1;
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 1){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup1.get(splayer));
    	}else if(pagenum == 2){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup2.get(splayer));
    	}else if(pagenum == 3){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup3.get(splayer));
    	}else if(pagenum == 4){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup4.get(splayer));
    	}else if(pagenum == 5){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup5.get(splayer));
    	}
	}
}
