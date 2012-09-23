package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Construction;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Excavation;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Farming;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Mining;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Woodcutting;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockListener implements Listener{
	public static RpgLeveling plugin;
	
	public BlockListener(RpgLeveling rpgLeveling) {
		BlockListener.plugin = rpgLeveling;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) throws Exception{
		Block block = event.getBlock();
		Player player = event.getPlayer();
		World world = player.getWorld();
		if(RpgEssentialsWorldListener.worlds.get(world)){
			block.setMetadata("Placed", new FixedMetadataValue(plugin, true));
			givePlaceExp(player, block);
		}
	}
	

	private static void givePlaceExp(Player player, Block block){
		if(Farming.isFarming(block)){
			int exp = Farming.getPlaceXp(block);
			PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FARMING, exp);
			Bukkit.getServer().getPluginManager().callEvent(callevent);
		}else if(Construction.isConstruction(block)){
			int exp = Construction.getXp(block, player, plugin);
			PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.CONSTRUCTION, exp);
			Bukkit.getServer().getPluginManager().callEvent(callevent);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) throws Exception{
		Block block = event.getBlock();
		Player player = event.getPlayer();
		World world = player.getWorld();
		
		if(RpgEssentialsWorldListener.worlds.get(world)){
			ItemStack inhand = player.getItemInHand();
			
			if(block.hasMetadata("Placed")){
				block.removeMetadata("Placed", plugin);
			}else{
				giveBreakExp(player,block,inhand,event);
			}
		}
	}
	
	private static void giveBreakExp(Player player, Block block, ItemStack inhand, BlockBreakEvent event){
		if(Mining.isMining(block)){
			if(Mining.canUse(RpgEssentials.pm.getRpgPlayer(player.getName()))){
				if(Mining.canMine(block, RpgEssentials.pm.getRpgPlayer(player.getName()))){
					int exp = Mining.getXp(block, player);
					if(exp != 0){
						PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.MINING, exp);
						Bukkit.getServer().getPluginManager().callEvent(callevent);
					}
				}else{
					block.removeMetadata("Placed", plugin);
					event.setCancelled(true);
				}
			}else{
				block.removeMetadata("Placed", plugin);
				event.setCancelled(true);
			}
		}else if(Woodcutting.isWoodcutting(block)){
			if(Woodcutting.canUse(RpgEssentials.pm.getRpgPlayer(player.getName()))){
				int exp = Woodcutting.getXp(block, player);
				if(exp != 0){
					PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.WOODCUTTING, exp);
					Bukkit.getServer().getPluginManager().callEvent(callevent);
				}
			}else{
				block.removeMetadata("Placed", plugin);
				event.setCancelled(true);
			}
		}else if(Excavation.isExcavation(block)){
			if(Excavation.canUse(RpgEssentials.pm.getRpgPlayer(player.getName()))){
				int exp = Excavation.getXp(block);
				if(exp != 0){
					PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.EXCAVATION, exp);
					Bukkit.getServer().getPluginManager().callEvent(callevent);
				}
			}else{
				block.removeMetadata("Placed", plugin);
				event.setCancelled(true);
			}
		}else if(Farming.isFarming(block)){
			if(Farming.canUse(RpgEssentials.pm.getRpgPlayer(player.getName()))){
				int exp = Farming.getBreakXp(block);
				if(exp != 0){
					PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FARMING, exp);
					Bukkit.getServer().getPluginManager().callEvent(callevent);
				}
			}else{
				block.removeMetadata("Placed", plugin);
				event.setCancelled(true);
			}
		}
	}
}
