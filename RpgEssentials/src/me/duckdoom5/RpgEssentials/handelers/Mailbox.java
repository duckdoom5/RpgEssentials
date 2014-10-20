package me.duckdoom5.RpgEssentials.handelers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Mailbox {
    public static HashMap<SpoutPlayer, Integer> mails = new LinkedHashMap<>();

    public static void create(RpgEssentials plugin, SpoutPlayer splayer, int x,
            int y, int z) {
        if (!Configuration.mail.contains("Mail." + splayer.getName() + ".mailbox")) {
            Configuration.mail.set("Mail." + splayer.getName() + ".mailbox", x + "," + y + "," + z);
            splayer.sendMessage(ChatColor.GREEN + "Mailbox has been created !");
            try {
                Configuration.mail.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        } else {
            final String raw = Configuration.mail.getString("Mail." + splayer.getName() + ".mailbox");
            final String[] coords = raw.split(",");
            if (x == Integer.parseInt(coords[0]) && y == Integer.parseInt(coords[1]) && z == Integer.parseInt(coords[2])) {
                read(plugin, splayer);
            } else {
                splayer.sendMessage(ChatColor.RED + "This is not your mailbox !");
            }
        }
    }

    public static void send(Player fromplayer, Player toplayer, String header,
            String message) {
        if (!Configuration.mail.contains("Mail." + toplayer.getName() + ".mailbox")) {
            fromplayer.sendMessage(ChatColor.RED + "Player " + toplayer.getName() + " doesn't have a mailbox.");
        } else {
            int mail = 1;
            Configuration.mail.set("Mail." + toplayer.getName() + ".amount",
                    mail);
            while (Configuration.mail.contains("Mail." + toplayer.getName() + ".mails" + mail + ".message")) {
                mail++;
                Configuration.mail.set(
                        "Mail." + toplayer.getName() + ".amount", mail);
            }
            Configuration.mail.set("Mail." + toplayer.getName() + ".mails" + mail + ".header", header);
            Configuration.mail.set("Mail." + toplayer.getName() + ".mails" + mail + ".message", message);
            fromplayer.sendMessage(ChatColor.GREEN + "Message has been send to: " + ChatColor.YELLOW + toplayer.getName());
            toplayer.sendMessage(ChatColor.YELLOW + fromplayer.getName() + ChatColor.GREEN + " has send you a message. Check your mailbox.");
            try {
                Configuration.mail.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(SpoutPlayer splayer) {
        Configuration.mail.set(
                "Mail." + splayer.getName() + ".mails" + mails.get(splayer),
                null);

        try {
            Configuration.mail.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static TextSelectMenu read(RpgEssentials plugin, SpoutPlayer splayer) {
        int mail = 1;
        if (!mails.containsKey(splayer)) {
            mails.put(splayer, 1);
        } else {
            mail = mails.get(splayer);
        }
        final String raw = Configuration.mail.getString("Mail." + splayer.getName() + ".mails" + mail + ".message");

        if (Configuration.mail.contains("Mail." + splayer.getName() + ".mails" + (mail + 1) + ".message")) {
            final String[] buttons = { "Next mail", "Delete", "Close" };
            return new TextSelectMenu(plugin, splayer, "Mailbox !",
                    MessageUtils.TextMenuSplit(raw), buttons);
        }
        final String[] buttons = { "Delete", "Close" };
        return new TextSelectMenu(plugin, splayer, "Mailbox !",
                MessageUtils.TextMenuSplit(raw), buttons);
    }
}
