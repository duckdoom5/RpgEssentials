package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DungeonPopulator extends BlockPopulator {

    private World world;
    private Random random;

    @Override
    public void populate(World w, Random rnd, Chunk chunk) {
        world = w;
        random = rnd;

        final int freq = Configuration.generator.getInt("Global.Structures.dungeons.frequency");

        // Go go dungeons
        if (random.nextInt(1000) < freq) {
            final int x = (chunk.getX() << 4) + random.nextInt(16);
            final int z = (chunk.getZ() << 4) + random.nextInt(16);
            final int y = 12 + random.nextInt(22);

            final int sizeX = random.nextInt(12) + 5;
            final int sizeY = random.nextInt(6) + 4;
            final int sizeZ = random.nextInt(12) + 5;

            generateRoom(x, y, z, sizeX, sizeY, sizeZ);
        }
    }

    private void generateRoom(int posX, int posY, int posZ, int sizeX,
            int sizeY, int sizeZ) {
        // Fill with random cobble
        for (int x = posX - 1; x <= posX + sizeX; x++) {
            for (int y = posY - 1; y <= posY + sizeY; y++) {
                for (int z = posZ - 1; z <= posZ + sizeZ; z++) {
                    placeBlock(x, y, z, pickStone());
                }
            }
        }

        /*
         * //debug for (int y = posY; y < 80 + sizeY; y++) {
         * world.getBlockAt(posX, y, posZ).setType(pickStone()); }
         */

        // clear room
        for (int x = posX; x < posX + sizeX; x++) {
            for (int y = posY; y < posY + sizeY; y++) {
                for (int z = posZ; z < posZ + sizeZ; z++) {
                    placeBlock(x, y, z, Material.AIR);
                }
            }
        }

        // get the config
        int numChests = Configuration.generator.getInt("Global.Structures.dungeons.chest.frequency");

        // Chests
        numChests = random.nextInt(numChests);
        for (int i = 0; i < numChests; ++i) {
            final int x = posX + random.nextInt(sizeX);
            final int z = posZ + random.nextInt(sizeZ);
            placeChest(world.getBlockAt(x, posY, z));
        }

        // Spawners (directly related to how many chests spawn)
        final int numSpawners = numChests + random.nextInt(2);
        for (int i = 0; i < numSpawners; ++i) {
            final int x = posX + random.nextInt(sizeX);
            final int z = posZ + random.nextInt(sizeZ);
            placeSpawner(world.getBlockAt(x, posY, z));
        }
    }

    private Material pickStone() {
        if (random.nextInt(6) == 0) {
            return Material.MOSSY_COBBLESTONE;
        }
        return Material.COBBLESTONE;
    }

    private void placeSpawner(Block block) {
        final EntityType[] types = new EntityType[] { EntityType.SKELETON,
                EntityType.ZOMBIE, EntityType.CREEPER, EntityType.SPIDER };

        block.setType(Material.MOB_SPAWNER);
        ((CreatureSpawner) block.getState()).setSpawnedType(types[random.nextInt(types.length)]);
    }

    private void placeChest(Block block) {
        block.setType(Material.CHEST);
        final Inventory chest = ((Chest) block.getState()).getInventory();

        // Populate the chest with a random amt of random items
        for (int i = 0; i < random.nextInt(5); i++) {
            chest.setItem(random.nextInt(chest.getSize()), getRandomTool(i));
        }
        for (int i = 0; i < random.nextInt(5); i++) {
            chest.setItem(random.nextInt(chest.getSize()), getRandomArmor(i));
        }
        for (int i = 0; i < random.nextInt(5); i++) {
            chest.setItem(random.nextInt(chest.getSize()), getRandomOre());
        }
    }

    private ItemStack getRandomOre() {
        final int chance = random.nextInt(255);
        final int count = random.nextInt(63) + 1;

        if (chance > 253) {
            return new ItemStack(Material.LAPIS_BLOCK, count);
        } else if (chance > 230) {
            return new ItemStack(Material.DIAMOND_ORE, count);
        } else if (chance > 190) {
            return new ItemStack(Material.GOLD_ORE, count);
        } else if (chance > 150) {
            return new ItemStack(Material.IRON_ORE, count);
        } else {
            return new ItemStack(Material.COAL, count);
        }
    }

    private ItemStack getRandomTool(int index) {
        // 0 = sword, 1 = spade, 2 = pickaxe, 3 = axe
        final int chance = random.nextInt(255);

        if (chance > 245) {
            // Diamond
            return new ItemStack(276 + index);
        } else if (chance > 230) {
            // Gold
            return new ItemStack(283 + index);
        } else if (chance > 190) {
            if (index == 0) {
                // Iron sword
                return new ItemStack(Material.IRON_SWORD);
            }
            return new ItemStack(255 + index);
        } else if (chance > 150) {
            // Stone
            return new ItemStack(272 + index);
        } else {
            // Wood
            return new ItemStack(268 + index);
        }
    }

    private ItemStack getRandomArmor(int index) {
        // 0 = helmet, 1 = chestplate, 2 = leggings, 3 = boots
        final int chance = random.nextInt(255);

        if (chance > 245) {
            // Diamond
            return new ItemStack(310 + index, 1);
        } else if (chance > 230) {
            // Chainmail
            return new ItemStack(302 + index, 1);
        } else if (chance > 190) {
            // Gold
            return new ItemStack(314 + index, 1);
        } else if (chance > 150) {
            // Iron
            return new ItemStack(306 + index, 1);
        } else {
            // Leather
            return new ItemStack(298 + index, 1);
        }
    }

    private void placeBlock(int x, int y, int z, Material mat) {
        if (canPlaceBlock(x, y, z)) {
            world.getBlockAt(x, y, z).setType(mat);
        }
    }

    private boolean canPlaceBlock(int x, int y, int z) {
        switch (world.getBlockAt(x, y, z).getType()) {
            case AIR:
            case MOB_SPAWNER:
            case CHEST:
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
