package me.duckdoom5.RpgEssentials.RpgRegions.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgRegions.RpgRegions;

public class Configuration {

    private static final String h = "[RpgRegions] ";

    public static MyConfiguration regions;

    static {
        regions = new MyConfiguration();
    }

    public static void start() {
        RpgRegions.plugin.getLogger().info(h + "Static Configuration loading...");

        if (load(regions, "regions.yml")) {
            regions = MyConfiguration.loadConfiguration("plugins/RpgRegions/regions.yml");
            RegionConfig.set();
            save(regions);
        }
        RegionConfig.set();
        try {
            regions.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void exclaim(String filename) {
        RpgRegions.plugin.getLogger().info(h + "Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgRegions.plugin.getLogger().severe(h + "On file " + filename + ":");
        RpgRegions.plugin.getLogger().severe(h + "Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgRegions.plugin.getLogger().severe(h + "On file " + filename + ":");
        RpgRegions.plugin.getLogger().severe(h + "Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgRegions/" + name);
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
                y.load("plugins/RpgRegions/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}