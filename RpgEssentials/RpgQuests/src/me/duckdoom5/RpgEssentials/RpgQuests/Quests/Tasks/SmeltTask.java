package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.NPC;

public class SmeltTask extends Task{
	private int amount;
	private Material material;
	private short durability;
	private int id;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public SmeltTask(int id, Material material, int amount, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.SMELT, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
		this.id = id;
	}
	
	public SmeltTask(int id, Material material, int amount, short durability, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.SMELT, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
		this.durability = durability;
		this.id = id;
	}
	
	public SmeltTask(int id, ItemStack material, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.SMELT, taskGiver, taskEnder);
		
		this.amount = material.getAmount();
		this.material = material.getType();
		this.durability = material.getDurability();
		this.id = id;
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
