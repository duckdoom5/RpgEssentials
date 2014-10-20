package me.duckdoom5.RpgEssentials.RpgEntities.Config;

public class Config {
    public static void set() {
        if (!Configuration.config.contains("Background")) {
            Configuration.config.set("Background", "http://rpgessentials.lynxdragon.com/plugin/textures/gui/bg.png");
        }
    }
}
