package me.duckdoom5.RpgEssentials.RpgLeveling;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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
	
	public static void addexp(Player player, Skill skill, Integer addexp, RpgLeveling plugin) {
		RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
		final SpoutPlayer splayer = SpoutManager.getPlayer(player);
		final Widget exp = new GenericLabel("+" + Integer.toString(addexp) + " exp").setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.CENTER_CENTER).shiftXPos(-5).shiftYPos(-10).animate(WidgetAnim.POS_Y, -1F, (short)20, (short)1, false, false).animateStart();
		splayer.getMainScreen().attachWidget(plugin, exp);
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	splayer.getMainScreen().removeWidget(exp);
		    	try {
					splayer.getMainScreen().getActivePopup().close();
				} catch (Exception e) {
				}
		    }
		}, 20L);
		
		oldexp = rpgplayer.getExp(skill);
		newexp = oldexp + addexp;
		rpgplayer.setExp(skill, newexp);
		checknewlvl(RpgEssentials.pm.getRpgPlayer(player), skill, newexp, plugin);
	}
	
	public static int getExpRequired(RpgPlayer player, Skill skill){
		currentlevel = player.getLvl(skill);
		xptolvl = 0;
		
		double exponent = Configuration.level.getDouble("Level exponent");
		
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/exponent)) * (level + 300) ) ) / 4 );
		}
		return xptolvl;
	}
	
	public static int getExpLeft(RpgPlayer player, Skill skill){
		currentlevel = player.getLvl(skill);
		xptolvl = 0;
		double exponent = Configuration.level.getDouble("Level exponent");
		
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/exponent)) * (level + 300) ) ) / 4 );
		}
		int currentexp = player.getExp(skill);
		return (xptolvl - currentexp);
	}
	
	public static void checknewlvl(RpgPlayer player, Skill skill, int currentexp, RpgLeveling plugin){
		currentlevel = player.getLvl(skill);
		xptolvl = 0;
		
		double exponent = Configuration.level.getDouble("Level exponent");
		for(int level = 0; level <= currentlevel && currentlevel != 100; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/exponent)) * (level + 300) ) ) / 4 );
		}
		SpoutPlayer splayer = (SpoutPlayer) player.getPlayer();
		if(currentexp >= xptolvl){
			newlevel = currentlevel + 1;
			SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, Configuration.level.getString("level-up sound"), false);
			splayer.sendNotification(skill.toString().toLowerCase() + " level up!", "Your level is now: " + newlevel, Material.getMaterial(Configuration.level.getInt("level-up material")));
			player.setLvl(skill, newlevel);
		}else {
		}
		checknewcombat(player,plugin);
	}
	public static void checknewcombat(RpgPlayer player, RpgLeveling plugin){
		int att = player.getLvl(Skill.ATTACK);
		int def = player.getLvl(Skill.DEFENSE);
		int ran = player.getLvl(Skill.RANGED);
		//int mag = rpgplayer.getLvl(Skill.MAGIC);
		//int str = rpgplayer.getLvl(Skill.STRENGTH);
		//int con = rpgplayer.getLvl(Skill.STRENGTH);
		//int pra = rpgplayer.getLvl(Skill.STRENGTH);
		
		int mag = 1;
		int pra = 1;
		int con = 1;
		int str = 1;
		
		double lvl = 1/4.0*(13/10.0*(att + str + (3/2.0 * mag) + (3/2.0 * ran)) + def + con + (1/2.0*pra));
		
		int combatlvl = (int) Math.floor(lvl);
		int oldcombatlvl = player.getLvl(Skill.COMBAT);
		if(oldcombatlvl < combatlvl){
			SpoutPlayer splayer = (SpoutPlayer) player.getPlayer();
			SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, Configuration.level.getString("combat level-up sound"), false);
			splayer.sendNotification("Combat level up!", "Your level is now: " + combatlvl, Material.getMaterial(Configuration.level.getInt("combat level-up material")));
			player.setLvl(Skill.COMBAT, combatlvl);
			Player onplayer[];
            int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
			for(int i=0; i < j; i++){
				Player on = onplayer[i];
				RpgPlayer otherrpgplayer = RpgEssentials.pm.getRpgPlayer(on);
				SpoutPlayer son = (SpoutPlayer) on;
				int combatlvlother = otherrpgplayer.getLvl(Skill.COMBAT);
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
				splayer.setTitleFor(son, colorme + player.getTitle() + " [lvl: " + combatlvl + "]");
				son.setTitleFor(splayer, colorother + otherrpgplayer.getTitle() + " [lvl: " + combatlvlother + "]");
			}
		}
	}
}
