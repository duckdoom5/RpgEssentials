package me.duckdoom5.RpgEssentials.handelers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Music {
	public static HashMap<SpoutPlayer, Boolean> music = new LinkedHashMap<SpoutPlayer, Boolean>();
	public static HashMap<UUID, SpoutPlayer> inbattle = new LinkedHashMap<UUID, SpoutPlayer>();
	
	private static boolean isPlaying(SpoutPlayer splayer){
		if(!music.containsKey(splayer)){
			music.put(splayer, false);
			return false;
		}else{
			if(music.get(splayer) == false){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public static void stop(RpgEssentials plugin, UUID id){
		if(inbattle.containsKey(id)){
			final SpoutPlayer splayer = inbattle.get(id);
			SpoutManager.getSoundManager().stopMusic(splayer);
			inbattle.remove(id);
			
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			    public void run() {
			    	music.put(splayer, false);
			    }
			}, 60L);
		}
	}
	
	public static void forceStop(RpgEssentials plugin, final SpoutPlayer splayer){
		SpoutManager.getSoundManager().stopMusic(splayer);
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	music.put(splayer, false);
		    }
		}, 60L);
	}
	
	public static void start(RpgEssentials plugin, UUID id, SpoutPlayer splayer){
		if(! Music.isPlaying(splayer)){
			inbattle.put(id, splayer);
			SpoutManager.getSoundManager().playCustomMusic(plugin, splayer, "http://dl.dropbox.com/u/62672791/music/cd1/113-battle.wav", false);
			music.put(splayer, true);
		}
	}
}
