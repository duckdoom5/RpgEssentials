package me.duckdoom5.RpgServer;

import java.util.logging.Logger;

import me.duckdoom5.RpgServer.commands.RpgServerCommandExecutor;
import me.duckdoom5.RpgServer.config.Configuration;
import me.duckdoom5.RpgServer.listener.RpgServerBlockListener;
import me.duckdoom5.RpgServer.listener.RpgServerEntityListener;
import me.duckdoom5.RpgServer.listener.RpgServerPlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.shadowz.phpsend.MainPhpSend;
import org.shadowz.phpsend.PhpSendPlugin;

public class RpgServer extends JavaPlugin{
	public static RpgServer plugin;
	public static final Logger log = Logger.getLogger("Minecraft");
	
	private final RpgServerCommandExecutor command = new RpgServerCommandExecutor(this);
	public static ServerManager sm = null; 
	
	public static String CsIP = "82.74.70.243";
	
	@Override
	public void onEnable() {
		log.info("[RpgServer] Loading configs...");
		Configuration.start();
		log.info("[RpgServer] loaded configs!");
		
		getcmds();
		reg();
		
		//if is main server
		
		if(Bukkit.getServer().getIp().equals(CsIP)){
			sm = new ServerManager();
			sm.registerServers();
		}
		
		PhpSendPlugin pl = new PHPsend();
		MainPhpSend.registerPlugin(pl,"RpgEssentials");
		
		logmsg(true);
	}

	private void getcmds() {
		getCommand("tut").setExecutor(command);
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvents(new RpgServerPlayerListener(this), this);
		pm.registerEvents(new RpgServerBlockListener(this), this);
		pm.registerEvents(new RpgServerEntityListener(), this);
	}
	
	@Override
	public void onDisable() {
		logmsg(false);
	}
	
	protected void logmsg(boolean enable){
		PluginDescriptionFile pdfile = this.getDescription();
		if (enable) {
			RpgServer.log.info("[" + pdfile.getName() + "]" + " version: " + pdfile.getVersion() + " is now enabled !");
		} else {
			RpgServer.log.info("[" + pdfile.getName() + "]" + " is now disabled !");
		}
		
	}
}
