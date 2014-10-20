package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TaskList extends Gui {
    private final GenericButton back = (GenericButton) new GenericButton("Back").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Task List").setHeight(15).shiftXPos(-25).setAnchor(WidgetAnchor.TOP_CENTER);
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
    private final int Y = 20;
    private final Quest quest;

    public TaskList(RpgQuests plugin, SpoutPlayer splayer, Quest quest) {
        super(plugin, splayer);
        this.plugin = plugin;
        this.splayer = splayer;
        this.quest = quest;
        page = 0;
        maxPage = (int) (Math.ceil(quest.getTasks().length / 9.0) - 1);

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

        final int i1 = page * 9;
        int i2 = i1 + 9;

        if (i2 > quest.getTasks().length) {
            i2 = quest.getTasks().length;
        }

        popup.attachWidget(
                plugin,
                new GenericLabel("ID").setWidth(50).setHeight(20).shiftXPos(-152).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericLabel("Type").setWidth(50).setHeight(20).shiftXPos(-14).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericLabel("Edit").setWidth(50).setHeight(20).shiftXPos(+112).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(
                plugin,
                new GenericLabel("Delete").setWidth(50).setHeight(20).shiftXPos(+156).setY(Y + 5).setAnchor(WidgetAnchor.TOP_CENTER));

        for (int row = i1; row < i2; row++) {
            final int pos = (page > 0 ? row - (page * 9) : row) + 1;

            popup.attachWidget(
                    plugin,
                    new GenericLabel(String.valueOf(quest.getTasks()[row].getId())).setWidth(50).setHeight(20).shiftXPos(-150).setY(Y + 5 + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));

            popup.attachWidget(
                    plugin,
                    new GenericLabel(String.valueOf(quest.getTasks()[row].getType())).setWidth(50).setHeight(20).shiftXPos(-20).setY(Y + 5 + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));

            popup.attachWidget(plugin, new GenericButton("Edit").setWidth(50).setHeight(20).shiftXPos(+100).setY(Y + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));

            popup.attachWidget(plugin, new GenericButton("Delete").setWidth(50).setHeight(20).shiftXPos(+150).setY(Y + (pos * 20)).setAnchor(WidgetAnchor.TOP_CENTER));
        }

        popup.attachWidget(
                plugin,
                new GenericButton("Next").setEnabled(page == maxPage ? false : true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin,
                new GenericButton("Prev").setEnabled(page == 0 ? false : true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(plugin, label).attachWidget(plugin, back).attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    @SuppressWarnings ("unused")
    @Override
    public void back() {
        new Editor((RpgQuests) plugin, splayer, quest);
    }

    public Task getTask(int row) {
        return quest.getTasks()[row - 1];
    }

    public Quest getQuest() {
        return quest;
    }
}