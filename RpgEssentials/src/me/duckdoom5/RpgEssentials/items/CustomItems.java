package me.duckdoom5.RpgEssentials.items;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class CustomItems extends GenericCustomItem {

    public CustomItems(Plugin plugin, String name, String texture) {
        super(plugin, name, texture);
        SpoutManager.getFileManager().addToPreLoginCache(plugin, texture);
    }
}
