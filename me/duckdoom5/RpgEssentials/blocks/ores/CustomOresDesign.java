package me.duckdoom5.RpgEssentials.blocks.ores;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

public class CustomOresDesign extends GenericCubeCustomBlock{
	private int minY = 2, maxY = 128, freq = 0, light = 1;
	float hard = 1, friction = 0;
	
	public CustomOresDesign(RpgEssentials plugin, String name, int textureId, int freq , int minY, int maxY, float hard, int light, float friction, CustomBlock drop, int amount){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureId));
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.hard = hard;
		this.light = light;
		this.friction = friction;
		this.setHardness(hard);
		this.setLightLevel(light);
		this.setFriction(friction);
		if(drop != null){
			this.setItemDrop(new SpoutItemStack(drop,amount));
		}
	}
	public CustomOresDesign(RpgEssentials plugin, String name, int textureId, int freq , int minY, int maxY, float hard, int light, float friction, CustomItem drop, int amount){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureId));
		this.minY = minY;
		this.maxY = maxY;
		this.freq = freq;
		this.hard = hard;
		this.light = light;
		this.friction = friction;
		this.setHardness(hard);
		this.setLightLevel(light);
		this.setFriction(friction);
		if(drop != null){
			this.setItemDrop(new SpoutItemStack(drop,amount));
		}
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
	public float gethardness(){
		return this.hard;	
	}
}