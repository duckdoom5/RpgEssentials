package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerConfig {
	public static RpgEssentials plugin;
	YamlConfiguration playerconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public PlayerConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setplayerconfig(){
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating player config...");
		}
		if(!playerconfig.contains("players.examplename.title")){
			playerconfig.set("players.examplename.title", "example title");
		}
		if(!playerconfig.contains("players.examplename.hidetitle")){
			playerconfig.set("players.examplename.hidetitle", false);
		}
		if(!playerconfig.contains("players.examplename.cape")){
			playerconfig.set("players.examplename.cape", "http://example url.com");
		}
		if(!playerconfig.contains("players.examplename.speed")){
			playerconfig.set("players.examplename.speed", 1);
		}
		if(!playerconfig.contains("players.examplename.skin")){
			playerconfig.set("players.examplename.skin", "http://example url.com");
		}
		if(!playerconfig.contains("players.examplename.money")){
			playerconfig.set("players.examplename.money", 1000);
		}
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
