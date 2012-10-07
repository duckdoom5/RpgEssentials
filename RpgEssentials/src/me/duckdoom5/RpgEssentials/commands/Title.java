package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Title extends RpgEssentialsCommandExecutor{
	
	public Title(RpgEssentials instance) {
		super(instance);
	}
	
	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg title
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.title.hide")){
					splayer.hideTitle();
					ConfigAdd.hidetitle(player);
					sender.sendMessage(ChatColor.RED + "Title has been removed !");
				} else {
					RpgEssentialsCommandExecutor.permissions(player);
				}
			}else{
				console(sender);
			}
		} else if(args.length == 2){//rpg title [title]
			if(player != null){
				if(plugin.hasPermission(player, "rpgessentials.rpg.title")){
					splayer.setTitle(args[1]);
					ConfigAdd.addTitle(player, args[1]);
					Configuration.players.set("players."+ player.getName() +".hidetitle", false);
					sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[1] + "\"" + ChatColor.GREEN + " !");
					try {
						Configuration.players.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					permissions(player);
				}
			}else{
				console(sender);
			}
		} else if(args.length == 3){//rpg title [player] [title]
			if(plugin.hasPermission(player, "rpgessentials.rpg.title.other")){
				Player P = plugin.getServer().getPlayer(args[1]);
				if(P == null){
					sender.sendMessage(ChatColor.RED + args[1] + " is offline !");
				} else {
					SpoutPlayer SP = SpoutManager.getPlayer(P);
					SP.setTitle(args[2]);
					ConfigAdd.addTitle(plugin.getServer().getPlayer(args[1]), args[2]);
					Configuration.players.set("players."+ P.getName() +".hidetitle", false);
					sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName()  + ChatColor.GREEN + " !");
					P.sendMessage(ChatColor.GREEN + "Your Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " by " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
					try {
						Configuration.players.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				RpgEssentialsCommandExecutor.permissions(player);
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Too many arguments !");
			sender.sendMessage(ChatColor.AQUA + "Usage: /rpg title "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
		}
	}
}
