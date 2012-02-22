package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TextSelectMenu {
	private static int Y = 15;
	private static int X = -125;
	
	public static void open(Plugin plugin, SpoutPlayer splayer, String title, String[] text, String[] buttons) {
		GenericPopup popup = new GenericPopup();
		
		int row = text.length + buttons.length;
		
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		
		GenericTexture BT = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/bordertop.png").setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(-(20 * buttons.length + 15 * text.length + 31)).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/borderbg.png").setMinWidth(160).setMaxWidth(160).setMinHeight(20 * buttons.length + 15 * text.length + 15).setMaxHeight(20 * buttons.length + 15 * text.length + 15).setPriority(RenderPriority.High).shiftYPos(-(20 * buttons.length + 15 * text.length + 23)).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		GenericTexture BB = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/borderbotom.png").setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(- 8).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		
		for(int pos = 0; pos < text.length; pos++){
			popup.attachWidget(plugin, new GenericLabel(text[pos]).setAlign(WidgetAnchor.TOP_CENTER).setWidth(140).setHeight(20).shiftXPos(-80).shiftYPos(-(15 * (text.length - pos - 1) + 20 * buttons.length + 24)).setAnchor(WidgetAnchor.BOTTOM_RIGHT));
		}
		
		for(int pos2 = 0; pos2 < buttons.length; pos2++){
			popup.attachWidget(plugin, new GenericButton(buttons[pos2]).setWidth(140).setHeight(20).shiftYPos(-(20 * (buttons.length - pos2 - 1) + 28)).shiftXPos(- 150).setAnchor(WidgetAnchor.BOTTOM_RIGHT));
		}
		
		popup.attachWidget(plugin, new GenericLabel(title).setAlign(WidgetAnchor.TOP_CENTER).setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(15).shiftXPos(-80).shiftYPos(-(20 * buttons.length + 15 * text.length + 24)).setAnchor(WidgetAnchor.BOTTOM_RIGHT));
		popup.attachWidget(plugin,BG);
		popup.attachWidget(plugin,BB);
		popup.attachWidget(plugin,BT);
		
		popup.setBgVisible(false);
		
		splayer.getMainScreen().attachPopupScreen(popup);
	}
}
