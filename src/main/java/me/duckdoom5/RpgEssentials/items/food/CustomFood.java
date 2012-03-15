package me.duckdoom5.RpgEssentials.items.food;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomFood extends GenericCustomFood{

	int restore;
	
	public CustomFood(Plugin plugin, String name, String texture, int restore) {
		super(plugin, name, texture, restore);
		this.restore = restore;
	}

	public boolean onItemInteract(SpoutPlayer player, SpoutBlock block, org.bukkit.block.BlockFace face){
		player.setHealth(restore);
		return true;
	}
}
