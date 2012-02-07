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
		if(!config.contains("Ores Texture")){
			config.set("Ores Texture", "http://82.74.70.243/server/textures/ores.png");
		}
		if(!config.contains("Blocks Texture")){
			config.set("Blocks Texture", "http://82.74.70.243/server/textures/blocks.png");
		}
		if(!config.contains("Stairs Texture")){
			config.set("Stairs Texture", "http://82.74.70.243/server/textures/trap.png");
		}
		if(!config.contains("Plants Texture")){
			config.set("Plants Texture", "http://82.74.70.243/server/textures/plants.png");
		}
		if(!config.contains("Misc Texture")){
			config.set("Misc Texture", "http://82.74.70.243/server/textures/misc.png");
		}
		
		if(!config.contains("player.join.enabeld")){
			config.set("player.join.enabled",true);
		}
		if(!config.contains("player.leave.enabeld")){
			config.set("player.leave.enabeld",true);
		}
		if(!config.contains("player.starting money")){
			config.set("player.starting money",100);
		}
		if(!config.contains("store.allow")){
			config.set("store.allow", false);
		}
		if(!config.contains("store.key")){
			config.set("store.key", "o");
		}
		if(!config.contains("stats.allow")){
			config.set("stats.allow", true);
		}
		if(!config.contains("stats.key")){
			config.set("stats.key", "l");
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
			config.set("texturepack.default","http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");
		}
		if(!config.contains("texturepack.worldname")){
			config.set("texturepack.worldname","http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");
		}
		
		try {
			config.save("plugins/RpgEssentials/config.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
