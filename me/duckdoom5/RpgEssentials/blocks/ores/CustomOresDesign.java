package me.duckdoom5.RpgEssentials.blocks.ores;


import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;


public class CustomOresDesign extends GenericCubeCustomBlock{
	private int minY = 2, maxY = 128, freq = 0;
	
	public CustomOresDesign(RpgEssentials plugin, String name, int textureId, int freq , int minY, int maxY){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureId));
		this.setLightLevel(1);
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
	}
	public CustomOresDesign(RpgEssentials plugin, String name, int textureId, int freq , int maxY, int minY, float hardness){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureId));
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.setHardness(hardness);
	}
	public int getfreq(){
		return this.freq;	
	}
	public int getminY(){
		return this.minY;	
	}
	public int getmaxY(){
		return this.maxY;	
	}
}