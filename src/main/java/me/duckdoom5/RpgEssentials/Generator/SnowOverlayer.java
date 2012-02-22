package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class SnowOverlayer extends BlockPopulator {

	@Override
	public void populate(World world, Random rand, Chunk chunk) {
		int x,y,z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
				//snow on snow biomes
				block = chunk.getBlock(x, y, z);
				if((block.getBiome() == Biome.FROZEN_OCEAN) || (block.getBiome() == Biome.FROZEN_RIVER) || (block.getBiome() == Biome.ICE_DESERT) || (block.getBiome() == Biome.ICE_MOUNTAINS) || (block.getBiome() == Biome.ICE_PLAINS) || (block.getBiome() == Biome.TUNDRA) || (block.getBiome() == Biome.EXTREME_HILLS)){
					if((block.getType() == Material.RED_ROSE) || (block.getType() == Material.YELLOW_FLOWER) || (block.getType() == Material.LONG_GRASS) || (block.getType() == Material.CACTUS) || (block.getType() == Material.SUGAR_CANE_BLOCK)){
					} else if((block.getType() == Material.STATIONARY_WATER) || (block.getType() == Material.WATER)){
						block.setType(Material.ICE);
					} else {
					block = chunk.getBlock(x, y + 1, z);
					block.setType(Material.SNOW);
					}
				}
			}
		}
	}
}
