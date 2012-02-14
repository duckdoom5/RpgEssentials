package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Woodcutting {
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){
		int addexp;
		String skilltype = "Woodcutting";
		if(block.getType() == Material.LOG){
			//normal log
			if(block.getData() == (byte) 0){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Oak Log");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//redwood
			}else if(block.getData() == (byte) 1){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Redwood Log");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//birch
			}else if(block.getData() == (byte) 2){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Birch Log");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.WOOD){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.FENCE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Fence");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 2){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 2){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}
		}else if(block.getType() == Material.WOOD_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wood Stairs");
			LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
		}
	}

	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event) {
		
		if((currentlevel > Configuration.level.getInt("UnlockLevel.Wood Axe") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Axe")) && inhand.getType() == Material.WOOD_AXE){
			Woodcutting.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Axe") || Bukkit.getPluginManager().getPlugin("WorldGuard").isEnabled() && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Axe")) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE)){
			Woodcutting.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Axe") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Axe")) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE)){
			Woodcutting.blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Axe") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Axe")) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE)){
			Woodcutting.blockcheck(block, player, plugin);
		}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Axe") && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE)){
			Woodcutting.blockcheck(block, player, plugin);
		}else if(inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
			player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
			event.setCancelled(true);
		}
		
	}
}
