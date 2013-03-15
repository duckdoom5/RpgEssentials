package me.duckdoom5.RpgEssentials.RpgEntities.Config;

import java.util.Arrays;

public class EntitiesConfig {
	public static void set(){
		if(!Configuration.entities.contains("Entities.Penguin.type")){
			Configuration.entities.set("Entities.Penguin.type", "chicken");
		}
		if(!Configuration.entities.contains("Entities.Penguin.skin url")){
			Configuration.entities.set("Entities.Penguin.skin url", "http://rpgessentials.lynxdragon.com/plugin/mobs/penguin.png");
		}
		if(!Configuration.entities.contains("Entities.Penguin.spawn mode")){
			Configuration.entities.set("Entities.Penguin.spawn mode", Arrays.asList("BREEDING", "NATURAL", "SPAWNER", "SPAWNER_EGG"));
		}
		if(!Configuration.entities.contains("Entities.Penguin.spawn biome")){
			Configuration.entities.set("Entities.Penguin.spawn biome", Arrays.asList("ICE_PLAINS", "ICE_MOUNTAINS", "TAIGA", "TAIGA_HILLS", "FROZEN_OCEAN", "FROZEN_RIVER"));
		}
		if(!Configuration.entities.contains("Entities.Penguin.spawn chance")){
			Configuration.entities.set("Entities.Penguin.spawn chance", 90);
		}
	}
}
