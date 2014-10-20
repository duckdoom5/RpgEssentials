package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcWand extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc wand
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.wand") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    player.getInventory().addItem(
                            RpgeManager.getInstance().getMaterialManager().getCustomItem("NPC Wand"));
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc wand");
            }
        }
    }
}
