package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomMobSpawner extends GenericCustomBlock {

    @SuppressWarnings ("unused")
    private final boolean particles;

    public CustomMobSpawner(RpgEssentials plugin, String name, int[] ids,
            boolean particles, int base, boolean canRotate) {
        super(plugin, name, base, new GenericCubeBlockDesign(plugin,
                RpgeManager.getInstance().blocks, ids), canRotate);
        this.particles = particles;
    }

    @Override
    public void onBlockPlace(org.bukkit.World world, int x, int y, int z,
            org.bukkit.entity.LivingEntity living) {
    }

    @Override
    public void onBlockDestroyed(World world, int x, int y, int z) {

    }
}
