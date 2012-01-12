package me.duckdoom5.RpgEssentials.Listeners;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;
import me.duckdoom5.RpgEssentials.levels.LevelingSystem;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsPlayerListener extends PlayerListener{
	
    public static RpgEssentials plugin;
    public final Logger log = Logger.getLogger("Minecraft");
    static ConfigAdd addtoconfig = new ConfigAdd(plugin);
    static YamlConfiguration config = new YamlConfiguration();
    static YamlConfiguration playerconfig = new YamlConfiguration();
    static YamlConfiguration levelconfig = new YamlConfiguration();
	private int currentlevel;
	private String skilltype;
	private int addexp;
    
    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance; 
    }
    public void onPlayerInteract(PlayerInteractEvent event){
    	try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
    	Player player = event.getPlayer();
    	Block block = event.getClickedBlock();
    	Action action = event.getAction();
    	ItemStack inhand = player.getItemInHand();
    	if(levelconfig.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL){
	    		if(action == Action.RIGHT_CLICK_BLOCK){
	    			if(inhand.getType() == Material.FLINT_AND_STEEL){
	    				block = block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
	    				if(block.getType() != Material.FIRE){
		    				skilltype = "Firemaking";
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Ignite");
		    				LevelingSystem.addexp(player, skilltype, addexp);
	    				}
	    			}
		    		if(block.getType() == Material.GRASS || block.getType() == Material.DIRT){
		    			skilltype = "Farming";
		    			currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
		    			if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_HOE){
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
		    				LevelingSystem.addexp(player, skilltype, addexp);
		    			}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE)){
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
		    				LevelingSystem.addexp(player, skilltype, addexp);
		    			}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE)){
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
		    				LevelingSystem.addexp(player, skilltype, addexp);
		    			}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE)){
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
		    				LevelingSystem.addexp(player, skilltype, addexp);
		    			}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE)){
		    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
		    				LevelingSystem.addexp(player, skilltype, addexp);
		    			}else if(inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE){
		    				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
		    				event.setCancelled(true);
			    		}
		    		}
		    	}
	    	}
    	}else{
    		if(action == Action.RIGHT_CLICK_BLOCK){
    			if(inhand.getType() == Material.FLINT_AND_STEEL){
    				skilltype = "Firemaking";
    				addexp = levelconfig.getInt("Exp." + skilltype + ".Ignite");
    				LevelingSystem.addexp(player, "Farming", addexp);
    			}
	    		if(block.getType() == Material.GRASS || block.getType() == Material.DIRT){
	    			skilltype = "Farming";
	    			currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
	    			if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_HOE){
	    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
	    				LevelingSystem.addexp(player, skilltype, addexp);
	    			}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE)){
	    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
	    				LevelingSystem.addexp(player, skilltype, addexp);
	    			}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE)){
	    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
	    				LevelingSystem.addexp(player, skilltype, addexp);
	    			}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE)){
	    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
	    				LevelingSystem.addexp(player, skilltype, addexp);
	    			}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE)){
	    				addexp = levelconfig.getInt("Exp." + skilltype + ".Soil.Create");
	    				LevelingSystem.addexp(player, skilltype, addexp);
	    			}else if(inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE){
	    				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
	    				event.setCancelled(true);
		    		}
	    		}
	    	}
    	}
    }
    public void onPlayerFish(PlayerFishEvent event){
    	Player player = event.getPlayer();
    	State state = event.getState();
    	if(state == state.CAUGHT_FISH){
    		LevelingSystem.addexp(player, "Fishing", 20);
    	}
    }
    
    @Override
    public void onPlayerJoin(PlayerJoinEvent event){
    	try {
			config.load("plugins/RpgEssentials/config.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	Player player = event.getPlayer();
    	
    	//set playername to config
    	addtoconfig.addplayer(player);
    	if(!plugin.useSpout){	
    		player.sendMessage(config.getString("spout.join.message"));
    	} else {
        	Player onplayer[];
            int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
            for(int i = 0; i < j; i++){
                Player joining = onplayer[i];
                SpoutPlayer sPlayer = (SpoutPlayer)joining;
                if(player.getName().length() > 26){
                    this.log.info(ChatColor.RED + "Player name is too long");
                } else {
                    sPlayer.sendNotification(player.getName(), "has joined the game", Material.getMaterial(config.getInt("spout.join.messageicon")));
                }
            }
    	}
    }
    
    public void onPlayerQuit(PlayerQuitEvent event){
    	Player player = event.getPlayer();
    	Player onplayer[];
        int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for(int i = 0; i < j; i++){
            Player leaveing = onplayer[i];
            SpoutPlayer sPlayer = (SpoutPlayer)leaveing;
            if(player.getName().length() > 26){
                this.log.info(ChatColor.RED + "Player name is too long");
            } else {
                sPlayer.sendNotification(player.getName(), "has left the game", Material.getMaterial(config.getInt("spout.leave.messageicon")));
            }
        }
    }
    
    //onPlayerPortal,onPlayerLogin,onPlayerRespawn,onPlayerTeleport,onPlayerKick


}
