package me.duckdoom5.RpgEssentials.RpgLeveling.Events;

import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerExpGainEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private SkillType skill;
    private Player player;
    private double exp;
    private boolean isCancelled;

    public PlayerExpGainEvent(Player player, SkillType skill, double exp) {
        this.player = player;
        this.skill = skill;
        this.exp = exp;
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

    public SkillType getSkill() {
        return skill;
    }

    public int getExp() {
        return (int) exp;
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
