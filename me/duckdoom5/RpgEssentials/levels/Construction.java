package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Construction {
	public static void blockplacecheck(Block block, Player player, RpgEssentials plugin) {

		int addexp;
		String skilltype = "Construction";
		if(block.getType() == Material.STONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LOG){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Log");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GLASS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Glass");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Lapis Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DISPENSER){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Dispenser");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SANDSTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sandstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NOTE_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Noteblock");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BED){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Bed");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PISTON_STICKY_BASE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sticky Piston");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PISTON_BASE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Piston");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOL){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wool");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_BLOCK){//TODO check blocks above
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron  Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.STEP){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Slab");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Bricks");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BOOKSHELF){//TODO data
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Bookshelf");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MOSSY_COBBLESTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Mossy Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.OBSIDIAN){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Obsidian");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOD_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wooden Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CHEST){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Chest");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WORKBENCH){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Workbench");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.FURNACE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Furnace");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.JUKEBOX){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Jukebox");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.FENCE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Jukebox");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_BRICK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_FENCE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Bars");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.THIN_GLASS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Glass Pane");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Nether Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Nether Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_FENCE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Nether Fence");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENCHANTMENT_TABLE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Enchantment Table");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENDER_STONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Ender Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
}
