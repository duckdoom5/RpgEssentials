package me.duckdoom5.RpgEssentials.RpgLeveling;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public enum Skill {
	ATTACK(Material.DIAMOND_SWORD, new String[]{"WOOD_SWORD", "STONE_SWORD", "IRON_SWORD", "GOLD_SWORD", "DIAMOND_SWORD"}),
	DEFENSE(Material.DIAMOND_CHESTPLATE, new String[]{"LEATHER_HELMET", "LEATHER_CHESTPLATE", "LEATHER_LEGGINGS", "LEATHER_BOOTS", "GOLD_HELMET", "GOLD_CHESTPLATE", "GOLD_LEGGINGS", "GOLD_BOOTS", "CHAINMAIL_HELMET", "CHAINMAIL_CHESTPLATE", "CHAINMAIL_LEGGINGS", "CHAINMAIL_BOOTS", "IRON_HELMET", "IRON_CHESTPLATE", "IRON_LEGGINGS", "IRON_BOOTS", "DIAMOND_HELMET", "DIAMOND_CHESTPLATE", "DIAMOND_LEGGINGS", "DIAMOND_BOOTS"}),
	STRENGTH(Material.SULPHUR, new String[]{}),
	RANGED(Material.BOW, new String[]{}),
	MAGIC(Material.ENDER_PEARL, new String[]{}),
	PRAYER(Material.TORCH, new String[]{}),
	CONSTRUCTION(Material.WOOD_DOOR, new String[]{}),
	COOKING(Material.CAKE, new String[]{}),
	EXCAVATION(Material.DIAMOND_SPADE, new String[]{"WOOD_SPADE", "STONE_SPADE", "IRON_SPADE", "GOLD_SPADE", "DIAMOND_SPADE"}),
	FARMING(Material.DIAMOND_HOE, new String[]{"WOOD_HOE", "STONE_HOE", "IRON_HOE", "GOLD_HOE", "DIAMOND_HOE"}),
	MINING(Material.DIAMOND_PICKAXE, new String[]{"WOOD_PICKAXE", "STONE_PICKAXE", "IRON_PICKAXE", "GOLD_PICKAXE", "DIAMOND_PICKAXE"}),
	WOODCUTTING(Material.DIAMOND_AXE, new String[]{"WOOD_AXE", "STONE_AXE", "IRON_AXE", "GOLD_AXE", "DIAMOND_AXE"}),
	FISHING(Material.FISHING_ROD, getFishing()),
	FIREMAKING(Material.FLINT_AND_STEEL, new String[]{}),
	SMITHING(Material.IRON_INGOT, new String[]{}),
	COMBAT(Material.DIAMOND_SWORD, new String[]{}),
	QUESTING(Material.BOOK, new String[]{});
	
	private Material material;
	private String[] items;
	
	Skill(Material material, String[] items){
		this.material = material;
		this.items = items;
	}
	
	public Material getMaterial(){
		return this.material;
	}
	
	public String[] getItems(){
		return items;
	}
	
	private static String[] getFishing(){
		String[] Fishing = new String[RpgEssentials.mm.getFishSize()];
		int counter = 0; 
		for(GenericCustomItem fish: RpgEssentials.mm.getFish()){
			Fishing[counter] = fish.getName();
			counter++;
		}
		return Fishing;
	}
}


