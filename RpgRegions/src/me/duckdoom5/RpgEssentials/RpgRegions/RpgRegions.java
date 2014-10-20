package me.duckdoom5.RpgEssentials.RpgRegions;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgRegions.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgRegions.Listerners.RpgEssentialsPlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgRegions extends JavaPlugin {
    public static RpgRegions plugin;
    public Plugin RpgEssentials;

    public static RpgEssentialsPlayerListener listener;

    @Override
    public void onEnable() {
        final Plugin wg = Bukkit.getPluginManager().getPlugin("WorldGuard");
        if (wg == null) {
            getLogger().severe("WorldGuard is disabled!");
            onDisable();
            return;
        }
        Configuration.start();
        listener = new RpgEssentialsPlayerListener(this);
        reg();
        RpgEssentials = Bukkit.getPluginManager().getPlugin("RpgEssentials");
        logmsg(true);
    }

    @Override
    public void onDisable() {
        logmsg(false);

    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(listener, this);

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
