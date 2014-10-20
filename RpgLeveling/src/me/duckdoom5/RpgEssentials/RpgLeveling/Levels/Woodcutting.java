package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Woodcutting extends Skill {
    public static Woodcutting instance;
    
    static {
        instance = new Woodcutting();
    }
    
    public int getXp(Block block) {
        if (isEnabled(SkillType.WOODCUTTING)) {
            if (block.getType() == Material.LOG) {
                // normal log
                if (block.getData() == (byte) 0) {
                    return Configuration.level.getInt("Exp.woodcutting.oak log");
                    // redwood
                } else if (block.getData() == (byte) 1) {
                    return Configuration.level.getInt("Exp.woodcutting.pine log");
                    // birch
                } else if (block.getData() == (byte) 2) {
                    return Configuration.level.getInt("Exp.woodcutting.birch log");
                    // jungle
                } else if (block.getData() == (byte) 3) {
                    return Configuration.level.getInt("Exp.woodcutting.jungle log");
                }
            } else if (block.getType() == Material.WOOD) {
                // normal log
                if (block.getData() == (byte) 0) {
                    return Configuration.level.getInt("Exp.woodcutting.oak wood");
                    // redwood
                } else if (block.getData() == (byte) 1) {
                    return Configuration.level.getInt("Exp.woodcutting.pine wood");
                    // birch
                } else if (block.getData() == (byte) 2) {
                    return Configuration.level.getInt("Exp.woodcutting.birch wood");
                    // jungle
                } else if (block.getData() == (byte) 3) {
                    return Configuration.level.getInt("Exp.woodcutting.jungle wood");
                }
            } else if (block.getType() == Material.STEP) {
                if (block.getData() == (byte) 2) {
                    return Configuration.level.getInt("Exp.woodcutting.wood step");
                }
            } else if (block.getType() == Material.DOUBLE_STEP) {
                if (block.getData() == (byte) 2) {
                    return Configuration.level.getInt("Exp.woodcutting.wood double step");
                }
            } else {
                return Configuration.level.getInt("Exp.woodcutting." + block.getType().toString().toLowerCase().replace("_", " "));
            }
        }
        return 0;
    }

    public static boolean isWoodcutting(Block block) {
        if ((block.getType() == Material.LOG) || (block.getType() == Material.WOOD) || (block.getType() == Material.WOOD_STAIRS) || (block.getType() == Material.FENCE) || ((block.getType() == Material.STEP) && (block.getData() == (byte) 2)) || ((block.getType() == Material.DOUBLE_STEP) && (block.getData() == (byte) 2))) {
            return true;
        }
        return false;
    }

    public boolean canUse(RpgPlayerLevel levelPlayer, Material type) {
        return super.canUse(levelPlayer, type, SkillType.WOODCUTTING);
    }
    
    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE };
    }

    @Override
    public Material getIcon() {
        return Material.IRON_AXE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.WOODCUTTING;
    }
}
