package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.customblocks.CustomOre;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.block.SpoutChunk;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomOresPopulator extends BlockPopulator {

    public CustomOresPopulator() {
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        int freq, maxY, minY, size;

        for (final GenericCustomBlock block : RpgeManager.getInstance().getMaterialManager().getOres()) {
            final CustomOre ore = (CustomOre) block;
            freq = ore.getFreq();
            minY = ore.getMinY();
            maxY = ore.getMaxY();
            size = ore.getSize();
            for (int j = 0; j < freq; j++) {
                final int x = chunk.getX() * 16 + random.nextInt(16);
                final int y = random.nextInt(maxY - minY) + minY;
                final int z = chunk.getZ() * 16 + random.nextInt(16);

                Block cur_block = world.getBlockAt(x, y, z);
                final SpoutChunk cur_chunk = Spout.getServer().getWorld(world.getName()).getChunkAt(cur_block);

                int cur_x = (random.nextInt(2) - 1) + x;
                int cur_y = (random.nextInt(2) - 1) + y;
                int cur_z = (random.nextInt(2) - 1) + z;

                for (int s = 0; s < random.nextInt(size); s++) {
                    cur_x = (random.nextInt(2) - 1) + x;
                    cur_y = (random.nextInt(2) - 1) + y;
                    cur_z = (random.nextInt(2) - 1) + z;

                    cur_block = cur_chunk.getBlock(cur_x, cur_y, cur_z);
                    if (cur_block.getType() == Material.STONE) {
                        cur_chunk.setCustomBlock(cur_x, cur_y, cur_z, ore);
                    }
                }
            }
        }
    }
}
