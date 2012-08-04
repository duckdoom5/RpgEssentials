package me.duckdoom5.RpgEssentials.RpgBanks.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ScreenListener implements Listener {
    private RpgBanks plugin;
    public ScreenListener(RpgBanks RpgBanks) {
          this.plugin = RpgBanks;
    }
    
    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
    	if(button.getPlugin().equals(plugin)){
	        SpoutPlayer splayer = event.getPlayer();
	        //close
	        if(button.getText().equals("Close")) {
	    		splayer.getMainScreen().closePopup();
	        
	        }else if(button.getText().equals("Open bank account")) {
	        	Bank.open((RpgBanks) RpgEssentials.RpgBanks, splayer);
	        }else if(button.getText().equals("Buy more room")) {
	        	Bank.requestUpgrade((RpgBanks) RpgEssentials.RpgBanks, splayer);
	        }else if(button.getText().equals("Accept size change")){
	        	Bank.upgradeSpace((RpgBanks) RpgEssentials.RpgBanks, splayer);
	        }
    	}
    }
}