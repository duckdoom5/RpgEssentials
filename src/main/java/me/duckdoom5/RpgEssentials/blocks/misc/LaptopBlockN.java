package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LaptopBlockN  extends GenericCubeCustomBlock{
	private static int[] id = {0,0,0,0,0,0};
	private RpgEssentials plugin;
	public LaptopBlockN(RpgEssentials plugin) {
		super(plugin, "Laptop(N)", false,new GenericCubeBlockDesign(plugin, plugin.misc, id));
		this.setBlockDesign(new LaptopDesign(plugin, plugin.misc, "North"));
		this.plugin = plugin;
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
		LevelMenu.open(plugin, splayer);
		return true;
	}

}
