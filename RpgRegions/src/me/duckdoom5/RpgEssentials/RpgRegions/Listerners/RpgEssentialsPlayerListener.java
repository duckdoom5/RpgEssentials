package me.duckdoom5.RpgEssentials.RpgRegions.Listerners;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgRegions.RpgRegions;
import me.duckdoom5.RpgEssentials.RpgRegions.Config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Music;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.player.RenderDistance;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RpgEssentialsPlayerListener implements Listener {
    public RpgRegions plugin;

    public RpgEssentialsPlayerListener(RpgRegions instance) {
        plugin = instance;
    }

    HashMap<Player, Vector> playerLoc = new HashMap<>();
    HashMap<LocalPlayer, String> inregion = new LinkedHashMap<>();

    public boolean isInRegion(Player player) {
        final WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        final LocalPlayer localplayer = worldguard.wrapPlayer(player);
        if (inregion.containsKey(localplayer))
            return true;
        return false;
    }

    public String getRegion(Player player) {
        final WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        final LocalPlayer localplayer = worldguard.wrapPlayer(player);
        if (inregion.containsKey(localplayer)) {
            return inregion.get(localplayer);
        }
        return null;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        final RpgEssentials rpge = (RpgEssentials) plugin.RpgEssentials;
        final Player player = event.getPlayer();
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);
        if (event.isCancelled())
            return;

        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        if (Bukkit.getPluginManager().isPluginEnabled(
                Bukkit.getPluginManager().getPlugin("WorldGuard"))) {
            final Vector position = new Vector(
                    player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
            if (!playerLoc.containsKey(player)) {
                playerLoc.put(player, position);
                return;
            }
            if (!playerLoc.get(player).equals(position)) {
                playerLoc.put(player, position);
                final WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
                final LocalPlayer localplayer = worldguard.wrapPlayer(event.getPlayer());
                final Vector curpos = localplayer.getPosition();
                final Location to = event.getTo();
                final World world = to.getWorld();
                final RegionManager rm = worldguard.getRegionManager(world);
                final ApplicableRegionSet regions = rm.getApplicableRegions(curpos);

                if (regions.size() == 0) {
                    if (inregion.containsKey(localplayer)) {
                        if (canLeave(player, inregion.get(localplayer))) {
                            if (Configuration.regions.contains("Regions." + inregion.get(localplayer) + ".exit.tpTo")) {
                                final org.bukkit.util.Vector tpTo = Configuration.regions.getVector("Regions." + inregion.get(localplayer) + ".exit.tpTo");
                                final String worldto = Configuration.regions.getString(
                                                "Regions." + inregion.get(localplayer) + ".exit.tpToWorld", "world");
                                final Location loc = tpTo.toLocation(Bukkit.getWorld(worldto));
                                player.teleport(loc);
                            }

                            // SpoutManager.getSkyManager().setSkyColor(splayer,
                            // new Color(0.0F,0.0F,0.0F,1.0F));
                            SpoutManager.getSkyManager().setSkyColor(splayer,
                                    Color.remove());
                            SpoutManager.getSkyManager().setFogColor(splayer,
                                    Color.remove());

                            Music.fadeOut(splayer, 10);

                            // region exit methods
                            final String message = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.message");
                            final String sub = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.submessage");
                            final int icon = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".exit.iconId");
                            final String music = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.music");
                            final String texturepack = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.texturepack");
                            final String command = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.command");
                            final String fog = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".exit.fog");
                            final boolean repeat = Configuration.regions.getBoolean("Regions." + inregion.get(localplayer) + ".exit.repeat");
                            final int time = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".exit.time");

                            if (message != null && sub != null && icon != 0)
                                if (message.length() <= 26 && sub.length() <= 26)
                                    splayer.sendNotification(message, sub,
                                            Material.getMaterial(icon));
                                else
                                    System.out.println("A region message is greater than 26 chars");
                            if (music != null) {
                                Music.fadeOut(splayer, 10);
                                if (repeat)
                                    Music.repeat(rpge, music, splayer,
                                            time > 0 ? time : 1);
                                else
                                    SpoutManager.getSoundManager().playCustomMusic(plugin, splayer,
                                                    music, false);
                            }
                            if (texturepack != null) {
                                splayer.setTexturePack(texturepack);
                            }
                            if (command != null) {
                                splayer.performCommand(command);
                            }
                            if (fog != null) {
                                if (fog.equalsIgnoreCase("tiny")) {
                                    splayer.setRenderDistance(RenderDistance.TINY);
                                } else if (fog.equalsIgnoreCase("short")) {
                                    splayer.setRenderDistance(RenderDistance.SHORT);
                                } else if (fog.equalsIgnoreCase("normal")) {
                                    splayer.setRenderDistance(RenderDistance.NORMAL);
                                } else if (fog.equalsIgnoreCase("far")) {
                                    splayer.setRenderDistance(RenderDistance.FAR);
                                }
                            }

                            inregion.remove(localplayer);
                            return;
                        }
                        player.teleport(event.getFrom());
                        event.setCancelled(true);
                        return;
                    }
                }

                String regionname = null;
                for (final Object name : regions) {
                    final ProtectedRegion protectedregion = (ProtectedRegion) name;
                    regionname = protectedregion.getId();
                }

                if (regionname != null) {
                    if (inregion.containsKey(localplayer) && inregion.get(localplayer).equals(regionname))
                        return;

                    if (canEnter(player, inregion.get(localplayer))) {
                        if (Configuration.regions.contains("Regions." + inregion.get(localplayer) + ".enter.tpTo")) {
                            final org.bukkit.util.Vector tpTo = Configuration.regions.getVector("Regions." + inregion.get(localplayer) + ".enter.tpTo");
                            final String worldto = Configuration.regions.getString(
                                            "Regions." + inregion.get(localplayer) + ".enter.tpToWorld", "world");
                            final Location loc = tpTo.toLocation(Bukkit.getWorld(worldto));
                            player.teleport(loc);
                        }
                        inregion.put(localplayer, regionname);

                        final String message = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.message");
                        final String sub = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.submessage");
                        final int icon = Configuration.regions.getInt("Regions." + inregion.get(localplayer) + ".enter.iconId");
                        final String music = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.music");
                        final String texturepack = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.texturepack");
                        final String command = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.command");
                        final String fog = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.fog");
                        final String skycolor = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.skycolor");
                        final String fogcolor = Configuration.regions.getString("Regions." + inregion.get(localplayer) + ".enter.fogcolor");
                        final boolean repeat = Configuration.regions.getBoolean(
                                        "Regions." + inregion.get(localplayer) + ".enter.repeat", false);
                        final int time = Configuration.regions.getInt(
                                "Regions." + inregion.get(localplayer) + ".enter.time", 1);

                        if (message != null && sub != null && icon != 0)
                            if (message.length() <= 26 && sub.length() <= 26)
                                splayer.sendNotification(message, sub,
                                        Material.getMaterial(icon));
                            else
                                System.out.println("A region message is greater than 26 chars");
                        if (music != null) {
                            Music.fadeOut(splayer, 10);
                            if (repeat)
                                Music.repeat(rpge, music, splayer,
                                        time > 0 ? time : 1);
                            else
                                SpoutManager.getSoundManager().playCustomMusic(
                                        plugin, splayer, music, false);
                        }
                        if (texturepack != null) {
                            splayer.setTexturePack(texturepack);
                        }
                        if (command != null) {
                            splayer.performCommand(command);
                        }
                        if (skycolor != null) {
                            final String[] strings = skycolor.split(" ");
                            final int red = Integer.parseInt(strings[0]);
                            final int green = Integer.parseInt(strings[1]);
                            final int blue = Integer.parseInt(strings[2]);

                            final Color color = new Color(red, green, blue, 1);
                            SpoutManager.getSkyManager().setSkyColor(splayer,
                                    color);
                            splayer.sendMessage("skycolor set");
                        }
                        if (fogcolor != null && skycolor != null) {
                            final String[] strings = skycolor.split(" ");
                            final int red = Integer.parseInt(strings[0]);
                            final int green = Integer.parseInt(strings[1]);
                            final int blue = Integer.parseInt(strings[2]);

                            final Color color = new Color(red, green, blue, 1);
                            SpoutManager.getSkyManager().setFogColor(splayer,
                                    color);
                        }
                        if (fog != null) {
                            if (fog.equalsIgnoreCase("tiny")) {
                                splayer.setRenderDistance(RenderDistance.TINY);
                            } else if (fog.equalsIgnoreCase("short")) {
                                splayer.setRenderDistance(RenderDistance.SHORT);
                            } else if (fog.equalsIgnoreCase("normal")) {
                                splayer.setRenderDistance(RenderDistance.NORMAL);
                            } else if (fog.equalsIgnoreCase("far")) {
                                splayer.setRenderDistance(RenderDistance.FAR);
                            }
                        }
                    } else {
                        event.setCancelled(true);
                        return;
                    }
                }
            }
            // }
        }
    }

    private boolean canLeave(Player player, String region) {
        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName());
        if (!Configuration.regions.getBoolean("Regions." + region + ".exit.canLeave", true)) {
            player.sendMessage(ChatColor.RED + "You can't leave this region!");
            return false;
        }
        if (Configuration.regions.contains("Regions." + region + ".exit.restrictions")) {
            if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.skillLvl")) {
                for (final SkillType skill : SkillType.values()) {
                    if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.minSkillLvl." + skill.toString().toLowerCase())) {
                        final int required = (Configuration.regions.getInt("Regions." + region + ".exit.restrictions.minSkillLvl." + skill.toString().toLowerCase()));
                        if (rpgplayer.getLvl(skill) < required) {
                            player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to leave this region");
                            return false;
                        }
                    }
                }
            }
            if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.maxSkillLvl")) {
                for (final SkillType skill : SkillType.values()) {
                    if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.maxSkillLvl." + skill.toString().toLowerCase())) {
                        final int required = (Configuration.regions.getInt("Regions." + region + ".exit.restrictions.maxSkillLvl." + skill.toString().toLowerCase()));
                        if (rpgplayer.getLvl(skill) > required) {
                            player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to leave this region");
                            return false;
                        }
                    }
                }
            }
            if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.completedQuest")) {
                final ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
                final Set<String> keys = section.getKeys(false);
                for (final String quest : keys) {
                    if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.completedQuest." + quest)) {
                        if (!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("completed")) {
                            final String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest + ".text.name");
                            player.sendMessage(ChatColor.RED + "You need to complete \"" + name + "\"before you may leave this region");
                            return false;
                        }
                    }
                }
            }

            if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.startedQuest")) {
                final ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
                final Set<String> keys = section.getKeys(false);
                for (final String quest : keys) {
                    if (Configuration.regions.contains("Regions." + region + ".exit.restrictions.startedQuest." + quest)) {
                        if (!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")) {
                            final String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest + ".text.name");
                            player.sendMessage(ChatColor.RED + "You need to start \"" + name + "\"before you may leave this region");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean canEnter(Player player, String region) {
        final RpgPlayerLevel rpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName());
        if (!Configuration.regions.getBoolean("Regions." + region + ".enter.canEnter", true)) {
            player.sendMessage(ChatColor.RED + "You can't enter this region!");
            return false;
        }
        if (Configuration.regions.contains("Regions." + region + ".enter.restrictions")) {
            if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.minSkillLvl")) {
                for (final SkillType skill : SkillType.values()) {
                    if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.minSkillLvl." + skill.toString().toLowerCase())) {
                        final int required = (Configuration.regions.getInt("Regions." + region + ".enter.restrictions.minSkillLvl." + skill.toString().toLowerCase()));
                        if (rpgplayer.getLvl(skill) < required) {
                            player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to enter this region");
                            return false;
                        }
                    }
                }
            }
            if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.maxSkillLvl")) {
                for (final SkillType skill : SkillType.values()) {
                    if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.maxSkillLvl." + skill.toString().toLowerCase())) {
                        final int required = (Configuration.regions.getInt("Regions." + region + ".enter.restrictions.maxSkillLvl." + skill.toString().toLowerCase()));
                        if (rpgplayer.getLvl(skill) > required) {
                            player.sendMessage(ChatColor.RED + "You need " + skill.toString().toLowerCase() + " level " + required + " to enter this region");
                            return false;
                        }
                    }
                }
            }
            if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.completedQuest")) {
                final ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
                final Set<String> keys = section.getKeys(false);
                for (final String quest : keys) {
                    if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.completedQuest." + quest)) {
                        if (!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("completed")) {
                            final String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest + ".text.name");
                            player.sendMessage(ChatColor.RED + "You need to complete \"" + name + "\"before you may enter this region");
                            return false;
                        }
                    }
                }
            }

            if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.startedQuest")) {
                final ConfigurationSection section = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getConfigurationSection("Quests");
                final Set<String> keys = section.getKeys(false);
                for (final String quest : keys) {
                    if (Configuration.regions.contains("Regions." + region + ".enter.restrictions.startedQuest." + quest)) {
                        if (!me.duckdoom5.RpgEssentials.config.Configuration.players.getString("players." + player.getName() + ".quest." + quest + ".state").equals("started")) {
                            final String name = me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration.quests.getString("Quests." + quest + ".text.name");
                            player.sendMessage(ChatColor.RED + "You need to start \"" + name + "\"before you may enter this region");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
