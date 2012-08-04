package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Excavation {
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){
		int addexp;
		String skilltype = "Excavation";
		if(block.getType() == Material.DIRT){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Dirt");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GRASS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Grass");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CLAY){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Clay");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SAND){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sand");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SOIL){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SOUL_SAND){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Soul Sand");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SNOW_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Snow Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SNOW){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Snow Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}

	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event) {
		if((currentlevel >= Configuration.level.getInt("UnlockLevel.Wood Spade") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Spade")) && inhand.getType() == Material.WOOD_SPADE){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Spade") && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Spade")) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Spade") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Spade")) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Spade") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Spade")) && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Spade") && (inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE || inhand.getType() == Material.DIAMOND_SPADE)){
			Excavation.blockcheck(block, player, plugin);
		}else if(inhand != null){
			if(inhand.getType() == Material.WOOD_SPADE || inhand.getType() == Material.STONE_SPADE || inhand.getType() == Material.IRON_SPADE || inhand.getType() == Material.GOLD_SPADE || inhand.getType() == Material.DIAMOND_SPADE){
				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
				event.setCancelled(true);
			}
		}
		
	}
}
