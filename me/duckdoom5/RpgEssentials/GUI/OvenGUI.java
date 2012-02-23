package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class OvenGUI {
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://dl.dropbox.com/u/62672791/textures/bg.png").setPriority(RenderPriority.High).setAnchor(WidgetAnchor.CENTER_CENTER);
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
	}
}
