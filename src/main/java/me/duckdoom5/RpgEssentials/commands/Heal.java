package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Heal extends RpgEssentialsCommandExecutor{
	
	public Heal(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			if(plugin.hasPermission(player, "rpgessentials.rpg.heal")){
				player.setHealth(20);
				player.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20" + ChatColor.GREEN + " !");
			} else {
				permissions(player);
			}
		}else if(args.length == 2){//rpg heal [player]
			if(plugin.hasPermission(player, "rpgessentials.rpg.heal.other")){
				Player P = plugin.getServer().getPlayer(args[1]);
				if(P == null){
					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
				} else {
					player.sendMessage(ChatColor.GREEN + "Health has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
					P.setHealth(20);
					P.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20 "+ ChatColor.GREEN +"by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
				}
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.RED + "Too many arguments !");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg heal " + ChatColor.GREEN + "[player]");
		}
	}

}
