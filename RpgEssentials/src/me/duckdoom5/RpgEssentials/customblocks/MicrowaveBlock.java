package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.customdesigns.MicrowaveDesign;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;

public class MicrowaveBlock extends GenericCubeCustomBlock {
    private static int[] id = { 6, 4, 3, 5, 3, 3 };

    public MicrowaveBlock(RpgEssentials plugin) {
        super(plugin, "Microwave", false, new GenericCubeBlockDesign(plugin,
                RpgeManager.getInstance().misc, id));
        this.setBlockDesign(new MicrowaveDesign(plugin));
        setRotate(true);
    }
}