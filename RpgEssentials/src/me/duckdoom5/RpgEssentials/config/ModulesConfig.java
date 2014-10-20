package me.duckdoom5.RpgEssentials.config;

public class ModulesConfig {
    public static void set() {
        if (!Configuration.modules.contains("Modules.mailing")) {
            Configuration.modules.set("Modules.mailing", true);
        }
        if (!Configuration.modules.contains("Modules.texturepack")) {
            Configuration.modules.set("Modules.texturepack", true);
        }
        if (!Configuration.modules.contains("Modules.custom mobs")) {
            Configuration.modules.set("Modules.custom mobs", true);
        }
        if (!Configuration.modules.contains("Modules.colored names")) {
            Configuration.modules.set("Modules.colored names", true);
        }
        if (!Configuration.modules.contains("Modules.battle music")) {
            Configuration.modules.set("Modules.battle music", true);
        }
        if (!Configuration.modules.contains("Modules.drop coins")) {
            Configuration.modules.set("Modules.drop coins", true);
        }
        if (!Configuration.modules.contains("Modules.npcs")) {
            Configuration.modules.set("Modules.npcs", true);
        }
    }
}
