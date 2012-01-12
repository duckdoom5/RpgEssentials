package me.duckdoom5.RpgEssentials.blocks.ores;

import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.CustomItem;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomOres extends CustomOresDesign {

	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY)
	{
		super(plugin, name, textureid, freq, minY, maxY);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomBlock drop, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, drop ,amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomItem drop, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, drop ,amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, float hard, int light, float friction)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, float hard, int light, float friction, CustomBlock drop, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, float hard, int light, float friction, CustomItem drop, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
}
