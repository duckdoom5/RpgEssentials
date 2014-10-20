package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

public class Config {
    public static void set() {
        if (!Configuration.config.contains("Background")) {
            Configuration.config.set("Background", "http://rpgessentials.lynxdragon.com/plugin/textures/gui/bg.png");
        }
        if (!Configuration.config.contains("Allow shortcut")) {
            Configuration.config.set("Allow shortcut", true);
        }
        if (!Configuration.config.contains("Shortcut key")) {
            Configuration.config.set("Shortcut key", "l");
        }
    }
}
