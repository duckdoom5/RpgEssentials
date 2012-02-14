package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Ranged {

	private static int addexp;
	
	public static void check(Entity attacker, RpgEssentials plugin){

		String skilltype = "Ranged";
		Projectile x = (Projectile) attacker;
		LivingEntity shooter = x.getShooter();
		if(shooter instanceof Player){
			Player player = (Player) shooter;
			boolean god = false;
			if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
				WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
				god = worldguard.getGlobalStateManager().hasGodMode(player);
			}
			if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
		    	if(player.getGameMode() == GameMode.SURVIVAL && god == false){
					addexp = Configuration.level.getInt("Exp." + skilltype + ".Arrow Shoot");
					LevelingSystem.addexp(player, skilltype, addexp, plugin);
		    	}
			}else{
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Arrow Shoot");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}
	}
}
