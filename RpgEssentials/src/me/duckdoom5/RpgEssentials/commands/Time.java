package me.duckdoom5.RpgEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Time extends CommandSet {
    public Time() {
        super("time", "rpg", new String[] { "time" }, new String[] { "world" });
    }

    @Override
    public void remove(Player player, SpoutPlayer splayer, String[] args) {
        final World world = player.getWorld();
        final String gettime = gettime((int) world.getTime());
        player.sendMessage(ChatColor.GREEN + "The current time is: " + ChatColor.YELLOW + gettime);
    }

    @Override
    public void setSelf(Player player, SpoutPlayer splayer, String[] args) {
        final World world = player.getWorld();

        if (args[1].toLowerCase().equals("morning") || args[1].toLowerCase().equals("dawn")) {
            world.setTime(0);
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
        } else if (args[1].toLowerCase().equals("day") || args[1].toLowerCase().equals("midday")) {
            world.setTime(6000);
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
        } else if (args[1].toLowerCase().equals("afternoon") || args[1].toLowerCase().equals("dusk")) {
            world.setTime(12000);
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
        } else if (args[1].toLowerCase().equals("night") || args[1].toLowerCase().equals("midnight")) {
            world.setTime(18000);
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + " !");
        } else {
            player.sendMessage(ChatColor.RED + "Please use: day, night, afternoon or morging to set the time!");
        }
    }

    @Override
    public void setOther(Player other, SpoutPlayer sother, CommandSender sender, String[] args) {
        final World world = Bukkit.getWorld(args[2]);
        if (world == null) {
            sender.sendMessage("World does not exist!");
        } else {
            if (args[1].toLowerCase().equals("morning") || args[1].toLowerCase().equals("dawn")) {
                world.setTime(0);
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
            } else if (args[1].toLowerCase().equals("day") || args[1].toLowerCase().equals("midday")) {
                world.setTime(6000);
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
            } else if (args[1].toLowerCase().equals("afternoon") || args[1].toLowerCase().equals("dusk")) {
                world.setTime(12000);
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
            } else if (args[1].toLowerCase().equals("night") || args[1].toLowerCase().equals("midnight")) {
                world.setTime(18000);
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set the time on world: " + ChatColor.YELLOW + world.getName() + ChatColor.GREEN + " to " + ChatColor.YELLOW + args[2] + ChatColor.GREEN + " !");
            } else {
                sender.sendMessage(ChatColor.RED + "Please use: day, night, dusk or dawn to set the time !");
            }
        }
    }

    private static String gettime(int time) {
        String gettime = "";
        if (time < 6000) {
            gettime = "morning";
        } else if (time < 12000) {
            gettime = "day";
        } else if (time < 18000) {
            gettime = "afternoon";
        } else if (time <= 24000) {
            gettime = "night";
        } else {
        }
        return gettime;

    }
}
