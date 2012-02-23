package me.duckdoom5.RpgEssentials.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.levels.LevelingSystem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
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

public class LevelMenu extends GenericPopup{
	public static Map<SpoutPlayer, GenericPopup> statspopup1 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericPopup> statspopup2 = new HashMap<SpoutPlayer, GenericPopup>();
	public static Map<SpoutPlayer, GenericLabel> pagewidget = new HashMap<SpoutPlayer, GenericLabel>();
	
	private static int Y = 15;
	private static int X = -200;
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://dl.dropbox.com/u/62672791/textures/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}

		GenericPopup page = new GenericPopup();
		GenericPopup stats1 = new GenericPopup();
		GenericPopup stats2 = new GenericPopup();
		Map map;
		int pos;
		GenericButton next;
		GenericButton next1 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next2 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton next3 = (GenericButton) new GenericButton("Next").setEnabled(false).setTooltip("next stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev;
		GenericButton prev1 = (GenericButton) new GenericButton("Prev").setEnabled(false).setTooltip("previous stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		GenericButton prev2 = (GenericButton) new GenericButton("Prev").setTooltip("previous stats page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER);
		
		if(!pagewidget.containsKey(splayer)){
			GenericLabel pagelabel = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(- 10).setAnchor(WidgetAnchor.TOP_RIGHT);
			pagewidget.put(splayer, pagelabel);
		}
		
		String[] names = {"Mining", "Woodcutting", "Farming", "Attack", "Defense", "Firemaking", "Construction", "Excavation", "Cooking", "Ranged", "Smithing", "Fishing"};
		WidgetAnchor anchor;
		page.removeWidgets(plugin);
		int sp = Configuration.players.getInt("players." + splayer.getName() + ".SP");
		for(int row = 0; row < names.length; row++){
			if(row < 9){
				next = next1;
				prev = prev1;
				page = stats1;
				map = statspopup1;
				pos = row;
			}else{
				stats1.removeWidget(next1);
				next1.setEnabled(true).setPriority(RenderPriority.Lowest);
				stats1.attachWidget(plugin, next1);
				statspopup1.put(splayer, stats1);
				next = next2;
				prev = prev2;
				page = stats2;
				map = statspopup2;
				pos = row - 9;
			}
			anchor = WidgetAnchor.TOP_CENTER;
			int currentlevel = Configuration.players.getInt("players." + splayer.getName() + "." + names[row] + ".level");
			page.attachWidget(plugin, new GenericItemWidget(new ItemStack(getmaterial(names[row]))).setDepth(8).setHeight(8).setWidth(8).setTooltip(names[row]).setX(X).setY((int) (Y + (pos * 20))).setAnchor(anchor));
			page.attachWidget(plugin, new GenericLabel().setText(names[row]).setHeight(10).setX(X + 22).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			page.attachWidget(plugin, new GenericLabel().setText(Integer.toString(currentlevel)).setTooltip("Level").setHeight(10).setX(X + 135).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			page.attachWidget(plugin, new GenericLabel().setText(Integer.toString(Configuration.players.getInt("players." + splayer.getName() + "." + names[row] +".exp")) + "/" + Integer.toString(LevelingSystem.getExpRequired(splayer, names[row]))).setTooltip("Exp left: " + Integer.toString(LevelingSystem.getExpLeft(splayer, names[row]))).setHeight(10).setX(X + 190).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			page.attachWidget(plugin, new GenericButton("Spend").setEnabled(sp>0?true:false).setHeight(20).setX(X + 270).setY((int) (Y + (pos * 20))).setAnchor(anchor));
			page.attachWidget(plugin, new GenericButton("Unlockables").setEnabled(names[row] == "Mining"?true:names[row] == "Woodcutting"?true:names[row] == "Farming"?true:names[row] == "Attack"?true:names[row] == "Excavation"?true:false).setHeight(20).setWidth(70).setX(X + 330).setY((int) (Y + (pos * 20))).setAnchor(anchor));
			
			page.attachWidget(plugin, prev);
	    	page.attachWidget(plugin, next);
			page.attachWidget(plugin,BG);
			
			GenericLabel points = new GenericLabel();
			page.attachWidget(plugin, new GenericItemWidget(new ItemStack(Material.DIAMOND_SWORD)).setDepth(8).setHeight(8).setWidth(8).shiftXPos(- 50).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
			page.attachWidget(plugin, new GenericLabel().setText("Combat level: " + Configuration.players.getInt("players." + splayer.getName() + ".combatlvl")).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
			page.attachWidget(plugin, new GenericLabel().setText("Skill Points: " + sp).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
			
			page.attachWidget(plugin, new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
	    	
			page.attachWidget(plugin, new GenericLabel().setText("Stats").setHeight(15).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER));
			
			map.put(splayer, page);
		}
		
		splayer.getMainScreen().attachPopupScreen(stats1);
	}

	private static Material getmaterial(String type) {
		if(type == "Mining"){
			return Material.DIAMOND_PICKAXE;
		}else if(type == "Woodcutting"){
			return Material.DIAMOND_AXE;
		}else if(type == "Farming"){
			return Material.DIAMOND_HOE;
		}else if(type == "Attack"){
			return Material.DIAMOND_SWORD;
		}else if(type == "Defence"){
			return Material.DIAMOND_CHESTPLATE;
		}else if(type == "Firemaking"){
			return Material.FLINT_AND_STEEL;
		}else if(type == "Construction"){
			return Material.WOOD_DOOR;
		}else if(type == "Excavation"){
			return Material.DIAMOND_SPADE;
		}else if(type == "Cooking"){
			return Material.FURNACE;
		}else if(type == "Ranged"){
			return Material.BOW;
		}else if(type == "Fishing"){
			return Material.FISHING_ROD;
		}else{
			return Material.IRON_INGOT;
		}
	}

	public static void getpoints(RpgEssentials plugin, SpoutPlayer splayer) {	
	}

	public static void spend(RpgEssentials plugin, SpoutPlayer splayer, Button button) {

        int sp = Configuration.players.getInt("players." + splayer.getName() + ".SP");
        Configuration.players.set("players." + splayer.getName() + ".SP", sp - 1);
		
		int row = (int) ((button.getY() -Y) / 12.5);
		WidgetAnchor anchor = (button.getAnchor());
		if(anchor.equals(WidgetAnchor.TOP_CENTER)){
			row = row + 1;
		}
		String Skill;
		if(row == 0){
			Skill = "Mining";
		}else if(row == 1){
			Skill = "Woodcutting";
		}else if(row == 2){
			Skill = "Farming";
		}else if(row == 3){
			Skill = "Attack";
		}else if(row == 4){
			Skill = "Defence";
		}else if(row == 5){
			Skill = "Firemaking";
		}else if(row == 6){
			Skill = "Construction";
		}else if(row == 7){
			Skill = "Excavation";
		}else if(row == 8){
			Skill = "Cooking";
		}else if(row == 9){
			Skill = "Ranged";
		}else{
			Skill = "Smithing";
		}
		int old = Configuration.players.getInt("players." + splayer.getName() + "." + Skill + ".level");
		int currentlevel = Configuration.players.getInt("players." + splayer.getName() + "." + Skill + ".level");
		int xptolvl = 0;
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		Configuration.players.set("players." + splayer.getName() + "." + Skill + ".exp", xptolvl);
		Configuration.players.set("players." + splayer.getName() + "." + Skill + ".level", old +1);
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LevelingSystem.checknewcombat(splayer, plugin);
		open(plugin, splayer);
		
	}
	public static void nextclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) + 1;
		if(pagenum > 2){
			pagenum = 2;
		}
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 2){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(statspopup2.get(splayer));
    	}
	}
	public static void prevclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) - 1;
		if(pagenum < 1){
			pagenum = 1;
		}
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 1){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(statspopup1.get(splayer));
    	}
	}
	public static void leaderboard(Plugin plugin, SpoutPlayer splayer){
		
	}
}
