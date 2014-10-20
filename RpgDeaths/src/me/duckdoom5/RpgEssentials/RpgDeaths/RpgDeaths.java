package me.duckdoom5.RpgEssentials.RpgDeaths;

import me.duckdoom5.RpgEssentials.RpgDeaths.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgDeaths.Listeners.BlockListener;
import me.duckdoom5.RpgEssentials.RpgDeaths.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgDeaths.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgDeaths.Listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgDeaths extends JavaPlugin {
    public static RpgDeaths plugin;
    public Plugin RpgEssentials;

    @Override
    public void onEnable() {
        plugin = this;
        Configuration.start();
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
        pm.registerEvents(new InventoryListener(this), this);
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new EntityListener(), this);
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
