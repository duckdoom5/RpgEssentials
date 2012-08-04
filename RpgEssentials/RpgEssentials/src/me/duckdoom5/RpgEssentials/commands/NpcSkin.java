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
				if(plugin.hasPermission(player, "rpgessentials.npc.skin") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						NPC np = RpgEssentials.nm.getNPC(id);
						
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
				} else {
					permissions(player);
				}
			}else if(args.length == 2){//npc skin {url}
				if(plugin.hasPermission(player, "rpgessentials.npc.skin") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						if(args[1].contains(".png")){
							NPC np = RpgEssentials.nm.getNPC(id);
							
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
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc skin " + ChatColor.RED + "{url}");
			}
		}
	}
}