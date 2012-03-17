package me.duckdoom5.RpgEssentials.handelers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Quests {

	public static Set<String> questlist = new LinkedHashSet<String>();
	public static HashMap<SpoutPlayer, String> clickednpc = new LinkedHashMap<SpoutPlayer, String>();
	
	public static void BlockPlace(BlockPlaceEvent event) throws Exception {
		Player player = event.getPlayer();
		Block block = event.getBlockPlaced();
		updateQuests();
		for(String quest:questlist){
			if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
				if(Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
					//test task requirements
					if(Configuration.quests.contains("Quests." + quest +".task.place." + block.getTypeId())){
						int required = Configuration.quests.getInt("Quests." + quest +".task.place." + block.getTypeId() + ".amount");
						if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".amount")){
							if(!Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".done")){
								int old = Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".amount");
								if(old == required){
									Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".done", true);
									Configuration.players.save();Configuration.players.save();
									
									if(isDone(quest, player)){
										player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
									}else{
										player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
									}
								}else{
									Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".amount", old + 1);
									Configuration.players.save();
									
								}
							}
						}else{
							Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".done", false);
							if(required == 1){
								Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".done", true);
								Configuration.players.save();
								
								if(isDone(quest, player)){
									player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
								}else{
									player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
								}
							}else{
								Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.place." + block.getTypeId() + ".amount", 1);
								Configuration.players.save();
							}
						}
					}
				}
			}
		}
	}

	public static void BlockBreak(BlockBreakEvent event) throws Exception {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		updateQuests();
		for(String quest:questlist){
			if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
				if(Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
					//test task requirements
					if(Configuration.quests.contains("Quests." + quest +".task.break." + block.getTypeId())){
						int required = Configuration.quests.getInt("Quests." + quest +".task.break." + block.getTypeId() + ".amount");
						if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".amount")){
							if(!Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".done")){
								int old = Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".amount");
								if(old == required){
									Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".done", true);
									Configuration.players.save();
									
									if(isDone(quest, player)){
										player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
									}else{
										player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
									}
								}else{
									Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".amount", old + 1);
									Configuration.players.save();
									
								}
							}
						}else{
							Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".done", false);
							if(required == 1){
								Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".done", true);
								Configuration.players.save();
								
								if(isDone(quest, player)){
									player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
								}else{
									player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
								}
								
							}else{
								Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.break." + block.getTypeId() + ".amount", 1);
								Configuration.players.save();
								
							}
						}
					}
				}
			}
		}
	}

	public static void EntityDamage(EntityDamageEvent event) {
		updateQuests();
	}

	public static void EntityDeath(EntityDeathEvent event) {
		updateQuests();
	}
	
	private static void updateQuests(){
		questlist.clear();
		ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests");
		Iterator keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String quest = (String)keys.next();
			questlist.add(quest);
		}
	}
	
	private static boolean isDone(String quest, Player player){
		Boolean all = true;
		if(Configuration.quests.contains("Quests." + quest +".task.break")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.break");
			Iterator keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.break." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.place")){
			ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".task.place");
			Iterator keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String type = (String)keys.next();
				if(!Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.place." + type + ".done")){
					//doesn't meet requirements
					all = false;
				}
			}
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.craft")){
			
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.smelt")){
			
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.kill")){
			
		}
		if(all && Configuration.quests.contains("Quests." + quest +".task.escort")){
			
		}
		return all;
	}
	
	public static void Clicked(RpgEssentials plugin, Player player, SpoutPlayer splayer, String id){
		String quest = Configuration.npc.getString("Npc." + id + ".quest");
		if(!quest.equals("none")){
			if(Configuration.quests.contains("Quests." + quest)){
				String name = Configuration.quests.getString("Quests." + quest +".text.name");
				if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
					if(Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
						if(isDone(quest, player)){
							Configuration.players.set("players." + splayer.getName() + ".quest." + Configuration.npc.getString("Npc." + id + ".quest") + ".state", "ended");
							try {
								Configuration.players.save();
							} catch (Exception e) {
								e.printStackTrace();
							}
							String end = Configuration.quests.getString("Quests." + quest +".text.end");
							String [] buttons = {"Close"};
							TextSelectMenu.open(plugin, splayer, name, MessageUtils.TextMenuSplit(end), buttons);
							//reward player
							ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests." + quest +".reward");
							Iterator keys = section.getKeys(false).iterator();
							for(int i = 0; keys.hasNext(); ++i){
								int type = (Integer)keys.next();
								player.getInventory().addItem(new ItemStack(Material.getMaterial(type), Configuration.quests.getInt("Quests." + quest +".reward" + type + ".amount")));
							}
							
						}else{
							String between = Configuration.quests.getString("Quests." + quest +".text.between");
							String [] buttons = {"Close"};
							TextSelectMenu.open(plugin, splayer, name, MessageUtils.TextMenuSplit(between), buttons);
						}
					}else{//state is ended
						player.sendMessage(ChatColor.RED + "You already finished this quest.");
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
					TextSelectMenu.open(plugin, splayer, name, text, buttons);
				}
			}else{
				player.sendMessage(ChatColor.RED + "This quest is not available, please warn your server admin.");
			}
		}else{
			player.sendMessage(ChatColor.RED + "This quester has no quests.");
		}
	}
	
	public static void accepted(RpgEssentials plugin, SpoutPlayer splayer){
		String id = clickednpc.get(splayer);
		clickednpc.remove(splayer);
		String quest = Configuration.npc.getString("Npc." + id + ".quest");
		String name = Configuration.quests.getString("Quests." + quest +".text.name");
		
		Configuration.players.set("players." + splayer.getName() + ".quest." + Configuration.npc.getString("Npc." + id + ".quest") + ".state", "started");
		
		try {
			Configuration.players.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String [] buttons = {"Close"};
		TextSelectMenu.open(plugin, splayer, name, MessageUtils.TextMenuSplit("Accepted " + name), buttons);
	}

}
