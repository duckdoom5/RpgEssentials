package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;
import org.getspout.spoutapi.player.accessories.AccessoryType;

public class Accessory extends Command {

    public Accessory() {
        super("accessory", "rpg", new String[] { "type", "url" }, new String[] { "player" });
    }

    @Override
    public void execute(String args[], Player player, SpoutPlayer splayer, CommandSender sender) {
        if (args.length == 1) {
            CommandManager.notEnoughArgs(this, sender);
        } else if (args.length == 2) {// rpg accessory {type}
            if (player != null) {
                if (CommandManager.hasPermission(this, player)) {
                    if (exists(sender, args[1].toUpperCase())) {
                        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).removeAccessory(AccessoryType.valueOf(args[1].toUpperCase()));
                        sender.sendMessage(ChatColor.RED + "Your accessory has been removed !");
                    }
                }
            } else {
                CommandManager.console(sender);
            }
        } else if (args.length == 3) {// rpg accessory {type} {url}
            if (player != null) {
                if (CommandManager.hasPermission(this, player)) {
                    if (exists(sender, args[1].toUpperCase())) {
                        if (args[2].contains(".png")) {
                            splayer.checkUrl(args[2]);
                            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).addAccessory(AccessoryType.valueOf(args[1].toUpperCase()), args[2]);
                            sender.sendMessage(ChatColor.GREEN + "Accessory has been set !");
                        } else {
                            player.sendMessage(ChatColor.RED + "Accessory file must be a png !");
                        }
                    }
                }
            } else {
                CommandManager.console(sender);
            }
        } else if (args.length == 3) {// rpg accessory [type] [url] [player]
            if (CommandManager.hasPermission(this, player, "other")) {
                if (exists(sender, args[1].toUpperCase())) {
                    if (args[2].contains(".png")) {
                        final Player P = Bukkit.getServer().getPlayer(args[2]);
                        if (P == null) {
                            sender.sendMessage(ChatColor.RED + args[2] + " is offline !");
                        } else {
                            if (exists(splayer, args[1].toUpperCase())) {
                                RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(P).addAccessory(AccessoryType.valueOf(args[1].toUpperCase()), args[3]);
                                // SpoutManager.getPlayer(P).addAccessory(AccessoryType.valueOf(args[1].toUpperCase()), args[3]);
                                // PlayerConfig.addAccessory(P, AccessoryType.valueOf(args[1].toUpperCase()), args[3]);
                                sender.sendMessage(ChatColor.GREEN + "Accessory has been set for " + ChatColor.AQUA + P.getName() + ChatColor.GREEN + " !");
                                P.sendMessage(ChatColor.GREEN + "Your " + args[1].toLowerCase() + " has been set by: " + ChatColor.AQUA + (player != null ? player.getName() : "CONSOLE") + ChatColor.GREEN + " !");
                            }
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Accessory file must be a png !");
                    }
                }
            }
        } else {
            CommandManager.tooManyArgs(this, sender);
        }
    }

    private static boolean exists(CommandSender sender, String type) {
        if (type.equals("BRACELET") || type.equals("EARS") || type.equals("NOTCHHAT") || type.equals("SUNGLASSES") || type.equals("TAIL") || type.equals("TOPHAT") || type.equals("WINGS")) {
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Not a valid accessory type, please use: bracelet/ears/notchhat/sunglasses/tail/tophat/wings");
        return false;
    }
}
