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

public class RpgQuests extends JavaPlugin{
	public static RpgQuests plugin;
	public static Plugin RpgEssentials;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static QuestManager qm = null;
	public static QuestHandler qh = null;

	public void onEnable(){
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
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new ScreenListener(this), this);
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new EntityListener(), this);
		pm.registerEvents(new SpoutListener(), this);
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
