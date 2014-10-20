package me.duckdoom5.RpgEssentials.RpgTracks;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgTracks extends JavaPlugin {
    public static RpgTracks plugin;

    @Override
    public void onEnable() {
        logmsg(true);
    }

    @Override
    public void onDisable() {
        logmsg(false);

    }

    protected void logmsg(boolean enable) {
        final PluginDescriptionFile pdfile = getDescription();
        if (enable) {
            getLogger().info("version: " + pdfile.getVersion() + " is now enabled !");
        } else {
            getLogger().info("is now disabled !");
        }

    }
}
