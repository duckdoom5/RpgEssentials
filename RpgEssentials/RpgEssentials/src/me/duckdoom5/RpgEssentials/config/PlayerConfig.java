package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import net.milkbowl.vault.economy.Economy;

public class PlayerConfig {

	public static Economy economy = null;
	
		public static void set(){
		
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
		} else {
			double current = getMoney(playername);
			double newm = m - current;
			if (m < current)
				economy.withdrawPlayer(playername, Math.abs(newm));
			else
				economy.depositPlayer(playername, newm);
		}
	}
	
	public static void setExp(String playername, Skill skill, int exp){
		Configuration.players.set("players." + playername + "." + skill.toString().toLowerCase() + ".exp", exp);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}