package me.duckdoom5.RpgEssentials.customblocks;

import java.util.ArrayList;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.PoweredRail;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.sound.SoundEffect;

public class UnloaderRail extends Rail {
    private final RpgEssentials plugin;

    public UnloaderRail(RpgEssentials plugin, String name, int[] textureids) {
        super(plugin, 27, true, name, textureids);
        this.plugin = plugin;
    }

    @Override
    public void onEntityMoveAt(final World world, final int x, final int y,
            final int z, Entity entity) {
        if (entity instanceof StorageMinecart) {
            final StorageMinecart minecart = (StorageMinecart) entity;
            final Vector velocity = minecart.getVelocity();
            final Block block = world.getBlockAt(x, y, z);

            if (Configuration.tracks.getBoolean(x + "," + y + "," + z + ".waitTillEmpty", true)) {
                if (canLoad(block)) {
                    load(minecart, block, velocity);
                } else {
                    sendSignal(minecart, block, velocity);
                    Bukkit.broadcastMessage("can't load");
                }
            } else {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(
                                plugin,
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        final PoweredRail poweredRail = (PoweredRail) block.getState().getData();
                                        poweredRail.setPowered(true);
                                        block.setData(poweredRail.getData(),
                                                true);
                                        SpoutManager.getSoundManager().playGlobalSoundEffect(
                                                        SoundEffect.CLICK,
                                                        new Location(world, x,
                                                                y, z));

                                        plugin.getServer().getScheduler().scheduleSyncDelayedTask(
                                                        plugin, new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                final PoweredRail poweredRail = (PoweredRail) block.getState().getData();
                                                                poweredRail.setPowered(false);
                                                                block.setData(
                                                                        poweredRail.getData(),
                                                                        true);
                                                            }
                                                        }, 20L);
                                    }
                                },
                                Configuration.tracks.getInt(x + "," + y + "," + z + ".waitTime", 10) * 20);
            }
        }
    }

    private final List<Chest> chests = new ArrayList<>();

    private boolean canLoad(Block block) {
        chests.clear();
        final Block[] ba = {
                block.getRelative(0, 1, 0), // up
                block.getRelative(0, 1, 1),
                block.getRelative(0, 1, -1),
                block.getRelative(1, 1, 0),
                block.getRelative(1, 1, 1),
                block.getRelative(1, 1, -1),
                block.getRelative(-1, 1, 0),
                block.getRelative(-1, 1, 1),
                block.getRelative(-1, 1, -1),

                // center
                block.getRelative(0, 0, 1), block.getRelative(0, 0, -1),
                block.getRelative(1, 0, 0), block.getRelative(1, 0, 1),
                block.getRelative(1, 0, -1),
                block.getRelative(-1, 0, 0),
                block.getRelative(-1, 0, 1),
                block.getRelative(-1, 0, -1),

                block.getRelative(0, -1, 0), // down
                block.getRelative(0, -1, 1), block.getRelative(0, -1, -1),
                block.getRelative(1, -1, 0), block.getRelative(1, -1, 1),
                block.getRelative(1, -1, -1), block.getRelative(-1, -1, 0),
                block.getRelative(-1, -1, 1), block.getRelative(-1, -1, -1), };

        for (final Block rblock : ba) {
            if (rblock.getType().equals(Material.CHEST)) {
                final Chest chest = (Chest) rblock.getState();
                if (!Methods.isInventoryFull(chest.getInventory().getContents())) {
                    chests.add(chest);
                }
            }
        }
        if (chests.isEmpty()) {
            return false;
        }

        return true;
    }

    private int count, chestCount;

    private void load(final StorageMinecart minecart, final Block block,
            final Vector velocity) {// unload minecart
        count = 0;
        chestCount = 0;
        if (!Methods.isInventoryEmpty(minecart.getInventory().getContents())) {
            final ItemStack[] contents = minecart.getInventory().getContents();
            final int taskid = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            if (count != contents.length) {
                                Chest chest = chests.get(chestCount);
                                if (!Methods.isInventoryFull(chest.getInventory().getContents())) {
                                    if (Methods.isInventoryFull(chest.getInventory().getContents())) {
                                        chestCount++;
                                        chest = chests.get(chestCount);
                                    }
                                    minecart.getInventory().remove(count); // remove
                                                                           // item
                                    chest.getInventory().setItem(
                                            chest.getInventory().firstEmpty(),
                                            contents[count]); // fill chest
                                    chest.update();
                                    Bukkit.broadcastMessage("remove");
                                }
                                count++;
                            }
                        }
                    }, 0L, 20L);

            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            plugin.getServer().getScheduler().cancelTask(taskid);
                            sendSignal(minecart, block, velocity);
                        }
                    }, contents.length * 20);// add config value
        } else {
            sendSignal(minecart, block, velocity);
            Bukkit.broadcastMessage("empty");
        }
    }

    public void sendSignal(StorageMinecart minecart, final Block block,
            Vector velocity) {
        Bukkit.broadcastMessage("send");
        final PoweredRail poweredRail = (PoweredRail) block.getState().getData();
        poweredRail.setPowered(true);
        block.setData(poweredRail.getData(), true);
        minecart.setVelocity(velocity);
        SpoutManager.getSoundManager().playGlobalSoundEffect(
                SoundEffect.CLICK,
                new Location(block.getWorld(), block.getX(), block.getY(),
                        block.getZ()));
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        final PoweredRail poweredRail = (PoweredRail) block.getState().getData();
                        poweredRail.setPowered(false);
                        block.setData(poweredRail.getData(), true);
                    }
                }, 40L);
    }

    @Override
    public void onBlockPlace(org.bukkit.World world, int x, int y, int z,
            org.bukkit.entity.LivingEntity living) {
        Configuration.tracks.set(x + "," + y + "," + z + ".waitTillEmpty", true);
        Configuration.tracks.set(x + "," + y + "," + z + ".waitTime", 10);
    }

    @Override
    public void onBlockDestroyed(World world, int x, int y, int z) {
        Configuration.tracks.set(x + "," + y + "," + z, null);
    }
}
