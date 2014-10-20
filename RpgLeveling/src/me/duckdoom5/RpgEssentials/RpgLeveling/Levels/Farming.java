package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Farming extends Skill {
    public static Farming instance;
    
    static {
        instance = new Farming();
    }
    
    public int getBreakXp(Block block) {
        if (isEnabled(SkillType.FARMING)) {
            return Configuration.level.getInt("Exp.farming." + block.getType().toString().toLowerCase().replace("_", " ") + ".break");
        }
        return 0;
    }

    public int getPlaceXp(Block block) {
        if (isEnabled(SkillType.FARMING)) {
            return Configuration.level.getInt("Exp.farming." + block.getType().toString().toLowerCase().replace("_", " ") + ".place");
        }
        return 0;
    }

    public int getSoilXp(Material tool) {
        if (isEnabled(SkillType.FARMING)) {
            int exp = Configuration.level.getInt("Exp.farming.soil.create");
            if (tool.equals(Material.WOOD_HOE)) {
                return exp;
            } else if (tool.equals(Material.STONE_HOE)) {
                return exp += 1;
            } else if (tool.equals(Material.IRON_HOE)) {
                return exp += 2;
            } else if (tool.equals(Material.GOLD_HOE)) {
                return exp += 3;
            } else if (tool.equals(Material.DIAMOND_HOE)) {
                return exp += 4;
            }
        }
        return 0;
    }

    public boolean isFarming(Block block) {
        if (block.getType() == Material.YELLOW_FLOWER || block.getType() == Material.RED_ROSE || block.getType() == Material.CACTUS || block.getType() == Material.PUMPKIN || block.getType() == Material.PUMPKIN_STEM || block.getType() == Material.MELON_BLOCK || block.getType() == Material.PUMPKIN_STEM || block.getType() == Material.RED_MUSHROOM || block.getType() == Material.BROWN_MUSHROOM || block.getType() == Material.HUGE_MUSHROOM_1 || block.getType() == Material.HUGE_MUSHROOM_2 || block.getType() == Material.LONG_GRASS || (block.getType() == Material.CROPS) || block.getType() == Material.VINE || block.getType() == Material.WATER_LILY || block.getType() == Material.LEAVES || block.getType() == Material.DEAD_BUSH) {
            return true;
        }
        return false;
    }

    public boolean canUse(RpgPlayerLevel levelPlayer, Material type) {
        return super.canUse(levelPlayer, type, SkillType.FARMING);
    }
    
    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE };
    }

    @Override
    public Material getIcon() {
        return Material.IRON_HOE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.FARMING;
    }
}
