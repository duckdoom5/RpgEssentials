package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

public class ChooseReward implements Gui{
	private GenericButton close = (GenericButton) new GenericButton("Back").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Choose Reward").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
	
	private static int Y = 20;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgQuests plugin;
	private SpoutPlayer splayer;
	private int page;
	
	public ChooseReward(RpgQuests plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		
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
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer.getName());
		
		popup.attachWidget(plugin, new GenericButton("Material").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
		popup.attachWidget(plugin, new GenericButton("Money").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
		popup.attachWidget(plugin, new GenericButton("Xp").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, label).attachWidget(plugin, close).attachWidget(plugin, BG);

		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	@Override
	public void back() {
		Creator gui = new Creator(plugin, splayer);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}
