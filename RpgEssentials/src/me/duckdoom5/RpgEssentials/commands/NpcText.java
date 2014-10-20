package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcText extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length > 1) {// npc text
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.text") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final StringBuilder text = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            if (i != 1)
                                text.append(' ');
                            text.append(args[i]);
                        }
                        RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).setDialogMessage(text.toString());
                        player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "messag has been set to \"" + ChatColor.YELLOW + text.toString() + ChatColor.GREEN + "\"");
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Not enough arguments!");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc text " + ChatColor.RED + "{text}");
            }
        }
    }
}