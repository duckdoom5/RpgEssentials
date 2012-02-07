package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsCommandExecutor implements CommandExecutor{
	
	public static RpgEssentials plugin;
	private final ConfigAdd addtoconfig = new ConfigAdd(plugin);
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration itemconfig = new YamlConfiguration();
	YamlConfiguration playerconfig = new YamlConfiguration();
	YamlConfiguration storeconfig = new YamlConfiguration();
	
	public RpgEssentialsCommandExecutor(RpgEssentials instance) {
        plugin = instance;  
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//load config
		try {
			config.load("plugins/RpgEssentials/config.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
			playerconfig.load("plugins/RpgEssentials/Players.yml");
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpoutPlayer splayer = null;
		Player player = null;
    	if (sender instanceof Player) {
    		player = (Player) sender;
    		splayer =  SpoutManager.getPlayer(player);
    	}
     
    	if (cmd.getName().equalsIgnoreCase("rpg")){ 
    		
    		if(args.length < 1){//rpg
    			if(player.hasPermission("rpg.help")){
	    			help(sender, 1);
	    			return true;
    			} else {
    				permissions(player);
    			}
    		}
    		if(args[0].equals("help")){
    			if(args.length == 1){//rpg help
    				if(player.hasPermission("rpg.help")){
	        			help(sender, 1);
	        			return true;
    				}else {
    					permissions(player);
    				}
        		}else if(args.length == 2){//rpg help {page}
        			if(player.hasPermission("rpg.help")){
	    				help(sender, Integer.parseInt(args[1]));
	    				return true;
        			} else {
        				permissions(player);
        			}
    			} else {
    				player.sendMessage(ChatColor.RED + "Too many arguments !");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg help " + ChatColor.RED + "{page}");
    			}
    		}else if(args[0].equals("test")){
    			return true;
			}else if(args[0].equals("cape")){
				if(args.length == 1){//rpg cape
					if(player.hasPermission("rpg.cape")){
						splayer.resetCape();
						addtoconfig.cape(player, "CapeUrl");
						sender.sendMessage(ChatColor.RED + "Your cape has been removed !");
						return true;
					} else {
						permissions(player);
					}
				}else if(args.length == 2){//rpg cape [url]
					if(args[1].contains(".png")){
						if(player.hasPermission("rpg.cape")){
							splayer.setCape(args[1]);
							addtoconfig.cape(player, args[1]);
							sender.sendMessage(ChatColor.GREEN + "Cape has been set !");
						} else {
							permissions(player);
						}
					}else{
						player.sendMessage(ChatColor.RED + "Cape file must be a png !");
					}
					return true;
				}else if(args.length == 3){//rpg cape [player] [url]
					if(args[2].contains(".png")){
						Player P = plugin.getServer().getPlayer(args[1]);
						if(P == null){
							player.sendMessage(ChatColor.RED + args[1] + " is offline !");
							return true;
						} else {
							if(player.hasPermission("rpg.cape.other")){
								SpoutPlayer SP = SpoutManager.getPlayer(P);
								SP.setCape(args[2]);
								addtoconfig.capeother(args[1], args[2]);
								sender.sendMessage(ChatColor.GREEN + "Cape has been set for " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
								P.sendMessage(ChatColor.GREEN + "Your cape has been set by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
								return true;
							} else {
								permissions(player);
							}
						}
					}else{
						player.sendMessage(ChatColor.RED + "Cape file must be a png !");
					}
					return true;
				}else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Useage: /rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
				}
    		} else if(args[0].equals("title")){
    			if(args.length == 1){//rpg title
    				if(player.hasPermission("rpg.title.hide")){
	    				splayer.hideTitle();
	    				addtoconfig.hidetitle(player);
	    				sender.sendMessage(ChatColor.RED + "Title has been removed !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 2){//rpg title [title]
    				if(player.hasPermission("rpg.title")){
	    				splayer.setTitle(args[1]);
	    				addtoconfig.title(player, args[1]);
	    				playerconfig.set("players."+ player.getName() +".hidetitle", false);
	    				sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[1] + "\"" + ChatColor.GREEN + " !");
	    				try {
	    					playerconfig.save("plugins/RpgEssentials/Players.yml");
	    				} catch (IOException e) {
	    					e.printStackTrace();
	    				}
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg title [player] [title]
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.title.other")){
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setTitle(args[2]);
	    					addtoconfig.titleother(args[1], args[2]);
	    					playerconfig.set("players."+ P.getName() +".hidetitle", false);
	    					sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName()  + ChatColor.GREEN + " !");
	    					P.sendMessage(ChatColor.GREEN + "Your Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " by " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
	    					try {
	    						playerconfig.save("plugins/RpgEssentials/Players.yml");
	    					} catch (IOException e) {
	    						e.printStackTrace();
	    					}
	    					return true;
    					} else {
    						permissions(player);
    					}
    				}
    			} else {
    				player.sendMessage(ChatColor.RED + "Too many arguments !");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg title "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
    			}
    		} else if(args[0].equals("speed")){//rpg speed
    			if(args.length == 1){
    				if(player.hasPermission("rpg.speed")){
	    				splayer.resetMovement();
	    				addtoconfig.speed(player, 1.0);
	    				player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 2){//rpg speed [speed]
    				if(player.hasPermission("rpg.speed")){
	    				double multi = Double.parseDouble(args[1]);
	    				splayer.setAirSpeedMultiplier(multi);
	    				splayer.setWalkingMultiplier(multi);
	    				splayer.setSwimmingMultiplier(multi - 0.5);
	    				addtoconfig.speed(player, multi);
	    				player.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg speed [player] {speed}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.speed.other")){
	    					double multi = Double.parseDouble(args[2]);
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setAirSpeedMultiplier(multi);
	    					SP.setWalkingMultiplier(multi);
	        				SP.setSwimmingMultiplier(multi - 0.5);
	    					addtoconfig.speedother(args[1], multi);
	    					player.sendMessage(ChatColor.GREEN + "Speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
	    					P.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
	    					return true;
    					} else {
    						permissions(player);
    					}
    				}
    			} else {
    			player.sendMessage(ChatColor.RED + "Too many arguments !");
    			player.sendMessage(ChatColor.AQUA + "Useage: /rpg speed "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
    			}
    		} else if(args[0].equals("texturepack")){
    			if(args.length < 2){
	    				player.sendMessage(ChatColor.RED + "Too few arguments");
	    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg texturepack "+ ChatColor.RED +  "{url}");
    			} else {
    				if(args[1].contains(".zip")){
    					if(player.hasPermission("rpg.texturepack")){
					    	player.sendMessage(player.getName() + args[1]);
					    	splayer.setTexturePack(args[1]);
					    	player.sendMessage(ChatColor.GREEN + "Texturepack set !");
	    					return true;
    					} else {
    						permissions(player);
    					}
    				} else {
    					player.sendMessage(ChatColor.RED + "Please use a .zip file !");
    					return true;
    				}
    			}

    		} else if(args[0].equals("skin")){
    			if(args.length == 1){//rpg skin
    				if(player.hasPermission("rpg.skin")){
	    				splayer.resetSkin();
	    				addtoconfig.skin(player, "Default");
	    				sender.sendMessage(ChatColor.RED + "Your skin has been reset !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 2){//rpg skin {url}
    				if(player.hasPermission("rpg.skin")){
	    				splayer.setSkin(args[1]);
	    				addtoconfig.skin(player, args[1]);
	    				sender.sendMessage(ChatColor.GREEN + "Your skin has been set !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 3){//rpg skin [player] {url}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.skin.other")){
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setSkin(args[2]);
	    					addtoconfig.skinother(args[1], args[2]);
	        				sender.sendMessage(ChatColor.GREEN + "Skin has been set for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
	        				P.sendMessage(ChatColor.GREEN +"Your Skin has been changed by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
	        				return true;
    					} else {
    						permissions(player);
    					}
    				}
    			} else {
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg skin "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
    			}
    			
    		} else if(args[0].equals("jump")){//rpg jump
    			if(args.length == 1){
    				if(player.hasPermission("rpg.jump")){
    					splayer.resetMovement();
    					addtoconfig.jump(player, 1.0);
    					player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
    					return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 2){//rpg jump {height}
    				if(player.hasPermission("rpg.jump")){
	    				double multi = Double.parseDouble(args[1]);
	    				splayer.setJumpingMultiplier(multi);
	    				addtoconfig.jump(player, multi);
	    				player.sendMessage(ChatColor.GREEN + "Your jumping height has been to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg jump [player] {height}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.jump.other")){
	    					double multi = Double.parseDouble(args[2]);
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setJumpingMultiplier(multi);
	    					addtoconfig.speedother(args[1], multi);
	    					player.sendMessage(ChatColor.GREEN + "Jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
	    					P.sendMessage(ChatColor.GREEN + "Your jumping height has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + "!");
	    					return true;
    					} else {
    						permissions(player);
    					}
    				}
    			} else {
    			player.sendMessage(ChatColor.RED + "Too many arguments !");
    			player.sendMessage(ChatColor.AQUA + "Useage: /rpg jump "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{height}");
    			}
    			
    		} else if(args[0].equals("time")){//rpg time [world] [time]
    			if(player == null){
    				if(args.length == 2){//rpg time {world} {time}
    					World world = plugin.getServer().getWorld(args[1]);
	    				
	    				if(world.equals(null)){
	    					sender.sendMessage(ChatColor.RED +  "World does not exist!");
	    					return true;
	    				} else {
		    				long longtime;
		    				
		    				if(args[2].toLowerCase().equals("day") || args[2].toLowerCase().equals("midday")){
		    					longtime = 0;
		    					world.setTime(longtime);
		    				}else if(args[2].toLowerCase().equals("morning") || args[2].toLowerCase().equals("dawn")){
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
	        				return true;
	    				}
    				} else {
    					sender.sendMessage(ChatColor.RED + "Please provide a world !");
    					sender.sendMessage(ChatColor.AQUA + "Useage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
    				}
    			}
    			if(args.length == 1){//rpg time {time}
    				if(player.hasPermission("rpg.set.time")){
	    				World world = player.getWorld();
	    				long time = world.getTime();
	    				int inttime = (int)time;
	    				String gettime = gettime(inttime);
	    				player.sendMessage(ChatColor.GREEN + "The current time is: " + gettime);
	    				return true;
    				} else {
    					permissions(player);
    				}
				} else if(args.length == 2){//rpg time {time}
					if(player.hasPermission("rpg.set.time")){
	    				World world = player.getWorld();
	    				long longtime;
	    				
	    				if(args[1].toLowerCase().equals("day") || args[1].toLowerCase().equals("midday")){
	    					longtime = 0;
	    					world.setTime(longtime);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				}else if(args[1].toLowerCase().equals("night") || args[1].toLowerCase().equals("midnight")){
	    					longtime = 6000;
	    					world.setTime(longtime);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				}else if(args[1].toLowerCase().equals("afternoon") || args[1].toLowerCase().equals("dusk")){
	    					longtime = 12000;
	    					world.setTime(longtime);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				}else if(args[1].toLowerCase().equals("morning") || args[1].toLowerCase().equals("dawn")){
	    					longtime = 18000;
	    					world.setTime(longtime);
	    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
	    				} else {
	    					sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
	    				}

	    				return true;
					} else {
						permissions(player);
					}
				} else if(args.length == 3){//rpg time [world] {time}
					if(player.hasPermission("rpg.set.time")){
						if(Bukkit.getWorld(args[1]) == null){
	    					player.sendMessage(ChatColor.RED + "World does not exist !");
	    					return true;
	    				} else {
	    					World world = plugin.getServer().getWorld(args[1]);
		    				long longtime;
		    				
		    				if(args[2].toLowerCase().equals("day") || args[2].toLowerCase().equals("midday")){
		    					longtime = 0;
		    					world.setTime(longtime);
		    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
		    				}else if(args[2].toLowerCase().equals("night") || args[2].toLowerCase().equals("midnight")){
		    					longtime = 6000;
		    					world.setTime(longtime);
		    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
		    				}else if(args[2].toLowerCase().equals("afternoon") || args[2].toLowerCase().equals("dusk")){
		    					longtime = 12000;
		    					world.setTime(longtime);
		    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
		    				}else if(args[2].toLowerCase().equals("morning") || args[2].toLowerCase().equals("dawn")){
		    					longtime = 18000;
		    					world.setTime(longtime);
		    					Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW  + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
		    				} else {
		    					sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time !");
		    				}
		    				return true;
	    				}
					} else {
						permissions(player);
					}
				} else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Useage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
				}
    			
    		} else if(args[0].equals("weather")){//rpg weather [world] [weather]
    			if(player == null){
    				if(args.length == 2){//rpg weather {world} {weather}
    					if(Bukkit.getWorld(args[1]) == null){
	    					sender.sendMessage("World does not exist!");
	    					return true;
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
		    				return true;
	    				}
    				} else {
    					sender.sendMessage(ChatColor.RED + "Please provide a world");
    					sender.sendMessage(ChatColor.AQUA + "Useage: /rpg weather "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
    				}
    			}
    			if(args.length == 1){//rpg weather
    				player.sendMessage(ChatColor.RED + "Too few arguments");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg weather "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{weather}");
    				return true;
				} else if(args.length == 2){//rpg weather {weather}
					if(player.hasPermission("rpg.set.time")){
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
	    				return true;
					} else {
						permissions(player);
					}
				} else if(args.length == 3){//rpg weather [world] {weather}
					if(player.hasPermission("rpg.set.time")){
						if(Bukkit.getWorld(args[1]) == null){
							sender.sendMessage("World does not exist!");
	    					return true;
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
							return true;
						}
					} else {
						permissions(player);
					}
				} else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Useage: /rpg weather "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
				}
				
    		} else if(args[0].equals("feed")){//rpg feed
    			if(args.length == 1){
    				if(player.hasPermission("rpg.feed")){
    					player.setFoodLevel(20);
    					player.sendMessage(ChatColor.GREEN + "Your food level has been set to " + ChatColor.YELLOW + "20" + ChatColor.GREEN + " !");
    					return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 2){//rpg feed [player]
    				if(player.hasPermission("rpg.feed.other")){
    					Player P = plugin.getServer().getPlayer(args[1]);
    					if(P == null){
    						player.sendMessage(ChatColor.RED + args[1] + " is offline !");
    						return true;
    					} else {
    						player.sendMessage(ChatColor.GREEN + "Food level has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
    						P.setFoodLevel(20);
    						P.sendMessage(ChatColor.GREEN + "Your food level has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
    						return true;
    					}
    				}else{
    					permissions(player);
    				}
    			} else {
    				player.sendMessage(ChatColor.RED + "Too many arguments !");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg feed");
    			}
    		} else if(args[0].equals("heal")){//rpg heal
    			if(args.length == 1){
    				if(player.hasPermission("rpg.heal")){
    					player.setHealth(20);
    					player.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20" + ChatColor.GREEN + " !");
    					return true;
    				} else {
	    				permissions(player);
	    			}
    			}else if(args.length == 2){//rpg heal [player]
    				if(player.hasPermission("rpg.heal.other")){
    					Player P = plugin.getServer().getPlayer(args[1]);
	    				if(P == null){
	    					player.sendMessage(ChatColor.RED + args[1] + " is offline !");
	    					return true;
	    				} else {
	    					player.sendMessage(ChatColor.GREEN + "Health has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
	    					P.setHealth(20);
	    					P.sendMessage(ChatColor.GREEN + "Your health has been set to " + ChatColor.YELLOW + "20 "+ ChatColor.GREEN +"by: " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " !");
	    					return true;
	    				}
    				} else {
    					permissions(player);
    				}
    			} else {
    				player.sendMessage(ChatColor.RED + "Too many arguments !");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg heal");
    			}
    		}else if(args[0].equals("money")){//rpg money
				if(args.length == 1){//rpg money
					int money = playerconfig.getInt("players." + player.getName() + ".money");
					if(money >= 1000000){
						player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + storeconfig.getString("Store.Currency") + ChatColor.GREEN + ". You'r a millonair!");
					}else if (money <= 100){
						player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + storeconfig.getString("Store.Currency") + ChatColor.GREEN + ".... Poor guy");
					}else{
						player.sendMessage(ChatColor.GREEN + "Your current money is: " + ChatColor.YELLOW + money + " " + storeconfig.getString("Store.Currency"));
					}
					return true;
				}else if(args.length == 3){//rpg money [set] {amount}
					if(player.hasPermission("rpg.money.set")){
						if(args[2].length() <= 9){
							int money = Integer.parseInt(args[2]);
							player.sendMessage(ChatColor.GREEN + "Your money has been set to: " + ChatColor.YELLOW + money + " " + storeconfig.getString("Store.Currency"));
							playerconfig.set("players." + splayer.getName() + ".money", money);
							try {
								playerconfig.save("plugins/RpgEssentials/Players.yml");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else{
							player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
						}
	    				return true;
					} else {
						permissions(player);
					}
				} else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
				}
    		}
    	}
    	help(player, 1);
    	return true;
    }

	private void help(CommandSender player,int page) {
		if(page == 1){
			player.sendMessage(ChatColor.GREEN + "-----{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                                     Page 1/2");
			player.sendMessage(ChatColor.AQUA + "/rpg help " + ChatColor.RED + "{page}");
			player.sendMessage(ChatColor.AQUA + "/rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg title " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
			player.sendMessage(ChatColor.AQUA + "/rpg speed " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
			player.sendMessage(ChatColor.AQUA + "/rpg skin " + ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg weather " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{thunder/sun/storm}");
			player.sendMessage(ChatColor.AQUA + "/rpg time " + ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
			player.sendMessage(ChatColor.AQUA + "/rpg heal" + ChatColor.GREEN + "[player]");
		} else if(page == 2){
			player.sendMessage(ChatColor.GREEN + "-----{ "+ ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN +" }-----                                     Page 2/2");
			player.sendMessage(ChatColor.AQUA + "/rpg feed" + ChatColor.GREEN + "[player]");
			player.sendMessage(ChatColor.AQUA + "/rpg money "+ ChatColor.GREEN + "[player] " + ChatColor.RED + "{set}");
			player.sendMessage(ChatColor.GREEN + "------------------------------");
		} else {
			player.sendMessage(ChatColor.RED + "Page doesn't exist !");
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
			player.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
		}
		return longtime;
	}
	private String gettimestr(CommandSender sender, String time){
		String gettime = "";
		if(time.toLowerCase().equals("day") || time.toLowerCase().equals("midday")){
			gettime = "day";
		}else if(time.toLowerCase().equals("night") || time.toLowerCase().equals("midnight")){
			gettime = "night";
		}else if(time.toLowerCase().equals("afternoon") || time.toLowerCase().equals("dusk")){
			gettime = "afternoon";
		}else if(time.toLowerCase().equals("morning") || time.toLowerCase().equals("dawn")){
			gettime = "morning";
		} else {
			sender.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
		}
		return gettime;
	}
	private String gettime(int time) {
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
	private void permissions(Player player){
		player.sendMessage(ChatColor.RED + "You don't have permissions !");	
	}
}
