package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Generator.BO2Populator;
import me.duckdoom5.RpgEssentials.Generator.DungeonPopulator;
import me.duckdoom5.RpgEssentials.Generator.OldStuffDeleter;
import me.duckdoom5.RpgEssentials.Generator.PlantsPopulator;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class RpgEssentialsWorldListener implements Listener {
    public RpgEssentials plugin;

    public HashMap<World, Boolean> generateworlds = new LinkedHashMap<>();

    public RpgEssentialsWorldListener(RpgEssentials instance) {
        plugin = instance;
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent event) {
        final World world = event.getWorld();
        // check if world is enabled for leveling etc
        if (!Configuration.config.contains("worlds.enabled." + world.getName())) {
            Configuration.config.set("worlds.enabled." + world.getName(), true);
            try {
                Configuration.config.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            RpgeManager.getInstance().enabledWorld(world);
        } else {
            if (Configuration.config.getBoolean("worlds.enabled." + world.getName())) {
                RpgeManager.getInstance().enabledWorld(world);
            }
        }

        if (!Configuration.generator.contains("generator.enabled." + world.getName())) {
            Configuration.generator.set("generator.enabled." + world.getName(),
                    false);
            try {
                Configuration.generator.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            generateworlds.put(world, false);
        } else {
            generateworlds.put(
                    world,
                    Configuration.generator.getBoolean("generator.enabled." + world.getName()));
        }

        if (!Configuration.texture.contains(world.getName())) {
            Configuration.texture.set(world.getName() + ".XXMrPiggyCompanyXX.url", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.zip");
            Configuration.texture.set(world.getName() + ".XXMrPiggyCompanyXX.icon", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.png");
            try {
                Configuration.texture.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        Configuration.generator.set("generator.enabled." + world.getName() + ".Ores", false);

        if (generateworlds.get(world)) {
            if (world.getEnvironment().equals(Environment.NORMAL)) {
                // old stuff deleter
                world.getPopulators().add(new OldStuffDeleter());
                /*
                 * //ores
                 * if(Configuration.generator.getBoolean("Global.Ores.Original"
                 * )){ world.getPopulators().add(new VanillaOresPopulator()); }
                 * if(Configuration.generator.getBoolean("Global.Ores.Custom")){
                 * world.getPopulators().add(new CustomOresPopulator()); }
                 */

                // dungeons
                if (Configuration.generator.getBoolean("Global.Structures.dungeons")) {
                    world.getPopulators().add(new DungeonPopulator());
                }

                // BO2objects
                world.getPopulators().add(new BO2Populator());

                // plants
                world.getPopulators().add(new PlantsPopulator());

            } else if (world.getEnvironment().equals(Environment.NETHER)) {
                // add nether populators
            }
        }

        if (Configuration.texture.getBoolean("use default config")) {
            if (!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 32x.url")) {
                Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 32x.url", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.zip");
            }
            if (!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 32x.iconurl")) {
                Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 32x.iconurl", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.png");
            }

            if (!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 16x.url")) {
                Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 16x.url", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.zip");
            }
            if (!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 16x.iconurl")) {
                Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 16x.iconurl", "https://dl.dropboxusercontent.com/u/62672791/RpgEssentials/textures/XXMrPiggyCompanyXX.png");
            }
            try {
                Configuration.texture.save();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    private final Set<String> worlds = new HashSet<>();

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        final World world = event.getPlayer().getWorld();
        if (!worlds.contains(world.getName())) {
            RpgEssentials.getLog().info("!!!!(FAKE) WORLD LOAD EVENT!!!!");
            worlds.add(world.getName());
            RpgeManager.getInstance().getRpgNpcManager().spawnNpcsForWorld(world);
        }
    }

    @EventHandler
    public void onWorldUnload(WorldUnloadEvent event) {
        System.out.println("!!!!WORLD UNLOAD EVENT!!!!");
        final World world = event.getWorld();
        if (worlds.contains(world.getName())) {
            // worlds.remove(world.getName());
        }
    }
}
