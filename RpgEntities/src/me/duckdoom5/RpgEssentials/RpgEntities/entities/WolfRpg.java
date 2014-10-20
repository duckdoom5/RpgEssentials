package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_6_R3.util.UnsafeList;

import net.minecraft.server.v1_6_R3.EntityHuman;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntitySkeleton;
import net.minecraft.server.v1_6_R3.EntityWolf;
import net.minecraft.server.v1_6_R3.GenericAttributes;
import net.minecraft.server.v1_6_R3.Item;
import net.minecraft.server.v1_6_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_6_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_6_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_6_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_6_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_6_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_6_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_6_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_6_R3.World;

public class WolfRpg extends EntityWolf implements EntityRpg {

    private static int lureItem = Item.SULPHUR.id;
    private EntityLiving owner;
    private boolean sitting;
    private boolean tamed;
    
    public WolfRpg(World world) {
        super(world);
        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("a");//PathfinderGoalSelector: private List a = new ArrayList();
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("b");//PathfinderGoalSelector: private List b = new ArrayList();
            cField.setAccessible(true);
            bField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            bField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        this.a(0.6F, 0.8F);//?
        this.getNavigation().a(true);//?
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntitySkeleton.class, 1.0D, true));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 0, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntitySkeleton.class, 0, false));
    }

    @Override
    protected void az(){
        super.az();
        this.getAttributeInstance(GenericAttributes.d).setValue(0.30000001192092896D);
        if (this.isTamed()) {
            this.getAttributeInstance(GenericAttributes.a).setValue(20.0D);
        } else {
            this.getAttributeInstance(GenericAttributes.a).setValue(8.0D);
        }
        //this.aX().b(GenericAttributes.e);//EnityLiving: public AttributeMapBase aX()
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
    public boolean canTarget(EntityLiving target, EntityLiving owner) {
        return true;
    }
}
