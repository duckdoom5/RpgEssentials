package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.RailsDesign;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class Rail extends GenericCustomBlock {

    // private RpgEssentials plugin;
    public Rail(RpgEssentials plugin, int base, boolean rotate, String name,
            int[] textureids) {
        super(plugin, name, base, rotate);
        this.setBlockDesign(new RailsDesign(plugin, textureids));
        // this.plugin = plugin;
    }

    @Override
    public void onEntityMoveAt(World world, int x, int y, int z, Entity entity) {
    }
}
