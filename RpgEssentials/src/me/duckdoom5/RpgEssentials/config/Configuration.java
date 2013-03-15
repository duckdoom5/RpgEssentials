package me.duckdoom5.RpgEssentials.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class Configuration {

private static final String h = "[RpgEssentials] ";

public static MyConfiguration config;
public static MyConfiguration block;
public static MyConfiguration pets;
public static MyConfiguration generator;
public static MyConfiguration items;
public static MyConfiguration players;
public static MyConfiguration npc;
public static MyConfiguration texture;
public static MyConfiguration mail;
public static MyConfiguration modules;
public static MyConfiguration clans;
public static MyConfiguration tracks;

	static {
		config = new MyConfiguration();
		block = new MyConfiguration();
		pets = new MyConfiguration();
		generator = new MyConfiguration();
		items = new MyConfiguration();
		players = new MyConfiguration();
		npc = new MyConfiguration();
		texture = new MyConfiguration();
		mail = new MyConfiguration();
		modules = new MyConfiguration();
		clans = new MyConfiguration();
		tracks = new MyConfiguration();
	}

	public static void start(){
		RpgEssentials.log.info(h+"Static Configuration loading...");
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgEssentials/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(block,"blocks.yml")){
			block = MyConfiguration.loadConfiguration("plugins/RpgEssentials/blocks.yml");
			BlockConfig.set();
			save(block);
		}
		BlockConfig.set();
		try {
			block.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(items,"items.yml")){
			items = MyConfiguration.loadConfiguration("plugins/RpgEssentials/items.yml");
			ItemConfig.set();
			save(items);
		}
		ItemConfig.set();
		try {
			items.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(pets,"Temp/pets.yml")){
			pets = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/pets.yml");
			PetsConfig.set();
			save(pets);
		}
		PetsConfig.set();
		try {
			pets.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(generator,"worldgenerator.yml")){
			generator = MyConfiguration.loadConfiguration("plugins/RpgEssentials/worldgenerator.yml");
			GeneratorConfig.set();
			save(generator);
		}
		GeneratorConfig.set();
		try {
			generator.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(players, "Temp/Players.yml")){
			players = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/Players.yml");
			PlayerConfig.set();
			save(players);
		}
		PlayerConfig.set();
		try {
			players.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(npc,"Temp/Npc.yml")){
			npc = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/Npc.yml");
			NpcConfig.set();
			save(npc);
		}
		NpcConfig.set();
		try {
			npc.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(texture,"textures.yml")){
			texture = MyConfiguration.loadConfiguration("plugins/RpgEssentials/textures.yml");
			TextureConfig.set();
			save(texture);
		}
		TextureConfig.set();
		try {
			texture.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(mail,"Temp/mail.yml")){
			mail = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/mail.yml");
			MailConfig.set();
			save(mail);
		}
		MailConfig.set();
		try {
			mail.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(modules,"modules.yml")){
			modules = MyConfiguration.loadConfiguration("plugins/RpgEssentials/modules.yml");
			ModulesConfig.set();
			save(modules);
		}
		ModulesConfig.set();
		try {
			modules.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(clans,"clans.yml")){
			clans = MyConfiguration.loadConfiguration("plugins/RpgEssentials/clans.yml");
			ClanConfig.set();
			save(clans);
		}
		ClanConfig.set();
		try {
			clans.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(tracks,"Temp/tracks.yml")){
			tracks = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/tracks.yml");
			save(tracks);
		}
		try {
			tracks.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public static Object load(String path) throws FileNotFoundException, Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object result = ois.readObject();
		ois.close();
		return result;
	}
	
	public static void save(Object obj, String path) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	private static void save(MyConfiguration y){
		try {
			y.save();
			try {
				y.load("plugins/RpgEssentials/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}