package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class BankConfig {
	public static RpgEssentials plugin;
	YamlConfiguration bankconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public BankConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setbankconfig(){
		try {
			bankconfig.load("plugins/RpgEssentials/Temp/Bank.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating bank config...");
		}
		
		if(!bankconfig.contains("Bank.example player.items")){
			bankconfig.set("Bank.example player.items", Arrays.asList("1:0:1","2:0:1","3:0:1"));
		}
		if(!bankconfig.contains("Bank.example player.size")){
			bankconfig.set("Bank.example player.size", 9);
		}
		
		try {
			bankconfig.save("plugins/RpgEssentials/Temp/Bank.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
