package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import org.bukkit.Location;

import com.topcat.npclib.entity.NPC;

public class EscortTask extends Task{
	private static final long serialVersionUID = 275842838445378372L;
	private NPC escort;
	private Location location = null;
	private String regionname = null;
	
	public EscortTask(int id, String regionname, NPC escort, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.ESCORT, taskGiver, taskEnder);
		
		this.escort = escort;
		this.regionname = regionname;
	}
	
	public EscortTask(int id, Location location, NPC escort, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.ESCORT, taskGiver, taskEnder);
		
		this.escort = escort;
		this.location = location;
	}
	
	public NPC getNpcToEscort(){
		return escort;
	}
	
	public String getRegionName(){
		return regionname;
	}
	
	public Location getLocation(){
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setNpcToEscort(NPC toEscort) {
		this.escort = toEscort;
	}

	public void setRegionName(String regionname) {
		this.regionname = regionname;
		
	}
}
