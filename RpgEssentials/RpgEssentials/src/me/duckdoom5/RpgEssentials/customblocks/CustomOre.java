package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
	
	public class CustomOre extends GenericCustomBlock {
		private int minY = 2, maxY = 128, freq = 0, size = 4;
		float hard = 1, friction = 0;
		
	public CustomOre(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, int size, org.getspout.spoutapi.material.Material drop, float hard, int light, float friction, int amount, int base){
		super(plugin, name, base, new GenericCubeBlockDesign(plugin, plugin.ores, textureid));
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.hard = hard;
		//this.friction = friction;
		this.size = size;
		this.setHardness(hard);
		this.setLightLevel(light);
		//this.setFriction(friction);
		if(drop != null){
			this.setItemDrop(new SpoutItemStack(drop,amount>1?amount:1));
		}
	}
	
	public CustomOre(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, int size, Material drop, float hard, int light, float friction, int amount, int base)
	{
		super(plugin, name, base, new GenericCubeBlockDesign(plugin, plugin.ores, textureid));
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.hard = hard;
		//this.friction = friction;
		this.size = size;
		this.setHardness(hard);
		this.setLightLevel(light);
		//this.setFriction(friction);
		if(drop != null){
			this.setItemDrop(new ItemStack(drop,amount));
		}
	}

	public int getFreq(){
		return this.freq;
	}
	public int getMinY(){
		return this.minY;
	}
	public int getMaxY(){
		return this.maxY;
	}
	public float getHardness(){
		return this.hard;
	}
	public int getSize() {
		return this.size;
	}
}