package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.CustomSlabDesign;

public class CustomSlab extends GenericCustomBlock {
	public CustomSlab(RpgEssentials plugin, String name, int[] textureids) {
		super(plugin, name, 44, false);
		this.setBlockDesign(new CustomSlabDesign(plugin, textureids));
	}
}
