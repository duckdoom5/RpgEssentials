package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.accessories.AccessoryType;

public class ConfigAdd {
	
	public static void addPlayer(Player player){
		if(!Configuration.players.contains("players."+ player.getName() + ".title")){
			RpgEssentials.log.info("[RpgEssentials] Adding new player to config...");
			Configuration.players.set("players." + player.getName() + ".title", player.getName());
			Configuration.players.set("players." + player.getName() + ".money", Configuration.config.getInt("player.starting money"));
			
			RpgEssentials.log.info("[RpgEssentials] Added "+ player.getName() +" to config!");
		}
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
}