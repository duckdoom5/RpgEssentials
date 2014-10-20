package me.duckdoom5.RpgEssentials.RpgBanks.Listeners;

import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.RpgBankManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ScreenListener implements Listener {
    private final RpgBanks plugin;

    public ScreenListener(RpgBanks RpgBanks) {
        plugin = RpgBanks;
    }

    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
        final Button button = event.getButton();
        if (button.getPlugin().equals(plugin)) {
            final SpoutPlayer splayer = event.getPlayer();
            // close
            if (button.getText().equals("Close")) {
                splayer.getMainScreen().closePopup();

            } else if (button.getText().equals("Open bank account")) {
                RpgBankManager.getInstance().getBank(splayer.getName()).open();
            } else if (button.getText().equals("Buy more room")) {
                RpgBankManager.getInstance().getBank(splayer.getName()).requestUpgrade(plugin);
            } else if (button.getText().equals("Buy")) {
                RpgBankManager.getInstance().getBank(splayer.getName()).upgradeSpace();
            }
        }
    }
}