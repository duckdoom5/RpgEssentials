package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;

public class SafeBlock extends GenericCustomBlock{
	public SafeBlock(RpgEssentials plugin, String name, int[] id) {
		super(plugin, name, 20, true);
		this.setBlockDesign(new GenericCubeBlockDesign(plugin, plugin.misc,id));
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
		Bank.open((RpgBanks) RpgEssentials.RpgBanks, splayer);
		return true;
	}
}
