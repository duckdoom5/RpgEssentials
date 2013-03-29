package me.duckdoom5.RpgEssentials.commands;

import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CommandManager implements CommandExecutor{
	
	public static LinkedHashMap<String, Command> commands = new LinkedHashMap<String, Command>();
	
	public CommandManager(){
		commands.put("help", new Help());
		commands.put("weather", new Weather());
		commands.put("time", new Time());
		commands.put("money", new Money());
		commands.put("cape", new Cape());
		commands.put("title", new Title());
		commands.put("accessory", new Accessory());
		commands.put("skin", new Skin());
		commands.put("heal", new Heal());
		commands.put("feed", new Feed());
		commands.put("gravity", new Gravity());
		commands.put("jump", new Jump());
		commands.put("speed", new Speed());
	}
	
	@Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		SpoutPlayer splayer = null;
		Player player = null;
    	if (sender instanceof Player) {
    		player = (Player) sender;
    		splayer =  SpoutManager.getPlayer(player);
    	}
     
    	if(cmd.getName().equalsIgnoreCase("rpg")){
    		
    		if(args.length < 1 || args == null){//rpg
    			if(RpgEssentials.hasPermission(player, "rpgessentials.rpg.help")){
    				Help.method(sender, 1);
	    			return true;
    			}
				permissions(player);
				return true;
    		}
    		if(commands.containsKey(args[0])){
				commands.get(args[0]).execute(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("test")){
    			RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
    			String url = Configuration.texture.getString(player.getWorld().getName() + "." + rpgplayer.getTexturepack(player.getWorld()) + ".url");
    			player.sendMessage(url);
    			return true;
    		}else if(args[0].equals("reload")){
				Reload.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("texturepack")){
    			Texturepack.command(args, player, splayer, sender);
    			return true;
    		}else if(args[0].equals("mail")){//rpg mail
    			Mail.command(args, player, splayer, sender);
    			return true;
    		} else if (args[0].equals("gen")) {
    			Generator.command(args, player, splayer, sender);
    			return true;
    		} 
    	}else if(cmd.getName().equalsIgnoreCase("rnpc")){
    		if(args.length < 1){//rpg
    			if(RpgEssentials.hasPermission(player, "rpgessentials.rpg.help")){
    				Help.method(sender, 2);
	    			return true;
    			}
    			permissions(player);
    		}
    		
    		if(player != null){
    			if(commands.containsKey(args[0])){
    				commands.get(args[0]).execute(args, player, splayer, sender);
    				return true;
    			}else if(args[0].equals("create")){
					NpcCreate.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("remove")){
					NpcRemove.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("rename")){
					NpcRename.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("walkto") || args[0].equals("moveto") || args[0].equals("move") || args[0].equals("walk") || args[0].equals("tpto")){
					NpcMove.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("cape")){
					NpcCape.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("skin")){
					NpcSkin.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("select")){
					NpcSelect.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("armor")){
					NpcArmor.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("item")){
					NpcItem.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("owner")){
					NpcOwner.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("text")){
					NpcText.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("type")){
					NpcType.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("wand")){
					NpcWand.command(args, player, splayer, sender);
					return true;
	    		}
    		}else{
    			console(sender);
    		}
    	}
    	if(RpgEssentials.hasPermission(player, "rpgessentials.rpg.help")){
    		Help.method(player, 1);
    	}
    	return true;
    }
	
	public static void permissions(Player player){
		player.sendMessage(ChatColor.RED + "You don't have permissions !");	
	}
	
	public static void console(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "You can't use this command from the console !");	
	}

	public static boolean hasPermission(Command command, Player player){
		if(!RpgEssentials.hasPermission(player, "rpgessentials." + command.getPrefix() + "." + command.getCommand())){
			permissions(player);
			return false;
		}
		return true;
	}
	
	public static boolean hasPermission(Command command, Player player, String suffix){
		if(!RpgEssentials.hasPermission(player, "rpgessentials." + command.getPrefix() + "." + command.getCommand() + suffix)){
			permissions(player);
			return false;
		}
		return true;
	}
	
	public static void notEnoughArgs(Command command, CommandSender sender){
		sender.sendMessage(ChatColor.RED + "Not enough arguments!");
		
		String msg = "Usage: /" + command.getPrefix() + " " + command.getCommand() + " ";
		for(String s: command.getRequiredArguments()){
			msg += ChatColor.RED + "{" + s + "} ";
		}
		for(String s: command.getOptionalArguments()){
			msg += ChatColor.GREEN + "[" + s + "] ";
		}
		sender.sendMessage(ChatColor.AQUA + msg);
	}
	
	public static void tooManyArgs(Command command, CommandSender sender){
		sender.sendMessage(ChatColor.RED + "Too many arguments!");
		
		String msg = "Usage: /" + command.getPrefix() + " " + command.getCommand() + " ";
		for(String s: command.getRequiredArguments()){
			msg += ChatColor.RED + "{" + s + "} ";
		}
		for(String s: command.getOptionalArguments()){
			msg += ChatColor.GREEN + "[" + s + "] ";
		}
		sender.sendMessage(ChatColor.AQUA + msg);
	}
}
