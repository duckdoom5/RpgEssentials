package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LeaderboardMenu {

	public static void openlocal(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://dl.dropbox.com/u/62672791/textures/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		GenericPopup leaderboard = new GenericPopup();
		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
			splayer.getMainScreen().getActivePopup().close();
		}
	}
	public static void openworld(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://dl.dropbox.com/u/62672791/textures/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		GenericPopup leaderboard = new GenericPopup();
		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
			splayer.getMainScreen().getActivePopup().close();
		}
	}
}