package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PoweredMinecart;
import org.getspout.spout.block.SpoutCraftBlock;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.sound.SoundEffect;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class PoweredMinecartDetectorRail extends Rail {
	private RpgEssentials plugin;
	public PoweredMinecartDetectorRail(RpgEssentials plugin, String name, int[] textureids) {
		super(plugin, 66, true, name, textureids);
		this.plugin = plugin;
	}
	
	@Override
	public void onEntityMoveAt(World world, int x, int y, int z, Entity entity){
		if(entity instanceof PoweredMinecart){
			PoweredMinecart minecart = (PoweredMinecart)entity;
			final SpoutCraftBlock block = (SpoutCraftBlock) world.getBlockAt(x, y, z);
			block.setBlockPowered(true);
			SpoutManager.getSoundManager().playGlobalSoundEffect(SoundEffect.CLICK, new Location(world,x,y,z));
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			    public void run() {
			    	block.setBlockPowered(false);
			    }
			}, 20L);
		}
	}
	
	public void onNeighborBlockChange(org.bukkit.World world, int x, int y, int z, int changedId){
		
	}
	
	public void onBlockPlace(org.bukkit.World world, int x, int y, int z, org.bukkit.entity.LivingEntity living){
		
	}
}
