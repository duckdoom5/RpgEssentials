package me.duckdoom5.RpgEssentials.config;

public class TextureConfig {

	public static void set(){
		if(!Configuration.texture.contains("Ores Texture")){
			Configuration.texture.set("Ores Texture", "http://dl.dropbox.com/u/62672791/textures/ores.png");
		}
		if(!Configuration.texture.contains("Blocks Texture")){
			Configuration.texture.set("Blocks Texture", "http://dl.dropbox.com/u/62672791/textures/blocks.png");
		}
		if(!Configuration.texture.contains("Stairs Texture")){
			Configuration.texture.set("Stairs Texture", "http://dl.dropbox.com/u/62672791/textures/stairs.png");
		}
		if(!Configuration.texture.contains("Plants Texture")){
			Configuration.texture.set("Plants Texture", "http://dl.dropbox.com/u/62672791/textures/plants.png");
		}
		if(!Configuration.texture.contains("Misc Texture")){
			Configuration.texture.set("Misc Texture", "http://dl.dropbox.com/u/62672791/textures/misc.png");
		}
		if(!Configuration.texture.contains("Store Background")){
			Configuration.texture.set("Store Background", "http://dl.dropbox.com/u/62672791/textures/bg.png");
		}
	}
}
