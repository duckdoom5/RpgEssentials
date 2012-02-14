package me.duckdoom5.RpgEssentials.config;

public class Config {

	public static void set(){
		if(!Configuration.config.contains("Ores Texture")){
			Configuration.config.set("Ores Texture", "http://82.74.70.243/server/textures/ores.png");
		}
		if(!Configuration.config.contains("Blocks Texture")){
			Configuration.config.set("Blocks Texture", "http://82.74.70.243/server/textures/blocks.png");
		}
		if(!Configuration.config.contains("Stairs Texture")){
			Configuration.config.set("Stairs Texture", "http://82.74.70.243/server/textures/trap.png");
		}
		if(!Configuration.config.contains("Plants Texture")){
			Configuration.config.set("Plants Texture", "http://82.74.70.243/server/textures/plants.png");
		}
		if(!Configuration.config.contains("Misc Texture")){
			Configuration.config.set("Misc Texture", "http://82.74.70.243/server/textures/misc.png");
		}
		if(!Configuration.config.contains("player.join.enabeld")){
			Configuration.config.set("player.join.enabled",true);
		}
		if(!Configuration.config.contains("player.leave.enabeld")){
			Configuration.config.set("player.leave.enabeld",true);
		}
		if(!Configuration.config.contains("player.starting money")){
			Configuration.config.set("player.starting money",100);
		}
		if(!Configuration.config.contains("store.allow")){
			Configuration.config.set("store.allow", false);
		}
		if(!Configuration.config.contains("store.key")){
			Configuration.config.set("store.key", "o");
		}
		if(!Configuration.config.contains("stats.allow")){
			Configuration.config.set("stats.allow", true);
		}
		if(!Configuration.config.contains("stats.key")){
			Configuration.config.set("stats.key", "l");
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
		if(!Configuration.config.contains("texturepack.default")){
			Configuration.config.set("texturepack.default","http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");
		}
		if(!Configuration.config.contains("texturepack.worldname")){
			Configuration.config.set("texturepack.worldname","http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");
		}
	}
}