package me.duckdoom5.RpgEssentials.RpgQuests.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

public class Configuration {

private static final String h = "[RpgQuests] ";

public static MyConfiguration quests;

	static {
		quests = new MyConfiguration();
	}

	public static void start(){
		RpgQuests.log.info(h+"Static Configuration loading...");
		
		if(load(quests,"quests.yml")){
			quests = MyConfiguration.loadConfiguration("plugins/RpgQuests/quests.yml");
			QuestConfig.set();
			save(quests);
		}
		QuestConfig.set();
		try {
			quests.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exclaim(String filename){
		RpgQuests.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgQuests.log.severe(h+"On file "+ filename + ":");
		RpgQuests.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgQuests.log.severe(h+"On file "+ filename + ":");
		RpgQuests.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgQuests/"+name);
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
				y.load("plugins/RpgQuests/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}