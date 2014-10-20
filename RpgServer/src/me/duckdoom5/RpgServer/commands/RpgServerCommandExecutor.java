package me.duckdoom5.RpgServer.commands;

import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgServer.RpgServer;
import me.duckdoom5.RpgServer.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RpgServerCommandExecutor implements CommandExecutor {
    public static RpgServer plugin;

    public RpgServerCommandExecutor(RpgServer instance) {
        plugin = instance;
    }

    public static HashMap<String, Boolean> chest = new LinkedHashMap<>();
    public static HashMap<String, Boolean> tp = new LinkedHashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label,
            String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equalsIgnoreCase("tut")) {
                    if (args[0].equals("chest")) {
                        chest.put(player.getName(), true);
                        player.sendMessage(ChatColor.GREEN + "Please left click the chest");
                        return true;
                    } else if (args[0].equals("tpStick")) {
                        if (tp.containsKey(player.getName())) {
                            if (tp.get(player.getName())) {
                                tp.put(player.getName(), false);
                                player.sendMessage(ChatColor.RED + "Tp stick deactivated");
                            } else {
                                tp.put(player.getName(), true);
                                player.sendMessage(ChatColor.GREEN + "Tp stick activated");
                            }
                        } else {
                            tp.put(player.getName(), true);
                            player.sendMessage(ChatColor.GREEN + "Tp stick activated");
                        }
                        return true;
                    } else if (args[0].equals("reload")) {
                        if (args.length == 1) {// rpg reload
                            Configuration.start();
                            sender.sendMessage(ChatColor.GREEN + "The configs are reloaded !");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Too many arguments !");
                            sender.sendMessage(ChatColor.AQUA + "Usage: /rpg reload");
                        }
                    } else if (args[0].equals("update")) {
                        if (args[1].equals("world")) {
                            if (args[2].equals("true")) {
                                Configuration.config.set("Update.World", true);
                                sender.sendMessage(ChatColor.GREEN + "World update set to true!");
                            } else if (args[2].equals("false")) {
                                Configuration.config.set("Update.World", false);
                                sender.sendMessage(ChatColor.GREEN + "World update set to false!");
                            }
                        } else if (args[1].equals("plugin")) {
                            if (args[2].equals("true")) {
                                Configuration.config.set("Update.Plugin", true);
                                sender.sendMessage(ChatColor.GREEN + "Plugin update set to true!");
                            } else if (args[2].equals("false")) {
                                Configuration.config.set("Update.Plugin", false);
                                sender.sendMessage(ChatColor.GREEN + "Plugin update set to false!");
                            }
                        }
                    }
                }
            }
        } else {
            if (cmd.getName().equalsIgnoreCase("tut")) {
                if (args[0].equals("reload")) {
                    if (args.length == 1) {// rpg reload
                        Configuration.start();
                        sender.sendMessage(ChatColor.GREEN + "The configs are reloaded !");
                    } else {
                        sender.sendMessage(ChatColor.RED + "Too many arguments !");
                        sender.sendMessage(ChatColor.AQUA + "Usage: /rpg reload");
                    }
                } else if (args[0].equals("update")) {
                    if (args[1].equals("world")) {
                        if (args[2].equals("true")) {
                            Configuration.config.set("Update.World", true);
                            try {
                                Configuration.config.save();
                                Configuration.config.reload();
                            } catch (final Exception e) {
                                e.printStackTrace();
                            }
                            sender.sendMessage(ChatColor.GREEN + "World update set to true!");
                        } else if (args[2].equals("false")) {
                            Configuration.config.set("Update.World", false);
                            try {
                                Configuration.config.save();
                                Configuration.config.reload();
                            } catch (final Exception e) {
                                e.printStackTrace();
                            }
                            sender.sendMessage(ChatColor.GREEN + "World update set to false!");
                        }
                    } else if (args[1].equals("plugin")) {
                        if (args[2].equals("true")) {
                            Configuration.config.set("Update.Plugin", true);
                            try {
                                Configuration.config.save();
                                Configuration.config.reload();
                            } catch (final Exception e) {
                                e.printStackTrace();
                            }
                            sender.sendMessage(ChatColor.GREEN + "Plugin update set to true!");
                        } else if (args[2].equals("false")) {
                            Configuration.config.set("Update.Plugin", false);
                            try {
                                Configuration.config.save();
                                Configuration.config.reload();
                            } catch (final Exception e) {
                                e.printStackTrace();
                            }
                            sender.sendMessage(ChatColor.GREEN + "Plugin update set to false!");
                        }
                    }
                }
            }
        }
        return true;
    }
}
