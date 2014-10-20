package me.duckdoom5.RpgEssentials.RpgLeveling.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerFireBoltEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private String bolttype;
    private Player player;
    private Arrow arrow;
    private boolean isCancelled;

    public PlayerFireBoltEvent(Player player, Arrow arrow, String bolttype) {
        this.player = player;
        this.arrow = arrow;
        this.bolttype = bolttype;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public Arrow getBolt() {
        return arrow;
    }

    public String getBoltType() {
        return bolttype;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = true;
    }
}
