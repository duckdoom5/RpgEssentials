package me.duckdoom5.RpgEssentials.RpgStores.Util;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Config.StoreConfig;
import me.duckdoom5.RpgEssentials.RpgStores.Config.StoreConfig.StoreValue;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.CustomStoreGui;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreHashmaps {
	//all
	public static Set<Material> custom = new LinkedHashSet<Material>();
	public static Set<Material> customdata = new LinkedHashSet<Material>();
	public static Set<org.getspout.spoutapi.material.Material> customcustom = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	
	public static Set<Material> food = new LinkedHashSet<Material>();
	public static Set<Material> tools = new LinkedHashSet<Material>();
	public static Set<Material> armor = new LinkedHashSet<Material>();
	public static Set<Material> mechanisms = new LinkedHashSet<Material>();
	public static Set<Material> gardening = new LinkedHashSet<Material>();
	public static Set<Material> furniture = new LinkedHashSet<Material>();
	public static Set<Material> materials = new LinkedHashSet<Material>();
	public static Set<Material> rawmaterials = new LinkedHashSet<Material>();
	public static Set<Material> theend = new LinkedHashSet<Material>();
	public static Set<Material> ores = new LinkedHashSet<Material>();
	public static Set<Material> mobdrops = new LinkedHashSet<Material>();
	public static Set<Material> brewing = new LinkedHashSet<Material>();
	public static Set<Material> painting = new LinkedHashSet<Material>();
	public static Set<Material> nether = new LinkedHashSet<Material>();
	public static Set<Material> music = new LinkedHashSet<Material>();
	public static Set<Material> misc = new LinkedHashSet<Material>();
	
	public static Set<org.getspout.spoutapi.material.Material> customfood = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customtools = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customarmor = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custommechanisms = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customgardening = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customfurniture = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custommaterials = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customrawmaterials = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customtheend = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customores = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custommobdrops = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custombrewing = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custompainting = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> customnether = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custommusic = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
	public static Set<org.getspout.spoutapi.material.Material> custommisc = new LinkedHashSet<org.getspout.spoutapi.material.Material>();
		
	//buy
	public static Set<Material> buy = new LinkedHashSet<Material>();
	public static Set<Material> custombuy = new LinkedHashSet<Material>();
	
	public static Set<GenericCustomBlock> buycustomblocks = new LinkedHashSet<GenericCustomBlock>();
	public static Set<GenericCustomItem> buycustomitems = new LinkedHashSet<GenericCustomItem>();
	
	//sell
	public static Set<Material> sell = new LinkedHashSet<Material>();
	public static Set<Material> customsell = new LinkedHashSet<Material>();
	
	public static Set<GenericCustomBlock> sellcustomblocks = new LinkedHashSet<GenericCustomBlock>();
	public static Set<GenericCustomItem> sellcustomitems = new LinkedHashSet<GenericCustomItem>();
	
	public static void registerstore(RpgStores rpgStore){
		
		for(StoreValue value:StoreValue.values()){
			String name = value.toString().toLowerCase().replace("_", " ");
			String type = value.getType();
			String type2 = value.getType2();
			String type3 = value.getType3();
			Material material = Material.getMaterial(value.toString());
			Set<Material> set = null;
			
			set = StoreType.valueOf(type.replace(" ", "_")).getType();
			
			if(Configuration.store.getBoolean("Store." + type + "." + name + ".Sell Able")){
				if(! set.contains(material)){
					set.add(material);
				}
				sell.add(material);
			}
			if(Configuration.store.getBoolean("Store." + type + "." + name + ".Buy Able")){
				if(! set.contains(material)){
					set.add(material);
				}
				buy.add(material);
			}
			
			if(type2 != null){
				set = StoreType.valueOf(type2.replace(" ", "_")).getType();
				
				if(Configuration.store.getBoolean("Store." + type2 + "." + name + ".Sell Able")){
					if(! set.contains(material)){
						set.add(material);
					}
					if(! sell.contains(material)){
						sell.add(material);
					}
				}
				if(Configuration.store.getBoolean("Store." + type2 + "." + name + ".Buy Able")){
					if(! set.contains(material)){
						set.add(material);
					}
					if(! buy.contains(material)){
						buy.add(material);
					}
				}
			}
			
			if(type3 != null){
				set = StoreType.valueOf(type3.replace(" ", "_")).getType();
				
				if(Configuration.store.getBoolean("Store." + type3 + "." + name + ".Sell Able")){
					if(! set.contains(material)){
						set.add(material);
					}
					if(! sell.contains(material)){
						sell.add(material);
					}
				}
				if(Configuration.store.getBoolean("Store." + type3 + "." + name + ".Buy Able")){
					if(! set.contains(material)){
						set.add(material);
					}
					if(! buy.contains(material)){
						buy.add(material);
					}
				}
			}
		}
				
		//custom ores
		for (GenericCustomBlock block:RpgEssentials.mm.getOres()) {
			if(me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Ores." + block.getName() + ".Sell Able")){
				customores.add(block);
				sellcustomblocks.add(block);
			}
			if(me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Ores." + block.getName() + ".Buy Able")){
				if(! customores.contains(block)){
					customores.add(block);
				}
				buycustomblocks.add(block);
			}
		}
		
		//custom blocks
		for (GenericCustomBlock block:RpgEssentials.mm.getBlocks()) {
			if(me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Blocks." + block.getName() + ".Sell Able")){
				CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.block.getString("Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(block);
				sellcustomblocks.add(block);
			}
			if(me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Blocks." + block.getName() + ".Buy Able")){
				if(! CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.block.getString("Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().contains(block)){
					CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.block.getString("Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(block);
				}
				buycustomblocks.add(block);
			}
		}
		
		//custom items
		for (GenericCustomItem items:RpgEssentials.mm.getItems()) {
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Items." + items.getName() + ".Sell Able")){
				CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.items.getString("Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(items);
				sellcustomitems.add(items);
			}
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Items." + items.getName() + ".Buy Able")){
				if(! CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.items.getString("Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().contains(items)){
					CustomStoreType.valueOf(me.duckdoom5.RpgEssentials.config.Configuration.items.getString("Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(items);
				}
				buycustomitems.add(items);
			}
		}
		
		//custom tools
		for (GenericCustomItem tools:RpgEssentials.mm.getTools()) {
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Tools." + tools.getName() + ".Sell Able")){
				customtools.add(tools);
				sellcustomitems.add(tools);
			}
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Tools." + tools.getName() + ".Buy Able")){
				if(! customtools.contains(tools)){
					customtools.add(tools);
				}
				buycustomitems.add(tools);
			}
		}
		
		//custom food
		for (GenericCustomItem food:RpgEssentials.mm.getFood()) {
			String type = StoreConfig.custommaterials.get(food.getName());
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom " + type + "." + food.getName() + ".Sell Able")){
				customfood.add(food);
				sellcustomitems.add(food);
			}
			if(me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom " + type + "." + food.getName() + ".Buy Able")){
				if(! customfood.contains(food)){
					customfood.add(food);
				}
				buycustomitems.add(food);
			}
		}
	}
	
	public static void registerCustomStore(RpgStores plugin, SpoutPlayer splayer, String type){
		custom.clear();
		custombuy.clear();
		customsell.clear();
		ConfigurationSection section = Configuration.customstores.getConfigurationSection(type);
		Iterator<?> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			//try{
				int name = Integer.parseInt((String)keys.next());
				
				if(Configuration.customstores.getBoolean(type + "." + name + ".Sell Able") == true){
					if(Methods.isDataMaterial(Material.getMaterial(name))){
						for(int x = 0; x < Methods.getDataAmount(Material.getMaterial(name)); x++){
							customdata.add(Material.getMaterial(name));
						}
					}else{
						custom.add(Material.getMaterial(name));
					}
					customsell.add(Material.getMaterial(name));
				}
				if(Configuration.customstores.getBoolean(type + "." + name + ".Buy Able") == true){
					if(! custom.contains(Material.getMaterial(name))){
						custom.add(Material.getMaterial(name));
					}
					custombuy.add(Material.getMaterial(name));
				}
			//}catch(NumberFormatException e){
			//	String name = (String)keys.next();
				//custom item/block
			//}
		}
		CustomStoreGui gui = new CustomStoreGui(plugin, splayer, type);
	}
	
	public static enum CustomStoreType{
		FOOD(customfood),
		TOOLS(customtools),
		ARMOR(customarmor),
		MECHANISMS(custommechanisms),
		GARDENING(customgardening),
		FURNITURE(customfurniture),
		MATERIALS(custommaterials),
		RAW_MATERIALS(customrawmaterials),
		THE_END(customtheend),
		ORES(customores),
		MOB_DROPS(custommobdrops),
		BREWING(custombrewing),
		PAINTING(custompainting),
		NETHER(customnether),
		MUSIC(custommusic),
		MISCELLANEOUS(custommisc);
		
		private final Set<org.getspout.spoutapi.material.Material> map;
		
		CustomStoreType(Set<org.getspout.spoutapi.material.Material> map){
			this.map = map;
		}
		
		public Set<org.getspout.spoutapi.material.Material> getType(){
			return map;
		}
	}
	
	public static enum StoreType{
		Food(food),
		Tools(tools),
		Armor(armor),
		Mechanisms(mechanisms),
		Gardening(gardening),
		Furniture(furniture),
		Materials(materials),
		Raw_Materials(rawmaterials),
		The_End(theend),
		Ores(ores),
		Mob_Drops(mobdrops),
		Brewing(brewing),
		Painting(painting),
		Nether(nether),
		Music(music),
		Miscellaneous(misc);
		
		private final Set<Material> map;
		
		StoreType(Set<Material> map){
			this.map = map;
		}

		public Set<Material> getType() {
			return this.map;
		}
	}
}

