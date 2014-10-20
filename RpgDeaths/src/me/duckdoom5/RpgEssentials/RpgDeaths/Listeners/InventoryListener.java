package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import me.duckdoom5.RpgEssentials.RpgDeaths.DeadPlayer;
import me.duckdoom5.RpgEssentials.RpgDeaths.DeathChests;
import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.block.Block;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener {
    public static RpgDeaths plugin;

    public InventoryListener(RpgDeaths instance) {
        plugin = instance;
    }

    @EventHandler
    public static void onInventoryClose(InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();
        final Inventory inventory = event.getInventory();
        if (inventory.getType().equals(InventoryType.CHEST)) {
            if (inventory instanceof DoubleChestInventory) {
                final DoubleChestInventory c = (DoubleChestInventory) inventory;
                final DoubleChest chest = c.getHolder();
                final Block block = chest.getLocation().getBlock();
                if (BlockListener.protect.containsKey(block.getLocation())) {
                    if (Methods.isInventoryEmpty(inventory.getContents())) {
                        final DeadPlayer deathplayer = DeathChests.getDeathPlayer(player.getName());

                        deathplayer.removeChest();
                    }
                }
            }
        }
    }
}
