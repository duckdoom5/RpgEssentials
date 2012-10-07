package me.duckdoom5.RpgEssentials.RpgDeaths.Listeners;

import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.RpgDeaths.DeathChests;
import me.duckdoom5.RpgEssentials.RpgDeaths.DeathPlayer;
import me.duckdoom5.RpgEssentials.RpgDeaths.RpgDeaths;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayerListener implements Listener{
	public static RpgDeaths plugin;
	
	public PlayerListener(RpgDeaths instance) {
        plugin = instance; 
    }
	
	@EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
	    	final Player player = event.getEntity();
	    	final SpoutPlayer splayer = SpoutManager.getPlayer(player);
	    	
	    	if(!DeathChests.isDeath(player.getName())){
	    		event.getDrops().clear();
		    	if(!Methods.isInventoryEmpty(player)){
		    		DeathPlayer deathplayer = new DeathPlayer(player.getName(), plugin);
		    	}
	    	}
		}
    }
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Player player = event.getPlayer();
	    	Block block = event.getClickedBlock();
	    	Action action = event.getAction();
	    	ItemStack inhand = player.getItemInHand();
	    	if(action == Action.RIGHT_CLICK_BLOCK){
	    		if(block.getType().equals(Material.CHEST)){
    				if(BlockListener.protect.containsKey(block.getLocation())){
    					if(!player.getName().equals(BlockListener.protect.get(block.getLocation()))){
    						player.sendMessage(ChatColor.RED + "This chest is still protected.");
    						event.setCancelled(true);
    					}
    				}
    			}
	    	}
    	}
    }
}
