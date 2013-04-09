package me.duckdoom5.RpgEssentials.RpgDeaths.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;

public class Configuration {

private static final String h = "[RpgDeathChests] ";

public static MyConfiguration config;

	static {
		config = new MyConfiguration();
	}

	public static void start(){
		RpgDeaths.log.info(h+"Static Configuration loading...");
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgDeathChests/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exclaim(String filename){
		RpgDeaths.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgDeaths.log.severe(h+"On file "+ filename + ":");
		RpgDeaths.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgDeaths.log.severe(h+"On file "+ filename + ":");
		RpgDeaths.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgDeathChests/"+name);
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
				y.load("plugins/RpgDeathChests/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}