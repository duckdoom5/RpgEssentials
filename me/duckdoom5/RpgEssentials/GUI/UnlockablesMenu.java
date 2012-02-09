package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class UnlockablesMenu {
	static YamlConfiguration playerconfig = new YamlConfiguration();
	static YamlConfiguration levelconfig = new YamlConfiguration();
	private static int Y = 15;
	private static int X = -125;
	
	public static void open(Plugin plugin, SpoutPlayer splayer, Button button) {
		int row = (button.getY() -15) /20;
		
		String name;
		String[] array;
		String[] Mining = {"WOOD_PICKAXE", "STONE_PICKAXE", "IRON_PICKAXE", "GOLD_PICKAXE", "DIAMOND_PICKAXE"};
		String[] Woodcutting = {"WOOD_AXE", "STONE_AXE", "IRON_AXE", "GOLD_AXE", "DIAMOND_AXE"};
		String[] Farming = {"WOOD_HOE", "STONE_HOE", "IRON_HOE", "GOLD_HOE", "DIAMOND_HOE"};
		String[] Attack = {"WOOD_SWORD", "STONE_SWORD", "IRON_SWORD", "GOLD_SWORD", "DIAMOND_SWORD"};
		String[] Defence = {};
		String[] Firemaking = {};
		String[] Construction = {};
		String[] Excavation = {"WOOD_SPADE", "STONE_SPADE", "IRON_SPADE", "GOLD_SPADE", "DIAMOND_SPADE"};
		String[] Cooking = {};
		String[] Ranged = {};
		String[] Smithing = {};
		
		splayer.sendMessage(Integer.toString(row));
		
		if(row == 0){
			name = "Mining";
			array = Mining;
		}else if(row == 1){
			name = "Woodcutting";
			array = Woodcutting;
		}else if(row == 2){
			name = "Farming";
			array = Farming;
		}else if(row == 3){
			name = "Attack";
			array = Attack;
		}else if(row == 4){
			name = "Defence";
			array = Defence;
		}else if(row == 5){
			name = "Firemaking";
			array = Firemaking;
		}else if(row == 6){
			name = "Construction";
			array = Construction;
		}else if(row == 7){
			name = "Excavation";
			array = Excavation;
		}else if(row == 8){
			name = "Cooking";
			array = Cooking;
		}else if(row == 9){
			name = "Ranged";
			array = Ranged;
		}else{
			name = "Smithing";
			array = Smithing;
		}
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		GenericPopup popup = new GenericPopup();
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		try {
			playerconfig.load("plugins/RpgEssentials/Temp/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
		popup.removeWidgets(plugin);
		
		
		int currentlevel = playerconfig.getInt("players." + splayer.getName() + "." + name + ".level");
		anchor = WidgetAnchor.TOP_CENTER;
		
		for(int pos = 0; pos < array.length; pos++){
			
			popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(Material.getMaterial(array[pos]))).setDepth(8).setHeight(8).setWidth(8).setTooltip(array[pos].toLowerCase().replace("_", " ")).setX(X).setY((int) (Y + (pos * 20))).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText(array[pos].toLowerCase().replace("_", " ")).setHeight(10).setX(X + 22).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			popup.attachWidget(plugin, new GenericLabel().setText("unlocked at level: ").setHeight(10).setX(X + 130).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			
			if(getLevel(array[pos], name) >= currentlevel){
				popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(Integer.toString(getLevel(array[pos], name))).setHeight(10).setX(X + 230).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			} else {
				popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(Integer.toString(getLevel(array[pos], name))).setHeight(10).setX(X + 230).setY((int) (Y + 5 + (pos * 20))).setAnchor(anchor));
			}
		}
		popup.attachWidget(plugin, new GenericLabel().setText("Unlockables").setHeight(15).shiftXPos(- 35).setAnchor(WidgetAnchor.TOP_CENTER));
		
		popup.attachWidget(plugin, new GenericLabel().setText("current level: " + currentlevel).setHeight(10).setX(-50).setY(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		
		popup.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to level menu"));
    	
		popup.attachWidget(plugin,BG);
		splayer.getMainScreen().attachPopupScreen(popup);
		
	}

	private static int getLevel(String material, String name) {
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int level = 0;
		
		if(name == "Mining"){
			if(material == "WOOD_PICKAXE"){
				level = levelconfig.getInt("UnlockLevel.Wood Pickaxe");
			}else if(material == "STONE_PICKAXE"){
				level = levelconfig.getInt("UnlockLevel.Stone Pickaxe");
			}else if(material == "IRON_PICKAXE"){
				level = levelconfig.getInt("UnlockLevel.Iron Pickaxe");
			}else if(material == "GOLD_PICKAXE"){
				level = levelconfig.getInt("UnlockLevel.Gold Pickaxe");
			}else if(material == "DIAMOND_PICKAXE"){
				level = levelconfig.getInt("UnlockLevel.Diamond Pickaxe");
			}
		}else if(name == "Woodcutting"){
			if(material == "WOOD_AXE"){
				level = levelconfig.getInt("UnlockLevel.Wood Axe");
			}else if(material == "STONE_AXE"){
				level = levelconfig.getInt("UnlockLevel.Stone Axe");
			}else if(material == "IRON_AXE"){
				level = levelconfig.getInt("UnlockLevel.Iron Axe");
			}else if(material == "GOLD_AXE"){
				level = levelconfig.getInt("UnlockLevel.Gold Axe");
			}else if(material == "DIAMOND_AXE"){
				level = levelconfig.getInt("UnlockLevel.Diamond Axe");
			}
		}else if(name == "Farming"){
			if(material == "WOOD_HOE"){
				level = levelconfig.getInt("UnlockLevel.Wood Hoe");
			}else if(material == "STONE_HOE"){
				level = levelconfig.getInt("UnlockLevel.Stone Hoe");
			}else if(material == "IRON_HOE"){
				level = levelconfig.getInt("UnlockLevel.Iron Hoe");
			}else if(material == "GOLD_HOE"){
				level = levelconfig.getInt("UnlockLevel.Gold Hoe");
			}else if(material == "DIAMOND_HOE"){
				level = levelconfig.getInt("UnlockLevel.Diamond Hoe");
			}
		}else if(name == "Attack"){
			if(material == "WOOD_SWORD"){
				level = levelconfig.getInt("UnlockLevel.Wood Sword");
			}else if(material == "STONE_SWORD"){
				level = levelconfig.getInt("UnlockLevel.Stone Sword");
			}else if(material == "IRON_SWORD"){
				level = levelconfig.getInt("UnlockLevel.Iron Sword");
			}else if(material == "GOLD_SWORD"){
				level = levelconfig.getInt("UnlockLevel.Gold Sword");
			}else if(material == "DIAMOND_SWORD"){
				level = levelconfig.getInt("UnlockLevel.Diamond Sword");
			}
		}else if(name == "Excavation"){
			if(material == "WOOD_SPADE"){
				level = levelconfig.getInt("UnlockLevel.Wood Spade");
			}else if(material == "STONE_SPADE"){
				level = levelconfig.getInt("UnlockLevel.Stone Spade");
			}else if(material == "IRON_SPADE"){
				level = levelconfig.getInt("UnlockLevel.Iron Spade");
			}else if(material == "GOLD_SPADE"){
				level = levelconfig.getInt("UnlockLevel.Gold Spade");
			}else if(material == "DIAMOND_SPADE"){
				level = levelconfig.getInt("UnlockLevel.Diamond Spade");
			}
		}
		return level;
	}
}
