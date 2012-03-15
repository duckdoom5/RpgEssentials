package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Firemaking {
	
	public static void check(ItemStack inhand, Block block, Player player, RpgEssentials plugin){
		if(inhand != null){
			if(inhand.getType() == Material.FLINT_AND_STEEL){
				if(canplace(block)){
					block = block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
					if(block.getType() != Material.FIRE){
						String skilltype = "Firemaking";
						int addexp = Configuration.level.getInt("Exp." + skilltype + ".Ignite");
						LevelingSystem.addexp(player, skilltype, addexp, plugin);
					}
				}
			}
		}
	}

	private static boolean canplace(Block block) {
		Location oldloc = block.getLocation();
		Block blockabove = oldloc.getWorld().getBlockAt(oldloc.getBlockX(), oldloc.getBlockY() + 1, oldloc.getBlockZ());
		if(!blockabove.getType().equals(Material.AIR) || block.getType().equals(Material.STEP) || block.getType().equals(Material.TORCH) || block.getType().equals(Material.LEVER) || block.getType().equals(Material.REDSTONE_WIRE) || block.getType().equals(Material.CHEST) || block.getType().equals(Material.STONE_PLATE) || block.getType().equals(Material.WOOD_PLATE) || block.getType().equals(Material.STONE_BUTTON) || block.getType().equals(Material.REDSTONE_TORCH_OFF) || block.getType().equals(Material.REDSTONE_TORCH_ON)
				|| block.getType().equals(Material.SAPLING) || block.getType().equals(Material.BROWN_MUSHROOM) || block.getType().equals(Material.RED_MUSHROOM) || block.getType().equals(Material.YELLOW_FLOWER) || block.getType().equals(Material.RED_ROSE) || block.getType().equals(Material.SUGAR_CANE_BLOCK) || block.getType().equals(Material.CACTUS) || block.getType().equals(Material.CAKE_BLOCK) || block.getType().equals(Material.CAULDRON) || block.getType().equals(Material.IRON_FENCE) || block.getType().equals(Material.THIN_GLASS)
				|| block.getType().equals(Material.WEB) || block.getType().equals(Material.ICE) || block.getType().equals(Material.SNOW_BLOCK) || block.getType().equals(Material.SNOW) || block.getType().equals(Material.BREWING_STAND) || block.getType().equals(Material.FURNACE)  || block.getType().equals(Material.BED_BLOCK)  || block.getType().equals(Material.BURNING_FURNACE) || block.getType().equals(Material.DETECTOR_RAIL) || block.getType().equals(Material.POWERED_RAIL) || block.getType().equals(Material.RAILS) 
				|| block.getType().equals(Material.DIODE_BLOCK_OFF) || block.getType().equals(Material.DIODE_BLOCK_ON) || block.getType().equals(Material.DISPENSER) || block.getType().equals(Material.DRAGON_EGG) || block.getType().equals(Material.JUKEBOX) || block.getType().equals(Material.ENCHANTMENT_TABLE) || block.getType().equals(Material.SEEDS) || block.getType().equals(Material.FENCE_GATE) || block.getType().equals(Material.ENDER_PORTAL) || block.getType().equals(Material.ENDER_PORTAL_FRAME) || block.getType().equals(Material.PORTAL)
				|| block.getType().equals(Material.NETHER_FENCE) || block.getType().equals(Material.NETHER_WARTS) || block.getType().equals(Material.WOODEN_DOOR) || block.getType().equals(Material.IRON_DOOR_BLOCK)){
			return false;
		}
		return true;
	}
}
