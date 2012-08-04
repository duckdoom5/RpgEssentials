package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import org.bukkit.Location;

import com.topcat.npclib.entity.NPC;

public class EscortTask extends Task{
	private NPC escort;
	private int id;
	private Location location = null;
	private String regionname = null;
	
	public EscortTask(int id, String regionname, NPC escort, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.ESCORT, taskGiver, taskEnder);
		
		this.id = id;
		this.escort = escort;
		this.regionname = regionname;
	}
	
	public EscortTask(int id, Location location, NPC escort, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.ESCORT, taskGiver, taskEnder);
		
		this.id = id;
		this.escort = escort;
		this.location = location;
	}
	
	public NPC getNpcToEscort(){
		return escort;
	}
	
	public int getId(){
		return id;
	}
	
	public String getRegionName(){
		return regionname;
	}
	
	public Location getLocation(){
		return location;
	}
}
