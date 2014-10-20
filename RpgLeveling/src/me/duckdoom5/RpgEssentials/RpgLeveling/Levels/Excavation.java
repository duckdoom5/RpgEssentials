package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Excavation extends Skill {
    public static Excavation instance;
    
    static {
        instance = new Excavation();
    }
    
    public int getExp(Material material, int amount){
        return super.getExpEarned(material, amount, SkillType.EXCAVATION);
    }
    
    public static boolean isExcavation(Block block) {
        if ((block.getType() == Material.DIRT) || (block.getType() == Material.GRASS) || (block.getType() == Material.CLAY) || (block.getType() == Material.SAND) || (block.getType() == Material.GRAVEL) || (block.getType() == Material.SOUL_SAND) || (block.getType() == Material.SOIL) || (block.getType() == Material.SNOW_BLOCK) || (block.getType() == Material.SNOW)) {
            return true;
        }
        return false;
    }

    public boolean canUse(RpgPlayerLevel levelPlayer, Material type) {
        return super.canUse(levelPlayer, type, SkillType.EXCAVATION);
    }
    
    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE };
    }

    @Override
    public Material getIcon() {
        return Material.IRON_SPADE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.EXCAVATION;
    }
}
