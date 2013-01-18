package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.Stores;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcType extends CommandManager{
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc type
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc type " + ChatColor.RED + "{type}");
			}else if(args.length == 2){//npc type {type}
				if(RpgEssentials.hasPermission(player, "rpgessentials.npc.type") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")){
					if(args[1].equalsIgnoreCase("default") || args[1].equalsIgnoreCase("banker") || args[1].equalsIgnoreCase("quester") || args[1].equalsIgnoreCase("merchant")){
						String id = npc.getSelected(player);
						if(id != null){
							if(!Configuration.npc.getString("Npc." + id + ".type").equals(args[1].toLowerCase())){
								Configuration.npc.set("Npc." + id + ".type", args[1].toLowerCase());
								
								player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "type has been set to " + ChatColor.YELLOW + args[1].toLowerCase());
								try {
									Configuration.npc.save();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}else{
								player.sendMessage(ChatColor.RED + "Your npc is already a " + ChatColor.YELLOW + args[1].toLowerCase());
							}
						}
						if(args[1].equalsIgnoreCase("merchant")){
							Stores.create(id, splayer);
						}
					}else{
						player.sendMessage(ChatColor.RED + "Please use a valid type: default/banker/quester/merchant");
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc type " + ChatColor.RED + "{type}");
			}
		}
	}
}