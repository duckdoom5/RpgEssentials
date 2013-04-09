package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;

public class StoreCreateGui extends Gui{
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Please enter the custom store's name or all").setHeight(15).shiftXPos(- 90).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
	private static int Y = 20;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgStores plugin;
	private SpoutPlayer splayer;
	private int page;
	
	public int x,y,z;
	
	public String name;
	
	public StoreCreateGui(int x, int y, int z, RpgStores plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		
		this.x = x;
		this.y = y;
		this.z = z;
		
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
	
	public StoreCreateGui(String name, RpgStores plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		
		this.name = name;
		
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
	
	public GenericTextField field1 = new GenericTextField();
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		boolean enabled = false;
		boolean hastask = false;
		popup.attachWidget(plugin, field1.setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("Create").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		
		popup.attachWidget(plugin, label).attachWidget(plugin, BG);

		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	@Override
	public void back() {
	}

	@Override
	public Integer getPage() {
		return page;
	}

	@Override
	public void nextPage() {
		popup.removeWidgets(plugin);
		this.page++;
		if(page > maxPage){
			page = maxPage;
		}
		createPopup(false, true);
	}

	@Override
	public void prevPage() {
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		createPopup(false, true);
	}

	@Override
	public void save() {
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}

}
