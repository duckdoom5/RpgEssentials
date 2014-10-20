package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.NPC;

public class NpcCreate extends CommandManager {

    public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc create
                player.sendMessage(ChatColor.RED + "Not enough arguments!");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
            } else if (args.length == 2) {// npc create {name}
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.create") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final Location location = player.getLocation();

                    final NPC npc = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().spawnHumanNPC(args[1], location);
                    RpgeManager.getInstance().getRpgNpcManager().addNPC(RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity(npc.getBukkitEntity()),
                                    new RpgNpc(npc, player));

                    player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " has been created!");
                    RpgeManager.getInstance().getRpgNpcManager().select(splayer, RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity( npc.getBukkitEntity()));
                } else {
                    permissions(player);
                }

            } else if (args.length == 3) {// npc create {name} [type]
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.create") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    if (args[2].equalsIgnoreCase("default") || args[2].equalsIgnoreCase("banker") || args[2].equalsIgnoreCase("quester")) {
                        final Location location = player.getLocation();

                        final NPC npc = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().spawnHumanNPC(args[1], location);
                        RpgNpc rnpc;
                        RpgeManager.getInstance().getRpgNpcManager().addNPC(RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity( npc.getBukkitEntity()), rnpc = new RpgNpc(npc, player));
                        rnpc.setNpcType(me.duckdoom5.RpgEssentials.util.NpcType.valueOf(args[2].toUpperCase()));

                        player.sendMessage(ChatColor.GREEN + "NPC: " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " with type: " + ChatColor.YELLOW + args[2].toLowerCase() + ChatColor.GREEN + " has been created!");
                        RpgeManager.getInstance().getRpgNpcManager().select(splayer, RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity(npc.getBukkitEntity()));
                    } else {
                        player.sendMessage(ChatColor.RED + "Please use a valid type: default/banker/quester");
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
            }
        }
    }
}
