package me.duckdoom5.RpgEssentials.RpgEntities.Listeners;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.GUI.EntityGui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.TextFieldChangeEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ScreenListener implements Listener {
    private final RpgEntities plugin;

    public ScreenListener(RpgEntities rpgEntities) {
        plugin = rpgEntities;
    }

    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
        final Button button = event.getButton();
        if (button.getPlugin().equals(plugin)) {
            final SpoutPlayer splayer = event.getPlayer();
            // close
            if (button.getText().equals("Close")) {
                splayer.getMainScreen().getActivePopup().close();
                // back
            } else if (button.getText().equals("Back")) {
                final Gui gui = GuiManager.gui.get(splayer);
                gui.back();
                // next
            } else if (button.getText().equals("Next")) {
                final Gui gui = GuiManager.gui.get(splayer);
                gui.nextPage();
                // prev
            } else if (button.getText().equals("Prev")) {
                final Gui gui = GuiManager.gui.get(splayer);
                gui.prevPage();
                // get skill points
            }
        }
    }
    @EventHandler
    public void onTextFieldChange(TextFieldChangeEvent event) {
        SpoutPlayer splayer = event.getPlayer();
        final Gui gui = GuiManager.gui.get(splayer);
        if(gui instanceof EntityGui){
            ((EntityGui)gui).onTextFieldChange(event);
        }
    }
}