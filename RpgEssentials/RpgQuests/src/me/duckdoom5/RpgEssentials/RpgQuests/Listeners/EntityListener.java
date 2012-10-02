package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityListener implements Listener{
	public static void EntityDeath(EntityDeathEvent event) throws IOException {
		if(event.getEntity().getKiller() != null){
			Player player = event.getEntity().getKiller();
			RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player.getName());
			RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.KILL, event);
			
			
			/*EntityType type = event.getEntity().getType();
			for(String quest:QuestOld.questlist){
				if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
					if(me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
						//test task requirements
						if(Configuration.quests.contains("Quests." + quest +".task.kill." + type.getName().toLowerCase().replace("_", " "))){
							boolean run = false;
							if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".done")){
								if(!me.duckdoom5.RpgEssentials.config.Configuration.players.getBoolean("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".done")){
									run = true;
								}
							}else{
								me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".done", false);
								run = true;
							}
							
							if(run){
								int required = Configuration.quests.getInt("Quests." + quest +".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount");
								if(me.duckdoom5.RpgEssentials.config.Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount")){
									int old = me.duckdoom5.RpgEssentials.config.Configuration.players.getInt("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount");
									if(old + 1 == required){
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".done", true);
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
										
										if(QuestOld.isDone(quest, player)){
											player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
											me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".state", "completed");
											me.duckdoom5.RpgEssentials.config.Configuration.players.save();
										}else{
											player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
										}
									}else{
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount", old + 1);
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									}
								}else{
									if(required == 1){
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".done", true);
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount", 1);
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
										
										if(QuestOld.isDone(quest, player)){
											player.sendMessage(ChatColor.GREEN + "You have completed the quest!");
											me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".state", "completed");
											me.duckdoom5.RpgEssentials.config.Configuration.players.save();
										}else{
											player.sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
										}
									}else{
										me.duckdoom5.RpgEssentials.config.Configuration.players.set("players." + player.getName() + ".quest." + quest + ".task.kill." + type.getName().toLowerCase().replace("_", " ") + ".amount", 1);
										me.duckdoom5.RpgEssentials.config.Configuration.players.save();
									}
								}
							}
						}
					}
				}
			}*/
		}
	}
}
