package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreCreateGui;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreGui;
import me.duckdoom5.RpgEssentials.RpgStores.Util.CustomStoreMethods;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreMethods;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenCloseEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ScreenListener implements Listener {
	private RpgStores plugin;
    public ScreenListener(RpgStores rpgStore) {
          this.plugin = rpgStore;
    }
    
    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
    	if(button.getPlugin().equals(plugin)){
	        SpoutPlayer splayer = event.getPlayer();
	        Gui gui = GuiManager.gui.get(splayer);
	        //close
	        if(button.getText().equals("Close")) {
	        	GuiManager.close(splayer);
	        //buy
	        }else if(button.getText().equals("Buy")) {
	        	if(gui instanceof StoreGui){
	        		StoreMethods.buyClick(splayer,button);
	        	}else{
	        		CustomStoreMethods.buyClick(splayer, button);
	        	}
	        //sell
	        }else if(button.getText().equals("Sell")) {
	        	if(gui instanceof StoreGui){
	        		StoreMethods.sellClick(splayer,button);
	        	}else{
	        		CustomStoreMethods.sellClick(splayer,button);
	        	}
	        //back
	        }else if(button.getText().equals("Back")) {
	        	gui.back();
	        //next
	        }else if(button.getText().equals("Next")) {
	        	gui.nextPage();
	        //prev
	        }else if(button.getText().equals("Prev")) {
	        	gui.prevPage();
	        }else if(button.getText().equals("Create")){
	        	StoreCreateGui scgui = (StoreCreateGui) gui;
	        	if(scgui.field1.getText().equals("")){
	        		splayer.sendNotification("Please enter a store", "name or 'all'", Material.APPLE);
	        	}else if(scgui.field1.getText().equals("all") || Configuration.customstores.contains(scgui.field1.getText())){
	        		if(scgui.name == null){
	        			Stores.place(scgui.x, scgui.y, scgui.z, scgui.field1.getText());
	        		}else{
	        			Stores.place(scgui.name, scgui.field1.getText());
	        		}
	        		GuiManager.close(splayer);
	        	}else{
	        		splayer.sendNotification("Not a valid store type!", scgui.field1.getText().length()<26?scgui.field1.getText():"", Material.APPLE);
	        	}
	        //subgroup
	        }else if(button.getText().equals("Food") || button.getText().equals("Tools") || button.getText().equals("Armor") || button.getText().equals("Mechanisms") || button.getText().equals("Gardening")
	        || button.getText().equals("Materials") || button.getText().equals("Raw Materials") || button.getText().equals("Painting") || button.getText().equals("Furniture") || button.getText().equals("Miscellaneous")
	        || button.getText().equals("Mob Drops") || button.getText().equals("Nether") ||button.getText().equals("Brewing") || button.getText().equals("Music") || button.getText().equals("The End") || button.getText().equals("Ores")){
	        	StoreGui sgui = new StoreGui(plugin, splayer, button.getText());
	        }else if(button.getText().equals("1")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("2");
	        }else if(button.getText().equals("2")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("5");
	        }else if(button.getText().equals("5")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("16");
	        }else if(button.getText().equals("16")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("32");
	        }else if(button.getText().equals("32")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("64");
	        }else if(button.getText().equals("64")) {
	        	StoreGui sgui = (StoreGui) GuiManager.gui.get(splayer);
	        	sgui.setAmount("1");
	        }
    	}
    }
    
    @EventHandler
    public void onScreenClose(ScreenCloseEvent event){
    	SpoutPlayer splayer = event.getPlayer();
    	Gui gui = GuiManager.gui.get(splayer);
    	if(gui instanceof StoreCreateGui){
    		event.setCancelled(true);
    		event.getPlayer().sendNotification("Error", "Please choose a type first", Material.APPLE);
    	}
    }
}