package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Reload extends RpgEssentialsCommandExecutor{
	
	
	public Reload(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg reload
			if(plugin.hasPermission(player, "rpgessentials.rpg.reload")){
				Configuration.start();
				sender.sendMessage(ChatColor.GREEN + "The configs are reloaded !");
			} else {
				permissions(player);
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Too many arguments !");
			sender.sendMessage(ChatColor.AQUA + "Usage: /rpg reload");
		}
	}
}
