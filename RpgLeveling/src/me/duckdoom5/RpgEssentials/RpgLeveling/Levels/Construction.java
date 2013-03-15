package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Construction {
	private static Skill skill = Skill.CONSTRUCTION;
	public static int getXp(Block block, Player player, RpgLeveling plugin) {
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			return Configuration.level.getInt("Exp.Construction." + block.getType().toString().toLowerCase().replace("_", " "));
		}
		return 0;
	}
	
	public static boolean isConstruction(Block block){
		if((block.getType() == Material.LOG) || (block.getType() == Material.GLASS) || (block.getType() == Material.DISPENSER) || (block.getType() == Material.NOTE_BLOCK) || (block.getType() == Material.BED) || (block.getType() == Material.PISTON_STICKY_BASE) || (block.getType() == Material.PISTON_BASE) || (block.getType() == Material.WOOL) || (block.getType() == Material.BOOKSHELF) || (block.getType() == Material.CHEST) || (block.getType() == Material.WORKBENCH) || (block.getType() == Material.FURNACE) || (block.getType() == Material.JUKEBOX) || (block.getType() == Material.FENCE) || (block.getType() == Material.THIN_GLASS) || (block.getType() == Material.IRON_FENCE) || (block.getType() == Material.ENCHANTMENT_TABLE) || (block.getType() == Material.WOOD) || (block.getType() == Material.WOOD_STAIRS) || (block.getType() == Material.FENCE) || (block.getType() == Material.STONE) || (block.getType() == Material.COBBLESTONE) || (block.getType() == Material.MOSSY_COBBLESTONE) || (block.getType() == Material.COBBLESTONE_STAIRS) || (block.getType() == Material.SMOOTH_BRICK) || (block.getType() == Material.SMOOTH_STAIRS) || (block.getType() == Material.BRICK) || (block.getType() == Material.ENDER_STONE) || (block.getType() == Material.BRICK_STAIRS) || (block.getType() == Material.IRON_BLOCK) || (block.getType() == Material.DIAMOND_BLOCK) || (block.getType() == Material.LAPIS_BLOCK) || (block.getType() == Material.GOLD_BLOCK) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.OBSIDIAN) || (block.getType() == Material.NETHER_BRICK) || (block.getType() == Material.NETHER_FENCE) || (block.getType() == Material.NETHER_BRICK_STAIRS) || (block.getType() == Material.STEP) || (block.getType() == Material.DOUBLE_STEP)){
			return true;
		}
		return false;
	}
}
