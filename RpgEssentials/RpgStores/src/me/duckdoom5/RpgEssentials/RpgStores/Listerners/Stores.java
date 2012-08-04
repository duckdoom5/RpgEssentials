package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;

public class Stores {
	public static void place(int x, int y, int z, String type){
		Configuration.storedata.set(x + "," + y + "," + z, type);
		try {
			Configuration.storedata.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(int x, int y, int z){
		Configuration.storedata.set(x + "," + y + "," + z, null);
		try {
			Configuration.storedata.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
