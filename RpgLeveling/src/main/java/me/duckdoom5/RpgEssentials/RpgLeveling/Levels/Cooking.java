package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.inventory.ItemStack;

public class Cooking {
	public static int getXp(ItemStack result, int amount){
		return Configuration.level.getInt("Exp.Cooking." + result.getType().toString().toLowerCase().replace("_", " ")) * amount;
	}
}
