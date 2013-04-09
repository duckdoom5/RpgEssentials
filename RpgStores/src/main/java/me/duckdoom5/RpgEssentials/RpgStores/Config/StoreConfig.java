package me.duckdoom5.RpgEssentials.RpgStores.Config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.bukkit.configuration.ConfigurationSection;

public class StoreConfig {
	public static HashMap<String, String> custommaterials = new LinkedHashMap<String, String>();
	public static void set() {
		
		for(StoreValue value:StoreValue.values()) {
			String name = value.toString().toLowerCase().replace("_", " ");
			String type = value.getType();
			String type2 = value.getType2();
			String type3 = value.getType3();
			
			if(!Configuration.store.contains("Store." + type + "." + name + ".Buy Able")){
				Configuration.store.set("Store." + type + "." + name + ".Buy Able",value.isBuyAble());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Sell Able")){
				Configuration.store.set("Store." + type + "." + name + ".Sell Able",value.isSellAble());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Buy Price")){
				Configuration.store.set("Store." + type + "." + name + ".Buy Price",value.getBuyPrice());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Sell Price")){
				Configuration.store.set("Store." + type + "." + name + ".Sell Price",value.getSellPrice());
			}
			
			if(type2 != null){
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Buy Able")){
					Configuration.store.set("Store." + type2 + "." + name + ".Buy Able",value.isBuyAble());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Sell Able")){
					Configuration.store.set("Store." + type2 + "." + name + ".Sell Able",value.isSellAble());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Buy Price")){
					Configuration.store.set("Store." + type2 + "." + name + ".Buy Price",value.getBuyPrice());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Sell Price")){
					Configuration.store.set("Store." + type2 + "." + name + ".Sell Price",value.getSellPrice());
				}
			}
			
			if(type3 != null){
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Buy Able")){
					Configuration.store.set("Store." + type3 + "." + name + ".Buy Able",value.isBuyAble());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Sell Able")){
					Configuration.store.set("Store." + type3 + "." + name + ".Sell Able",value.isSellAble());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Buy Price")){
					Configuration.store.set("Store." + type3 + "." + name + ".Buy Price",value.getBuyPrice());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Sell Price")){
					Configuration.store.set("Store." + type3 + "." + name + ".Sell Price",value.getSellPrice());
				}
			}
		}
		
		//custom materials
		update();
		for(String name:custommaterials.keySet()){
			me.duckdoom5.RpgEssentials.config.MyConfiguration config;
			
			if(custommaterials.get(name).equals("Ores") || custommaterials.get(name).equals("Blocks")){
				config = me.duckdoom5.RpgEssentials.config.Configuration.block;
			}else{
				config = me.duckdoom5.RpgEssentials.config.Configuration.items;
			}
			
			if(!Configuration.store.contains("Store.custom." + custommaterials.get(name) + "." + name + ".Buy Price")){
				Configuration.store.set("Store.custom." + custommaterials.get(name) + "." + name + ".Buy Price", config.getInt("Custom " + custommaterials.get(name) + "." + name + ".Buy Price"));
			}
			if(!Configuration.store.contains("Store.custom." + custommaterials.get(name) + "." + name + ".Sell Price")){
				Configuration.store.set("Store.custom." + custommaterials.get(name) + "." + name + ".Sell Price", config.getInt("Custom " + custommaterials.get(name) + "." + name + ".Sell Price"));
			}
		}
	}
	
	private static void update() {
		String[] types  = new String[]{"Items", "Tools", "Food", "Fish", "Ores", "Blocks"};
		for(String type:types){
			ConfigurationSection section;
			if(type.equals("Ores") || type.equals("Blocks")){
				section = me.duckdoom5.RpgEssentials.config.Configuration.block.getConfigurationSection("Custom " + type);
			}else{
				section = me.duckdoom5.RpgEssentials.config.Configuration.items.getConfigurationSection("Custom " + type);
			}
			if(section!=null){
				Iterator<?> keys = section.getKeys(false).iterator();
				while(keys.hasNext()){
					String name = (String)keys.next();
					custommaterials.put(name, type);
				}
			}
		}
		
	}
	public static enum StoreValue{
		APPLE("Food", null, null, true, true, 15, 7.5),
		GOLDEN_APPLE("Food", null, null, true, true, 50, 25),
		BREAD("Food", null, null, true, true, 10, 5),
		CAKE("Food", null, null, true, true, 60, 30),
		RAW_BEEF("Food", null, null, true, true, 20, 10),
		COOKED_BEEF("Food", null, null, true, true, 40, 20),
		RAW_CHICKEN("Food", null, null, true, true, 15, 7.5),
		COOKED_CHICKEN("Food", null, null, true, true, 25, 12.5),
		RAW_FISH("Food", null, null, true, true, 20, 10),
		COOKED_FISH("Food", null, null, true, true, 40, 20),
		COOKIE("Food", null, null, true, true, 20, 10),
		PORK("Food", null, null, true, true, 20, 10),
		GRILLED_PORK("Food", null, null, true, true, 40, 10),
		MELON("Food", null, null, true, true, 50, 25),
		MUSHROOM_SOUP("Food", null, null, true, true, 30, 15),
		ROTTEN_FLESH("Food", "Mob Drops", null, true, true, 5, 2.5),
		SPIDER_EYE("Food", "Mob Drops", null, true, true, 20, 10),
		COCOA("Food", "Painting", null, true, true, 20, 10),
		
		WOOD_AXE("Tools", null, null, true, true, 15, 7.5),
		WOOD_HOE("Tools", "Gardening", null, true, true, 10, 5),
		WOOD_PICKAXE("Tools", null, null, true, true, 15, 7.5),
		WOOD_SWORD("Tools", null, null, true, true, 20, 10),
		WOOD_SPADE("Tools", null, null, true, true, 15, 7.5),
		STONE_AXE("Tools", null, null, true, true, 30, 15),
		STONE_HOE("Tools", null, null, true, true, 25, 12.5),
		STONE_PICKAXE("Tools", null, null, true, true, 30, 15),
		STONE_SWORD("Tools", null, null, true, true, 35, 17.5),
		STONE_SPADE("Tools", null, null, true, true, 25, 12.5),
		IRON_AXE("Tools", null, null, true, true, 50, 25),
		IRON_HOE("Tools", null, null, true, true, 45, 22.5),
		IRON_PICKAXE("Tools", null, null, true, true, 50, 25),
		IRON_SWORD("Tools", null, null, true, true, 55, 27.5),
		IRON_SPADE("Tools", null, null, true, true, 40, 20),
		GOLD_AXE("Tools", null, null, true, true, 100, 50),
		GOLD_HOE("Tools", null, null, true, true, 90, 45),
		GOLD_PICKAXE("Tools", null, null, true, true, 100, 50),
		GOLD_SWORD("Tools", null, null, true, true, 110, 55),
		GOLD_SPADE("Tools", null, null, true, true, 80, 40),
		DIAMOND_AXE("Tools", null, null, true, true, 500, 250),
		DIAMOND_HOE("Tools", null, null, true, true, 450, 225),
		DIAMOND_PICKAXE("Tools", null, null, true, true, 500, 250),
		DIAMOND_SWORD("Tools", null, null, true, true, 550, 275),
		DIAMOND_SPADE("Tools", null, null, true, true, 400, 200),
		MINECART("Tools", null, null, true, true, 100, 50),
		POWERED_MINECART("Tools", null, null, true, true, 150, 75),
		STORAGE_MINECART("Tools", null, null, true, true, 150, 75),
		COMPASS("Tools", null, null, true, true, 100, 50),
		WATCH("Tools", null, null, true, true, 120, 60),
		ARROW("Tools", "Mob Drops", null, true, true, 10, 10),
		BUCKET("Tools", null, null, true, true, 50, 25),
		WATER_BUCKET("Tools", "Gardening", "Brewing", true, true, 55, 27.5),
		LAVA_BUCKET("Tools", null, null, true, true, 200, 50),
		MILK_BUCKET("Tools", null, null, true, true, 60, 20),
		BOW("Tools", null, null, true, true, 150, 75),
		BOAT("Tools", null, null, true, true, 100, 40),
		SADDLE("Tools", null, null, true, true, 200, 100),
		FISHING_ROD("Tools", null, null, true, true, 50, 25),
		SHEARS("Tools", null, null, true, true, 60, 30),
		FLINT_AND_STEEL("Tools", null, null, true, true, 40, 20),
		BOWL("Tools", null, null, true, true, 20, 5),
		STICK("Tools", null, null, true, true, 10, 1),
		SNOW_BALL("Tools", "Raw Materials", null, true, true, 20, 10),
		MAP("Tools", null, null, true, true, 300, 100),
		BOOK_AND_QUILL("Tools", null, null, true, true, 70, 35),
		
		LEATHER_HELMET("Armor", null, null, true, true, 20, 10),
		LEATHER_CHESTPLATE("Armor", null, null, true, true, 50, 25),
		LEATHER_LEGGINGS("Armor", null, null, true, true, 30, 15),
		LEATHER_BOOTS("Armor", null, null, true, true, 20, 10),
		CHAINMAIL_HELMET("Armor", null, null, true, true, 50, 25),
		CHAINMAIL_CHESTPLATE("Armor", null, null, true, true, 100, 50),
		CHAINMAIL_LEGGINGS("Armor", null, null, true, true, 70, 35),
		CHAINMAIL_BOOTS("Armor", null, null, true, true, 50, 25),
		IRON_HELMET("Armor", null, null, true, true, 100, 50),
		IRON_CHESTPLATE("Armor", null, null, true, true, 250, 125),
		IRON_LEGGINGS("Armor", null, null, true, true, 200, 100),
		IRON_BOOTS("Armor", null, null, true, true, 100, 50),
		GOLD_HELMET("Armor", null, null, true, true, 250, 125),
		GOLD_CHESTPLATE("Armor", null, null, true, true, 500, 250),
		GOLD_LEGGINGS("Armor", null, null, true, true, 350, 175),
		GOLD_BOOTS("Armor", null, null, true, true, 250, 125),
		DIAMOND_HELMET("Armor", null, null, true, true, 500, 250),
		DIAMOND_CHESTPLATE("Armor", null, null, true, true, 1000, 400),
		DIAMOND_LEGGINGS("Armor", null, null, true, true, 700, 350),
		DIAMOND_BOOTS("Armor", null, null, true, true, 500, 250),
		
		REDSTONE("Mechanisms", "Brewing", null, true, true, 5, 1),
		TRIPWIRE_HOOK("Mechanisms", null, null, true, true, 30, 10),
		DIODE("Mechanisms", null, null, true, true, 20, 5),
		PISTON_BASE("Mechanisms", null, null, true, true, 70, 35),
		PISTON_STICKY_BASE("Mechanisms", null, null, true, true, 100, 50),
		LEVER("Mechanisms", null, null, true, true, 10, 2),
		WOOD_PLATE("Mechanisms", null, null, true, true, 15, 7.5),
		STONE_PLATE("Mechanisms", null, null, true, true, 20, 10),
		DETECTOR_RAIL("Mechanisms", null, null, true, true, 40, 20),
		REDSTONE_TORCH_OFF("Mechanisms", null, null, true, true, 15, 7.5),
		POWERED_RAIL("Mechanisms", null, null, true, true, 60, 30),
		RAILS("Mechanisms", null, null, true, true, 30, 15),
		WOOD_DOOR("Mechanisms", "Furniture", null, true, true, 40, 20),
		IRON_DOOR("Mechanisms", "Furniture", null, true, true, 60, 30),
		DISPENSER("Mechanisms", null, null, true, true, 150, 75),
		STONE_BUTTON("Mechanisms", null, null, true, true, 5, 1),
		TRAP_DOOR("Mechanisms", "Furniture", null, true, true, 50, 25),
		TNT("Mechanisms", null, null, true, true, 150, 75),
		REDSTONE_LAMP_OFF("Mechanisms", null, null, true, true, 100, 50),
		
		BROWN_MUSHROOM("Gardening", null, null, true, true, 30, 5),
		RED_MUSHROOM("Gardening", null, null, true, true, 50, 5),
		RED_ROSE("Gardening", null, null, true, true, 20, 5),
		YELLOW_FLOWER("Gardening", null, null, true, true, 15, 5),
		CACTUS("Gardening", null, null, true, true, 30, 5),
		SAPLING("Gardening", null, null, true, true, 20, 5),
		SEEDS("Gardening", null, null, true, true, 50, 5),
		SUGAR_CANE("Gardening", null, null, true, true, 50, 5),
		WHEAT("Gardening", null, null, true, true, 20, 5),
		MELON_SEEDS("Gardening", null, null, true, true, 500, 20),
		MELON_BLOCK("Gardening", null, null, true, true, 600, 20),
		PUMPKIN_SEEDS("Gardening", null, null, true, true, 500, 20),
		PUMPKIN("Gardening", null, null, true, true, 600, 20),
		SOIL("Gardening", null, null, false, false, 20, 1),
		LONG_GRASS("Gardening", null, null, true, true, 15, 1),
		DEAD_BUSH("Gardening", null, null, true, true, 15, 1),
		VINE("Gardening", null, null, true, true, 50, 10),
		WATER_LILY("Gardening", null, null, true, true, 30, 5),
		
		BED("Furniture", null, null, true, true, 250, 50),
		BOOKSHELF("Furniture", null, null, true, true, 150, 75),
		BRICK_STAIRS("Furniture", null, null, true, true, 70, 35),
		SANDSTONE_STAIRS("Furniture", null, null, true, true, 70, 35),
		BIRCH_WOOD_STAIRS("Furniture", null, null, true, true, 70, 35),
		JUNGLE_WOOD_STAIRS("Furniture", null, null, true, true, 80, 40),
		SPRUCE_WOOD_STAIRS("Furniture", null, null, true, true, 80, 40),
		WORKBENCH("Furniture", null, null, true, true, 50, 5),
		CHEST("Furniture", null, null, true, true, 70, 20),
		ENDER_CHEST("Furniture", null, null, true, true, 200, 50),
		COBBLESTONE_STAIRS("Furniture", null, null, true, true, 40, 20),
		ENCHANTMENT_TABLE("Furniture", null, null, true, true, 300, 100),
		FENCE("Furniture", null, null, true, true, 20, 5),
		FENCE_GATE("Furniture", null, null, true, true, 40, 20),
		FURNACE("Furniture", null, null, true, true, 60, 10),
		JACK_O_LANTERN("Furniture", null, null, true, true, 150, 50),
		LADDER("Furniture", null, null, true, true, 20, 10),
		PAINTING("Furniture", null, null, true, true, 20, 10),
		SIGN("Furniture", null, null, true, true, 20, 10),
		TORCH("Furniture", null, null, true, true, 30, 1),
		WOOD_STAIRS("Furniture", null, null, true, true, 40, 10),
		SMOOTH_STAIRS("Furniture", null, null, true, true, 70, 35),
		IRON_FENCE("Furniture", null, null, true, true, 50, 10),
		THIN_GLASS("Furniture", null, null, true, true, 40, 5),
		
		STONE("Materials", null, null, true, true, 10, 1),
		GRASS("Materials", null, null, true, true, 30, 5),
		DIRT("Materials", null, null, true, true, 5, 0.5),
		COBBLESTONE("Materials", null, null, true, true, 5, 0.5),
		WOOD("Materials", null, null, true, true, 10, 0.5),
		BEDROCK("Materials", null, null, false, false, 1000000, 1),
		WATER("Materials", null, null, false, false, 100, 1),
		STATIONARY_WATER("Materials", null, null, false, false, 150, 1),
		LAVA("Materials", null, null, false, false, 5000, 1),
		STATIONARY_LAVA("Materials", null, null, false, false, 5000, 1),
		SAND("Materials", null, null, true, true, 15, 1),
		GRAVEL("Materials", null, null, true, true, 15, 1),
		LOG("Materials", null, null, true, true, 15, 2),
		LEAVES("Materials", null, null, true, true, 15, 1),
		SPONGE("Materials", null, null, true, true, 50, 10),
		GLASS("Materials", null, null, true, true, 15, 7.5),
		SANDSTONE("Materials", null, null, true, true, 25, 10),
		DOUBLE_STEP("Materials", null, null, true, true, 15, 7.5),
		WOOD_DOUBLE_STEP("Materials", null, null, true, true, 15, 5),
		STEP("Materials", null, null, true, true, 10, 3),
		WOOD_STEP("Materials", null, null, true, true, 10, 3),
		BRICK("Materials", null, null, true, true, 30, 5),
		MOSSY_COBBLESTONE("Materials", null, null, true, true, 35, 10),
		OBSIDIAN("Materials", null, null, true, true, 100, 20),
		SNOW("Materials", null, null, true, true, 20, 10),
		ICE("Materials", null, null, true, true, 40, 10),
		SNOW_BLOCK("Materials", null, null, true, true, 30, 15),
		CLAY("Materials", null, null, true, true, 35, 5),
		SMOOTH_BRICK("Materials", null, null, true, true, 110, 20),
		MYCEL("Materials", null, null, true, true, 150, 10),
		
		COAL("Raw Materials", null, null, true, true, 40, 2),
		IRON_INGOT("Raw Materials", null, null, true, true, 60, 5),
		GOLD_INGOT("Raw Materials", null, null, true, true, 100, 10),
		DIAMOND("Raw Materials", null, null, true, true, 600, 50),
		EMERALD("Raw Materials", null, null, true, true, 700, 50),
		CLAY_BALL("Raw Materials", null, null, true, true, 15, 3),
		CLAY_BRICK("Raw Materials", null, null, true, true, 20, 7),
		FLINT("Raw Materials", null, null, true, true, 15, 5),
		PAPER("Raw Materials", null, null, true, true, 40, 10),
		BOOK("Raw Materials", null, null, true, true, 50, 20),
		DIAMOND_BLOCK("Raw Materials", null, null, true, true, 17500, 600),
		EMERALD_BLOCK("Raw Materials", null, null, true, true, 20000, 300),
		IRON_BLOCK("Raw Materials", null, null, true, true, 2250, 200),
		GOLD_BLOCK("Raw Materials", null, null, true, true, 4500, 400),
		LAPIS_BLOCK("Raw Materials", null, null, true, true, 1000, 150),
		
		ENDER_PORTAL_FRAME("The End", "Miscellaneous", null, false, false, 70, 10),
		DRAGON_EGG("The End", "Miscellaneous", null, false, false, 200, 30),
		ENDER_STONE("The End", "Materials", null, true, true, 100, 20),
		ENDER_PEARL("The End", "Mob Drops", null, true, true, 50, 10),
		EYE_OF_ENDER("The End", null, null, true, true, 70, 20),
		
		GOLD_ORE("Ores", null, null, true, true, 500, 100),
		DIAMOND_ORE("Ores", null, null, true, true, 2000, 400),
		EMERALD_ORE("Ores", null, null, true, true, 3000, 700),
		REDSTONE_ORE("Ores", null, null, true, true, 300, 70),
		IRON_ORE("Ores", null, null, true, true, 250, 30),
		COAL_ORE("Ores", null, null, true, true, 100, 20),
		LAPIS_ORE("Ores", null, null, true, true, 150, 50),
		
		STRING("Mob Drops", null, null, true, true, 15, 4),
		LEATHER("Mob Drops", null, null, true, true, 30, 5),
		FEATHER("Mob Drops", null, null, true, true, 40, 6),
		EGG("Mob Drops", null, null, true, true, 20, 2),
		BONE("Mob Drops", null, null, true, true, 30, 3),
		SLIME_BALL("Mob Drops", null, null, true, true, 60, 6),
		
		BREWING_STAND_ITEM("Brewing", "Furniture", null, true, true, 200, 50),
		CAULDRON_ITEM("Brewing", "Furniture", null, true, true, 200, 50),
		BLAZE_POWDER("Brewing", null, null, true, true, 90, 20),
		POTION("Brewing", null, null, true, true, 30, 5),
		GLASS_BOTTLE("Brewing", null, null, true, true, 10, 2),
		FERMENTED_SPIDER_EYE("Brewing", null, null, true, true, 40, 10),
		MAGMA_CREAM("Brewing", "Mob Drops", null, true, true, 80, 20),
		SUGAR("Brewing", "Raw Materials", null, true, true, 20, 5),
		SPECKLED_MELON("Brewing", null, null, true, true, 100, 30),
		SULPHUR("Brewing", "Mob Drops", null, true, true, 80, 20),
		
		WOOL("Painting", null, null, true, true, 25, 5),
		INK_SACK("Painting", null, null, true, true, 30, 5),
		
		NETHERRACK("Nether", "Materials", null, true, true, 50, 5),
		NETHER_BRICK("Nether", "Materials", null, true, true, 60, 10),
		NETHER_BRICK_STAIRS("Nether", "Furniture", null, true, true, 70, 10),
		NETHER_FENCE("Nether", "Furniture", null, true, true, 70, 10),
		NETHER_STALK("Nether", "Furniture", null, true, true, 70, 5),
		NETHER_WARTS("Nether", "Brewing", "Gardening", true, true, 50, 10),
		BLAZE_ROD("Nether", "Mob Drops", null, true, true, 70, 15),
		GHAST_TEAR("Nether", "Brewing", "Mob Drops", true, true, 80, 20),
		GOLD_NUGGET("Nether", "Mob Drops", null, true, true, 40, 10),
		SOUL_SAND("Nether", "Materials", "Gardening", true, true, 60, 15),
		GLOWSTONE_DUST("Nether", "Brewing", "Raw Materials", true, true, 40, 5),
		GLOWSTONE("Nether", "Materials", null, true, true, 60, 10),
		PORTAL("Nether", "Miscellaneous", null, false, false, 100, 10),
		
		JUKEBOX("Music", "Furniture", null, true, true, 400, 40),
		NOTE_BLOCK("Music", "Mechanisms", "Furniture", true, true, 150, 40),
		GOLD_RECORD("Music", null, null, true, true, 200, 20),
		GREEN_RECORD("Music", null, null, true, true, 200, 20),
		RECORD_3("Music", null, null, true, true, 250, 50),
		RECORD_4("Music", null, null, true, true, 250, 50),
		RECORD_5("Music", null, null, true, true, 250, 50),
		RECORD_6("Music", null, null, true, true, 250, 50),
		RECORD_7("Music", null, null, true, true, 250, 50),
		RECORD_8("Music", null, null, true, true, 250, 50),
		RECORD_9("Music", null, null, true, true, 250, 50),
		RECORD_10("Music", null, null, true, true, 250, 50),
		RECORD_11("Music", null, null, true, true, 300, 60),
		
		WEB("Miscellaneous", null, null, true, true, 80, 10),
		FIRE("Miscellaneous", null, null, false, false, 60, 10),
		MONSTER_EGG("Miscellaneous", null, null, true, true, 150, 20),
		MONSTER_EGGS("Miscellaneous", null, null, false, false, 150, 20),
		MOB_SPAWNER("Miscellaneous", null, null, true, true, 2000, 50);
		
		private final String type;
		private final String type2;
		private final String type3;
		private final boolean buyAble;
		private final boolean sellAble;
		private final double buyPrice;
		private final double sellPrice;
		
		StoreValue(String type, String type2, String type3, boolean buyAble, boolean sellAble, double buyPrice, double sellPrice){
			this.type = type;
			this.type2 = type2;
			this.type3 = type3;
			this.buyAble = buyAble;
			this.sellAble = sellAble;
			this.buyPrice = buyPrice;
			this.sellPrice = sellPrice;
		}
		
		public String getType(){
			return type;
		}
		
		public String getType2(){
			return type2;
		}
		
		public String getType3(){
			return type3;
		}
		
		public boolean isBuyAble(){
			return buyAble;
		}
		
		public boolean isSellAble(){
			return sellAble;
		}
		
		public double getBuyPrice(){
			return buyPrice;
		}
		
		public double getSellPrice(){
			return sellPrice;
		}
	}
}
