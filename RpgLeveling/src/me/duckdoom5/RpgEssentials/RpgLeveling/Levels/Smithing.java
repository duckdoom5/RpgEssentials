package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.inventory.ItemStack;

public class Smithing {
	private static Skill skill = Skill.SMITHING;
	public static int getXp(ItemStack result, int amount){
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			return Configuration.level.getInt("Exp.Smithing." + result.getType().toString().toLowerCase().replace("_", " ")) * amount;
		}
		return 0;
	}
}
