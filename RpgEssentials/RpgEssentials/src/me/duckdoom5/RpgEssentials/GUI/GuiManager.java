package me.duckdoom5.RpgEssentials.GUI;

import java.util.HashMap;
import java.util.Map;

import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GuiManager {
	public static Map<SpoutPlayer, Gui> gui = new HashMap<SpoutPlayer, Gui>();
	
	public static void close(SpoutPlayer splayer){
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			splayer.getMainScreen().closePopup();
		}
	}
}
