package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreSelectGui;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.Stores;
import me.duckdoom5.RpgEssentials.customdesigns.RegisterDesign;

import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
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
		return true;
	}
	
	@Override
	public void onBlockPlace(World world, int x, int y, int z, LivingEntity living){
		if(living instanceof SpoutPlayer){
			if(GuiManager.gui.get(living) == null){
				Stores.create(x, y, z, (SpoutPlayer)living);
			}
		}
	}
	
	@Override
	public void onBlockDestroyed(World world, int x, int y, int z){
		Stores.remove(x, y, z);
	}
}