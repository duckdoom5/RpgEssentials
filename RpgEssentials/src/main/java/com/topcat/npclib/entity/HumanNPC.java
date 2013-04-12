package com.topcat.npclib.entity;

import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.Packet18ArmAnimation;
import net.minecraft.server.v1_4_R1.Packet38EntityStatus;
import net.minecraft.server.v1_4_R1.Packet5EntityEquipment;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_4_R1.CraftServer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.getspout.spout.player.SpoutCraftPlayer;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.NPCUtils;
import com.topcat.npclib.nms.NPCEntity;

public class HumanNPC extends NPC {

	private final net.minecraft.server.v1_4_R1.ItemStack[]	previousEquipment	= { null, null, null, null, null };
	
	public HumanNPC(final NPCEntity npcEntity) {
		super(npcEntity);
	}

	public void actAsHurt() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet38EntityStatus(getEntity().id, (byte)2));
	}
	
	public void animateArmSwing() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet18ArmAnimation(getEntity(), 1));
	}

	public PlayerInventory getInventory() {
		return ((HumanEntity) getEntity().getBukkitEntity()).getInventory();
	}

	public String getName() {
		return ((NPCEntity) getEntity()).name;
	}

	public void getOutOfBed() {
		((NPCEntity) getEntity()).a(true, true, true);
	}
	
	public SpoutPlayer getSpoutPlayer() {
		try {
			Class.forName("org.getspout.spout.Spout");

			if (!(getEntity().getBukkitEntity() instanceof SpoutCraftPlayer)) {
				((NPCEntity) getEntity()).setBukkitEntity(new SpoutCraftPlayer((CraftServer) Bukkit.getServer(), (EntityPlayer) getEntity()));
			}

			return (SpoutPlayer) getEntity().getBukkitEntity();
		} catch (final ClassNotFoundException e) {
			Bukkit.getServer().getLogger().warning("Cannot get spout player without spout installed");
		}
		return null;
	}

	public void lookAtPoint(final Location point) {
		if (getEntity().getBukkitEntity().getWorld() != point.getWorld()) {
			return;
		}
		final Location npcLoc = ((LivingEntity) getEntity().getBukkitEntity()).getEyeLocation();
		final double xDiff = point.getX() - npcLoc.getX();
		final double yDiff = point.getY() - npcLoc.getY();
		final double zDiff = point.getZ() - npcLoc.getZ();
		final double DistanceXZ = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		final double DistanceY = Math.sqrt(DistanceXZ * DistanceXZ + yDiff * yDiff);
		double newYaw = Math.acos(xDiff / DistanceXZ) * 180 / Math.PI;
		final double newPitch = Math.acos(yDiff / DistanceY) * 180 / Math.PI - 90;
		if (zDiff < 0.0) {
			newYaw = newYaw + Math.abs(180 - newYaw) * 2;
		}
		getEntity().yaw = (float) (newYaw - 90);
		getEntity().pitch = (float) newPitch;
		((EntityPlayer) getEntity()).az = (float) (newYaw - 90);
	}

	public void putInBed(final Location bed) {
		getEntity().setPosition(bed.getX(), bed.getY(), bed.getZ());
		getEntity().a((int) bed.getX(), (int) bed.getY(), (int) bed.getZ());
	}

	public void setItemInHand(final Material m) {
		setItemInHand(m, (short) 0);
		updateEquipment();
	}

	public void setItemInHand(final Material m, final short damage) {
		((HumanEntity) getEntity().getBukkitEntity()).setItemInHand(new ItemStack(m, 1, damage));
		updateEquipment();
	}

	public void setName(final String name) {
		((NPCEntity) getEntity()).name = name;
	}

	public void setSneaking() {
		getEntity().setSneaking(true);
	}
	
	public void updateEquipment() {
		for (int i = 0; i < previousEquipment.length; i++) {
			final net.minecraft.server.v1_4_R1.ItemStack previous = previousEquipment[i];
			final net.minecraft.server.v1_4_R1.ItemStack current = ((EntityPlayer) getEntity()).getEquipment(i);
			if (previous != current) {
				NPCUtils.sendPacketNearby(getBukkitEntity().getLocation(), new Packet5EntityEquipment(getEntity().id, i, current), 20);
				previousEquipment[i] = current;
			}
		}
	}

}
