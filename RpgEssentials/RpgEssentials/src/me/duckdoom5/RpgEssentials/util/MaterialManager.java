package me.duckdoom5.RpgEssentials.util;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.MyConfiguration;
import me.duckdoom5.RpgEssentials.customblocks.AnvilBlock;
import me.duckdoom5.RpgEssentials.customblocks.CustomBlock;
import me.duckdoom5.RpgEssentials.customblocks.CustomOre;
import me.duckdoom5.RpgEssentials.customblocks.CustomStair;
import me.duckdoom5.RpgEssentials.customblocks.CustomStairEdge;
import me.duckdoom5.RpgEssentials.customblocks.OriginalOre;
import me.duckdoom5.RpgEssentials.customblocks.RegisterBlock;
import me.duckdoom5.RpgEssentials.customblocks.SafeBlock;
import me.duckdoom5.RpgEssentials.items.CustomItems;
import me.duckdoom5.RpgEssentials.items.food.CustomFood;
import me.duckdoom5.RpgEssentials.items.tools.CustomTool;

public class MaterialManager {

	private RpgEssentials plugin;
	
	private HashMap<GenericCustomBlock, BlockType> blocks = new LinkedHashMap<GenericCustomBlock, BlockType>();
	private HashMap<GenericCustomItem, ItemType> items = new LinkedHashMap<GenericCustomItem, ItemType>();
	private HashMap<org.getspout.spoutapi.material.Material, MaterialType> materials = new LinkedHashMap<org.getspout.spoutapi.material.Material, MaterialType>();
	
	public static Set<OriginalOre> originalores = new LinkedHashSet<OriginalOre>();
	
	
	
	public MaterialManager(RpgEssentials plugin){
		this.plugin = plugin;
		registerBlocks();
	}
	
	public Set<GenericCustomItem> getItems(){
		return items.keySet();
	}
	
	public GenericCustomItem getItemByName(String name){
		for(GenericCustomItem item: items.keySet()){
			if(item.getName().equals(name))
				return item;
		}
		return null;
	}
	
	public Set<GenericCustomBlock> getBlocks(){
		return blocks.keySet();
	}
	
	public GenericCustomBlock getBlockByName(String name){
		for(GenericCustomBlock block: blocks.keySet()){
			if(block.getName().equals(name))
				return block;
		}
		return null;
	}
	
	public boolean hasMaterial(org.getspout.spoutapi.material.Material material){
		if(materials.containsKey(material))
			return true;
		
		return false;
	}
	
	public boolean hasMaterial(String name){
		for(org.getspout.spoutapi.material.Material material: materials.keySet()){
			if(material.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public Set<org.getspout.spoutapi.material.Material> getMaterials(){
		return materials.keySet();
	}
	
	public org.getspout.spoutapi.material.Material getMaterialByName(String name){
		for(org.getspout.spoutapi.material.Material material: materials.keySet()){
			if(material.getName().equals(name))
				return material;
		}
		return null;
	}
	
	public Set<GenericCustomBlock> getStairs(){
		Set<GenericCustomBlock> stair = new HashSet<GenericCustomBlock>();
		for(GenericCustomBlock block:blocks.keySet()){
			if(blocks.get(block).equals(BlockType.STAIR)){
				stair.add(block);
			}
		}
		return stair;
	}
	
	
	//BLOCKS
	
	//default

	private void CustomBlock(){
		ConfigurationSection section = Configuration.block.getConfigurationSection("Custom Blocks");
		Iterator<?> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String name = (String)keys.next();
			String textureIds = Configuration.block.getString("Custom Blocks." + name + ".textureIds", "0,0,0,0,0,0");
			float hard = (float) Configuration.block.getDouble("Custom Blocks." + name + ".hardness", 0.0D);
			int light = Configuration.block.getInt("Custom Blocks." + name + ".lightlevel", 0);
			
			float friction = (float) Configuration.block.getDouble("Custom Blocks." + name + ".friction", 0.0D);
			int freq = Configuration.block.getInt("Custom Blocks." + name + ".frequency", 1);
			String design = Configuration.block.getString("Custom Blocks." + name + ".design", "block");
			float brightness = (float)Configuration.block.getDouble("Custom Blocks." + name + ".brightness", 0.0D);
			String textureurl = Configuration.block.getString("Custom Blocks." + name + ".textureurl");
			int texturesize = Configuration.block.getInt("Custom Blocks." + name + ".texturesize", 16);
			int base = Configuration.block.getInt("Custom Blocks." + name + ".base", 1);
			boolean canRotate = Configuration.block.getBoolean("Custom Blocks." + name + ".rotate", false);
			boolean opaque = Configuration.block.getBoolean("Custom Blocks." + name + ".opaque", false);
			
			String[] k = textureIds.split(",");
			int[] ids = new int[k.length];
			
			for(int i = 0; i < k.length; i++){
				ids[i] = Integer.parseInt(k[i]);
			}
			
			if(design.equalsIgnoreCase("block")){
				addblock(plugin, name, ids, opaque, hard, light, friction, base, canRotate);
			}else if(design.equalsIgnoreCase("stair")){
				addStair(plugin, name, ids);
			}else if(design.equalsIgnoreCase("stairedge")){
				addStairEdge(plugin, name, ids);
				
			}else{
				File file = new File("plugins/RpgEssentials/Designs/" + design + ".yml");
				if(file.exists()){
					MyConfiguration config = MyConfiguration.loadConfiguration(file);
					
					GenericBlockDesign blockdesign = addDesign(plugin, config, ids, textureurl, texturesize);
					blockdesign.setBrightness(brightness);
					
					boolean custom = true;
					
					for(BlockType blocktype: BlockType.values()){
						if(blocktype.toString().replace("_", " ").equalsIgnoreCase(design)){
							addblock(plugin, name, ids, hard, light, friction, base, canRotate, blockdesign, BlockType.valueOf(design.toUpperCase().replace(" ", "_")));
							custom = false;
						}
					}
					if(custom){
						addblock(plugin, name, ids, hard, light, friction, base, canRotate, blockdesign, BlockType.CUSTOM);
					}
					
					
				}else{
					RpgEssentials.log.warning("!!! " + name + " has no design. Please use: block/slab/stair/stairedge/bush/flower !!!");
				}
			}
		}
	}
	
	public void addblock(RpgEssentials plugin, String name, int[] ids, boolean opaque, float hard, int light, float friction, int base, boolean canRotate) {
		CustomBlock block = new CustomBlock(plugin, name, ids, opaque, hard, light, friction, base, canRotate);
		blocks.put(block, BlockType.DEFAULT);
		materials.put(block, MaterialType.BLOCK);
	}
	
	public void addblock(RpgEssentials plugin, String name, int[] ids, float hard, int light, float friction, int base, boolean canRotate, GenericBlockDesign design, BlockType type) {
		CustomBlock block = new CustomBlock(plugin, name, ids, hard, light, friction, base, canRotate, design);
		blocks.put(block, type);
		materials.put(block, MaterialType.valueOf(type.toString()));
	}
	
	//ores
	private void CustomOres(){
		ConfigurationSection section = Configuration.block.getConfigurationSection("Custom Ores");
		Iterator<?> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String name = (String)keys.next();
			int textureID = Configuration.block.getInt("Custom Ores." + name + ".textureID");
			int freq = Configuration.block.getInt("Custom Ores." + name + ".frequency");
			int size = Configuration.block.getInt("Custom Ores." + name + ".max vein size");
			int minY = Configuration.block.getInt("Custom Ores." + name + ".min height");
			int maxY = Configuration.block.getInt("Custom Ores." + name + ".max height");
			
			float hard = 0;
			float friction = 0;
			int light = 0;
			int amount = 0;
			int base = 1;
			org.getspout.spoutapi.material.Material drop = null;
			Material mdrop = null;
			
			if(Configuration.block.contains("Custom Ores." + name + ".hardness")){
				hard = (float) Configuration.block.getDouble("Custom Ores." + name + ".hardness", 0.0D);
			}
			if(Configuration.block.contains("Custom Ores." + name + ".lightlevel")){
				light = Configuration.block.getInt("Custom Ores." + name + ".lightlevel", 0);
			}
			if(Configuration.block.contains("Custom Ores." + name + ".friction")){
				friction = (float) Configuration.block.getDouble("Custom Ores." + name + ".friction", 0.0D);
			}
			if(Configuration.block.contains("Custom Ores." + name + ".base")){
				base = Configuration.block.getInt("Custom Ores." + name + ".base", 1);
			}
			if(Configuration.block.contains("Custom Ores." + name + ".drop")){
				if(Configuration.block.contains("Custom Ores." + name + ".drop.amount")){
					amount = Configuration.block.getInt("Custom Ores." + name + ".drop.amount", 1);
				}
				String sdrop = Configuration.block.getString("Custom Ores." + name + ".drop");
				try{
					mdrop = Material.getMaterial(Integer.parseInt(sdrop));
					addOre(plugin, name, textureID, freq, minY, maxY, size, hard, light, friction, mdrop, amount, base);
				}catch(NumberFormatException e){
					if(materials.containsValue(sdrop)){
						drop = getMaterialByName(sdrop);
					}
				}
			}
			if(drop != null){
				addOre(plugin, name, textureID, freq, minY, maxY, size, hard, light, friction, drop, amount, base);
			}else{
				addOre(plugin, name, textureID, freq, minY, maxY, size, hard, light, friction, mdrop, amount, base);
			}
		}
	}
	
	public void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY, int size, float hard, int light, float friction, org.getspout.spoutapi.material.Material drop, int amount, int base) {
		CustomOre ore = new CustomOre(plugin, name, textureID, freq, minY, maxY, size, drop, hard, light, friction, amount, base);
		blocks.put(ore, BlockType.ORE);
		materials.put(ore, MaterialType.ORE);
	}
	
	public void addOre(RpgEssentials plugin, String name, int textureID, int freq, int minY, int maxY, int size, float hard, int light, float friction, Material drop, int amount, int base) {
		CustomOre ore = new CustomOre(plugin, name, textureID, freq, minY, maxY, size, drop, hard, light, friction, amount, base);
		blocks.put(ore, BlockType.ORE);
		materials.put(ore, MaterialType.ORE);
	}
	
	public Set<GenericCustomBlock> getOres(){
		Set<GenericCustomBlock> ores = new HashSet<GenericCustomBlock>();
		for(GenericCustomBlock block:blocks.keySet()){
			if(blocks.get(block).equals(BlockType.ORE)){
				ores.add(block);
			}
		}
		return ores;
	}
	
	
	//ITEMS
	
	//default
	private void CustomItems(){
		ConfigurationSection section = Configuration.items.getConfigurationSection("Custom Items");
		Iterator<?> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String name = (String)keys.next();
			String textureurl = Configuration.items.getString("Custom Items." + name + ".texture url");
			String type = Configuration.items.getString("Custom Items." + name + ".type", "default");
			addItem(plugin, name, textureurl, ItemType.valueOf(type.toUpperCase().replace(" ", "_")));
		}
		ConfigurationSection section2 = Configuration.items.getConfigurationSection("Custom Tools");
		Iterator<?> keys2 = section2.getKeys(false).iterator();
		while(keys2.hasNext()){
			String name = (String)keys2.next();
			String textureurl = Configuration.items.getString("Custom Tools." + name + ".texture url");
			int durability = Configuration.items.getInt("Custom Tools." + name + ".durability");
			String type = Configuration.items.getString("Custom Tools." + name + ".type", "sword");
			addTool(plugin, name, textureurl, durability, ToolType.valueOf(type.toUpperCase().replace(" ", "_")));
		}
		ConfigurationSection section3 = Configuration.items.getConfigurationSection("Custom Food");
		Iterator<?> keys3 = section3.getKeys(false).iterator();
		while(keys3.hasNext()){
			String name = (String)keys3.next();
			String textureurl = Configuration.items.getString("Custom Food." + name + ".texture url");
			int restore = Configuration.items.getInt("Custom Food." + name + ".restore");
			int heal = Configuration.items.getInt("Custom Food." + name + ".heal");
			addFood(plugin, name, textureurl, restore, heal);
		}
		ConfigurationSection section4 = Configuration.items.getConfigurationSection("Custom Fish");
		Iterator<?> keys4 = section4.getKeys(false).iterator();
		while(keys4.hasNext()){
			String name = (String)keys4.next();
			String textureurl = Configuration.items.getString("Custom Fish." + name + ".texture url");
			int restore = Configuration.items.getInt("Custom Fish." + name + ".restore");
			int heal = Configuration.items.getInt("Custom Fish." + name + ".heal");
			addFood(plugin, name, textureurl, restore, heal);
			addFish(plugin, name, textureurl);
		}
	}
	
	public void addItem(RpgEssentials plugin, String name, String textureurl, ItemType type) {
		CustomItems item = new CustomItems(plugin, name, textureurl);
		items.put(item, type);
		materials.put(item, type==ItemType.DEFAULT?MaterialType.ITEM:MaterialType.valueOf(type.toString()));
	}
	
	//tools
	
	public void addTool(RpgEssentials plugin, String name, String textureurl, int durability, ToolType type) {
		CustomTool tool = new CustomTool(plugin, name, textureurl, (short) durability, type);
		items.put(tool, ItemType.TOOL);
		materials.put(tool, MaterialType.TOOL);
	}
	
	public boolean isTool(GenericCustomItem item){
		if(item instanceof GenericCustomTool){
			return true;
		}
		return false;
	}
	
	public CustomTool getTool(ItemStack itemstack){
		SpoutItemStack tool = new SpoutItemStack(itemstack);
		if(tool.isCustomItem()){
			return (CustomTool) tool.getMaterial();
		}
		return null;
	}
	
	public Set<GenericCustomItem> getTools(){
		Set<GenericCustomItem> tools = new HashSet<GenericCustomItem>();
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.TOOL)){
				tools.add(item);
			}
		}
		return tools;
	}
	
	public CustomTool getToolByName(String name){
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.TOOL)){
				if(item.getName().equals(name)){
					return (CustomTool) item;
				}
			}
		}
		return null;
	}
	
	//food
	public void addFood(RpgEssentials plugin, String name, String textureurl, int restore, int heal) {
		CustomFood food = new CustomFood(plugin, name, textureurl, restore, heal);
		items.put(food, ItemType.FOOD);
		materials.put(food, MaterialType.FOOD);
	}
	
	public CustomFood getFoodByName(String name){
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.FOOD)){
				if(item.getName().equals(name)){
					return (CustomFood) item;
				}
			}
		}
		return null;
	}
	
	public Set<GenericCustomItem> getFood(){
		Set<GenericCustomItem> food = new HashSet<GenericCustomItem>();
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.FOOD)){
				food.add(item);
			}
		}
		return food;
	}
	
	//fish
	
	public void addFish(RpgEssentials plugin, String name, String textureurl) {
		CustomFood fish = getFoodByName(name);
		items.put(fish, ItemType.FISH);
		materials.put(fish, MaterialType.FISH);
	}
	
	public CustomFood getFishByName(String name){
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.FISH)){
				if(item.getName().equals(name)){
					return (CustomFood) item;
				}
			}
		}
		return null;
	}
	
	public Set<GenericCustomItem> getFish(){
		Set<GenericCustomItem> fish = new HashSet<GenericCustomItem>();
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.FISH)){
				fish.add(item);
			}
		}
		return fish;
	}
	
	public int getFishSize(){
		Set<GenericCustomItem> fish = new HashSet<GenericCustomItem>();
		for(GenericCustomItem item:items.keySet()){
			if(items.get(item).equals(ItemType.FISH)){
				fish.add(item);
			}
		}
		return fish.size();
	}
	
	//DESIGNS
	private static int quadnumber = 0;
	private static Set<String> names = new LinkedHashSet<String>();
	private static GenericBlockDesign addDesign(RpgEssentials plugin, MyConfiguration config, int[] ids, String textureurl, int texturesize){
		GenericBlockDesign design = new GenericBlockDesign();
		
		String[] boundingbox = config.getString("BoundingBox").split(",");
		
		design.setBoundingBox(Float.parseFloat(boundingbox[0]), Float.parseFloat(boundingbox[1]), Float.parseFloat(boundingbox[2]), Float.parseFloat(boundingbox[3]), Float.parseFloat(boundingbox[4]), Float.parseFloat(boundingbox[5]));
	    
		Texture texture = new Texture(plugin, textureurl, 16*texturesize, 16*texturesize, texturesize);
		
		design.setTexture(plugin, texture.getTexture()).setMinBrightness(0F).setMaxBrightness(1F);
		
		ConfigurationSection section = config.getConfigurationSection("Shape");
		Iterator<?> keys = section.getKeys(false).iterator();
		quadnumber = 1;
		names.clear();
		while(keys.hasNext()){
			String name = (String) keys.next();
			names.add(name);
			quadnumber++;
		}
		
		design.setQuadNumber(quadnumber);
		
		quadnumber = 0;
		for(String name:names){
			List<String> coords = config.getStringList("Shape."+ name + ".Coords");
			
			Iterator<String> keys2 = coords.iterator();
			String[] row1 = keys2.next().toString().split(" ");
			String[] row2 = keys2.next().toString().split(" ");
			String[] row3 = keys2.next().toString().split(" ");
			String[] row4 = keys2.next().toString().split(" ");
			
			int textureid = config.getInt("Shape."+ name + ".TextureId");
			
			Quad quad = new Quad(quadnumber, texture.getSubTexture(ids[textureid]));
			quad.addVertex(0, Float.parseFloat(row1[0]), Float.parseFloat(row1[1]), Float.parseFloat(row1[2]));
			quad.addVertex(1, Float.parseFloat(row2[0]), Float.parseFloat(row2[1]), Float.parseFloat(row2[2]));
			quad.addVertex(2, Float.parseFloat(row3[0]), Float.parseFloat(row3[1]), Float.parseFloat(row3[2]));
			quad.addVertex(3, Float.parseFloat(row4[0]), Float.parseFloat(row4[1]), Float.parseFloat(row4[2]));
			
			design.setQuad(quad);
			quadnumber++;
		}
		
		return design;
	}
	
	public void addStair(RpgEssentials plugin, String name, int[] ids) {
		CustomStair stair = new CustomStair(plugin, name, ids);
		blocks.put(stair, BlockType.STAIR);
		materials.put(stair, MaterialType.STAIR);
	}
	
	public void addStairEdge(RpgEssentials plugin, String name, int[] ids) {
		CustomStairEdge stair = new CustomStairEdge(plugin, name, ids);
		blocks.put(stair, BlockType.STAIREDGE);
		materials.put(stair, MaterialType.STAIREDGE);
	}
	
	private void registerBlocks() {
		//orginal ores
		OriginalOre CoalOre = new OriginalOre(plugin, Material.COAL_ORE, Configuration.block.getInt("Original Ores.Coal Ore.frequency"), Configuration.block.getInt("Original Ores.Coal Ore.max vein size"), Configuration.block.getInt("Original Ores.Coal Ore.min height"), Configuration.block.getInt("Original Ores.Coal Ore.max height"));
		OriginalOre IronOre = new OriginalOre(plugin, Material.IRON_ORE, Configuration.block.getInt("Original Ores.Iron Ore.frequency"), Configuration.block.getInt("Original Ores.Iron Ore.max vein size"), Configuration.block.getInt("Original Ores.Iron Ore.min height"), Configuration.block.getInt("Original Ores.Iron Ore.max height"));
		OriginalOre LapisOre = new OriginalOre(plugin, Material.LAPIS_ORE, Configuration.block.getInt("Original Ores.Lapis Ore.frequency"), Configuration.block.getInt("Original Ores.Gold Ore.max vein size"), Configuration.block.getInt("Original Ores.Lapis Ore.min height"), Configuration.block.getInt("Original Ores.Lapis Ore.max height"));
		OriginalOre GoldOre = new OriginalOre(plugin, Material.GOLD_ORE, Configuration.block.getInt("Original Ores.Gold Ore.frequency"), Configuration.block.getInt("Original Ores.Coal Ore.max vein size"), Configuration.block.getInt("Original Ores.Gold Ore.min height"), Configuration.block.getInt("Original Ores.Gold Ore.max height"));
		OriginalOre RedstoneOre = new OriginalOre(plugin, Material.REDSTONE_ORE, Configuration.block.getInt("Original Ores.Redstone Ore.frequency"), Configuration.block.getInt("Original Ores.Redstone Ore.max vein size"), Configuration.block.getInt("Original Ores.Redstone Ore.min height"), Configuration.block.getInt("Original Ores.Redstone Ore.max height"));
		OriginalOre DiamondOre = new OriginalOre(plugin, Material.DIAMOND_ORE, Configuration.block.getInt("Original Ores.Diamond Ore.frequency"), Configuration.block.getInt("Original Ores.Diamond Ore.max vein size"), Configuration.block.getInt("Original Ores.Diamond Ore.min height"), Configuration.block.getInt("Original Ores.Diamond Ore.max height"));
		originalores.add(CoalOre);
		originalores.add(IronOre);
		originalores.add(LapisOre);
		originalores.add(GoldOre);
		originalores.add(RedstoneOre);
		originalores.add(DiamondOre);
		
		CustomOres();
		CustomItems();
		CustomBlock();
		
		//MicrowaveBlock microwaveblock = new MicrowaveBlock(plugin);
		//misc.add(microwaveblock);
		
		if(RpgEssentials.RpgBanks != null){
			int[] id = {6,6,6,5,6,6};
			SafeBlock safeBlock = new SafeBlock(plugin, "Safe", id);
			blocks.put(safeBlock, BlockType.SAFE);
			materials.put(safeBlock, MaterialType.SAFE);
		}
		
		AnvilBlock anvilBlock = new AnvilBlock(plugin);
		blocks.put(anvilBlock, BlockType.ANVIL);
		
		if(RpgEssentials.RpgStores != null){
			RegisterBlock registerBlock = new RegisterBlock(plugin);
			blocks.put(registerBlock, BlockType.REGISTER);
			materials.put(registerBlock, MaterialType.REGISTER);
		}
		
		/*EmptyCartDetectorRail emptycartdetectorrail = new EmptyCartDetectorRail(plugin, "Empty Cart Detector", new int[]{6,6,6,5,6,6});
		blocks.put(emptycartdetectorrail, BlockType.RAILS);
		materials.put(emptycartdetectorrail, MaterialType.RAILS);
		StorageCartDetectorRail storagecartdetectorrail = new StorageCartDetectorRail(plugin, "Storage Cart Detector", new int[]{6,6,6,5,6,6});
		blocks.put(storagecartdetectorrail, BlockType.RAILS);
		materials.put(storagecartdetectorrail, MaterialType.RAILS);
		PoweredMinecartDetectorRail poweredcartdetectorrail = new PoweredMinecartDetectorRail(plugin, "Powered Cart Detector", new int[]{6,6,6,5,6,6});
		blocks.put(poweredcartdetectorrail, BlockType.RAILS);
		materials.put(poweredcartdetectorrail, MaterialType.RAILS);
		LoaderRail loaderrail = new LoaderRail(plugin, "StorageCart Loader", new int[]{6,6,6,5,6,6});
		blocks.put(loaderrail, BlockType.RAILS);
		materials.put(loaderrail, MaterialType.RAILS);
		UnloaderRail unloaderrail = new UnloaderRail(plugin, "StorageCart Unloader", new int[]{6,6,6,5,6,6});
		blocks.put(unloaderrail, BlockType.RAILS);
		materials.put(unloaderrail, MaterialType.RAILS);*/
		
		
		if(RpgEssentials.RpgLeveling != null){
			/*LaptopBlockN LaptopN = new LaptopBlockN(plugin);
			laptopmap.put("North", LaptopN);
			LaptopBlockE LaptopE = new LaptopBlockE(plugin);
			laptopmap.put("East", LaptopE);
			LaptopBlockS LaptopS = new LaptopBlockS(plugin);
			laptopmap.put("South", LaptopS);
			LaptopBlockW LaptopW = new LaptopBlockW(plugin);
			laptopmap.put("West", LaptopW);*/
		}
		
		int [] plantpotids = {1,2,0,0,0,0};
		
		//PlantPot plantpot = new PlantPot(plugin, plantpotids);
		//plants.add(plantpot);
	}
}
