package me.duckdoom5.RpgServer.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreakDoorEvent;

public class RpgServerEntityListener implements Listener{
	
	@EventHandler
	public void onEntityBreakDoorEventEvent(EntityBreakDoorEvent event){
		event.setCancelled(true);
	}
}
