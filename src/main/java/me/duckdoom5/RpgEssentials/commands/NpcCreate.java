package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcCreate extends RpgEssentialsCommandExecutor{
	public NpcCreate(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc create
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
			}else if(args.length == 2){//npc create {name}
				if(player.hasPermission("rpgessentials.npc.create") || player.hasPermission("npc.admin")){
					Location location = player.getLocation();
					location.toVector();
					
					Configuration.npc.set("Npc." + args[1] + ".type", "default");
					Configuration.npc.set("Npc." + args[1] + ".owner", player.getName());
					Configuration.npc.set("Npc." + args[1] + ".location", location.toVector());
					Configuration.npc.set("Npc." + args[1] + ".world", location.getWorld().getName());
					Configuration.npc.set("Npc." + args[1] + ".pitch", location.getPitch());
					Configuration.npc.set("Npc." + args[1] + ".yaw", location.getYaw());
					try {
						Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					plugin.m.spawnHumanNPC(args[1], location);
					player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " has been created!");
					NpcHashmaps.select(plugin, splayer, args[1]);
				} else {
					permissions(player);
				}
				
			}else if(args.length == 3){//npc create {name} [type]
				if(player.hasPermission("rpgessentials.npc.create") || player.hasPermission("npc.admin")){
					if(args[2].equalsIgnoreCase("default") || args[2].equalsIgnoreCase("banker")){
						Location location = player.getLocation();
						location.toVector();
						
						Configuration.npc.set("Npc." + args[1] + ".type", args[2]);
						Configuration.npc.set("Npc." + args[1] + ".text", "Hello, have a nice day!");
						Configuration.npc.set("Npc." + args[1] + ".location", location.toVector());
						Configuration.npc.set("Npc." + args[1] + ".world", location.getWorld().getName());
						Configuration.npc.set("Npc." + args[1] + ".pitch", location.getPitch());
						Configuration.npc.set("Npc." + args[1] + ".yaw", location.getYaw());
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						plugin.m.spawnHumanNPC(args[1], location);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " with type:" + args[2] +" has been created!");
					}else{
						player.sendMessage(ChatColor.RED + "Please use a valid type: default/banker");
					}
				} else {
					permissions(player);
				}
			}else{
			player.sendMessage(ChatColor.RED + "Too many arguments !");
			player.sendMessage(ChatColor.AQUA + "Usage: /npc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
			}
		}
	}
}
