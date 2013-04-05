package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Ocelot.Type;

import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.EntityOcelot;
import net.minecraft.server.v1_4_R1.EntityTameableAnimal;
import net.minecraft.server.v1_4_R1.Packet18ArmAnimation;
import net.minecraft.server.v1_4_R1.WorldServer;

public class RpgCat extends RpgEntity implements Serializable{
	private static final long serialVersionUID = 4187071714471932304L;

	private Type cattype;
	
	public RpgCat(Entity entity){
		super(entity, EntityType.OCELOT);
	}
	
	public void actAsHurt() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet18ArmAnimation(getEntity(), 2));
	}
	
	public void setAge(int age){
		((Ocelot)getBukkitEntity()).setAge(age);
	}
	
	public void lockAge(boolean lock){
		((Ocelot)getBukkitEntity()).setAgeLock(lock);
	}
	
	public void setSprinting(boolean sprint){
		getEntity().setSprinting(sprint);
		sprinting = sprint;
		save();
	}
	
	public void setSneaking(boolean sneak) {
		getEntity().setSneaking(sneak);
		sneaking = sneak;
		save();
	}
	
	public void setSitting(boolean sit){
		((EntityTameableAnimal)getEntity()).setSitting(sit);
		sitting = sit;
		save();
	}
	
	public EntityType getType(){
		return EntityType.OCELOT;
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
		((EntityOcelot)getEntity()).az = (float)(newYaw - 90);
	}
	
	public Type getCatType(){
		return cattype;
	}
	
	public void setCatType(Type cattype){
		this.cattype = cattype;
	}
}
