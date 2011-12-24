package me.duckdoom5.RpgEssentials.commands;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;

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
	public final Logger log = Logger.getLogger("Minecraft");
	public ConfigAdd addtoconfig = new ConfigAdd();
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration itemconfig = new YamlConfiguration();
	YamlConfiguration playerconfig = new YamlConfiguration();
	
	public RpgEssentialsCommandExecutor(RpgEssentials instance) {
        plugin = instance;
        
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//load config
		try {
			config.load("plugins/RpgEssentials/config.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
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
    		if(args[0].equals("test")){
    			List<String> rules = itemconfig.getList("Custom Items.Adamantine Ingot.recipe.ingredients");
                Iterator<String> iter = rules.iterator();
                
                String[] row1 = iter.next().toString().split(",");
                if(row1[0] == null){
                	player.sendMessage("row1[0] == null");
                }else if(row1[0] == ""){
                	player.sendMessage("row1[0] == ''");
                } else {
                	player.sendMessage("row1[0] != null || '' ");
                }
                return true;
    		}else if(args[0].equals("help")){
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
			}else if(args[0].equals("cape")){
				if(args.length == 1){//rpg cape
					if(player.hasPermission("rpg.cape")){
						splayer.resetCape();
						addtoconfig.cape(player, "CapeUrl");
						sender.sendMessage(ChatColor.RED + "Cape removed!");
						return true;
					} else {
						permissions(player);
					}
				}else if(args.length == 2){//rpg cape [url]
					if(args[1].contains(".png")){
						if(player.hasPermission("rpg.cape")){
							splayer.setCape(args[1]);
							addtoconfig.cape(player, args[1]);
							sender.sendMessage(ChatColor.GREEN + "Cape set!");
						} else {
							permissions(player);
						}
					}else{
						player.sendMessage(ChatColor.RED + "Cape file must be a png!");
					}
					return true;
				}else if(args.length == 3){//rpg cape [player] [url]
					if(args[2].contains(".png")){
						Player P = plugin.getServer().getPlayer(args[1]);
						if(P == null){
							player.sendMessage(ChatColor.RED + args[1] + " is offline!");
							return true;
						} else {
							if(player.hasPermission("rpg.cape.other")){
								SpoutPlayer SP = SpoutManager.getPlayer(P);
								SP.setCape(args[2]);
								addtoconfig.capeother(args[1], args[2]);
								sender.sendMessage(ChatColor.GREEN + "Cape set for " + P.getName()  + " !");
								return true;
							} else {
								permissions(player);
							}
						}
					}else{
						player.sendMessage(ChatColor.RED + "Cape file must be a png!");
					}
					return true;
				}else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Useage: /rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
				}
				player.sendMessage(ChatColor.AQUA + "Useage: /rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
    		} else if(args[0].equals("title")){
    			if(args.length == 1){//rpg title
    				if(player.hasPermission("rpg.title.hide")){
	    				splayer.hideTitle();
	    				addtoconfig.hidetitle(player);
	    				sender.sendMessage(ChatColor.RED + "Title removed!");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 2){//rpg title [title]
    				if(player.hasPermission("rpg.title")){
	    				splayer.setTitle(args[1]);
	    				addtoconfig.title(player, args[1]);
	    				playerconfig.set("players."+ player.getName() +".hidetitle", false);
	    				sender.sendMessage(ChatColor.GREEN + "Title set!");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg title [player] [title]
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline!");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.title.other")){
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setTitle(args[2]);
	    					addtoconfig.titleother(args[1], args[2]);
	    					playerconfig.set("players."+ P.getName() +".hidetitle", false);
	    					sender.sendMessage(ChatColor.GREEN + "Title set for player: " + P.getName()  + " !");
	    					return true;
    					} else {
    						permissions(player);
    					}
    				}
    			} else {
    				player.sendMessage(ChatColor.RED + "Too many arguments !");
    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg title "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
    			}
    			player.sendMessage(ChatColor.AQUA + "Useage: /rpg title "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
    		} else if(args[0].equals("speed")){//rpg speed
    			if(args.length == 1){
    				if(player.hasPermission("rpg.speed")){
	    				splayer.resetMovement();
	    				addtoconfig.speed(player, 1.0);
	    				player.sendMessage(ChatColor.GREEN + "All movement reset to 1 !");
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
	    				player.sendMessage(ChatColor.GREEN + "Set speed to " + args[1] + " !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg speed [player] {speed}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline!");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.speed.other")){
	    					double multi = Double.parseDouble(args[2]);
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setAirSpeedMultiplier(multi);
	    					SP.setWalkingMultiplier(multi);
	        				SP.setSwimmingMultiplier(multi - 0.5);
	    					addtoconfig.speedother(args[1], multi);
	    					player.sendMessage(ChatColor.GREEN + "Set speed to " + args[1] + " for player: " + P.getName() + " !");
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
	    				player.sendMessage("Too few arguments");
	    				player.sendMessage(ChatColor.AQUA + "Useage: /rpg texturepack "+ ChatColor.RED +  "{url}");
    			} else {
    				if(args[1].contains(".zip")){
    					if(player.hasPermission("rpg.texturepack")){
					    	player.sendMessage(player.getName() + args[1]);
					    	splayer.setTexturePack(args[1]);
					    	player.sendMessage(ChatColor.GREEN + "Texturepack set!");
	    					return true;
    					} else {
    						permissions(player);
    					}
    				} else {
    					player.sendMessage(ChatColor.RED + "Please use a .zip file!");
    					return true;
    				}
    			}

    		} else if(args[0].equals("skin")){
    			if(args.length == 1){//rpg skin
    				if(player.hasPermission("rpg.skin")){
	    				splayer.resetSkin();
	    				addtoconfig.skin(player, "Default");
	    				sender.sendMessage(ChatColor.RED + "Skin reset!");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 2){//rpg skin {url}
    				if(player.hasPermission("rpg.skin")){
	    				splayer.setSkin(args[1]);
	    				addtoconfig.skin(player, args[1]);
	    				sender.sendMessage(ChatColor.GREEN + "Skin set!");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 3){//rpg skin [player] {url}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline!");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.skin.other")){
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setSkin(args[2]);
	    					addtoconfig.skinother(args[1], args[2]);
	        				sender.sendMessage(ChatColor.GREEN + "Skin set for player: " + P.getName() + " !");
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
    					player.sendMessage(ChatColor.GREEN + "All movement reset to 1 !");
    					return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 2){//rpg jump {height}
    				if(player.hasPermission("rpg.jump")){
	    				double multi = Double.parseDouble(args[1]);
	    				splayer.setJumpingMultiplier(multi);
	    				addtoconfig.jump(player, multi);
	    				player.sendMessage(ChatColor.GREEN + "Set jumping height to " + args[1] + " !");
	    				return true;
    				} else {
    					permissions(player);
    				}
    			} else if(args.length == 3){//rpg jump [player] {height}
    				Player P = plugin.getServer().getPlayer(args[1]);
    				if(P == null){
    					player.sendMessage(ChatColor.RED + args[1] + " is offline!");
    					return true;
    				} else {
    					if(player.hasPermission("rpg.jump.other")){
	    					double multi = Double.parseDouble(args[2]);
	    					SpoutPlayer SP = SpoutManager.getPlayer(P);
	    					SP.setJumpingMultiplier(multi);
	    					addtoconfig.speedother(args[1], multi);
	    					player.sendMessage(ChatColor.GREEN + "Set jumping height to " + args[1] + " for player: " + P.getName() + " !");
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
    					long time = Long.parseLong(args[2]);
        				world.setTime(time);
        				return true;
    				} else {
    					sender.sendMessage(ChatColor.RED + "Please provide a world");
    					sender.sendMessage(ChatColor.AQUA + "Useage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
    				}
    			}
    			if(args.length == 1){//rpg time {time}
    				if(player.hasPermission("rpg.set.time")){
	    				World world = player.getWorld();
	    				long time = world.getTime();
	    				int inttime = (int)time;
	    				String gettime = gettime(player, inttime);
	    				player.sendMessage(ChatColor.GREEN + "The current time is: " + gettime);
	    				return true;
    				} else {
    					permissions(player);
    				}
				} else if(args.length == 2){//rpg time {time}
					if(player.hasPermission("rpg.set.time")){
	    				World world = player.getWorld();
	    				String gettime = gettimestr(player, args[1]);
	    				long time = time(player, args[1]);
	    				world.setTime(time);
	    				player.sendMessage(ChatColor.GREEN + "Time set to " + gettime);
	    				return true;
					} else {
						permissions(player);
					}
				} else if(args.length == 3){//rpg time [world] {time}
					if(player.hasPermission("rpg.set.time")){
	    				World world = plugin.getServer().getWorld(args[1]);
	    				long time = time(player, args[2]);
	    				String gettime = gettimestr(player, args[1]);
	    				world.setTime(time);
	    				player.sendMessage(ChatColor.GREEN + "Time set to " + gettime);
	    				return true;
					} else {
						permissions(player);
					}
				} else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Useage: /rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{time}");
				}
				
    		} else if(args[0].equals("feed")){//rpg feed
    			if(args.length == 1){
    				if(player.hasPermission("rpg.feed")){
    					player.setFoodLevel(20);
    					return true;
    				} else {
    					permissions(player);
    				}
    			}else if(args.length == 2){//rpg feed [player]
    				if(player.hasPermission("rpg.feed.other")){
    					Player P = plugin.getServer().getPlayer(args[1]);
    					if(P == null){
    						player.sendMessage(ChatColor.RED + args[1] + " is offline!");
    						return true;
    					} else {
    						P.setFoodLevel(20);
    						return true;
    					}
    				}else{
    					permissions(player);
    				}
    			}
    		} else if(args[0].equals("heal")){//rpg feed
    			if(args.length == 1){
    				if(player.hasPermission("rpg.heal")){
    					player.setHealth(20);
    					return true;
    				} else {
	    				permissions(player);
	    			}
    			}else if(args.length == 2){//rpg feed [player]
    				if(player.hasPermission("rpg.heal.other")){
    					Player P = plugin.getServer().getPlayer(args[1]);
	    				if(P == null){
	    					player.sendMessage(ChatColor.RED + args[1] + " is offline!");
	    					return true;
	    				} else {
	    					P.setHealth(20);
	    					return true;
	    				}
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
			player.sendMessage(ChatColor.AQUA + "-----{Rpg help}-----                                        Page 1/3");
			player.sendMessage(ChatColor.AQUA + "/rpg help " + ChatColor.RED + "{page}");
			player.sendMessage(ChatColor.AQUA + "/rpg cape " + ChatColor.GREEN + "[player] " + ChatColor.RED + "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg title "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{title}");
			player.sendMessage(ChatColor.AQUA + "/rpg speed "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{speed}");
			player.sendMessage(ChatColor.AQUA + "/rpg skin "+ ChatColor.GREEN + "[player] " + ChatColor.RED +  "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg texturepack "+ ChatColor.RED +  "{url}");
			player.sendMessage(ChatColor.AQUA + "/rpg time "+ ChatColor.GREEN + "[world] " + ChatColor.RED +  "{morning/day/afternoon/night}");
			player.sendMessage(ChatColor.AQUA + "/rpg heal");
			player.sendMessage(ChatColor.AQUA + "/rpg feed");
		} else if(page == 2){
			player.sendMessage(ChatColor.AQUA + "-----{Rpg help}-----                                        Page 2/3");
		} else if(page == 3){
			player.sendMessage(ChatColor.AQUA + "-----{Rpg help}-----                                        Page 3/3");
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
	private String gettimestr(Player player, String time){
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
			player.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
		}
		return gettime;
	}
	private String gettime(Player player, int time) {
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
			player.sendMessage(ChatColor.RED + "Can't get the time?");
		}
		return gettime;
		
	}
	private void permissions(Player player){
		player.sendMessage(ChatColor.RED + "You don't have permissions !");	
	}
}
