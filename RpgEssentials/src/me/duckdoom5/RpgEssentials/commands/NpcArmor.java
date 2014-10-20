package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NpcArmor extends CommandManager {

    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc armour
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.armor") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        hnpc.setArmor(0, new ItemStack(Material.AIR, 0, (short) -1));
                        hnpc.setArmor(1, new ItemStack(Material.AIR, 0, (short) -1));
                        hnpc.setArmor(2, new ItemStack(Material.AIR, 0, (short) -1));
                        hnpc.setArmor(3, new ItemStack(Material.AIR, 0, (short) -1));

                        player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "armor has been cleared");
                    }
                } else {
                    permissions(player);
                }
            } else if (args.length == 2) {// npc armour {armour id}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.armor") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    final Material m = Material.getMaterial(Integer.parseInt(args[1]));
                    if (id != null) {
                        final RpgNpc hnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        if (args[1].equals("299") || args[1].equals("303") || args[1].equals("307") || args[1].equals("315") || args[1].equals("311")) {
                            hnpc.setArmor(2, new ItemStack(m));
                            player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "chestplate has been set to " + m.toString().toLowerCase().replace("_", " "));

                        } else if (args[1].equals("300") || args[1].equals("304") || args[1].equals("308") || args[1].equals("316") || args[1].equals("312")) {

                            hnpc.setArmor(3, new ItemStack(m));
                            player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "leggings has been set to " + m.toString().toLowerCase().replace("_", " "));

                        } else if (args[1].equals("301") || args[1].equals("305") || args[1].equals("309") || args[1].equals("317") || args[1].equals("313")) {

                            hnpc.setArmor(4, new ItemStack(m));
                            player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "boots has been set to " + m.toString().toLowerCase().replace("_", " "));

                        } else {
                            hnpc.setArmor(0, new ItemStack(m));
                            player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "helmet has been set to " + m.toString().toLowerCase().replace("_", " "));
                        }
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc armor " + ChatColor.RED + "{armor id}");
            }
        }
    }
}