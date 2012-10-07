package me.duckdoom5.RpgEssentials.RpgStores.Listerners;

import java.io.IOException;

import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreCreateGui;

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
	
	public static void create(int x, int y, int z, SpoutPlayer splayer){
		StoreCreateGui gui = new StoreCreateGui(x, y, z, (RpgStores) RpgEssentials.RpgStores, splayer);
	}
}
