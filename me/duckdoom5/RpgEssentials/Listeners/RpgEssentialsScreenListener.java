package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;

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
	            StoreMenu.buyclick(splayer,button);
	        //back
	        }else if(button.getText().equals("Back")) {
	        	if(button.getTooltip().toString().equals("Back to group selection")){
	        		StoreMenu.open(plugin, splayer);
	        	}
	        //next
	        }else if(button.getText().equals("Next")) {
	        	StoreMenu.nextclick(plugin, splayer);
	        //prev
	        }else if(button.getText().equals("Prev")) {
	        	StoreMenu.prevclick(plugin, splayer);
	        //get skill points
	        }else if(button.getText().equals("Get Free Skill Points !")) {
	        	LevelMenu.getpoints(plugin, splayer);
	        	//get skill points
	        }else if(button.getText().equals("Spend")) {
	        	LevelMenu.spend(plugin, splayer,button);	
	        	
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
		        	amount.setText("16");
	        		
		        //X 16
		        }else if(button.getText().equals("16")) {
		        	GenericButton amount = StoreMenu.amountwidget.get(splayer);
		        	amount.setText("32");
		        //X 32
		        }else if(button.getText().equals("32")) {
		        	GenericButton amount = StoreMenu.amountwidget.get(splayer);
		        	amount.setText("64");
		        //X 64
		        }else if(button.getText().equals("64")) {
		        	GenericButton amount = StoreMenu.amountwidget.get(splayer);
		        	amount.setText("1");
		        }
	        }
    	}
    }
}