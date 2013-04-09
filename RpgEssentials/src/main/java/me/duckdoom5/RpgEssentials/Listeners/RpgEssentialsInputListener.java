package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.PlayerOptionsGui;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsInputListener implements Listener{
	public RpgEssentials plugin;
	public Keyboard key;
	
	public RpgEssentialsInputListener(RpgEssentials RpgEssentials) {
		this.plugin = RpgEssentials;
	}

	@EventHandler
	public void onKeyPressedEvent(KeyPressedEvent event) {
		Keyboard key = event.getKey();
		SpoutPlayer splayer = event.getPlayer();
		
		if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
			
			String rkey = Configuration.config.getString("Options.Key").toUpperCase();
			if(key.toString().equals("KEY_" + rkey) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN){
				PlayerOptionsGui ogui = new PlayerOptionsGui(plugin, splayer);
			}
		}
    }
}
