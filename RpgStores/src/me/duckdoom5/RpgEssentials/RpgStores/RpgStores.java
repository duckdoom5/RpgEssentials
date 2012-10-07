package me.duckdoom5.RpgEssentials.RpgStores;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreHashmaps;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.InputListener;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.ScreenListener;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgStores extends JavaPlugin{
	public static RpgStores plugin;
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){
		Configuration.start();
		reg();
		StoreHashmaps.registerstore(this);
		logmsg(true);
	}
	
	@Override
	public void onDisable() {
		logmsg(false);
		
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ScreenListener(this), this);
		pm.registerEvents(new InputListener(this), this);
		
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
