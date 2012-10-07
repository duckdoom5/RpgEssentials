package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Farming;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Firemaking;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Fishing;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListerner implements Listener{
public static RpgLeveling plugin;
	
	public PlayerListerner(RpgLeveling rpgLeveling) {
		BlockListener.plugin = rpgLeveling;
	}
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Player player = event.getPlayer();
	    	Block block = event.getClickedBlock();
	    	Action action = event.getAction();
	    	ItemStack inhand = player.getItemInHand();
	    	if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR){
	    		/*if(inhand.getDurability() == Hashmaps.customitemsmap.get("Green Xp Book").getCustomId()){
	    			TODO open xp gui
	    		}else if(inhand.getDurability() == Hashmaps.customitemsmap.get("Red Xp Book").getCustomId()){
	    			TODO open xp gui
	    		}else if(inhand.getDurability() == Hashmaps.customitemsmap.get("Gold Xp Book").getCustomId()){
	    			TODO open xp gui
	    		}else if(inhand.getDurability() == Hashmaps.customitemsmap.get("Quest Book").getCustomId()){
	    			TODO open quest requirements gui
	    		}*/
	    	}
	    	if(action == Action.RIGHT_CLICK_BLOCK){
    			if(inhand.getType().equals(Material.FLINT_AND_STEEL)){
    				if(Firemaking.canIgnite(block)){
    					block = block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
    					if(block.getType() != Material.FIRE){
    						int exp = Configuration.level.getInt("Exp.Firemaking.Ignite");
		    				
			    			PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FIREMAKING, exp);
			    			Bukkit.getServer().getPluginManager().callEvent(callevent);
    						
    					}else{
    						event.setCancelled(true);
    					}
    				}else{
    					event.setCancelled(true);
    				}
    			}else if(block.getType() == Material.GRASS || block.getType() == Material.DIRT){
    				Material tool = player.getItemInHand().getType();
    				if(Farming.canUse(RpgEssentials.pm.getRpgPlayer(player))){
    					int exp = Farming.getSoilXp(tool);
    					if(exp != 0){
		    				PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FARMING, exp);
			    			Bukkit.getServer().getPluginManager().callEvent(callevent);
    					}
    				}else{
    					event.setCancelled(true);
    				}
    			}
    		}
    	}
    }
	
	@EventHandler
    public void onPlayerFish(PlayerFishEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
    		Player player = event.getPlayer();
    		int exp = Fishing.getExp(event, plugin);
    		if(exp != 0){
    			PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FISHING, exp);
    			Bukkit.getServer().getPluginManager().callEvent(callevent);
    		}
    	}
    }
}
