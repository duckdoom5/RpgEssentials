package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Cooking extends Skill {
    public static Cooking instance;
    
    static {
        instance = new Cooking();
    }
    
    public int getXp(ItemStack result, int amount) {
        if (isEnabled(getSkillType())) {
            return Configuration.level.getInt("Exp." + getSkillType().toString().toLowerCase() + "." + result.getType().toString().toLowerCase().replace("_", " ")) * amount;
        }
        return 0;
    }
    
    @Override
    public Material getIcon() {
        return Material.CAKE;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.COOKING;
    }
}
