package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcRemove extends CommandManager {
    public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
        } else {
            if (args.length == 1) {// npc remove
                if (RpgEssentials.hasPermission(player, "rpgessentials.npc.remove") || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
                    final String id = RpgeManager.getInstance().getRpgNpcManager().getSelected(player);
                    if (id != null) {
                        RpgeManager.getInstance().getRpgNpcManager().deleteRpgNpc(id);
                        RpgeManager.getInstance().getRpgNpcManager().getNPCManager().despawnById(id);
                        RpgeManager.getInstance().getRpgNpcManager().deselect(splayer);
                        player.sendMessage(ChatColor.GREEN + "You have successfully removed NPC: " + ChatColor.YELLOW + id);
                    }
                } else {
                    permissions(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments !");
                player.sendMessage(ChatColor.AQUA + "Usage: /rnpc remove");
            }
        }
    }
}
