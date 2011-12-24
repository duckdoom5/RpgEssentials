package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class PlantsPopulator extends BlockPopulator {

	public TreeType treetype;
	public TreeType redwood;
	public Material flowertype;
	public Material type;
	
	public void populate(World world, Random random, Chunk chunk) {
		int x,y,z;
		Block block;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				
				
			//grass
				
				if(random.nextInt(100) < 5){
					for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
						block =chunk.getBlock(x, y, z);
						//set bytes per biome specific
						if((block.getBiome() == Biome.DESERT) || (block.getBiome() == Biome.SHRUBLAND)){
							if(block.getType() == Material.SAND){
								block = chunk.getBlock(x, y + 1, z);
								if(random.nextInt(100) < 20){
									block.setType(Material.LONG_GRASS);
									block.setData((byte) 0x0);
								}
							}
						} else if((block.getBiome() == Biome.PLAINS) || (block.getBiome() == Biome.SAVANNA) || (block.getBiome() == Biome.SKY)){
							if(block.getType() == Material.GRASS){
								block = chunk.getBlock(x, y + 1, z);
								block.setType(Material.LONG_GRASS);
								block.setData((byte) 0x1);
							}
						} else if((block.getBiome() == Biome.FOREST) || (block.getBiome() == Biome.RAINFOREST) || (block.getBiome() == Biome.SEASONAL_FOREST)){
							if(block.getType() == Material.GRASS){
								block = chunk.getBlock(x, y + 1, z);
								block.setType(Material.LONG_GRASS);
								block.setData((byte) 0x2);
							}
						//set with less %
						} else if(block.getBiome() == Biome.ICE_DESERT){
							if(block.getType() == Material.GRASS){
								block = chunk.getBlock(x, y + 1, z);
								if(random.nextInt(100) < 10){
									block.setType(Material.LONG_GRASS);
									block.setData((byte) 0x0);
								}
							}
						} else if((block.getBiome() == Biome.EXTREME_HILLS) || (block.getBiome() == Biome.ICE_MOUNTAINS) || (block.getBiome() == Biome.ICE_PLAINS) || (block.getBiome() == Biome.MUSHROOM_ISLAND) || (block.getBiome() == Biome.MUSHROOM_SHORE)){
							if(block.getType() == Material.GRASS){
								block = chunk.getBlock(x, y + 1, z);
								if(random.nextInt(100) < 20){
									block.setType(Material.LONG_GRASS);
									block.setData((byte) 0x1);
								}
							}
						} else if((block.getBiome() == Biome.TAIGA) || (block.getBiome() == Biome.TUNDRA)){
							if(block.getType() == Material.GRASS){
								block = chunk.getBlock(x, y + 1, z);
								if(random.nextInt(100) < 20){
									block.setType(Material.LONG_GRASS);
									block.setData((byte) 0x2);
								}
							}
						}
				}
				
			//flowers
				
				flowertype = (random.nextInt(100) < 40) ? Material.RED_ROSE : Material.YELLOW_FLOWER ;
				if(random.nextInt(400) < 1){
					for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
						block =chunk.getBlock(x, y, z);
						if(block.getType() == Material.GRASS){
							block =chunk.getBlock(x, y + 1, z);
							block.setType(flowertype);
						}
				}
				
				
			//cacti
				
				if(random.nextInt(200) < 1){
					for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
					block =chunk.getBlock(x, y, z);
					if((block.getBiome() == Biome.DESERT) || (block.getBiome() == Biome.SHRUBLAND) || (block.getBiome() == Biome.ICE_DESERT)){
						if(block.getType() == Material.SAND){
							if(chunk.getBlock(x + 1, y, z).getType() == Material.AIR){
								if(chunk.getBlock(x - 1, y, z).getType() == Material.AIR){
									if(chunk.getBlock(x, y, z + 1).getType() == Material.AIR){
										if(chunk.getBlock(x, y, z - 1).getType() == Material.AIR){
											block = chunk.getBlock(x, y + 1, z);
											block.setType(Material.CACTUS);
											block = chunk.getBlock(x, y + 2, z);
											block.setType(Material.CACTUS);
											if(random.nextInt(100) < 60){
												block =chunk.getBlock(x, y + 3, z);
												block.setType(Material.CACTUS);
											}
										}
									}
								}
							}
						}
					}
				}
			//pumpkin and melon farm
				type = (random.nextInt(100) < 40) ? Material.MELON_BLOCK : Material.PUMPKIN;
				if(random.nextInt(10000) < 1){
					int a = random.nextInt(1);
					for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
					block =chunk.getBlock(x, y, z);
					if(block.getType() == Material.GRASS){
						makefarm(block ,chunk ,x ,y ,z , type);
					}
				}
			//reeds
				if(random.nextInt(200) < 1){
					for (y = 65; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
					block =chunk.getBlock(x, y, z);
					
					if(block.getType() == Material.SAND){
						if((chunk.getBlock(x + 1, y, z).getType() == Material.WATER) || (chunk.getBlock(x + 1, y, z).getType() == Material.STATIONARY_WATER)){
							block = chunk.getBlock(x, y + 1, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							block = chunk.getBlock(x, y + 2, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							if(random.nextInt(100) < 60){
								block =chunk.getBlock(x, y + 3, z);
								block.setType(Material.SUGAR_CANE_BLOCK);
							}
						}else if((chunk.getBlock(x + 1, y, z).getType() == Material.WATER) || (chunk.getBlock(x + 1, y, z).getType() == Material.STATIONARY_WATER)){
							block = chunk.getBlock(x, y + 1, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							block = chunk.getBlock(x, y + 2, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							if(random.nextInt(100) < 60){
								block =chunk.getBlock(x, y + 3, z);
								block.setType(Material.SUGAR_CANE_BLOCK);
							}
						}else if((chunk.getBlock(x + 1, y, z).getType() == Material.WATER) || (chunk.getBlock(x + 1, y, z).getType() == Material.STATIONARY_WATER)){
							block = chunk.getBlock(x, y + 1, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							block = chunk.getBlock(x, y + 2, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							if(random.nextInt(100) < 60){
								block =chunk.getBlock(x, y + 3, z);
								block.setType(Material.SUGAR_CANE_BLOCK);
							}
						}else if((chunk.getBlock(x + 1, y, z).getType() == Material.WATER) || (chunk.getBlock(x + 1, y, z).getType() == Material.STATIONARY_WATER)){
							block = chunk.getBlock(x, y + 1, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							block = chunk.getBlock(x, y + 2, z);
							block.setType(Material.SUGAR_CANE_BLOCK);
							if(random.nextInt(100) < 60){
								block =chunk.getBlock(x, y + 3, z);
								block.setType(Material.SUGAR_CANE_BLOCK);
							}
						}
					}
				}
			//trees
				
				if(random.nextInt(100) < 10){
					for (y = 80; chunk.getBlock(x,y,z).getType() == Material.AIR; --y);
					block =chunk.getBlock(x, y, z);
					if(block.getType() == Material.GRASS){
						
						treetype = (random.nextInt(100) < 1) ? TreeType.BIG_TREE : (random.nextInt(100) < 2) ? TreeType.BIRCH : TreeType.TREE;
						redwood = (random.nextInt(100) < 5) ? TreeType.TALL_REDWOOD : TreeType.REDWOOD;
						
						if((block.getBiome() == Biome.PLAINS) || (block.getBiome() == Biome.SAVANNA) || (block.getBiome() == Biome.SKY)){
							if(random.nextInt(100) < 1){
								world.generateTree(chunk.getBlock(6 + random.nextInt(6), y + 1, 6 + random.nextInt(6)).getLocation(), treetype);
							}
						} else if((block.getBiome() == Biome.FOREST) || (block.getBiome() == Biome.RAINFOREST) || (block.getBiome() == Biome.SEASONAL_FOREST)){
							world.generateTree(chunk.getBlock(6 + random.nextInt(6), y + 1, 6 + random.nextInt(6)).getLocation(), treetype);
						} else if((block.getBiome() == Biome.EXTREME_HILLS) || (block.getBiome() == Biome.ICE_MOUNTAINS) || (block.getBiome() == Biome.ICE_PLAINS) || (block.getBiome() == Biome.MUSHROOM_ISLAND) || (block.getBiome() == Biome.MUSHROOM_SHORE)){
							if(random.nextInt(100) < 10){
								world.generateTree(chunk.getBlock(6 + random.nextInt(4), y + 1, 6 + random.nextInt(4)).getLocation(), treetype);
							}
						} else if((block.getBiome() == Biome.TAIGA) || (block.getBiome() == Biome.TUNDRA)){
							if(random.nextInt(100) < 60){
								world.generateTree(chunk.getBlock(6 + random.nextInt(6), y + 1, 6 + random.nextInt(6)).getLocation(), redwood);
							}
						} else if((block.getBiome() == Biome.SWAMPLAND)){
							if(random.nextInt(100) < 50){
								world.generateTree(chunk.getBlock(6 + random.nextInt(6), y + 1, 6 + random.nextInt(6)).getLocation(), TreeType.TREE);
							}
						}
					}
				}
			}
		}

	}

	private void makefarm(Block block, Chunk chunk, int x, int y, int z, Material material) {
		block = chunk.getBlock(x, y, z);
		if(block.getType() == Material.GRASS){
			block.setType(Material.SOIL);
			block = chunk.getBlock(x, y + 1, z);
			block.setType(material);
			block = chunk.getBlock(x, y - 1, z);
			
			
		}
		
	}

}
