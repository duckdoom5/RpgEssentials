package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class PlantsPopulator extends BlockPopulator {

	private TreeType treetype, redwood, mushroom, jungletype;
	private Material flowertype, mushroomtype, type;
	
	private boolean grasslogged = false;
	private boolean flowerlogged = false;
	private boolean cactilogged = false;
	private boolean pandmlogged = false;
	private boolean canelogged = false;
	private boolean treelogged = false;
	private boolean mushlogged = false;
	
	private BlockFace[] faces = { BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST };
	
	public void populate(World world, Random random, Chunk chunk) {
		Block block;
		int x = (chunk.getX() << 4) + random.nextInt(16);
		int z = (chunk.getZ() << 4) + random.nextInt(16);
        int y = world.getHighestBlockYAt(x, z);
        
        block = chunk.getBlock(x,y - 1,z);
        if(block.getType().equals(Material.SNOW)){
        	block = chunk.getBlock(x,y - 2,z);
        }
        
        Biome biome = block.getBiome();
		Material material = block.getType();
		
		//grass
		if(Configuration.generator.getBoolean("Generator.grass.generate")){
			int grass = Configuration.generator.getInt("Generator.grass.frequency");
			for (int i = 0; i < grass; i++) {
				x = (chunk.getX() << 4) + random.nextInt(16);
				z = (chunk.getZ() << 4) + random.nextInt(16);
				if(biome.equals(Biome.DESERT) || biome.equals(Biome.DESERT_HILLS) || biome.equals(Biome.SHRUBLAND)){
					if(random.nextInt(100) < 20){
						if(material.equals(Material.SAND)){
							block.getRelative(0, 1, 0).setTypeId(Material.DEAD_BUSH.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x0);
						}
					}
				} else if(biome.equals(Biome.PLAINS) || biome.equals(Biome.SAVANNA) || biome.equals(Biome.SKY)){
					if(random.nextInt(100) < 90){
						if(material.equals(Material.GRASS)){
							block.getRelative(0, 1, 0).setTypeId(Material.LONG_GRASS.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x1);
						}
					}
				} else if(biome.equals(Biome.FOREST) || biome.equals(Biome.FOREST_HILLS) || biome.equals(Biome.JUNGLE) || biome.equals(Biome.JUNGLE_HILLS) || biome.equals(Biome.RAINFOREST) || biome.equals(Biome.SEASONAL_FOREST)){
					if(random.nextInt(100) < 90){
						if(material.equals(Material.GRASS)){
							block.getRelative(0, 1, 0).setTypeId(Material.LONG_GRASS.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x2);
						}
					}
				} else if(biome.equals(Biome.ICE_DESERT)){
					if(random.nextInt(100) < 10){
						if(material.equals(Material.SAND)){
							block.getRelative(0, 1, 0).setTypeId(Material.DEAD_BUSH.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x0);
						}
					}
				} else if(biome.equals(Biome.EXTREME_HILLS) || biome.equals(Biome.ICE_MOUNTAINS) || biome.equals(Biome.ICE_PLAINS) || biome.equals(Biome.MUSHROOM_ISLAND) || biome.equals(Biome.MUSHROOM_SHORE)){
					if(random.nextInt(100) < 20){
						if(material.equals(Material.GRASS)){
							block.getRelative(0, 1, 0).setTypeId(Material.LONG_GRASS.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x1);
						}
					}
				} else if(biome.equals(Biome.TAIGA) || biome.equals(Biome.TAIGA_HILLS) || biome.equals(Biome.TUNDRA)){
					if(random.nextInt(100) < 10){
						if(material.equals(Material.GRASS)){
							block.getRelative(0, 1, 0).setTypeId(Material.LONG_GRASS.getId());
							block.getRelative(0, 1, 0).setData((byte) 0x2);
						}
					}
				}
			}
		}else {
			if(grasslogged == false){
				RpgEssentials.log.info("[RpgEssentials]Grass generation disabled");
				grasslogged = true;
			}
		}
		
		//flowers
		if(Configuration.generator.getBoolean("Generator.flowers.generate") == true){
			int flower = Configuration.generator.getInt("Generator.flowers.frequency");
			for (int i = 0; i < flower; i++) {
				flowertype = (random.nextInt(100) < 40) ? Material.RED_ROSE : Material.YELLOW_FLOWER ;
				if(random.nextInt(400) < 1){
					if(material.equals(Material.GRASS)){
						block.getRelative(0, 1, 0).setType(flowertype);
					}
				}
			}
		}else {
			if(flowerlogged == false){
				RpgEssentials.log.info("[RpgEssentials]Flower generation disabled");
				flowerlogged = true;
			}
		}
		
		//cacti
		if(Configuration.generator.getBoolean("Generator.cacti.generate") == true){
			int cacti = Configuration.generator.getInt("Generator.cacti.frequency");
			for (int i = 0; i < cacti; i++) {
				if(random.nextInt(400) < 1){
					if(biome.equals(Biome.DESERT) || biome.equals(Biome.SHRUBLAND) || biome.equals(Biome.ICE_DESERT)){
						if(material.equals(Material.SAND)){
							int air = 0;
							for(BlockFace face : faces){
								if(block.getRelative(face).getType().equals(Material.AIR)){
									air++;
								}
							}
							if(air==4){
								block.getRelative(0, 1, 0).setTypeId(Material.CACTUS.getId());
								block.getRelative(0, 2, 0).setTypeId(Material.CACTUS.getId());
								if(random.nextInt(100) < 60){
									block.getRelative(0, 3, 0).setTypeId(Material.CACTUS.getId());
								}
							}
						}
					}
				}
			}
		}else {
			if(cactilogged == false){
				RpgEssentials.log.info("[RpgEssentials]Cacti generation disabled");
				cactilogged = true;
			}
		}
		//pumpkin and melon farm
		if(Configuration.generator.getBoolean("Generator.pumpkins and melons.generate") == true){
			int mandp = Configuration.generator.getInt("Generator.pumpkins and melons.frequency");
			for (int i = 0; i < mandp; i++) {
				type = (random.nextInt(100) < 40) ? Material.MELON_BLOCK : Material.PUMPKIN;
				if(random.nextInt(10000) < 1){
					int a = random.nextInt(1);
					if(material.equals(Material.GRASS)){
						makefarm(block, chunk, x, y, z, type);
					}
				}
			}
		}else {
			if(pandmlogged == false){
				RpgEssentials.log.info("[RpgEssentials]Pumpkins and melon generation disabled");
				pandmlogged = true;
			}
		}
		//reeds
		if(Configuration.generator.getBoolean("Generator.sugar cane.generate") == true){
			int sugar = Configuration.generator.getInt("Generator.sugar cane.frequency");
			for (int i = 0; i < sugar; i++) {
				if(random.nextInt(200) < 1){
					if(material.equals(Material.SAND)){
						boolean water = false;
						for(BlockFace face : faces){
							if(block.getRelative(face).getType().equals(Material.WATER) || block.getRelative(face).getType().equals(Material.STATIONARY_WATER)){
								water = true;
							}
						}
						if(water){
							block.getRelative(0, 1, 0).setTypeId(Material.SUGAR_CANE_BLOCK.getId());
							block.getRelative(0, 2, 0).setTypeId(Material.SUGAR_CANE_BLOCK.getId());
							if(random.nextInt(100) < 60){
								block.getRelative(0, 3, 0).setTypeId(Material.SUGAR_CANE_BLOCK.getId());
							}
						}
					}
				}
			}
		}else {
			if(canelogged == false){
				RpgEssentials.log.info("[RpgEssentials]Sugar cane generation disabled");
				canelogged = true;
			}
		}
		
		//trees
		if(Configuration.generator.getBoolean("Generator.trees.generate") == true){
			int tree = Configuration.generator.getInt("Generator.trees.frequency");
			for (int i = 0; i < tree; i++) {
				if(material.equals(Material.GRASS)){
					treetype = (random.nextInt(100) < 1) ? TreeType.BIG_TREE : (random.nextInt(100) < 2) ? TreeType.BIRCH : TreeType.TREE;
					redwood = (random.nextInt(100) < 5) ? TreeType.TALL_REDWOOD : TreeType.REDWOOD;
					mushroom = (random.nextInt(100) < 40) ? TreeType.RED_MUSHROOM : TreeType.BROWN_MUSHROOM;
					jungletype = (random.nextInt(100) < 70) ? TreeType.JUNGLE_BUSH : (random.nextInt(100) < 60) ? TreeType.JUNGLE : TreeType.SMALL_JUNGLE;
					
					if(biome.equals(Biome.PLAINS) || biome.equals(Biome.SAVANNA) || biome.equals(Biome.SKY)){
						if(random.nextInt(100) < 5){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), treetype);
						}
					}else if(biome.equals(Biome.FOREST) || biome.equals(Biome.FOREST_HILLS) || biome.equals(Biome.RAINFOREST) || biome.equals(Biome.SEASONAL_FOREST)){
						world.generateTree(block.getRelative(0, 1, 0).getLocation(), treetype);
					}else if(biome.equals(Biome.EXTREME_HILLS) || biome.equals(Biome.ICE_MOUNTAINS) || biome.equals(Biome.ICE_PLAINS)){
						if(random.nextInt(100) < 10){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), treetype);
						}
					}else if(biome.equals(Biome.MUSHROOM_ISLAND) || biome.equals(Biome.MUSHROOM_SHORE)){
						if(random.nextInt(100) < 30){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), mushroom);
						}
					}else if(biome.equals(Biome.TAIGA) || biome.equals(Biome.TAIGA_HILLS)){
						if(random.nextInt(100) < 60){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), redwood);
						}
					}else if(biome.equals(Biome.TUNDRA)){
						if(random.nextInt(100) < 10){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), redwood);
						}
					}else if(biome.equals(Biome.JUNGLE) || biome.equals(Biome.JUNGLE_HILLS)){
						if(random.nextInt(100) < 90){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), jungletype);
						}
					}else if(biome.equals(Biome.SWAMPLAND)){
						if(random.nextInt(100) < 50){
							world.generateTree(block.getRelative(0, 1, 0).getLocation(), TreeType.SWAMP);
						}
					}
				}
			}
		}else {
			if(treelogged == false){
				RpgEssentials.log.info("[RpgEssentials]Tree generation disabled");
				treelogged = true;
			}
		}
		//mushrooms
		
		mushroomtype = (random.nextInt(100) < 40) ? Material.RED_MUSHROOM : Material.BROWN_MUSHROOM ;
		if(Configuration.generator.getBoolean("Generator.mushrooms.generate") && Configuration.generator.getBoolean("Generator.trees.generate")){
			int mushrooms = Configuration.generator.getInt("Generator.mushrooms.frequency");
			for (int i = 0; i < mushrooms; i++) {
				if(random.nextInt(400) < 1){
					if(material.equals(Material.LEAVES)){
						if(block.getRelative(0, -6, 0).getType() == Material.GRASS){
							block.getRelative(0, -5, 0).setType(mushroomtype);
						}else if(block.getRelative(0, -5, 0).getType() == Material.GRASS){
							block.getRelative(0, -4, 0).setType(mushroomtype);
						}else if(block.getRelative(0, -4, 0).getType() == Material.GRASS){
							block.getRelative(0, -3, 0).setType(mushroomtype);
						}else if(block.getRelative(0, -3, 0).getType() == Material.GRASS){
							block.getRelative(0, -2, 0).setType(mushroomtype);
						}
					}
				}
			}
		}else {
			if(mushlogged == false){
				RpgEssentials.log.info("[RpgEssentials]Mushroom generation disabled");
				mushlogged = true;
			}
		}
	}

	private void makefarm(Block block, Chunk chunk, int x, int y, int z, Material material) {
		block = chunk.getBlock(x,y,z);
		if(block.getType() == Material.GRASS){
			block.setType(Material.SOIL);
			block.getRelative(0,1,0).setType(material);
		}
	}
}
