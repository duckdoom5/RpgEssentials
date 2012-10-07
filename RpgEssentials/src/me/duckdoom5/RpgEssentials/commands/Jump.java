package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Jump extends RpgEssentialsCommandExecutor{
	
	public Jump(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.jump")){
					splayer.resetMovement();
					ConfigAdd.addJump(player, 1.0);
					player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		} else if(args.length == 2){//rpg jump {height}
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.jump")){
					double multi = Double.parseDouble(args[1]);
					if(multi > 10){
						multi = 10;
						player.sendMessage(ChatColor.RED + "Height too high, setting to 10 !");
					}
					splayer.setJumpingMultiplier(multi);
					ConfigAdd.addJump(player, multi);
					player.sendMessage(ChatColor.GREEN + "Your jumping height has been to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		} else if(args.length == 3){//rpg jump [player] {height}
			if(plugin.hasPermission(player, "rpgessentials.rpg.jump.other")){
				Player P = plugin.getServer().getPlayer(args[1]);
				if(P == null){
					sender.sendMessage(ChatColor.RED + args[1] + " is offline !");
				}else{
					double multi = Double.parseDouble(args[2]);
					if(multi > 10){
						multi = 10;
						sender.sendMessage(ChatColor.RED + "Height too high, setting to 10 !");
					}
					SpoutPlayer SP = SpoutManager.getPlayer(P);
					SP.setJumpingMultiplier(multi);
					ConfigAdd.addSpeed(plugin.getServer().getPlayer(args[1]), multi);
					sender.sendMessage(ChatColor.GREEN + "Jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
					P.sendMessage(ChatColor.GREEN + "Your jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + "!");
				}
			} else {
				permissions(player);
			}
		} else {
		sender.sendMessage(ChatColor.RED + "Too many arguments !");
		sender.sendMessage(ChatColor.AQUA + "Usage: /rpg jump "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{height}");
		}
	}
}
