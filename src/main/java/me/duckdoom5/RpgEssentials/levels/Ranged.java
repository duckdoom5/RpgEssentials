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
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class Ranged {

	private static int addexp;
	
	public static void check(Entity attacker, RpgEssentials plugin){

		String skilltype = "Ranged";
		Projectile x = (Projectile) attacker;
		LivingEntity shooter = x.getShooter();
		if(shooter instanceof Player){
			Player player = (Player) shooter;
			boolean god = false;
			boolean pvp = true;
			if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
				WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
				god = worldguard.getGlobalStateManager().hasGodMode(player);
				pvp  = worldguard.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).allows(DefaultFlag.PVP);
			}
			if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
		    	if(player.getGameMode() == GameMode.SURVIVAL && god == false && pvp == true){
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
