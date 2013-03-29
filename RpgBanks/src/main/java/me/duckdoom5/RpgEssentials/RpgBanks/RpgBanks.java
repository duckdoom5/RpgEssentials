package me.duckdoom5.RpgEssentials.RpgBanks;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgBanks.Listeners.InventoryListener;
import me.duckdoom5.RpgEssentials.RpgBanks.Listeners.ScreenListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgBanks extends JavaPlugin{
	public static RpgBanks plugin;
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
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new ScreenListener(this), this);
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
