package me.duckdoom5.RpgEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Heal extends Command{
	public Heal() {
		super("heal", "rpg", new String[]{}, new String[]{"player"});
	}
	
	public void execute(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			if(player != null){
				if(CommandManager.hasPermission(this, player)){
					player.setHealth(20);
					player.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20" + ChatColor.GREEN + " !");
				}
			}else{
				CommandManager.console(sender);
			}
		}else if(args.length == 2){//rpg heal [player]
			if(CommandManager.hasPermission(this, player, "other")){
				Player P = Bukkit.getServer().getPlayer(args[1]);
				if(P == null){
					sender.sendMessage(ChatColor.RED + args[1] + " is offline !");
				} else {
					sender.sendMessage(ChatColor.GREEN + "Health has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
					P.setHealth(20);
					P.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20 "+ ChatColor.GREEN +"by: " + ChatColor.AQUA + (player!=null?player.getName():"CONSOLE") + ChatColor.GREEN + " !");
				}
			}
		} else {
			CommandManager.tooManyArgs(this, sender);
		}
	}

}
