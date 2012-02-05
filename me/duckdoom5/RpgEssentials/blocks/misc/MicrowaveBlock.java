package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

public class MicrowaveBlock extends GenericCubeCustomBlock{
	private static int[] id = {6,4,3,5,3,3};
	private RpgEssentials plugin;
	public MicrowaveBlock(RpgEssentials plugin) {
		super(plugin, "Microwave", false,new GenericCubeBlockDesign(plugin, plugin.misc,id));
		this.setBlockDesign(new MicrowaveDesign(plugin));
		this.plugin = plugin;
	}
}