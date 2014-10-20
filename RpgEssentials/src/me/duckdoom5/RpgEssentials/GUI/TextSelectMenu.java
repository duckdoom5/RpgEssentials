package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TextSelectMenu extends Gui {
    private final String[] text;
    private final String title;
    private final String[] buttons;

    public TextSelectMenu(RpgEssentials plugin, SpoutPlayer splayer,
            String title, String[] text, String[] buttons) {
        super(plugin, splayer);
        this.title = title;
        this.text = text;
        this.buttons = buttons;

        final Gui gui = GuiManager.gui.get(splayer);
        if (gui == null) {
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

        final GenericTexture BT = (GenericTexture) new GenericTexture().setUrl(Configuration.texture.getString("Chatbox Top")).setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(-(20 * buttons.length + 15 * text.length + 31)).shiftXPos(-160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
        final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.texture.getString("Chatbox Background")).setMinWidth(160).setMaxWidth(160).setMinHeight(20 * buttons.length + 15 * text.length + 15).setMaxHeight(20 * buttons.length + 15 * text.length + 15).setPriority(RenderPriority.High).shiftYPos(-(20 * buttons.length + 15 * text.length + 23)).shiftXPos(-160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
        final GenericTexture BB = (GenericTexture) new GenericTexture().setUrl(Configuration.texture.getString("Chatbox Bottom")).setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(-8).shiftXPos(-160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);
        // GenericTexture ET = (GenericTexture) new
        // GenericTexture().setUrl(Configuration.texture.getString(toTalkTo.toString().toLowerCase().replace("_",
        // " "))).setMinWidth(160).setMaxWidth(160).setMinHeight(8).setMaxHeight(8).setPriority(RenderPriority.High).shiftYPos(-
        // 8).shiftXPos(- 160).setAnchor(WidgetAnchor.BOTTOM_RIGHT);

        for (int pos = 0; pos < text.length; pos++) {
            popup.attachWidget(
                    plugin,
                    new GenericLabel(text[pos]).setAlign(WidgetAnchor.TOP_CENTER).setWidth(140).setHeight(20).shiftXPos(-80).shiftYPos(
                                    -(15 * (text.length - pos - 1) + 20
                                            * buttons.length + 24)).setAnchor(WidgetAnchor.BOTTOM_RIGHT).setPriority(RenderPriority.Lowest));
        }

        for (int pos2 = 0; pos2 < buttons.length; pos2++) {
            popup.attachWidget(
                    plugin,
                    new GenericButton(buttons[pos2]).setWidth(140).setHeight(20).shiftYPos(-(20 * (buttons.length - pos2 - 1) + 28)).shiftXPos(-150).setAnchor(WidgetAnchor.BOTTOM_RIGHT).setPriority(RenderPriority.Lowest));
        }

        // popup.attachWidget(plugin, ET);

        popup.attachWidget(
                plugin,
                new GenericLabel(title).setAlign(WidgetAnchor.TOP_CENTER).setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(15).shiftXPos(-80).shiftYPos(
                                -(20 * buttons.length + 15 * text.length + 24)).setAnchor(WidgetAnchor.BOTTOM_RIGHT).setPriority(RenderPriority.Lowest));
        popup.attachWidget(plugin, BG);
        popup.attachWidget(plugin, BB);
        popup.attachWidget(plugin, BT);

        popup.setTransparent(true);
        popup.setBgVisible(false);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
}
