package me.duckdoom5.RpgServer;

import org.bukkit.Bukkit;

public class API {
	
	//CENRAL SERVER CODE
	
	public static void requestServerInfo(){
		if(Bukkit.getServer().getIp().equals(RpgServer.CsIP)){
			for(RpgServerData server:RpgServer.sm.getServers()){
				server.requestData();
			}
		}
	}
	
	//OTHER SERVER CODE
}
