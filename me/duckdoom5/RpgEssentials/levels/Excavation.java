package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Excavation {
	static YamlConfiguration levelconfig = new YamlConfiguration();
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Excavation";
		if(block.getType() == Material.DIRT){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Dirt");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GRASS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Grass");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CLAY){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Clay");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SAND){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sand");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SOIL){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Soil");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SOUL_SAND){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Soul Sand");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SNOW_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Snow Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SNOW){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Snow Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}

	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event) {
		if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_SPADE){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE || inhand.getType() == Material.DIAMOND_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if(inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE || inhand.getType() == Material.DIAMOND_SPADE){
			player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
			event.setCancelled(true);
		}
		
	}
}
