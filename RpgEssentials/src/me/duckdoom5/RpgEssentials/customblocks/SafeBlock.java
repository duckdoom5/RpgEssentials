package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class SafeBlock extends GenericCustomBlock{
	public SafeBlock(RpgEssentials plugin, String name, int[] id) {
		super(plugin, name, 42, true);
		this.setBlockDesign(new GenericCubeBlockDesign(plugin, plugin.misc, id));
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
		RpgEssentials.pm.getRpgPlayerBank(splayer).getBank().open();
		return true;
	}
}
