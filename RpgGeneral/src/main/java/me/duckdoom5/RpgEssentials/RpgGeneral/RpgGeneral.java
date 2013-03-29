package me.duckdoom5.RpgEssentials.RpgGeneral;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgGeneral extends JavaPlugin{
	public static RpgGeneral plugin;
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){
		logmsg(true);
	}
	
	@Override
	public void onDisable() {
		logmsg(false);
		
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
