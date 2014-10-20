package me.duckdoom5.RpgServer.listener;

import me.duckdoom5.RpgServer.RpgServer;

import org.bukkit.event.Listener;

public class RpgServerBlockListener implements Listener {
    public static RpgServer plugin;

    public RpgServerBlockListener(RpgServer instance) {
        plugin = instance;
    }
}
