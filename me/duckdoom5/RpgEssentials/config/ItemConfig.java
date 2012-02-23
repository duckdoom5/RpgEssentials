package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class ItemConfig {

	public static void set(){
		
		
		//Coins
		if(!Configuration.items.contains("Custom Items.Bronze Coin.texture url")){
			Configuration.items.set("Custom Items.Bronze Coin.texture url","http://dl.dropbox.com/u/62672791/textures/bronzecoin.png");
		}
		if(!Configuration.items.contains("Custom Items.Silver Coin.texture url")){
			Configuration.items.set("Custom Items.Silver Coin.texture url","http://dl.dropbox.com/u/62672791/textures/silvercoin.png");
		}
		if(!Configuration.items.contains("Custom Items.Gold Coin.texture url")){
			Configuration.items.set("Custom Items.Gold Coin.texture url","http://dl.dropbox.com/u/62672791/textures/goldcoin.png");
		}
		
		
		
		
		
		//Custom Items
		
		if(!Configuration.items.contains("Custom Items.NPC Wand.texture url")){
			Configuration.items.set("Custom Items.NPC Wand.texture url","http://dl.dropbox.com/u/62672791/textures/npcwand.png");
		}
		//Adamantine ingot
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.texture url")){
			Configuration.items.set("Custom Items.Adamantine Ingot.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantineingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.ingredient", "Adamantine Ore");
		}
		
		//Iridium nugget
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.texture url")){
			Configuration.items.set("Custom Items.Iridium Nugget.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumnugget.png");
		}
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Iridium Nugget.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Iridium Nugget.furnace recipe1.ingredient", "Iridium Ore");
		}
		
		//Iridium ingot
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.texture url")){
			Configuration.items.set("Custom Items.Iridium Ingot.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Iridium Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Iridium Ingot.furnace recipe1.ingredient", "Iridium Nugget");
		}
		
		//Mithril ingot
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.texture url")){
			Configuration.items.set("Custom Items.Mithril Ingot.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Mithril Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Mithril Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Mithril Ingot.furnace recipe1.ingredient", "Mithril Ore");
		}
		
		//Verdite ingot
		if(!Configuration.items.contains("Custom Items.Verdite Ingot.texture url")){
			Configuration.items.set("Custom Items.Verdite Ingot.texture url","http://dl.dropbox.com/u/62672791/textures/Verditeingot.png");
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
			Configuration.items.set("Custom Food.Hamburger.texture url","http://dl.dropbox.com/u/62672791/textures/hamburger.png");
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
			Configuration.items.set("Custom Food.Raw Bacon.texture url","http://dl.dropbox.com/u/62672791/textures/rawbacon.png");
		}
		if(!Configuration.items.contains("Custom Food.Raw Bacon.restore")){
			Configuration.items.set("Custom Food.Raw Bacon.restore",3);
		}
		
		//Cooked Bacon
		if(!Configuration.items.contains("Custom Food.Cooked Bacon.texture url")){
			Configuration.items.set("Custom Food.Cooked Bacon.texture url","http://dl.dropbox.com/u/62672791/textures/cookedbacon.png");
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
			Configuration.items.set("Custom Tools.Adamantine Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinesword.png");
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
			Configuration.items.set("Custom Tools.Adamantine Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantineshovel.png");
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
			Configuration.items.set("Custom Tools.Adamantine Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantineaxe.png");
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
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinepick.png");
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
			Configuration.items.set("Custom Tools.Adamantine Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinehoe.png");
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
			Configuration.items.set("Custom Tools.Iridium Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumsword.png");
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
			Configuration.items.set("Custom Tools.Iridium Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumshovel.png");
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
			Configuration.items.set("Custom Tools.Iridium Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumaxe.png");
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
			Configuration.items.set("Custom Tools.Iridium Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumpick.png");
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
			Configuration.items.set("Custom Tools.Iridium Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumhoe.png");
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
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.texture url")){
			Configuration.items.set("Custom Tools.Mithril Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilsword.png");
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.durability")){
			Configuration.items.set("Custom Tools.Mithril Sword.durability",20);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe1.amount")){
			Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe1.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe1.ingredients", Arrays.asList("-,Mithril Ingot,-", "-,Mithril Ingot,-", "-,280,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe2.amount")){
			Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe2.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe2.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe2.ingredients", Arrays.asList("Mithril Ingot,-,-","Mithril Ingot,-,-","280,-,-"));
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe3.amount")){
			Configuration.items.set("Custom Tools.Iridium Sword.shaped recipe3.amount", 1);
		}
		if(!Configuration.items.contains("Custom Tools.Mithril Sword.shaped recipe3.ingredients")){
			Configuration.items.set("Custom Tools.Mithril Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Mithril Ingot","-,-,Mithril Ingot","-,-,280"));
		}
		//Mithril Shovel
		if(!Configuration.items.contains("Custom Tools.Mithril Shovel.texture url")){
			Configuration.items.set("Custom Tools.Mithril Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilshovel.png");
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
			Configuration.items.set("Custom Tools.Mithril Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilaxe.png");
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
			Configuration.items.set("Custom Tools.Mithril Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilpick.png");
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
			Configuration.items.set("Custom Tools.Mithril Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilhoe.png");
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
			Configuration.items.set("Custom Tools.Verdite Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Verditesword.png");
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
			Configuration.items.set("Custom Tools.Verdite Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Verditeshovel.png");
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
			Configuration.items.set("Custom Tools.Verdite Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditeaxe.png");
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
			Configuration.items.set("Custom Tools.Verdite Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditepick.png");
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
			Configuration.items.set("Custom Tools.Verdite Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditehoe.png");
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
		
		
		
		
		//removing old urls
		if(Configuration.items.getString("Custom Items.Bronze Coin.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Items.Bronze Coin.texture url","http://dl.dropbox.com/u/62672791/textures/bronzecoin.png");
		}
		if(Configuration.items.getString("Custom Items.Silver Coin.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Items.Silver Coin.texture url","http://dl.dropbox.com/u/62672791/textures/silvercoin.png");
		}
		if(Configuration.items.getString("Custom Items.Gold Coin.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Items.Gold Coin.texture url","http://dl.dropbox.com/u/62672791/textures/goldcoin.png");
		}
		
		if(!Configuration.items.getString("Custom Tools.Adamantine Sword.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Adamantine Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinesword.png");
		}
		if(!Configuration.items.getString("Custom Tools.Adamantine Shovel.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Adamantine Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantineshovel.png");
		}
		if(!Configuration.items.getString("Custom Tools.Adamantine Axe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Adamantine Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantineaxe.png");
		}
		if(!Configuration.items.getString("Custom Tools.Adamantine Pickaxe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Adamantine Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinepick.png");
		}
		if(!Configuration.items.getString("Custom Tools.Adamantine Hoe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Adamantine Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Adamantinehoe.png");
		}
		
		if(!Configuration.items.getString("Custom Tools.Iridium Sword.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Iridium Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumsword.png");
		}
		if(!Configuration.items.getString("Custom Tools.Iridium Shovel.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Iridium Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumshovel.png");
		}
		if(!Configuration.items.getString("Custom Tools.Iridium Axe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Iridium Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumaxe.png");
		}
		if(!Configuration.items.getString("Custom Tools.Iridium Pickaxe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Iridium Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumpick.png");
		}
		if(!Configuration.items.getString("Custom Tools.Iridium Hoe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Iridium Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Iridiumhoe.png");
		}
		
		if(!Configuration.items.getString("Custom Tools.Mithril Sword.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Mithril Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilsword.png");
		}
		if(!Configuration.items.getString("Custom Tools.Mithril Shovel.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Mithril Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilshovel.png");
		}
		if(!Configuration.items.getString("Custom Tools.Mithril Axe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Mithril Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilaxe.png");
		}
		if(!Configuration.items.getString("Custom Tools.Mithril Pickaxe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Mithril Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilpick.png");
		}
		if(!Configuration.items.getString("Custom Tools.Mithril Hoe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Mithril Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Mithrilhoe.png");
		}
		
		if(!Configuration.items.getString("Custom Tools.Verdite Sword.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Verdite Sword.texture url","http://dl.dropbox.com/u/62672791/textures/Verditesword.png");
		}
		if(!Configuration.items.getString("Custom Tools.Verdite Shovel.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Verdite Shovel.texture url","http://dl.dropbox.com/u/62672791/textures/Verditeshovel.png");
		}
		if(!Configuration.items.getString("Custom Tools.Verdite Axe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Verdite Axe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditeaxe.png");
		}
		if(!Configuration.items.getString("Custom Tools.Verdite Pickaxe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Verdite Pickaxe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditepick.png");
		}
		if(!Configuration.items.getString("Custom Tools.Verdite Hoe.texture url").contains("82.74.70.243")){
			Configuration.items.set("Custom Tools.Verdite Hoe.texture url","http://dl.dropbox.com/u/62672791/textures/Verditehoe.png");
		}
	}

}