package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcText extends RpgEssentialsCommandExecutor{
	public NpcText(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length > 1){//npc text
				if(plugin.hasPermission(player, "rpgessentials.npc.text") || plugin.hasPermission(player, "npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						StringBuilder text = new StringBuilder();
						for(int i = 1; i<args.length; i++){
						    if(i != 1)
						    	text.append(' ');
						    text.append(args[i]);
						}
						Configuration.npc.set("Npc." + id + ".text", text.toString());
						player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "text has been set to \"" + ChatColor.YELLOW + text.toString() + ChatColor.GREEN + "\"");
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc text " + ChatColor.RED + "{text}");
			}
		}
	}
}