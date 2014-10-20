package me.duckdoom5.RpgEssentials.RpgLeveling.Events;

import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLevelUpEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private SkillType skill;
    private Player player;

    public PlayerLevelUpEvent(Player player, SkillType skill) {
        this.player = player;
        this.skill = skill;
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
}
