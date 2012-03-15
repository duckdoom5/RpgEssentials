package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcQuest extends RpgEssentialsCommandExecutor{
	public NpcQuest(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc quest
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc quest " + ChatColor.RED + "{quest id}");
			}else if(args.length > 1){//npc quest {quest id}
				if(plugin.hasPermission(player, "rpgessentials.npc.quest") || plugin.hasPermission(player, "npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						if(Configuration.npc.getString("Npc." + id + ".type").equals("quester")){
							
							StringBuilder text = new StringBuilder();
							for(int i = 1; i<args.length; i++){
							    if(i != 1)
							    	text.append(' ');
							    text.append(args[i]);
							}
							
							if(Configuration.quests.contains("Quests." + text.toString())){
								Configuration.npc.set("Npc." + id + ".quest", text.toString());
								
								player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "quest has been set to " + ChatColor.YELLOW + text.toString());
								try {
									Configuration.npc.save();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}else{
								player.sendMessage(ChatColor.RED + "That quest doesn't exist.");
							}
						}else{
							player.sendMessage(ChatColor.RED + "Your npc is not a quester.");
						}
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc quest " + ChatColor.RED + "{quest id}");
			}
		}
	}
}