package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOres;
import me.duckdoom5.RpgEssentials.blocks.ores.OriginalOres;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.getspout.spoutapi.Spout;

public class OresPopulator extends BlockPopulator {
	private RpgEssentials plugin;
	
	private boolean cmorelogged = false;
	private boolean orelogged = false;
	
	public OresPopulator(RpgEssentials plugin) {
		this.plugin = plugin;
	}

	public void populate(World world, Random random, Chunk chunk) {
		int freq, maxY, minY;
		Material material;
		
		if(Configuration.generator.getBoolean("Generator.Ores.Custom") == true){
			for (CustomOres block:Hashmaps.customores) {
				freq = block.getFreq();
				minY = block.getMinY();
				maxY = block.getMaxY();
				runcustom(freq,minY,maxY,random,world,chunk,block);
			}
		} else {
			if(cmorelogged == false){
				RpgEssentials.log.info("[RpgEssentials]Custom ores generation disabled");
				cmorelogged = true;
			}
		}
		
		if(Configuration.generator.getBoolean("Generator.Ores.Original") == true){
			for (OriginalOres block:Hashmaps.originalores){
				freq = block.getfreq();
				minY = block.getminY();
				maxY = block.getmaxY();
				material = block.getmaterial();
				run(freq, minY, maxY, random, world, chunk, material);
				
			}
		}else {
			if(orelogged == false){
				RpgEssentials.log.info("[RpgEssentials]Original ores generation disabled");
				orelogged = true;
			}
		}
		
		int x,y,z;
		Block block;
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				//random bedrock
				if(random.nextInt(100) < 70){
					y = 2 - random.nextInt(2);
					block =chunk.getBlock(x, y, z);
					block.setType(Material.BEDROCK);
				
				}
			}
		}
	}
	private void runcustom(int freq, int minY, int maxY, Random random, World world, Chunk chunk, CustomOres type) {
		int x,y,z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				if((maxY - minY) < 25){
					if(random.nextInt(700) < freq){
						for (y = maxY; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
						y = y - random.nextInt(y - (minY - 1));
						block = chunk.getBlock(x, y, z);
						if(block.getType() == Material.STONE){
							Spout.getServer().getWorld(world.getName()).getChunkAt(block).setCustomBlock(x, y, z, type);
						}
					}
				} else {
					if(random.nextInt(200) < freq){
						for (y = maxY; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
						y = y - random.nextInt(y - (minY - 1));
						block = chunk.getBlock(x, y, z);
						if(block.getType() == Material.STONE){
							Spout.getServer().getWorld(world.getName()).getChunkAt(block).setCustomBlock(x, y, z, type);
						}
					}
				}
			}
		}
	}
	private void run(int freq, int minY, int maxY, Random random, World world, Chunk chunk, Material type) {
		int x,y,z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				if(random.nextInt(100) < freq){
					for (y = maxY; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
					y = y - random.nextInt(y - (minY - 1));// y = 70 - (70 - (2 -1)) because random.nextInt(70) = 0 - 69)
					block = chunk.getBlock(x, y, z);
					if(block.getType() == Material.STONE){
						block.setType(type);
					}
				}
			}
		}
	}
}
