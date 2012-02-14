package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help extends RpgEssentialsCommandExecutor{

	public Help(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, CommandSender sender){
		if(args.length == 1){//rpg help
			if(player.hasPermission("rpg.help")){
    			method(sender, 1);
			}else {
				permissions(player);
			}
		}else if(args.length == 2){//rpg help {page}
			if(player.hasPermission("rpg.help")){
				method(sender, Integer.parseInt(args[1]));
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.RED + "Too many arguments !");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg help " + ChatColor.RED + "{page}");
		}
	}
	
	public static void method(CommandSender player, int page) {
		if(page == 1){
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                                     Page 1/2");
			player.sendMessage(ChatColor.AQUA + "/rpg help " + ChatColor.RED + "{page}");
			player.sendMessage(ChatColor.AQUA + "/rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg title " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
			player.sendMessage(ChatColor.AQUA + "/rpg speed " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
			player.sendMessage(ChatColor.AQUA + "/rpg skin " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg weather " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
			player.sendMessage(ChatColor.AQUA + "/rpg time " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
			player.sendMessage(ChatColor.AQUA + "/rpg heal " + ChatColor.GREEN + "[player]");
		} else if(page == 2){
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                                     Page 2/2");
			player.sendMessage(ChatColor.AQUA + "/rpg feed " + ChatColor.GREEN + "[player]");
			player.sendMessage(ChatColor.AQUA + "/rpg money "+ ChatColor.GREEN + "[player] " + ChatColor.RED + "{set}");
			player.sendMessage(ChatColor.GREEN + "------------------------------");
		} else {
			player.sendMessage(ChatColor.RED + "Page doesn't exist !");
		}
		
	}
	
}
