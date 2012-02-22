package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcText extends RpgEssentialsCommandExecutor{
	public NpcText(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc text
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc owner " + ChatColor.RED + "{player}");
			}else if(args.length == 2){//npc text {text}
				if(player.hasPermission("rpgessentials.npc.text") || player.hasPermission("npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						
						Configuration.npc.set("Npc." + id + ".text", args[1]);
						player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "text has been set to \"" + ChatColor.YELLOW + args[1] + "\"");
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.RED + "No npc selected!");
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc owner " + ChatColor.RED + "{player}");
			}
		}
	}
}