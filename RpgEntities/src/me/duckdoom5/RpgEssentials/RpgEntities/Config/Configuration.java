package me.duckdoom5.RpgEssentials.RpgEntities.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;

public class Configuration {
    public static MyConfiguration config;
    public static MyConfiguration entities;

    static {
        config = new MyConfiguration();
        entities = new MyConfiguration();
    }

    public static void start() {
        RpgEntities.plugin.getLogger().info("Static Configuration loading...");

        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/RpgEntities/config.yml");
            Config.set();
            save(config);
        }
        Config.set();
        try {
            config.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(entities, "entities.yml")) {
            entities = MyConfiguration.loadConfiguration("plugins/RpgEntities/entities.yml");
            EntitiesConfig.set();
            save(entities);
        }
        EntitiesConfig.set();
        try {
            entities.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void exclaim(String filename) {
        RpgEntities.plugin.getLogger().info("Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgEntities.plugin.getLogger().severe("On file " + filename + ":");
        RpgEntities.plugin.getLogger().severe("Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgEntities.plugin.getLogger().severe("On file " + filename + ":");
        RpgEntities.plugin.getLogger().severe("Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgEntities/" + name);
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
                y.load("plugins/RpgEntities/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}