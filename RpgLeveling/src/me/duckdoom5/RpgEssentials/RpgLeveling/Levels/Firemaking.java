package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import org.bukkit.Material;

public class Firemaking extends Skill {
    public static Firemaking instance;
    
    static {
        instance = new Firemaking();
    }
    
    public boolean canIgnite() {
        return isEnabled(SkillType.FIREMAKING);
    }

    @Override
    public Material getIcon() {
        return Material.FLINT_AND_STEEL;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.FIREMAKING;
    }
}
