package me.duckdoom5.RpgEssentials.RpgLeveling;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.BlockListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.InputListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.LevelingListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.PlayerListerner;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.ScreenListener;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgLeveling extends JavaPlugin {
    public static RpgLeveling plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Configuration.start();
        reg();
        RpgPlayerLevelManager.getInstance().loadRpgPlayerLevels();
        logmsg(true);
    }

    @Override
    public void onDisable() {
        logmsg(false);

    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new InputListener(this), this);
        pm.registerEvents(new ScreenListener(this), this);
        pm.registerEvents(new PlayerListerner(this), this);
        pm.registerEvents(new LevelingListener(this), this);
        pm.registerEvents(new BlockListener(this), this);
        pm.registerEvents(new EntityListener(this), this);
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
