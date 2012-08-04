package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.NPC;

public class PlaceTask extends Task{
	private int amount;
	private Material material;
	private short durability;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public PlaceTask(int id, Material material, int amount, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.PLACE, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
	}
	
	public PlaceTask(int id, Material material, int amount, short durability, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.PLACE, taskGiver, taskEnder);
		
		this.amount = amount;
		this.material = material;
		this.durability = durability;
	}
	
	public PlaceTask(int id, ItemStack material, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.PLACE, taskGiver, taskEnder);
		
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
	
	public short getDurability(){
		return durability;
	}
}
