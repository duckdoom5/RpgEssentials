package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import org.bukkit.Material;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;

public class Settings implements Gui{
	private GenericButton save = (GenericButton) new GenericButton("Save").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(0).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
	private static int Y = 20;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgQuests plugin;
	private SpoutPlayer splayer;
	private int page;
	private Quest quest;
	private boolean edit;
	
	public Settings(RpgQuests plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		
		this.edit = false;
		
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
	
	public Settings(RpgQuests plugin, SpoutPlayer splayer, Quest quest){
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		page = 0;

		this.quest = quest;
		
		this.edit = true;
		
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
	
	private GenericTextField field1;
	private GenericTextField field2;
	private GenericTextField field3;
	private GenericTextField field4;
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		boolean enabled = true;;
		if(!RpgQuests.qm.createQuest.containsKey(splayer)){
			enabled = false;
		}
		
		GenericLabel label = (GenericLabel) new GenericLabel().setText(edit?"Edit Settings":"Settings").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		
		popup.attachWidget(plugin, new GenericLabel("ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
		field1 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?quest.getId():"").setTooltip("The id used for commands.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(plugin, field1);
		
		popup.attachWidget(plugin, new GenericLabel("Name *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
		field2 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?quest.getName():"").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(plugin, field2);
		
		popup.attachWidget(plugin, new GenericLabel("Quest giver  *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
		field3 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?RpgEssentials.nm.getNPCIdFromEntity(RpgEssentials.nm.getNPC(quest.getQuestGiver()).getBukkitEntity()):"").setTooltip("Name of the npc.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(plugin, field3);
		
		popup.attachWidget(plugin, new GenericLabel("Quest ender *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
		field4 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?RpgEssentials.nm.getNPCIdFromEntity(RpgEssentials.nm.getNPC(quest.getQuestEnder()).getBukkitEntity()):"").setTooltip("Name of the npc.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(plugin, field4);
		
		popup.attachWidget(plugin, new GenericButton("Cancel").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, label).attachWidget(plugin, save).attachWidget(plugin, BG);

		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	@Override
	public void back() {
		if(edit && !RpgQuests.qm.isCreating.contains(splayer)){
			Editor gui = new Editor(plugin, splayer, quest);
		}else{
			Creator gui = new Creator(plugin, splayer);
		}
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
	
	public boolean validateAndAdd(){
		if(field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals("")){
			splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
			return false;
		}
		
		NPC giver = RpgEssentials.nm.getNPC(field3.getText());
		if(giver == null){
			splayer.sendNotification("Error on quest giver", "This npc does not exist", Material.APPLE);
			return false;
		}
		
		NPC ender = RpgEssentials.nm.getNPC(field4.getText());
		if(ender == null){
			splayer.sendNotification("Error on quest ender", "This npc does not exist", Material.APPLE);
			return false;
		}
		if(edit){
			Quest quest = this.quest;
			quest.setId(field1.getText()).setName(field2.getText()).setQuestGiver(field3.getText()).setQuestEnder(field4.getText());
		}else{
			Quest quest = new Quest(field1.getText(), field2.getText(), field3.getText(), field4.getText());
			add(quest);
		}
		
		splayer.sendNotification("Saved!", "", Material.APPLE);
		return true;
	}
	
	private void add(Quest quest){
		RpgQuests.qm.createQuest.put(splayer, quest);
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}