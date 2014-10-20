package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.customdesigns.AnvilDesign;

import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class AnvilBlock extends GenericCustomBlock {
    public AnvilBlock(RpgEssentials plugin) {
        super(plugin, "Anvil", 20, true);
        this.setBlockDesign(new AnvilDesign(plugin, RpgeManager.getInstance().misc));
        setRotate(true);
    }

    /*
     * @Override public boolean onBlockInteract(World world, int x, int y, int
     * z, SpoutPlayer splayer) { AnvilGUI.open(plugin, splayer); return true; }
     */
}