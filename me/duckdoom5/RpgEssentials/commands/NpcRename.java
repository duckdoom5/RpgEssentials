package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcRename extends RpgEssentialsCommandExecutor{
	public NpcRename(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc rename
				player.sendMessage(ChatColor.RED + "Not enough arguments!");
				player.sendMessage(ChatColor.AQUA + "Useage: /npc rename " + ChatColor.GREEN + "[id] " + ChatColor.RED + "{name}");
			}else if(args.length == 2){//npc rename {name}
				String id = npc.getSelected(player);
				if(id != null){
					NPC n = plugin.m.getNPC(id);
					Entity entity = n.getBukkitEntity();
					Location location = new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(), entity.getLocation().getYaw(), entity.getLocation().getPitch());
					
					//setting new
					Configuration.npc.set("Npc." + args[1] + ".type", Configuration.npc.getString("Npc." + id + ".type"));
					Configuration.npc.set("Npc." + args[1] + ".owner", Configuration.npc.getString("Npc." + id + ".owner"));
					Configuration.npc.set("Npc." + args[1] + ".location", n.getBukkitEntity().getLocation().toVector());
					Configuration.npc.set("Npc." + args[1] + ".world", n.getBukkitEntity().getWorld().getName());
					Configuration.npc.set("Npc." + args[1] + ".pitch", n.getBukkitEntity().getLocation().getPitch());
					Configuration.npc.set("Npc." + args[1] + ".yaw", n.getBukkitEntity().getLocation().getYaw());
					if(Configuration.npc.contains("Npc." + id + ".cape")){
						Configuration.npc.set("Npc." + args[1] + ".cape", Configuration.npc.getString("Npc." + id + ".cape"));
					}
					if(Configuration.npc.contains("Npc." + id + ".skin")){
						Configuration.npc.set("Npc." + args[1] + ".skin", Configuration.npc.getString("Npc." + id + ".skin"));
					}
					if(Configuration.npc.contains("Npc." + id + ".item")){
						Configuration.npc.set("Npc." + args[1] + ".item", Configuration.npc.getInt("Npc." + id + ".item"));
					}
					if(Configuration.npc.contains("Npc." + id + ".item data")){
						Configuration.npc.set("Npc." + args[1] + ".item data", Configuration.npc.getInt("Npc." + id + ".item data"));
					}
					
					//removing old
					Configuration.npc.set("Npc." + args[1] + ".owner", null);
					Configuration.npc.set("Npc." + id + ".type", null);
					Configuration.npc.set("Npc." + id + ".location", null);
					Configuration.npc.set("Npc." + id + ".world", null);
					Configuration.npc.set("Npc." + id + ".pitch", null);
					Configuration.npc.set("Npc." + id + ".yaw", null);
					if(Configuration.npc.contains("Npc." + id + ".cape")){
						Configuration.npc.set("Npc." + id + ".cape", null);
					}
					if(Configuration.npc.contains("Npc." + id + ".skin")){
						Configuration.npc.set("Npc." + id + ".skin", null);
					}
					if(Configuration.npc.contains("Npc." + id + ".item")){
						Configuration.npc.set("Npc." + id + ".item", null);
					}
					if(Configuration.npc.contains("Npc." + id + ".item data")){
						Configuration.npc.set("Npc." + id + ".item data", null);
					}
					Configuration.npc.set("Npc." + id, null);
					
					try {
						Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					plugin.m.rename(id, args[1], location, plugin, splayer);
					player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " name is now: " + ChatColor.YELLOW + args[1]);
				}
			}else if(args.length == 3){//npc rename [id] {name}
				NPC n = plugin.m.getNPC(args[2]);
				Entity entity = n.getBukkitEntity();
				Location location = new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(), entity.getLocation().getYaw(), entity.getLocation().getPitch());
				
				//setting new
				Configuration.npc.set("Npc." + args[2] + ".owner", Configuration.npc.getString("Npc." + args[1] + ".owner"));
				Configuration.npc.set("Npc." + args[2] + ".type", Configuration.npc.getString("Npc." + args[1] + ".type"));
				Configuration.npc.set("Npc." + args[2] + ".location", n.getBukkitEntity().getLocation());
				Configuration.npc.set("Npc." + args[2] + ".world", n.getBukkitEntity().getWorld().getName());
				Configuration.npc.set("Npc." + args[2] + ".pitch", n.getBukkitEntity().getLocation().getPitch());
				Configuration.npc.set("Npc." + args[2] + ".yaw", n.getBukkitEntity().getLocation().getYaw());
				if(Configuration.npc.contains("Npc." + args[1] + ".cape")){
					Configuration.npc.set("Npc." + args[2] + ".cape", Configuration.npc.getString("Npc." + args[1] + ".cape"));
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".skin")){
					Configuration.npc.set("Npc." + args[2] + ".skin", Configuration.npc.getString("Npc." + args[1] + ".skin"));
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".item")){
					Configuration.npc.set("Npc." + args[2] + ".item", Configuration.npc.getInt("Npc." + args[1] + ".item"));
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".item data")){
					Configuration.npc.set("Npc." + args[2] + ".item data", Configuration.npc.getInt("Npc." + args[1] + ".item data"));
				}
				
				//Removing old
				Configuration.npc.set("Npc." + args[1] + ".owner", null);
				Configuration.npc.set("Npc." + args[1] + ".type", null);
				Configuration.npc.set("Npc." + args[1] + ".location", null);
				Configuration.npc.set("Npc." + args[1] + ".world", null);
				Configuration.npc.set("Npc." + args[1] + ".pitch", null);
				Configuration.npc.set("Npc." + args[1] + ".yaw", null);
				if(Configuration.npc.contains("Npc." + args[1] + ".cape")){
					Configuration.npc.set("Npc." + args[1] + ".cape", null);
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".skin")){
					Configuration.npc.set("Npc." + args[1] + ".skin", null);
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".item")){
					Configuration.npc.set("Npc." + args[1] + ".item", null);
				}
				if(Configuration.npc.contains("Npc." + args[1] + ".item data")){
					Configuration.npc.set("Npc." + args[1] + ".item data", null);
				}
				Configuration.npc.set("Npc." + args[1], null);
				
				try {
					Configuration.npc.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
				plugin.m.rename(args[1], args[2], location, plugin, splayer);
				player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + "'s" + ChatColor.GREEN + " name is now: " + ChatColor.YELLOW + args[2]);
				
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc rename " + ChatColor.GREEN + "[id] " + ChatColor.RED + "{name}");
			}
		}
	}
}
