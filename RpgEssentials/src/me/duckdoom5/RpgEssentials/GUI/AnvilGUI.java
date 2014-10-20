package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class AnvilGUI extends GenericPopup {
    public static void open(Plugin plugin, SpoutPlayer splayer) {
        if (splayer.getActiveScreen() != ScreenType.GAME_SCREEN) {
            try {
                splayer.getMainScreen().getActivePopup().close();
            } catch (final Exception e) {
            }
        }

        final GenericPopup gui = new GenericPopup();

        final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://dl.lynxdragon.com/rpgessentials/textures/gui/furnace.png").setPriority(RenderPriority.High).setAnchor(WidgetAnchor.CENTER_CENTER).setHeight(176).setWidth(166).shiftXPos(-88).shiftYPos(-83);

        splayer.openInventory(splayer.getInventory());

        /*
         * GenericSlot quickbar1 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos
         * (1).setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot quickbar2 =
         * (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor
         * .CENTER_CENTER); GenericSlot quickbar3 = (GenericSlot) new
         * GenericSlot
         * ().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         * GenericSlot quickbar4 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos
         * (1).setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot quickbar5 =
         * (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor
         * .CENTER_CENTER); GenericSlot quickbar6 = (GenericSlot) new
         * GenericSlot
         * ().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         * GenericSlot quickbar7 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos
         * (1).setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot quickbar8 =
         * (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor
         * .CENTER_CENTER); GenericSlot quickbar9 = (GenericSlot) new
         * GenericSlot
         * ().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         * 
         * GenericSlot inventory1 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).
         * shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot
         * inventory2 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1)
         * .setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot inventory3 =
         * (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor
         * .CENTER_CENTER); GenericSlot inventory4 = (GenericSlot) new
         * GenericSlot
         * ().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         * GenericSlot inventory5 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).
         * shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot
         * inventory6 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1)
         * .setAnchor(WidgetAnchor.CENTER_CENTER); GenericSlot inventory7 =
         * (GenericSlot) new
         * GenericSlot().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor
         * .CENTER_CENTER); GenericSlot inventory8 = (GenericSlot) new
         * GenericSlot
         * ().shiftXPos(1).shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         * GenericSlot inventory9 = (GenericSlot) new
         * GenericSlot().shiftXPos(1).
         * shiftYPos(1).setAnchor(WidgetAnchor.CENTER_CENTER);
         */

        gui.attachWidget(plugin, BG);
        splayer.getMainScreen().attachPopupScreen(gui);
    }
}
