package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Mining {
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){
		int addexp;
		String skilltype = "Mining";
		if(block.getType() == Material.STONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COAL_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Coal Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Lapis Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.REDSTONE_ORE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Redstone Ore");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SANDSTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sandstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.OBSIDIAN){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Obsidian");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LAPIS_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Lapis Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.IRON_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Iron Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GOLD_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Gold Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DIAMOND_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Diamond Block");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 0){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 1){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Sandstone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 3){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 4){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(block.getData() == (byte) 5){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 0){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 1){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Sandstone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 3){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 4){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}else if(block.getData() == (byte) 5){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick Slab");
				LevelingSystem.addexp(player, skilltype, addexp + 5, plugin);
			}
		}else if(block.getType() == Material.BRICK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MOSSY_COBBLESTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Mossy Cobblestone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BRICK_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.COBBLESTONE_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cobblestone Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SMOOTH_BRICK){
			//normal
			if(block.getData() == (byte) 0){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//mossy
			}else if(block.getData() == (byte) 1){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Mossy Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			//cracked
			}else if(block.getData() == (byte) 2){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Cracked Stone Brick");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}else if(block.getType() == Material.NETHERRACK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Netherrack");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.GLOWSTONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Glowstone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Nether Brick");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.NETHER_BRICK_STAIRS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Nether Brick Stairs");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.ENDER_STONE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".End Stone");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
	public static void canuse(int currentlevel, Block block, Player player, RpgEssentials plugin, ItemStack inhand, BlockBreakEvent event){
		if((currentlevel > Configuration.level.getInt("UnlockLevel.Wood Pickaxe") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Pickaxe")) && inhand.getType() == Material.WOOD_PICKAXE){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Pickaxe") && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Pickaxe")) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Pickaxe") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Pickaxe")) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Pickaxe") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Pickaxe")) && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Pickaxe") && (inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE || inhand.getType() == Material.DIAMOND_PICKAXE)){
			blockcheck(block, player, plugin);
		}else if(inhand.getType() == Material.WOOD_PICKAXE || inhand.getType() == Material.STONE_PICKAXE || inhand.getType() == Material.IRON_PICKAXE || inhand.getType() == Material.GOLD_PICKAXE || inhand.getType() == Material.DIAMOND_PICKAXE){
			player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
			event.setCancelled(true);
		}
	}
}
