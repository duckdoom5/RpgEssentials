package me.duckdoom5.RpgEssentials.GUI;


import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericCheckBox;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TestMenu {
 
	public static GenericPopup store = new GenericPopup();
	public static GenericPopup buy = new GenericPopup(); 
	
	public static void additem(Plugin plugin, int Y, int startX){
		GenericItemWidget Wool = new GenericItemWidget(new ItemStack(35, 1));
		Wool.setData((short) 14);
		Wool.setDepth(8).setHeight(8).setMaxHeight(8).setWidth(8).setMaxWidth(8);
		Wool.setTooltip("Red wool");
		Wool.setX(startX);
		Wool.setY(Y);
		Wool.setAnchor(WidgetAnchor.TOP_LEFT);
		store.attachWidget(plugin, Wool);
		addlabel(plugin, Y, startX);
	}
	public static void addlabel(Plugin plugin, int Y, int startX){
		GenericLabel name = new GenericLabel();
		name.setText("Red wool");
		name.setX(startX + 30);
		name.setHeight(20);
		name.setY(Y + 5);
		name.setAnchor(WidgetAnchor.TOP_LEFT);
		store.attachWidget(plugin, name);
		addprice(plugin, Y, startX);
	}
	public static void addprice(Plugin plugin, int Y, int startX){
		GenericLabel name = new GenericLabel();
		name.setText("$ 10");
		name.setHeight(20);
		name.setX(startX + 80);
		name.setY(Y + 5);
		name.setAnchor(WidgetAnchor.TOP_LEFT);
		store.attachWidget(plugin, name);
		addcheckbox(plugin, Y, startX);
	}
	public static void addcheckbox(Plugin plugin, int Y, int startX){
		GenericCheckBox cb = new GenericCheckBox("");
		cb.setWidth(30);
		cb.setHeight(30);
		cb.setX(startX + 110);
    	cb.setY(Y);
    	cb.setAnchor(WidgetAnchor.TOP_LEFT);
    	store.attachWidget(plugin, cb);
    	addtextfield(plugin, Y, startX);
	}
	public static void addtextfield(Plugin plugin, int Y, int startX){
		GenericTextField tf = new GenericTextField();
		tf.setText("999");
		tf.setWidth(40);
		tf.setHeight(20);
		tf.setX(startX + 140);
    	tf.setY(Y);
    	tf.setAnchor(WidgetAnchor.TOP_LEFT);
    	store.attachWidget(plugin, tf);
    	addbuttons(plugin, Y, startX);
	}
	public static void addbuttons(Plugin plugin, int Y, int startX){
		GenericButton plus = new GenericButton("+");
		GenericButton min = new GenericButton("-");
		//plus
		plus.setWidth(20);
		plus.setHeight(10);
		plus.setX(startX + 191);
    	plus.setY(Y);
    	plus.setAnchor(WidgetAnchor.TOP_LEFT);
    	//min
		min.setWidth(20);
		min.setHeight(10);
		min.setX(startX + 191);
    	min.setY(Y + 10);
    	min.setAnchor(WidgetAnchor.TOP_LEFT);
    	store.attachWidget(plugin, plus);
    	store.attachWidget(plugin, min);
	}
	public static void checkboxclick(SpoutPlayer splayer, Button button){
		button.getHeight();
		//get textfield widget from hashmap where height == button.getheight
	}
	
	public static void open(Plugin plugin, SpoutPlayer splayer) { 
    	GenericTexture BG = new GenericTexture();
    	GenericButton button1 = new GenericButton("Next");
    	
    	additem(plugin,40,10);
    	
    	BG.setUrl("http://82.74.70.243/server/shop/bg.png");
        BG.setWidth(250).setMaxWidth(250).setHeight(900);
        BG.shiftXPos(- BG.getWidth() / 2);
        BG.setY(5);
        BG.setMarginTop(5);
        BG.setMarginBottom(5);
        BG.setPriority(RenderPriority.High);
        BG.setAnchor(WidgetAnchor.TOP_CENTER);
    	
    	button1.setWidth(200).setHeight(20).setMinWidth(200).setMaxWidth(200);
    	button1.setY(5);
    	button1.shiftXPos(- button1.getWidth() / 2);
    	button1.setAnchor(WidgetAnchor.TOP_CENTER);
		
        
        store.attachWidget(plugin, button1);
        store.attachWidget(plugin, BG);
        
        splayer.getMainScreen().attachPopupScreen(store); // attach the popup to the players screen
    }
	public static void button2(SpoutPlayer splayer) {
		GenericButton button2 = new GenericButton("Button2");
		GenericTexture BG = new GenericTexture();
		
		BG.setUrl("http://82.74.70.243/server/shop/bg.png");
        BG.setWidth(250).setMaxWidth(250).setHeight(900);
        BG.shiftXPos(- BG.getWidth() / 2);
        BG.setY(5);
        BG.setMarginTop(5);
        BG.setMarginBottom(5);
        BG.setPriority(RenderPriority.High);
        BG.setAnchor(WidgetAnchor.TOP_CENTER);
		
		button2.setWidth(200).setHeight(20).setMinWidth(200).setMaxWidth(200);
    	button2.setY(5);
    	button2.shiftXPos(- button2.getWidth() / 2);
    	button2.setAnchor(WidgetAnchor.TOP_CENTER);
    	
    	buy.attachWidget(Bukkit.getServer().getPluginManager().getPlugin("RpgEssentials"), button2);
    	splayer.getMainScreen().closePopup();
		splayer.getMainScreen().attachPopupScreen(buy);
	}
}