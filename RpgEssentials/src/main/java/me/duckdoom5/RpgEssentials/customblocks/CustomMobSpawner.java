package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Location;
import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomMobSpawner extends GenericCustomBlock {
	
	@SuppressWarnings("unused")
	private boolean particles;
	
	public CustomMobSpawner(RpgEssentials plugin, String name, int[] ids, boolean particles, float hard, int light, float friction, int base, boolean canRotate){
		super(plugin, name, base, new GenericCubeBlockDesign(plugin, plugin.blocks, ids), canRotate);
		this.particles = particles;
	}
	
	@Override
	public void onBlockPlace(org.bukkit.World world, int x, int y, int z, org.bukkit.entity.LivingEntity living){
		Location location = new Location(world,x,y,z);
		//MobSpawnerTile tile = new MobSpawnerTile(location, particles, 6, 600, null);
	}
	
	@Override
	public void onBlockDestroyed(World world, int x, int y, int z){
		
	}
}
