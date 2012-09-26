package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

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

	public Block block;
	double noise;
	double noise2;
	private boolean sealogged = false;
	private boolean desertlogged = false;
	private boolean mushroomlogged = false;
	private boolean beachlogged = false;
	public Generator(RpgEssentials rpgEssentials) {
	}

	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		//ores
		populators.add(new OresPopulator(true));
		
		//caves
		if(Configuration.generator.getBoolean("Generator.Structures.caves")){
			populators.add(new CavePopulator());
		}
		
		//dungeons
		if(Configuration.generator.getBoolean("Generator.Structures.dungeons")){
			populators.add(new DungeonPopulator());
		}
		
		//BO2objects
		populators.add(new BO2Populator());
		
		//plants
		populators.add(new PlantsPopulator());
		
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
		
		int height = Configuration.generator.getInt("Generator.world.height");
		double spread = Configuration.generator.getDouble("Generator.world.spread");
		
		Random rand = new Random(world.getSeed());
		
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, height);
		
		octave.setScale(1 / spread);
		
		int bedrock = Configuration.generator.getInt("Generator.bedrock.frequency");
		
		int sealevel = Configuration.generator.getInt("Generator.sea.level");
		boolean sea = Configuration.generator.getBoolean("Generator.sea.generate");
		boolean desert = Configuration.generator.getBoolean("Generator.desert.generate");
		boolean beach = Configuration.generator.getBoolean("Generator.beach.generate");
		boolean mushroom = Configuration.generator.getBoolean("Generator.mushroom island.generate");
		
		if(!sea){
	    	if(sealogged == false){
	    		RpgEssentials.log.info("[RpgEssentials]Sea generation disabled.");
	    		sealogged = true;
	    	}
		}
		if(!desert){
			if(desertlogged == false){
	    		RpgEssentials.log.info("[RpgEssentials]Desert generation disabled.");
	    		desertlogged = true;
	    	}
		}
		if(!beach){
			if(beachlogged == false){
	    		RpgEssentials.log.info("[RpgEssentials]Beach generation disabled.");
	    		beachlogged = true;
	    	}
		}
		if(!mushroom){
			if(mushroomlogged == false){
	    		RpgEssentials.log.info("[RpgEssentials]Mushroom island generation disabled.");
	    		mushroomlogged = true;
	    	}
		}
		
		//generate
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				setBlockAt(result, x, 0, z, Material.BEDROCK);
				
				noise = octave.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 8;
				
				for(y = 1; y < 59 + noise; ++y){
					setBlockAt(result, x, y, z, Material.STONE);
				}
				
				Biome biome = biomes.getBiome(x, z);
				
				if(biome.equals(Biome.BEACH) || biome.equals(Biome.OCEAN) || biome.equals(Biome.RIVER) || biome.equals(Biome.FROZEN_OCEAN) || biome.equals(Biome.FROZEN_RIVER)){
					biomes.setBiome(x, z, Biome.PLAINS);
				}
				
				//generate biomes
				for(int a = 0; a <= 5; a++){
					if(desert && (biome.equals(Biome.DESERT) || biome.equals(Biome.DESERT_HILLS))){
						if(a == 0){
							setBlockAt(result, x, y + a, z, Material.SANDSTONE);
						}else{
							setBlockAt(result, x, y + a, z, Material.SAND);
						}
					}else{
						setBlockAt(result, x, y + a, z, Material.DIRT);
					}
				}
				
				y += 5;
				
				if(desert && (biome.equals(Biome.DESERT) || biome.equals(Biome.DESERT_HILLS))){
					setBlockAt(result, x, y, z, Material.SAND);
				}else if(mushroom && (biome.equals(Biome.MUSHROOM_ISLAND) || biome.equals(Biome.MUSHROOM_SHORE))){
					setBlockAt(result, x, y, z, Material.MYCEL);
				}else{
					setBlockAt(result, x, y, z, Material.GRASS);
				}
				
				//generate sea/dirt bottom
				
				if(sea){
				    if(y <= sealevel - 1 && (getBlockIdAt(result, x, y, z) == Material.GRASS.getId() || getBlockIdAt(result, x, y, z) == Material.SAND.getId())){
				    	setBlockAt(result, x, y, z, Material.DIRT);
				    	for(int a = y + 1; a <= sealevel; a++){
				    		if(getBlockIdAt(result, x, a, z) == Material.AIR.getId()){
				    			setBlockAt(result, x, a, z, Material.STATIONARY_WATER);
				    		}
				    	}
				    }
			    }
				
				//generate beach
				if(beach){
				    if(y <= sealevel + 1 && getBlockIdAt(result, x, y, z) == Material.GRASS.getId()){
				    	for (int a = 0; a < 5; a++){
				    		setBlockAt(result, x, y - a, z, Material.SAND);
						}
				    	setBlockAt(result, x, y - 5, z, Material.SANDSTONE);
				    }
			    }
				
				//snow over layer
				if(y > sealevel && (biome.equals(Biome.TAIGA) || biome.equals(Biome.TAIGA_HILLS))){
					int id = getBlockIdAt(result, x, y, z);
					if(id == Material.STATIONARY_WATER.getId() || id == Material.WATER.getId()){
						setBlockAt(result, x, y, z, Material.ICE);
					} else {
						setBlockAt(result, x, y + 1, z, Material.SNOW);
					}
				}
				
				//random bedrock
				if(random.nextInt(100) < bedrock){
					y = 2 - random.nextInt(1);
					setBlockAt(result, x, y, z, Material.BEDROCK);
				}
			}
		}
		
		return result;
	}
}
