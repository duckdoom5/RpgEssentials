package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.entity.EntityType;

import com.topcat.npclib.entity.NPC;

public class KillTask extends Task{
	private int amount;
	private EntityType type;
	private int id;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public KillTask(int id, EntityType type, int amount, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.KILL, taskGiver, taskEnder);
		
		this.amount = amount;
		this.type = type;
		this.id = id;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public EntityType getEntityType(){
		return type;
	}
	
	public int getId(){
		return id;
	}
}
