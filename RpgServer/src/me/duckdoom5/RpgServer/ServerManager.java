package me.duckdoom5.RpgServer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ServerManager {
	private HashMap<String, RpgServerData> servers = new LinkedHashMap<String, RpgServerData>();
	private HashMap<String, String> worlds = new LinkedHashMap<String, String>();
	
	public void registerServers() {
		RpgServerData server1 = new RpgServerData("82.74.70.243", 25565);
		
		servers.put("world1", server1);
		worlds.put("82.74.70.243", "world1");
	}
	
	public RpgServerData[] getServers(){
		return servers.values().toArray(new RpgServerData[servers.values().size()]);
	}
	
	public String getWorldName(String ip){
		return worlds.get(ip);
	}
}
