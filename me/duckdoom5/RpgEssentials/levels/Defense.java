package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Defense {

	private static int addexp;

	public static void check(LivingEntity defender, RpgEssentials plugin, EntityDamageByEntityEvent event1) {
		String skilltype = "Defense";
		Player player = (Player) defender;
		DamageCause cause = event1.getCause();
		boolean god = false;
		if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
			WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
			god = worldguard.getGlobalStateManager().hasGodMode(player);
		}
		
		if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL && god == false){
				if(cause == DamageCause.ENTITY_ATTACK){
					addexp = Configuration.level.getInt("Exp." + skilltype + ".Entity Attack");
				}else if(cause == DamageCause.BLOCK_EXPLOSION){
					addexp = Configuration.level.getInt("Exp." + skilltype + ".Block Explosion");
				}else if(cause == DamageCause.ENTITY_EXPLOSION){
					addexp = Configuration.level.getInt("Exp." + skilltype + ".Entity Explosion");
				}else if(cause == DamageCause.PROJECTILE){//TODO DOESN'T WORK
					addexp = Configuration.level.getInt("Exp." + skilltype + ".Projectile");
				}
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
	    	}
		}else{
			if(cause == DamageCause.ENTITY_ATTACK){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Entity Attack");
			}else if(cause == DamageCause.BLOCK_EXPLOSION){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Block Explosion");
			}else if(cause == DamageCause.ENTITY_EXPLOSION){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Entity Explosion");
			}else if(cause == DamageCause.PROJECTILE){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Projectile");
			}
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
		
	}

}
