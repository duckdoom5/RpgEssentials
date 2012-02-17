package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcRemove extends RpgEssentialsCommandExecutor{
	public NpcRemove(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc remove
				if(player.hasPermission("rpgessentials.npc.remove") || player.hasPermission("npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						
						Configuration.npc.set("Npc." + id + ".location", null);
						Configuration.npc.set("Npc." + id + ".world", null);
						Configuration.npc.set("Npc." + id + ".pitch", null);
						Configuration.npc.set("Npc." + id + ".yaw", null);
						if(Configuration.npc.contains("Npc." + id + ".cape")){
							Configuration.npc.set("Npc." + id + ".cape", null);
						}
						if(Configuration.npc.contains("Npc." + id + ".skin")){
							Configuration.npc.set("Npc." + id + ".skin", null);
						}
						if(Configuration.npc.contains("Npc." + id + ".item")){
							Configuration.npc.set("Npc." + id + ".item", null);
						}
						Configuration.npc.set("Npc." + id, null);
						
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						plugin.m.despawnById(id);
						player.sendMessage(ChatColor.GREEN + "You have successfully removed NPC: " + ChatColor.YELLOW + id);
					}else{
						player.sendMessage(ChatColor.RED + "No npc selected!");
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc remove " + ChatColor.GREEN + "[name]");
			}
		}
	}
}
