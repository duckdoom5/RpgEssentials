package me.duckdoom5.RpgEssentials.RpgStores.Config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;

import org.bukkit.configuration.ConfigurationSection;

public class StoreConfig {
	public static HashMap<String, String> custommaterials = new LinkedHashMap<String, String>();
	public static void set() {
		
		for(StoreValue value:StoreValue.values()) {
			String name = value.toString().toLowerCase().replace("_", " ");
			String type = value.getType();
			String type2 = value.getType2();
			String type3 = value.getType3();
			
			if(!Configuration.store.contains("Store." + type + "." + name + ".Buy Able")){
				Configuration.store.set("Store." + type + "." + name + ".Buy Able",value.isBuyAble());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Sell Able")){
				Configuration.store.set("Store." + type + "." + name + ".Sell Able",value.isSellAble());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Buy Price")){
				Configuration.store.set("Store." + type + "." + name + ".Buy Price",value.getBuyPrice());
			}
			if(!Configuration.store.contains("Store." + type + "." + name + ".Sell Price")){
				Configuration.store.set("Store." + type + "." + name + ".Sell Price",value.getSellPrice());
			}
			
			if(type2 != null){
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Buy Able")){
					Configuration.store.set("Store." + type2 + "." + name + ".Buy Able",value.isBuyAble());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Sell Able")){
					Configuration.store.set("Store." + type2 + "." + name + ".Sell Able",value.isSellAble());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Buy Price")){
					Configuration.store.set("Store." + type2 + "." + name + ".Buy Price",value.getBuyPrice());
				}
				if(!Configuration.store.contains("Store." + type2 + "." + name + ".Sell Price")){
					Configuration.store.set("Store." + type2 + "." + name + ".Sell Price",value.getSellPrice());
				}
			}
			
			if(type3 != null){
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Buy Able")){
					Configuration.store.set("Store." + type3 + "." + name + ".Buy Able",value.isBuyAble());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Sell Able")){
					Configuration.store.set("Store." + type3 + "." + name + ".Sell Able",value.isSellAble());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Buy Price")){
					Configuration.store.set("Store." + type3 + "." + name + ".Buy Price",value.getBuyPrice());
				}
				if(!Configuration.store.contains("Store." + type3 + "." + name + ".Sell Price")){
					Configuration.store.set("Store." + type3 + "." + name + ".Sell Price",value.getSellPrice());
				}
			}
		}
		
		//custom materials
		update();
		for(String name:custommaterials.keySet()){
			me.duckdoom5.RpgEssentials.config.MyConfiguration config;
			
			if(custommaterials.get(name).equals("Ores") || custommaterials.get(name).equals("Blocks")){
				config = me.duckdoom5.RpgEssentials.config.Configuration.block;
			}else{
				config = me.duckdoom5.RpgEssentials.config.Configuration.items;
			}
			
			if(!Configuration.store.contains("Store.custom." + custommaterials.get(name) + "." + name + ".Buy Price")){
				Configuration.store.set("Store.custom." + custommaterials.get(name) + "." + name + ".Buy Price", config.getInt("Custom " + custommaterials.get(name) + "." + name + ".Buy Price"));
			}
			if(!Configuration.store.contains("Store.custom." + custommaterials.get(name) + "." + name + ".Sell Price")){
				Configuration.store.set("Store.custom." + custommaterials.get(name) + "." + name + ".Sell Price", config.getInt("Custom " + custommaterials.get(name) + "." + name + ".Sell Price"));
			}
		}
		
		/*//food
		if(!Configuration.store.contains("Store.Food.apple.Sell Able")){
			Configuration.store.set("Store.Food.apple.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.apple.Buy Able")){
			Configuration.store.set("Store.Food.apple.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.apple.Buy Price")){
			Configuration.store.set("Store.Food.apple.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Food.apple.Sell Price")){
			Configuration.store.set("Store.Food.apple.Sell Price",15);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Sell Able")){
			Configuration.store.set("Store.Food.golden apple.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Buy Able")){
			Configuration.store.set("Store.Food.golden apple.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Buy Price")){
			Configuration.store.set("Store.Food.golden apple.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Sell Price")){
			Configuration.store.set("Store.Food.golden apple.Sell Price",50);
		}
		if(!Configuration.store.contains("Store.Food.bread.Sell Able")){
			Configuration.store.set("Store.Food.bread.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.bread.Buy Able")){
			Configuration.store.set("Store.Food.bread.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.bread.Sell Price")){
			Configuration.store.set("Store.Food.bread.Sell Price",10);
		}
		if(!Configuration.store.contains("Store.Food.bread.Buy Price")){
			Configuration.store.set("Store.Food.bread.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Food.cake.Sell Able")){
			Configuration.store.set("Store.Food.cake.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cake.Buy Able")){
			Configuration.store.set("Store.Food.cake.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cake.Buy Price")){
			Configuration.store.set("Store.Food.cake.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Food.cake.Sell Price")){
			Configuration.store.set("Store.Food.cake.Sell Price",60);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Sell Able")){
			Configuration.store.set("Store.Food.raw beef.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Buy Able")){
			Configuration.store.set("Store.Food.raw beef.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Buy Price")){
			Configuration.store.set("Store.Food.raw beef.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Sell Price")){
			Configuration.store.set("Store.Food.raw beef.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Sell Able")){
			Configuration.store.set("Store.Food.cooked beef.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Buy Able")){
			Configuration.store.set("Store.Food.cooked beef.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Buy Price")){
			Configuration.store.set("Store.Food.cooked beef.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Sell Price")){
			Configuration.store.set("Store.Food.cooked beef.Sell Price",40);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Sell Able")){
			Configuration.store.set("Store.Food.raw chicken.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Buy Able")){
			Configuration.store.set("Store.Food.raw chicken.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Buy Price")){
			Configuration.store.set("Store.Food.raw chicken.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Sell Price")){
			Configuration.store.set("Store.Food.raw chicken.Sell Price",15);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Sell Able")){
			Configuration.store.set("Store.Food.cooked chicken.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Buy Able")){
			Configuration.store.set("Store.Food.cooked chicken.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Buy Price")){
			Configuration.store.set("Store.Food.cooked chicken.Buy Price",25);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Sell Price")){
			Configuration.store.set("Store.Food.cooked chicken.Sell Price",25);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Sell Able")){
			Configuration.store.set("Store.Food.raw fish.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Buy Able")){
			Configuration.store.set("Store.Food.raw fish.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Buy Price")){
			Configuration.store.set("Store.Food.raw fish.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Sell Price")){
			Configuration.store.set("Store.Food.raw fish.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Sell Able")){
			Configuration.store.set("Store.Food.cooked fish.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Buy Able")){
			Configuration.store.set("Store.Food.cooked fish.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Buy Price")){
			Configuration.store.set("Store.Food.cooked fish.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Sell Price")){
			Configuration.store.set("Store.Food.cooked fish.Sell Price",40);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Sell Able")){
			Configuration.store.set("Store.Food.cookie.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Buy Able")){
			Configuration.store.set("Store.Food.cookie.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Sell Price")){
			Configuration.store.set("Store.Food.cookie.Sell Price",15);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Buy Price")){
			Configuration.store.set("Store.Food.cookie.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Food.pork.Sell Able")){
			Configuration.store.set("Store.Food.pork.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.pork.Buy Able")){
			Configuration.store.set("Store.Food.pork.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.pork.Buy Price")){
			Configuration.store.set("Store.Food.pork.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Food.pork.Sell Price")){
			Configuration.store.set("Store.Food.pork.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Sell Able")){
			Configuration.store.set("Store.Food.grilled pork.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Buy Able")){
			Configuration.store.set("Store.Food.grilled pork.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Buy Price")){
			Configuration.store.set("Store.Food.grilled pork.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Sell Price")){
			Configuration.store.set("Store.Food.grilled pork.Sell Price",40);
		}
		if(!Configuration.store.contains("Store.Food.melon.Sell Able")){
			Configuration.store.set("Store.Food.melon.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.melon.Buy Able")){
			Configuration.store.set("Store.Food.melon.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.melon.Sell Price")){
			Configuration.store.set("Store.Food.melon.Sell Price",50);
		}
		if(!Configuration.store.contains("Store.Food.melon.Buy Price")){
			Configuration.store.set("Store.Food.melon.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Sell Able")){
			Configuration.store.set("Store.Food.mushroom soup.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Buy Able")){
			Configuration.store.set("Store.Food.mushroom soup.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Buy Price")){
			Configuration.store.set("Store.Food.mushroom soup.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Sell Price")){
			Configuration.store.set("Store.Food.mushroom soup.Sell Price",30);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Sell Able")){
			Configuration.store.set("Store.Food.rotten flesh.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Buy Able")){
			Configuration.store.set("Store.Food.rotten flesh.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Buy Price")){
			Configuration.store.set("Store.Food.rotten flesh.Buy Price",5);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Sell Price")){
			Configuration.store.set("Store.Food.rotten flesh.Sell Price",5);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Sell Able")){
			Configuration.store.set("Store.Food.spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Buy Able")){
			Configuration.store.set("Store.Food.spider eye.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Buy Price")){
			Configuration.store.set("Store.Food.spider eye.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Sell Price")){
			Configuration.store.set("Store.Food.spider eye.Sell Price",20);
		}
		
		//tools
		if(!Configuration.store.contains("Store.Tools.wood axe.Sell Able")){
			Configuration.store.set("Store.Tools.wood axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood axe.Buy Able")){
			Configuration.store.set("Store.Tools.wood axe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood axe.Buy Price")){
			Configuration.store.set("Store.Tools.wood axe.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood axe.Sell Price")){
			Configuration.store.set("Store.Tools.wood axe.Sell Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Sell Able")){
			Configuration.store.set("Store.Tools.wood hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Buy Able")){
			Configuration.store.set("Store.Tools.wood hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Buy Price")){
			Configuration.store.set("Store.Tools.wood hoe.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Sell Price")){
			Configuration.store.set("Store.Tools.wood hoe.Sell Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.wood pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Buy Able")){
			Configuration.store.set("Store.Tools.wood pickaxe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Buy Price")){
			Configuration.store.set("Store.Tools.wood pickaxe.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Sell Price")){
			Configuration.store.set("Store.Tools.wood pickaxe.Sell Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Sell Able")){
			Configuration.store.set("Store.Tools.wood sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Buy Able")){
			Configuration.store.set("Store.Tools.wood sword.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Buy Price")){
			Configuration.store.set("Store.Tools.wood sword.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Sell Price")){
			Configuration.store.set("Store.Tools.wood sword.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Sell Able")){
			Configuration.store.set("Store.Tools.wood spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Buy Able")){
			Configuration.store.set("Store.Tools.wood spade.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Buy Price")){
			Configuration.store.set("Store.Tools.wood spade.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Sell Price")){
			Configuration.store.set("Store.Tools.wood spade.Sell Price",15);
		}
		
		if(!Configuration.store.contains("Store.Tools.stone axe.Sell Able")){
			Configuration.store.set("Store.Tools.stone axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone axe.Buy Able")){
			Configuration.store.set("Store.Tools.stone axe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone axe.Buy Price")){
			Configuration.store.set("Store.Tools.stone axe.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone axe.Sell Price")){
			Configuration.store.set("Store.Tools.stone axe.Sell Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Sell Able")){
			Configuration.store.set("Store.Tools.stone hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Buy Able")){
			Configuration.store.set("Store.Tools.stone hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Buy Price")){
			Configuration.store.set("Store.Tools.stone hoe.Buy Price",25);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Sell Price")){
			Configuration.store.set("Store.Tools.stone hoe.Sell Price",25);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.stone pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Buy Able")){
			Configuration.store.set("Store.Tools.stone pickaxe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Buy Price")){
			Configuration.store.set("Store.Tools.stone pickaxe.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Sell Price")){
			Configuration.store.set("Store.Tools.stone pickaxe.Sell Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Sell Able")){
			Configuration.store.set("Store.Tools.stone sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Buy Able")){
			Configuration.store.set("Store.Tools.stone sword.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Buy Price")){
			Configuration.store.set("Store.Tools.stone sword.Buy Price",35);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Sell Price")){
			Configuration.store.set("Store.Tools.stone sword.Sell Price",35);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Sell Able")){
			Configuration.store.set("Store.Tools.stone spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Buy Able")){
			Configuration.store.set("Store.Tools.stone spade.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Buy Price")){
			Configuration.store.set("Store.Tools.stone spade.Buy Price",25);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Sell Price")){
			Configuration.store.set("Store.Tools.stone spade.Sell Price",25);
		}
		
		if(!Configuration.store.contains("Store.Tools.iron axe.Sell Able")){
			Configuration.store.set("Store.Tools.iron axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron axe.Buy Able")){
			Configuration.store.set("Store.Tools.iron axe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron axe.Buy Price")){
			Configuration.store.set("Store.Tools.iron axe.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron axe.Sell Price")){
			Configuration.store.set("Store.Tools.iron axe.Sell Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Sell Able")){
			Configuration.store.set("Store.Tools.iron hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Buy Able")){
			Configuration.store.set("Store.Tools.iron hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Buy Price")){
			Configuration.store.set("Store.Tools.iron hoe.Buy Price",45);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Sell Price")){
			Configuration.store.set("Store.Tools.iron hoe.Sell Price",45);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.iron pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Byu Able")){
			Configuration.store.set("Store.Tools.iron pickaxe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Buy Price")){
			Configuration.store.set("Store.Tools.iron pickaxe.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Sell Price")){
			Configuration.store.set("Store.Tools.iron pickaxe.Sell Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Sell Able")){
			Configuration.store.set("Store.Tools.iron sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Buy Able")){
			Configuration.store.set("Store.Tools.iron sword.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Buy Price")){
			Configuration.store.set("Store.Tools.iron sword.Buy Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Sell Price")){
			Configuration.store.set("Store.Tools.iron sword.Sell Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Sell Able")){
			Configuration.store.set("Store.Tools.iron spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Buy Able")){
			Configuration.store.set("Store.Tools.iron spade.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Buy Price")){
			Configuration.store.set("Store.Tools.iron spade.Buy Price",45);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Sell Price")){
			Configuration.store.set("Store.Tools.iron spade.Sell Price",45);
		}
		
		if(!Configuration.store.contains("Store.Tools.gold axe.Sell Able")){
			Configuration.store.set("Store.Tools.gold axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold axe.Buy Able")){
			Configuration.store.set("Store.Tools.gold axe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold axe.Buy Price")){
			Configuration.store.set("Store.Tools.gold axe.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold axe.Sell Price")){
			Configuration.store.set("Store.Tools.gold axe.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Sell Able")){
			Configuration.store.set("Store.Tools.gold hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Buy Able")){
			Configuration.store.set("Store.Tools.gold hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Buy Price")){
			Configuration.store.set("Store.Tools.gold hoe.Buy Price",90);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Sell Price")){
			Configuration.store.set("Store.Tools.gold hoe.Sell Price",90);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.gold pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Buy Able")){
			Configuration.store.set("Store.Tools.gold pickaxe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Buy Price")){
			Configuration.store.set("Store.Tools.gold pickaxe.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Sell Price")){
			Configuration.store.set("Store.Tools.gold pickaxe.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Sell Able")){
			Configuration.store.set("Store.Tools.gold sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Buy Able")){
			Configuration.store.set("Store.Tools.gold sword.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Buy Price")){
			Configuration.store.set("Store.Tools.gold sword.Buy Price",110);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Sell Price")){
			Configuration.store.set("Store.Tools.gold sword.Sell Price",110);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Sell Able")){
			Configuration.store.set("Store.Tools.gold spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Buy Able")){
			Configuration.store.set("Store.Tools.gold spade.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Buy Price")){
			Configuration.store.set("Store.Tools.gold spade.Buy Price",90);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Sell Price")){
			Configuration.store.set("Store.Tools.gold spade.Sell Price",90);
		}
		
		if(!Configuration.store.contains("Store.Tools.diamond axe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond axe.Buy Able")){
			Configuration.store.set("Store.Tools.diamond axe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond axe.Buy Price")){
			Configuration.store.set("Store.Tools.diamond axe.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond axe.Sell Price")){
			Configuration.store.set("Store.Tools.diamond axe.Sell Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Buy Able")){
			Configuration.store.set("Store.Tools.diamond hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Buy Price")){
			Configuration.store.set("Store.Tools.diamond hoe.Buy Price",450);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Sell Price")){
			Configuration.store.set("Store.Tools.diamond hoe.Sell Price",450);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Buy Able")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Buy Price")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Sell Price")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Sell Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Sell Able")){
			Configuration.store.set("Store.Tools.diamond sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Buy Able")){
			Configuration.store.set("Store.Tools.diamond sword.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Buy Price")){
			Configuration.store.set("Store.Tools.diamond sword.Buy Price",600);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Sell Price")){
			Configuration.store.set("Store.Tools.diamond sword.Sell Price",600);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Sell Able")){
			Configuration.store.set("Store.Tools.diamond spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Buy Able")){
			Configuration.store.set("Store.Tools.diamond spade.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Buy Price")){
			Configuration.store.set("Store.Tools.diamond spade.Buy Price",450);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Sell Price")){
			Configuration.store.set("Store.Tools.diamond spade.Sell Price",450);
		}
		
		if(!Configuration.store.contains("Store.Tools.minecart.Sell Able")){
			Configuration.store.set("Store.Tools.minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.minecart.Buy Able")){
			Configuration.store.set("Store.Tools.minecart.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.minecart.Buy Price")){
			Configuration.store.set("Store.Tools.minecart.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.minecart.Sell Price")){
			Configuration.store.set("Store.Tools.minecart.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.powered minecart.Sell Able")){
			Configuration.store.set("Store.Tools.powerd minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.powered minecart.Buy Able")){
			Configuration.store.set("Store.Tools.powerd minecart.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.powered minecart.Buy Price")){
			Configuration.store.set("Store.Tools.powerd minecart.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.powered minecart.Sell Price")){
			Configuration.store.set("Store.Tools.powerd minecart.Sell Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Sell Able")){
			Configuration.store.set("Store.Tools.storage minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Buy Able")){
			Configuration.store.set("Store.Tools.storage minecart.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Buy Price")){
			Configuration.store.set("Store.Tools.storage minecart.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Sell Price")){
			Configuration.store.set("Store.Tools.storage minecart.Sell Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Sell Able")){
			Configuration.store.set("Store.Tools.compass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Buy Able")){
			Configuration.store.set("Store.Tools.compass.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Buy Price")){
			Configuration.store.set("Store.Tools.compass.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Sell Price")){
			Configuration.store.set("Store.Tools.compass.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Sell Able")){
			Configuration.store.set("Store.Tools.watch.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Buy Able")){
			Configuration.store.set("Store.Tools.watch.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Buy Price")){
			Configuration.store.set("Store.Tools.watch.Buy Price",120);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Sell Price")){
			Configuration.store.set("Store.Tools.watch.Sell Price",120);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Sell Able")){
			Configuration.store.set("Store.Tools.arrow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Buy Able")){
			Configuration.store.set("Store.Tools.arrow.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Buy Price")){
			Configuration.store.set("Store.Tools.arrow.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Sell Price")){
			Configuration.store.set("Store.Tools.arrow.Sell Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Sell Able")){
			Configuration.store.set("Store.Tools.bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Buy Able")){
			Configuration.store.set("Store.Tools.bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Buy Price")){
			Configuration.store.set("Store.Tools.bucket.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Sell Price")){
			Configuration.store.set("Store.Tools.bucket.Sell Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Sell Able")){
			Configuration.store.set("Store.Tools.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Buy Able")){
			Configuration.store.set("Store.Tools.water bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Buy Price")){
			Configuration.store.set("Store.Tools.water bucket.Buy Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Sell Price")){
			Configuration.store.set("Store.Tools.water bucket.Sell Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Sell Able")){
			Configuration.store.set("Store.Tools.lava bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Buy Able")){
			Configuration.store.set("Store.Tools.lava bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Buy Price")){
			Configuration.store.set("Store.Tools.lava bucket.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Sell Price")){
			Configuration.store.set("Store.Tools.lava bucket.Sell Price",70);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Sell Able")){
			Configuration.store.set("Store.Tools.milk bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Buy Able")){
			Configuration.store.set("Store.Tools.milk bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Buy Price")){
			Configuration.store.set("Store.Tools.milk bucket.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Sell Price")){
			Configuration.store.set("Store.Tools.milk bucket.Sell Price",60);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Sell Able")){
			Configuration.store.set("Store.Tools.bow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Buy Able")){
			Configuration.store.set("Store.Tools.bow.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Buy Price")){
			Configuration.store.set("Store.Tools.bow.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Sell Price")){
			Configuration.store.set("Store.Tools.bow.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Sell Able")){
			Configuration.store.set("Store.Tools.boat.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Buy Able")){
			Configuration.store.set("Store.Tools.boat.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Buy Price")){
			Configuration.store.set("Store.Tools.boat.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Sell Price")){
			Configuration.store.set("Store.Tools.boat.Sell Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Sell Able")){
			Configuration.store.set("Store.Tools.saddle.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Buy Able")){
			Configuration.store.set("Store.Tools.saddle.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Buy Price")){
			Configuration.store.set("Store.Tools.saddle.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Sell Price")){
			Configuration.store.set("Store.Tools.saddle.Sell Price",200);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Sell Able")){
			Configuration.store.set("Store.Tools.fishing rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Buy Able")){
			Configuration.store.set("Store.Tools.fishing rod.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Buy Price")){
			Configuration.store.set("Store.Tools.fishing rod.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Sell Price")){
			Configuration.store.set("Store.Tools.fishing rod.Sell Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Sell Able")){
			Configuration.store.set("Store.Tools.shears.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Buy Able")){
			Configuration.store.set("Store.Tools.shears.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Buy Price")){
			Configuration.store.set("Store.Tools.shears.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Sell Price")){
			Configuration.store.set("Store.Tools.shears.Sell Price",60);
		}
		
		if(!Configuration.store.contains("Store.Tools.flint and steel.Sell Able")){
			Configuration.store.set("Store.Tools.flint and steel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.flint and steel.Buy Able")){
			Configuration.store.set("Store.Tools.flint and steel.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.flint and steel.Buy Price")){
			Configuration.store.set("Store.Tools.flint and steel.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Tools.flint and steel.Sell Price")){
			Configuration.store.set("Store.Tools.flint and steel.Sell Price",40);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Sell Able")){
			Configuration.store.set("Store.Tools.bowl.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Buy Able")){
			Configuration.store.set("Store.Tools.bowl.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Buy Price")){
			Configuration.store.set("Store.Tools.bowl.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Sell Price")){
			Configuration.store.set("Store.Tools.bowl.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Sell Able")){
			Configuration.store.set("Store.Tools.stick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Buy Able")){
			Configuration.store.set("Store.Tools.stick.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Buy Price")){
			Configuration.store.set("Store.Tools.stick.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Sell Price")){
			Configuration.store.set("Store.Tools.stick.Sell Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Sell Able")){
			Configuration.store.set("Store.Tools.snow ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Buy Able")){
			Configuration.store.set("Store.Tools.snow ball.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Buy Price")){
			Configuration.store.set("Store.Tools.snow ball.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Sell Price")){
			Configuration.store.set("Store.Tools.snow ball.Sell Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.map.Sell Able")){
			Configuration.store.set("Store.Tools.map.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.map.Buy Able")){
			Configuration.store.set("Store.Tools.map.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.map.Buy Price")){
			Configuration.store.set("Store.Tools.map.Buy Price",300);
		}
		if(!Configuration.store.contains("Store.Tools.map.Sell Price")){
			Configuration.store.set("Store.Tools.map.Sell Price",300);
		}
		
		//Armour
		
		if(!Configuration.store.contains("Store.Armour.leather helmet.Sell Able")){
			Configuration.store.set("Store.Armour.leather helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather helmet.Buy Able")){
			Configuration.store.set("Store.Armour.leather helmet.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather helmet.Buy Price")){
			Configuration.store.set("Store.Armour.leather helmet.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Armour.leather helmet.Buy Price")){
			Configuration.store.set("Store.Armour.leather helmet.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.leather chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Buy Able")){
			Configuration.store.set("Store.Armour.leather chestplate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.leather chestplate.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.leather chestplate.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Sell Able")){
			Configuration.store.set("Store.Armour.leather leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Buy Able")){
			Configuration.store.set("Store.Armour.leather leggings.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Buy Price")){
			Configuration.store.set("Store.Armour.leather leggings.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Buy Price")){
			Configuration.store.set("Store.Armour.leather leggings.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Sell Able")){
			Configuration.store.set("Store.Armour.leather boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Buy Able")){
			Configuration.store.set("Store.Armour.leather boots.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Buy Price")){
			Configuration.store.set("Store.Armour.leather boots.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Buy Price")){
			Configuration.store.set("Store.Armour.leather boots.Buy Price",20);
		}
		
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Buy Able")){
			Configuration.store.set("Store.Armour.chainmail helmet.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail helmet.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail helmet.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Buy Able")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Buy Able")){
			Configuration.store.set("Store.Armour.chainmail leggings.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail leggings.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail leggings.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Buy Able")){
			Configuration.store.set("Store.Armour.chainmail boots.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail boots.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Buy Price")){
			Configuration.store.set("Store.Armour.chainmail boots.Buy Price",50);
		}
		
		if(!Configuration.store.contains("Store.Armour.iron helmet.Sell Able")){
			Configuration.store.set("Store.Armour.iron helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron helmet.Buy Able")){
			Configuration.store.set("Store.Armour.iron helmet.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron helmet.Buy Price")){
			Configuration.store.set("Store.Armour.iron helmet.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.iron helmet.Buy Price")){
			Configuration.store.set("Store.Armour.iron helmet.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.iron chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Buy Able")){
			Configuration.store.set("Store.Armour.iron chestplate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.iron chestplate.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.iron chestplate.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Sell Able")){
			Configuration.store.set("Store.Armour.iron leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Buy Able")){
			Configuration.store.set("Store.Armour.iron leggings.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Buy Price")){
			Configuration.store.set("Store.Armour.iron leggings.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Buy Price")){
			Configuration.store.set("Store.Armour.iron leggings.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Armour.iron boots.Sell Able")){
			Configuration.store.set("Store.Armour.iron boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron boots.Buy Able")){
			Configuration.store.set("Store.Armour.iron boots.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron boots.Buy Price")){
			Configuration.store.set("Store.Armour.iron boots.Buy Price",100);
		}
		
		if(!Configuration.store.contains("Store.Armour.gold helmet.Sell Able")){
			Configuration.store.set("Store.Armour.gold helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold helmet.Buy Able")){
			Configuration.store.set("Store.Armour.gold helmet.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold helmet.Buy Price")){
			Configuration.store.set("Store.Armour.gold helmet.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Armour.gold chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.gold chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold chestplate.Buy Able")){
			Configuration.store.set("Store.Armour.gold chestplate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.gold chestplate.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Armour.gold leggings.Sell Able")){
			Configuration.store.set("Store.Armour.gold leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold leggings.Buy Able")){
			Configuration.store.set("Store.Armour.gold leggings.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold leggings.Buy Price")){
			Configuration.store.set("Store.Armour.gold leggings.Buy Price",350);
		}
		if(!Configuration.store.contains("Store.Armour.gold boots.Sell Able")){
			Configuration.store.set("Store.Armour.gold boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold boots.Buy Able")){
			Configuration.store.set("Store.Armour.gold boots.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold boots.Buy Price")){
			Configuration.store.set("Store.Armour.gold boots.Buy Price",250);
		}
		
		if(!Configuration.store.contains("Store.Armour.diamond helmet.Sell Able")){
			Configuration.store.set("Store.Armour.diamond helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond helmet.Buy Able")){
			Configuration.store.set("Store.Armour.diamond helmet.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond helmet.Buy Price")){
			Configuration.store.set("Store.Armour.diamond helmet.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Armour.diamond chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.diamond chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond chestplate.Buy Able")){
			Configuration.store.set("Store.Armour.diamond chestplate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond chestplate.Buy Price")){
			Configuration.store.set("Store.Armour.diamond chestplate.Buy Price",1000);
		}
		if(!Configuration.store.contains("Store.Armour.diamond leggings.Sell Able")){
			Configuration.store.set("Store.Armour.diamond leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond leggings.Buy Able")){
			Configuration.store.set("Store.Armour.diamond leggings.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond leggings.Buy Price")){
			Configuration.store.set("Store.Armour.diamond leggings.Buy Price",700);
		}
		if(!Configuration.store.contains("Store.Armour.diamond boots.Sell Able")){
			Configuration.store.set("Store.Armour.diamond boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond boots.Buy Able")){
			Configuration.store.set("Store.Armour.diamond boots.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond boots.Buy Price")){
			Configuration.store.set("Store.Armour.diamond boots.Buy Price",500);
		}
		
		//mechanisms
		
		if(!Configuration.store.contains("Store.Mechanisms.redstone.Sell Able")){
			Configuration.store.set("Store.Mechanisms.redstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone.Buy Able")){
			Configuration.store.set("Store.Mechanisms.redstone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone.Buy Price")){
			Configuration.store.set("Store.Mechanisms.redstone.Buy Price",5);
		}
		if(!Configuration.store.contains("Store.Mechanisms.diode.Sell Able")){
			Configuration.store.set("Store.Mechanisms.diode.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.diode.Buy Able")){
			Configuration.store.set("Store.Mechanisms.diode.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.diode.Buy Price")){
			Configuration.store.set("Store.Mechanisms.diode.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston base.Sell Able")){
			Configuration.store.set("Store.Mechanisms.piston base.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston base.Buy Able")){
			Configuration.store.set("Store.Mechanisms.piston base.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston base.Buy Price")){
			Configuration.store.set("Store.Mechanisms.piston base.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston sticky base.Sell Able")){
			Configuration.store.set("Store.Mechanisms.piston sticky base.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston sticky base.Buy Able")){
			Configuration.store.set("Store.Mechanisms.piston sticky base.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston sticky base.Buy Price")){
			Configuration.store.set("Store.Mechanisms.piston sticky base.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Mechanisms.lever.Sell Able")){
			Configuration.store.set("Store.Mechanisms.lever.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.lever.Buy Able")){
			Configuration.store.set("Store.Mechanisms.lever.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.lever.Buy Price")){
			Configuration.store.set("Store.Mechanisms.lever.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood plate.Sell Able")){
			Configuration.store.set("Store.Mechanisms.wood plate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood plate.Buy Able")){
			Configuration.store.set("Store.Mechanisms.wood plate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood plate.Buy Price")){
			Configuration.store.set("Store.Mechanisms.wood plate.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone plate.Sell Able")){
			Configuration.store.set("Store.Mechanisms.stone plate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone plate.Buy Able")){
			Configuration.store.set("Store.Mechanisms.stone plate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone plate.Buy Price")){
			Configuration.store.set("Store.Mechanisms.stone plate.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.note block.Sell Able")){
			Configuration.store.set("Store.Mechanisms.note block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.note block.Buy Able")){
			Configuration.store.set("Store.Mechanisms.note block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.note block.Buy Price")){
			Configuration.store.set("Store.Mechanisms.note block.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Mechanisms.detector rail.Sell Able")){
			Configuration.store.set("Store.Mechanisms.detector rail.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.detector rail.Buy Able")){
			Configuration.store.set("Store.Mechanisms.detector rail.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.detector rail.Buy Price")){
			Configuration.store.set("Store.Mechanisms.detector rail.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone torch off.Sell Able")){
			Configuration.store.set("Store.Mechanisms.redstone torch off.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone torch off.Buy Able")){
			Configuration.store.set("Store.Mechanisms.redstone torch off.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone torch off.Buy Price")){
			Configuration.store.set("Store.Mechanisms.redstone torch off.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.powered rail.Sell Able")){
			Configuration.store.set("Store.Mechanisms.powered rail.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.powered rail.Buy Able")){
			Configuration.store.set("Store.Mechanisms.powered rail.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.powered rail.Buy Price")){
			Configuration.store.set("Store.Mechanisms.powered rail.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Mechanisms.rails.Sell Able")){
			Configuration.store.set("Store.Mechanisms.rails.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.rails.Buy Able")){
			Configuration.store.set("Store.Mechanisms.rails.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.rails.Buy Price")){
			Configuration.store.set("Store.Mechanisms.rails.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.wood door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood door.Buy Able")){
			Configuration.store.set("Store.Mechanisms.wood door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood door.Buy Price")){
			Configuration.store.set("Store.Mechanisms.wood door.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Mechanisms.iron door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.iron door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.iron door.Buy Able")){
			Configuration.store.set("Store.Mechanisms.iron door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.iron door.Buy Price")){
			Configuration.store.set("Store.Mechanisms.iron door.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Mechanisms.dispenser.Sell Able")){
			Configuration.store.set("Store.Mechanisms.dispenser.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.dispenser.Buy Able")){
			Configuration.store.set("Store.Mechanisms.dispenser.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.dispenser.Buy Price")){
			Configuration.store.set("Store.Mechanisms.dispenser.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone button.Sell Able")){
			Configuration.store.set("Store.Mechanisms.stone button.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone button.Buy Able")){
			Configuration.store.set("Store.Mechanisms.stone button.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone button.Buy Price")){
			Configuration.store.set("Store.Mechanisms.stone button.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Mechanisms.trap door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.trap door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.trap door.Buy Able")){
			Configuration.store.set("Store.Mechanisms.trap door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.trap door.Buy Price")){
			Configuration.store.set("Store.Mechanisms.trap door.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Mechanisms.tnt.Sell Able")){
			Configuration.store.set("Store.Mechanisms.tnt.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.tnt.Buy Able")){
			Configuration.store.set("Store.Mechanisms.tnt.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.tnt.Buy Price")){
			Configuration.store.set("Store.Mechanisms.tnt.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone lamp off.Sell Able")){
			Configuration.store.set("Store.Mechanisms.redstone lamp off.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone lamp off.Buy Able")){
			Configuration.store.set("Store.Mechanisms.redstone lamp off.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone lamp off.Price")){
			Configuration.store.set("Store.Mechanisms.redstone lamp off.Price",100);
		}
		
		//gardening
		
		if(!Configuration.store.contains("Store.Gardening.wood hoe.Sell Able")){
			Configuration.store.set("Store.Gardening.wood hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wood hoe.Buy Able")){
			Configuration.store.set("Store.Gardening.wood hoe.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wood hoe.Buy Price")){
			Configuration.store.set("Store.Gardening.wood hoe.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Gardening.bucket.Sell Able")){
			Configuration.store.set("Store.Gardening.bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.bucket.Buy Able")){
			Configuration.store.set("Store.Gardening.bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.bucket.Buy Price")){
			Configuration.store.set("Store.Gardening.bucket.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.water bucket.Sell Able")){
			Configuration.store.set("Store.Gardening.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water bucket.Buy Able")){
			Configuration.store.set("Store.Gardening.water bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water bucket.Buy Price")){
			Configuration.store.set("Store.Gardening.water bucket.Buy Price",55);
		}
		if(!Configuration.store.contains("Store.Gardening.brown mushroom.Sell Able")){
			Configuration.store.set("Store.Gardening.brown mushroom.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.brown mushroom.Buy Able")){
			Configuration.store.set("Store.Gardening.brown mushroom.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.brown mushroom.Buy Price")){
			Configuration.store.set("Store.Gardening.brown mushroom.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.red mushroom.Sell Able")){
			Configuration.store.set("Store.Gardening.red mushroom.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red mushroom.Buy Able")){
			Configuration.store.set("Store.Gardening.red mushroom.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red mushroom.Buy Price")){
			Configuration.store.set("Store.Gardening.red mushroom.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.red rose.Sell Able")){
			Configuration.store.set("Store.Gardening.red rose.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red rose.Buy Able")){
			Configuration.store.set("Store.Gardening.red rose.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red rose.Buy Price")){
			Configuration.store.set("Store.Gardening.red rose.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.yellow flower.Sell Able")){
			Configuration.store.set("Store.Gardening.yellow flower.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.yellow flower.Buy Able")){
			Configuration.store.set("Store.Gardening.yellow flower.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.yellow flower.Buy Price")){
			Configuration.store.set("Store.Gardening.yellow flower.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.cactus.Sell Able")){
			Configuration.store.set("Store.Gardening.cactus.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.cactus.Buy Able")){
			Configuration.store.set("Store.Gardening.cactus.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.cactus.Buy Price")){
			Configuration.store.set("Store.Gardening.cactus.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.sapling.Sell Able")){
			Configuration.store.set("Store.Gardening.sapling.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sapling.Buy Able")){
			Configuration.store.set("Store.Gardening.sapling.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sapling.Buy Price")){
			Configuration.store.set("Store.Gardening.sapling.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.seeds.Buy Able")){
			Configuration.store.set("Store.Gardening.seeds.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.seeds.Buy Price")){
			Configuration.store.set("Store.Gardening.seeds.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.sugar cane.Sell Able")){
			Configuration.store.set("Store.Gardening.sugar cane.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sugar cane.Buy Able")){
			Configuration.store.set("Store.Gardening.sugar cane.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sugar cane.Buy Price")){
			Configuration.store.set("Store.Gardening.sugar cane.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.wheat.Sell Able")){
			Configuration.store.set("Store.Gardening.wheat.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wheat.Buy Able")){
			Configuration.store.set("Store.Gardening.wheat.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wheat.Buy Price")){
			Configuration.store.set("Store.Gardening.wheat.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.melon seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.melon seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon seeds.Buy Able")){
			Configuration.store.set("Store.Gardening.melon seeds.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon seeds.Buy Price")){
			Configuration.store.set("Store.Gardening.melon seeds.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Gardening.melon block.Sell Able")){
			Configuration.store.set("Store.Gardening.melon block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon block.Buy Able")){
			Configuration.store.set("Store.Gardening.melon block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon block.Buy Price")){
			Configuration.store.set("Store.Gardening.melon block.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.pumpkin seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin seeds.Buy Able")){
			Configuration.store.set("Store.Gardening.pumpkin seeds.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin seeds.Buy Price")){
			Configuration.store.set("Store.Gardening.pumpkin seeds.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin.Sell Able")){
			Configuration.store.set("Store.Gardening.pumpkin.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin.Buy Able")){
			Configuration.store.set("Store.Gardening.pumpkin.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin.Buy Price")){
			Configuration.store.set("Store.Gardening.pumpkin.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Gardening.soil.Sell Able")){
			Configuration.store.set("Store.Gardening.soil.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Gardening.soil.Buy Able")){
			Configuration.store.set("Store.Gardening.soil.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Gardening.soil.Buy Price")){
			Configuration.store.set("Store.Gardening.soil.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.long grass.Sell Able")){
			Configuration.store.set("Store.Gardening.long grass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.long grass.Buy Able")){
			Configuration.store.set("Store.Gardening.long grass.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.long grass.Buy Price")){
			Configuration.store.set("Store.Gardening.long grass.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.dead bush.Sell Able")){
			Configuration.store.set("Store.Gardening.dead bush.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.dead bush.Buy Able")){
			Configuration.store.set("Store.Gardening.dead bush.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.dead bush.Buy Price")){
			Configuration.store.set("Store.Gardening.dead bush.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.vine.Sell Able")){
			Configuration.store.set("Store.Gardening.vine.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.vine.Buy Able")){
			Configuration.store.set("Store.Gardening.vine.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.vine.Buy Price")){
			Configuration.store.set("Store.Gardening.vine.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.water lily.Sell Able")){
			Configuration.store.set("Store.Gardening.water lily.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water lily.Buy Able")){
			Configuration.store.set("Store.Gardening.water lily.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water lily.Buy Price")){
			Configuration.store.set("Store.Gardening.water lily.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.nether warts.Sell Able")){
			Configuration.store.set("Store.Gardening.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.nether warts.Buy Able")){
			Configuration.store.set("Store.Gardening.nether warts.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.nether warts.Buy Price")){
			Configuration.store.set("Store.Gardening.nether warts.Buy Price",60);
		}
		
		//furniture
		
		if(!Configuration.store.contains("Store.Furniture.bed.Sell Able")){
			Configuration.store.set("Store.Furniture.bed.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bed.Buy Able")){
			Configuration.store.set("Store.Furniture.bed.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bed.Buy Price")){
			Configuration.store.set("Store.Furniture.bed.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Furniture.bookshelf.Sell Able")){
			Configuration.store.set("Store.Furniture.bookshelf.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bookshelf.Buy Able")){
			Configuration.store.set("Store.Furniture.bookshelf.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bookshelf.Buy Price")){
			Configuration.store.set("Store.Furniture.bookshelf.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.brewing stand item.Sell Able")){
			Configuration.store.set("Store.Furniture.brewing stand item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brewing stand item.Buy Able")){
			Configuration.store.set("Store.Furniture.brewing stand item.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brewing stand item.Buy Price")){
			Configuration.store.set("Store.Furniture.brewing stand item.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Furniture.brick stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brick stairs.Buy Able")){
			Configuration.store.set("Store.Furniture.brick stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brick stairs.Buy Price")){
			Configuration.store.set("Store.Furniture.brick stairs.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.cauldron item.Sell Able")){
			Configuration.store.set("Store.Furniture.cauldron item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cauldron item.Buy Able")){
			Configuration.store.set("Store.Furniture.cauldron item.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cauldron item.Buy Price")){
			Configuration.store.set("Store.Furniture.cauldron item.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Furniture.workbench.Sell Able")){
			Configuration.store.set("Store.Furniture.workbench.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.workbench.Buy Able")){
			Configuration.store.set("Store.Furniture.workbench.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.workbench.Buy Price")){
			Configuration.store.set("Store.Furniture.workbench.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.chest.Sell Able")){
			Configuration.store.set("Store.Furniture.chest.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.chest.Buy Able")){
			Configuration.store.set("Store.Furniture.chest.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.chest.Buy Price")){
			Configuration.store.set("Store.Furniture.chest.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.cobblestone stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.cobblestone stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cobblestone stairs.Buy Able")){
			Configuration.store.set("Store.Furniture.cobblestone stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cobblestone stairs.Buy Price")){
			Configuration.store.set("Store.Furniture.cobblestone stairs.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.dispenser.Sell Able")){
			Configuration.store.set("Store.Furniture.dispenser.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.dispenser.Buy Able")){
			Configuration.store.set("Store.Furniture.dispenser.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.dispenser.Buy Price")){
			Configuration.store.set("Store.Furniture.dispenser.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.enchantment table.Sell Able")){
			Configuration.store.set("Store.Furniture.enchantment table.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.enchantment table.Buy Able")){
			Configuration.store.set("Store.Furniture.enchantment table.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.enchantment table.Buy Price")){
			Configuration.store.set("Store.Furniture.enchantment table.Buy Price",300);
		}
		if(!Configuration.store.contains("Store.Furniture.fence.Sell Able")){
			Configuration.store.set("Store.Furniture.fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence.Buy Able")){
			Configuration.store.set("Store.Furniture.fence.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence.Buy Price")){
			Configuration.store.set("Store.Furniture.fence.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.fence gate.Sell Able")){
			Configuration.store.set("Store.Furniture.fence gate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence gate.Buy Able")){
			Configuration.store.set("Store.Furniture.fence gate.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence gate.Buy Price")){
			Configuration.store.set("Store.Furniture.fence gate.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.furnace.Sell Able")){
			Configuration.store.set("Store.Furniture.furnace.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.furnace.Buy Able")){
			Configuration.store.set("Store.Furniture.furnace.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.furnace.Buy Price")){
			Configuration.store.set("Store.Furniture.furnace.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Furniture.jukebox.Sell Able")){
			Configuration.store.set("Store.Furniture.jukebox.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jukebox.Buy Able")){
			Configuration.store.set("Store.Furniture.jukebox.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jukebox.Buy Price")){
			Configuration.store.set("Store.Furniture.jukebox.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.jack o lantern.Sell Able")){
			Configuration.store.set("Store.Furniture.jack o lantern.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jack o lantern.Buy Able")){
			Configuration.store.set("Store.Furniture.jack o lantern.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jack o lantern.Buy Price")){
			Configuration.store.set("Store.Furniture.jack o lantern.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.ladder.Sell Able")){
			Configuration.store.set("Store.Furniture.ladder.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.ladder.Buy Able")){
			Configuration.store.set("Store.Furniture.ladder.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.ladder.Buy Price")){
			Configuration.store.set("Store.Furniture.ladder.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.nether brick stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.nether brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether brick stairs.Buy Able")){
			Configuration.store.set("Store.Furniture.nether brick stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether brick stairs.Buy Price")){
			Configuration.store.set("Store.Furniture.nether brick stairs.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.nether fence.Sell Able")){
			Configuration.store.set("Store.Furniture.nether fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether fence.Buy Able")){
			Configuration.store.set("Store.Furniture.nether fence.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether fence.Buy Price")){
			Configuration.store.set("Store.Furniture.nether fence.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.note block.Sell Able")){
			Configuration.store.set("Store.Furniture.note block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.note block.Buy Able")){
			Configuration.store.set("Store.Furniture.note block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.note block.Buy Price")){
			Configuration.store.set("Store.Furniture.note block.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.painting.Sell Able")){
			Configuration.store.set("Store.Furniture.painting.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.painting.Buy Able")){
			Configuration.store.set("Store.Furniture.painting.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.painting.Buy Price")){
			Configuration.store.set("Store.Furniture.painting.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.sign.Sell Able")){
			Configuration.store.set("Store.Furniture.sign.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.sign.Buy Able")){
			Configuration.store.set("Store.Furniture.sign.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.sign.Buy Price")){
			Configuration.store.set("Store.Furniture.sign.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.wood door.Sell Able")){
			Configuration.store.set("Store.Furniture.wood door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood door.Buy Able")){
			Configuration.store.set("Store.Furniture.wood door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood door.Buy Price")){
			Configuration.store.set("Store.Furniture.wood door.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.iron door.Sell Able")){
			Configuration.store.set("Store.Furniture.iron door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron door.Buy Able")){
			Configuration.store.set("Store.Furniture.iron door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron door.Buy Price")){
			Configuration.store.set("Store.Furniture.iron door.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Furniture.torch.Sell Able")){
			Configuration.store.set("Store.Furniture.torch.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.torch.Buy Able")){
			Configuration.store.set("Store.Furniture.torch.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.torch.Buy Price")){
			Configuration.store.set("Store.Furniture.torch.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Furniture.trap door.Sell Able")){
			Configuration.store.set("Store.Furniture.trap door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.trap door.Buy Able")){
			Configuration.store.set("Store.Furniture.trap door.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.trap door.Buy Price")){
			Configuration.store.set("Store.Furniture.trap door.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.wood stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.wood stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood stairs.Buy Able")){
			Configuration.store.set("Store.Furniture.wood stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood stairs.Buy Price")){
			Configuration.store.set("Store.Furniture.wood stairs.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.smooth stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.smooth stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.smooth stairs.Buy Able")){
			Configuration.store.set("Store.Furniture.smooth stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.smooth stairs.Buy Price")){
			Configuration.store.set("Store.Furniture.smooth stairs.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.iron fence.Sell Able")){
			Configuration.store.set("Store.Furniture.iron fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron fence.Buy Able")){
			Configuration.store.set("Store.Furniture.iron fence.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron fence.Buy Price")){
			Configuration.store.set("Store.Furniture.iron fence.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.thin glass.Sell Able")){
			Configuration.store.set("Store.Furniture.thin glass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.thin glass.Buy Able")){
			Configuration.store.set("Store.Furniture.thin glass.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.thin glass.Buy Price")){
			Configuration.store.set("Store.Furniture.thin glass.Buy Price",40);
		}
		
		
		//materials
		
		if(!Configuration.store.contains("Store.Materials.stone.Sell Able")){
			Configuration.store.set("Store.Materials.stone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.stone.Buy Able")){
			Configuration.store.set("Store.Materials.stone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.stone.Buy Price")){
			Configuration.store.set("Store.Materials.stone.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.grass.Sell Able")){
			Configuration.store.set("Store.Materials.grass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.grass.Buy Able")){
			Configuration.store.set("Store.Materials.grass.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.grass.Buy Price")){
			Configuration.store.set("Store.Materials.grass.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.dirt.Sell Able")){
			Configuration.store.set("Store.Materials.dirt.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.dirt.Buy Able")){
			Configuration.store.set("Store.Materials.dirt.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.dirt.Buy Price")){
			Configuration.store.set("Store.Materials.dirt.Buy Price",5);
		}
		if(!Configuration.store.contains("Store.Materials.cobblestone.Sell Able")){
			Configuration.store.set("Store.Materials.cobblestone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.cobblestone.Buy Able")){
			Configuration.store.set("Store.Materials.cobblestone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.cobblestone.Buy Price")){
			Configuration.store.set("Store.Materials.cobblestone.Buy Price",5);
		}
		if(!Configuration.store.contains("Store.Materials.wood.Sell Able")){
			Configuration.store.set("Store.Materials.wood.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.wood.Buy Able")){
			Configuration.store.set("Store.Materials.wood.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.wood.Buy Price")){
			Configuration.store.set("Store.Materials.wood.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.bedrock.Sell Able")){
			Configuration.store.set("Store.Materials.bedrock.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.bedrock.Buy Able")){
			Configuration.store.set("Store.Materials.bedrock.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.bedrock.Buy Price")){
			Configuration.store.set("Store.Materials.bedrock.Buy Price",10000);
		}
		if(!Configuration.store.contains("Store.Materials.water.Sell Able")){
			Configuration.store.set("Store.Materials.water.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.water.Buy Able")){
			Configuration.store.set("Store.Materials.water.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.water.Buy Price")){
			Configuration.store.set("Store.Materials.water.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.stationary water.Sell Able")){
			Configuration.store.set("Store.Materials.stationary water.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.stationary water.Buy Able")){
			Configuration.store.set("Store.Materials.stationary water.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.stationary water.Buy Price")){
			Configuration.store.set("Store.Materials.stationary water.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Materials.lava.Sell Able")){
			Configuration.store.set("Store.Materials.lava.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.lava.Buy Able")){
			Configuration.store.set("Store.Materials.lava.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.lava.Buy Price")){
			Configuration.store.set("Store.Materials.lava.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.stationary lava.Sell Able")){
			Configuration.store.set("Store.Materials.stationary lava.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.stationary lava.Buy Able")){
			Configuration.store.set("Store.Materials.stationary lava.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.stationary lava.Buy Price")){
			Configuration.store.set("Store.Materials.stationary lava.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Materials.sand.Sell Able")){
			Configuration.store.set("Store.Materials.sand.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sand.Buy Able")){
			Configuration.store.set("Store.Materials.sand.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sand.Buy Price")){
			Configuration.store.set("Store.Materials.sand.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.gravel.Sell Able")){
			Configuration.store.set("Store.Materials.gravel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.gravel.Buy Able")){
			Configuration.store.set("Store.Materials.gravel.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.gravel.Buy Price")){
			Configuration.store.set("Store.Materials.gravel.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.log.Sell Able")){
			Configuration.store.set("Store.Materials.log.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.log.Buy Able")){
			Configuration.store.set("Store.Materials.log.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.log.Buy Price")){
			Configuration.store.set("Store.Materials.log.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.leaves.Sell Able")){
			Configuration.store.set("Store.Materials.leaves.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.leaves.Buy Able")){
			Configuration.store.set("Store.Materials.leaves.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.leaves.Buy Price")){
			Configuration.store.set("Store.Materials.leaves.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.sponge.Sell Able")){
			Configuration.store.set("Store.Materials.sponge.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sponge.Buy Able")){
			Configuration.store.set("Store.Materials.sponge.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sponge.Buy Price")){
			Configuration.store.set("Store.Materials.sponge.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Materials.glass.Sell Able")){
			Configuration.store.set("Store.Materials.glass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.glass.Buy Able")){
			Configuration.store.set("Store.Materials.glass.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.glass.Buy Price")){
			Configuration.store.set("Store.Materials.glass.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.sandstone.Sell Able")){
			Configuration.store.set("Store.Materials.sandstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sandstone.Buy Able")){
			Configuration.store.set("Store.Materials.sandstone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sandstone.Buy Price")){
			Configuration.store.set("Store.Materials.sandstone.Buy Price",25);
		}
		if(!Configuration.store.contains("Store.Materials.double step.Sell Able")){
			Configuration.store.set("Store.Materials.double step.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.double step.Buy Able")){
			Configuration.store.set("Store.Materials.double step.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.double step.Buy Price")){
			Configuration.store.set("Store.Materials.double step.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.step.Sell Able")){
			Configuration.store.set("Store.Materials.step.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.step.Buy Able")){
			Configuration.store.set("Store.Materials.step.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.step.Buy Price")){
			Configuration.store.set("Store.Materials.step.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.brick.Sell Able")){
			Configuration.store.set("Store.Materials.brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.brick.Buy Able")){
			Configuration.store.set("Store.Materials.brick.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.brick.Buy Price")){
			Configuration.store.set("Store.Materials.brick.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.mossy cobblestone.Sell Able")){
			Configuration.store.set("Store.Materials.mossy cobblestone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mossy cobblestone.Buy Able")){
			Configuration.store.set("Store.Materials.mossy cobblestone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mossy cobblestone.Price")){
			Configuration.store.set("Store.Materials.mossy cobblestone.Price",35);
		}
		if(!Configuration.store.contains("Store.Materials.obsidian.Sell Able")){
			Configuration.store.set("Store.Materials.obsidian.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.obsidian.Buy Able")){
			Configuration.store.set("Store.Materials.obsidian.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.obsidian.Buy Price")){
			Configuration.store.set("Store.Materials.obsidian.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.snow.Sell Able")){
			Configuration.store.set("Store.Materials.snow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow.Buy Able")){
			Configuration.store.set("Store.Materials.snow.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow.Buy Price")){
			Configuration.store.set("Store.Materials.snow.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Materials.ice.Sell Able")){
			Configuration.store.set("Store.Materials.ice.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ice.Buy Able")){
			Configuration.store.set("Store.Materials.ice.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ice.Buy Price")){
			Configuration.store.set("Store.Materials.ice.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Materials.snow block.Sell Able")){
			Configuration.store.set("Store.Materials.snow block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow block.Buy Able")){
			Configuration.store.set("Store.Materials.snow block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow block.Buy Price")){
			Configuration.store.set("Store.Materials.snow block.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.clay.Sell Able")){
			Configuration.store.set("Store.Materials.clay.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.clay.Buy Able")){
			Configuration.store.set("Store.Materials.clay.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.clay.Buy Price")){
			Configuration.store.set("Store.Materials.clay.Buy Price",35);
		}
		if(!Configuration.store.contains("Store.Materials.smooth brick.Sell Able")){
			Configuration.store.set("Store.Materials.smooth brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.smooth brick.Buy Able")){
			Configuration.store.set("Store.Materials.smooth brick.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.smooth brick.Buy Price")){
			Configuration.store.set("Store.Materials.smooth brick.Buy Price",110);
		}
		if(!Configuration.store.contains("Store.Materials.mycel.Sell Able")){
			Configuration.store.set("Store.Materials.mycel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mycel.Buy Able")){
			Configuration.store.set("Store.Materials.mycel.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mycel.Buy Price")){
			Configuration.store.set("Store.Materials.mycel.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Materials.ender stone.Sell Able")){
			Configuration.store.set("Store.Materials.ender stone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ender stone.Buy Able")){
			Configuration.store.set("Store.Materials.ender stone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ender stone.Buy Price")){
			Configuration.store.set("Store.Materials.ender stone.Buy Price",30);
		}
		
		
		//rawmaterials
		
		if(!Configuration.store.contains("Store.Raw Materials.coal.Sell Able")){
			Configuration.store.set("Store.Raw Materials.coal.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.coal.Buy Able")){
			Configuration.store.set("Store.Raw Materials.coal.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.coal.Buy Price")){
			Configuration.store.set("Store.Raw Materials.coal.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron ingot.Sell Able")){
			Configuration.store.set("Store.Raw Materials.iron ingot.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron ingot.Buy Able")){
			Configuration.store.set("Store.Raw Materials.iron ingot.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron ingot.Buy Price")){
			Configuration.store.set("Store.Raw Materials.iron ingot.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold ingot.Sell Able")){
			Configuration.store.set("Store.Raw Materials.gold ingot.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold ingot.Buy Able")){
			Configuration.store.set("Store.Raw Materials.gold ingot.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold ingot.Buy Price")){
			Configuration.store.set("Store.Raw Materials.gold ingot.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond.Sell Able")){
			Configuration.store.set("Store.Raw Materials.diamond.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond.Buy Able")){
			Configuration.store.set("Store.Raw Materials.diamond.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond.Buy Price")){
			Configuration.store.set("Store.Raw Materials.diamond.Buy Price",400);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay ball.Sell Able")){
			Configuration.store.set("Store.Raw Materials.clay ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay ball.Buy Able")){
			Configuration.store.set("Store.Raw Materials.clay ball.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay ball.Buy Price")){
			Configuration.store.set("Store.Raw Materials.clay ball.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay brick.Sell Able")){
			Configuration.store.set("Store.Raw Materials.clay brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay brick.Buy Able")){
			Configuration.store.set("Store.Raw Materials.clay brick.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay brick.Buy Price")){
			Configuration.store.set("Store.Raw Materials.clay brick.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Raw Materials.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Raw Materials.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.glowstone dust.Buy Able")){
			Configuration.store.set("Store.Raw Materials.glowstone dust.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.glowstone dust.Buy Price")){
			Configuration.store.set("Store.Raw Materials.glowstone dust.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Raw Materials.flint.Sell Able")){
			Configuration.store.set("Store.Raw Materials.flint.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.flint.Buy Able")){
			Configuration.store.set("Store.Raw Materials.flint.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.flint.Buy Price")){
			Configuration.store.set("Store.Raw Materials.flint.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Raw Materials.paper.Sell Able")){
			Configuration.store.set("Store.Raw Materials.paper.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.paper.Buy Able")){
			Configuration.store.set("Store.Raw Materials.paper.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.paper.Buy Price")){
			Configuration.store.set("Store.Raw Materials.paper.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Raw Materials.book.Sell Able")){
			Configuration.store.set("Store.Raw Materials.book.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.book.Buy Able")){
			Configuration.store.set("Store.Raw Materials.book.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.book.Buy Price")){
			Configuration.store.set("Store.Raw Materials.book.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Raw Materials.snow ball.Sell Able")){
			Configuration.store.set("Store.Raw Materials.snow ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.snow ball.Buy Able")){
			Configuration.store.set("Store.Raw Materials.snow ball.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.snow ball.Buy Price")){
			Configuration.store.set("Store.Raw Materials.snow ball.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Raw Materials.sugar.Sell Able")){
			Configuration.store.set("Store.Raw Materials.sugar.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.sugar.Buy Able")){
			Configuration.store.set("Store.Raw Materials.sugar.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.sugar.Buy Price")){
			Configuration.store.set("Store.Raw Materials.sugar.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond block.Sell Able")){
			Configuration.store.set("Store.Raw Materials.diamond block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond block.Buy Able")){
			Configuration.store.set("Store.Raw Materials.diamond block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond block.Buy Price")){
			Configuration.store.set("Store.Raw Materials.diamond block.Buy Price",17500);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron block.Sell Able")){
			Configuration.store.set("Store.Raw Materials.iron block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron block.Buy Able")){
			Configuration.store.set("Store.Raw Materials.iron block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron block.Buy Price")){
			Configuration.store.set("Store.Raw Materials.iron block.Buy Price",2250);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold block.Sell Able")){
			Configuration.store.set("Store.Raw Materials.gold block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold block.Buy Able")){
			Configuration.store.set("Store.Raw Materials.gold block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold block.Buy Price")){
			Configuration.store.set("Store.Raw Materials.gold block.Buy Price",4500);
		}
		if(!Configuration.store.contains("Store.Raw Materials.lapis block.Sell Able")){
			Configuration.store.set("Store.Raw Materials.lapis block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.lapis block.Buy Able")){
			Configuration.store.set("Store.Raw Materials.lapis block.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.lapis block.Buy Price")){
			Configuration.store.set("Store.Raw Materials.lapis block.Buy Price",1000);
		}
		
		//the end
		
		if(!Configuration.store.contains("Store.The End.ender portal frame.Sell Able")){
			Configuration.store.set("Store.The End.ender portal frame.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.The End.ender portal frame.Buy Able")){
			Configuration.store.set("Store.The End.ender portal frame.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.The End.ender portal frame.Buy Price")){
			Configuration.store.set("Store.The End.ender portal frame.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.The End.dragon egg.Sell Able")){
			Configuration.store.set("Store.The End.dragon egg.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.The End.dragon egg.Buy Able")){
			Configuration.store.set("Store.The End.dragon egg.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.The End.dragon egg.Buy Price")){
			Configuration.store.set("Store.The End.dragon egg.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.The End.ender stone.Sell Able")){
			Configuration.store.set("Store.The End.ender stone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.The End.ender stone.Buy Able")){
			Configuration.store.set("Store.The End.ender stone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.The End.ender stone.Buy Price")){
			Configuration.store.set("Store.The End.ender stone.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.The End.ender pearl.Sell Able")){
			Configuration.store.set("Store.The End.ender pearl.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.The End.ender pearl.Buy Able")){
			Configuration.store.set("Store.The End.ender pearl.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.The End.ender pearl.Buy Price")){
			Configuration.store.set("Store.The End.ender pearl.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.The End.eye of ender.Sell Able")){
			Configuration.store.set("Store.The End.eye of ender.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.The End.eye of ender.Buy Able")){
			Configuration.store.set("Store.The End.eye of ender.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.The End.eye of ender.Buy Price")){
			Configuration.store.set("Store.The End.eye of ender.Buy Price",70);
		}
		
		//ores
		
		if(!Configuration.store.contains("Store.Ores.gold ore.Sell Able")){
			Configuration.store.set("Store.Ores.gold ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.gold ore.Buy Able")){
			Configuration.store.set("Store.Ores.gold ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.gold ore.Buy Price")){
			Configuration.store.set("Store.Ores.gold ore.Buy Price",500);
		}
		if(!Configuration.store.contains("Store.Ores.diamond ore.Sell Able")){
			Configuration.store.set("Store.Ores.diamond ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.diamond ore.Buy Able")){
			Configuration.store.set("Store.Ores.diamond ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.diamond ore.Buy Price")){
			Configuration.store.set("Store.Ores.diamond ore.Buy Price",2000);
		}
		if(!Configuration.store.contains("Store.Ores.redstone ore.Sell Able")){
			Configuration.store.set("Store.Ores.redstone ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.redstone ore.Buy Able")){
			Configuration.store.set("Store.Ores.redstone ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.redstone ore.Buy Price")){
			Configuration.store.set("Store.Ores.redstone ore.Buy Price",300);
		}
		if(!Configuration.store.contains("Store.Ores.iron ore.Sell Able")){
			Configuration.store.set("Store.Ores.iron ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.iron ore.Buy Able")){
			Configuration.store.set("Store.Ores.iron ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.iron ore.Buy Price")){
			Configuration.store.set("Store.Ores.iron ore.Buy Price",250);
		}
		if(!Configuration.store.contains("Store.Ores.coal ore.Sell Able")){
			Configuration.store.set("Store.Ores.coal ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.coal ore.Buy Able")){
			Configuration.store.set("Store.Ores.coal ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.coal ore.Buy Price")){
			Configuration.store.set("Store.Ores.coal ore.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Ores.lapis ore.Sell Able")){
			Configuration.store.set("Store.Ores.lapis ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.lapis ore.Buy Able")){
			Configuration.store.set("Store.Ores.lapis ore.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.lapis ore.Buy Price")){
			Configuration.store.set("Store.Ores.lapis ore.Buy Price",150);
		}
		
		
		
		//mobdrops
		
		if(!Configuration.store.contains("Store.Mob Drops.string.Sell Able")){
			Configuration.store.set("Store.Mob Drops.string.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.string.Buy Able")){
			Configuration.store.set("Store.Mob Drops.string.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.string.Buy Price")){
			Configuration.store.set("Store.Mob Drops.string.Buy Price",15);
		}
		if(!Configuration.store.contains("Store.Mob Drops.leather.Sell Able")){
			Configuration.store.set("Store.Mob Drops.leather.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.leather.Buy Able")){
			Configuration.store.set("Store.Mob Drops.leather.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.leather.Buy Price")){
			Configuration.store.set("Store.Mob Drops.leather.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.feather.Sell Able")){
			Configuration.store.set("Store.Mob Drops.feather.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.feather.Buy Able")){
			Configuration.store.set("Store.Mob Drops.feather.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.feather.Buy Price")){
			Configuration.store.set("Store.Mob Drops.feather.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Mob Drops.arrow.Sell Able")){
			Configuration.store.set("Store.Mob Drops.arrow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.arrow.Buy Able")){
			Configuration.store.set("Store.Mob Drops.arrow.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.arrow.Buy Price")){
			Configuration.store.set("Store.Mob Drops.arrow.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Mob Drops.egg.Sell Able")){
			Configuration.store.set("Store.Mob Drops.egg.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.egg.Buy Able")){
			Configuration.store.set("Store.Mob Drops.egg.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.egg.Buy Price")){
			Configuration.store.set("Store.Mob Drops.egg.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Mob Drops.blaze rod.Sell Able")){
			Configuration.store.set("Store.Mob Drops.blaze rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.blaze rod.Buy Able")){
			Configuration.store.set("Store.Mob Drops.blaze rod.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.blaze rod.Buy Price")){
			Configuration.store.set("Store.Mob Drops.blaze rod.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ghast tear.Sell Able")){
			Configuration.store.set("Store.Mob Drops.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ghast tear.Buy Able")){
			Configuration.store.set("Store.Mob Drops.ghast tear.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ghast tear.Buy Price")){
			Configuration.store.set("Store.Mob Drops.ghast tear.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Mob Drops.gold nugget.Sell Able")){
			Configuration.store.set("Store.Mob Drops.gold nugget.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.gold nugget.Buy Able")){
			Configuration.store.set("Store.Mob Drops.gold nugget.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.gold nugget.Buy Price")){
			Configuration.store.set("Store.Mob Drops.gold nugget.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Mob Drops.rotten flesh.Sell Able")){
			Configuration.store.set("Store.Mob Drops.rotten flesh.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.rotten flesh.Buy Able")){
			Configuration.store.set("Store.Mob Drops.rotten flesh.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.rotten flesh.Buy Price")){
			Configuration.store.set("Store.Mob Drops.rotten flesh.Buy Price",5);
		}
		if(!Configuration.store.contains("Store.Mob Drops.bone.Sell Able")){
			Configuration.store.set("Store.Mob Drops.bone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.bone.Buy Able")){
			Configuration.store.set("Store.Mob Drops.bone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.bone.Buy Price")){
			Configuration.store.set("Store.Mob Drops.bone.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.sulphur.Sell Able")){
			Configuration.store.set("Store.Mob Drops.sulphur.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.sulphur.Buy Able")){
			Configuration.store.set("Store.Mob Drops.sulphur.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.sulphur.Buy Price")){
			Configuration.store.set("Store.Mob Drops.sulphur.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.spider eye.Sell Able")){
			Configuration.store.set("Store.Mob Drops.spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.spider eye.Buy Able")){
			Configuration.store.set("Store.Mob Drops.spider eye.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.spider eye.Buy Price")){
			Configuration.store.set("Store.Mob Drops.spider eye.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ender pearl.Sell Able")){
			Configuration.store.set("Store.Mob Drops.ender pearl.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ender pearl.Buy Able")){
			Configuration.store.set("Store.Mob Drops.ender pearl.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ender pearl.Buy Price")){
			Configuration.store.set("Store.Mob Drops.ender pearl.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Mob Drops.slime ball.Sell Able")){
			Configuration.store.set("Store.Mob Drops.slime ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.slime ball.Buy Able")){
			Configuration.store.set("Store.Mob Drops.slime ball.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.slime ball.Buy Price")){
			Configuration.store.set("Store.Mob Drops.slime ball.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Mob Drops.magma cream.Sell Able")){
			Configuration.store.set("Store.Mob Drops.magma cream.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.magma cream.Buy Able")){
			Configuration.store.set("Store.Mob Drops.magma cream.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.magma cream.Buy Price")){
			Configuration.store.set("Store.Mob Drops.magma cream.Buy Price",80);
		}
		
		//brewing
		
		if(!Configuration.store.contains("Store.Brewing.brewing stand item.Sell Able")){
			Configuration.store.set("Store.Brewing.brewing stand item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.brewing stand item.Buy Able")){
			Configuration.store.set("Store.Brewing.brewing stand item.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.brewing stand item.Buy Price")){
			Configuration.store.set("Store.Brewing.brewing stand item.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Brewing.cauldron item.Sell Able")){
			Configuration.store.set("Store.Brewing.cauldron item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.cauldron item.Buy Able")){
			Configuration.store.set("Store.Brewing.cauldron item.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.cauldron item.Buy Price")){
			Configuration.store.set("Store.Brewing.cauldron item.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Brewing.water bucket.Sell Able")){
			Configuration.store.set("Store.Brewing.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.water bucket.Buy Able")){
			Configuration.store.set("Store.Brewing.water bucket.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.water bucket.Buy Price")){
			Configuration.store.set("Store.Brewing.water bucket.Buy Price",55);
		}
		if(!Configuration.store.contains("Store.Brewing.blaze powder.Sell Able")){
			Configuration.store.set("Store.Brewing.blaze powder.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.blaze powder.Buy Able")){
			Configuration.store.set("Store.Brewing.blaze powder.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.blaze powder.Buy Price")){
			Configuration.store.set("Store.Brewing.blaze powder.Buy Price",90);
		}
		if(!Configuration.store.contains("Store.Brewing.nether warts.Sell Able")){
			Configuration.store.set("Store.Brewing.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.nether warts.Buy Able")){
			Configuration.store.set("Store.Brewing.nether warts.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.nether warts.Buy Price")){
			Configuration.store.set("Store.Brewing.nether warts.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Brewing.potion.Sell Able")){
			Configuration.store.set("Store.Brewing.potion.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.potion.Buy Able")){
			Configuration.store.set("Store.Brewing.potion.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.potion.Buy Price")){
			Configuration.store.set("Store.Brewing.potion.Buy Price",30);
		}
		if(!Configuration.store.contains("Store.Brewing.glass bottle.Sell Able")){
			Configuration.store.set("Store.Brewing.glass bottle.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glass bottle.Buy Able")){
			Configuration.store.set("Store.Brewing.glass bottle.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glass bottle.Buy Price")){
			Configuration.store.set("Store.Brewing.glass bottle.Buy Price",10);
		}
		if(!Configuration.store.contains("Store.Brewing.fermented spider eye.Sell Able")){
			Configuration.store.set("Store.Brewing.fermented spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.fermented spider eye.Buy Able")){
			Configuration.store.set("Store.Brewing.fermented spider eye.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.fermented spider eye.Buy Price")){
			Configuration.store.set("Store.Brewing.fermented spider eye.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Brewing.magma cream.Sell Able")){
			Configuration.store.set("Store.Brewing.magma cream.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.magma cream.Buy Able")){
			Configuration.store.set("Store.Brewing.magma cream.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.magma cream.Buy Price")){
			Configuration.store.set("Store.Brewing.magma cream.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Brewing.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Brewing.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glowstone dust.Buy Able")){
			Configuration.store.set("Store.Brewing.glowstone dust.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glowstone dust.Buy Price")){
			Configuration.store.set("Store.Brewing.glowstone dust.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Brewing.redstone.Sell Able")){
			Configuration.store.set("Store.Brewing.redstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.redstone.Buy Able")){
			Configuration.store.set("Store.Brewing.redstone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.redstone.Buy Price")){
			Configuration.store.set("Store.Brewing.redstone.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Brewing.sugar.Sell Able")){
			Configuration.store.set("Store.Brewing.sugar.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sugar.Buy Able")){
			Configuration.store.set("Store.Brewing.sugar.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sugar.Buy Price")){
			Configuration.store.set("Store.Brewing.sugar.Buy Price",20);
		}
		if(!Configuration.store.contains("Store.Brewing.speckled melon.Sell Able")){
			Configuration.store.set("Store.Brewing.speckled melon.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.speckled melon.Buy Able")){
			Configuration.store.set("Store.Brewing.speckled melon.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.speckled melon.Buy Price")){
			Configuration.store.set("Store.Brewing.speckled melon.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Brewing.ghast tear.Sell Able")){
			Configuration.store.set("Store.Brewing.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.ghast tear.Buy Able")){
			Configuration.store.set("Store.Brewing.ghast tear.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.ghast tear.Buy Price")){
			Configuration.store.set("Store.Brewing.ghast tear.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Brewing.sulphur.Sell Able")){
			Configuration.store.set("Store.Brewing.sulphur.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sulphur.Buy Able")){
			Configuration.store.set("Store.Brewing.sulphur.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sulphur.Buy Price")){
			Configuration.store.set("Store.Brewing.sulphur.Buy Price",30);
		}
		
		//painting
	
		if(!Configuration.store.contains("Store.Painting.wool.Sell Able")){
			Configuration.store.set("Store.Painting.wool.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.wool.Buy Able")){
			Configuration.store.set("Store.Painting.wool.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.wool.Buy Price")){
			Configuration.store.set("Store.Painting.wool.Buy Price",25);
		}
		if(!Configuration.store.contains("Store.Painting.ink sack.Sell Able")){
			Configuration.store.set("Store.Painting.ink sack.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.ink sack.Buy Able")){
			Configuration.store.set("Store.Painting.ink sack.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.ink sack.Buy Price")){
			Configuration.store.set("Store.Painting.ink sack.Buy Price",30);
		}
		
		//nether
		
		if(!Configuration.store.contains("Store.Nether.netherrack.Sell Able")){
			Configuration.store.set("Store.Nether.netherrack.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.netherrack.Buy Able")){
			Configuration.store.set("Store.Nether.netherrack.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.netherrack.Buy Price")){
			Configuration.store.set("Store.Nether.netherrack.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick.Sell Able")){
			Configuration.store.set("Store.Nether.nether brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick.Buy Able")){
			Configuration.store.set("Store.Nether.nether brick.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick.Buy Price")){
			Configuration.store.set("Store.Nether.nether brick.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick stairs.Sell Able")){
			Configuration.store.set("Store.Nether.nether brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick stairs.Buy Able")){
			Configuration.store.set("Store.Nether.nether brick stairs.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick stairs.Buy Price")){
			Configuration.store.set("Store.Nether.nether brick stairs.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether fence.Sell Able")){
			Configuration.store.set("Store.Nether.nether fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether fence.Buy Able")){
			Configuration.store.set("Store.Nether.nether fence.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether fence.Buy Price")){
			Configuration.store.set("Store.Nether.nether fence.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether stalk.Sell Able")){
			Configuration.store.set("Store.Nether.nether stalk.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether stalk.Buy Able")){
			Configuration.store.set("Store.Nether.nether stalk.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether stalk.Buy Price")){
			Configuration.store.set("Store.Nether.nether stalk.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether warts.Sell Able")){
			Configuration.store.set("Store.Nether.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether warts.Buy Able")){
			Configuration.store.set("Store.Nether.nether warts.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether warts.Buy Price")){
			Configuration.store.set("Store.Nether.nether warts.Buy Price",50);
		}
		if(!Configuration.store.contains("Store.Nether.blaze rod.Sell Able")){
			Configuration.store.set("Store.Nether.blaze rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.blaze rod.Buy Able")){
			Configuration.store.set("Store.Nether.blaze rod.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.blaze rod.Buy Price")){
			Configuration.store.set("Store.Nether.blaze rod.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.ghast tear.Sell Able")){
			Configuration.store.set("Store.Nether.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.ghast tear.Buy Able")){
			Configuration.store.set("Store.Nether.ghast tear.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.ghast tear.Buy Price")){
			Configuration.store.set("Store.Nether.ghast tear.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Nether.gold nugget.Sell Able")){
			Configuration.store.set("Store.Nether.gold nugget.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.gold nugget.Buy Able")){
			Configuration.store.set("Store.Nether.gold nugget.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.gold nugget.Buy Price")){
			Configuration.store.set("Store.Nether.gold nugget.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Nether.soul sand.Sell Able")){
			Configuration.store.set("Store.Nether.soul sand.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.soul sand.Buy Able")){
			Configuration.store.set("Store.Nether.soul sand.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.soul sand.Buy Price")){
			Configuration.store.set("Store.Nether.soul sand.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Nether.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone dust.Buy Able")){
			Configuration.store.set("Store.Nether.glowstone dust.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone dust.Buy Price")){
			Configuration.store.set("Store.Nether.glowstone dust.Buy Price",40);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone.Sell Able")){
			Configuration.store.set("Store.Nether.glowstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone.Buy Able")){
			Configuration.store.set("Store.Nether.glowstone.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone.Buy Price")){
			Configuration.store.set("Store.Nether.glowstone.Buy Price",60);
		}
		
		//music
		
		if(!Configuration.store.contains("Store.Music.jukebox.Sell Able")){
			Configuration.store.set("Store.Music.jukebox.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.jukebox.Buy Able")){
			Configuration.store.set("Store.Music.jukebox.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.jukebox.Buy Price")){
			Configuration.store.set("Store.Music.jukebox.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.gold record.Sell Able")){
			Configuration.store.set("Store.Music.gold record.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.gold record.Buy Able")){
			Configuration.store.set("Store.Music.gold record.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.gold record.Buy Price")){
			Configuration.store.set("Store.Music.gold record.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Music.green record.Sell Able")){
			Configuration.store.set("Store.Music.green record.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.green record.Buy Able")){
			Configuration.store.set("Store.Music.green record.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.green record.Buy Price")){
			Configuration.store.set("Store.Music.green record.Buy Price",100);
		}
		if(!Configuration.store.contains("Store.Music.record 3.Sell Able")){
			Configuration.store.set("Store.Music.record 3.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 3.Buy Able")){
			Configuration.store.set("Store.Music.record 3.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 3.Buy Price")){
			Configuration.store.set("Store.Music.record 3.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 4.Sell Able")){
			Configuration.store.set("Store.Music.record 4.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 4.Buy Able")){
			Configuration.store.set("Store.Music.record 4.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 4.Buy Price")){
			Configuration.store.set("Store.Music.record 4.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 5.Sell Able")){
			Configuration.store.set("Store.Music.record 5.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 5.Buy Able")){
			Configuration.store.set("Store.Music.record 5.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 5.Buy Price")){
			Configuration.store.set("Store.Music.record 5.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 6.Sell Able")){
			Configuration.store.set("Store.Music.record 6.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 6.Buy Able")){
			Configuration.store.set("Store.Music.record 6.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 6.Buy Price")){
			Configuration.store.set("Store.Music.record 6.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 7.Sell Able")){
			Configuration.store.set("Store.Music.record 7.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 7.Buy Able")){
			Configuration.store.set("Store.Music.record 7.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 7.Buy Price")){
			Configuration.store.set("Store.Music.record 7.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 8.Sell Able")){
			Configuration.store.set("Store.Music.record 8.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 8.Buy Able")){
			Configuration.store.set("Store.Music.record 8.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 8.Buy Price")){
			Configuration.store.set("Store.Music.record 8.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 9.Sell Able")){
			Configuration.store.set("Store.Music.record 9.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 9.Buy Able")){
			Configuration.store.set("Store.Music.record 9.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 9.Buy Price")){
			Configuration.store.set("Store.Music.record 9.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 10.Sell Able")){
			Configuration.store.set("Store.Music.record 10.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 10.Buy Able")){
			Configuration.store.set("Store.Music.record 10.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 10.Buy Price")){
			Configuration.store.set("Store.Music.record 10.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 11.Sell Able")){
			Configuration.store.set("Store.Music.record 11.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 11.Buy Able")){
			Configuration.store.set("Store.Music.record 11.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 11.Buy Price")){
			Configuration.store.set("Store.Music.record 11.Buy Price",150);
		}
		
		//misc
		
		if(!Configuration.store.contains("Store.Miscellaneous.web.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.web.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.web.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.web.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.web.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.web.Buy Price",80);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.fire.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.fire.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.fire.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.fire.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.fire.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.fire.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.portal.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.portal.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.portal.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.portal.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.portal.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.portal.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.ender portal frame.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.ender portal frame.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.ender portal frame.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.ender portal frame.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.ender portal frame.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.ender portal frame.Buy Price",70);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.dragon egg.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.dragon egg.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.dragon egg.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.dragon egg.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.dragon egg.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.dragon egg.Buy Price",200);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster egg.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.monster egg.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster egg.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.monster egg.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster egg.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.monster egg.Buy Price",150);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster eggs.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.monster eggs.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster eggs.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.monster eggs.Buy Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster eggs.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.monster eggs.Buy Price",60);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.mob spawner.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.mob spawner.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.mob spawner.Buy Able")){
			Configuration.store.set("Store.Miscellaneous.mob spawner.Buy Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.mob spawner.Buy Price")){
			Configuration.store.set("Store.Miscellaneous.mob spawner.Buy Price",250);
		}*/

	}
	
	private static void update() {
		String[] types  = new String[]{"Items", "Tools", "Food", "Fish", "Ores", "Blocks"};
		for(String type:types){
			ConfigurationSection section;
			if(type.equals("Ores") || type.equals("Blocks")){
				section = me.duckdoom5.RpgEssentials.config.Configuration.block.getConfigurationSection("Custom " + type);
			}else{
				section = me.duckdoom5.RpgEssentials.config.Configuration.items.getConfigurationSection("Custom " + type);
			}
			if(section!=null){
				Iterator<?> keys = section.getKeys(false).iterator();
				while(keys.hasNext()){
					String name = (String)keys.next();
					custommaterials.put(name, type);
				}
			}
		}
		
	}
	public static enum StoreValue{
		APPLE("Food", null, null, true, true, 15, 7.5),
		GOLDEN_APPLE("Food", null, null, true, true, 50, 25),
		BREAD("Food", null, null, true, true, 10, 5),
		CAKE("Food", null, null, true, true, 60, 30),
		RAW_BEEF("Food", null, null, true, true, 20, 10),
		COOKED_BEEF("Food", null, null, true, true, 40, 20),
		RAW_CHICKEN("Food", null, null, true, true, 15, 7.5),
		COOKED_CHICKEN("Food", null, null, true, true, 25, 12.5),
		RAW_FISH("Food", null, null, true, true, 20, 10),
		COOKED_FISH("Food", null, null, true, true, 40, 20),
		COOKIE("Food", null, null, true, true, 20, 10),
		PORK("Food", null, null, true, true, 20, 10),
		GRILLED_PORK("Food", null, null, true, true, 40, 10),
		MELON("Food", null, null, true, true, 50, 25),
		MUSHROOM_SOUP("Food", null, null, true, true, 30, 15),
		ROTTEN_FLESH("Food", "Mob Drops", null, true, true, 5, 2.5),
		SPIDER_EYE("Food", "Mob Drops", null, true, true, 20, 10),
		COCOA("Food", "Painting", null, true, true, 20, 10),
		
		WOOD_AXE("Tools", null, null, true, true, 15, 7.5),
		WOOD_HOE("Tools", "Gardening", null, true, true, 10, 5),
		WOOD_PICKAXE("Tools", null, null, true, true, 15, 7.5),
		WOOD_SWORD("Tools", null, null, true, true, 20, 10),
		WOOD_SPADE("Tools", null, null, true, true, 15, 7.5),
		STONE_AXE("Tools", null, null, true, true, 30, 15),
		STONE_HOE("Tools", null, null, true, true, 25, 12.5),
		STONE_PICKAXE("Tools", null, null, true, true, 30, 15),
		STONE_SWORD("Tools", null, null, true, true, 35, 17.5),
		STONE_SPADE("Tools", null, null, true, true, 25, 12.5),
		IRON_AXE("Tools", null, null, true, true, 50, 25),
		IRON_HOE("Tools", null, null, true, true, 45, 22.5),
		IRON_PICKAXE("Tools", null, null, true, true, 50, 25),
		IRON_SWORD("Tools", null, null, true, true, 55, 27.5),
		IRON_SPADE("Tools", null, null, true, true, 40, 20),
		GOLD_AXE("Tools", null, null, true, true, 100, 50),
		GOLD_HOE("Tools", null, null, true, true, 90, 45),
		GOLD_PICKAXE("Tools", null, null, true, true, 100, 50),
		GOLD_SWORD("Tools", null, null, true, true, 110, 55),
		GOLD_SPADE("Tools", null, null, true, true, 80, 40),
		DIAMOND_AXE("Tools", null, null, true, true, 500, 250),
		DIAMOND_HOE("Tools", null, null, true, true, 450, 225),
		DIAMOND_PICKAXE("Tools", null, null, true, true, 500, 250),
		DIAMOND_SWORD("Tools", null, null, true, true, 550, 275),
		DIAMOND_SPADE("Tools", null, null, true, true, 400, 200),
		MINECART("Tools", null, null, true, true, 100, 50),
		POWERED_MINECART("Tools", null, null, true, true, 150, 75),
		STORAGE_MINECART("Tools", null, null, true, true, 150, 75),
		COMPASS("Tools", null, null, true, true, 100, 50),
		WATCH("Tools", null, null, true, true, 120, 60),
		ARROW("Tools", "Mob Drops", null, true, true, 10, 10),
		BUCKET("Tools", null, null, true, true, 50, 25),
		WATER_BUCKET("Tools", "Gardening", "Brewing", true, true, 55, 27.5),
		LAVA_BUCKET("Tools", null, null, true, true, 200, 50),
		MILK_BUCKET("Tools", null, null, true, true, 60, 20),
		BOW("Tools", null, null, true, true, 150, 75),
		BOAT("Tools", null, null, true, true, 100, 40),
		SADDLE("Tools", null, null, true, true, 200, 100),
		FISHING_ROD("Tools", null, null, true, true, 50, 25),
		SHEARS("Tools", null, null, true, true, 60, 30),
		FLINT_AND_STEEL("Tools", null, null, true, true, 40, 20),
		BOWL("Tools", null, null, true, true, 20, 5),
		STICK("Tools", null, null, true, true, 10, 1),
		SNOW_BALL("Tools", "Raw Materials", null, true, true, 20, 10),
		MAP("Tools", null, null, true, true, 300, 100),
		BOOK_AND_QUILL("Tools", null, null, true, true, 70, 35),
		
		LEATHER_HELMET("Armor", null, null, true, true, 20, 10),
		LEATHER_CHESTPLATE("Armor", null, null, true, true, 50, 25),
		LEATHER_LEGGINGS("Armor", null, null, true, true, 30, 15),
		LEATHER_BOOTS("Armor", null, null, true, true, 20, 10),
		CHAINMAIL_HELMET("Armor", null, null, true, true, 50, 25),
		CHAINMAIL_CHESTPLATE("Armor", null, null, true, true, 100, 50),
		CHAINMAIL_LEGGINGS("Armor", null, null, true, true, 70, 35),
		CHAINMAIL_BOOTS("Armor", null, null, true, true, 50, 25),
		IRON_HELMET("Armor", null, null, true, true, 100, 50),
		IRON_CHESTPLATE("Armor", null, null, true, true, 250, 125),
		IRON_LEGGINGS("Armor", null, null, true, true, 200, 100),
		IRON_BOOTS("Armor", null, null, true, true, 100, 50),
		GOLD_HELMET("Armor", null, null, true, true, 250, 125),
		GOLD_CHESTPLATE("Armor", null, null, true, true, 500, 250),
		GOLD_LEGGINGS("Armor", null, null, true, true, 350, 175),
		GOLD_BOOTS("Armor", null, null, true, true, 250, 125),
		DIAMOND_HELMET("Armor", null, null, true, true, 500, 250),
		DIAMOND_CHESTPLATE("Armor", null, null, true, true, 1000, 400),
		DIAMOND_LEGGINGS("Armor", null, null, true, true, 700, 350),
		DIAMOND_BOOTS("Armor", null, null, true, true, 500, 250),
		
		REDSTONE("Mechanisms", "Brewing", null, true, true, 5, 1),
		TRIPWIRE_HOOK("Mechanisms", null, null, true, true, 30, 10),
		DIODE("Mechanisms", null, null, true, true, 20, 5),
		PISTON_BASE("Mechanisms", null, null, true, true, 70, 35),
		PISTON_STICKY_BASE("Mechanisms", null, null, true, true, 100, 50),
		LEVER("Mechanisms", null, null, true, true, 10, 2),
		WOOD_PLATE("Mechanisms", null, null, true, true, 15, 7.5),
		STONE_PLATE("Mechanisms", null, null, true, true, 20, 10),
		DETECTOR_RAIL("Mechanisms", null, null, true, true, 40, 20),
		REDSTONE_TORCH_OFF("Mechanisms", null, null, true, true, 15, 7.5),
		POWERED_RAIL("Mechanisms", null, null, true, true, 60, 30),
		RAILS("Mechanisms", null, null, true, true, 30, 15),
		WOOD_DOOR("Mechanisms", "Furniture", null, true, true, 40, 20),
		IRON_DOOR("Mechanisms", "Furniture", null, true, true, 60, 30),
		DISPENSER("Mechanisms", null, null, true, true, 150, 75),
		STONE_BUTTON("Mechanisms", null, null, true, true, 5, 1),
		TRAP_DOOR("Mechanisms", "Furniture", null, true, true, 50, 25),
		TNT("Mechanisms", null, null, true, true, 150, 75),
		REDSTONE_LAMP_OFF("Mechanisms", null, null, true, true, 100, 50),
		
		BROWN_MUSHROOM("Gardening", null, null, true, true, 30, 5),
		RED_MUSHROOM("Gardening", null, null, true, true, 50, 5),
		RED_ROSE("Gardening", null, null, true, true, 20, 5),
		YELLOW_FLOWER("Gardening", null, null, true, true, 15, 5),
		CACTUS("Gardening", null, null, true, true, 30, 5),
		SAPLING("Gardening", null, null, true, true, 20, 5),
		SEEDS("Gardening", null, null, true, true, 50, 5),
		SUGAR_CANE("Gardening", null, null, true, true, 50, 5),
		WHEAT("Gardening", null, null, true, true, 20, 5),
		MELON_SEEDS("Gardening", null, null, true, true, 500, 20),
		MELON_BLOCK("Gardening", null, null, true, true, 600, 20),
		PUMPKIN_SEEDS("Gardening", null, null, true, true, 500, 20),
		PUMPKIN("Gardening", null, null, true, true, 600, 20),
		SOIL("Gardening", null, null, false, false, 20, 1),
		LONG_GRASS("Gardening", null, null, true, true, 15, 1),
		DEAD_BUSH("Gardening", null, null, true, true, 15, 1),
		VINE("Gardening", null, null, true, true, 50, 10),
		WATER_LILY("Gardening", null, null, true, true, 30, 5),
		
		BED("Furniture", null, null, true, true, 250, 50),
		BOOKSHELF("Furniture", null, null, true, true, 150, 75),
		BRICK_STAIRS("Furniture", null, null, true, true, 70, 35),
		SANDSTONE_STAIRS("Furniture", null, null, true, true, 70, 35),
		BIRCH_WOOD_STAIRS("Furniture", null, null, true, true, 70, 35),
		JUNGLE_WOOD_STAIRS("Furniture", null, null, true, true, 80, 40),
		SPRUCE_WOOD_STAIRS("Furniture", null, null, true, true, 80, 40),
		WORKBENCH("Furniture", null, null, true, true, 50, 5),
		CHEST("Furniture", null, null, true, true, 70, 20),
		ENDER_CHEST("Furniture", null, null, true, true, 200, 50),
		COBBLESTONE_STAIRS("Furniture", null, null, true, true, 40, 20),
		ENCHANTMENT_TABLE("Furniture", null, null, true, true, 300, 100),
		FENCE("Furniture", null, null, true, true, 20, 5),
		FENCE_GATE("Furniture", null, null, true, true, 40, 20),
		FURNACE("Furniture", null, null, true, true, 60, 10),
		JACK_O_LANTERN("Furniture", null, null, true, true, 150, 50),
		LADDER("Furniture", null, null, true, true, 20, 10),
		PAINTING("Furniture", null, null, true, true, 20, 10),
		SIGN("Furniture", null, null, true, true, 20, 10),
		TORCH("Furniture", null, null, true, true, 30, 1),
		WOOD_STAIRS("Furniture", null, null, true, true, 40, 10),
		SMOOTH_STAIRS("Furniture", null, null, true, true, 70, 35),
		IRON_FENCE("Furniture", null, null, true, true, 50, 10),
		THIN_GLASS("Furniture", null, null, true, true, 40, 5),
		
		STONE("Materials", null, null, true, true, 10, 1),
		GRASS("Materials", null, null, true, true, 30, 5),
		DIRT("Materials", null, null, true, true, 5, 0.5),
		COBBLESTONE("Materials", null, null, true, true, 5, 0.5),
		WOOD("Materials", null, null, true, true, 10, 0.5),
		BEDROCK("Materials", null, null, false, false, 1000000, 1),
		WATER("Materials", null, null, false, false, 100, 1),
		STATIONARY_WATER("Materials", null, null, false, false, 150, 1),
		LAVA("Materials", null, null, false, false, 5000, 1),
		STATIONARY_LAVA("Materials", null, null, false, false, 5000, 1),
		SAND("Materials", null, null, true, true, 15, 1),
		GRAVEL("Materials", null, null, true, true, 15, 1),
		LOG("Materials", null, null, true, true, 15, 2),
		LEAVES("Materials", null, null, true, true, 15, 1),
		SPONGE("Materials", null, null, true, true, 50, 10),
		GLASS("Materials", null, null, true, true, 15, 7.5),
		SANDSTONE("Materials", null, null, true, true, 25, 10),
		DOUBLE_STEP("Materials", null, null, true, true, 15, 7.5),
		WOOD_DOUBLE_STEP("Materials", null, null, true, true, 15, 5),
		STEP("Materials", null, null, true, true, 10, 3),
		WOOD_STEP("Materials", null, null, true, true, 10, 3),
		BRICK("Materials", null, null, true, true, 30, 5),
		MOSSY_COBBLESTONE("Materials", null, null, true, true, 35, 10),
		OBSIDIAN("Materials", null, null, true, true, 100, 20),
		SNOW("Materials", null, null, true, true, 20, 10),
		ICE("Materials", null, null, true, true, 40, 10),
		SNOW_BLOCK("Materials", null, null, true, true, 30, 15),
		CLAY("Materials", null, null, true, true, 35, 5),
		SMOOTH_BRICK("Materials", null, null, true, true, 110, 20),
		MYCEL("Materials", null, null, true, true, 150, 10),
		
		COAL("Raw Materials", null, null, true, true, 40, 2),
		IRON_INGOT("Raw Materials", null, null, true, true, 60, 5),
		GOLD_INGOT("Raw Materials", null, null, true, true, 100, 10),
		DIAMOND("Raw Materials", null, null, true, true, 600, 50),
		EMERALD("Raw Materials", null, null, true, true, 700, 50),
		CLAY_BALL("Raw Materials", null, null, true, true, 15, 3),
		CLAY_BRICK("Raw Materials", null, null, true, true, 20, 7),
		FLINT("Raw Materials", null, null, true, true, 15, 5),
		PAPER("Raw Materials", null, null, true, true, 40, 10),
		BOOK("Raw Materials", null, null, true, true, 50, 20),
		DIAMOND_BLOCK("Raw Materials", null, null, true, true, 17500, 600),
		EMERALD_BLOCK("Raw Materials", null, null, true, true, 20000, 300),
		IRON_BLOCK("Raw Materials", null, null, true, true, 2250, 200),
		GOLD_BLOCK("Raw Materials", null, null, true, true, 4500, 400),
		LAPIS_BLOCK("Raw Materials", null, null, true, true, 1000, 150),
		
		ENDER_PORTAL_FRAME("The End", "Miscellaneous", null, false, false, 70, 10),
		DRAGON_EGG("The End", "Miscellaneous", null, false, false, 200, 30),
		ENDER_STONE("The End", "Materials", null, true, true, 100, 20),
		ENDER_PEARL("The End", "Mob Drops", null, true, true, 50, 10),
		EYE_OF_ENDER("The End", null, null, true, true, 70, 20),
		
		GOLD_ORE("Ores", null, null, true, true, 500, 100),
		DIAMOND_ORE("Ores", null, null, true, true, 2000, 400),
		EMERALD_ORE("Ores", null, null, true, true, 3000, 700),
		REDSTONE_ORE("Ores", null, null, true, true, 300, 70),
		IRON_ORE("Ores", null, null, true, true, 250, 30),
		COAL_ORE("Ores", null, null, true, true, 100, 20),
		LAPIS_ORE("Ores", null, null, true, true, 150, 50),
		
		STRING("Mob Drops", null, null, true, true, 15, 4),
		LEATHER("Mob Drops", null, null, true, true, 30, 5),
		FEATHER("Mob Drops", null, null, true, true, 40, 6),
		EGG("Mob Drops", null, null, true, true, 20, 2),
		BONE("Mob Drops", null, null, true, true, 30, 3),
		SLIME_BALL("Mob Drops", null, null, true, true, 60, 6),
		
		BREWING_STAND_ITEM("Brewing", "Furniture", null, true, true, 200, 50),
		CAULDRON_ITEM("Brewing", "Furniture", null, true, true, 200, 50),
		BLAZE_POWDER("Brewing", null, null, true, true, 90, 20),
		POTION("Brewing", null, null, true, true, 30, 5),
		GLASS_BOTTLE("Brewing", null, null, true, true, 10, 2),
		FERMENTED_SPIDER_EYE("Brewing", null, null, true, true, 40, 10),
		MAGMA_CREAM("Brewing", "Mob Drops", null, true, true, 80, 20),
		SUGAR("Brewing", "Raw Materials", null, true, true, 20, 5),
		SPECKLED_MELON("Brewing", null, null, true, true, 100, 30),
		SULPHUR("Brewing", "Mob Drops", null, true, true, 80, 20),
		
		WOOL("Painting", null, null, true, true, 25, 5),
		INK_SACK("Painting", null, null, true, true, 30, 5),
		
		NETHERRACK("Nether", "Materials", null, true, true, 50, 5),
		NETHER_BRICK("Nether", "Materials", null, true, true, 60, 10),
		NETHER_BRICK_STAIRS("Nether", "Furniture", null, true, true, 70, 10),
		NETHER_FENCE("Nether", "Furniture", null, true, true, 70, 10),
		NETHER_STALK("Nether", "Furniture", null, true, true, 70, 5),
		NETHER_WARTS("Nether", "Brewing", "Gardening", true, true, 50, 10),
		BLAZE_ROD("Nether", "Mob Drops", null, true, true, 70, 15),
		GHAST_TEAR("Nether", "Brewing", "Mob Drops", true, true, 80, 20),
		GOLD_NUGGET("Nether", "Mob Drops", null, true, true, 40, 10),
		SOUL_SAND("Nether", "Materials", "Gardening", true, true, 60, 15),
		GLOWSTONE_DUST("Nether", "Brewing", "Raw Materials", true, true, 40, 5),
		GLOWSTONE("Nether", "Materials", null, true, true, 60, 10),
		PORTAL("Nether", "Miscellaneous", null, false, false, 100, 10),
		
		JUKEBOX("Music", "Furniture", null, true, true, 400, 40),
		NOTE_BLOCK("Music", "Mechanisms", "Furniture", true, true, 150, 40),
		GOLD_RECORD("Music", null, null, true, true, 200, 20),
		GREEN_RECORD("Music", null, null, true, true, 200, 20),
		RECORD_3("Music", null, null, true, true, 250, 50),
		RECORD_4("Music", null, null, true, true, 250, 50),
		RECORD_5("Music", null, null, true, true, 250, 50),
		RECORD_6("Music", null, null, true, true, 250, 50),
		RECORD_7("Music", null, null, true, true, 250, 50),
		RECORD_8("Music", null, null, true, true, 250, 50),
		RECORD_9("Music", null, null, true, true, 250, 50),
		RECORD_10("Music", null, null, true, true, 250, 50),
		RECORD_11("Music", null, null, true, true, 300, 60),
		
		WEB("Miscellaneous", null, null, true, true, 80, 10),
		FIRE("Miscellaneous", null, null, false, false, 60, 10),
		MONSTER_EGG("Miscellaneous", null, null, true, true, 150, 20),
		MONSTER_EGGS("Miscellaneous", null, null, false, false, 150, 20),
		MOB_SPAWNER("Miscellaneous", null, null, true, true, 2000, 50);
		
		private final String type;
		private final String type2;
		private final String type3;
		private final boolean buyAble;
		private final boolean sellAble;
		private final double buyPrice;
		private final double sellPrice;
		
		StoreValue(String type, String type2, String type3, boolean buyAble, boolean sellAble, double buyPrice, double sellPrice){
			this.type = type;
			this.type2 = type2;
			this.type3 = type3;
			this.buyAble = buyAble;
			this.sellAble = sellAble;
			this.buyPrice = buyPrice;
			this.sellPrice = sellPrice;
		}
		
		public String getType(){
			return type;
		}
		
		public String getType2(){
			return type2;
		}
		
		public String getType3(){
			return type3;
		}
		
		public boolean isBuyAble(){
			return buyAble;
		}
		
		public boolean isSellAble(){
			return sellAble;
		}
		
		public double getBuyPrice(){
			return buyPrice;
		}
		
		public double getSellPrice(){
			return sellPrice;
		}
	}
}
