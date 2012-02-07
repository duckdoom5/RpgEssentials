package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Mining {
	static YamlConfiguration levelconfig = new YamlConfiguration();
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Mining";
		if(block.getType() == Material.STONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COAL_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Coal Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Lapis Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.REDSTONE_ORE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Redstone Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SANDSTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sandstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.OBSIDIAN){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Obsidian");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Lapis Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Iron Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Gold Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Diamond Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 0){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 1){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Sandstone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 3){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 4){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 5){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 0){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 1){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Sandstone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 3){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 4){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 5){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}
		}else if(block.getType() == Material.BRICK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MOSSY_COBBLESTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Mossy Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cobblestone Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_BRICK){
			//normal
			if(block.getData() == (byte) 0){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//mossy
			}else if(block.getData() == (byte) 1){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Mossy Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//cracked
			}else if(block.getData() == (byte) 2){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Cracked Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.NETHERRACK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Netherrack");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GLOWSTONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Glowstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Nether Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK_STAIRS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Nether Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENDER_STONE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".End Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event){
		if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_PICKAXE){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE || inhand.getType() == Material.DIAMOND_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if(inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE || inhand.getType() == Material.DIAMOND_PICKAXE){
			player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
			event.setCancelled(true);
		}
	}
}
