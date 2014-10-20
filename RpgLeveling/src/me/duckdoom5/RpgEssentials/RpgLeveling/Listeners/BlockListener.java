package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Construction;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Excavation;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Farming;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Firemaking;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Mining;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Woodcutting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockListener implements Listener {
    public static RpgLeveling plugin;

    public BlockListener(RpgLeveling rpgLeveling) {
        BlockListener.plugin = rpgLeveling;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) throws Exception {
        if(event.isCancelled()){
            return;
        }
        final Block block = event.getBlock();
        final Player player = event.getPlayer();
        // if(RpgEssentials.wl.worlds.get(world)){
        block.setMetadata("Placed", new FixedMetadataValue(plugin, true));
        givePlaceExp(player, block);
        // }
    }

    private static void givePlaceExp(Player player, Block block) {
        if (Farming.instance.isFarming(block)) {
            final int exp = Farming.instance.getPlaceXp(block);
            final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.FARMING, exp);
            Bukkit.getServer().getPluginManager().callEvent(callevent);
        } else if (Construction.isConstruction(block)) {
            final int exp = Construction.instance.getXp(block);
            final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.CONSTRUCTION, exp);
            Bukkit.getServer().getPluginManager().callEvent(callevent);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) throws Exception {
        if(event.isCancelled()){
            return;
        }
        if (!Configuration.level.getBoolean("Disable block break on damage event")) {
            final Block block = event.getBlock();
            final Player player = event.getPlayer();
            if (canBreak(player, block)) {
                if (block.hasMetadata("Placed")) {
                    block.removeMetadata("Placed", plugin);
                } else {
                    giveBreakExp(player, block);
                }
            } else {
                event.setCancelled(true);
                player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() - 1));
            }
        }
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) throws Exception {
        if(event.isCancelled()){
            return;
        }
        if (Configuration.level.getBoolean("Disable block break on damage event")) {
            final Block block = event.getBlock();
            final Player player = event.getPlayer();
            if (!canBreak(player, block)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if(event.getIgnitingEntity() instanceof Player){
            if (Firemaking.instance.canIgnite()) {
                final int exp = Configuration.level.getInt("Exp.firemaking.ignite");

                final PlayerExpGainEvent callevent = new PlayerExpGainEvent((Player) event.getIgnitingEntity(), SkillType.FIREMAKING, exp);
                Bukkit.getServer().getPluginManager().callEvent(callevent);
            }
        }
    }
    
    private boolean canBreak(Player player, Block block) {
        if (Mining.isMining(block)) {
            if (!Configuration.level.getBoolean("Disable tool use for low level"))
                return true;
            if (Mining.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), player.getItemInHand().getType())) {
                if (!Configuration.level.getBoolean("Disable block break for low level") || Mining.instance.canMine(block, RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()))) {
                    return true;
                }
                return false;
            }
            return false;
        } else if (Woodcutting.isWoodcutting(block)) {
            if (!Configuration.level.getBoolean("Disable tool use for low level") || Woodcutting.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), player.getItemInHand().getType())) {
                return true;
            }
            return false;
        } else if (Excavation.isExcavation(block)) {
            if (!Configuration.level.getBoolean("Disable tool use for low level") || Excavation.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), player.getItemInHand().getType())) {
                return true;
            }
            return false;
        } else if (Farming.instance.isFarming(block)) {
            if (!Configuration.level.getBoolean("Disable tool use for low level") || Farming.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), player.getItemInHand().getType())) {
                return true;
            }
            return false;
        }
        return true;
    }

    private void giveBreakExp(Player player, Block block) {
        if (Mining.isMining(block)) {
            final int exp = Mining.instance.getXp(block);
            if (exp != 0) {
                final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.MINING, exp);
                Bukkit.getServer().getPluginManager().callEvent(callevent);
            }
        } else if (Woodcutting.isWoodcutting(block)) {
            final int exp = Woodcutting.instance.getXp(block);
            if (exp != 0) {
                final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.WOODCUTTING, exp);
                Bukkit.getServer().getPluginManager().callEvent(callevent);
            }
        } else if (Excavation.isExcavation(block)) {
            final int exp = Excavation.instance.getExp(block.getType(), 1);
            if (exp != 0) {
                final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.EXCAVATION, exp);
                Bukkit.getServer().getPluginManager().callEvent(callevent);
            }
        } else if (Farming.instance.isFarming(block)) {
            final int exp = Farming.instance.getBreakXp(block);
            if (exp != 0) {
                final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.FARMING, exp);
                Bukkit.getServer().getPluginManager().callEvent(callevent);
            }
        }
    }
}
