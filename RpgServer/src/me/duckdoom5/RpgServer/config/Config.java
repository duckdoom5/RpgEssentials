package me.duckdoom5.RpgServer.config;

public class Config {

    public static void set() {
        if (!Configuration.config.contains("Update.World")) {
            Configuration.config.set("Update.World", false);
        }
        if (!Configuration.config.contains("Update.Plugin")) {
            Configuration.config.set("Update.Plugin", false);
        }
    }
}