package me.duckdoom5.RpgEssentials.RpgEntities;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEntities.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgEntities.Listeners.EntityListener;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.ChickenRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.RpgEntityManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RpgEntities extends JavaPlugin{
	public static RpgEntities plugin;
	public Plugin RpgEssentials;
	public static RpgEntityManager em;
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){
		plugin = this;
		Configuration.start();
		reg();
		RpgEssentials = Bukkit.getPluginManager().getPlugin("RpgEssentials");
		em = new RpgEntityManager();
		logmsg(true);
		
		createLinks();
	}
	
	public void createLinks(){
		try{
			@SuppressWarnings("rawtypes")
			Class[] args = new Class[3];
			args[0] = Class.class;
			args[1] = String.class;
			args[2] = int.class;
			 
			Method a = net.minecraft.server.v1_4_R1.EntityTypes.class.getDeclaredMethod("a", args);
			a.setAccessible(true);
			 
			a.invoke(a, ChickenRpg.class, "Chicken", 93);
		}catch (Exception e){
			e.printStackTrace();
			this.setEnabled(false);
		}
	}
	
	@Override
	public void onDisable() {
		logmsg(false);
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
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
