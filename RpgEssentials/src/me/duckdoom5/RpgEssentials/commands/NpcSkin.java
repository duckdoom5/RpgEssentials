package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcSkin extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc skin
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.skin") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).setSkin(null);
                        player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " skin has been removed");
                    }
                } else {
                    permissions(player);
                }
            } else if (args.length == 2) {// npc skin {url}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.skin") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        if (args[1].contains(".png")) {
                            RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).setSkin(args[1]);
                            player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + id + "'s" + ChatColor.GREEN + " skin has been changed");
                        } else {
                            player.sendMessage(ChatColor.RED + "Skin file must be a png !");
                        }
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc skin " + ChatColor.RED + "{url}");
            }
        }
    }
}