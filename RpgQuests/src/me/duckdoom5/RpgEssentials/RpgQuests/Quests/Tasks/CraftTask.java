package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CraftTask extends Task {
    private static final long serialVersionUID = -2564506788842268665L;
    private int amount;
    private Material material;
    private short durability;

    public HashMap<RpgPlayer, Integer> remaining = new HashMap<>();

    public CraftTask(int id, Material material, int amount, String taskGiver,
            String taskEnder) {
        super(id, TaskType.CRAFT, taskGiver, taskEnder);

        this.amount = amount;
        this.material = material;
    }

    public CraftTask(int id, Material material, int amount, short durability,
            String taskGiver, String taskEnder) {
        super(id, TaskType.CRAFT, taskGiver, taskEnder);

        this.amount = amount;
        this.material = material;
        this.durability = durability;
    }

    public CraftTask(int id, ItemStack material, String taskGiver,
            String taskEnder) {
        super(id, TaskType.CRAFT, taskGiver, taskEnder);

        amount = material.getAmount();
        this.material = material.getType();
        durability = material.getDurability();
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
