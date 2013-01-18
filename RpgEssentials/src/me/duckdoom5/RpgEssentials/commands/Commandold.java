package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class Commandold {
	private int minArgs, maxArgs;
	private String command;
	private String[] requiredArgs, optionalArgs;
	private boolean requirePermissions, consoleCanExecute, npcCommand;
	
	public Commandold(String command, String[] requiredArgs, String[] optionalArgs, boolean requirePermissions, int minArgs, int maxArgs, boolean consoleCanExecute, boolean npcCommand){
		this.command = command;
		this.requiredArgs = requiredArgs;
		this.optionalArgs = optionalArgs;
		this.minArgs = minArgs;
		this.maxArgs = maxArgs;
		this.requirePermissions = requirePermissions;
		this.consoleCanExecute = consoleCanExecute;
		this.npcCommand = npcCommand;
	}
	
	public void execute(String[] args, Player player, SpoutPlayer splayer, CommandSender sender){
		if(!consoleCanExecute && player == null){
			sender.sendMessage(ChatColor.RED + "You can't use this command from the console !");	
		}else if(args.length < minArgs){
			notEnoughArgs(sender);
		}else if(args.length > maxArgs){
			tooManyArgs(sender);
		}else{
			if(player != null){
				if(requirePermissions){
					if(npcCommand){
						if(!RpgEssentials.hasPermission(player, "rpgessentials.npc." + command) || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")){
							player.sendMessage(ChatColor.RED + "You don't have the required permissions to run this command!");
							return;
						}
					}else{
						if(!RpgEssentials.hasPermission(player, "rpgessentials.rpg." + command)){
							player.sendMessage(ChatColor.RED + "You don't have the required permissions to run this command!");
							return;
						}
					}
				}
				runCommand(args, player, splayer, sender);
			}else{
				runConsoleCommand(args, sender);
			}
		}
	}
	
	public void permissions(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "You don't have the required permissions to run this command!");
	}
	
	public void notEnoughArgs(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "Not enough arguments!");
		
		String msg = "Usage: " + (npcCommand? "/rnpc " : "/rpg ") + command + " ";
		for(String s: requiredArgs){
			msg += ChatColor.RED + "{" + s + "}";
		}
		for(String s: optionalArgs){
			msg += ChatColor.YELLOW + "[" + s + "]";
		}
		sender.sendMessage(ChatColor.AQUA + msg);
	}
	
	public void tooManyArgs(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "Too many arguments!");
		
		String msg = "Usage: " + (npcCommand? "/rnpc "  : "/rpg ") + command + " ";
		for(String s: requiredArgs){
			msg += ChatColor.RED + "{" + s + "}";
		}
		for(String s: optionalArgs){
			msg += ChatColor.YELLOW + "[" + s + "]";
		}
		sender.sendMessage(ChatColor.AQUA + msg);
	}
	
	public abstract void runCommand(String[] args, Player player, SpoutPlayer splayer, CommandSender sender);
	
	public abstract void runConsoleCommand(String[] args, CommandSender sender);
}
