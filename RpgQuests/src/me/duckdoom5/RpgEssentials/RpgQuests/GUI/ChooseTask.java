package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ChooseTask extends Gui {
    private final GenericButton close = (GenericButton) new GenericButton(
            "Back").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Choose Task").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);

    private final int Y = 20;

    public ChooseTask(RpgQuests plugin, SpoutPlayer splayer) {
        super(plugin, splayer);

        final Gui gui = GuiManager.gui.get(splayer);
        if (gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN) {
            popup = new GenericPopup();
            createPopup(true, false);
        } else {
            popup = gui.getPopup();
            createPopup(false, true);
        }

        GuiManager.gui.put(splayer, this);
    }

    @Override
    protected void createPopup(boolean attach, boolean remove) {
        if (remove) {
            popup.removeWidgets(plugin);
        }

        popup.attachWidget(
                plugin,
                new GenericButton("Break").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Craft").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Deliver").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Escort").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Kill").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 100).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Place").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 125).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Smelt").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("TalkTo").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 175).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, label).attachWidget(plugin, close).attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    @SuppressWarnings ("unused")
    @Override
    public void back() {
        new Creator((RpgQuests) plugin, splayer);
    }
}
