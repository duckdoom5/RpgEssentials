package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcOwner extends RpgEssentialsCommandExecutor{
	public NpcOwner(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc owner
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc owner " + ChatColor.RED + "{player}");
			}else if(args.length == 2){//npc owner {player}
				if(plugin.hasPermission(player, "rpgessentials.npc.owner") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						
						Configuration.npc.set("Npc." + id + ".owner", args[1]);
						player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "owner has been set to " + ChatColor.YELLOW + args[1]);
						npc.unselect(player);
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
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