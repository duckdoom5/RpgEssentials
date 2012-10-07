package me.duckdoom5.RpgEssentials.RpgBanks.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;

public class Configuration {

private static final String h = "[RpgBanks] ";

public static MyConfiguration bank;
public static MyConfiguration config;

	static {
		bank = new MyConfiguration();
		config = new MyConfiguration();
	}

	public static void start(){
		RpgBanks.log.info(h+"Static Configuration loading...");
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgBanks/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(bank,"Temp/Bank.yml")){
			bank = MyConfiguration.loadConfiguration("plugins/RpgBanks/Temp/Bank.yml");
			save(bank);
		}
		try {
			bank.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exclaim(String filename){
		RpgBanks.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgBanks.log.severe(h+"On file "+ filename + ":");
		RpgBanks.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgBanks.log.severe(h+"On file "+ filename + ":");
		RpgBanks.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgBanks/"+name);
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
				y.load("plugins/RpgBanks/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}