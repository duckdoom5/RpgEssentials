package me.duckdoom5.RpgEssentials.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
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
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						NPC np = RpgEssentials.nm.getNPC(id);
						
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
			} else if (args.length == 2){//npc item {id}
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						NPC np = RpgEssentials.nm.getNPC(id);
						HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
						if (args[1].equals("hand")) {
							ItemStack itemStack = new ItemStack(splayer.getItemInHand().getType(), 1);
							itemStack.setDurability(splayer.getItemInHand().getDurability());
							Configuration.npc.set("Npc." + id + ".item", itemStack.getTypeId() + ":" + itemStack.getDurability());
							humannpc.getSpoutPlayer().setItemInHand(itemStack);
							player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + (new SpoutItemStack(itemStack)).getMaterial().getName());
						} else {
							try {
								int matid = Integer.parseInt(args[1]);
								Configuration.npc.set("Npc." + id + ".item", matid);
								humannpc.setItemInHand(Material.getMaterial(matid));
								player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + Material.getMaterial(matid).toString().toLowerCase().replace("_", " "));
							} catch (NumberFormatException e) {
								int customId = 0;
								Material material = Material.FLINT;
								if(RpgEssentials.mm.hasMaterial(args[1].replace('_', ' '))){
									org.getspout.spoutapi.material.Material smaterial = RpgEssentials.mm.getMaterialByName(args[1].replace('_', ' '));
									Configuration.npc.set("Npc." + id + ".item", smaterial.getRawId() + ":" + smaterial.getRawData());
									humannpc.getSpoutPlayer().setItemInHand(new SpoutItemStack(smaterial, 1));
									player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + args[1]);
								}else{
									player.sendMessage(ChatColor.RED + "Could not find item with that name...");
								}
							}
						}
						//TODO NPC SAVE METHOD!!!
						
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					permissions(player);
				}
			} else if(args.length == 3) {//npc item {id} [data]
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						int matid;
						short dataid;
						HumanNPC humannpc = new HumanNPC((NPCEntity) RpgEssentials.nm.getNPC(id).getEntity());
						try {
							matid = Integer.parseInt(args[1]);
							dataid = Short.parseShort(args[2]);
						} catch (NumberFormatException e) {
							if(RpgEssentials.mm.hasMaterial(args[1] + " " + args[2])) {
								org.getspout.spoutapi.material.Material smaterial = RpgEssentials.mm.getMaterialByName(args[1] + " " + args[2]);
								Configuration.npc.set("Npc." + id + ".item", smaterial.getRawId() + ":" + smaterial.getRawData());
								humannpc.getSpoutPlayer().setItemInHand(new SpoutItemStack(smaterial, 1));
								player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + args[1] + " " + args[2]);
								return;
							}
							player.sendMessage(ChatColor.RED + "Please use a number to specify a item/data value or check item spelling...");
							return;
						}
						Material material = Material.getMaterial(matid);
						
						Configuration.npc.set("Npc." + id + ".item", matid + ":" + dataid);
						try {
							Configuration.npc.save();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						humannpc.setItemInHand(material,dataid);
						player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + material.toString());
					}
				} else {
					permissions(player);
				}
			}else{
				if(plugin.hasPermission(player, "rpgessentials.npc.item") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					String id = npc.getSelected(player);
					if(id != null){
						HumanNPC humannpc = new HumanNPC((NPCEntity) RpgEssentials.nm.getNPC(id).getEntity());
						String itemName = "";
						// Change the args into a item name string
						for (int i = 1; i < args.length; i++) {
							itemName += args[i];
							if (i != args.length - 1) {
								itemName += " ";
							}
						}
						// Custom item with more than 2 words in the name
						if(RpgEssentials.mm.hasMaterial(itemName)) {
							org.getspout.spoutapi.material.Material smaterial = RpgEssentials.mm.getMaterialByName(itemName);
							Configuration.npc.set("Npc." + id + ".item", "" + smaterial.getRawId() + ":" + smaterial.getRawData());
							humannpc.getSpoutPlayer().setItemInHand(new SpoutItemStack(smaterial, 1));
							player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + itemName);
							
							try {
								Configuration.npc.save();
							} catch (IOException e) {
								e.printStackTrace();
							}							
							return;
						}
					}
				}
				player.sendMessage(ChatColor.RED + "Too many arguments or item not found...");
				player.sendMessage(ChatColor.AQUA + "Usage: /rnpc item " + ChatColor.RED + "{item id} {item data}");
				player.sendMessage(ChatColor.AQUA + "           /rnpc item " + ChatColor.RED + "{item name}");
			}
		}
	}
}