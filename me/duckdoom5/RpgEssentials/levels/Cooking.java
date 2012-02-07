package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cooking {
    static YamlConfiguration levelconfig = new YamlConfiguration();
    
	public static void blockcheck(ItemStack result, Player player, int amount, RpgEssentials plugin){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Cooking";
		if(result.getType() == Material.GOLDEN_APPLE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Golden Apple");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.BREAD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Bread");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.MUSHROOM_SOUP){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Mushroom Soup");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.CAKE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cake");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_BEEF){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cooked Beef");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_CHICKEN){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cooked Chicken");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.COOKED_FISH){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cooked Fish");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GRILLED_PORK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Grilled Porkchop");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		//Smithing
		}else if(result.getType() == Material.IRON_INGOT){
			addexp = levelconfig.getInt("Exp.Smithing.Iron Ingot");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}else if(result.getType() == Material.CLAY_BRICK){
			addexp = levelconfig.getInt("Exp.Smithing.Clay Brick");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_INGOT){
			addexp = levelconfig.getInt("Exp.Smithing.Gold Ingot");
			LevelingSystem.addexp(player, "Smithing", (addexp * amount), plugin);
		}
	}
}
