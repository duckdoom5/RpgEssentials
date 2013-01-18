package me.duckdoom5.RpgEssentials.RpgLeveling.Gui;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.LevelingSystem;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelGui extends Gui{
	private Skill[] skills = new Skill[]{Skill.ATTACK, Skill.DEFENSE, Skill.RANGED, Skill.EXCAVATION, Skill.FARMING, Skill.MINING, Skill.WOODCUTTING, Skill.CONSTRUCTION, Skill.COOKING, Skill.FIREMAKING, Skill.FISHING, Skill.SMITHING, Skill.QUESTING};
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericTexture BG = null;
	private WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
	private GenericItemWidget sword = (GenericItemWidget) new GenericItemWidget(new ItemStack(Material.DIAMOND_SWORD)).setDepth(18).setHeight(18).setWidth(18).shiftXPos(- 50).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericLabel label = (GenericLabel) new GenericLabel().setText("Stats").setHeight(15).shiftXPos(- 15).setAnchor(anchor);
	private int maxPage = 1;
	private static int Y = 20;
	private static int X = -200;
	private RpgLeveling plugin;
	private RpgEssentials plugin2;
	private SpoutPlayer splayer;
	private GenericPopup popup;
	private int page;
	private int SP;
	
	
	public LevelGui(RpgLeveling plugin, RpgEssentials plugin2, SpoutPlayer splayer){
		this.plugin = plugin;
		this.plugin2 = plugin2;
		this.splayer = splayer;
		BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setWidth(splayer.getMainScreen().getWidth()).setHeight(splayer.getMainScreen().getHeight()).setPriority(RenderPriority.High);
		page = 0;
		
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		SP = rpgplayer.getSkillPoints();
		
		maxPage = (int) (Math.ceil(skills.length/9.0) -1);
		
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
	
	public void back(){
	}
	
	private void createPopup(boolean attach, boolean remove){
		if(remove){
			if(plugin2 != null){
				popup.getPlugin();
				popup.removeWidgets(plugin2);
			}
			popup.removeWidgets(plugin);
		}
		
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
		int i1 = page * 9;
		int i2 = i1 + 9;
		
		if(i2>skills.length){
			i2 = skills.length;
		}
		
		for(int row = i1; row < i2; row++){
			int pos = (page > 0 ? row-(page*9) : row);
			int currentlevel = rpgplayer.getLvl(skills[row]);
			popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(skills[row].getMaterial())).setDepth(18).setHeight(18).setWidth(18).setTooltip(skills[row].toString().toLowerCase()).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText(skills[row].toString().toLowerCase()).setHeight(10).setX(X + 22).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText(Integer.toString(currentlevel)).setTooltip("Level").setHeight(10).setX(X + 135).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText(Integer.toString(rpgplayer.getExp(skills[row])) + "/" + Integer.toString(LevelingSystem.getExpRequired(rpgplayer, skills[row]))).setTooltip("Exp left: " + Integer.toString(LevelingSystem.getExpLeft(rpgplayer, skills[row]))).setHeight(10).setX(X + 190).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericButton("Spend").setEnabled(SP>0?true:false).setHeight(20).setX(X + 270).setY(Y + (pos * 20)).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericButton("Unlockables").setEnabled(skills[row].equals(Skill.MINING)?true:skills[row].equals(Skill.WOODCUTTING)?true:skills[row].equals(Skill.FARMING)?true:skills[row].equals(Skill.ATTACK)?true:skills[row].equals(Skill.EXCAVATION)?true:skills[row].equals(Skill.FISHING)?true:skills[row].equals(Skill.DEFENSE)?true:false).setHeight(20).setWidth(70).setX(X + 330).setY(Y + (pos * 20)).setAnchor(anchor));
		}
		
		popup.attachWidget(plugin, label);
		
		popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page==maxPage?false:true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page==0?false:true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, close);
		popup.attachWidget(plugin, BG);
		
		popup.attachWidget(plugin, sword);
		
		
		popup.attachWidget(plugin, new GenericLabel().setText("Combat level: " + rpgplayer.getLvl(Skill.COMBAT)).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericLabel().setText("Skill Points: " + rpgplayer.getSkillPoints()).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	public Integer getPage(){
		return page;
	}
	
	static int xptolvl;
	public void spend(RpgLeveling plugin, SpoutPlayer splayer, Button button) {
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
        int oldpage = GuiManager.gui.get(splayer).getPage();
		int oldrow = ((button.getY() -15) /20) + oldpage*9;
		Skill[] skills = new Skill[]{Skill.ATTACK, Skill.DEFENSE, Skill.RANGED, Skill.EXCAVATION, Skill.FARMING, Skill.MINING, Skill.WOODCUTTING, Skill.CONSTRUCTION, Skill.COOKING, Skill.FIREMAKING, Skill.FISHING, Skill.SMITHING, Skill.QUESTING};
		Skill skill = skills[oldrow];
		int currentlevel = rpgplayer.getLvl(skill);
		xptolvl = 0;
		
		double exponent = Configuration.level.getDouble("Level exponent");
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/exponent)) * (level + 300) ) ) / 4 );
		}
		
		rpgplayer.setExp(skill, xptolvl);
		rpgplayer.setLvl(skill, rpgplayer.getLvl(skill) + 1);
		rpgplayer.setSkillPoints(SP - 1);
		
		splayer.sendNotification(skill.toString().toLowerCase() + " level up!", "Your level is now: " + (rpgplayer.getLvl(skill) + 1), Material.getMaterial(Configuration.level.getInt("level-up material")));
		LevelingSystem.checknewcombat(rpgplayer, plugin);
		
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
