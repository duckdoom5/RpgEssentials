package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class BiomesPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int x,y,z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				
				
				//dirt bottom
			    
				for (y = 63; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
			    block = chunk.getBlock(x,y,z);
			    if(block.getType() == Material.GRASS){
			    	block.setType(Material.DIRT);
			    }
			    
			    //desert
			    
			    for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
				block =chunk.getBlock(x, y, z);
				if((block.getBiome() == Biome.DESERT) || (block.getBiome() == Biome.SHRUBLAND) || (block.getBiome() == Biome.ICE_DESERT)){
					if((block.getType() == Material.GRASS) || (block.getType() == Material.SAND)){
						for (int a = 0; a <= 5; ++a){
							block.setType(Material.SAND);
							block = chunk.getBlock(x, y - a, z);
						}
						block.setType(Material.SANDSTONE);
					}
				}
				
				//beach
				
				for (y = 65; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
			    block = chunk.getBlock(x,y,z);
			    if(block.getType() == Material.GRASS){
			    	for (int a = 0; a <= 5; ++a){
						block.setType(Material.SAND);
						block = chunk.getBlock(x, y - a, z);
					}
					block.setType(Material.SANDSTONE);
			    }
			    
				    
				//sea
				    
				for (y = 64; chunk.getBlock(x,y,z).getType() == Material.AIR;){
					block = chunk.getBlock(x,y,z);
					block.setType(Material.STATIONARY_WATER);
					--y;
				}
			}
		}
	}

}
