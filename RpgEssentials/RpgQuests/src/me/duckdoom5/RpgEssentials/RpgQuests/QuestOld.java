package me.duckdoom5.RpgEssentials.RpgQuests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class QuestOld {
	public static Set<String> questlist = new LinkedHashSet<String>();
	public static HashMap<SpoutPlayer, String> clickednpc = new LinkedHashMap<SpoutPlayer, String>();
	
	public static void run(Player player, String type, Material material) throws IOException{
		for(String quest:questlist){
			if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
				if(me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
					//test task requirements
					if(Configuration.quests.contains("Quests." + quest +".task." + type + "." + material.getId())){
						
						boolean run = false;
						if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".done")){
							if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".done")){
								run = true;
							}
						}else{
							me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".done", false);
							run = true;
						}
						
						if(run){
							int required = Configuration.quests.getInt("Quests." + quest +".task." + type + "." + material.getId() + ".amount");
							if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".amount")){
								int old = me.duckdoom5.RpgEssentials.config.Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".amount");
								if(old + 1 == required){
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".done", true);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									
									if(isDone(quest, player)){
										player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".state", "completed");
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									}else{
										player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
									}
								}else{
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".amount", old + 1);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								}
							}else{
								if(required == 1){
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".done", true);
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".amount", 1);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									
									if(isDone(quest, player)){
										player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".state", "completed");
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									}else{
										player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
									}
								}else{
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task." + type + "." + material.getId() + ".amount", 1);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean bringItems(String quest, Player player) throws IOException {
		if(Configuration.quests.contains("Quests." + quest +".task.bring")){
			for(Material material:Material.values()){
				if(Configuration.quests.contains("Quests." + quest +".task.bring." + material.getId())){
					boolean run = false;
					if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".done")){
						if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".done")){
							run = true;
						}
					}else{
						me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".done", false);
						run = true;
					}
					
					if(run){
						int required = Configuration.quests.getInt("Quests." + quest +".task.bring." + material.getId() + ".amount");
						if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount")){
							
							
							while(player.getInventory().contains(material)){
								ItemStack item = player.getInventory().getItem(player.getInventory().first(material));
								int got = item.getAmount();
								
								int old = me.duckdoom5.RpgEssentials.config.Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount");
								
								if(old + got > required){
									int remove = required - old;
									item.setAmount(got - remove);
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount", old + (got -remove));
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									break;
								}else if(old + got == required){
									player.getInventory().removeItem(item);
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount", old + got);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									break;
								}else if(old + got < required){
									player.getInventory().removeItem(item);
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount", old + got);
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								}
							}
							
							int old = me.duckdoom5.RpgEssentials.config.Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".amount");
							
							if(old == required){
								me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.bring." + material.getId() + ".done", true);
								me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								
								if(isDone(quest, player)){
									player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
									me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".state", "completed");
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								}else{
									player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
								}
								return true;
							}
							player.sendMessage(ChatColor.RED + "You still need " + (required - old) + " " + material.toString().toLowerCase().replace("_", " "));
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void updateQuests(){
		questlist.clear();
		if(Configuration.quests.contains("Quests")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests");
			Iterator<?> keys = section.getKeys(false).iterator();
			while(keys.hasNext()){
				String quest = (String)keys.next();
				questlist.add(quest);
			}
		}
	}
	
	public static boolean isDone(String quest, Player player){
		Boolean all = true;
		if(Configuration.quests.contains("Quests." + quest +".task.break")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.break");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.break." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.place")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.place");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.place." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.craft")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.craft");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.craft." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.smelt")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.smelt");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.smelt." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.kill")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.kill");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.kill." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.bring")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.bring");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.bring." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.escort")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.escort");
			Iterator<?> keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.escort." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		return all;
	}
	
	public static void Clicked(RpgQuests plugin, Player player, SpoutPlayer splayer, String id) throws IOException{
		boolean run = true;
		String quest = me.duckdoom5.RpgEssentials.config.Configuration.npc.getString("Npc." + id + ".quest");
		if(!quest.equals("none")){
			if(Configuration.quests.contains("Quests." + quest)){
				
				
				if(Configuration.quests.contains("Quests." + quest + ".requires")){
					String required = Configuration.quests.getString("Quests." + quest + ".requires.quest");
					if(!me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + required + ".state") && !me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + required + ".state").equals("ended")){
						player.sendMessage(ChatColor.RED + "This quest requires " + Configuration.quests.getString("Quests." + required +".text.name"));
						run= false;
					}
					
					if(RpgEssentials.RpgLeveling != null && run){
						for(Skill skill:Skill.values()){
							if(Configuration.quests.contains("Quests." + quest + ".requires." + skill.toString().toLowerCase())){
								int requiredlvl = Configuration.quests.getInt("Quests." + quest + ".requires." + skill.toString().toLowerCase());
								RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player.getName());
								if(rpgplayer.getLvl(skill) < requiredlvl){
									player.sendMessage(ChatColor.RED + "This quest requires " + skill.toString().toLowerCase() + " level " + requiredlvl);
									run = false;
									continue;
								}
							}
						}
					}
				}else{
					run = true;
				}
				
				if(Configuration.quests.getBoolean("Quests." + quest + ".repeatable")){
					if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state") && me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("ended")){
						//do you want to restart?
						me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + splayer.getName() + ".quest." + me.duckdoom5.RpgEssentials.config.Configuration.npc.getString("Npc." + id + ".quest"), null);
						try {
							me.duckdoom5.RpgEssentials.config.Configuration.players.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				if(run){
					String name = Configuration.quests.getString("Quests." + quest +".text.name");
					if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
						if(me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started") || me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("completed")){
							if(isDone(quest, player)){
								me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + splayer.getName() + ".quest." + me.duckdoom5.RpgEssentials.config.Configuration.npc.getString("Npc." + id + ".quest") + ".state", "ended");
								try {
									me.duckdoom5.RpgEssentials.config.Configuration.players.save();
								} catch (Exception e) {
									e.printStackTrace();
								}
								String end = Configuration.quests.getString("Quests." + quest +".text.end");
								String [] buttons = {"Close"};
								
								//reward player
								ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".reward");
								Iterator<?> keys = section.getKeys(false).iterator();
								for(int i = 0; keys.hasNext(); ++i){
									String type = (String) keys.next();
									try{
										player.getInventory().addItem(new ItemStack(Material.getMaterial(Integer.parseInt(type)), Configuration.quests.getInt("Quests." + quest +".reward." + type + ".amount")));
									}catch(NumberFormatException e){
										int customId = 0;
										Material material = Material.FLINT;
										if(RpgEssentials.mm.hasMaterial(type)){
											org.getspout.spoutapi.material.Material smaterial = RpgEssentials.mm.getMaterialByName(type);
											if(smaterial instanceof GenericCustomBlock){
												customId = ((GenericCustomBlock) smaterial).getCustomId();
												material = Material.getMaterial(((GenericCustomBlock) smaterial).getBlockId());
											}else{
												customId = ((GenericCustomItem) smaterial).getCustomId();
											}
										}
										player.getInventory().addItem(new ItemStack(material, Configuration.quests.getInt("Quests." + quest +".reward." + type + ".amount"), (short) customId));
									}
								}
								if(RpgEssentials.RpgLeveling != null){
									if(Configuration.quests.contains("Quests." + quest +".reward.xp")){
										int exp = Configuration.quests.getInt("Quests." + quest +".reward.xp");
										PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.QUESTING, exp);
						    			Bukkit.getServer().getPluginManager().callEvent(callevent);
									}else{
										int exp = 20;
										PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.QUESTING, exp);
						    			Bukkit.getServer().getPluginManager().callEvent(callevent);
									}
								}
								if(Configuration.quests.contains("Quests." + quest +".reward.money")){
									int money = Configuration.quests.getInt("Quests." + quest +".reward.money");
									PlayerConfig.setMoney(player.getName(), PlayerConfig.getMoney(player.getName()) + money);
								}
								
								TextSelectMenu menu = new TextSelectMenu(plugin, splayer, name, MessageUtils.TextMenuSplit(end), buttons, EntityType.PLAYER);
							}else{
								if(!bringItems(quest, player)){
									String between = Configuration.quests.getString("Quests." + quest +".text.between");
									
									String [] buttons = {"Close"};
									TextSelectMenu menu = new TextSelectMenu(plugin, splayer, name, MessageUtils.TextMenuSplit(between), buttons, EntityType.PLAYER);
								}
							}
						}else{//state is ended
							player.sendMessage(ChatColor.RED + "You already finished " + Configuration.quests.getString("Quests." + quest +".text.name") + ".");
						}
					}else{
						clickednpc.put(splayer, id);
						String welcome = Configuration.quests.getString("Quests." + quest +".text.welcome");
						String task = Configuration.quests.getString("Quests." + quest +".text.task");
						String [] raw = MessageUtils.TextMenuSplit(task);
						String [] text = new String[raw.length + 1];
						for(int i = 0; i - 1 < raw.length; i++){
							if(i == 0){
								text[i] = welcome;
							}else{
								text[i] = raw[i-1];
							}
						}
						String [] buttons = {"Accept Quest", "Close"};
						TextSelectMenu menu = new TextSelectMenu(plugin, splayer, name, text, buttons, EntityType.PLAYER);
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "This quest is not available, please warn your server admin.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "This quester has no quest. Type: /rnpc quest {quest id} to provide one.");
		}
	}
	
	public static void accepted(RpgQuests plugin, SpoutPlayer splayer){
		String id = clickednpc.get(splayer);
		clickednpc.remove(splayer);
		String quest = me.duckdoom5.RpgEssentials.config.Configuration.npc.getString("Npc." + id + ".quest");
		String name = Configuration.quests.getString("Quests." + quest +".text.name");
		
		me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + splayer.getName() + ".quest." + me.duckdoom5.RpgEssentials.config.Configuration.npc.getString("Npc." + id + ".quest") + ".state", "started");
		
		try {
			me.duckdoom5.RpgEssentials.config.Configuration.players.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String [] buttons = {"Close"};
		TextSelectMenu menu = new TextSelectMenu(plugin, splayer, name, MessageUtils.TextMenuSplit("Accepted " + name), buttons, EntityType.PLAYER);
	}

}
