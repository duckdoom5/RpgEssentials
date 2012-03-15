package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.util.BO2Populator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class Generator extends ChunkGenerator {

	private RpgEssentials plugin;
	public Block block;
	double noise;
	double noise2;
	
	public Generator(RpgEssentials rpgEssentials) {
		this.plugin = rpgEssentials;
	}

	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		//biomes
		//populators.add(new BiomesPopulator(plugin));
		//ores
		//populators.add(new OresPopulator(plugin));
		//BO2objects
		populators.add(new BO2Populator(plugin));
		//plants
		populators.add(new PlantsPopulator(plugin));
		//snow overlayer
		//populators.add(new SnowOverlayer());
		
		return populators;
	}
	
	public Location getFixedSpawnLocation(World world, Random random){
		int x,y,z;
		x = random.nextInt(16);
		y = 0;
		z = random.nextInt(16);
		for (y = 80; world.getBlockAt(x,y,z).getType() == Material.AIR; --y);
		return new Location(world, x,y + 1,z);
	}
	
	private int coordsToInt(int x, int y, int z){
		return (x * 16 + z) * 128 + y;
	}
	
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		byte[] blocks = new byte[32768];
		int x, y, z;
		
		Random rand = new Random(world.getSeed());
		
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);
		
		
		octave.setScale(1 / 128.0);
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				blocks[this.coordsToInt(x, 0, z)] = (byte) Material.BEDROCK.getId();
				
				noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 8;
				
				for(y = 1; y < 59 + noise; ++y){
					blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
				}
				for(int a = 0; a < 5; ++a){
					if(world.getBiome(x, z).equals(Biome.DESERT) || world.getBiome(x, z).equals(Biome.BEACH) || world.getBiome(x, z).equals(Biome.DESERT_HILLS) || world.getBiome(x, z).equals(Biome.FOREST) || world.getBiome(x, z).equals(Biome.JUNGLE)){
						blocks[this.coordsToInt(x, y + a, z)] = (byte) Material.SAND.getId();
					}else{
						blocks[this.coordsToInt(x, y + a, z)] = (byte) Material.DIRT.getId();
					}
				}
				if(world.getBiome(x, z).equals(Biome.DESERT)){
					blocks[this.coordsToInt(x, y + 5, z)] = (byte) Material.SAND.getId();
				}else{
					blocks[this.coordsToInt(x, y + 5, z)] = (byte) Material.GRASS.getId();
				}
			}
		}
		
		return blocks;
	}

}
