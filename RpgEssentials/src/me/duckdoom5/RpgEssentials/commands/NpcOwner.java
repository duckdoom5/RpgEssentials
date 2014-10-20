package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcOwner extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc owner
                player.sendMessage(ChatColor.RED + "Not enough arguments!");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc owner " + ChatColor.RED + "{player}");
            } else if (args.length == 2) {// npc owner {player}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.owner") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final RpgNpc rnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                        rnpc.setOwner(Bukkit.getOfflinePlayer(args[1]));

                        player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "owner has been set to " + ChatColor.YELLOW + args[1]);
                        RpgeManager.getInstance().getRpgNpcManager().deselect(player);
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc owner " + ChatColor.RED + "{player}");
            }
        }
    }
}