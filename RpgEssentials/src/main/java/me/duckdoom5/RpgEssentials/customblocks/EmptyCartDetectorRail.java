package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.PoweredMinecart;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.material.PoweredRail;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.sound.SoundEffect;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class EmptyCartDetectorRail extends Rail {
	private RpgEssentials plugin;
	public EmptyCartDetectorRail(RpgEssentials plugin, String name, int[] textureids) {
		super(plugin, 66, true, name, textureids);
		this.plugin = plugin;
	}
	
	@Override
	public void onEntityMoveAt(World world, int x, int y, int z, Entity entity){
		if(entity instanceof Minecart && !(entity instanceof StorageMinecart) && !(entity instanceof PoweredMinecart)){
			Minecart minecart = (Minecart)entity;
			if(minecart.isEmpty()){
				final Block block = world.getBlockAt(x, y, z);
				PoweredRail poweredRail = (PoweredRail) block.getState().getData();
		    	poweredRail.setPowered(true);
		    	block.setData(poweredRail.getData(), true);
				SpoutManager.getSoundManager().playGlobalSoundEffect(SoundEffect.CLICK, new Location(world,x,y,z));
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	PoweredRail poweredRail = (PoweredRail) block.getState().getData();
				    	poweredRail.setPowered(false);
				    	block.setData(poweredRail.getData(), true);
				    }
				}, 20L);
			}
		}
	}
	
	public void onNeighborBlockChange(org.bukkit.World world, int x, int y, int z, int changedId){
		
	}
	
	public void onBlockPlace(org.bukkit.World world, int x, int y, int z, org.bukkit.entity.LivingEntity living){
		
	}
}
