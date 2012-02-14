package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Firemaking {
	
	public static void check(ItemStack inhand, Block block, Player player, RpgEssentials plugin){
		if(inhand.getType() == Material.FLINT_AND_STEEL){
			block = block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
			if(block.getType() != Material.FIRE){
				String skilltype = "Firemaking";
				int addexp = Configuration.level.getInt("Exp." + skilltype + ".Ignite");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}
	}
}
