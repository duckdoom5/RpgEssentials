package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.massivecraft.factions.listeners.FactionsBlockListener;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

import me.duckdoom5.RpgEssentials.RpgLeveling.LevelingSystem;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerFireBoltEvent;

public class LevelingListener implements Listener{
	private static boolean god = false, pvp = true, build = true, bbreak = true, interact = true;
	private static RpgLeveling plugin;
	
	public LevelingListener(RpgLeveling rpgLeveling){
        plugin = rpgLeveling; 
    }
    
    @EventHandler(priority = EventPriority.LOW)
	public void onPlayerExpGain(PlayerExpGainEvent event){
		if(event.isCancelled()){
			return;
		}
		Player player = event.getPlayer();
		
		if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
			WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
			god = worldguard.getGlobalStateManager().hasGodMode(player);
			pvp  = worldguard.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).allows(DefaultFlag.PVP);
			build = worldguard.canBuild(player, player.getLocation());
		}else{
			pvp = player.getWorld().getPVP();
		}
		
		if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("Factions"))){			
			if (!FactionsBlockListener.playerCanBuildDestroyBlock(event.getPlayer(), player.getLocation(), "destroy", false)){
				build = false;
				bbreak = false;
			}
		}
		Skill skill = event.getSkill();
		
		if(Configuration.level.getBoolean("Survival Gamemode Required")){
			if(player.getGameMode().equals(GameMode.SURVIVAL)){
				if(canGainExp(skill)){
					int exp = event.getExp();
					LevelingSystem.addexp(player, skill, exp, plugin);
				}
			}
		}else if(canGainExp(event.getSkill())){
			int exp = event.getExp();
			LevelingSystem.addexp(player, skill, exp, plugin);
		}
			
	}
    
    public boolean canGainExp(Skill skill){
    	if((skill.equals(Skill.ATTACK) || skill.equals(Skill.DEFENSE) || skill.equals(Skill.MAGIC) || skill.equals(Skill.RANGED)) && !god && pvp){
    		return true;
    	}else if((skill.equals(Skill.CONSTRUCTION) || skill.equals(Skill.FIREMAKING)) && build){
    		return true;
    	}else if(skill.equals(Skill.FARMING) && build && bbreak){
			return true;
		}else if((skill.equals(Skill.EXCAVATION) || skill.equals(Skill.MINING) || skill.equals(Skill.WOODCUTTING)) && bbreak){
			return true;
		}else if((skill.equals(Skill.COOKING) || skill.equals(Skill.SMITHING)) && !interact){
			return true;
		}
		return false;
    }
    
    @EventHandler
    public void onPlayerFireBolt(PlayerFireBoltEvent event){
    	Player player = event.getPlayer();
    	String bolt = event.getBoltType();
    	int exp = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Item." + bolt + ".xp");
    	PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.RANGED, exp);
		Bukkit.getServer().getPluginManager().callEvent(callevent);
    }
}
