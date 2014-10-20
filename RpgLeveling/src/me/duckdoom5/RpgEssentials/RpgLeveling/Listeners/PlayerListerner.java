package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Farming;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Firemaking;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Fishing;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListerner implements Listener {
    public static RpgLeveling plugin;

    public PlayerListerner(RpgLeveling rpgLeveling) {
        BlockListener.plugin = rpgLeveling;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.isCancelled()){
            return;
        }
        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
        final Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        final Action action = event.getAction();
        final ItemStack inhand = player.getItemInHand();
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            /*
             * if(inhand.getDurability() ==
             * Hashmaps.customitemsmap.get("Green Xp Book").getCustomId()){ TODO
             * open xp gui }else if(inhand.getDurability() ==
             * Hashmaps.customitemsmap.get("Red Xp Book").getCustomId()){ TODO
             * open xp gui }else if(inhand.getDurability() ==
             * Hashmaps.customitemsmap.get("Gold Xp Book").getCustomId()){ TODO
             * open xp gui }else if(inhand.getDurability() ==
             * Hashmaps.customitemsmap.get("Quest Book").getCustomId()){ TODO
             * open quest requirements gui }
             */
        }
        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (block.getType() == Material.GRASS || block.getType() == Material.DIRT) {
                final Material tool = player.getItemInHand().getType();
                if (Farming.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), tool)) {
                    final int exp = Farming.instance.getSoilXp(tool);
                    if (exp != 0) {
                        final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.FARMING, exp);
                        Bukkit.getServer().getPluginManager().callEvent(callevent);
                    }
                } else {
                    event.setCancelled(true);
                }
            }
        }
        // }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
        final Player player = event.getPlayer();
        final int exp = Fishing.instance.getExp(event);
        if (exp != 0) {
            final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.FISHING, exp);
            Bukkit.getServer().getPluginManager().callEvent(callevent);
        }
        // }
    }
}
