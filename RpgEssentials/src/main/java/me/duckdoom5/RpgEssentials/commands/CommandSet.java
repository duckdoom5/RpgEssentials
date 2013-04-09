package me.duckdoom5.RpgEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class CommandSet extends Command{
	
	private boolean set;

	public CommandSet(String command, String prefix, String[] requiredArguments, String[] optionalArguments) {
		super(command, prefix, requiredArguments, optionalArguments);
	}

	public void execute(String[] args, Player player, SpoutPlayer splayer, CommandSender sender){
		if(args[0].equals("money") || args[0].equals("time")){
			set = true;
		}
		if(args.length == 1){//rpg cmd
			if(player != null){
				if(set?true:CommandManager.hasPermission(this, player)){
					remove(player, splayer, args);
				}
			}else{
				CommandManager.console(sender);
			}
		}else if(args.length == 2){//rpg cmd [arg]
			if(player != null){
				if(set?CommandManager.hasPermission(this, player, "set"):CommandManager.hasPermission(this, player)){
					setSelf(player, splayer, args);
				}
			}else{
				CommandManager.console(sender);
			}
		}else if(args.length == 3){//rpg cmd [arg] [player]
			if(set?CommandManager.hasPermission(this, player, "set.other"):CommandManager.hasPermission(this, player, "other")){
				if(args[0].equals("time") || args[0].equals("weather")){
					setOther(null, null, sender, args);
				}else{
					Player P = Bukkit.getServer().getPlayer(args[requiredArguments.length + optionalArguments.length]);
					if(P == null){
						sender.sendMessage(ChatColor.RED + args[requiredArguments.length + optionalArguments.length] + " is offline !");
					} else {
						setOther(P, SpoutManager.getPlayer(P), sender, args);
					}
				}
			}
		}else {
			CommandManager.tooManyArgs(this, sender);
		}
	}
	
	public abstract void remove(Player player, SpoutPlayer splayer, String[] args);
	
	public abstract void setSelf(Player player, SpoutPlayer splayer, String[] args);
	
	public abstract void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args);
}
