package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

import org.bukkit.ChatColor;
import org.bukkit.block.CreatureSpawner;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpawnerWandGui implements Gui{
	String[] names = new String[]{"Pig","Chicken","Sheep", "Cow","Squid", "Mooshroom", "Wolf", "Ocelot", "Villager", "Iron Golem", "Snow Golem", "Pig Zombie", "Zombie", "Skeleton", "Creeper", "Giant", "Ghast", "Spider", "Blaze", "Slime", "Magma Slime", "Enderman", "Silverfish", "Cave Spider"};
	private CreatureSpawner spawner;
	private GenericLabel type = (GenericLabel) new GenericLabel().setHeight(15).setWidth(30).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_CENTER);
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	private RpgEssentials plugin;
	private SpoutPlayer splayer;
	private GenericPopup popup;
	int Y = 25;
	
	public SpawnerWandGui(RpgEssentials plugin, SpoutPlayer splayer, CreatureSpawner spawner){
		this.plugin = plugin;
		this.splayer = splayer;
		this.spawner = spawner;
		
		Gui gui = GuiManager.gui.get(splayer);
		if(gui == null){
			popup = new GenericPopup();
		}else{
			popup = gui.getPopup();
		}
		
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
	
	public CreatureSpawner getSpawner(){
		return spawner;
	}
	
	private void createPopup(boolean attach, boolean remove) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		for(int row = 0; row < names.length; row++){
			int pos = row;
			boolean right = false;
			boolean center = false;
			if(row % 3 == 1){
				pos = row -1;
				center = true;
			}else if(row % 3 == 2){
				pos = row -2;
				right = true;
			}
			popup.attachWidget(plugin, new GenericButton(names[row]).setWidth(100).setHeight(20).shiftXPos(right? -160 : center? -50 :+60).setY((int) (Y + (pos * 25/3.0))).setAnchor(WidgetAnchor.TOP_CENTER));
		}
		double money = PlayerConfig.getMoney(splayer.getName());
		
		type.setText(ChatColor.YELLOW + "Current type: " + ChatColor.GREEN + spawner.getCreatureTypeName().toLowerCase().replace("_", " "));
		
		popup.attachWidget(plugin, type).attachWidget(plugin, BG).attachWidget(plugin, close);
		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	public void save() {
	}

	public void updateText() {
		type.setText(ChatColor.YELLOW + "Current type: " + ChatColor.GREEN + spawner.getCreatureTypeName().toLowerCase().replace("_", " "));
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}