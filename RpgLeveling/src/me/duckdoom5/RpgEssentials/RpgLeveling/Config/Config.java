package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

public class Config {
	public static void set(){
		if(!Configuration.config.contains("Background")){
			Configuration.config.set("Background", "http://rpgessentials.lynxdragon.com/plugin/textures/gui/bg.png");
		}
		if(!Configuration.config.contains("Allow key")){
			Configuration.config.set("Allow key", true);
		}
		if(!Configuration.config.contains("Key")){
			Configuration.config.set("Key", "l");
		}
	}
}
