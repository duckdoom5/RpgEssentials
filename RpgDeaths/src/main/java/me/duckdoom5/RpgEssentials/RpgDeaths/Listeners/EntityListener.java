package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityListener implements Listener{
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event){
		List<Block> blocks = event.blockList();
		for(Block block:blocks){
			if(block.getType().equals(Material.CHEST)){
				if(BlockListener.protect.containsKey(block.getLocation())){
					blocks.remove(block);
				}
			}
		}
	}
}
