package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class OldStuffDeleter extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int x,y,z;
		for (y = 1; y < world.getMaxHeight(); ++y){
			for (x = 0; x < 16; ++x){
				for (z = 0; z < 16; ++z){
					Block block = world.getBlockAt(x, y, z);
					RpgEssentials.log.warning(block.getType().toString());
					if(block.getType().equals(Material.IRON_ORE) || block.getType().equals(Material.COAL_ORE) || block.getType().equals(Material.GOLD_ORE) || block.getType().equals(Material.REDSTONE_ORE) || block.getType().equals(Material.LAPIS_ORE) || block.getType().equals(Material.DIAMOND_ORE)){
						block.setType(Material.STONE);
					}else if(block.getType().equals(Material.LOG) || block.getType().equals(Material.LEAVES) || block.getType().equals(Material.VINE) || block.getType().equals(Material.RED_ROSE) || block.getType().equals(Material.YELLOW_FLOWER) || block.getType().equals(Material.LONG_GRASS) || block.getType().equals(Material.CACTUS) || block.getType().equals(Material.SUGAR_CANE) || block.getType().equals(Material.BROWN_MUSHROOM) || block.getType().equals(Material.RED_MUSHROOM) || block.getType().equals(Material.DEAD_BUSH) || block.getType().equals(Material.PUMPKIN) || block.getType().equals(Material.SNOW)){
						block.setType(Material.AIR);
					}
				}
			}
		}
	}
}
