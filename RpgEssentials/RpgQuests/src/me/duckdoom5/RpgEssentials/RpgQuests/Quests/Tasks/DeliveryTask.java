package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.NPC;

public class DeliveryTask extends Task{
	private static final long serialVersionUID = 6742134736658846848L;
	private int amount;
	private Material material;
	private short durability;
	private NPC deliverTo;
	
	public HashMap<RpgPlayer, Integer> remaining = new HashMap<RpgPlayer, Integer>();
	
	public DeliveryTask(int id, Material material, int amount, NPC taskGiver, NPC deliverTo, NPC taskEnder) {
		super(id, TaskType.DELIVER, taskGiver, taskEnder);
		
		this.amount = amount;
		this.deliverTo = deliverTo;
		this.material = material;
	}
	
	public DeliveryTask(int id, Material material, int amount, short durability, NPC deliverTo, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.DELIVER, taskGiver, taskEnder);
		
		this.amount = amount;
		this.deliverTo = deliverTo;
		this.material = material;
		this.durability = durability;
	}
	
	public DeliveryTask(int id, ItemStack material, NPC deliverTo, NPC taskGiver, NPC taskEnder) {
		super(id, TaskType.DELIVER, taskGiver, taskEnder);
		
		this.amount = material.getAmount();
		this.deliverTo = deliverTo;
		this.material = material.getType();
		this.durability = material.getDurability();
	}
	
	public NPC getNpcToDeliverTo(){
		return deliverTo;
	}
	
	public void setNpcToDeliverTo(NPC deliverTo){
		this.deliverTo = deliverTo;
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
