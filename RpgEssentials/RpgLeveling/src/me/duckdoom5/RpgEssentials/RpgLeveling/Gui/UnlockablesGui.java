package me.duckdoom5.RpgEssentials.RpgLeveling.Gui;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class UnlockablesGui implements Gui{
	private Skill[] skills = new Skill[]{Skill.ATTACK, Skill.DEFENSE, Skill.RANGED, Skill.EXCAVATION, Skill.FARMING, Skill.MINING, Skill.WOODCUTTING, Skill.CONSTRUCTION, Skill.COOKING, Skill.FIREMAKING, Skill.FISHING, Skill.SMITHING, Skill.QUESTING};
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	private WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
	private Skill skill;
	private RpgLeveling plugin;
	private SpoutPlayer splayer;
	private GenericPopup popup;
	private int page, oldpage, oldrow;
	private int maxPage = 0;
	private static int Y = 15;
	private static int X = -125;
	
	public UnlockablesGui(RpgLeveling plugin, SpoutPlayer splayer, Button button){
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		this.plugin = plugin;
		this.splayer = splayer;
		popup = new GenericPopup();
		page = 0;
		oldpage = GuiManager.gui.get(splayer).getPage();
		oldrow = ((button.getY() -15) /20) + oldpage*9;
		skill = skills[oldrow];
		maxPage = (int) (Math.ceil(skill.getItems().length/9.0) -1);
		createPopup(true);
		
		GuiManager.gui.put(splayer, this);
	}
	
	public void nextPage(){
		splayer.sendMessage("next");
		popup.removeWidgets(plugin);
		this.page++;
		if(page > maxPage){
			page = maxPage;
		}
		createPopup(false);
	}
	
	public void back(){
		LevelGui gui = new LevelGui(plugin, splayer);
	}
	
	public void prevPage(){
		splayer.sendMessage("prev");
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
	
	private void createPopup(Boolean attach){
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		int currentlevel = rpgplayer.getLvl(skill);
		int i1 = page * 9;
		int i2 = i1 + 9;
		
		if(i2 > skill.getItems().length){
			i2 = skill.getItems().length;
		}
		
		for(int row = i1; row < i2; row++){
			int pos = (page > 0 ? row-(page*9) : row);
			if(skill.equals(Skill.FISHING)){
				popup.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(RpgEssentials.mm.getFoodByName(skill.getItems()[row]))).setDepth(18).setHeight(18).setWidth(18).setTooltip(skill.getItems()[row]).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
			}else{
				popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(Material.getMaterial(skill.getItems()[row]))).setDepth(18).setHeight(18).setWidth(18).setTooltip(skill.getItems()[row].toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
			}
			popup.attachWidget(plugin, new GenericLabel().setText(skill.getItems()[row].toLowerCase().replace("_", " ")).setHeight(10).setX(X + 22).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText("Unlocked at level: ").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			
			if(getLevel(skill.getItems()[row], skill) > currentlevel){
				popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(Integer.toString(getLevel(skill.getItems()[row], skill))).setHeight(10).setX(X + 230).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			} else {
				popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(Integer.toString(getLevel(skill.getItems()[row], skill))).setHeight(10).setX(X + 230).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			}
		}
		popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page==maxPage?false:true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page==0?false:true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin,BG);
		
		popup.attachWidget(plugin, new GenericLabel().setText("Unlockables").setHeight(15).shiftXPos(- 35).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericLabel().setText("Current level: " + currentlevel).setHeight(10).setX(-50).setY(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to level menu"));
    	
		popup.attachWidget(plugin,BG);
		
		if(attach){
			GuiManager.close(splayer);
			splayer.getMainScreen().attachPopupScreen(popup);
		}
	}
	
	private static int getLevel(String material, Skill skill) {
		int level = 0;
		if(skill == Skill.FISHING){
			level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + material + ".level");
		}else{
			level = Configuration.level.getInt("UnlockLevel." + material.toLowerCase().replace("_", " "));
		}
		return level;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
