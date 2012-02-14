package me.duckdoom5.RpgEssentials.GUI;

import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

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
	
	public static void registerstore(RpgEssentials plugin){
		
		//food
		if(Configuration.store.getBoolean("Store.Food.apple.Sell Able") == true){
			food.add(Material.APPLE);
		}
		if(Configuration.store.getBoolean("Store.Food.golden apple.Sell Able") == true){
			food.add(Material.GOLDEN_APPLE);
		}
		if(Configuration.store.getBoolean("Store.Food.bread.Sell Able") == true){
			food.add(Material.BREAD);
		}
		if(Configuration.store.getBoolean("Store.Food.cake.Sell Able") == true){
			food.add(Material.CAKE);
		}
		if(Configuration.store.getBoolean("Store.Food.raw beef.Sell Able") == true){
			food.add(Material.RAW_BEEF);
		}
		if(Configuration.store.getBoolean("Store.Food.cooked beef.Sell Able") == true){
			food.add(Material.COOKED_BEEF);
		}
		if(Configuration.store.getBoolean("Store.Food.raw chicken.Sell Able") == true){
			food.add(Material.RAW_CHICKEN);
		}
		if(Configuration.store.getBoolean("Store.Food.cooked chicken.Sell Able") == true){
			food.add(Material.COOKED_CHICKEN);
		}
		if(Configuration.store.getBoolean("Store.Food.raw fish.Sell Able") == true){
			food.add(Material.RAW_FISH);
		}
		if(Configuration.store.getBoolean("Store.Food.cooked fish.Sell Able") == true){
			food.add(Material.COOKED_FISH);
		}
		if(Configuration.store.getBoolean("Store.Food.cookie.Sell Able") == true){
			food.add(Material.COOKIE);
		}
		if(Configuration.store.getBoolean("Store.Food.pork.Sell Able") == true){
			food.add(Material.PORK);
		}
		if(Configuration.store.getBoolean("Store.Food.grilled pork.Sell Able") == true){
			food.add(Material.GRILLED_PORK);
		}
		if(Configuration.store.getBoolean("Store.Food.melon.Sell Able") == true){
			food.add(Material.MELON);
		}
		if(Configuration.store.getBoolean("Store.Food.mushroom soup.Sell Able") == true){
			food.add(Material.MUSHROOM_SOUP);
		}
		if(Configuration.store.getBoolean("Store.Food.rotten flesh.Sell Able") == true){
			food.add(Material.ROTTEN_FLESH);
		}
		if(Configuration.store.getBoolean("Store.Food.spider eye.Sell Able") == true){
			food.add(Material.SPIDER_EYE);
		}
		
		//tools
		if(Configuration.store.getBoolean("Store.Tools.wood axe.Sell Able") == true){
			tools.add(Material.WOOD_AXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.wood hoe.Sell Able") == true){
			tools.add(Material.WOOD_HOE);
		}
		if(Configuration.store.getBoolean("Store.Tools.wood pickaxe.Sell Able") == true){
			tools.add(Material.WOOD_PICKAXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.wood spade.Sell Able") == true){
			tools.add(Material.WOOD_SPADE);
		}
		if(Configuration.store.getBoolean("Store.Tools.wood sword.Sell Able") == true){
			tools.add(Material.WOOD_SWORD);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.stone axe.Sell Able") == true){
			tools.add(Material.STONE_AXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.stone hoe.Sell Able") == true){
			tools.add(Material.STONE_HOE);
		}
		if(Configuration.store.getBoolean("Store.Tools.stone pickaxe.Sell Able") == true){
			tools.add(Material.STONE_PICKAXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.stone spade.Sell Able") == true){
			tools.add(Material.STONE_SPADE);
		}
		if(Configuration.store.getBoolean("Store.Tools.stone sword.Sell Able") == true){
			tools.add(Material.STONE_SWORD);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.iron axe.Sell Able") == true){
			tools.add(Material.IRON_AXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.iron hoe.Sell Able") == true){
			tools.add(Material.IRON_HOE);
		}
		if(Configuration.store.getBoolean("Store.Tools.iron pickaxe.Sell Able") == true){
			tools.add(Material.IRON_PICKAXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.iron spade.Sell Able") == true){
			tools.add(Material.IRON_SPADE);
		}
		if(Configuration.store.getBoolean("Store.Tools.iron sword.Sell Able") == true){
			tools.add(Material.IRON_SWORD);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.gold axe.Sell Able") == true){
			tools.add(Material.GOLD_AXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.gold hoe.Sell Able") == true){
			tools.add(Material.GOLD_HOE);
		}
		if(Configuration.store.getBoolean("Store.Tools.gold pickaxe.Sell Able") == true){
			tools.add(Material.GOLD_PICKAXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.gold spade.Sell Able") == true){
			tools.add(Material.GOLD_SPADE);
		}
		if(Configuration.store.getBoolean("Store.Tools.gold sword.Sell Able") == true){
			tools.add(Material.GOLD_SWORD);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.diamond axe.Sell Able") == true){
			tools.add(Material.DIAMOND_AXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.diamond hoe.Sell Able") == true){
			tools.add(Material.DIAMOND_HOE);
		}
		if(Configuration.store.getBoolean("Store.Tools.diamond pickaxe.Sell Able") == true){
			tools.add(Material.DIAMOND_PICKAXE);
		}
		if(Configuration.store.getBoolean("Store.Tools.diamond spade.Sell Able") == true){
			tools.add(Material.DIAMOND_SPADE);
		}
		if(Configuration.store.getBoolean("Store.Tools.diamond sword.Sell Able") == true){
			tools.add(Material.DIAMOND_SWORD);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.minecart.Sell Able") == true){
			tools.add(Material.MINECART);
		}
		if(Configuration.store.getBoolean("Store.Tools.powerd minecart.Sell Able") == true){
			tools.add(Material.POWERED_MINECART);
		}
		if(Configuration.store.getBoolean("Store.Tools.storage minecart.Sell Able") == true){
			tools.add(Material.STORAGE_MINECART);
		}
		if(Configuration.store.getBoolean("Store.Tools.compass.Sell Able") == true){
			tools.add(Material.COMPASS);
		}
		if(Configuration.store.getBoolean("Store.Tools.watch.Sell Able") == true){
			tools.add(Material.WATCH);
		}
		
		if(Configuration.store.getBoolean("Store.Tools.arrow.Sell Able") == true){
			tools.add(Material.ARROW);
		}
		if(Configuration.store.getBoolean("Store.Tools.bow.Sell Able") == true){
			tools.add(Material.BOW);
		}
		if(Configuration.store.getBoolean("Store.Tools.bucket.Sell Able") == true){
			tools.add(Material.BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Tools.milk bucket.Sell Able") == true){
			tools.add(Material.MILK_BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Tools.water bucket.Sell Able") == true){
			tools.add(Material.WATER_BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Tools.lava bucket.Sell Able") == true){
			tools.add(Material.LAVA_BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Tools.boat.Sell Able") == true){
			tools.add(Material.BOAT);
		}
		if(Configuration.store.getBoolean("Store.Tools.saddle.Sell Able") == true){
			tools.add(Material.SADDLE);
		}
		if(Configuration.store.getBoolean("Store.Tools.fishing rod.Sell Able") == true){
			tools.add(Material.FISHING_ROD);
		}
		if(Configuration.store.getBoolean("Store.Tools.shears.Sell Able") == true){
			tools.add(Material.SHEARS);
		}
		
		//page 3
		if(Configuration.store.getBoolean("Store.Tools.flint and steel.Sell Able") == true){
			tools.add(Material.FLINT_AND_STEEL);
		}
		if(Configuration.store.getBoolean("Store.Tools.bowl.Sell Able") == true){
			tools.add(Material.BOWL);
		}
		if(Configuration.store.getBoolean("Store.Tools.stick.Sell Able") == true){
			tools.add(Material.STICK);
		}
		if(Configuration.store.getBoolean("Store.Tools.snow ball.Sell Able") == true){
			tools.add(Material.SNOW_BALL);
		}
		if(Configuration.store.getBoolean("Store.Tools.map.Sell Able") == true){
			tools.add(Material.MAP);
		}
		
		//armour
		if(Configuration.store.getBoolean("Store.Armour.leather helmet.Sell Able") == true){
			armour.add(Material.LEATHER_HELMET);
		}
		if(Configuration.store.getBoolean("Store.Armour.leather chestplate.Sell Able") == true){
			armour.add(Material.LEATHER_CHESTPLATE);
		}
		if(Configuration.store.getBoolean("Store.Armour.leather leggings.Sell Able") == true){
			armour.add(Material.LEATHER_LEGGINGS);
		}
		if(Configuration.store.getBoolean("Store.Armour.leather boots.Sell Able") == true){
			armour.add(Material.LEATHER_BOOTS);
		}
		
		if(Configuration.store.getBoolean("Store.Armour.chainmail helmet.Sell Able") == true){
			armour.add(Material.CHAINMAIL_HELMET);
		}
		if(Configuration.store.getBoolean("Store.Armour.chainmail chestplate.Sell Able") == true){
			armour.add(Material.CHAINMAIL_CHESTPLATE);
		}
		if(Configuration.store.getBoolean("Store.Armour.chainmail leggings.Sell Able") == true){
			armour.add(Material.CHAINMAIL_LEGGINGS);
		}
		if(Configuration.store.getBoolean("Store.Armour.chainmail boots.Sell Able") == true){
			armour.add(Material.CHAINMAIL_BOOTS);
		}
		
		if(Configuration.store.getBoolean("Store.Armour.iron helmet.Sell Able") == true){
			armour.add(Material.IRON_HELMET);
		}
		if(Configuration.store.getBoolean("Store.Armour.iron chestplate.Sell Able") == true){
			armour.add(Material.IRON_CHESTPLATE);
		}
		if(Configuration.store.getBoolean("Store.Armour.iron leggings.Sell Able") == true){
			armour.add(Material.IRON_LEGGINGS);
		}
		if(Configuration.store.getBoolean("Store.Armour.iron boots.Sell Able") == true){
			armour.add(Material.IRON_BOOTS);
		}
		
		if(Configuration.store.getBoolean("Store.Armour.gold helmet.Sell Able") == true){
			armour.add(Material.GOLD_HELMET);
		}
		if(Configuration.store.getBoolean("Store.Armour.gold chestplate.Sell Able") == true){
			armour.add(Material.GOLD_CHESTPLATE);
		}
		if(Configuration.store.getBoolean("Store.Armour.gold leggings.Sell Able") == true){
			armour.add(Material.GOLD_LEGGINGS);
		}
		if(Configuration.store.getBoolean("Store.Armour.gold boots.Sell Able") == true){
			armour.add(Material.GOLD_BOOTS);
		}
		
		if(Configuration.store.getBoolean("Store.Armour.diamond helmet.Sell Able") == true){
			armour.add(Material.DIAMOND_HELMET);
		}
		if(Configuration.store.getBoolean("Store.Armour.diamond chestplate.Sell Able") == true){
			armour.add(Material.DIAMOND_CHESTPLATE);
		}
		if(Configuration.store.getBoolean("Store.Armour.diamond leggings.Sell Able") == true){
			armour.add(Material.DIAMOND_LEGGINGS);
		}
		if(Configuration.store.getBoolean("Store.Armour.diamond boots.Sell Able") == true){
			armour.add(Material.DIAMOND_BOOTS);
		}
		
		//mechanisms
		if(Configuration.store.getBoolean("Store.Mechanisms.redstone.Sell Able") == true){
			mechanisms.add(Material.REDSTONE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.diode.Sell Able") == true){
			mechanisms.add(Material.DIODE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.piston base.Sell Able") == true){
			mechanisms.add(Material.PISTON_BASE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.piston sticky base.Sell Able") == true){
			mechanisms.add(Material.PISTON_STICKY_BASE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.lever.Sell Able") == true){
			mechanisms.add(Material.LEVER);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.wood plate.Sell Able") == true){
			mechanisms.add(Material.WOOD_PLATE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.stone plate.Sell Able") == true){
			mechanisms.add(Material.STONE_PLATE);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.note block.Sell Able") == true){
			mechanisms.add(Material.NOTE_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.detector rail.Sell Able") == true){
			mechanisms.add(Material.DETECTOR_RAIL);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.redstone torch off.Sell Able") == true){
			mechanisms.add(Material.REDSTONE_TORCH_OFF);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.powered rail.Sell Able") == true){
			mechanisms.add(Material.POWERED_RAIL);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.rails.Sell Able") == true){
			mechanisms.add(Material.RAILS);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.wood door.Sell Able") == true){
			mechanisms.add(Material.WOOD_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.iron door.Sell Able") == true){
			mechanisms.add(Material.IRON_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.dispenser.Sell Able") == true){
			mechanisms.add(Material.DISPENSER);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.stone button.Sell Able") == true){
			mechanisms.add(Material.STONE_BUTTON);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.trap door.Sell Able") == true){
			mechanisms.add(Material.TRAP_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Mechanisms.tnt.Sell Able") == true){
			mechanisms.add(Material.TNT);
		}
		//gardening
		if(Configuration.store.getBoolean("Store.Gardening.wood hoe.Sell Able") == true){
			gardening.add(Material.WOOD_HOE);
		}
		if(Configuration.store.getBoolean("Store.Gardening.bucket.Sell Able") == true){
			gardening.add(Material.BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Gardening.water bucket.Sell Able") == true){
			gardening.add(Material.WATER_BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Gardening.brown mushroom.Sell Able") == true){
			gardening.add(Material.BROWN_MUSHROOM);
		}
		if(Configuration.store.getBoolean("Store.Gardening.red mushroom.Sell Able") == true){
			gardening.add(Material.RED_MUSHROOM);
		}
		if(Configuration.store.getBoolean("Store.Gardening.red rose.Sell Able") == true){
			gardening.add(Material.RED_ROSE);
		}
		if(Configuration.store.getBoolean("Store.Gardening.yellow flower.Sell Able") == true){
			gardening.add(Material.YELLOW_FLOWER);
		}
		if(Configuration.store.getBoolean("Store.Gardening.cactus.Sell Able") == true){
			gardening.add(Material.CACTUS);
		}
		
		if(Configuration.store.getBoolean("Store.Gardening.sapling.Sell Able") == true){
			gardening.add(Material.SAPLING);
		}
		if(Configuration.store.getBoolean("Store.Gardening.seeds.Sell Able") == true){
			gardening.add(Material.SEEDS);
		}
		if(Configuration.store.getBoolean("Store.Gardening.sugar cane.Sell Able") == true){
			gardening.add(Material.SUGAR_CANE);
		}
		if(Configuration.store.getBoolean("Store.Gardening.wheat.Sell Able") == true){
			gardening.add(Material.WHEAT);
		}
		if(Configuration.store.getBoolean("Store.Gardening.melon seeds.Sell Able") == true){
			gardening.add(Material.MELON_SEEDS);
		}
		if(Configuration.store.getBoolean("Store.Gardening.melon block.Sell Able") == true){
			gardening.add(Material.MELON_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Gardening.pumpkin seeds.Sell Able") == true){
			gardening.add(Material.PUMPKIN_SEEDS);
		}
		if(Configuration.store.getBoolean("Store.Gardening.pumpkin.Sell Able") == true){
			gardening.add(Material.PUMPKIN);
		}
		if(Configuration.store.getBoolean("Store.Gardening.soil.Sell Able") == true){
			gardening.add(Material.SOIL);
		}
		if(Configuration.store.getBoolean("Store.Gardening.long grass.Sell Able") == true){
			gardening.add(Material.LONG_GRASS);
		}
		if(Configuration.store.getBoolean("Store.Gardening.dead bush.Sell Able") == true){
			gardening.add(Material.DEAD_BUSH);
		}
		if(Configuration.store.getBoolean("Store.Gardening.vine.Sell Able") == true){
			gardening.add(Material.VINE);
		}
		if(Configuration.store.getBoolean("Store.Gardening.water lily.Sell Able") == true){
			gardening.add(Material.WATER_LILY);
		}
		if(Configuration.store.getBoolean("Store.Gardening.nether warts.Sell Able") == true){
			gardening.add(Material.NETHER_WARTS);
		}
		
		//furniture
		if(Configuration.store.getBoolean("Store.Furniture.bed.Sell Able") == true){
			furniture.add(Material.BED);
		}
		if(Configuration.store.getBoolean("Store.Furniture.bookshelf.Sell Able") == true){
			furniture.add(Material.BOOKSHELF);
		}
		if(Configuration.store.getBoolean("Store.Furniture.brewing stand item.Sell Able") == true){
			furniture.add(Material.BREWING_STAND_ITEM);
		}
		if(Configuration.store.getBoolean("Store.Furniture.brick stairs.Sell Able") == true){
			furniture.add(Material.BRICK_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Furniture.cauldron item.Sell Able") == true){
			furniture.add(Material.CAULDRON_ITEM);
		}
		if(Configuration.store.getBoolean("Store.Furniture.workbench.Sell Able") == true){
			furniture.add(Material.WORKBENCH);
		}
		if(Configuration.store.getBoolean("Store.Furniture.chest.Sell Able") == true){
			furniture.add(Material.CHEST);
		}
		if(Configuration.store.getBoolean("Store.Furniture.cobblestone stairs.Sell Able") == true){
			furniture.add(Material.COBBLESTONE_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Furniture.dispenser.Sell Able") == true){
			furniture.add(Material.DISPENSER);
		}
		if(Configuration.store.getBoolean("Store.Furniture.enchantment table.Sell Able") == true){
			furniture.add(Material.ENCHANTMENT_TABLE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.fence.Sell Able") == true){
			furniture.add(Material.FENCE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.fence gate.Sell Able") == true){
			furniture.add(Material.FENCE_GATE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.furnace.Sell Able") == true){
			furniture.add(Material.FURNACE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.jukebox.Sell Able") == true){
			furniture.add(Material.JUKEBOX);
		}
		if(Configuration.store.getBoolean("Store.Furniture.jack o lantern.Sell Able") == true){
			furniture.add(Material.JACK_O_LANTERN);
		}
		if(Configuration.store.getBoolean("Store.Furniture.ladder.Sell Able") == true){
			furniture.add(Material.LADDER);
		}
		if(Configuration.store.getBoolean("Store.Furniture.nether brick stairs.Sell Able") == true){
			furniture.add(Material.NETHER_BRICK_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Furniture.nether fence.Sell Able") == true){
			furniture.add(Material.NETHER_FENCE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.note block.Sell Able") == true){
			furniture.add(Material.NOTE_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Furniture.painting.Sell Able") == true){
			furniture.add(Material.PAINTING);
		}
		if(Configuration.store.getBoolean("Store.Furniture.sign.Sell Able") == true){
			furniture.add(Material.SIGN);
		}
		if(Configuration.store.getBoolean("Store.Furniture.wood door.Sell Able") == true){
			furniture.add(Material.WOOD_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Furniture.iron door.Sell Able") == true){
			furniture.add(Material.IRON_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Furniture.torch.Sell Able") == true){
			furniture.add(Material.TORCH);
		}
		if(Configuration.store.getBoolean("Store.Furniture.trap door.Sell Able") == true){
			furniture.add(Material.TRAP_DOOR);
		}
		if(Configuration.store.getBoolean("Store.Furniture.wood stairs.Sell Able") == true){
			furniture.add(Material.WOOD_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Furniture.smooth stairs.Sell Able") == true){
			furniture.add(Material.SMOOTH_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Furniture.iron fence.Sell Able") == true){
			furniture.add(Material.IRON_FENCE);
		}
		if(Configuration.store.getBoolean("Store.Furniture.thin glass.Sell Able") == true){
			furniture.add(Material.THIN_GLASS);
		}
		
		//ores
		if(Configuration.store.getBoolean("Store.Ores.diamond ore.Sell Able") == true){
			ores.add(Material.DIAMOND_ORE);
		}
		if(Configuration.store.getBoolean("Store.Ores.gold ore.Sell Able") == true){
			ores.add(Material.GOLD_ORE);
		}
		if(Configuration.store.getBoolean("Store.Ores.iron ore.Sell Able") == true){
			ores.add(Material.IRON_ORE);
		}
		if(Configuration.store.getBoolean("Store.Ores.coal ore.Sell Able") == true){
			ores.add(Material.COAL_ORE);
		}
		if(Configuration.store.getBoolean("Store.Ores.lapis ore.Sell Able") == true){
			ores.add(Material.LAPIS_ORE);
		}
		if(Configuration.store.getBoolean("Store.Ores.redstone ore.Sell Able") == true){
			ores.add(Material.REDSTONE_ORE);
		}
		
		//minerals
		if(Configuration.store.getBoolean("Store.Minerals.lapis block.Sell Able") == true){
			minerals.add(Material.LAPIS_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Minerals.gold block.Sell Able") == true){
			minerals.add(Material.GOLD_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Minerals.iron block.Sell Able") == true){
			minerals.add(Material.IRON_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Minerals.diamond block.Sell Able") == true){
			minerals.add(Material.DIAMOND_BLOCK);
		}
		
		//materials
		if(Configuration.store.getBoolean("Store.Materials.stone.Sell Able") == true){
			materials.add(Material.STONE);
		}
		if(Configuration.store.getBoolean("Store.Materials.grass.Sell Able") == true){
			materials.add(Material.GRASS);
		}
		if(Configuration.store.getBoolean("Store.Materials.dirt.Sell Able") == true){
			materials.add(Material.DIRT);
		}
		if(Configuration.store.getBoolean("Store.Materials.cobblestone.Sell Able") == true){
			materials.add(Material.COBBLESTONE);
		}
		if(Configuration.store.getBoolean("Store.Materials.wood.Sell Able") == true){
			materials.add(Material.WOOD);
		}
		if(Configuration.store.getBoolean("Store.Materials.bedrock.Sell Able") == true){
			materials.add(Material.BEDROCK);
		}
		if(Configuration.store.getBoolean("Store.Materials.water.Sell Able") == true){
			materials.add(Material.WATER);
		}
		if(Configuration.store.getBoolean("Store.Materials.stationary water.Sell Able") == true){
			materials.add(Material.STATIONARY_WATER);
		}
		if(Configuration.store.getBoolean("Store.Materials.lava.Sell Able") == true){
			materials.add(Material.LAVA);
		}
		if(Configuration.store.getBoolean("Store.Materials.stationary lava.Sell Able") == true){
			materials.add(Material.STATIONARY_LAVA);
		}
		if(Configuration.store.getBoolean("Store.Materials.sand.Sell Able") == true){
			materials.add(Material.SAND);
		}
		if(Configuration.store.getBoolean("Store.Materials.gravel.Sell Able") == true){
			materials.add(Material.GRAVEL);
		}
		if(Configuration.store.getBoolean("Store.Materials.log.Sell Able") == true){
			materials.add(Material.LOG);
		}
		if(Configuration.store.getBoolean("Store.Materials.leaves.Sell Able") == true){
			materials.add(Material.LEAVES);
		}
		if(Configuration.store.getBoolean("Store.Materials.sponge.Sell Able") == true){
			materials.add(Material.SPONGE);
		}
		if(Configuration.store.getBoolean("Store.Materials.glass.Sell Able") == true){
			materials.add(Material.GLASS);
		}
		if(Configuration.store.getBoolean("Store.Materials.sandstone.Sell Able") == true){
			materials.add(Material.SANDSTONE);
		}
		if(Configuration.store.getBoolean("Store.Materials.double step.Sell Able") == true){
			materials.add(Material.DOUBLE_STEP);
		}
		if(Configuration.store.getBoolean("Store.Materials.step.Sell Able") == true){
			materials.add(Material.STEP);
		}
		if(Configuration.store.getBoolean("Store.Materials.brick.Sell Able") == true){
			materials.add(Material.BRICK);
		}
		if(Configuration.store.getBoolean("Store.Materials.mossy cobblestone.Sell Able") == true){
			materials.add(Material.MOSSY_COBBLESTONE);
		}
		if(Configuration.store.getBoolean("Store.Materials.obsidian.Sell Able") == true){
			materials.add(Material.OBSIDIAN);
		}
		if(Configuration.store.getBoolean("Store.Materials.snow.Sell Able") == true){
			materials.add(Material.SNOW);
		}
		if(Configuration.store.getBoolean("Store.Materials.ice.Sell Able") == true){
			materials.add(Material.ICE);
		}
		if(Configuration.store.getBoolean("Store.Materials.snow block.Sell Able") == true){
			materials.add(Material.SNOW_BLOCK);
		}
		if(Configuration.store.getBoolean("Store.Materials.clay.Sell Able") == true){
			materials.add(Material.CLAY);
		}
		if(Configuration.store.getBoolean("Store.Materials.smooth brick.Sell Able") == true){
			materials.add(Material.SMOOTH_BRICK);
		}
		if(Configuration.store.getBoolean("Store.Materials.mycel.Sell Able") == true){
			materials.add(Material.MYCEL);
		}
		if(Configuration.store.getBoolean("Store.Materials.enderstone.Sell Able") == true){
			materials.add(Material.ENDER_STONE);
		}
		
		//raw materials
		if(Configuration.store.getBoolean("Store.Raw Materials.coal.Sell Able") == true){
			rawmaterials.add(Material.COAL);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.iron ingot.Sell Able") == true){
			rawmaterials.add(Material.IRON_INGOT);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.gold ingot.Sell Able") == true){
			rawmaterials.add(Material.GOLD_INGOT);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.diamond.Sell Able") == true){
			rawmaterials.add(Material.DIAMOND);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.clay ball.Sell Able") == true){
			rawmaterials.add(Material.CLAY_BALL);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.clay brick.Sell Able") == true){
			rawmaterials.add(Material.CLAY_BRICK);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.glowstone dust.Sell Able") == true){
			rawmaterials.add(Material.GLOWSTONE_DUST);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.flint.Sell Able") == true){
			rawmaterials.add(Material.FLINT);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.paper.Sell Able") == true){
			rawmaterials.add(Material.PAPER);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.book.Sell Able") == true){
			rawmaterials.add(Material.BOOK);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.snow ball.Sell Able") == true){
			rawmaterials.add(Material.SNOW_BALL);
		}
		if(Configuration.store.getBoolean("Store.Raw Materials.sugar.Sell Able") == true){
			rawmaterials.add(Material.SUGAR);
		}
		
		//nether
		if(Configuration.store.getBoolean("Store.Nether.netherrack.Sell Able") == true){
			nether.add(Material.NETHERRACK);
		}
		if(Configuration.store.getBoolean("Store.Nether.nether brick.Sell Able") == true){
			nether.add(Material.NETHER_BRICK);
		}
		if(Configuration.store.getBoolean("Store.Nether.nether brick stairs.Sell Able") == true){
			nether.add(Material.NETHER_BRICK_STAIRS);
		}
		if(Configuration.store.getBoolean("Store.Nether.nether fence.Sell Able") == true){
			nether.add(Material.NETHER_FENCE);
		}
		if(Configuration.store.getBoolean("Store.Nether.nether stalk.Sell Able") == true){
			nether.add(Material.NETHER_STALK);
		}
		if(Configuration.store.getBoolean("Store.Nether.nether warts.Sell Able") == true){
			nether.add(Material.NETHER_WARTS);
		}
		if(Configuration.store.getBoolean("Store.Nether.blaze rod.Sell Able") == true){
			nether.add(Material.BLAZE_ROD);
		}
		if(Configuration.store.getBoolean("Store.Nether.ghast tear.Sell Able") == true){
			nether.add(Material.GHAST_TEAR);
		}
		if(Configuration.store.getBoolean("Store.Nether.gold nugget.Sell Able") == true){
			nether.add(Material.GOLD_NUGGET);
		}
		if(Configuration.store.getBoolean("Store.Nether.soul sand.Sell Able") == true){
			nether.add(Material.SOUL_SAND);
		}
		if(Configuration.store.getBoolean("Store.Nether.glowstone dust.Sell Able") == true){
			nether.add(Material.GLOWSTONE_DUST);
		}
		if(Configuration.store.getBoolean("Store.Nether.glowstone.Sell Able") == true){
			nether.add(Material.GLOWSTONE);
		}
		
		//painting
		if(Configuration.store.getBoolean("Store.Painting.wool.Sell Able") == true){
			painting.add(Material.WOOL);
		}
		if(Configuration.store.getBoolean("Store.Painting.ink sack.Sell Able") == true){
			painting.add(Material.INK_SACK);
		}
		
		//mobdrops
		if(Configuration.store.getBoolean("Store.Mob Drops.string.Sell Able") == true){
			mobdrops.add(Material.STRING);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.leather.Sell Able") == true){
			mobdrops.add(Material.LEATHER);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.feather.Sell Able") == true){
			mobdrops.add(Material.FEATHER);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.arrow.Sell Able") == true){
			mobdrops.add(Material.ARROW);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.egg.Sell Able") == true){
			mobdrops.add(Material.EGG);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.blaze rod.Sell Able") == true){
			mobdrops.add(Material.BLAZE_ROD);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.ghast tear.Sell Able") == true){
			mobdrops.add(Material.GHAST_TEAR);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.gold nugget.Sell Able") == true){
			mobdrops.add(Material.GOLD_NUGGET);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.rotten flesh.Sell Able") == true){
			mobdrops.add(Material.ROTTEN_FLESH);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.bone.Sell Able") == true){
			mobdrops.add(Material.BONE);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.sulphur.Sell Able") == true){
			mobdrops.add(Material.SULPHUR);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.spider eye.Sell Able") == true){
			mobdrops.add(Material.SPIDER_EYE);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.ender pearl.Sell Able") == true){
			mobdrops.add(Material.ENDER_PEARL);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.slime ball.Sell Able") == true){
			mobdrops.add(Material.SLIME_BALL);
		}
		if(Configuration.store.getBoolean("Store.Mob Drops.magma cream.Sell Able") == true){
			mobdrops.add(Material.MAGMA_CREAM);
		}
		
		//brewing
		if(Configuration.store.getBoolean("Store.Brewing.brewing stand item.Sell Able") == true){
			brewing.add(Material.BREWING_STAND_ITEM);
		}
		if(Configuration.store.getBoolean("Store.Brewing.cauldron item.Sell Able") == true){
			brewing.add(Material.CAULDRON_ITEM);
		}
		if(Configuration.store.getBoolean("Store.Brewing.water bucket.Sell Able") == true){
			brewing.add(Material.WATER_BUCKET);
		}
		if(Configuration.store.getBoolean("Store.Brewing.blaze powder.Sell Able") == true){
			brewing.add(Material.BLAZE_POWDER);
		}
		if(Configuration.store.getBoolean("Store.Brewing.nether warts.Sell Able") == true){
			brewing.add(Material.NETHER_WARTS);
		}
		//TODO potion data values!
		if(Configuration.store.getBoolean("Store.Brewing.potion.Sell Able") == true){
			brewing.add(Material.POTION);
		}
		if(Configuration.store.getBoolean("Store.Brewing.glass bottle.Sell Able") == true){
			brewing.add(Material.GLASS_BOTTLE);
		}
		if(Configuration.store.getBoolean("Store.Brewing.fermented spider eye.Sell Able") == true){
			brewing.add(Material.FERMENTED_SPIDER_EYE);
		}
		if(Configuration.store.getBoolean("Store.Brewing.magma cream.Sell Able") == true){
			brewing.add(Material.MAGMA_CREAM);
		}
		if(Configuration.store.getBoolean("Store.Brewing.glowstone dust.Sell Able") == true){
		brewing.add(Material.GLOWSTONE_DUST);
		}
		if(Configuration.store.getBoolean("Store.Brewing.redstone.Sell Able") == true){
		brewing.add(Material.REDSTONE);
		}
		if(Configuration.store.getBoolean("Store.Brewing.sugar.Sell Able") == true){
		brewing.add(Material.SUGAR);
		}
		if(Configuration.store.getBoolean("Store.Brewing.speckled melon.Sell Able") == true){
		brewing.add(Material.SPECKLED_MELON);
		}
		if(Configuration.store.getBoolean("Store.Brewing.ghast tear.Sell Able") == true){
			brewing.add(Material.GHAST_TEAR);
		}
		if(Configuration.store.getBoolean("Store.Brewing.sulphur.Sell Able") == true){
			brewing.add(Material.SULPHUR);
		}
		
		//music
		if(Configuration.store.getBoolean("Store.Music.jukebox.Sell Able") == true){
			music.add(Material.JUKEBOX);
		}
		if(Configuration.store.getBoolean("Store.Music.gold record.Sell Able") == true){
			music.add(Material.GOLD_RECORD);
		}
		if(Configuration.store.getBoolean("Store.Music.green record.Sell Able") == true){
			music.add(Material.GREEN_RECORD);
		}
		if(Configuration.store.getBoolean("Store.Music.record 3.Sell Able") == true){
			music.add(Material.RECORD_3);
		}
		if(Configuration.store.getBoolean("Store.Music.record 4.Sell Able") == true){
			music.add(Material.RECORD_4);
		}
		if(Configuration.store.getBoolean("Store.Music.record 5.Sell Able") == true){
			music.add(Material.RECORD_5);
		}
		if(Configuration.store.getBoolean("Store.Music.record 6.Sell Able") == true){
			music.add(Material.RECORD_6);
		}
		if(Configuration.store.getBoolean("Store.Music.record 7.Sell Able") == true){
			music.add(Material.RECORD_7);
		}
		if(Configuration.store.getBoolean("Store.Music.record 8.Sell Able") == true){
			music.add(Material.RECORD_8);
		}
		if(Configuration.store.getBoolean("Store.Music.record 9.Sell Able") == true){
			music.add(Material.RECORD_9);
		}
		if(Configuration.store.getBoolean("Store.Music.record 10.Sell Able") == true){
			music.add(Material.RECORD_10);
		}
		if(Configuration.store.getBoolean("Store.Music.record 11.Sell Able") == true){
			music.add(Material.RECORD_11);
		}
		
		//misc
		if(Configuration.store.getBoolean("Store.Miscellaneous.web.Sell Able") == true){
			misc.add(Material.WEB);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.fire.Sell Able") == true){
			misc.add(Material.FIRE);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.portal.Sell Able") == true){
			misc.add(Material.PORTAL);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.ender portal frame.Sell Able") == true){
			misc.add(Material.ENDER_PORTAL_FRAME);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.dragon egg.Sell Able") == true){
			misc.add(Material.DRAGON_EGG);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.monster egg.Sell Able") == true){
			//TODO monster EGG data values!
			misc.add(Material.MONSTER_EGG);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.monster eggs.Sell Able") == true){
			misc.add(Material.MONSTER_EGGS);
		}
		if(Configuration.store.getBoolean("Store.Miscellaneous.mob spawner.Sell Able") == true){
			//TODO mob spawner data values!
			misc.add(Material.MOB_SPAWNER);
		}
	}
	
}
