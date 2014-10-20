package me.duckdoom5.RpgEssentials.Generator;

import java.util.ArrayList;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class OldStuffDeleter extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        // RpgEssentials.getLog().info("Enter old stuff");
        int x, y, z;
        // for (y = 1; y < world.getMaxHeight(); ++y){
        for (x = 0; x < 16; ++x) {
            for (z = 0; z < 16; ++z) {
                final int starty = world.getHighestBlockYAt(x, z);
                for (y = starty; y > 1; y--) {
                    final Block block = world.getBlockAt(x, y, z);
                    // RpgEssentials.getLog().warning(block.getType().toString() +
                    // block.getType().name());
                    if (block.getType().equals(Material.IRON_ORE) || block.getType().equals(Material.COAL_ORE) || block.getType().equals(Material.GOLD_ORE) || block.getType().equals(Material.REDSTONE_ORE) || block.getType().equals(Material.LAPIS_ORE) || block.getType().equals(Material.DIAMOND_ORE)) {
                        RpgEssentials.getLog().info("Changing to stone" + x + y + z);
                        block.setType(Material.STONE);
                    } else if (block.getType().equals(Material.LOG) || block.getType().equals(Material.LEAVES) || block.getType().equals(Material.VINE) || block.getType().equals(Material.RED_ROSE) || block.getType().equals(Material.YELLOW_FLOWER) || block.getType().equals(Material.LONG_GRASS) || block.getType().equals(Material.CACTUS) || block.getType().equals(Material.SUGAR_CANE) || block.getType().equals(Material.BROWN_MUSHROOM) || block.getType().equals(Material.RED_MUSHROOM) || block.getType().equals(Material.DEAD_BUSH) || block.getType().equals(Material.PUMPKIN) || block.getType().equals(Material.SNOW)) {
                        RpgEssentials.getLog().info("Changing to air");
                        block.setType(Material.AIR);
                    }
                }
            }
        }
        // }
        // RpgEssentials.getLog().info("Ending old stuff");
    }

    public ArrayList<Block> GetSurfaceBlocks(Chunk source, World world) {
        final ArrayList<Block> blocks = new ArrayList<>();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                Block b = source.getBlock(x, 64, z);
                final int y = world.getHighestBlockYAt(b.getX(), b.getZ());
                b = source.getBlock(x, y, z);

                blocks.add(b.getRelative(BlockFace.DOWN)); // Get the block
                                                           // below
                // (since highest is an
                // air block
            }
        }

        return blocks;
    }
}
