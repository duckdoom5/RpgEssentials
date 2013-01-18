package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Skin extends CommandSet{
	public Skin() {
		super("skin", "rpg", new String[]{"url"}, new String[]{"player"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		splayer.resetSkin();
		PlayerConfig.addSkin(player, "Default");
		player.sendMessage(ChatColor.RED + "Your skin has been reset !");
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
		if(args[1].contains(".png")){
			splayer.setSkin(args[1]);
			PlayerConfig.addSkin(player, args[1]);
			player.sendMessage(ChatColor.GREEN + "Your skin has been set !");
		}
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		if(args[1].contains(".png")){
			sother.setSkin(args[1]);
			PlayerConfig.addSkin(other, args[1]);
			sender.sendMessage(ChatColor.GREEN + "Skin has been set for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
			other.sendMessage(ChatColor.GREEN +"Your Skin has been changed by: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
		}
	}
}
