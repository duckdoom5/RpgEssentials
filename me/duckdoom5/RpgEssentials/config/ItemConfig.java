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
		
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.texture url")){
			Configuration.items.set("Custom Items.Adamantine Ingot.texture url","http://82.74.70.243/server/items/ingots/Adamantineingot.png");
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.amount")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.amount", 1);
		}
		if(!Configuration.items.contains("Custom Items.Adamantine Ingot.furnace recipe1.ingredient")){
			Configuration.items.set("Custom Items.Adamantine Ingot.furnace recipe1.ingredient", "Adamantine Ore");
		}
		//Custom Food
		if(!Configuration.items.contains("Custom Food.Hamburger.texture url")){
			Configuration.items.set("Custom Food.Hamburger.texture url","http://82.74.70.243/server/items/food/hamburger.png");
		}
		if(!Configuration.items.contains("Custom Food.Hamburger.restore")){
			Configuration.items.set("Custom Food.Hamburger.restore",10);
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
			Configuration.items.set("Custom Tools.Adamantine Sword.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,Adamantine Ingot,-","-,280,-"));
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
		/*//Adamantine Axe
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.texture url")){
			itemconfig.set("Custom Tools.Adamantine Axe.texture url","http://82.74.70.243/server/items/tools/Adamantineaxe.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.durability")){
			itemconfig.set("Custom Tools.Adamantine Axe.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","Adamantine Ingot,280,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,Adamantine Ingot","-,280,-"));
		}
		//Adamantine Hoe
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.texture url")){
			itemconfig.set("Custom Tools.Adamantine Hoe.texture url","http://82.74.70.243/server/items/tools/Adamantinehoe.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.durability")){
			itemconfig.set("Custom Tools.Adamantine Hoe.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","-,280,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,-","-,280,-"));
		}*/
	}

}
