package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Help extends Command {
    public Help() {
        super("help", "rpg", new String[] {}, new String[] { "page" });
    }

    @Override
    public void execute(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (args.length == 1) {// rpg help
            if (RpgEssentials.hasPermission(player, "rpgessentials.rpg.help")) {
                method(sender, 1);
            }
        } else if (args.length == 2) {// rpg help {page}
            if (RpgEssentials.hasPermission(player, "rpgessentials.rpg.help")) {
                method(sender, Integer.parseInt(args[1]));
            }
        } else {
            CommandManager.tooManyArgs(this, sender);
        }
    }

    public static void method(CommandSender player, int page) {
        if (page == 1) {
            player.sendMessage("");
            player.sendMessage(ChatColor.GREEN + "-----------------{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN + " }----------Page 1/4");
            player.sendMessage(ChatColor.GREEN + "[arg] - Optional  " + ChatColor.RED + "{arg} - required" + ChatColor.AQUA + "  /command");
            int i = 0;
            for (final Command cmd : CommandManager.commands.values()) {
                if (i > 7)
                    break;

                String msg = ChatColor.AQUA + "/" + cmd.getPrefix() + " " + cmd.getCommand() + " ";
                for (final String s : cmd.getRequiredArguments()) {
                    msg += ChatColor.RED + "{" + s + "} ";
                }
                for (final String s : cmd.getOptionalArguments()) {
                    msg += ChatColor.GREEN + "[" + s + "] ";
                }
                player.sendMessage(msg);
                i++;
            }
        } else if (page == 2) {
            player.sendMessage("");
            player.sendMessage(ChatColor.GREEN + "-----------------{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN + " }----------Page 2/4");
            int i = 0;
            for (final Command cmd : CommandManager.commands.values()) {
                if (i > 7) {
                    if (i > CommandManager.commands.size())
                        break;

                    String msg = ChatColor.AQUA + "/" + cmd.getPrefix() + " " + cmd.getCommand() + " ";
                    for (final String s : cmd.getRequiredArguments()) {
                        msg += ChatColor.RED + "{" + s + "} ";
                    }
                    for (final String s : cmd.getOptionalArguments()) {
                        msg += ChatColor.GREEN + "[" + s + "] ";
                    }
                    player.sendMessage(msg);
                }
                i++;
            }
            player.sendMessage("");
            player.sendMessage(ChatColor.AQUA + "/rnpc wand");
            player.sendMessage(ChatColor.AQUA + "/rnpc create " + ChatColor.RED + "{name} " + ChatColor.GREEN + "[type]");
            player.sendMessage(ChatColor.AQUA + "/rnpc select " + ChatColor.RED + "{npc id}");

        } else if (page == 3) {
            player.sendMessage("");
            player.sendMessage(ChatColor.GREEN + "-----------------{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN + " }----------Page 3/4");
            player.sendMessage(ChatColor.AQUA + "/rnpc type " + ChatColor.RED + "{default/quester/banker}");
            player.sendMessage(ChatColor.AQUA + "/rnpc rename " + ChatColor.RED + "{name}");
            player.sendMessage(ChatColor.AQUA + "/rnpc owner " + ChatColor.RED + "{player}");
            player.sendMessage(ChatColor.AQUA + "/rnpc remove");
            player.sendMessage(ChatColor.AQUA + "/rnpc text " + ChatColor.RED + "{text}");
            player.sendMessage(ChatColor.AQUA + "/rnpc move " + ChatColor.GREEN + "[x,y,z]");
            player.sendMessage(ChatColor.AQUA + "/rnpc cape " + ChatColor.RED + "{url}");
            player.sendMessage(ChatColor.AQUA + "/rnpc skin " + ChatColor.RED + "{url}");
            player.sendMessage(ChatColor.AQUA + "/rnpc item " + ChatColor.RED + "{item id}");
        } else if (page == 4) {
            player.sendMessage("");
            player.sendMessage(ChatColor.GREEN + "-----------------{ " + ChatColor.YELLOW + "RpgEssentials help" + ChatColor.GREEN + " }----------Page 4/4");
            player.sendMessage(ChatColor.AQUA + "/rnpc armor " + ChatColor.RED + "{armor id}");
            player.sendMessage(ChatColor.GREEN + "-----------------------------------------------------");
        } else {
            player.sendMessage(ChatColor.RED + "Page doesn't exist !");
        }

    }

}
