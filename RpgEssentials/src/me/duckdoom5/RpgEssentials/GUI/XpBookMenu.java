package me.duckdoom5.RpgEssentials.GUI;

import java.util.HashMap;
import java.util.Map;

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

public class XpBookMenu extends Gui {
    public static Map<SpoutPlayer, GenericPopup> bookpopup1 = new HashMap<>();
    public static Map<SpoutPlayer, GenericLabel> pagewidget = new HashMap<>();

    public XpBookMenu(RpgEssentials plugin, SpoutPlayer splayer) {
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
            if (plugin != null) {
                popup.getPlugin();
                popup.removeWidgets(plugin);
            }
            popup.removeWidgets(plugin);
        }

        final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.texture.getString("Level Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
        if (splayer.getActiveScreen() != ScreenType.GAME_SCREEN) {
            try {
                splayer.getMainScreen().getActivePopup().close();
            } catch (final Exception e) {
            }
        }
        GenericPopup page = new GenericPopup();
        final GenericPopup book1 = new GenericPopup();
        Map<SpoutPlayer, GenericPopup> map;

        if (!pagewidget.containsKey(splayer)) {
            final GenericLabel pagelabel = (GenericLabel) new GenericLabel().setText("1").setHeight(15).setWidth(5).shiftXPos(-10).setAnchor(WidgetAnchor.TOP_RIGHT);
            pagewidget.put(splayer, pagelabel);
        }

        final String[] names = { "Mining", "Woodcutting" };

        page.removeWidgets(plugin);
        for (final String name : names) {
            // if(row < 10){
            // next = next1;
            // prev = prev1;
            page = book1;
            map = bookpopup1;
            // }

            // page.attachWidget(plugin, prev);
            // page.attachWidget(plugin, next);
            page.attachWidget(plugin, BG);

            page.attachWidget(
                    plugin,
                    new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER));

            page.attachWidget(plugin,
                    new GenericLabel().setText("Quests").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER));

            map.put(splayer, page);
        }
        splayer.getMainScreen().attachPopupScreen(book1);
    }
}
