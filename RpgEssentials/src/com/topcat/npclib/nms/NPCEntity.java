package com.topcat.npclib.nms;

<<<<<<< HEAD
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.EntityHuman;
import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.EnumGamemode;
import net.minecraft.server.v1_4_R1.PlayerInteractManager;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.craftbukkit.v1_4_R1.CraftServer;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.event.entity.EntityTargetEvent;

=======
>>>>>>> origin/pom-updates
import com.topcat.npclib.NPCManager;
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.EntityHuman;
import net.minecraft.server.v1_4_R1.EntityPlayer;
import net.minecraft.server.v1_4_R1.EnumGamemode;
import net.minecraft.server.v1_4_R1.PlayerInteractManager;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.craftbukkit.v1_4_R1.CraftServer;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.event.entity.EntityTargetEvent;

/**
 * 
 * @author martin
 */
public class NPCEntity extends EntityPlayer {

	private int		lastTargetId;
	private long	lastBounceTick;
	private int		lastBounceId;

	public NPCEntity(final NPCManager npcManager, final BWorld world, final String s, final PlayerInteractManager playerInteractManager) {
		super(npcManager.getServer().getMCServer(), world.getWorldServer(), s, playerInteractManager);

		playerInteractManager.setGameMode(EnumGamemode.SURVIVAL);

		playerConnection = new NPCNetHandler(npcManager, this);
		
		lastTargetId = -1;
		lastBounceId = -1;
		lastBounceTick = 0;

<<<<<<< HEAD
	public void setBukkitEntity(org.bukkit.entity.Entity entity) {
		bukkitEntity = (CraftEntity) entity;
	}

	@Override
	public boolean a(EntityHuman entity) {
		EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_RIGHTCLICKED);
		CraftServer server = ((WorldServer) world).getServer();
=======
		fauxSleeping = true;
	}

	@Override
	public boolean a(final EntityHuman entity) {
		final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_RIGHTCLICKED);
		final CraftServer server = ((WorldServer) world).getServer();
>>>>>>> origin/pom-updates
		server.getPluginManager().callEvent(event);

		return super.a(entity);
	}

	@Override
<<<<<<< HEAD
	public void c_(EntityHuman entity) {
		if ((lastBounceId != entity.id || System.currentTimeMillis() - lastBounceTick > 1000) && entity.getBukkitEntity().getLocation().distanceSquared(getBukkitEntity().getLocation()) <= 1) {
			EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_BOUNCED);
			CraftServer server = ((WorldServer) world).getServer();
=======
	public void c(final Entity entity) {
		if (lastBounceId != entity.id || System.currentTimeMillis() - lastBounceTick > 1000) {
			final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_BOUNCED);
			final CraftServer server = ((WorldServer) world).getServer();
>>>>>>> origin/pom-updates
			server.getPluginManager().callEvent(event);

			lastBounceTick = System.currentTimeMillis();
		}

<<<<<<< HEAD
		super.c_(entity);
=======
		lastBounceId = entity.id;

		super.c(entity);
>>>>>>> origin/pom-updates
	}

	@Override
	public void c_(final EntityHuman entity) {
		if ((lastBounceId != entity.id || System.currentTimeMillis() - lastBounceTick > 1000) && entity.getBukkitEntity().getLocation().distanceSquared(getBukkitEntity().getLocation()) <= 1) {
			final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_BOUNCED);
			final CraftServer server = ((WorldServer) world).getServer();
			server.getPluginManager().callEvent(event);
			lastBounceTick = System.currentTimeMillis();
			lastBounceId = entity.id;
		}

		if (lastTargetId == -1 || lastTargetId != entity.id) {
			final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.CLOSEST_PLAYER);
			final CraftServer server = ((WorldServer) world).getServer();
			server.getPluginManager().callEvent(event);
			lastTargetId = entity.id;
		}

		super.c_(entity);
	}

	@Override
	public void move(final double arg0, final double arg1, final double arg2) {
		setPosition(arg0, arg1, arg2);
	}

	public void setBukkitEntity(final org.bukkit.entity.Entity entity) {
		bukkitEntity = (CraftEntity)entity;
	}

}