package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.RpgBankManager;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SafeBlock extends GenericCustomBlock {
    public SafeBlock(RpgEssentials plugin, String name, int[] id) {
        super(plugin, name, 42, true);
        this.setBlockDesign(new GenericCubeBlockDesign(plugin, RpgeManager.getInstance().misc, id));
    }

    @Override
    public boolean onBlockInteract(World world, int x, int y, int z,
            SpoutPlayer splayer) {
        RpgBankManager.getInstance().getBank(splayer.getName()).open();
        return true;
    }
}
