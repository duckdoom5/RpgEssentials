package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import org.bukkit.Material;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.util.Methods;

public class Defense {
	static Skill skill = Skill.DEFENSE;
	
	public static boolean canUse(RpgPlayer player, Material type){
		if(Configuration.level.getBoolean("Enabled." + skill.toString())){
			int currentlevel = player.getLvl(skill);
			if(Methods.isArmor(type)){
				if(currentlevel < Configuration.level.getInt("UnlockLevel." + type.toString().toLowerCase().replace("_", " "))){
					return false;
				}
			}
		}
		return true;
	}
}
