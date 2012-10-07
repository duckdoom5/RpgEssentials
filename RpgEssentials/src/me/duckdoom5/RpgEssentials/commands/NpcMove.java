package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcMove extends RpgEssentialsCommandExecutor{
	public NpcMove(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc walkto
				if(plugin.hasPermission(player, "rpgessentials.npc.move") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						Location location = player.getLocation();
						NPC npc2 = RpgEssentials.nm.getNPC(id);
						
						Configuration.npc.set("Npc." + id + ".location", player.getLocation().toVector());
						Configuration.npc.set("Npc." + id + ".world", player.getWorld().getName());
						Configuration.npc.set("Npc." + id + ".pitch", player.getLocation().getPitch());
						Configuration.npc.set("Npc." + id + ".yaw", player.getLocation().getYaw());
						
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						npc2.walkTo(location);
					}
				} else {
					permissions(player);
				}
			}else if(args.length == 2){//npc walkto [x,y,z]
				if(plugin.hasPermission(player, "rpgessentials.npc.move") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String[] xyz = args[1].split(":");
					
					if(xyz[0] == null || xyz[1] == null || xyz[2] == null){
						player.sendMessage(ChatColor.RED + "Please provide a valid location!");
					}else{
						double x = Double.parseDouble(xyz[0]);
						double y = Double.parseDouble(xyz[1]);
						double z = Double.parseDouble(xyz[2]);
						
						String id = npc.getSelected(player);
						if(id != null){
							Location location = new Location(player.getWorld(), x,y,z, player.getLocation().getYaw(), player.getLocation().getPitch());
							NPC npc2 = RpgEssentials.nm.getNPC(id);
							
							Configuration.npc.set("Npc." + id + ".location", location.toVector());
							Configuration.npc.set("Npc." + id + ".world", location.getWorld().getName());
							Configuration.npc.set("Npc." + id + ".pitch", location.getPitch());
							Configuration.npc.set("Npc." + id + ".yaw", location.getYaw());
							
							try {
								Configuration.npc.save();
							} catch (IOException e) {
								e.printStackTrace();
							}
							npc2.walkTo(location);
						}
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc move " + ChatColor.GREEN + "[x,y,z]");
			}
		}
	}
}
