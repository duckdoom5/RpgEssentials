package me.duckdoom5.RpgEssentials.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import me.duckdoom5.RpgEssentials.util.Methodes;

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
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreMenu {
 
	public static RpgEssentials plugin;

	//row, name
	public static Map<Integer, String> custom = new HashMap<Integer, String>();
	public static Map<Integer, Short> datamap = new HashMap<Integer, Short>();
	public static Map<Integer, Material> name = new HashMap<Integer, Material>();
	public static Map<Integer, Widget> customblocks = new HashMap<Integer, Widget>();
	public static Map<SpoutPlayer, GenericPopup> storepopup1 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericPopup> storepopup2 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericPopup> storepopup3 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericLabel> pagewidget = new HashMap<SpoutPlayer, GenericLabel>();
	public static Map<SpoutPlayer, GenericLabel> moneywidget = new HashMap<SpoutPlayer, GenericLabel>();
	public static Map<SpoutPlayer, GenericButton> amountwidget = new HashMap<SpoutPlayer, GenericButton>();
	static int X = 2;
	static int Y = 15;
	
	static YamlConfiguration storeconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	public StoreMenu(RpgEssentials instance) {
        plugin = instance; 
    }
	public static void buyclick(SpoutPlayer splayer, Button button){
		int row = (int) ((button.getY() -Y) / 10);
		WidgetAnchor anchor = (button.getAnchor());
		if(anchor.equals(WidgetAnchor.TOP_CENTER)){
			row = row + 1;
		}
		GenericLabel page = pagewidget.get(splayer);
		if(page.getText().equals("2")){
			row = row + 20;
		}else if(page.getText().equals("3")){
			row = row + 40;
		}
		
		int amount2 = 1; //Integer.parseInt(amount.getText());
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
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
						playerconfig.save("plugins/RpgEssentials/Players.yml");
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
						playerconfig.save("plugins/RpgEssentials/Players.yml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			for (Material material:StoreHashmaps.food) {
				runBuy("Food", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.tools) {
				runBuy("Tools", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.armour) {
				runBuy("Armour", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.gardening) {
				if(material.toString().toLowerCase().equals("sapling")){
					Short data = datamap.get(row);
					rundataBuy("Gardening", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("long_grass")){
					Short data = datamap.get(row);
					rundataBuy("Gardening", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("leaves")){
					Short data = datamap.get(row);
					rundataBuy("Gardening", material, data, row, amount2, splayer);
				}else{
					runBuy("Gardening", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.furniture) {
				runBuy("Furniture", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.mechanisms) {
				runBuy("Mechanisms", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.brewing) {
				runBuy("Brewing", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.materials) {
				if(material.toString().toLowerCase().equals("log")){
					Short data = datamap.get(row);
					rundataBuy("Materials", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("leaves")){
					Short data = datamap.get(row);
					rundataBuy("Materials", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("smooth_brick")){
					Short data = datamap.get(row);
					rundataBuy("Materials", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("step")){
					Short data = datamap.get(row);
					rundataBuy("Materials", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("double_step")){
					Short data = datamap.get(row);
					rundataBuy("Materials", material, data, row, amount2, splayer);
				}else{
					runBuy("Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.rawmaterials) {
				if(material.toString().toLowerCase().equals("coal")){
					Short data = datamap.get(row);
					rundataBuy("Raw Materials", material, data, row, amount2, splayer);
				}else{
					runBuy("Raw Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.minerals) {
				runBuy("Minerals", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.misc) {
				runBuy("Miscellaneous", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.mobdrops) {
				runBuy("Mob Drops", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.music) {
				runBuy("Music", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.nether) {
				runBuy("Nether", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.ores) {
				runBuy("Ores", material, row, amount2, splayer);
			}
			for (Material material:StoreHashmaps.painting) {
				if(material.toString().toLowerCase().equals("wool")){
					Short data = datamap.get(row);
					rundataBuy("Painting", material, data, row, amount2, splayer);
				}else if(material.toString().toLowerCase().equals("ink_sack")){
					Short data = datamap.get(row);
					rundataBuy("Painting", material, data, row, amount2, splayer);
				}
			}
		}
	}
	public static void runBuy(String type, Material material, int row, int amount2, SpoutPlayer splayer){
		int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		if(material.toString().equals(name.get(row).toString())){
			int money = playerconfig.getInt("players." + splayer.getName() + ".money");
			price2 = price2 * amount2;
			if(money < price2){
				splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
			}else{
				splayer.getInventory().addItem(new ItemStack(material, amount2));
				splayer.sendNotification(material.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material), 1000);
				//money min price
				money = money - price2;
				playerconfig.set("players." + splayer.getName() + ".money", money);
				try {
					playerconfig.save("plugins/RpgEssentials/Players.yml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void rundataBuy(String type, Material material, short data, int row, int amount2, SpoutPlayer splayer){
		int price2 = storeconfig.getInt("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		if(material.toString().equals(name.get(row).toString())){
			int money = playerconfig.getInt("players." + splayer.getName() + ".money");
			price2 = price2 * amount2;
			if(money < price2){
				splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
			}else{
				splayer.getInventory().addItem(new ItemStack(material, amount2, data));
				splayer.sendNotification(Methodes.getDataName(material, data), "Bought for: " + price2 +" "+ storeconfig.getString("Store.Currency"), new ItemStack(material, amount2, data), 1000);
				//money min price
				money = money - price2;
				playerconfig.set("players." + splayer.getName() + ".money", money);
				try {
					playerconfig.save("plugins/RpgEssentials/Players.yml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
    	}
	}
	
	public static void addcustomoreblock(Plugin plugin, int startY, int startX, int row, int price2, String currency, CustomOresDesign block, WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store, GenericPopup store1, GenericPopup store2){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		store.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(block)).setDepth(8).setHeight(8).setWidth(8).setTooltip(block.getName()).setX(startX).setY((int) (startY + (row * 10))).setAnchor(anchor));
		
		store.attachWidget(plugin, new GenericLabel().setText(block.getName()).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (row * 10))).setAnchor(anchor));
		
		if(custom.containsKey(row)){
			custom.put(row + 1, block.getName());
		}else{
			custom.put(row, block.getName());
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 10))).setAnchor(anchor));
		} else {
			store.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 10))).setAnchor(anchor));
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			store.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 10))).setAnchor(anchor));
		} else {
			store.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 10))).setAnchor(anchor));	
		}
		storepopup1.put(splayer, store);
		
	}
	
	public static void addmaterialanddata(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material,short data , WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store, GenericPopup store1, GenericPopup store2){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name2 = Methodes.getDataName(material, data);
		
		GenericPopup page;
		Map map;
		int pos;
		GenericButton next;
		GenericButton next1 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next2 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next3 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev;
		GenericButton prev1 = (GenericButton) new GenericButton("Prev").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev2 = (GenericButton) new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		
		if(row < 20){
			next = next1;
			prev = prev1;
			page = store;
			map = storepopup1;
			pos = row;
		}else if(row < 40){
			store.removeWidget(next1);
			next1.setEnabled(true).setPriority(RenderPriority.Lowest);
			store.attachWidget(plugin, next1);
	    	storepopup1.put(splayer, store);
			next = next2;
			prev = prev2;
			page = store1;
			map = storepopup2;
			pos = row - 20;
		}else{
			store1.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store1.attachWidget(plugin, next2);
	    	storepopup2.put(splayer, store1);
			next = next3;
			prev = prev2;
			page = store2;
			map = storepopup3;
			pos = row - 40;
		}
		page.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setData(data).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (pos * 10))).setAnchor(anchor));
		
		page.attachWidget(plugin, new GenericLabel().setText(name2).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		
		if(name.containsKey(row)){
			name.put(row + 1, material);
			datamap.put(row + 1, data);
		}else{
			name.put(row, material);
			datamap.put(row, data);
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		}
		
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 10))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 10))).setAnchor(anchor));	
		}
		
		page.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		page.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
    	
		page.attachWidget(plugin, prev);
    	page.attachWidget(plugin, next);
    	map.put(splayer, page);
	}
	
	public static void addmaterial(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material, WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store, GenericPopup store1, GenericPopup store2){
		
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GenericPopup page;
		Map map;
		int pos;
		GenericButton next;
		GenericButton next1 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next2 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next3 = (GenericButton) new GenericButton("Next").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev;
		GenericButton prev1 = (GenericButton) new GenericButton("Prev").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev2 = (GenericButton) new GenericButton("Prev").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		
		if(row < 20){
			next = next1;
			prev = prev1;
			page = store;
			map = storepopup1;
			pos = row;
		}else if(row < 40){
			store.removeWidget(next1);
			next1.setEnabled(true).setPriority(RenderPriority.Lowest);
			store.attachWidget(plugin, next1);
	    	storepopup1.put(splayer, store);
			next = next2;
			prev = prev2;
			page = store1;
			map = storepopup2;
			pos = row - 20;
		}else{
			store1.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store1.attachWidget(plugin, next2);
	    	storepopup2.put(splayer, store1);
			next = next3;
			prev = prev2;
			page = store2;
			map = storepopup3;
			pos = row - 40;
		}
		page.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (pos * 10))).setAnchor(anchor));
		
		page.attachWidget(plugin, new GenericLabel().setText(material.toString().toLowerCase().replace("_", " ")).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		
		if(name.containsKey(row)){
			name.put(row + 1, material);
		}else{
			name.put(row, material);
		}
		
		//money
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 10))).setAnchor(anchor));
		}
		
		//level
		//TODO
		
		//buy
		if(playerconfig.getInt("players." + splayer.getName() + ".money") >= price2){
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 10))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 10))).setAnchor(anchor));	
		}
		//sell
		//TODO
		
    	page.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
    	page.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
    	
    	page.attachWidget(plugin, prev);
    	page.attachWidget(plugin, next);
    	map.put(splayer, page);
	}
	
	public static void store(Plugin plugin, SpoutPlayer splayer, String subgroupstr, String pagenum) {
		GenericLabel page = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);
		GenericPopup store = new GenericPopup();
		GenericPopup store1 = new GenericPopup();
		GenericPopup store2 = new GenericPopup();
		GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		int money = playerconfig.getInt("players." + splayer.getName() + ".money");
		GenericLabel moneylb = (GenericLabel) new GenericLabel().setText(Integer.toString(money)).setHeight(15).setWidth(50).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_RIGHT);
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		
		GenericButton amount = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
		
		try {
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String currency = storeconfig.getString("Store.Currency");
		
    	int row = 0;
    	custom.clear();
    	name.clear();
    	amountwidget.put(splayer, amount);
    	pagewidget.put(splayer, page);
    	if(subgroupstr.equals("Food")) {
    		for (Material material:StoreHashmaps.food) {
    			int price2 = storeconfig.getInt("Store.Food."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
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
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Armour")){
        	for (Material material:StoreHashmaps.armour) {
        		int price2 = storeconfig.getInt("Store.Armour."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Mechanisms")){
        	for (Material material:StoreHashmaps.mechanisms) {
        		int price2 = storeconfig.getInt("Store.Mechanisms."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Gardening")){
        	for (Material material:StoreHashmaps.gardening) {
        		if(material.equals(Material.SAPLING)){
        			int price2 = storeconfig.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.LONG_GRASS)){
        			int price2 = storeconfig.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.LEAVES)){
        			int price2 = storeconfig.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else{
	        		int price2 = storeconfig.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
	        		if(row % 2 == 0){
	    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
	        		} else {
	        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
	        		}
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Raw Materials")){
        	for (Material material:StoreHashmaps.rawmaterials) {
        		if(material.equals(Material.COAL)){
        			int price2 = storeconfig.getInt("Store.Raw Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 1; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else{
	        		int price2 = storeconfig.getInt("Store.Raw Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
	        		if(row % 2 == 0){
	    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
	        		} else {
	        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
	        		}
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Furniture")){
        	for (Material material:StoreHashmaps.furniture) {
        		int price2 = storeconfig.getInt("Store.Furniture."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Miscellaneous")){
        	for (Material material:StoreHashmaps.misc) {
        		int price2 = storeconfig.getInt("Store.Miscellaneous."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Materials")){
        	for (Material material:StoreHashmaps.materials) {
        		int price2 = storeconfig.getInt("Store.Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(material.equals(Material.LOG)){
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.LEAVES)){
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.SMOOTH_BRICK)){
        			for (short data = 0; data <= 2; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.STEP)){
        			for (short data = 0; data <= 5; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.DOUBLE_STEP)){
        			for (short data = 0; data <= 5; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else{
	        		if(row % 2 == 0){
	    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
	        		} else {
	        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
	        		}
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = storeconfig.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Minerals")){
        	for (Material material:StoreHashmaps.minerals) {
        		int price2 = storeconfig.getInt("Store.Minerals."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Ores")){
        	for (CustomOresDesign block:Hashmaps.customores) {
        		int price2 = storeconfig.getInt("Store.custom.Ores."+ block.getName() +".Price");
        		if(row % 2 == 0){
    	    		addcustomoreblock(plugin,Y,X,row,price2,currency,block, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addcustomoreblock(plugin,Y,X,row - 1,price2,currency,block, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        	for (Material material:StoreHashmaps.ores) {
        		int price2 = storeconfig.getInt("Store.Ores."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Painting")){
        	for (Material material:StoreHashmaps.painting) {
        		if(material.equals(Material.WOOL)){
        			int price2 = storeconfig.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 15; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else if(material.equals(Material.INK_SACK)){
        			int price2 = storeconfig.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 15; data ++) {
        				if(row % 2 == 0){
            	    		addmaterialanddata(plugin, Y, X, row, price2,currency, material, data, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
                		} else {
                			addmaterialanddata(plugin, Y, X, row - 1, price2,currency, material, data, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
                		}
        				row++;
        			}
        		}else{
        			int price2 = storeconfig.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
	        		if(row % 2 == 0){
	    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
	        		} else {
	        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
	        		}
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Mob Drops")){
        	for (Material material:StoreHashmaps.mobdrops) {
        		int price2 = storeconfig.getInt("Store.Mob Drops."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Brewing")){
        	for (Material material:StoreHashmaps.brewing) {
        		int price2 = storeconfig.getInt("Store.Brewing."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Music")){
        	for (Material material:StoreHashmaps.music) {
        		int price2 = storeconfig.getInt("Store.Music."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = storeconfig.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(row % 2 == 0){
    	    		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_LEFT, splayer, store, store1, store2);
        		} else {
        			addmaterial(plugin,Y,X,row - 1,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store, store1, store2);
        		}
        		row++;
        	}
        }
    	
    	store.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	
    	store1.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	
    	store2.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	
    	if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
			splayer.getMainScreen().getActivePopup().close();
		}
        splayer.getMainScreen().attachPopupScreen(store);
    }
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		GenericPopup group = new GenericPopup(); 
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
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
    	
		
		splayer.getMainScreen().attachPopupScreen(group);
	}
}