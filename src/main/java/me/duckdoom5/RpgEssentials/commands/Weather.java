package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Weather extends RpgEssentialsCommandExecutor{
	
	public Weather(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			if(args.length == 3){//rpg weather {world} {weather}
				if(Bukkit.getWorld(args[1]) == null){
					sender.sendMessage("World does not exist!");
				} else {
					World world = plugin.getServer().getWorld(args[1]);
					if(args[1].equalsIgnoreCase("thunder") || args[1].equalsIgnoreCase("thundering")){
    					world.setThundering(true);
    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "CONSOLE " + ChatColor.GREEN + "has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
    				}else if(args[1].equalsIgnoreCase("storm") || args[1].equalsIgnoreCase("on")){
    					world.setStorm(true);
    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "CONSOLE " + ChatColor.GREEN + "has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
    				}else if(args[1].equalsIgnoreCase("sunny") || args[1].equalsIgnoreCase("sun") || args[1].equalsIgnoreCase("off") || args[1].equalsIgnoreCase("sunshine") || args[1].equalsIgnoreCase("clear")){
    					world.setStorm(false);
    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "CONSOLE " + ChatColor.GREEN + "has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
    				} else {
    					sender.sendMessage(ChatColor.RED + "Please use: thunder, sun, storm or rain to set the weather !");
    				}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Please provide a world");
				sender.sendMessage(ChatColor.AQUA + "Usage: /rpg weather "+ ChatColor.GREEN + "{world} " + ChatColor.RED +  "{thunder/sun/storm}");
			}
		}else{
			if(args.length == 1){//rpg weather
				player.sendMessage(ChatColor.RED + "Too few arguments");
				player.sendMessage(ChatColor.AQUA + "Useage: /rpg weather "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{weather}");
			} else if(args.length == 2){//rpg weather {weather}
				if(plugin.hasPermission(player, "rpgessentials.rpg.weather")){
					World world = player.getWorld();
					if(args[1].equalsIgnoreCase("thunder") || args[1].equalsIgnoreCase("thundering")){
						world.setThundering(true);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
					}else if(args[1].equalsIgnoreCase("storm") || args[1].equalsIgnoreCase("on")){
						world.setStorm(true);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
					}else if(args[1].equalsIgnoreCase("sunny") || args[1].equalsIgnoreCase("sun") || args[1].equalsIgnoreCase("off") || args[1].equalsIgnoreCase("sunshine") || args[1].equalsIgnoreCase("clear")){
						world.setStorm(false);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
					} else {
						sender.sendMessage(ChatColor.RED + "Please use: thunder, sun, storm or rain to set the weather !");
					}
				} else {
					permissions(player);
				}
			} else if(args.length == 3){//rpg weather [world] {weather}
				if(plugin.hasPermission(player, "rpgessentials.rpg.weather")){
					if(Bukkit.getWorld(args[1]) == null){
						sender.sendMessage("World does not exist!");
					}else {
						World world = plugin.getServer().getWorld(args[1]);
						if(args[2].equalsIgnoreCase("thunder") || args[2].equalsIgnoreCase("thundering")){
	    					world.setThundering(true);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
	    				}else if(args[2].equalsIgnoreCase("stormy") || args[2].equalsIgnoreCase("storm") || args[2].equalsIgnoreCase("on") || args[2].equalsIgnoreCase("rain") || args[2].equalsIgnoreCase("rainy") || args[2].equalsIgnoreCase("snow") || args[2].equalsIgnoreCase("snowy")){
	    					world.setStorm(true);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
	    				}else if(args[2].equalsIgnoreCase("sunny") || args[2].equalsIgnoreCase("sun") || args[2].equalsIgnoreCase("off") || args[2].equalsIgnoreCase("sunshine") || args[2].equalsIgnoreCase("clear")){
	    					world.setStorm(false);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
	    				} else {
	    					sender.sendMessage(ChatColor.RED + "Please use: thunder, sun, storm or rain to set the weather !");
	    				}
					}
				} else {
					permissions(player);
				}
			} else {
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /rpg weather "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
			}
		}
	}
}
