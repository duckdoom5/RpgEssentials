package me.duckdoom5.RpgEssentials.config;

public class GeneratorConfig {

    public static void set() {
        // Set the global defaults for the config
        if (!Configuration.generator.contains("Global.world.height")) {
            Configuration.generator.set("Global.world.height", 8);
        }
        if (!Configuration.generator.contains("Global.world.spread")) {
            Configuration.generator.set("Global.world.spread", 128);
        }
        if (!Configuration.generator.contains("Global.world.sea.level")) {
            Configuration.generator.set("Global.world.sea.level", 64);
        }
        if (!Configuration.generator.contains("Global.sea.generate")) {
            Configuration.generator.set("Global.world.sea.generate", true);
        }

        // Blocks config
        if (!Configuration.generator.contains("Global.bedrock.frequency")) {
            Configuration.generator.set("Global.bedrock.frequency", 40);
        }
        if (!Configuration.generator.contains("Global.bedrock.generate")) {
            Configuration.generator.set("Global.bedrock.generate", true);
        }
        if (!Configuration.generator.contains("Global.grass.frequency")) {
            Configuration.generator.set("Global.grass.frequency", 60);
        }
        if (!Configuration.generator.contains("Global.grass.generate")) {
            Configuration.generator.set("Global.grass.generate", true);
        }

        // Plants config
        if (!Configuration.generator.contains("Global.flowers.frequency")) {
            Configuration.generator.set("Global.flowers.frequency", 10);
        }
        if (!Configuration.generator.contains("Global.flowers.generate")) {
            Configuration.generator.set("Global.flowers.generate", true);
        }
        if (!Configuration.generator.contains("Global.cacti.frequency")) {
            Configuration.generator.set("Global.cacti.frequency", 10);
        }
        if (!Configuration.generator.contains("Global.cacti.generate")) {
            Configuration.generator.set("Global.cacti.generate", true);
        }
        if (!Configuration.generator.contains("Global.pumpkins and melons.frequency")) {
            Configuration.generator.set("Global.pumpkins and melons.frequency", 5);
        }
        if (!Configuration.generator.contains("Global.pumpkins and melons.generate")) {
            Configuration.generator.set("Global.pumpkins and melons.generate", true);
        }
        if (!Configuration.generator.contains("Global.sugar cane.frequency")) {
            Configuration.generator.set("Global.sugar cane.frequency", 15);
        }
        if (!Configuration.generator.contains("Global.sugar cane.generate")) {
            Configuration.generator.set("Global.sugar cane.generate", true);
        }
        if (!Configuration.generator.contains("Global.trees.frequency")) {
            Configuration.generator.set("Global.trees.frequency", 60);
        }
        if (!Configuration.generator.contains("Global.trees.generate")) {
            Configuration.generator.set("Global.trees.generate", true);
        }
        if (!Configuration.generator.contains("Global.mushrooms.frequency")) {
            Configuration.generator.set("Global.mushrooms.frequency", 8);
        }
        if (!Configuration.generator.contains("Global.mushrooms.generate")) {
            Configuration.generator.set("Global.mushrooms.generate", true);
        }

        // Biome generation
        if (!Configuration.generator.contains("Global.desert.generate")) {
            Configuration.generator.set("Global.desert.generate", true);
        }
        if (!Configuration.generator.contains("Global.beach.generate")) {
            Configuration.generator.set("Global.beach.generate", true);
        }
        if (!Configuration.generator.contains("Global.mushroom island.generate")) {
            Configuration.generator.set("Global.mushroom island.generate", true);
        }

        // Structures generation
        if (!Configuration.generator.contains("Global.Structures.dungeons")) {
            Configuration.generator.set("Global.Structures.dungeons", true);
        }
        if (!Configuration.generator.contains("Global.Structures.dungeons.frequency")) {
            Configuration.generator.set("Global.Structures.dungeons.frequency", 1);
        }
        if (!Configuration.generator.contains("Global.Structures.dungeons.chest.generate")) {
            Configuration.generator.set("Global.Structures.dungeons.chest.generate", true);
        }
        if (!Configuration.generator.contains("Global.Structures.dungeons.chest.frequency")) {
            Configuration.generator.set("Global.Structures.dungeons.chest.frequency", 2);
        }
        if (!Configuration.generator.contains("Global.Structures.villages")) {
            Configuration.generator.set("Global.Structures.villages", true);
        }
        if (!Configuration.generator.contains("Global.Structures.villages.frequency")) {
            Configuration.generator.set("Global.Structures.villages.frequency", 250);
        }
        if (!Configuration.generator.contains("Global.Structures.caves")) {
            Configuration.generator.set("Global.Structures.caves", true);
        }
        if (!Configuration.generator.contains("Global.Structures.caves.frequency")) {
            Configuration.generator.set("Global.Structures.caves.frequency", 300);
        }

        // Ores generation
        if (!Configuration.generator.contains("Global.Ores.Custom")) {
            Configuration.generator.set("Global.Ores.Custom", true);
        }
        if (!Configuration.generator.contains("Global.Ores.Original")) {
            Configuration.generator.set("Global.Ores.Original", true);
        }
    }
}