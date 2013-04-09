package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Clans  extends Command{
	public static HashMap<String, String> clans = new LinkedHashMap<String, String>();
	public static HashMap<String, List<String>> clanmembers = new LinkedHashMap<String, List<String>>();
	public static HashMap<String, String> claninvites = new LinkedHashMap<String, String>();
	
	public Clans() {
		super("clan", "rpg", new String[]{"type", "url"}, new String[]{"player"});
	}
	
	public void execute(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){//rpg clan
			if(CommandManager.hasPermission(this, player)){
				
			}
		}else if(args.length == 2){//rpg clan (arg)
			if(args[2].equals("create")){
				if(args.length == 3){//rpg clan create (name)
					if(!isInClan(player)){
						Configuration.clans.set("clan." + args[3] + ".owner", player.getName());
						
						List<String> members = (List<String>) Configuration.clans.getList("clan." + args[3] + ".members");
						members.add(player.getName());
						Configuration.clans.set("clan." + args[3] + ".members", members);
						try {
							Configuration.clans.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						clans.put(player.getName(), args[3]);
						
						player.sendMessage(ChatColor.GREEN + "You have created " + ChatColor.AQUA + args[3]);
					}else{
						player.sendMessage(ChatColor.RED + "You are in a clan. use /rpg clan leave to leave");
					}
				}else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Usage: /rpg clan create " + ChatColor.RED + "{name}");
				}
			}else if(args[2].equals("disband")){
				if(isInClan(player)){
					if(isOwner(player)){
						//members
						List<String> members = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".members");
						Iterator<String> keys2 = members.iterator();
						while(keys2.hasNext()){
							String playername = keys2.next().toString();
							clans.remove(playername);
							
							MessageUtils.sendOnline(ChatColor.AQUA + getClan(player) + ChatColor.GREEN + " has been disbanded");
						}
						
						//invites
						List<String> invites = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".invites");
						Iterator<String> keys3 = invites.iterator();
						while(keys3.hasNext()){
							String playername = keys3.next().toString();
							claninvites.remove(playername);
						}
						
						Configuration.clans.set("clan." + getClan(player), null);
						
						try {
							Configuration.clans.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.RED + "You can't disband this clan. You are not the owner!");
					}
				}else{
					player.sendMessage(ChatColor.RED + "You are not in a clan. use /rpg clan create (name) to creat one.");
				}
			}else if(args[2].equals("invite")){
				if(args.length == 3){//rpg clan invite (name)
					if(isInClan(player)){
						if(isOwner(player) || isMod(player)){
							Player P = Bukkit.getServer().getPlayer(args[3]);
							if(P == null){
								player.sendMessage(ChatColor.RED + args[3] + " is offline !");
							} else {
								List<String> invites = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".invites");
								invites.add(P.getName());
								Configuration.clans.set("clan." + getClan(player) + ".invites", invites);
								try {
									Configuration.clans.save();
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								claninvites.put(P.getName(), getClan(player));
							}
						}else{
							player.sendMessage(ChatColor.RED + "You can't invite someone to this clan. You are not the owner or a moderator!");
						}
					}else{
						player.sendMessage(ChatColor.RED + "You are not in a clan. use /rpg clan create (name) to creat one.");
					}
				}else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Usage: /rpg clan invite " + ChatColor.RED + "{name}");
				}
			}else if(args[2].equals("join")){
				if(hasInvite(player)){
					clans.put(player.getName(), getInvitedClan(player));
					claninvites.remove(player.getName());
					
					List<String> invites = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".invites");
					invites.remove(player.getName());
					Configuration.clans.set("clan." + getClan(player) + ".invites", invites);
					
					List<String> members = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".members");
					members.add(player.getName());
					Configuration.clans.set("clan." + getClan(player) + ".members", members);
					try {
						Configuration.clans.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					player.sendMessage(ChatColor.GREEN + "You have now joined " + getClan(player));
				}else{
					player.sendMessage(ChatColor.RED + "You are not invited to a clan.");
				}
			}else if(args[2].equals("leave")){
				if(isInClan(player)){
					List<String> members = (List<String>) Configuration.clans.getList("clan." + getClan(player) + ".members");
					members.remove(player.getName());
					Configuration.clans.set("clan." + getClan(player) + ".members", members);
					try {
						Configuration.clans.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					player.sendMessage(ChatColor.GREEN + "You have now left " + getClan(player));
					
					clans.remove(player.getName());
				}else{
					player.sendMessage(ChatColor.RED + "You are not in a clan. use /rpg clan create (name) to creat one.");
				}
			}else if(args[2].equals("kick")){
				if(args.length == 3){//rpg clan kick (name)
					
				}else {
					player.sendMessage(ChatColor.RED + "Too many arguments !");
					player.sendMessage(ChatColor.AQUA + "Usage: /rpg clan kick " + ChatColor.RED + "{name}");
				}
			}
		}
	}
	
	private static boolean isMod(Player player) {
		return false;
	}

	public static boolean isInClan(Player player) {
		if(clans.containsKey(player.getName())){
			return true;
		}
		return false;
		
	}
	public static boolean hasInvite(Player player) {
		if(claninvites.containsKey(player.getName())){
			return true;
		}
		return false;
		
	}
	
	public static String getClan(Player player){
		String clan = clans.get(player.getName());
		return clan;
	}
	
	public static String getInvitedClan(Player player){
		String clan = claninvites.get(player.getName());
		return clan;
	}
	
	public static boolean isOwner(Player player){
		if(Configuration.clans.getString("clan." + getClan(player) + ".owner").equals(player.getName())){
			return true;
		}
		return false;
	}
	
	public void setupClans(){
		
		ConfigurationSection section = Configuration.clans.getConfigurationSection("clan");
		Iterator<String> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String clan = keys.next().toString();
			
			//members
			List<String> members = (List<String>) Configuration.clans.getList("clan." + clan + ".members");
			Iterator<String> keys2 = members.iterator();
			while(keys2.hasNext()){
				String playername = keys2.next().toString();
				clans.put(playername, clan);
			}
			
			//invites
			List<String> invites = (List<String>) Configuration.clans.getList("clan." + clan + ".invites");
			Iterator<String> keys3 = invites.iterator();
			while(keys3.hasNext()){
				String playername = keys3.next().toString();
				claninvites.put(playername, clan);
			}
		}
		
	}
}
