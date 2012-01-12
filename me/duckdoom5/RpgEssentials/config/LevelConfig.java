package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class LevelConfig {
	public static RpgEssentials plugin;
	YamlConfiguration levelconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public LevelConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setlevelconfig(){
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating level config...");
		}
		//general
		if(!levelconfig.contains("Survival Gamemode Required")){
			levelconfig.set("Survival Gamemode Required",true);
		}
		//mining
		if(!levelconfig.contains("Exp.Mining.Stone")){
			levelconfig.set("Exp.Mining.Stone",10);
		}
		if(!levelconfig.contains("Exp.Mining.Cobblestone")){
			levelconfig.set("Exp.Mining.Cobblestone",15);
		}
		if(!levelconfig.contains("Exp.Mining.Mossy Cobblestone")){
			levelconfig.set("Exp.Mining.Mossy Cobblestone",20);
		}
		if(!levelconfig.contains("Exp.Mining.Coal Ore")){
			levelconfig.set("Exp.Mining.Coal Ore",15);
		}
		if(!levelconfig.contains("Exp.Mining.Iron Ore")){
			levelconfig.set("Exp.Mining.Iron Ore",20);
		}
		if(!levelconfig.contains("Exp.Mining.Gold Ore")){
			levelconfig.set("Exp.Mining.Gold Ore",25);
		}
		if(!levelconfig.contains("Exp.Mining.Lapis Ore")){
			levelconfig.set("Exp.Mining.Lapis Ore",25);
		}
		if(!levelconfig.contains("Exp.Mining.Redstone Ore")){
			levelconfig.set("Exp.Mining.Redstone Ore",20);
		}
		if(!levelconfig.contains("Exp.Mining.Diamond Ore")){
			levelconfig.set("Exp.Mining.Diamond Ore",40);
		}
		if(!levelconfig.contains("Exp.Mining.Sandstone")){
			levelconfig.set("Exp.Mining.Sandstone",10);
		}
		if(!levelconfig.contains("Exp.Mining.Obsidian")){
			levelconfig.set("Exp.Mining.Obsidian",50);
		}
		if(!levelconfig.contains("Exp.Mining.Lapis Block")){
			levelconfig.set("Exp.Mining.Lapis Block",25);
		}
		if(!levelconfig.contains("Exp.Mining.Iron Block")){
			levelconfig.set("Exp.Mining.Iron Block",25);
		}
		if(!levelconfig.contains("Exp.Mining.Gold Block")){
			levelconfig.set("Exp.Mining.Gold Block",25);
		}
		if(!levelconfig.contains("Exp.Mining.Diamond Block")){
			levelconfig.set("Exp.Mining.Diamond Block",30);
		}
		if(!levelconfig.contains("Exp.Mining.Stone Slab")){
			levelconfig.set("Exp.Mining.Stone Slab",10);
		}
		if(!levelconfig.contains("Exp.Mining.Sandstone Slab")){
			levelconfig.set("Exp.Mining.Sandstone Slab",10);
		}
		if(!levelconfig.contains("Exp.Mining.Cobblestone Slab")){
			levelconfig.set("Exp.Mining.Cobblestone Slab",10);
		}
		if(!levelconfig.contains("Exp.Mining.Brick Slab")){
			levelconfig.set("Exp.Mining.Brick Slab",15);
		}
		if(!levelconfig.contains("Exp.Mining.Stone Brick Slab")){
			levelconfig.set("Exp.Mining.Stone Brick Slab",15);
		}
		if(!levelconfig.contains("Exp.Mining.Bricks")){
			levelconfig.set("Exp.Mining.Bricks",20);
		}
		if(!levelconfig.contains("Exp.Mining.Brick Stairs")){
			levelconfig.set("Exp.Mining.Brick Stairs",25);
		}
		if(!levelconfig.contains("Exp.Mining.Stone Brick Stairs")){
			levelconfig.set("Exp.Mining.Stone Brick Stairs",25);
		}
		if(!levelconfig.contains("Exp.Mining.Cobblestone Stairs")){
			levelconfig.set("Exp.Mining.Cobblestone Stairs",20);
		}
		if(!levelconfig.contains("Exp.Mining.Stone Brick")){
			levelconfig.set("Exp.Mining.Stone Brick",20);
		}
		if(!levelconfig.contains("Exp.Mining.Mossy Stone Brick")){
			levelconfig.set("Exp.Mining.Mossy Stone Brick",25);
		}
		if(!levelconfig.contains("Exp.Mining.Cracked Stone Brick")){
			levelconfig.set("Exp.Mining.Cracked Stone Brick",25);
		}
		if(!levelconfig.contains("Exp.Mining.Netherrack")){
			levelconfig.set("Exp.Mining.Netherrack",15);
		}
		if(!levelconfig.contains("Exp.Mining.Glowstone")){
			levelconfig.set("Exp.Mining.Glowstone",20);
		}
		if(!levelconfig.contains("Exp.Mining.Nether Brick")){
			levelconfig.set("Exp.Mining.Nether Brick",20);
		}
		if(!levelconfig.contains("Exp.Mining.Nether Brick Stairs")){
			levelconfig.set("Exp.Mining.Nether Brick Stairs",25);
		}
		if(!levelconfig.contains("Exp.Mining.End Stone")){
			levelconfig.set("Exp.Mining.End Stone",10);
		}
		//woodcutting
		if(!levelconfig.contains("Exp.Woodcutting.Oak Log")){
			levelconfig.set("Exp.Woodcutting.Oak Log",20);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Redwood Log")){
			levelconfig.set("Exp.Woodcutting.Redwood Log",30);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Birch Log")){
			levelconfig.set("Exp.Woodcutting.Brich Log",30);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Wood")){
			levelconfig.set("Exp.Woodcutting.Wood",10);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Wood Slab")){
			levelconfig.set("Exp.Woodcutting.Wood Slab",15);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Wood Stairs")){
			levelconfig.set("Exp.Woodcutting.Wood Stairs",20);
		}
		if(!levelconfig.contains("Exp.Woodcutting.Fence")){
			levelconfig.set("Exp.Woodcutting.Fence",15);
		}
		
		//excavation
		if(!levelconfig.contains("Exp.Excavation.Dirt")){
			levelconfig.set("Exp.Excavation.Dirt",5);
		}
		if(!levelconfig.contains("Exp.Excavation.Grass")){
			levelconfig.set("Exp.Excavation.Grass",5);
		}
		if(!levelconfig.contains("Exp.Excavation.Sand")){
			levelconfig.set("Exp.Excavation.Sand",10);
		}
		if(!levelconfig.contains("Exp.Excavation.Clay")){
			levelconfig.set("Exp.Excavation.Clay",15);
		}
		if(!levelconfig.contains("Exp.Excavation.Soil")){
			levelconfig.set("Exp.Excavation.Soil",10);
		}
		if(!levelconfig.contains("Exp.Excavation.Soul Sand")){
			levelconfig.set("Exp.Excavation.Soul Sand",10);
		}
		if(!levelconfig.contains("Exp.Excavation.Snow Block")){
			levelconfig.set("Exp.Excavation.Snow Block",10);
		}
		
		//farming break
		if(!levelconfig.contains("Exp.Farming.Yellow Flower.Break")){
			levelconfig.set("Exp.Farming.Yellow Flower.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Rose.Break")){
			levelconfig.set("Exp.Farming.Rose.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Pumpkin Block.Break")){
			levelconfig.set("Exp.Farming.Pumpkin Block.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Pumpkin Stem.Break")){
			levelconfig.set("Exp.Farming.Pumpkin Stem.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Melon Block.Break")){
			levelconfig.set("Exp.Farming.Melon Block.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Melon Stem.Break")){
			levelconfig.set("Exp.Farming.Melon Stem.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Red Mushroom.Break")){
			levelconfig.set("Exp.Farming.Red Mushroom.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Brown Mushroom.Break")){
			levelconfig.set("Exp.Farming.Brown Mushroom.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Huge Red Mushroom.Break")){
			levelconfig.set("Exp.Farming.Huge Red Mushroom.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Huge Brown Mushroom.Break")){
			levelconfig.set("Exp.Farming.Huge Brown Mushroom.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Tall Grass.Break")){
			levelconfig.set("Exp.Farming.Tall Grass.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Wheat.Break")){
			levelconfig.set("Exp.Farming.Wheat.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Cacti.Break")){
			levelconfig.set("Exp.Farming.Cacti.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Sugar Cane.Break")){
			levelconfig.set("Exp.Farming.Sugar Cane.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Vines.Break")){
			levelconfig.set("Exp.Farming.Vines.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Water Lily.Break")){
			levelconfig.set("Exp.Farming.Water Lily.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Leaves.Break")){
			levelconfig.set("Exp.Farming.Leaves.Break",10);
		}
		if(!levelconfig.contains("Exp.Farming.Dead Bush.Break")){
			levelconfig.set("Exp.Farming.Dead Bush.Break",10);
		}
		//farming place
		if(!levelconfig.contains("Exp.Farming.Yellow Flower.Place")){
			levelconfig.set("Exp.Farming.Yellow Flower.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Rose.Place")){
			levelconfig.set("Exp.Farming.Rose.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Pumpkin Block.Place")){
			levelconfig.set("Exp.Farming.Pumpkin Block.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Pumpkin Stem.Place")){
			levelconfig.set("Exp.Farming.Pumpkin Stem.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Melon Block.Place")){
			levelconfig.set("Exp.Farming.Melon Block.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Melon Stem.Place")){
			levelconfig.set("Exp.Farming.Melon Stem.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Red Mushroom.Place")){
			levelconfig.set("Exp.Farming.Red Mushroom.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Brown Mushroom.Place")){
			levelconfig.set("Exp.Farming.Brown Mushroom.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Huge Red Mushroom.Place")){
			levelconfig.set("Exp.Farming.Huge Red Mushroom.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Huge Brown Mushroom.Place")){
			levelconfig.set("Exp.Farming.Huge Brown Mushroom.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Tall Grass.Place")){
			levelconfig.set("Exp.Farming.Tall Grass.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Wheat.Place")){
			levelconfig.set("Exp.Farming.Wheat.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Cacti.Place")){
			levelconfig.set("Exp.Farming.Cacti.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Sugar Cane.Place")){
			levelconfig.set("Exp.Farming.Sugar Cane.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Vines.Place")){
			levelconfig.set("Exp.Farming.Vines.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Water Lily.Place")){
			levelconfig.set("Exp.Farming.Water Lily.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Leaves.Place")){
			levelconfig.set("Exp.Farming.Leaves.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Dead Bush.Place")){
			levelconfig.set("Exp.Farming.Dead Bush.Place",10);
		}
		if(!levelconfig.contains("Exp.Farming.Soil.Create")){
			levelconfig.set("Exp.Farming.Soil.Create",10);
		}
		//attack
		if(!levelconfig.contains("Exp.Attack.Creeper")){
			levelconfig.set("Exp.Attack.Creeper",20);
		}
		if(!levelconfig.contains("Exp.Attack.Zombie")){
			levelconfig.set("Exp.Attack.Zombie",10);
		}
		if(!levelconfig.contains("Exp.Attack.Pig Zombie")){
			levelconfig.set("Exp.Attack.Pig Zombie",10);
		}
		if(!levelconfig.contains("Exp.Attack.Skeleton")){
			levelconfig.set("Exp.Attack.Skeleton",15);
		}
		if(!levelconfig.contains("Exp.Attack.Enderman")){
			levelconfig.set("Exp.Attack.Enderman",15);
		}
		if(!levelconfig.contains("Exp.Attack.Ender Dragon")){
			levelconfig.set("Exp.Attack.Ender Dragon",50);
		}
		if(!levelconfig.contains("Exp.Attack.Ghast")){
			levelconfig.set("Exp.Attack.Ghast",30);
		}
		if(!levelconfig.contains("Exp.Attack.Blaze")){
			levelconfig.set("Exp.Attack.Blaze",25);
		}
		if(!levelconfig.contains("Exp.Attack.Slime")){
			levelconfig.set("Exp.Attack.Slime",10);
		}
		if(!levelconfig.contains("Exp.Attack.Magma Cube")){
			levelconfig.set("Exp.Attack.Magma Cube",15);
		}
		if(!levelconfig.contains("Exp.Attack.Spider")){
			levelconfig.set("Exp.Attack.Spider",10);
		}
		if(!levelconfig.contains("Exp.Attack.Cave Spider")){
			levelconfig.set("Exp.Attack.Cave Spider",15);
		}
		if(!levelconfig.contains("Exp.Attack.Silverfish")){
			levelconfig.set("Exp.Attack.Silverfish",10);
		}
		if(!levelconfig.contains("Exp.Attack.Giant")){
			levelconfig.set("Exp.Attack.Giant",40);
		}
		
		if(!levelconfig.contains("Exp.Attack.Pig")){
			levelconfig.set("Exp.Attack.Pig",10);
		}
		if(!levelconfig.contains("Exp.Attack.Chicken")){
			levelconfig.set("Exp.Attack.Chicken",5);
		}
		if(!levelconfig.contains("Exp.Attack.Villager")){
			levelconfig.set("Exp.Attack.Villager",15);
		}
		if(!levelconfig.contains("Exp.Attack.Sheep")){
			levelconfig.set("Exp.Attack.Sheep",10);
		}
		if(!levelconfig.contains("Exp.Attack.Cow")){
			levelconfig.set("Exp.Attack.Cow",10);
		}
		if(!levelconfig.contains("Exp.Attack.Mooshroom")){
			levelconfig.set("Exp.Attack.Mooshroom",15);
		}
		if(!levelconfig.contains("Exp.Attack.Squid")){
			levelconfig.set("Exp.Attack.Squid",10);
		}
		if(!levelconfig.contains("Exp.Attack.Wolf")){
			levelconfig.set("Exp.Attack.Wolf",10);
		}
		if(!levelconfig.contains("Exp.Attack.Snow Golem")){
			levelconfig.set("Exp.Attack.Snow Golem",10);
		}
		if(!levelconfig.contains("Exp.Attack.Player")){
			levelconfig.set("Exp.Attack.Player",10);
		}
		//defence
		if(!levelconfig.contains("Exp.Defence.Entity Attack")){
			levelconfig.set("Exp.Defence.Entity Attack",20);
		}
		if(!levelconfig.contains("Exp.Defence.Block Explosion")){
			levelconfig.set("Exp.Defence.Block Explosion",15);
		}
		if(!levelconfig.contains("Exp.Defence.Entity Explosion")){
			levelconfig.set("Exp.Defence.Entity Explosion",15);
		}
		if(!levelconfig.contains("Exp.Defence.Projectile")){
			levelconfig.set("Exp.Defence.Projectile",20);
		}
		//cooking
		if(!levelconfig.contains("Exp.Cooking.Golden Apple")){
			levelconfig.set("Exp.Cooking.Golden Apple",40);
		}
		if(!levelconfig.contains("Exp.Cooking.Bread")){
			levelconfig.set("Exp.Cooking.Bread",10);
		}
		if(!levelconfig.contains("Exp.Cooking.Mushroom Soup")){
			levelconfig.set("Exp.Cooking.Mushroom Soup",20);
		}
		if(!levelconfig.contains("Exp.Cooking.Cake")){
			levelconfig.set("Exp.Cooking.Cake",30);
		}
		//ranged
		if(!levelconfig.contains("Exp.Ranged.Arrow Shoot")){
			levelconfig.set("Exp.Ranged.Arrow Shoot",20);
		}
		//firemaking
		if(!levelconfig.contains("Exp.Firemaking.Ignite")){
			levelconfig.set("Exp.Firemaking.Ignite",20);
		}
		//smithing
		if(!levelconfig.contains("Exp.Smithing.Wood Axe")){
			levelconfig.set("Exp.Smithing.Wood Axe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Wood Pickaxe")){
			levelconfig.set("Exp.Smithing.Wood Pickaxe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Wood Spade")){
			levelconfig.set("Exp.Smithing.Wood Spade",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Wood Sword")){
			levelconfig.set("Exp.Smithing.Wood Sword",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Wood Hoe")){
			levelconfig.set("Exp.Smithing.Wood Hoe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Stone Axe")){
			levelconfig.set("Exp.Smithing.Stone Axe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Stone Pickaxe")){
			levelconfig.set("Exp.Smithing.Stone Pickaxe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Stone Spade")){
			levelconfig.set("Exp.Smithing.Stone Spade",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Stone Sword")){
			levelconfig.set("Exp.Smithing.Stone Sword",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Stone Hoe")){
			levelconfig.set("Exp.Smithing.Stone Hoe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Iron Axe")){
			levelconfig.set("Exp.Smithing.Iron Axe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Iron Pickaxe")){
			levelconfig.set("Exp.Smithing.Iron Pickaxe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Iron Spade")){
			levelconfig.set("Exp.Smithing.Iron Spade",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Iron Sword")){
			levelconfig.set("Exp.Smithing.Iron Sword",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Iron Hoe")){
			levelconfig.set("Exp.Smithing.Iron Hoe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Gold Axe")){
			levelconfig.set("Exp.Smithing.Gold Axe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Gold Pickaxe")){
			levelconfig.set("Exp.Smithing.Gold Pickaxe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Gold Spade")){
			levelconfig.set("Exp.Smithing.Gold Spade",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Gold Sword")){
			levelconfig.set("Exp.Smithing.Gold Sword",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Gold Hoe")){
			levelconfig.set("Exp.Smithing.Gold Hoe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Diamond Axe")){
			levelconfig.set("Exp.Smithing.Diamond Axe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Diamond Pickaxe")){
			levelconfig.set("Exp.Smithing.Diamond Pickaxe",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Diamond Spade")){
			levelconfig.set("Exp.Smithing.Diamond Spade",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Diamond Sword")){
			levelconfig.set("Exp.Smithing.Diamond Sword",20);
		}
		if(!levelconfig.contains("Exp.Smithing.Diamond Hoe")){
			levelconfig.set("Exp.Smithing.Diamond Hoe",20);
		}
		
		//Construction
		if(!levelconfig.contains("Exp.Construction.wood")){
			levelconfig.set("Exp.Construction.wood",10);
		}
		try {
			levelconfig.save("plugins/RpgEssentials/Leveling.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
