package com.topcat.npclib.entity;

import java.util.ArrayList;
import java.util.Iterator;

import com.topcat.npclib.NPCManager;
import com.topcat.npclib.pathing.NPCPath;
import com.topcat.npclib.pathing.NPCPathFinder;
import com.topcat.npclib.pathing.Node;
import com.topcat.npclib.pathing.PathReturn;
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class NPC {

	private final Entity	entity;
	private NPCPathFinder	path;
	private Iterator<Node>	pathIterator;
	private Node			last;
	private NPCPath			runningPath;
	private int				taskid;
	private Runnable		onFail;

	public NPC(final Entity entity) {
		this.entity = entity;
	}

	public org.bukkit.entity.Entity getBukkitEntity() {
		return entity.getBukkitEntity();
	}

	public Entity getEntity() {
		return entity;
	}

	public void moveTo(final Location l) {
		getBukkitEntity().teleport(l);
	}

	public void pathFindTo(final Location l, final int maxIterations, final PathReturn callback) {
		if (path != null) {
			path.cancel = true;
		}
		if (l.getWorld() != getBukkitEntity().getWorld()) {
			final ArrayList<Node> pathList = new ArrayList<Node>();
			pathList.add(new Node(l.getBlock()));
			callback.run(new NPCPath(null, pathList, l));
		} else {
			path = new NPCPathFinder(getBukkitEntity().getLocation(), l, maxIterations, callback);
			path.start();
		}
	}

	public void pathFindTo(final Location l, final PathReturn callback) {
		pathFindTo(l, 3000, callback);
	}

	private void pathStep() {
		if (pathIterator.hasNext()) {
			final Node n = pathIterator.next();
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
					((EntityPlayer) getEntity()).az = angle;
				} else {
					onFail.run();
				}
			}
			last = n;
		} else {
			getEntity().setPositionRotation(runningPath.getEnd().getX(), runningPath.getEnd().getY(), runningPath.getEnd().getZ(), runningPath.getEnd().getYaw(), runningPath.getEnd().getPitch());
			((EntityPlayer) getEntity()).az = runningPath.getEnd().getYaw();
			Bukkit.getServer().getScheduler().cancelTask(taskid);
			taskid = 0;
		}
	}

	public void removeFromWorld() {
		try {
			entity.world.removeEntity(entity);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void usePath(final NPCPath path) {
		usePath(path, new Runnable() {
			@Override
			public void run() {
				walkTo(runningPath.getEnd(), 3000);
			}
		});
	}

	public void usePath(final NPCPath path, final Runnable onFail) {
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

	public void walkTo(final Location l) {
		walkTo(l, 3000);
	}

	public void walkTo(final Location l, final int maxIterations) {
		pathFindTo(l, maxIterations, new PathReturn() {
			@Override
			public void run(final NPCPath path) {
				usePath(path, new Runnable() {
					@Override
					public void run() {
						walkTo(l, maxIterations);
					}
				});
			}
		});
	}

}