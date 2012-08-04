package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreGui;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreMethods;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
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
	        //close
	        if(button.getText().equals("Close")) {
	    		splayer.getMainScreen().getActivePopup().close();
	        //buy
	        }else if(button.getText().equals("Buy")) {
	        	StoreMethods.buyClick(splayer,button);
	        //sell
	        }else if(button.getText().equals("Sell")) {
	        	StoreMethods.sellClick(splayer,button);
	        //back
	        }else if(button.getText().equals("Back")) {
	        	Gui gui = GuiManager.gui.get(splayer);
	        	gui.back();
	        //next
	        }else if(button.getText().equals("Next")) {
	        	Gui gui = GuiManager.gui.get(splayer);
	        	gui.nextPage();
	        //prev
	        }else if(button.getText().equals("Prev")) {
	        	Gui gui = GuiManager.gui.get(splayer);
	        	gui.prevPage();
	        //subgroup
	        }else if(button.getText().equals("Food") || button.getText().equals("Tools") || button.getText().equals("Armor") || button.getText().equals("Mechanisms") || button.getText().equals("Gardening")
	        || button.getText().equals("Materials") || button.getText().equals("Raw Materials") || button.getText().equals("Painting") || button.getText().equals("Furniture") || button.getText().equals("Miscellaneous")
	        || button.getText().equals("Mob Drops") || button.getText().equals("Nether") ||button.getText().equals("Brewing") || button.getText().equals("Music") || button.getText().equals("The End") || button.getText().equals("Ores")){
	        	StoreGui gui = new StoreGui(plugin, splayer, button.getText());
	        }else if(button.getText().equals("1")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("2");
	        }else if(button.getText().equals("2")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("5");
	        }else if(button.getText().equals("5")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("16");
	        }else if(button.getText().equals("16")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("32");
	        }else if(button.getText().equals("32")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("64");
	        }else if(button.getText().equals("64")) {
	        	StoreGui gui = (StoreGui) GuiManager.gui.get(splayer);
	        	gui.setAmount("1");
	        }
    	}
    }
}