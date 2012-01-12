package me.duckdoom5.RpgEssentials.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.Material;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.items.CustomItems;
import me.duckdoom5.RpgEssentials.items.tools.CustomTools;
import me.duckdoom5.RpgEssentials.blocks.misc.MicrowaveBlock;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOres;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;
import me.duckdoom5.RpgEssentials.blocks.ores.OriginalOresDesign;
import me.duckdoom5.RpgEssentials.blocks.plants.CustomBush;
import me.duckdoom5.RpgEssentials.blocks.plants.PlantPot;
import me.duckdoom5.RpgEssentials.blocks.stairs.CustomStair;
import me.duckdoom5.RpgEssentials.blocks.stairs.CustomStairEdge;

public class Hashmaps {
	static YamlConfiguration blockconfig = new YamlConfiguration();
	static YamlConfiguration itemconfig = new YamlConfiguration();
	public static Set<CustomOresDesign> customores = new LinkedHashSet<CustomOresDesign>();
	public static HashMap<String, CustomOresDesign> customoresmap = new LinkedHashMap<String, CustomOresDesign>();
	public static Set<GenericCustomItem> customitems = new LinkedHashSet<GenericCustomItem>();
	public static HashMap<String, GenericCustomItem> customitemsmap = new LinkedHashMap<String, GenericCustomItem>();
	public static Set<GenericCustomTool> customtools = new LinkedHashSet<GenericCustomTool>();
	public static HashMap<String, GenericCustomTool> customtoolsmap = new LinkedHashMap<String, GenericCustomTool>();
	public static Set<OriginalOresDesign> originalores = new LinkedHashSet<OriginalOresDesign>();
	public static Set<GenericCubeCustomBlock> bushes = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> stairs = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> plants = new LinkedHashSet<GenericCubeCustomBlock>();
	public static Set<GenericCubeCustomBlock> misc = new LinkedHashSet<GenericCubeCustomBlock>();
	
	public static void CustomOres(RpgEssentials plugin){
		ConfigurationSection section = blockconfig.getConfigurationSection("Custom Ores");
		Iterator keys = section.getKeys(false).iterator();
		for(int i = 0; keys.hasNext(); ++i){
			String name = (String)keys.next();
			int textureID = blockconfig.getInt("Custom Ores." + name + ".textureID");
			int freq = blockconfig.getInt("Custom Ores." + name + ".frequency");
			int minY = blockconfig.getInt("Custom Ores." + name + ".minheight");
			int maxY = blockconfig.getInt("Custom Ores." + name + ".maxheight");
			float hard = blockconfig.getInt("Custom Ores." + name + ".hardness");
			int light = blockconfig.getInt("Custom Ores." + name + ".lightlevel");
			float friction = blockconfig.getInt("Custom Ores." + name + ".friction");
			addOre(plugin, name, textureID, freq, minY, maxY,hard,light,friction);
		}
	}
	
	public static void CustomItems(RpgEssentials plugin){
		ConfigurationSection section = itemconfig.getConfigurationSection("Custom Items");
		Iterator keys = section.getKeys(false).iterator();
		for(int i = 0; keys.hasNext(); ++i){
			String name = (String)keys.next();
			String textureurl = itemconfig.getString("Custom Items." + name + ".texture url");
			addItem(plugin, name, textureurl);
		}
		ConfigurationSection section2 = itemconfig.getConfigurationSection("Custom Tools");
		Iterator keys2 = section2.getKeys(false).iterator();
		for(int i = 0; keys2.hasNext(); ++i){
			String name = (String)keys2.next();
			String textureurl = itemconfig.getString("Custom Tools." + name + ".texture url");
			int durability = itemconfig.getInt("Custom Tools." + name + ".durability");
			addTool(plugin, name, textureurl, durability);
		}
	}
	
	private static void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY, float hard, int light, float friction) {
		customores.add(new CustomOres(plugin, name, textureID, freq, minY, maxY, hard, light, friction));
		customoresmap.put(name, new CustomOres(plugin, name, textureID, freq, minY, maxY, hard, light, friction));
	}
	private static void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY) {
		customores.add(new CustomOres(plugin, name, textureID, freq, minY, maxY));
		customoresmap.put(name, new CustomOres(plugin, name, textureID, freq, minY, maxY));
	}

	private static void addItem(RpgEssentials plugin, String name, String textureurl) {
		customitems.add(new CustomItems(plugin, name, textureurl));
		customitemsmap.put(name, new CustomItems(plugin, name, textureurl));
	}
	
	private static void addTool(RpgEssentials plugin, String name, String textureurl, int durability) {
		customtools.add(new CustomTools(plugin, name, textureurl, (short) durability));
		customtoolsmap.put(name, new CustomTools(plugin, name, textureurl, (short) durability));
	}

	public static void registerBlocks(RpgEssentials plugin) {
		try {
			blockconfig.load("plugins/RpgEssentials/blocks.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//orginal ores
		OriginalOresDesign CoalOre = new OriginalOresDesign(plugin, Material.COAL_ORE, blockconfig.getInt("Original Ores.Coal Ore.frequency"), blockconfig.getInt("Original Ores.Coal Ore.minheight"), blockconfig.getInt("Original Ores.Coal Ore.maxheight"));
		OriginalOresDesign IronOre = new OriginalOresDesign(plugin, Material.IRON_ORE, blockconfig.getInt("Original Ores.Iron Ore.frequency"), blockconfig.getInt("Original Ores.Iron Ore.minheight"), blockconfig.getInt("Original Ores.Iron Ore.maxheight"));
		OriginalOresDesign LapisOre = new OriginalOresDesign(plugin, Material.LAPIS_ORE, blockconfig.getInt("Original Ores.Lapis Ore.frequency"), blockconfig.getInt("Original Ores.Lapis Ore.minheight"), blockconfig.getInt("Original Ores.Lapis Ore.maxheight"));
		OriginalOresDesign GoldOre = new OriginalOresDesign(plugin, Material.GOLD_ORE, blockconfig.getInt("Original Ores.Gold Ore.frequency"), blockconfig.getInt("Original Ores.Gold Ore.minheight"), blockconfig.getInt("Original Ores.Gold Ore.maxheight"));
		OriginalOresDesign RedstoneOre = new OriginalOresDesign(plugin, Material.REDSTONE_ORE, blockconfig.getInt("Original Ores.Redstone Ore.frequency"), blockconfig.getInt("Original Ores.Redstone Ore.minheight"), blockconfig.getInt("Original Ores.Redstone Ore.maxheight"));
		OriginalOresDesign DiamondOre = new OriginalOresDesign(plugin, Material.DIAMOND_ORE, blockconfig.getInt("Original Ores.Diamond Ore.frequency"), blockconfig.getInt("Original Ores.Diamond Ore.minheight"), blockconfig.getInt("Original Ores.Diamond Ore.maxheight"));
		originalores.add(CoalOre);
		originalores.add(IronOre);
		originalores.add(LapisOre);
		originalores.add(GoldOre);
		originalores.add(RedstoneOre);
		originalores.add(DiamondOre);
		
		CustomItems(plugin);
		CustomOres(plugin);
		Recipes.addItemShapedRecipe(plugin);
		Recipes.addBlockShapedRecipe(plugin);
		Recipes.addToolShapedRecipe(plugin);
		
		MicrowaveBlock microwaveblock = new MicrowaveBlock(plugin);
		misc.add(microwaveblock);
		
		int [] textureids = {0,0,0,0,0,0};
		int [] plantpotids = {1,2,0,0,0,0};
		CustomBush bush = new CustomBush(plugin,textureids,50);
		bushes.add(bush);
		
		CustomStair stair = new CustomStair(plugin);
		stairs.add(stair);
		
		CustomStairEdge stairedge = new CustomStairEdge(plugin);
		stairs.add(stairedge);
		
		PlantPot plantpot = new PlantPot(plugin, plantpotids);
		plants.add(plantpot);
	}
}
