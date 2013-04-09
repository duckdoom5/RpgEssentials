package me.duckdoom5.RpgEssentials.RpgRegions.Listerners;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgRegions.RpgRegions;
import me.duckdoom5.RpgEssentials.RpgRegions.Config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Music;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.player.RenderDistance;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RpgEssentialsPlayerListener implements Listener{
	public RpgRegions plugin;
    
    public RpgEssentialsPlayerListener(RpgRegions instance) {
        plugin = instance; 
    }
	
	HashMap<Player, Vector> playerLoc = new HashMap<Player, Vector>();
    HashMap<LocalPlayer, String> inregion = new LinkedHashMap<LocalPlayer, String>();
    
    public boolean isInRegion(Player player){
    	WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
    	LocalPlayer localplayer = worldguard.wrapPlayer(player);
    	if(inregion.containsKey(localplayer))
    		return true;
    	return false;
    }
    
    public String getRegion(Player player){
    	WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
    	LocalPlayer localplayer = worldguard.wrapPlayer(player);
    	if(inregion.containsKey(localplayer)){
    		return inregion.get(localplayer);
    	}
		return null;
    }
    
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
		RpgEssentials rpge = (RpgEssentials) plugin.RpgEssentials;
    	Player player = event.getPlayer();
    	SpoutPlayer splayer = SpoutManager.getPlayer(player);
    	if(event.isCancelled())
            return;
    	
    	if(RpgEssentials.wl.worlds.get(player.getWorld())){
	    	if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
		    	Vector position = new Vector(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
		    	if(!playerLoc.containsKey(player))
		        {
		            playerLoc.put(player, position);
		            return;
		        }
		        if(!playerLoc.get(player).equals(position))
		        {
		        	playerLoc.put(player, position);
			        WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
			        LocalPlayer localplayer = worldguard.wrapPlayer(event.getPlayer());
			        Vector curpos = localplayer.getPosition();
			        Location to = event.getTo();
			        World world = to.getWorld();
			        RegionManager rm = worldguard.getRegionManager(world);
			        ApplicableRegionSet regions = rm.getApplicableRegions(curpos);
			        
			        if(regions.size() == 0){
			        	if(inregion.containsKey(localplayer)){
			        		if(canLeave(player, inregion.get(localplayer))){
			        			if(Configuration.regions.contains("Regions." + inregion.get(localplayer) + ".exit.tpTo")){
					        		org.bukkit.util.Vector tpTo = Configuration.regions.getVector("Regions." + inregion.get(localplayer) + ".exit.tpTo");
					        		String worldto = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.tpToWorld", "world");
					        		Location loc = tpTo.toLocation(Bukkit.getWorld(worldto));
					        		player.teleport(loc);
					        	}
			        			
			        			//SpoutManager.getSkyManager().setSkyColor(splayer, new Color(0.0F,0.0F,0.0F,1.0F));
			        			SpoutManager.getSkyManager().setSkyColor(splayer, Color.remove());
			        			SpoutManager.getSkyManager().setFogColor(splayer, Color.remove());
				        		
			        			Music.fadeOut(rpge, splayer, 10);
			        			
					        	//region exit methods
					        	String message = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.message");
						        String sub = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.submessage");
						        int icon = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".exit.iconId");
						        String music = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.music");
						        String texturepack = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.texturepack");
						        String command = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.command");
						        String fog = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.fog");
						        boolean repeat = Configuration.regions.getBoolean("Regions." + inregion.get(localplayer) + ".exit.repeat");
						        int time = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".exit.time");
						        
						        if(message != null && sub != null && icon != 0)
						            if(message.length() <= 26 && sub.length() <= 26)
						                splayer.sendNotification(message, sub, Material.getMaterial(icon));
						            else
						                System.out.println("A region message is greater than 26 chars");
						        if(music != null){
						        	Music.fadeOut(rpge, splayer, 10);
						        	if(repeat)
						        		Music.repeat(rpge, music, splayer, time>0?time:1);
						        	else
						        		SpoutManager.getSoundManager().playCustomMusic(plugin, splayer, music, false);
						        }
						        if(texturepack != null){
						        	splayer.setTexturePack(texturepack);
						        }
						        if(command != null){
						        	splayer.performCommand(command);
						        }
						        if(fog != null){
							        if(fog.equalsIgnoreCase("tiny")){
							            splayer.setRenderDistance(RenderDistance.TINY);
							        }else if(fog.equalsIgnoreCase("short")){
							            splayer.setRenderDistance(RenderDistance.SHORT);
							        }else if(fog.equalsIgnoreCase("normal")){
							            splayer.setRenderDistance(RenderDistance.NORMAL);
							        }else if(fog.equalsIgnoreCase("far")){
							            splayer.setRenderDistance(RenderDistance.FAR);
							        }
						        }
						        
					        	inregion.remove(localplayer);
					            return;
			        		}
							player.teleport(event.getFrom());
							event.setCancelled(true);
							return;
			        	}
			        }
			        
			        String regionname = null;
			        for(Iterator<?> iterator = regions.iterator(); iterator.hasNext();)
			        {
			            ProtectedRegion protectedregion = (ProtectedRegion)iterator.next();
			            regionname = protectedregion.getId();
			        }
			        
			        if(regionname != null){
				        if(inregion.containsKey(localplayer) && inregion.get(localplayer).equals(regionname))
			                return;
				        
				        if(canEnter(player, inregion.get(localplayer))){
				        	if(Configuration.regions.contains("Regions." + inregion.get(localplayer) + ".enter.tpTo")){
				        		org.bukkit.util.Vector tpTo = Configuration.regions.getVector("Regions." + inregion.get(localplayer) + ".enter.tpTo");
				        		String worldto = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.tpToWorld", "world");
				        		Location loc = tpTo.toLocation(Bukkit.getWorld(worldto));
				        		player.teleport(loc);
				        	}
					        inregion.put(localplayer, regionname);
					        
					        String message = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.message");
					        String sub = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.submessage");
					        int icon = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".enter.iconId");
					        String music = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.music");
					        String texturepack = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.texturepack");
					        String command = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.command");
					        String fog = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.fog");
					        String skycolor = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.skycolor");
					        String fogcolor = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.fogcolor");
					        boolean repeat = Configuration.regions.getBoolean("Regions." + inregion.get(localplayer) + ".enter.repeat", false);
					        int time = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".enter.time", 1);
					        
					        if(message != null && sub != null && icon != 0)
					            if(message.length() <= 26 && sub.length() <= 26)
					                splayer.sendNotification(message, sub, Material.getMaterial(icon));
					            else
					                System.out.println("A region message is greater than 26 chars");
					        if(music != null){
					        	Music.fadeOut(rpge, splayer, 10);
					        	if(repeat)
					        		Music.repeat(rpge, music, splayer, time>0?time:1);
					        	else
					        		SpoutManager.getSoundManager().playCustomMusic(plugin, splayer, music, false);
					        }
					        if(texturepack != null){
					        	splayer.setTexturePack(texturepack);
					        }
					        if(command != null){
					        	splayer.performCommand(command);
					        }
					        if(skycolor != null){
					        	String[] strings = skycolor.split(" ");
					        	int red = Integer.parseInt(strings[0]);
					        	int green = Integer.parseInt(strings[1]);
					        	int blue = Integer.parseInt(strings[2]);
					        	
					        	Color color = new Color(red, green, blue, 1);
					        	SpoutManager.getSkyManager().setSkyColor(splayer, color);
					        	splayer.sendMessage("skycolor set");
					        }
					        if(fogcolor != null){
					        	String[] strings = skycolor.split(" ");
					        	int red = Integer.parseInt(strings[0]);
					        	int green = Integer.parseInt(strings[1]);
					        	int blue = Integer.parseInt(strings[2]);
					        	
					        	Color color = new Color(red, green, blue, 1);
					        	SpoutManager.getSkyManager().setFogColor(splayer, color);
					        }
					        if(fog != null){
						        if(fog.equalsIgnoreCase("tiny")){
						            splayer.setRenderDistance(RenderDistance.TINY);
						        }else if(fog.equalsIgnoreCase("short")){
						            splayer.setRenderDistance(RenderDistance.SHORT);
						        }else if(fog.equalsIgnoreCase("normal")){
						            splayer.setRenderDistance(RenderDistance.NORMAL);
						        }else if(fog.equalsIgnoreCase("far")){
						            splayer.setRenderDistance(RenderDistance.FAR);
						        }
					        }
				        }else{
				        	event.setCancelled(true);
				        	return;
				        }
			        }
		        }
	    	}
    	}
    }
    
    private boolean canLeave(Player player, String region) {
    	RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
    	if(!Configuration.regions.getBoolean("Regions." + region + ".exit.canLeave", true)){
    		player.sendMessage(ChatColor.RED + "You can't leave this region!");
    		return false;
    	}
		if(Configuration.regions.contains("Regions." + region + ".exit.restrictions")){
			if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.skillLvl")){
				for(Skill skill:Skill.values()){
					if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.minSkillLvl."+ skill.toString().toLowerCase())){
						int required = (Configuration.regions.getInt("Regions." + region + ".exit.restrictions.minSkillLvl."+ skill.toString().toLowerCase()));
						if(rpgplayer.getLvl(skill) < required){
							player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to leave this region");
							return false;
						}
					}
				}
			}
			if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.maxSkillLvl")){
				for(Skill skill:Skill.values()){
					if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.maxSkillLvl."+ skill.toString().toLowerCase())){
						int required = (Configuration.regions.getInt("Regions." + region + ".exit.restrictions.maxSkillLvl."+ skill.toString().toLowerCase()));
						if(rpgplayer.getLvl(skill) > required){
							player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to leave this region");
							return false;
						}
					}
				}
			}
			if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.completedQuest")){
				ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
				Set<String> keys = section.getKeys(false);
				for(String quest: keys){
					if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.completedQuest." + quest)){
						if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("completed")){
							String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest +".text.name");
							player.sendMessage(ChatColor.RED + "You need to complete \"" + name + "\"before you may leave this region");
							return false;
						}
					}
				}
			}
			
			if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.startedQuest")){
				ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
				Set<String> keys = section.getKeys(false);
				for(String quest: keys){
					if(Configuration.regions.contains("Regions." + region + ".exit.restrictions.startedQuest." + quest)){
						if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
							String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest +".text.name");
							player.sendMessage(ChatColor.RED + "You need to start \"" + name + "\"before you may leave this region");
							return false;
						}
					}
				}
			}
		}
    	return true;
	}

	private boolean canEnter(Player player, String region) {
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
    	if(!Configuration.regions.getBoolean("Regions." + region + ".enter.canEnter", true)){
    		player.sendMessage(ChatColor.RED + "You can't enter this region!");
    		return false;
    	}
    	if(Configuration.regions.contains("Regions." + region + ".enter.restrictions")){
			if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.minSkillLvl")){
				for(Skill skill:Skill.values()){
					if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.minSkillLvl."+ skill.toString().toLowerCase())){
						int required = (Configuration.regions.getInt("Regions." + region + ".enter.restrictions.minSkillLvl."+ skill.toString().toLowerCase()));
						if(rpgplayer.getLvl(skill) < required){
							player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to enter this region");
							return false;
						}
					}
				}
			}
			if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.maxSkillLvl")){
				for(Skill skill:Skill.values()){
					if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.maxSkillLvl."+ skill.toString().toLowerCase())){
						int required = (Configuration.regions.getInt("Regions." + region + ".enter.restrictions.maxSkillLvl."+ skill.toString().toLowerCase()));
						if(rpgplayer.getLvl(skill) > required){
							player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to enter this region");
							return false;
						}
					}
				}
			}
			if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.completedQuest")){
				ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
				Set<String> keys = section.getKeys(false);
				for(String quest: keys){
					if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.completedQuest." + quest)){
						if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("completed")){
							String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest +".text.name");
							player.sendMessage(ChatColor.RED + "You need to complete \"" + name + "\"before you may enter this region");
							return false;
						}
					}
				}
			}
			
			if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.startedQuest")){
				ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
				Set<String> keys = section.getKeys(false);
				for(String quest: keys){
					if(Configuration.regions.contains("Regions." + region + ".enter.restrictions.startedQuest." + quest)){
						if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
							String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest +".text.name");
							player.sendMessage(ChatColor.RED + "You need to start \"" + name + "\"before you may enter this region");
							return false;
						}
					}
				}
			}
		}
    	return true;
	}
}
