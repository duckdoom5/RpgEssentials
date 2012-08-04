package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class BlockConfig {

	public static void set(){
		//Original Ores
		
		if(!Configuration.block.contains("Original Ores.Coal Ore.frequency")){
			Configuration.block.set("Original Ores.Coal Ore.frequency",15);
		}
		if(!Configuration.block.contains("Original Ores.Coal Ore.max vein size")){
			Configuration.block.set("Original Ores.Coal Ore.max vein size",10);
		}
		if(!Configuration.block.contains("Original Ores.Coal Ore.min height")){
			Configuration.block.set("Original Ores.Coal Ore.min height",16);
		}
		if(!Configuration.block.contains("Original Ores.Coal Ore.max height")){
			Configuration.block.set("Original Ores.Coal Ore.max height",70);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.frequency")){
			Configuration.block.set("Original Ores.Iron Ore.frequency",10);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.max vein size")){
			Configuration.block.set("Original Ores.Iron Ore.max vein size",6);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.min height")){
			Configuration.block.set("Original Ores.Iron Ore.min height",16);
		}
		if(!Configuration.block.contains("Original Ores.Iron Ore.max height")){
			Configuration.block.set("Original Ores.Iron Ore.max height",64);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.frequency")){
			Configuration.block.set("Original Ores.Lapis Ore.frequency",2);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.max vein size")){
			Configuration.block.set("Original Ores.Lapis Ore.max vein size",4);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.min height")){
			Configuration.block.set("Original Ores.Lapis Ore.min height",2);
		}
		if(!Configuration.block.contains("Original Ores.Lapis Ore.max height")){
			Configuration.block.set("Original Ores.Lapis Ore.max height",34);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.frequency")){
			Configuration.block.set("Original Ores.Gold Ore.frequency",3);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.max vein size")){
			Configuration.block.set("Original Ores.Gold Ore.max vein size",4);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.min height")){
			Configuration.block.set("Original Ores.Gold Ore.min height",5);
		}
		if(!Configuration.block.contains("Original Ores.Gold Ore.max height")){
			Configuration.block.set("Original Ores.Gold Ore.max height",32);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.frequency")){
			Configuration.block.set("Original Ores.Redstone Ore.frequency",3);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.max vein size")){
			Configuration.block.set("Original Ores.Redstone Ore.max vein size",5);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.min height")){
			Configuration.block.set("Original Ores.Redstone Ore.min height",3);
		}
		if(!Configuration.block.contains("Original Ores.Redstone Ore.max height")){
			Configuration.block.set("Original Ores.Redstone Ore.max height",16);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.frequency")){
			Configuration.block.set("Original Ores.Diamond Ore.frequency",1);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.max vein size")){
			Configuration.block.set("Original Ores.Diamond Ore.max vein size",3);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.min height")){
			Configuration.block.set("Original Ores.Diamond Ore.min height",3);
		}
		if(!Configuration.block.contains("Original Ores.Diamond Ore.max height")){
			Configuration.block.set("Original Ores.Diamond Ore.max height",16);
		}
		
		if(Configuration.config.getBoolean("use default config")){
			//Custom Ores
			
			//Adamantine
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.textureID")){
				Configuration.block.set("Custom Ores.Adamantine Ore.textureID",0);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.frequency")){
				Configuration.block.set("Custom Ores.Adamantine Ore.frequency",1);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.max vein size")){
				Configuration.block.set("Custom Ores.Adamantine Ore.max vein size",2);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.min height")){
				Configuration.block.set("Custom Ores.Adamantine Ore.min height",3);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.max height")){
				Configuration.block.set("Custom Ores.Adamantine Ore.max height",10);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.hardness")){
				Configuration.block.set("Custom Ores.Adamantine Ore.hardness",10);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.drop")){
				Configuration.block.set("Custom Ores.Adamantine Ore.drop","Adamantine Ingot");
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Adamantine Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Adamantine Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Adamantine Ore.Buy Price",2000);
			}
			if(!Configuration.block.contains("Custom Ores.Adamantine Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Adamantine Ore.Sell Price",1000);
			}
			
			//Irridium
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.textureID")){
				Configuration.block.set("Custom Ores.Irridium Ore.textureID",1);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.frequency")){
				Configuration.block.set("Custom Ores.Irridium Ore.frequency",1);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.max vein size")){
				Configuration.block.set("Custom Ores.Irridium Ore.max vein size",2);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.min height")){
				Configuration.block.set("Custom Ores.Irridium Ore.min height",3);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.max height")){
				Configuration.block.set("Custom Ores.Irridium Ore.max height",5);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.hardness")){
				Configuration.block.set("Custom Ores.Irridium Ore.hardness",8);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Irridium Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Irridium Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Irridium Ore.Buy Price",1000);
			}
			if(!Configuration.block.contains("Custom Ores.Irridium Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Irridium Ore.Sell Price",500);
			}
			
			//Mithril
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.textureID")){
				Configuration.block.set("Custom Ores.Mithril Ore.textureID",2);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.frequency")){
				Configuration.block.set("Custom Ores.Mithril Ore.frequency",3);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.max vein size")){
				Configuration.block.set("Custom Ores.Mithril Ore.max vein size",4);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.min height")){
				Configuration.block.set("Custom Ores.Mithril Ore.min height",20);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.max height")){
				Configuration.block.set("Custom Ores.Mithril Ore.max height",30);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.hardness")){
				Configuration.block.set("Custom Ores.Mithril Ore.hardness",7);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Mithril Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Mithril Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Mithril Ore.Buy Price",800);
			}
			if(!Configuration.block.contains("Custom Ores.Mithril Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Mithril Ore.Sell Price",400);
			}
			
			//Verdite
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.textureID")){
				Configuration.block.set("Custom Ores.Verdite Ore.textureID",3);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.frequency")){
				Configuration.block.set("Custom Ores.Verdite Ore.frequency",12);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.max vein size")){
				Configuration.block.set("Custom Ores.Verdite Ore.max vein size",8);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.min height")){
				Configuration.block.set("Custom Ores.Verdite Ore.min height",55);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.max height")){
				Configuration.block.set("Custom Ores.Verdite Ore.max height",70);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.hardness")){
				Configuration.block.set("Custom Ores.Verdite Ore.hardness",2);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Verdite Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Verdite Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Verdite Ore.Buy Price",500);
			}
			if(!Configuration.block.contains("Custom Ores.Verdite Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Verdite Ore.Sell Price",250);
			}
			
			//Emerald
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.textureID")){
				Configuration.block.set("Custom Ores.Emerald Ore.textureID",255);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.frequency")){
				Configuration.block.set("Custom Ores.Emerald Ore.frequency",2);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.max vein size")){
				Configuration.block.set("Custom Ores.Emerald Ore.max vein size",2);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.min height")){
				Configuration.block.set("Custom Ores.Emerald Ore.min height",3);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.max height")){
				Configuration.block.set("Custom Ores.Emerald Ore.max height",10);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.hardness")){
				Configuration.block.set("Custom Ores.Emerald Ore.hardness",8);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Emerald Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Emerald Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Emerald Ore.Buy Price",1000);
			}
			if(!Configuration.block.contains("Custom Ores.Emerald Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Emerald Ore.Sell Price",500);
			}
			
			//Amethyst
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.textureID")){
				Configuration.block.set("Custom Ores.Amethyst Ore.textureID",254);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.frequency")){
				Configuration.block.set("Custom Ores.Amethyst Ore.frequency",3);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.max vein size")){
				Configuration.block.set("Custom Ores.Amethyst Ore.max vein size",3);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.min height")){
				Configuration.block.set("Custom Ores.Amethyst Ore.min height",28);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.max height")){
				Configuration.block.set("Custom Ores.Amethyst Ore.max height",36);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.hardness")){
				Configuration.block.set("Custom Ores.Amethyst Ore.hardness",6);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Amethyst Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Amethyst Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Amethyst Ore.Buy Price",800);
			}
			if(!Configuration.block.contains("Custom Ores.Amethyst Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Amethyst Ore.Sell Price",400);
			}
			
			//Saphire
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.textureID")){
				Configuration.block.set("Custom Ores.Saphire Ore.textureID",253);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.frequency")){
				Configuration.block.set("Custom Ores.Saphire Ore.frequency",4);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.max vein size")){
				Configuration.block.set("Custom Ores.Saphire Ore.max vein size",4);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.min height")){
				Configuration.block.set("Custom Ores.Saphire Ore.min height",40);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.max height")){
				Configuration.block.set("Custom Ores.Saphire Ore.max height",60);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.hardness")){
				Configuration.block.set("Custom Ores.Saphire Ore.hardness",4);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Saphire Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Saphire Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Saphire Ore.Buy Price",800);
			}
			if(!Configuration.block.contains("Custom Ores.Saphire Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Saphire Ore.Sell Price",400);
			}
			
			//Topaz
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.textureID")){
				Configuration.block.set("Custom Ores.Topaz Ore.textureID",252);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.frequency")){
				Configuration.block.set("Custom Ores.Topaz Ore.frequency",6);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.max vein size")){
				Configuration.block.set("Custom Ores.Topaz Ore.max vein size",4);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.min height")){
				Configuration.block.set("Custom Ores.Topaz Ore.min height",16);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.max height")){
				Configuration.block.set("Custom Ores.Topaz Ore.max height",70);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.hardness")){
				Configuration.block.set("Custom Ores.Topaz Ore.hardness",3);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.Sell Able")){
				Configuration.block.set("Custom Ores.Topaz Ore.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.Buy Able")){
				Configuration.block.set("Custom Ores.Topaz Ore.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.Buy Price")){
				Configuration.block.set("Custom Ores.Topaz Ore.Buy Price",600);
			}
			if(!Configuration.block.contains("Custom Ores.Topaz Ore.Sell Price")){
				Configuration.block.set("Custom Ores.Topaz Ore.Sell Price",300);
			}
			
			//Other
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.textureIds")){
				Configuration.block.set("Custom Blocks.Do Not Continue.textureIds","5,5,5,5,5,5");
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.design")){
				Configuration.block.set("Custom Blocks.Do Not Continue.design","block");
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.textureurl")){
				Configuration.block.set("Custom Blocks.Do Not Continue.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/blocks.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.texturesize")){
				Configuration.block.set("Custom Blocks.Do Not Continue.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.base")){
				Configuration.block.set("Custom Blocks.Do Not Continue.base",35);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.rotate")){
				Configuration.block.set("Custom Blocks.Do Not Continue.rotate",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.brightness")){
				Configuration.block.set("Custom Blocks.Do Not Continue.brightness",0.2D);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Do Not Continue.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Do Not Continue.shaped recipe1.ingredients", Arrays.asList("35:4,35:15,35:4","35:15,35:4,35:15","35:4,35:15,35:4"));
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.Sell Able")){
				Configuration.block.set("Custom Blocks.Do Not Continue.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.Buy Able")){
				Configuration.block.set("Custom Blocks.Do Not Continue.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.Buy Price")){
				Configuration.block.set("Custom Blocks.Do Not Continue.Buy Price",600);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.Sell Price")){
				Configuration.block.set("Custom Blocks.Do Not Continue.Sell Price",300);
			}
			if(!Configuration.block.contains("Custom Blocks.Do Not Continue.storetype")){
				Configuration.block.set("Custom Blocks.Do Not Continue.storetype", "materials");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Marble.textureIds")){
				Configuration.block.set("Custom Blocks.Marble.textureIds","12,12,12,12,12,12");
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.design")){
				Configuration.block.set("Custom Blocks.Marble.design","block");
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.textureurl")){
				Configuration.block.set("Custom Blocks.Marble.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/blocks.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.texturesize")){
				Configuration.block.set("Custom Blocks.Marble.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.base")){
				Configuration.block.set("Custom Blocks.Marble.base",98);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.rotate")){
				Configuration.block.set("Custom Blocks.Marble.rotate",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.brightness")){
				Configuration.block.set("Custom Blocks.Marble.brightness",0.2D);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.Sell Able")){
				Configuration.block.set("Custom Blocks.Marble.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.Buy Able")){
				Configuration.block.set("Custom Blocks.Marble.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.Buy Price")){
				Configuration.block.set("Custom Blocks.Marble.Buy Price",600);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.Sell Price")){
				Configuration.block.set("Custom Blocks.Marble.Sell Price",300);
			}
			if(!Configuration.block.contains("Custom Blocks.Marble.storetype")){
				Configuration.block.set("Custom Blocks.Marble.storetype", "materials");
			}
			
			//flowers
			if(!Configuration.block.contains("Custom Blocks.Tulip.textureIds")){
				Configuration.block.set("Custom Blocks.Tulip.textureIds","16,16,16,16,16,16");
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.design")){
				Configuration.block.set("Custom Blocks.Tulip.design","flower");
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.textureurl")){
				Configuration.block.set("Custom Blocks.Tulip.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.texturesize")){
				Configuration.block.set("Custom Blocks.Tulip.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.base")){
				Configuration.block.set("Custom Blocks.Tulip.base",38);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.brightness")){
				Configuration.block.set("Custom Blocks.Tulip.brightness",0.0D);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.rotate")){
				Configuration.block.set("Custom Blocks.Tulip.rotate",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.frequency")){
				Configuration.block.set("Custom Blocks.Tulip.frequency",10);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.Sell Able")){
				Configuration.block.set("Custom Blocks.Tulip.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.Buy Able")){
				Configuration.block.set("Custom Blocks.Tulip.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.Buy Price")){
				Configuration.block.set("Custom Blocks.Tulip.Buy Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.Sell Price")){
				Configuration.block.set("Custom Blocks.Tulip.Sell Price",25);
			}
			if(!Configuration.block.contains("Custom Blocks.Tulip.storetype")){
				Configuration.block.set("Custom Blocks.Tulip.storetype", "gardening");
			}
			
			//bushes
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.textureIds")){
				Configuration.block.set("Custom Blocks.Orange Bush.textureIds","0,0,0,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.design")){
				Configuration.block.set("Custom Blocks.Orange Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.textureurl")){
				Configuration.block.set("Custom Blocks.Orange Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.texturesize")){
				Configuration.block.set("Custom Blocks.Orange Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.base")){
				Configuration.block.set("Custom Blocks.Orange Bush.base",30);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Orange Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Orange Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,351:14,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.Orange Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.Orange Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.Orange Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.Orange Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Orange Bush.storetype")){
				Configuration.block.set("Custom Blocks.Orange Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.textureIds")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.textureIds","3,3,3,3,3,3");
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.design")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.textureurl")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.texturesize")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.base")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.base",18);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,351:2,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Dark Green Bush.storetype")){
				Configuration.block.set("Custom Blocks.Dark Green Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Green Bush.textureIds")){
				Configuration.block.set("Custom Blocks.Green Bush.textureIds","4,4,4,4,4,4");
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.design")){
				Configuration.block.set("Custom Blocks.Green Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.textureurl")){
				Configuration.block.set("Custom Blocks.Green Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.texturesize")){
				Configuration.block.set("Custom Blocks.Green Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.base")){
				Configuration.block.set("Custom Blocks.Green Bush.base",30);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Green Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Green Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,18,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.Green Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.Green Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.Green Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.Green Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Green Bush.storetype")){
				Configuration.block.set("Custom Blocks.Green Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.textureIds")){
				Configuration.block.set("Custom Blocks.Light Green Bush.textureIds","5,5,5,5,5,5");
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.design")){
				Configuration.block.set("Custom Blocks.Light Green Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.textureurl")){
				Configuration.block.set("Custom Blocks.Light Green Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.texturesize")){
				Configuration.block.set("Custom Blocks.Light Green Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.base")){
				Configuration.block.set("Custom Blocks.Light Green Bush.base",30);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Light Green Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Light Green Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,351:10,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.Light Green Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.Light Green Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.Light Green Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.Light Green Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Light Green Bush.storetype")){
				Configuration.block.set("Custom Blocks.Light Green Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.textureIds")){
				Configuration.block.set("Custom Blocks.Pink Bush.textureIds","11,11,11,11,11,11");
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.design")){
				Configuration.block.set("Custom Blocks.Pink Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.textureurl")){
				Configuration.block.set("Custom Blocks.Pink Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.texturesize")){
				Configuration.block.set("Custom Blocks.Pink Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.base")){
				Configuration.block.set("Custom Blocks.Pink Bush.base",30);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.Pink Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.Pink Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,351:9,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.Pink Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.Pink Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.Pink Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.Pink Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Pink Bush.storetype")){
				Configuration.block.set("Custom Blocks.Pink Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.White Bush.textureIds")){
				Configuration.block.set("Custom Blocks.White Bush.textureIds","12,12,12,12,12,12");
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.design")){
				Configuration.block.set("Custom Blocks.White Bush.design","bush");
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.textureurl")){
				Configuration.block.set("Custom Blocks.White Bush.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/plants.png");
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.texturesize")){
				Configuration.block.set("Custom Blocks.White Bush.texturesize",16);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.base")){
				Configuration.block.set("Custom Blocks.White Bush.base",30);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.shaped recipe1.amount")){
				Configuration.block.set("Custom Blocks.White Bush.shaped recipe1.amount", 1);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.shaped recipe1.ingredients")){
				Configuration.block.set("Custom Blocks.White Bush.shaped recipe1.ingredients", Arrays.asList("18,18,18","18,351:15,18","18,18,18"));
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.Sell Able")){
				Configuration.block.set("Custom Blocks.White Bush.Sell Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.Buy Able")){
				Configuration.block.set("Custom Blocks.White Bush.Buy Able",true);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.Buy Price")){
				Configuration.block.set("Custom Blocks.White Bush.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.Sell Price")){
				Configuration.block.set("Custom Blocks.White Bush.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.White Bush.storetype")){
				Configuration.block.set("Custom Blocks.White Bush.storetype", "gardening");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Blank Sign.textureIds","30,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.design")){
				Configuration.block.set("Custom Blocks.Blank Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Blank Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Blank Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.base")){
				Configuration.block.set("Custom Blocks.Blank Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.rotate")){
				Configuration.block.set("Custom Blocks.Blank Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Blank Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Blank Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Blank Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Blank Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Blank Sign.storetype")){
				Configuration.block.set("Custom Blocks.Blank Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.textureIds","32,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.design")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.base")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.rotate")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Alchemist Sign.storetype")){
				Configuration.block.set("Custom Blocks.Alchemist Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Armor Sign.textureIds","10,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.design")){
				Configuration.block.set("Custom Blocks.Armor Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Armor Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Armor Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.base")){
				Configuration.block.set("Custom Blocks.Armor Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.rotate")){
				Configuration.block.set("Custom Blocks.Armor Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Armor Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Armor Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Armor Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Armor Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Armor Sign.storetype")){
				Configuration.block.set("Custom Blocks.Armor Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Bakery Sign.textureIds","9,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.design")){
				Configuration.block.set("Custom Blocks.Bakery Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Bakery Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Bakery Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.base")){
				Configuration.block.set("Custom Blocks.Bakery Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.rotate")){
				Configuration.block.set("Custom Blocks.Bakery Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Bakery Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Bakery Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Bakery Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Bakery Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Bakery Sign.storetype")){
				Configuration.block.set("Custom Blocks.Bakery Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.textureIds","8,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.design")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.base")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.rotate")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Blacksmith Sign.storetype")){
				Configuration.block.set("Custom Blocks.Blacksmith Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.textureIds","7,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.design")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.base")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.rotate")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Bookstore Sign.storetype")){
				Configuration.block.set("Custom Blocks.Bookstore Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.textureIds","6,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.design")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.base")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.rotate")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Bowyer Sign.storetype")){
				Configuration.block.set("Custom Blocks.Bowyer Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Cafe Sign.textureIds","5,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.design")){
				Configuration.block.set("Custom Blocks.Cafe Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Cafe Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Cafe Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.base")){
				Configuration.block.set("Custom Blocks.Cafe Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.rotate")){
				Configuration.block.set("Custom Blocks.Cafe Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Cafe Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Cafe Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Cafe Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Cafe Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Cafe Sign.storetype")){
				Configuration.block.set("Custom Blocks.Cafe Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.textureIds","4,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.design")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.base")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.rotate")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Carpenter Sign.storetype")){
				Configuration.block.set("Custom Blocks.Carpenter Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.textureIds","3,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.design")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.base")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.rotate")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Cobbler Sign.storetype")){
				Configuration.block.set("Custom Blocks.Cobbler Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Dyer Sign.textureIds","2,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.design")){
				Configuration.block.set("Custom Blocks.Dyer Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Dyer Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Dyer Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.base")){
				Configuration.block.set("Custom Blocks.Dyer Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.rotate")){
				Configuration.block.set("Custom Blocks.Dyer Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Dyer Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Dyer Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Dyer Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Dyer Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Dyer Sign.storetype")){
				Configuration.block.set("Custom Blocks.Dyer Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.textureIds","1,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.design")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.base")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.rotate")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Fishmonger Sign.storetype")){
				Configuration.block.set("Custom Blocks.Fishmonger Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Florist Sign.textureIds","29,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.design")){
				Configuration.block.set("Custom Blocks.Florist Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Florist Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Florist Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.base")){
				Configuration.block.set("Custom Blocks.Florist Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.rotate")){
				Configuration.block.set("Custom Blocks.Florist Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Florist Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Florist Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Florist Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Florist Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Florist Sign.storetype")){
				Configuration.block.set("Custom Blocks.Florist Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.General Sign.textureIds")){
				Configuration.block.set("Custom Blocks.General Sign.textureIds","28,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.design")){
				Configuration.block.set("Custom Blocks.General Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.textureurl")){
				Configuration.block.set("Custom Blocks.General Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.texturesize")){
				Configuration.block.set("Custom Blocks.General Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.base")){
				Configuration.block.set("Custom Blocks.General Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.rotate")){
				Configuration.block.set("Custom Blocks.General Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.General Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.General Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.General Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.General Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.General Sign.storetype")){
				Configuration.block.set("Custom Blocks.General Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Grocery Sign.textureIds","27,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.design")){
				Configuration.block.set("Custom Blocks.Grocery Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Grocery Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Grocery Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.base")){
				Configuration.block.set("Custom Blocks.Grocery Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.rotate")){
				Configuration.block.set("Custom Blocks.Grocery Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Grocery Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Grocery Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Grocery Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Grocery Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Grocery Sign.storetype")){
				Configuration.block.set("Custom Blocks.Grocery Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Healer Sign.textureIds","26,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.design")){
				Configuration.block.set("Custom Blocks.Healer Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Healer Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Healer Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.base")){
				Configuration.block.set("Custom Blocks.Healer Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.rotate")){
				Configuration.block.set("Custom Blocks.Healer Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Healer Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Healer Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Healer Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Healer Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Healer Sign.storetype")){
				Configuration.block.set("Custom Blocks.Healer Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.textureIds","25,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.design")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.base")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.rotate")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Herbalist Sign.storetype")){
				Configuration.block.set("Custom Blocks.Herbalist Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Inn Sign.textureIds","24,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.design")){
				Configuration.block.set("Custom Blocks.Inn Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Inn Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Inn Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.base")){
				Configuration.block.set("Custom Blocks.Inn Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.rotate")){
				Configuration.block.set("Custom Blocks.Inn Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Inn Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Inn Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Inn Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Inn Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Inn Sign.storetype")){
				Configuration.block.set("Custom Blocks.Inn Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Items Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Items Sign.textureIds","23,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.design")){
				Configuration.block.set("Custom Blocks.Items Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Items Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Items Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.base")){
				Configuration.block.set("Custom Blocks.Items Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.rotate")){
				Configuration.block.set("Custom Blocks.Items Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Items Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Items Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Items Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Items Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Items Sign.storetype")){
				Configuration.block.set("Custom Blocks.Items Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.textureIds","22,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.design")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.base")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.rotate")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Jeweler Sign.storetype")){
				Configuration.block.set("Custom Blocks.Jeweler Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Library Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Library Sign.textureIds","21,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.design")){
				Configuration.block.set("Custom Blocks.Library Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Library Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Library Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.base")){
				Configuration.block.set("Custom Blocks.Library Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.rotate")){
				Configuration.block.set("Custom Blocks.Library Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Library Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Library Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Library Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Library Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Library Sign.storetype")){
				Configuration.block.set("Custom Blocks.Library Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Livestock Sign.textureIds","20,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.design")){
				Configuration.block.set("Custom Blocks.Livestock Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Livestock Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Livestock Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.base")){
				Configuration.block.set("Custom Blocks.Livestock Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.rotate")){
				Configuration.block.set("Custom Blocks.Livestock Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Livestock Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Livestock Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Livestock Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Livestock Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Livestock Sign.storetype")){
				Configuration.block.set("Custom Blocks.Livestock Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Magic Sign.textureIds","19,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.design")){
				Configuration.block.set("Custom Blocks.Magic Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Magic Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Magic Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.base")){
				Configuration.block.set("Custom Blocks.Magic Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.rotate")){
				Configuration.block.set("Custom Blocks.Magic Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Magic Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Magic Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Magic Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Magic Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Magic Sign.storetype")){
				Configuration.block.set("Custom Blocks.Magic Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Mason Sign.textureIds","18,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.design")){
				Configuration.block.set("Custom Blocks.Mason Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Mason Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Mason Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.base")){
				Configuration.block.set("Custom Blocks.Mason Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.rotate")){
				Configuration.block.set("Custom Blocks.Mason Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Mason Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Mason Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Mason Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Mason Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Mason Sign.storetype")){
				Configuration.block.set("Custom Blocks.Mason Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Music Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Music Sign.textureIds","17,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.design")){
				Configuration.block.set("Custom Blocks.Music Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Music Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Music Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.base")){
				Configuration.block.set("Custom Blocks.Music Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.rotate")){
				Configuration.block.set("Custom Blocks.Music Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Music Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Music Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Music Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Music Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Music Sign.storetype")){
				Configuration.block.set("Custom Blocks.Music Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Pets Sign.textureIds","16,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.design")){
				Configuration.block.set("Custom Blocks.Pets Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Pets Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Pets Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.base")){
				Configuration.block.set("Custom Blocks.Pets Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.rotate")){
				Configuration.block.set("Custom Blocks.Pets Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Pets Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Pets Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Pets Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Pets Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Pets Sign.storetype")){
				Configuration.block.set("Custom Blocks.Pets Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Potions Sign.textureIds","31,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.design")){
				Configuration.block.set("Custom Blocks.Potions Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Potions Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Potions Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.base")){
				Configuration.block.set("Custom Blocks.Potions Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.rotate")){
				Configuration.block.set("Custom Blocks.Potions Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Potions Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Potions Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Potions Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Potions Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Potions Sign.storetype")){
				Configuration.block.set("Custom Blocks.Potions Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Pub Sign.textureIds","15,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.design")){
				Configuration.block.set("Custom Blocks.Pub Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Pub Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Pub Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.base")){
				Configuration.block.set("Custom Blocks.Pub Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.rotate")){
				Configuration.block.set("Custom Blocks.Pub Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Pub Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Pub Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Pub Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Pub Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Pub Sign.storetype")){
				Configuration.block.set("Custom Blocks.Pub Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Tailor Sign.textureIds","14,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.design")){
				Configuration.block.set("Custom Blocks.Tailor Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Tailor Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Tailor Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.base")){
				Configuration.block.set("Custom Blocks.Tailor Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.rotate")){
				Configuration.block.set("Custom Blocks.Tailor Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Tailor Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Tailor Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Tailor Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Tailor Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Tailor Sign.storetype")){
				Configuration.block.set("Custom Blocks.Tailor Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Tanner Sign.textureIds","13,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.design")){
				Configuration.block.set("Custom Blocks.Tanner Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Tanner Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Tanner Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.base")){
				Configuration.block.set("Custom Blocks.Tanner Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.rotate")){
				Configuration.block.set("Custom Blocks.Tanner Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Tanner Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Tanner Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Tanner Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Tanner Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Tanner Sign.storetype")){
				Configuration.block.set("Custom Blocks.Tanner Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Tools Sign.textureIds","12,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.design")){
				Configuration.block.set("Custom Blocks.Tools Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Tools Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Tools Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.base")){
				Configuration.block.set("Custom Blocks.Tools Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.rotate")){
				Configuration.block.set("Custom Blocks.Tools Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Tools Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Tools Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Tools Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Tools Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Tools Sign.storetype")){
				Configuration.block.set("Custom Blocks.Tools Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.textureIds")){
				Configuration.block.set("Custom Blocks.Weapons Sign.textureIds","11,0,33,0,0,0");
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.design")){
				Configuration.block.set("Custom Blocks.Weapons Sign.design","sign");
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.textureurl")){
				Configuration.block.set("Custom Blocks.Weapons Sign.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/signs.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.texturesize")){
				Configuration.block.set("Custom Blocks.Weapons Sign.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.base")){
				Configuration.block.set("Custom Blocks.Weapons Sign.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.rotate")){
				Configuration.block.set("Custom Blocks.Weapons Sign.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.Sell Able")){
				Configuration.block.set("Custom Blocks.Weapons Sign.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.Buy Able")){
				Configuration.block.set("Custom Blocks.Weapons Sign.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.Buy Price")){
				Configuration.block.set("Custom Blocks.Weapons Sign.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.Sell Price")){
				Configuration.block.set("Custom Blocks.Weapons Sign.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Weapons Sign.storetype")){
				Configuration.block.set("Custom Blocks.Weapons Sign.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Barrel.textureIds")){
				Configuration.block.set("Custom Blocks.Barrel.textureIds","0,1,2,3,4,5");
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.design")){
				Configuration.block.set("Custom Blocks.Barrel.design","barrel");
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.textureurl")){
				Configuration.block.set("Custom Blocks.Barrel.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/barrel.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.texturesize")){
				Configuration.block.set("Custom Blocks.Barrel.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.base")){
				Configuration.block.set("Custom Blocks.Barrel.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.rotate")){
				Configuration.block.set("Custom Blocks.Barrel.rotate",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.Sell Able")){
				Configuration.block.set("Custom Blocks.Barrel.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.Buy Able")){
				Configuration.block.set("Custom Blocks.Barrel.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.Buy Price")){
				Configuration.block.set("Custom Blocks.Barrel.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.Sell Price")){
				Configuration.block.set("Custom Blocks.Barrel.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Barrel.storetype")){
				Configuration.block.set("Custom Blocks.Barrel.storetype", "misc");
			}
			
			if(!Configuration.block.contains("Custom Blocks.Pole.textureIds")){
				Configuration.block.set("Custom Blocks.Pole.textureIds","13,13,13,13,13,13");
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.design")){
				Configuration.block.set("Custom Blocks.Pole.design","pole");
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.textureurl")){
				Configuration.block.set("Custom Blocks.Pole.textureurl","http://dl.lynxdragon.com/rpgessentials/textures/blocks.png");
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.texturesize")){
				Configuration.block.set("Custom Blocks.Pole.texturesize",64);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.base")){
				Configuration.block.set("Custom Blocks.Pole.base",85);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.rotate")){
				Configuration.block.set("Custom Blocks.Pole.rotate",true);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.Sell Able")){
				Configuration.block.set("Custom Blocks.Pole.Sell Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.Buy Able")){
				Configuration.block.set("Custom Blocks.Pole.Buy Able",false);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.Buy Price")){
				Configuration.block.set("Custom Blocks.Pole.Buy Price",100);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.Sell Price")){
				Configuration.block.set("Custom Blocks.Pole.Sell Price",50);
			}
			if(!Configuration.block.contains("Custom Blocks.Pole.storetype")){
				Configuration.block.set("Custom Blocks.Pole.storetype", "misc");
			}
		}
	}
}