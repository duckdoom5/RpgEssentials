package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.CustomStairDesign;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomStair extends GenericCustomBlock {
    public CustomStair(RpgEssentials plugin, String name, int[] textureids) {
        super(plugin, name, 53, true);
        this.setBlockDesign(new CustomStairDesign(plugin, textureids));
    }
}
