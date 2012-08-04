package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;
import com.topcat.npclib.nms.NPCEntity;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class NpcItem extends RpgEssentialsCommandExecutor{
	public NpcItem(RpgEssentials instance) {
		super(instance);
	}
	
	private final static NpcHashmaps npc = new NpcHashmaps();

	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc item
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						NPC np = plugin.m.getNPC(id);
						
						Configuration.npc.set("Npc." + id + ".item", null);
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
						humannpc.getInventory().remove(new ItemStack(humannpc.getInventory().getItemInHand().getType(),humannpc.getInventory().getItemInHand().getAmount(), humannpc.getInventory().getItemInHand().getDurability()));
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " doesn't hold anything anymore");
					}
				} else {
					permissions(player);
				}
			}else if(args.length == 2){//npc item {id}
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						int matid;
						try {
							matid = Integer.parseInt(args[1]);
						} catch (NumberFormatException e) {
						  /*if(Hashmaps.customblocksmap.containsKey(args[1].replace("_", " "))){
							}*/
							player.sendMessage(ChatColor.RED + "Please use a number to specify a item/data value !");
							return;
						}
						Material material = Material.getMaterial(matid);
						NPC np = plugin.m.getNPC(id);
						
						Configuration.npc.set("Npc." + id + ".item", material.getId());
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
						humannpc.setItemInHand(material);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + material.toString().toLowerCase().replace("_", " "));
					}
				} else {
					permissions(player);
				}
			}else if(args.length == 3){//npc item {id} [data]
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						int matid;
						short dataid;
						try {
							matid = Integer.parseInt(args[1]);
							dataid = Short.parseShort(args[2]);
						} catch (NumberFormatException e) {
							player.sendMessage(ChatColor.RED + "Please use a number to specify a item/data value !");
							return;
						}
						Material material = Material.getMaterial(matid);
						NPC np = plugin.m.getNPC(id);
						
						Configuration.npc.set("Npc." + id + ".item", material.getId());
						Configuration.npc.set("Npc." + id + ".item data", material.getData());
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
						humannpc.setItemInHand(material,dataid);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + material.toString());
					}
				} else {
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc item " + ChatColor.RED + "{item id}");
			}
		}
	}
}