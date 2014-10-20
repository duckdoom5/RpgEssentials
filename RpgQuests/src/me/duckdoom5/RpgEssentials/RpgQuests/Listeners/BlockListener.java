package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
    @EventHandler
    public static void BlockPlace(BlockPlaceEvent event) throws Exception {
        final Player player = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.PLACE, event);
    }

    @EventHandler
    public static void BlockBreak(BlockBreakEvent event) throws Exception {
        final Player player = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.BREAK, event);
    }
}
