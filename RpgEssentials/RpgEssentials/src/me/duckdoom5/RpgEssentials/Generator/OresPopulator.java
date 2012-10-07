package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.customblocks.CustomOre;
import me.duckdoom5.RpgEssentials.customblocks.OriginalOre;
import me.duckdoom5.RpgEssentials.util.MaterialManager;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.block.SpoutChunk;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class OresPopulator extends BlockPopulator {
	private boolean cmorelogged = false;
	private boolean orelogged = false;
	private boolean generateOriginal;
	public OresPopulator(Boolean generateOriginal){
		this.generateOriginal = generateOriginal;
	}
	
	public void populate(World world, Random random, Chunk chunk) {
		int freq, maxY, minY, size;
		Material material;
		
		if(generateOriginal){
			if(Configuration.generator.getBoolean("Generator.Ores.Original")){
				for (OriginalOre block:MaterialManager.originalores){
					freq = block.getfreq();
					minY = block.getminY();
					maxY = block.getmaxY();
					size = block.getSize();
					for (int j = 0; j < freq; j++) {
						int x = chunk.getX() * 16 + random.nextInt(16);
						int y = random.nextInt(maxY - minY) + minY;
						int z = chunk.getZ() * 16 + random.nextInt(16);
						
						Block cur_block = world.getBlockAt(x, y, z);
						Chunk cur_chunk = Bukkit.getServer().getWorld(world.getName()).getChunkAt(cur_block);
						
						int cur_x = (random.nextInt(2) - 1) + x;
						int cur_y = (random.nextInt(2) - 1) + y;
						int cur_z = (random.nextInt(2) - 1) + z;
						
						for (int s = 0; s < random.nextInt(size); s++) {
							cur_x = (random.nextInt(2) - 1) + cur_x;
							cur_y = (random.nextInt(2) - 1) + cur_y;
							cur_z = (random.nextInt(2) - 1) + cur_z;
							
							cur_block = cur_chunk.getBlock(cur_x, cur_y, cur_z);
							if (cur_block.getType() == Material.STONE) {
								cur_block.setType(block.getmaterial());
							}
						}
					}
				}
			}else {
				if(orelogged == false){
					RpgEssentials.log.info("[RpgEssentials] Original ores generation disabled");
					orelogged = true;
				}
			}
		}
		
		if(Configuration.generator.getBoolean("Generator.Ores.Custom")){
			for (GenericCustomBlock block:RpgEssentials.mm.getOres()) {
				CustomOre ore = (CustomOre)block;
				freq = ore.getFreq();
				minY = ore.getMinY();
				maxY = ore.getMaxY();
				size = ore.getSize();
				for (int j = 0; j < freq; j++) {
					int x = chunk.getX() * 16 + random.nextInt(16);
					int y = random.nextInt(maxY - minY) + minY;
					int z = chunk.getZ() * 16 + random.nextInt(16);
					
					Block cur_block = world.getBlockAt(x, y, z);
					SpoutChunk cur_chunk = Spout.getServer().getWorld(world.getName()).getChunkAt(cur_block);
					
					int cur_x = (random.nextInt(2) - 1) + x;
					int cur_y = (random.nextInt(2) - 1) + y;
					int cur_z = (random.nextInt(2) - 1) + z;
					
					for (int s = 0; s < random.nextInt(size); s++) {
						cur_x = (random.nextInt(2) - 1) + cur_x;
						cur_y = (random.nextInt(2) - 1) + cur_y;
						cur_z = (random.nextInt(2) - 1) + cur_z;
						
						cur_block = cur_chunk.getBlock(cur_x, cur_y, cur_z);
						if (cur_block.getType() == Material.STONE) {
							cur_chunk.setCustomBlock(cur_x, cur_y, cur_z, ore);
						}
					}
				}
			}
		} else {
			if(cmorelogged == false){
				RpgEssentials.log.info("[RpgEssentials] Custom ores generation disabled");
				cmorelogged = true;
			}
		}
	}
}
