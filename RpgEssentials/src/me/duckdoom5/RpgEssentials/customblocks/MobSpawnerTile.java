package me.duckdoom5.RpgEssentials.customblocks;

import net.minecraft.server.v1_6_R3.AxisAlignedBB;
import net.minecraft.server.v1_6_R3.Entity;
import net.minecraft.server.v1_6_R3.EntityLiving;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_6_R3.CraftWorld;

public class MobSpawnerTile {
    private final Location location;
    private final boolean particles;
    private final World world;
    private Entity entity;

    private int delay;

    public MobSpawnerTile(Location location, boolean particles) {
        this.location = location;
        this.particles = particles;
        world = location.getWorld();
    }

    public boolean anyPlayerInRange() {
        final net.minecraft.server.v1_6_R3.World worldObj = ((CraftWorld) location.getWorld()).getHandle();
        return worldObj.findNearbyPlayer(location.getX() + 0.5D,
                location.getY() + 0.5D, location.getZ() + 0.5D, 16D) != null;
    }

    public void update() {
        if (particles) {
            world.playEffect(location, Effect.SMOKE, 1);
            world.playEffect(location, Effect.MOBSPAWNER_FLAMES, 1);
        }

        if (!anyPlayerInRange())
            return;

        if (delay == -1)
            updateDelay();

        if (delay > 0) {
            delay--;
            return;
        }

        final byte byte0 = 4;

        for (int i = 0; i < byte0; i++) {
            final EntityLiving entityliving = (EntityLiving) entity;
            if (entityliving == null)
                return;

            final net.minecraft.server.v1_6_R3.World worldObj = ((CraftWorld) location.getWorld()).getHandle();
            final int j = worldObj.getEntities(
                    entityliving,
                    AxisAlignedBB.a(location.getX(), location.getY(),
                            location.getZ(), location.getX() + 1,
                            location.getY() + 1, location.getZ() + 1).a(8D, 4D,
                            8D)).size();

            if (j >= 6) {
                updateDelay();
                return;
            }

            final double d3 = location.getX() + (worldObj.random.nextDouble() - worldObj.random.nextDouble()) * 4D;
            final double d4 = (location.getY() + worldObj.random.nextInt(3)) - 1;
            final double d5 = location.getZ() + (worldObj.random.nextDouble() - worldObj.random.nextDouble()) * 4D;
            entityliving.setPositionRotation(d3, d4, d5,
                    worldObj.random.nextFloat() * 360F, 0.0F);

            entityliving.spawnIn(worldObj);
            updateDelay();
        }
    }

    public void updateDelay() {

    }
}
