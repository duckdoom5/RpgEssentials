package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import org.bukkit.Bukkit;
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
import net.minecraft.server.v1_6_R3.EntityHuman;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntitySquid;
import net.minecraft.server.v1_6_R3.Item;
import net.minecraft.server.v1_6_R3.ItemStack;
import net.minecraft.server.v1_6_R3.World;

public class SquidRpg extends EntitySquid implements EntityRpg {

    private static int lureItem = Item.INK_SACK.id;
    private EntityLiving owner;
    private boolean sitting;
    private boolean tamed;
    
    public SquidRpg(World world) {
        super(world);
        this.goalSelector.a(1, new PathfinderGoalFollowOwner2(this, 1.0D, 10.0F, 2.0F));
    }
    
    @Override
    public boolean a(EntityHuman entityhuman) {
        ItemStack itemstack = entityhuman.inventory.getItemInHand();
        
        if (itemstack != null && itemstack.id == lureItem && !this.isTamed()) {
            boolean canTame = true;
            if(RpgEntities.isLevelEnabled()){
                RpgPlayerLevel pl = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(entityhuman.getName());
                if(pl.getLvl(SkillType.TAMING) < Taming.instance.getUnlockLevel(SkillType.TAMING, new SpawnEgg(EntityType.BAT))){
                    canTame = false;
                }
            }
            if(canTame){
                if (!this.world.isStatic) {
                    if (this.random.nextInt(3) == 0) {
                        if (!entityhuman.abilities.canInstantlyBuild) {
                            if(RpgEntities.isLevelEnabled()){
                                final PlayerExpGainEvent callevent = new PlayerExpGainEvent((Player) entityhuman.getBukkitEntity(), SkillType.FARMING, Taming.instance.getXp(EntityType.BAT));
                                Bukkit.getServer().getPluginManager().callEvent(callevent);
                            }
                            --itemstack.count;
                        }
                        
                        if (itemstack.count <= 0) {
                            entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack) null);
                        }
                        
                        this.setTamed(true);
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
