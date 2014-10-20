package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import java.util.ArrayList;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreHashmaps;
import me.duckdoom5.RpgEssentials.util.AddonType;
import me.duckdoom5.RpgEssentials.util.Methods;
import me.duckdoom5.RpgEssentials.util.StringUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
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
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreGui extends Gui {

    protected ArrayList<Material> materials = new ArrayList<>();
    protected ArrayList<ItemStack> dataMaterials = new ArrayList<>();
    protected ArrayList<org.getspout.spoutapi.material.Material> customMaterials = new ArrayList<>();

    protected short[] monsterEggData = { 50, 51, 52, 53, 54, 55, 56, 57, 58,
            59, 60, 61, 62, 63, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
            120 };
    protected short[] potionData = { 0, 16, 32, 64, 8192, 8193, 8225, 8257,
            16385, 16417, 16449, 8194, 8226, 8258, 16386, 16418, 16450, 8195,
            8259, 16387, 16451, 8196, 8228, 8260, 16388, 16420, 16452, 8197,
            8229, 16389, 16421, 8198, 8262, 16390, 16454, 8200, 8264, 16392,
            16456, 8201, 8233, 8265, 16393, 16425, 16457, 8202, 8266, 16394,
            16458, 8204, 8236, 16396, 16428, 8206, 8270, 16398, 16462, 8205,
            8269, 16397, 16461 };

    protected GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(-15).setAnchor(WidgetAnchor.TOP_CENTER);
    protected GenericButton close = (GenericButton) new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    protected GenericButton back = (GenericButton) new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(-20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection");
    protected GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
    protected GenericButton amount = (GenericButton) new GenericButton().setTooltip("Amount").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
    protected GenericLabel moneylb = (GenericLabel) new GenericLabel().setHeight(15).setWidth(50).shiftXPos(-50).setAnchor(WidgetAnchor.TOP_RIGHT);
    protected WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
    protected int price, i, X = -200, Y = 20;
    protected String currency, subgroupstr, amountText = "1";
    protected short data;

    public StoreGui(RpgStores plugin, SpoutPlayer splayer, String subgroupstr) {
        super(plugin, splayer);
        this.plugin = plugin;
        this.splayer = splayer;
        currency = me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value");
        this.subgroupstr = subgroupstr;

        final Gui gui = GuiManager.gui.get(splayer);
        if (gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN) {
            popup = new GenericPopup();
            prepairPopup(true, false);
        } else {
            popup = gui.getPopup();
            prepairPopup(false, true);
        }

        GuiManager.gui.put(splayer, this);
    }

    protected void prepairPopup(boolean attach, boolean remove) {
        Set<org.getspout.spoutapi.material.Material> cl = null;
        Set<Material> ml = null;

        switch (subgroupstr) {
            case "Food":
                cl = StoreHashmaps.customfood;
                ml = StoreHashmaps.food;
                break;
            case "Tools":
                cl = StoreHashmaps.customtools;
                ml = StoreHashmaps.tools;
                break;
            case "Armor":
                cl = StoreHashmaps.customarmor;
                ml = StoreHashmaps.armor;
                break;
            case "Mechanisms":
                cl = StoreHashmaps.custommechanisms;
                ml = StoreHashmaps.mechanisms;
                break;
            case "Gardening":
                cl = StoreHashmaps.customgardening;
                ml = StoreHashmaps.gardening;
                break;
            case "Raw Materials":
                cl = StoreHashmaps.customrawmaterials;
                ml = StoreHashmaps.rawmaterials;
                break;
            case "Furniture":
                cl = StoreHashmaps.customfurniture;
                ml = StoreHashmaps.furniture;
                break;
            case "Miscellaneous":
                cl = StoreHashmaps.custommisc;
                ml = StoreHashmaps.misc;
                break;

            case "Materials":
                cl = StoreHashmaps.custommaterials;
                ml = StoreHashmaps.materials;
                break;
            case "Nether":
                cl = StoreHashmaps.customnether;
                ml = StoreHashmaps.nether;
                break;
            case "The End":
                cl = StoreHashmaps.customtheend;
                ml = StoreHashmaps.theend;
                break;
            case "Ores":
                cl = StoreHashmaps.customores;
                ml = StoreHashmaps.ores;
                break;
            case "Painting":
                cl = StoreHashmaps.custompainting;
                ml = StoreHashmaps.painting;
                break;
            case "Mob Drops":
                cl = StoreHashmaps.custommobdrops;
                ml = StoreHashmaps.mobdrops;
                break;
            case "Brewing":
                cl = StoreHashmaps.custombrewing;
                ml = StoreHashmaps.brewing;
                break;
            case "Music":
                cl = StoreHashmaps.custommusic;
                ml = StoreHashmaps.music;
                break;
            default:
                break;
        }
        if (cl != null && !cl.isEmpty()) {
            for (final org.getspout.spoutapi.material.Material m : cl) {
                customMaterials.add(m);
            }
        }

        if (ml != null && !ml.isEmpty()) {
            for (final Material m : ml) {
                if (Methods.isDataMaterial(m)) {
                    for (int idata = 0; idata < Methods.getDataAmount(m); idata++) {
                        if (m.equals(Material.MONSTER_EGG)) {
                            dataMaterials.add(new ItemStack(m, 1, monsterEggData[idata]));
                        } else if (m.equals(Material.MOB_SPAWNER)) {
                            dataMaterials.add(new ItemStack(m, 1, monsterEggData[idata]));
                        } else if (m.equals(Material.POTION)) {
                            dataMaterials.add(new ItemStack(m, 1, potionData[idata]));
                        } else {
                            dataMaterials.add(new ItemStack(m, 1, (short) idata));
                        }
                    }
                } else {
                    materials.add(m);
                }
            }
        }

        createPopup(attach, remove);
    }

    protected int length;

    @Override
    protected void createPopup(boolean attach, boolean remove) {
        if (remove) {
            popup.removeWidgets(plugin);
        }

        length = materials.size() + customMaterials.size() + dataMaterials.size();

        maxPage = (int) (Math.ceil((length / 10.0) - 1));

        final int i1 = page * 10;
        int i2 = i1 + 10;

        if (i2 > length) {
            i2 = length;
        }

        for (int row = i1; row < i2; row++) {
            final int pos = (page > 0 ? row - (page * 10) : row);
            if (row < customMaterials.size()) {
                price = Configuration.store.getInt("Store.custom." + subgroupstr + "." + customMaterials.get(row).getName() + ".Buy Price");
                popup.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(customMaterials.get(row))).setDepth(18).setHeight(18).setWidth(18).setTooltip(customMaterials.get(row).getName()).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));

                popup.attachWidget(plugin, new GenericLabel().setText(customMaterials.get(row).getName()).setX(X + 21).setHeight(10).setY((Y + 5 + (pos * 20))).setAnchor(anchor));

                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price) {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                }

                // level
                if (RpgeManager.getInstance().isAddonEnabled(AddonType.LEVELING)) {
                    final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
                    final SkillType skill = Methods.getCustomSkill(customMaterials.get(row));
                    if (skill != null) {
                        int unlockLevel = Skill.getUnlockLevel(skill, customMaterials.get(row));
                        if (rpgplayer.getLvl(skill) >= unlockLevel) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Unlocked (lvl: "+ unlockLevel + ")").setTooltip("You have unlocked this tool!").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + unlockLevel).setTooltip("The level required for using this tool.").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        }
                    } else {
                        popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY((Y + 5 + (pos * 20))).setAnchor(anchor));
                    }
                }

                // buy
                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price && StoreHashmaps.buycustomitems.contains(customMaterials.get(row))) {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                }

                if (customMaterials.get(row) instanceof GenericCustomItem) {
                    final ItemStack[] items = splayer.getInventory().getContents();
                    boolean sell = false;
                    for (final ItemStack item : items) {
                        if (item != null) {
                            if (item.getType().equals(Material.FLINT) && item.getDurability() == ((GenericCustomItem) customMaterials.get(row)).getCustomId()) {
                                sell = true;
                                break;
                            }
                        }
                    }
                    // sell
                    if (sell && StoreHashmaps.sellcustomitems.contains(customMaterials.get(row))) {
                        popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                    } else {
                        popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                    }
                } else {
                    final ItemStack[] items = splayer.getInventory().getContents();
                    boolean sell = false;
                    for (final ItemStack item : items) {
                        if (item != null) {
                            if (item.getTypeId() == ((GenericCustomBlock) customMaterials.get(row)).getBlockId() && item.getDurability() == ((GenericCustomBlock) customMaterials.get(row)).getCustomId()) {
                                sell = true;
                                break;
                            }
                        }
                    }
                    // sell
                    if (sell && StoreHashmaps.sellcustomblocks.contains(customMaterials.get(row))) {
                        popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                    } else {
                        popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                    }
                }
            } else if (row < (customMaterials.size() + dataMaterials.size())) {
                final int id = row - customMaterials.size();

                data = dataMaterials.get(id).getDurability();

                final String name2 = Methods.getDataName(dataMaterials.get(id).getType(), data);
                price = Configuration.store.getInt("Store." + subgroupstr + "." + dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " ") + ".Buy Price");
                popup.attachWidget(plugin, new GenericItemWidget(dataMaterials.get(id)).setData(data).setDepth(18).setHeight(18).setWidth(18).setTooltip(dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));

                popup.attachWidget(plugin, new GenericLabel().setText(StringUtils.UCWords(name2)).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));

                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price) {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                }

                // level
                if (RpgeManager.getInstance().isAddonEnabled(AddonType.LEVELING)) {
                    final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
                    final SkillType skill = Methods.getSkill(dataMaterials.get(id).getType());
                    if (skill != null) {
                        int unlockLevel = Skill.getUnlockLevel(skill, dataMaterials.get(id).getType());
                        if (rpgplayer.getLvl(skill) >= unlockLevel) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Unlocked (lvl: "+ unlockLevel + ")").setTooltip("You have unlocked this tool!").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + unlockLevel).setTooltip("The level required for using this tool.").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        }
                    } else {
                        popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                    }
                }

                // buy
                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price && StoreHashmaps.buy.contains(dataMaterials.get(id).getType())) {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                }

                // sell
                final ItemStack[] items = splayer.getInventory().getContents();
                boolean sell = false;
                for (final ItemStack item : items) {
                    if (item != null) {
                        if (item.getType().equals(dataMaterials.get(id).getType()) && item.getDurability() == data) {
                            sell = true;
                            break;
                        }
                    }
                }
                if (sell && StoreHashmaps.sell.contains(dataMaterials.get(id).getType())) {
                    popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                }
            } else if (row < (length)) {
                final int id = row - customMaterials.size() - dataMaterials.size();
                price = Configuration.store.getInt("Store." + subgroupstr + "." + materials.get(id).toString().toLowerCase().replace("_", " ") + ".Buy Price");
                popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(materials.get(id))).setDepth(18).setHeight(18).setWidth(18).setTooltip(materials.get(id).toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));

                popup.attachWidget(plugin, new GenericLabel().setText(StringUtils.UCWords(materials.get(id).toString().toLowerCase().replace("_", " "))).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));

                // money
                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price) {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price + " " + currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                }

                // level
                if (RpgeManager.getInstance().isAddonEnabled(AddonType.LEVELING)) {
                    final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(splayer.getName());
                    final SkillType skill = Methods.getSkill(materials.get(id));
                    if (skill != null) {
                        int unlockLevel = Skill.getUnlockLevel(skill, materials.get(id));
                        if (rpgplayer.getLvl(skill) >= unlockLevel) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Unlocked (lvl: "+ unlockLevel + ")").setTooltip("You have unlocked this tool!").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + unlockLevel).setTooltip("The level required for using this tool.").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        }
                    } else {
                        popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                    }
                }

                // buy
                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price && StoreHashmaps.buy.contains(materials.get(id))) {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
                }
                // sell
                if (splayer.getInventory().contains(materials.get(id)) && StoreHashmaps.sell.contains(materials.get(id))) {
                    popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                } else {
                    popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
                }
            }
        }

        final double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        amount.setText(amountText);
        popup.attachWidget(plugin, amount);
        moneylb.setText(Double.toString(money));
        popup.attachWidget(plugin, moneylb);
        popup.attachWidget(plugin, storelb);

        popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page == maxPage ? false : true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(+100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page == 0 ? false : true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(-20).shiftXPos(-200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, close);
        popup.attachWidget(plugin, back);
        popup.attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
    
    @Override
    public void back() {
        new StoreSelectGui((RpgStores) plugin, splayer);
    }

    public void setMoney(double money) {
        moneylb.setText(Double.toString(money));
    }

    public void setAmount(String amountText) {
        this.amountText = amountText;
        amount.setText(amountText);
    }

    public String getAmount() {
        return amountText;
    }

    public String getType() {
        return subgroupstr;
    }

    public int getCustomLength() {
        return customMaterials.size();
    }

    public int getDataLength() {
        return dataMaterials.size();
    }

    public int getMaterialLength() {
        return materials.size();
    }

    public org.getspout.spoutapi.material.Material getCustomMaterial(int row) {
        return customMaterials.get(row);
    }

    public ItemStack getDataMaterial(int row) {
        return dataMaterials.get(row - customMaterials.size());
    }

    public Material getMaterial(int row) {
        return materials.get(row - customMaterials.size() - dataMaterials.size());
    }

    @Override
    public GenericPopup getPopup() {
        return popup;
    }
}
