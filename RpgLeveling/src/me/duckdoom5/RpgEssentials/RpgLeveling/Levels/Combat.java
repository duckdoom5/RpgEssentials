package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import org.bukkit.Material;

public class Combat extends Skill {
    public static Combat instance;
    
    static {
        instance = new Combat();
    }

    @Override
    public Material getIcon() {
        return Material.DIAMOND_SWORD;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.COMBAT;
    }
}
