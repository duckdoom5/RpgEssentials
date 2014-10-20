package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;
import me.duckdoom5.RpgEssentials.RpgStores.Listerners.Stores;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcType extends CommandManager {
    public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc type
                player.sendMessage(ChatColor.RED + "Not enough arguments!");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc type " + ChatColor.RED + "{type}");
            } else if (args.length == 2) {// npc type {type}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.type") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    if (me.duckdoom5.RpgEssentials.util.NpcType.contains(args[1])) {
                        final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                        if (id != null) {
                            final RpgNpc rnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);
                            if (!rnpc.getNpcType().equals(me.duckdoom5.RpgEssentials.util.NpcType.valueOf(args[1].toUpperCase()))) {
                                rnpc.setNpcType(me.duckdoom5.RpgEssentials.util.NpcType.valueOf(args[1].toUpperCase()));
                                player.sendMessage(ChatColor.YELLOW + id + "'s " + ChatColor.GREEN + "type has been set to " + ChatColor.YELLOW + args[1].toLowerCase());
                            } else {
                                player.sendMessage(ChatColor.RED + "Your npc already is a " + ChatColor.YELLOW + args[1].toLowerCase());
                            }

                            if (args[1].equalsIgnoreCase("merchant")) {
                                Stores.create(id, splayer);
                            }
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Please use a valid type: default/banker/quester/merchant");
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc type " + ChatColor.RED + "{type}");
            }
        }
    }
}