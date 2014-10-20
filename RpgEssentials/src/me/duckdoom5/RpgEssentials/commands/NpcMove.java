package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NpcMove extends CommandManager {

    public static void command(String args[], Player player, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc walkto
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.move") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        final Location location = player.getLocation();
                        RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).walkTo(location);
                    }
                } else {
                    permissions(player);
                }
            } else if (args.length == 2) {// npc walkto [x,y,z]
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.move") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String[] xyz = args[1].split(",");

                    if (xyz[0] == null || xyz[1] == null || xyz[2] == null) {
                        player.sendMessage(ChatColor.RED + "Please provide a valid location!");
                    } else {
                        final double x = Double.parseDouble(xyz[0]);
                        final double y = Double.parseDouble(xyz[1]);
                        final double z = Double.parseDouble(xyz[2]);

                        final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                        if (id != null) {
                            final Location location = new Location(
                                    player.getWorld(), x, y, z, player.getLocation().getYaw(), player.getLocation().getPitch());
                            RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id).walkTo(location);
                        }
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc move " + ChatColor.GREEN + "[x,y,z]");
            }
        }
    }
}
