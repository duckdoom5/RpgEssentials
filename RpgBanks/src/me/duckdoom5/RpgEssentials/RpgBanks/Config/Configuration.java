package me.duckdoom5.RpgEssentials.RpgBanks.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;
import me.duckdoom5.RpgEssentials.config.MyConfiguration;

public class Configuration {
    public static MyConfiguration config;

    static {
        config = new MyConfiguration();
    }

    public static void start() {
        RpgBanks.plugin.getLogger().info("Static Configuration loading...");

        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/RpgBanks/config.yml");
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
        RpgBanks.plugin.getLogger().info("Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgBanks.plugin.getLogger().severe("On file " + filename + ":");
        RpgBanks.plugin.getLogger().severe("Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgBanks.plugin.getLogger().severe("On file " + filename + ":");
        RpgBanks.plugin.getLogger().severe("Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgBanks/" + name);
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
                y.load("plugins/RpgBanks/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}