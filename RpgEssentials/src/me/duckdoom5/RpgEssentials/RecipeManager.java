package me.duckdoom5.RpgEssentials;

import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.MyConfiguration;
import me.duckdoom5.RpgEssentials.util.FurnaceRecipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class RecipeManager {

    public RecipeManager() {
        addItemShapedRecipe();
        addBlockShapedRecipe();
        addToolShapedRecipe();
        addFoodShapedRecipe();
        addChainmailRecipe();
    }
    
    private static String[] row1dv1;
    private static String[] row1dv2;
    private static String[] row1dv3;
    private static String[] row2dv1;
    private static String[] row2dv2;
    private static String[] row2dv3;
    private static String[] row3dv1;
    private static String[] row3dv2;
    private static String[] row3dv3;

    private void addItemShapedRecipe() {
        for (final GenericCustomItem item : RpgeManager.getInstance().getMaterialManager().getItems()) {
            checkItem("Items", item, Configuration.items);
        }
    }

    private void addBlockShapedRecipe() {
        for (final GenericCustomBlock block : RpgeManager.getInstance().getMaterialManager().getOres()) {
            checkItem("Ores", block, Configuration.block);
        }
        for (final GenericCustomBlock block : RpgeManager.getInstance().getMaterialManager().getBlocks()) {
            checkItem("Blocks", block, Configuration.block);
        }
    }

    private void addToolShapedRecipe() {
        for (final GenericCustomItem tool : RpgeManager.getInstance().getMaterialManager().getTools()) {
            checkItem("Tools", tool, Configuration.items);
        }
    }

    private void addFoodShapedRecipe() {
        for (final GenericCustomItem food : RpgeManager.getInstance().getMaterialManager().getFood()) {
            checkItem("Food", food, Configuration.items);
        }
    }

    private int i = 0;
    private SpoutShapedRecipe recipe;
    private SpoutShapelessRecipe shapelessrecipe;
    private String rowletter;
    
    private void checkItem(String type, org.getspout.spoutapi.material.Material item, MyConfiguration config){
        int recipeNumber = 0;
        while(config.contains("Custom " + type + "." + item.getName() + ".shaped recipe" + recipeNumber)){
            String[][] prerecipe = new String[3][3];
            String[][] recipeShape = new String[3][3];
            SpoutShapedRecipe recipe;
            
            final int amount = config.getInt("Custom " + type + "." + item.getName() + ".shaped recipe" + recipeNumber + ".amount");
            final List<?> list = config.getList("Custom " + type + "." + item.getName() + ".shaped recipe" + recipeNumber + ".ingredients");
            final Iterator<?> keys = list.iterator();
            prerecipe[0] = keys.next().toString().split(",");
            prerecipe[1] = keys.next().toString().split(",");
            prerecipe[2] = keys.next().toString().split(",");
            
            final ItemStack result = new SpoutItemStack(item, amount);
            recipe = new SpoutShapedRecipe(result);
            recipe.shape("ghi", "def", "abc");
            
            char letter = 'a';
            
            for(int x = 0; x < 3; x++){
                for(int y = 0; y < 3; y++){
                    letter++;
                    if(!prerecipe[x][y].equals("-")){
                        try {
                            if (prerecipe[x][y].contains(":")) {
                                String[] data = prerecipe[x][y].split(":");
                                recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(data[0]), Short.parseShort(data[1])));
                            } else {
                                recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(prerecipe[x][y])));
                            }
                        }catch(final NumberFormatException e){
                            int customId = 0;
                            if (RpgeManager.getInstance().getMaterialManager().hasMaterial(prerecipe[x][y])) {
                                final org.getspout.spoutapi.material.Material material = RpgeManager.getInstance().getMaterialManager().getMaterialByName(prerecipe[x][y]);
                                if (material instanceof GenericCustomBlock) {
                                    customId = ((GenericCustomBlock) material).getCustomId();
                                } else {
                                    customId = ((GenericCustomItem) material).getCustomId();
                                }
                            }
                            recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
                        }
                        recipeShape[x][y] = String.valueOf(letter);
                    }else{
                        recipeShape[x][y] = " ";
                    }
                }
            }
            recipe.shape(recipeShape[0][0] + recipeShape[0][1] + recipeShape[0][2], recipeShape[1][0] + recipeShape[1][1] + recipeShape[1][2], recipeShape[2][0] + recipeShape[2][1] + recipeShape[2][2]);
            SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
            System.out.println("Added shaped recipe " + recipeNumber + " for: " + item.getName());
            recipeNumber++;
        }
        
        recipeNumber = 0;
        while (config.contains("Custom " + type + "." + item.getName() + ".furnace recipe" + recipeNumber)) {
            final int amount = config.getInt("Custom " + type + "." + item.getName() + ".furnace recipe" + recipeNumber + ".amount");
            final String ingredientRaw = config.getString("Custom " + type + "." + item.getName() + ".furnace recipe" + recipeNumber + ".ingredient");
            int customId = 0;
            final ItemStack result = new SpoutItemStack(item, amount);
            try {
                final Material ingredient = Material.getMaterial(Integer.parseInt(ingredientRaw));
                FurnaceRecipes.NewFurnaceRecipe(result, ingredient);
            } catch (final NumberFormatException e) {
                if (RpgeManager.getInstance().getMaterialManager().hasMaterial(ingredientRaw)) {
                    final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(ingredientRaw);
                    if (smaterial instanceof GenericCustomBlock) {
                        customId = ((GenericCustomBlock) smaterial).getCustomId();
                        final Material material = Material.getMaterial(((GenericCustomBlock) smaterial).getBlockId());
                        FurnaceRecipes.CustomFurnaceRecipe(result, material, (short) customId);
                    } else {
                        customId = ((GenericCustomItem) smaterial).getCustomId();
                        FurnaceRecipes.CustomFurnaceRecipe(result, Material.FLINT, (short) customId);
                    }
                }
            }
            System.out.println("Added furnace recipe " + recipeNumber + " for: " + item.getName());
            recipeNumber++;
        }
        
        recipeNumber = 0;
        while(config.contains("Custom " + type + "." + item.getName() + ".shapeless recipe" + recipeNumber)) {
            final int amount = config.getInt("Custom " + type + "." + item.getName() + ".shapeless recipe" + recipeNumber + ".amount");
            final List<?> list = config.getList("Custom " + type + "." + item.getName() + ".shapeless recipe" + recipeNumber + ".ingredients");
            final Iterator<?> keys = list.iterator();
            while (keys.hasNext()) {
                final String ingredientraw = keys.next().toString();
                int customId = 0;
                final ItemStack result = new SpoutItemStack(item, amount);
                shapelessrecipe = new SpoutShapelessRecipe(result);
                try {
                    final int ingredient = Integer.parseInt(ingredientraw);
                    shapelessrecipe.addIngredient(MaterialData.getMaterial(ingredient));
                } catch (final NumberFormatException e) {
                    if (RpgeManager.getInstance().getMaterialManager().hasMaterial(ingredientraw)) {
                        final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(ingredientraw);
                        if (smaterial instanceof GenericCustomBlock) {
                            customId = ((GenericCustomBlock) smaterial).getCustomId();
                        } else {
                            customId = ((GenericCustomItem) smaterial).getCustomId();
                        }
                    }
                    shapelessrecipe.addIngredient(MaterialData.getCustomItem(customId));
                }
            }
            SpoutManager.getMaterialManager().registerSpoutRecipe(shapelessrecipe);
            System.out.println("Added shapless recipe " + recipeNumber + " for: " + item.getName());
            recipeNumber++;
        }
    }
    
    @SuppressWarnings ("deprecation")
    private void checkitem(String type, org.getspout.spoutapi.material.Material item, MyConfiguration config) {
        for (int rpc = 1; rpc < 10; rpc++) {
            if (config.contains("Custom " + type + "." + item.getName() + ".shaped recipe" + rpc)) {
                final int amount = config.getInt("Custom " + type + "." + item.getName() + ".shaped recipe" + rpc + ".amount");
                final List<?> list = config.getList("Custom " + type + "." + item.getName() + ".shaped recipe" + rpc + ".ingredients");
                final Iterator<?> keys = list.iterator();
                final String[] row1 = keys.next().toString().split(",");
                final String[] row2 = keys.next().toString().split(",");
                final String[] row3 = keys.next().toString().split(",");
                String srow1 = "";
                String srow2 = "";
                String srow3 = "";

                final ItemStack result = new SpoutItemStack(item, amount);
                recipe = new SpoutShapedRecipe(result);
                recipe.shape("ghi", "def", "abc");

                char letter = 0;
                
                for (int count = 0; count < 3; count++) {
                    if (row1[count].contains(":")) {
                        if (count == 0) {
                            row1dv1 = row1[count].split(":");
                        } else if (count == 1) {
                            row1dv2 = row1[count].split(":");
                        } else if (count == 2) {
                            row1dv3 = row1[count].split(":");
                        }
                    }
                    if (row2[count].contains(":")) {
                        if (count == 0) {
                            row2dv1 = row2[count].split(":");
                        } else if (count == 1) {
                            row2dv2 = row2[count].split(":");
                        } else if (count == 2) {
                            row2dv3 = row2[count].split(":");
                        }
                    }
                    if (row3[count].contains(":")) {
                        if (count == 0) {
                            row3dv1 = row3[count].split(":");
                        } else if (count == 1) {
                            row3dv2 = row3[count].split(":");
                        } else if (count == 2) {
                            row3dv3 = row3[count].split(":");
                        }
                    }
                }

                for (int rowi = 0; rowi < 3; ++rowi) {
                    if (rowi == 0) {
                        for (i = 0; i < 3;) {
                            if (i == 0) {
                                letter = 'a';
                                rowletter = "a";
                            } else if (i == 1) {
                                letter = 'b';
                                rowletter = "b";
                            } else if (i == 2) {
                                letter = 'c';
                                rowletter = "c";
                            }
                            if (!row1[i].equals("-")) {
                                try {
                                    if (i == 0) {
                                        if (row1dv1 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1dv1[0]), Short.parseShort(row1dv1[1])));
                                            srow1 = srow1 + rowletter;
                                            row1dv1 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
                                            srow1 = srow1 + rowletter;
                                        }
                                    } else if (i == 1) {
                                        if (row1dv2 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1dv2[0]), Short.parseShort(row1dv2[1])));
                                            srow1 = srow1 + rowletter;
                                            row1dv2 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
                                            srow1 = srow1 + rowletter;
                                        }
                                    } else {
                                        if (row1dv3 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1dv3[0]), Short.parseShort(row1dv3[1])));
                                            srow1 = srow1 + rowletter;
                                            row1dv3 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
                                            srow1 = srow1 + rowletter;
                                        }
                                    }
                                } catch (final NumberFormatException e) {
                                    int customId = 0;
                                    if (RpgeManager.getInstance().getMaterialManager().hasMaterial(row1[i])) {
                                        final org.getspout.spoutapi.material.Material material = RpgeManager.getInstance().getMaterialManager().getMaterialByName(row1[i]);
                                        if (material instanceof GenericCustomBlock) {
                                            customId = ((GenericCustomBlock) material).getCustomId();
                                        } else {
                                            customId = ((GenericCustomItem) material).getCustomId();
                                        }
                                        srow1 = srow1 + rowletter;
                                    }
                                    recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
                                }
                            } else {
                                srow1 = srow1 + " ";
                            }
                            ++i;
                        }
                    } else if (rowi == 1) {
                        for (int i = 0; i < 3;) {
                            if (i == 0) {
                                letter = 'd';
                                rowletter = "d";
                            } else if (i == 1) {
                                letter = 'e';
                                rowletter = "e";
                            } else if (i == 2) {
                                letter = 'f';
                                rowletter = "f";
                            }
                            if (!row2[i].equals("-")) {
                                try {
                                    if (i == 0) {
                                        if (row2dv1 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2dv1[0]), Short.parseShort(row2dv1[1])));
                                            srow2 = srow2 + rowletter;
                                            row2dv1 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
                                            srow2 = srow2 + rowletter;
                                        }
                                    } else if (i == 1) {
                                        if (row2dv2 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2dv2[0]), Short.parseShort(row2dv2[1])));
                                            srow2 = srow2 + rowletter;
                                            row2dv2 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
                                            srow2 = srow2 + rowletter;
                                        }
                                    } else {
                                        if (row2dv3 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2dv3[0]), Short.parseShort(row2dv3[1])));
                                            srow2 = srow2 + rowletter;
                                            row2dv3 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
                                            srow2 = srow2 + rowletter;
                                        }
                                    }
                                } catch (final NumberFormatException e) {
                                    int customId = 0;

                                    if (RpgeManager.getInstance().getMaterialManager().hasMaterial(row2[i])) {
                                        final org.getspout.spoutapi.material.Material material = RpgeManager.getInstance().getMaterialManager().getMaterialByName(row2[i]);
                                        if (material instanceof GenericCustomBlock) {
                                            customId = ((GenericCustomBlock) material).getCustomId();
                                        } else {
                                            customId = ((GenericCustomItem) material).getCustomId();
                                        }
                                        srow2 = srow2 + rowletter;
                                    }
                                    recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
                                }
                            } else {
                                srow2 = srow2 + " ";
                            }
                            ++i;
                        }
                    } else if (rowi == 2) {
                        for (int i = 0; i < 3;) {
                            if (i == 0) {
                                letter = 'g';
                                rowletter = "g";
                            } else if (i == 1) {
                                letter = 'h';
                                rowletter = "h";
                            } else if (i == 2) {
                                letter = 'i';
                                rowletter = "i";
                            }
                            if (!row3[i].equals("-")) {
                                try {
                                    if (i == 0) {
                                        if (row3dv1 != null) {
                                            recipe.setIngredient(
                                                    letter,
                                                    MaterialData.getMaterial(Integer.parseInt(row3dv1[0]), Short.parseShort(row3dv1[1])));
                                            srow3 = srow3 + rowletter;
                                            row3dv1 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
                                            srow3 = srow3 + rowletter;
                                        }
                                    } else if (i == 1) {
                                        if (row3dv2 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3dv2[0]), Short.parseShort(row3dv2[1])));
                                            srow3 = srow3 + rowletter;
                                            row3dv2 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
                                            srow3 = srow3 + rowletter;
                                        }
                                    } else {
                                        if (row3dv3 != null) {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3dv3[0]), Short.parseShort(row3dv3[1])));
                                            srow3 = srow3 + rowletter;
                                            row3dv3 = null;
                                        } else {
                                            recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
                                            srow3 = srow3 + rowletter;
                                        }
                                    }
                                } catch (final NumberFormatException e) {
                                    int customId = 0;

                                    if (RpgeManager.getInstance().getMaterialManager().hasMaterial(row3[i])) {
                                        final org.getspout.spoutapi.material.Material material = RpgeManager.getInstance().getMaterialManager().getMaterialByName(row3[i]);
                                        if (material instanceof GenericCustomBlock) {
                                            customId = ((GenericCustomBlock) material).getCustomId();
                                        } else if (material instanceof GenericCustomItem) {
                                            customId = ((GenericCustomItem) material).getCustomId();
                                        }
                                        srow3 = srow3 + rowletter;
                                    }
                                    recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
                                }
                            } else {
                                srow3 = srow3 + " ";
                            }
                            ++i;
                        }
                    }
                }
                recipe.shape(srow1, srow2, srow3);
                SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
                System.out.println("Added shaped recipe " + rpc + " for: " + item.getName());
            }
            if (config.contains("Custom " + type + "." + item.getName() + ".furnace recipe" + rpc)) {
                final int amount = config.getInt("Custom " + type + "." + item.getName() + ".furnace recipe" + rpc + ".amount");
                final String ingredientraw = config.getString("Custom " + type + "." + item.getName() + ".furnace recipe" + rpc + ".ingredient");
                int customId = 0;
                final ItemStack result = new SpoutItemStack(item, amount);
                try {
                    final Material ingredient = Material.getMaterial(Integer.parseInt(ingredientraw));
                    FurnaceRecipes.NewFurnaceRecipe(result, ingredient);
                } catch (final NumberFormatException e) {
                    if (RpgeManager.getInstance().getMaterialManager().hasMaterial(ingredientraw)) {
                        final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(ingredientraw);
                        if (smaterial instanceof GenericCustomBlock) {
                            customId = ((GenericCustomBlock) smaterial).getCustomId();
                            final Material material = Material.getMaterial(((GenericCustomBlock) smaterial).getBlockId());
                            FurnaceRecipes.CustomFurnaceRecipe(result, material, (short) customId);
                        } else {
                            customId = ((GenericCustomItem) smaterial).getCustomId();
                            FurnaceRecipes.CustomFurnaceRecipe(result, Material.FLINT, (short) customId);
                        }
                    }
                }
                System.out.println("Added furnace recipe " + rpc + " for: " + item.getName());
            }

            if (config.contains("Custom " + type + "." + item.getName() + ".shapeless recipe" + rpc)) {
                final int amount = config.getInt("Custom " + type + "." + item.getName() + ".shapeless recipe" + rpc + ".amount");
                final List<?> list = config.getList("Custom " + type + "." + item.getName() + ".shapeless recipe" + rpc + ".ingredients");
                final Iterator<?> keys = list.iterator();
                while (keys.hasNext()) {
                    final String ingredientraw = keys.next().toString();
                    int customId = 0;
                    final ItemStack result = new SpoutItemStack(item, amount);
                    shapelessrecipe = new SpoutShapelessRecipe(result);
                    try {
                        final int ingredient = Integer.parseInt(ingredientraw);
                        shapelessrecipe.addIngredient(MaterialData.getMaterial(ingredient));
                    } catch (final NumberFormatException e) {
                        if (RpgeManager.getInstance().getMaterialManager().hasMaterial(ingredientraw)) {
                            final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(ingredientraw);
                            if (smaterial instanceof GenericCustomBlock) {
                                customId = ((GenericCustomBlock) smaterial).getCustomId();
                            } else {
                                customId = ((GenericCustomItem) smaterial).getCustomId();
                            }
                        }
                        shapelessrecipe.addIngredient(MaterialData.getCustomItem(customId));
                    }
                }
                SpoutManager.getMaterialManager().registerSpoutRecipe(shapelessrecipe);
                System.out.println("Added shapless recipe " + rpc + " for: " + item.getName());
            }
        }
    }

    private void addChainmailRecipe() {
        final int customId = RpgeManager.getInstance().getMaterialManager().getItemByName("Chain").getCustomId();

        // helmet
        final ItemStack result = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        recipe = new SpoutShapedRecipe(result);
        recipe.shape("ghi", "d f", "   ");
        recipe.setIngredient('g', MaterialData.getCustomItem(customId));
        recipe.setIngredient('h', MaterialData.getCustomItem(customId));
        recipe.setIngredient('i', MaterialData.getCustomItem(customId));
        recipe.setIngredient('d', MaterialData.getCustomItem(customId));
        recipe.setIngredient('f', MaterialData.getCustomItem(customId));
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);

        // chestplate
        final ItemStack result2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        recipe = new SpoutShapedRecipe(result2);
        recipe.shape("g i", "def", "abc");
        recipe.setIngredient('a', MaterialData.getCustomItem(customId));
        recipe.setIngredient('b', MaterialData.getCustomItem(customId));
        recipe.setIngredient('c', MaterialData.getCustomItem(customId));
        recipe.setIngredient('d', MaterialData.getCustomItem(customId));
        recipe.setIngredient('e', MaterialData.getCustomItem(customId));
        recipe.setIngredient('f', MaterialData.getCustomItem(customId));
        recipe.setIngredient('g', MaterialData.getCustomItem(customId));
        recipe.setIngredient('i', MaterialData.getCustomItem(customId));
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);

        // leggings
        final ItemStack result3 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        recipe = new SpoutShapedRecipe(result3);
        recipe.shape("ghi", "d f", "a c");
        recipe.setIngredient('a', MaterialData.getCustomItem(customId));
        recipe.setIngredient('c', MaterialData.getCustomItem(customId));
        recipe.setIngredient('d', MaterialData.getCustomItem(customId));
        recipe.setIngredient('f', MaterialData.getCustomItem(customId));
        recipe.setIngredient('g', MaterialData.getCustomItem(customId));
        recipe.setIngredient('h', MaterialData.getCustomItem(customId));
        recipe.setIngredient('i', MaterialData.getCustomItem(customId));
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);

        // boots
        final ItemStack result4 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        recipe = new SpoutShapedRecipe(result4);
        recipe.shape("   ", "d f", "a c");
        recipe.setIngredient('d', MaterialData.getCustomItem(customId));
        recipe.setIngredient('f', MaterialData.getCustomItem(customId));
        recipe.setIngredient('a', MaterialData.getCustomItem(customId));
        recipe.setIngredient('c', MaterialData.getCustomItem(customId));
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
    }
}
