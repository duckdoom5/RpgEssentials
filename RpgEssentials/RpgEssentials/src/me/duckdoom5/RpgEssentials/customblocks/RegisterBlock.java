package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreSelectGui;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.Stores;
import me.duckdoom5.RpgEssentials.customdesigns.RegisterDesign;

import org.bukkit.World;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RegisterBlock extends GenericCustomBlock{
	public RegisterBlock(RpgEssentials plugin) {
		super(plugin, "Register", 20, true);
		this.setBlockDesign(new RegisterDesign(plugin, plugin.misc));
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
		StoreSelectGui gui = new StoreSelectGui((RpgStores) RpgEssentials.RpgStores, splayer, x, y, z);
		//StoreMenu.open(plugin, splayer, x, y, z);
		return true;
	}
	
	@Override
	public void onBlockPlace(World world, int x, int y, int z){
		Stores.place(x, y, z, "all");
	}
	
	@Override
	public void onBlockDestroyed(World world, int x, int y, int z){
		Stores.remove(x, y, z);
	}
}