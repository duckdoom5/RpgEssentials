package me.duckdoom5.RpgEssentials.util;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.entity.Player;

public class MessageUtils {
	public static String[] TextMenuSplit(String raw){
		if(raw == null){
			return null;
		}
		int length = raw.length();
		String [] text = new String[length/25 + 1];
		if(length < 25){
			text[0] = raw;
		}else if(length < 50){
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, length);
		}else if(length < 75){
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, 50);
			text[2] = raw.substring(50, length);
		}else if(length < 100){
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, 50);
			text[2] = raw.substring(50, 75);
			text[3] = raw.substring(75, length);
		}else if(length < 125){
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, 50);
			text[2] = raw.substring(50, 75);
			text[3] = raw.substring(75, 100);
			text[4] = raw.substring(100, length);
		}else if(length < 150){
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, 50);
			text[2] = raw.substring(50, 75);
			text[3] = raw.substring(75, 100);
			text[4] = raw.substring(100, 125);
			text[5] = raw.substring(125, length);
		}else{
			text[0] = raw.substring(0, 25);
			text[1] = raw.substring(25, 50);
			text[2] = raw.substring(50, 75);
			text[3] = raw.substring(75, 100);
			text[4] = raw.substring(100, 125);
			text[5] = raw.substring(125, 150);
			text[6] = raw.substring(150, length);
		}
		return text;
	}
	
	public static void sendOnline(RpgEssentials plugin, String msg){
		Player onplayer[];
        int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for(int i = 0; i < j; i++){
            Player P = onplayer[i];
			P.sendMessage(msg);
		}
	}
}
