package me.duckdoom5.RpgEssentials.RpgEntities;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgEntities.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgEntities.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgEntities.Listeners.ScreenListener;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.RpgEntityManager;
import me.duckdoom5.RpgEssentials.RpgEntities.util.CustomEntityType;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.util.AddonType;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgEntities extends JavaPlugin {
    public static RpgEntities plugin;
    public Plugin RpgEssentials;
    public static RpgEntityManager em;
    private static boolean lvlEnabled = RpgeManager.getInstance().isAddonEnabled(AddonType.LEVELING) && Skill.isEnabled(SkillType.TAMING);
    
    @Override
    public void onEnable() {
        plugin = this;
        Configuration.start();
        reg();
        RpgEssentials = Bukkit.getPluginManager().getPlugin("RpgEssentials");
        em = new RpgEntityManager();
        logmsg(true);
        
        CustomEntityType.registerEntities();
    }

    @Override
    public void onDisable() {
        CustomEntityType.unregisterEntities();
        logmsg(false);
    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EntityListener(), this);
        pm.registerEvents(new ScreenListener(this), this);
    }

    protected void logmsg(boolean enable) {
        final PluginDescriptionFile pdfile = getDescription();
        if (enable) {
            getLogger().info("version: " + pdfile.getVersion() + " is now enabled !");
        } else {
            getLogger().info("is now disabled !");
        }

    }
    
    public static boolean isLevelEnabled(){
        return lvlEnabled;
    }
}
