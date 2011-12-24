package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class Generator extends ChunkGenerator {

	private RpgEssentials plugin;
	public Block block;
	double noise;
	
	public Generator(RpgEssentials rpgEssentials) {
		this.plugin = rpgEssentials;
	}

	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		//biomes
		populators.add(new BiomesPopulator());
		//ores
		populators.add(new OresPopulator(plugin));
		//builings
		//plants
		populators.add(new PlantsPopulator());
		
		return populators;
	}
	
	public Location getFixedSpawnLocation(World world, Random random){
		return new Location(world, 6, 50, 6);
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
				
				/*
				if((world.getBiome(x, z) == Biome.DESERT) || (world.getBiome(x, z) == Biome.SHRUBLAND) || (world.getBiome(x, z) == Biome.ICE_DESERT) || (world.getBiome(x, z) == Biome.PLAINS) || (world.getBiome(x, z) == Biome.SAVANNA)){
					noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 1;
				} else if((world.getBiome(x, z) == Biome.EXTREME_HILLS) || (world.getBiome(x, z) == Biome.ICE_MOUNTAINS)){
					noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 12;
				} else {
				*/
					noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 8;
				for(y = 1; y < 59 + noise; ++y){
					blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
				}
				for(int a = 0; a < 5; ++a){
					blocks[this.coordsToInt(x, y + a, z)] = (byte) Material.DIRT.getId();
				}
				blocks[this.coordsToInt(x, y + 5, z)] = (byte) Material.GRASS.getId();
			}
		}
		
		return blocks;
	}

}
