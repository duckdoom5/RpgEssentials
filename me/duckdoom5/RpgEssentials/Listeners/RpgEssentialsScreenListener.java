package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;


public class RpgEssentialsScreenListener extends ScreenListener {
    private RpgEssentials plugin;
    public RpgEssentialsScreenListener(RpgEssentials plugin) {
          this.plugin = plugin;
    }
    
    @Override
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
    	
    	if(button.getPlugin().equals(plugin)){
	        SpoutPlayer splayer = event.getPlayer();
	        //close
	        if(button.getText().equals("Close")) {
	            splayer.getMainScreen().closePopup();
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
	        //X 1
	        }else if(button.getText().equals("1")) {
	        	if(StoreMenu.page.getText().equals("1")){
		        	StoreMenu.store.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("16");
		        	StoreMenu.amount2.setText("16");
	        		StoreMenu.amount3.setText("16");
	        		StoreMenu.store.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("2")){
		        	StoreMenu.store1.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("16");
		        	StoreMenu.amount2.setText("16");
	        		StoreMenu.amount3.setText("16");
	        		StoreMenu.store1.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("3")){
		        	StoreMenu.store2.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("16");
		        	StoreMenu.amount2.setText("16");
	        		StoreMenu.amount3.setText("16");
	        		StoreMenu.store2.attachWidget(plugin, StoreMenu.amount1);
	        	}
	        //X 16
	        }else if(button.getText().equals("16")) {
	        	if(StoreMenu.page.getText().equals("1")){
		        	StoreMenu.store.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("32");
		        	StoreMenu.amount2.setText("32");
	        		StoreMenu.amount3.setText("32");
	        		StoreMenu.store.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("2")){
		        	StoreMenu.store1.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("32");
		        	StoreMenu.amount2.setText("32");
	        		StoreMenu.amount3.setText("32");
	        		StoreMenu.store1.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("3")){
		        	StoreMenu.store2.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("32");
		        	StoreMenu.amount2.setText("32");
	        		StoreMenu.amount3.setText("32");
	        		StoreMenu.store2.attachWidget(plugin, StoreMenu.amount1);
	        	}
	        //X 32
	        }else if(button.getText().equals("32")) {
	        	if(StoreMenu.page.getText().equals("1")){
		        	StoreMenu.store.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("64");
		        	StoreMenu.amount2.setText("64");
	        		StoreMenu.amount3.setText("64");
	        		StoreMenu.store.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("2")){
		        	StoreMenu.store1.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("64");
		        	StoreMenu.amount2.setText("64");
	        		StoreMenu.amount3.setText("64");
	        		StoreMenu.store1.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("3")){
		        	StoreMenu.store2.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("64");
		        	StoreMenu.amount2.setText("64");
	        		StoreMenu.amount3.setText("64");
	        		StoreMenu.store2.attachWidget(plugin, StoreMenu.amount1);
	        	}
	        //X 64
	        }else if(button.getText().equals("64")) {
	        	if(StoreMenu.page.getText().equals("1")){
		        	StoreMenu.store.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("1");
		        	StoreMenu.amount2.setText("1");
	        		StoreMenu.amount3.setText("1");
	        		StoreMenu.store.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("2")){
		        	StoreMenu.store1.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("1");
		        	StoreMenu.amount2.setText("1");
	        		StoreMenu.amount3.setText("1");
	        		StoreMenu.store1.attachWidget(plugin, StoreMenu.amount1);
	        	}else if(StoreMenu.page.getText().equals("3")){
		        	StoreMenu.store2.removeWidget(StoreMenu.amount1);
		        	StoreMenu.amount1.setText("1");
		        	StoreMenu.amount2.setText("1");
	        		StoreMenu.amount3.setText("1");
	        		StoreMenu.store2.attachWidget(plugin, StoreMenu.amount1);
	        	}
	        	
	        	
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
    	}
    }
}