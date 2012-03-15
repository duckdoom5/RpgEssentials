package me.duckdoom5.RpgEssentials.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class FurnaceRecipes {
	
	public static void NewFurnaceRecipe(ItemStack result, int ingredient){
		
		FurnaceRecipe fr = new FurnaceRecipe(result, (new MaterialData(ingredient)));
		
		Bukkit.getServer().addRecipe(fr);

	}

	public static void CustomFurnaceRecipe(ItemStack result, Material material, int i) {
		System.out.println("test");
		FurnaceRecipe fr = new FurnaceRecipe(result, material, i);
		
		Bukkit.getServer().addRecipe(fr);
		
	}
}
