package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;
import org.getspout.spout.block.SpoutCraftBlock;

public class RpgEssentialsVehicleListener implements Listener{
	public static RpgEssentials plugin;
	private Set<Vector> set = new HashSet<Vector>();
	
	public RpgEssentialsVehicleListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	//TODO move to RpgTracks
	
	@EventHandler
	public void onVehicleMove(VehicleMoveEvent event){
		Location to = event.getTo();
		SpoutCraftBlock block = (SpoutCraftBlock)to.getBlock();
		if(block.isCustomBlock()){
			final Vector vec = new Vector(to.getBlockX(),to.getBlockY(),to.getBlockZ());
			if(!set.contains(vec)){
				block.getCustomBlock().onEntityMoveAt(to.getWorld(), to.getBlockX(), to.getBlockY(), to.getBlockZ(), event.getVehicle());
				
				set.add(vec);
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	set.remove(vec);
				    }
				}, 20L);
			}
		}
	}
}
