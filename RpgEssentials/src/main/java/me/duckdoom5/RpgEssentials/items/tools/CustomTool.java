package me.duckdoom5.RpgEssentials.items.tools;

import me.duckdoom5.RpgEssentials.util.ToolType;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.item.GenericCustomTool;

public class CustomTool extends GenericCustomTool{
	
	private ToolType tooltype;
	
	public CustomTool(Plugin plugin, String name, String texture, short durability, ToolType tooltype) {
		super(plugin, name, texture);
		this.setStackable(false);
		this.setMaxDurability(durability);
		this.tooltype = tooltype;
		SpoutManager.getFileManager().addToPreLoginCache(plugin, texture);
		this.setStrengthModifier(MaterialData.stone, 2.0F);
	}
	
	public ToolType getToolType(){
		return this.tooltype;
	}
}
