package me.duckdoom5.RpgEssentials.RpgStores.Config;

public class Config {
	public static void set(){
		if(!Configuration.config.contains("Allow key")){
			Configuration.config.set("Allow key", false);
		}
		
		if(!Configuration.config.contains("Key")){
			Configuration.config.set("Key", "o");
		}
		
		if(!Configuration.config.contains("Background")){
			Configuration.config.set("Background", "http://dl.lynxdragon.com/rpgessentials/textures/gui/bg.png");
		}
	}
}
