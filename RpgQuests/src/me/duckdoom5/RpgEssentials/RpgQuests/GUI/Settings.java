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
	
	private GenericTextField field1 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?quest.getId():"").setTooltip("The id used for commands.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field2 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?quest.getName():"").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field3 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?RpgEssentials.nm.getNPCIdFromEntity(RpgEssentials.nm.getNPC(quest.getQuestGiver()).getBukkitEntity()):"").setTooltip("Name of the npc.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field4 = (GenericTextField) new GenericTextField().setMaximumLines(1).setText(edit?RpgEssentials.nm.getNPCIdFromEntity(RpgEssentials.nm.getNPC(quest.getQuestEnder()).getBukkitEntity()):"").setTooltip("Name of the npc.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field5 = (GenericTextField) new GenericTextField().setMaximumCharacters(10000).setMaximumLines(4).setText(edit?quest.getStartText():"").setTooltip("Text that the npc will say when you've started the quest.").setWidth(200).setHeight(45).shiftXPos(-100).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field6 = (GenericTextField) new GenericTextField().setMaximumCharacters(10000).setMaximumLines(4).setText(edit?quest.getTaskText():"").setTooltip("Tasks of the quest.").setWidth(200).setHeight(45).shiftXPos(-100).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field7 = (GenericTextField) new GenericTextField().setMaximumCharacters(10000).setMaximumLines(4).setText(edit?quest.getBetweenText():"").setTooltip("Text that the npc will say when you've started the quest, but you've not done or completed the quest yet.").setWidth(200).setHeight(45).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field8 = (GenericTextField) new GenericTextField().setMaximumCharacters(10000).setMaximumLines(4).setText(edit?quest.getCompleteText():"").setTooltip("Text that the npc will say when you've completed the quest.").setWidth(200).setHeight(45).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericTextField field9 = (GenericTextField) new GenericTextField().setMaximumCharacters(10000).setMaximumLines(4).setText(edit?quest.getDoneText():"").setTooltip("Text that the npc will say when you've done the quest.").setWidth(200).setHeight(45).shiftXPos(-100).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER);
	
	private GenericLabel label1;
	private GenericLabel label2;
	private GenericLabel label3;
	private GenericLabel label4;
	private GenericLabel label5;
	private GenericLabel label6;
	private GenericLabel label7;
	private GenericLabel label8;
	private GenericLabel label9;
	
	private GenericButton cancel = (GenericButton) new GenericButton("Cancel").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericButton prev = (GenericButton) new GenericButton("Prev").setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericButton next = (GenericButton) new GenericButton("Next").setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label;
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			if(page == 1){				
				field1.setVisible(false);
				field2.setVisible(false);
				field3.setVisible(false);
				field4.setVisible(false);
				field5.setVisible(false);
				field6.setVisible(false);
			}else{				
				field7.setVisible(false);
				field8.setVisible(false);
				field9.setVisible(false);
			}
			if(popup.containsWidget(BG)){
				popup.removeWidget(label1);
				popup.removeWidget(label2);
				popup.removeWidget(label3);
				popup.removeWidget(label4);
				popup.removeWidget(label5);
				popup.removeWidget(label6);
				popup.removeWidget(label7);
				popup.removeWidget(label8);
				popup.removeWidget(label9);
				
				popup.removeWidget(BG);
				popup.removeWidget(prev);
				popup.removeWidget(next);
				popup.removeWidget(cancel);
				popup.removeWidget(label);
				popup.removeWidget(save);
			}else if(remove){
				popup.removeWidgets(plugin);
			}
		}
		
		boolean enabled = true;;
		if(!RpgQuests.qm.createQuest.containsKey(splayer)){
			enabled = false;
		}
		
		label = (GenericLabel) new GenericLabel().setText(edit?"Edit Settings":"Settings").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		
		if(page == 1){
			popup.attachWidget(plugin, label7 = (GenericLabel) new GenericLabel("Between text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
			field7.setVisible(true);
			popup.attachWidget(plugin, field7);
			
			popup.attachWidget(plugin, label8 = (GenericLabel) new GenericLabel("Complete text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field8.setVisible(true);
			popup.attachWidget(plugin, field8);
			
			popup.attachWidget(plugin, label9 = (GenericLabel) new GenericLabel("Done text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER));
			field9.setVisible(true);
			popup.attachWidget(plugin, field9);
			
		}else{
		
			popup.attachWidget(plugin, label1 = (GenericLabel) new GenericLabel("ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
			field1.setVisible(true);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, label2 = (GenericLabel) new GenericLabel("Name *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field2.setVisible(true);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, label3 = (GenericLabel) new GenericLabel("Quest giver  *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field3.setVisible(true);
			popup.attachWidget(plugin, field3);
			
			popup.attachWidget(plugin, label4 = (GenericLabel) new GenericLabel("Quest ender *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field4.setVisible(true);
			popup.attachWidget(plugin, field4);
			
			popup.attachWidget(plugin, label5 = (GenericLabel) new GenericLabel("Start text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER));
			field5.setVisible(true);
			popup.attachWidget(plugin, field5);
			
			popup.attachWidget(plugin, label6 = (GenericLabel) new GenericLabel("Task text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER));
			field6.setVisible(true);
			popup.attachWidget(plugin, field6);
		
		}
		
		popup.attachWidget(plugin, next.setEnabled(page==maxPage?false:true));
		popup.attachWidget(plugin, prev.setEnabled(page==0?false:true));
				
		popup.attachWidget(plugin, label).attachWidget(plugin, save).attachWidget(plugin, BG).attachWidget(plugin, cancel);

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
		
		saveTemp();
		
		createPopup(false, true);
	}

	@Override
	public void prevPage() {
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		
		saveTemp();
		
		createPopup(false, true);
	}

	private void saveTemp() {
		
	}

	@Override
	public void save() {
	}
	
	public boolean validateAndAdd(){
		if(field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals("") || field6.getText().equals("") || field7.getText().equals("") || field8.getText().equals("") || field9.getText().equals("")){
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
			Quest quest = new Quest(field1.getText(), field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText(), field7.getText(), field8.getText(), field9.getText());
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