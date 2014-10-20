package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreHashmaps;
import me.duckdoom5.RpgEssentials.util.AddonType;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomStoreGui extends StoreGui {
    public CustomStoreGui(RpgStores plugin, SpoutPlayer splayer, String StoreType) {
        super(plugin, splayer, StoreType);
    }

    @Override
    protected void prepairPopup(boolean attach, boolean remove) {
        for (final Material material : StoreHashmaps.custom) {
            if (Methods.isDataMaterial(material)) {
                for (int idata = 0; idata < Methods.getDataAmount(material); idata++) {
                    dataMaterials.add(new ItemStack(material, 1, (short) idata));
                }
            } else {
                materials.add(material);
            }
        }

        for (final org.getspout.spoutapi.material.Material material : StoreHashmaps.customcustom) {
            customMaterials.add(material);
        }

        createPopup(attach, remove);
    }

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
                price = Configuration.customstores.getInt(subgroupstr + "." + customMaterials.get(row).getName() + ".Buy Price");
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
                        if (rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials.get(row).getName())) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials.get(row).getName())).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials.get(row).getName())).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        }
                    } else {
                        popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY((Y + 5 + (pos * 20))).setAnchor(anchor));
                    }
                }

                // buy
                if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney() >= price && StoreHashmaps.buycustomitems.contains(customMaterials.get(row))) {
                    popup.attachWidget(plugin,  new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
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
                price = Configuration.customstores.getInt(subgroupstr + "." + dataMaterials.get(id).getType().getId() + ":" + dataMaterials.get(id).getDurability() + ".Buy Price");

                popup.attachWidget(plugin, new GenericItemWidget(dataMaterials.get(id)).setData(data).setDepth(18).setHeight(18).setWidth(18).setTooltip(dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));

                popup.attachWidget(plugin, new GenericLabel().setText(name2).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));

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
                        if (rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " "))) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials.get(id).getType().toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
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
                price = Configuration.customstores.getInt(subgroupstr + "." + materials.get(id).getId() + ".Buy Price");
                popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(materials.get(id))).setDepth(18).setHeight(18).setWidth(18).setTooltip(materials.get(id).toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));

                popup.attachWidget(plugin, new GenericLabel().setText(materials.get(id).toString().toLowerCase().replace("_", " ")).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));

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
                        if (rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials.get(id).toString().toLowerCase().replace("_", " "))) {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials.get(id).toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
                        } else {
                            popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials.get(id).toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
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
    public GenericPopup getPopup() {
        return popup;
    }
}
