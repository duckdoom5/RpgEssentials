package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Jump extends CommandSet {
    public Jump() {
        super("jump", "rpg", new String[] { "height" }, new String[] { "player" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setJump(1.0);
        player.sendMessage(ChatColor.GREEN + "Jumping multiplier has been reset to 1 !");
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        double multi = Double.parseDouble(args[1]);
        if (multi > 10) {
            multi = 10;
            player.sendMessage(ChatColor.RED + "Multiplier too high, setting to 10 !");
        } else if (multi < -10) {
            multi = -10;
            player.sendMessage(ChatColor.RED + "Multiplier too low, setting to -10 !");
        }
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setJump(multi);
        player.sendMessage(ChatColor.GREEN + "Your jumping height has been to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
    }

    @Override
    public void setOther(Player other, SpoutPlayer sother,
            CommandSender sender, String[] args) {
        double multi = Double.parseDouble(args[1]);
        if (multi > 10) {
            multi = 10;
            sender.sendMessage(ChatColor.RED + "Multiplier too high, setting to 10 !");
        } else if (multi < -10) {
            multi = -10;
            sender.sendMessage(ChatColor.RED + "Multiplier too low, setting to -10 !");
        }
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).setJump(multi);
        sender.sendMessage(ChatColor.GREEN + "Jumping multiplier has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
        other.sendMessage(ChatColor.GREEN + "Your jumping multiplier has been set to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " by player: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + "!");
    }
}
