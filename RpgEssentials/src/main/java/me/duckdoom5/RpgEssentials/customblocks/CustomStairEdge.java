package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.CustomStairEdgeDesign;


public class CustomStairEdge extends GenericCustomBlock {
	public CustomStairEdge(RpgEssentials plugin, String name, int[] textureids) {
		super(plugin, name, 53, true);
		this.setBlockDesign(new CustomStairEdgeDesign(plugin,textureids));
	}
}
