package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.Arrays;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.levels.Cooking;
import me.duckdoom5.RpgEssentials.levels.Smithing;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RpgEssentialsInventoryListener implements Listener{

	public static RpgEssentials plugin;
	private String skilltype = "null";
	
	public RpgEssentialsInventoryListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	/*@EventHandler
	public void onCraftItemEvent(CraftItemEvent event){
		Player player = (Player) event.getWhoClicked();
		player.sendMessage("test");//doesn't fire ?
		if(Configuration.modules.getBoolean("Modules.leveling") && RpgEssentialsWorldListener.worlds.get(player.getWorld())){
			Recipe recipe = event.getRecipe();
			ItemStack result = recipe.getResult();
			int amount = result.getAmount();
			if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
		    	if(player.getGameMode() == GameMode.SURVIVAL){
		    		String skill = getSkill(result);
					if(skill == "Cooking"){
						Cooking.blockcheck(result, player, amount, plugin);
					}else if(skill == "Smithing"){
						Smithing.blockcheck(result, player, amount, plugin);
					}
		    	}
			}else{
				String skill = getSkill(result);
				if(skill == "Cooking"){
					Cooking.blockcheck(result, player, amount, plugin);
				}else if(skill == "Smithing"){
					Smithing.blockcheck(result, player, amount, plugin);
				}
			}
		}
	}*/
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		if(Configuration.modules.getBoolean("Modules.leveling") && RpgEssentialsWorldListener.worlds.get(player.getWorld())){
			SlotType slottype = event.getSlotType();
			ItemStack cursor = event.getCursor();
			ItemStack result = event.getCurrentItem();
			if(result != null){
				int amount = result.getAmount();
				if(slottype == SlotType.RESULT){
					if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
				    	if(player.getGameMode() == GameMode.SURVIVAL){
							try{
								if(!Methods.isTool(cursor.getType())){
									if(!(cursor.getAmount() == 64)){
										try{
											String skill = getSkill(result);
											if(skill == "Cooking"){
												Cooking.blockcheck(result, player, amount, plugin);
											}else if(skill == "Smithing"){
												Smithing.blockcheck(result, player, amount, plugin);
											}
										}catch(Exception e){}
									}
								}
							}catch(Exception e){
								try{
									String skill = getSkill(result);
									if(skill == "Cooking"){
										Cooking.blockcheck(result, player, amount, plugin);
									}else if(skill == "Smithing"){
										Smithing.blockcheck(result, player, amount, plugin);
									}
								}catch(Exception ex){}
							}
				    	}
					}else{
						try{
							if(!Methods.isTool(cursor.getType())){
								if(!(cursor.getAmount() == 64)){
									try{
										String skill = getSkill(result);
										if(skill == "Cooking"){
											Cooking.blockcheck(result, player, amount, plugin);
										}else if(skill == "Smithing"){
											Smithing.blockcheck(result, player, amount, plugin);
										}
									}catch(Exception e){}
								}
							}
						}catch(Exception e){
							try{
								String skill = getSkill(result);
								if(skill == "Cooking"){
									Cooking.blockcheck(result, player, amount, plugin);
								}else if(skill == "Smithing"){
									Smithing.blockcheck(result, player, amount, plugin);
								}
							}catch(Exception ex){}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();
		
		if(inventory.getName() == "Bank"){
			
			ItemStack[] items = inventory.getContents();
			
			String[] set = new String[items.length];
			for(int counter = 0; counter < items.length; counter++){
				if(items[counter] == null){
					set[counter] = "0:-1:0";
				}else{
					int amount = items[counter].getAmount();
					int id = items[counter].getType().getId();
					short data = items[counter].getDurability();
					set[counter] = Integer.toString(id) + ":" + Integer.toString(data) + ":" + Integer.toString(amount);
				}
			}
			
			Configuration.bank.set("Bank." + player.getName() + ".items", Arrays.asList(set));
			
			try {
				Configuration.bank.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getSkill(ItemStack result) {
		if((result.getType() == Material.GOLDEN_APPLE) || (result.getType() == Material.BREAD) || (result.getType() == Material.MUSHROOM_SOUP) || (result.getType() == Material.CAKE) || (result.getType() == Material.COOKED_BEEF) || (result.getType() == Material.COOKED_CHICKEN) || (result.getType() == Material.COOKED_FISH) || (result.getType() == Material.GRILLED_PORK)){
			skilltype = "Cooking";
		}else if((result.getType() == Material.WOOD_AXE) || (result.getType() == Material.WOOD_HOE) || (result.getType() == Material.WOOD_PICKAXE) || (result.getType() == Material.WOOD_SPADE) || (result.getType() == Material.WOOD_SWORD) || (result.getType() == Material.STONE_AXE) || (result.getType() == Material.STONE_HOE) || (result.getType() == Material.STONE_PICKAXE) || (result.getType() == Material.STONE_SPADE) || (result.getType() == Material.STONE_SWORD) || (result.getType() == Material.IRON_AXE) || (result.getType() == Material.IRON_HOE) || (result.getType() == Material.IRON_PICKAXE) || (result.getType() == Material.IRON_SPADE) || (result.getType() == Material.IRON_SWORD) || (result.getType() == Material.GOLD_AXE) || (result.getType() == Material.GOLD_HOE) || (result.getType() == Material.GOLD_PICKAXE) || (result.getType() == Material.GOLD_SPADE) || (result.getType() == Material.GOLD_SWORD) || (result.getType() == Material.DIAMOND_AXE) || (result.getType() == Material.DIAMOND_HOE) || (result.getType() == Material.DIAMOND_PICKAXE) || (result.getType() == Material.DIAMOND_SPADE) || (result.getType() == Material.DIAMOND_SWORD) || (result.getType() == Material.IRON_INGOT) || (result.getType() == Material.CLAY_BRICK) || (result.getType() == Material.GOLD_INGOT)){
			skilltype = "Smithing";
		}
		return skilltype;
	}
}
