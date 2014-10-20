package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.Random;

import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

/**
 * BlockPopulator for snake-based caves.
 */
public class CavePopulator extends BlockPopulator {

    private static boolean isGenerating = false;

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (isGenerating)
            return;

        final int freq = Configuration.generator.getInt("Global.Structures.caves.frequency");
        if (random.nextInt(1000) < freq) {
            final int rx = 4 + random.nextInt(8);
            final int rz = 4 + random.nextInt(8);
            int maxY = world.getHighestBlockYAt(rx, rz);
            if (maxY < 16) {
                maxY = 32;
            }

            isGenerating = true;
            final int ry = random.nextInt(maxY);
            ArrayList<Block> snake = startSnake(world, random,
                    chunk.getBlock(rx, ry, rz));
            finishSnake(world, random, snake);

            if (random.nextInt(16) > 5) {
                if (ry > 36) {
                    snake = startSnake(world, random,
                            chunk.getBlock(rx, ry / 2, rz));
                    finishSnake(world, random, snake);
                } else if (ry < 24) {
                    snake = startSnake(world, random,
                            chunk.getBlock(rx, ry * 2, rz));
                    finishSnake(world, random, snake);
                }
            }
            isGenerating = false;
        }
    }

    private ArrayList<Block> startSnake(World world, Random random, Block block) {
        final ArrayList<Block> snakeBlocks = new ArrayList<>();

        int blockX = block.getX();
        int blockY = block.getY();
        int blockZ = block.getZ();
        while (world.getBlockAt(blockX, blockY, blockZ).getType() != Material.AIR) {
            if (snakeBlocks.size() > 4000) {
                break;
            }

            if (random.nextInt(20) == 0) {
                blockY = blockY + 1;
            } else if (world.getBlockAt(blockX, blockY + 2, blockZ).getType() == Material.AIR) {
                blockY = blockY + 2;
            } else if (world.getBlockAt(blockX + 2, blockY, blockZ).getType() == Material.AIR) {
                blockX = blockX + 1;
            } else if (world.getBlockAt(blockX - 2, blockY, blockZ).getType() == Material.AIR) {
                blockX = blockX - 1;
            } else if (world.getBlockAt(blockX, blockY, blockZ + 2).getType() == Material.AIR) {
                blockZ = blockZ + 1;
            } else if (world.getBlockAt(blockX, blockY, blockZ - 2).getType() == Material.AIR) {
                blockZ = blockZ - 1;
            } else if (world.getBlockAt(blockX + 1, blockY, blockZ).getType() == Material.AIR) {
                blockX = blockX + 1;
            } else if (world.getBlockAt(blockX - 1, blockY, blockZ).getType() == Material.AIR) {
                blockX = blockX - 1;
            } else if (world.getBlockAt(blockX, blockY, blockZ + 1).getType() == Material.AIR) {
                blockZ = blockZ + 1;
            } else if (world.getBlockAt(blockX, blockY, blockZ - 1).getType() == Material.AIR) {
                blockZ = blockZ - 1;
            } else if (random.nextBoolean()) {
                if (random.nextBoolean()) {
                    blockX = blockX + 1;
                } else {
                    blockZ = blockZ + 1;
                }
            } else {
                if (random.nextBoolean()) {
                    blockX = blockX - 1;
                } else {
                    blockZ = blockZ - 1;
                }
            }

            if (world.getBlockAt(blockX, blockY, blockZ).getType() != Material.AIR) {
                snakeBlocks.add(world.getBlockAt(blockX, blockY, blockZ));
            }
        }

        return snakeBlocks;
    }

    private void finishSnake(World world, Random random,
            ArrayList<Block> snakeBlocks) {
        for (final Block block : snakeBlocks) {
            final Vector center = new BlockVector(block.getX(), block.getY(),
                    block.getZ());
            if (block.getType() != Material.AIR) {
                final int radius = 1 + random.nextInt(4);
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -radius; y <= radius; y++) {
                        for (int z = -radius; z <= radius; z++) {
                            final Vector position = center.clone().add(
                                    new Vector(x, y, z));

                            if (center.distance(position) <= radius + 0.5) {
                                if (canPlaceBlock(world, position.getBlockX(),
                                        position.getBlockY(),
                                        position.getBlockZ())) {
                                    world.getBlockAt(position.toLocation(world)).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean canPlaceBlock(World world, int x, int y, int z) {
        switch (world.getBlockAt(x, y, z).getType()) {
            case AIR:
            case WATER:
            case STATIONARY_WATER:
            case LAVA:
            case STATIONARY_LAVA:
            case BEDROCK:
                return false;
            default:
                return true;
        }
    }
}
