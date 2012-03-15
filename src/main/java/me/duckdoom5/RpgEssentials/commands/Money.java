package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Money extends RpgEssentialsCommandExecutor{
	
	public Money(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg money
			double money = PlayerConfig.getMoney(player.getName());
			if(money >= 1000000){
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency") + ChatColor.GREEN + ". A millionare!!");
			}else if (money <= 100){
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency") + ChatColor.GREEN + ".... Poor guy");
			}else{
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency"));
			}
		}else if(args.length == 2){
			if(plugin.hasPermission(player, "rpgessentials.rpg.money.set")){
				if(args[1].length() <= 9){
					double money = Double.parseDouble(args[1]);
					player.sendMessage(ChatColor.GREEN + "Your money has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency"));
					PlayerConfig.setMoney(player.getName(), money);
				}else{
					player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
				}
			} else {
				permissions(player);
			}
		}else if(args.length == 3){//rpg money [player] {amount}
			if(plugin.hasPermission(player, "rpgessentials.rpg.money.set.other")){
				Player P = plugin.getServer().getPlayer(args[1]);
				if(P == null){
					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
				} else {
					if(args[2].length() <= 9){
						double money = Double.parseDouble(args[2]);
						sender.sendMessage(ChatColor.GREEN + "Money has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency") + "for " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
						P.sendMessage(ChatColor.GREEN + "Your money has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("store.currency") + "by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
						PlayerConfig.setMoney(P.getName(), money);
					}else{
						player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
					}
				}
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.RED + "Too many arguments !");
		}
	}

}
