package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.WidgetType;
import org.getspout.spoutapi.player.SpoutPlayer;


public class RpgEssentialsScreenListener extends ScreenListener {
    private RpgEssentials plugin;
    public RpgEssentialsScreenListener(RpgEssentials plugin) {
          this.plugin = plugin;
    }
 
    @Override
    public void onButtonClick(ButtonClickEvent event) {
    	Button button = event.getButton();
        SpoutPlayer splayer = event.getPlayer();
        if(button.getText().equals("Close")) {
            splayer.getMainScreen().closePopup();
        }else if(button.getText().equals("Next")) {
            TestMenu.button2(splayer);
        }else if(button.getType() == WidgetType.CheckBox) {
            TestMenu.checkboxclick(splayer,button);

        }
    }
}