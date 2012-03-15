package me.duckdoom5.RpgEssentials.handelers;

import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Quests {

	public static void BlockPlace(BlockPlaceEvent event) {
		
	}

	public static void BlockBreak(BlockBreakEvent event) {
		
	}

	public static void EntityDamage(EntityDamageEvent event) {
		
	}

	public static void EntityDeath(EntityDeathEvent event) {
		
	}
	
	public static HashMap<SpoutPlayer, String> clickednpc = new LinkedHashMap<SpoutPlayer, String>();
	
	public static void Clicked(RpgEssentials plugin, Player player, SpoutPlayer splayer, String id){
		String quest = Configuration.npc.getString("Npc." + id + ".quest");
		if(!quest.equals("none")){
			if(Configuration.quests.contains("Quests." + quest)){
				String name = Configuration.quests.getString("Quests." + quest +".text.name");
				if(Configuration.players.contains("players." + player.getName() + ".quest." + quest + ".state")){
					if(Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")){
						//test task requirements
						//if(true){
						//}else{
							String between = Configuration.quests.getString("Quests." + quest +".text.between");
							String [] buttons = {"Close"};
							TextSelectMenu.open(plugin, splayer, name, MessageUtils.TextMenuSplit(between), buttons);
						//}
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
