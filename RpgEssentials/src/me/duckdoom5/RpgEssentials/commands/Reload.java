package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload extends CommandManager {
    public static void command(String args[], Player player, CommandSender sender) {
        if (args.length == 1) {// rpg reload
            if (RpgEssentials.hasPermission(player, "rpgessentials.rpg.reload")) {
                RpgEssentials.reload();
                sender.sendMessage(ChatColor.GREEN + "The configs are reloaded !");
            } else {
                permissions(player);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Too many arguments !");
            sender.sendMessage(ChatColor.AQUA + "Usage: /rpg reload");
        }
    }
}
