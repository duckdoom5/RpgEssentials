package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreCreateGui;

import org.getspout.spoutapi.player.SpoutPlayer;

public class Stores {
    public static void place(int x, int y, int z, String type) {
        Configuration.storedata.set(x + "," + y + "," + z, type);
        try {
            Configuration.storedata.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void place(String name, String type) {
        Configuration.storedata.set(name, type);
        try {
            Configuration.storedata.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void remove(int x, int y, int z) {
        Configuration.storedata.set(x + "," + y + "," + z, null);
        try {
            Configuration.storedata.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void create(int x, int y, int z, SpoutPlayer splayer) {
        new StoreCreateGui(x, y, z, RpgStores.plugin, splayer);
    }

    public static void create(String name, SpoutPlayer splayer) {
        new StoreCreateGui(name, RpgStores.plugin, splayer);
    }
}
