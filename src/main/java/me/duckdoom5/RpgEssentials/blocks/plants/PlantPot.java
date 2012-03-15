package me.duckdoom5.RpgEssentials.blocks.plants;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;


public class PlantPot extends GenericCubeCustomBlock {
	private RpgEssentials plugin;
	public PlantPot(RpgEssentials plugin, int[] textureids) {
		super(plugin, "Plant Pot", false, new GenericCubeBlockDesign(plugin, plugin.plants,textureids));
		this.setBlockDesign(new PlantPotDesign(plugin, textureids));
		this.plugin = plugin;
	}
}