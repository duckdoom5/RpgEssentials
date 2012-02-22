package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Texturepack extends RpgEssentialsCommandExecutor{
	
	public Texturepack(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length < 2){
			player.sendMessage(ChatColor.RED + "Too few arguments");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg texturepack "+ ChatColor.RED +  "{url}");
		} else {
			if(args[1].contains(".zip")){
				if(player.hasPermission("rpgessentials.rpg.texturepack")){
			    	player.sendMessage(player.getName() + args[1]);
			    	splayer.setTexturePack(args[1]);
			    	player.sendMessage(ChatColor.GREEN + "Texturepack set !");
				} else {
					permissions(player);
				}
			} else {
				player.sendMessage(ChatColor.RED + "Please use a .zip file !");
			}
		}
	}
}
