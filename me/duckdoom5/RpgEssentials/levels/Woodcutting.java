package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Woodcutting {
	static YamlConfiguration levelconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	public static void blockcheck(Block block, Player player){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Woodcutting";
		if(block.getType() == Material.LOG){
			//normal log
			if(block.getData() == (byte) 0){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Oak log");
				LevelingSystem.addexp(player, skilltype, addexp);
			//redwood
			}else if(block.getData() == (byte) 1){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Redwood log");
				LevelingSystem.addexp(player, skilltype, addexp);
			//birch
			}else if(block.getData() == (byte) 2){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Birch log");
				LevelingSystem.addexp(player, skilltype, addexp);
			}
		}else if(block.getType() == Material.WOOD){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.FENCE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Fence");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 2){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Slab");
				LevelingSystem.addexp(player, skilltype, addexp);
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 2){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5);
			}
		}else if(block.getType() == Material.WOOD_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wood Stairs");
			LevelingSystem.addexp(player, skilltype, addexp + 5);
		}
	}

	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event) {
		if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_AXE){
			Woodcutting.blockcheck(block, player);
		}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE)){
			Woodcutting.blockcheck(block, player);
		}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE)){
			Woodcutting.blockcheck(block, player);
		}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE)){
			Woodcutting.blockcheck(block, player);
		}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE)){
			Woodcutting.blockcheck(block, player);
		}else if(inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
			player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
			event.setCancelled(true);
		}
		
	}
}
