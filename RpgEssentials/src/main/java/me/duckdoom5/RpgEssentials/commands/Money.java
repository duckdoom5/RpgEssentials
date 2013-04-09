package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Money extends CommandSet{
	public Money() {
		super("money", "rpg", new String[]{}, new String[]{"player", "amount"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		double money = PlayerConfig.getMoney(player.getName());
		if(money >= 1000000){
			player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency") + ChatColor.GREEN + ". A millionare!!");
		}else if (money < 100){
			player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency") + ChatColor.GREEN + ".... Poor guy");
		}else{
			player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency"));
		}
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		if(args[1].length() <= 9){
			double money = Double.parseDouble(args[1]);
			player.sendMessage(ChatColor.GREEN + "Your balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency"));
			PlayerConfig.setMoney(player.getName(), money);
		}else{
			player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
		}
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		if(args[1].length() <= 9){
			double money = Double.parseDouble(args[1]);
			sender.sendMessage(ChatColor.GREEN + "Balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency") + " for " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
			other.sendMessage(ChatColor.GREEN + "Your balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("Currency") + " by: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
			PlayerConfig.setMoney(other.getName(), money);
		}else{
			sender.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
		}
	}
}
