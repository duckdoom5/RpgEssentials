package me.duckdoom5.RpgEssentials.RpgDeaths;

import java.util.HashMap;
import java.util.Map;

public class DeathChests {
	public static Map<String, DeathPlayer> deathplayers = new HashMap<String, DeathPlayer>();
	
	public static DeathPlayer getDeathPlayer(String playername){
		return deathplayers.get(playername);
	}
	
	public static boolean isDeath(String playername){
		return deathplayers.containsKey(playername);
	}
}
