package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

public class Ranged {

	private static int addexp;
	static YamlConfiguration levelconfig = new YamlConfiguration();
	
	public static void check(Entity attacker, RpgEssentials plugin){
		try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		String skilltype = "Ranged";
		Projectile x = (Projectile) attacker;
		LivingEntity shooter = x.getShooter();
		if(shooter instanceof Player){
			Player player = (Player) shooter;
			if(levelconfig.getBoolean("Survival Gamemode Required") == true){
		    	if(player.getGameMode() == GameMode.SURVIVAL){
					addexp = levelconfig.getInt("Exp." + skilltype + ".Arrow Shoot");
					LevelingSystem.addexp(player, skilltype, addexp, plugin);
		    	}
			}else{
				addexp = levelconfig.getInt("Exp." + skilltype + ".Arrow Shoot");
				LevelingSystem.addexp(player, skilltype, addexp, plugin);
			}
		}
	}
}
