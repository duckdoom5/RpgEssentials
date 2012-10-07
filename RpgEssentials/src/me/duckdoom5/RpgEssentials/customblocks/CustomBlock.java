package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomBlock extends GenericCustomBlock {
	private int light = 1;
	float hard = 1, friction = 0;
	
	public CustomBlock(RpgEssentials plugin, String name, int[] ids, boolean opaque, float hard, int light, float friction, int base, boolean canRotate){
		super(plugin, name, base, new GenericCubeBlockDesign(plugin, plugin.blocks, ids), canRotate);
		this.setLightLevel(light);
		this.setOpaque(opaque);
	}
	
	public CustomBlock(RpgEssentials plugin, String name, int[] ids, float hard2, int light2, float friction2, int base, boolean canRotate, GenericBlockDesign design) {
		super(plugin, name, base, design, canRotate);
		this.setLightLevel(light);
	}

	public float gethardness(){
		return this.hard;	
	}
}
