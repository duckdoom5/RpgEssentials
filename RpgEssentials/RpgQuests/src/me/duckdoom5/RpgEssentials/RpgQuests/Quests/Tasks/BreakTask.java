package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BreakTask extends Task{
	private static final long serialVersionUID = -3155061563479929671L;
	private int amount;
	private Material material;
	private short durability;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public BreakTask(int id, Material material, int amount) {
		super(id, TaskType.BREAK);
		
		this.amount = amount;
		this.material = material;
	}
	
	public BreakTask(int id, Material material, int amount, short durability) {
		super(id, TaskType.BREAK);
		
		this.amount = amount;
		this.material = material;
		this.durability = durability;
	}
	
	public BreakTask(int id, ItemStack material) {
		super(id, TaskType.BREAK);
		
		this.amount = material.getAmount();
		this.material = material.getType();
		this.durability = material.getDurability();
	}
	
	public BreakTask(int id, Material material, int amount, String taskGiver, String taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
	}
	
	public BreakTask(int id, Material material, int amount, short durability, String taskGiver, String taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
		this.durability = durability;
	}
	
	public BreakTask(int id, ItemStack material, String taskGiver, String taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = material.getAmount();
		this.material = material.getType();
		this.durability = material.getDurability();
	}
	
	public int getAmount(){
		return amount;
	}
	
	public Material getMaterial(){
		return material;
	}
	
	public int getDurability(){
		return durability;
	}
	
	public void setMaterial(Material material){
		this.material = material;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public void setMaterial(ItemStack material){
		this.material = material.getType();
		this.amount = material.getAmount();
		this.durability = material.getDurability();
	}
}
