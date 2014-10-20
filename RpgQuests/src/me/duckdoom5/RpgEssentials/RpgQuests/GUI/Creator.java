package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Creator extends Gui {
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Creator").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);
    private final int Y = 20;

    public Creator(RpgQuests plugin, SpoutPlayer splayer) {
        super(plugin, splayer);

        final Gui gui = GuiManager.gui.get(splayer);
        if (gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN) {
            popup = new GenericPopup();
            createPopup(true, false);
        } else {
            popup = gui.getPopup();
            createPopup(false, true);
        }

        RpgQuests.qm.isCreating.add(splayer);
        GuiManager.gui.put(splayer, this);
    }

    @Override
    protected void createPopup(boolean attach, boolean remove) {
        if (remove) {
            popup.removeWidgets(plugin);
        }

        boolean enabled = false;
        boolean hastask = false;
        if (RpgQuests.qm.createQuest.containsKey(splayer)) {
            enabled = true;
            final Quest quest = RpgQuests.qm.createQuest.get(splayer);
            hastask = quest.hasTask();
        }
        popup.attachWidget(
                plugin,
                new GenericButton("Add Task").setEnabled(enabled).setTooltip(
                                enabled ? "" : "Please save settings first.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Add Reward").setEnabled(enabled).setTooltip(
                                enabled ? "" : "Please save settings first.").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton(enabled ? "Edit Settings" : "Settings").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Show Quest").setEnabled(enabled).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 125).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericButton("Delete").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Finish").setEnabled(hastask).setTooltip(hastask ? "" : "Please add a task first.").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(plugin, label).attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    @SuppressWarnings ("unused")
    @Override
    public void back() {
        new QuestList((RpgQuests) plugin, null, splayer);
    }
}
