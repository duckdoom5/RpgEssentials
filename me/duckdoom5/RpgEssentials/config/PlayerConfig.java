package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;

import net.milkbowl.vault.economy.Economy;

public class PlayerConfig {
	
	public static Economy economy = null;
	
	public static void set(){

		if(!Configuration.players.contains("players.examplename.title")){
			Configuration.players.set("players.examplename.title", "example title");
		}
		if(!Configuration.players.contains("players.examplename.hidetitle")){
			Configuration.players.set("players.examplename.hidetitle", false);
		}
		if(!Configuration.players.contains("players.examplename.cape")){
			Configuration.players.set("players.examplename.cape", "http://example url.com");
		}
		if(!Configuration.players.contains("players.examplename.speed")){
			Configuration.players.set("players.examplename.speed", 1);
		}
		if(!Configuration.players.contains("players.examplename.skin")){
			Configuration.players.set("players.examplename.skin", "http://example url.com");
		}
		if(!Configuration.players.contains("players.examplename.money")){
			Configuration.players.set("players.examplename.money", 1000);
		}
		
	}
	
	public static double getMoney(String playername){
		if (economy!=null)
			return economy.getBalance(playername);
		return Configuration.players.getDouble("players." + playername + ".money");
	}
	
	public static void setMoney(String playername, double m){
		if (economy==null){
			Configuration.players.set("players." + playername + ".money", m);
			try {
				Configuration.players.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			double current = getMoney(playername);
			double newm = m - current;
			if (newm < current)
				economy.withdrawPlayer(playername, Math.abs(newm));
			else
				economy.depositPlayer(playername, newm);
		}
	}

}
