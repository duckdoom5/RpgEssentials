package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.bukkit.material.SpawnEgg;

public class Taming extends Skill {
    public static Taming instance;
    
    static {
        instance = new Taming();
    }
    
    @Override
    public MaterialData[] getUnlockableMaterialData(){
        return new MaterialData[] { new SpawnEgg(EntityType.SQUID), new SpawnEgg(EntityType.SNOWMAN), new SpawnEgg(EntityType.CHICKEN), new SpawnEgg(EntityType.SHEEP), new SpawnEgg(EntityType.PIG),
                new SpawnEgg(EntityType.COW), new SpawnEgg(EntityType.MUSHROOM_COW), new SpawnEgg(EntityType.OCELOT), new SpawnEgg(EntityType.WOLF), new SpawnEgg(EntityType.HORSE),
                new SpawnEgg(EntityType.BAT), new SpawnEgg(EntityType.ZOMBIE), new SpawnEgg(EntityType.PIG_ZOMBIE), new SpawnEgg(EntityType.SLIME), new SpawnEgg(EntityType.MAGMA_CUBE),
                new SpawnEgg(EntityType.SKELETON), new SpawnEgg(EntityType.SPIDER), new SpawnEgg(EntityType.CAVE_SPIDER), new SpawnEgg(EntityType.BLAZE), new SpawnEgg(EntityType.CREEPER),
                new SpawnEgg(EntityType.ENDERMAN), new SpawnEgg(EntityType.SILVERFISH), new SpawnEgg(EntityType.GHAST), new SpawnEgg(EntityType.VILLAGER), new SpawnEgg(EntityType.WITCH),
                new SpawnEgg(EntityType.GIANT), new SpawnEgg(EntityType.IRON_GOLEM), new SpawnEgg(EntityType.WITHER), new SpawnEgg(EntityType.ENDER_DRAGON) };
    }

    @Override
    public Material getIcon() {
        return Material.DRAGON_EGG;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.TAMING;
    }
    
    @Override
    public boolean hasUnlockableMaterialData(){
        return true;
    }
    
    @Override
    public int getUnlockLevel(SkillType skill, MaterialData material){
        if(isEnabled(skill)){
            return Configuration.level.getInt("UnlockLevel." + skill.toString().toLowerCase() + "." + ((SpawnEgg)material).getSpawnedType().toString().toLowerCase().replace("_", " "));
        }
        return 1;
    }
    
    public int getXp(EntityType e) {
        if (isEnabled(getSkillType())) {
            return Configuration.level.getInt("Exp." + getSkillType().toString().toLowerCase() + "." + e.toString().toLowerCase().replace("_", " "));
        }
        return 0;
    }
}
