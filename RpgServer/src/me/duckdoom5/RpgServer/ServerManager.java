package me.duckdoom5.RpgServer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ServerManager {
    private final HashMap<String, RpgServerData> servers = new LinkedHashMap<>();
    private final HashMap<String, String> worlds = new LinkedHashMap<>();

    public void registerServers() {
        final RpgServerData server1 = new RpgServerData("82.74.70.243", 25565);

        servers.put("world1", server1);
        worlds.put("82.74.70.243", "world1");
    }

    public RpgServerData[] getServers() {
        return servers.values().toArray(
                new RpgServerData[servers.values().size()]);
    }

    public String getWorldName(String ip) {
        return worlds.get(ip);
    }
}
