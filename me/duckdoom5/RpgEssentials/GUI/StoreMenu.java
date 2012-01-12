package me.duckdoom5.RpgEssentials.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreMenu {
 
	public static RpgEssentials plugin;
	public static GenericPopup store = new GenericPopup();
	public static GenericPopup store1 = new GenericPopup();
	public static GenericPopup store2 = new GenericPopup();
	public static GenericPopup group = new GenericPopup(); 
	public static GenericLabel page = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);

	public static GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	public static GenericLabel storelb1 = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	public static GenericLabel storelb2 = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	public static GenericLabel storelb3 = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	
	public static GenericButton amount1 = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
	public static GenericButton amount2 = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
	public static GenericButton amount3 = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
	
	public static GenericButton next = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	public static GenericButton next1 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	public static GenericButton next2 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	
	public static GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	public static GenericTexture BG1 = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	public static GenericTexture BG2 = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	public static GenericTexture BG3 = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);

	//row, name
	public static Map<Integer, String> custom = new HashMap<Integer, String>();
	public static Map<Integer, Material> name = new HashMap<Integer, Material>();
	public static Map<Integer, Widget> customblocks = new HashMap<Integer, Widget>();
	static int X = 2;
	static int Y = 15;
	
	static YamlConfiguration storeconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	public StoreMenu(RpgEssentials instance) {
        plugin = instance; 
    }
	public static void buyclick(SpoutPlayer splayer, Button button){
		int row = (int) ((button.getY() -Y) / 12.5);
		WidgetAnchor anchor = (button.getAnchor());
		if(anchor.equals(WidgetAnchor.TOP_CENTER)){
			row = row + 1;
		}
		
		if(page.getText().equals("2")){
			row = row + 20;
		}else if(page.getText().equals("3")){
			row = row + 40;
		}
		
		int amount2 = Integer.parseInt(amount1.getText());
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		if(!custom.isEmpty()){
			for (GenericCustomItem itemcheck:Hashmaps.customitems) {
				int price2 = storeconfig.getInt("Store.custom.Item."+ itemcheck.getName() +".Price");
				if(itemcheck.getName().equals(custom.get(row))){
					splayer.getInventory().addItem(new SpoutItemStack(itemcheck, amount2));
					splayer.sendNotification(itemcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(itemcheck), 1000);
				}
			}
			for (CustomOresDesign blockcheck:Hashmaps.customores) {
				int price2 = storeconfig.getInt("Store.custom.Ores."+ blockcheck.getName() +".Price");
				if(blockcheck.getName().equals(custom.get(row))){
					splayer.getInventory().addItem(new SpoutItemStack(blockcheck, amount2));
					splayer.sendNotification(blockcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(blockcheck), 1000);
					//money min price
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					money = money - price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			for (GenericCustomTool toolcheck:Hashmaps.customtools) {
				int price2 = storeconfig.getInt("Store.custom.Tools."+ toolcheck.getName() +".Price");
				if(toolcheck.getName().equals(custom.get(row))){
					splayer.getInventory().addItem(new SpoutItemStack(toolcheck, amount2));
					splayer.sendNotification(toolcheck.getName(), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new SpoutItemStack(toolcheck), 1000);
					//money min price
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					money = money - price2;
					playerconfig.set("players." + splayer.getName() + ".money", money);
					try {
						playerconfig.save("plugins/RpgEssentials/players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			for (Material foodmaterial:StoreHashmaps.food) {
				int price2 = storeconfig.getInt("Store.Food."+ foodmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(foodmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(foodmaterial, amount2));
						splayer.sendNotification(foodmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(foodmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material toolmaterial:StoreHashmaps.tools) {
				int price2 = storeconfig.getInt("Store.Tools."+ toolmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(toolmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(toolmaterial, amount2));
						splayer.sendNotification(toolmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(toolmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material armourmaterial:StoreHashmaps.armour) {
				int price2 = storeconfig.getInt("Store.Armour."+ armourmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(armourmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(armourmaterial, amount2));
						splayer.sendNotification(armourmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(armourmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material gardenmaterial:StoreHashmaps.gardening) {
				int price2 = storeconfig.getInt("Store.Gardening."+ gardenmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(gardenmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(gardenmaterial, amount2));
						splayer.sendNotification(gardenmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(gardenmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material furnmaterial:StoreHashmaps.furniture) {
				int price2 = storeconfig.getInt("Store.Furniture."+ furnmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(furnmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(furnmaterial, amount2));
						splayer.sendNotification(furnmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(furnmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material mechmaterial:StoreHashmaps.mechanisms) {
				int price2 = storeconfig.getInt("Store.Mechanisms."+ mechmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(mechmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(mechmaterial, amount2));
						splayer.sendNotification(mechmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(mechmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material brewmaterial:StoreHashmaps.brewing) {
				int price2 = storeconfig.getInt("Store.Brewing."+ brewmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(brewmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(brewmaterial, amount2));
						splayer.sendNotification(brewmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(brewmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material matmaterial:StoreHashmaps.materials) {
				int price2 = storeconfig.getInt("Store.Materials."+ matmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(matmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(matmaterial, amount2));
						splayer.sendNotification(matmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(matmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material rawmaterial:StoreHashmaps.rawmaterials) {
				int price2 = storeconfig.getInt("Store.Raw Materials."+ rawmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(rawmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(rawmaterial, amount2));
						splayer.sendNotification(rawmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(rawmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material minmaterial:StoreHashmaps.minerals) {
				int price2 = storeconfig.getInt("Store.Minerals."+ minmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(minmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(minmaterial, amount2));
						splayer.sendNotification(minmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(minmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material miscmaterial:StoreHashmaps.misc) {
				int price2 = storeconfig.getInt("Store.Misc."+ miscmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(miscmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(miscmaterial, amount2));
						splayer.sendNotification(miscmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(miscmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material mobmaterial:StoreHashmaps.mobdrops) {
				int price2 = storeconfig.getInt("Store.Mob Drops."+ mobmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(mobmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(mobmaterial, amount2));
						splayer.sendNotification(mobmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(mobmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material musicmaterial:StoreHashmaps.music) {
				int price2 = storeconfig.getInt("Store.Music."+ musicmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(musicmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(musicmaterial, amount2));
						splayer.sendNotification(musicmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(musicmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material nethmaterial:StoreHashmaps.nether) {
				int price2 = storeconfig.getInt("Store.Nether."+ nethmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(nethmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(nethmaterial, amount2));
						splayer.sendNotification(nethmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(nethmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material orematerial:StoreHashmaps.ores) {
				int price2 = storeconfig.getInt("Store.Ores."+ orematerial.toString().toLowerCase().replace("_", " ") +".Price");
				if(orematerial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(orematerial, amount2));
						splayer.sendNotification(orematerial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(orematerial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (Material paintmaterial:StoreHashmaps.painting) {
				int price2 = storeconfig.getInt("Store.Painting."+ paintmaterial.toString().toLowerCase().replace("_", " ") +".Price");
				if(paintmaterial.toString().equals(name.get(row).toString())){
					int money = playerconfig.getInt("players." + splayer.getName() + ".money");
					price2 = price2 * amount2;
					if(money < price2){
						splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
					}else{
						splayer.getInventory().addItem(new ItemStack(paintmaterial, amount2));
						splayer.sendNotification(paintmaterial.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(paintmaterial), 1000);
						//money min price
						money = money - price2;
						playerconfig.set("players." + splayer.getName() + ".money", money);
						try {
							playerconfig.save("plugins/RpgEssentials/players.yml");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	public static void nextclick(Plugin plugin, SpoutPlayer splayer){
		int pagenum = Integer.parseInt(page.getText()) + 1;
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 2){
    		store.close();
    		splayer.getMainScreen().attachPopupScreen(store1);
    	}else if(pagenum == 3){
    		store1.close();
    		splayer.getMainScreen().attachPopupScreen(store2);
    	}
	}
	public static void prevclick(Plugin plugin, SpoutPlayer splayer){
		
		int pagenum = Integer.parseInt(page.getText()) - 1;
		page.setText(Integer.toString(pagenum));
    	splayer.getMainScreen().closePopup();
    	if(pagenum == 1){
    		splayer.getMainScreen().closePopup();
    		splayer.getMainScreen().attachPopupScreen(store);
    	}else if(pagenum == 2){
    		splayer.getMainScreen().closePopup();
    		splayer.getMainScreen().attachPopupScreen(store1);
    	}
	}
	
	public static void addcustomoreblock(Plugin plugin, int startY, int startX, int row, int price2, String currency, CustomOresDesign block, WidgetAnchor anchor, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		store.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(block)).setDepth(8).setHeight(8).setWidth(8).setTooltip(block.getName()).setX(startX).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
		
		store.attachWidget(plugin, new GenericLabel().setText(block.getName()).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
		
		if(custom.containsKey(row)){
			custom.put(row + 1, block.getName());
		}else{
			custom.put(row, block.getName());
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
		} else {
			store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			store.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
		} else {
			store.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));	
		}
		
	}
	
	public static void addmaterialanddata(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material,short data , WidgetAnchor anchor, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name2 = material.toString().toLowerCase().replace("_", " ");
		if(name2.equals("wool")){
			name2 = "Color " + name2;
		}else if(name2.equals("ink sack")){
			name2 = name2 + " Color";
		}
		
		if(row < 20){
			store.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setData(data).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
			
			store.attachWidget(plugin, new GenericLabel().setText(name2).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			} else {
				store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
			} else {
				store.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));	
			}
	    	store.attachWidget(plugin, new GenericButton("Prev").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	
	    	store.attachWidget(plugin, next.setEnabled(false));
	    	
		}else if(row < 40){
			
			next.setEnabled(true);
			
			store1.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setData(data).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));
			
			store1.attachWidget(plugin, new GenericLabel().setText(name2).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			} else {
				store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));
			} else {
				store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));	
			}
			
			store1.attachWidget(plugin, new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store1.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store1.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	store1.attachWidget(plugin, next1.setEnabled(false));
			
		}else if(row < 60){

			next1.setEnabled(true);
			
			store2.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setData(data).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));
			
			store2.attachWidget(plugin, new GenericLabel().setText(name2).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store2.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			} else {
				store2.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store2.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));
			} else {
				store2.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));	
			}
			
			store2.attachWidget(plugin, new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store2.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store2.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	store2.attachWidget(plugin, next2.setEnabled(false));
		}
	}
	
	public static void addmaterial(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material, WidgetAnchor anchor, SpoutPlayer splayer){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(row < 20){
			store.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
			
			store.attachWidget(plugin, new GenericLabel().setText(material.toString().toLowerCase().replace("_", " ")).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			} else {
				store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));
			} else {
				store.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 12.5))).setAnchor(anchor));	
			}
	    	store.attachWidget(plugin, new GenericButton("Prev").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	
	    	store.attachWidget(plugin, next.setEnabled(false));
	    	
		}else if(row < 40){
			
			next.setEnabled(true);
			
			store1.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));
			
			store1.attachWidget(plugin, new GenericLabel().setText(material.toString().toLowerCase().replace("_", " ")).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			} else {
				store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 20) * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));
			} else {
				store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 20) * 12.5))).setAnchor(anchor));	
			}
			
			store1.attachWidget(plugin, new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store1.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store1.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	store1.attachWidget(plugin, next1.setEnabled(false));
			
		}else if(row < 60){

			next1.setEnabled(true);
			
			store2.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));
			
			store2.attachWidget(plugin, new GenericLabel().setText(material.toString().toLowerCase().replace("_", " ")).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			
			if(name.containsKey(row)){
				name.put(row + 1, material);
			}else{
				name.put(row, material);
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store2.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			} else {
				store2.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + ((row - 40) * 12.5))).setAnchor(anchor));
			}
			
			if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
				store2.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));
			} else {
				store2.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + ((row - 40) * 12.5))).setAnchor(anchor));	
			}
			
			store2.attachWidget(plugin, new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store2.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	store2.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
	    	store2.attachWidget(plugin, next2.setEnabled(false));
		}
	}
	
	public static void store(Plugin plugin, SpoutPlayer splayer, String subgroupstr, String pagenum) {
		try {
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String currency = storeconfig.getString("Store.Currency");
		
    	int row = 0;
    	custom.clear();
    	name.clear();
    	amount1.setText("1");
    	amount2.setText("1");
		amount3.setText("1");
    	page.setText("1");
    	store.removeWidgets(plugin);
    	store1.removeWidgets(plugin);
    	store2.removeWidgets(plugin);
    	if(subgroupstr.equals("Food")) {
    		for (Material material:StoreHashmaps.food) {
    			int price2 = storeconfig.getInt("Store.Food."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
    		if(pagenum.equals("2")){
    			nextclick(plugin, splayer);
    		}else if(pagenum.equals("3")){
    			nextclick(plugin, splayer);
    			nextclick(plugin, splayer);
    		}
        }else if(subgroupstr.equals("Tools")){
        	for (Material material:StoreHashmaps.tools) {
        		int price2 = storeconfig.getInt("Store.Tools."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Armour")){
        	for (Material material:StoreHashmaps.armour) {
        		int price2 = storeconfig.getInt("Store.Armour."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Mechanisms")){
        	for (Material material:StoreHashmaps.mechanisms) {
        		int price2 = storeconfig.getInt("Store.Mechanisms."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Gardening")){
        	for (Material material:StoreHashmaps.gardening) {
        		int price2 = storeconfig.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Raw Materials")){
        	for (Material material:StoreHashmaps.rawmaterials) {
        		int price2 = storeconfig.getInt("Store.Raw Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Furniture")){
        	for (Material material:StoreHashmaps.furniture) {
        		int price2 = storeconfig.getInt("Store.Furniture."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Miscellaneous")){
        	for (Material material:StoreHashmaps.misc) {
        		int price2 = storeconfig.getInt("Store.Miscellaneous."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Materials")){
        	for (Material material:StoreHashmaps.materials) {
        		int price2 = storeconfig.getInt("Store.Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = storeconfig.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Minerals")){
        	for (Material material:StoreHashmaps.minerals) {
        		int price2 = storeconfig.getInt("Store.Minerals."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Ores")){
        	for (CustomOresDesign block:Hashmaps.customores) {
        		int price2 = storeconfig.getInt("Store.custom.Ores."+ block.getName() +".Price");
        		if(row % 2 == 0){
    	    		addcustomoreblock(plugin,Y,X,row,price2,currency,block, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addcustomoreblock(plugin,Y,X,row - 1,price2,currency,block, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        	for (Material material:StoreHashmaps.ores) {
        		int price2 = storeconfig.getInt("Store.Ores."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Painting")){
        	for (Material material:StoreHashmaps.painting) {
        		if(material.equals(Material.WOOL)){
        			for (short data = 0; data <= 15; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, 1000,currency, material, data, WidgetAnchor.TOP_LEFT, splayer);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, 1000,currency, material, data, WidgetAnchor.TOP_CENTER, splayer);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.INK_SACK)){
        			for (short data = 0; data <= 15; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, 1000,currency, material, data, WidgetAnchor.TOP_LEFT, splayer);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, 1000,currency, material, data, WidgetAnchor.TOP_CENTER, splayer);
                		}
        				row++;
        			}
        		}else{
	        		if(row % 2 == 0){
	    	    		addmaterial(plugin,Y,X,row,1000,currency,material, WidgetAnchor.TOP_LEFT, splayer);
	        		} else {
	        			addmaterial(plugin,Y,X,row - 1,1000,currency,material, WidgetAnchor.TOP_CENTER, splayer);
	        		}
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Mob Drops")){
        	for (Material material:StoreHashmaps.mobdrops) {
        		int price2 = storeconfig.getInt("Store.Mob Drops."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Brewing")){
        	for (Material material:StoreHashmaps.brewing) {
        		int price2 = storeconfig.getInt("Store.Brewing."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Music")){
        	for (Material material:StoreHashmaps.music) {
        		int price2 = storeconfig.getInt("Store.Music."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = storeconfig.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer);
        		}
        		row++;
        	}
        }
    	
    	store.attachWidget(plugin, BG1).attachWidget(plugin, storelb1).attachWidget(plugin, amount1);
    	
    	store1.attachWidget(plugin, BG2).attachWidget(plugin, storelb2).attachWidget(plugin, amount2);
    	
    	store2.attachWidget(plugin, BG3).attachWidget(plugin, storelb3).attachWidget(plugin, amount3);
    	
        splayer.getMainScreen().closePopup();
        splayer.getMainScreen().attachPopupScreen(store);
    }
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		
		GenericButton food = new GenericButton("Food");
		GenericButton tools = new GenericButton("Tools");
		GenericButton armour = new GenericButton("Armour");
		GenericButton mech = new GenericButton("Mechanisms");
		GenericButton gard = new GenericButton("Gardening");
		GenericButton furn = new GenericButton("Furniture");
		GenericButton mat = new GenericButton("Materials");
		GenericButton rawmat = new GenericButton("Raw Materials");
		GenericButton mine = new GenericButton("Minerals");
		GenericButton ore = new GenericButton("Ores");
		GenericButton paint = new GenericButton("Painting");
		GenericButton mob = new GenericButton("Mob Drops");
		GenericButton brew = new GenericButton("Brewing");
		GenericButton music = new GenericButton("Music");
		GenericButton nether = new GenericButton("Nether");
		GenericButton misc = new GenericButton("Miscellaneous");
		GenericButton close = new GenericButton("Close");
		int Y = 25;
        
		food.setWidth(200).setHeight(20).shiftXPos(- 5 - food.getWidth()).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
		
		tools.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
		
		armour.setWidth(200).setHeight(20).shiftXPos(- 5 - armour.getWidth()).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
		
		mech.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
		
		gard.setWidth(200).setHeight(20).shiftXPos(- 5 - gard.getWidth()).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
		
		furn.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
		
		mat.setWidth(200).setHeight(20).shiftXPos(- 5 - mat.getWidth()).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
		
		rawmat.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
		
		mine.setWidth(200).setHeight(20).shiftXPos(- 5 - mine.getWidth()).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER);
		
		ore.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER);
		
		paint.setWidth(200).setHeight(20).shiftXPos(- 5 - paint.getWidth()).setY(Y + 125).setAnchor(WidgetAnchor.TOP_CENTER);
		
		mob.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 125).setAnchor(WidgetAnchor.TOP_CENTER);
		
		brew.setWidth(200).setHeight(20).shiftXPos(- 5 - brew.getWidth()).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER);
		
		music.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER);
		
		nether.setWidth(200).setHeight(20).shiftXPos(- 5 - nether.getWidth()).setY(Y + 175).setAnchor(WidgetAnchor.TOP_CENTER);
		
		misc.setWidth(200).setHeight(20).shiftXPos(+ 5).setY(Y + 175).setAnchor(WidgetAnchor.TOP_CENTER);
		
		close.setWidth(200).setHeight(20).shiftXPos(- close.getWidth() / 2).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		   	
		group.removeWidgets(plugin).attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, food).attachWidget(plugin, tools).attachWidget(plugin, armour).attachWidget(plugin, mech).attachWidget(plugin, gard).attachWidget(plugin, furn).attachWidget(plugin, mat).attachWidget(plugin, rawmat).attachWidget(plugin, mine).attachWidget(plugin, ore).attachWidget(plugin, paint).attachWidget(plugin, mob).attachWidget(plugin, brew).attachWidget(plugin, music).attachWidget(plugin, nether).attachWidget(plugin, misc).attachWidget(plugin, close);
    	
    	splayer.getMainScreen().closePopup();
		splayer.getMainScreen().attachPopupScreen(group);
	}
}