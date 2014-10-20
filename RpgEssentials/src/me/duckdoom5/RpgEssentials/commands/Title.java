package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Title extends CommandSet {
    public Title() {
        super("title", "rpg", new String[] { "title" }, new String[] { "player" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        splayer.resetTitle();
        player.sendMessage(ChatColor.RED + "Title has been reset !");
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        if (args[1].equals("hide") || args[1].equals("hidden") || args[1].equals("null") || args[1].equals("nothing")) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).hidetitle(RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).isHideTitle());
            player.sendMessage(ChatColor.GREEN + "Your title is hidden from view now!");
        } else {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setCustomName(args[1]);
            player.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[1] + "\"" + ChatColor.GREEN + " !");
        }
    }

    @Override
    public void setOther(Player other, SpoutPlayer sother,
            CommandSender sender, String[] args) {
        if (args[1].equals("hide") || args[1].equals("hidden") || args[1].equals("null") || args[1].equals("nothing")) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).hidetitle(RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).isHideTitle());
            sender.sendMessage(ChatColor.GREEN + "Title has been hidden for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
            other.sendMessage(ChatColor.GREEN + "Your Title has been hidden by " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
        } else {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).setCustomName(args[2]);
            sender.sendMessage(ChatColor.GREEN + "Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
            other.sendMessage(ChatColor.GREEN + "Your Title has been set to " + ChatColor.YELLOW + "\"" + args[2] + "\"" + ChatColor.GREEN + " by " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
        }
    }
}
