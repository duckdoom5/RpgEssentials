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
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;

public class QuestList extends Gui{
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericButton create = (GenericButton) new GenericButton("Create").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Quest List").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	private static int Y = 20;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgQuests plugin;
	private RpgEssentials plugin2;
	private SpoutPlayer splayer;
	private int page;
	
	public QuestList(RpgQuests plugin, RpgEssentials plugin2, SpoutPlayer splayer){
		this.plugin = plugin;
		this.plugin2 = plugin2;
		this.splayer = splayer;
		page = 0;
		maxPage = (int) (Math.ceil(RpgQuests.qm.getQuests().length/9.0) -1);
		
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
			if(plugin2 != null){
				popup.getPlugin();
				popup.removeWidgets(plugin2);
			}
			popup.removeWidgets(plugin);
		}
		
		int i1 = page * 9;
		int i2 = i1 + 9;
		
		if(i2>RpgQuests.qm.getQuests().length){
			i2 = RpgQuests.qm.getQuests().length;
		}
		
		popup.removeWidgets(plugin);
		
		popup.attachWidget(plugin, new GenericLabel("ID").setWidth(100).setHeight(20).shiftXPos(-202).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericLabel("Name").setWidth(200).setHeight(20).shiftXPos(-104).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericLabel("Edit").setWidth(50).setHeight(20).shiftXPos(+112).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericLabel("Delete").setWidth(50).setHeight(20).shiftXPos(+156).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));
		
		for(int row = i1; row < i2; row++){
			int pos = (page > 0 ? row-(page*9) : row) + 1;
			
			popup.attachWidget(plugin, new GenericLabel(String.valueOf(RpgQuests.qm.getQuests()[row].getId())).setWidth(100).setHeight(20).shiftXPos(-200).setY(Y + 5 + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));
			
			popup.attachWidget(plugin, new GenericLabel(String.valueOf(RpgQuests.qm.getQuests()[row].getName())).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 5 + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));
			
			popup.attachWidget(plugin, new GenericButton("Edit").setWidth(50).setHeight(20).shiftXPos(+100).setY(Y + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));
			
			popup.attachWidget(plugin, new GenericButton("Delete").setWidth(50).setHeight(20).shiftXPos(+150).setY(Y + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));
		}
		
		popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page==maxPage?false:true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page==0?false:true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, label).attachWidget(plugin, close).attachWidget(plugin, create).attachWidget(plugin, BG);
		
		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	public void back() {
		if(RpgQuests.qm.isCreating.contains(splayer)){
			Creator gui = new Creator(plugin, splayer);
		}
	}

	public Quest getQuest(int row) {
		return RpgQuests.qm.getQuests()[row -1];
	}
	
	@Override
	public Integer getPage(){
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