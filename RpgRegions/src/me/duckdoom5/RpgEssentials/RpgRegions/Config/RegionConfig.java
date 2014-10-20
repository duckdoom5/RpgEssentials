package me.duckdoom5.RpgEssentials.RpgRegions.Config;

import org.bukkit.util.Vector;

public class RegionConfig {

    public static void set() {

        if (!Configuration.regions.contains("Regions.examplename.enter.message")) {
            Configuration.regions.set("Regions.examplename.enter.message", "message");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.submessage")) {
            Configuration.regions.set("Regions.examplename.enter.submessage", "submessage");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.iconId")) {
            Configuration.regions.set("Regions.examplename.enter.iconId", 264);
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.music")) {
            Configuration.regions.set("Regions.examplename.enter.music", "http://exampleurl.com");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.repeat")) {
            Configuration.regions.set("Regions.examplename.enter.repeat", true);
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.time")) {
            Configuration.regions.set("Regions.examplename.enter.time", 61);
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.texturepack")) {
            Configuration.regions.set("Regions.examplename.enter.texturepack", "http://exampleurl.com");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.command")) {
            Configuration.regions.set("Regions.examplename.enter.command", "rpg help");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.fog")) {
            Configuration.regions.set("Regions.examplename.enter.fog", "far");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.skycolor")) {
            Configuration.regions.set("Regions.examplename.enter.skycolor", "1 0 0");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.fogcolor")) {
            Configuration.regions.set("Regions.examplename.enter.fogcolor", "1 0 0");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.tpTo")) {
            Configuration.regions.set("Regions.examplename.enter.tpTo",
                    new Vector(0, 0, 0));
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.tpToWorld")) {
            Configuration.regions.set("Regions.examplename.enter.tpToWorld",
                    new Vector(0, 0, 0));
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.restrictions.minSkillLvl.attack")) {
            Configuration.regions.set("Regions.examplename.enter.restrictions.minSkillLvl.attack",
                            10);
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.restrictions.maxSkillLvl.attack")) {
            Configuration.regions.set("Regions.examplename.enter.restrictions.maxSkillLvl.attack",
                            50);
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.restrictions.completedQuest")) {
            Configuration.regions.set(
                    "Regions.examplename.enter.restrictions.completedQuest", "test");
        }
        if (!Configuration.regions.contains("Regions.examplename.enter.restrictions.startedQuest")) {
            Configuration.regions.set(
                    "Regions.examplename.enter.restrictions.startedQuest", "test2");
        }

        if (!Configuration.regions.contains("Regions.examplename.exit.message")) {
            Configuration.regions.set("Regions.examplename.exit.message", "message");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.submessage")) {
            Configuration.regions.set("Regions.examplename.exit.submessage", "submessage");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.iconId")) {
            Configuration.regions.set("Regions.examplename.exit.iconId", 264);
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.music")) {
            Configuration.regions.set("Regions.examplename.exit.music", "http://exampleurl.com");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.repeat")) {
            Configuration.regions.set("Regions.examplename.exit.repeat", true);
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.time")) {
            Configuration.regions.set("Regions.examplename.exit.time", 61);
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.texturepack")) {
            Configuration.regions.set("Regions.examplename.exit.texturepack", "http://exampleurl.com");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.command")) {
            Configuration.regions.set("Regions.examplename.exit.command", "rpg help");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.fog")) {
            Configuration.regions.set("Regions.examplename.exit.fog", "far");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.tpTo")) {
            Configuration.regions.set("Regions.examplename.exit.tpTo",
                    new Vector(0, 0, 0));
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.tpToWorld")) {
            Configuration.regions.set("Regions.examplename.exit.tpToWorld",
                    new Vector(0, 0, 0));
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.restrictions.minSkillLvl.attack")) {
            Configuration.regions.set(
                    "Regions.examplename.exit.restrictions.minSkillLvl.attack",
                    10);
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.restrictions.maxSkillLvl.attack")) {
            Configuration.regions.set(
                    "Regions.examplename.exit.restrictions.maxSkillLvl.attack",
                    50);
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.restrictions.completedQuest")) {
            Configuration.regions.set(
                    "Regions.examplename.exit.restrictions.completedQuest", "test");
        }
        if (!Configuration.regions.contains("Regions.examplename.exit.restrictions.startedQuest")) {
            Configuration.regions.set(
                    "Regions.examplename.exit.restrictions.startedQuest", "test2");
        }

        for (int house = 0; house < 100; house++) {
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.message")) {
                Configuration.regions.set("Regions.house" + house + ".enter.message", "House");
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.submessage")) {
                Configuration.regions.set("Regions.house" + house + ".enter.submessage", "Welcome");
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.iconId")) {
                Configuration.regions.set("Regions.house" + house + ".enter.iconId", 355);
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.music")) {
                Configuration.regions.set("Regions.house" + house + ".enter.music", "http://rpgessentials.lynxdragon.com/plugin/music/house.wav");
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.repeat")) {
                Configuration.regions.set("Regions.house" + house + ".enter.repeat", true);
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.time")) {
                Configuration.regions.set("Regions.house" + house + ".enter.time", 61);
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".enter.fog")) {
                Configuration.regions.set("Regions.house" + house + ".enter.fog", "tiny");
            }
            if (!Configuration.regions.contains("Regions.house" + house + ".exit.fog")) {
                Configuration.regions.set(
                        "Regions.house" + house + ".exit.fog", "far");
            }
        }
    }
}