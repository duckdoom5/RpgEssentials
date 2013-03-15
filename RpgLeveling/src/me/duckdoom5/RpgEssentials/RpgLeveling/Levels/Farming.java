package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Farming {
	
	public static int getBreakXp(Block block){
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			return Configuration.level.getInt("Exp.Farming." + block.getType().toString().toLowerCase().replace("_", " ") + ".Break");
		}
		return 0;
	}
	
	public static int getPlaceXp(Block block) {
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			return Configuration.level.getInt("Exp.Farming." + block.getType().toString().toLowerCase().replace("_", " ") + ".Place");
		}
		return 0;
	}
	
	public static int getSoilXp(Material tool){
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			int exp = Configuration.level.getInt("Exp.Farming.Soil.Create");
		    if(tool.equals(Material.WOOD_HOE)){
		    	return exp;
		    }else if(tool.equals(Material.STONE_HOE)){
				return exp+=1;
			}else if(tool.equals(Material.IRON_HOE)){
				return exp+=2;
			}else if(tool.equals(Material.GOLD_HOE)){
				return exp+=3;
			}else if(tool.equals(Material.DIAMOND_HOE)){
				return exp+=4;
			}
		}
		return 0;
	}
	
	public static boolean isFarming(Block block){
		if((block.getType() == Material.YELLOW_FLOWER) || (block.getType() == Material.RED_ROSE)  || (block.getType() == Material.CACTUS) || (block.getType() == Material.PUMPKIN) || (block.getType() == Material.PUMPKIN_STEM) || (block.getType() == Material.MELON_BLOCK) || (block.getType() == Material.PUMPKIN_STEM) || (block.getType() == Material.RED_MUSHROOM) || (block.getType() == Material.BROWN_MUSHROOM) || (block.getType() == Material.HUGE_MUSHROOM_1) || (block.getType() == Material.HUGE_MUSHROOM_2) || (block.getType() == Material.LONG_GRASS) || (block.getType() == Material.getMaterial(59)) || (block.getType() == Material.VINE) || (block.getType() == Material.WATER_LILY) || (block.getType() == Material.LEAVES) || (block.getType() == Material.DEAD_BUSH)){
			return true;
		}
		return false;
	}
	
	private static Skill skill = Skill.FARMING;
	private static String type = "hoe";
	
	public static boolean canUse(RpgPlayer player){
		if(((Player)player.getPlayer()).getGameMode() == GameMode.SURVIVAL && Configuration.level.getBoolean("Enabled." + skill.toString())){
			Material inHand = ((Player)player.getPlayer()).getItemInHand().getType();
			int currentlevel = player.getLvl(skill);
			int wood = Configuration.level.getInt("UnlockLevel.wood " + type);
			int stone = Configuration.level.getInt("UnlockLevel.stone " + type);
			int iron = Configuration.level.getInt("UnlockLevel.iron " + type);
			int gold = Configuration.level.getInt("UnlockLevel.gold " + type);
			int diamond = Configuration.level.getInt("UnlockLevel.diamond " + type);
			
			if((currentlevel >= wood && currentlevel < stone) && inHand == Material.WOOD_HOE){
				return true;
			}else if((currentlevel >= stone && currentlevel < iron) && (inHand == Material.WOOD_HOE || inHand == Material.STONE_HOE)){
				return true;
			}else if((currentlevel >= iron && currentlevel < gold) && (inHand == Material.WOOD_HOE || inHand == Material.STONE_HOE || inHand == Material.IRON_HOE)){
				return true;
			}else if((currentlevel >= gold && currentlevel < diamond) && (inHand == Material.WOOD_HOE || inHand == Material.STONE_HOE || inHand == Material.IRON_HOE || inHand == Material.GOLD_HOE)){
				return true;
			}else if(currentlevel >= diamond && (inHand == Material.WOOD_HOE || inHand == Material.STONE_HOE || inHand == Material.IRON_HOE || inHand == Material.GOLD_HOE || inHand == Material.DIAMOND_HOE)){
				return true;
			}else if(inHand != Material.AIR){
				if(inHand == Material.WOOD_HOE || inHand == Material.STONE_HOE || inHand == Material.IRON_HOE || inHand == Material.GOLD_HOE || inHand == Material.DIAMOND_HOE){
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
}
