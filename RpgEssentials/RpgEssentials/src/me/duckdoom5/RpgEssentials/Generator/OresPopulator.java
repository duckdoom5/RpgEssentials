package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.customblocks.CustomOre;
import me.duckdoom5.RpgEssentials.customblocks.OriginalOre;
import me.duckdoom5.RpgEssentials.util.MaterialManager;

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
					material = block.getmaterial();
					for (int j = 0; j < freq; j++) {
						run(world, random, chunk.getX() * 16 + random.nextInt(16), random.nextInt(maxY - minY) + minY, chunk.getZ() * 16 + random.nextInt(16), size, material);
					}
				}
			}else {
				if(orelogged == false){
					RpgEssentials.log.info("[RpgEssentials]Original ores generation disabled");
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
					runcustom(world, random, chunk.getX() * 16 + random.nextInt(16), random.nextInt(maxY - minY) + minY, chunk.getZ() * 16 + random.nextInt(16), size, ore);
				}
			}
		} else {
			if(cmorelogged == false){
				RpgEssentials.log.info("[RpgEssentials]Custom ores generation disabled");
				cmorelogged = true;
			}
		}
	}
	
	private void runcustom(World world, Random random, int x, int y, int z, int size, CustomOre type) {
        Block b = world.getBlockAt(x, y, z);
        SpoutChunk c = Spout.getServer().getWorld(world.getName()).getChunkAt(b);
        
        if(b.getType() == Material.STONE){
			c.setCustomBlock(x, y, z, type);
		}
        
       /* for (int j = 0; j < random.nextInt(size) + 1; j++) {
			if(b.getType() == Material.STONE){
				c.setCustomBlock(x, y, z, type);
			}
			b = b.getRelative(faces[random.nextInt(faces.length)]);
        }*/
	}
	
	private void run(World world, Random random, int x, int y, int z, int size, Material type) {
		Block block = world.getBlockAt(x, y, z);
		
		if(block.getType() == Material.STONE){
			block.setType(type);
		}
		
		/*for (int j = 0; j < random.nextInt(size) + 1; j++) {
			if(block.getType() == Material.STONE){
				block.setType(type);
			}
			block = block.getRelative(faces[random.nextInt(faces.length)]);
		}*/
	}
}
