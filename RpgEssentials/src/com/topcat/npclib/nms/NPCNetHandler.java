package com.topcat.npclib.nms;

<<<<<<< HEAD
=======
import com.topcat.npclib.NPCManager;
>>>>>>> origin/pom-updates
import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.Packet;
import net.minecraft.server.v1_4_R1.Packet101CloseWindow;
import net.minecraft.server.v1_4_R1.Packet102WindowClick;
import net.minecraft.server.v1_4_R1.Packet106Transaction;
import net.minecraft.server.v1_4_R1.Packet10Flying;
import net.minecraft.server.v1_4_R1.Packet130UpdateSign;
import net.minecraft.server.v1_4_R1.Packet14BlockDig;
import net.minecraft.server.v1_4_R1.Packet15Place;
import net.minecraft.server.v1_4_R1.Packet16BlockItemSwitch;
import net.minecraft.server.v1_4_R1.Packet18ArmAnimation;
import net.minecraft.server.v1_4_R1.Packet19EntityAction;
import net.minecraft.server.v1_4_R1.Packet255KickDisconnect;
import net.minecraft.server.v1_4_R1.Packet3Chat;
import net.minecraft.server.v1_4_R1.Packet7UseEntity;
import net.minecraft.server.v1_4_R1.Packet9Respawn;
import net.minecraft.server.v1_4_R1.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_4_R1.CraftServer;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftPlayer;
<<<<<<< HEAD

import com.topcat.npclib.NPCManager;
=======
>>>>>>> origin/pom-updates

/**
 * 
 * @author martin
 */
public class NPCNetHandler extends PlayerConnection {

	public NPCNetHandler(final NPCManager npcManager, final EntityPlayer entityplayer) {
		super(npcManager.getServer().getMCServer(), npcManager.getNPCNetworkManager(), entityplayer);
	}

	@Override
	public void a(final double d0, final double d1, final double d2, final float f, final float f1) {
	}

	@Override
	public void a(final Packet102WindowClick packet102windowclick) {
	};

	@Override
	public void a(final Packet106Transaction packet106transaction) {
	};

	@Override
	public void a(final Packet10Flying packet10flying) {
	};

	@Override
	public void a(final Packet130UpdateSign packet130updatesign) {
	};

	@Override
	public void a(final Packet14BlockDig packet14blockdig) {
	};

	@Override
	public void a(final Packet15Place packet15place) {
	};

	@Override
	public void a(final Packet16BlockItemSwitch packet16blockitemswitch) {
	};

	@Override
	public void a(final Packet18ArmAnimation packet18armanimation) {
	};

	@Override
	public void a(final Packet19EntityAction packet19entityaction) {
	};

	@Override
	public void a(final Packet255KickDisconnect packet255kickdisconnect) {
	};

	@Override
	public void a(final Packet3Chat packet3chat) {
	};

	@Override
	public void a(final Packet7UseEntity packet7useentity) {
	};

	@Override
	public void a(final Packet9Respawn packet9respawn) {
	};
	
	@Override
	public void a(final String s, final Object[] aobject) {
	};

	@Override
	public void d() {
	};

	@Override
	public CraftPlayer getPlayer() {
		return new CraftPlayer((CraftServer) Bukkit.getServer(), player); //Fake player prevents spout NPEs
	};

	@Override
	public void handleContainerClose(final Packet101CloseWindow packet101closewindow) {
	};

	@Override
	public int lowPriorityCount() {
		return super.lowPriorityCount();
	};

	@Override
	public void onUnhandledPacket(final Packet packet) {
	}

	@Override
	public void sendPacket(final Packet packet) {
	};

}