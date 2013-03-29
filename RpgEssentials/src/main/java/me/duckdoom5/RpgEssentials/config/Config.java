package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class Config {

	public static void set(){
		
		if(!Configuration.config.contains("player.join.enabled")){
			Configuration.config.set("player.join.enabled",true);
		}
		if(!Configuration.config.contains("player.leave.enabled")){
			Configuration.config.set("player.leave.enabled",true);
		}
		if(!Configuration.config.contains("player.starting money")){
			Configuration.config.set("player.starting money",100);
		}
		if(!Configuration.config.contains("player.close gui on damage")){
			Configuration.config.set("player.close gui on damage",true);
		}
		
		if(!Configuration.config.contains("Options.Key")){
			Configuration.config.set("Options.Key", "r");
		}
		
		if(!Configuration.config.contains("Currency")){
			Configuration.config.set("Currency","Dollar");
		}
		
		if(!Configuration.config.contains("Bronze value")){
			Configuration.config.set("Bronze value",1);
		}
		if(!Configuration.config.contains("Silver value")){
			Configuration.config.set("Silver value",5);
		}
		if(!Configuration.config.contains("Gold value")){
			Configuration.config.set("Gold value",10);
		}
		
		if(!Configuration.config.contains("worlds.enabled")){
			Configuration.config.set("worlds.enabled",Arrays.asList("RPG"));
		}
		
		if(!Configuration.config.contains("custom fish chance")){
			Configuration.config.set("custom fish chance", 40);
		}
		
		if(!Configuration.config.contains("allow version check")){
			Configuration.config.set("allow version check", true);
		}
		
		if(!Configuration.config.contains("spout.leave.messageicon")){
			Configuration.config.set("spout.leave.messageicon",260);
		}
		if(!Configuration.config.contains("spout.join.messageicon")){
			Configuration.config.set("spout.join.messageicon",322);
		}
		if(!Configuration.config.contains("spout.join.message")){
			Configuration.config.set("spout.join.message","Welcome to the server!");
		}
		if(!Configuration.config.contains("spout.join.submessage")){
			Configuration.config.set("spout.join.submessage","Have a good time");
		}
		if(!Configuration.config.contains("spout.precache")){
			Configuration.config.set("spout.precache", Arrays.asList("http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.zip"));
		}
	}
}