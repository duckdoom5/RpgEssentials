package me.duckdoom5.RpgEssentials.levels;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cooking {
	static YamlConfiguration playerconfig = new YamlConfiguration();
    static YamlConfiguration levelconfig = new YamlConfiguration();
    
	public static void blockcheck(ItemStack result, Player player){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Cooking";
		if(result.getType() == Material.GOLDEN_APPLE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Golden Apple");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.BREAD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Bread");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.MUSHROOM_SOUP){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Mushroom Soup");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.CAKE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cake");
			LevelingSystem.addexp(player, skilltype, addexp);
		}
	}
}
