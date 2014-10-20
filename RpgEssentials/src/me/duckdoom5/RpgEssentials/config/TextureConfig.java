package me.duckdoom5.RpgEssentials.config;

public class TextureConfig {

    public static void set() {
        if (!Configuration.texture.contains("use default config")) {
            Configuration.texture.set("use default config", true);
        }

        if (Configuration.texture.getBoolean("use default config")) {
            final String[] textures = new String[] { "Ores", "Blocks", "Stairs", "Plants", "Misc", "Signs" };
            final int[] size = new int[] { 16, 32, 16, 16, 16, 64 };

            for (int i = 0; i < textures.length; i++) {
                if (!Configuration.texture.contains(textures[i] + " Texture.url")) {
                    Configuration.texture.set(textures[i] + " Texture.url", "http://rpgessentials.lynxdragon.com/plugin/textures/" + textures[i].toLowerCase() + ".png");
                }
                if (!Configuration.texture.contains(textures[i] + " Texture.size")) {
                    Configuration.texture.set(textures[i] + " Texture.size", size[i]);
                }
            }

            if (!Configuration.texture.contains("Level Background")) {
                Configuration.texture.set("Level Background","http://rpgessentials.lynxdragon.com/plugin/textures/gui/bg.png");
            }
            if (!Configuration.texture.contains("Quests Background")) {
                Configuration.texture.set("Quests Background","http://rpgessentials.lynxdragon.com/plugin/textures/gui/bg.png");
            }
            if (!Configuration.texture.contains("Chatbox Background")) {
                Configuration.texture.set("Chatbox Background","http://rpgessentials.lynxdragon.com/plugin/textures/gui/borderbg.png");
            }
            if (!Configuration.texture.contains("Chatbox Bottom")) {
                Configuration.texture.set("Chatbox Bottom","http://rpgessentials.lynxdragon.com/plugin/textures/gui/borderbottom.png");
            }
            if (!Configuration.texture.contains("Chatbox Top")) {
                Configuration.texture.set("Chatbox Top","http://rpgessentials.lynxdragon.com/plugin/textures/gui/bordertop.png");
            }
        }
    }
}
