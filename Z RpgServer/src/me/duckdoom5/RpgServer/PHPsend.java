package me.duckdoom5.RpgServer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.shadowz.phpsend.PhpSendPlugin;

public class PHPsend extends PhpSendPlugin{

	@Override
	public boolean onWebCommand(String cmd) {
		if (cmd.equals("getServerInfo")){
			//world name, on players/max players, special stuff
			
			send(RpgServer.sm.getWorldName(Bukkit.getServer().getIp()));
			
			Player players[]=Bukkit.getServer().getOnlinePlayers();
			send(Integer.toString(players.length));
			send(Integer.toString(Bukkit.getServer().getMaxPlayers()));
			
			return false;
		}else if (cmd.equals("PHPgetOnlinePlayers")){
			Player players[]=Bukkit.getServer().getOnlinePlayers();
			send(""+players.length);
			send(""+Bukkit.getServer().getMaxPlayers());
			for (Player p : players)
				send(p.getName());
			return false;
		}
			
		return true;
	}
}
