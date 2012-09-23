package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.entity.EntityType;

import com.topcat.npclib.entity.NPC;

public class KillTask extends Task{
	private static final long serialVersionUID = 382566650613315613L;
	private int amount;
	private EntityType type;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public KillTask(int id, EntityType type, int amount, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.KILL, taskGiver, taskEnder);
		
		this.amount = amount;
		this.type = type;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public EntityType getEntityType(){
		return type;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setEntityType(EntityType type) {
		this.type = type;
	}
}
