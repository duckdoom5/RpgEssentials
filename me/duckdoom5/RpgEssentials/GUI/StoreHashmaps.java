package me.duckdoom5.RpgEssentials.GUI;

import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

public class StoreHashmaps {
	public static Set<Material> food = new LinkedHashSet<Material>();
	public static Set<Material> tools = new LinkedHashSet<Material>();
	public static Set<Material> armour = new LinkedHashSet<Material>();
	public static Set<Material> mechanisms = new LinkedHashSet<Material>();
	public static Set<Material> gardening = new LinkedHashSet<Material>();
	public static Set<Material> furniture = new LinkedHashSet<Material>();
	public static Set<Material> materials = new LinkedHashSet<Material>();
	public static Set<Material> rawmaterials = new LinkedHashSet<Material>();
	public static Set<Material> minerals = new LinkedHashSet<Material>();
	public static Set<Material> ores = new LinkedHashSet<Material>();
	public static Set<Material> mobdrops = new LinkedHashSet<Material>();
	public static Set<Material> brewing = new LinkedHashSet<Material>();
	public static Set<Material> painting = new LinkedHashSet<Material>();
	public static Set<Material> nether = new LinkedHashSet<Material>();
	public static Set<Material> music = new LinkedHashSet<Material>();
	public static Set<Material> misc = new LinkedHashSet<Material>();
	
	static YamlConfiguration storeconfig = new YamlConfiguration();
	
	public static void registerstore(RpgEssentials plugin){
		try {
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//food
		if(storeconfig.getBoolean("Store.Food.apple.Sell Able") == true){
			food.add(Material.APPLE);
		}
		if(storeconfig.getBoolean("Store.Food.golden apple.Sell Able") == true){
			food.add(Material.GOLDEN_APPLE);
		}
		if(storeconfig.getBoolean("Store.Food.bread.Sell Able") == true){
			food.add(Material.BREAD);
		}
		if(storeconfig.getBoolean("Store.Food.cake.Sell Able") == true){
			food.add(Material.CAKE);
		}
		if(storeconfig.getBoolean("Store.Food.raw beef.Sell Able") == true){
			food.add(Material.RAW_BEEF);
		}
		if(storeconfig.getBoolean("Store.Food.cooked beef.Sell Able") == true){
			food.add(Material.COOKED_BEEF);
		}
		if(storeconfig.getBoolean("Store.Food.raw chicken.Sell Able") == true){
			food.add(Material.RAW_CHICKEN);
		}
		if(storeconfig.getBoolean("Store.Food.cooked chicken.Sell Able") == true){
			food.add(Material.COOKED_CHICKEN);
		}
		if(storeconfig.getBoolean("Store.Food.raw fish.Sell Able") == true){
			food.add(Material.RAW_FISH);
		}
		if(storeconfig.getBoolean("Store.Food.cooked fish.Sell Able") == true){
			food.add(Material.COOKED_FISH);
		}
		if(storeconfig.getBoolean("Store.Food.cookie.Sell Able") == true){
			food.add(Material.COOKIE);
		}
		if(storeconfig.getBoolean("Store.Food.pork.Sell Able") == true){
			food.add(Material.PORK);
		}
		if(storeconfig.getBoolean("Store.Food.grilled pork.Sell Able") == true){
			food.add(Material.GRILLED_PORK);
		}
		if(storeconfig.getBoolean("Store.Food.melon.Sell Able") == true){
			food.add(Material.MELON);
		}
		if(storeconfig.getBoolean("Store.Food.mushroom soup.Sell Able") == true){
			food.add(Material.MUSHROOM_SOUP);
		}
		if(storeconfig.getBoolean("Store.Food.rotten flesh.Sell Able") == true){
			food.add(Material.ROTTEN_FLESH);
		}
		if(storeconfig.getBoolean("Store.Food.spider eye.Sell Able") == true){
			food.add(Material.SPIDER_EYE);
		}
		
		//tools
		if(storeconfig.getBoolean("Store.Tools.wood axe.Sell Able") == true){
			tools.add(Material.WOOD_AXE);
		}
		if(storeconfig.getBoolean("Store.Tools.iron axe.Sell Able") == true){
			tools.add(Material.IRON_AXE);
		}
		if(storeconfig.getBoolean("Store.Tools.wood hoe.Sell Able") == true){
			tools.add(Material.WOOD_HOE);
		}
		if(storeconfig.getBoolean("Store.Tools.iron hoe.Sell Able") == true){
			tools.add(Material.IRON_HOE);
		}
		if(storeconfig.getBoolean("Store.Tools.wood pickaxe.Sell Able") == true){
			tools.add(Material.WOOD_PICKAXE);
		}
		if(storeconfig.getBoolean("Store.Tools.iron pickaxe.Sell Able") == true){
			tools.add(Material.IRON_PICKAXE);
		}
		if(storeconfig.getBoolean("Store.Tools.wood spade.Sell Able") == true){
			tools.add(Material.WOOD_SPADE);
		}
		if(storeconfig.getBoolean("Store.Tools.iron spade.Sell Able") == true){
			tools.add(Material.IRON_SPADE);
		}
		if(storeconfig.getBoolean("Store.Tools.wood sword.Sell Able") == true){
			tools.add(Material.WOOD_SWORD);
		}
		if(storeconfig.getBoolean("Store.Tools.iron sword.Sell Able") == true){
			tools.add(Material.IRON_SWORD);
		}
		
		if(storeconfig.getBoolean("Store.Tools.stone axe.Sell Able") == true){
			tools.add(Material.STONE_AXE);
		}
		if(storeconfig.getBoolean("Store.Tools.gold axe.Sell Able") == true){
			tools.add(Material.GOLD_AXE);
		}
		if(storeconfig.getBoolean("Store.Tools.stone hoe.Sell Able") == true){
			tools.add(Material.STONE_HOE);
		}
		if(storeconfig.getBoolean("Store.Tools.gold hoe.Sell Able") == true){
			tools.add(Material.GOLD_HOE);
		}
		if(storeconfig.getBoolean("Store.Tools.stone pickaxe.Sell Able") == true){
			tools.add(Material.STONE_PICKAXE);
		}
		if(storeconfig.getBoolean("Store.Tools.gold pickaxe.Sell Able") == true){
			tools.add(Material.GOLD_PICKAXE);
		}
		if(storeconfig.getBoolean("Store.Tools.stone spade.Sell Able") == true){
			tools.add(Material.STONE_SPADE);
		}
		if(storeconfig.getBoolean("Store.Tools.gold spade.Sell Able") == true){
			tools.add(Material.GOLD_SPADE);
		}
		if(storeconfig.getBoolean("Store.Tools.stone sword.Sell Able") == true){
			tools.add(Material.STONE_SWORD);
		}
		if(storeconfig.getBoolean("Store.Tools.gold sword.Sell Able") == true){
			tools.add(Material.GOLD_SWORD);
		}
		
		//page 2
		if(storeconfig.getBoolean("Store.Tools.diamond axe.Sell Able") == true){
			tools.add(Material.DIAMOND_AXE);
		}
		if(storeconfig.getBoolean("Store.Tools.minecart.Sell Able") == true){
			tools.add(Material.MINECART);
		}
		if(storeconfig.getBoolean("Store.Tools.diamond hoe.Sell Able") == true){
			tools.add(Material.DIAMOND_HOE);
		}
		if(storeconfig.getBoolean("Store.Tools.powerd minecart.Sell Able") == true){
			tools.add(Material.POWERED_MINECART);
		}
		if(storeconfig.getBoolean("Store.Tools.diamond pickaxe.Sell Able") == true){
			tools.add(Material.DIAMOND_PICKAXE);
		}
		if(storeconfig.getBoolean("Store.Tools.storage minecart.Sell Able") == true){
			tools.add(Material.STORAGE_MINECART);
		}
		if(storeconfig.getBoolean("Store.Tools.diamond spade.Sell Able") == true){
			tools.add(Material.DIAMOND_SPADE);
		}
		if(storeconfig.getBoolean("Store.Tools.compass.Sell Able") == true){
			tools.add(Material.COMPASS);
		}
		if(storeconfig.getBoolean("Store.Tools.diamond sword.Sell Able") == true){
			tools.add(Material.DIAMOND_SWORD);
		}
		if(storeconfig.getBoolean("Store.Tools.watch.Sell Able") == true){
			tools.add(Material.WATCH);
		}
		
		if(storeconfig.getBoolean("Store.Tools.arrow.Sell Able") == true){
			tools.add(Material.ARROW);
		}
		if(storeconfig.getBoolean("Store.Tools.bucket.Sell Able") == true){
			tools.add(Material.BUCKET);
		}
		if(storeconfig.getBoolean("Store.Tools.bow.Sell Able") == true){
			tools.add(Material.BOW);
		}
		if(storeconfig.getBoolean("Store.Tools.milk bucket.Sell Able") == true){
			tools.add(Material.MILK_BUCKET);
		}
		if(storeconfig.getBoolean("Store.Tools.boat.Sell Able") == true){
			tools.add(Material.BOAT);
		}
		if(storeconfig.getBoolean("Store.Tools.water bucket.Sell Able") == true){
			tools.add(Material.WATER_BUCKET);
		}
		if(storeconfig.getBoolean("Store.Tools.saddle.Sell Able") == true){
			tools.add(Material.SADDLE);
		}
		if(storeconfig.getBoolean("Store.Tools.lava bucket.Sell Able") == true){
			tools.add(Material.LAVA_BUCKET);
		}
		if(storeconfig.getBoolean("Store.Tools.fishing rod.Sell Able") == true){
			tools.add(Material.FISHING_ROD);
		}
		if(storeconfig.getBoolean("Store.Tools.shears.Sell Able") == true){
			tools.add(Material.SHEARS);
		}
		
		//page 3
		if(storeconfig.getBoolean("Store.Tools.flint and steel.Sell Able") == true){
			tools.add(Material.FLINT_AND_STEEL);
		}
		if(storeconfig.getBoolean("Store.Tools.bowl.Sell Able") == true){
			tools.add(Material.BOWL);
		}
		if(storeconfig.getBoolean("Store.Tools.stick.Sell Able") == true){
			tools.add(Material.STICK);
		}
		if(storeconfig.getBoolean("Store.Tools.snow ball.Sell Able") == true){
		tools.add(Material.SNOW_BALL);
		}
		if(storeconfig.getBoolean("Store.Tools.map.Sell Able") == true){
			tools.add(Material.MAP);
		}
		
		//armour
		if(storeconfig.getBoolean("Store.Armour.leather helmet.Sell Able") == true){
		armour.add(Material.LEATHER_HELMET);
		}
		if(storeconfig.getBoolean("Store.Armour.chainmail helmet.Sell Able") == true){
		armour.add(Material.CHAINMAIL_HELMET);
		}
		if(storeconfig.getBoolean("Store.Armour.leather chestplate.Sell Able") == true){
		armour.add(Material.LEATHER_CHESTPLATE);
		}
		if(storeconfig.getBoolean("Store.Armour.chainmail chestplate.Sell Able") == true){
		armour.add(Material.CHAINMAIL_CHESTPLATE);
		}
		if(storeconfig.getBoolean("Store.Armour.leather leggings.Sell Able") == true){
		armour.add(Material.LEATHER_LEGGINGS);
		}
		if(storeconfig.getBoolean("Store.Armour.chainmail leggings.Sell Able") == true){
		armour.add(Material.CHAINMAIL_LEGGINGS);
		}
		if(storeconfig.getBoolean("Store.Armour.leather boots.Sell Able") == true){
		armour.add(Material.LEATHER_BOOTS);
		}
		if(storeconfig.getBoolean("Store.Armour.chainmail boots.Sell Able") == true){
		armour.add(Material.CHAINMAIL_BOOTS);
		}
		
		if(storeconfig.getBoolean("Store.Armour.iron helmet.Sell Able") == true){
		armour.add(Material.IRON_HELMET);
		}
		if(storeconfig.getBoolean("Store.Armour.gold helmet.Sell Able") == true){
		armour.add(Material.GOLD_HELMET);
		}
		if(storeconfig.getBoolean("Store.Armour.iron chestplate.Sell Able") == true){
		armour.add(Material.IRON_CHESTPLATE);
		}
		if(storeconfig.getBoolean("Store.Armour.gold chestplate.Sell Able") == true){
		armour.add(Material.GOLD_CHESTPLATE);
		}
		if(storeconfig.getBoolean("Store.Armour.iron leggings.Sell Able") == true){
		armour.add(Material.IRON_LEGGINGS);
		}
		if(storeconfig.getBoolean("Store.Armour.gold leggings.Sell Able") == true){
		armour.add(Material.GOLD_LEGGINGS);
		}
		if(storeconfig.getBoolean("Store.Armour.iron boots.Sell Able") == true){
		armour.add(Material.IRON_BOOTS);
		}
		if(storeconfig.getBoolean("Store.Armour.gold boots.Sell Able") == true){
		armour.add(Material.GOLD_BOOTS);
		}
		
		if(storeconfig.getBoolean("Store.Armour.diamond helmet.Sell Able") == true){
		armour.add(Material.DIAMOND_HELMET);
		}
		if(storeconfig.getBoolean("Store.Armour.diamond leggings.Sell Able") == true){
		armour.add(Material.DIAMOND_LEGGINGS);
		}
		if(storeconfig.getBoolean("Store.Armour.diamond chestplate.Sell Able") == true){
		armour.add(Material.DIAMOND_CHESTPLATE);
		}
		if(storeconfig.getBoolean("Store.Armour.diamond boots.Sell Able") == true){
		armour.add(Material.DIAMOND_BOOTS);
		}
		
		//mechanisms
		mechanisms.add(Material.REDSTONE);
		mechanisms.add(Material.DIODE);
		mechanisms.add(Material.PISTON_BASE);
		mechanisms.add(Material.PISTON_STICKY_BASE);
		mechanisms.add(Material.LEVER);
		mechanisms.add(Material.WOOD_PLATE);
		mechanisms.add(Material.STONE_PLATE);
		mechanisms.add(Material.NOTE_BLOCK);
		mechanisms.add(Material.DETECTOR_RAIL);
		mechanisms.add(Material.REDSTONE_TORCH_OFF);
		mechanisms.add(Material.POWERED_RAIL);
		mechanisms.add(Material.RAILS);
		mechanisms.add(Material.WOOD_DOOR);
		mechanisms.add(Material.IRON_DOOR);
		mechanisms.add(Material.DISPENSER);
		mechanisms.add(Material.STONE_BUTTON);
		mechanisms.add(Material.TRAP_DOOR);
		mechanisms.add(Material.TNT);
		
		//gardening
		gardening.add(Material.WOOD_HOE);
		gardening.add(Material.BUCKET);
		gardening.add(Material.WATER_BUCKET);
		gardening.add(Material.BROWN_MUSHROOM);
		gardening.add(Material.RED_MUSHROOM);
		gardening.add(Material.RED_ROSE);
		gardening.add(Material.YELLOW_FLOWER);
		gardening.add(Material.CACTUS);
		//TODO sapling data values!
		gardening.add(Material.SAPLING);
		gardening.add(Material.SEEDS);
		gardening.add(Material.SUGAR_CANE);
		gardening.add(Material.WHEAT);
		gardening.add(Material.MELON_SEEDS);
		gardening.add(Material.MELON_BLOCK);
		gardening.add(Material.PUMPKIN_SEEDS);
		gardening.add(Material.PUMPKIN);
		gardening.add(Material.SOIL);
		//TODO long grass data values!
		gardening.add(Material.LONG_GRASS);
		gardening.add(Material.DEAD_BUSH);
		gardening.add(Material.VINE);
		gardening.add(Material.WATER_LILY);
		gardening.add(Material.NETHER_WARTS);
		
		//furniture
		furniture.add(Material.BED);
		furniture.add(Material.BOOKSHELF);
		furniture.add(Material.BREWING_STAND_ITEM);
		furniture.add(Material.BRICK_STAIRS);
		furniture.add(Material.CAULDRON_ITEM);
		furniture.add(Material.WORKBENCH);
		furniture.add(Material.CHEST);
		furniture.add(Material.COBBLESTONE_STAIRS);
		furniture.add(Material.DISPENSER);
		furniture.add(Material.ENCHANTMENT_TABLE);
		furniture.add(Material.FENCE);
		furniture.add(Material.FENCE_GATE);
		furniture.add(Material.FURNACE);
		furniture.add(Material.JUKEBOX);
		furniture.add(Material.JACK_O_LANTERN);
		furniture.add(Material.LADDER);
		furniture.add(Material.NETHER_BRICK_STAIRS);
		furniture.add(Material.NETHER_FENCE);
		furniture.add(Material.NOTE_BLOCK);
		furniture.add(Material.PAINTING);
		furniture.add(Material.SIGN);
		furniture.add(Material.WOOD_DOOR);
		furniture.add(Material.IRON_DOOR);
		furniture.add(Material.TORCH);
		furniture.add(Material.TRAP_DOOR);
		furniture.add(Material.WOOD_STAIRS);
		furniture.add(Material.SMOOTH_STAIRS);
		furniture.add(Material.IRON_FENCE);
		furniture.add(Material.THIN_GLASS);
		
		//ores
		if(storeconfig.getBoolean("Store.Ores.diamond ore.Sell Able") == true){
			ores.add(Material.DIAMOND_ORE);
		}
		if(storeconfig.getBoolean("Store.Ores.gold ore.Sell Able") == true){
			ores.add(Material.GOLD_ORE);
		}
		if(storeconfig.getBoolean("Store.Ores.iron ore.Sell Able") == true){
			ores.add(Material.IRON_ORE);
		}
		if(storeconfig.getBoolean("Store.Ores.coal ore.Sell Able") == true){
			ores.add(Material.COAL_ORE);
		}
		if(storeconfig.getBoolean("Store.Ores.lapis ore.Sell Able") == true){
			ores.add(Material.LAPIS_ORE);
		}
		if(storeconfig.getBoolean("Store.Ores.redstone ore.Sell Able") == true){
			ores.add(Material.REDSTONE_ORE);
		}
		
		//minerals
		if(storeconfig.getBoolean("Store.Minerals.lapis block.Sell Able") == true){
			minerals.add(Material.LAPIS_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Minerals.gold block.Sell Able") == true){
			minerals.add(Material.GOLD_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Minerals.iron block.Sell Able") == true){
			minerals.add(Material.IRON_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Minerals.diamond block.Sell Able") == true){
			minerals.add(Material.DIAMOND_BLOCK);
		}
		
		//materials
		materials.add(Material.STONE);
		materials.add(Material.GRASS);
		materials.add(Material.DIRT);
		materials.add(Material.COBBLESTONE);
		materials.add(Material.WOOD);
		materials.add(Material.BEDROCK);
		materials.add(Material.WATER);
		materials.add(Material.STATIONARY_WATER);
		materials.add(Material.LAVA);
		materials.add(Material.STATIONARY_LAVA);
		materials.add(Material.SAND);
		materials.add(Material.GRAVEL);
		//TODO log data values! 
		materials.add(Material.LOG);
		//TODO leaves data values! 
		materials.add(Material.LEAVES);
		materials.add(Material.SPONGE);
		materials.add(Material.GLASS);
		materials.add(Material.SANDSTONE);
		//TODO double step data values!
		materials.add(Material.DOUBLE_STEP);
		//TODO singel step data values!
		materials.add(Material.STEP);
		materials.add(Material.BRICK);
		materials.add(Material.MOSSY_COBBLESTONE);
		materials.add(Material.OBSIDIAN);
		materials.add(Material.SNOW);
		materials.add(Material.ICE);
		materials.add(Material.SNOW_BLOCK);
		materials.add(Material.CLAY);
		//TODO smooth brick data values!
		materials.add(Material.SMOOTH_BRICK);
		materials.add(Material.MYCEL);
		materials.add(Material.ENDER_STONE);
		
		//raw materials
		rawmaterials.add(Material.COAL);
		rawmaterials.add(Material.IRON_INGOT);
		rawmaterials.add(Material.GOLD_INGOT);
		rawmaterials.add(Material.DIAMOND);
		rawmaterials.add(Material.CLAY_BALL);
		rawmaterials.add(Material.CLAY_BRICK);
		rawmaterials.add(Material.GLOWSTONE_DUST);
		rawmaterials.add(Material.FLINT);
		rawmaterials.add(Material.PAPER);
		rawmaterials.add(Material.BOOK);
		rawmaterials.add(Material.SNOW_BALL);
		
		//nether
		nether.add(Material.NETHERRACK);
		nether.add(Material.NETHER_BRICK);
		nether.add(Material.NETHER_BRICK_STAIRS);
		nether.add(Material.NETHER_FENCE);
		nether.add(Material.NETHER_STALK);
		nether.add(Material.NETHER_WARTS);
		nether.add(Material.BLAZE_ROD);
		nether.add(Material.GHAST_TEAR);
		nether.add(Material.GOLD_NUGGET);
		nether.add(Material.SOUL_SAND);
		nether.add(Material.GLOWSTONE_DUST);
		nether.add(Material.GLOWSTONE);
		
		//painting
		//TODO wool data values!
		painting.add(Material.WOOL);
		//TODO dye data values!
		painting.add(Material.INK_SACK);
		
		//mobdrops
		mobdrops.add(Material.STRING);
		mobdrops.add(Material.LEATHER);
		mobdrops.add(Material.FEATHER);
		mobdrops.add(Material.EGG);
		mobdrops.add(Material.BLAZE_ROD);
		mobdrops.add(Material.GHAST_TEAR);
		mobdrops.add(Material.GOLD_NUGGET);
		mobdrops.add(Material.ROTTEN_FLESH);
		mobdrops.add(Material.BONE);
		mobdrops.add(Material.SULPHUR);
		mobdrops.add(Material.SPIDER_EYE);
		mobdrops.add(Material.ENDER_PEARL);
		mobdrops.add(Material.SLIME_BALL);
		
		//brewing
		brewing.add(Material.BREWING_STAND_ITEM);
		brewing.add(Material.CAULDRON_ITEM);
		brewing.add(Material.WATER_BUCKET);
		brewing.add(Material.BLAZE_POWDER);
		brewing.add(Material.NETHER_WARTS);
		//TODO potion data values!
		brewing.add(Material.POTION);
		brewing.add(Material.GLASS_BOTTLE);
		brewing.add(Material.FERMENTED_SPIDER_EYE);
		brewing.add(Material.MAGMA_CREAM);
		brewing.add(Material.EYE_OF_ENDER);
		brewing.add(Material.SPECKLED_MELON);
		
		//music
		music.add(Material.JUKEBOX);
		music.add(Material.GOLD_RECORD);
		music.add(Material.GREEN_RECORD);
		music.add(Material.RECORD_3);
		music.add(Material.RECORD_4);
		music.add(Material.RECORD_5);
		music.add(Material.RECORD_6);
		music.add(Material.RECORD_7);
		music.add(Material.RECORD_8);
		music.add(Material.RECORD_9);
		music.add(Material.RECORD_10);
		music.add(Material.RECORD_11);
		
		//misc
		misc.add(Material.WEB);
		misc.add(Material.FIRE);
		misc.add(Material.PORTAL);
		misc.add(Material.ENDER_PORTAL_FRAME);
		misc.add(Material.DRAGON_EGG);
		//TODO monster EGGS data values!
		misc.add(Material.getMaterial(97));
		misc.add(Material.MONSTER_EGGS);
		//TODO mob spawner data values!
		misc.add(Material.MOB_SPAWNER);
	}
	
}
