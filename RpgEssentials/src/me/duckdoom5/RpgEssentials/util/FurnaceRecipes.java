package me.duckdoom5.RpgEssentials.util;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class FurnaceRecipes {

    public static HashMap<Short, ItemStack> customrecipes = new LinkedHashMap<>();

    public static void NewFurnaceRecipe(ItemStack result, Material ingredient) {
        final FurnaceRecipe fr = new FurnaceRecipe(result, ingredient);
        Bukkit.getServer().addRecipe(fr);
    }

    public static void CustomFurnaceRecipe(ItemStack result, Material material, short i) {
        customrecipes.put(i, result);
        final FurnaceRecipe fr = new FurnaceRecipe(result, new MaterialData(material, (byte) i));
        Bukkit.getServer().addRecipe(fr);
    }
}
