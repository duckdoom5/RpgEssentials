package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Feed extends Command {

    public Feed() {
        super("feed", "rpg", new String[] {}, new String[] { "player" });
    }

    @Override
    public void execute(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (args.length == 1) {
            if (player != null) {
                if (CommandManager.hasPermission(this, player)) {
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.GREEN + "Your food level has been set to " + ChatColor.YELLOW + "20" + ChatColor.GREEN + " !");
                }
            } else {
                CommandManager.console(sender);
            }
        } else if (args.length == 2) {// rpg feed [player]
            if (RpgEssentials.hasPermission(player, "rpgessentials.rpg.feed.other")) {
                final Player P = Bukkit.getServer().getPlayer(args[1]);
                if (P == null) {
                    sender.sendMessage(ChatColor.RED + args[1] + " is offline !");
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Food level has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "for player: " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
                    P.setFoodLevel(20);
                    P.sendMessage(ChatColor.GREEN + "Your food level has been set to " + ChatColor.YELLOW + "20 " + ChatColor.GREEN + "by: " + ChatColor.AQUA + (player != null ? player.getName() : "CONSOLE") + ChatColor.GREEN + " !");
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Too many arguments !");
            sender.sendMessage(ChatColor.AQUA + "Usage: /rpg feed " + ChatColor.GREEN + "[player]");
        }
    }

}
