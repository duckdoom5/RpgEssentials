package me.duckdoom5.RpgEssentials.RpgBanks.Listeners;

import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.RpgBankManager;
import me.duckdoom5.RpgEssentials.util.CustomItemStack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    @EventHandler
    public static void onInventoryClose(InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();
        final Inventory inventory = event.getInventory();
        if (inventory.getName().equals("Bank")) {
            final ItemStack[] inv = inventory.getContents();
            final CustomItemStack[] cinv = new CustomItemStack[inv.length];

            for (int i = 0; i < inv.length; i++) {
                if (inv[i] != null) {
                    cinv[i] = new CustomItemStack(inv[i]);
                }
            }

            final Bank bank = RpgBankManager.getInstance().getBank(
                    player.getName());
            bank.setInventory(cinv);
            RpgBankManager.saveBank(bank);

            inventory.clear();
        }
    }
}
