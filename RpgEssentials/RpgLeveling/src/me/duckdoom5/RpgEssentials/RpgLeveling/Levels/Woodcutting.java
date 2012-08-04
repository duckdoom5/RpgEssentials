package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Woodcutting {
	private static Skill skill = Skill.MINING;
	private static String type = "axe";
	
	public static int getXp(Block block, Player player){
		if(block.getType() == Material.LOG){
			//normal log
			if(block.getData() == (byte) 0){
				return Configuration.level.getInt("Exp.Woodcutting.oak log");
			//redwood
			}else if(block.getData() == (byte) 1){
				return Configuration.level.getInt("Exp.Woodcutting.pine log");
			//birch
			}else if(block.getData() == (byte) 2){
				return Configuration.level.getInt("Exp.Woodcutting.birch log");
			//jungle
			}else if(block.getData() == (byte) 3){
				return Configuration.level.getInt("Exp.Woodcutting.jungle log");
			}
		}else if(block.getType() == Material.WOOD){
			//normal log
			if(block.getData() == (byte) 0){
				return Configuration.level.getInt("Exp.Woodcutting.oak wood");
			//redwood
			}else if(block.getData() == (byte) 1){
				return Configuration.level.getInt("Exp.Woodcutting.pine wood");
			//birch
			}else if(block.getData() == (byte) 2){
				return Configuration.level.getInt("Exp.Woodcutting.birch wood");
			//jungle
			}else if(block.getData() == (byte) 3){
				return Configuration.level.getInt("Exp.Woodcutting.jungle wood");
			}
		}else if(block.getType() == Material.STEP){
			if(block.getData() == (byte) 2){
				return Configuration.level.getInt("Exp.Woodcutting.wood step");
			}
		}else if(block.getType() == Material.DOUBLE_STEP){
			if(block.getData() == (byte) 2){
				return Configuration.level.getInt("Exp.Woodcutting.wood double step");
			}
		}else{
			return Configuration.level.getInt("Exp.Woodcutting." + block.getType().toString().toLowerCase().replace("_", " "));
		}
		return 0;
	}

	public static boolean isWoodcutting(Block block){
		if((block.getType() == Material.LOG) || (block.getType() == Material.WOOD) || (block.getType() == Material.WOOD_STAIRS) || (block.getType() == Material.FENCE) || ( (block.getType() == Material.STEP)&&(block.getData() == (byte) 2) ) || ( (block.getType() == Material.DOUBLE_STEP)&&(block.getData() == (byte) 2) ) ){
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
			
			if((currentlevel >= wood && currentlevel < stone) && inHand == Material.WOOD_AXE){
				return true;
			}else if((currentlevel >= stone && currentlevel < iron) && (inHand == Material.WOOD_AXE || inHand == Material.STONE_AXE)){
				return true;
			}else if((currentlevel >= iron && currentlevel < gold) && (inHand == Material.WOOD_AXE || inHand == Material.STONE_AXE || inHand == Material.IRON_AXE)){
				return true;
			}else if((currentlevel >= gold && currentlevel < diamond) && (inHand == Material.WOOD_AXE || inHand == Material.STONE_AXE || inHand == Material.IRON_AXE || inHand == Material.GOLD_AXE)){
				return true;
			}else if(currentlevel >= diamond && (inHand == Material.WOOD_AXE || inHand == Material.STONE_AXE || inHand == Material.IRON_AXE || inHand == Material.GOLD_AXE || inHand == Material.DIAMOND_AXE)){
				return true;
			}else if(inHand != Material.AIR){
				if(inHand == Material.WOOD_AXE || inHand == Material.STONE_AXE || inHand == Material.IRON_AXE || inHand == Material.GOLD_AXE || inHand == Material.DIAMOND_AXE){
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
