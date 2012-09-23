package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.GUI.PlayerOptionsGui;
import me.duckdoom5.RpgEssentials.GUI.SpawnerWandGui;
import me.duckdoom5.RpgEssentials.GUI.TexturepackGui;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Gui.LevelGui;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.QuestList;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenCloseEvent;
import org.getspout.spoutapi.gui.Button;
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
	        RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer.getName());
	        //close
	        Gui gui = GuiManager.gui.get(splayer);
	        if(button.getText().equals("Close")) {
	        	if(gui instanceof TexturepackGui || gui instanceof PlayerOptionsGui){
	        		if(rpgplayer.getTexturepack(splayer.getWorld()).equals("null")){
	        			splayer.sendNotification("Error!", "Select a texture pack!", Material.APPLE);
	        			event.setCancelled(true);
	        			return;
	        		}
	        	}
	    		splayer.getMainScreen().closePopup();
	        //buy
	        }else if(button.getText().equals("Cancel")) {
	        	gui.back();
	        }else if(button.getText().equals("Save")) {
	        	gui.save();
	        }else if(button.getText().equals("Back")) {
	        	gui.back();
	        	
	        	//if(button.getTooltip().toString().equals("Back to group selection")){
	        		//StoreMenu.open(plugin, splayer, 0, 0, 0);
	        	//}
	        //next
	        }else if(button.getText().equals("Next")) {
	        	gui.nextPage();
	        //prev
	        }else if(button.getText().equals("Prev")) {
	        	gui.prevPage();
	        //options
	        }else if(button.getText().equals("Edit Texturepack")) {
	        	TexturepackGui tgui = new TexturepackGui(plugin, splayer);
	        
	        }else if(button.getText().equals("Q")) {
	        	QuestList lgui = new QuestList((RpgQuests) RpgEssentials.RpgQuests, plugin, splayer);
	        	//Creator cgui = new Creator((RpgQuests) RpgEssentials.RpgQuests, splayer);
	        }else if(button.getText().equals("L")) {
	        	LevelGui lgui = new LevelGui((RpgLeveling) RpgEssentials.RpgLeveling, splayer);
	        
	        }else if(gui instanceof SpawnerWandGui){
	        	SpawnerWandGui sgui = (SpawnerWandGui) gui;
	        	CreatureSpawner spawner = sgui.getSpawner();
	        	spawner.setCreatureTypeByName(button.getText().toUpperCase().replace(" ", "_"));
	        	splayer.sendNotification("Spawner changed to:", button.getText(), Material.MOB_SPAWNER);
	        	sgui.updateText();
	        }
    	}
    }
    
    @EventHandler
    public void onScreenClose(ScreenCloseEvent event) {
    	SpoutPlayer splayer = event.getPlayer();
    	RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer.getName());
    	if(rpgplayer.getTexturepack(splayer.getWorld()).equals("null")){
			Gui gui = GuiManager.gui.get(splayer);
        	if(gui instanceof TexturepackGui){
        		splayer.sendNotification("Error!", "Select a texture pack!", Material.APPLE);
        		event.setCancelled(true);
    			return;
        	}else if(gui instanceof PlayerOptionsGui){
        		splayer.sendNotification("Error!", "Select a texture pack!", Material.APPLE);
        		event.setCancelled(true);
    			return;
        	}
		}
		GuiManager.gui.remove(splayer);
    }
}