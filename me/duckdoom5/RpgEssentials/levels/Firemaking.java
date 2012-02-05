package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Firemaking {
	static YamlConfiguration levelconfig = new YamlConfiguration();
	
	public static void check(ItemStack inhand, Block block, Player player, RpgEssentials plugin){
		try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		if(inhand.getType() == Material.FLINT_AND_STEEL){
			block = block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
			if(block.getType() != Material.FIRE){
				String skilltype = "Firemaking";
				int addexp = levelconfig.getInt("Exp." + skilltype + ".Ignite");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}
	}
}
