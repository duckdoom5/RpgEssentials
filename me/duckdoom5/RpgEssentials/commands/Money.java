package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

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
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.store.getString("Store.Currency") + ChatColor.GREEN + ". A millionare!!");
			}else if (money <= 100){
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.store.getString("Store.Currency") + ChatColor.GREEN + ".... Poor guy");
			}else{
				player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + Configuration.store.getString("Store.Currency"));
			}
		}else if(args.length == 3){//rpg money [set] {amount}
			if(player.hasPermission("rpg.money.set")){
				if(args[2].length() <= 9){
					double money = Double.parseDouble(args[2]);
					player.sendMessage(ChatColor.GREEN + "Your money has been set to: " + ChatColor.YELLOW + money + " " + Configuration.store.getString("Store.Currency"));
					Configuration.players.set("players." + splayer.getName() + ".money", money);
					try {
						Configuration.players.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
				}
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.RED + "Too many arguments !");
		}
	}

}
