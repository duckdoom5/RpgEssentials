package me.duckdoom5.RpgEssentials.RpgDeaths.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;

public class Configuration {
    public static MyConfiguration config;

    static {
        config = new MyConfiguration();
    }

    public static void start() {
        RpgDeaths.plugin.getLogger().info("Static Configuration loading...");

        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/RpgDeathChests/config.yml");
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
        RpgDeaths.plugin.getLogger().info("Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgDeaths.plugin.getLogger().severe("On file " + filename + ":");
        RpgDeaths.plugin.getLogger().severe("Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgDeaths.plugin.getLogger().severe("On file " + filename + ":");
        RpgDeaths.plugin.getLogger().severe("Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgDeathChests/" + name);
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
                y.load("plugins/RpgDeathChests/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}