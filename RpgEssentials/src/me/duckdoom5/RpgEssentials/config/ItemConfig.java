package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;
import java.util.List;

public class ItemConfig {

    @SuppressWarnings ("unchecked")
    public static void set() {
        // Coins
        final String[] coins = new String[] { "Bronze", "Silver", "Gold" };
        for (int i = 0; i < coins.length; i++) {
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.texture url")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/misc/" + coins[i].toLowerCase() + "coin.png");
            }
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.Sell Able")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.Sell Able", false);
            }
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.Buy Able")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.Buy Able", false);
            }
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.Buy Price")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.Buy Price", 1);
            }
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.Sell Price")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.Sell Price", 0);
            }
            if (!Configuration.items.contains("Custom Items." + coins[i] + " Coin.storetype")) {
                Configuration.items.set("Custom Items." + coins[i] + " Coin.storetype", "miscellaneous");
            }
        }

        // Custom Items
        final String[] wands = new String[] { "NPC", "Pet", "Snow", "Spawner" };
        for (int i = 0; i < wands.length; i++) {
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.texture url")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/wands/" + wands[i].toLowerCase() + "wand.png");
            }
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.Sell Able")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.Buy Able")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.Buy Price")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.Buy Price", 1000);
            }
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.Sell Price")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.Sell Price", 200);
            }
            if (!Configuration.items.contains("Custom Items." + wands[i] + " Wand.storetype")) {
                Configuration.items.set("Custom Items." + wands[i] + " Wand.storetype", "miscellaneous");
            }
        }

        if (!Configuration.block.contains("Bolts.use default config")) {
            Configuration.block.set("Bolts.use default config", true);
        }
        if (Configuration.block.getBoolean("Bolts.use default config")) {
            // bolts
            final String[] bolts = new String[] { "Wood", "Stone", "Iron", "Gold", "Diamond" };
            final int[] damage = new int[] { 2, 3, 5, 7, 10 };
            final List<String>[] recipe = new List[] { Arrays.asList("280", "5"), Arrays.asList("280", "4"), Arrays.asList("280", "265"), Arrays.asList("280", "266"), Arrays.asList("280", "264") };
            final int[] buyPrice = new int[] { 5, 7, 15, 25, 50 };
            final int[] sellPrice = new int[] { 1, 2, 3, 5, 10 };

            for (int i = 0; i < bolts.length; i++) {
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.texture url")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/bolts/" + bolts[i] + "bolt.png");
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.type")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.type", "bolt");
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.damage")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.damage", damage[i]);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.shapeless recipe1.amount")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.shapeless recipe1.amount", 4);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.shapeless recipe1.ingredients")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.shapeless recipe1.ingredients", recipe[i]);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.Sell Able")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.Sell Able", true);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.Buy Able")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.Buy Able", true);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.Buy Price")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.Buy Price", buyPrice[i]);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.Sell Price")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.Sell Price", sellPrice[i]);
                }
                if (!Configuration.items.contains("Custom Items." + bolts[i] + " Bolt.storetype")) {
                    Configuration.items.set("Custom Items." + bolts[i] + " Bolt.storetype", "tools");
                }
            }

            if (!Configuration.block.contains("Ingots.use default config")) {
                Configuration.block.set("Ingots.use default config", true);
            }
            if (Configuration.block.getBoolean("Ingots.use default config")) {
                final String[] ingots = new String[] { "Adamantine", "Mithril", "Verdite" };
                final int[] iBuyPrice = new int[] { 1000, 400, 200 };
                final int[] iSellPrice = new int[] { 300, 100, 50 };

                for (int i = 0; i < ingots.length; i++) {
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.texture url")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/ingots/" + ingots[i] + "ingot.png");
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.furnace recipe1.amount")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.furnace recipe1.amount", 1);
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.furnace recipe1.ingredient")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.furnace recipe1.ingredient", ingots[i] + " Ore");
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.Sell Able")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.Sell Able", true);
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.Buy Able")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.Buy Able", true);
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.Buy Price")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.Buy Price", iBuyPrice[i]);
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.Sell Price")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.Sell Price", iSellPrice[i]);
                    }
                    if (!Configuration.items.contains("Custom Items." + ingots[i] + " Ingot.storetype")) {
                        Configuration.items.set("Custom Items." + ingots[i] + " Ingot.storetype", "raw materials");
                    }
                }
            }

            // Iridium nugget
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.texture url")) {
                Configuration.items.set("Custom Items.Iridium Nugget.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/ingots/Iridiumnugget.png");
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.amount")) {
                Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.ingredient")) {
                Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.ingredient", "Iridium Ore");
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.Sell Able")) {
                Configuration.items.set("Custom Items.Iridium Nugget.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.Buy Able")) {
                Configuration.items.set("Custom Items.Iridium Nugget.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.Buy Price")) {
                Configuration.items.set("Custom Items.Iridium Nugget.Buy Price", 500);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.Sell Price")) {
                Configuration.items.set("Custom Items.Iridium Nugget.Sell Price", 300);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Nugget.storetype")) {
                Configuration.items.set("Custom Items.Iridium Nugget.storetype", "raw materials");
            }

            // Iridium ingot
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.texture url")) {
                Configuration.items.set("Custom Items.Iridium Ingot.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/ingots/Iridiumingot.png");
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.amount")) {
                Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.ingredient")) {
                Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.ingredient", "Iridium Nugget");
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.Sell Able")) {
                Configuration.items.set("Custom Items.Iridium Ingot.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.Buy Able")) {
                Configuration.items.set("Custom Items.Iridium Ingot.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.Buy Price")) {
                Configuration.items.set("Custom Items.Iridium Ingot.Buy Price", 600);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.Sell Price")) {
                Configuration.items.set("Custom Items.Iridium Ingot.Sell Price", 200);
            }
            if (!Configuration.items.contains("Custom Items.Iridium Ingot.storetype")) {
                Configuration.items.set("Custom Items.Iridium Ingot.storetype", "raw materials");
            }

            if (!Configuration.items.contains("Custom Items.Chain.texture url")) {
                Configuration.items.set("Custom Items.Chain.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/items/chain.png");
            }
            if (!Configuration.items.contains("Custom Items.Chain.shapeless recipe1.amount")) {
                Configuration.items.set("Custom Items.Chain.shapeless recipe1.amount", 2);
            }
            if (!Configuration.items.contains("Custom Items.Chain.shapeless recipe1.ingredients")) {
                Configuration.items.set("Custom Items.Chain.shapeless recipe1.ingredients", Arrays.asList("265"));
            }
            if (!Configuration.items.contains("Custom Items.Chain.Sell Able")) {
                Configuration.items.set("Custom Items.Chain.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Chain.Buy Able")) {
                Configuration.items.set("Custom Items.Chain.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Items.Chain.Buy Price")) {
                Configuration.items.set("Custom Items.Chain.Buy Price", 1000);
            }
            if (!Configuration.items.contains("Custom Items.Chain.Sell Price")) {
                Configuration.items.set("Custom Items.Chain.Sell Price", 1);
            }
            if (!Configuration.items.contains("Custom Items.Chain.storetype")) {
                Configuration.items.set("Custom Items.Chain.storetype", "raw materials");
            }

            // Custom Fish
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.texture url")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/fish/cavetrout.png");
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.restore")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.restore", 10);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.level")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.level", 50);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.chance")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.chance", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.xp")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.xp", 150);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.Buy Able")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.Buy Price")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Trout.Sell Price")) {
                Configuration.items.set("Custom Fish.Raw Cave Trout.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.texture url")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/fish/caveeel.png");
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.restore")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.restore", 10);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.level")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.level", 40);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.chance")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.chance", 8);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.xp")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.xp", 70);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.Buy Able")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.Buy Price")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Cave Eel.Sell Price")) {
                Configuration.items.set("Custom Fish.Raw Cave Eel.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.texture url")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/fish/minefish.png");
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.restore")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.restore", 3);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.level")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.level", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.chance")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.chance", 30);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.xp")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.xp", 25);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.Buy Able")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.Buy Price")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Mine Fish.Sell Price")) {
                Configuration.items.set("Custom Fish.Raw Mine Fish.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.texture url")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/fish/pufferfish.png");
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.restore")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.restore", 4);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.level")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.level", 20);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.chance")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.chance", 10);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.xp")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.xp", 50);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.Buy Able")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.Buy Price")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Fish.Raw Puffer Fish.Sell Price")) {
                Configuration.items.set("Custom Fish.Raw Puffer Fish.Sell Price", 1);
            }

            // Custom Food

            // tomato
            if (!Configuration.items.contains("Custom Food.Tomato.texture url")) {
                Configuration.items.set("Custom Food.Tomato.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/tomato.png");
            }
            if (!Configuration.items.contains("Custom Food.Tomato.restore")) {
                Configuration.items.set("Custom Food.Tomato.restore", 3);
            }
            if (!Configuration.items.contains("Custom Food.Tomato.Buy Able")) {
                Configuration.items.set("Custom Food.Tomato.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Tomato.Buy Price")) {
                Configuration.items.set("Custom Food.Tomato.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Tomato.Sell Price")) {
                Configuration.items.set("Custom Food.Tomato.Sell Price", 1);
            }

            // salad
            if (!Configuration.items.contains("Custom Food.Salad.texture url")) {
                Configuration.items.set("Custom Food.Salad.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/salad.png");
            }
            if (!Configuration.items.contains("Custom Food.Salad.restore")) {
                Configuration.items.set("Custom Food.Salad.restore", 2);
            }
            if (!Configuration.items.contains("Custom Food.Salad.Buy Able")) {
                Configuration.items.set("Custom Food.Salad.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Salad.Buy Price")) {
                Configuration.items.set("Custom Food.Salad.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Salad.Sell Price")) {
                Configuration.items.set("Custom Food.Salad.Sell Price", 1);
            }

            // cheese
            if (!Configuration.items.contains("Custom Food.Cheese.texture url")) {
                Configuration.items.set("Custom Food.Cheese.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/cheese.png");
            }
            if (!Configuration.items.contains("Custom Food.Cheese.restore")) { Configuration.items.set("Custom Food.Cheese.restore", 8);
            }
            if (!Configuration.items.contains("Custom Food.Cheese.Buy Able")) {
                Configuration.items.set("Custom Food.Cheese.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Cheese.Buy Price")) {
                Configuration.items.set("Custom Food.Cheese.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Cheese.Sell Price")) {
                Configuration.items.set("Custom Food.Cheese.Sell Price", 1);
            }

            // Hamburger
            if (!Configuration.items.contains("Custom Food.Hamburger.texture url")) {
                Configuration.items.set("Custom Food.Hamburger.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/hamburger.png");
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.restore")) { Configuration.items.set("Custom Food.Hamburger.restore", 20);
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.shaped recipe1.amount")) {
                Configuration.items.set("Custom Food.Hamburger.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Food.Hamburger.shaped recipe1.ingredients", Arrays.asList("297,297,297", "Salad,Tomato,Cheese", "297,297,297"));
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.Buy Able")) {
                Configuration.items.set("Custom Food.Hamburger.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.Buy Price")) {
                Configuration.items.set("Custom Food.Hamburger.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Hamburger.Sell Price")) {
                Configuration.items.set("Custom Food.Hamburger.Sell Price", 1);
            }

            // Raw Bacon
            if (!Configuration.items.contains("Custom Food.Raw Bacon.texture url")) {
                Configuration.items.set("Custom Food.Raw Bacon.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/rawbacon.png");
            }
            if (!Configuration.items.contains("Custom Food.Raw Bacon.restore")) {
                Configuration.items.set("Custom Food.Raw Bacon.restore", 3);
            }
            if (!Configuration.items.contains("Custom Food.Raw Bacon.Buy Able")) {
                Configuration.items.set("Custom Food.Raw Bacon.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Raw Bacon.Buy Price")) {
                Configuration.items.set("Custom Food.Raw Bacon.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Raw Bacon.Sell Price")) {
                Configuration.items.set("Custom Food.Raw Bacon.Sell Price", 1);
            }

            // Cooked Bacon
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.texture url")) {
                Configuration.items.set("Custom Food.Cooked Bacon.texture url", "http://rpgessentials.lynxdragon.com/plugin/textures/food/cookedbacon.png");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.restore")) {
                Configuration.items.set("Custom Food.Cooked Bacon.restore", 8);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.furnace recipe1.amount")) {
                Configuration.items.set("Custom Food.Cooked Bacon.furnace recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.furnace recipe1.ingredient")) {
                Configuration.items.set("Custom Food.Cooked Bacon.furnace recipe1.ingredient", "Raw Bacon");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.Buy Able")) {
                Configuration.items.set("Custom Food.Cooked Bacon.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.Buy Price")) {
                Configuration.items.set("Custom Food.Cooked Bacon.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Bacon.Sell Price")) {
                Configuration.items.set("Custom Food.Cooked Bacon.Sell Price", 1);
            }

            // Cooked Cave Eel
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.texture url")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/food/cookedcaveeel.png");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.restore")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.restore", 13);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.furnace recipe1.amount")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.furnace recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.furnace recipe1.ingredient")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.furnace recipe1.ingredient","Raw Cave Eel");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.Buy Able")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.Buy Price")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Eel.Sell Price")) {
                Configuration.items.set("Custom Food.Cooked Cave Eel.Sell Price", 1);
            }

            // Cooked Cave Trout
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.texture url")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/food/cookedcavetrout.png");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.restore")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.restore", 15);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.furnace recipe1.amount")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.furnace recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.furnace recipe1.ingredient")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.furnace recipe1.ingredient","Raw Cave Trout");
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.Buy Able")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.Buy Price")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Cooked Cave Trout.Sell Price")) {
                Configuration.items.set("Custom Food.Cooked Cave Trout.Sell Price", 1);
            }

            // Salad Bowl
            if (!Configuration.items.contains("Custom Food.Salad Bowl.texture url")) {
                Configuration.items.set("Custom Food.Salad Bowl.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/food/saladbowl.png");
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.restore")) {
                Configuration.items.set("Custom Food.Salad Bowl.restore", 6);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe1.amount")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe1.ingredients", Arrays.asList("Salad,-,-", "281,-,-", "-,-,-"));
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe2.amount")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe2.ingredients", Arrays.asList("-,Salad,-", "-,281,-", "-,-,-"));
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe3.amount")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Food.Salad Bowl.shaped recipe3.ingredients", Arrays.asList("-,-,Salad", "-,-,281", "-,-,-"));
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.Buy Able")) {
                Configuration.items.set("Custom Food.Salad Bowl.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.Buy Price")) {
                Configuration.items.set("Custom Food.Salad Bowl.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Food.Salad Bowl.Sell Price")) {
                Configuration.items.set("Custom Food.Salad Bowl.Sell Price", 5);
            }

            // Custom Tools
            // Adamantine Sword
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.texture url")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Adamantinesword.png");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.durability")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.damage")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.damage", 10);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.type")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.type","sword");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,Adamantine Ingot,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","Adamantine Ingot,-,-", "280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,Adamantine Ingot", "-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.Sell Able")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.Buy Able")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.Buy Price")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Sword.Sell Price")) {
                Configuration.items.set("Custom Tools.Adamantine Sword.Sell Price", 1);
            }
            // Adamantine Shovel
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.texture url")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Adamantineshovel.png");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.durability")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.type")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.type","shovel");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","280,-,-", "280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,280", "-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.Sell Able")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.Buy Able")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.Buy Price")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Shovel.Sell Price")) {
                Configuration.items.set("Custom Tools.Adamantine Shovel.Sell Price", 1);
            }
            // Adamantine Axe
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.texture url")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Adamantineaxe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.durability")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.type")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.type","axe");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","Adamantine Ingot,280,-", "-,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,Adamantine Ingot", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.Sell Able")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.Buy Able")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.Buy Price")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Axe.Sell Price")) {
                Configuration.items.set("Custom Tools.Adamantine Axe.Sell Price", 1);
            }
            // Adamantine Pickaxe
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.texture url")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Adamantinepick.png");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.durability")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.type")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.type","pickaxe");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,Adamantine Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.Sell Able")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.Buy Able")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.Buy Price")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.Sell Price")) {
                Configuration.items.set("Custom Tools.Adamantine Pickaxe.Sell Price", 1);
            }
            // Adamantine Hoe
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.texture url")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Adamantinehoe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.durability")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.type")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.type","hoe");
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.Sell Able")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.Buy Able")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.Buy Price")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Adamantine Hoe.Sell Price")) {
                Configuration.items.set("Custom Tools.Adamantine Hoe.Sell Price", 1);
            }

            // Iridium Sword
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.texture url")) {
                Configuration.items.set("Custom Tools.Iridium Sword.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Iridiumsword.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.durability")) {
                Configuration.items.set("Custom Tools.Iridium Sword.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.damage")) {
                Configuration.items.set("Custom Tools.Iridium Sword.damage", 8);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.type")) {
                Configuration.items.set("Custom Tools.Iridium Sword.type","sword");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.ingredients", Arrays.asList("-,Iridium Ingot,-","-,Iridium Ingot,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.ingredients", Arrays.asList("Iridium Ingot,-,-","Iridium Ingot,-,-", "280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Iridium Ingot","-,-,Iridium Ingot", "-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.Sell Able")) {
                Configuration.items.set("Custom Tools.Iridium Sword.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.Buy Able")) {
                Configuration.items.set("Custom Tools.Iridium Sword.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.Buy Price")) {
                Configuration.items.set("Custom Tools.Iridium Sword.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Sword.Sell Price")) {
                Configuration.items.set("Custom Tools.Iridium Sword.Sell Price", 1);
            }
            // Iridium Shovel
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.texture url")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Iridiumshovel.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.durability")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.type")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.type","shovel");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe1.ingredients", Arrays.asList("-,Iridium Ingot,-", "-,280,-","-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe2.ingredients", Arrays.asList("Iridium Ingot,-,-", "280,-,-","280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Iridium Ingot", "-,-,280","-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.Sell Able")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.Buy Able")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.Buy Price")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Shovel.Sell Price")) {
                Configuration.items.set("Custom Tools.Iridium Shovel.Sell Price", 1);
            }
            // Iridium Axe
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.texture url")) {
                Configuration.items.set("Custom Tools.Iridium Axe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Iridiumaxe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.durability")) {
                Configuration.items.set("Custom Tools.Iridium Axe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.type")) {
                Configuration.items.set("Custom Tools.Iridium Axe.type", "axe");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,-","Iridium Ingot,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe2.ingredients", Arrays.asList("-,Iridium Ingot,Iridium Ingot","-,280,Iridium Ingot", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.Sell Able")) {
                Configuration.items.set("Custom Tools.Iridium Axe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.Buy Able")) {
                Configuration.items.set("Custom Tools.Iridium Axe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.Buy Price")) {
                Configuration.items.set("Custom Tools.Iridium Axe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Axe.Sell Price")) {
                Configuration.items.set("Custom Tools.Iridium Axe.Sell Price", 1);
            }
            // Iridium Pickaxe
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.texture url")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Iridiumpick.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.durability")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.type")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.type","pickaxe");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,Iridium Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.Sell Able")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.Buy Able")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.Buy Price")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Pickaxe.Sell Price")) {
                Configuration.items.set("Custom Tools.Iridium Pickaxe.Sell Price", 1);
            }
            // Iridium Hoe
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.texture url")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Iridiumhoe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.durability")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.type")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.type", "hoe");
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,-","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe2.ingredients", Arrays.asList("-,Iridium Ingot,Iridium Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.Sell Able")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.Buy Able")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.Buy Price")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iridium Hoe.Sell Price")) {
                Configuration.items.set("Custom Tools.Iridium Hoe.Sell Price", 1);
            }

            // Mithril Sword
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.texture url")) {
                Configuration.items.set("Custom Tools.Mithril Sword.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Mithrilsword.png");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.durability")) {
                Configuration.items.set("Custom Tools.Mithril Sword.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.damage")) {
                Configuration.items.set("Custom Tools.Mithril Sword.damage", 6);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.type")) {
                Configuration.items.set("Custom Tools.Mithril Sword.type","sword");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe1.ingredients", Arrays.asList("-,Mithril Ingot,-","-,Mithril Ingot,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe2.ingredients", Arrays.asList("Mithril Ingot,-,-","Mithril Ingot,-,-", "280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Mithril Ingot","-,-,Mithril Ingot", "-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.Sell Able")) {
                Configuration.items.set("Custom Tools.Mithril Sword.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.Buy Able")) {
                Configuration.items.set("Custom Tools.Mithril Sword.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.Buy Price")) {
                Configuration.items.set("Custom Tools.Mithril Sword.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Sword.Sell Price")) {
                Configuration.items.set("Custom Tools.Mithril Sword.Sell Price", 1);
            }
            // Mithril Shovel
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.texture url")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Mithrilshovel.png");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.durability")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.type")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.type","shovel");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe1.ingredients", Arrays.asList("-,Mithril Ingot,-", "-,280,-","-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe2.ingredients", Arrays.asList("Mithril Ingot,-,-", "280,-,-","280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Mithril Ingot", "-,-,280","-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.Sell Able")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.Buy Able")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.Buy Price")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Shovel.Sell Price")) {
                Configuration.items.set("Custom Tools.Mithril Shovel.Sell Price", 1);
            }
            // Mithril Axe
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.texture url")) {
                Configuration.items.set("Custom Tools.Mithril Axe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Mithrilaxe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.durability")) {
                Configuration.items.set("Custom Tools.Mithril Axe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.type")) {
                Configuration.items.set("Custom Tools.Mithril Axe.type", "axe");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,-","Mithril Ingot,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe2.ingredients", Arrays.asList("-,Mithril Ingot,Mithril Ingot","-,280,Mithril Ingot", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.Sell Able")) {
                Configuration.items.set("Custom Tools.Mithril Axe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.Buy Able")) {
                Configuration.items.set("Custom Tools.Mithril Axe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.Buy Price")) {
                Configuration.items.set("Custom Tools.Mithril Axe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Axe.Sell Price")) {
                Configuration.items.set("Custom Tools.Mithril Axe.Sell Price", 1);
            }
            // Mithril Pickaxe
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.texture url")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Mithrilpick.png");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.durability")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.type")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.type","pickaxe");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,Mithril Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.Sell Able")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.Buy Able")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.Buy Price")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Pickaxe.Sell Price")) {
                Configuration.items.set("Custom Tools.Mithril Pickaxe.Sell Price", 1);
            }
            // Mithril Hoe
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.texture url")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Mithrilhoe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.durability")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.durability",
                        20);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.type")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.type", "hoe");
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,-","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe2.ingredients", Arrays.asList("-,Mithril Ingot,Mithril Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.Sell Able")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.Buy Able")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.Buy Price")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Mithril Hoe.Sell Price")) {
                Configuration.items.set("Custom Tools.Mithril Hoe.Sell Price", 1);
            }

            // Verdite Sword
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.texture url")) {
                Configuration.items.set("Custom Tools.Verdite Sword.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Verditesword.png");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.durability")) {
                Configuration.items.set("Custom Tools.Verdite Sword.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.damage")) {
                Configuration.items.set("Custom Tools.Verdite Sword.damage", 4);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.type")) {
                Configuration.items.set("Custom Tools.Verdite Sword.type","sword");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe1.ingredients", Arrays.asList("-,Verdite Ingot,-","-,Verdite Ingot,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe2.ingredients", Arrays.asList("Verdite Ingot,-,-","Verdite Ingot,-,-", "280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Verdite Ingot","-,-,Verdite Ingot", "-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.Sell Able")) {
                Configuration.items.set("Custom Tools.Verdite Sword.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.Buy Able")) {
                Configuration.items.set("Custom Tools.Verdite Sword.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.Buy Price")) {
                Configuration.items.set("Custom Tools.Verdite Sword.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Sword.Sell Price")) {
                Configuration.items.set("Custom Tools.Verdite Sword.Sell Price", 1);
            }
            // Verdite Shovel
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.texture url")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Verditeshovel.png");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.durability")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.type")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.type","shovel");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe1.ingredients", Arrays.asList("-,Verdite Ingot,-", "-,280,-","-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe2.ingredients", Arrays.asList("Verdite Ingot,-,-", "280,-,-","280,-,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe3.amount")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe3.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe3.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Verdite Ingot", "-,-,280","-,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.Sell Able")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.Buy Able")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.Buy Price")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Shovel.Sell Price")) {
                Configuration.items.set("Custom Tools.Verdite Shovel.Sell Price", 1);
            }
            // Verdite Axe
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.texture url")) {
                Configuration.items.set("Custom Tools.Verdite Axe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Verditeaxe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.durability")) {
                Configuration.items.set("Custom Tools.Verdite Axe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.type")) {
                Configuration.items.set("Custom Tools.Verdite Axe.type", "axe");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,-","Verdite Ingot,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe2.ingredients", Arrays.asList("-,Verdite Ingot,Verdite Ingot","-,280,Verdite Ingot", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.Sell Able")) {
                Configuration.items.set("Custom Tools.Verdite Axe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.Buy Able")) {
                Configuration.items.set("Custom Tools.Verdite Axe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.Buy Price")) {
                Configuration.items.set("Custom Tools.Verdite Axe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Axe.Sell Price")) {
                Configuration.items.set("Custom Tools.Verdite Axe.Sell Price", 1);
            }
            // Verdite Pickaxe
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.texture url")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Verditepick.png");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.durability")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.type")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.type","pickaxe");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,Verdite Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.Sell Able")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.Buy Able")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.Buy Price")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Pickaxe.Sell Price")) {
                Configuration.items.set("Custom Tools.Verdite Pickaxe.Sell Price", 1);
            }
            // Verdite Hoe
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.texture url")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/tools/Verditehoe.png");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.durability")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.type")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.type", "hoe");
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,-","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe2.amount")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe2.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe2.ingredients")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe2.ingredients", Arrays.asList("-,Verdite Ingot,Verdite Ingot","-,280,-", "-,280,-"));
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.Sell Able")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.Buy Able")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.Buy Price")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Verdite Hoe.Sell Price")) {
                Configuration.items.set("Custom Tools.Verdite Hoe.Sell Price", 1);
            }

            // cross bows
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.texture url")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/crossbows/Woodcrossbow.png");
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.durability")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.required bolts")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.required bolts", Arrays.asList("Wood Bolt"));
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.type")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.type","crossbow");
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.shaped recipe1.ingredients", Arrays.asList("5,5,287", "5,280,-", "287,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.Sell Able")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.Buy Able")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.Buy Price")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Wood Crossbow.Sell Price")) {
                Configuration.items.set("Custom Tools.Wood Crossbow.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.texture url")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/crossbows/Stonecrossbow.png");
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.durability")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.required bolts")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.required bolts", Arrays.asList("Wood Bolt", "Stone Bolt"));
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.type")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.type","crossbow");
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.shaped recipe1.ingredients", Arrays.asList("4,4,287", "4,280,-", "287,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.Sell Able")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.Buy Able")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.Buy Price")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Stone Crossbow.Sell Price")) {
                Configuration.items.set("Custom Tools.Stone Crossbow.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.texture url")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/crossbows/Ironcrossbow.png");
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.durability")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.required bolts")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.required bolts", Arrays.asList("Wood Bolt", "Stone Bolt", "Iron Bolt"));
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.type")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.type","crossbow");
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.shaped recipe1.ingredients", Arrays.asList("265,265,287", "265,280,-","287,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.Sell Able")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.Buy Able")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.Buy Price")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Iron Crossbow.Sell Price")) {
                Configuration.items.set("Custom Tools.Iron Crossbow.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.texture url")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/crossbows/Goldcrossbow.png");
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.durability")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.required bolts")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.required bolts", Arrays.asList("Wood Bolt", "Stone Bolt", "Iron Bolt","Gold Bolt"));
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.type")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.type","crossbow");
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.shaped recipe1.ingredients", Arrays.asList("266,266,287", "266,280,-","287,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.Sell Able")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.Buy Able")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.Buy Price")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Gold Crossbow.Sell Price")) {
                Configuration.items.set("Custom Tools.Gold Crossbow.Sell Price", 1);
            }

            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.texture url")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.texture url","http://rpgessentials.lynxdragon.com/plugin/textures/crossbows/Diamondcrossbow.png");
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.durability")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.durability", 20);
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.required bolts")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.required bolts", Arrays.asList("Wood Bolt", "Stone Bolt", "Iron Bolt", "Gold Bolt", "Diamond Bolt"));
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.type")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.type", "crossbow");
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.shaped recipe1.amount")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.shaped recipe1.amount", 1);
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.shaped recipe1.ingredients")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.shaped recipe1.ingredients", Arrays.asList("264,264,287", "264,280,-", "287,-,280"));
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.Sell Able")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.Sell Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.Buy Able")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.Buy Able", true);
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.Buy Price")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.Buy Price", 5);
            }
            if (!Configuration.items.contains("Custom Tools.Diamond Crossbow.Sell Price")) {
                Configuration.items.set("Custom Tools.Diamond Crossbow.Sell Price", 1);
            }
        }
    }
}