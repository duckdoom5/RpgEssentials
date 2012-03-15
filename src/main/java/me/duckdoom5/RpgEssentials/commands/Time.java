package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Time extends RpgEssentialsCommandExecutor{
	
	public Time(RpgEssentials instance) {
		super(instance);
	}

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			if(args.length == 2){//rpg time {world} {time}
				World world = plugin.getServer().getWorld(args[1]);
				
				if(world.equals(null)){
					sender.sendMessage(ChatColor.RED +  "World does not exist!");
				} else {
					long longtime;
					
					if(args[2].toLowerCase().equals("morning") || args[2].toLowerCase().equals("dawn")){
						longtime = 0;
						world.setTime(longtime);
					}else if(args[2].toLowerCase().equals("day") || args[2].toLowerCase().equals("midday")){
						longtime = 6000;
						world.setTime(longtime);
					}else if(args[2].toLowerCase().equals("afternoon") || args[2].toLowerCase().equals("dusk")){
						longtime = 12000;
						world.setTime(longtime);
					}else if(args[2].toLowerCase().equals("night") || args[2].toLowerCase().equals("midnight")){
						longtime = 18000;
						world.setTime(longtime);
					} else {
						sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
					}
					
					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "CONSOLE" + ChatColor.GREEN +" has set the time on world: " + ChatColor.YELLOW + world.getName() + " to " + args[2] + " !");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Please provide a world !");
				sender.sendMessage(ChatColor.AQUA + "Usage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
			}
		}
		if(args.length == 1){//rpg time
			if(plugin.hasPermission(player, "rpgessentials.rpg.time")){
				World world = player.getWorld();
				long time = world.getTime();
				int inttime = (int)time;
				String gettime = gettime(inttime);
				player.sendMessage(ChatColor.GREEN + "The current time is: " + gettime);
			} else {
				permissions(player);
			}
		} else if(args.length == 2){//rpg time {time}
			if(plugin.hasPermission(player, "rpgessentials.rpg.time.set")){
				World world = player.getWorld();
				long longtime;
				
				if(args[1].toLowerCase().equals("morning") || args[1].toLowerCase().equals("dawn")){
					longtime = 0;
					world.setTime(longtime);
					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
				}else if(args[1].toLowerCase().equals("day") || args[1].toLowerCase().equals("midday")){
					longtime = 6000;
					world.setTime(longtime);
					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
				}else if(args[1].toLowerCase().equals("afternoon") || args[1].toLowerCase().equals("dusk")){
					longtime = 12000;
					world.setTime(longtime);
					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
				}else if(args[1].toLowerCase().equals("night") || args[1].toLowerCase().equals("midnight")){
					longtime = 18000;
					world.setTime(longtime);
					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
				} else {
					sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
				}
			} else {
				permissions(player);
			}
		} else if(args.length == 3){//rpg time [world] {time}
			if(plugin.hasPermission(player, "rpgessentials.rpg.time.set")){
				if(Bukkit.getWorld(args[1]) == null){
					player.sendMessage(ChatColor.RED + "World does not exist !");
				} else {
					World world = plugin.getServer().getWorld(args[1]);
					long longtime;
					
					if(args[2].toLowerCase().equals("morning") || args[2].toLowerCase().equals("dawn")){
						longtime = 0;
						world.setTime(longtime);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
					}else if(args[2].toLowerCase().equals("day") || args[2].toLowerCase().equals("midday")){
						longtime = 6000;
						world.setTime(longtime);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
					}else if(args[2].toLowerCase().equals("afternoon") || args[2].toLowerCase().equals("dusk")){
						longtime = 12000;
						world.setTime(longtime);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
					}else if(args[2].toLowerCase().equals("night") || args[2].toLowerCase().equals("midnight")){
						longtime = 18000;
						world.setTime(longtime);
						Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
					} else {
						sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morning to set the time !");
					}
				}
			} else {
				permissions(player);
			}
		} else {
			player.sendMessage(ChatColor.RED + "Too many arguments !");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
		}
	}
	private long time(Player player, String time){
		long longtime = 0;
		if(time.toLowerCase().equals("morning") || time.toLowerCase().equals("dawn")){
			longtime = 0;
		}else if(time.toLowerCase().equals("day") || time.toLowerCase().equals("midday")){
			longtime = 6000;
		}else if(time.toLowerCase().equals("afternoon") || time.toLowerCase().equals("dusk")){
			longtime = 12000;
		}else if(time.toLowerCase().equals("night") || time.toLowerCase().equals("midnight")){
			longtime = 18000;
		} else {
			player.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morning to set the time!");
		}
		return longtime;
	}
	private String gettimestr(CommandSender sender, String time){
		String gettime = "";
		if(time.toLowerCase().equals("morning") || time.toLowerCase().equals("dawn")){
			gettime = "day";
		}else if(time.toLowerCase().equals("day") || time.toLowerCase().equals("midday")){
			gettime = "night";
		}else if(time.toLowerCase().equals("afternoon") || time.toLowerCase().equals("dusk")){
			gettime = "afternoon";
		}else if(time.toLowerCase().equals("night") || time.toLowerCase().equals("midnight")){
			gettime = "morning";
		} else {
			sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morning to set the time!");
		}
		return gettime;
	}
	private static String gettime(int time) {
		String gettime = "";
		if(time < 6000){
			gettime = "morning";
		}else if(time < 12000){
			gettime = "day";
		}else if(time < 18000){
			gettime = "afternoon";
		}else if(time <= 24000){
			gettime = "night";
		} else {
		}
		return gettime;
		
	}
}
