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

public class Editor extends Gui {
    private final GenericButton finish = (GenericButton) new GenericButton(
            "Finish").setEnabled(false).setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Editor").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
    private final int Y = 20;
    private final Quest quest;

    public Editor(RpgQuests plugin, SpoutPlayer splayer, Quest quest) {
        super(plugin, splayer);
        this.quest = quest;

        RpgQuests.qm.editQuest.put(splayer, quest);

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
                new GenericButton("Edit Tasks").setEnabled(quest.hasTask()).setTooltip(
                                quest.hasTask() ? ""
                                        : "This quest has no tasks yet").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Edit Rewards").setEnabled(quest.hasReward()).setTooltip(
                                quest.hasReward() ? ""
                                        : "This quest has no rewards").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Add Task").setEnabled(!RpgQuests.qm.isCreating.contains(splayer)).setTooltip(
                                RpgQuests.qm.isCreating.contains(splayer) ? "Please press back to add more rewards"
                                        : "").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Add Reward").setEnabled(!RpgQuests.qm.isCreating.contains(splayer)).setTooltip(
                                RpgQuests.qm.isCreating.contains(splayer) ? "Please press back to add more rewards"
                                        : "").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericButton("Edit Settings").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 150).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericButton("Delete").setEnabled(false).setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(
                plugin,
                new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(plugin, label).attachWidget(plugin, finish).attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    @SuppressWarnings ("unused")
    @Override
    public void back() {
        if (RpgQuests.qm.isCreating.contains(splayer)) {
            new Creator((RpgQuests) plugin, splayer);
        } else {
            new QuestList((RpgQuests) plugin, null, splayer);
        }
    }
}