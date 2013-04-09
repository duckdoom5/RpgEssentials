package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Cape extends CommandSet {
	public Cape() {
		super("cape", "rpg", new String[]{"url"}, new String[]{"player"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		splayer.resetCape();
		PlayerConfig.addCape(player, "CapeUrl");
		player.sendMessage(ChatColor.RED + "Your cape has been removed !");
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		if(args[1].contains(".png")){
			splayer.setCape(args[1]);
			PlayerConfig.addCape(player, args[1]);
			player.sendMessage(ChatColor.GREEN + "Cape has been set !");
		}else{
			player.sendMessage(ChatColor.RED + "Cape file must be a png !");
		}
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		if(args[1].contains(".png")){
			sother.setCape(args[1]);
			PlayerConfig.addCape(other, args[1]);
			sender.sendMessage(ChatColor.GREEN + "Cape has been set for " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
			other.sendMessage(ChatColor.GREEN + "Your cape has been set by: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
		}else{
			sender.sendMessage(ChatColor.RED + "Cape file must be a png !");
		}
	}
}
