package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreSelectGui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InputListener implements Listener{
	public RpgStores plugin;
	public Keyboard key;
	
	public InputListener(RpgStores rpgStore) {
		this.plugin = rpgStore;
	}

	@EventHandler
	public void onKeyPressedEvent(KeyPressedEvent event) {
		Keyboard key = event.getKey();
		SpoutPlayer splayer = event.getPlayer();
		
		if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
			
			String okey = Configuration.config.getString("Key").toUpperCase();
			if(key.toString().equals("KEY_" + Configuration.config.getString("Key").toUpperCase()) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN && Configuration.config.getBoolean("Allow key")){
				StoreSelectGui gui = new StoreSelectGui(plugin, splayer);
			}
		}
    }
}
