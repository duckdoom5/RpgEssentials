package com.topcat.npclib.pathing;

import java.util.ArrayList;

import org.bukkit.Location;

public class NPCPath {

	private final ArrayList<Node>	path;
	private final NPCPathFinder		pathFinder;
	private final Location			end;

	public NPCPath(final NPCPathFinder npcPathFinder, final ArrayList<Node> path, final Location end) {
		this.path = path;
		this.end = end;
		pathFinder = npcPathFinder;
	}

	public boolean checkPath(final Node node, final Node parent, final boolean update) {
		return pathFinder.checkPath(node, parent, update);
	}

	public Location getEnd() {
		return end;
	}

	public ArrayList<Node> getPath() {
		return path;
	}

}