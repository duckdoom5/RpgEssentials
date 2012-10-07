package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.BreakTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.CraftTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.DeliveryTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.EscortTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.KillTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.PlaceTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.SmeltTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TalkToTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;

public class AddTask implements Gui{
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
	
	private static int Y = 20;
	private int maxPage = 1;
	private GenericPopup popup;
	private RpgQuests plugin;
	private SpoutPlayer splayer;
	private int page;
	private TaskType type;
	private Task task;
	private boolean edit;
	
	public AddTask(RpgQuests plugin, SpoutPlayer splayer, TaskType type){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		this.edit = false;
		
		this.type = type;
		
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
	
	public AddTask(RpgQuests plugin, SpoutPlayer splayer, TaskType type, Task task){
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		page = 0;
		this.edit = true;
		
		this.type = type;
		
		this.task = task;
		
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
	
	private GenericTextField field1 = null;
	private GenericTextField field2 = null;
	private GenericTextField field3 = null;
	private GenericTextField field4 = null;
	private GenericTextField field5 = null;
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		GenericLabel label = (GenericLabel) new GenericLabel().setText(edit?"Edit Task":"Add Task").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
		
		if(type.equals(TaskType.BREAK)){
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((BreakTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((BreakTask)task).getMaterial().getId()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field3 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((BreakTask)task).getDurability()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field3);
			
		}else if(type.equals(TaskType.CRAFT)){
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((CraftTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((CraftTask)task).getMaterial().getId()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field3 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((CraftTask)task).getDurability()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field3);
			
		}else if(type.equals(TaskType.DELIVER)){
			popup.attachWidget(plugin, new GenericLabel("Npc ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?((DeliveryTask)task).getTaskGiver():"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((DeliveryTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field3 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((DeliveryTask)task).getMaterial().getId()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field3);
			
			popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER));
			field4 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((DeliveryTask)task).getDurability()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field4);
			
		}else if(type.equals(TaskType.ESCORT)){
			popup.attachWidget(plugin, new GenericLabel("Npc ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?((EscortTask)task).getNpcToEscort():"").setMaximumCharacters(16).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			if(RpgEssentials.RpgRegions != null){
				popup.attachWidget(plugin, new GenericLabel("Region *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
				field2 = (GenericTextField) new GenericTextField().setText(edit?((EscortTask)task).getRegionName():"").setMaximumCharacters(16).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
				popup.attachWidget(plugin, field2);
			}else{
				popup.attachWidget(plugin, new GenericLabel("Location *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
				String text = "";
				if(edit){
					Location loc = ((EscortTask)task).getLocation();
					text = loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
				}
				field2 = (GenericTextField) new GenericTextField().setText(text).setMaximumLines(1).setTooltip("X,Y,Z").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
				popup.attachWidget(plugin, field2);
			}
		}else if(type.equals(TaskType.KILL)){
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((KillTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Entity type *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((KillTask)task).getType()):"").setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
		}else if(type.equals(TaskType.PLACE)){
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((PlaceTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((PlaceTask)task).getMaterial().getId()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field3 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((PlaceTask)task).getDurability()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field3);
			
		}else if(type.equals(TaskType.SMELT)){
			popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((SmeltTask)task).getAmount()):"").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((SmeltTask)task).getMaterial().getId()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
			
			popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
			field3 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((SmeltTask)task).getDurability()):"").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field3);
			
		}else if(type.equals(TaskType.TALKTO)){
			popup.attachWidget(plugin, new GenericLabel("Npc ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
			field1 = (GenericTextField) new GenericTextField().setText(edit?((TalkToTask)task).getNpcToTalkTo():"").setMaximumCharacters(16).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field1);
			
			popup.attachWidget(plugin, new GenericLabel("Text *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
			field2 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(((TalkToTask)task).getText()):"").setMaximumCharacters(100000000).setMaximumLines(8).setTooltip("The text the npc will say.").setWidth(200).setHeight(100).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
			popup.attachWidget(plugin, field2);
		}
		
		popup.attachWidget(plugin, new GenericLabel("Task ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
		field5 = (GenericTextField) new GenericTextField().setText(edit?String.valueOf(task.getId()):"").setMaximumCharacters(3).setMaximumLines(1).setTooltip("Used for follow order.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
		popup.attachWidget(plugin, field5);
		
		popup.attachWidget(plugin, new GenericButton("Cancel").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		GenericButton add = (GenericButton) new GenericButton(edit?"Edit":"Add").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(0).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		
		popup.attachWidget(plugin, label).attachWidget(plugin, add).attachWidget(plugin, BG);

		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	@Override
	public void back() {
		if(edit){
			Quest quest;
        	if(RpgQuests.qm.createQuest.containsKey(splayer)){
        		quest = RpgQuests.qm.createQuest.get(splayer);
        	}else{
        		quest = RpgQuests.qm.editQuest.get(splayer);
        	}
			TaskList gui = new TaskList(plugin, splayer, quest);
		}else{
			ChooseTask gui = new ChooseTask(plugin, splayer);
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
	
	public boolean addAndValidate(){
		if(type.equals(TaskType.BREAK)){
			int id = 0;
			int amount = 1;
			int matid = 1;
			int data = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field1.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				matid = Integer.parseInt(field2.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			if(!field3.getText().equals("")){
				try{
					data = Integer.parseInt(field3.getText());
				}catch(NumberFormatException e){
					splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
					return false;
				}
			}
			if(edit){
				BreakTask task = (BreakTask)this.task;
				task.setId(id);
				task.setMaterial(new ItemStack(Material.getMaterial(matid),amount,(short) data));
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new BreakTask(id, new ItemStack(Material.getMaterial(matid),amount,(short) data), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			return true;
		}else if(type.equals(TaskType.CRAFT)){
			int id = 0;
			int amount = 1;
			int matid = 1;
			int data = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field1.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				matid = Integer.parseInt(field2.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			if(!field3.getText().equals("")){
				try{
					data = Integer.parseInt(field3.getText());
				}catch(NumberFormatException e){
					splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
					return false;
				}
			}
			
			if(edit){
				CraftTask task = (CraftTask)this.task;
				task.setId(id);
				task.setMaterial(new ItemStack(Material.getMaterial(matid),amount,(short) data));
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new CraftTask(id, new ItemStack(Material.getMaterial(matid),amount,(short) data), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			
			return true;
		}else if(type.equals(TaskType.DELIVER)){
			int id = 0;
			int amount = 1;
			int matid = 1;
			int data = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			NPC deliverTo = RpgEssentials.nm.getNPC(field1.getText());
			if(deliverTo == null){
				splayer.sendNotification("This npc does not exist", "", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field2.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				matid = Integer.parseInt(field3.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			if(!field4.getText().equals("")){
				try{
					data = Integer.parseInt(field4.getText());
				}catch(NumberFormatException e){
					splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
					return false;
				}
			}
			
			if(edit){
				DeliveryTask task = (DeliveryTask)this.task;
				task.setId(id);
				task.setMaterial(new ItemStack(Material.getMaterial(matid),amount,(short) data));
				task.setNpcToDeliverTo(field1.getText());
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new DeliveryTask(id, new ItemStack(Material.getMaterial(matid),amount,(short) data), field1.getText(), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			
			return true;
		}else if(type.equals(TaskType.ESCORT)){
			int id = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			NPC toEscort = RpgEssentials.nm.getNPC(field1.getText());
			if(toEscort == null){
				splayer.sendNotification("This npc does not exist", "", Material.APPLE);
				return false;
			}
			
			if(RpgEssentials.RpgRegions != null){
				String regionname = field2.getText();
				WorldGuardPlugin plugin = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
				if(!plugin.getRegionManager(splayer.getWorld()).hasRegion(regionname)){
					splayer.sendNotification("That region does not exist", "", Material.APPLE);
					return false;
				}
				if(edit){
					EscortTask task = (EscortTask)this.task;
					task.setId(id);
					task.setRegionName(regionname);
					task.setNpcToEscort(field1.getText());
					task.setTaskEnder(null);
					task.setTaskGiver(null);
					splayer.sendNotification("Task edited!", "", Material.APPLE);
				}else{
					Task task = new EscortTask(id, regionname, field1.getText(), null, null);//TODO add npc options!
					add(task);
					splayer.sendNotification("Task added!", "", Material.APPLE);
				}
				return true;
			}
			String[] xyz =  field2.getText().split(",");
			
			if(xyz.length < 3){
				splayer.sendNotification("Incorrect location", "Please use commas", Material.APPLE);
				return false;
			}
			
			double x, y, z;
			
			try{
				x = Integer.parseInt(xyz[0]);
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect x", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				y = Integer.parseInt(xyz[1]);
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect y", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				z = Integer.parseInt(xyz[2]);
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect z", "Please use an integer", Material.APPLE);
				return false;
			}
			
			Location to = new Location(splayer.getWorld(), x,y,z);
			
			if(edit){
				EscortTask task = (EscortTask)this.task;
				task.setId(id);
				task.setLocation(to);
				task.setNpcToEscort(field1.getText());
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new EscortTask(id, to, field1.getText(), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			return true;
			
		}else if(type.equals(TaskType.KILL)){
			EntityType etype = null;
			int amount = 1;
			int id = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field1.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				etype = EntityType.valueOf(field2.getText().toUpperCase().replace(" ", "_"));
			}catch(Exception e){
				splayer.sendNotification("That is not a valid", "entity type", Material.APPLE);
				return false;
			}
			if(edit){
				KillTask task = (KillTask)this.task;
				task.setId(id);
				task.setEntityType(etype);
				task.setAmount(amount);
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new KillTask(id, etype, amount, null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			return true;
		}else if(type.equals(TaskType.PLACE)){
			int id = 0;
			int amount = 1;
			int matid = 1;
			int data = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field1.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				matid = Integer.parseInt(field2.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			if(!field3.getText().equals("")){
				try{
					data = Integer.parseInt(field3.getText());
				}catch(NumberFormatException e){
					splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
					return false;
				}
			}
			
			if(edit){
				PlaceTask task = (PlaceTask)this.task;
				task.setId(id);
				task.setMaterial(new ItemStack(Material.getMaterial(matid),amount,(short) data));
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new PlaceTask(id, new ItemStack(Material.getMaterial(matid),amount,(short) data), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			
			return true;
		}else if(type.equals(TaskType.SMELT)){
			int id = 0;
			int amount = 1;
			int matid = 1;
			int data = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				amount = Integer.parseInt(field1.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
				return false;
			}
			
			try{
				matid = Integer.parseInt(field2.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			if(!field3.getText().equals("")){
				try{
					data = Integer.parseInt(field3.getText());
				}catch(NumberFormatException e){
					splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
					return false;
				}
			}
			
			if(edit){
				SmeltTask task = (SmeltTask)this.task;
				task.setId(id);
				task.setMaterial(new ItemStack(Material.getMaterial(matid),amount,(short) data));
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new SmeltTask(id, new ItemStack(Material.getMaterial(matid),amount,(short) data), null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			
			return true;
		}else if(type.equals(TaskType.TALKTO)){
			int id = 0;
			
			if(field1.getText().equals("") || field2.getText().equals("") || field5.getText().equals("")){
				splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
				return false;
			}
			String text = field2.getText();
			try{
				id = Integer.parseInt(field5.getText());
			}catch(NumberFormatException e){
				splayer.sendNotification("Incorrect ID", "Please use an integer", Material.APPLE);
				return false;
			}
			
			NPC toTalkTo = RpgEssentials.nm.getNPC(field1.getText());
			if(toTalkTo == null){
				splayer.sendNotification("This npc does not exist", "", Material.APPLE);
				return false;
			}
			
			if(edit){
				TalkToTask task = (TalkToTask)this.task;
				task.setId(id);
				task.setNpcToTalkTo(field1.getText());
				task.setText(text);
				task.setTaskEnder(null);
				task.setTaskGiver(null);
				splayer.sendNotification("Task edited!", "", Material.APPLE);
			}else{
				Task task = new TalkToTask(id, field1.getText(), text, null, null);//TODO add npc options!
				add(task);
				splayer.sendNotification("Task added!", "", Material.APPLE);
			}
			
			return true;
		}
		return false;
	}
	
	private void add(Task task){
		Quest quest = RpgQuests.qm.createQuest.get(splayer);
		quest.addTask(task);
		RpgQuests.qm.createQuest.put(splayer, quest);
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}
