package me.duckdoom5.RpgEssentials.RpgPets.Config;

public class Config {
	public static void set(){
		if(!Configuration.config.contains("deathchest.protect time in minutes")){
			Configuration.config.set("deathchest.protect time in minutes", 2);
		}
		if(!Configuration.config.contains("deathchest.unprotect time in minutes")){
			Configuration.config.set("deathchest.unprotect time in minutes", 2);
		}
	}
}
