package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;


public class AnvilBlock extends GenericCubeCustomBlock {
	private static int[] id = {0,0,0,0,0,0};
	private RpgEssentials plugin;

	public AnvilBlock(RpgEssentials plugin) {
		super(plugin, "Anvil", false, new GenericCubeBlockDesign(plugin, plugin.misc, id));
		this.setBlockDesign(new AnvilDesign(plugin, plugin.misc));
		this.plugin = plugin;
	}
}