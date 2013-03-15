package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;

import net.minecraft.server.v1_4_R1.EntityWolf;
import net.minecraft.server.v1_4_R1.World;

public class WolfRpg extends EntityWolf implements EntityRpg{

	public WolfRpg(World world) {
		super(world);
	}

	public void setBukkitEntity(org.bukkit.entity.Entity entity) {
		bukkitEntity = (CraftEntity) entity;
	}
	
	@Override
	public void move(double x, double y, double z) {
		setPosition(x, y, z);
	}
}
