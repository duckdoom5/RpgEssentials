package me.duckdoom5.RpgEssentials.GUI;

import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericListWidget;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.ListWidgetItem;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TexturepackGui implements Gui{
	private GenericButton cancel = (GenericButton) new GenericButton("Cancel").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericButton save = (GenericButton) new GenericButton("Save").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	
	private WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Options").setHeight(15).shiftXPos(- 15).setAnchor(anchor);
	private int maxPage = 1;
	private GenericPopup popup;
	private GenericListWidget list;
	private RpgEssentials plugin;
	private SpoutPlayer splayer;
	private int page;
	private World world;
	
	public TexturepackGui(RpgEssentials plugin, SpoutPlayer splayer){
		this.plugin = plugin;
		this.splayer = splayer;
		this.world = splayer.getWorld();

		page = 0;
		
		Gui gui = GuiManager.gui.get(splayer);
		if(gui == null){
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
		
		list = new GenericListWidget();
		list.setAnchor(WidgetAnchor.CENTER_CENTER).setWidth(400).setHeight(200).shiftXPos(-200).shiftYPos(-100);
		
		if(plugin.hasPermission(splayer, "rpgessentials.rpg.texturepack.playerschoise")){
			list.addItem(new ListWidgetItem(ChatColor.YELLOW + "Player's Choice", ""));
		}
		
		if(Configuration.texture.contains(world.getName())){
			ConfigurationSection section = Configuration.texture.getConfigurationSection(world.getName());
			Set<String> keys = section.getKeys(false);
			
			for(String name:keys){
				ListWidgetItem item = new ListWidgetItem(name, "");
				item.setIconUrl(Configuration.texture.getString(world.getName() + "." + name + ".iconurl"));
				list.addItem(item);
			}
			
			popup.attachWidget(plugin, label).attachWidget(plugin, cancel).attachWidget(plugin, save).attachWidget(plugin, list);
			
			if(attach){
				GuiManager.close(splayer);
				GuiManager.attach(splayer, popup, plugin);
			}
		}else{
			splayer.sendNotification("No texture packs found", "for this world!", Material.APPLE);
		}
	}

	public void nextPage(){
		popup.removeWidgets(plugin);
		this.page++;
		if(page > maxPage){
			page = maxPage;
		}
		createPopup(false, true);
	}
	
	public void prevPage(){
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		createPopup(false, true);
	}

	
	public Integer getPage(){
		return page;
	}

	
	public void back() {
		PlayerOptionsGui gui = new PlayerOptionsGui(plugin, splayer);
	}
	
	public void save() {
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		if (list.getSelectedItem() == null) {
			splayer.sendNotification("Error!", "Select a texture pack!", Material.APPLE);
			return;
		}
		String title = list.getSelectedItem().getTitle();
		if(title.equals(ChatColor.YELLOW + "Player's Choice")){
			splayer.sendNotification("Texture pack removed!", "", Material.GOLDEN_APPLE);
			splayer.resetTexturePack();
			rpgplayer.setTexturepack(world, "none");
		}else{
			splayer.sendNotification("Texture pack selected!", "Downloading...", Material.GOLDEN_APPLE);
			splayer.setTexturePack(Configuration.texture.getString(world.getName() + "." + title + ".url"));
			rpgplayer.setTexturepack(world, title);
		}
		PlayerOptionsGui gui = new PlayerOptionsGui(plugin, splayer);
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}
