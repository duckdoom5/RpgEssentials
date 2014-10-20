package me.duckdoom5.RpgEssentials.RpgQuests.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

public class Configuration {

    private static final String h = "[RpgQuests] ";

    public static MyConfiguration quests;

    static {
        quests = new MyConfiguration();
    }

    public static void start() {
        RpgQuests.plugin.getLogger().info(h + "Static Configuration loading...");

        if (load(quests, "quests.yml")) {
            quests = MyConfiguration.loadConfiguration("plugins/RpgQuests/quests.yml");
            QuestConfig.set();
            save(quests);
        }
        QuestConfig.set();
        try {
            quests.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void exclaim(String filename) {
        RpgQuests.plugin.getLogger().info(h + "Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgQuests.plugin.getLogger().severe(h + "On file " + filename + ":");
        RpgQuests.plugin.getLogger().severe(h + "Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgQuests.plugin.getLogger().severe(h + "On file " + filename + ":");
        RpgQuests.plugin.getLogger().severe(h + "Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/RpgQuests/" + name);
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
                y.load("plugins/RpgQuests/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }
}