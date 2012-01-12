package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	public static RpgEssentials plugin;
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration blocks = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public Config(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setconfig(){
		try {
			config.load("plugins/RpgEssentials/config.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating config...");
		}
		if(!config.contains("player.join.enabeld")){
			config.set("player.join.enabled",true);
		}
		if(!config.contains("player.leave.enabeld")){
			config.set("player.leave.enabeld",true);
		}
		if(!config.contains("player.starting money")){
			config.set("player.starting money",1000);
		}
		if(!config.contains("spout.leave.messageicon")){
			config.set("spout.leave.messageicon",260);
		}
		if(!config.contains("spout.join.messageicon")){
			config.set("spout.join.messageicon",322);
		}
		if(!config.contains("spout.join.message")){
			config.set("spout.join.message","Welcome to the server!");
		}
		if(!config.contains("spout.join.submessage")){
			config.set("spout.join.submessage","Have a good time");
		}
		if(!config.contains("texturepack.default")){
			config.set("texturepack.default","http://ExampleUrl.com");
		}
		if(!config.contains("texturepack.world.worldname")){
			config.set("texturepack.world.worldname","http://ExampleUrl.com");
		}
		
		try {
			config.save("plugins/RpgEssentials/config.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
