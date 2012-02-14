package me.duckdoom5.RpgEssentials.levels;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.gui.WidgetAnim;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelingSystem {

	static int oldexp, newexp, currentlevel, newlevel, xptolvl;
	private static ChatColor colorme;
	private static ChatColor colorother;
	
	public static void addexp(Player player, String skilltype, Integer addexp, RpgEssentials plugin) {
		
		final SpoutPlayer splayer = SpoutManager.getPlayer(player);
		final Widget exp = new GenericLabel("+" + Integer.toString(addexp) + " exp").setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.CENTER_CENTER).shiftXPos(-5).shiftYPos(-10).animate(WidgetAnim.POS_Y, -1F, (short)20, (short)1, false, false).animateStart();
		splayer.getMainScreen().attachWidget(plugin, exp);
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	splayer.getMainScreen().removeWidget(exp);
		    }
		}, 20L);
		
		oldexp = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".exp");
		newexp = oldexp + addexp;
		Configuration.players.set("players." + player.getName() + "." + skilltype + ".exp", newexp);
		
		try {
			Configuration.players.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		checknewlvl(player, skilltype, newexp, plugin);
	}
	public static int getExpRequired(Player player, String skilltype){
		currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
		xptolvl = 0;
		
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		return xptolvl;
	}
	public static int getExpLeft(Player player, String skilltype){
		currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
		xptolvl = 0;
		
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		int currentexp = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".exp");
		return (xptolvl - currentexp);
	}
	public static void checknewlvl(Player player, String skilltype, int currentexp, RpgEssentials plugin){
		currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
		xptolvl = 0;
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		SpoutPlayer splayer = (SpoutPlayer) player;
		if(currentexp >= xptolvl){
			newlevel = currentlevel + 1;
			splayer.sendNotification(skilltype + " level up!", "Your level is now: " + newlevel, Material.CAKE);
			Configuration.players.set("players." + player.getName() + "." + skilltype + ".level", newlevel);
			try {
				Configuration.players.save();
			} catch (Exception e) {
			}
		}else {
		}
		checknewcombat(player,plugin);
	}
	public static void checknewcombat(Player player, RpgEssentials plugin){
		int att = Configuration.players.getInt("players." + player.getName() + ".Attack.level");
		int def = Configuration.players.getInt("players." + player.getName() + ".Defence.level");
		int ran = Configuration.players.getInt("players." + player.getName() + ".Ranged.level");
		int mag = Configuration.players.getInt("players." + player.getName() + ".Magic.level");
		int str = Configuration.players.getInt("players." + player.getName() + ".Strength.level");
		int con = Configuration.players.getInt("players." + player.getName() + ".Constitution.level");
		int pra = Configuration.players.getInt("players." + player.getName() + ".Prayer.level");
		
		pra = pra + 1;
		con = con + 1;
		str = str + 1;
		
		double lvl = 1/4.0*(13/10.0*(att + str + (3/2.0 * mag) + (3/2.0 * ran)) + def + con + (1/2.0*pra));
		
		int combatlvl = (int) Math.floor(lvl);
		int oldcombatlvl = Configuration.players.getInt("players." + player.getName() + ".combatlvl");
		if(oldcombatlvl < combatlvl){
			SpoutPlayer splayer = (SpoutPlayer) player;
			splayer.sendNotification("Combat level up!", "Your level is now: " + combatlvl, Material.DIAMOND_SWORD);
			Configuration.players.set("players." + player.getName() + ".combatlvl", combatlvl);
			try {
				Configuration.players.save();
			} catch (Exception e) {
			}
			
			combatlvl = Configuration.players.getInt("players."+ player.getName() +".combatlvl");
			Player onplayer[];
            int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
			for(int i=0; i < j; i++){
				Player on = onplayer[i];
				SpoutPlayer son = (SpoutPlayer) on;
				int combatlvlother = Configuration.players.getInt("players."+ on.getName() +".combatlvl");
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
				splayer.setTitleFor(son, colorme + Configuration.players.getString("players."+ player.getName() +".title")+ " [lvl: " + combatlvl + "]");
				son.setTitleFor(splayer, colorother + Configuration.players.getString("players."+ on.getName() +".title")+ " [lvl: " + combatlvlother + "]");
			}
		}
	}
}
