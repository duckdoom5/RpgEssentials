package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.PlayerOptionsGui;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.ServerTickEvent;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsSpoutListener implements Listener{
	
	public RpgEssentials plugin;
	private HashMap<Player, Integer> taskid = new HashMap<Player, Integer>();
	    
    public RpgEssentialsSpoutListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
    @EventHandler
	public void onServerTick(ServerTickEvent event){
    	
    }
    
    @EventHandler
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event){
    	final Player player = event.getPlayer();
    	if(RpgEssentials.wl.worlds.get(player.getWorld())){
			World world = player.getWorld();
			final SpoutPlayer splayer = SpoutManager.getPlayer(player);
			
			RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
			
			if(Configuration.modules.getBoolean("Modules.texturepack")){
				((Player)rpgplayer.getPlayer()).sendMessage(rpgplayer.getTexturepack(world));
		    	if(!rpgplayer.getTexturepack(world).equals("none") && !rpgplayer.getTexturepack(world).equals("null")){
		    		if(Configuration.texture.contains(world.getName() + "." + rpgplayer.getTexturepack(world) + ".url")){
			    		String url = Configuration.texture.getString(world.getName() + "." + rpgplayer.getTexturepack(world) + ".url");
			    		
			    		splayer.setTexturePack(url);
		    		}
				}else if(rpgplayer.getTexturepack(world).equals("null")){
					PlayerOptionsGui gui = new PlayerOptionsGui(plugin, splayer);
				}
			}
			
			/*//load title + color
			int combatlvl = Configuration.players.getInt("players."+ player.getName() +".combatlvl");
	    	SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
			for(int i = 0; i < onplayers.length; i++){
				int combatlvlother = Configuration.players.getInt("players."+ onplayers[i].getName() +".combatlvl");
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
				splayer.setTitleFor(onplayers[i], colorme + Configuration.players.getString("players."+ player.getName() +".title")+ " [lvl: " + combatlvl + "]");
				
				onplayers[i].setTitleFor(SpoutManager.getPlayer(player), colorother + Configuration.players.getString("players."+ onplayers[i].getName() +".title")+ " [lvl: " + combatlvlother + "]");
			}*/
			
			/*if(Configuration.modules.getBoolean("Modules.texturepack") && Configuration.config.contains("texturepack." + world.getName())){
				String worldpack = (Configuration.config.getString("texturepack." + world.getName()));
				if(worldpack.contains(".zip")){
					try{
						splayer.setTexturePack(worldpack);
					}catch(Exception e){
					}
				}else{
					RpgEssentials.log.info("[RpgEssentials] Your texturepack for world: " + world.getName() + " is not a zip file!");
				}
			}else if(Configuration.modules.getBoolean("Modules.texturepack")){
				String defaultpack = (Configuration.config.getString("texturepack.default"));
				if(defaultpack.contains(".zip")){
					try{
						splayer.setTexturePack(defaultpack);
					}catch(Exception e){
					}
				}else{
					RpgEssentials.log.warning("[RpgEssentials] Your default texturepack is not a zip file!");
				}
			}*/
			
			if((Configuration.players.contains("players." + player.getName() + ".cape") && (!Configuration.players.getString("players." + player.getName() + ".cape").equalsIgnoreCase("capeurl")))){
				try{
					splayer.setCape(Configuration.players.getString("players."+ player.getName() +".cape"));
				}catch(Exception e){
				}
			}
			
			if(Configuration.players.contains("players." + player.getName() + ".hidetitle")){
				if((Configuration.players.getBoolean("players."+ player.getName() +".hidetitle")) == true){
					try{
						splayer.hideTitle();
					}catch(Exception e){
					}
				}
			}
			
			if(Configuration.players.contains("players." + player.getName() + ".speed")){
				try{
					splayer.setAirSpeedMultiplier(Configuration.players.getDouble("players."+ player.getName() +".speed"));
					splayer.setWalkingMultiplier(Configuration.players.getDouble("players."+ player.getName() +".speed"));
					splayer.setSwimmingMultiplier(Configuration.players.getDouble("players."+ player.getName() +".speed"));
				}catch(Exception e){
				}
			}
			
			if(Configuration.players.contains("players." + player.getName() + ".skin")){
				try{
					splayer.setSkin(Configuration.players.getString("players."+ player.getName() +".skin"));
				}catch(Exception e){
				}
			}
			
			if((Configuration.config.getString("spout.join.message").length() > 26) || (Configuration.config.getString("spout.join.submessage").length() > 26)){
				player.sendMessage(ChatColor.RED + "Tried to welcome you but the message was too long.");
	        } else {
	        	if(splayer.isPreCachingComplete()){
	        		try{
	        			splayer.sendNotification(Configuration.config.getString("spout.join.message"), Configuration.config.getString("spout.join.submessage"), Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
	        		}catch(Exception e){
	        			player.sendMessage("Invalid notification accidentally sent...");
	        		}
	        	}else{
					splayer.sendNotification("Precaching files!", "Please wait...", Material.WATCH);
					taskid.put(player, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("RpgEssentials"), new Runnable(){
						public void run() {
							if(splayer.isPreCachingComplete()){
								try{
									splayer.sendNotification(Configuration.config.getString("spout.join.message"), Configuration.config.getString("spout.join.submessage"), Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
									Bukkit.getServer().getScheduler().cancelTask(taskid.get(player));
								}catch(Exception e){
									player.sendMessage("Invalid notification accidentally sent...");
								}
							}
						}
					}, 2L, 2L));
	        	}
	        }
    	}
	}
}