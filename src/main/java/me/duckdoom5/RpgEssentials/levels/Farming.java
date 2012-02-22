package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Farming {
	
	public static void blockcheck(Block block, Player player, RpgEssentials plugin){

		int addexp;
		String skilltype = "Farming";
		if(block.getType() == Material.YELLOW_FLOWER){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Yellow Flower.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.RED_ROSE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Rose.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PUMPKIN){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pumpkin Block.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PUMPKIN_STEM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pumpkin Stem.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MELON_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Melon Block.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MELON_STEM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Melon Stem.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.RED_MUSHROOM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Red Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BROWN_MUSHROOM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Brown Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.HUGE_MUSHROOM_1){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Huge Red Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.HUGE_MUSHROOM_2){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Huge Brown Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LONG_GRASS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Tall Grass.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WHEAT  && block.getData() == (byte) 0x07){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wheat.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CACTUS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cacti.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SUGAR_CANE_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sugar Cane.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.VINE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Vines.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WATER_LILY){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Water Lily.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LEAVES){//TODO data
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Leaves.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DEAD_BUSH){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Dead Bush.Break");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
		
	}

	static int addexp;
	public static void soil(Block block, Player player, ItemStack inhand, RpgEssentials plugin, PlayerInteractEvent event){
		if(block.getType() == Material.GRASS || block.getType() == Material.DIRT){
			String skilltype = "Farming";
			int currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
			if((currentlevel >= Configuration.level.getInt("UnlockLevel.Wood Hoe") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Hoe")) && inhand.getType() == Material.WOOD_HOE){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil.Create");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Hoe") && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Hoe")) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE)){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil.Create");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Hoe") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Hoe")) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE)){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil.Create");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Hoe") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Hoe")) && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE)){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil.Create");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Hoe") && (inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE)){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Soil.Create");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}else if(inhand != null){
				if(inhand.getType() == Material.WOOD_HOE || inhand.getType() == Material.STONE_HOE || inhand.getType() == Material.IRON_HOE || inhand.getType() == Material.GOLD_HOE || inhand.getType() == Material.DIAMOND_HOE){
					player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
					event.setCancelled(true);
				}
    		}
		}
	}
	
	public static void blockplacecheck(Block block, Player player, RpgEssentials plugin) {
		int addexp;
		String skilltype = "Farming";
		if(block.getType() == Material.YELLOW_FLOWER){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Yellow Flower.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.RED_ROSE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Rose.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PUMPKIN){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pumpkin Block.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.PUMPKIN_STEM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pumpkin Stem.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MELON_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Melon Block.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.MELON_STEM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Melon Stem.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.RED_MUSHROOM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Red Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.BROWN_MUSHROOM){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Brown Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.HUGE_MUSHROOM_1){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Huge Red Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.HUGE_MUSHROOM_2){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Huge Brown Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LONG_GRASS){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Tall Grass.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WHEAT && block.getData() == (byte) 0x07){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wheat.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.CACTUS){//TODO check blocks above
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cacti.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.SUGAR_CANE_BLOCK){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sugar Cane.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.VINE){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Vines.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.WATER_LILY){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Water Lily.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.LEAVES){//TODO data
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Leaves.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}else if(block.getType() == Material.DEAD_BUSH){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Dead Bush.Place");
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
}
