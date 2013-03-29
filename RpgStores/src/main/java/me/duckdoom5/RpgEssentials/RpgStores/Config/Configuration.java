package me.duckdoom5.RpgEssentials.RpgStores.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;

public class Configuration {

private static final String h = "[RpgStores] ";

public static MyConfiguration store;
public static MyConfiguration config;
public static MyConfiguration storedata;
public static MyConfiguration customstores;

	static {
		config = new MyConfiguration();
		store = new MyConfiguration();
		storedata = new MyConfiguration();
		customstores = new MyConfiguration();
	}

	public static void start(){
		RpgStores.log.info(h+"Static Configuration loading...");
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgStores/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(store,"store.yml")){
			store = MyConfiguration.loadConfiguration("plugins/RpgStores/store.yml");
			StoreConfig.set();
			save(store);
		}
		StoreConfig.set();
		try {
			store.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(customstores,"customstores.yml")){
			customstores = MyConfiguration.loadConfiguration("plugins/RpgStores/customstores.yml");
			CustomStoreConfig.set();
			save(customstores);
		}
		CustomStoreConfig.set();
		try {
			customstores.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(storedata,"Temp/storedata.yml")){
			storedata = MyConfiguration.loadConfiguration("plugins/RpgStores/Temp/storedata.yml");
			save(storedata);
		}
		try {
			storedata.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exclaim(String filename){
		RpgStores.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgStores.log.severe(h+"On file "+ filename + ":");
		RpgStores.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgStores.log.severe(h+"On file "+ filename + ":");
		RpgStores.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgStores/"+name);
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
				y.load("plugins/RpgStores/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}