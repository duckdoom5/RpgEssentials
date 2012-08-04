package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgQuests.QuestOld;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ScreenListener implements Listener {
    private RpgQuests plugin;
    public ScreenListener(RpgQuests RpgQuests) {
          this.plugin = RpgQuests;
    }
    
    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
    	if(button.getPlugin().equals(plugin)){
	        SpoutPlayer splayer = event.getPlayer();
	        //close
	        if(button.getText().equals("Close")) {
	    		splayer.getMainScreen().closePopup();
	    		
	        }else if(button.getText().equals("Accept Quest")) {
	        	QuestOld.accepted(plugin, splayer);
	        }
    	}
    }
}