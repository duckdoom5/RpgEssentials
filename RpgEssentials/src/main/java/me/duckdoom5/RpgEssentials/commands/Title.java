package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Title extends CommandSet{
	public Title() {
		super("title", "rpg", new String[]{"title"}, new String[]{"player"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		splayer.resetTitle();
		Configuration.players.set("players."+ player.getName() +".hidetitle", false);
		player.sendMessage(ChatColor.RED + "Title has been reset !");
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		if(args[1].equals("hide") || args[1].equals("hidden") || args[1].equals("null") || args[1].equals("nothing")){
			splayer.hideTitle();
			PlayerConfig.hidetitle(player);
			player.sendMessage(ChatColor.GREEN + "Your title is hidden from view now!");
		}else{
			splayer.setTitle(args[1]);
			PlayerConfig.addTitle(player, args[1]);
			Configuration.players.set("players."+ player.getName() +".hidetitle", false);
			player.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[1] + "\"" + ChatColor.GREEN + " !");
		}
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		if(args[1].equals("hide") || args[1].equals("hidden") || args[1].equals("null") || args[1].equals("nothing")){
			sother.hideTitle();
			PlayerConfig.hidetitle(other);
			sender.sendMessage(ChatColor.GREEN + "Title has been hidden for player: " + ChatColor.AQUA + other.getName()  + ChatColor.GREEN + " !");
			other.sendMessage(ChatColor.GREEN + "Your Title has been hidden by " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
		}else{
			sother.setTitle(args[2]);
			PlayerConfig.addTitle(other, args[2]);
			Configuration.players.set("players."+ other.getName() +".hidetitle", false);
			sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName()  + ChatColor.GREEN + " !");
			other.sendMessage(ChatColor.GREEN + "Your Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " by " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
		}
	}
}
