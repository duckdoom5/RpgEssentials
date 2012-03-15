package me.duckdoom5.RpgEssentials.blocks.stairs;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;


public class CustomStair extends GenericCubeCustomBlock {
	private RpgEssentials plugin;
	private static int[] textureids = {0,0,0,0,0,0};
	public CustomStair(RpgEssentials plugin) {
		super(plugin, "Golden Stairs", false, new GenericCubeBlockDesign(plugin, plugin.stairs, textureids));
		this.setBlockDesign(new CustomStairDesign(plugin, textureids));
		this.plugin = plugin;
	}
}
