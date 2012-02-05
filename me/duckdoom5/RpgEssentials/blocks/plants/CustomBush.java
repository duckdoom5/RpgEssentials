package me.duckdoom5.RpgEssentials.blocks.plants;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;


public class CustomBush extends GenericCubeCustomBlock {
	private RpgEssentials plugin;
	public CustomBush(RpgEssentials plugin,String name, int[] textureids, int freq) {
		super(plugin, name, false, new GenericCubeBlockDesign(plugin, plugin.plants,textureids));
		this.setBlockDesign(new CustomBushDesign(plugin, textureids, freq));
		this.plugin = plugin;
	}
}
