package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcCape extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
            if (id != null && id != "") {
                final RpgNpc npc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);

                if (args.length == 1) {// npc cape
                    if (RpgEssentials.hasPermission(player, "rpgessentials.npc.cape") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                        npc.setCape(null);
                    } else {
                        permissions(player);
                    }
                } else if (args.length == 2) {// npc cape {url}
                    if (RpgEssentials.hasPermission(player, "rpgessentials.npc.cape")) {
                        if (args[1].contains(".png")) {
                            npc.setCape(args[1]);
                            player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " cape has been changed");
                        } else {
                            player.sendMessage(ChatColor.RED + "Cape file must be a png !");
                        }
                    } else {
                        permissions(player);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Too many arguments !");
                    player.sendMessage(ChatColor.AQUA + "Usage: /npc cape " + ChatColor.RED + "{url}");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Error, no npc selected !");
            }
        }
    }
}