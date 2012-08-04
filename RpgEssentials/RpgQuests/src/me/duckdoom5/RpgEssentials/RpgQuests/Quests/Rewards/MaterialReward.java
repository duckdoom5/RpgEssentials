package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.NPC;

public class MaterialReward extends Reward{
	private int amount;
	private Material material;
	private short durability = 0;
	
	public HashMap<Player, ItemStack> remaining = new HashMap<Player, ItemStack>();
	
	public MaterialReward(Material material, int amount, NPC rewardGiver) {
		super(RewardType.XP, rewardGiver);
		
		this.amount = amount;
		this.material = material;
	}
	
	public MaterialReward(Material material, int amount, short durability, NPC rewardGiver) {
		super(RewardType.XP, rewardGiver);
		
		this.amount = amount;
		this.material = material;
		this.durability = durability;
	}
	
	public MaterialReward(ItemStack material, NPC rewardGiver) {
		super(RewardType.XP, rewardGiver);
		
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
