package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigAdd {
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration playerconfig = new YamlConfiguration();
	YamlConfiguration blocks = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public void addplayer(Player player){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!playerconfig.contains("players."+ player.getName() + ".title")){
			log.info("[RpgEssentials] Adding new player to config...");
			playerconfig.set("players." + player.getName() + ".title", player.getName());
			log.info("[RpgEssentials] Added "+ player.getName() +" to config!");
		}
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cape(Player player, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".cape", url);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void capeother(String cmdplayer, String url) {
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".cape", url);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void title(Player player, String title) {
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".title", title);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void hidetitle(Player player){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".hidetitle", true);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void titleother(String cmdplayer, String title){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".title", title);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void speed(Player player, double speed){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".speed", speed);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void speedother(String cmdplayer, double speed){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".speed", speed);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void skin(Player player, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".skin", url);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void skinother(String cmdplayer, String url){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".skin", url);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void jump(Player player, double height) {
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + player.getName() + ".jump", height);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void jumpother(String cmdplayer, double height){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerconfig.set("players." + cmdplayer + ".speed", height);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
