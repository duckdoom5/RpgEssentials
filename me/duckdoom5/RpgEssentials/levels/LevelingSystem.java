package me.duckdoom5.RpgEssentials.levels;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelingSystem {

	static YamlConfiguration levelconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	
	static int oldexp, newexp, currentlevel, newlevel, xptolvl;
	private static ChatColor colorme;
	private static ChatColor colorother;
	
	public static void addexp(Player player, String skilltype, Integer addexp, RpgEssentials plugin) {
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
		checknewlvl(player, skilltype, newexp, plugin);
	}
	public static void checknewlvl(Player player, String skilltype, int currentexp, RpgEssentials plugin){
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
		checknewcombat(player,plugin);
	}
	public static void checknewcombat(Player player, RpgEssentials plugin){
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
			
			combatlvl = playerconfig.getInt("players."+ player.getName() +".combatlvl");
			Player onplayer[];
            int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
			for(int i=0; i < j; i++){
				Player on = onplayer[i];
				SpoutPlayer son = (SpoutPlayer) on;
				int combatlvlother = playerconfig.getInt("players."+ on.getName() +".combatlvl");
				if(combatlvl > combatlvlother){
					if(combatlvl - combatlvlother <= 5){
						colorme = ChatColor.RED;
						colorother = ChatColor.GREEN;
					}else{
						colorme = ChatColor.DARK_RED;
						colorother = ChatColor.DARK_GREEN;
					}
				}else if(combatlvl < combatlvlother){
					if(combatlvlother - combatlvl <= 5){
						colorme = ChatColor.GREEN;
						colorother = ChatColor.RED;
					}else{
						colorme = ChatColor.DARK_GREEN;
						colorother = ChatColor.DARK_RED;
					}
				}else if(combatlvl == combatlvlother){
					colorme = ChatColor.YELLOW;
					colorother = ChatColor.YELLOW;
				}
				splayer.setTitleFor(son, colorme + playerconfig.getString("players."+ player.getName() +".title")+ " [lvl: " + combatlvl + "]");
				son.setTitleFor(splayer, colorother + playerconfig.getString("players."+ on.getName() +".title")+ " [lvl: " + combatlvlother + "]");
			}
		}
	}
}
