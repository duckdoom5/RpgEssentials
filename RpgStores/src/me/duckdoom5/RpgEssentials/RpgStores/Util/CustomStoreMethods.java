package me.duckdoom5.RpgEssentials.RpgStores.Util;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.CustomStoreGui;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomStoreMethods {

    public static void buyClick(SpoutPlayer splayer, Button button) {
        final int oldpage = GuiManager.gui.get(splayer).getPage();
        final int row = ((button.getY() - 20) / 20) + oldpage * 10;
        final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
        final int amount = Integer.parseInt(gui.getAmount());

        if (gui.getCustomLength() != 0 && row < gui.getCustomLength()) {
            buyCustom(gui.getCustomMaterial(row), amount, splayer, gui.getType());
        } else if (gui.getDataLength() != 0 && row < (gui.getCustomLength() + gui.getDataLength())) {
            buyData(gui.getDataMaterial(row), amount, splayer, gui.getType());
        } else {
            buyMaterial(gui.getMaterial(row), amount, splayer, gui.getType());
        }
    }

    private static void buyCustom(org.getspout.spoutapi.material.Material customMaterial, int amount, SpoutPlayer splayer, String type) {
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        final double price = Configuration.customstores.getInt(type + "." + customMaterial.getName() + ".Buy Price") * amount;
        if (money < price) {
            splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
        } else {
            for (int count = 0; count < amount; count++) {
                splayer.getInventory().addItem(new SpoutItemStack(customMaterial));
            }

            splayer.sendNotification(amount + "x " + customMaterial.getName(), "Bought for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), new SpoutItemStack(customMaterial), 1000);
            // money min price
            money = money - price;
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

            final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
            gui.setMoney(money);
        }
    }

    private static void buyData(ItemStack dataMaterial, int amount, SpoutPlayer splayer, String type) {
        final double price = Configuration.customstores.getInt(type + "." + dataMaterial.getType().getId() + ":" + dataMaterial.getDurability() + ".Buy Price") * amount;
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        if (money < price) {
            splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
        } else {
            for (int count = 0; count < amount; count++) {
                splayer.getInventory().addItem(new ItemStack(dataMaterial.getType(), amount, dataMaterial.getDurability()));
            }
            splayer.sendNotification(amount + "x " + Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()), "Bought for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), dataMaterial, 1000);
            // money min price
            money = money - price;
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

            final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
            gui.setMoney(money);
        }
    }

    private static void buyMaterial(Material material, int amount, SpoutPlayer splayer, String type) {
        final double price = Configuration.customstores.getInt(type + "." + material.getId() + ".Buy Price") * amount;
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        if (money < price) {
            splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
        } else {
            for (int count = 0; count < amount; count++) {
                splayer.getInventory().addItem(new ItemStack(material));
            }

            splayer.sendNotification(amount + "x " + material.toString().toLowerCase().replace("_", " "), "Bought for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), new ItemStack(material), 1000);
            // money min price
            money = money - price;
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

            final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
            gui.setMoney(money);
        }
    }

    public static void sellClick(SpoutPlayer splayer, Button button) {
        final int oldpage = GuiManager.gui.get(splayer).getPage();
        final int row = ((button.getY() - 20) / 20) + oldpage * 10;
        final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
        final int amount = Integer.parseInt(gui.getAmount());

        if (gui.getCustomLength() != 0 && row < gui.getCustomLength()) {
            sellCustom(gui.getCustomMaterial(row), amount, splayer, gui.getType());
        } else if (gui.getDataLength() != 0 && row < (gui.getCustomLength() + gui.getDataLength())) {
            sellData(gui.getDataMaterial(row), amount, splayer, gui.getType());
        } else {
            sellMaterial(gui.getMaterial(row), amount, splayer, gui.getType());
        }
    }

    private static void sellCustom(org.getspout.spoutapi.material.Material customMaterial, int amount, SpoutPlayer splayer, String type) {
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        final double price = Configuration.customstores.getInt(type + "." + customMaterial.getName() + ".Sell Price") * amount;

        Material material = Material.FLINT;
        Short customId;

        if (customMaterial instanceof GenericCustomBlock) {
            material = Material.getMaterial(((GenericCustomBlock) customMaterial).getBlockId());
            customId = (short) ((GenericCustomBlock) customMaterial).getCustomId();
        } else {
            customId = (short) ((GenericCustomItem) customMaterial).getCustomId();
        }

        final ItemStack[] items = splayer.getInventory().getContents();
        boolean sell = false;
        boolean gotAmount = false;
        for (final ItemStack item : items) {
            if (item != null) {
                if (item.getType().equals(material) && item.getDurability() == customId) {
                    sell = true;
                    if (item.getAmount() >= amount) {
                        gotAmount = true;
                        break;
                    }
                }
            }
        }
        if (!sell) {
            if (customMaterial.getName().length() < 15) {
                splayer.sendNotification("Not enough " + customMaterial.getName(), "Please buy some!", new ItemStack(Material.ARROW), 1000);
            } else {
                splayer.sendNotification("Not enough", "Please buy some!", new ItemStack(Material.ARROW), 1000);
            }
        } else {
            if (!gotAmount) {
                if (customMaterial.getName().length() < 15) {
                    splayer.sendNotification("Not enough " + customMaterial.getName(), "Change your amount!", new ItemStack(Material.ARROW), 1000);
                } else {
                    splayer.sendNotification("Not enough", "Change your amount!", new ItemStack(Material.ARROW), 1000);
                }
            } else {
                splayer.getInventory().removeItem(new ItemStack(material, amount, customId));

                splayer.sendNotification(amount + "x " + customMaterial.getName(), "Sold for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), new SpoutItemStack(customMaterial), 1000);
                // money plus price
                money = money + price;
                RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

                final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
                gui.setMoney(money);
            }
        }
    }

    private static void sellData(ItemStack dataMaterial, int amount, SpoutPlayer splayer, String type) {
        final double price = Configuration.customstores.getInt(type + "." + dataMaterial.getType().getId() + ":" + dataMaterial.getDurability() + ".Sell Price") * amount;
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();

        final ItemStack[] items = splayer.getInventory().getContents();
        boolean sell = false;
        boolean gotAmount = false;
        for (final ItemStack item : items) {
            if (item != null) {
                if (item.getType().equals(dataMaterial.getType()) && item.getDurability() == dataMaterial.getDurability()) {
                    sell = true;
                    if (item.getAmount() >= amount) {
                        gotAmount = true;
                        break;
                    }
                }
            }
        }

        if (!sell) {
            if (Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()).length() < 15) {
                splayer.sendNotification("Not enough " + Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()), "Please buy some!", new ItemStack(Material.ARROW), 1000);
            } else {
                splayer.sendNotification("Not enough", "Please buy some!", new ItemStack(Material.ARROW), 1000);
            }
        } else {
            if (!gotAmount) {
                if (Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()).length() < 15) {
                    splayer.sendNotification("Not enough " + Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()), "Change your amount!", new ItemStack(Material.ARROW), 1000);
                } else {
                    splayer.sendNotification("Not enough", "Change your amount!", new ItemStack(Material.ARROW), 1000);
                }
            } else {
                splayer.getInventory().removeItem(new ItemStack(dataMaterial.getType(), amount, dataMaterial.getDurability()));

                splayer.sendNotification(
                        amount + "x " + Methods.getDataName(dataMaterial.getType(), dataMaterial.getDurability()), "Sold for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), dataMaterial, 1000);
                // money plus price
                money = money + price;
                RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

                final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
                gui.setMoney(money);
            }
        }
    }

    private static void sellMaterial(Material material, int amount, SpoutPlayer splayer, String type) {
        final double price = Configuration.customstores.getInt(type + "." + material.getId() + ".Sell Price") * amount;
        double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();
        if (!splayer.getInventory().contains(material)) {
            if (material.toString().length() < 15) {
                splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Please buy some!", new ItemStack(Material.ARROW), 1000);
            } else {
                splayer.sendNotification("Not enough", "Please buy some!", new ItemStack(Material.ARROW), 1000);
            }
        } else {
            if (!splayer.getInventory().contains(material, amount)) {
                if (material.toString().length() < 15) {
                    splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Change your amount!", new ItemStack(Material.ARROW), 1000);
                } else {
                    splayer.sendNotification("Not enough", "Change your amount!", new ItemStack(Material.ARROW), 1000);
                }
            } else {
                boolean run = false;
                if (Methods.isTool(material)) {
                    if (splayer.getInventory().contains(new ItemStack(material))) {
                        run = true;
                    } else {
                        splayer.sendNotification("Error!", "Can't sell broken tools", new ItemStack(material), 1000);
                    }
                } else {
                    run = true;
                }
                if (run) {
                    splayer.getInventory().removeItem(new ItemStack(material, amount));
                    splayer.sendNotification(amount + "x " + material.toString().toLowerCase().replace("_", " "), "Sold for: " + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value"), new ItemStack(material), 1000);
                    // money plus price
                    money = money + price;
                    RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(money);

                    final CustomStoreGui gui = (CustomStoreGui) GuiManager.gui.get(splayer);
                    gui.setMoney(money);
                }
            }
        }
    }
}
