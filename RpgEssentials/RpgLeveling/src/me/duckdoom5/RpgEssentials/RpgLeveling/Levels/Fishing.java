package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Fishing {
	public static int getExp(PlayerFishEvent event, RpgLeveling plugin){
		Player player = event.getPlayer();
    	State state = event.getState();
    	Set<GenericCustomItem> fishes = new LinkedHashSet<GenericCustomItem>();
    	Random rand = new Random();
    	String skilltype = "Fishing";
    	
    	if(state == State.CAUGHT_FISH){
    		
    		int currentlevel = RpgEssentials.pm.getRpgPlayer(player.getName()).getLvl(Skill.FISHING);
    		
    		//custom fish
        	Entity entity = event.getCaught();
        	if(entity.getType().equals(EntityType.DROPPED_ITEM)){
        		Item item = (Item) entity;
        		
        		int customchance = me.duckdoom5.RpgEssentials.config.Configuration.config.getInt("custom fish chance");
        		if(rand.nextInt(100) < customchance){
	        		for(GenericCustomItem f: RpgEssentials.mm.getFish()){
	        			int level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".level");
	        			if(level <= currentlevel){
	        				fishes.add(f);
	        			}
	        		}
	        		for(GenericCustomItem f: fishes){
	        			int chance = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".chance");
	        			if(rand.nextInt(100) < chance){
	        				item.getItemStack().setType(Material.FLINT);
	        				item.getItemStack().setDurability((short) f.getCustomId());
	        				return me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".xp");
	        			}
	        		}
        		}
        		return Configuration.level.getInt("Exp." + skilltype + ".caught");
        	}
    	}
		return 0;
	}
}
