package me.duckdoom5.RpgEssentials.RpgQuests;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.Listeners.BlockListener;
import me.duckdoom5.RpgEssentials.RpgQuests.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgQuests.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgQuests.Listeners.ScreenListener;
import me.duckdoom5.RpgEssentials.RpgQuests.Listeners.SpoutListener;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.QuestHandler;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.QuestManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgQuests extends JavaPlugin {
    public static RpgQuests plugin;
    public static Plugin RpgEssentials;
    public static QuestManager qm = null;
    public static QuestHandler qh = null;

    @Override
    public void onEnable() {
        Configuration.start();
        reg();
        qm = new QuestManager();
        qm.loadQuests();
        qh = new QuestHandler(this);
        RpgEssentials = Bukkit.getPluginManager().getPlugin("RpgEssentials");
        logmsg(true);
    }

    @Override
    public void onDisable() {
        qm.saveQuests();
        logmsg(false);
    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new ScreenListener(this), this);
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new EntityListener(), this);
        pm.registerEvents(new SpoutListener(), this);
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
