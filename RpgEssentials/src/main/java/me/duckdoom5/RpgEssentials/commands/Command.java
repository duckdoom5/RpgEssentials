package me.duckdoom5.RpgEssentials.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class Command {
	private String command, prefix;
	protected String[] optionalArguments;
	protected String[] requiredArguments;
	
	public Command(String command, String prefix, String[] requiredArguments, String[] optionalArguments){
		this.command = command;
		this.prefix = prefix;
		this.requiredArguments = requiredArguments;
		this.optionalArguments = optionalArguments;
	}

	public String getCommand() {
		return command;
	}
	
	public String getPrefix() {
		return prefix;
	}


	public String[] getOptionalArguments() {
		return optionalArguments;
	}

	public String[] getRequiredArguments() {
		return requiredArguments;
	}

	public abstract void execute(String[] args, Player player, SpoutPlayer splayer,CommandSender sender);
}
