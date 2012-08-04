package me.duckdoom5.RpgEssentials.RpgPets;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgPets.Config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgPets extends JavaPlugin{
	public static RpgPets plugin;
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
		//pm.registerEvents(new InventoryListener(this), this);
		//pm.registerEvents(new PlayerListener(this), this);
		//pm.registerEvents(new BlockListener(), this);
		//pm.registerEvents(new EntityListener(), this);
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
