package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.levels.Cooking;
import me.duckdoom5.RpgEssentials.levels.Smithing;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.event.inventory.InventoryClickEvent;
import org.getspout.spoutapi.event.inventory.InventoryCraftEvent;
import org.getspout.spoutapi.event.inventory.InventorySlotType;

public class RpgEssentialsInventoryListener implements Listener{

	public static RpgEssentials plugin;
	static YamlConfiguration levelconfig = new YamlConfiguration();
	private String skilltype;
	
	public RpgEssentialsInventoryListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onInventoryCraft(InventoryCraftEvent event){
		try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		Player player = event.getPlayer();
		ItemStack result = event.getResult();
		int amount = result.getAmount();
		if(levelconfig.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL){
				if(getSkill(result) == "Cooking"){
					Cooking.blockcheck(result, player, amount, plugin);
				}else if(getSkill(result) == "Smithing"){
					Smithing.blockcheck(result, player, amount, plugin);
				}
	    	}
		}else{
			if(getSkill(result) == "Cooking"){
				Cooking.blockcheck(result, player, amount, plugin);
			}else if(getSkill(result) == "Smithing"){
				Smithing.blockcheck(result, player, amount, plugin);
			}
		}
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		InventorySlotType slottype = event.getSlotType();
		ItemStack cursor = event.getCursor();
		Player player = event.getPlayer();
		ItemStack result = event.getItem();
		int amount = result.getAmount();
		try{
			if(cursor.getType() == result.getType()){
			}else{
				if(slottype == InventorySlotType.RESULT){
					if(levelconfig.getBoolean("Survival Gamemode Required") == true){
				    	if(player.getGameMode() == GameMode.SURVIVAL){
							try{
							Cooking.blockcheck(result, player, amount, plugin);
							}catch(Exception e){}
				    	}
					}else{
						try{
						Cooking.blockcheck(result, player, amount, plugin);
						}catch(Exception e){}
					}
				}
			}
		}catch(Exception e){
			if(slottype == InventorySlotType.RESULT){
				if(levelconfig.getBoolean("Survival Gamemode Required") == true){
			    	if(player.getGameMode() == GameMode.SURVIVAL){
						try{
						Cooking.blockcheck(result, player, amount, plugin);
						}catch(Exception ex){}
			    	}
				}else{
					try{
					Cooking.blockcheck(result, player, amount, plugin);
					}catch(Exception ex){}
				}
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
