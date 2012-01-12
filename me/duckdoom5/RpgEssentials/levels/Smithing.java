package me.duckdoom5.RpgEssentials.levels;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Smithing {
	static YamlConfiguration playerconfig = new YamlConfiguration();
    static YamlConfiguration levelconfig = new YamlConfiguration();
	
	public static void blockcheck(ItemStack result, Player player){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Smithing";
		if(result.getType() == Material.WOOD_AXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Axe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.WOOD_HOE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Hoe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.WOOD_PICKAXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Pickaxe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.WOOD_SWORD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Sword");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.WOOD_SPADE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Spade");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.STONE_AXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Axe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.STONE_HOE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Hoe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.STONE_PICKAXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Pickaxe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.STONE_SWORD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Sword");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.STONE_SPADE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Spade");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.IRON_AXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Axe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.IRON_HOE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Hoe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.IRON_PICKAXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Pickaxe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.IRON_SWORD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Sword");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.IRON_SPADE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Spade");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.GOLD_AXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Axe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.GOLD_HOE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Hoe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.GOLD_PICKAXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Pickaxe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.GOLD_SWORD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Sword");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.GOLD_SPADE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Spade");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.DIAMOND_AXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Axe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.DIAMOND_HOE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Hoe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.DIAMOND_PICKAXE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Pickaxe");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.DIAMOND_SWORD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Sword");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(result.getType() == Material.DIAMOND_SPADE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Spade");
			LevelingSystem.addexp(player, skilltype, addexp);
		}
	}
}
