package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.customdesigns.LaptopDesign;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LaptopBlockE extends GenericCubeCustomBlock{
	private static int[] id = {0,0,0,0,0,0};
	public LaptopBlockE(RpgEssentials plugin) {
		super(plugin, "Laptop(E)", false,new GenericCubeBlockDesign(plugin, plugin.misc, id));
		this.setBlockDesign(new LaptopDesign(plugin, plugin.misc, "East"));
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
		//LevelMenu.open(plugin, splayer);
		return true;
	}
}
