package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MaterialReward extends Reward{
	private static final long serialVersionUID = 6716573988825724717L;
	private Material material;
	private short durability = 0;
	
	public HashMap<Player, ItemStack> remaining = new HashMap<Player, ItemStack>();
	
	public MaterialReward(Material material, int amount, String rewardGiver) {
		super(RewardType.XP, rewardGiver, amount);
		
		this.material = material;
	}
	
	public MaterialReward(Material material, int amount, short durability, String rewardGiver) {
		super(RewardType.MATERIAL, rewardGiver, amount);
		
		this.material = material;
		this.durability = durability;
	}
	
	public MaterialReward(ItemStack material, String rewardGiver) {
		super(RewardType.XP, rewardGiver, material.getAmount());
		
		this.material = material.getType();
		this.durability = material.getDurability();
	}
	
	public Material getMaterial(){
		return material;
	}
	
	public short getDurability(){
		return durability;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public void setDurability(short durability) {
		this.durability = durability;
	}
}
