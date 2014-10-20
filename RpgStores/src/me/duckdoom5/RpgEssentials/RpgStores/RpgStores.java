package me.duckdoom5.RpgEssentials.RpgStores;

import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.InputListener;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.ScreenListener;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreHashmaps;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgStores extends JavaPlugin {
    public static RpgStores plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Configuration.start();
        reg();
        StoreHashmaps.registerstore();
        logmsg(true);
    }

    @Override
    public void onDisable() {
        logmsg(false);
    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ScreenListener(this), this);
        pm.registerEvents(new InputListener(this), this);

    }

    protected void logmsg(boolean enable) {
        final PluginDescriptionFile pdfile = getDescription();
        if (enable) {
            plugin.getLogger().info("version: " + pdfile.getVersion() + " is now enabled !");
        } else {
            plugin.getLogger().info("is now disabled !");
        }

    }
}
