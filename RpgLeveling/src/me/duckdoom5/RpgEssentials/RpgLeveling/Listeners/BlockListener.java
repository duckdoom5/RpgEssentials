package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
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
import org.bukkit.event.block.BlockDamageEvent;
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
		if(RpgEssentials.wl.worlds.get(world)){
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
		if(!Configuration.level.getBoolean("Disable block break on damage event")){
			Block block = event.getBlock();
			Player player = event.getPlayer();
			World world = player.getWorld();
			
			if(RpgEssentials.wl.worlds.get(world)){
				ItemStack inhand = player.getItemInHand();
				
				if(canBreak(player, block)){
					if(block.hasMetadata("Placed")){
						block.removeMetadata("Placed", plugin);
					}else{
						giveBreakExp(player, block);
					}
				}else{
					event.setCancelled(true);
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() - 1));
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) throws Exception{
		if(Configuration.level.getBoolean("Disable block break on damage event")){
			Block block = event.getBlock();
			Player player = event.getPlayer();
			World world = player.getWorld();
			
			if(RpgEssentials.wl.worlds.get(world)){
				ItemStack inhand = player.getItemInHand();
				
				if(!canBreak(player, block)){
					event.setCancelled(true);
				}
			}
		}
	}
	
	private boolean canBreak(Player player, Block block){
		if(Mining.isMining(block)){
			if(!Configuration.level.getBoolean("Disable tool use for low level"))
				return true;
			if(Mining.canUse(RpgEssentials.pm.getRpgPlayer(player))){
				if(!Configuration.level.getBoolean("Disable block break for low level")){
					return true;
				}else if(Mining.canMine(block, RpgEssentials.pm.getRpgPlayer(player))){
					return true;
				}
				return false;
			}
			return false;
		}else if(Woodcutting.isWoodcutting(block)){
			if(!Configuration.level.getBoolean("Disable tool use for low level")){
				return true;
			}else if(Woodcutting.canUse(RpgEssentials.pm.getRpgPlayer(player))){
				return true;
			}
			return false;
		}else if(Excavation.isExcavation(block)){
			if(!Configuration.level.getBoolean("Disable tool use for low level")){
				return true;
			}else if(Excavation.canUse(RpgEssentials.pm.getRpgPlayer(player))){
				return true;
			}
			return false;
		}else if(Farming.isFarming(block)){
			if(!Configuration.level.getBoolean("Disable tool use for low level")){
				return true;
			}else if(Farming.canUse(RpgEssentials.pm.getRpgPlayer(player))){
				return true;
			}
			return false;
		}
		return true;
	}
	
	
	private void giveBreakExp(Player player, Block block){
		if(Mining.isMining(block)){
			int exp = Mining.getXp(block, player);
			if(exp != 0){
				PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.MINING, exp);
				Bukkit.getServer().getPluginManager().callEvent(callevent);
			}
		}else if(Woodcutting.isWoodcutting(block)){
			int exp = Woodcutting.getXp(block, player);
			if(exp != 0){
				PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.WOODCUTTING, exp);
				Bukkit.getServer().getPluginManager().callEvent(callevent);
			}
		}else if(Excavation.isExcavation(block)){
			int exp = Excavation.getXp(block);
			if(exp != 0){
				PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.EXCAVATION, exp);
				Bukkit.getServer().getPluginManager().callEvent(callevent);
			}
		}else if(Farming.isFarming(block)){
			int exp = Farming.getBreakXp(block);
			if(exp != 0){
				PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.FARMING, exp);
				Bukkit.getServer().getPluginManager().callEvent(callevent);
			}
		}
	}
}
