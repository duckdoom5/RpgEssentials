package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

public class LevelConfig {

    public static void set() {
        // general
        if (!Configuration.level.contains("Survival Gamemode Required")) {
            Configuration.level.set("Survival Gamemode Required", true);
        }
        if (!Configuration.level.contains("Disable place cheat")) {
            Configuration.level.set("Disable place cheat", true);
        }
        if (!Configuration.level.contains("Disable block break for low level")) {
            Configuration.level.set("Disable block break for low level", true);
        }
        if (!Configuration.level.contains("Disable tool use for low level")) {
            Configuration.level.set("Disable tool use for low level", true);
        }
        if (!Configuration.level.contains("Disable block break on damage event")) {
            Configuration.level.set("Disable block break on damage event",
                    false);
        }
        if (!Configuration.level.contains("Level exponent")) {
            Configuration.level.set("Level exponent", 7.5);
        }
        if (!Configuration.level.contains("combat level-up sound")) {
            Configuration.level.set("combat level-up sound", "http://dl.lynxdragon.com/rpgessentials/music/levelup.wav");
        }
        if (!Configuration.level.contains("level-up sound")) {
            Configuration.level.set("level-up sound", "http://dl.lynxdragon.com/rpgessentials/music/levelup.wav");
        }
        if (!Configuration.level.contains("level-up material")) {
            Configuration.level.set("level-up material", 354);
        }
        if (!Configuration.level.contains("combat level-up material")) {
            Configuration.level.set("combat level-up material", 276);
        }
        for (final SkillType skill : SkillType.values()) {
            if (!Configuration.level.contains("Enabled." + skill.toString())) {
                Configuration.level.set("Enabled." + skill.toString(), true);
            }
        }

        // unlock level

        // Armour
        if (!Configuration.level.contains("UnlockLevel.defense.leather helmet")) {
            Configuration.level.set("UnlockLevel.defense.leather helmet", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.leather chestplate")) {
            Configuration.level.set("UnlockLevel.defense.leather chestplate", 10);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.leather leggings")) {
            Configuration.level.set("UnlockLevel.defense.leather leggings", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.leather boots")) {
            Configuration.level.set("UnlockLevel.defense.leather boots", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.gold helmet")) {
            Configuration.level.set("UnlockLevel.defense.gold helmet", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.gold chestplate")) {
            Configuration.level.set("UnlockLevel.defense.gold chestplate", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.gold leggings")) {
            Configuration.level.set("UnlockLevel.defense.gold leggings", 10);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.gold boots")) {
            Configuration.level.set("UnlockLevel.defense.gold boots", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.chainmail helmet")) {
            Configuration.level.set("UnlockLevel.defense.chainmail helmet", 10);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.chainmail chestplate")) {
            Configuration.level.set("UnlockLevel.defense.chainmail chestplate", 20);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.chainmail leggings")) {
            Configuration.level.set("UnlockLevel.defense.chainmail leggings", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.chainmail boots")) {
            Configuration.level.set("UnlockLevel.defense.chainmail boots", 10);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.iron helmet")) {
            Configuration.level.set("UnlockLevel.defense.iron helmet", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.iron chestplate")) {
            Configuration.level.set("UnlockLevel.defense.iron chestplate", 35);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.iron leggings")) {
            Configuration.level.set("UnlockLevel.defense.iron leggings", 30);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.iron boots")) {
            Configuration.level.set("UnlockLevel.defense.iron boots", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.diamond helmet")) {
            Configuration.level.set("UnlockLevel.defense.diamond helmet", 40);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.diamond chestplate")) {
            Configuration.level.set("UnlockLevel.defense.diamond chestplate", 60);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.diamond leggings")) {
            Configuration.level.set("UnlockLevel.defense.diamond leggings", 50);
        }
        if (!Configuration.level.contains("UnlockLevel.defense.diamond boots")) {
            Configuration.level.set("UnlockLevel.defense.diamond boots", 40);
        }

        // ores
        if (!Configuration.level.contains("UnlockLevel.ores.coal ore")) {
            Configuration.level.set("UnlockLevel.ores.coal ore", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.ores.iron ore")) {
            Configuration.level.set("UnlockLevel.ores.iron ore", 8);
        }
        if (!Configuration.level.contains("UnlockLevel.ores.gold ore")) {
            Configuration.level.set("UnlockLevel.ores.gold ore", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.ores.lapis ore")) {
            Configuration.level.set("UnlockLevel.ores.lapis ore", 16);
        }
        if (!Configuration.level.contains("UnlockLevel.ores.redstone ore")) {
            Configuration.level.set("UnlockLevel.ores.redstone ore", 20);
        }
        if (!Configuration.level.contains("UnlockLevel.ores.diamond ore")) {
            Configuration.level.set("UnlockLevel.ores.diamond ore", 25);
        }

        // tools
        if (!Configuration.level.contains("UnlockLevel.mining.wood pickaxe")) {
            Configuration.level.set("UnlockLevel.mining.wood pickaxe", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.mining.stone pickaxe")) {
            Configuration.level.set("UnlockLevel.mining.stone pickaxe", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.mining.iron pickaxe")) {
            Configuration.level.set("UnlockLevel.mining.iron pickaxe", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.mining.gold pickaxe")) {
            Configuration.level.set("UnlockLevel.mining.gold pickaxe", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.mining.diamond pickaxe")) {
            Configuration.level.set("UnlockLevel.mining.diamond pickaxe", 50);
        }
        if (!Configuration.level.contains("UnlockLevel.woodcutting.wood axe")) {
            Configuration.level.set("UnlockLevel.woodcutting.wood axe", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.woodcutting.stone axe")) {
            Configuration.level.set("UnlockLevel.woodcutting.stone axe", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.woodcutting.iron axe")) {
            Configuration.level.set("UnlockLevel.woodcutting.iron axe", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.woodcutting.gold axe")) {
            Configuration.level.set("UnlockLevel.woodcutting.gold axe", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.woodcutting.diamond axe")) {
            Configuration.level.set("UnlockLevel.woodcutting.diamond axe", 50);
        }
        if (!Configuration.level.contains("UnlockLevel.farming.wood hoe")) {
            Configuration.level.set("UnlockLevel.farming.wood hoe", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.farming.stone hoe")) {
            Configuration.level.set("UnlockLevel.farming.stone hoe", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.farming.iron hoe")) {
            Configuration.level.set("UnlockLevel.farming.iron hoe", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.farming.gold hoe")) {
            Configuration.level.set("UnlockLevel.farming.gold hoe", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.farming.diamond hoe")) {
            Configuration.level.set("UnlockLevel.farming.diamond hoe", 50);
        }
        if (!Configuration.level.contains("UnlockLevel.attack.wood sword")) {
            Configuration.level.set("UnlockLevel.attack.wood sword", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.attack.stone sword")) {
            Configuration.level.set("UnlockLevel.attack.stone sword", 10);
        }
        if (!Configuration.level.contains("UnlockLevel.attack.iron sword")) {
            Configuration.level.set("UnlockLevel.attack.iron sword", 20);
        }
        if (!Configuration.level.contains("UnlockLevel.attack.gold sword")) {
            Configuration.level.set("UnlockLevel.attack.gold sword", 40);
        }
        if (!Configuration.level.contains("UnlockLevel.attack.diamond sword")) {
            Configuration.level.set("UnlockLevel.attack.diamond sword", 60);
        }
        if (!Configuration.level.contains("UnlockLevel.excavation.wood spade")) {
            Configuration.level.set("UnlockLevel.excavation.wood spade", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.excavation.stone spade")) {
            Configuration.level.set("UnlockLevel.excavation.stone spade", 5);
        }
        if (!Configuration.level.contains("UnlockLevel.excavation.iron spade")) {
            Configuration.level.set("UnlockLevel.excavation.iron spade", 15);
        }
        if (!Configuration.level.contains("UnlockLevel.excavation.gold spade")) {
            Configuration.level.set("UnlockLevel.excavation.gold spade", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.excavation.diamond spade")) {
            Configuration.level.set("UnlockLevel.excavation.diamond spade", 50);
        }
        //--------------------------------------TAMING--------------------------------------------
        if (!Configuration.level.contains("UnlockLevel.taming.bat")) {
            Configuration.level.set("UnlockLevel.taming.bat", 28);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.blaze")) {
            Configuration.level.set("UnlockLevel.taming.blaze", 50);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.cave spider")) {
            Configuration.level.set("UnlockLevel.taming.cave spider", 47);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.chicken")) {
            Configuration.level.set("UnlockLevel.taming.chicken", 4);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.cow")) {
            Configuration.level.set("UnlockLevel.taming.cow", 12);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.creeper")) {
            Configuration.level.set("UnlockLevel.taming.creeper", 55);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.ender dragon")) {
            Configuration.level.set("UnlockLevel.taming.ender dragon", 100);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.enderman")) {
            Configuration.level.set("UnlockLevel.taming.enderman", 58);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.ghast")) {
            Configuration.level.set("UnlockLevel.taming.ghast", 67);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.giant")) {
            Configuration.level.set("UnlockLevel.taming.giant", 80);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.horse")) {
            Configuration.level.set("UnlockLevel.taming.horse", 25);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.iron golem")) {
            Configuration.level.set("UnlockLevel.taming.iron golem", 85);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.magma cube")) {
            Configuration.level.set("UnlockLevel.taming.magma cube", 37);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.mushroom cow")) {
            Configuration.level.set("UnlockLevel.taming.mushroom cow", 14);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.ocelot")) {
            Configuration.level.set("UnlockLevel.taming.ocelot", 19);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.pig")) {
            Configuration.level.set("UnlockLevel.taming.pig", 9);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.pig zombie")) {
            Configuration.level.set("UnlockLevel.taming.pig zombie", 31);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.sheep")) {
            Configuration.level.set("UnlockLevel.taming.sheep", 7);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.silverfish")) {
            Configuration.level.set("UnlockLevel.taming.silverfish", 62);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.skeleton")) {
            Configuration.level.set("UnlockLevel.taming.skeleton", 40);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.slime")) {
            Configuration.level.set("UnlockLevel.taming.slime", 34);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.snowman")) {
            Configuration.level.set("UnlockLevel.taming.snowman", 2);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.spider")) {
            Configuration.level.set("UnlockLevel.taming.spider", 44);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.squid")) {
            Configuration.level.set("UnlockLevel.taming.squid", 1);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.villager")) {
            Configuration.level.set("UnlockLevel.taming.villager", 70);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.witch")) {
            Configuration.level.set("UnlockLevel.taming.witch", 74);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.wither")) {
            Configuration.level.set("UnlockLevel.taming.wither", 90);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.wolf")) {
            Configuration.level.set("UnlockLevel.taming.wolf", 22);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.zombie")) {
            Configuration.level.set("UnlockLevel.taming.zombie", 30);
        }

        // exp
        // mining
        if (!Configuration.level.contains("Exp.mining.stone")) {
            Configuration.level.set("Exp.mining.stone", 5);
        }
        if (!Configuration.level.contains("Exp.mining.cobblestone")) {
            Configuration.level.set("Exp.mining.cobblestone", 2);
        }
        if (!Configuration.level.contains("Exp.mining.mossy cobblestone")) {
            Configuration.level.set("Exp.mining.mossy cobblestone", 8);
        }
        if (!Configuration.level.contains("Exp.mining.coal ore")) {
            Configuration.level.set("Exp.mining.coal ore", 10);
        }
        if (!Configuration.level.contains("Exp.mining.iron ore")) {
            Configuration.level.set("Exp.mining.iron ore", 15);
        }
        if (!Configuration.level.contains("Exp.mining.gold ore")) {
            Configuration.level.set("Exp.mining.gold ore", 20);
        }
        if (!Configuration.level.contains("Exp.mining.lapis ore")) {
            Configuration.level.set("Exp.mining.lapis ore", 25);
        }
        if (!Configuration.level.contains("Exp.mining.redstone ore")) {
            Configuration.level.set("Exp.mining.redstone ore", 20);
        }
        if (!Configuration.level.contains("Exp.mining.glowing redstone ore")) {
            Configuration.level.set("Exp.mining.glowing redstone ore", 20);
        }
        if (!Configuration.level.contains("Exp.mining.diamond ore")) {
            Configuration.level.set("Exp.mining.diamond ore", 40);
        }
        if (!Configuration.level.contains("Exp.mining.sandstone")) {
            Configuration.level.set("Exp.mining.sandstone", 5);
        }
        if (!Configuration.level.contains("Exp.mining.obsidian")) {
            Configuration.level.set("Exp.mining.obsidian", 50);
        }
        if (!Configuration.level.contains("Exp.mining.lapis block")) {
            Configuration.level.set("Exp.mining.lapis block", 5);
        }
        if (!Configuration.level.contains("Exp.mining.iron block")) {
            Configuration.level.set("Exp.mining.iron block", 5);
        }
        if (!Configuration.level.contains("Exp.mining.gold block")) {
            Configuration.level.set("Exp.mining.gold block", 5);
        }
        if (!Configuration.level.contains("Exp.mining.diamond block")) {
            Configuration.level.set("Exp.mining.diamond block", 10);
        }
        if (!Configuration.level.contains("Exp.mining.stone step")) {
            Configuration.level.set("Exp.mining.stone step", 5);
        }
        if (!Configuration.level.contains("Exp.mining.sandstone step")) {
            Configuration.level.set("Exp.mining.sandstone step", 5);
        }
        if (!Configuration.level.contains("Exp.mining.cobblestone step")) {
            Configuration.level.set("Exp.mining.cobblestone step", 5);
        }
        if (!Configuration.level.contains("Exp.mining.brick step")) {
            Configuration.level.set("Exp.mining.brick step", 5);
        }
        if (!Configuration.level.contains("Exp.mining.smooth step")) {
            Configuration.level.set("Exp.mining.smooth step", 5);
        }
        if (!Configuration.level.contains("Exp.mining.bricks")) {
            Configuration.level.set("Exp.mining.bricks", 10);
        }
        if (!Configuration.level.contains("Exp.mining.brick stairs")) {
            Configuration.level.set("Exp.mining.brick stairs", 10);
        }
        if (!Configuration.level.contains("Exp.mining.smooth stairs")) {
            Configuration.level.set("Exp.mining.smooth stairs", 10);
        }
        if (!Configuration.level.contains("Exp.mining.cobblestone stairs")) {
            Configuration.level.set("Exp.mining.cobblestone stairs", 10);
        }
        if (!Configuration.level.contains("Exp.mining.smooth brick")) {
            Configuration.level.set("Exp.mining.smooth brick", 10);
        }
        if (!Configuration.level.contains("Exp.mining.mossy smooth brick")) {
            Configuration.level.set("Exp.mining.mossy smooth brick", 10);
        }
        if (!Configuration.level.contains("Exp.mining.cracked smooth brick")) {
            Configuration.level.set("Exp.mining.cracked smooth brick", 10);
        }
        if (!Configuration.level.contains("Exp.mining.netherrack")) {
            Configuration.level.set("Exp.mining.netherrack", 5);
        }
        if (!Configuration.level.contains("Exp.mining.glowstone")) {
            Configuration.level.set("Exp.mining.glowstone", 10);
        }
        if (!Configuration.level.contains("Exp.mining.nether brick")) {
            Configuration.level.set("Exp.mining.nether brick", 10);
        }
        if (!Configuration.level.contains("Exp.mining.nether brick stairs")) {
            Configuration.level.set("Exp.mining.nether brick stairs", 10);
        }
        if (!Configuration.level.contains("Exp.mining.end stone")) {
            Configuration.level.set("Exp.mining.end stone", 10);
        }
        // woodcutting
        if (!Configuration.level.contains("Exp.woodcutting.oak log")) {
            Configuration.level.set("Exp.woodcutting.oak log", 10);
        }
        if (!Configuration.level.contains("Exp.woodcutting.pine log")) {
            Configuration.level.set("Exp.woodcutting.pine log", 20);
        }
        if (!Configuration.level.contains("Exp.woodcutting.birch log")) {
            Configuration.level.set("Exp.woodcutting.brich log", 20);
        }
        if (!Configuration.level.contains("Exp.woodcutting.jungle log")) {
            Configuration.level.set("Exp.woodcutting.jungle log", 30);
        }
        if (!Configuration.level.contains("Exp.woodcutting.oak wood")) {
            Configuration.level.set("Exp.woodcutting.oak wood", 5);
        }
        if (!Configuration.level.contains("Exp.woodcutting.pine wood")) {
            Configuration.level.set("Exp.woodcutting.pine wood", 10);
        }
        if (!Configuration.level.contains("Exp.woodcutting.birch wood")) {
            Configuration.level.set("Exp.woodcutting.brich wood", 10);
        }
        if (!Configuration.level.contains("Exp.woodcutting.jungle wood")) {
            Configuration.level.set("Exp.woodcutting.jungle wood", 15);
        }
        if (!Configuration.level.contains("Exp.woodcutting.wood step")) {
            Configuration.level.set("Exp.woodcutting.wood step", 5);
        }
        if (!Configuration.level.contains("Exp.woodcutting.wood double step")) {
            Configuration.level.set("Exp.woodcutting.Wood double step", 10);
        }
        if (!Configuration.level.contains("Exp.woodcutting.wood stairs")) {
            Configuration.level.set("Exp.woodcutting.wood stairs", 10);
        }
        if (!Configuration.level.contains("Exp.woodcutting.fence")) {
            Configuration.level.set("Exp.woodcutting.fence", 5);
        }

        // excavation
        if (!Configuration.level.contains("Exp.excavation.dirt")) {
            Configuration.level.set("Exp.excavation.dirt", 2);
        }
        if (!Configuration.level.contains("Exp.excavation.grass")) {
            Configuration.level.set("Exp.excavation.grass", 2);
        }
        if (!Configuration.level.contains("Exp.excavation.sand")) {
            Configuration.level.set("Exp.excavation.sand", 5);
        }
        if (!Configuration.level.contains("Exp.excavation.gravel")) {
            Configuration.level.set("Exp.excavation.gravel", 5);
        }
        if (!Configuration.level.contains("Exp.excavation.clay")) {
            Configuration.level.set("Exp.excavation.clay", 10);
        }
        if (!Configuration.level.contains("Exp.excavation.soil")) {
            Configuration.level.set("Exp.excavation.soil", 2);
        }
        if (!Configuration.level.contains("Exp.excavation.soul sand")) {
            Configuration.level.set("Exp.excavation.soul sand", 5);
        }
        if (!Configuration.level.contains("Exp.excavation.snow block")) {
            Configuration.level.set("Exp.excavation.snow block", 4);
        }

        // farming break
        if (!Configuration.level.contains("Exp.farming.yellow flower.break")) {
            Configuration.level.set("Exp.farming.yellow flower.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.yellow flower.place")) {
            Configuration.level.set("Exp.farming.yellow flower.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.rose.break")) {
            Configuration.level.set("Exp.farming.rose.break", 2);
        }
        if (!Configuration.level.contains("Exp.farming.rose.place")) {
            Configuration.level.set("Exp.farming.rose.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.pumpkin.break")) {
            Configuration.level.set("Exp.farming.pumpkin.break", 10);
        }
        if (!Configuration.level.contains("Exp.farming.pumpkin.place")) {
            Configuration.level.set("Exp.farming.pumpkin.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.pumpkin stem.break")) {
            Configuration.level.set("Exp.farming.pumpkin stem.break", 0);
        }
        if (!Configuration.level.contains("Exp.farming.pumpkin stem.place")) {
            Configuration.level.set("Exp.farming.pumpkin stem.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.melon block.break")) {
            Configuration.level.set("Exp.farming.melon block.break", 10);
        }
        if (!Configuration.level.contains("Exp.farming.melon block.place")) {
            Configuration.level.set("Exp.farming.melon block.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.melon stem.break")) {
            Configuration.level.set("Exp.farming.melon stem.break", 0);
        }
        if (!Configuration.level.contains("Exp.farming.melon stem.place")) {
            Configuration.level.set("Exp.farming.melon stem.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.red mushroom.break")) {
            Configuration.level.set("Exp.farming.red mushroom.break", 5);
        }
        if (!Configuration.level.contains("Exp.farming.red mushroom.place")) {
            Configuration.level.set("Exp.farming.red mushroom.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.brown mushroom.break")) {
            Configuration.level.set("Exp.farming.brown mushroom.break", 5);
        }
        if (!Configuration.level.contains("Exp.farming.brown mushroom.place")) {
            Configuration.level.set("Exp.farming.brown mushroom.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.huge mushroom 1.break")) {
            Configuration.level.set("Exp.farming.huge mushroom 1.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.huge mushroom 1.place")) {
            Configuration.level.set("Exp.farming.huge Red mushroom 1.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.huge mushroom 2.break")) {
            Configuration.level.set("Exp.farming.huge mushroom 2.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.huge mushroom 2.place")) {
            Configuration.level.set("Exp.farming.huge mushroom 2.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.long grass.break")) {
            Configuration.level.set("Exp.farming.long grass.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.long grass.place")) {
            Configuration.level.set("Exp.farming.long grass.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.wheat.break")) {
            Configuration.level.set("Exp.farming.wheat.break", 5);
        }
        if (!Configuration.level.contains("Exp.farming.seeds.place")) {
            Configuration.level.set("Exp.farming.seeds.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.cacti.break")) {
            Configuration.level.set("Exp.farming.cacti.break", 5);
        }
        if (!Configuration.level.contains("Exp.farming.cacti.place")) {
            Configuration.level.set("Exp.farming.cacti.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.sugar cane.break")) {
            Configuration.level.set("Exp.farming.sugar cane.break", 2);
        }
        if (!Configuration.level.contains("Exp.farming.sugar cane.place")) {
            Configuration.level.set("Exp.farming.sugar cane.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.vines.break")) {
            Configuration.level.set("Exp.farming.vines.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.vines.place")) {
            Configuration.level.set("Exp.farming.vines.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.water lily.break")) {
            Configuration.level.set("Exp.farming.water lily.break", 2);
        }
        if (!Configuration.level.contains("Exp.farming.water lily.place")) {
            Configuration.level.set("Exp.farming.water lily.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.leaves.break")) {
            Configuration.level.set("Exp.farming.leaves.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.leaves.place")) {
            Configuration.level.set("Exp.farming.leaves.place", 1);
        }
        if (!Configuration.level.contains("Exp.farming.dead bush.break")) {
            Configuration.level.set("Exp.farming.dead bush.break", 1);
        }
        if (!Configuration.level.contains("Exp.farming.dead bush.place")) {
            Configuration.level.set("Exp.farming.dead bush.place", 1);
        }
        
        // farming create
        if (!Configuration.level.contains("Exp.farming.soil.create")) {
            Configuration.level.set("Exp.farming.soil.create", 1);
        }

        // cooking
        if (!Configuration.level.contains("Exp.cooking.golden apple")) {
            Configuration.level.set("Exp.cooking.golden apple", 20);
        }
        if (!Configuration.level.contains("Exp.cooking.bread")) {
            Configuration.level.set("Exp.cooking.bread", 5);
        }
        if (!Configuration.level.contains("Exp.cooking.mushroom soup")) {
            Configuration.level.set("Exp.cooking.mushroom soup", 10);
        }
        if (!Configuration.level.contains("Exp.cooking.cake")) {
            Configuration.level.set("Exp.cooking.cake", 30);
        }
        if (!Configuration.level.contains("Exp.cooking.cooked beef")) {
            Configuration.level.set("Exp.cooking.cooked beef", 10);
        }
        if (!Configuration.level.contains("Exp.cooking.cooked chicken")) {
            Configuration.level.set("Exp.cooking.cooked chicken", 10);
        }
        if (!Configuration.level.contains("Exp.cooking.cooked fish")) {
            Configuration.level.set("Exp.cooking.cooked fish", 10);
        }
        if (!Configuration.level.contains("Exp.cooking.grilled porkchop")) {
            Configuration.level.set("Exp.cooking.grilled porkchop", 10);
        }

        // fishing
        if (!Configuration.level.contains("Exp.fishing.caught")) {
            Configuration.level.set("Exp.fishing.caught", 10);
        }

        // firemaking
        if (!Configuration.level.contains("Exp.firemaking.ignite")) {
            Configuration.level.set("Exp.firemaking.ignite", 10);
        }

        // smithing
        if (!Configuration.level.contains("Exp.smithing.iron ingot")) {
            Configuration.level.set("Exp.smithing.iron ingot", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.clay brick")) {
            Configuration.level.set("Exp.smithing.clay brick", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.gold ingot")) {
            Configuration.level.set("Exp.smithing.gold ingot", 15);
        }
        if (!Configuration.level.contains("Exp.smithing.wood axe")) {
            Configuration.level.set("Exp.smithing.wood axe", 5);
        }
        if (!Configuration.level.contains("Exp.smithing.wood pickaxe")) {
            Configuration.level.set("Exp.smithing.wood pickaxe", 5);
        }
        if (!Configuration.level.contains("Exp.smithing.wood spade")) {
            Configuration.level.set("Exp.smithing.wood spade", 5);
        }
        if (!Configuration.level.contains("Exp.smithing.wood sword")) {
            Configuration.level.set("Exp.smithing.wood sword", 6);
        }
        if (!Configuration.level.contains("Exp.smithing.wood hoe")) {
            Configuration.level.set("Exp.smithing.wood hoe", 5);
        }
        if (!Configuration.level.contains("Exp.smithing.stone axe")) {
            Configuration.level.set("Exp.smithing.stone axe", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.stone pickaxe")) {
            Configuration.level.set("Exp.smithing.stone pickaxe", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.stone spade")) {
            Configuration.level.set("Exp.smithing.stone spade", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.stone sword")) {
            Configuration.level.set("Exp.smithing.stone sword", 12);
        }
        if (!Configuration.level.contains("Exp.smithing.stone hoe")) {
            Configuration.level.set("Exp.smithing.stone hoe", 10);
        }
        if (!Configuration.level.contains("Exp.smithing.iron axe")) {
            Configuration.level.set("Exp.smithing.iron axe", 15);
        }
        if (!Configuration.level.contains("Exp.smithing.iron pickaxe")) {
            Configuration.level.set("Exp.smithing.iron pickaxe", 15);
        }
        if (!Configuration.level.contains("Exp.smithing.iron spade")) {
            Configuration.level.set("Exp.smithing.iron spade", 15);
        }
        if (!Configuration.level.contains("Exp.smithing.iron sword")) {
            Configuration.level.set("Exp.smithing.iron sword", 18);
        }
        if (!Configuration.level.contains("Exp.smithing.iron hoe")) {
            Configuration.level.set("Exp.smithing.iron hoe", 15);
        }
        if (!Configuration.level.contains("Exp.smithing.gold axe")) {
            Configuration.level.set("Exp.smithing.gold axe", 20);
        }
        if (!Configuration.level.contains("Exp.smithing.gold pickaxe")) {
            Configuration.level.set("Exp.smithing.gold pickaxe", 20);
        }
        if (!Configuration.level.contains("Exp.smithing.gold spade")) {
            Configuration.level.set("Exp.smithing.gold spade", 20);
        }
        if (!Configuration.level.contains("Exp.smithing.gold sword")) {
            Configuration.level.set("Exp.smithing.gold sword", 25);
        }
        if (!Configuration.level.contains("Exp.smithing.gold hoe")) {
            Configuration.level.set("Exp.smithing.gold hoe", 20);
        }
        if (!Configuration.level.contains("Exp.smithing.diamond axe")) {
            Configuration.level.set("Exp.smithing.diamond axe", 30);
        }
        if (!Configuration.level.contains("Exp.smithing.diamond pickaxe")) {
            Configuration.level.set("Exp.smithing.diamond pickaxe", 30);
        }
        if (!Configuration.level.contains("Exp.smithing.diamond spade")) {
            Configuration.level.set("Exp.smithing.diamond spade", 30);
        }
        if (!Configuration.level.contains("Exp.smithing.diamond sword")) {
            Configuration.level.set("Exp.smithing.diamond sword", 40);
        }
        if (!Configuration.level.contains("Exp.smithing.diamond hoe")) {
            Configuration.level.set("Exp.smithing.diamond hoe", 30);
        }

        // construction
        if (!Configuration.level.contains("Exp.construction.stone")) {
            Configuration.level.set("Exp.construction.stone", 1);
        }
        if (!Configuration.level.contains("Exp.construction.cobblestone")) {
            Configuration.level.set("Exp.construction.cobblestone", 1);
        }
        if (!Configuration.level.contains("Exp.construction.wood")) {
            Configuration.level.set("Exp.construction.wood", 1);
        }
        if (!Configuration.level.contains("Exp.construction.log")) {
            Configuration.level.set("Exp.construction.log", 5);
        }
        if (!Configuration.level.contains("Exp.construction.glass")) {
            Configuration.level.set("Exp.construction.glass", 10);
        }
        if (!Configuration.level.contains("Exp.construction.lapis block")) {
            Configuration.level.set("Exp.construction.lapis block", 20);
        }
        if (!Configuration.level.contains("Exp.construction.dispenser")) {
            Configuration.level.set("Exp.construction.dispenser", 15);
        }
        if (!Configuration.level.contains("Exp.construction.sandstone")) {
            Configuration.level.set("Exp.construction.sandstone", 1);
        }
        if (!Configuration.level.contains("Exp.construction.note block")) {
            Configuration.level.set("Exp.construction.note block", 15);
        }
        if (!Configuration.level.contains("Exp.construction.bed")) {
            Configuration.level.set("Exp.construction.bed", 50);
        }
        if (!Configuration.level.contains("Exp.construction.piston sticky base")) {
            Configuration.level.set("Exp.construction.piston sticky base", 15);
        }
        if (!Configuration.level.contains("Exp.construction.piston base")) {
            Configuration.level.set("Exp.construction.piston base", 10);
        }
        if (!Configuration.level.contains("Exp.construction.wool")) {
            Configuration.level.set("Exp.construction.Wool", 5);
        }
        if (!Configuration.level.contains("Exp.construction.gold block")) {
            Configuration.level.set("Exp.construction.gold block", 20);
        }
        if (!Configuration.level.contains("Exp.construction.iron block")) {
            Configuration.level.set("Exp.construction.iron block", 20);
        }
        if (!Configuration.level.contains("Exp.construction.step")) {
            Configuration.level.set("Exp.construction.step", 5);
        }
        if (!Configuration.level.contains("Exp.construction.bricks")) {
            Configuration.level.set("Exp.construction.bricks", 10);
        }
        if (!Configuration.level.contains("Exp.construction.bookshelf")) {
            Configuration.level.set("Exp.construction.bookshelf", 15);
        }
        if (!Configuration.level.contains("Exp.construction.mossy cobblestone")) {
            Configuration.level.set("Exp.construction.mossy cobblestone", 5);
        }
        if (!Configuration.level.contains("Exp.construction.obsidian")) {
            Configuration.level.set("Exp.construction.obsidian", 20);
        }
        if (!Configuration.level.contains("Exp.construction.wood stairs")) {
            Configuration.level.set("Exp.construction.wood stairs", 10);
        }
        if (!Configuration.level.contains("Exp.construction.chest")) {
            Configuration.level.set("Exp.construction.chest", 5);
        }
        if (!Configuration.level.contains("Exp.construction.diamond block")) {
            Configuration.level.set("Exp.construction.diamond block", 30);
        }
        if (!Configuration.level.contains("Exp.construction.workbench")) {
            Configuration.level.set("Exp.construction.workbench", 2);
        }
        if (!Configuration.level.contains("Exp.construction.furnace")) {
            Configuration.level.set("Exp.construction.furnace", 5);
        }
        if (!Configuration.level.contains("Exp.construction.cobblestone stairs")) {
            Configuration.level.set("Exp.construction.cobblestone stairs", 10);
        }
        if (!Configuration.level.contains("Exp.construction.jukebox")) {
            Configuration.level.set("Exp.construction.jukebox", 20);
        }
        if (!Configuration.level.contains("Exp.construction.fence")) {
            Configuration.level.set("Exp.construction.fence", 1);
        }
        if (!Configuration.level.contains("Exp.construction.smooth brick")) {
            Configuration.level.set("Exp.construction.smooth brick", 5);
        }
        if (!Configuration.level.contains("Exp.construction.iron bars")) {
            Configuration.level.set("Exp.construction.iron bars", 10);
        }
        if (!Configuration.level.contains("Exp.construction.glass pane")) {
            Configuration.level.set("Exp.construction.glass pane", 15);
        }
        if (!Configuration.level.contains("Exp.construction.brick stairs")) {
            Configuration.level.set("Exp.construction.brick stairs", 10);
        }
        if (!Configuration.level.contains("Exp.construction.smooth stairs")) {
            Configuration.level.set("Exp.construction.smooth stairs", 10);
        }
        if (!Configuration.level.contains("Exp.construction.nether brick")) {
            Configuration.level.set("Exp.construction.nether brick", 5);
        }
        if (!Configuration.level.contains("Exp.construction.nether brick stairs")) {
            Configuration.level.set("Exp.construction.nether brick stairs", 10);
        }
        if (!Configuration.level.contains("Exp.construction.nether fence")) {
            Configuration.level.set("Exp.construction.nether fence", 1);
        }
        if (!Configuration.level.contains("Exp.construction.enchantment table")) {
            Configuration.level.set("Exp.construction.enchantment table", 60);
        }
        if (!Configuration.level.contains("Exp.construction.ender stone")) {
            Configuration.level.set("Exp.construction.ender stone", 5);
        }
        
        //Taming
        if (!Configuration.level.contains("Exp.taming.bat")) {
            Configuration.level.set("Exp.taming.bat", 61);
        }
        if (!Configuration.level.contains("Exp.taming.blaze")) {
            Configuration.level.set("Exp.taming.blaze", 103);
        }
        if (!Configuration.level.contains("Exp.taming.cave spider")) {
            Configuration.level.set("Exp.taming.cave spider", 97);
        }
        if (!Configuration.level.contains("Exp.taming.chicken")) {
            Configuration.level.set("Exp.taming.chicken", 8);
        }
        if (!Configuration.level.contains("Exp.taming.cow")) {
            Configuration.level.set("Exp.taming.cow", 28);
        }
        if (!Configuration.level.contains("Exp.taming.creeper")) {
            Configuration.level.set("Exp.taming.creeper", 115);
        }
        if (!Configuration.level.contains("Exp.taming.ender dragon")) {
            Configuration.level.set("Exp.taming.ender dragon", 315);
        }
        if (!Configuration.level.contains("Exp.taming.enderman")) {
            Configuration.level.set("Exp.taming.enderman", 126);
        }
        if (!Configuration.level.contains("Exp.taming.ghast")) {
            Configuration.level.set("Exp.taming.ghast", 148);
        }
        if (!Configuration.level.contains("Exp.taming.giant")) {
            Configuration.level.set("Exp.taming.giant", 189);
        }
        if (!Configuration.level.contains("Exp.taming.horse")) {
            Configuration.level.set("Exp.taming.horse", 52);
        }
        if (!Configuration.level.contains("Exp.taming.iron golem")) {
            Configuration.level.set("Exp.taming.iron golem", 227);
        }
        if (!Configuration.level.contains("Exp.taming.magma cube")) {
            Configuration.level.set("Exp.taming.magma cube", 85);
        }
        if (!Configuration.level.contains("Exp.taming.mushroom cow")) {
            Configuration.level.set("Exp.taming.mushroom cow", 32);
        }
        if (!Configuration.level.contains("Exp.taming.ocelot")) {
            Configuration.level.set("Exp.taming.ocelot", 37);
        }
        if (!Configuration.level.contains("Exp.taming.pig")) {
            Configuration.level.set("Exp.taming.pig", 22);
        }
        if (!Configuration.level.contains("UnlockLevel.taming.pig zombie")) {
            Configuration.level.set("UnlockLevel.taming.pig zombie", 79);
        }
        if (!Configuration.level.contains("Exp.taming.sheep")) {
            Configuration.level.set("Exp.taming.sheep", 15);
        }
        if (!Configuration.level.contains("Exp.taming.silverfish")) {
            Configuration.level.set("Exp.taming.silverfish", 134);
        }
        if (!Configuration.level.contains("Exp.taming.skeleton")) {
            Configuration.level.set("Exp.taming.skeleton", 90);
        }
        if (!Configuration.level.contains("Exp.taming.slime")) {
            Configuration.level.set("Exp.taming.slime", 83);
        }
        if (!Configuration.level.contains("Exp.taming.snowman")) {
            Configuration.level.set("Exp.taming.snowman", 4);
        }
        if (!Configuration.level.contains("Exp.taming.spider")) {
            Configuration.level.set("Exp.taming.spider", 95);
        }
        if (!Configuration.level.contains("Exp.taming.squid")) {
            Configuration.level.set("Exp.taming.squid", 2);
        }
        if (!Configuration.level.contains("Exp.taming.villager")) {
            Configuration.level.set("Exp.taming.villager", 161);
        }
        if (!Configuration.level.contains("Exp.taming.witch")) {
            Configuration.level.set("Exp.taming.witch", 176);
        }
        if (!Configuration.level.contains("Exp.taming.wither")) {
            Configuration.level.set("Exp.taming.wither", 249);
        }
        if (!Configuration.level.contains("Exp.taming.wolf")) {
            Configuration.level.set("Exp.taming.wolf", 46);
        }
        if (!Configuration.level.contains("Exp.taming.zombie")) {
            Configuration.level.set("Exp.taming.zombie", 74);
        }
    }
}