package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.Material;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreMenu {
 
	public static RpgEssentials plugin;

	//row, name
	public static Map<Integer, String> custom = new HashMap<Integer, String>();
	public static Map<Integer, Short> datamap = new HashMap<Integer, Short>();
	public static Map<Integer, Material> name = new HashMap<Integer, Material>();
	public static Map<Integer, Widget> customblocks = new HashMap<Integer, Widget>();
	
	public static void customStore(SpoutPlayer splayer, String type){
		GenericLabel page = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);
		GenericPopup store1 = new GenericPopup();
		GenericPopup store2 = new GenericPopup();
		GenericPopup store3 = new GenericPopup();
		GenericPopup store4 = new GenericPopup();
		GenericPopup store5 = new GenericPopup();
		GenericPopup store6 = new GenericPopup();
		GenericPopup store7 = new GenericPopup();
		GenericPopup store8 = new GenericPopup();
		GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		
		GenericButton amount = (GenericButton) new GenericButton().setText("1").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
		
		
		String currency = me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency");
		
    	int row = 0;
    	
    	for(Material material:StoreHashmaps.custom) {
    		
    	}
    	
    	
    	double money = PlayerConfig.getMoney(splayer.getName());
    	GenericLabel moneylb = (GenericLabel) new GenericLabel().setText(Double.toString(money)).setHeight(15).setWidth(50).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_RIGHT);
    	
    	store1.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store2.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store3.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store4.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store5.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store6.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store7.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	store8.attachWidget(plugin, BG).attachWidget(plugin, storelb).attachWidget(plugin, amount).attachWidget(plugin, moneylb);
    	
    	if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
			splayer.getMainScreen().getActivePopup().close();
		}
        splayer.getMainScreen().attachPopupScreen(store1);
	}
}