package com.topcat.npclib.nms;

import java.io.IOException;
import java.lang.reflect.Field;

import net.minecraft.server.v1_4_R1.Connection;
import net.minecraft.server.v1_4_R1.NetworkManager;
import net.minecraft.server.v1_4_R1.Packet;

/**
 * 
 * @author martin
 */
public class NPCNetworkManager extends NetworkManager {

	public NPCNetworkManager() throws IOException {
		super(new NullSocket(), "NPC Manager", new Connection() {
			@Override
			public boolean a() {
				return true;
			}
		}, null);
		try {
			final Field f = NetworkManager.class.getDeclaredField("m");
			f.setAccessible(true);
			f.set(this, false);
		} catch (final Exception e) {
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