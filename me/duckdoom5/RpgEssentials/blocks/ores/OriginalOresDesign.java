package me.duckdoom5.RpgEssentials.blocks.ores;

import org.bukkit.Material;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class OriginalOresDesign {
	private int minY = 2, maxY = 128, freq = 0;
	Material material;
	
	public OriginalOresDesign(RpgEssentials plugin, Material material, int freq , int minY, int maxY){
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.material = material;
	}
	public int getfreq(){
		return this.freq;	
	}
	public Material getmaterial(){
		return this.material;	
	}
	public int getminY(){
		return this.minY;	
	}
	public int getmaxY(){
		return this.maxY;	
	}
}
