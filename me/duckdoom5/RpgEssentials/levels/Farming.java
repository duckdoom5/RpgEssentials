package me.duckdoom5.RpgEssentials.levels;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Farming {
	static YamlConfiguration levelconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	public static void blockcheck(Block block, Player player){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Farming";
		if(block.getType() == Material.YELLOW_FLOWER){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Yellow Flower.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.RED_ROSE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Rose.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.PUMPKIN){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pumpkin Block.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.PUMPKIN_STEM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pumpkin Stem.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.MELON_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Melon Block.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.MELON_STEM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Melon Stem.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.RED_MUSHROOM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Red Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.BROWN_MUSHROOM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Brown Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.HUGE_MUSHROOM_1){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Huge Red Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.HUGE_MUSHROOM_2){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Huge Brown Mushroom.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.LONG_GRASS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Tall Grass.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.WHEAT  && block.getData() == (byte) 0x07){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wheat.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.CACTUS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cacti.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.SUGAR_CANE_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sugar Cane.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.VINE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Vines.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.WATER_LILY){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Water Lily.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.LEAVES){//TODO data
			addexp = levelconfig.getInt("Exp." + skilltype + ".Leaves.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.DEAD_BUSH){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Dead Bush.Break");
			LevelingSystem.addexp(player, skilltype, addexp);
		}
		
	}

	public static void blockplacecheck(Block block, Player player) {
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int addexp;
		String skilltype = "Farming";
		if(block.getType() == Material.YELLOW_FLOWER){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Yellow Flower.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.RED_ROSE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Rose.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.PUMPKIN){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pumpkin Block.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.PUMPKIN_STEM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pumpkin Stem.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.MELON_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Melon Block.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.MELON_STEM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Melon Stem.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.RED_MUSHROOM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Red Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.BROWN_MUSHROOM){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Brown Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.HUGE_MUSHROOM_1){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Huge Red Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.HUGE_MUSHROOM_2){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Huge Brown Mushroom.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.LONG_GRASS){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Tall Grass.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.WHEAT && block.getData() == (byte) 0x07){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wheat.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.CACTUS){//TODO check blocks above
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cacti.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.SUGAR_CANE_BLOCK){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sugar Cane.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.VINE){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Vines.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.WATER_LILY){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Water Lily.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.LEAVES){//TODO data
			addexp = levelconfig.getInt("Exp." + skilltype + ".Leaves.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}else if(block.getType() == Material.DEAD_BUSH){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Dead Bush.Place");
			LevelingSystem.addexp(player, skilltype, addexp);
		}
	}
}
