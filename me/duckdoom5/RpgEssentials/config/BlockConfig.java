package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class BlockConfig {

	public static void set(){
		//Original Ores
		
		if(!Configuration.block.contains("Original Ores.Coal Ore.frequency")){
			Configuration.block.set("Original Ores.Coal Ore.frequency",110);
		}
		if(!Configuration.block.contains("Original Ores.Coal Ore.minheight")){
			Configuration.block.set("Original Ores.Coal Ore.minheight",16);
		}
		if(!Configuration.block.contains("Original Ores.Coal Ore.maxheight")){
			Configuration.block.set("Original Ores.Coal Ore.maxheight",70);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.frequency")){
			Configuration.block.set("Original Ores.Iron Ore.frequency",90);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.minheight")){
			Configuration.block.set("Original Ores.Iron Ore.minheight",16);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.maxheight")){
			Configuration.block.set("Original Ores.Iron Ore.maxheight",64);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.frequency")){
			Configuration.block.set("Original Ores.Lapis Ore.frequency",4);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.minheight")){
			Configuration.block.set("Original Ores.Lapis Ore.minheight",2);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.maxheight")){
			Configuration.block.set("Original Ores.Lapis Ore.maxheight",34);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.frequency")){
			Configuration.block.set("Original Ores.Gold Ore.frequency",20);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.minheight")){
			Configuration.block.set("Original Ores.Gold Ore.minheight",5);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.maxheight")){
			Configuration.block.set("Original Ores.Gold Ore.maxheight",32);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.frequency")){
			Configuration.block.set("Original Ores.Redstone Ore.frequency",20);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.minheight")){
			Configuration.block.set("Original Ores.Redstone Ore.minheight",2);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.maxheight")){
			Configuration.block.set("Original Ores.Redstone Ore.maxheight",16);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.frequency")){
			Configuration.block.set("Original Ores.Diamond Ore.frequency",5);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.minheight")){
			Configuration.block.set("Original Ores.Diamond Ore.minheight",2);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.maxheight")){
			Configuration.block.set("Original Ores.Diamond Ore.maxheight",16);
		}
		
		
		//Custom Ores
		
		//Adamantine
		if(!Configuration.block.contains("Custom Ores.Adamantine Ore.textureID")){
			Configuration.block.set("Custom Ores.Adamantine Ore.textureID",0);
		}
		if(!Configuration.block.contains("Custom Ores.Adamantine Ore.frequency")){
			Configuration.block.set("Custom Ores.Adamantine Ore.frequency",4);
		}
		if(!Configuration.block.contains("Custom Ores.Adamantine Ore.minheight")){
			Configuration.block.set("Custom Ores.Adamantine Ore.minheight",2);
		}
		if(!Configuration.block.contains("Custom Ores.Adamantine Ore.maxheight")){
			Configuration.block.set("Custom Ores.Adamantine Ore.maxheight",10);
		}
		if(!Configuration.block.contains("Custom Ores.Adamantine Ore.hardness")){
			Configuration.block.set("Custom Ores.Adamantine Ore.hardness",4);
		}
		//Irridium
		if(!Configuration.block.contains("Custom Ores.Irridium Ore.textureID")){
			Configuration.block.set("Custom Ores.Irridium Ore.textureID",1);
		}
		if(!Configuration.block.contains("Custom Ores.Irridium Ore.frequency")){
			Configuration.block.set("Custom Ores.Irridium Ore.frequency",3);
		}
		if(!Configuration.block.contains("Custom Ores.Irridium Ore.minheight")){
			Configuration.block.set("Custom Ores.Irridium Ore.minheight",2);
		}
		if(!Configuration.block.contains("Custom Ores.Irridium Ore.maxheight")){
			Configuration.block.set("Custom Ores.Irridium Ore.maxheight",5);
		}
		//Mithril
		if(!Configuration.block.contains("Custom Ores.Mithril Ore.textureID")){
			Configuration.block.set("Custom Ores.Mithril Ore.textureID",2);
		}
		if(!Configuration.block.contains("Custom Ores.Mithril Ore.frequency")){
			Configuration.block.set("Custom Ores.Mithril Ore.frequency",16);
		}
		if(!Configuration.block.contains("Custom Ores.Mithril Ore.minheight")){
			Configuration.block.set("Custom Ores.Mithril Ore.minheight",20);
		}
		if(!Configuration.block.contains("Custom Ores.Mithril Ore.maxheight")){
			Configuration.block.set("Custom Ores.Mithril Ore.maxheight",30);
		}
		//Verdite
		if(!Configuration.block.contains("Custom Ores.Verdite Ore.textureID")){
			Configuration.block.set("Custom Ores.Verdite Ore.textureID",3);
		}
		if(!Configuration.block.contains("Custom Ores.Verdite Ore.frequency")){
			Configuration.block.set("Custom Ores.Verdite Ore.frequency",80);
		}
		if(!Configuration.block.contains("Custom Ores.Verdite Ore.minheight")){
			Configuration.block.set("Custom Ores.Verdite Ore.minheight",55);
		}
		if(!Configuration.block.contains("Custom Ores.Verdite Ore.maxheight")){
			Configuration.block.set("Custom Ores.Verdite Ore.maxheight",70);
		}
		//Emerald
		if(!Configuration.block.contains("Custom Ores.Emerald Ore.textureID")){
			Configuration.block.set("Custom Ores.Emerald Ore.textureID",255);
		}
		if(!Configuration.block.contains("Custom Ores.Emerald Ore.frequency")){
			Configuration.block.set("Custom Ores.Emerald Ore.frequency",3);
		}
		if(!Configuration.block.contains("Custom Ores.Emerald Ore.minheight")){
			Configuration.block.set("Custom Ores.Emerald Ore.minheight",2);
		}
		if(!Configuration.block.contains("Custom Ores.Emerald Ore.maxheight")){
			Configuration.block.set("Custom Ores.Emerald Ore.maxheight",10);
		}
		//Amethyst
		if(!Configuration.block.contains("Custom Ores.Amethyst Ore.textureID")){
			Configuration.block.set("Custom Ores.Amethyst Ore.textureID",254);
		}
		if(!Configuration.block.contains("Custom Ores.Amethyst Ore.frequency")){
			Configuration.block.set("Custom Ores.Amethyst Ore.frequency",8);
		}
		if(!Configuration.block.contains("Custom Ores.Amethyst Ore.minheight")){
			Configuration.block.set("Custom Ores.Amethyst Ore.minheight",30);
		}
		if(!Configuration.block.contains("Custom Ores.Amethyst Ore.maxheight")){
			Configuration.block.set("Custom Ores.Amethyst Ore.maxheight",34);
		}
		//Saphire
		if(!Configuration.block.contains("Custom Ores.Saphire Ore.textureID")){
			Configuration.block.set("Custom Ores.Saphire Ore.textureID",253);
		}
		if(!Configuration.block.contains("Custom Ores.Saphire Ore.frequency")){
			Configuration.block.set("Custom Ores.Saphire Ore.frequency",8);
		}
		if(!Configuration.block.contains("Custom Ores.Saphire Ore.minheight")){
			Configuration.block.set("Custom Ores.Saphire Ore.minheight",40);
		}
		if(!Configuration.block.contains("Custom Ores.Saphire Ore.maxheight")){
			Configuration.block.set("Custom Ores.Saphire Ore.maxheight",60);
		}
		//Topaz
		if(!Configuration.block.contains("Custom Ores.Topaz Ore.textureID")){
			Configuration.block.set("Custom Ores.Topaz Ore.textureID",252);
		}
		if(!Configuration.block.contains("Custom Ores.Topaz Ore.frequency")){
			Configuration.block.set("Custom Ores.Topaz Ore.frequency",12);
		}
		if(!Configuration.block.contains("Custom Ores.Topaz Ore.minheight")){
			Configuration.block.set("Custom Ores.Topaz Ore.minheight",16);
		}
		if(!Configuration.block.contains("Custom Ores.Topaz Ore.maxheight")){
			Configuration.block.set("Custom Ores.Topaz Ore.maxheight",70);
		}
		//Other
		if(!Configuration.block.contains("Custom Blocks.Do Not Continue.textureID")){
			Configuration.block.set("Custom Blocks.Do Not Continue.textureID",5);
		}
		if(!Configuration.block.contains("Custom Blocks.Do Not Continue.shaped recipe1.amount")){
			Configuration.block.set("Custom Blocks.Do Not Continue.shaped recipe1.amount", 1);
		}
		if(!Configuration.block.contains("Custom Blocks.Do Not Continue.shaped recipe1.ingredients")){
			Configuration.block.set("Custom Blocks.Do Not Continue.shaped recipe1.ingredients", Arrays.asList("35:4,35:15,35:4","35:15,35:4,35:15","35:4,35:15,35:4"));
		}
	}
}