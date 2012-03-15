package me.duckdoom5.RpgEssentials.blocks.block;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

public class CustomBlockDesign extends GenericCubeCustomBlock{
	private int light = 1;
	float hard = 1, friction = 0;
	
	public CustomBlockDesign(RpgEssentials plugin, String name, int textureID, float hard, int light, float friction){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.blocks, textureID));
		this.setLightLevel(light);
	}
	public float gethardness(){
		return this.hard;	
	}
}