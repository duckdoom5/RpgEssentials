package com.topcat.npclib.entity;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Packet18ArmAnimation;
import net.minecraft.server.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import org.getspout.spout.player.SpoutCraftPlayer;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.nms.NPCEntity;

public class HumanNPC extends NPC {

	public HumanNPC(NPCEntity npcEntity) {
		super(npcEntity);
	}

	public void animateArmSwing() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet18ArmAnimation(getEntity(), 1));
	}

	public void actAsHurt() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet18ArmAnimation(getEntity(), 2));
	}

	public void setItemInHand(Material m) {
		setItemInHand(m, (short) 0);
	}

	public void setItemInHand(Material m, short damage) {
		((HumanEntity) getEntity().getBukkitEntity()).setItemInHand(new ItemStack(m, 1, damage));
	}

	public void setName(String name) {
		((NPCEntity) getEntity()).name = name;
	}

	public String getName() {
		return ((NPCEntity) getEntity()).name;
	}

	public PlayerInventory getInventory() {
		return ((HumanEntity) getEntity().getBukkitEntity()).getInventory();
	}

	public void putInBed(Location bed) {
		getEntity().setPosition(bed.getX(), bed.getY(), bed.getZ());
		getEntity().a((int) bed.getX(), (int) bed.getY(), (int) bed.getZ());
	}

	public void getOutOfBed() {
		((NPCEntity) getEntity()).a(true, true, true);
	}

	public void setSneaking(boolean b) {
		getEntity().setSneak(b);
	}

	public SpoutPlayer getSpoutPlayer() {
		try {
			Class.forName("org.getspout.spout.Spout");

			if (!(getEntity().getBukkitEntity() instanceof SpoutCraftPlayer)) {
				((NPCEntity) getEntity()).setBukkitEntity(new SpoutCraftPlayer((CraftServer) Bukkit.getServer(), (EntityPlayer) getEntity()));
			}

			return (SpoutPlayer) getEntity().getBukkitEntity();
		} catch (ClassNotFoundException e) {
			Bukkit.getServer().getLogger().warning("Cannot get spout player without spout installed");
		}
		return null;
	}

	public void lookAtPoint(Location point) {
		if (getEntity().getBukkitEntity().getWorld() != point.getWorld()) {
			return;
		}
		Location npcLoc = ((LivingEntity) getEntity().getBukkitEntity()).getEyeLocation();
		double xDiff = point.getX() - npcLoc.getX();
		double yDiff = point.getY() - npcLoc.getY();
		double zDiff = point.getZ() - npcLoc.getZ();
		double DistanceXZ = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		double DistanceY = Math.sqrt(DistanceXZ * DistanceXZ + yDiff * yDiff);
		double newYaw = Math.acos(xDiff / DistanceXZ) * 180 / Math.PI;
		double newPitch = Math.acos(yDiff / DistanceY) * 180 / Math.PI - 90;
		if (zDiff < 0.0) {
			newYaw = newYaw + Math.abs(180 - newYaw) * 2;
		}
		getEntity().yaw = (float) (newYaw - 90);
		getEntity().pitch = (float) newPitch;
	}

}