package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DeliveryTask extends Task {
    private static final long serialVersionUID = 6742134736658846848L;
    private int amount;
    private Material material;
    private short durability;
    private String deliverTo;

    public HashMap<RpgPlayer, Integer> remaining = new HashMap<>();

    public DeliveryTask(int id, Material material, int amount,
            String taskGiver, String deliverTo, String taskEnder) {
        super(id, TaskType.DELIVER, taskGiver, taskEnder);

        this.amount = amount;
        this.deliverTo = deliverTo;
        this.material = material;
    }

    public DeliveryTask(int id, Material material, int amount,
            short durability, String deliverTo, String taskGiver,
            String taskEnder) {
        super(id, TaskType.DELIVER, taskGiver, taskEnder);

        this.amount = amount;
        this.deliverTo = deliverTo;
        this.material = material;
        this.durability = durability;
    }

    public DeliveryTask(int id, ItemStack material, String deliverTo,
            String taskGiver, String taskEnder) {
        super(id, TaskType.DELIVER, taskGiver, taskEnder);

        amount = material.getAmount();
        this.deliverTo = deliverTo;
        this.material = material.getType();
        durability = material.getDurability();
    }

    public String getNpcToDeliverTo() {
        return deliverTo;
    }

    public void setNpcToDeliverTo(String deliverTo) {
        this.deliverTo = deliverTo;
    }

    public int getAmount() {
        return amount;
    }

    public Material getMaterial() {
        return material;
    }

    public int getDurability() {
        return durability;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMaterial(ItemStack material) {
        this.material = material.getType();
        amount = material.getAmount();
        durability = material.getDurability();
    }
}
