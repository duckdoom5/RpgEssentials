package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

public class LevelConfig {

	public static void set(){
		//general
		if(!Configuration.level.contains("Survival Gamemode Required")){
			Configuration.level.set("Survival Gamemode Required",true);
		}
		if(!Configuration.level.contains("Disable place cheat")){
			Configuration.level.set("Disable place cheat",true);
		}
		if(!Configuration.level.contains("Disable block break for low level")){
			Configuration.level.set("Disable block break for low level",true);
		}
		if(!Configuration.level.contains("Disable tool use for low level")){
			Configuration.level.set("Disable tool use for low level",true);
		}
		if(!Configuration.level.contains("Disable block break on damage event")){
			Configuration.level.set("Disable block break on damage event", false);
		}
		if(!Configuration.level.contains("Level exponent")){
			Configuration.level.set("Level exponent", 7.5);
		}
		if(!Configuration.level.contains("combat level-up sound")){
			Configuration.level.set("combat level-up sound", "http://dl.lynxdragon.com/rpgessentials/music/levelup.wav");
		}
		if(!Configuration.level.contains("level-up sound")){
			Configuration.level.set("level-up sound", "http://dl.lynxdragon.com/rpgessentials/music/levelup.wav");
		}
		if(!Configuration.level.contains("level-up material")){
			Configuration.level.set("level-up material", 354);
		}
		if(!Configuration.level.contains("combat level-up material")){
			Configuration.level.set("combat level-up material", 276);
		}
		for(Skill skill: Skill.values()){
			if(!Configuration.level.contains("Enabled." + skill.toString())){
				Configuration.level.set("Enabled." + skill.toString(), true);
			}
		}
		
		//unlock level
		
		//Armour
		if(!Configuration.level.contains("UnlockLevel.leather helmet")){
			Configuration.level.set("UnlockLevel.leather helmet",1);
		}
		if(!Configuration.level.contains("UnlockLevel.leather chestplate")){
			Configuration.level.set("UnlockLevel.leather chestplate",10);
		}
		if(!Configuration.level.contains("UnlockLevel.leather leggings")){
			Configuration.level.set("UnlockLevel.leather leggings",5);
		}
		if(!Configuration.level.contains("UnlockLevel.leather boots")){
			Configuration.level.set("UnlockLevel.leather boots",1);
		}
		if(!Configuration.level.contains("UnlockLevel.gold helmet")){
			Configuration.level.set("UnlockLevel.gold helmet",5);
		}
		if(!Configuration.level.contains("UnlockLevel.gold chestplate")){
			Configuration.level.set("UnlockLevel.gold chestplate",15);
		}
		if(!Configuration.level.contains("UnlockLevel.gold leggings")){
			Configuration.level.set("UnlockLevel.gold leggings",10);
		}
		if(!Configuration.level.contains("UnlockLevel.gold boots")){
			Configuration.level.set("UnlockLevel.gold boots",5);
		}
		if(!Configuration.level.contains("UnlockLevel.chainmail helmet")){
			Configuration.level.set("UnlockLevel.chainmail helmet",10);
		}
		if(!Configuration.level.contains("UnlockLevel.chainmail chestplate")){
			Configuration.level.set("UnlockLevel.chainmail chestplate",20);
		}
		if(!Configuration.level.contains("UnlockLevel.chainmail leggings")){
			Configuration.level.set("UnlockLevel.chainmail leggings",15);
		}
		if(!Configuration.level.contains("UnlockLevel.chainmail boots")){
			Configuration.level.set("UnlockLevel.chainmail boots",10);
		}
		if(!Configuration.level.contains("UnlockLevel.iron helmet")){
			Configuration.level.set("UnlockLevel.iron helmet",25);
		}
		if(!Configuration.level.contains("UnlockLevel.iron chestplate")){
			Configuration.level.set("UnlockLevel.iron chestplate",35);
		}
		if(!Configuration.level.contains("UnlockLevel.iron leggings")){
			Configuration.level.set("UnlockLevel.iron leggings",30);
		}
		if(!Configuration.level.contains("UnlockLevel.iron boots")){
			Configuration.level.set("UnlockLevel.iron boots",25);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond helmet")){
			Configuration.level.set("UnlockLevel.diamond helmet",40);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond chestplate")){
			Configuration.level.set("UnlockLevel.diamond chestplate",60);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond leggings")){
			Configuration.level.set("UnlockLevel.diamond leggings",50);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond boots")){
			Configuration.level.set("UnlockLevel.diamond boots",40);
		}
		
		//ores
		if(!Configuration.level.contains("UnlockLevel.coal ore")){
			Configuration.level.set("UnlockLevel.coal ore",5);
		}
		if(!Configuration.level.contains("UnlockLevel.iron ore")){
			Configuration.level.set("UnlockLevel.iron ore",8);
		}
		if(!Configuration.level.contains("UnlockLevel.gold ore")){
			Configuration.level.set("UnlockLevel.gold ore",15);
		}
		if(!Configuration.level.contains("UnlockLevel.lapis ore")){
			Configuration.level.set("UnlockLevel.lapis ore",16);
		}
		if(!Configuration.level.contains("UnlockLevel.redstone ore")){
			Configuration.level.set("UnlockLevel.redstone ore",20);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond ore")){
			Configuration.level.set("UnlockLevel.diamond ore",25);
		}
		
		//tools
		if(!Configuration.level.contains("UnlockLevel.wood pickaxe")){
			Configuration.level.set("UnlockLevel.wood pickaxe",1);
		}
		if(!Configuration.level.contains("UnlockLevel.stone pickaxe")){
			Configuration.level.set("UnlockLevel.stone pickaxe",5);
		}
		if(!Configuration.level.contains("UnlockLevel.iron pickaxe")){
			Configuration.level.set("UnlockLevel.iron pickaxe",15);
		}
		if(!Configuration.level.contains("UnlockLevel.gold pickaxe")){
			Configuration.level.set("UnlockLevel.gold pickaxe",25);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond pickaxe")){
			Configuration.level.set("UnlockLevel.diamond pickaxe",50);
		}
		if(!Configuration.level.contains("UnlockLevel.wood axe")){
			Configuration.level.set("UnlockLevel.wood axe",1);
		}
		if(!Configuration.level.contains("UnlockLevel.stone axe")){
			Configuration.level.set("UnlockLevel.stone axe",5);
		}
		if(!Configuration.level.contains("UnlockLevel.iron axe")){
			Configuration.level.set("UnlockLevel.iron axe",15);
		}
		if(!Configuration.level.contains("UnlockLevel.gold axe")){
			Configuration.level.set("UnlockLevel.gold axe",25);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond axe")){
			Configuration.level.set("UnlockLevel.diamond axe",50);
		}
		if(!Configuration.level.contains("UnlockLevel.wood hoe")){
			Configuration.level.set("UnlockLevel.wood hoe",1);
		}
		if(!Configuration.level.contains("UnlockLevel.stone hoe")){
			Configuration.level.set("UnlockLevel.stone hoe",5);
		}
		if(!Configuration.level.contains("UnlockLevel.iron hoe")){
			Configuration.level.set("UnlockLevel.iron hoe",15);
		}
		if(!Configuration.level.contains("UnlockLevel.gold hoe")){
			Configuration.level.set("UnlockLevel.gold hoe",25);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond hoe")){
			Configuration.level.set("UnlockLevel.diamond hoe",50);
		}
		if(!Configuration.level.contains("UnlockLevel.wood sword")){
			Configuration.level.set("UnlockLevel.wood sword",1);
		}
		if(!Configuration.level.contains("UnlockLevel.stone sword")){
			Configuration.level.set("UnlockLevel.stone sword",10);
		}
		if(!Configuration.level.contains("UnlockLevel.iron sword")){
			Configuration.level.set("UnlockLevel.iron sword",20);
		}
		if(!Configuration.level.contains("UnlockLevel.gold sword")){
			Configuration.level.set("UnlockLevel.gold sword",40);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond sword")){
			Configuration.level.set("UnlockLevel.diamond sword",60);
		}
		if(!Configuration.level.contains("UnlockLevel.wood spade")){
			Configuration.level.set("UnlockLevel.wood spade",1);
		}
		if(!Configuration.level.contains("UnlockLevel.stone spade")){
			Configuration.level.set("UnlockLevel.stone spade",5);
		}
		if(!Configuration.level.contains("UnlockLevel.iron spade")){
			Configuration.level.set("UnlockLevel.iron spade",15);
		}
		if(!Configuration.level.contains("UnlockLevel.gold spade")){
			Configuration.level.set("UnlockLevel.gold spade",25);
		}
		if(!Configuration.level.contains("UnlockLevel.diamond spade")){
			Configuration.level.set("UnlockLevel.diamond spade",50);
		}
		
		//exp
		//mining
		if(!Configuration.level.contains("Exp.Mining.stone")){
			Configuration.level.set("Exp.Mining.stone",5);
		}
		if(!Configuration.level.contains("Exp.Mining.cobblestone")){
			Configuration.level.set("Exp.Mining.cobblestone",2);
		}
		if(!Configuration.level.contains("Exp.Mining.mossy cobblestone")){
			Configuration.level.set("Exp.Mining.mossy cobblestone",8);
		}
		if(!Configuration.level.contains("Exp.Mining.coal ore")){
			Configuration.level.set("Exp.Mining.coal ore",10);
		}
		if(!Configuration.level.contains("Exp.Mining.iron ore")){
			Configuration.level.set("Exp.Mining.iron ore",15);
		}
		if(!Configuration.level.contains("Exp.Mining.gold ore")){
			Configuration.level.set("Exp.Mining.gold ore",20);
		}
		if(!Configuration.level.contains("Exp.Mining.lapis ore")){
			Configuration.level.set("Exp.Mining.lapis ore",25);
		}
		if(!Configuration.level.contains("Exp.Mining.redstone ore")){
			Configuration.level.set("Exp.Mining.redstone ore",20);
		}
		if(!Configuration.level.contains("Exp.Mining.glowing redstone ore")){
			Configuration.level.set("Exp.Mining.glowing redstone ore",20);
		}
		if(!Configuration.level.contains("Exp.Mining.diamond ore")){
			Configuration.level.set("Exp.Mining.diamond ore",40);
		}
		if(!Configuration.level.contains("Exp.Mining.sandstone")){
			Configuration.level.set("Exp.Mining.sandstone",5);
		}
		if(!Configuration.level.contains("Exp.Mining.obsidian")){
			Configuration.level.set("Exp.Mining.obsidian",50);
		}
		if(!Configuration.level.contains("Exp.Mining.lapis block")){
			Configuration.level.set("Exp.Mining.lapis block",5);
		}
		if(!Configuration.level.contains("Exp.Mining.iron block")){
			Configuration.level.set("Exp.Mining.iron block",5);
		}
		if(!Configuration.level.contains("Exp.Mining.gold block")){
			Configuration.level.set("Exp.Mining.gold block",5);
		}
		if(!Configuration.level.contains("Exp.Mining.diamond block")){
			Configuration.level.set("Exp.Mining.diamond block",10);
		}
		if(!Configuration.level.contains("Exp.Mining.stone step")){
			Configuration.level.set("Exp.Mining.stone step",5);
		}
		if(!Configuration.level.contains("Exp.Mining.sandstone step")){
			Configuration.level.set("Exp.Mining.sandstone step",5);
		}
		if(!Configuration.level.contains("Exp.Mining.cobblestone step")){
			Configuration.level.set("Exp.Mining.cobblestone step",5);
		}
		if(!Configuration.level.contains("Exp.Mining.brick step")){
			Configuration.level.set("Exp.Mining.brick step",5);
		}
		if(!Configuration.level.contains("Exp.Mining.smooth step")){
			Configuration.level.set("Exp.Mining.smooth step",5);
		}
		if(!Configuration.level.contains("Exp.Mining.bricks")){
			Configuration.level.set("Exp.Mining.bricks",10);
		}
		if(!Configuration.level.contains("Exp.Mining.brick stairs")){
			Configuration.level.set("Exp.Mining.brick stairs",10);
		}
		if(!Configuration.level.contains("Exp.Mining.smooth stairs")){
			Configuration.level.set("Exp.Mining.smooth stairs",10);
		}
		if(!Configuration.level.contains("Exp.Mining.cobblestone stairs")){
			Configuration.level.set("Exp.Mining.cobblestone stairs",10);
		}
		if(!Configuration.level.contains("Exp.Mining.smooth brick")){
			Configuration.level.set("Exp.Mining.smooth brick",10);
		}
		if(!Configuration.level.contains("Exp.Mining.mossy smooth brick")){
			Configuration.level.set("Exp.Mining.mossy smooth brick",10);
		}
		if(!Configuration.level.contains("Exp.Mining.cracked smooth brick")){
			Configuration.level.set("Exp.Mining.cracked smooth brick",10);
		}
		if(!Configuration.level.contains("Exp.Mining.netherrack")){
			Configuration.level.set("Exp.Mining.netherrack",5);
		}
		if(!Configuration.level.contains("Exp.Mining.glowstone")){
			Configuration.level.set("Exp.Mining.glowstone",10);
		}
		if(!Configuration.level.contains("Exp.Mining.nether brick")){
			Configuration.level.set("Exp.Mining.nether brick",10);
		}
		if(!Configuration.level.contains("Exp.Mining.nether brick stairs")){
			Configuration.level.set("Exp.Mining.nether brick stairs",10);
		}
		if(!Configuration.level.contains("Exp.Mining.end stone")){
			Configuration.level.set("Exp.Mining.end stone",10);
		}
		//woodcutting
		if(!Configuration.level.contains("Exp.Woodcutting.oak log")){
			Configuration.level.set("Exp.Woodcutting.oak log",10);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.pine log")){
			Configuration.level.set("Exp.Woodcutting.pine log",20);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.birch log")){
			Configuration.level.set("Exp.Woodcutting.brich log",20);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.jungle log")){
			Configuration.level.set("Exp.Woodcutting.jungle log",30);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.oak wood")){
			Configuration.level.set("Exp.Woodcutting.oak wood",5);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.pine wood")){
			Configuration.level.set("Exp.Woodcutting.pine wood",10);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.birch wood")){
			Configuration.level.set("Exp.Woodcutting.brich wood",10);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.jungle wood")){
			Configuration.level.set("Exp.Woodcutting.jungle wood",15);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.wood step")){
			Configuration.level.set("Exp.Woodcutting.wood step",5);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.wood double step")){
			Configuration.level.set("Exp.Woodcutting.Wood double step",10);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.wood stairs")){
			Configuration.level.set("Exp.Woodcutting.wood stairs",10);
		}
		if(!Configuration.level.contains("Exp.Woodcutting.fence")){
			Configuration.level.set("Exp.Woodcutting.fence",5);
		}
		
		//excavation
		if(!Configuration.level.contains("Exp.Excavation.dirt")){
			Configuration.level.set("Exp.Excavation.dirt",2);
		}
		if(!Configuration.level.contains("Exp.Excavation.grass")){
			Configuration.level.set("Exp.Excavation.grass",2);
		}
		if(!Configuration.level.contains("Exp.Excavation.sand")){
			Configuration.level.set("Exp.Excavation.sand",5);
		}
		if(!Configuration.level.contains("Exp.Excavation.gravel")){
			Configuration.level.set("Exp.Excavation.gravel",5);
		}
		if(!Configuration.level.contains("Exp.Excavation.clay")){
			Configuration.level.set("Exp.Excavation.clay",10);
		}
		if(!Configuration.level.contains("Exp.Excavation.soil")){
			Configuration.level.set("Exp.Excavation.soil",2);
		}
		if(!Configuration.level.contains("Exp.Excavation.soul sand")){
			Configuration.level.set("Exp.Excavation.soul sand",5);
		}
		if(!Configuration.level.contains("Exp.Excavation.snow block")){
			Configuration.level.set("Exp.Excavation.snow block",4);
		}
		
		//farming break
		if(!Configuration.level.contains("Exp.Farming.yellow flower.Break")){
			Configuration.level.set("Exp.Farming.yellow flower.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.rose.Break")){
			Configuration.level.set("Exp.Farming.rose.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.pumpkin.Break")){
			Configuration.level.set("Exp.Farming.pumpkin.Break",10);
		}
		if(!Configuration.level.contains("Exp.Farming.pumpkin stem.Break")){
			Configuration.level.set("Exp.Farming.pumpkin stem.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.melon block.Break")){
			Configuration.level.set("Exp.Farming.melon block.Break",10);
		}
		if(!Configuration.level.contains("Exp.Farming.melon stem.Break")){
			Configuration.level.set("Exp.Farming.melon stem.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.red mushroom.Break")){
			Configuration.level.set("Exp.Farming.red mushroom.Break",5);
		}
		if(!Configuration.level.contains("Exp.Farming.brown mushroom.Break")){
			Configuration.level.set("Exp.Farming.brown mushroom.Break",5);
		}
		if(!Configuration.level.contains("Exp.Farming.huge mushroom 1.Break")){
			Configuration.level.set("Exp.Farming.huge mushroom 1.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.huge mushroom 2.Break")){
			Configuration.level.set("Exp.Farming.huge mushroom 2.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.long grass.Break")){
			Configuration.level.set("Exp.Farming.long grass.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.wheat.Break")){
			Configuration.level.set("Exp.Farming.wheat.Break",5);
		}
		if(!Configuration.level.contains("Exp.Farming.cacti.Break")){
			Configuration.level.set("Exp.Farming.cacti.Break",5);
		}
		if(!Configuration.level.contains("Exp.Farming.sugar cane.Break")){
			Configuration.level.set("Exp.Farming.sugar cane.Break",2);
		}
		if(!Configuration.level.contains("Exp.Farming.vines.Break")){
			Configuration.level.set("Exp.Farming.vines.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.water lily.Break")){
			Configuration.level.set("Exp.Farming.water lily.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.leaves.Break")){
			Configuration.level.set("Exp.Farming.leaves.Break",1);
		}
		if(!Configuration.level.contains("Exp.Farming.dead bush.Break")){
			Configuration.level.set("Exp.Farming.dead bush.Break",1);
		}
		//farming place
		if(!Configuration.level.contains("Exp.Farming.yellow flower.Place")){
			Configuration.level.set("Exp.Farming.yellow flower.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.rose.Place")){
			Configuration.level.set("Exp.Farming.rose.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.pumpkin.Place")){
			Configuration.level.set("Exp.Farming.pumpkin.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.pumpkin stem.Place")){
			Configuration.level.set("Exp.Farming.pumpkin stem.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.melon block.Place")){
			Configuration.level.set("Exp.Farming.melon block.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.melon stem.Place")){
			Configuration.level.set("Exp.Farming.melon stem.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.red mushroom.Place")){
			Configuration.level.set("Exp.Farming.red mushroom.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.brown mushroom.Place")){
			Configuration.level.set("Exp.Farming.brown mushroom.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.huge mushroom 1.Place")){
			Configuration.level.set("Exp.Farming.huge Red mushroom 1.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.huge mushroom 2.Place")){
			Configuration.level.set("Exp.Farming.huge mushroom 2.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.long grass.Place")){
			Configuration.level.set("Exp.Farming.long grass.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.seeds.Place")){
			Configuration.level.set("Exp.Farming.seeds.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.cacti.Place")){
			Configuration.level.set("Exp.Farming.cacti.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.sugar cane.Place")){
			Configuration.level.set("Exp.Farming.sugar cane.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.vines.Place")){
			Configuration.level.set("Exp.Farming.vines.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.water lily.Place")){
			Configuration.level.set("Exp.Farming.water lily.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.leaves.Place")){
			Configuration.level.set("Exp.Farming.leaves.Place",1);
		}
		if(!Configuration.level.contains("Exp.Farming.dead bush.Place")){
			Configuration.level.set("Exp.Farming.dead bush.Place",1);
		}
		
		//farming create
		if(!Configuration.level.contains("Exp.Farming.Soil.Create")){
			Configuration.level.set("Exp.Farming.Soil.Create",1);
		}
		
		//cooking
		if(!Configuration.level.contains("Exp.Cooking.golden apple")){
			Configuration.level.set("Exp.Cooking.golden apple",20);
		}
		if(!Configuration.level.contains("Exp.Cooking.bread")){
			Configuration.level.set("Exp.Cooking.bread",5);
		}
		if(!Configuration.level.contains("Exp.Cooking.mushroom soup")){
			Configuration.level.set("Exp.Cooking.mushroom soup",10);
		}
		if(!Configuration.level.contains("Exp.Cooking.cake")){
			Configuration.level.set("Exp.Cooking.cake",30);
		}
		if(!Configuration.level.contains("Exp.Cooking.cooked beef")){
			Configuration.level.set("Exp.Cooking.cooked beef",10);
		}
		if(!Configuration.level.contains("Exp.Cooking.cooked chicken")){
			Configuration.level.set("Exp.Cooking.cooked chicken",10);
		}
		if(!Configuration.level.contains("Exp.Cooking.cooked fish")){
			Configuration.level.set("Exp.Cooking.cooked fish",10);
		}
		if(!Configuration.level.contains("Exp.Cooking.grilled porkchop")){
			Configuration.level.set("Exp.Cooking.grilled porkchop",10);
		}
		
		//fishing
		if(!Configuration.level.contains("Exp.Fishing.caught")){
			Configuration.level.set("Exp.Fishing.caught",10);
		}
				
		//firemaking
		if(!Configuration.level.contains("Exp.Firemaking.Ignite")){
			Configuration.level.set("Exp.Firemaking.Ignite",10);
		}
		
		//smithing
		if(!Configuration.level.contains("Exp.Smithing.iron ingot")){
			Configuration.level.set("Exp.Smithing.iron ingot",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.clay brick")){
			Configuration.level.set("Exp.Smithing.clay brick",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold ingot")){
			Configuration.level.set("Exp.Smithing.gold ingot",15);
		}
		if(!Configuration.level.contains("Exp.Smithing.wood axe")){
			Configuration.level.set("Exp.Smithing.wood axe",5);
		}
		if(!Configuration.level.contains("Exp.Smithing.wood pickaxe")){
			Configuration.level.set("Exp.Smithing.wood pickaxe",5);
		}
		if(!Configuration.level.contains("Exp.Smithing.wood spade")){
			Configuration.level.set("Exp.Smithing.wood spade",5);
		}
		if(!Configuration.level.contains("Exp.Smithing.wood sword")){
			Configuration.level.set("Exp.Smithing.wood sword",6);
		}
		if(!Configuration.level.contains("Exp.Smithing.wood hoe")){
			Configuration.level.set("Exp.Smithing.Wood hoe",5);
		}
		if(!Configuration.level.contains("Exp.Smithing.stone axe")){
			Configuration.level.set("Exp.Smithing.stone axe",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.stone pickaxe")){
			Configuration.level.set("Exp.Smithing.stone pickaxe",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.stone spade")){
			Configuration.level.set("Exp.Smithing.stone spade",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.stone sword")){
			Configuration.level.set("Exp.Smithing.stone sword",12);
		}
		if(!Configuration.level.contains("Exp.Smithing.stone hoe")){
			Configuration.level.set("Exp.Smithing.stone hoe",10);
		}
		if(!Configuration.level.contains("Exp.Smithing.iron axe")){
			Configuration.level.set("Exp.Smithing.iron axe",15);
		}
		if(!Configuration.level.contains("Exp.Smithing.iron pickaxe")){
			Configuration.level.set("Exp.Smithing.iron pickaxe",15);
		}
		if(!Configuration.level.contains("Exp.Smithing.iron spade")){
			Configuration.level.set("Exp.Smithing.iron spade",15);
		}
		if(!Configuration.level.contains("Exp.Smithing.iron sword")){
			Configuration.level.set("Exp.Smithing.iron sword",18);
		}
		if(!Configuration.level.contains("Exp.Smithing.iron hoe")){
			Configuration.level.set("Exp.Smithing.iron hoe",15);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold axe")){
			Configuration.level.set("Exp.Smithing.gold axe",20);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold pickaxe")){
			Configuration.level.set("Exp.Smithing.gold pickaxe",20);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold spade")){
			Configuration.level.set("Exp.Smithing.gold spade",20);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold sword")){
			Configuration.level.set("Exp.Smithing.gold sword",25);
		}
		if(!Configuration.level.contains("Exp.Smithing.gold hoe")){
			Configuration.level.set("Exp.Smithing.gold hoe",20);
		}
		if(!Configuration.level.contains("Exp.Smithing.diamond axe")){
			Configuration.level.set("Exp.Smithing.diamond axe",30);
		}
		if(!Configuration.level.contains("Exp.Smithing.diamond pickaxe")){
			Configuration.level.set("Exp.Smithing.diamond pickaxe",30);
		}
		if(!Configuration.level.contains("Exp.Smithing.diamond spade")){
			Configuration.level.set("Exp.Smithing.diamond spade",30);
		}
		if(!Configuration.level.contains("Exp.Smithing.diamond sword")){
			Configuration.level.set("Exp.Smithing.diamond sword",40);
		}
		if(!Configuration.level.contains("Exp.Smithing.diamond hoe")){
			Configuration.level.set("Exp.Smithing.diamond hoe",30);
		}
		
		//Construction
		if(!Configuration.level.contains("Exp.Construction.stone")){
			Configuration.level.set("Exp.Construction.stone",1);
		}
		if(!Configuration.level.contains("Exp.Construction.cobblestone")){
			Configuration.level.set("Exp.Construction.cobblestone",1);
		}
		if(!Configuration.level.contains("Exp.Construction.wood")){
			Configuration.level.set("Exp.Construction.wood",1);
		}
		if(!Configuration.level.contains("Exp.Construction.log")){
			Configuration.level.set("Exp.Construction.log",5);
		}
		if(!Configuration.level.contains("Exp.Construction.glass")){
			Configuration.level.set("Exp.Construction.glass",10);
		}
		if(!Configuration.level.contains("Exp.Construction.lapis block")){
			Configuration.level.set("Exp.Construction.lapis block",20);
		}
		if(!Configuration.level.contains("Exp.Construction.dispenser")){
			Configuration.level.set("Exp.Construction.dispenser",15);
		}
		if(!Configuration.level.contains("Exp.Construction.sandstone")){
			Configuration.level.set("Exp.Construction.sandstone",1);
		}
		if(!Configuration.level.contains("Exp.Construction.note block")){
			Configuration.level.set("Exp.Construction.note block",15);
		}
		if(!Configuration.level.contains("Exp.Construction.bed")){
			Configuration.level.set("Exp.Construction.bed",50);
		}
		if(!Configuration.level.contains("Exp.Construction.piston sticky base")){
			Configuration.level.set("Exp.Construction.piston sticky base",15);
		}
		if(!Configuration.level.contains("Exp.Construction.piston base")){
			Configuration.level.set("Exp.Construction.piston base",10);
		}
		if(!Configuration.level.contains("Exp.Construction.Wool")){
			Configuration.level.set("Exp.Construction.Wool",5);
		}
		if(!Configuration.level.contains("Exp.Construction.Gold Block")){
			Configuration.level.set("Exp.Construction.Gold Block",20);
		}
		if(!Configuration.level.contains("Exp.Construction.Iron Block")){
			Configuration.level.set("Exp.Construction.Iron Block",20);
		}
		if(!Configuration.level.contains("Exp.Construction.step")){
			Configuration.level.set("Exp.Construction.step",5);
		}
		if(!Configuration.level.contains("Exp.Construction.bricks")){
			Configuration.level.set("Exp.Construction.bricks",10);
		}
		if(!Configuration.level.contains("Exp.Construction.bookshelf")){
			Configuration.level.set("Exp.Construction.bookshelf",15);
		}
		if(!Configuration.level.contains("Exp.Construction.mossy cobblestone")){
			Configuration.level.set("Exp.Construction.mossy cobblestone",5);
		}
		if(!Configuration.level.contains("Exp.Construction.obsidian")){
			Configuration.level.set("Exp.Construction.obsidian",20);
		}
		if(!Configuration.level.contains("Exp.Construction.wood stairs")){
			Configuration.level.set("Exp.Construction.wood stairs",10);
		}
		if(!Configuration.level.contains("Exp.Construction.chest")){
			Configuration.level.set("Exp.Construction.chest",5);
		}
		if(!Configuration.level.contains("Exp.Construction.diamond block")){
			Configuration.level.set("Exp.Construction.diamond block",30);
		}
		if(!Configuration.level.contains("Exp.Construction.workbench")){
			Configuration.level.set("Exp.Construction.workbench",2);
		}
		if(!Configuration.level.contains("Exp.Construction.furnace")){
			Configuration.level.set("Exp.Construction.furnace",5);
		}
		if(!Configuration.level.contains("Exp.Construction.cobblestone stairs")){
			Configuration.level.set("Exp.Construction.cobblestone stairs",10);
		}
		if(!Configuration.level.contains("Exp.Construction.jukebox")){
			Configuration.level.set("Exp.Construction.jukebox",20);
		}
		if(!Configuration.level.contains("Exp.Construction.fence")){
			Configuration.level.set("Exp.Construction.fence",1);
		}
		if(!Configuration.level.contains("Exp.Construction.smooth brick")){
			Configuration.level.set("Exp.Construction.smooth brick",5);
		}
		if(!Configuration.level.contains("Exp.Construction.iron bars")){
			Configuration.level.set("Exp.Construction.iron bars",10);
		}
		if(!Configuration.level.contains("Exp.Construction.glass pane")){
			Configuration.level.set("Exp.Construction.glass pane",15);
		}
		if(!Configuration.level.contains("Exp.Construction.brick stairs")){
			Configuration.level.set("Exp.Construction.brick stairs",10);
		}
		if(!Configuration.level.contains("Exp.Construction.smooth stairs")){
			Configuration.level.set("Exp.Construction.smooth stairs",10);
		}
		if(!Configuration.level.contains("Exp.Construction.nether brick")){
			Configuration.level.set("Exp.Construction.nether brick",5);
		}
		if(!Configuration.level.contains("Exp.Construction.nether brick stairs")){
			Configuration.level.set("Exp.Construction.nether brick stairs",10);
		}
		if(!Configuration.level.contains("Exp.Construction.nether fence")){
			Configuration.level.set("Exp.Construction.nether fence",1);
		}
		if(!Configuration.level.contains("Exp.Construction.enchantment table")){
			Configuration.level.set("Exp.Construction.enchantment table",60);
		}
		if(!Configuration.level.contains("Exp.Construction.ender stone")){
			Configuration.level.set("Exp.Construction.ender stone",5);
		}
	}
}