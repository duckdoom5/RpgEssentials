package com.topcat.npclib;

import net.minecraft.server.v1_4_R1.Packet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NPCUtils {
	public static ItemStack[] combineItemStackArrays(final Object[] a, final Object[] b) {
		final ItemStack[] c = new ItemStack[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public static void sendPacketNearby(final Location location, final Packet packet) {
		sendPacketNearby(location, packet, 64);
	}

	public static void sendPacketNearby(final Location location, final Packet packet, double radius) {
		radius *= radius;
		final World world = location.getWorld();
		for (final Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (p == null || world != p.getWorld()) {
				continue;
			}
			if (location.distanceSquared(p.getLocation()) > radius) {
				continue;
			}

			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}
}
