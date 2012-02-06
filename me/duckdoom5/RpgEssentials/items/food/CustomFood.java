package me.duckdoom5.RpgEssentials.items.food;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.item.GenericCustomFood;

public class CustomFood extends GenericCustomFood{

	public CustomFood(Plugin plugin, String name, String texture, int restore) {
		super(plugin, name, texture, restore);
	}

}
