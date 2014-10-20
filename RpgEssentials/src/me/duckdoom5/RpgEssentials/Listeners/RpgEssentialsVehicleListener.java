package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.block.SpoutBlock;

public class RpgEssentialsVehicleListener implements Listener {
    public RpgEssentials plugin;
    private final Set<Vector> set = new HashSet<>();

    public RpgEssentialsVehicleListener(RpgEssentials instance) {
        plugin = instance;
    }

    // TODO move to RpgTracks

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        final Location to = event.getTo();
        final SpoutBlock block = (SpoutBlock) to.getBlock();
        final Vector vec = new Vector(to.getBlockX(), to.getBlockY(),
                to.getBlockZ());
        if (!set.contains(vec)) {
            block.getCustomBlock().onEntityMoveAt(to.getWorld(),
                    to.getBlockX(), to.getBlockY(), to.getBlockZ(),
                    event.getVehicle());

            set.add(vec);

            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            set.remove(vec);
                        }
                    }, 20L);
        }
    }
}
