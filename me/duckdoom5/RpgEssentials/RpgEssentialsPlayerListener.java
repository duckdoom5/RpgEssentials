package me.duckdoom5.RpgEssentials;

import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.config.ConfigAdd;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsPlayerListener extends PlayerListener{
	
    public static RpgEssentials plugin;
    public final Logger log = Logger.getLogger("Minecraft");
    ConfigAdd addtoconfig = new ConfigAdd();
    YamlConfiguration config = new YamlConfiguration();
    YamlConfiguration playerconfig = new YamlConfiguration();
    
    
    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance;
        
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
    
    //public void onSpoutCraftEnable(SpoutCraftEnableEvent event){
    //	spoutcraft = true;
    //}
    
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
