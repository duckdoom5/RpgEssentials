package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreSelectGui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InputListener implements Listener {
    public RpgStores plugin;
    public Keyboard key;

    public InputListener(RpgStores rpgStore) {
        plugin = rpgStore;
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public void onKeyPressedEvent(KeyPressedEvent event) {
        final Keyboard key = event.getKey();
        final SpoutPlayer splayer = event.getPlayer();

        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
        
        if (key.toString().equals("KEY_" + Configuration.config.getString("Key").toUpperCase()) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN && Configuration.config.getBoolean("Allow key")) {
            new StoreSelectGui(plugin, splayer);
        }
        // }
    }
}
