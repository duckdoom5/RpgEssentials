package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcItem extends CommandManager {

    public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc item
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.item") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        hnpc.setItemInHand(null);
                        player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding nothing");
                    }
                } else {
                    permissions(player);
                }
            } else if (args.length == 2) {// npc item {id}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.item") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);

                        // Use the item in the player's hand
                        if (args[1].equals("hand")) {
                            final ItemStack itemStack = splayer.getItemInHand();
                            hnpc.setItemInHand(itemStack);
                            player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + (new SpoutItemStack(itemStack)).getMaterial().getName());
                        } else {
                            try {
                                final Material material = Material.getMaterial(Integer.parseInt(args[1]));
                                hnpc.setItemInHand(new ItemStack(material));
                                player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + material.toString().toLowerCase().replace("_", " "));
                            } catch (final NumberFormatException e) {
                                // Custom item with "_" instead of spaces
                                if (RpgeManager.getInstance().getMaterialManager().hasMaterial(args[1].replace('_', ' '))) {
                                    final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(args[1].replace('_', ' '));
                                    hnpc.setItemInHand(new SpoutItemStack(smaterial, 1));
                                    player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + args[1]);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Could not find item with that name...");
                                }
                            }
                        }
                    }
                } else {
                    permissions(player);
                }
            } else if (args.length == 3) {// npc item {id} [data]
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.item") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        int matid;
                        short dataid;
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        try {
                            matid = Integer.parseInt(args[1]);
                            dataid = Short.parseShort(args[2]);
                        } catch (final NumberFormatException e) {
                            // Custom item with 2 words in the name
                            if (RpgeManager.getInstance().getMaterialManager().hasMaterial(args[1] + " " + args[2])) {
                                final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(args[1] + " " + args[2]);
                                hnpc.setItemInHand(new SpoutItemStack(smaterial, 1));
                                player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + args[1] + " " + args[2]);
                                return;
                            }
                            player.sendMessage(ChatColor.RED + "Please use a number to specify a item/data value or check item spelling...");
                            return;
                        }
                        final Material material = Material.getMaterial(matid);
                        hnpc.setItemInHand(new ItemStack(material, 1, dataid));
                        player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + material.toString());
                    }
                } else {
                    permissions(player);
                }
            } else {
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.item") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        String itemName = "";
                        // Change the args into a item name string
                        for (int i = 1; i < args.length; i++) {
                            itemName += args[i];
                            if (i != args.length - 1) {
                                itemName += " ";
                            }
                        }
                        // Custom item with more than 2 words in the name
                        if (RpgeManager.getInstance().getMaterialManager().hasMaterial(itemName)) {
                            final org.getspout.spoutapi.material.Material smaterial = RpgeManager.getInstance().getMaterialManager().getMaterialByName(itemName);
                            hnpc.setItemInHand(new SpoutItemStack(smaterial, 1));
                            player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + ChatColor.GREEN + " is now holding: " + ChatColor.AQUA + itemName);
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