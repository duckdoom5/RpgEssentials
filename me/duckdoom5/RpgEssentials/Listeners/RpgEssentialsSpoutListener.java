package me.duckdoom5.RpgEssentials.Listeners;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsSpoutListener implements Listener{
	
	public static RpgEssentials plugin;
	private int taskId = 0;
	public final Logger log = Logger.getLogger("Minecraft");
    YamlConfiguration config = new YamlConfiguration();
    YamlConfiguration playerconfig = new YamlConfiguration();
	private ChatColor colorother;
	private ChatColor colorme;
    
    public RpgEssentialsSpoutListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
    @EventHandler
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event){
		
		final Player player = event.getPlayer();
		World world = player.getWorld();
		final SpoutPlayer splayer = SpoutManager.getPlayer(player);
		
		//load config
		try {
			config.load("plugins/RpgEssentials/config.yml");
			playerconfig.load("plugins/RpgEssentials/Players.yml");
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
				plugin.log.warning("[RpgEssentials] Your default texturepack is not a zip file!");
			}
		}
		
		if((playerconfig.contains("players." + player.getName() + ".cape") && (!playerconfig.getString("players." + player.getName() + ".cape").equalsIgnoreCase("capeurl")))){
			try{
				splayer.setCape(playerconfig.getString("players."+ player.getName() +".cape"));
			}catch(Exception e){
			}
		}
		if(playerconfig.contains("players." + player.getName() + ".title")){
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			    public void run() {
			    	int combatlvl = playerconfig.getInt("players."+ player.getName() +".combatlvl");
					Player onplayer[] = plugin.getServer().getOnlinePlayers();
		            int j = onplayer.length;
					for(int i=0; i < j; i++){
						Player on = onplayer[i];
						SpoutPlayer son = (SpoutPlayer) on;
						int combatlvlother = playerconfig.getInt("players."+ on.getName() +".combatlvl");
						if(combatlvl > combatlvlother){
							if(combatlvl - combatlvlother <= 5){
								colorme = ChatColor.RED;
								colorother = ChatColor.GREEN;
							}else{
								colorme = ChatColor.DARK_RED;
								colorother = ChatColor.DARK_GREEN;
							}
						}else if(combatlvl < combatlvlother){
							if(combatlvlother - combatlvl <= 5){
								colorme = ChatColor.GREEN;
								colorother = ChatColor.RED;
							}else{
								colorme = ChatColor.DARK_GREEN;
								colorother = ChatColor.DARK_RED;
							}
						}else if(combatlvl == combatlvlother){
							colorme = ChatColor.YELLOW;
							colorother = ChatColor.YELLOW;
						}
						splayer.setTitleFor(son, colorme + playerconfig.getString("players."+ player.getName() +".title")+ " [lvl: " + combatlvl + "]");
						
						son.setTitleFor(SpoutManager.getPlayer(player), colorother + playerconfig.getString("players."+ on.getName() +".title")+ " [lvl: " + combatlvlother + "]");
					}
			    }
			}, 20L);
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
			        			//second time because first doesn't always work?
			        			Bukkit.getServer().getScheduler().cancelTask(taskId);
			        		}catch(Exception e){
			        			player.sendMessage("Invalid notification");
			        		}
						}
						
					}
    	        	
     	       }, 2L, 2L);
        		
        	}
        }
	}
}