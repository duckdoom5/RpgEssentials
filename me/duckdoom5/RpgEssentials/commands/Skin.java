package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Skin extends RpgEssentialsCommandExecutor{
	
	public Skin(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg skin
			if(player.hasPermission("rpgessentials.rpg.skin")){
				splayer.resetSkin();
				ConfigAdd.skin(player, "Default");
				sender.sendMessage(ChatColor.RED + "Your skin has been reset !");
			} else {
				permissions(player);
			}
		}else if(args.length == 2){//rpg skin {url}
			if(player.hasPermission("rpgessentials.rpg.skin")){
				if(args[1].contains(".png")){
					splayer.setSkin(args[1]);
					ConfigAdd.skin(player, args[1]);
					sender.sendMessage(ChatColor.GREEN + "Your skin has been set !");
				}
			} else {
				permissions(player);
			}
		}else if(args.length == 3){//rpg skin [player] {url}
			if(player.hasPermission("rpgessentials.rpg.skin.other")){
				if(args[2].contains(".png")){
					Player P = plugin.getServer().getPlayer(args[1]);
					if(P == null){
						player.sendMessage(ChatColor.RED + args[1] + " is offline !");
					} else {
						SpoutPlayer SP = SpoutManager.getPlayer(P);
						SP.setSkin(args[2]);
						ConfigAdd.skinother(args[1], args[2]);
	    				sender.sendMessage(ChatColor.GREEN + "Skin has been set for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
	    				P.sendMessage(ChatColor.GREEN +"Your Skin has been changed by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
					}
				}
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg skin "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
		}
	}
}
