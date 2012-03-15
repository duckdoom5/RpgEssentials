package me.duckdoom5.RpgEssentials.blocks.misc;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.banking.Bank;

public class SafeBlock extends GenericCubeCustomBlock{
	private RpgEssentials plugin;
	public SafeBlock(RpgEssentials plugin, String name, int[] id) {
		super(plugin, name, false, new GenericCubeBlockDesign(plugin, plugin.misc,id));
		//this.setBlockDesign(new SafeDesign(plugin,id));
		this.plugin = plugin;
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
	Bank.open(plugin, splayer);
	return true;
	}
}
