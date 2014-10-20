package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import java.util.Iterator;

import me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutListener implements Listener {
    @EventHandler
    public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
        final Player player = event.getPlayer();
        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        final World world = player.getWorld();
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);

        final ConfigurationSection section = Configuration.quests.getConfigurationSection("Quests");
        final Iterator<?> keys = section.getKeys(false).iterator();
        while (keys.hasNext()) {
            final String name = (String) keys.next();
            if (Configuration.quests.contains("Quests." + name + ".location")) {
                Methods.addPublicWaypoint(
                        Configuration.quests.getString("Quests." + name + ".text.name"),
                        Configuration.quests.getVector("Quests." + name + ".location"));
            }
        }
        // }
    }
}
