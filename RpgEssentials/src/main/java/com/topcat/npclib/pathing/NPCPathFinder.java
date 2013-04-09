package com.topcat.npclib.pathing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * 
 * @author Top_Cat
 */
public class NPCPathFinder extends Thread {

	public class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(final Node o1, final Node o2) {
			if (o1.f > o2.f) {
				return 1;
			} else if (o1.f < o2.f) {
				return -1;
			}
			return 0;
		}
	}

	HashMap<Block, Node>		nodes		= new HashMap<Block, Node>();
	ArrayList<Node>				path		= new ArrayList<Node>();
	ArrayList<Node>				open		= new ArrayList<Node>();
	ArrayList<Node>				closed		= new ArrayList<Node>();
	Comparator<Node>			nodeComp	= new NodeComparator();
	Node						startNode, endNode;
	public boolean				cancel		= false;
	private final Location		start, end;
	private final int			maxIterations;

	private final PathReturn	callback;

	public NPCPathFinder(final Location start, final Location end, final int maxIterations, final PathReturn callback) {
		this.start = start;
		this.end = end;
		this.maxIterations = maxIterations;
		this.callback = callback;
	}

	public boolean checkPath(final Node node, final Node parent) {
		return checkPath(node, parent, false);
	}

	public boolean checkPath(final Node node, final Node parent, final boolean update) {
		boolean corner = false;
		if (node.xPos != parent.xPos && node.zPos != parent.zPos) {
			final int xDir = node.xPos - parent.xPos;
			final int zDir = node.zPos - parent.zPos;

			final boolean xZCor1 = !getNode(parent.b.getRelative(0, 0, zDir)).notsolid;
			final boolean xZCor2 = !getNode(parent.b.getRelative(xDir, 0, 0)).notsolid;

			corner = xZCor1 || xZCor2;
		} else if (node.xPos != parent.xPos && node.yPos != parent.yPos || node.yPos != parent.yPos && node.zPos != parent.zPos) {
			corner = node.yPos > parent.yPos ? !getNode(parent.b.getRelative(0, 2, 0)).notsolid : !getNode(node.b.getRelative(0, 2, 0)).notsolid;
			;
		}

		final Node nodeBelow = getNode(node.b.getRelative(0, -1, 0));
		final Node nodeAbove = getNode(node.b.getRelative(0, 1, 0));

		if (update) {
			nodeBelow.update();
			nodeAbove.update();
			node.update();
		}

		return !corner && (node.notsolid && (!nodeBelow.notsolid || nodeBelow.liquid && node.liquid) && nodeAbove.notsolid || node == endNode);
	}

	private Node getNode(final Block b) {
		if (!nodes.containsKey(b)) {
			nodes.put(b, new Node(b));
		}
		return nodes.get(b);
	}

	private void look(Node c, final int max) {
		Node adjacentBlock;
		int rep = 0;
		while (c != endNode && rep < max) { // Repetition variable prevents infinite loop when destination is unreachable
			if (cancel) {
				return;
			}
			rep++;
			closed.add(c);
			open.remove(c);

			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					for (int k = -1; k <= 1; k++) {
						adjacentBlock = getNode(c.b.getRelative(i, j, k));
						if (adjacentBlock != c && !(j == 1 && adjacentBlock.b.getRelative(0, -1, 0).getType() == Material.FENCE)) {
							scoreBlock(adjacentBlock, c);
						}
					}
				}
			}
			final Node[] n = open.toArray(new Node[open.size()]);
			Arrays.sort(n, nodeComp);
			if (n.length == 0) {
				break;
			}
			c = n[0];
			if (c == endNode) {
				adjacentBlock = c;
				while (adjacentBlock != null && adjacentBlock != startNode) {
					path.add(adjacentBlock);
					adjacentBlock = adjacentBlock.parent;
				}
				Collections.reverse(path);
			}
		}
		if (path.size() == 0) {
			path.add(endNode);
		}
	}

	@Override
	public void run() {
		startNode = getNode(start.getBlock());
		endNode = getNode(end.getBlock());
		look(startNode, maxIterations);
		if (cancel) {
			path.clear();
		}
		callback.run(new NPCPath(this, path, end));
	}

	private void scoreBlock(final Node node, final Node parent) {
		final int diagonal = node.xPos != parent.xPos && node.zPos != parent.zPos || node.xPos != parent.xPos && node.yPos != parent.yPos || node.yPos != parent.yPos && node.zPos != parent.zPos ? 14 : 10;

		if (checkPath(node, parent)) {
			if (!open.contains(node) && !closed.contains(node)) {
				node.parent = parent;
				node.g = parent.g + diagonal;

				final int difX = Math.abs(endNode.xPos - node.xPos);
				final int difY = Math.abs(endNode.yPos - node.yPos);
				final int difZ = Math.abs(endNode.zPos - node.zPos);

				node.h = (difX + difY + difZ) * 10;
				node.f = node.g + node.h;

				open.add(node);
			} else if (!closed.contains(node)) {
				final int g = parent.g + diagonal;
				if (g < node.g) {
					node.g = g;
					node.parent = parent;
				}
			}
		}
	}

}