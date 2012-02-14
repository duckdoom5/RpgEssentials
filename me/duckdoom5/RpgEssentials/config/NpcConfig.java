package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class NpcConfig {
	public static RpgEssentials plugin;
	YamlConfiguration npcconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public NpcConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setnpcconfig(){
		try {
			npcconfig.load("plugins/RpgEssentials/Temp/Npc.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating npc config...");
		}
		
		try {
			npcconfig.save("plugins/RpgEssentials/Temp/Npc.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
