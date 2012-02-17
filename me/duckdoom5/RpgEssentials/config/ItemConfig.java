package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class ItemConfig {

	public static void set(){
		
		
		//Coins
		if(!Configuration.items.contains("Custom Items.Bronze Coin.texture url")){
			Configuration.items.set("Custom Items.Bronze Coin.texture url","http://82.74.70.243/server/items/bronzecoin.png");
		}
		if(!Configuration.items.contains("Custom Items.Silver Coin.texture url")){
			Configuration.items.set("Custom Items.Silver Coin.texture url","http://82.74.70.243/server/items/silvercoin.png");
		}
		if(!Configuration.items.contains("Custom Items.Gold Coin.texture url")){
			Configuration.items.set("Custom Items.Gold Coin.texture url","http://82.74.70.243/server/items/goldcoin.png");
		}
		
		
		
		
		
		//Custom Items
		
		if(!Configuration.items.contains("Custom Items.NPC Wand.texture url")){
			Configuration.items.set("Custom Items.NPC Wand.texture url","http://82.74.70.243/server/items/wands/npcwand.png");
		}
		//Adamantine ingot
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.texture url")){
			Configuration.items.set("Custom Items.Adamantine Ingot.texture url","http://82.74.70.243/server/items/ingots/Adamantineingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.ingredient", "Adamantine Ore");
		}
		
		//Iridium nugget
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.texture url")){
			Configuration.items.set("Custom Items.Iridium Nugget.texture url","http://82.74.70.243/server/items/ingots/Iridiumnugget.png");
		}
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.ingredient", "Iridium Ore");
		}
		
		//Iridium ingot
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.texture url")){
			Configuration.items.set("Custom Items.Iridium Ingot.texture url","http://82.74.70.243/server/items/ingots/Iridiumingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.ingredient", "Iridium Nugget");
		}
		
		//Mithril ingot
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.texture url")){
			Configuration.items.set("Custom Items.Mithril Ingot.texture url","http://82.74.70.243/server/items/ingots/Mithrilingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Mithril Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Mithril Ingot.furnace recipe1.ingredient", "Mithril Ore");
		}
		
		//Verdite ingot
		if(!Configuration.items.contains("Custom Items.Verdite Ingot.texture url")){
			Configuration.items.set("Custom Items.Verdite Ingot.texture url","http://82.74.70.243/server/items/ingots/Verditeingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Verdite Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Verdite Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Verdite Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Verdite Ingot.furnace recipe1.ingredient", "Verdite Ore");
		}
		
		
		
		
		//Custom Food
		
		//Hamburger
		if(!Configuration.items.contains("Custom Food.Hamburger.texture url")){
			Configuration.items.set("Custom Food.Hamburger.texture url","http://82.74.70.243/server/items/food/hamburger.png");
		}
		if(!Configuration.items.contains("Custom Food.Hamburger.restore")){
			Configuration.items.set("Custom Food.Hamburger.restore",10);
		}
		if(!Configuration.items.contains("Custom Food.Hamburger.shaped recipe1.amount")){
			Configuration.items.set("Custom Food.Hamburger.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Food.Hamburger.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Food.Hamburger.shaped recipe1.ingredients", Arrays.asList("297,297,297", "Salade,364,Chees", "297,297,297"));
		}
		
		//Raw Bacon
		if(!Configuration.items.contains("Custom Food.Raw Bacon.texture url")){
			Configuration.items.set("Custom Food.Raw Bacon.texture url","http://82.74.70.243/server/items/food/rawbacon.png");
		}
		if(!Configuration.items.contains("Custom Food.Raw Bacon.restore")){
			Configuration.items.set("Custom Food.Raw Bacon.restore",3);
		}
		
		//Cooked Bacon
		if(!Configuration.items.contains("Custom Food.Cooked Bacon.texture url")){
			Configuration.items.set("Custom Food.Cooked Bacon.texture url","http://82.74.70.243/server/items/food/cookedbacon.png");
		}
		if(!Configuration.items.contains("Custom Food.Cooked Bacon.restore")){
			Configuration.items.set("Custom Food.Cooked Bacon.restore",8);
		}
		if(!Configuration.items.contains("Custom Food.Cooked Bacon.furnace recipe1.amount")){
			Configuration.items.set("Custom Food.Cooked Bacon.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Food.Cooked Bacon.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Food.Cooked Bacon.furnace recipe1.ingredient", "Raw Bacon");
		}
		
		
		
		
		
		//Custom Tools
		//Adamantine Sword
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.texture url")){
			Configuration.items.set("Custom Tools.Adamantine Sword.texture url","http://82.74.70.243/server/items/tools/Adamantinesword.png");
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.durability")){
			Configuration.items.set("Custom Tools.Adamantine Sword.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-", "-,Adamantine Ingot,-", "-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","Adamantine Ingot,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Sword.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,Adamantine Ingot","-,-,280"));
		}
		//Adamantine Shovel
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.texture url")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.texture url","http://82.74.70.243/server/items/tools/Adamantineshovel.png");
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.durability")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","280,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,280","-,-,280"));
		}
		//Adamantine Axe
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.texture url")){
			Configuration.items.set("Custom Tools.Adamantine Axe.texture url","http://82.74.70.243/server/items/tools/Adamantineaxe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.durability")){
			Configuration.items.set("Custom Tools.Adamantine Axe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","Adamantine Ingot,280,-","-,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Axe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Axe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,Adamantine Ingot","-,280,-"));
		}
		//Adamantine Pickaxe
		if(!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.texture url")){
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.texture url","http://82.74.70.243/server/items/tools/Adamantinepick.png");
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.durability")){
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Pickaxe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,Adamantine Ingot","-,280,-","-,280,-"));
		}
		//Adamantine Hoe
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.texture url")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.texture url","http://82.74.70.243/server/items/tools/Adamantinehoe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.durability")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,-","-,280,-"));
		}
		
		//Iridium Sword
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.texture url")){
			Configuration.items.set("Custom Tools.Iridium Sword.texture url","http://82.74.70.243/server/items/tools/Iridiumsword.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.durability")){
			Configuration.items.set("Custom Tools.Iridium Sword.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.ingredients", Arrays.asList("-,Iridium Ingot,-", "-,Iridium Ingot,-", "-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.ingredients", Arrays.asList("Iridium Ingot,-,-","Iridium Ingot,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Iridium Ingot","-,-,Iridium Ingot","-,-,280"));
		}
		//Iridium Shovel
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.texture url")){
			Configuration.items.set("Custom Tools.Iridium Shovel.texture url","http://82.74.70.243/server/items/tools/Iridiumshovel.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.durability")){
			Configuration.items.set("Custom Tools.Iridium Shovel.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe1.ingredients", Arrays.asList("-,Iridium Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe2.ingredients", Arrays.asList("Iridium Ingot,-,-","280,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Shovel.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Iridium Ingot","-,-,280","-,-,280"));
		}
		//Iridium Axe
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.texture url")){
			Configuration.items.set("Custom Tools.Iridium Axe.texture url","http://82.74.70.243/server/items/tools/Iridiumaxe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.durability")){
			Configuration.items.set("Custom Tools.Iridium Axe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,-","Iridium Ingot,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Axe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Axe.shaped recipe2.ingredients", Arrays.asList("-,Iridium Ingot,Iridium Ingot","-,280,Iridium Ingot","-,280,-"));
		}
		//Iridium Pickaxe
		if(!Configuration.items.contains("Custom Tools.Iridium Pickaxe.texture url")){
			Configuration.items.set("Custom Tools.Iridium Pickaxe.texture url","http://82.74.70.243/server/items/tools/Iridiumpick.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Pickaxe.durability")){
			Configuration.items.set("Custom Tools.Iridium Pickaxe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Pickaxe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Pickaxe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Pickaxe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Pickaxe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,Iridium Ingot","-,280,-","-,280,-"));
		}
		//Iridium Hoe
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.texture url")){
			Configuration.items.set("Custom Tools.Iridium Hoe.texture url","http://82.74.70.243/server/items/tools/Iridiumhoe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.durability")){
			Configuration.items.set("Custom Tools.Iridium Hoe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe1.ingredients", Arrays.asList("Iridium Ingot,Iridium Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Hoe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Hoe.shaped recipe2.ingredients", Arrays.asList("-,Iridium Ingot,Iridium Ingot","-,280,-","-,280,-"));
		}
		
		//Mithril Sword
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.texture url")){
			Configuration.items.set("Custom Tools.Iridium Sword.texture url","http://82.74.70.243/server/items/tools/Mithrilsword.png");
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.durability")){
			Configuration.items.set("Custom Tools.Iridium Sword.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe1.ingredients", Arrays.asList("-,Mithril Ingot,-", "-,Mithril Ingot,-", "-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe2.ingredients", Arrays.asList("Mithril Ingot,-,-","Mithril Ingot,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Iridium Sword.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Mithril Ingot","-,-,Mithril Ingot","-,-,280"));
		}
		//Mithril Shovel
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.texture url")){
			Configuration.items.set("Custom Tools.Mithril Shovel.texture url","http://82.74.70.243/server/items/tools/Mithrilshovel.png");
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.durability")){
			Configuration.items.set("Custom Tools.Mithril Shovel.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe1.ingredients", Arrays.asList("-,Mithril Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe2.ingredients", Arrays.asList("Mithril Ingot,-,-","280,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Mithril Ingot","-,-,280","-,-,280"));
		}
		//Mithril Axe
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.texture url")){
			Configuration.items.set("Custom Tools.Mithril Axe.texture url","http://82.74.70.243/server/items/tools/Mithrilaxe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.durability")){
			Configuration.items.set("Custom Tools.Mithril Axe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,-","Mithril Ingot,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Axe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Axe.shaped recipe2.ingredients", Arrays.asList("-,Mithril Ingot,Mithril Ingot","-,280,Mithril Ingot","-,280,-"));
		}
		//Mithril Pickaxe
		if(!Configuration.items.contains("Custom Tools.Mithril Pickaxe.texture url")){
			Configuration.items.set("Custom Tools.Mithril Pickaxe.texture url","http://82.74.70.243/server/items/tools/Mithrilpick.png");
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Pickaxe.durability")){
			Configuration.items.set("Custom Tools.Mithril Pickaxe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Pickaxe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Mithril Pickaxe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Pickaxe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Pickaxe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,Mithril Ingot","-,280,-","-,280,-"));
		}
		//Mithril Hoe
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.texture url")){
			Configuration.items.set("Custom Tools.Mithril Hoe.texture url","http://82.74.70.243/server/items/tools/Mithrilhoe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.durability")){
			Configuration.items.set("Custom Tools.Mithril Hoe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe1.ingredients", Arrays.asList("Mithril Ingot,Mithril Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Hoe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Hoe.shaped recipe2.ingredients", Arrays.asList("-,Mithril Ingot,Mithril Ingot","-,280,-","-,280,-"));
		}
		
		//Verdite Sword
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.texture url")){
			Configuration.items.set("Custom Tools.Verdite Sword.texture url","http://82.74.70.243/server/items/tools/Verditesword.png");
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.durability")){
			Configuration.items.set("Custom Tools.Verdite Sword.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe1.ingredients", Arrays.asList("-,Verdite Ingot,-", "-,Verdite Ingot,-", "-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe2.ingredients", Arrays.asList("Verdite Ingot,-,-","Verdite Ingot,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Sword.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Verdite Ingot","-,-,Verdite Ingot","-,-,280"));
		}
		//Verdite Shovel
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.texture url")){
			Configuration.items.set("Custom Tools.Verdite Shovel.texture url","http://82.74.70.243/server/items/tools/Verditeshovel.png");
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.durability")){
			Configuration.items.set("Custom Tools.Verdite Shovel.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe1.ingredients", Arrays.asList("-,Verdite Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe2.ingredients", Arrays.asList("Verdite Ingot,-,-","280,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Shovel.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Verdite Ingot","-,-,280","-,-,280"));
		}
		//Verdite Axe
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.texture url")){
			Configuration.items.set("Custom Tools.Verdite Axe.texture url","http://82.74.70.243/server/items/tools/Verditeaxe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.durability")){
			Configuration.items.set("Custom Tools.Verdite Axe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,-","Verdite Ingot,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Axe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Axe.shaped recipe2.ingredients", Arrays.asList("-,Verdite Ingot,Verdite Ingot","-,280,Verdite Ingot","-,280,-"));
		}
		//Verdite Pickaxe
		if(!Configuration.items.contains("Custom Tools.Verdite Pickaxe.texture url")){
			Configuration.items.set("Custom Tools.Verdite Pickaxe.texture url","http://82.74.70.243/server/items/tools/Verditepick.png");
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Pickaxe.durability")){
			Configuration.items.set("Custom Tools.Verdite Pickaxe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Pickaxe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Verdite Pickaxe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Pickaxe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Pickaxe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,Verdite Ingot","-,280,-","-,280,-"));
		}
		//Verdite Hoe
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.texture url")){
			Configuration.items.set("Custom Tools.Verdite Hoe.texture url","http://82.74.70.243/server/items/tools/Verditehoe.png");
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.durability")){
			Configuration.items.set("Custom Tools.Verdite Hoe.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe1.ingredients", Arrays.asList("Verdite Ingot,Verdite Ingot,-","-,280,-","-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Verdite Hoe.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Verdite Hoe.shaped recipe2.ingredients", Arrays.asList("-,Verdite Ingot,Verdite Ingot","-,280,-","-,280,-"));
		}
	}

}