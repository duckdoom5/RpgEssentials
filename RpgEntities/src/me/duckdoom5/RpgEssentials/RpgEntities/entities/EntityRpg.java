package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import net.minecraft.server.v1_6_R3.EntityLiving;

public interface EntityRpg {
    
    public void setOwner(EntityLiving owner);
    
    public EntityLiving getOwner();

    public boolean isSitting();

    public boolean isTamed();
    
    public void setTamed(boolean value);

    public boolean canTarget(EntityLiving target, EntityLiving owner);

}
