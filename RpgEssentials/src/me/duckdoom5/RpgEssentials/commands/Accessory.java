package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;
import org.getspout.spoutapi.player.accessories.AccessoryType;

public class Accessory extends RpgEssentialsCommandExecutor{
	
	
	public Accessory(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			player.sendMessage(ChatColor.RED + "Not enough arguments!");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg accessory " + ChatColor.RED + "{type}" + ChatColor.RED + "{url}");
		}else if(args.length == 2){//rpg accessory type
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.accessory")){
					if(exists(splayer, args[1].toUpperCase())){
						splayer.removeAccessory(AccessoryType.valueOf(args[1].toUpperCase()));
						ConfigAdd.addAccessory(player, AccessoryType.valueOf(args[1].toUpperCase()), "Url");
						sender.sendMessage(ChatColor.RED + "Your accessory has been removed !");
					}
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		}else if(args.length == 3){//rpg accessory [type] [url]
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.accessory")){
					if(exists(splayer, args[1].toUpperCase())){
						if(args[2].contains(".png")){
							splayer.checkUrl(args[2]);
							splayer.addAccessory(AccessoryType.valueOf(args[1].toUpperCase()), args[2]);
							ConfigAdd.addAccessory(player, AccessoryType.valueOf(args[1].toUpperCase()), args[2]);
							sender.sendMessage(ChatColor.GREEN + "Accessory has been set !");
						}else{
							player.sendMessage(ChatColor.RED + "Accessory file must be a png !");
						}
					}
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		}else if(args.length == 3){//rpg accessory [type] [player] [url]
			if(plugin.hasPermission(player, "rpgessentials.rpg.accessory.other")){
				if(args[2].contains(".png")){
					Player P = plugin.getServer().getPlayer(args[2]);
					if(P == null){
						sender.sendMessage(ChatColor.RED + args[2] + " is offline !");
					} else {
						if(exists(splayer, args[1].toUpperCase())){
							SpoutPlayer SP = SpoutManager.getPlayer(P);
							SP.addAccessory(AccessoryType.valueOf(args[1].toUpperCase()), args[3]);
							ConfigAdd.addAccessory(plugin.getServer().getPlayer(args[2]),AccessoryType.valueOf(args[1].toUpperCase()), args[3]);
							sender.sendMessage(ChatColor.GREEN + "Accessory has been set for " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
							P.sendMessage(ChatColor.GREEN + "Your " + args[1].toLowerCase() +" has been set by: " + ChatColor.AQUA + (player!=null?player.getName():"CONSOLE") + ChatColor.GREEN + " !");
						}
					}
				}else{
					player.sendMessage(ChatColor.RED + "Accessory file must be a png !");
				}
			} else {
				permissions(player);
			}
		}else {
			sender.sendMessage(ChatColor.RED + "Too many arguments !");
			sender.sendMessage(ChatColor.AQUA + "Usage: /rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
		}
	}

	private static boolean exists(SpoutPlayer splayer, String type) {
		if(type.equals("BRACELET") || type.equals("EARS") || type.equals("NOTCHHAT") || type.equals("SUNGLASSES") || type.equals("TAIL") || type.equals("TOPHAT") || type.equals("WINGS")){
			return true;
		}
		splayer.sendMessage(ChatColor.RED + "Not a valid accessory type, please use: bracelet/ears/notchhat/sunglasses/tail/tophat/wings");
		return false;
	}
}
