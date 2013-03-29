package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Mining {
	private static Skill skill = Skill.MINING;
	private static String type = "pickaxe";
	
	public static int getXp(Block block, Player player){
		if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 0){
				return Configuration.level.getInt("Exp.Mining.stone slab");
			}else if(block.getData() == (byte) 1){
				return Configuration.level.getInt("Exp.Mining.sandstone slab");
			}else if(block.getData() == (byte) 3){
				return Configuration.level.getInt("Exp.Mining.cobblestone slab");
			}else if(block.getData() == (byte) 4){
				return Configuration.level.getInt("Exp.Mining.brick slab");
			}else if(block.getData() == (byte) 5){
				return Configuration.level.getInt("Exp.Mining.stone brick slab");
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 0){
				return Configuration.level.getInt("Exp.Mining.stone slab") * 2;
			}else if(block.getData() == (byte) 1){
				return Configuration.level.getInt("Exp.Mining.sandstone slab") * 2;
			}else if(block.getData() == (byte) 3){
				return Configuration.level.getInt("Exp.Mining.cobblestone slab") * 2;
			}else if(block.getData() == (byte) 4){
				return Configuration.level.getInt("Exp.Mining.brick slab") * 2;
			}else if(block.getData() == (byte) 5){
				return Configuration.level.getInt("Exp.Mining.stone brick slab") * 2;
			}
		}else if(block.getType() == Material.SMOOTH_BRICK){
			//normal
			if(block.getData() == (byte) 0){
				return Configuration.level.getInt("Exp.Mining.stone brick");
			//mossy
			}else if(block.getData() == (byte) 1){
				return Configuration.level.getInt("Exp.Mining.mossy stone brick");
			//cracked
			}else if(block.getData() == (byte) 2){
				return Configuration.level.getInt("Exp.Mining.cracked stone brick");
			}
		}else{
			return Configuration.level.getInt("Exp.Mining." + block.getType().toString().toLowerCase().replace("_", " "));
		}
		return 0;
	}
	
	public static boolean isMining(Block block){
		if((block.getType() == Material.STONE) || (block.getType() == Material.COBBLESTONE) || (block.getType() == Material.MOSSY_COBBLESTONE) || (block.getType() == Material.COBBLESTONE_STAIRS) || (block.getType() == Material.SMOOTH_BRICK) || (block.getType() == Material.SMOOTH_STAIRS) || (block.getType() == Material.BRICK) || (block.getType() == Material.ENDER_STONE) || (block.getType() == Material.BRICK_STAIRS) || (block.getType() == Material.IRON_BLOCK) || (block.getType() == Material.DIAMOND_BLOCK) || (block.getType() == Material.LAPIS_BLOCK) || (block.getType() == Material.GOLD_BLOCK) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.COAL_ORE) || (block.getType() == Material.IRON_ORE) || (block.getType() == Material.GOLD_ORE) || (block.getType() == Material.LAPIS_ORE) || (block.getType() == Material.OBSIDIAN) || (block.getType() == Material.NETHERRACK) || (block.getType() == Material.GLOWSTONE) || (block.getType() == Material.NETHER_BRICK) || (block.getType() == Material.NETHER_BRICK_STAIRS) || (block.getType() == Material.REDSTONE_ORE) || (block.getType() == Material.DIAMOND_ORE) || ( (block.getType() == Material.STEP)&&(block.getData() != (byte) 2) ) || ( (block.getType() == Material.DOUBLE_STEP)&&(block.getData() != (byte) 2) ) ){
			return true;
		}
		return false;
	}
	
	public static boolean canUse(RpgPlayer player){
		if(((Player)player.getPlayer()).getGameMode() == GameMode.SURVIVAL){
			Material inHand = ((Player)player.getPlayer()).getItemInHand().getType();
			int currentlevel = player.getLvl(skill);
			int wood = Configuration.level.getInt("UnlockLevel.wood " + type);
			int stone = Configuration.level.getInt("UnlockLevel.stone " + type);
			int iron = Configuration.level.getInt("UnlockLevel.iron " + type);
			int gold = Configuration.level.getInt("UnlockLevel.gold " + type);
			int diamond = Configuration.level.getInt("UnlockLevel.diamond " + type);
			
			if((currentlevel >= wood && currentlevel < stone) && inHand == Material.WOOD_PICKAXE){
				return true;
			}else if((currentlevel >= stone && currentlevel < iron) && (inHand == Material.WOOD_PICKAXE || inHand == Material.STONE_PICKAXE)){
				return true;
			}else if((currentlevel >= iron && currentlevel < gold) && (inHand == Material.WOOD_PICKAXE || inHand == Material.STONE_PICKAXE || inHand == Material.IRON_PICKAXE)){
				return true;
			}else if((currentlevel >= gold && currentlevel < diamond) && (inHand == Material.WOOD_PICKAXE || inHand == Material.STONE_PICKAXE || inHand == Material.IRON_PICKAXE || inHand == Material.GOLD_PICKAXE)){
				return true;
			}else if(currentlevel >= diamond && (inHand == Material.WOOD_PICKAXE || inHand == Material.STONE_PICKAXE || inHand == Material.IRON_PICKAXE || inHand == Material.GOLD_PICKAXE || inHand == Material.DIAMOND_PICKAXE)){
				return true;
			}else if(inHand != Material.AIR){
				if(inHand == Material.WOOD_PICKAXE || inHand == Material.STONE_PICKAXE || inHand == Material.IRON_PICKAXE || inHand == Material.GOLD_PICKAXE || inHand == Material.DIAMOND_PICKAXE){
					((Player)player.getPlayer()).sendMessage(ChatColor.RED + "You only use a " + inHand.toString().toLowerCase().replace("_", " ") + " on level " + Configuration.level.getInt("UnlockLevel." + inHand.toString().toLowerCase().replace("_", " ")));
					((Player)player.getPlayer()).getItemInHand().setDurability((short) (((Player)player.getPlayer()).getItemInHand().getDurability() + 1));
					return false;
				}
				return true;
			}else{
				return true;
			}
		}
		return true;
	}
	
	public static boolean canMine(Block block, RpgPlayer player){
		if(Configuration.level.contains("UnlockLevel." + block.getType().toString().toLowerCase().replace("_", " ")) && ((Player)player.getPlayer()).getGameMode() == GameMode.SURVIVAL){
			String skilltype = "Mining";
			int currentlevel = player.getLvl(skill);
			if(currentlevel >= Configuration.level.getInt("UnlockLevel." + block.getType().toString().toLowerCase().replace("_", " "))){
				return true;
			}
			((Player)player.getPlayer()).sendMessage(ChatColor.RED + "You can only break " + block.getType().toString().toLowerCase().replace("_", " ") + " on level " + Configuration.level.getInt("UnlockLevel." + block.getType().toString().toLowerCase().replace("_", " ")));
			return false;
		}
		return true;
	}
}
