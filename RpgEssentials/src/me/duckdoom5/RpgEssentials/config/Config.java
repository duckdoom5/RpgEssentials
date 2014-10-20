package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

import net.milkbowl.vault.economy.Economy;

public class Config {
    public static Economy economy = null;

    public static void set() {
        if (!Configuration.config.contains("general.allow version check")) {
            Configuration.config.set("general.allow version check", true);
        }
        if (!Configuration.config.contains("general.close guis on damage")) {
            Configuration.config.set("general.close guis on damage", true);
        }
        if (!Configuration.config.contains("general.options key")) {
            Configuration.config.set("general.options key", "r");
        }

        if (!Configuration.config.contains("currency.starting money")) {
            Configuration.config.set("currency.starting money", 100);
        }
        if (!Configuration.config.contains("currency.value")) {
            Configuration.config.set("currency.value", "Dollar");
        }
        if (!Configuration.config.contains("currency.use coins")) {
            Configuration.config.set("currency.use coins", true);
        }
        if (!Configuration.config.contains("currency.bronze value")) {
            Configuration.config.set("currency.Bronze value", 1);
        }
        if (!Configuration.config.contains("currency.silver value")) {
            Configuration.config.set("currency.silver value", 5);
        }
        if (!Configuration.config.contains("currency.gold value")) {
            Configuration.config.set("currency.gold value", 10);
        }

        if (!Configuration.config.contains("spout.leave.enabled")) {
            Configuration.config.set("spout.leave.enabled", true);
        }
        if (!Configuration.config.contains("spout.leave.messageicon")) {
            Configuration.config.set("spout.leave.messageicon", 260);
        }
        if (!Configuration.config.contains("spout.join.enabled")) {
            Configuration.config.set("spout.join.enabled", true);
        }
        if (!Configuration.config.contains("spout.join.messageicon")) {
            Configuration.config.set("spout.join.messageicon", 322);
        }
        if (!Configuration.config.contains("spout.join.message")) {
            Configuration.config.set("spout.join.message", "Welcome to the server!");
        }
        if (!Configuration.config.contains("spout.join.submessage")) {
            Configuration.config.set("spout.join.submessage", "Have a good time");
        }
        if (!Configuration.config.contains("spout.precache")) {
            Configuration.config.set("spout.precache", Arrays.asList("http://rpgessentials.lynxdragon.com/plugin/textures/XXMrPiggyCompanyXX.zip"));
        }

        if (!Configuration.config.contains("worlds.enabled")) {
            Configuration.config.set("worlds.enabled", "");
        }
    }
}