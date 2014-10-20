package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.TexturepackGui;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsSpoutListener implements Listener {

    public RpgEssentials plugin;
    private final HashMap<Player, Integer> taskid = new HashMap<>();

    public RpgEssentialsSpoutListener(RpgEssentials instance) {
        plugin = instance;
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
        final Player player = event.getPlayer();
        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        final World world = player.getWorld();
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);

        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);

        if (Configuration.modules.getBoolean("Modules.texturepack") && Configuration.texture.contains(world.getName())) {
            if (!rpgplayer.getTexturepack(world).equals("none") && !rpgplayer.getTexturepack(world).equals("null")) {
                if (Configuration.texture.contains(world.getName() + "." + rpgplayer.getTexturepack(world) + ".url")) {
                    final String url = Configuration.texture.getString(world.getName() + "." + rpgplayer.getTexturepack(world) + ".url");

                    splayer.setTexturePack(url);
                }
            } else if (rpgplayer.getTexturepack(world).equals("null")) {
                new TexturepackGui(plugin, splayer);
            }
        }

        /*
         * //load title + color int combatlvl =
         * Configuration.players.getInt("players."+ player.getName()
         * +".combatlvl"); SpoutPlayer[] onplayers =
         * Spout.getServer().getOnlinePlayers(); for(int i = 0; i <
         * onplayers.length; i++){ int combatlvlother =
         * Configuration.players.getInt("players."+ onplayers[i].getName()
         * +".combatlvl"); if(combatlvl > combatlvlother){ if(combatlvl -
         * combatlvlother <= 5){ colorme = ChatColor.RED; colorother =
         * ChatColor.GREEN; }else{ colorme = ChatColor.DARK_RED; colorother =
         * ChatColor.DARK_GREEN; } }else if(combatlvl < combatlvlother){
         * if(combatlvlother - combatlvl <= 5){ colorme = ChatColor.GREEN;
         * colorother = ChatColor.RED; }else{ colorme = ChatColor.DARK_GREEN;
         * colorother = ChatColor.DARK_RED; } }else if(combatlvl ==
         * combatlvlother){ colorme = ChatColor.YELLOW; colorother =
         * ChatColor.YELLOW; } splayer.setTitleFor(onplayers[i], colorme +
         * Configuration.players.getString("players."+ player.getName()
         * +".title")+ " [lvl: " + combatlvl + "]");
         * 
         * onplayers[i].setTitleFor(SpoutManager.getPlayer(player), colorother +
         * Configuration.players.getString("players."+ onplayers[i].getName()
         * +".title")+ " [lvl: " + combatlvlother + "]"); }
         */

        RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player).initialize();

        if (splayer.isPreCachingComplete()) {
            if (Configuration.config.getBoolean("spout.join.enabled")) {
                if (Configuration.config.getString("spout.join.message").length() > 26 || Configuration.config.getString(
                                "spout.join.submessage").length() > 26) {
                    player.sendMessage(ChatColor.RED + "Tried to welcome you but the message was too long.");
                } else {
                    splayer.sendNotification(Configuration.config.getString("spout.join.message"),
                            Configuration.config.getString("spout.join.submessage"),
                            Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
                }
            }
        } else {
            splayer.sendNotification("Precaching files!", "Please wait...",
                    Material.WATCH);
            if (Configuration.config.getBoolean("spout.join.enabled")) {
                taskid.put(
                        player,
                        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(
                                        Bukkit.getPluginManager().getPlugin(
                                                "RpgEssentials"),
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                if (splayer.isPreCachingComplete()) {
                                                    if (Configuration.config.getString(
                                                                    "spout.join.message").length() > 26 || Configuration.config.getString(
                                                                            "spout.join.submessage").length() > 26) {
                                                        player.sendMessage(ChatColor.RED + "Tried to welcome you but the message was too long.");
                                                    } else {
                                                        splayer.sendNotification(
                                                                Configuration.config.getString("spout.join.message"),
                                                                Configuration.config.getString("spout.join.submessage"),
                                                                Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
                                                    }
                                                    Bukkit.getServer().getScheduler().cancelTask(
                                                                    taskid.get(player));
                                                }
                                            }
                                        }, 2L, 2L));
            }
        }
        // }
    }
}