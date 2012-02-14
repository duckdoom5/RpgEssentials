package me.duckdoom5.RpgEssentials.util;

import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;

public class FurnaceRecipes {
	
	public static void NewFurnaceRecipe(ItemStack result, int ingredient){
		
		FurnaceRecipe fr = new FurnaceRecipe(result, (new MaterialData(ingredient)));
		
		Bukkit.getServer().addRecipe(fr);

	}

	public static void CustomOreFurnaceRecipe(ItemStack result, Material stone, CustomOresDesign test1) {
		
		int durability = test1.getCustomId();
		
		MaterialData customblock = new MaterialData(stone, (byte) durability);
		
		FurnaceRecipe fr = new FurnaceRecipe(result, customblock);
		
		Bukkit.getServer().addRecipe(fr);
		
	}

	public static void CustomItemFurnaceRecipe(ItemStack result, Material flint, GenericCustomItem test2) {
		// TODO Auto-generated method stub
		
	}

	public static void CustomToolFurnaceRecipe(ItemStack result, Material flint, GenericCustomTool test3) {
		// TODO Auto-generated method stub
		
	}
}
