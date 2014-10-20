package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.handelers.Mailbox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mail extends CommandManager {

    public static void command(String args[], Player player, CommandSender sender) {
        if (args.length == 1 || args.length == 2) {// rpg mail / rpg mail toplayer
            sender.sendMessage(ChatColor.RED + "Not enough arguments!");
            sender.sendMessage(ChatColor.AQUA + "Usage: /rpg mail " + ChatColor.RED + "{to player} {header + | + message}");
        } else if (args.length > 2) {// rpg mail toplayer header|message
            final Player toplayer = Bukkit.getServer().getPlayer(args[1]);
            if (toplayer == null) {
                player.sendMessage(ChatColor.RED + args[1] + " is offline !");
            } else {
                final StringBuilder raw = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    if (i != 2)
                        raw.append(' ');
                    raw.append(args[i]);
                }
                final String[] text = raw.toString().split("\\|");
                Mailbox.send(player, toplayer, text[0], text[1]);
            }
        } else {
            player.sendMessage(ChatColor.RED + "Not enough arguments!");
            player.sendMessage(ChatColor.AQUA + "Usage: /rpg mail " + ChatColor.RED + "{to player} {header + | + message}");
        }
    }
}
