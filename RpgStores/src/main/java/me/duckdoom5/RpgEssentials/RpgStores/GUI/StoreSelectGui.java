package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreHashmaps;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreSelectGui extends Gui{
	String[] names = new String[]{"Food","Tools","Armor","Mechanisms","Gardening","Furniture","Materials","Raw Materials","The End","Ores","Painting","Mob Drops","Brewing","Music","Nether","Miscellaneous"};
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	private RpgStores plugin;
	private SpoutPlayer splayer;
	private GenericPopup popup;
	int Y = 25;
	
	public StoreSelectGui(RpgStores plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;

		Gui gui = GuiManager.gui.get(splayer);
		if(gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN){
			popup = new GenericPopup();
			createPopup(true, false);
		}else{
			popup = gui.getPopup();
			createPopup(false, true);
		}
		
		GuiManager.gui.put(splayer, this);
	}
	
	public StoreSelectGui(RpgStores plugin, SpoutPlayer splayer, int x, int y, int z){
		if((!Configuration.storedata.contains(x + "," + y + "," + z))){
			Configuration.storedata.set(x + "," + y + "," + z, "all");
		}
		if(!Configuration.storedata.getString(x + "," + y + "," + z).equalsIgnoreCase("all")){
			StoreHashmaps.registerCustomStore(plugin, splayer, Configuration.storedata.getString(x + "," + y + "," + z));
			return;
		}
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		createPopup(true, false);
		
		GuiManager.gui.put(splayer, this);
	}
	
	public StoreSelectGui(RpgStores plugin, SpoutPlayer splayer, String name){
		if((!Configuration.storedata.contains(name))){
			Configuration.storedata.set(name, "all");
		}
		if(!Configuration.storedata.getString(name).equalsIgnoreCase("all")){
			StoreHashmaps.registerCustomStore(plugin, splayer, Configuration.storedata.getString(name));
			return;
		}
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		createPopup(true, false);
		
		GuiManager.gui.put(splayer, this);
	}
	
	public void nextPage(){
	}
	
	public void prevPage(){
	}
	
	public void back(){
	}
	
	public Integer getPage(){
		return 0;
	}
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		for(int row = 0; row < names.length; row++){
			int pos = row;
			boolean right = false;
			if(row % 2 != 0){
				pos = row -1;
				right = true;
			}
			popup.attachWidget(plugin, new GenericButton(names[row]).setWidth(200).setHeight(20).shiftXPos(right? -205 : +5).setY((int) (Y + (pos * 12.5))).setAnchor(WidgetAnchor.TOP_CENTER));
		}
		double money = PlayerConfig.getMoney(splayer.getName());
    	GenericLabel moneylb = (GenericLabel) new GenericLabel().setText(Double.toString(money)).setHeight(15).setWidth(50).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_RIGHT);
		GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		
		popup.attachWidget(plugin, moneylb).attachWidget(plugin, storelb).attachWidget(plugin, BG).attachWidget(plugin, close);
		
		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	public void save() {
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}
