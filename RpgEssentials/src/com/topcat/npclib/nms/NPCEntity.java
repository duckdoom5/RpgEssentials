package com.topcat.npclib.nms;

import net.minecraft.server.v1_6_R3.Entity;
import net.minecraft.server.v1_6_R3.EntityHuman;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.EnumGamemode;
import net.minecraft.server.v1_6_R3.PlayerInteractManager;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEntity;
import org.bukkit.event.entity.EntityTargetEvent;

import com.topcat.npclib.NPCManager;

/**
 * 
 * @author martin
 */
public class NPCEntity extends EntityPlayer {

    private int lastTargetId;
    private long lastBounceTick;
    private int lastBounceId;

    public NPCEntity(NPCManager npcManager, BWorld world, String s, PlayerInteractManager itemInWorldManager) {
        super(npcManager.getServer().getMCServer(), world.getWorldServer(), s, itemInWorldManager);

        itemInWorldManager.b(EnumGamemode.SURVIVAL);

        playerConnection = new NPCPlayerConnection(npcManager, this);
        lastTargetId = -1;
        lastBounceId = -1;
        lastBounceTick = 0;

        fauxSleeping = true;
    }

    public void setBukkitEntity(org.bukkit.entity.Entity entity) {
        bukkitEntity = (CraftEntity) entity;
    }

    @Override
    public boolean a(EntityHuman entity) {
        final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_RIGHTCLICKED);
        Bukkit.getPluginManager().callEvent(event);

        return super.a(entity);
    }

    @Override
    public void b_(EntityHuman entity) {
        if ((lastBounceId != entity.id || System.currentTimeMillis() - lastBounceTick > 1000) && entity.getBukkitEntity().getLocation().distanceSquared(getBukkitEntity().getLocation()) <= 1) {
            final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_BOUNCED);
            Bukkit.getPluginManager().callEvent(event);

            lastBounceTick = System.currentTimeMillis();
            lastBounceId = entity.id;
        }

        if (lastTargetId == -1 || lastTargetId != entity.id) {
            final EntityTargetEvent event = new NpcEntityTargetEvent( getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.CLOSEST_PLAYER);
            Bukkit.getPluginManager().callEvent(event);
            lastTargetId = entity.id;
        }

        super.b_(entity);
    }

    @Override
    public void c(Entity entity) {
        if (lastBounceId != entity.id || System.currentTimeMillis() - lastBounceTick > 1000) {
            final EntityTargetEvent event = new NpcEntityTargetEvent(getBukkitEntity(), entity.getBukkitEntity(), NpcEntityTargetEvent.NpcTargetReason.NPC_BOUNCED);
            Bukkit.getPluginManager().callEvent(event);

            lastBounceTick = System.currentTimeMillis();
        }

        lastBounceId = entity.id;

        super.c(entity);
    }

    @Override
    public void move(double arg0, double arg1, double arg2) {
        setPosition(arg0, arg1, arg2);
    }
}