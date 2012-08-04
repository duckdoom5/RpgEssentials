package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

public class Creator implements Gui{
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Create").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setWidth(800).setHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
	private static int Y = 15;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgQuests plugin;
	private SpoutPlayer splayer;
	private int page;
	
	public Creator(RpgQuests plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		page = 0;
		
		createPopup(true);
		
		GuiManager.gui.put(splayer, this);
	}
	
	private void createPopup(Boolean attach) {
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		popup.attachWidget(plugin, new GenericButton("New Task").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("New Reward").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("Settings").setWidth(200).setHeight(20).shiftXPos(-100).setY(-Y - 25).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page==maxPage?false:true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page==0?false:true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, label).attachWidget(plugin, close).attachWidget(plugin, BG);
		if(attach){
			GuiManager.close(splayer);
			splayer.getMainScreen().attachPopupScreen(popup);
		}
	}
	
	@Override
	public void back() {
		List gui = new List(plugin, splayer);
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
		createPopup(false);
	}

	@Override
	public void prevPage() {
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		createPopup(false);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
