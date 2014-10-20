package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Speed extends CommandSet {
    
    public Speed() {
        super("speed", "rpg", new String[] { "speed" }, new String[] { "player" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setSpeed(1.0);
        player.sendMessage(ChatColor.GREEN + "All movement has been reset to 1 !");
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        double multi = Double.parseDouble(args[1]);
        if (multi > 10) {
            multi = 10;
            player.sendMessage(ChatColor.RED + "Speed too high, setting to 10 !");
        } else if (multi < -10) {
            multi = -10;
            player.sendMessage(ChatColor.RED + "Speed too low, setting to -10 !");
        }
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setSpeed(multi);
        player.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
    }

    @Override
    public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args) {
        double multi = Double.parseDouble(args[1]);
        if (multi > 10) {
            multi = 10;
            sender.sendMessage(ChatColor.RED + "Speed too high, setting to 10 !");
        } else if (multi < -10) {
            multi = -10;
            sender.sendMessage(ChatColor.RED + "Speed too low, setting to -10 !");
        }
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).setSpeed(multi);
        sender.sendMessage(ChatColor.GREEN + "Speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
        other.sendMessage(ChatColor.GREEN + "Your speed has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
    }
}
