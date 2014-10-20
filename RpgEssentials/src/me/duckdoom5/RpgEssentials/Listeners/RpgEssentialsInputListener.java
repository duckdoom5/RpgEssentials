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

public class RpgEssentialsInputListener implements Listener {
    public RpgEssentials plugin;
    public Keyboard key;

    public RpgEssentialsInputListener(RpgEssentials RpgEssentials) {
        plugin = RpgEssentials;
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public void onKeyPressedEvent(KeyPressedEvent event) {
        final Keyboard key = event.getKey();
        final SpoutPlayer splayer = event.getPlayer();

        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){

        final String rkey = Configuration.config.getString(
                "general.options key").toUpperCase();
        if (key.toString().equals("KEY_" + rkey) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN) {
            new PlayerOptionsGui(plugin, splayer);
        }
        // }
    }
}
