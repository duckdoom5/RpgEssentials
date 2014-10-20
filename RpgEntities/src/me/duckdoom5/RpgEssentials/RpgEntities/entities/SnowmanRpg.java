package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

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
import net.minecraft.server.v1_6_R3.Block;
import net.minecraft.server.v1_6_R3.DamageSource;
import net.minecraft.server.v1_6_R3.EntityHuman;
import net.minecraft.server.v1_6_R3.EntityInsentient;
import net.minecraft.server.v1_6_R3.EntityItem;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntitySnowman;
import net.minecraft.server.v1_6_R3.IMonster;
import net.minecraft.server.v1_6_R3.Item;
import net.minecraft.server.v1_6_R3.ItemArmor;
import net.minecraft.server.v1_6_R3.ItemStack;
import net.minecraft.server.v1_6_R3.ItemSword;
import net.minecraft.server.v1_6_R3.MathHelper;
import net.minecraft.server.v1_6_R3.PathfinderGoalArrowAttack;
import net.minecraft.server.v1_6_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_6_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_6_R3.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_6_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_6_R3.PathfinderGoalTempt;
import net.minecraft.server.v1_6_R3.World;

public class SnowmanRpg extends EntitySnowman implements EntityRpg {

    private static int lureItem = Item.CARROT.id;
    private EntityLiving owner;
    private boolean sitting;
    private boolean tamed;
    
    public SnowmanRpg(World world) {
        super(world);
        System.out.println("Override");
        /*try {
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
        this.goalSelector.a(1, new PathfinderGoalTempt(this, 1.1D, lureItem, false));
        this.goalSelector.a(2, new PathfinderGoalFollowOwner2(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.a(3, new PathfinderGoalArrowAttack(this, 1.25D, 20, 10.0F));
        this.goalSelector.a(4, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(5, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(6, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalOwnerHurtByTarget2(this));
        this.targetSelector.a(2, new PathfinderGoalOwnerHurtTarget2(this));
        this.targetSelector.a(3, new PathfinderGoalNearestAttackableTarget(this, EntityInsentient.class, 0, true, false, IMonster.a));*/
    }
    
    /*@Override
    public boolean a(EntityHuman entityhuman) {
        ItemStack itemstack = entityhuman.inventory.getItemInHand();
        
        if (itemstack != null && itemstack.id == lureItem && !this.isTamed()) {
            boolean canTame = true;
            if(RpgEntities.isLevelEnabled()){
                RpgPlayerLevel pl = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(entityhuman.getName());
                if(pl.getLvl(SkillType.TAMING) < Taming.instance.getUnlockLevel(SkillType.TAMING, new SpawnEgg(EntityType.SNOWMAN))){
                    canTame = false;
                }
            }
            if(canTame){
                if (!this.world.isStatic) {
                    if (this.random.nextInt(3) == 0) {
                        if (!entityhuman.abilities.canInstantlyBuild) {
                            if(RpgEntities.isLevelEnabled()){
                                final PlayerExpGainEvent callevent = new PlayerExpGainEvent((Player) entityhuman.getBukkitEntity(), SkillType.FARMING, Taming.instance.getXp(EntityType.SNOWMAN));
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
    public void c() {
        try{
            Field bqField = EntityLiving.class.getDeclaredField("bq");//private int bq; (line: 69)
            bqField.setAccessible(true);
            
            if (bqField.getInt(this) > 0) {
                bqField.set(this, bqField.getInt(this) - 1);
            }
    
            if (this.bh > 0) {
                double d0 = this.locX + (this.bi - this.locX) / this.bh;
                double d1 = this.locY + (this.bj - this.locY) / this.bh;
                double d2 = this.locZ + (this.bk - this.locZ) / this.bh;
                double d3 = MathHelper.g(this.bl - this.yaw);
    
                this.yaw = (float) (this.yaw + d3 / this.bh);
                this.pitch = (float) (this.pitch + (this.bm - this.pitch) / this.bh);
                --this.bh;
                this.setPosition(d0, d1, d2);
                this.b(this.yaw, this.pitch);
            } else if (!this.bm()) {
                this.motX *= 0.98D;
                this.motY *= 0.98D;
                this.motZ *= 0.98D;
            }
    
            if (Math.abs(this.motX) < 0.005D) {
                this.motX = 0.0D;
            }
    
            if (Math.abs(this.motY) < 0.005D) {
                this.motY = 0.0D;
            }
    
            if (Math.abs(this.motZ) < 0.005D) {
                this.motZ = 0.0D;
            }
    
            this.world.methodProfiler.a("ai");
            if (this.bc()) {
                this.bd = false;
                this.be = 0.0F;
                this.bf = 0.0F;
                this.bg = 0.0F;
            } else if (this.bm()) {
                if (this.bf()) {
                    this.world.methodProfiler.a("newAi");
                    this.bi();
                    this.world.methodProfiler.b();
                } else {
                    this.world.methodProfiler.a("oldAi");
                    this.bl();
                    this.world.methodProfiler.b();
                    this.aP = this.yaw;
                }
            }
    
            this.world.methodProfiler.b();
            this.world.methodProfiler.a("jump");
            if (this.bd) {
                if (!this.H() && !this.J()) {
                    if (this.onGround && bqField.getInt(this) == 0) {
                        this.be();
                        bqField.set(this, 10);
                    }
                } else {
                    this.motY += 0.03999999910593033D;
                }
            } else {
                bqField.set(this, 0);
            }
    
            this.world.methodProfiler.b();
            this.world.methodProfiler.a("travel");
            this.be *= 0.98F;
            this.bf *= 0.98F;
            this.bg *= 0.9F;
            this.e(this.be, this.bf);
            this.world.methodProfiler.b();
            this.world.methodProfiler.a("push");
            if (!this.world.isStatic) {
                this.bj();
            }
    
            this.world.methodProfiler.b();
            
            this.world.methodProfiler.a("looting");
            if (!this.world.isStatic && this.bD() && !this.aU && this.world.getGameRules().getBoolean("mobGriefing")) {
                List list = this.world.a(EntityItem.class, this.boundingBox.grow(1.0D, 0.0D, 1.0D));
                Iterator iterator = list.iterator();
    
                while (iterator.hasNext()) {
                    EntityItem entityitem = (EntityItem) iterator.next();
    
                    if (!entityitem.dead && entityitem.getItemStack() != null) {
                        ItemStack itemstack = entityitem.getItemStack();
                        int i = b(itemstack);
    
                        if (i > -1) {
                            boolean flag = true;
                            ItemStack itemstack1 = this.getEquipment(i);
    
                            if (itemstack1 != null) {
                                if (i == 0) {
                                    if (itemstack.getItem() instanceof ItemSword && !(itemstack1.getItem() instanceof ItemSword)) {
                                        flag = true;
                                    } else if (itemstack.getItem() instanceof ItemSword && itemstack1.getItem() instanceof ItemSword) {
                                        ItemSword itemsword = (ItemSword) itemstack.getItem();
                                        ItemSword itemsword1 = (ItemSword) itemstack1.getItem();
    
                                        if (itemsword.g() == itemsword1.g()) {
                                            flag = itemstack.getData() > itemstack1.getData() || itemstack.hasTag() && !itemstack1.hasTag();
                                        } else {
                                            flag = itemsword.g() > itemsword1.g();
                                        }
                                    } else {
                                        flag = false;
                                    }
                                } else if (itemstack.getItem() instanceof ItemArmor && !(itemstack1.getItem() instanceof ItemArmor)) {
                                    flag = true;
                                } else if (itemstack.getItem() instanceof ItemArmor && itemstack1.getItem() instanceof ItemArmor) {
                                    ItemArmor itemarmor = (ItemArmor) itemstack.getItem();
                                    ItemArmor itemarmor1 = (ItemArmor) itemstack1.getItem();
    
                                    if (itemarmor.c == itemarmor1.c) {
                                        flag = itemstack.getData() > itemstack1.getData() || itemstack.hasTag() && !itemstack1.hasTag();
                                    } else {
                                        flag = itemarmor.c > itemarmor1.c;
                                    }
                                } else {
                                    flag = false;
                                }
                            }
    
                            if (flag) {
                                if (itemstack1 != null && this.random.nextFloat() - 0.1F < this.dropChances[i]) {
                                    this.a(itemstack1, 0.0F);
                                }
    
                                this.setEquipment(i, itemstack);
                                this.dropChances[i] = 2.0F;
                                this.persistent = true;
                                this.receive(entityitem, 1);
                                entityitem.die();
                            }
                        }
                    }
                }
            }
    
            this.world.methodProfiler.b();
            
            if(!this.isTamed()){
                if (this.G()) {
                    this.damageEntity(DamageSource.DROWN, 1.0F);
                }
        
                int i = MathHelper.floor(this.locX);
                int j = MathHelper.floor(this.locZ);
        
                if (this.world.getBiome(i, j).j() > 1.0F) {
                    this.damageEntity(DamageSource.BURN, 1.0F);
                }
        
                for (i = 0; i < 4; ++i) {
                    j = MathHelper.floor(this.locX + (i % 2 * 2 - 1) * 0.25F);
                    int k = MathHelper.floor(this.locY);
                    int l = MathHelper.floor(this.locZ + (i / 2 % 2 * 2 - 1) * 0.25F);
        
                    if (this.world.getTypeId(j, k, l) == 0 && this.world.getBiome(j, l).j() < 0.8F && Block.SNOW.canPlace(this.world, j, k, l)) {
                        this.world.setTypeIdUpdate(j, k, l, Block.SNOW.id);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    
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
