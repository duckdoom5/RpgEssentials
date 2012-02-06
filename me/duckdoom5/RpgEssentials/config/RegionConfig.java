package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class RegionConfig {
	public static RpgEssentials plugin;
	YamlConfiguration regionconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public RegionConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setregionconfig(){
		try {
			regionconfig.load("plugins/RpgEssentials/Regions.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating region config...");
		}
		
		if(!regionconfig.contains("Regions.examplename.message")){
			regionconfig.set("Regions.examplename.message","message");
		}
		if(!regionconfig.contains("Regions.examplename.submessage")){
			regionconfig.set("Regions.examplename.submessage","submessage");
		}
		if(!regionconfig.contains("Regions.examplename.iconId")){
			regionconfig.set("Regions.examplename.iconId", 264);
		}
		if(!regionconfig.contains("Regions.examplename.music")){
			regionconfig.set("Regions.examplename.music", "http://exampleurl.com");
		}
		if(!regionconfig.contains("Regions.examplename.command")){
			regionconfig.set("Regions.examplename.command", "rpg help");
		}
		if(!regionconfig.contains("Regions.examplename.fog")){
			regionconfig.set("Regions.examplename.fog", "far");
		}
		
		try {
			regionconfig.save("plugins/RpgEssentials/Regions.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
