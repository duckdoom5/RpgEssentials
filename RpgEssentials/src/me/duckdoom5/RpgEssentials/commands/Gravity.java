package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Gravity extends CommandSet {
	public Gravity() {
		super("gravity", "rpg", new String[]{"gravity"}, new String[]{"player"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		splayer.resetMovement();
		PlayerConfig.addGravity(player, 1.0);
		player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		double multi = Double.parseDouble(args[1]);
		if(multi > 10){
			multi = 10;
			player.sendMessage(ChatColor.RED + "Gravity too high, setting to 10 !");
		}else if(multi < -10){
			multi = -10;
			player.sendMessage(ChatColor.RED + "Gravity too low, setting to -10 !");
		}
		splayer.setGravityMultiplier(multi);
		PlayerConfig.addGravity(player, multi);
		player.sendMessage(ChatColor.GREEN + "Your gravity has been to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		double multi = Double.parseDouble(args[1]);
		if(multi > 10){
			multi = 10;
			sender.sendMessage(ChatColor.RED + "Gravity too high, setting to 10 !");
		}else if(multi < -10){
			multi = -10;
			sender.sendMessage(ChatColor.RED + "Gravity too low, setting to -10 !");
		}
		sother.setGravityMultiplier(multi);
		PlayerConfig.addGravity(other, multi);
		sender.sendMessage(ChatColor.GREEN + "Gravity has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
		sender.sendMessage(ChatColor.GREEN + "Your gravity has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + "!");
	}
}
