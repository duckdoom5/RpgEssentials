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
			if(plugin.hasPermission(player, "rpgessentials.rpg.help")){
    			method(sender, 1);
			}else {
				permissions(player);
			}
		}else if(args.length == 2){//rpg help {page}
			if(plugin.hasPermission(player, "rpgessentials.rpg.help")){
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
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                         Page 1/3");
			player.sendMessage(ChatColor.GREEN + "[arg] - Optional  " + ChatColor.RED + "{arg} - half required" + ChatColor.AQUA + "  /command - clear/get");
			player.sendMessage(ChatColor.AQUA + "/rpg help " + ChatColor.RED + "{page}");
			player.sendMessage(ChatColor.AQUA + "/rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg title " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
			player.sendMessage(ChatColor.AQUA + "/rpg speed " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
			player.sendMessage(ChatColor.AQUA + "/rpg skin " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg weather " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
			player.sendMessage(ChatColor.AQUA + "/rpg time " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
			player.sendMessage(ChatColor.AQUA + "/rpg heal " + ChatColor.GREEN + "[player]");
		} else if(page == 2){
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                         Page 2/3");
			player.sendMessage(ChatColor.AQUA + "/rpg feed " + ChatColor.GREEN + "[player]");
			player.sendMessage(ChatColor.AQUA + "/rpg money "+ ChatColor.GREEN + "[player] " + ChatColor.RED + "{amount}");
			player.sendMessage(ChatColor.AQUA + "/npc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
			player.sendMessage(ChatColor.AQUA + "/npc remove " + ChatColor.GREEN + "[name]");
			player.sendMessage(ChatColor.AQUA + "/npc rename " + ChatColor.RED + "{name}");
			player.sendMessage(ChatColor.AQUA + "/npc owner " + ChatColor.RED + "{player}");
			player.sendMessage(ChatColor.AQUA + "/npc select " + ChatColor.RED + "{npc id}");
			player.sendMessage(ChatColor.AQUA + "/npc move " + ChatColor.GREEN + "[x,y,z]");
			player.sendMessage(ChatColor.AQUA + "/npc cape " + ChatColor.RED + "{url}");
		} else if(page == 3){
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                         Page 3/3");
			player.sendMessage(ChatColor.AQUA + "/npc skin " + ChatColor.RED + "{url}");
			player.sendMessage(ChatColor.AQUA + "/npc item " + ChatColor.RED + "{item id}");
			player.sendMessage(ChatColor.AQUA + "/npc armour " + ChatColor.RED + "{armour id}");
			player.sendMessage(ChatColor.GREEN + "------------------------------");
		} else {
			player.sendMessage(ChatColor.RED + "Page doesn't exist !");
		}
		
	}
	
}
