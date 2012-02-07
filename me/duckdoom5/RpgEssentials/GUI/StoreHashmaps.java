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
		if(storeconfig.getBoolean("Store.Mechanisms.redstone.Sell Able") == true){
			mechanisms.add(Material.REDSTONE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.diode.Sell Able") == true){
			mechanisms.add(Material.DIODE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.piston base.Sell Able") == true){
			mechanisms.add(Material.PISTON_BASE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.piston sticky base.Sell Able") == true){
			mechanisms.add(Material.PISTON_STICKY_BASE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.lever.Sell Able") == true){
			mechanisms.add(Material.LEVER);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.wood plate.Sell Able") == true){
			mechanisms.add(Material.WOOD_PLATE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.stone plate.Sell Able") == true){
			mechanisms.add(Material.STONE_PLATE);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.note block.Sell Able") == true){
			mechanisms.add(Material.NOTE_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.detector rail.Sell Able") == true){
			mechanisms.add(Material.DETECTOR_RAIL);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.redstone torch off.Sell Able") == true){
			mechanisms.add(Material.REDSTONE_TORCH_OFF);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.powered rail.Sell Able") == true){
			mechanisms.add(Material.POWERED_RAIL);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.rails.Sell Able") == true){
			mechanisms.add(Material.RAILS);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.wood door.Sell Able") == true){
			mechanisms.add(Material.WOOD_DOOR);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.iron door.Sell Able") == true){
			mechanisms.add(Material.IRON_DOOR);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.dispenser.Sell Able") == true){
			mechanisms.add(Material.DISPENSER);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.stone button.Sell Able") == true){
			mechanisms.add(Material.STONE_BUTTON);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.trap door.Sell Able") == true){
			mechanisms.add(Material.TRAP_DOOR);
		}
		if(storeconfig.getBoolean("Store.Mechanisms.tnt.Sell Able") == true){
			mechanisms.add(Material.TNT);
		}
		//gardening
		if(storeconfig.getBoolean("Store.Gardening.wood hoe.Sell Able") == true){
			gardening.add(Material.WOOD_HOE);
		}
		if(storeconfig.getBoolean("Store.Gardening.bucket.Sell Able") == true){
			gardening.add(Material.BUCKET);
		}
		if(storeconfig.getBoolean("Store.Gardening.water bucket.Sell Able") == true){
			gardening.add(Material.WATER_BUCKET);
		}
		if(storeconfig.getBoolean("Store.Gardening.brown mushroom.Sell Able") == true){
			gardening.add(Material.BROWN_MUSHROOM);
		}
		if(storeconfig.getBoolean("Store.Gardening.red mushroom.Sell Able") == true){
			gardening.add(Material.RED_MUSHROOM);
		}
		if(storeconfig.getBoolean("Store.Gardening.red rose.Sell Able") == true){
			gardening.add(Material.RED_ROSE);
		}
		if(storeconfig.getBoolean("Store.Gardening.yellow flower.Sell Able") == true){
			gardening.add(Material.YELLOW_FLOWER);
		}
		if(storeconfig.getBoolean("Store.Gardening.cactus.Sell Able") == true){
			gardening.add(Material.CACTUS);
		}
		
		if(storeconfig.getBoolean("Store.Gardening.sapling.Sell Able") == true){
			gardening.add(Material.SAPLING);
		}
		if(storeconfig.getBoolean("Store.Gardening.seeds.Sell Able") == true){
			gardening.add(Material.SEEDS);
		}
		if(storeconfig.getBoolean("Store.Gardening.sugar cane.Sell Able") == true){
			gardening.add(Material.SUGAR_CANE);
		}
		if(storeconfig.getBoolean("Store.Gardening.wheat.Sell Able") == true){
			gardening.add(Material.WHEAT);
		}
		if(storeconfig.getBoolean("Store.Gardening.melon seeds.Sell Able") == true){
			gardening.add(Material.MELON_SEEDS);
		}
		if(storeconfig.getBoolean("Store.Gardening.melon block.Sell Able") == true){
			gardening.add(Material.MELON_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Gardening.pumpkin seeds.Sell Able") == true){
			gardening.add(Material.PUMPKIN_SEEDS);
		}
		if(storeconfig.getBoolean("Store.Gardening.pumpkin.Sell Able") == true){
			gardening.add(Material.PUMPKIN);
		}
		if(storeconfig.getBoolean("Store.Gardening.soil.Sell Able") == true){
			gardening.add(Material.SOIL);
		}
		if(storeconfig.getBoolean("Store.Gardening.long grass.Sell Able") == true){
			gardening.add(Material.LONG_GRASS);
		}
		if(storeconfig.getBoolean("Store.Gardening.dead bush.Sell Able") == true){
			gardening.add(Material.DEAD_BUSH);
		}
		if(storeconfig.getBoolean("Store.Gardening.vine.Sell Able") == true){
			gardening.add(Material.VINE);
		}
		if(storeconfig.getBoolean("Store.Gardening.water lily.Sell Able") == true){
			gardening.add(Material.WATER_LILY);
		}
		if(storeconfig.getBoolean("Store.Gardening.nether warts.Sell Able") == true){
			gardening.add(Material.NETHER_WARTS);
		}
		
		//furniture
		if(storeconfig.getBoolean("Store.Furniture.bed.Sell Able") == true){
			furniture.add(Material.BED);
		}
		if(storeconfig.getBoolean("Store.Furniture.bookshelf.Sell Able") == true){
			furniture.add(Material.BOOKSHELF);
		}
		if(storeconfig.getBoolean("Store.Furniture.brewing stand item.Sell Able") == true){
			furniture.add(Material.BREWING_STAND_ITEM);
		}
		if(storeconfig.getBoolean("Store.Furniture.brick stairs.Sell Able") == true){
			furniture.add(Material.BRICK_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Furniture.cauldron item.Sell Able") == true){
			furniture.add(Material.CAULDRON_ITEM);
		}
		if(storeconfig.getBoolean("Store.Furniture.workbench.Sell Able") == true){
			furniture.add(Material.WORKBENCH);
		}
		if(storeconfig.getBoolean("Store.Furniture.chest.Sell Able") == true){
			furniture.add(Material.CHEST);
		}
		if(storeconfig.getBoolean("Store.Furniture.cobblestone stairs.Sell Able") == true){
			furniture.add(Material.COBBLESTONE_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Furniture.dispenser.Sell Able") == true){
			furniture.add(Material.DISPENSER);
		}
		if(storeconfig.getBoolean("Store.Furniture.enchantment table.Sell Able") == true){
			furniture.add(Material.ENCHANTMENT_TABLE);
		}
		if(storeconfig.getBoolean("Store.Furniture.fence.Sell Able") == true){
			furniture.add(Material.FENCE);
		}
		if(storeconfig.getBoolean("Store.Furniture.fence gate.Sell Able") == true){
			furniture.add(Material.FENCE_GATE);
		}
		if(storeconfig.getBoolean("Store.Furniture.furnace.Sell Able") == true){
			furniture.add(Material.FURNACE);
		}
		if(storeconfig.getBoolean("Store.Furniture.jukebox.Sell Able") == true){
			furniture.add(Material.JUKEBOX);
		}
		if(storeconfig.getBoolean("Store.Furniture.jack o lantern.Sell Able") == true){
			furniture.add(Material.JACK_O_LANTERN);
		}
		if(storeconfig.getBoolean("Store.Furniture.ladder.Sell Able") == true){
			furniture.add(Material.LADDER);
		}
		if(storeconfig.getBoolean("Store.Furniture.nether brick stairs.Sell Able") == true){
			furniture.add(Material.NETHER_BRICK_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Furniture.nether fence.Sell Able") == true){
			furniture.add(Material.NETHER_FENCE);
		}
		if(storeconfig.getBoolean("Store.Furniture.note block.Sell Able") == true){
			furniture.add(Material.NOTE_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Furniture.painting.Sell Able") == true){
			furniture.add(Material.PAINTING);
		}
		if(storeconfig.getBoolean("Store.Furniture.sign.Sell Able") == true){
			furniture.add(Material.SIGN);
		}
		if(storeconfig.getBoolean("Store.Furniture.wood door.Sell Able") == true){
			furniture.add(Material.WOOD_DOOR);
		}
		if(storeconfig.getBoolean("Store.Furniture.iron door.Sell Able") == true){
			furniture.add(Material.IRON_DOOR);
		}
		if(storeconfig.getBoolean("Store.Furniture.torch.Sell Able") == true){
			furniture.add(Material.TORCH);
		}
		if(storeconfig.getBoolean("Store.Furniture.trap door.Sell Able") == true){
			furniture.add(Material.TRAP_DOOR);
		}
		if(storeconfig.getBoolean("Store.Furniture.wood stairs.Sell Able") == true){
			furniture.add(Material.WOOD_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Furniture.smooth stairs.Sell Able") == true){
			furniture.add(Material.SMOOTH_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Furniture.iron fence.Sell Able") == true){
			furniture.add(Material.IRON_FENCE);
		}
		if(storeconfig.getBoolean("Store.Furniture.thin glass.Sell Able") == true){
			furniture.add(Material.THIN_GLASS);
		}
		
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
		if(storeconfig.getBoolean("Store.Materials.stone.Sell Able") == true){
			materials.add(Material.STONE);
		}
		if(storeconfig.getBoolean("Store.Materials.grass.Sell Able") == true){
			materials.add(Material.GRASS);
		}
		if(storeconfig.getBoolean("Store.Materials.dirt.Sell Able") == true){
			materials.add(Material.DIRT);
		}
		if(storeconfig.getBoolean("Store.Materials.cobblestone.Sell Able") == true){
			materials.add(Material.COBBLESTONE);
		}
		if(storeconfig.getBoolean("Store.Materials.wood.Sell Able") == true){
			materials.add(Material.WOOD);
		}
		if(storeconfig.getBoolean("Store.Materials.bedrock.Sell Able") == true){
			materials.add(Material.BEDROCK);
		}
		if(storeconfig.getBoolean("Store.Materials.water.Sell Able") == true){
			materials.add(Material.WATER);
		}
		if(storeconfig.getBoolean("Store.Materials.stationary water.Sell Able") == true){
			materials.add(Material.STATIONARY_WATER);
		}
		if(storeconfig.getBoolean("Store.Materials.lava.Sell Able") == true){
			materials.add(Material.LAVA);
		}
		if(storeconfig.getBoolean("Store.Materials.stationary lava.Sell Able") == true){
			materials.add(Material.STATIONARY_LAVA);
		}
		if(storeconfig.getBoolean("Store.Materials.sand.Sell Able") == true){
			materials.add(Material.SAND);
		}
		if(storeconfig.getBoolean("Store.Materials.gravel.Sell Able") == true){
			materials.add(Material.GRAVEL);
		}
		if(storeconfig.getBoolean("Store.Materials.log.Sell Able") == true){
			materials.add(Material.LOG);
		}
		if(storeconfig.getBoolean("Store.Materials.leaves.Sell Able") == true){
			materials.add(Material.LEAVES);
		}
		if(storeconfig.getBoolean("Store.Materials.sponge.Sell Able") == true){
			materials.add(Material.SPONGE);
		}
		if(storeconfig.getBoolean("Store.Materials.glass.Sell Able") == true){
			materials.add(Material.GLASS);
		}
		if(storeconfig.getBoolean("Store.Materials.sandstone.Sell Able") == true){
			materials.add(Material.SANDSTONE);
		}
		if(storeconfig.getBoolean("Store.Materials.double step.Sell Able") == true){
			materials.add(Material.DOUBLE_STEP);
		}
		if(storeconfig.getBoolean("Store.Materials.step.Sell Able") == true){
			materials.add(Material.STEP);
		}
		if(storeconfig.getBoolean("Store.Materials.brick.Sell Able") == true){
			materials.add(Material.BRICK);
		}
		if(storeconfig.getBoolean("Store.Materials.mossy cobblestone.Sell Able") == true){
			materials.add(Material.MOSSY_COBBLESTONE);
		}
		if(storeconfig.getBoolean("Store.Materials.obsidian.Sell Able") == true){
			materials.add(Material.OBSIDIAN);
		}
		if(storeconfig.getBoolean("Store.Materials.snow.Sell Able") == true){
			materials.add(Material.SNOW);
		}
		if(storeconfig.getBoolean("Store.Materials.ice.Sell Able") == true){
			materials.add(Material.ICE);
		}
		if(storeconfig.getBoolean("Store.Materials.snow block.Sell Able") == true){
			materials.add(Material.SNOW_BLOCK);
		}
		if(storeconfig.getBoolean("Store.Materials.clay.Sell Able") == true){
			materials.add(Material.CLAY);
		}
		if(storeconfig.getBoolean("Store.Materials.smooth brick.Sell Able") == true){
			materials.add(Material.SMOOTH_BRICK);
		}
		if(storeconfig.getBoolean("Store.Materials.mycel.Sell Able") == true){
			materials.add(Material.MYCEL);
		}
		if(storeconfig.getBoolean("Store.Materials.enderstone.Sell Able") == true){
			materials.add(Material.ENDER_STONE);
		}
		
		//raw materials
		if(storeconfig.getBoolean("Store.Raw Materials.coal.Sell Able") == true){
			rawmaterials.add(Material.COAL);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.iron ingot.Sell Able") == true){
			rawmaterials.add(Material.IRON_INGOT);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.gold ingot.Sell Able") == true){
			rawmaterials.add(Material.GOLD_INGOT);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.diamond.Sell Able") == true){
			rawmaterials.add(Material.DIAMOND);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.clay ball.Sell Able") == true){
			rawmaterials.add(Material.CLAY_BALL);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.clay brick.Sell Able") == true){
			rawmaterials.add(Material.CLAY_BRICK);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.glowstone dust.Sell Able") == true){
			rawmaterials.add(Material.GLOWSTONE_DUST);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.flint.Sell Able") == true){
			rawmaterials.add(Material.FLINT);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.paper.Sell Able") == true){
			rawmaterials.add(Material.PAPER);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.book.Sell Able") == true){
			rawmaterials.add(Material.BOOK);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.snow ball.Sell Able") == true){
			rawmaterials.add(Material.SNOW_BALL);
		}
		if(storeconfig.getBoolean("Store.Raw Materials.sugar.Sell Able") == true){
			rawmaterials.add(Material.SUGAR);
		}
		
		//nether
		if(storeconfig.getBoolean("Store.Nether.netherrack.Sell Able") == true){
			nether.add(Material.NETHERRACK);
		}
		if(storeconfig.getBoolean("Store.Nether.nether brick.Sell Able") == true){
			nether.add(Material.NETHER_BRICK);
		}
		if(storeconfig.getBoolean("Store.Nether.nether brick stairs.Sell Able") == true){
			nether.add(Material.NETHER_BRICK_STAIRS);
		}
		if(storeconfig.getBoolean("Store.Nether.nether fence.Sell Able") == true){
			nether.add(Material.NETHER_FENCE);
		}
		if(storeconfig.getBoolean("Store.Nether.nether stalk.Sell Able") == true){
			nether.add(Material.NETHER_STALK);
		}
		if(storeconfig.getBoolean("Store.Nether.nether warts.Sell Able") == true){
			nether.add(Material.NETHER_WARTS);
		}
		if(storeconfig.getBoolean("Store.Nether.blaze rod.Sell Able") == true){
			nether.add(Material.BLAZE_ROD);
		}
		if(storeconfig.getBoolean("Store.Nether.ghast tear.Sell Able") == true){
			nether.add(Material.GHAST_TEAR);
		}
		if(storeconfig.getBoolean("Store.Nether.gold nugget.Sell Able") == true){
			nether.add(Material.GOLD_NUGGET);
		}
		if(storeconfig.getBoolean("Store.Nether.soul sand.Sell Able") == true){
			nether.add(Material.SOUL_SAND);
		}
		if(storeconfig.getBoolean("Store.Nether.glowstone dust.Sell Able") == true){
			nether.add(Material.GLOWSTONE_DUST);
		}
		if(storeconfig.getBoolean("Store.Nether.glowstone.Sell Able") == true){
			nether.add(Material.GLOWSTONE);
		}
		
		//painting
		if(storeconfig.getBoolean("Store.Painting.wool.Sell Able") == true){
			painting.add(Material.WOOL);
		}
		if(storeconfig.getBoolean("Store.Painting.ink sack.Sell Able") == true){
			painting.add(Material.INK_SACK);
		}
		
		//mobdrops
		if(storeconfig.getBoolean("Store.Mob Drops.string.Sell Able") == true){
			mobdrops.add(Material.STRING);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.leather.Sell Able") == true){
			mobdrops.add(Material.LEATHER);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.feather.Sell Able") == true){
			mobdrops.add(Material.FEATHER);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.arrow.Sell Able") == true){
			mobdrops.add(Material.ARROW);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.egg.Sell Able") == true){
			mobdrops.add(Material.EGG);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.blaze rod.Sell Able") == true){
			mobdrops.add(Material.BLAZE_ROD);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.ghast tear.Sell Able") == true){
			mobdrops.add(Material.GHAST_TEAR);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.gold nugget.Sell Able") == true){
			mobdrops.add(Material.GOLD_NUGGET);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.rotten flesh.Sell Able") == true){
			mobdrops.add(Material.ROTTEN_FLESH);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.bone.Sell Able") == true){
			mobdrops.add(Material.BONE);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.sulphur.Sell Able") == true){
			mobdrops.add(Material.SULPHUR);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.spider eye.Sell Able") == true){
			mobdrops.add(Material.SPIDER_EYE);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.ender pearl.Sell Able") == true){
			mobdrops.add(Material.ENDER_PEARL);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.slime ball.Sell Able") == true){
			mobdrops.add(Material.SLIME_BALL);
		}
		if(storeconfig.getBoolean("Store.Mob Drops.magma cream.Sell Able") == true){
			mobdrops.add(Material.MAGMA_CREAM);
		}
		
		//brewing
		if(storeconfig.getBoolean("Store.Brewing.brewing stand item.Sell Able") == true){
			brewing.add(Material.BREWING_STAND_ITEM);
		}
		if(storeconfig.getBoolean("Store.Brewing.cauldron item.Sell Able") == true){
			brewing.add(Material.CAULDRON_ITEM);
		}
		if(storeconfig.getBoolean("Store.Brewing.water bucket.Sell Able") == true){
			brewing.add(Material.WATER_BUCKET);
		}
		if(storeconfig.getBoolean("Store.Brewing.blaze powder.Sell Able") == true){
			brewing.add(Material.BLAZE_POWDER);
		}
		if(storeconfig.getBoolean("Store.Brewing.nether warts.Sell Able") == true){
			brewing.add(Material.NETHER_WARTS);
		}
		//TODO potion data values!
		if(storeconfig.getBoolean("Store.Brewing.potion.Sell Able") == true){
			brewing.add(Material.POTION);
		}
		if(storeconfig.getBoolean("Store.Brewing.glass bottle.Sell Able") == true){
			brewing.add(Material.GLASS_BOTTLE);
		}
		if(storeconfig.getBoolean("Store.Brewing.fermented spider eye.Sell Able") == true){
			brewing.add(Material.FERMENTED_SPIDER_EYE);
		}
		if(storeconfig.getBoolean("Store.Brewing.magma cream.Sell Able") == true){
			brewing.add(Material.MAGMA_CREAM);
		}
		if(storeconfig.getBoolean("Store.Brewing.glowstone dust.Sell Able") == true){
		brewing.add(Material.GLOWSTONE_DUST);
		}
		if(storeconfig.getBoolean("Store.Brewing.redstone.Sell Able") == true){
		brewing.add(Material.REDSTONE);
		}
		if(storeconfig.getBoolean("Store.Brewing.sugar.Sell Able") == true){
		brewing.add(Material.SUGAR);
		}
		if(storeconfig.getBoolean("Store.Brewing.speckled melon.Sell Able") == true){
		brewing.add(Material.SPECKLED_MELON);
		}
		if(storeconfig.getBoolean("Store.Brewing.ghast tear.Sell Able") == true){
			brewing.add(Material.GHAST_TEAR);
		}
		if(storeconfig.getBoolean("Store.Brewing.sulphur.Sell Able") == true){
			brewing.add(Material.SULPHUR);
		}
		
		//music
		if(storeconfig.getBoolean("Store.Music.jukebox.Sell Able") == true){
			music.add(Material.JUKEBOX);
		}
		if(storeconfig.getBoolean("Store.Music.gold record.Sell Able") == true){
			music.add(Material.GOLD_RECORD);
		}
		if(storeconfig.getBoolean("Store.Music.green record.Sell Able") == true){
			music.add(Material.GREEN_RECORD);
		}
		if(storeconfig.getBoolean("Store.Music.record 3.Sell Able") == true){
			music.add(Material.RECORD_3);
		}
		if(storeconfig.getBoolean("Store.Music.record 4.Sell Able") == true){
			music.add(Material.RECORD_4);
		}
		if(storeconfig.getBoolean("Store.Music.record 5.Sell Able") == true){
			music.add(Material.RECORD_5);
		}
		if(storeconfig.getBoolean("Store.Music.record 6.Sell Able") == true){
			music.add(Material.RECORD_6);
		}
		if(storeconfig.getBoolean("Store.Music.record 7.Sell Able") == true){
			music.add(Material.RECORD_7);
		}
		if(storeconfig.getBoolean("Store.Music.record 8.Sell Able") == true){
			music.add(Material.RECORD_8);
		}
		if(storeconfig.getBoolean("Store.Music.record 9.Sell Able") == true){
			music.add(Material.RECORD_9);
		}
		if(storeconfig.getBoolean("Store.Music.record 10.Sell Able") == true){
			music.add(Material.RECORD_10);
		}
		if(storeconfig.getBoolean("Store.Music.record 11.Sell Able") == true){
			music.add(Material.RECORD_11);
		}
		
		//misc
		if(storeconfig.getBoolean("Store.Miscellaneous.web.Sell Able") == true){
			misc.add(Material.WEB);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.fire.Sell Able") == true){
			misc.add(Material.FIRE);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.portal.Sell Able") == true){
			misc.add(Material.PORTAL);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.ender portal frame.Sell Able") == true){
			misc.add(Material.ENDER_PORTAL_FRAME);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.dragon egg.Sell Able") == true){
			misc.add(Material.DRAGON_EGG);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.monster egg.Sell Able") == true){
			//TODO monster EGG data values!
			misc.add(Material.MONSTER_EGG);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.monster eggs.Sell Able") == true){
			misc.add(Material.MONSTER_EGGS);
		}
		if(storeconfig.getBoolean("Store.Miscellaneous.mob spawner.Sell Able") == true){
			//TODO mob spawner data values!
			misc.add(Material.MOB_SPAWNER);
		}
	}
	
}
