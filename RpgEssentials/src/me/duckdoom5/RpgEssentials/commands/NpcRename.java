package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcRename extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc rename
                player.sendMessage(ChatColor.RED + "Not enough arguments!");
                player.sendMessage(ChatColor.AQUA + "Useage: /rnpc rename " + ChatColor.RED + "{name}");
            } else if (args.length == 2) {// npc rename {name}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.rename") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).setName(args[1]);

                        player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " name is now: " + ChatColor.YELLOW + args[1]);
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc rename " + ChatColor.RED + "{name}");
            }
        }
    }
}
