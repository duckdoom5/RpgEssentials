package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.AddReward;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.AddTask;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.ChooseReward;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.ChooseTask;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.Creator;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.Editor;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.QuestList;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.RewardList;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.Settings;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.TaskList;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward.RewardType;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ScreenListener implements Listener {
    private final RpgQuests plugin;

    public ScreenListener(RpgQuests RpgQuests) {
        plugin = RpgQuests;
    }

    @EventHandler
    public void onButtonClick(ButtonClickEvent event) {
        final Button button = event.getButton();
        if (button.getPlugin().equals(plugin)) {
            final SpoutPlayer splayer = event.getPlayer();
            final Gui gui = GuiManager.gui.get(splayer);

            if (button.getText().equals("Close")) {
                splayer.getMainScreen().closePopup();
            } else if (button.getText().equals("Next")) {
                gui.nextPage();
            } else if (button.getText().equals("Prev")) {
                gui.prevPage();

            } else if (button.getText().equals("Create")) {
                final Creator creator = new Creator(plugin, splayer);

            } else if (button.getText().equals("Accept Quest")) {
                RpgQuests.qh.accepted(plugin, RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer),
                        ((TextSelectMenu) gui).getQuest());
            } else if (button.getText().equals("Add Task")) {
                final ChooseTask tgui = new ChooseTask(plugin, splayer);

            } else if (button.getText().equals("Add Reward")) {
                final ChooseReward rgui = new ChooseReward(plugin, splayer);

            } else if (button.getText().equals("Settings")) {
                final Settings sgui = new Settings(plugin, splayer);

            } else if (button.getText().equals("Edit")) {
                if (gui instanceof TaskList) {
                    final int oldpage = gui.getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    final AddTask tgui = new AddTask(plugin, splayer,
                            ((TaskList) gui).getTask(row).getType(),
                            ((TaskList) gui).getTask(row));
                } else if (gui instanceof RewardList) {
                    final int oldpage = GuiManager.gui.get(splayer).getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    final AddReward rgui = new AddReward(plugin, splayer,
                            ((RewardList) gui).getReward(row).getType(),
                            ((RewardList) gui).getReward(row));
                } else if (gui instanceof QuestList) {
                    final int oldpage = gui.getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    final Editor editor = new Editor(plugin, splayer,
                            ((QuestList) gui).getQuest(row));
                } else if (gui instanceof AddTask) {
                    if (((AddTask) gui).addAndValidate()) {
                        gui.back();
                    }
                } else if (gui instanceof AddReward) {
                    if (((AddReward) gui).addAndValidate()) {
                        gui.back();
                    }
                }
            } else if (button.getText().equals("Edit Tasks")) {
                Quest quest;
                if (RpgQuests.qm.createQuest.containsKey(splayer)) {
                    quest = RpgQuests.qm.createQuest.get(splayer);
                } else {
                    quest = RpgQuests.qm.editQuest.get(splayer);
                }
                final TaskList tgui = new TaskList(plugin, splayer, quest);
            } else if (button.getText().equals("Edit Rewards")) {
                Quest quest;
                if (RpgQuests.qm.createQuest.containsKey(splayer)) {
                    quest = RpgQuests.qm.createQuest.get(splayer);
                } else {
                    quest = RpgQuests.qm.editQuest.get(splayer);
                }
                final RewardList rgui = new RewardList(plugin, splayer, quest);
            } else if (button.getText().equals("Edit Settings")) {
                Quest quest;
                if (RpgQuests.qm.createQuest.containsKey(splayer)) {
                    quest = RpgQuests.qm.createQuest.get(splayer);
                } else {
                    quest = RpgQuests.qm.editQuest.get(splayer);
                }
                final Settings sgui = new Settings(plugin, splayer, quest);

            } else if (button.getText().equals("Delete")) {
                if (gui instanceof TaskList) {
                    final int oldpage = gui.getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    ((TaskList) gui).getQuest().removeTask(
                            ((TaskList) gui).getTask(row));
                    splayer.sendNotification("Task has been removed", "",
                            Material.APPLE);
                    final TaskList tgui = new TaskList(plugin, splayer,
                            ((TaskList) gui).getQuest());
                } else if (gui instanceof RewardList) {
                    final int oldpage = GuiManager.gui.get(splayer).getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    ((RewardList) gui).getQuest().removeReward(
                            ((RewardList) gui).getReward(row));
                    splayer.sendNotification("Reward has been removed", "",
                            Material.APPLE);
                    final RewardList tgui = new RewardList(plugin, splayer,
                            ((RewardList) gui).getQuest());
                } else if (gui instanceof QuestList) {
                    final int oldpage = gui.getPage();
                    final int row = ((button.getY() - 20) / 20) + oldpage * 9;
                    RpgQuests.qm.removeQuest(((QuestList) gui).getQuest(row));
                    splayer.sendNotification("Quest has been removed", "",
                            Material.APPLE);
                }

            } else if (button.getText().equals("Show Quest")) {
                final Quest quest = RpgQuests.qm.createQuest.get(splayer);
                final Editor sgui = new Editor(plugin, splayer, quest);

            } else if (button.getText().equals("Save")) {
                if (gui instanceof Settings) {
                    if (((Settings) gui).validateAndAdd()) {
                        gui.back();
                    }
                }
            } else if (button.getText().equals("Finish")) {
                Quest quest;
                if (RpgQuests.qm.createQuest.containsKey(splayer)) {
                    quest = RpgQuests.qm.createQuest.get(splayer);
                    RpgQuests.qm.createQuest.remove(splayer);
                    RpgQuests.qm.isCreating.remove(splayer);
                } else {
                    quest = RpgQuests.qm.editQuest.get(splayer);
                    RpgQuests.qm.editQuest.remove(splayer);
                }
                RpgQuests.qm.addQuest(quest);
                splayer.sendNotification("Quest has been saved as:",
                        quest.getId(), Material.BOOK);
                gui.back();

            } else if (button.getText().equals("Cancel") || button.getText().equals("Back")) {
                gui.back();
            } else if (button.getText().equals("Add")) {
                if (gui instanceof AddTask) {
                    if (((AddTask) gui).addAndValidate()) {
                        gui.back();
                    }
                } else if (gui instanceof AddReward) {
                    if (((AddReward) gui).addAndValidate()) {
                        gui.back();
                    }
                }

            } else if (button.getText().equals("Break") || button.getText().equals("Craft") || button.getText().equals("Deliver") || button.getText().equals("Escort") || button.getText().equals("Kill") || button.getText().equals("Place") || button.getText().equals("Smelt") || button.getText().equals("TalkTo")) {
                final AddTask tgui = new AddTask(plugin, splayer,
                        TaskType.valueOf(button.getText().toUpperCase()));
            } else if (button.getText().equals("Material") || button.getText().equals("Money") || button.getText().equals("Xp")) {
                final AddReward rgui = new AddReward(plugin, splayer,
                        RewardType.valueOf(button.getText().toUpperCase()));
            }

        }
    }
}