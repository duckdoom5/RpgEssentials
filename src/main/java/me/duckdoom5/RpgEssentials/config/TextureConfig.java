package me.duckdoom5.RpgEssentials.config;

public class TextureConfig {

	public static void set(){
		if(!Configuration.texture.contains("Ores Texture")){
			Configuration.texture.set("Ores Texture", "http://82.74.70.243/server/textures/ores.png");
		}
		if(!Configuration.texture.contains("Blocks Texture")){
			Configuration.texture.set("Blocks Texture", "http://82.74.70.243/server/textures/blocks.png");
		}
		if(!Configuration.texture.contains("Stairs Texture")){
			Configuration.texture.set("Stairs Texture", "http://82.74.70.243/server/textures/stairs.png");
		}
		if(!Configuration.texture.contains("Plants Texture")){
			Configuration.texture.set("Plants Texture", "http://82.74.70.243/server/textures/plants.png");
		}
		if(!Configuration.texture.contains("Misc Texture")){
			Configuration.texture.set("Misc Texture", "http://82.74.70.243/server/textures/misc.png");
		}
	}
}
