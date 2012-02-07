package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigAdd {
	public static RpgEssentials plugin;
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration playerconfig = new YamlConfiguration();
	YamlConfiguration blocks = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public ConfigAdd(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void addplayer(Player player){
		try {
			config.load("plugins/RpgEssentials/config.yml");
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!playerconfig.contains("players."+ player.getName() + ".title")){
			log.info("[RpgEssentials] Adding new player to config...");
			playerconfig.set("players." + player.getName() + ".title", player.getName());
			playerconfig.set("players." + player.getName() + ".money", config.getInt("player.starting money"));
			playerconfig.set("players." + player.getName() + ".Mining.exp", 0);
			playerconfig.set("players." + player.getName() + ".Mining.level", 1);
			playerconfig.set("players." + player.getName() + ".Woodcutting.exp", 0);
			playerconfig.set("players." + player.getName() + ".Woodcutting.level", 1);
			playerconfig.set("players." + player.getName() + ".Excavation.exp", 0);
			playerconfig.set("players." + player.getName() + ".Excavation.level", 1);
			playerconfig.set("players." + player.getName() + ".Farming.exp", 0);
			playerconfig.set("players." + player.getName() + ".Farming.level", 1);
			playerconfig.set("players." + player.getName() + ".Attack.exp", 0);
			playerconfig.set("players." + player.getName() + ".Attack.level", 1);
			playerconfig.set("players." + player.getName() + ".Defence.exp", 0);
			playerconfig.set("players." + player.getName() + ".Defence.level", 1);
			playerconfig.set("players." + player.getName() + ".Ranged.exp", 0);
			playerconfig.set("players." + player.getName() + ".Ranged.level", 1);
			playerconfig.set("players." + player.getName() + ".Firemaking.exp", 0);
			playerconfig.set("players." + player.getName() + ".Firemaking.level", 1);
			playerconfig.set("players." + player.getName() + ".Cooking.exp", 0);
			playerconfig.set("players." + player.getName() + ".Cooking.level", 1);
			playerconfig.set("players." + player.getName() + ".Construction.exp", 0);
			playerconfig.set("players." + player.getName() + ".Construction.level", 1);
			playerconfig.set("players." + player.getName() + ".Smithing.exp", 0);
			playerconfig.set("players." + player.getName() + ".Smithing.level", 1);
			playerconfig.set("players." + player.getName() + ".combatlvl", 3);
			log.info("[RpgEssentials] Added "+ player.getName() +" to config!");
		}
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cape(Player player, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".cape", url);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void capeother(String cmdplayer, String url) {
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".cape", url);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void title(Player player, String title) {
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".title", title);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void hidetitle(Player player){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".hidetitle", true);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void titleother(String cmdplayer, String title){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".title", title);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void speed(Player player, double speed){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".speed", speed);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void speedother(String cmdplayer, double speed){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".speed", speed);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void skin(Player player, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".skin", url);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void skinother(String cmdplayer, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".skin", url);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void jump(Player player, double height) {
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".jump", height);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void jumpother(String cmdplayer, double height){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".speed", height);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
