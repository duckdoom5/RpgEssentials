package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R3.util.UnsafeList;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.material.SpawnEgg;

import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.util.ParticleUtil;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Taming;
import net.minecraft.server.v1_6_R3.EntityCreeper;
import net.minecraft.server.v1_6_R3.EntityHuman;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntityOcelot;
import net.minecraft.server.v1_6_R3.Item;
import net.minecraft.server.v1_6_R3.ItemStack;
import net.minecraft.server.v1_6_R3.PathfinderGoalAvoidPlayer;
import net.minecraft.server.v1_6_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_6_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_6_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_6_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_6_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_6_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_6_R3.PathfinderGoalSwell;
import net.minecraft.server.v1_6_R3.PathfinderGoalTempt;
import net.minecraft.server.v1_6_R3.World;

public class CreeperRpg extends EntityCreeper implements EntityRpg {

    private static int lureItem = Item.SULPHUR.id;
    private EntityLiving owner;
    private boolean sitting;
    private boolean tamed;
    
    public CreeperRpg(World world) {
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
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalTempt(this, 1.1D, lureItem, false));
        this.goalSelector.a(3, new PathfinderGoalFollowOwner2(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.a(4, new PathfinderGoalSwell(this));
        this.goalSelector.a(5, new PathfinderGoalAvoidPlayer(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.a(6, new PathfinderGoalMeleeAttack(this, 1.0D, false));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.8D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalOwnerHurtByTarget2(this));
        this.targetSelector.a(2, new PathfinderGoalOwnerHurtTarget2(this));
        this.targetSelector.a(3, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 0, true));
        this.targetSelector.a(4, new PathfinderGoalHurtByTarget(this, false));
    }
    
    @Override
    public boolean a(EntityHuman entityhuman) {
        ItemStack itemstack = entityhuman.inventory.getItemInHand();
        
        if (itemstack != null && itemstack.id == lureItem && !this.isTamed()) {
            boolean canTame = true;
            if(RpgEntities.isLevelEnabled()){
                RpgPlayerLevel pl = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(entityhuman.getName());
                if(pl.getLvl(SkillType.TAMING) < Taming.instance.getUnlockLevel(SkillType.TAMING, new SpawnEgg(EntityType.CREEPER))){
                    canTame = false;
                }
            }
            if(canTame){
                if (!this.world.isStatic) {
                    if (this.random.nextInt(3) == 0) {
                        if (!entityhuman.abilities.canInstantlyBuild) {
                            if(RpgEntities.isLevelEnabled()){
                                final PlayerExpGainEvent callevent = new PlayerExpGainEvent((Player) entityhuman.getBukkitEntity(), SkillType.FARMING, Taming.instance.getXp(EntityType.CREEPER));
                                Bukkit.getServer().getPluginManager().callEvent(callevent);
                            }
                            --itemstack.count;
                        }
                        
                        if (itemstack.count <= 0) {
                            entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack) null);
                        }
                        
                        this.setTamed(true);
                        this.setPathEntity(null);
                        this.setGoalTarget(null);
                        this.setHealth(40.0F);
                        this.setOwner(entityhuman);
                        ParticleUtil.spawnHearts(this.getBukkitEntity().getLocation().add(0, 1, 0));
                    }else{
                        ParticleUtil.spawnSmoke(this.getBukkitEntity().getLocation().add(0, 1, 0));
                    }
                }
            }
        }

        return super.a(entityhuman);
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
