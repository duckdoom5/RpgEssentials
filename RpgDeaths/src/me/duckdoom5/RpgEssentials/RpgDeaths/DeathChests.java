package me.duckdoom5.RpgEssentials.RpgDeaths;

import java.util.HashMap;
import java.util.Map;

public class DeathChests {
    public static Map<String, DeadPlayer> deathplayers = new HashMap<>();

    public static DeadPlayer getDeathPlayer(String playername) {
        return deathplayers.get(playername);
    }

    public static boolean isDeath(String playername) {
        return deathplayers.containsKey(playername);
    }
}
