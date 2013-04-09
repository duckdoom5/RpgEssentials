package me.duckdoom5.RpgEssentials.config;

public class TextureConfig {

	public static void set(){
		String[] textures = new String[]{"Ores", "Blocks", "Stairs", "Plants", "Misc", "Signs"};
		int[] size = new int[]{16, 16, 16, 16, 16, 64};
		
		for(int i = 0; i < textures.length; i++){
			if(!Configuration.texture.contains(textures[i] + " Texture.url")){
				Configuration.texture.set(textures[i] + " Texture.url", "http://dl.lynxdragon.com/rpgessentials/textures/" + textures[i].toLowerCase() + ".png");
			}
			if(!Configuration.texture.contains(textures[i] + " Texture.size")){
				Configuration.texture.set(textures[i] + " Texture.size", 16);
			}
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
