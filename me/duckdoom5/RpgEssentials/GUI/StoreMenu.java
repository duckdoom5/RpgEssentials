package me.duckdoom5.RpgEssentials.GUI;

import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
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
	public static Map<SpoutPlayer, GenericPopup> storepopup4 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericPopup> storepopup5 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericPopup> storepopup6 = new HashMap<SpoutPlayer, GenericPopup>();
	
	public static Map<SpoutPlayer, GenericLabel> pagewidget = new HashMap<SpoutPlayer, GenericLabel>();
	public static Map<SpoutPlayer, GenericLabel> moneywidget = new HashMap<SpoutPlayer, GenericLabel>();
	public static Map<SpoutPlayer, GenericButton> amountwidget = new HashMap<SpoutPlayer, GenericButton>();
	static int X = -135;
	static int Y = 20;
	
	public StoreMenu(RpgEssentials instance) {
        plugin = instance; 
    }
	
	
	public static void addcustomoreblock(Plugin plugin, int startY, int startX, int row, int price2, String currency, CustomOresDesign block, WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store1, GenericPopup store2, GenericPopup store3){

		
		store1.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(block)).setDepth(8).setHeight(8).setWidth(8).setTooltip(block.getName()).setX(startX).setY((int) (startY + (row * 20))).setAnchor(anchor));
		
		store1.attachWidget(plugin, new GenericLabel().setText(block.getName()).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (row * 20))).setAnchor(anchor));
		
		custom.put(row, block.getName());
		
		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 20))).setAnchor(anchor));
		} else {
			store1.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (row * 20))).setAnchor(anchor));
		}
		
		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 20))).setAnchor(anchor));
		} else {
			store1.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (row * 20))).setAnchor(anchor));	
		}
		storepopup1.put(splayer, store1);
		
	}
	
	public static void addmaterialanddata(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material,short data , WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store1, GenericPopup store2, GenericPopup store3, GenericPopup store4, GenericPopup store5, GenericPopup store6){
		
		String name2 = Methods.getDataName(material, data);
		
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
		
		if(row < 10){
			next = next1;
			prev = prev1;
			page = store1;
			map = storepopup1;
			pos = row;
		}else if(row < 20){
			store1.removeWidget(next1);
			next1.setEnabled(true).setPriority(RenderPriority.Lowest);
			store1.attachWidget(plugin, next1);
	    	storepopup1.put(splayer, store1);
			next = next2;
			prev = prev2;
			page = store2;
			map = storepopup2;
			pos = row - 10;
		}else if(row < 30){
			store2.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store2.attachWidget(plugin, next2);
	    	storepopup2.put(splayer, store2);
			next = next3;
			prev = prev2;
			page = store3;
			map = storepopup3;
			pos = row - 20;
		}else if(row < 40){
			store3.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store3.attachWidget(plugin, next2);
	    	storepopup3.put(splayer, store3);
			next = next3;
			prev = prev2;
			page = store4;
			map = storepopup4;
			pos = row - 30;
		}else if(row < 50){
			store4.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store4.attachWidget(plugin, next2);
	    	storepopup4.put(splayer, store4);
			next = next3;
			prev = prev2;
			page = store5;
			map = storepopup5;
			pos = row - 40;
		}else{
			store5.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store5.attachWidget(plugin, next2);
	    	storepopup5.put(splayer, store5);
			next = next3;
			prev = prev2;
			page = store6;
			map = storepopup6;
			pos = row - 50;
		}
		page.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setData(data).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		
		page.attachWidget(plugin, new GenericLabel().setText(name2).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		
		name.put(row, material);
		datamap.put(row, data);
		

		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		}
		
		//buy

		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 20))).setAnchor(anchor));	
		}
		//sell
		if(splayer.getInventory().contains(new ItemStack(material, 1, data))){
			page.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 240).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 240).setY((int) (startY + (pos * 20))).setAnchor(anchor));	
		}
		
		page.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		page.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
    	
		page.attachWidget(plugin, prev);
    	page.attachWidget(plugin, next);
    	map.put(splayer, page);
	}
	
	public static void addmaterial(Plugin plugin, int startY, int startX, int row, int price2, String currency, Material material, WidgetAnchor anchor, SpoutPlayer splayer, GenericPopup store1, GenericPopup store2, GenericPopup store3, GenericPopup store4, GenericPopup store5, GenericPopup store6){

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
		
		if(row < 10){
			next = next1;
			prev = prev1;
			page = store1;
			map = storepopup1;
			pos = row;
		}else if(row < 20){
			store1.removeWidget(next1);
			next1.setEnabled(true).setPriority(RenderPriority.Lowest);
			store1.attachWidget(plugin, next1);
	    	storepopup1.put(splayer, store1);
			next = next2;
			prev = prev2;
			page = store2;
			map = storepopup2;
			pos = row - 10;
		}else if(row < 30){
			store2.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store2.attachWidget(plugin, next2);
	    	storepopup2.put(splayer, store2);
			next = next3;
			prev = prev2;
			page = store3;
			map = storepopup3;
			pos = row - 20;
		}else if(row < 40){
			store3.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store3.attachWidget(plugin, next2);
	    	storepopup3.put(splayer, store3);
			next = next3;
			prev = prev2;
			page = store4;
			map = storepopup4;
			pos = row - 30;
		}else if(row < 50){
			store4.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store4.attachWidget(plugin, next2);
	    	storepopup4.put(splayer, store4);
			next = next3;
			prev = prev2;
			page = store5;
			map = storepopup5;
			pos = row - 40;
		}else{
			store5.removeWidget(next2);
			next2.setEnabled(true).setPriority(RenderPriority.Lowest);
			store5.attachWidget(plugin, next2);
	    	storepopup5.put(splayer, store5);
			next = next3;
			prev = prev2;
			page = store6;
			map = storepopup6;
			pos = row - 50;
		}
		
		page.attachWidget(plugin, new GenericItemWidget(new ItemStack(material)).setDepth(8).setHeight(8).setWidth(8).setTooltip(material.toString().toLowerCase().replace("_", " ")).setX(startX).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		
		page.attachWidget(plugin, new GenericLabel().setText(material.toString().toLowerCase().replace("_", " ")).setX(startX + 21).setHeight(10).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		
		name.put(row, material);
		
		
		//money
		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price2 +" "+ currency).setHeight(10).setX(startX + 140).setY((int) (startY + 5 + (pos * 20))).setAnchor(anchor));
		}
		
		//level
		//TODO
		
		//buy
		if(PlayerConfig.getMoney(splayer.getName()) >= price2){
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 200).setY((int) (startY + (pos * 20))).setAnchor(anchor));	
		}
		//sell
		if(splayer.getInventory().contains(material)){
			page.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(30).setHeight(20).setX(startX + 240).setY((int) (startY + (pos * 20))).setAnchor(anchor));
		} else {
			page.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(30).setHeight(20).setX(startX + 240).setY((int) (startY + (pos * 20))).setAnchor(anchor));	
		}
		
    	page.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
    	page.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection"));
    	
    	page.attachWidget(plugin, prev);
    	page.attachWidget(plugin, next);
    	map.put(splayer, page);
	}
	
	public static void store(Plugin plugin, SpoutPlayer splayer, String subgroupstr, String pagenum) {
		GenericLabel page = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);
		GenericPopup store1 = new GenericPopup();
		GenericPopup store2 = new GenericPopup();
		GenericPopup store3 = new GenericPopup();
		GenericPopup store4 = new GenericPopup();
		GenericPopup store5 = new GenericPopup();
		GenericPopup store6 = new GenericPopup();
		GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		
		GenericButton amount = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);

		String currency = Configuration.store.getString("Store.Currency");
		
    	int row = 0;
    	custom.clear();
    	name.clear();
    	amountwidget.put(splayer, amount);
    	pagewidget.put(splayer, page);
    	if(subgroupstr.equals("Food")) {
    		for (Material material:StoreHashmaps.food) {
    			int price2 = Configuration.store.getInt("Store.Food."+ material.toString().toLowerCase().replace("_", " ") +".Price");
    			addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Tools")){
        	for (Material material:StoreHashmaps.tools) {
        		int price2 = Configuration.store.getInt("Store.Tools."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Armour")){
        	for (Material material:StoreHashmaps.armour) {
        		int price2 = Configuration.store.getInt("Store.Armour."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Mechanisms")){
        	for (Material material:StoreHashmaps.mechanisms) {
        		int price2 = Configuration.store.getInt("Store.Mechanisms."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Gardening")){
        	for (Material material:StoreHashmaps.gardening) {
        		if(material.equals(Material.SAPLING)){
        			int price2 = Configuration.store.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.LONG_GRASS)){
        			int price2 = Configuration.store.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.LEAVES)){
        			int price2 = Configuration.store.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 2; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else{
	        		int price2 = Configuration.store.getInt("Store.Gardening."+ material.toString().toLowerCase().replace("_", " ") +".Price");
	        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Raw Materials")){
        	for (Material material:StoreHashmaps.rawmaterials) {
        		if(material.equals(Material.COAL)){
        			int price2 = Configuration.store.getInt("Store.Raw Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 1; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else{
	        		int price2 = Configuration.store.getInt("Store.Raw Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
	        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Furniture")){
        	for (Material material:StoreHashmaps.furniture) {
        		int price2 = Configuration.store.getInt("Store.Furniture."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Miscellaneous")){
        	for (Material material:StoreHashmaps.misc) {
        		int price2 = Configuration.store.getInt("Store.Miscellaneous."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Materials")){
        	for (Material material:StoreHashmaps.materials) {
        		int price2 = Configuration.store.getInt("Store.Materials."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		if(material.equals(Material.LOG)){
        			for (short data = 0; data <= 2; data ++) {
        				addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.LEAVES)){
        			for (short data = 0; data <= 2; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.SMOOTH_BRICK)){
        			for (short data = 0; data <= 2; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.STEP)){
        			for (short data = 0; data <= 5; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.DOUBLE_STEP)){
        			for (short data = 0; data <= 5; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else{
        			addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = Configuration.store.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Minerals")){
        	for (Material material:StoreHashmaps.minerals) {
        		int price2 = Configuration.store.getInt("Store.Minerals."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Ores")){
        	for (CustomOresDesign block:Hashmaps.customores) {
        		int price2 = Configuration.store.getInt("Store.custom.Ores."+ block.getName() +".Price");
        		addcustomoreblock(plugin,Y,X,row,price2,currency,block, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3);
        		row++;
        	}
        	for (Material material:StoreHashmaps.ores) {
        		int price2 = Configuration.store.getInt("Store.Ores."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Painting")){
        	for (Material material:StoreHashmaps.painting) {
        		if(material.equals(Material.WOOL)){
        			int price2 = Configuration.store.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 15; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else if(material.equals(Material.INK_SACK)){
        			int price2 = Configuration.store.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			for (short data = 0; data <= 15; data ++) {
        				addmaterialanddata(plugin,Y,X,row,price2,currency,material, data, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        				row++;
        			}
        		}else{
        			int price2 = Configuration.store.getInt("Store.Painting."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        			addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
	        		row++;
        		}
        	}
        }else if(subgroupstr.equals("Mob Drops")){
        	for (Material material:StoreHashmaps.mobdrops) {
        		int price2 = Configuration.store.getInt("Store.Mob Drops."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Brewing")){
        	for (Material material:StoreHashmaps.brewing) {
        		int price2 = Configuration.store.getInt("Store.Brewing."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Music")){
        	for (Material material:StoreHashmaps.music) {
        		int price2 = Configuration.store.getInt("Store.Music."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }else if(subgroupstr.equals("Nether")){
        	for (Material material:StoreHashmaps.nether) {
        		int price2 = Configuration.store.getInt("Store.Nether."+ material.toString().toLowerCase().replace("_", " ") +".Price");
        		addmaterial(plugin,Y,X,row,price2,currency,material, WidgetAnchor.TOP_CENTER, splayer, store1, store2, store3, store4, store5, store6);
        		row++;
        	}
        }
    	
		double money = PlayerConfig.getMoney(splayer.getName());
    	GenericLabel moneylb = (GenericLabel) new GenericLabel().setText(Double.toString(money)).setHeight(15).setWidth(50).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_RIGHT);

    	store1.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store2.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store3.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store4.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store5.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store6.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	
    	if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
			splayer.getMainScreen().getActivePopup().close();
		}
        splayer.getMainScreen().attachPopupScreen(store1);
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
