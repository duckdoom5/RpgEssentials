package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StartupGUI extends Gui {
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Welcome").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
    private final int Y = 15;

    public StartupGUI(RpgEssentials plugin, SpoutPlayer splayer) {
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

        popup.attachWidget(
                plugin,
                new GenericButton("Add Task").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericButton("Add Reward").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Settings").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericButton("Show Quest").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 125).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericButton("Delete").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(plugin, new GenericButton("Disconnect").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Add Task").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, label).attachWidget(plugin, BG);
        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
}
