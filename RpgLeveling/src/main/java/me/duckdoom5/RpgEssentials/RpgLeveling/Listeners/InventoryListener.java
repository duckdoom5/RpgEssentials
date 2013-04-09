package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Cooking;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Defense;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Smithing;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InventoryListener implements Listener{
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		if(RpgEssentials.wl.worlds.get(player.getWorld())){
			SlotType slottype = event.getSlotType();
			ItemStack cursor = event.getCursor();
			ItemStack result = event.getCurrentItem();
			if(slottype == SlotType.RESULT){
				if(result != null){
					int amount = result.getAmount();
					try{
						if(!Methods.isTool(cursor.getType())){
							if(!(cursor.getAmount() == 64)){
								Skill skill = getSkill(result);
								if(skill == Skill.COOKING){
									int exp = Cooking.getXp(result, amount);
									PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
									Bukkit.getServer().getPluginManager().callEvent(callevent);
								}else if(skill == Skill.SMITHING){
									int exp = Smithing.getXp(result, amount);
									PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
									Bukkit.getServer().getPluginManager().callEvent(callevent);
								}
							}
						}
					}catch(Exception e){
						Skill skill = getSkill(result);
						if(skill == Skill.COOKING){
							int exp = Cooking.getXp(result, amount);
							PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
							Bukkit.getServer().getPluginManager().callEvent(callevent);
						}else if(skill == Skill.SMITHING){
							int exp = Smithing.getXp(result, amount);
							PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
							Bukkit.getServer().getPluginManager().callEvent(callevent);
						}
					}
				}
			}else if(slottype == SlotType.ARMOR){
				if(!Defense.canUse(RpgEssentials.pm.getRpgPlayer(player), cursor.getType())){
					splayer.sendNotification("Error!", "Check your chat box", cursor.getType());
					player.sendMessage(ChatColor.RED + "You can only wear " + cursor.getType().toString().toLowerCase().replace("_", " ") + " on level " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + cursor.getType().toString().toLowerCase().replace("_", " ")));
					event.setCancelled(true);
				}
			}
		}
	}
	
	public static Skill getSkill(ItemStack result) {
		if((result.getType() == Material.GOLDEN_APPLE) || (result.getType() == Material.BREAD) || (result.getType() == Material.MUSHROOM_SOUP) || (result.getType() == Material.CAKE) || (result.getType() == Material.COOKED_BEEF) || (result.getType() == Material.COOKED_CHICKEN) || (result.getType() == Material.COOKED_FISH) || (result.getType() == Material.GRILLED_PORK)){
			return Skill.COOKING;
		}else if((result.getType() == Material.WOOD_AXE) || (result.getType() == Material.WOOD_HOE) || (result.getType() == Material.WOOD_PICKAXE) || (result.getType() == Material.WOOD_SPADE) || (result.getType() == Material.WOOD_SWORD) || (result.getType() == Material.STONE_AXE) || (result.getType() == Material.STONE_HOE) || (result.getType() == Material.STONE_PICKAXE) || (result.getType() == Material.STONE_SPADE) || (result.getType() == Material.STONE_SWORD) || (result.getType() == Material.IRON_AXE) || (result.getType() == Material.IRON_HOE) || (result.getType() == Material.IRON_PICKAXE) || (result.getType() == Material.IRON_SPADE) || (result.getType() == Material.IRON_SWORD) || (result.getType() == Material.GOLD_AXE) || (result.getType() == Material.GOLD_HOE) || (result.getType() == Material.GOLD_PICKAXE) || (result.getType() == Material.GOLD_SPADE) || (result.getType() == Material.GOLD_SWORD) || (result.getType() == Material.DIAMOND_AXE) || (result.getType() == Material.DIAMOND_HOE) || (result.getType() == Material.DIAMOND_PICKAXE) || (result.getType() == Material.DIAMOND_SPADE) || (result.getType() == Material.DIAMOND_SWORD) || (result.getType() == Material.IRON_INGOT) || (result.getType() == Material.CLAY_BRICK) || (result.getType() == Material.GOLD_INGOT)){
			return Skill.SMITHING;
		}
		return null;
	}
}
