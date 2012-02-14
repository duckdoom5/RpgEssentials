package me.duckdoom5.RpgEssentials.Listeners;


import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class RpgEssentialsFurnaceListener implements Listener{

	public static RpgEssentials plugin;
	private String skilltype;
	
	public RpgEssentialsFurnaceListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onFurnaceSmelt(FurnaceSmeltEvent event){
		Player player;
		/*Iterator<Player> iter = event.getFurnace().getWorld().getPlayers().iterator();
		while(iter.hasNext()){
			if(iter.next().getLocation() == event.getFurnace().getFace(arg0){
				player = iter.next();
			}
		}*/
		/*ItemStack result = event.getResult();
		if(getSkill(result) == "Cooking"){
			Cooking.blockcheck(result, player);
		}else if(getSkill(result) == "Smithing"){
			Smithing.blockcheck(result, player);
		}*/
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
