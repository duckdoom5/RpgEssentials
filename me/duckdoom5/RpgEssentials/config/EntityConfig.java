package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class EntityConfig {
	public static RpgEssentials plugin;
	YamlConfiguration entityconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public EntityConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setentityconfig(){
		try {
			entityconfig.load("plugins/RpgEssentials/Entitys.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating entity config...");
		}
		
		try {
			entityconfig.save("plugins/RpgEssentials/Entitys.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
