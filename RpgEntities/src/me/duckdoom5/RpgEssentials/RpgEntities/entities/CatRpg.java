package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;

import net.minecraft.server.v1_4_R1.EntityOcelot;
import net.minecraft.server.v1_4_R1.World;

public class CatRpg extends EntityOcelot implements EntityRpg{

	public CatRpg(World world) {
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
