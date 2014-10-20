package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayerOptionsGui extends Gui {
    private final GenericButton close = (GenericButton) new GenericButton(
            "Close").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Options").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    private static int Y = 15;

    public PlayerOptionsGui(RpgEssentials plugin, SpoutPlayer splayer) {
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

        popup.attachWidget(plugin, new GenericButton("Edit Texturepack").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Q").setWidth(50).setHeight(50).shiftXPos(-50).setY(0).setAnchor(WidgetAnchor.TOP_RIGHT));

        popup.attachWidget(plugin, new GenericButton("L").setWidth(50).setHeight(50).setX(0).setY(0).setAnchor(WidgetAnchor.TOP_LEFT));

        popup.attachWidget(plugin, label).attachWidget(plugin, close);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
}
