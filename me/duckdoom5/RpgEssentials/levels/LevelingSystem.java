package me.duckdoom5.RpgEssentials.levels;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelingSystem {

	static YamlConfiguration levelconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	static int oldexp, newexp, currentlevel, newlevel, xptolvl;
	
	public static void addexp(Player player, String skilltype, Integer addexp) {
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldexp = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".exp");
		newexp = oldexp + addexp;
		playerconfig.set("players." + player.getName() + "." + skilltype + ".exp", newexp);
		try {
			playerconfig.save("plugins/RpgEssentials/players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		checknewlvl(player, skilltype, newexp);
	}
	public static void checknewlvl(Player player, String skilltype, int currentexp){
		currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
		xptolvl = 0;
		for(int level = 0; level <= currentlevel; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		
		player.sendMessage("exp required: " + xptolvl);
		if(currentexp >= xptolvl){
			SpoutPlayer splayer = (SpoutPlayer) player;
			newlevel = currentlevel + 1;
			splayer.sendNotification(skilltype + " level up!", "Your level is now: " + newlevel, Material.CAKE);
			playerconfig.set("players." + player.getName() + "." + skilltype + ".level", newlevel);
			try {
				playerconfig.save("plugins/RpgEssentials/players.yml");
			} catch (Exception e) {
			}
		}else {
			player.sendMessage("current exp: " + currentexp);
			player.sendMessage("exp left: " + (xptolvl - currentexp));
		}
		checknewcombat(player);
	}
	public static void checknewcombat(Player player){
		try {
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		int att = playerconfig.getInt("players." + player.getName() + ".Attack.level");
		int def = playerconfig.getInt("players." + player.getName() + ".Defence.level");
		int ran = playerconfig.getInt("players." + player.getName() + ".Ranged.level");
		int mag = playerconfig.getInt("players." + player.getName() + ".Magic.level");
		int str = playerconfig.getInt("players." + player.getName() + ".Strength.level");
		int con = playerconfig.getInt("players." + player.getName() + ".Constitution.level");
		int pra = playerconfig.getInt("players." + player.getName() + ".Prayer.level");
		
		pra = pra + 1;
		con = con + 1;
		str = str + 1;
		
		double lvl = 1/4.0*(13/10.0*(att + str + (3/2.0 * mag) + (3/2.0 * ran)) + def + con + (1/2.0*pra));
		
		int combatlvl = (int) Math.floor(lvl);
		int oldcombatlvl = playerconfig.getInt("players." + player.getName() + ".combatlvl");
		if(oldcombatlvl < combatlvl){
			SpoutPlayer splayer = (SpoutPlayer) player;
			splayer.sendNotification("Combat level up!", "Your level is now: " + combatlvl, Material.DIAMOND_SWORD);
			playerconfig.set("players." + player.getName() + ".combatlvl", combatlvl);
			try {
				playerconfig.save("plugins/RpgEssentials/players.yml");
			} catch (Exception e) {
			}
		}
	}
}
