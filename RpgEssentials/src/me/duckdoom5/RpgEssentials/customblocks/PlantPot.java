package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.PlantPotDesign;


public class PlantPot extends GenericCubeCustomBlock {
	public PlantPot(RpgEssentials plugin, int[] textureids) {
		super(plugin, "Plant Pot", false, new GenericCubeBlockDesign(plugin, plugin.plants,textureids));
		this.setBlockDesign(new PlantPotDesign(plugin, textureids));
	}
}