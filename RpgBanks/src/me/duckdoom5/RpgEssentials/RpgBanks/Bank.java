package me.duckdoom5.RpgEssentials.RpgBanks;

import java.io.Serializable;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgBanks.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.util.CustomItemStack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.ScreenType;

public class Bank implements Serializable {
    private static final long serialVersionUID = -7901987279586675508L;
    private final String owner;

    private CustomItemStack[] inventory;

    public Bank(RpgPlayer owner) {
        this.owner = owner.getName();
        inventory = new CustomItemStack[9];
    }

    public RpgPlayer getOwner() {
        return RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(owner);
    }

    /**
     * Opens the text menu for the player who clicked
     * 
     * @param splayer
     *            The spout player that clicked the npc.
     * @return
     **/
    public TextSelectMenu clicked(RpgBanks plugin) {
        final String[] text = {};
        if (Configuration.config.getBoolean("bank.bankers.openbank")) {
            final String[] buttons = { "Open bank account", "Buy more room", "Close" };
            return new TextSelectMenu(plugin, getOwner().getSpoutPlayer(), "How can I help you ?", text, buttons);
        }
        final String[] buttons = { "Buy more room", "Close" };
        return new TextSelectMenu(plugin, getOwner().getSpoutPlayer(), "How can I help you ?", text, buttons);
    }

    /**
     * Opens the player's safe
     * 
     * @param splayer
     *            The spout player that opened the safe.
     **/
    public void open() {
        if (getOwner().getSpoutPlayer().getActiveScreen() != ScreenType.GAME_SCREEN) {
            try {
                getOwner().getSpoutPlayer().getMainScreen().getActivePopup().close();
            } catch (final Exception e) {
            }
        }

        final Inventory inv = Bukkit.createInventory(getOwner().getPlayer().getPlayer(), getSize(), "Bank");
        inv.setMaxStackSize(64);
        final ItemStack[] i = new ItemStack[inventory.length];
        for (int x = 0; x < inventory.length; x++) {
            i[x] = (inventory[x] == null ? null : inventory[x].getItemStack());
        }
        inv.setContents(i);
        getOwner().getPlayer().getPlayer().openInventory(inv);
        // owner.getPlayer().getPlayer().openInventory(arg0);

        // owner.getSpoutPlayer().openInventory(inventory);
    }

    /**
     * Check if the player can and wants to upgrade.
     * 
     * @param splayer
     *            The spout player that wants to upgrade.
     * @return
     **/

    public TextSelectMenu requestUpgrade(RpgBanks plugin) {
        final int newsize = getSize() + 9;
        if (newsize > 54) {
            final String[] buttons = { "Close" };
            final String[] text = { "You can't upgrade anymore" };
            return new TextSelectMenu(plugin, getOwner().getSpoutPlayer(), "Your bank is on max size !", text, buttons);
        }

        final int price = Configuration.config.getInt("bank.size." + newsize + ".price");
        final double money = getOwner().getMoney();

        if (money < price) {
            final String[] buttons = { "Close" };
            final String[] text = { "You can't buy more room.", "You need to have: " + ChatColor.RED + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value") };
            return new TextSelectMenu(plugin, getOwner().getSpoutPlayer(), "Not enough money !", text, buttons);
        }

        final String[] buttons = { "Buy", "Close" };
        final String[] text = { "Upgrading to " + newsize + " slots", "Price : " + ChatColor.GREEN + price + " " + me.duckdoom5.RpgEssentials.config.Configuration.config.getString("currency.value") };
        return new TextSelectMenu(plugin, getOwner().getSpoutPlayer(), "Are you sure ?", text, buttons);
    }

    /**
     * Upgrade the storage room for the player.
     * 
     * @param splayer
     *            The spout player that gets the upgrade.
     **/
    public void upgradeSpace() {
        if (getOwner().getSpoutPlayer().getActiveScreen() != ScreenType.GAME_SCREEN) {
            try {
                getOwner().getSpoutPlayer().getMainScreen().getActivePopup().close();
            } catch (final Exception e) {
            }
        }
        final int newsize = getSize() + 9;
        final int price = Configuration.config.getInt("bank.size." + newsize + ".price");
        getOwner().setMoney(getOwner().getMoney() - price);
        final CustomItemStack[] newinventory = new CustomItemStack[newsize];
        System.arraycopy(inventory, 0, newinventory, 0, inventory.length);
        inventory = newinventory;

        getOwner().getSpoutPlayer().sendMessage(
                ChatColor.GREEN + "Your bank size has been changed to " + ChatColor.YELLOW + newsize);
    }

    /**
     * Gets the players current storage room.
     * 
     * @param splayer
     *            The spout player to get the size from.
     **/
    public int getSize() {
        return inventory.length;
    }

    public void setInventory(CustomItemStack[] inventory) {
        this.inventory = inventory;
    }

    public CustomItemStack[] getInventory() {
        return inventory;
    }
}
