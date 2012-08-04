package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.NPC;

public class BreakTask extends Task{
	private int amount;
	private Material material;
	private short durability;
	private int id;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public BreakTask(int id, Material material, int amount) {
		super(id, TaskType.BREAK);
		
		this.amount = amount;
		this.id = id;
		this.material = material;
	}
	
	public BreakTask(int id, Material material, int amount, short durability) {
		super(id, TaskType.BREAK);
		
		this.amount = amount;
		this.id = id;
		this.material = material;
		this.durability = durability;
	}
	
	public BreakTask(int id, ItemStack material) {
		super(id, TaskType.BREAK);
		
		this.amount = material.getAmount();
		this.id = id;
		this.material = material.getType();
		this.durability = material.getDurability();
	}
	
	public BreakTask(int id, Material material, int amount, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = amount;
		this.id = id;
		this.material = material;
	}
	
	public BreakTask(int id, Material material, int amount, short durability, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = amount;
		this.id = id;
		this.material = material;
		this.durability = durability;
	}
	
	public BreakTask(int id, ItemStack material, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.BREAK, taskGiver, taskEnder);
		
		this.amount = material.getAmount();
		this.id = id;
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
	
	public int getId(){
		return id;
	}
}