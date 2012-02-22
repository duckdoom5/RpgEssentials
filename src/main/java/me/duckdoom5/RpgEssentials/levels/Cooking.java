package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cooking {
    
	public static void blockcheck(ItemStack result, Player player, int amount, RpgEssentials plugin){
		int addexp;
		String skilltype = "Cooking";
		if(result.getType() == Material.GOLDEN_APPLE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Golden Apple");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.BREAD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Bread");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.MUSHROOM_SOUP){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Mushroom Soup");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.CAKE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cake");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_BEEF){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cooked Beef");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_CHICKEN){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cooked Chicken");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_FISH){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cooked Fish");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GRILLED_PORK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Grilled Porkchop");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		//Smithing
		}else if(result.getType() == Material.IRON_INGOT){
			addexp = Configuration.level.getInt("Exp.Smithing.Iron Ingot");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}else if(result.getType() == Material.CLAY_BRICK){
			addexp = Configuration.level.getInt("Exp.Smithing.Clay Brick");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_INGOT){
			addexp = Configuration.level.getInt("Exp.Smithing.Gold Ingot");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}
	}
}
