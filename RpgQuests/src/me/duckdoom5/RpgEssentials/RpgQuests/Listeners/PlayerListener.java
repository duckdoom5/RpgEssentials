package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.ESCORT, event);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.TALKTO, event);
    }
}
