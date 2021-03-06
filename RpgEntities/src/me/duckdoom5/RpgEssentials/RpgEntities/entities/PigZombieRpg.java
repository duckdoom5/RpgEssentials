package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntityPigZombie;
import net.minecraft.server.v1_6_R3.Item;
import net.minecraft.server.v1_6_R3.World;

public class PigZombieRpg extends EntityPigZombie implements EntityRpg {

    private static int lureItem = Item.SULPHUR.id;
    private EntityLiving owner;
    private boolean sitting;
    private boolean tamed;
    
    public PigZombieRpg(World world) {
        super(world);
    }
    
    @Override
    public EntityLiving getOwner() {
        return owner;
    }

    @Override
    public boolean isSitting() {
        return sitting;
    }

    @Override
    public void setOwner(EntityLiving owner) {
        this.owner = owner;
    }

    @Override
    public boolean isTamed() {
        return tamed;
    }

    @Override
    public void setTamed(boolean value) {
        this.tamed = value;
    }

    @Override
    public boolean canTarget(EntityLiving target, EntityLiving owner) {
        return true;
    }
}
