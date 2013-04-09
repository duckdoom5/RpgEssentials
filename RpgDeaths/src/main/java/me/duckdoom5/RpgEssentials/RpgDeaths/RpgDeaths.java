package me.duckdoom5.RpgEssentials.RpgDeaths;

import java.util.logging.Logger;

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

public class RpgDeaths extends JavaPlugin{
	public static RpgDeaths plugin;
	public Plugin RpgEssentials;
	public static final Logger log = Logger.getLogger("Minecraft");

	@Override
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
		pm.registerEvents(new InventoryListener(this), this);
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new EntityListener(), this);
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
