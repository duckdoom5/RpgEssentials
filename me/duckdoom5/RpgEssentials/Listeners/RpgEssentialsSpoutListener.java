package me.duckdoom5.RpgEssentials.Listeners;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsSpoutListener extends SpoutListener{
	
	public static RpgEssentials plugin;
	private int taskId = 0;
	public final Logger log = Logger.getLogger("Minecraft");
    YamlConfiguration config = new YamlConfiguration();
    YamlConfiguration playerconfig = new YamlConfiguration();
    
    public RpgEssentialsSpoutListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event){
		
		final Player player = event.getPlayer();
		World world = player.getWorld();
		final SpoutPlayer splayer = SpoutManager.getPlayer(player);
		
		//load config
		try {
			config.load("plugins/RpgEssentials/config.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		if(config.contains("texturepack." + world.getName())){
			String worldpack = (config.getString("texturepack." + world.getName()));
			if(worldpack.contains(".zip")){
				try{
					splayer.setTexturePack(worldpack);
				}catch(Exception e){
				}
			}else{
				plugin.log.info("[RpgEssentials] Your texturepack for world: " + world.getName() + " is not a zip file!");
			}
		}else{
			String defaultpack = (config.getString("texturepack.default"));
			if(defaultpack.contains(".zip")){
				try{
					splayer.setTexturePack(defaultpack);
				}catch(Exception e){
				}
			}else{
				plugin.log.info("[RpgEssentials] Your default texturepack is not a zip file!");
			}
		}
		
		if((playerconfig.contains("players." + player.getName() + ".cape") && (!playerconfig.getString("players." + player.getName() + ".cape").equalsIgnoreCase("capeurl")))){
			try{
				splayer.setCape(playerconfig.getString("players."+ player.getName() +".cape"));
			}catch(Exception e){
			}
		}
		if(playerconfig.contains("players." + player.getName() + ".title")){
			try{
				splayer.setTitle(playerconfig.getString("players."+ player.getName() +".title")+ " [lvl: " + playerconfig.getInt("players."+ player.getName() +".combatlvl") + "]");
			}catch(Exception e){
			}
		}else{
			try{
				splayer.setTitle(player.getName() + " [lvl: " + playerconfig.getInt("players."+ player.getName() +".combatlvl") + "]");
			}catch(Exception e){
			}
		}
		if(playerconfig.contains("players." + player.getName() + ".hidetitle")){
			if((playerconfig.getBoolean("players."+ player.getName() +".hidetitle")) == true){
				try{
					splayer.hideTitle();
				}catch(Exception e){
				}
			}
		}
		if(playerconfig.contains("players." + player.getName() + ".speed")){
			try{
				splayer.setAirSpeedMultiplier(playerconfig.getDouble("players."+ player.getName() +".speed"));
				splayer.setWalkingMultiplier(playerconfig.getDouble("players."+ player.getName() +".speed"));
				splayer.setSwimmingMultiplier(playerconfig.getDouble("players."+ player.getName() +".speed"));
			}catch(Exception e){
			}
		}
		if(playerconfig.contains("players." + player.getName() + ".skin")){
			try{
				splayer.setSkin(playerconfig.getString("players."+ player.getName() +".skin"));
			}catch(Exception e){
			}
		}
		if((config.getString("spout.join.message").length() > 26) || (config.getString("spout.join.submessage").length() > 26)){
			player.sendMessage(ChatColor.RED + "Join message is too long !");
        } else {
        	if(splayer.isPreCachingComplete()){
        		try{
        			splayer.sendNotification(config.getString("spout.join.message"), config.getString("spout.join.submessage"), Material.getMaterial(config.getInt("spout.join.messageicon")));
        		}catch(Exception e){
        			player.sendMessage("Invalid notification");
        		}
        	}else{
        		try{
            		splayer.sendNotification("Precaching files!", "Please wait...", Material.WATCH);
            	}catch(Exception e){
            		player.sendMessage("Invalid notification");
            	}
        		taskId = Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(Bukkit.getPluginManager().getPlugin("RpgEssentials"), new Runnable(){
					public void run() {
						if(splayer.isPreCachingComplete()){
			        		try{
			        			splayer.sendNotification(config.getString("spout.join.message"), config.getString("spout.join.submessage"), Material.getMaterial(config.getInt("spout.join.messageicon")));
			        			Bukkit.getServer().getScheduler().cancelTask(taskId);
			        		}catch(Exception e){
			        			player.sendMessage("Invalid notification");
			        		}
						}
						
					}
    	        	
     	       }, 1L, 1L);
        		
        	}
        }
	}
}