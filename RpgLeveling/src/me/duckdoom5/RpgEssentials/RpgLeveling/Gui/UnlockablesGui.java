package me.duckdoom5.RpgEssentials.RpgLeveling.Gui;

import java.util.ArrayList;
import java.util.Arrays;

import me.duckdoom5.RpgEssentials.RpgeManager;
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
import org.bukkit.material.MaterialData;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class UnlockablesGui extends Gui {
    private final GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
    private final WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
    private final Skill skill;
    private final int oldpage, oldrow;
    private final int Y = 20, X = -125;

    public UnlockablesGui(RpgLeveling plugin, SpoutPlayer splayer, Button button) {
        super(plugin, splayer);
        oldpage = GuiManager.gui.get(splayer).getPage();
        oldrow = ((button.getY() - 15) / 20) + oldpage * 9;
        ArrayList<SkillType> skills = new ArrayList<>();
        skills.addAll(Arrays.asList(SkillType.values()));
        skills.remove(SkillType.COMBAT);
        skill = skills.get(oldrow).getInstance();
        if(skill.hasUnlockableMaterialData()){
            maxPage = (int) (Math.ceil(skill.getUnlockableMaterialData().length / 9.0) - 1);
        }else{
            maxPage = (int) (Math.ceil(skill.getUnlockableMaterials().length / 9.0) - 1);
        }

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
    public void createPopup(boolean attach, boolean remove) {
        if (remove) {
            popup.removeWidgets(plugin);
        }

        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
        final int currentlevel = rpgplayer.getLvl(skill.getSkillType());
        final int i1 = page * 9;
        int i2 = i1 + 9;

        if(skill.hasUnlockableMaterialData()){
            if (i2 > skill.getUnlockableMaterialData().length) {
                i2 = skill.getUnlockableMaterialData().length;
            }
        }else{
            if (i2 > skill.getUnlockableMaterials().length) {
                i2 = skill.getUnlockableMaterials().length;
            }
        }

        for (int row = i1; row < i2; row++) {
            final int pos = (page > 0 ? row - (page * 9) : row);
            String name = "";
            if (skill.equals(SkillType.FISHING)) {
                popup.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(RpgeManager.getInstance().getMaterialManager().getFoodByName(skill.getUnlockableMaterials()[row].toString()))).setDepth(18).setHeight(18).setWidth(18).setTooltip(skill.getUnlockableMaterials()[row].toString()).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
            }else if(skill.hasUnlockableMaterialData()){
                name = StringUtils.UCWords(skill.getUnlockableMaterialData()[row].toString().toLowerCase().split("\\{")[1].split("\\}")[0].replace("_", " "));
                popup.attachWidget(plugin, new GenericItemWidget(skill.getUnlockableMaterialData()[row].toItemStack()).setDepth(18).setHeight(18).setWidth(18).setTooltip(name).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
            } else {
                name = StringUtils.UCWords(skill.getUnlockableMaterials()[row].toString().toLowerCase().replace("_", " "));
                popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(skill.getUnlockableMaterials()[row])).setDepth(18).setHeight(18).setWidth(18).setTooltip(name).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
            }
            popup.attachWidget(plugin, new GenericLabel().setText(name).setHeight(10).setX(X + 22).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            
            popup.attachWidget(plugin, new GenericLabel().setText("Unlocked at level: ").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            
            int lvl = 0;
            
            if(skill.hasUnlockableMaterialData()){
                lvl = getLevel(skill.getUnlockableMaterialData()[row]);
            }else{
                lvl = getLevel(skill.getUnlockableMaterials()[row]);
            }
            
            if (lvl > currentlevel) {
                popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(Integer.toString(lvl)).setHeight(10).setX(X + 230).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            } else {
                popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(Integer.toString(lvl)).setHeight(10).setX(X + 230).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
            }
        }
        popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page == maxPage ? false : true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page == 0 ? false : true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, BG);

        popup.attachWidget(plugin, new GenericLabel().setText("Unlockables").setHeight(15).shiftXPos(-35).setAnchor(WidgetAnchor.TOP_CENTER));

        popup.attachWidget(plugin, new GenericLabel().setText("Current level: " + currentlevel).setHeight(10).setX(-50).setY(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));

        popup.attachWidget(plugin, new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(-20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to level menu"));

        popup.attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }

    private int getLevel(MaterialData material) {
        return skill.getUnlockLevel(skill.getSkillType(), material);
    }
    
    private int getLevel(Material material) {
        int level = 0;
        if (skill.getSkillType() == SkillType.FISHING) {
            level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + material + ".level");
        } else {
            level = Skill.getUnlockLevel(skill.getSkillType(), material);
        }
        return level;
    }

    @Override
    public void back() {
        new LevelGui((RpgLeveling) plugin, null, splayer);
    }
}
