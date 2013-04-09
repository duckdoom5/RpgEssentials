package me.duckdoom5.RpgEssentials.RpgRegions;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgRegions.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgRegions.Listerners.RpgEssentialsPlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgRegions extends JavaPlugin{
	public static RpgRegions plugin;
	public Plugin RpgEssentials;
	public static final Logger log = Logger.getLogger("Minecraft");
	
	public static RpgEssentialsPlayerListener listener;

	public void onEnable(){
		Plugin wg = Bukkit.getPluginManager().getPlugin("WorldGuard");
		if(wg==null){
			log.severe("WorldGuard is disabled!");
			this.onDisable();
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
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(listener, this);
		
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
