package me.duckdoom5.RpgEssentials.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.Material;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.bukkit.configuration.ConfigurationSection;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.items.CustomItems;
import me.duckdoom5.RpgEssentials.items.food.CustomFood;
import me.duckdoom5.RpgEssentials.items.tools.CustomTools;
import me.duckdoom5.RpgEssentials.blocks.block.CustomBlockDesign;
import me.duckdoom5.RpgEssentials.blocks.block.CustomBlocks;
import me.duckdoom5.RpgEssentials.blocks.misc.AnvilBlock;
import me.duckdoom5.RpgEssentials.blocks.misc.CheckoutBlockE;
import me.duckdoom5.RpgEssentials.blocks.misc.CheckoutBlockN;
import me.duckdoom5.RpgEssentials.blocks.misc.CheckoutBlockS;
import me.duckdoom5.RpgEssentials.blocks.misc.CheckoutBlockW;
import me.duckdoom5.RpgEssentials.blocks.misc.SafeBlock;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOres;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.blocks.ores.OriginalOresDesign;
import me.duckdoom5.RpgEssentials.blocks.plants.CustomBush;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class Hashmaps {
	
	public static Set<CustomOresDesign> customores = new LinkedHashSet<CustomOresDesign>();
	public static HashMap<String, CustomOresDesign> customoresmap = new LinkedHashMap<String, CustomOresDesign>();
	
	public static Set<CustomBlockDesign> customblocks = new LinkedHashSet<CustomBlockDesign>();
	public static HashMap<String, CustomBlockDesign> customblocksmap = new LinkedHashMap<String, CustomBlockDesign>();
	
	public static Set<GenericCustomItem> customitems = new LinkedHashSet<GenericCustomItem>();
	public static HashMap<String, GenericCustomItem> customitemsmap = new LinkedHashMap<String, GenericCustomItem>();
	
	public static Set<GenericCustomTool> customtools = new LinkedHashSet<GenericCustomTool>();
	public static HashMap<String, GenericCustomTool> customtoolsmap = new LinkedHashMap<String, GenericCustomTool>();
	
	public static HashMap<String, GenericCustomFood> customfoodmap = new LinkedHashMap<String, GenericCustomFood>();
	
	public static Set<OriginalOresDesign> originalores = new LinkedHashSet<OriginalOresDesign>();
	public static Set<GenericCubeCustomBlock> bushes = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> stairs = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> plants = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> misc = new LinkedHashSet<GenericCubeCustomBlock>();
	public static HashMap<String, GenericCubeCustomBlock> checkoutmap = new LinkedHashMap<String, GenericCubeCustomBlock>();
	public static HashMap<String, GenericCubeCustomBlock> safemap = new LinkedHashMap<String, GenericCubeCustomBlock>();
	
	public static void CustomOres(RpgEssentials plugin){
		ConfigurationSection section = Configuration.block.getConfigurationSection("Custom Ores");
		Iterator keys = section.getKeys(false).iterator();
		for(int i = 0; keys.hasNext(); ++i){
			String name = (String)keys.next();
			int textureID = Configuration.block.getInt("Custom Ores." + name + ".textureID");
			int freq = Configuration.block.getInt("Custom Ores." + name + ".frequency");
			int minY = Configuration.block.getInt("Custom Ores." + name + ".minheight");
			int maxY = Configuration.block.getInt("Custom Ores." + name + ".maxheight");
			float hard = Configuration.block.getInt("Custom Ores." + name + ".hardness");
			int light = Configuration.block.getInt("Custom Ores." + name + ".lightlevel");
			float friction = Configuration.block.getInt("Custom Ores." + name + ".friction");
			addOre(plugin, name, textureID, freq, minY, maxY, hard, light, friction);
		}
	}
	public static void CustomBlock(RpgEssentials plugin){
		ConfigurationSection section = Configuration.block.getConfigurationSection("Custom Blocks");
		Iterator keys = section.getKeys(false).iterator();
		for(int i = 0; keys.hasNext(); ++i){
			String name = (String)keys.next();
			int textureID = Configuration.block.getInt("Custom Blocks." + name + ".textureID");
			float hard = Configuration.block.getInt("Custom Blocks." + name + ".hardness");
			int light = Configuration.block.getInt("Custom Blocks." + name + ".lightlevel");
			float friction = Configuration.block.getInt("Custom Blocks." + name + ".friction");
			addblock(plugin, name, textureID, hard, light, friction);
		}
	}
	
	public static void CustomItems(RpgEssentials plugin){
		ConfigurationSection section = Configuration.items.getConfigurationSection("Custom Items");
		Iterator keys = section.getKeys(false).iterator();
		for(int i = 0; keys.hasNext(); ++i){
			String name = (String)keys.next();
			String textureurl = Configuration.items.getString("Custom Items." + name + ".texture url");
			addItem(plugin, name, textureurl);
		}
		ConfigurationSection section2 = Configuration.items.getConfigurationSection("Custom Tools");
		Iterator keys2 = section2.getKeys(false).iterator();
		for(int i = 0; keys2.hasNext(); ++i){
			String name = (String)keys2.next();
			String textureurl = Configuration.items.getString("Custom Tools." + name + ".texture url");
			int durability = Configuration.items.getInt("Custom Tools." + name + ".durability");
			addTool(plugin, name, textureurl, durability);
		}
		ConfigurationSection section3 = Configuration.items.getConfigurationSection("Custom Food");
		Iterator keys3 = section3.getKeys(false).iterator();
		for(int i = 0; keys3.hasNext(); ++i){
			String name = (String)keys3.next();
			String textureurl = Configuration.items.getString("Custom Food." + name + ".texture url");
			int restore = Configuration.items.getInt("Custom Food." + name + ".restore");
			addFood(plugin, name, textureurl, restore);
		}
	}
	
	private static void addblock(RpgEssentials plugin, String name, int textureID, float hard, int light, float friction) {
		CustomBlocks block = new CustomBlocks(plugin, name, textureID, hard, light, friction);
		customblocks.add(block);
		customblocksmap.put(name, block);
		
	}
	private static void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY, float hard, int light, float friction) {
		CustomOres ore = new CustomOres(plugin, name, textureID, freq, minY, maxY, hard, light, friction);
		customores.add(ore);
		customoresmap.put(name, ore);
	}
	private static void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY) {
		CustomOres ore = new CustomOres(plugin, name, textureID, freq, minY, maxY);
		customores.add(ore);
		customoresmap.put(name, ore);
	}

	private static void addItem(RpgEssentials plugin, String name, String textureurl) {
		CustomItems item = new CustomItems(plugin, name, textureurl);
		customitems.add(item);
		customitemsmap.put(name, item);
	}
	
	private static void addFood(RpgEssentials plugin, String name, String textureurl, int restore) {
		CustomFood food = new CustomFood(plugin, name, textureurl, restore);
		customfoodmap.put(name, food);
	}
	
	private static void addTool(RpgEssentials plugin, String name, String textureurl, int durability) {
		CustomTools tool = new CustomTools(plugin, name, textureurl, (short) durability);
		customtools.add(tool);
		customtoolsmap.put(name, tool);
	}

	public static void registerBlocks(RpgEssentials plugin) {
		
		//orginal ores
		OriginalOresDesign CoalOre = new OriginalOresDesign(plugin, Material.COAL_ORE, Configuration.block.getInt("Original Ores.Coal Ore.frequency"), Configuration.block.getInt("Original Ores.Coal Ore.minheight"), Configuration.block.getInt("Original Ores.Coal Ore.maxheight"));
		OriginalOresDesign IronOre = new OriginalOresDesign(plugin, Material.IRON_ORE, Configuration.block.getInt("Original Ores.Iron Ore.frequency"), Configuration.block.getInt("Original Ores.Iron Ore.minheight"), Configuration.block.getInt("Original Ores.Iron Ore.maxheight"));
		OriginalOresDesign LapisOre = new OriginalOresDesign(plugin, Material.LAPIS_ORE, Configuration.block.getInt("Original Ores.Lapis Ore.frequency"), Configuration.block.getInt("Original Ores.Lapis Ore.minheight"), Configuration.block.getInt("Original Ores.Lapis Ore.maxheight"));
		OriginalOresDesign GoldOre = new OriginalOresDesign(plugin, Material.GOLD_ORE, Configuration.block.getInt("Original Ores.Gold Ore.frequency"), Configuration.block.getInt("Original Ores.Gold Ore.minheight"), Configuration.block.getInt("Original Ores.Gold Ore.maxheight"));
		OriginalOresDesign RedstoneOre = new OriginalOresDesign(plugin, Material.REDSTONE_ORE, Configuration.block.getInt("Original Ores.Redstone Ore.frequency"), Configuration.block.getInt("Original Ores.Redstone Ore.minheight"), Configuration.block.getInt("Original Ores.Redstone Ore.maxheight"));
		OriginalOresDesign DiamondOre = new OriginalOresDesign(plugin, Material.DIAMOND_ORE, Configuration.block.getInt("Original Ores.Diamond Ore.frequency"), Configuration.block.getInt("Original Ores.Diamond Ore.minheight"), Configuration.block.getInt("Original Ores.Diamond Ore.maxheight"));
		originalores.add(CoalOre);
		originalores.add(IronOre);
		originalores.add(LapisOre);
		originalores.add(GoldOre);
		originalores.add(RedstoneOre);
		originalores.add(DiamondOre);
		
		CustomItems(plugin);
		CustomBlock(plugin);
		CustomOres(plugin);
		Recipes.addItemShapedRecipe(plugin);
		Recipes.addBlockShapedRecipe(plugin);
		Recipes.addToolShapedRecipe(plugin);
		
		//MicrowaveBlock microwaveblock = new MicrowaveBlock(plugin);
		//misc.add(microwaveblock);
		
		int[] id1 = {6,5,6,6,6,6};
		SafeBlock safeblockN = new SafeBlock(plugin, "Safe(N)", id1);
		safemap.put("North", safeblockN);
		int[] id2 = {6,6,5,6,6,6};
		SafeBlock safeblockE = new SafeBlock(plugin, "Safe(E)", id2);
		safemap.put("East", safeblockN);
		int[] id3 = {6,6,6,5,6,6};
		SafeBlock safeblockS = new SafeBlock(plugin, "Safe(S)", id3);
		safemap.put("South", safeblockN);
		int[] id4 = {6,6,6,6,5,6};
		SafeBlock safeblockW = new SafeBlock(plugin, "Safe(W)", id4);
		safemap.put("West", safeblockN);
		
		AnvilBlock anvilblock = new AnvilBlock(plugin);
		misc.add(anvilblock);
		
		CheckoutBlockN checkoutblockN = new CheckoutBlockN(plugin);
		checkoutmap.put("North", checkoutblockN);
		CheckoutBlockE checkoutblockE = new CheckoutBlockE(plugin);
		checkoutmap.put("East", checkoutblockE);
		CheckoutBlockS checkoutblockS = new CheckoutBlockS(plugin);
		checkoutmap.put("South", checkoutblockS);
		CheckoutBlockW checkoutblockW = new CheckoutBlockW(plugin);
		checkoutmap.put("West", checkoutblockW);
		
		int [] plantpotids = {1,2,0,0,0,0};
		CustomBush orangebush = new CustomBush(plugin, "Orange Bush",new int[]{0,0,0,0,0,0},50);
		CustomBush darkgreenbush = new CustomBush(plugin, "Dark Green Bush",new int[]{3,3,3,3,3,3},50);
		CustomBush greenbush = new CustomBush(plugin, "Green Bush",new int[]{4,4,4,4,4,4},50);
		CustomBush lightgreenbush = new CustomBush(plugin, "Light Green Bush",new int[]{5,5,5,5,5,5},50);
		CustomBush greenbush2 = new CustomBush(plugin, "Green Bush",new int[]{6,6,6,6,6,6},50);
		CustomBush darkgreenbush2 = new CustomBush(plugin, "Dark Green Bush",new int[]{7,7,7,7,7,7},50);
		CustomBush darkgreenbush3 = new CustomBush(plugin, "Dark Green Bush",new int[]{8,8,8,8,8,8,},50);
		CustomBush lightgreenbush2 = new CustomBush(plugin, "Light Green Bush",new int[]{9,9,9,9,9,9},50);
		CustomBush greenbush3 = new CustomBush(plugin, "Green Bush",new int[]{10,10,10,10,10,10},50);
		CustomBush pinkbush = new CustomBush(plugin, "Pink Bush",new int[]{11,11,11,11,11,11},50);
		CustomBush withebush = new CustomBush(plugin, "Withe Bush",new int[]{12,12,12,12,12,12},50);
		bushes.add(orangebush);
		bushes.add(darkgreenbush);
		bushes.add(greenbush);
		bushes.add(lightgreenbush);
		bushes.add(greenbush2);
		bushes.add(darkgreenbush2);
		bushes.add(darkgreenbush3);
		bushes.add(lightgreenbush2);
		bushes.add(greenbush3);
		bushes.add(pinkbush);
		bushes.add(withebush);
		
		//CustomStair stair = new CustomStair(plugin);
		//stairs.add(stair);
		
		//CustomStairEdge stairedge = new CustomStairEdge(plugin);
		//stairs.add(stairedge);
		
		//PlantPot plantpot = new PlantPot(plugin, plantpotids);
		//plants.add(plantpot);
	}
}
