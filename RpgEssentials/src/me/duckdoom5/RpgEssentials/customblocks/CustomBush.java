package me.duckdoom5.RpgEssentials.customblocks;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.CustomBushDesign;


public class CustomBush extends GenericCustomBlock {
	public CustomBush(RpgEssentials plugin,String name, int[] textureids, int freq) {
		super(plugin, name, 18, true);
		this.setBlockDesign(new CustomBushDesign(plugin, textureids, freq));
	}
}
