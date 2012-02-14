package me.duckdoom5.RpgEssentials.NPC;

import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.topcat.npclib.entity.NPC;

public class NpcHashmaps {
	public static HashMap<Player, String> selected = new LinkedHashMap<Player, String>();
	static YamlConfiguration npcconfig = new YamlConfiguration();
	
	public static void select(RpgEssentials plugin, Player player, String id){
		
		NPC npc = plugin.m.getNPC(id);
		if(npcconfig.getString("Npc." + id + ".owner") == "");
		player.sendMessage(ChatColor.GREEN + "You have selected NPC: " + ChatColor.YELLOW + id);
		selected.put(player, id);
	}
	
	public static String getSelected(Player player){
		if(selected.containsKey(player)){
			String id = selected.get(player);
			return id;
		}else{
			player.sendMessage(ChatColor.RED + "No npc selected!");
			return null;
		}
	}
}
