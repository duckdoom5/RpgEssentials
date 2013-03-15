package me.duckdoom5.RpgEssentials.RpgEntities.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;

public class Configuration {

private static final String h = "[RpgEntities] ";

public static MyConfiguration config;
public static MyConfiguration entities;

	static {
		config = new MyConfiguration();
		entities = new MyConfiguration();
	}

	public static void start(){
		RpgEntities.log.info(h+"Static Configuration loading...");
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgEntities/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(entities,"entities.yml")){
			entities = MyConfiguration.loadConfiguration("plugins/RpgEntities/entities.yml");
			EntitiesConfig.set();
			save(entities);
		}
		EntitiesConfig.set();
		try {
			entities.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exclaim(String filename){
		RpgEntities.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgEntities.log.severe(h+"On file "+ filename + ":");
		RpgEntities.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgEntities.log.severe(h+"On file "+ filename + ":");
		RpgEntities.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgEntities/"+name);
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
			try {
				y.load("plugins/RpgEntities/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}