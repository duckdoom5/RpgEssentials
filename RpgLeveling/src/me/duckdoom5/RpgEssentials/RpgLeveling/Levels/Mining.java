package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.material.Step;

public class Mining extends Skill {
    public static Mining instance;
    
    static {
        instance = new Mining();
    }
    
    public int getXp(Block block) {
        if (isEnabled(SkillType.MINING)) {
            if (block.getType() == Material.STEP || block.getType() == Material.DOUBLE_STEP) {
                final BlockState bs = block.getState();
                final Step step = (Step) bs.getData();
                if (step.getMaterial().equals(Material.STONE)) {
                    return Configuration.level.getInt("Exp.mining.stone slab");
                } else if (step.getMaterial().equals(Material.SANDSTONE)) {
                    return Configuration.level.getInt("Exp.mining.sandstone slab");
                } else if (step.getMaterial().equals(Material.COBBLESTONE)) {
                    return Configuration.level.getInt("Exp.mining.cobblestone slab");
                } else if (step.getMaterial().equals(Material.BRICK)) {
                    return Configuration.level.getInt("Exp.mining.brick slab");
                } else if (step.getMaterial().equals(Material.SMOOTH_BRICK)) {
                    return Configuration.level.getInt("Exp.mining.stone brick slab");
                }
            } else if (block.getType() == Material.SMOOTH_BRICK) {
                // normal
                if (block.getData() == (byte) 0) {
                    return Configuration.level.getInt("Exp.mining.stone brick");
                    // mossy
                } else if (block.getData() == (byte) 1) {
                    return Configuration.level.getInt("Exp.mining.mossy stone brick");
                    // cracked
                } else if (block.getData() == (byte) 2) {
                    return Configuration.level.getInt("Exp.mining.cracked stone brick");
                }
            } else {
                return Configuration.level.getInt("Exp.mining."+ block.getType().toString().toLowerCase().replace("_", " "));
            }
        }
        return 0;
    }

    public static boolean isMining(Block block) {
        if ((block.getType() == Material.STONE) || (block.getType() == Material.COBBLESTONE) || (block.getType() == Material.MOSSY_COBBLESTONE) || (block.getType() == Material.COBBLESTONE_STAIRS) || (block.getType() == Material.SMOOTH_BRICK) || (block.getType() == Material.SMOOTH_STAIRS) || (block.getType() == Material.BRICK) || (block.getType() == Material.ENDER_STONE) || (block.getType() == Material.BRICK_STAIRS) || (block.getType() == Material.IRON_BLOCK) || (block.getType() == Material.DIAMOND_BLOCK) || (block.getType() == Material.LAPIS_BLOCK) || (block.getType() == Material.GOLD_BLOCK) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.COAL_ORE) || (block.getType() == Material.IRON_ORE) || (block.getType() == Material.GOLD_ORE) || (block.getType() == Material.LAPIS_ORE) || (block.getType() == Material.OBSIDIAN) || (block.getType() == Material.NETHERRACK) || (block.getType() == Material.GLOWSTONE) || (block.getType() == Material.NETHER_BRICK) || (block.getType() == Material.NETHER_BRICK_STAIRS) || (block.getType() == Material.REDSTONE_ORE) || (block.getType() == Material.DIAMOND_ORE) || ((block.getType() == Material.STEP) && (block.getData() != (byte) 2)) || ((block.getType() == Material.DOUBLE_STEP) && (block.getData() != (byte) 2))) {
            return true;
        }
        return false;
    }

    public boolean canUse(RpgPlayerLevel levelPlayer, Material type) {
        return super.canUse(levelPlayer, type, SkillType.MINING);
    }
    
    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE };
    }

    public boolean canMine(Block block, RpgPlayerLevel player) {
        if (Configuration.level.contains("UnlockLevel.ores." + block.getType().toString().toLowerCase().replace("_", " ")) && ((Player) player.getRpgPlayer().getPlayer()).getGameMode() == GameMode.SURVIVAL && isEnabled(SkillType.MINING)) {
            final int currentlevel = player.getLvl(SkillType.MINING);
            if (currentlevel >= Configuration.level.getInt("UnlockLevel.ores." + block.getType().toString().toLowerCase().replace("_", " "))) {
                return true;
            }
            ((Player) player.getRpgPlayer().getPlayer()).sendMessage(ChatColor.RED + "You can only break " + block.getType().toString().toLowerCase().replace("_", " ") + " on level " + Configuration.level.getInt("UnlockLevel." + block.getType().toString().toLowerCase().replace("_", " ")));
            return false;
        }
        return true;
    }

    @Override
    public Material getIcon() {
        return Material.IRON_PICKAXE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.MINING;
    }
}
