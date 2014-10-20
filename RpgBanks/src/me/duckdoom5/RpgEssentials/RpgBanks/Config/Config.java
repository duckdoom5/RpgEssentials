package me.duckdoom5.RpgEssentials.RpgBanks.Config;

public class Config {
    public static void set() {
        if (!Configuration.config.contains("bank.size.18.price")) {
            Configuration.config.set("bank.size.18.price", 100);
        }
        if (!Configuration.config.contains("bank.size.27.price")) {
            Configuration.config.set("bank.size.27.price", 500);
        }
        if (!Configuration.config.contains("bank.size.36.price")) {
            Configuration.config.set("bank.size.36.price", 1000);
        }
        if (!Configuration.config.contains("bank.size.45.price")) {
            Configuration.config.set("bank.size.45.price", 2000);
        }
        if (!Configuration.config.contains("bank.size.54.price")) {
            Configuration.config.set("bank.size.54.price", 5000);
        }
        if (!Configuration.config.contains("bank.global")) {
            Configuration.config.set("bank.global", false);
        }
        if (!Configuration.config.contains("bank.global.key")) {
            Configuration.config.set("bank.global.key", "b");
        }
        if (!Configuration.config.contains("bank.bankers.openbank")) {
            Configuration.config.set("bank.bankers.openbank", false);
        }
    }
}
