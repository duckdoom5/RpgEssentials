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

	private final static NpcHashmaps npc = new NpcHashmaps();
	
	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc create
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
			}else if(args.length == 2){//npc create {name}
				if(plugin.hasPermission(player, "rpgessentials.npc.create") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					Location location = player.getLocation();
					location.toVector();
					
					Configuration.npc.set("Npc." + args[1] + ".type", "default");
					Configuration.npc.set("Npc." + args[1] + ".text", "Hello, have a nice day!");
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
					
					RpgEssentials.nm.spawnHumanNPC(args[1], location);
					player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " has been created!");
					npc.select(plugin, splayer, args[1]);
				} else {
					permissions(player);
				}
				
			}else if(args.length == 3){//npc create {name} [type]
				if(plugin.hasPermission(player, "rpgessentials.npc.create") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					if(args[2].equalsIgnoreCase("default") || args[2].equalsIgnoreCase("banker") || args[2].equalsIgnoreCase("quester")){
						Location location = player.getLocation();
						location.toVector();
						
						Configuration.npc.set("Npc." + args[1] + ".type", args[2].toLowerCase());
						
						if(args[1].equalsIgnoreCase("quester")){
							Configuration.npc.set("Npc." + args[1] + ".quest", "none");
						}
						
						Configuration.npc.set("Npc." + args[1] + ".text", "Hello, have a nice day!");
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
						
						RpgEssentials.nm.spawnHumanNPC(args[1], location);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " with type: " + ChatColor.YELLOW + args[2].toLowerCase() + ChatColor.GREEN +" has been created!");
						npc.select(plugin, splayer, args[1]);
					}else{
						player.sendMessage(ChatColor.RED + "Please use a valid type: default/banker/quester");
					}
				} else {
					permissions(player);
				}
			}else{
			player.sendMessage(ChatColor.RED + "Too many arguments !");
			player.sendMessage(ChatColor.AQUA + "Usage: /rnpc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
			}
		}
	}
}
