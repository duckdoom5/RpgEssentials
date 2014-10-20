package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomBlock extends GenericCustomBlock {
    private final int light = 1;
    float hard = 1, friction = 0;

    public CustomBlock(RpgEssentials plugin, String name, int[] ids,
            boolean opaque, int light, int base, boolean canRotate) {
        super(plugin, name, base, new GenericCubeBlockDesign(plugin,
                RpgeManager.getInstance().blocks, ids), canRotate);
        setLightLevel(light);
        setOpaque(opaque);
    }

    public CustomBlock(RpgEssentials plugin, String name, int base,
            boolean canRotate, GenericBlockDesign design) {
        super(plugin, name, base, design, canRotate);
        setLightLevel(light);
    }

    public float gethardness() {
        return hard;
    }
}
