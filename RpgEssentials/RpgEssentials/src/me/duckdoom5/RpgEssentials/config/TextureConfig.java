package me.duckdoom5.RpgEssentials.config;

public class TextureConfig {

	public static void set(){
		if(!Configuration.texture.contains("Ores Texture.url")){
			Configuration.texture.set("Ores Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/ores.png");
		}
		if(!Configuration.texture.contains("Ores Texture.size")){
			Configuration.texture.set("Ores Texture.size", 16);
		}
		if(!Configuration.texture.contains("Blocks Texture.url")){
			Configuration.texture.set("Blocks Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/blocks.png");
		}
		if(!Configuration.texture.contains("Blocks Texture.size")){
			Configuration.texture.set("Blocks Texture.size", 16);
		}
		if(!Configuration.texture.contains("Stairs Texture.url")){
			Configuration.texture.set("Stairs Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/stairs.png");
		}
		if(!Configuration.texture.contains("Stairs Texture.size")){
			Configuration.texture.set("Stairs Texture.size", 16);
		}
		if(!Configuration.texture.contains("Plants Texture.url")){
			Configuration.texture.set("Plants Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
		}
		if(!Configuration.texture.contains("Plants Texture.size")){
			Configuration.texture.set("Plants Texture.size", 16);
		}
		if(!Configuration.texture.contains("Misc Texture.url")){
			Configuration.texture.set("Misc Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/misc.png");
		}
		if(!Configuration.texture.contains("Misc Texture.size")){
			Configuration.texture.set("Misc Texture.size", 16);
		}
		if(!Configuration.texture.contains("Sign Texture.url")){
			Configuration.texture.set("Sign Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
		}
		if(!Configuration.texture.contains("Sign Texture.size")){
			Configuration.texture.set("Sign Texture.size", 64);
		}
		if(!Configuration.texture.contains("Level Background")){
			Configuration.texture.set("Level Background", "http://dl.lynxdragon.com/rpgessentials/textures/gui/bg.png");
		}
		if(!Configuration.texture.contains("Quests Background")){
			Configuration.texture.set("Quests Background", "http://dl.lynxdragon.com/rpgessentials/textures/gui/bg.png");
		}
		if(!Configuration.texture.contains("Chatbox Background")){
			Configuration.texture.set("Chatbox Background", "http://dl.lynxdragon.com/rpgessentials/textures/gui/borderbg.png");
		}
		if(!Configuration.texture.contains("Chatbox Bottom")){
			Configuration.texture.set("Chatbox Bottom", "http://dl.lynxdragon.com/rpgessentials/textures/gui/borderbottom.png");
		}
		if(!Configuration.texture.contains("Chatbox Top")){
			Configuration.texture.set("Chatbox Top", "http://dl.lynxdragon.com/rpgessentials/textures/gui/bordertop.png");
		}
	}
}
