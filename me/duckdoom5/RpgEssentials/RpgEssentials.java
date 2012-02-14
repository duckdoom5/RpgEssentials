package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.GUI.StoreHashmaps;
import me.duckdoom5.RpgEssentials.Generator.Generator;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsInventoryListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsBlockListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsEntityListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsFurnaceListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsInputListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsPlayerListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsScreenListener;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsSpoutListener;
import me.duckdoom5.RpgEssentials.commands.RpgEssentialsCommandExecutor;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.BO2ObjectManager;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;

public class RpgEssentials extends JavaPlugin{
	
	public static RpgEssentials plugin;
	public Texture ores, plants, stairs, misc, blocks;
	
	public boolean useSpout = false;
	public boolean useWorldGuard = false;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static final String ln = "[RpgEssentials] ";
	File bo2file;
	
	//classes
	private final RpgEssentialsCommandExecutor command = new RpgEssentialsCommandExecutor(this);
	
	@Override
	public void onDisable() {
		Hashmaps.bushes.clear();
		Hashmaps.customitems.clear();
		Hashmaps.customores.clear();
		Hashmaps.customtools.clear();
		Hashmaps.misc.clear();
		Hashmaps.originalores.clear();
		Hashmaps.plants.clear();
		Hashmaps.stairs.clear();
		logmsg(false);
		
	}

	@Override
	public void onEnable() {
		String path = this.getDataFolder() + "/BO2Objects/";
		new File(path).mkdirs();
		String[] names = {"palm","prettypine","caketree"};
		for(int a = 0; a < names.length; ++a){
			bo2file = new File(path, names[a] + ".bo2");
			copy(getResource("resources/" + names[a] + ".bo2"), bo2file);
		}
		try {
			BO2ObjectManager.ReadBO2Files(this.getDataFolder() + "/BO2Objects/");
		} catch (FileNotFoundException e) {
		}
		
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");//TODO check for config
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://82.74.70.243/server/shop/bg.png");
		log.info("[RpgEssentials] Loading configs...");
		Configuration.start();
		this.loadTextures();
		getcmds();
		spoutinstalled();
		log.info("[RpgEssentials] Done loading configs!");	
		log.info("[RpgEssentials] Adding blocks and items...");
		Hashmaps.registerBlocks(this);
		StoreHashmaps.registerstore(this);
		log.info("[RpgEssentials] Added blocks and items!");
		log.info("[RpgEssentials] Hooking into Vault...");
		if (!setupEconomy())
			log.warning("[RpgEssentials] Can't find an economy plugin; Using built-in.");
		else
			log.info("[RpgEssentials] Found economy via Vault!");
		reg();
		logmsg(true);
	    
	}
	
	public void copy (InputStream in, File file){
        try {
                OutputStream out = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
	
	public ChunkGenerator getDefaultWorldGenerator(String worldname, String uid){
		return new Generator(this);
	}
	
	private void getcmds() {
		getCommand("rpg").setExecutor(command);
		
	}

	public void spoutinstalled(){
		useSpout = false;
		PluginManager pm = Bukkit.getServer().getPluginManager();
		Plugin spout = pm.getPlugin("Spout");
		if(spout.isEnabled()){
			useSpout = true;
			RpgEssentials.log.info("[RpgEssentials] Spout will be used.");
		}else{
			RpgEssentials.log.info("[RpgEssentials] Spout will not be used.");
			useSpout = false;
	
		}
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		
		//player
		pm.registerEvents(new RpgEssentialsPlayerListener(this), this);
		//block
		pm.registerEvents(new RpgEssentialsBlockListener(this), this);
		//furnace
		pm.registerEvents(new RpgEssentialsFurnaceListener(this), this);
		//entity
		pm.registerEvents(new RpgEssentialsEntityListener(this), this);
		//spout
		pm.registerEvents(new RpgEssentialsSpoutListener(this), this);
		pm.registerEvents(new RpgEssentialsScreenListener(this), this);
		pm.registerEvents(new RpgEssentialsInputListener(this), this);
		pm.registerEvents(new RpgEssentialsInventoryListener(this), this);
	}
	protected void logmsg(boolean enable){
		PluginDescriptionFile pdfile = this.getDescription();
		
		if (enable == true) {
			RpgEssentials.log.info("[" + pdfile.getName() + "]" + " version: " + pdfile.getVersion() + " is now enabled !");
		} else {
			RpgEssentials.log.info("[" + pdfile.getName() + "]" + " is now disabled !");
		}
		
	}
	public void loadTextures() {
        ores = new Texture(this, Configuration.config.getString("Ores Texture"), 256, 256, 16);
        blocks = new Texture(this, Configuration.config.getString("Blocks Texture"), 256, 256, 16);
        stairs = new Texture(this, Configuration.config.getString("Stairs Texture"), 256, 256 ,16);
        plants = new Texture(this, Configuration.config.getString("Plants Texture"), 256, 256 ,16);
        misc = new Texture(this, Configuration.config.getString("Misc Texture"), 256, 256 ,16);
	}

    private Boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            PlayerConfig.economy = economyProvider.getProvider();
        }

        return (PlayerConfig.economy != null);
    }
}
