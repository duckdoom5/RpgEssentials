package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.Material;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class OriginalOre {
	private int minY = 2, maxY = 128, freq = 0, size = 4;
	Material material;
	
	public OriginalOre(RpgEssentials plugin, Material material, int freq , int size, int minY, int maxY){
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.size = size;
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
	public int getSize() {
		return this.size;
	}
}
