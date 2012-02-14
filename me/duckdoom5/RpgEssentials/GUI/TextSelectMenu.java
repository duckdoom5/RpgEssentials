package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
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
	
	public static void open(Plugin plugin, SpoutPlayer splayer, String Question, String[] args) {
		GenericPopup popup = new GenericPopup();
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		
		GenericTexture BT = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/bordertop.png").setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(-(20 * args.length + 16)).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/borderbg.png").setMinWidth(160).setMaxWidth(160).setMinHeight(20 * args.length).setMaxHeight(20 * args.length).setPriority(RenderPriority.High).shiftYPos(-(20 * args.length + 8)).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		GenericTexture BB = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/text/borderbotom.png").setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(- 8).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		
		GenericLabel question = (GenericLabel) new GenericLabel().setText(Question).setHeight(15).shiftYPos(-(20 * args.length + 8)).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
		popup.attachWidget(plugin, question.shiftXPos(question.getWidth()/2));
		
		for(int pos = 0; pos < args.length; pos++){
			popup.attachWidget(plugin, new GenericButton(args[pos]).setWidth(140).setHeight(20).shiftYPos(-(20 * pos + 28)).shiftXPos(- 150).setAnchor(WidgetAnchor.BOTTOM_RIGHT));
		}
		
		popup.attachWidget(plugin,BG);
		popup.attachWidget(plugin,BB);
		popup.attachWidget(plugin,BT);
		
		popup.setBgVisible(false);
		
		splayer.getMainScreen().attachPopupScreen(popup);
	}
}
