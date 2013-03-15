package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import net.minecraft.server.v1_4_R1.Block;
import net.minecraft.server.v1_4_R1.EntityChicken;
import net.minecraft.server.v1_4_R1.World;

import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_4_R1.event.CraftEventFactory;

public class ChickenRpg extends EntityChicken implements EntityRpg{

	public ChickenRpg(World world) {
		super(world);
	}

	public void echo(){
		System.out.println("I'm a ChickenRpg");
	}
	
	public void setBukkitEntity(org.bukkit.entity.Entity entity) {
		bukkitEntity = (CraftEntity) entity;
	}
	
	@Override
	public void move(double x, double y, double z) {
		setPosition(x, y, z);
	}
	
	public void dropDeathLoot(boolean flag, int i) {
        java.util.List<org.bukkit.inventory.ItemStack> loot = new java.util.ArrayList<org.bukkit.inventory.ItemStack>();
        int j = this.random.nextInt(3) + this.random.nextInt(1 + i);

        if (j > 0) {
            loot.add(new org.bukkit.inventory.ItemStack(Block.ICE.id, j));
        }

        /*if (this.isBurning()) {
            loot.add(new org.bukkit.inventory.ItemStack(Item.COOKED_CHICKEN.id, 1));
        } else {
            loot.add(new org.bukkit.inventory.ItemStack(Item.RAW_CHICKEN.id, 1));
        }*/

        CraftEventFactory.callEntityDeathEvent(this, loot);
    }
}
