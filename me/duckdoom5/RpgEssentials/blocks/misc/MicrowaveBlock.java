package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class MicrowaveBlock extends GenericCubeCustomBlock{
	private static int[] id = {3,1,0,2,0,0};
	private RpgEssentials plugin;
	public MicrowaveBlock(RpgEssentials plugin) {
		super(plugin, "Microwave", false,new GenericCubeBlockDesign(plugin, plugin.MiscTextureFile,id));
		this.setBlockDesign(new MicrowaveDesign(plugin));
		this.plugin = plugin;
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
	StoreMenu.open(plugin, splayer);
	return true;
	}
}