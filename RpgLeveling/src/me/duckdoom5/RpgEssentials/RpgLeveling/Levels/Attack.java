package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Attack extends Skill {
    public static Attack instance;
    
    static {
        instance = new Attack();
    }
    
    public boolean canUse(RpgPlayerLevel levelPlayer) {
        return super.canUse(levelPlayer, ((Player)levelPlayer.getRpgPlayer().getPlayer()).getItemInHand().getType(), SkillType.ATTACK);
    }
    
    @Override
    public Material[] getUnlockableMaterials(){
        return new Material[] { Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD};
    }

    @Override
    public Material getIcon() {
        return Material.IRON_SWORD;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.ATTACK;
    }
}
