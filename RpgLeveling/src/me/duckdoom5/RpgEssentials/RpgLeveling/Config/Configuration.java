package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;

public class Configuration {
    public static MyConfiguration level;
    public static MyConfiguration config;

    static {
        level = new MyConfiguration();
        config = new MyConfiguration();
    }

    public static void start() {
        RpgLeveling.plugin.getLogger().info("Static Configuration loading...");

        if (load(level, "leveling.yml")) {
            level = MyConfiguration.loadConfiguration("plugins/RpgLeveling/leveling.yml");
            LevelConfig.set();
            save(level);
        }
        LevelConfig.set();
        try {
            level.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/RpgLeveling/config.yml");
            Config.set();
            save(config);
        }
        Config.set();
        try {
            config.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void exclaim(String filename) {
        RpgLeveling.plugin.getLogger().info("Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgLeveling.plugin.getLogger().severe("On file " + filename + ":");
        RpgLeveling.plugin.getLogger().severe("Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgLeveling.plugin.getLogger().severe("On file " + filename + ":");
        RpgLeveling.plugin.getLogger().severe("Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgLeveling/" + name);
        } catch (final FileNotFoundException e) {
            return true;
        } catch (final Exception e) {
            complain(name);
        }
        return false;
    }

    private static void save(MyConfiguration y) {
        try {
            y.save();
            try {
                y.load("plugins/RpgLeveling/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}