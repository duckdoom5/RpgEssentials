package me.duckdoom5.RpgEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Weather extends CommandSet{
	public Weather() {
		super("weather", "rpg", new String[]{"Weather"}, new String[]{"world"});
	}
	
	public void remove(Player player, SpoutPlayer splayer, String[] args){
		CommandManager.notEnoughArgs(this, player);
	}
	
	public void setSelf(Player player, SpoutPlayer splayer, String[] args){
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
			player.sendMessage(ChatColor.RED + "Please use: thunder, sun, storm or rain to set the weather !");
		}
	}
	
	public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args){
		World world = Bukkit.getWorld(args[2]);
		if(world == null){
			sender.sendMessage("World does not exist!");
		} else {
			if(args[2].equalsIgnoreCase("thunder") || args[1].equalsIgnoreCase("thundering")){
				world.setThundering(true);
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
			}else if(args[2].equalsIgnoreCase("stormy") || args[1].equalsIgnoreCase("storm") || args[1].equalsIgnoreCase("on") || args[1].equalsIgnoreCase("rain") || args[1].equalsIgnoreCase("rainy") || args[2].equalsIgnoreCase("snow") || args[1].equalsIgnoreCase("snowy")){
				world.setStorm(true);
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
			}else if(args[2].equalsIgnoreCase("sunny") || args[1].equalsIgnoreCase("sun") || args[1].equalsIgnoreCase("off") || args[1].equalsIgnoreCase("sunshine") || args[1].equalsIgnoreCase("clear")){
				world.setStorm(false);
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN +" has set the weather on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
			} else {
				sender.sendMessage(ChatColor.RED + "Please use: thunder, sun, storm or rain to set the weather !");
			}
		}
	}
}
