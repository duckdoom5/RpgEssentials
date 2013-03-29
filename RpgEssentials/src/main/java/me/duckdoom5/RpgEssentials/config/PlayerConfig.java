package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.accessories.AccessoryType;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import net.milkbowl.vault.economy.Economy;

public class PlayerConfig {

	public static Economy economy = null;
	
	public static void set(){}
	
	public static void addCape(Player player, String url){
		Configuration.players.set("players." + player.getName() + ".cape", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTitle(Player player, String title) {
		Configuration.players.set("players." + player.getName() + ".title", title);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void hidetitle(Player player){
		Configuration.players.set("players." + player.getName() + ".hidetitle", true);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addSpeed(Player player, double speed){
		Configuration.players.set("players." + player.getName() + ".speed", speed);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addSkin(Player player, String url){
		Configuration.players.set("players." + player.getName() + ".skin", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addJump(Player player, double height) {
		Configuration.players.set("players." + player.getName() + ".jump", height);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addGravity(Player player, double gravity) {
		Configuration.players.set("players." + player.getName() + ".gravity", gravity);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addAccessory(Player player,AccessoryType type, String url) {
		Configuration.players.set("players." + player.getName() + "." + type.toString().toLowerCase(), url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addPlayer(Player player){
		String playername = player.getName();
		if(!Configuration.players.contains("players."+ player.getName() + ".title")){
			RpgEssentials.log.info("[RpgEssentials] Adding new player to config...");
			Configuration.players.set("players." + playername + ".title", playername);
			Configuration.players.set("players." + playername + ".money", Configuration.config.getInt("player.starting money"));
			try {
				Configuration.players.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			RpgEssentials.log.info("[RpgEssentials] Added "+ playername +" to config!");
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