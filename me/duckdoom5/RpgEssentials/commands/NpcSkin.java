package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;
import com.topcat.npclib.nms.NPCEntity;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcSkin extends RpgEssentialsCommandExecutor{
	public NpcSkin(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc skin
				String id = npc.getSelected(player);
				if(id != null){
					NPC np = plugin.m.getNPC(id);
					
					Configuration.npc.set("Npc." + id + ".skin", null);
					try {
						Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
					humannpc.getSpoutPlayer().resetSkin();
					player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " skin has been removed");
				}
			}else if(args.length == 2){//npc skin {url}
				String id = npc.getSelected(player);
				if(id != null){
					if(args[1].contains(".png")){
						NPC np = plugin.m.getNPC(id);
						
						Configuration.npc.set("Npc." + id + ".skin", args[1]);
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
						humannpc.getSpoutPlayer().setSkin(args[1]);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " skin has been changed");
					}else{
						player.sendMessage(ChatColor.RED + "Skin file must be a png !");
					}
				}
			}else if(args.length == 3){//npc skin [id] {url}
				if(args[2].contains(".png")){
					NPC np = plugin.m.getNPC(args[1]);
					HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
					
					Configuration.npc.set("Npc." + args[1] + ".skin", args[2]);
					try {
						Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					humannpc.getSpoutPlayer().setSkin(args[2]);
					player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + "'s" + ChatColor.GREEN + " skin has been changed");
				}else{
					player.sendMessage(ChatColor.RED + "Skin file must be a png !");
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc skin "+ ChatColor.GREEN + "[id] " + ChatColor.RED + "{url}");
			}
		}
	}
}