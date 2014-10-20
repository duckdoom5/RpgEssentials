package com.topcat.npclib.nms;

import net.minecraft.server.v1_6_R3.Connection;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.NetworkManager;
import net.minecraft.server.v1_6_R3.Packet;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 
 * @author martin
 */
public class NPCNetworkManager extends NetworkManager {

	public NPCNetworkManager() throws IOException {
		super(MinecraftServer.getServer().getLogger(), new NullSocket(), "NPC Manager", new Connection() {
			@Override
			public boolean a() {
				return true;
			}
		}, MinecraftServer.getServer().H().getPrivate());

		try {
			final Field f = NetworkManager.class.getDeclaredField("n");
			f.setAccessible(true);
			f.set(this, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void a() {
	}

	@Override
	public void a(final Connection connection) {
	}

	@Override
	public void a(final String s, final Object... aobject) {
	}

	@Override
	public void queue(final Packet packet) {
	}
}