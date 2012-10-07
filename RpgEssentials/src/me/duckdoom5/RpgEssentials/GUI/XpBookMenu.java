package me.duckdoom5.RpgEssentials.GUI;

import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class XpBookMenu extends GenericPopup{
	public static Map<SpoutPlayer, GenericPopup> bookpopup1 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericLabel> pagewidget = new HashMap<SpoutPlayer, GenericLabel>();
	
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.texture.getString("Level Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		GenericPopup page = new GenericPopup();
		GenericPopup book1 = new GenericPopup();
		Map<SpoutPlayer, GenericPopup> map;
		int pos;
		GenericButton next;
		GenericButton next1 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next2 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next3 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev;
		GenericButton prev1 = (GenericButton) new GenericButton("Prev").setEnabled(false).setTooltip("previous stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev2 = (GenericButton) new GenericButton("Prev").setTooltip("previous stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		
		if(!pagewidget.containsKey(splayer)){
			GenericLabel pagelabel = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);
			pagewidget.put(splayer, pagelabel);
		}
		
		String[] names = {"Mining", "Woodcutting"};
		
		WidgetAnchor anchor;
		page.removeWidgets(plugin);
		for(int row = 0; row < names.length; row++){
			//if(row < 10){
				//next = next1;
				//prev = prev1;
				page = book1;
				map = bookpopup1;
				pos = row;
			//}
			anchor = WidgetAnchor.TOP_CENTER;
			
			//page.attachWidget(plugin, prev);
	    	//page.attachWidget(plugin, next);
			page.attachWidget(plugin,BG);
			
			page.attachWidget(plugin, new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	
			page.attachWidget(plugin, new GenericLabel().setText("Quests").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER));
			
			map.put(splayer, page);
		}
		splayer.getMainScreen().attachPopupScreen(book1);
	}
}
