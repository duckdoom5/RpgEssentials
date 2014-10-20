package me.duckdoom5.RpgEssentials.RpgLeveling.Gui;

import java.util.ArrayList;
import java.util.Arrays;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.util.StringUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelGui extends Gui {
    private final GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private GenericTexture BG = null;
    private final WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
    private final GenericItemWidget sword = (GenericItemWidget) new GenericItemWidget(new ItemStack(Material.DIAMOND_SWORD)).setDepth(18).setHeight(18).setWidth(18).shiftXPos(-50).shiftYPos(-40).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Stats").setHeight(15).shiftXPos(-15).setAnchor(anchor);
    private final int Y = 20;
    private final int X = -200;
    private final RpgEssentials plugin2;
    private final int SP;

    public LevelGui(RpgLeveling plugin, RpgEssentials plugin2, SpoutPlayer splayer) {
        super(plugin, splayer);
        this.plugin2 = plugin2;
        BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setWidth(splayer.getMainScreen().getWidth()).setHeight(splayer.getMainScreen().getHeight()).setPriority(RenderPriority.High);

        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
        SP = rpgplayer.getSkillPoints();

        maxPage = (int) (Math.ceil(SkillType.values().length / 9.0) - 1);

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
            if (plugin2 != null) {
                popup.getPlugin();
                popup.removeWidgets(plugin2);
            }
            popup.removeWidgets(plugin);
        }

        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
        final int i1 = page * 9;
        int i2 = i1 + 9;
        
        ArrayList<SkillType> skills = new ArrayList<>();
        skills.addAll(Arrays.asList(SkillType.values()));
        skills.remove(SkillType.COMBAT);
        
        if (i2 > skills.size()) {
            i2 = skills.size();
        }
        
        for (int row = i1; row < i2; row++) {
            final int pos = (page > 0 ? row - (page * 9) : row);
            final SkillType skill = skills.get(row);
            final int currentlevel = rpgplayer.getLvl(skill);
            
            popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(skill.getInstance().getIcon())).setDepth(18).setHeight(18).setWidth(18).setTooltip(skill.toString().toLowerCase()).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
            popup.attachWidget(plugin, new GenericLabel().setText(StringUtils.UCFirst(skill.toString().toLowerCase())).setHeight(10).setX(X + 22).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            popup.attachWidget(plugin, new GenericLabel().setText(Integer.toString(currentlevel)).setTooltip("Level").setHeight(10).setX(X + 135).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            popup.attachWidget(plugin, new GenericLabel().setText(Integer.toString(rpgplayer.getExp(skill)) + "/" + Integer.toString(Skill.getExpRequired(rpgplayer, skill))).setTooltip("Exp left: " + Integer.toString(Skill.getExpLeft(rpgplayer, skill))).setHeight(10).setX(X + 190).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            popup.attachWidget(plugin, new GenericButton("Spend").setEnabled(SP > 0 ? true : false).setHeight(20).setX(X + 270).setY(Y + (pos * 20)).setAnchor(anchor));
            popup.attachWidget(plugin, new GenericButton("Unlockables").setEnabled(skill.hasUnlockables()).setHeight(20).setWidth(70).setX(X + 330).setY(Y + (pos * 20)).setAnchor(anchor));
        }

        popup.attachWidget(plugin, label);

        popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page == maxPage ? false : true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page == 0 ? false : true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, close);
        popup.attachWidget(plugin, BG);

        popup.attachWidget(plugin, sword);

        popup.attachWidget(plugin, new GenericLabel().setText("Combat level: " + rpgplayer.getLvl(SkillType.COMBAT)) .setWidth(60).setHeight(15).shiftXPos(-30).shiftYPos(-40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericLabel().setText("Skill Points: " + rpgplayer.getSkillPoints()).setWidth(60).setHeight(15).shiftXPos(-30).shiftYPos(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
    
    public void spend(RpgLeveling plugin, SpoutPlayer splayer, Button button) {
        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
        final int oldpage = GuiManager.gui.get(splayer).getPage();
        final int oldrow = ((button.getY() - 15) / 20) + oldpage * 9;
        final SkillType skill = SkillType.values()[oldrow];
        final int currentlevel = rpgplayer.getLvl(skill);
        int xptolvl = 0;

        final double exponent = Configuration.level.getDouble("Level exponent");
        for (int level = 0; level <= currentlevel && currentlevel != 100; level++) {
            xptolvl += (int) Math.floor(Math.floor((Math.pow(2.0, (level / exponent)) * (level + 300))) / 4);
        }

        rpgplayer.setExp(skill, xptolvl);
        rpgplayer.setLvl(skill, rpgplayer.getLvl(skill) + 1);
        rpgplayer.setSkillPoints(SP - 1);

        splayer.sendNotification(skill.toString().toLowerCase() + " level up!", "Your level is now: " + (rpgplayer.getLvl(skill) + 1), Material.getMaterial(Configuration.level.getInt("level-up material")));
        Skill.checknewcombat(rpgplayer, plugin);

        createPopup(false, true);
    }
}
