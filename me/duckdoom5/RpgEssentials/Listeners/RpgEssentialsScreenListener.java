package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;
import me.duckdoom5.RpgEssentials.GUI.StoreMethods;
import me.duckdoom5.RpgEssentials.GUI.UnlockablesMenu;
import me.duckdoom5.RpgEssentials.banking.Bank;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.player.SpoutPlayer;


public class RpgEssentialsScreenListener implements Listener {
    private RpgEssentials plugin;
    public RpgEssentialsScreenListener(RpgEssentials plugin) {
          this.plugin = plugin;
    }
    
    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
    	
    	if(button.getPlugin().equals(plugin)){
	        SpoutPlayer splayer = event.getPlayer();
	        //close
	        if(button.getText().equals("Close")) {
	    		splayer.getMainScreen().getActivePopup().close();
	        //buy
	        }else if(button.getText().equals("Buy")) {
	        	StoreMethods.buyclick(splayer,button);
	        //sell
	        }else if(button.getText().equals("Sell")) {
	        	StoreMethods.sellclick(splayer,button);
	        //back
	        }else if(button.getText().equals("Back")) {
	        	if(button.getTooltip().toString().equals("Back to group selection")){
	        		StoreMenu.open(plugin, splayer);
	        	}else if(button.getTooltip().toString().equals("Back to level menu")){
	        		LevelMenu.open(plugin, splayer);
	        	}
	        //next
	        }else if(button.getText().equals("Next")) {
	        	StoreMethods.nextclick(plugin, splayer);
	        //prev
	        }else if(button.getText().equals("Prev")) {
	        	StoreMethods.prevclick(plugin, splayer);
	        //get skill points
	        }else if(button.getText().equals("Get Free Skill Points !")) {
	        	LevelMenu.getpoints(plugin, splayer);
	        //get skill points
	        }else if(button.getText().equals("Spend")) {
	        	LevelMenu.spend(plugin, splayer,button);
	        //unlockables
	        }else if(button.getText().equals("Unlockables")) {
	        	UnlockablesMenu.open(plugin, splayer, button);	
	        	
	        //npc text
	        }else if(button.getText().equals("Open bank account")) {
	        	Bank.open(plugin, splayer);
	        }else if(button.getText().equals("Buy more room")) {
	        	Bank.open(plugin, splayer);
	        	
	        //subgroup
	        //TODO make this || instead of else if
	        }else if(button.getText().equals("Food")) {
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Tools")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Armour")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Mechanisms")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Gardening")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Materials")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Raw Materials")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Painting")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Furniture")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Miscellaneous")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Mob Drops")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Nether")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Brewing")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Music")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Minerals")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }else if(button.getText().equals("Ores")){
	        	StoreMenu.store(plugin, splayer, button.getText(), "1");
	        }
	        if(button == StoreMenu.amountwidget.get(splayer)){
	        	splayer.sendMessage(button.getText());
		        if(button.getText().equals("1")) {
		        	GenericPopup store = StoreMenu.storepopup1.get(splayer);
		        	GenericButton amountwidget = StoreMenu.amountwidget.get(splayer);
		        	GenericButton amount = (GenericButton) store.getWidget(amountwidget.getId());
		        	store.removeWidget(amount);
		        	amountwidget.setText("16");
		        	store.attachWidget(plugin, amountwidget);
		        	StoreMenu.amountwidget.put(splayer, amountwidget);
	        		
		        //X 16
		        }else if(button.getText().equals("16")) {
		        	GenericPopup store = StoreMenu.storepopup1.get(splayer);
		        	GenericButton amountwidget = StoreMenu.amountwidget.get(splayer);
		        	GenericButton amount = (GenericButton) store.getWidget(amountwidget.getId());
		        	store.removeWidget(amount);
		        	amountwidget.setText("32");
		        	store.attachWidget(plugin, amountwidget);
		        	StoreMenu.amountwidget.put(splayer, amountwidget);
		        //X 32
		        }else if(button.getText().equals("32")) {
		        	GenericPopup store = StoreMenu.storepopup1.get(splayer);
		        	GenericButton amountwidget = StoreMenu.amountwidget.get(splayer);
		        	GenericButton amount = (GenericButton) store.getWidget(amountwidget.getId());
		        	store.removeWidget(amount);
		        	amountwidget.setText("64");
		        	store.attachWidget(plugin, amountwidget);
		        	StoreMenu.amountwidget.put(splayer, amountwidget);
		        //X 64
		        }else if(button.getText().equals("64")) {
		        	GenericPopup store = StoreMenu.storepopup1.get(splayer);
		        	GenericButton amountwidget = StoreMenu.amountwidget.get(splayer);
		        	GenericButton amount = (GenericButton) store.getWidget(amountwidget.getId());
		        	store.removeWidget(amount);
		        	amountwidget.setText("1");
		        	store.attachWidget(plugin, amountwidget);
		        	StoreMenu.amountwidget.put(splayer, amountwidget);
		        }
	        }
    	}
    }
}