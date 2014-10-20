package me.duckdoom5.RpgServer.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgServer.RpgServer;

public class Configuration {

    private static final String h = "[RpgServer] ";

    public static MyConfiguration config;

    static {
        config = new MyConfiguration();

        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/RpgServer/config.yml");
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

    public static void start() {
        RpgServer.log.info(h + "Static Configuration loading...");
    }

    private static void exclaim(String filename) {
        RpgServer.log.info(h + "Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgServer.log.severe(h + "On file " + filename + ":");
        RpgServer.log.severe(h + "Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgServer.log.severe(h + "On file " + filename + ":");
        RpgServer.log.severe(h + "Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgServer/" + name);
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
                y.load("plugins/RpgServer/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}