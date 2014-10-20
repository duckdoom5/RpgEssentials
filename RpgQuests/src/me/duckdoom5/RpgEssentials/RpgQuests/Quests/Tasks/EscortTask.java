package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import org.bukkit.Location;

public class EscortTask extends Task {
    private static final long serialVersionUID = 275842838445378372L;
    private String escort;
    private Location location = null;
    private String regionname = null;

    public EscortTask(int id, String regionname, String escort,
            String taskGiver, String taskEnder) {
        super(id, TaskType.ESCORT, taskGiver, taskEnder);

        this.escort = escort;
        this.regionname = regionname;
    }

    public EscortTask(int id, Location location, String escort,
            String taskGiver, String taskEnder) {
        super(id, TaskType.ESCORT, taskGiver, taskEnder);

        this.escort = escort;
        this.location = location;
    }

    public String getNpcToEscort() {
        return escort;
    }

    public String getRegionName() {
        return regionname;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setNpcToEscort(String toEscort) {
        escort = toEscort;
    }

    public void setRegionName(String regionname) {
        this.regionname = regionname;

    }
}
