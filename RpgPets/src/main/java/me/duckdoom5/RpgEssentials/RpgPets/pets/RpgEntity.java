package me.duckdoom5.RpgEssentials.RpgPets.pets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import me.duckdoom5.RpgEssentials.config.Configuration;
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.LivingEntity;
import org.getspout.spoutapi.Spout;

import com.topcat.npclib.NPCManager;
import com.topcat.npclib.pathing.NPCPath;
import com.topcat.npclib.pathing.NPCPathFinder;
import com.topcat.npclib.pathing.Node;
import com.topcat.npclib.pathing.PathReturn;

public class RpgEntity implements Serializable{
	private static final long serialVersionUID = -136885983231687748L;
	private Entity entity;
	private NPCPathFinder path;
	private Iterator<Node> pathIterator;
	private Node last;
	private NPCPath runningPath;
	private int taskid;
	private Runnable onFail;
	protected OfflinePlayer owner;
	private RpgEntityType type;
	private int id;
	protected String name;
	protected boolean sitting = false;
	protected boolean sneaking = false;
	protected boolean sprinting = false;
	private boolean isPet;
	private RpgEntityState state = RpgEntityState.ALIVE;
	
	public RpgEntity(Entity entity, RpgEntityType wolf, int id) {
		this.entity = entity;
		this.type = null;
		this.owner = null;
		this.id = id;
		this.name = null;
		this.isPet = false;
	}
	
	public RpgEntity(Entity entity, RpgEntityType type, OfflinePlayer owner, String name, int id) {
		this.entity = entity;
		this.type = type;
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.isPet = true;
		
	}

	public boolean isPet(){
		return isPet;
	}

	public void setName(String name){
		Spout.getServer().setTitle((LivingEntity) getEntity(), name);
		this.name = name;
		save();
	}
	
	public String getName(){
		return name;
	}
	
	public void save(){
		if(isPet()){
			try {
				Configuration.save(this, "plugins/RpgPets/Temp/" + getType().toString().toLowerCase() + "s/" + id + ".RpgP");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				Configuration.save(this, "plugins/RpgPets/Temp/" + getType().toString().toLowerCase() + "s/" + id + ".RpgM");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getId(){
		return this.id;
	}
	
	public OfflinePlayer getOwner(){
		return this.owner;
	}
	
	public RpgEntityType getType(){
		return type;
	}
	
	public RpgEntityState getState() {
		return state;
	}

	public void setState(RpgEntityState state){
		this.state = state;
	}
	
	public Entity getEntity() {
		return entity;
	}

	public void removeFromWorld() {
		try {
			entity.world.removeEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public org.bukkit.entity.Entity getBukkitEntity() {
		return entity.getBukkitEntity();
	}

	public void moveTo(Location l) {
		getBukkitEntity().teleport(l);
	}

	public void pathFindTo(Location l, PathReturn callback) {
		pathFindTo(l, 3000, callback);
	}

	public void pathFindTo(Location l, int maxIterations, PathReturn callback) {
		if (path != null) {
			path.cancel = true;
		}
		if (l.getWorld() != getBukkitEntity().getWorld()) {
			ArrayList<Node> pathList = new ArrayList<Node>();
			pathList.add(new Node(l.getBlock()));
			callback.run(new NPCPath(null, pathList, l));
		} else {
			path = new NPCPathFinder(getBukkitEntity().getLocation(), l, maxIterations, callback);
			path.start();
		}
	}

	public void walkTo(Location l) {
		walkTo(l, 3000);
	}

	public void walkTo(final Location l, final int maxIterations) {
		pathFindTo(l, maxIterations, new PathReturn() {
			@Override
			public void run(NPCPath path) {
				usePath(path, new Runnable() {
					@Override
					public void run() {
						walkTo(l, maxIterations);
					}
				});
			}
		});
	}

	public void usePath(NPCPath path) {
		usePath(path, new Runnable() {
			@Override
			public void run() {
				walkTo(runningPath.getEnd(), 3000);
			}
		});
	}

	public void usePath(NPCPath path, Runnable onFail) {
		if (taskid == 0) {
			taskid = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(NPCManager.plugin, new Runnable() {
				@Override
				public void run() {
					pathStep();
				}
			}, 6L, 6L);
		}
		pathIterator = path.getPath().iterator();
		runningPath = path;
		this.onFail = onFail;
	}

	private void pathStep() {
		if (pathIterator.hasNext()) {
			Node n = pathIterator.next();
			if (n.b.getWorld() != getBukkitEntity().getWorld()) {
				getBukkitEntity().teleport(n.b.getLocation());
			} else {
				float angle = getEntity().yaw;
				float look = getEntity().pitch;
				if (last == null || runningPath.checkPath(n, last, true)) {
					if (last != null) {
						angle = (float) Math.toDegrees(Math.atan2(last.b.getX() - n.b.getX(), n.b.getZ() - last.b.getZ()));
						look = (float) (Math.toDegrees(Math.asin(last.b.getY() - n.b.getY())) / 2);
					}
					getEntity().setPositionRotation(n.b.getX() + 0.5, n.b.getY(), n.b.getZ() + 0.5, angle, look);
					((EntityPlayer)getEntity()).ay = angle;
				} else {
					onFail.run();
				}
			}
			last = n;
		} else {
			getEntity().setPositionRotation(runningPath.getEnd().getX(), runningPath.getEnd().getY(), runningPath.getEnd().getZ(), runningPath.getEnd().getYaw(), runningPath.getEnd().getPitch());
			((EntityPlayer)getEntity()).ay = runningPath.getEnd().getYaw();
			Bukkit.getServer().getScheduler().cancelTask(taskid);
			taskid = 0;
		}
	}
}