package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.BO2Populator;

import org.bukkit.Chunk;
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
	private boolean sealogged = false;
	private boolean desertlogged = false;
	private boolean mounlogged = false;
	private boolean beachlogged = false;
	
	public Generator(RpgEssentials rpgEssentials) {
		this.plugin = rpgEssentials;
	}

	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		//ores
		populators.add(new OresPopulator(plugin));
		
		//BO2objects
		//populators.add(new BO2Populator(plugin));
		
		//plants
		populators.add(new PlantsPopulator(plugin));
		
		//snow overlayer
		populators.add(new SnowOverlayer());
		
		//caves
		populators.add(new CavePopulator());
		
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
	
	public static Block getHighestBlock(Chunk chunk, int x, int z) {
		Block block = null;
		int y;
		for(y = chunk.getWorld().getMaxHeight(); chunk.getBlock(x,y,z).getType() == Material.AIR; y--);
		block = chunk.getBlock(x, y, z);
		return block;
	}
	
	public void setBlockAt(short[][] result, int x, int y, int z, Material material) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new short[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = (short) material.getId();
    }
	
	public short getBlockIdAt(short[][] result, int x, int y, int z) {
        if (result[y >> 4] == null) {
            return (short)0;
        }
        return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];
    }
	
	@Override
	public short[][] generateExtBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomes) {
		short[][] result = new short[world.getMaxHeight() / 16 + 1][];
		int x, y, z;
		
		Random rand = new Random(world.getSeed());
		
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);
		
		
		octave.setScale(1 / 128.0);
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				setBlockAt(result, x, 0, z, Material.BEDROCK);
				
				noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 8;
				
				for(y = 1; y < 59 + noise; ++y){
					setBlockAt(result, x, y, z, Material.STONE);
				}
				
				//generate biomes
				for(int a = 0; a < 5; ++a){
					if(biomes.getBiome(x, z).equals(Biome.DESERT) || biomes.getBiome(x, z).equals(Biome.BEACH) || biomes.getBiome(x, z).equals(Biome.DESERT_HILLS)){
						setBlockAt(result, x, y + a, z, Material.SAND);
					}else{
						setBlockAt(result, x, y + a, z, Material.DIRT);
					}
				}
				if(Configuration.generator.getBoolean("Generator.Biomes.Desert") == true && biomes.getBiome(x, z).equals(Biome.DESERT) || biomes.getBiome(x, z).equals(Biome.BEACH) || biomes.getBiome(x, z).equals(Biome.DESERT_HILLS)){
					setBlockAt(result, x, y + 5, z, Material.SAND);
				}else if(Configuration.generator.getBoolean("Generator.Biomes.Mushroom Island") == true && biomes.getBiome(x, z).equals(Biome.MUSHROOM_ISLAND) || biomes.getBiome(x, z).equals(Biome.MUSHROOM_SHORE)){
					setBlockAt(result, x, y + 5, z, Material.MYCEL);
				}else{
					setBlockAt(result, x, y + 5, z, Material.GRASS);
				}
				
				for(y = world.getMaxHeight(); getBlockIdAt(result, x, y, z) == Material.AIR.getId(); y--);
				
				//generate sea/dirt botom
				
				if(Configuration.generator.getBoolean("Generator.Biomes.Sea") == true){
				    if(y <= 63 && getBlockIdAt(result, x, y, z) == Material.GRASS.getId() || getBlockIdAt(result, x, y, z) == Material.SAND.getId()){
				    	setBlockAt(result, x, y, z, Material.DIRT);
				    	for(int a = y + 1; a <= 64; a++){
				    		if(getBlockIdAt(result, x, a, z) == Material.AIR.getId()){
				    			setBlockAt(result, x, a, z, Material.STATIONARY_WATER);
				    		}
				    	}
				    }
			    }else {
			    	if(sealogged == false){
			    		RpgEssentials.log.info("[RpgEssentials]Sea generation disabled");
			    		sealogged = true;
			    	}
				}
				
				//generate beach
				if(Configuration.generator.getBoolean("Generator.Biomes.Beach") == true){
				    if(y <= 65 && getBlockIdAt(result, x, y, z) == Material.GRASS.getId()){
				    	for (int a = 0; a <= 5; a++){
				    		setBlockAt(result, x, y - a, z, Material.SAND);
						}
				    	setBlockAt(result, x, y - 6, z, Material.SANDSTONE);
				    }
			    }else {
			    	if(beachlogged == false){
			    		RpgEssentials.log.info("[RpgEssentials]Beach generation disabled");
			    		beachlogged = true;
			    	}
				}
			}
		}
		
		return result;
	}

}
