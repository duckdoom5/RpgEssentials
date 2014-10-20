package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import org.bukkit.Material;

public class Questing extends Skill {
    public static Questing instance;
    
    static {
        instance = new Questing();
    }

    @Override
    public Material getIcon() {
        return Material.BOOK_AND_QUILL;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.QUESTING;
    }
}
