package me.duckdoom5.RpgEssentials.RpgPets.pets;

import net.minecraft.server.EntityOcelot;
import net.minecraft.server.World;

public class CatRpg extends EntityOcelot{

	public CatRpg(World world) {
		super(world);
	}

	public void setBukkitEntity(org.bukkit.entity.Entity entity) {
		bukkitEntity = entity;
	}
	
	@Override
	public void move(double x, double y, double z) {
		setPosition(x, y, z);
	}
}
