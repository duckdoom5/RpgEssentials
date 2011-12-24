package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class BlockConfig {
	public static RpgEssentials plugin;
	YamlConfiguration blockconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public void setblockconfig(){
		try {
			blockconfig.load("plugins/RpgEssentials/blocks.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating blocks config...");
		}
		
		//Original Ores
		
		if(!blockconfig.contains("Original Ores.Coal Ore.frequency")){
			blockconfig.set("Original Ores.Coal Ore.frequency",110);
		}
		if(!blockconfig.contains("Original Ores.Coal Ore.minheight")){
			blockconfig.set("Original Ores.Coal Ore.minheight",16);
		}
		if(!blockconfig.contains("Original Ores.Coal Ore.maxheight")){
			blockconfig.set("Original Ores.Coal Ore.maxheight",70);
		}
		if(!blockconfig.contains("Original Ores.Iron Ore.frequency")){
			blockconfig.set("Original Ores.Iron Ore.frequency",90);
		}
		if(!blockconfig.contains("Original Ores.Iron Ore.minheight")){
			blockconfig.set("Original Ores.Iron Ore.minheight",16);
		}
		if(!blockconfig.contains("Original Ores.Iron Ore.maxheight")){
			blockconfig.set("Original Ores.Iron Ore.maxheight",64);
		}
		if(!blockconfig.contains("Original Ores.Lapis Ore.frequency")){
			blockconfig.set("Original Ores.Lapis Ore.frequency",4);
		}
		if(!blockconfig.contains("Original Ores.Lapis Ore.minheight")){
			blockconfig.set("Original Ores.Lapis Ore.minheight",2);
		}
		if(!blockconfig.contains("Original Ores.Lapis Ore.maxheight")){
			blockconfig.set("Original Ores.Lapis Ore.maxheight",34);
		}
		if(!blockconfig.contains("Original Ores.Gold Ore.frequency")){
			blockconfig.set("Original Ores.Gold Ore.frequency",20);
		}
		if(!blockconfig.contains("Original Ores.Gold Ore.minheight")){
			blockconfig.set("Original Ores.Gold Ore.minheight",5);
		}
		if(!blockconfig.contains("Original Ores.Gold Ore.maxheight")){
			blockconfig.set("Original Ores.Gold Ore.maxheight",32);
		}
		if(!blockconfig.contains("Original Ores.Redstone Ore.frequency")){
			blockconfig.set("Original Ores.Redstone Ore.frequency",20);
		}
		if(!blockconfig.contains("Original Ores.Redstone Ore.minheight")){
			blockconfig.set("Original Ores.Redstone Ore.minheight",2);
		}
		if(!blockconfig.contains("Original Ores.Redstone Ore.maxheight")){
			blockconfig.set("Original Ores.Redstone Ore.maxheight",16);
		}
		if(!blockconfig.contains("Original Ores.Diamond Ore.frequency")){
			blockconfig.set("Original Ores.Diamond Ore.frequency",5);
		}
		if(!blockconfig.contains("Original Ores.Diamond Ore.minheight")){
			blockconfig.set("Original Ores.Diamond Ore.minheight",2);
		}
		if(!blockconfig.contains("Original Ores.Diamond Ore.maxheight")){
			blockconfig.set("Original Ores.Diamond Ore.maxheight",16);
		}
		
		
		//Custom Ores
		
		//Adamantine
		if(!blockconfig.contains("Custom Ores.Adamantine Ore.textureID")){
			blockconfig.set("Custom Ores.Adamantine Ore.textureID",0);
		}
		if(!blockconfig.contains("Custom Ores.Adamantine Ore.frequency")){
			blockconfig.set("Custom Ores.Adamantine Ore.frequency",2);
		}
		if(!blockconfig.contains("Custom Ores.Adamantine Ore.minheight")){
			blockconfig.set("Custom Ores.Adamantine Ore.minheight",2);
		}
		if(!blockconfig.contains("Custom Ores.Adamantine Ore.maxheight")){
			blockconfig.set("Custom Ores.Adamantine Ore.maxheight",10);
		}
		//Irridium
		if(!blockconfig.contains("Custom Ores.Irridium Ore.textureID")){
			blockconfig.set("Custom Ores.Irridium Ore.textureID",1);
		}
		if(!blockconfig.contains("Custom Ores.Irridium Ore.frequency")){
			blockconfig.set("Custom Ores.Irridium Ore.frequency",2);
		}
		if(!blockconfig.contains("Custom Ores.Irridium Ore.minheight")){
			blockconfig.set("Custom Ores.Irridium Ore.minheight",2);
		}
		if(!blockconfig.contains("Custom Ores.Irridium Ore.maxheight")){
			blockconfig.set("Custom Ores.Irridium Ore.maxheight",5);
		}
		//Mithril
		if(!blockconfig.contains("Custom Ores.Mithril Ore.textureID")){
			blockconfig.set("Custom Ores.Mithril Ore.textureID",2);
		}
		if(!blockconfig.contains("Custom Ores.Mithril Ore.frequency")){
			blockconfig.set("Custom Ores.Mithril Ore.frequency",8);
		}
		if(!blockconfig.contains("Custom Ores.Mithril Ore.minheight")){
			blockconfig.set("Custom Ores.Mithril Ore.minheight",20);
		}
		if(!blockconfig.contains("Custom Ores.Mithril Ore.maxheight")){
			blockconfig.set("Custom Ores.Mithril Ore.maxheight",30);
		}
		//Verdite
		if(!blockconfig.contains("Custom Ores.Verdite Ore.textureID")){
			blockconfig.set("Custom Ores.Verdite Ore.textureID",3);
		}
		if(!blockconfig.contains("Custom Ores.Verdite Ore.frequency")){
			blockconfig.set("Custom Ores.Verdite Ore.frequency",40);
		}
		if(!blockconfig.contains("Custom Ores.Verdite Ore.minheight")){
			blockconfig.set("Custom Ores.Verdite Ore.minheight",55);
		}
		if(!blockconfig.contains("Custom Ores.Verdite Ore.maxheight")){
			blockconfig.set("Custom Ores.Verdite Ore.maxheight",70);
		}
		//Emerald
		if(!blockconfig.contains("Custom Ores.Emerald Ore.textureID")){
			blockconfig.set("Custom Ores.Emerald Ore.textureID",255);
		}
		if(!blockconfig.contains("Custom Ores.Emerald Ore.frequency")){
			blockconfig.set("Custom Ores.Emerald Ore.frequency",2);
		}
		if(!blockconfig.contains("Custom Ores.Emerald Ore.minheight")){
			blockconfig.set("Custom Ores.Emerald Ore.minheight",2);
		}
		if(!blockconfig.contains("Custom Ores.Emerald Ore.maxheight")){
			blockconfig.set("Custom Ores.Emerald Ore.maxheight",10);
		}
		//Amethyst
		if(!blockconfig.contains("Custom Ores.Amethyst Ore.textureID")){
			blockconfig.set("Custom Ores.Amethyst Ore.textureID",254);
		}
		if(!blockconfig.contains("Custom Ores.Amethyst Ore.frequency")){
			blockconfig.set("Custom Ores.Amethyst Ore.frequency",4);
		}
		if(!blockconfig.contains("Custom Ores.Amethyst Ore.minheight")){
			blockconfig.set("Custom Ores.Amethyst Ore.minheight",30);
		}
		if(!blockconfig.contains("Custom Ores.Amethyst Ore.maxheight")){
			blockconfig.set("Custom Ores.Amethyst Ore.maxheight",34);
		}
		//Saphire
		if(!blockconfig.contains("Custom Ores.Saphire Ore.textureID")){
			blockconfig.set("Custom Ores.Saphire Ore.textureID",253);
		}
		if(!blockconfig.contains("Custom Ores.Saphire Ore.frequency")){
			blockconfig.set("Custom Ores.Saphire Ore.frequency",4);
		}
		if(!blockconfig.contains("Custom Ores.Saphire Ore.minheight")){
			blockconfig.set("Custom Ores.Saphire Ore.minheight",40);
		}
		if(!blockconfig.contains("Custom Ores.Saphire Ore.maxheight")){
			blockconfig.set("Custom Ores.Saphire Ore.maxheight",60);
		}
		//Topaz
		if(!blockconfig.contains("Custom Ores.Topaz Ore.textureID")){
			blockconfig.set("Custom Ores.Topaz Ore.textureID",252);
		}
		if(!blockconfig.contains("Custom Ores.Topaz Ore.frequency")){
			blockconfig.set("Custom Ores.Topaz Ore.frequency",6);
		}
		if(!blockconfig.contains("Custom Ores.Topaz Ore.minheight")){
			blockconfig.set("Custom Ores.Topaz Ore.minheight",16);
		}
		if(!blockconfig.contains("Custom Ores.Topaz Ore.maxheight")){
			blockconfig.set("Custom Ores.Topaz Ore.maxheight",70);
		}
		
		
		try {
			blockconfig.save("plugins/RpgEssentials/blocks.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
