package me.duckdoom5.RpgServer.listener;

import me.duckdoom5.RpgServer.RpgServer;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class RpgServerBlockListener  implements Listener{
	public static RpgServer plugin;
	
	public RpgServerBlockListener(RpgServer instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
	}
}
