package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class RpgBlock extends GenericCustomBlock {
	public RpgBlock(RpgEssentials plugin, String name, int[] ids, float hard2, int light2, float friction2, int base, boolean canRotate, GenericBlockDesign design) {
		super(plugin, name, base, canRotate);
		this.setBlockDesign(design);
		this.setHardness(hard2);
		this.setLightLevel(light2);
	}
}
