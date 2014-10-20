package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Texturepack extends CommandManager {
    public static void command(String args[], Player player, SpoutPlayer splayer) {
        if (args.length < 2) {
            player.sendMessage(ChatColor.RED + "Too few arguments");
            player.sendMessage(ChatColor.AQUA + "Usage: /rpg texturepack " + ChatColor.RED + "{url}");
        } else {
            if (args[1].contains(".zip")) {
                if (RpgEssentials.hasPermission(player, "rpgessentials.rpg.texturepack")) {
                    player.sendMessage(player.getName() + args[1]);
                    splayer.setTexturePack(args[1]);
                    player.sendMessage(ChatColor.GREEN + "Texturepack set !");
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Please use a .zip file !");
            }
        }
    }
}
