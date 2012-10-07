package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Excavation {
	private static Skill skill = Skill.EXCAVATION;
	private static String type = "spade";
	
	public static int getXp(Block block){
		return Configuration.level.getInt("Exp.Excavation." + block.getType().toString().toLowerCase().replace("_", " "));
	}

	public static boolean isExcavation(Block block){
		if((block.getType() == Material.DIRT) || (block.getType() == Material.GRASS) || (block.getType() == Material.CLAY) || (block.getType() == Material.SAND) || (block.getType() == Material.GRAVEL) || (block.getType() == Material.SOUL_SAND) || (block.getType() == Material.SOIL) || (block.getType() == Material.SNOW_BLOCK) || (block.getType() == Material.SNOW)){
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
			
			if((currentlevel >= wood && currentlevel < stone) && inHand == Material.WOOD_SPADE){
				return true;
			}else if((currentlevel >= stone && currentlevel < iron) && (inHand == Material.WOOD_SPADE || inHand == Material.STONE_SPADE)){
				return true;
			}else if((currentlevel >= iron && currentlevel < gold) && (inHand == Material.WOOD_SPADE || inHand == Material.STONE_SPADE || inHand == Material.IRON_SPADE)){
				return true;
			}else if((currentlevel >= gold && currentlevel < diamond) && (inHand == Material.WOOD_SPADE || inHand == Material.STONE_SPADE || inHand == Material.IRON_SPADE || inHand == Material.GOLD_SPADE)){
				return true;
			}else if(currentlevel >= diamond && (inHand == Material.WOOD_SPADE || inHand == Material.STONE_SPADE || inHand == Material.IRON_SPADE || inHand == Material.GOLD_SPADE || inHand == Material.DIAMOND_SPADE)){
				return true;
			}else if(inHand != Material.AIR){
				if(inHand == Material.WOOD_SPADE || inHand == Material.STONE_SPADE || inHand == Material.IRON_SPADE || inHand == Material.GOLD_SPADE || inHand == Material.DIAMOND_SPADE){
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
