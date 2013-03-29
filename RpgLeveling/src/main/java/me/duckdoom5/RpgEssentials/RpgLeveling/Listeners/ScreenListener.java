package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Gui.LevelGui;
import me.duckdoom5.RpgEssentials.RpgLeveling.Gui.UnlockablesGui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ScreenListener implements Listener {
    private RpgLeveling plugin;
    public ScreenListener(RpgLeveling rpgStore) {
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
	        //get skill points
	        }else if(button.getText().equals("Spend")) {
	        	LevelGui gui = (LevelGui) GuiManager.gui.get(splayer);
	        	gui.spend(plugin, splayer, button);
	        	//unlockables
	        }else if(button.getText().equals("Unlockables")) {
	        	UnlockablesGui gui = new UnlockablesGui(plugin, splayer, button);
	        }
    	}
    }
}