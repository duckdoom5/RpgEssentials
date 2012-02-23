package me.duckdoom5.RpgEssentials.items.tools;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.item.GenericCustomTool;

public class CustomTools extends GenericCustomTool{

	public CustomTools(Plugin plugin, String name, String texture, short durability) {
		super(plugin, name, texture);
		this.setDurability(durability);
	}
}
