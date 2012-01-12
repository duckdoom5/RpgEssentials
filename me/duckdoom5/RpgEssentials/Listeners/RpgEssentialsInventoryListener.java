package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.levels.Cooking;
import me.duckdoom5.RpgEssentials.levels.Smithing;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;
import org.getspout.spoutapi.event.inventory.InventoryCraftEvent;
import org.getspout.spoutapi.event.inventory.InventoryListener;
import org.getspout.spoutapi.event.inventory.InventorySlotType;

public class RpgEssentialsInventoryListener extends InventoryListener{

	public static RpgEssentials plugin;
	private String skilltype;
	
	public RpgEssentialsInventoryListener(RpgEssentials instance) {
        plugin = instance; 
    }

	public void onInventoryCraft(InventoryCraftEvent event){
		Player player = event.getPlayer();
		player.sendMessage("Craft");
		ItemStack result = event.getResult();
		if(getSkill(result) == "Cooking"){
			Cooking.blockcheck(result, player);
		}else if(getSkill(result) == "Smithing"){
			Smithing.blockcheck(result, player);
		}
	}
	public void onInventoryClick(InventoryClickEvent event){
		InventorySlotType slottype = event.getSlotType();
		ItemStack cursor = event.getCursor();
		if(slottype == InventorySlotType.SMELTING){
			if(cursor != null){
				Bukkit.broadcastMessage(Short.toString(event.getItem().getDurability()));
			}
		}
	}
	private String getSkill(ItemStack result) {
		if((result.getType() == Material.GOLDEN_APPLE) || (result.getType() == Material.BREAD) || (result.getType() == Material.MUSHROOM_SOUP)){
			skilltype = "Cooking";
		}else if((result.getType() == Material.WOOD_AXE) || (result.getType() == Material.WOOD_HOE) || (result.getType() == Material.WOOD_PICKAXE) || (result.getType() == Material.WOOD_SPADE) || (result.getType() == Material.WOOD_SWORD) || (result.getType() == Material.STONE_AXE) || (result.getType() == Material.STONE_HOE) || (result.getType() == Material.STONE_PICKAXE) || (result.getType() == Material.STONE_SPADE) || (result.getType() == Material.STONE_SWORD) || (result.getType() == Material.IRON_AXE) || (result.getType() == Material.IRON_HOE) || (result.getType() == Material.IRON_PICKAXE) || (result.getType() == Material.IRON_SPADE) || (result.getType() == Material.IRON_SWORD) || (result.getType() == Material.GOLD_AXE) || (result.getType() == Material.GOLD_HOE) || (result.getType() == Material.GOLD_PICKAXE) || (result.getType() == Material.GOLD_SPADE) || (result.getType() == Material.GOLD_SWORD) || (result.getType() == Material.DIAMOND_AXE) || (result.getType() == Material.DIAMOND_HOE) || (result.getType() == Material.DIAMOND_PICKAXE) || (result.getType() == Material.DIAMOND_SPADE) || (result.getType() == Material.DIAMOND_SWORD)){
			skilltype = "Smithing";
		}
		return skilltype;
	}
}
