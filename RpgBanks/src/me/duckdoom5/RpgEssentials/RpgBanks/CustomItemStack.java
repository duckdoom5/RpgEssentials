package me.duckdoom5.RpgEssentials.RpgBanks;

import java.io.Serializable;

import org.bukkit.inventory.ItemStack;

public class CustomItemStack implements Serializable{
	private static final long serialVersionUID = 4591970773275136800L;
	private int material;
	private int amount;
	private short durability;
	
	public CustomItemStack(ItemStack itemStack) {
		this.material = itemStack.getTypeId();
		this.amount = itemStack.getAmount();
		this.durability = itemStack.getDurability();
	}
	
	public CustomItemStack(int material, int amount, short durability) {
		this.material = material;
		this.amount = amount;
		this.durability = durability;
	}
	
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public short getDurability() {
		return durability;
	}
	public void setDamage(short damage) {
		this.durability = damage;
	}
}
