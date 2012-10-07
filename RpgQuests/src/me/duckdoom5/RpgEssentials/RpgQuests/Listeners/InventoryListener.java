package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener{
	public static void InventoryClick(InventoryClickEvent event){
		boolean run2 = false;
		Player player = (Player) event.getWhoClicked();
		SlotType slottype = event.getSlotType();
		ItemStack cursor = event.getCursor();
		ItemStack result = event.getCurrentItem();
		if(slottype == SlotType.RESULT){
			if(result != null){
				int amount = result.getAmount();
				try{
					if(!Methods.isTool(cursor.getType())){
						if(!(cursor.getAmount() == 64)){
							try{
								String skill = getSkill(result);
								if(skill == "craft"){
									for(int count = 0; count < amount; count++){
										RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
										RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.CRAFT, event);
										
										//QuestOld.run(player, "craft", result.getType());
									}
								}else if(skill == "smelt"){
									for(int count = 0; count < amount; count++){
										RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
										RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.SMELT, event);
										
										//QuestOld.run(player, "smelt", result.getType());
									}
								}
							}catch(Exception e){}
						}
					}
				}catch(Exception e){
					try{
						String skill = getSkill(result);
						if(skill == "craft"){
							for(int count = 0; count < amount; count++){
								RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
								RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.CRAFT, event);
								
								//QuestOld.run(player, "craft", result.getType());
							}
						}else if(skill == "smelt"){
							for(int count = 0; count < amount; count++){
								RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
								RpgQuests.qh.startQuestCheck(rpgplayer, TaskType.SMELT, event);
								
								//QuestOld.run(player, "smelt", result.getType());
							}
						}
					}catch(Exception ex){}
				}
			}
		}
		if(run2){
			
		}
	}
	private static String getSkill(ItemStack result) {
		String skilltype = null;
		if((result.getType() == Material.IRON_INGOT) || (result.getType() == Material.CLAY_BRICK) || (result.getType() == Material.GOLD_INGOT)){
			skilltype = "smelt";
		}else{
			skilltype = "craft";
		}
		return skilltype;
	}
}
