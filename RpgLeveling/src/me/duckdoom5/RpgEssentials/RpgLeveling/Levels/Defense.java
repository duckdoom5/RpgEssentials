package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;

public class Defense extends Skill {
public static Defense instance;
    
    static {
        instance = new Defense();
    }

    public boolean canUse(RpgPlayerLevel levelPlayer, Material type) {
        return super.canUse(levelPlayer, type, SkillType.DEFENSE);
    }

    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.LEATHER_BOOTS, Material.LEATHER_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_CHESTPLATE, 
                                Material.IRON_BOOTS, Material.IRON_LEGGINGS, Material.IRON_CHESTPLATE, Material.IRON_CHESTPLATE,
                                Material.GOLD_BOOTS, Material.GOLD_LEGGINGS, Material.GOLD_CHESTPLATE, Material.GOLD_CHESTPLATE,
                                Material.DIAMOND_BOOTS, Material.DIAMOND_LEGGINGS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_CHESTPLATE };
    }
    
    @Override
    public Material getIcon() {
        return Material.IRON_CHESTPLATE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.DEFENSE;
    }
}
