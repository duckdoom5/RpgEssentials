package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import java.util.Iterator;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

public class Ranged {
	static Skill skill =  Skill.RANGED;
	//public static int getXp(FireBoltEvent event, RpgEssentials plugin){
		
	//}
	
	public static boolean canUse(RpgPlayer player, String crossbow){
		if(crossbow != null && Configuration.level.getBoolean("Enabled." + skill.toString())){
			int currentlvl = player.getLvl(skill);
			int level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Tools." + crossbow + ".level");
			if(currentlvl < level){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public static String[] getRequiredBolts(String crossbow){
		if(me.duckdoom5.RpgEssentials.config.Configuration.items.contains("Custom Tools." + crossbow + ".required bolts")){
			String[] bolts = new String[50];
			List<?> list = me.duckdoom5.RpgEssentials.config.Configuration.items.getList("Custom Tools." + crossbow + ".required bolts");
			Iterator<?> keys = list.iterator();
			int i = 0;
			while(keys.hasNext()){
				bolts[i] = keys.next().toString();
				i = i + 1;
			}
			return bolts;
		}
		RpgEssentials.log.warning("ERROR: " + crossbow + " has no required bolts!");
		return null;
	}
	
	private static boolean hasRequiredBolt(SpoutPlayer player, String bolt){
		for(ItemStack item:player.getInventory().getContents()){
			/*if(item.getDurability() == MaterialManager.custombolts.get(bolt).getCustomId()){
				return true;
			}*/
		}
		return false;
	}
	
	public static String getBestBolt(SpoutPlayer player, String[] bolts){
		int prevdamage = 0;
		String boltname = null;
		for(String bolt:bolts){
			int newdamage = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Item." + bolt + ".damage");
			if(prevdamage < newdamage){
				if(hasRequiredBolt(player,bolt)){
					prevdamage = newdamage;
					boltname = bolt;
				}
			}//else if(prevdamage == newdamage){
				//do another check to see what is better
			//}
		}
		
		return boltname;
	}
	
	public static String getCrossbow(SpoutPlayer player){
		ItemStack inHand = player.getItemInHand();
		/*for(GenericCustomTool crossbow :MaterialManager.customcrossbows){
			if(inHand.getDurability() == crossbow.getCustomId()){
				return crossbow.getName();
			}
		}*/
		return null;
	}
}
