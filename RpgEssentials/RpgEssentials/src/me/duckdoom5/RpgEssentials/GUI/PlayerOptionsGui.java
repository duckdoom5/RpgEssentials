package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayerOptionsGui implements Gui{
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Options").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	private static int Y = 15;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgEssentials plugin;
	private SpoutPlayer splayer;
	private int page;
	
	public PlayerOptionsGui(RpgEssentials plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		page = 0;
		
		createPopup(true);
		
		GuiManager.gui.put(splayer, this);
	}
	
	private void createPopup(Boolean attach) {
		
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		
		popup.attachWidget(plugin, new GenericButton("Edit Texturepack").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, label).attachWidget(plugin, close);
		if(attach){
			GuiManager.close(splayer);
			splayer.getMainScreen().attachPopupScreen(popup);
		}
	}
	
	public void nextPage(){
		popup.removeWidgets(plugin);
		this.page++;
		if(page > maxPage){
			page = maxPage;
		}
		createPopup(false);
	}
	
	public void prevPage(){
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		createPopup(false);
	}
	
	public Integer getPage() {
		return page;
	}
	
	public void back() {
				
	}
	
	public void save() {
				
	}
}
