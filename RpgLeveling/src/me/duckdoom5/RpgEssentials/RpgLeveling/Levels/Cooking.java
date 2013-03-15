package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.inventory.ItemStack;

public class Cooking {
	private static Skill skill = Skill.COOKING;
	
	public static int getXp(ItemStack result, int amount){
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			return Configuration.level.getInt("Exp.Cooking." + result.getType().toString().toLowerCase().replace("_", " ")) * amount;
		}
		return 0;
	}
}
