package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.CustomFlowerDesign;

public class CustomFlower extends GenericCustomBlock {
	public CustomFlower(RpgEssentials plugin, String name, int[] textureids, int freq) {
		super(plugin, name, 38, false);
		this.setBlockDesign(new CustomFlowerDesign(plugin, textureids));
	}
}
