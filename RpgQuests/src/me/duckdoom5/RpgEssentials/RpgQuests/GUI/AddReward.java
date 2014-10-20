package me.duckdoom5.RpgEssentials.RpgQuests.GUI;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.MaterialReward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.MoneyReward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward.RewardType;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.XpReward;

import org.bukkit.Material;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.NPC;

public class AddReward extends Gui {
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.Highest).setAnchor(WidgetAnchor.TOP_LEFT);

    private static int Y = 20;
    private final RewardType type;
    private final boolean edit;
    private Reward reward;

    public AddReward(RpgQuests plugin, SpoutPlayer splayer, RewardType type) {
        super(plugin, splayer);
        edit = false;
        this.type = type;

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

    public AddReward(RpgQuests plugin, SpoutPlayer splayer, RewardType type, Reward reward) {
        super(plugin, splayer);
        edit = true;
        this.type = type;
        this.reward = reward;

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

    private GenericTextField field1;
    private GenericTextField field2;
    private GenericTextField field3;
    private GenericTextField field4;

    @Override
    protected void createPopup(boolean attach, boolean remove) {
        if (remove) {
            popup.removeWidgets(plugin);
        }

        final GenericLabel label = (GenericLabel) new GenericLabel().setText(edit ? "Edit Reward" : "Add Reward").setHeight(15).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);

        if (type.equals(RewardType.MATERIAL)) {
            popup.attachWidget(plugin, new GenericLabel("Material ID *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
            field2 = (GenericTextField) new GenericTextField().setText(edit ? String.valueOf(((MaterialReward) reward).getMaterial()) : "").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
            popup.attachWidget(plugin, field2);

            popup.attachWidget(plugin, new GenericLabel("Material Data").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER));
            field3 = (GenericTextField) new GenericTextField().setText(edit ? String.valueOf(((MaterialReward) reward).getDurability()) : "").setMaximumCharacters(4).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 75).setAnchor(WidgetAnchor.TOP_CENTER);
            popup.attachWidget(plugin, field3);
        } else if (type.equals(RewardType.MONEY)) {

        } else if (type.equals(RewardType.XP)) {
            popup.attachWidget(plugin, new GenericLabel("Skill *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER));
            field2 = (GenericTextField) new GenericTextField().setText(edit ? String.valueOf(((XpReward) reward).getSkill()) : "").setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 50).setAnchor(WidgetAnchor.TOP_CENTER);
            popup.attachWidget(plugin, field2);
        }

        popup.attachWidget(plugin, new GenericLabel("Amount *").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER));
        field1 = (GenericTextField) new GenericTextField().setText(edit ? String.valueOf(reward.getAmount()) : "").setMaximumCharacters(10).setMaximumLines(1).setWidth(200).setHeight(20).shiftXPos(-100).setY(Y).setAnchor(WidgetAnchor.TOP_CENTER);
        popup.attachWidget(plugin, field1);
        popup.attachWidget(plugin, new GenericLabel("NPC").setWidth(50).setHeight(20).shiftXPos(-200).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER));
        field4 = (GenericTextField) new GenericTextField().setText(edit ? reward.getRewardGiver() : "").setMaximumCharacters(10).setMaximumLines(1).setTooltip("Npc to claim reward from").setWidth(200).setHeight(20).shiftXPos(-100).setY(Y + 25).setAnchor(WidgetAnchor.TOP_CENTER);
        popup.attachWidget(plugin, field4);

        popup.attachWidget(plugin, new GenericButton("Cancel").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        final GenericButton add = (GenericButton) new GenericButton(edit ? "Edit" : "Add").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(0).setAnchor(WidgetAnchor.BOTTOM_CENTER);

        popup.attachWidget(plugin, label).attachWidget(plugin, add).attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    @SuppressWarnings ("unused")
    @Override
    public void back() {
        if (edit) {
            Quest quest;
            if (RpgQuests.qm.createQuest.containsKey(splayer)) {
                quest = RpgQuests.qm.createQuest.get(splayer);
            } else {
                quest = RpgQuests.qm.editQuest.get(splayer);
            }
            new RewardList((RpgQuests) plugin, splayer, quest);
        } else {
            new ChooseReward((RpgQuests) plugin, splayer);
        }
    }

    public boolean addAndValidate() {
        if (type.equals(RewardType.MATERIAL)) {
            int amount = 1;
            int id = 1;
            int data = 0;
            NPC claim = null;

            if (field1.getText().equals("") || field2.getText().equals("")) {
                splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
                return false;
            }

            try {
                amount = Integer.parseInt(field1.getText());
            } catch (final NumberFormatException e) {
                splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
                return false;
            }

            try {
                id = Integer.parseInt(field2.getText());
            } catch (final NumberFormatException e) {
                splayer.sendNotification("Incorrect material ID", "Please use an integer", Material.APPLE);
                return false;
            }

            if (!field3.getText().equals("")) {
                try {
                    data = Integer.parseInt(field3.getText());
                } catch (final NumberFormatException e) {
                    splayer.sendNotification("Incorrect data", "Please use an integer.", Material.APPLE);
                    return false;
                }
            }

            if (!field4.getText().equals("")) {
                claim = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPC(field4.getText());
                if (claim == null) {
                    splayer.sendNotification("This npc does not exist", "", Material.APPLE);
                    return false;
                }
            }

            if (edit) {
                final MaterialReward reward = (MaterialReward) this.reward;
                reward.setMaterial(Material.getMaterial(id));
                reward.setAmount(amount);
                reward.setDurability((short) data);
                reward.setRewardGiver(field4.getText());
                splayer.sendNotification("Reward edited!", "", Material.APPLE);
            } else {
                final Reward reward = new MaterialReward(Material.getMaterial(id), amount, (short) data, field4.getText());
                add(reward);
                splayer.sendNotification("Reward added!", "", Material.APPLE);
            }

            return true;
        } else if (type.equals(RewardType.MONEY)) {
            int amount = 1;
            NPC claim = null;

            if (field1.getText().equals("")) {
                splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
                return false;
            }

            try {
                amount = Integer.parseInt(field1.getText());
            } catch (final NumberFormatException e) {
                splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
                return false;
            }

            if (!field4.getText().equals("")) {
                claim = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPC(field4.getText());
                if (claim == null) {
                    splayer.sendNotification("This npc does not exist", "", Material.APPLE);
                    return false;
                }
            }

            if (edit) {
                final MoneyReward reward = (MoneyReward) this.reward;
                reward.setAmount(amount);
                reward.setRewardGiver(field4.getText());
                splayer.sendNotification("Reward edited!", "", Material.APPLE);
            } else {
                final Reward reward = new MoneyReward(amount, field4.getText());
                add(reward);
                splayer.sendNotification("Reward added!", "", Material.APPLE);
            }

            return true;
        } else if (type.equals(RewardType.XP)) {
            int amount = 1;
            SkillType skill;
            NPC claim = null;

            if (field1.getText().equals("") || field2.getText().equals("")) {
                splayer.sendNotification("A required field is empty", "Fill in fields with *", Material.APPLE);
                return false;
            }

            try {
                amount = Integer.parseInt(field1.getText());
            } catch (final NumberFormatException e) {
                splayer.sendNotification("Incorrect amount", "Please use an integer", Material.APPLE);
                return false;
            }

            try {
                skill = SkillType.valueOf(field2.getText().toUpperCase());
            } catch (final Exception e) {
                splayer.sendNotification("Not a valid skill", "Please use a rpge skill", Material.APPLE);
                return false;
            }

            if (!field4.getText().equals("")) {
                claim = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPC(field4.getText());
                if (claim == null) {
                    splayer.sendNotification("This npc does not exist", "", Material.APPLE);
                    return false;
                }
            }

            if (edit) {
                final XpReward reward = (XpReward) this.reward;
                reward.setAmount(amount);
                reward.setSkill(skill);
                reward.setRewardGiver(field4.getText());
                splayer.sendNotification("Reward edited!", "", Material.APPLE);
            } else {
                final Reward reward = new XpReward(skill, amount, field4.getText());
                add(reward);
                splayer.sendNotification("Reward added!", "", Material.APPLE);
            }

            return true;
        }
        return true;
    }

    private void add(Reward reward) {
        final Quest quest = RpgQuests.qm.createQuest.get(splayer);
        quest.addReward(reward);
        RpgQuests.qm.createQuest.put(splayer, quest);
    }

    @Override
    public GenericPopup getPopup() {
        return popup;
    }
}
