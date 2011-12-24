package me.duckdoom5.RpgEssentials.blocks.plants;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;


public class CustomBush extends GenericCubeCustomBlock {
	private RpgEssentials plugin;
	public CustomBush(RpgEssentials plugin, int[] textureids, int freq) {
		super(plugin, "Empty Bush", false, new GenericCubeBlockDesign(plugin, plugin.plants,textureids));
		this.setBlockDesign(new CustomBushDesign(plugin, textureids, freq));
		this.plugin = plugin;
	}
}
