package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Skin extends CommandSet {
    public Skin() {
        super("skin", "rpg", new String[] { "url" }, new String[] { "player" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).removeSkin();
        player.sendMessage(ChatColor.RED + "Your skin has been reset !");
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        if (args[1].contains(".png")) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).setSkin(args[1]);
            player.sendMessage(ChatColor.GREEN + "Your skin has been set !");
        }
    }

    @Override
    public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args) {
        if (args[1].contains(".png")) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(other).setSkin(args[1]);
            sender.sendMessage(ChatColor.GREEN + "Skin has been set for player: " + ChatColor.AQUA + other.getName() + ChatColor.GREEN + " !");
            other.sendMessage(ChatColor.GREEN + "Your Skin has been changed by: " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " !");
        }
    }
}
