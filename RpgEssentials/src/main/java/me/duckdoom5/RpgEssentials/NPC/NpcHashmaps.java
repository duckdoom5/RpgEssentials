package me.duckdoom5.RpgEssentials.NPC;

import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.topcat.npclib.entity.NPC;

public class NpcHashmaps {
	public static HashMap<Player, String> selected = new LinkedHashMap<Player, String>();
	
	public void select(Player player, String id){
		NPC npc = RpgEssentials.nm.getNPC(id);
		if(Configuration.npc.getString("Npc." + id + ".owner").equals(player.getName()) || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")){
			player.sendMessage(ChatColor.GREEN + "You have selected NPC: " + ChatColor.YELLOW + id);
			selected.put(player, id);
		}else{
			player.sendMessage(ChatColor.RED + "This is not your npc!");
		}
	}
	
	public void unselect(Player player){
		selected.remove(player);
		player.sendMessage(ChatColor.GREEN + "You have unselected your npc!");
	}
	
	public String getSelected(Player player){
		if(selected.containsKey(player)){
			String id = selected.get(player);
			return id;
		}
		player.sendMessage(ChatColor.RED + "No npc selected!");
		return null;
	}
}
