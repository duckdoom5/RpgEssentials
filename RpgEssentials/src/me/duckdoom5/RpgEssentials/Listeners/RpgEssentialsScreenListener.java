package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
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
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenCloseEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsScreenListener implements Listener {
    private final RpgEssentials plugin;

    public RpgEssentialsScreenListener(RpgEssentials plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
        final Button button = event.getButton();
        if (button.getPlugin().equals(plugin)) {
            final SpoutPlayer splayer = event.getPlayer();
            final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer);
            // close
            final Gui gui = GuiManager.gui.get(splayer);
            if (button.getText().equals("Close")) {
                if (gui instanceof TexturepackGui) {
                    if (rpgplayer.getTexturepack(splayer.getWorld()).equals(
                            "null")) {
                        splayer.sendNotification("Error!", "Select a texture pack!", Material.APPLE);
                        event.setCancelled(true);
                        return;
                    }
                }
                splayer.getMainScreen().closePopup();
                // buy
            } else if (button.getText().equals("Cancel") || button.getText().equals("Back")) {
                gui.back();
            } else if (button.getText().equals("Save")) {
                gui.save();
                // if(button.getTooltip().toString().equals("Back to group selection")){
                // StoreMenu.open(plugin, splayer, 0, 0, 0);
                // }

                // next
            } else if (button.getText().equals("Next")) {
                gui.nextPage();
                // prev
            } else if (button.getText().equals("Prev")) {
                gui.prevPage();
                // options
            } else if (button.getText().equals("Edit Texturepack")) {
                new TexturepackGui(plugin, splayer);

            } else if (button.getText().equals("Q")) {
                new QuestList((RpgQuests) RpgeManager.getInstance().getAddon(
                        "RpgQuests"), plugin, splayer);
            } else if (button.getText().equals("L")) {
                new LevelGui((RpgLeveling) RpgeManager.getInstance().getAddon(
                        "RpgLeveling"), plugin, splayer);

            } else if (gui instanceof SpawnerWandGui) {
                final SpawnerWandGui sgui = (SpawnerWandGui) gui;
                final CreatureSpawner spawner = sgui.getSpawner();
                spawner.setCreatureTypeByName(button.getText().toUpperCase().replace(" ", "_"));
                splayer.sendNotification("Spawner changed to:",
                        button.getText(), Material.MOB_SPAWNER);
                sgui.updateText();
            }
        }
    }

    @EventHandler
    public void onScreenClose(ScreenCloseEvent event) {
        final SpoutPlayer splayer = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer);
        if (Configuration.modules.getBoolean("Modules.texturepack") && rpgplayer.getTexturepack(splayer.getWorld()).equals("null") && Configuration.texture.contains(splayer.getWorld().getName())) {
            final Gui gui = GuiManager.gui.get(splayer);
            if (gui instanceof TexturepackGui) {
                splayer.sendNotification("Error!", "Select a texture pack!",
                        Material.APPLE);
                event.setCancelled(true);
                return;
            } else if (gui instanceof PlayerOptionsGui) {
                splayer.sendNotification("Error!", "Select a texture pack!",
                        Material.APPLE);
                event.setCancelled(true);
                return;
            }
        }
        GuiManager.gui.remove(splayer);
    }
}