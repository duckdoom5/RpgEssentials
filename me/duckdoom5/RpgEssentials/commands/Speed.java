package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Speed extends RpgEssentialsCommandExecutor{
	
	public Speed(RpgEssentials instance) {
		super(instance);
	}
	
	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			if(player.hasPermission("rpg.speed")){
				splayer.resetMovement();
				ConfigAdd.speed(player, 1.0);
				player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
			} else {
				permissions(player);
			}
		} else if(args.length == 2){//rpg speed [speed]
			if(player.hasPermission("rpg.speed")){
				double multi = Double.parseDouble(args[1]);
				if(multi > 10){
					multi = 10;
					player.sendMessage(ChatColor.RED + "Speed too high, setting to 10 !");
				}
				splayer.setAirSpeedMultiplier(multi);
				splayer.setWalkingMultiplier(multi);
				splayer.setSwimmingMultiplier(multi - 0.5);
				ConfigAdd.speed(player, multi);
				player.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
			} else {
				permissions(player);
			}
		} else if(args.length == 3){//rpg speed [player] {speed}
			Player P = plugin.getServer().getPlayer(args[1]);
			if(P == null){
				player.sendMessage(ChatColor.RED + args[1] + " is offline !");
			} else {
				if(player.hasPermission("rpg.speed.other")){
					double multi = Double.parseDouble(args[2]);
					if(multi > 10){
						multi = 10;
						player.sendMessage(ChatColor.RED + "Speed too high, setting to 10 !");
					}
					SpoutPlayer SP = SpoutManager.getPlayer(P);
					SP.setAirSpeedMultiplier(multi);
					SP.setWalkingMultiplier(multi);
					SP.setSwimmingMultiplier(multi - 0.5);
					ConfigAdd.speedother(args[1], multi);
					player.sendMessage(ChatColor.GREEN + "Speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
					P.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
				} else {
					permissions(player);
				}
			}
		} else {
		player.sendMessage(ChatColor.RED + "Too many arguments !");
		player.sendMessage(ChatColor.AQUA + "Usage: /rpg speed "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
		}
	}
}
