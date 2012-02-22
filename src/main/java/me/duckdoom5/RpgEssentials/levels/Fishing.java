package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;

public class Fishing {

	public static void check(PlayerFishEvent event, RpgEssentials plugin){
		Player player = event.getPlayer();
    	State state = event.getState();
    	if(state == state.CAUGHT_FISH){
    		LevelingSystem.addexp(player, "Fishing", 20, plugin);
    	}
	}
}
