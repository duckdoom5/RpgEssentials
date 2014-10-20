package me.duckdoom5.RpgEssentials.RpgEntities.Config;

import java.util.Arrays;

import me.duckdoom5.RpgEssentials.RpgEntities.util.CustomEntityType;

public class EntitiesConfig {
    public static void set() {
        if (!Configuration.entities.contains("Entities.heart.icon")) {
            Configuration.entities.set("Entities.heart.icon", "http://rpgessentials.lynxdragon.com/plugin/mobs/icons/heart.png");
        }
        if (!Configuration.entities.contains("Entities.heart.spacing")) {
            Configuration.entities.set("Entities.heart.spacing", 10);
        }
        if (!Configuration.entities.contains("Entities.halfheart.icon")) {
            Configuration.entities.set("Entities.halfheart.icon", "http://rpgessentials.lynxdragon.com/plugin/mobs/icons/halfheart.png");
        }
        if (!Configuration.entities.contains("Entities.heartbg.icon")) {
            Configuration.entities.set("Entities.heartbg.icon", "http://rpgessentials.lynxdragon.com/plugin/mobs/icons/heartbg.png");
        }
        for(CustomEntityType type : CustomEntityType.values()){
            if (!Configuration.entities.contains("Entities." + type.toString().toLowerCase() + ".faceIcon")) {
                Configuration.entities.set("Entities." + type.toString().toLowerCase() + ".faceIcon", "http://rpgessentials.lynxdragon.com/plugin/mobs/faces/" + type.toString().toLowerCase() + ".png");
            }
        }
        if (!Configuration.entities.contains("Entities.Penguin.type")) {
            Configuration.entities.set("Entities.Penguin.type", "chicken");
        }
        if (!Configuration.entities.contains("Entities.Penguin.skin url")) {
            Configuration.entities.set("Entities.Penguin.skin url", "http://rpgessentials.lynxdragon.com/plugin/mobs/penguin.png");
        }
        if (!Configuration.entities.contains("Entities.Penguin.spawn mode")) {
            Configuration.entities.set("Entities.Penguin.spawn mode", Arrays.asList("BREEDING", "NATURAL", "SPAWNER", "SPAWNER_EGG"));
        }
        if (!Configuration.entities.contains("Entities.Penguin.spawn biome")) {
            Configuration.entities.set("Entities.Penguin.spawn biome", Arrays.asList("ICE_PLAINS", "ICE_MOUNTAINS", "TAIGA", "TAIGA_HILLS", "FROZEN_OCEAN", "FROZEN_RIVER"));
        }
        if (!Configuration.entities.contains("Entities.Penguin.spawn chance")) {
            Configuration.entities.set("Entities.Penguin.spawn chance", 90);
        }
    }
}
