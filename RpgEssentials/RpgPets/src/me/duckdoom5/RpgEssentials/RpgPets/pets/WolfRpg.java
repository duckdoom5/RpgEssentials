package me.duckdoom5.RpgEssentials.RpgPets.pets;

import net.minecraft.server.EntityWolf;
import net.minecraft.server.World;

public class WolfRpg extends EntityWolf{

	public WolfRpg(World world) {
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
