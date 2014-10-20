package me.duckdoom5.RpgEssentials;

import java.util.HashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayerManager;
import me.duckdoom5.RpgEssentials.commands.CommandManager;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.AddonType;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;

public class RpgeManager {
    // public static boolean battlemusic = true, coindrop = true, texturepack =
    // true;
    public Texture ores, plants, stairs, misc, blocks, signs;

    private static RpgeManager instance = null;
    private final HashMap<String, World> enabledWorlds = new HashMap<>();
    private final HashMap<String, Plugin> plugins = new HashMap<>();
    private RpgNpcManager nm;
    private MaterialManager mm;
    private RpgPlayerManager pm;
    private RecipeManager rm;
    private CommandManager cm;

    public static RpgeManager getInstance() {
        if (instance == null) {
            instance = new RpgeManager();
        }
        return instance;
    }

    public void initialize(RpgEssentials plugin) {
        loadModules(plugin);
        loadTextures(plugin);

        plugin.getLogger().info("Adding blocks and items...");
        mm = new MaterialManager(plugin);
        plugin.getLogger().info("Added blocks and items!");

        rm = new RecipeManager();
        nm = new RpgNpcManager(plugin);
        nm.loadNpcs();
        pm = new RpgPlayerManager();
        pm.loadPlayers();
        cm = new CommandManager();

        plugin.getCommand("rpg").setExecutor(cm);
        if (Configuration.modules.getBoolean("Modules.npcs")) {
            plugin.getCommand("rnpc").setExecutor(cm);
        }
    }

    public void loadTextures(RpgEssentials plugin) {
        final int osize = Configuration.texture.getInt("Ores Texture.size");
        final int bsize = Configuration.texture.getInt("Blocks Texture.size");
        final int ssize = Configuration.texture.getInt("Stairs Texture.size");
        final int psize = Configuration.texture.getInt("Plants Texture.size");
        final int msize = Configuration.texture.getInt("Misc Texture.size");

        ores = new Texture(plugin, Configuration.texture.getString("Ores Texture.url"), 16 * osize, 16 * osize, osize);
        blocks = new Texture(plugin, Configuration.texture.getString("Blocks Texture.url"), 16 * bsize, 16 * bsize, bsize);
        stairs = new Texture(plugin, Configuration.texture.getString("Stairs Texture.url"), 16 * ssize, 16 * ssize, ssize);
        plants = new Texture(plugin, Configuration.texture.getString("Plants Texture.url"), 16 * psize, 16 * psize, psize);
        misc = new Texture(plugin, Configuration.texture.getString("Misc Texture.url"), 16 * msize, 16 * msize, msize);
        signs = new Texture(plugin, Configuration.texture.getString("Signs Texture.url"), 16 * msize, 16 * msize, msize);
    }

    private void loadModules(RpgEssentials plugin) {
        final String[] names = { "WorldEdit", "WorldGuard", "RpgStores", "RpgRegions", "RpgLeveling", "RpgBanks", "RpgDeaths", "RpgQuests" };

        for (final String name : names) {
            plugins.put(name, Bukkit.getPluginManager().getPlugin(name));
            if (plugins.get(name) == null) {
                plugin.getLogger().warning("Unable to find: " + name + ".");
            }
        }
    }

    public void enabledWorld(World world) {
        enabledWorlds.put(world.getName(), world);
    }

    public boolean isWorldEnabled(String name) {
        return enabledWorlds.get(name) != null;
    }

    public boolean isWorldEnabled(World world) {
        return enabledWorlds.containsValue(world);
    }

    public boolean isAddonEnabled(AddonType type) {
        return plugins.get(type.getName()) != null;
    }

    public Plugin getAddon(String addonName) {
        return plugins.get(addonName);
    }

    public RpgPlayerManager getRpgPlayerManager() {
        return pm;
    }

    public RpgNpcManager getRpgNpcManager() {
        return nm;
    }

    public MaterialManager getMaterialManager() {
        return mm;
    }

    public RecipeManager getRecipeManager() {
        return rm;
    }

    public CommandManager getCommandManager() {
        return cm;
    }
}
