package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import me.duckdoom5.RpgEssentials.RpgDeaths.DeadPlayer;
import me.duckdoom5.RpgEssentials.RpgDeaths.DeathChests;
import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
    public static RpgDeaths plugin;

    public PlayerListener(RpgDeaths instance) {
        plugin = instance;
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        // if(RpgEssentials.wl.worlds.get(event.getEntity().getWorld())){
        final Player player = event.getEntity();

        if (!DeathChests.isDeath(player.getName())) {
            event.getDrops().clear();
            if (!Methods.isInventoryEmpty(player)) {
                new DeadPlayer(player.getName(), plugin);
            }
        }
        // }
    }

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent event) {
        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
        final Player player = event.getPlayer();
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();
        player.getItemInHand();
        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (block.getType().equals(Material.CHEST)) {
                if (BlockListener.protect.containsKey(block.getLocation())) {
                    if (!player.getName().equals(
                            BlockListener.protect.get(block.getLocation()))) {
                        player.sendMessage(ChatColor.RED + "This chest is still protected.");
                        event.setCancelled(true);
                    }
                }
            }
        }
        // }
    }
}
