package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.entity.Player;

public class ConfigAdd {
	
	public static void addplayer(Player player){
		if(!Configuration.players.contains("players."+ player.getName() + ".title")){
			RpgEssentials.log.info("[RpgEssentials] Adding new player to config...");
			Configuration.players.set("players." + player.getName() + ".title", player.getName());
			Configuration.players.set("players." + player.getName() + ".money", Configuration.config.getInt("player.starting money"));
			Configuration.players.set("players." + player.getName() + ".Mining.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Mining.level", 1);
			Configuration.players.set("players." + player.getName() + ".Woodcutting.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Woodcutting.level", 1);
			Configuration.players.set("players." + player.getName() + ".Excavation.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Excavation.level", 1);
			Configuration.players.set("players." + player.getName() + ".Farming.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Farming.level", 1);
			Configuration.players.set("players." + player.getName() + ".Attack.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Attack.level", 1);
			Configuration.players.set("players." + player.getName() + ".Defense.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Defense.level", 1);
			Configuration.players.set("players." + player.getName() + ".Ranged.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Ranged.level", 1);
			Configuration.players.set("players." + player.getName() + ".Firemaking.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Firemaking.level", 1);
			Configuration.players.set("players." + player.getName() + ".Cooking.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Cooking.level", 1);
			Configuration.players.set("players." + player.getName() + ".Construction.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Construction.level", 1);
			Configuration.players.set("players." + player.getName() + ".Smithing.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Smithing.level", 1);
			Configuration.players.set("players." + player.getName() + ".Fishing.exp", 0);
			Configuration.players.set("players." + player.getName() + ".Fishing.level", 1);
			Configuration.players.set("players." + player.getName() + ".combatlvl", 3);
			RpgEssentials.log.info("[RpgEssentials] Added "+ player.getName() +" to config!");
		}
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cape(Player player, String url){
		Configuration.players.set("players." + player.getName() + ".cape", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void capeother(String cmdplayer, String url) {
		Configuration.players.set("players." + cmdplayer + ".cape", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void title(Player player, String title) {
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
	
	public static void titleother(String cmdplayer, String title){
		Configuration.players.set("players." + cmdplayer + ".title", title);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void speed(Player player, double speed){
		Configuration.players.set("players." + player.getName() + ".speed", speed);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void speedother(String cmdplayer, double speed){
		Configuration.players.set("players." + cmdplayer + ".speed", speed);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void skin(Player player, String url){
		Configuration.players.set("players." + player.getName() + ".skin", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void skinother(String cmdplayer, String url){
		Configuration.players.set("players." + cmdplayer + ".skin", url);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void jump(Player player, double height) {
		Configuration.players.set("players." + player.getName() + ".jump", height);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void jumpother(String cmdplayer, double height){
		Configuration.players.set("players." + cmdplayer + ".speed", height);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}