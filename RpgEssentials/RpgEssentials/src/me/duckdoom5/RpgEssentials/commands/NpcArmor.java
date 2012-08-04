package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.HumanNPC;

public class NpcArmor extends RpgEssentialsCommandExecutor{
	public NpcArmor(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc armour
				if(plugin.hasPermission(player, "rpgessentials.npc.armor") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						HumanNPC hnpc = (HumanNPC) RpgEssentials.nm.getNPC(id);
						hnpc.getInventory().setHelmet(new ItemStack(Material.getMaterial(0), 0 , (short) -1));
						hnpc.getInventory().setChestplate(new ItemStack(Material.getMaterial(0), 0 , (short) -1));
						hnpc.getInventory().setLeggings(new ItemStack(Material.getMaterial(0), 0 , (short) -1));
						hnpc.getInventory().setBoots(new ItemStack(Material.getMaterial(0), 0 , (short) -1));
						
						player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "armor has been cleared");
						
						Configuration.npc.set("Npc." + id + ".helmet", null);
						Configuration.npc.set("Npc." + id + ".chestplate", null);
						Configuration.npc.set("Npc." + id + ".leggings", null);
						Configuration.npc.set("Npc." + id + ".boots", null);
						
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				} else {
					permissions(player);
				}
			}else if(args.length == 2){//npc armour {armour id}
				if(plugin.hasPermission(player, "rpgessentials.npc.armor") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						HumanNPC hnpc = (HumanNPC) RpgEssentials.nm.getNPC(id);
						if(args[1].equals("298") || args[1].equals("302") || args[1].equals("306") || args[1].equals("314") || args[1].equals("310")){
							
							hnpc.getInventory().setHelmet(new ItemStack(Material.getMaterial(Integer.parseInt(args[1])), 1));
							Configuration.npc.set("Npc." + id + ".helmet", args[1]);
							player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "helmet has been set to " + Material.getMaterial(Integer.parseInt(args[1])).toString().toLowerCase().replace("_", " "));
							
						}else if(args[1].equals("299") || args[1].equals("303") || args[1].equals("307") || args[1].equals("315") || args[1].equals("311")){
							
							hnpc.getInventory().setChestplate(new ItemStack(Material.getMaterial(Integer.parseInt(args[1])),1));
							Configuration.npc.set("Npc." + id + ".chestplate", args[1]);
							player.sendMessage(ChatColor.YELLOW + id + "'s " +  ChatColor.GREEN + "chestplate has been set to " + Material.getMaterial(Integer.parseInt(args[1])).toString().toLowerCase().replace("_", " "));
							
						}else if(args[1].equals("300") || args[1].equals("304") || args[1].equals("308") || args[1].equals("316") || args[1].equals("312")){
							
							hnpc.getInventory().setLeggings(new ItemStack(Material.getMaterial(Integer.parseInt(args[1])),1));
							Configuration.npc.set("Npc." + id + ".leggings", args[1]);
							player.sendMessage(ChatColor.YELLOW + id + "'s " +  ChatColor.GREEN + "leggings has been set to " + Material.getMaterial(Integer.parseInt(args[1])).toString().toLowerCase().replace("_", " "));
							
						}else if(args[1].equals("301") || args[1].equals("305") || args[1].equals("309") || args[1].equals("317") || args[1].equals("313")){
							
							hnpc.getInventory().setBoots(new ItemStack(Material.getMaterial(Integer.parseInt(args[1])),1));
							Configuration.npc.set("Npc." + id + ".boots", args[1]);
							player.sendMessage(ChatColor.YELLOW + id + "'s " +  ChatColor.GREEN + "boots has been set to " + Material.getMaterial(Integer.parseInt(args[1])).toString().toLowerCase().replace("_", " "));
							
						}else{
							player.sendMessage(ChatColor.RED + "Please use a valid armor id!");
						}
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
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc armor " + ChatColor.RED + "{armor id}");
			}
		}
	}
}