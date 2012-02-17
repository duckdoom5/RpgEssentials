package me.duckdoom5.RpgEssentials.blocks.ores;

import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.CustomItem;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomOres extends CustomOresDesign {
	private float hard = null;
	private float friction = null;
	private int light = 1;
	private int amount = 1;
	private CustomBlock = null;
	private CustomItem = null;

	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, float hard, int light, float friction)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomItem drop)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomItem drop, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomBlock drop, float hard, int light, float friction)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
	public CustomOres(RpgEssentials plugin,String name, int textureid, int freq, int minY, int maxY, CustomBlock drop, float hard, int light, float friction, int amount)
	{
		super(plugin, name, textureid, freq, minY, maxY, hard, light, friction, drop, amount);
	}
}
