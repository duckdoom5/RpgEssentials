package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsInputListener implements Listener{
	public static RpgEssentials plugin;
	public static Keyboard key;
	
	public RpgEssentialsInputListener(RpgEssentials instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onKeyPressedEvent(KeyPressedEvent event) {
		SpoutPlayer splayer = event.getPlayer();
		Keyboard key = event.getKey();
		String okey = Configuration.config.getString("store.key").toUpperCase();
		String lkey = Configuration.config.getString("stats.key");
		if(key.toString().equals("KEY_" + Configuration.config.getString("stats.key").toUpperCase()) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN && Configuration.config.getBoolean("stats.allow") == true){
			LevelMenu.open(plugin, splayer);
		}else if(key.toString().equals("KEY_" + Configuration.config.getString("store.key").toUpperCase()) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN && Configuration.config.getBoolean("store.allow") == true){
			StoreMenu.open(plugin, splayer);
		}
    }
}
