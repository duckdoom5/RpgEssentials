package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class GeneratorConfig {
	public static RpgEssentials plugin;
	YamlConfiguration generatorconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public GeneratorConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setgeneratorconfig(){
		try {
			generatorconfig.load("plugins/RpgEssentials/generator.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating generator config...");
		}
		
		//biomes
		
		if(!generatorconfig.contains("Generator.Biomes.Desert")){
			generatorconfig.set("Generator.Biomes.Desert",true);
		}
		if(!generatorconfig.contains("Generator.Biomes.Beach")){
			generatorconfig.set("Generator.Biomes.Beach",true);
		}
		if(!generatorconfig.contains("Generator.Biomes.Sea")){
			generatorconfig.set("Generator.Biomes.Sea",true);
		}
		//ores
		if(!generatorconfig.contains("Generator.Ores.Custom")){
			generatorconfig.set("Generator.Ores.Custom",true);
		}
		if(!generatorconfig.contains("Generator.Ores.Original")){
			generatorconfig.set("Generator.Ores.Original",true);
		}
		//plants
		if(!generatorconfig.contains("Generator.Plants.Grass")){
			generatorconfig.set("Generator.Plants.Grass",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Flowers")){
			generatorconfig.set("Generator.Plants.Flowers",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Cacti")){
			generatorconfig.set("Generator.Plants.Cacti",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Pumpkins and Melons")){
			generatorconfig.set("Generator.Plants.Pumpkins and Melons",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Sugar Cane")){
			generatorconfig.set("Generator.Plants.Sugar Cane",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Trees")){
			generatorconfig.set("Generator.Plants.Trees",true);
		}
		if(!generatorconfig.contains("Generator.Plants.Mushrooms")){
			generatorconfig.set("Generator.Plants.Mushrooms",true);
		}
		try {
			generatorconfig.save("plugins/RpgEssentials/generator.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
