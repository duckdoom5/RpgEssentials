package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Money extends CommandSet {
    public Money() {
        super("money", "rpg", new String[] {}, new String[] { "player", "amount" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        final double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).getMoney();
        if (money >= 1000000) {
            player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value") + ChatColor.GREEN + ". A millionare!!");
        } else if (money < 100) {
            player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value") + ChatColor.GREEN + ".... Poor guy");
        } else {
            player.sendMessage(ChatColor.GREEN + "Your current balance is: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value"));
        }
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        try {
            Double.parseDouble(args[1]);
            if (args[1].length() <= 9) {
                final double money = Double.parseDouble(args[1]);
                player.sendMessage(ChatColor.GREEN + "Your balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value"));
                RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setMoney(money);
            } else {
                player.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
            }
        } catch (final NumberFormatException e) {
            if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(args[1]) != null) {
                player.sendMessage(ChatColor.GREEN + args[1] + "'s current balance is: " + ChatColor.YELLOW + RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(args[1]).getMoney() + " " + Configuration.config.getString("currency.value"));
            } else {
                player.sendMessage("That player doesn't exist.");
            }
        }

    }

    @Override
    public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args) {
        if (args[1].length() <= 9) {
            final double money = Double.parseDouble(args[1]);
            sender.sendMessage(ChatColor.GREEN + "Balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value") + " for " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
            other.sendMessage(ChatColor.GREEN + "Your balance has been set to: " + ChatColor.YELLOW + money + " " + Configuration.config.getString("currency.value") + " by: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).setMoney(money);
        } else {
            sender.sendMessage(ChatColor.RED + "Too long, please don't use more than 9 characters");
        }
    }
}
