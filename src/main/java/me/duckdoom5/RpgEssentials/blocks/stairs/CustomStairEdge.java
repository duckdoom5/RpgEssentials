package me.duckdoom5.RpgEssentials.blocks.stairs;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;


public class CustomStairEdge extends GenericCubeCustomBlock {
	private RpgEssentials plugin;
	private static int [] textureids = {0,0,0,0,0,0};
	public CustomStairEdge(RpgEssentials plugin) {
		super(plugin, "Golden Stair Edge", false, new GenericCubeBlockDesign(plugin, plugin.stairs,textureids));
		this.setBlockDesign(new CustomStairEdgeDesign(plugin,textureids));
		this.plugin = plugin;
	}
}
