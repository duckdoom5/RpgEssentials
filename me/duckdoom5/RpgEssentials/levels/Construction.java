package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Construction {
	static YamlConfiguration levelconfig = new YamlConfiguration();

	public static void blockplacecheck(Block block, Player player, RpgEssentials plugin) {
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Construction";
		if(block.getType() == Material.STONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LOG){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Log");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GLASS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Glass");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Lapis Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DISPENSER){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Dispenser");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SANDSTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sandstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NOTE_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Noteblock");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BED){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Bed");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PISTON_STICKY_BASE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sticky Piston");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PISTON_BASE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Piston");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOL){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wool");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_BLOCK){//TODO check blocks above
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron  Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.STEP){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Slab");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Bricks");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BOOKSHELF){//TODO data
			addexp = levelconfig.getInt("Exp." + skilltype + ".Bookshelf");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MOSSY_COBBLESTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Mossy Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.OBSIDIAN){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Obsidian");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WOOD_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wooden Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CHEST){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Chest");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WORKBENCH){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Workbench");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.FURNACE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Furnace");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.JUKEBOX){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Jukebox");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.FENCE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Jukebox");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_BRICK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_FENCE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Bars");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.THIN_GLASS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Glass Pane");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Nether Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Nether Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_FENCE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Nether Fence");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENCHANTMENT_TABLE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Enchantment Table");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENDER_STONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Ender Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
}
