package me.duckdoom5.RpgEssentials.RpgBanks;

import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.RpgBankManager;
import me.duckdoom5.RpgEssentials.RpgBanks.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgBanks.Listeners.ScreenListener;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgBanks extends JavaPlugin {
    public static RpgBanks plugin;
    
    @Override
    public void onEnable() {
        plugin = this;
        Configuration.start();
        reg();
        RpgBankManager.getInstance().loadBanks();
        logmsg(true);
    }

    @Override
    public void onDisable() {
        logmsg(false);
    }

    private void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new ScreenListener(this), this);
    }

    private void logmsg(boolean enable) {
        final PluginDescriptionFile pdfile = getDescription();
        if (enable) {
            plugin.getLogger().info("version: " + pdfile.getVersion() + " is now enabled !");
        } else {
            plugin.getLogger().info("is now disabled !");
        }

    }
}
