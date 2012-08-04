package me.duckdoom5.RpgEssentials.RpgLeveling.Events;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerExpGainEvent extends Event implements Cancellable{ 
    private static final HandlerList handlers = new HandlerList();
    Skill skill;
    Player player;
    int exp;
    boolean isCancelled;
    
    public PlayerExpGainEvent(Player player, Skill skill, int exp) {
        this.player = player;
        this.skill = skill;
        this.exp = exp;
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
    
    public int getExp(){
    	return exp;
    }

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = true;
	}
}
