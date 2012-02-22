package me.duckdoom5.RpgEssentials.blocks.ores;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.CustomItem;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
	
	public class CustomOres extends GenericCubeCustomBlock {
		private int minY = 2, maxY = 128, freq = 0, light = 1;
		float hard = 1, friction = 0;
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomItem drop, float hard, int light, float friction, int amount){
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureid));
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
	
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomBlock drop, float hard, int light, float friction, int amount)
	{
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureid));
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
	
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, Material drop, float hard, int light, float friction, int amount)
	{
		super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.ores, textureid));
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
}