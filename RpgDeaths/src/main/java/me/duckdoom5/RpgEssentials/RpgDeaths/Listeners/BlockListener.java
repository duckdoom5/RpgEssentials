package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener{
	public static Map<Location, String> protect = new HashMap<Location, String>();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) throws Exception{
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		if(block.getType().equals(Material.CHEST)){
			if(protect.containsKey(block.getLocation())){
				player.sendMessage(ChatColor.RED + "You can't destroy a death chest");
				event.setCancelled(true);
			}
		}
	}
}
