package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;


public class NpcSelect extends RpgEssentialsCommandExecutor{
	public NpcSelect(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc select
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc select " + ChatColor.RED + "{npc id}");
			}else if(args.length == 2){//npc select {id}
				if(plugin.hasPermission(player, "rpgessentials.npc.select") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					npc.select(plugin, splayer, args[1]);
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc select " + ChatColor.RED + "{npc id}");
			}
		}
	}
}
