package me.duckdoom5.RpgEssentials.customblocks;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityCreature;
import net.minecraft.server.EntityLiving;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.EntityType;

public class MobSpawnerTile{
	private Location location;
	private boolean particles;
	private World world;
	private Entity entity;
	
	private int delay;
	
	public MobSpawnerTile(Location location, boolean particles, int maxMobs, int maxDelay, EntityType entity){
		this.location = location;
		this.particles = particles;
		this.world = location.getWorld();
	}
	
	public boolean anyPlayerInRange(){
		net.minecraft.server.World worldObj = ((CraftWorld)location.getWorld()).getHandle();
		return worldObj.findNearbyPlayer(location.getX() + 0.5D, location.getY() + 0.5D, location.getZ() + 0.5D, 16D) != null;
	}
	
	public void update(){
		if(particles){
			world.playEffect(location, Effect.SMOKE, 1);
			world.playEffect(location, Effect.MOBSPAWNER_FLAMES, 1);
		}
		
		if (!anyPlayerInRange())
            return;
		
		if (delay == -1)
            updateDelay();

        if (delay > 0){
            delay--;
            return;
        }
		
        byte byte0 = 4;

        for (int i = 0; i < byte0; i++){
        	Entity entity2;
        	EntityCreature entityliving = (EntityCreature)entity;
        	if (entityliving == null)
                return;
        	
        	net.minecraft.server.World worldObj = ((CraftWorld)location.getWorld()).getHandle();
        	int j = worldObj.getEntities(entityliving, AxisAlignedBB.a(location.getX(), location.getY(), location.getZ(), location.getX() + 1, location.getY() + 1, location.getZ() + 1).a(8D, 4D, 8D)).size();

            if (j >= 6)
            {
                updateDelay();
                return;
            }
            
            double d3 = location.getX() + (worldObj.random.nextDouble() - worldObj.random.nextDouble()) * 4D;
            double d4 = (location.getY() + worldObj.random.nextInt(3)) - 1;
            double d5 = location.getZ() + (worldObj.random.nextDouble() - worldObj.random.nextDouble()) * 4D;
            entityliving.setPositionRotation(d3, d4, d5, worldObj.random.nextFloat() * 360F, 0.0F);

            if (entityliving.canSpawn()){
                worldObj.addEntity(entityliving);
                //worldObj.playNote(2004, location.getBlockX(), location.getBlockY(), location.getBlockZ(), 0, 0);
                //entityliving.spawnExplosionParticle();
                updateDelay();
            }
        }
	}
	
	public void updateDelay(){
		
	}
}
