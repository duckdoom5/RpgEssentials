package me.duckdoom5.RpgEssentials.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class Configuration {
	
	private static final String h = "[RpgEssentials] ";

	public static final MyConfiguration config;
	public static final MyConfiguration block;
	public static final MyConfiguration entity;
	public static final MyConfiguration generator;
	public static final MyConfiguration items;
	public static final MyConfiguration level;
	public static final MyConfiguration players;
	public static final MyConfiguration region;
	public static final MyConfiguration store;
	
	static {
		config = new MyConfiguration();
		block = new MyConfiguration();
		entity = new MyConfiguration();
		generator = new MyConfiguration();
		items = new MyConfiguration();
		level = new MyConfiguration();
		players = new MyConfiguration();
		region = new MyConfiguration();
		store = new MyConfiguration();
		
		if (load(config,"config.yml")){
			Config.set();
			save(config);
		}
		
		if (load(block,"blocks.yml")){
			BlockConfig.set();
			save(block);
		}
		
		if (load(entity,"Entities.yml")){
			EntityConfig.set();
			save(entity);
		}
		
		if (load(generator,"worldgenerator.yml")){
			GeneratorConfig.set();
			save(generator);
		}
		
		if (load(items,"items.yml")){
			ItemConfig.set();
			save(items);
		}
		
		if (load(level,"leveling.yml")){
			LevelConfig.set();
			save(level);
		}
		
		if (load(players, "Temp/Players.yml")){
			PlayerConfig.set();
			save(players);
		}
		
		if (load(region,"regions.yml")){
			RegionConfig.set();
			save(region);
		}
		
		if (load(store,"store.yml")){
			StoreConfig.set();
			save(store);
		}
	}
	
	public static void start(){
		RpgEssentials.log.info(h+"Static Configuration loading...");
	}
	
	private static void exclaim(String filename){
		RpgEssentials.log.info(h+"Saved file "+ filename + "!");
	}
	
	private static void complain(String filename){
		RpgEssentials.log.severe(h+"On file "+ filename + ":");
		RpgEssentials.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}
	
	private static void complainFileCreation(String filename){
		RpgEssentials.log.severe(h+"On file "+ filename + ":");
		RpgEssentials.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}
	
	// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgEssentials/"+name);
		} catch (FileNotFoundException e) {
			return true;
		} catch (Exception e) {
			complain(name);
		}
		return false;
	}
	
	private static void save(MyConfiguration y){
		try {
			y.save();
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
	
}
