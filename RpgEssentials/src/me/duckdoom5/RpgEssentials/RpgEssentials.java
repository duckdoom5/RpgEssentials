package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.Generator.Generator;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsBlockListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsEntityListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsInputListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsInventoryListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsPlayerListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsScreenListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsSpoutListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsVehicleListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.config.Config;
import me.duckdoom5.RpgEssentials.config.Configuration;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;

public class RpgEssentials extends JavaPlugin {
    public static RpgEssentials instance;
    private RpgeManager rpgm;

    private final Boolean isDevVersion = true;

    @Override
    public void onEnable() {
        instance = this;
        try {
            final Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (final IOException e) {
            // Failed to submit the stats :-(
        }

        Configuration.start();
        install();
        precache();

        setupVault();

        rpgm = RpgeManager.getInstance();
        rpgm.initialize(this);

        reg();
        logmsg(true);

        if(!isDevVersion && Configuration.config.getBoolean("general.allow version check", true)){
            checkversion();
        }
    }

    @Override
    public void onDisable() {
        logmsg(false);
        RpgeManager.getInstance().getRpgPlayerManager().savePlayers();
    }

    protected void reg() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new RpgEssentialsWorldListener(this), this);
        pm.registerEvents(new RpgEssentialsPlayerListener(this), this);
        pm.registerEvents(new RpgEssentialsInventoryListener(this), this);
        pm.registerEvents(new RpgEssentialsBlockListener(this), this);
        pm.registerEvents(new RpgEssentialsEntityListener(this), this);
        pm.registerEvents(new RpgEssentialsVehicleListener(this), this);
        pm.registerEvents(new RpgEssentialsSpoutListener(this), this);
        pm.registerEvents(new RpgEssentialsScreenListener(this), this);
        pm.registerEvents(new RpgEssentialsInputListener(this), this);
    }

    private void setupVault() {
        getLogger().info("Hooking into Vault...");
        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            if (!setupEconomy())
                getLogger().warning("Can't find an economy plugin; Using built-in.");
            else
                getLogger().info("Found economy via Vault!");
            if (!setupPermissions())
                getLogger().warning("Can't find an permissions plugin.");
            else
                getLogger().info("Found permissions plugin via Vault!");
        } else {
            getLogger().warning("Unable to find: Vault. RpgEssentials will use build in economy.");
        }
    }

    private Boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            Config.economy = economyProvider.getProvider();
        }
        return (Config.economy != null);
    }

    public static Permission permission = null;

    private boolean setupPermissions() {
        final RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    public static boolean hasPermission(Player player, String permissionNode) {
        if (player != null) {
            if (permission != null) {
                return permission.has(player, permissionNode);
            }
            return player.hasPermission(permissionNode);
        }
        return true;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldname, String uid) {
        getLogger().info(Configuration.generator.getString("Global.world.type"));
        if (Configuration.generator.getString("Global.world.type").equals("RpgEssentials")) {
            getLogger().info("Loading rpg");
            return new Generator();
        } else if (Configuration.generator.getString("Global.world.type").equals("RpgNormal")) {
            /*
             * RpgEssentials.getLog().info("Loading normal"); return new
             * NormalWorldGenerator(); try { net.minecraft.server.v1_4_6.World
             * mworld =
             * ((CraftWorld)this.getServer().getWorld(worldname)).getHandle();
             * MinecraftWorld wgen = new MinecraftWorld(mworld, 123456789,
             * true); RpgEssentials.getLog().info(wgen.toString() + wgen.getName());
             * return wgen; } catch(Exception ex) { ex.printStackTrace(); return
             * new MinecraftWorld(null, 123456789, true); if
             * (this.getServer().getWorld(worldname) == null) {
             * RpgEssentials.getLog().info("creating the world"); Environment
             * environment = Environment.NORMAL; WorldCreator worldcreator = new
             * WorldCreator(worldname); worldcreator.environment(environment);
             * this.getServer().createWorld(worldcreator);
             * net.minecraft.server.v1_4_6.World mworld =
             * ((CraftWorld)this.getServer().getWorld(worldname)).getHandle();
             * worldcreator.generator(new MinecraftWorld(null, 123456789,
             * true)); this.getServer().createWorld(worldcreator); for (World w
             * : this.getServer().getWorlds()) {
             * RpgEssentials.getLog().info(w.getName()); } return new
             * MinecraftWorld(mworld, 123456789, true); } else {
             * RpgEssentials.getLog().info("Else"); } }
             */
            // return new
            // NormalWorldGenerator(((CraftWorld)this.getServer().getWorld(worldname)).getHandle());
        }
        getLogger().info("Loading default");
        return null;
    }

    private void install() {
        // Install BO2 files
        String path = getDataFolder() + "/BO2Objects/";
        if (!new File(path).exists()) {
            new File(path).mkdirs();
            final String[] names = { "palm", "prettypine", "deadoak1", "oak1", "smallhut" };
            for (final String name : names) {
                copy(getResource("resources/" + name + ".bo2"), new File(path, name + ".bo2"));
            }
        }

        /*
         * if(config.generator){ //Load BO2 files try {
         * BO2ObjectManager.ReadBO2Files(this.getDataFolder() + "/BO2Objects/");
         * } catch (FileNotFoundException e) { } }
         */

        // Install designs
        path = getDataFolder() + "/Designs/";
        if (!new File(path).exists()) {
            new File(path).mkdirs();
            final String[] names2 = { "anvil", "barrel", "bush", "flower", "pole", "rails", "sign", "slab" };
            for (final String element : names2) {
                copy(getResource("designs/" + element + ".yml"), new File(path, element + ".yml"));
            }
        }
    }

    @SuppressWarnings ("unchecked")
    public void precache() {
        final List<String> list = (List<String>) Configuration.config.getList("spout.precache");
        SpoutManager.getFileManager().addToPreLoginCache(this, list);

        final String[] toPreCache = new String[] { "Ores Texture.url", "Blocks Texture.url", "Stairs Texture.url", "Plants Texture.url", "Misc Texture.url", "Signs Texture.url", "Chatbox Background", "Chatbox Bottom", "Chatbox Top" };
        for (final String name : toPreCache) {
            SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString(name));
        }

        // TODO precache in your own plugin bro
        
        /*if(RpgStores != null){
            if(me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration.config.contains("Background")){
                SpoutManager.getFileManager().addToPreLoginCache(this, me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration.config.getString("Background"));
            }
        }
        if(RpgLeveling != null){
            if(me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.config.contains("Background")){
                SpoutManager.getFileManager().addToPreLoginCache(this, me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.config.getString("Background"));
            }
        }
        
        SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Quests Background"));*/
    }

    private void checkversion() {
        final PluginDescriptionFile pdfile = getDescription();

        try {
            final URI baseURI = new URI("http://forums.bukkit.org/threads/59033/");
            final HttpURLConnection con = (HttpURLConnection) baseURI.toURL().openConnection();
            con.setInstanceFollowRedirects(true);
            if (con.getHeaderField("Location") == null) {
                getLogger().warning("Couldn't connect to RpgEssentials thread to check for updates.");
                return;
            }
            final String url = new URI(con.getHeaderField("Location")).toString();
            if (!url.contains(pdfile.getVersion().replace(".", "-"))) {
                RpgEssentialsPlayerListener.warnOp = true;
                getLogger().warning("---------------ALERT--------------- \n \n There is a new version of RpgEssentials available! \n \n ----------------------------------- \n");
                return;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    private void logmsg(boolean enable) {
        final PluginDescriptionFile pdfile = getDescription();
        if (enable) {
            getLogger().info((isDevVersion ? "dev " : "") + "version: " + pdfile.getVersion() + " is now enabled !");
        } else {
            getLogger().info("is now disabled !");
        }

    }

    public void copy(InputStream in, File file) {
        try (FileOutputStream out = new FileOutputStream(file)) {
            final byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        Configuration.start();
    }
    
    public static Logger getLog(){
        return instance.getLogger();
    }
}
