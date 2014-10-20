package me.duckdoom5.RpgServer.listener;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import me.duckdoom5.RpgServer.RpgServer;
import me.duckdoom5.RpgServer.commands.RpgServerCommandExecutor;
import me.duckdoom5.RpgServer.config.Configuration;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

@SuppressWarnings ("deprecation")
public class RpgServerPlayerListener implements Listener {
    public static RpgServer plugin;

    public RpgServerPlayerListener(RpgServer instance) {
        plugin = instance;
    }

    public static HashMap<String, String> from = new LinkedHashMap<>();
    public static HashMap<String, String> to = new LinkedHashMap<>();

    @EventHandler
    public void onPlayerPreLogin(PlayerPreLoginEvent event) {
        if (Configuration.config.getBoolean("Update.World")) {
            event.disallow(Result.KICK_OTHER, "World update in progress. Please wait ~2 hours until next login.");
        } else if (Configuration.config.getBoolean("Update.Plugin")) {
            event.disallow(Result.KICK_OTHER, "Plugin update in progress. Please wait ~5 minutes until next login.");
        }
    }

    @SuppressWarnings ("unchecked")
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Action action = event.getAction();
        final Block block = event.getClickedBlock();
        if (action == Action.LEFT_CLICK_BLOCK && block.getType().equals(Material.CHEST) && player.isOp()) {
            if (RpgServerCommandExecutor.chest.containsKey(player.getName())) {
                if (RpgServerCommandExecutor.chest.get(player.getName())) {
                    final Chest chest = (Chest) block.getState();
                    final int x = block.getX();
                    final int y = block.getY();
                    final int z = block.getZ();

                    final ItemStack[] items = chest.getInventory().getContents();

                    Configuration.config.set("Chests." + x + "," + y + "," + z,
                            Arrays.asList(items));
                    try {
                        Configuration.config.save();
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }

                    player.sendMessage("The chest is added to the config");
                    event.setCancelled(true);
                }
            }
        }

        if (action == Action.RIGHT_CLICK_BLOCK && block.getType().equals(Material.CHEST)) {
            final int x = block.getX();
            final int y = block.getY();
            final int z = block.getZ();
            if (Configuration.config.contains("Chests." + x + "," + y + "," + z)) {
                final ItemStack[] content = new ItemStack[27];
                final List<ItemStack> list = (List<ItemStack>) Configuration.config.getList("Chests." + x + "," + y + "," + z);
                int count = 0;
                for (final ItemStack item : list) {
                    // have to create a new one, else it will be a "fake" item
                    ItemStack newitem;
                    if (item != null) {
                        newitem = new ItemStack(item.getType(),
                                item.getAmount(), item.getDurability());
                    } else {
                        newitem = item;
                    }
                    content[count] = newitem;
                    count++;
                }
                final Chest chest = (Chest) block.getState();
                chest.getInventory().setContents(content);
            }
        }

        if (player.isOp() && RpgServerCommandExecutor.tp.containsKey(player.getName())) {
            if (RpgServerCommandExecutor.tp.get(player.getName())) {
                if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
                    if (player.getItemInHand().getType() == Material.STICK) {
                        int x, y, z;
                        if (action == Action.RIGHT_CLICK_BLOCK) {
                            x = block.getX();
                            y = block.getY();
                            z = block.getZ();
                        } else {
                            x = player.getLocation().getBlockX();
                            y = player.getLocation().getBlockY();
                            z = player.getLocation().getBlockZ();
                        }
                        final String toS = x + "," + y + "," + z;
                        to.put(player.getName(), toS);
                        player.sendMessage("To possition was set to: " + x + "," + y + "," + z);
                        if (from.containsKey(player.getName())) {
                            addTp(player, from.get(player.getName()),
                                    to.get(player.getName()));
                        }
                    }
                } else if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR) {
                    if (player.getItemInHand().getType() == Material.STICK) {
                        int x, y, z;
                        if (action == Action.LEFT_CLICK_BLOCK) {
                            x = block.getX();
                            y = block.getY();
                            z = block.getZ();
                        } else {
                            x = player.getLocation().getBlockX();
                            y = player.getLocation().getBlockY();
                            z = player.getLocation().getBlockZ();
                        }
                        final String fromS = x + "," + y + "," + z;
                        from.put(player.getName(), fromS);
                        player.sendMessage("From possition was set to: " + x + "," + y + "," + z);
                        if (to.containsKey(player.getName())) {
                            addTp(player, from.get(player.getName()),
                                    to.get(player.getName()));
                        }
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    public void addTp(Player player, String fromS, String toS) {
        to.remove(player.getName());
        from.remove(player.getName());

        final String[] coords = toS.split(",");

        final int x = Integer.parseInt(coords[0]);
        final int y = Integer.parseInt(coords[1]);
        final int z = Integer.parseInt(coords[2]);

        final Vector vec = new Vector(x, y, z);
        Configuration.config.set(fromS + ".location", vec);
        Configuration.config.set(fromS + ".pitch", player.getLocation().getPitch());
        Configuration.config.set(fromS + ".yaw", player.getLocation().getYaw());

        try {
            Configuration.config.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        player.sendMessage("You will now tp from " + fromS + " to " + toS);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        final Location from = event.getTo();
        final int x = from.getBlockX();
        final int y = from.getBlockY();
        final int z = from.getBlockZ();
        final String xyz = x + "," + y + "," + z;
        if (Configuration.config.contains(xyz)) {
            final Vector to = Configuration.config.getVector(xyz + ".location");
            final int pitch = Configuration.config.getInt(xyz + ".pitch");
            final int yaw = Configuration.config.getInt(xyz + ".yaw");

            final Player player = event.getPlayer();
            player.teleport(to.toLocation(player.getWorld(), yaw, pitch));
        }
    }
}
