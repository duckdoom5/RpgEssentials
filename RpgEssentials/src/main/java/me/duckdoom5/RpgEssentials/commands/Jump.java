package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Jump extends CommandSet {
	public Jump() {
		super("jump", "rpg", new String[]{"height"}, new String[]{"player"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		splayer.resetMovement();
		PlayerConfig.addJump(player, 1.0);
		player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		double multi = Double.parseDouble(args[1]);
		if(multi > 10){
			multi = 10;
			player.sendMessage(ChatColor.RED + "Height too high, setting to 10 !");
		}else if(multi < -10){
			multi = -10;
			player.sendMessage(ChatColor.RED + "Height too low, setting to -10 !");
		}
		splayer.setJumpingMultiplier(multi);
		PlayerConfig.addJump(player, multi);
		player.sendMessage(ChatColor.GREEN + "Your jumping height has been to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		double multi = Double.parseDouble(args[1]);
		if(multi > 10){
			multi = 10;
			sender.sendMessage(ChatColor.RED + "Height too high, setting to 10 !");
		}else if(multi < -10){
			multi = -10;
			sender.sendMessage(ChatColor.RED + "Height too low, setting to -10 !");
		}
		sother.setJumpingMultiplier(multi);
		PlayerConfig.addSpeed(other, multi);
		sender.sendMessage(ChatColor.GREEN + "Jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
		other.sendMessage(ChatColor.GREEN + "Your jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + "!");
	}
}
