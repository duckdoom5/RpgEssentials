package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Smithing {
	
	public static void blockcheck(ItemStack result, Player player, int amount, RpgEssentials plugin){

		int addexp;
		String skilltype = "Smithing";
		if(result.getType() == Material.WOOD_AXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Axe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.WOOD_HOE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Hoe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.WOOD_PICKAXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Pickaxe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.WOOD_SWORD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Sword");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.WOOD_SPADE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Spade");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.STONE_AXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Axe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.STONE_HOE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Hoe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.STONE_PICKAXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Pickaxe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.STONE_SWORD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Sword");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.STONE_SPADE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Spade");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.IRON_AXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Axe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.IRON_HOE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Hoe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.IRON_PICKAXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Pickaxe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.IRON_SWORD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Sword");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.IRON_SPADE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Spade");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_AXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Axe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_HOE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Hoe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_PICKAXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Pickaxe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_SWORD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Sword");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.GOLD_SPADE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Spade");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.DIAMOND_AXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Axe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.DIAMOND_HOE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Hoe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.DIAMOND_PICKAXE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Pickaxe");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.DIAMOND_SWORD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Sword");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		}else if(result.getType() == Material.DIAMOND_SPADE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Spade");
			LevelingSystem.addexp(player, skilltype, (addexp * amount), plugin);
		//ingot
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
