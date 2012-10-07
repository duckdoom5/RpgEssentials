package me.duckdoom5.RpgEssentials.RpgLeveling;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.BlockListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.InputListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.LevelingListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.PlayerListerner;
import me.duckdoom5.RpgEssentials.RpgLeveling.Listeners.ScreenListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgLeveling extends JavaPlugin{
	public static RpgLeveling plugin;
	public Plugin RpgEssentials;
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){
		Configuration.start();
		reg();
		RpgEssentials = Bukkit.getPluginManager().getPlugin("RpgEssentials");
		logmsg(true);
	}
	
	@Override
	public void onDisable() {
		logmsg(false);
		
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new InputListener(this), this);
		pm.registerEvents(new ScreenListener(this), this);
		pm.registerEvents(new PlayerListerner(this), this);
		pm.registerEvents(new LevelingListener(this), this);
		pm.registerEvents(new BlockListener(this), this);
		pm.registerEvents(new EntityListener(this), this);
	}
	
	protected void logmsg(boolean enable){
		PluginDescriptionFile pdfile = this.getDescription();
		if(enable){
			log.info("[" + pdfile.getName() + "]" + " version: " + pdfile.getVersion() + " is now enabled !");
		}else{
			log.info("[" + pdfile.getName() + "]" + " is now disabled !");
		}
		
	}
}
