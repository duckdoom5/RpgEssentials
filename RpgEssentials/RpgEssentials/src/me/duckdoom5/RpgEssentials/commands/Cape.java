package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Cape extends RpgEssentialsCommandExecutor{
	
	
	public Cape(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg cape
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.cape")){
					splayer.resetCape();
					ConfigAdd.addCape(player, "CapeUrl");
					sender.sendMessage(ChatColor.RED + "Your cape has been removed !");
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		}else if(args.length == 2){//rpg cape [url]
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.cape")){
					if(args[1].contains(".png")){
						splayer.setCape(args[1]);
						ConfigAdd.addCape(player, args[1]);
						sender.sendMessage(ChatColor.GREEN + "Cape has been set !");
					}else{
						player.sendMessage(ChatColor.RED + "Cape file must be a png !");
					}
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		}else if(args.length == 3){//rpg cape [player] [url]
			if(plugin.hasPermission(player, "rpgessentials.rpg.cape.other")){
				if(args[2].contains(".png")){
					Player P = plugin.getServer().getPlayer(args[1]);
					if(P == null){
						sender.sendMessage(ChatColor.RED + args[1] + " is offline !");
					} else {
						SpoutPlayer SP = SpoutManager.getPlayer(P);
						SP.setCape(args[2]);
						ConfigAdd.addCape(plugin.getServer().getPlayer(args[1]), args[2]);
						sender.sendMessage(ChatColor.GREEN + "Cape has been set for " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
						P.sendMessage(ChatColor.GREEN + "Your cape has been set by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
					}
				}else{
					player.sendMessage(ChatColor.RED + "Cape file must be a png !");
				}
			} else {
				permissions(player);
			}
		}else {
			sender.sendMessage(ChatColor.RED + "Too many arguments !");
			sender.sendMessage(ChatColor.AQUA + "Usage: /rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
		}
	}
}
