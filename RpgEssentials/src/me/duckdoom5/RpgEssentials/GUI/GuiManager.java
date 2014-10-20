package me.duckdoom5.RpgEssentials.GUI;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GuiManager {

    public static Map<SpoutPlayer, Gui> gui = new HashMap<>();

    public static void close(SpoutPlayer splayer) {
        if (splayer.getActiveScreen() != ScreenType.GAME_SCREEN) {
            splayer.getMainScreen().closePopup();
            gui.remove(splayer);
        }
    }

    public static void attach(final SpoutPlayer splayer,
            final GenericPopup popup, Plugin plugin) {
        if (splayer.getActiveScreen() != ScreenType.GAME_SCREEN) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,
                    new Runnable() {
                        @Override
                        public void run() {
                            splayer.getMainScreen().attachPopupScreen(popup);
                        }
                    }, 20L);
        } else {
            splayer.getMainScreen().attachPopupScreen(popup);
        }
    }
}
