package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;
import java.util.List;

public class BlockConfig {

    @SuppressWarnings ("unchecked")
    public static void set() {
        if (!Configuration.block.contains("Original Ores.use default config")) {
            Configuration.block.set("Original Ores.use default config", false);
        }

        if (Configuration.block.getBoolean("Original Ores.use default config")) {
            // Original Ores
            final String[] ores = new String[] { "Coal Ore", "Iron Ore", "Lapis Ore", "Gold Ore", "Redstone Ore", "Diamond Ore" };
            final int[] frequency = new int[] { 15, 10, 2, 3, 3, 1 };
            final int[] maxVeinSize = new int[] { 10, 6, 4, 4, 5, 3 };
            final int[] minHeight = new int[] { 16, 16, 2, 5, 3, 3 };
            final int[] maxHeight = new int[] { 70, 64, 34, 32, 16, 16 };

            for (int i = 0; i < ores.length; i++) {

                if (!Configuration.block.contains("Original Ores." + ores[i] + ".frequency")) {
                    Configuration.block.set("Original Ores." + ores[i] + ".frequency", frequency[i]);
                }
                if (!Configuration.block.contains("Original Ores." + ores[i] + ".max vein size")) {
                    Configuration.block.set("Original Ores." + ores[i] + ".max vein size", maxVeinSize[i]);
                }
                if (!Configuration.block.contains("Original Ores." + ores[i] + ".min height")) {
                    Configuration.block.set("Original Ores." + ores[i] + ".min height", minHeight[i]);
                }
                if (!Configuration.block.contains("Original Ores." + ores[i] + ".max height")) {
                    Configuration.block.set("Original Ores." + ores[i] + ".max height", maxHeight[i]);
                }
            }
        }

        if (!Configuration.block.contains("Custom Ores.use default config")) {
            Configuration.block.set("Custom Ores.use default config", false);
        }

        if (Configuration.block.getBoolean("Custom Ores.use default config")) {
            // Custom Ores
            final String[] cOres = new String[] { "Adamantine Ore", "Irridium Ore", "Mithril Ore", "Verdite Ore", "Amethyst Ore", "Saphire Ore", "Topaz Ore" };
            final int[] textureIds = new int[] { 0, 1, 2, 3, 254, 253, 252 };
            final int[] cFrequency = new int[] { 1, 1, 3, 12, 3, 4, 6 };
            final int[] cMaxVeinSize = new int[] { 2, 2, 4, 8, 3, 4, 4 };
            final int[] cMinHeight = new int[] { 3, 3, 20, 55, 28, 40, 16 };
            final int[] cMaxHeight = new int[] { 10, 5, 30, 70, 36, 60, 70 };
            final int[] hardness = new int[] { 10, 8, 7, 2, 6, 4, 3 };
            final int[] base = new int[] { 1, 1, 1, 1, 1, 1, 1 };
            final String[] drop = new String[] { "Adamantine Ingot", null, null, null, null, null, null };
            final boolean[] buyAble = new boolean[] { true, true, true, true, true, true, true };
            final boolean[] sellAble = new boolean[] { true, true, true, true, true, true, true };
            final int[] buyPrice = new int[] { 1000, 2000, 800, 500, 800, 800, 600 };
            final int[] sellPrice = new int[] { 500, 1000, 400, 250, 400, 400, 300 };

            for (int i = 0; i < cOres.length; i++) {

                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".textureID")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".textureID", textureIds[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".frequency")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".frequency", cFrequency[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".max vein size")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".max vein size", cMaxVeinSize[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".min height")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".min height", cMinHeight[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".max height")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".max height", cMaxHeight[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".hardness")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".hardness", hardness[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".base")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".base", base[i]);
                }
                if (drop[i] != null && !Configuration.block.contains("Custom Ores." + cOres[i] + ".drop")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".drop", drop[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".Buy Able")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".Buy Able", buyAble[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".Sell Able")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".Sell Able", sellAble[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".Buy Price")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".Buy Price", buyPrice[i]);
                }
                if (!Configuration.block.contains("Custom Ores." + cOres[i] + ".Sell Price")) {
                    Configuration.block.set("Custom Ores." + cOres[i] + ".Sell Price", sellPrice[i]);
                }
            }
        }
        if (!Configuration.block.contains("Bushes.use default config")) {
            Configuration.block.set("Bushes.use default config", false);
        }

        if (Configuration.block.getBoolean("Bushes.use default config")) {
            // bushes
            final String[] bushes = new String[] { "Orange", "Dark Green", "Green", "Light Green", "Pink", "White" };
            final String[] bIds = new String[] { "0,0,0,0,0,0", "3,3,3,3,3,3", "4,4,4,4,4,4", "5,5,5,5,5,5", "11,11,11,11,11,11", "12,12,12,12,12,12" };
            final List<String>[] ingredients = new List[] {
                    Arrays.asList("18,18,18", "18,351:14,18", "18,18,18"),
                    Arrays.asList("18,18,18", "18,351:2,18", "18,18,18"),
                    Arrays.asList("18,18,18", "18,18,18", "18,18,18"),
                    Arrays.asList("18,18,18", "18,351:10,18", "18,18,18"),
                    Arrays.asList("18,18,18", "18,351:9,18", "18,18,18"),
                    Arrays.asList("18,18,18", "18,351:15,18", "18,18,18") };

            for (int i = 0; i < bushes.length; i++) {
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.textureIds")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.textureIds", bIds[i]);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.design")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.design", "bush");
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.textureurl")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/plants.png");
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.texturesize")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.texturesize", 16);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.base")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.base", 30);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.shaped recipe1.amount")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.shaped recipe1.amount", 1);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.shaped recipe1.ingredients")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.shaped recipe1.ingredients", ingredients[i]);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.Sell Able")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.Sell Able", true);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.Buy Able")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.Buy Able", true);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.Buy Price")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.Buy Price", 100);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.Sell Price")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.Sell Price", 50);
                }
                if (!Configuration.block.contains("Custom Blocks." + bushes[i] + " Bush.storetype")) {
                    Configuration.block.set("Custom Blocks." + bushes[i] + " Bush.storetype", "gardening");
                }
            }
        }
        if (!Configuration.block.contains("Signs.use default config")) {
            Configuration.block.set("Signs.use default config", true);
        }

        if (Configuration.block.getBoolean("Signs.use default config")) {
            final String[] signs = new String[] { "Blank", "Alchemist", "Armor", "Bakery", "Blacksmith", "Bookstore", "Bowyer", "Cafe", "Carpenter", "Cobbler", "Dyer", "Fishmonger", "Florist", "General", "Grocery", "Healer", "Herbalist", "Inn", "Items", "Jeweler", "Library", "Livestock", "Magic", "Mason", "Music", "Pets", "Potions", "Pub", "Tailor", "Tanner", "Tools", "Weapons" };
            final String[] sIds = new String[] { "30,0,33,0,0,0", "32,0,33,0,0,0", "10,0,33,0,0,0", "9,0,33,0,0,0", "8,0,33,0,0,0", "7,0,33,0,0,0", "6,0,33,0,0,0", "5,0,33,0,0,0", "4,0,33,0,0,0", "3,0,33,0,0,0", "2,0,33,0,0,0", "1,0,33,0,0,0", "29,0,33,0,0,0", "28,0,33,0,0,0", "27,0,33,0,0,0", "26,0,33,0,0,0", "25,0,33,0,0,0", "24,0,33,0,0,0", "23,0,33,0,0,0", "22,0,33,0,0,0", "21,0,33,0,0,0", "20,0,33,0,0,0", "19,0,33,0,0,0", "18,0,33,0,0,0", "17,0,33,0,0,0", "16,0,33,0,0,0", "31,0,33,0,0,0", "15,0,33,0,0,0", "14,0,33,0,0,0", "13,0,33,0,0,0", "12,0,33,0,0,0", "11,0,33,0,0,0" };

            for (int i = 0; i < signs.length; i++) {
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.textureIds")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.textureIds", sIds[i]);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.design")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.design", "sign");
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.textureurl")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/signs.png");
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.texturesize")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.texturesize", 64);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.base")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.base", 85);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.rotate")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.rotate", true);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.Sell Able")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.Sell Able", false);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.Buy Able")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.Buy Able", false);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.Buy Price")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.Buy Price", 100);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.Sell Price")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.Sell Price", 50);
                }
                if (!Configuration.block.contains("Custom Blocks." + signs[i] + " Sign.storetype")) {
                    Configuration.block.set("Custom Blocks." + signs[i] + " Sign.storetype", "miscellaneousellaneous");
                }
            }
        }
        if (!Configuration.block.contains("Flowers.use default config")) {
            Configuration.block.set("Flowers.use default config", false);
        }

        if (Configuration.block.getBoolean("Flowers.use default config")) {

            // flowers
            if (!Configuration.block.contains("Custom Blocks.Tulip.textureIds")) {
                Configuration.block.set("Custom Blocks.Tulip.textureIds", "16,16,16,16,16,16");
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.design")) {
                Configuration.block.set("Custom Blocks.Tulip.design", "flower");
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.textureurl")) {
                Configuration.block.set("Custom Blocks.Tulip.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/plants.png");
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.texturesize")) {
                Configuration.block.set("Custom Blocks.Tulip.texturesize", 16);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.base")) {
                Configuration.block.set("Custom Blocks.Tulip.base", 38);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.brightness")) {
                Configuration.block.set("Custom Blocks.Tulip.brightness", 0.0D);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.rotate")) {
                Configuration.block.set("Custom Blocks.Tulip.rotate", false);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.frequency")) {
                Configuration.block.set("Custom Blocks.Tulip.frequency", 10);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.Sell Able")) {
                Configuration.block.set("Custom Blocks.Tulip.Sell Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.Buy Able")) {
                Configuration.block.set("Custom Blocks.Tulip.Buy Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.Buy Price")) {
                Configuration.block.set("Custom Blocks.Tulip.Buy Price", 50);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.Sell Price")) {
                Configuration.block.set("Custom Blocks.Tulip.Sell Price", 25);
            }
            if (!Configuration.block.contains("Custom Blocks.Tulip.storetype")) {
                Configuration.block.set("Custom Blocks.Tulip.storetype", "gardening");
            }
        }
        if (!Configuration.block.contains("Other.use default config")) {
            Configuration.block.set("Other.use default config", true);
        }

        if (Configuration.block.getBoolean("Other.use default config")) {
            // Other
            if (!Configuration.block.contains("Custom Blocks.Barrel.textureIds")) {
                Configuration.block.set("Custom Blocks.Barrel.textureIds", "0,1,2,3,4,5");
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.design")) {
                Configuration.block.set("Custom Blocks.Barrel.design", "barrel");
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.textureurl")) {
                Configuration.block.set("Custom Blocks.Barrel.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/barrel.png");
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.texturesize")) {
                Configuration.block.set("Custom Blocks.Barrel.texturesize", 64);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.base")) {
                Configuration.block.set("Custom Blocks.Barrel.base", 85);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.rotate")) {
                Configuration.block.set("Custom Blocks.Barrel.rotate", false);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.Sell Able")) {
                Configuration.block.set("Custom Blocks.Barrel.Sell Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.Buy Able")) {
                Configuration.block.set("Custom Blocks.Barrel.Buy Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.Buy Price")) {
                Configuration.block.set("Custom Blocks.Barrel.Buy Price", 100);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.Sell Price")) {
                Configuration.block.set("Custom Blocks.Barrel.Sell Price", 50);
            }
            if (!Configuration.block.contains("Custom Blocks.Barrel.storetype")) {
                Configuration.block.set("Custom Blocks.Barrel.storetype", "miscellaneous");
            }

            if (!Configuration.block.contains("Custom Blocks.Pole.textureIds")) {
                Configuration.block.set("Custom Blocks.Pole.textureIds", "13,13,13,13,13,13");
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.design")) {
                Configuration.block.set("Custom Blocks.Pole.design", "pole");
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.textureurl")) {
                Configuration.block.set("Custom Blocks.Pole.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/blocks.png");
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.texturesize")) {
                Configuration.block.set("Custom Blocks.Pole.texturesize", 64);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.base")) {
                Configuration.block.set("Custom Blocks.Pole.base", 85);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.rotate")) {
                Configuration.block.set("Custom Blocks.Pole.rotate", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.Sell Able")) {
                Configuration.block.set("Custom Blocks.Pole.Sell Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.Buy Able")) {
                Configuration.block.set("Custom Blocks.Pole.Buy Able", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.Buy Price")) {
                Configuration.block.set("Custom Blocks.Pole.Buy Price", 100);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.Sell Price")) {
                Configuration.block.set("Custom Blocks.Pole.Sell Price", 50);
            }
            if (!Configuration.block.contains("Custom Blocks.Pole.storetype")) {
                Configuration.block.set("Custom Blocks.Pole.storetype", "miscellaneous");
            }

            if (!Configuration.block.contains("Custom Blocks.Invisible Block.textureIds")) {
                Configuration.block.set("Custom Blocks.Invisible Block.textureIds", "14,14,14,14,14,14");
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.design")) {
                Configuration.block.set("Custom Blocks.Invisible Block.design", "block");
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.textureurl")) {
                Configuration.block.set("Custom Blocks.Invisible Block.textureurl", "http://rpgessentials.lynxdragon.com/plugin/textures/blocks.png");
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.texturesize")) {
                Configuration.block.set("Custom Blocks.Invisible Block.texturesize", 64);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.base")) {
                Configuration.block.set("Custom Blocks.Invisible Block.base", 85);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.rotate")) {
                Configuration.block.set("Custom Blocks.Invisible Block.rotate", true);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.Sell Able")) {
                Configuration.block.set("Custom Blocks.Invisible Block.Sell Able", false);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.Buy Able")) {
                Configuration.block.set("Custom Blocks.Invisible Block.Buy Able", false);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.Buy Price")) {
                Configuration.block.set("Custom Blocks.Invisible Block.Buy Price", 100);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.Sell Price")) {
                Configuration.block.set("Custom Blocks.Invisible Block.Sell Price", 50);
            }
            if (!Configuration.block.contains("Custom Blocks.Invisible Block.storetype")) {
                Configuration.block.set("Custom Blocks.Invisible Block.storetype", "miscellaneous");
            }
        }
    }
}