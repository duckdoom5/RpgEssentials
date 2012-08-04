package me.duckdoom5.RpgEssentials.RpgLeveling.Events;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLevelUpEvent extends Event { 
    private static final HandlerList handlers = new HandlerList();
    Skill skill;
    Player player;
    
    public PlayerLevelUpEvent(Player player, Skill skill) {
        this.player = player;
        this.skill = skill;
    }
    
    public HandlerList getHandlers() {
        return handlers;
    }
     
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public Player getPlayer(){
    	return player;
    }
    
    public Skill getSkill(){
    	return skill;
    }
}
