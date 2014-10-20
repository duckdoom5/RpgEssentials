package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Smithing extends Skill {
    public static Smithing instance;
    
    static {
        instance = new Smithing();
    }
    
    public int getXp(ItemStack result, int amount) {
        if (isEnabled(SkillType.SMITHING)) {
            return Configuration.level.getInt("Exp.smithing." + result.getType().toString().toLowerCase().replace("_", " ")) * amount;
        }
        return 0;
    }

    @Override
    public Material getIcon() {
        return Material.ANVIL;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.SMITHING;
    }
}
