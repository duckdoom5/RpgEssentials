package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import me.duckdoom5.RpgEssentials.config.BlockConfig;
import me.duckdoom5.RpgEssentials.config.Config;
import me.duckdoom5.RpgEssentials.config.GeneratorConfig;
import me.duckdoom5.RpgEssentials.config.ItemConfig;
import me.duckdoom5.RpgEssentials.config.LevelConfig;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.config.StoreConfig;
import me.duckdoom5.RpgEssentials.util.BO2ObjectManager;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;

public class RpgEssentials extends JavaPlugin{
	
	public static RpgEssentials plugin;
	public Texture ores, plants, stairs , MiscTextureFile;
	
	public boolean useSpout = false;
	public final Logger log = Logger.getLogger("Minecraft");
	private final YamlConfiguration config = new YamlConfiguration();
	private final YamlConfiguration playerconfig = new YamlConfiguration();
	private final YamlConfiguration blockconfig = new YamlConfiguration();
	private final YamlConfiguration generatorconfig = new YamlConfiguration();
	File bo2file;
	
	//classes
	private final Config configclass = new Config(this);
	private final PlayerConfig playerconfigclass = new PlayerConfig(this);
	private final BlockConfig blockconfigclass = new BlockConfig(this);
	private final ItemConfig itemconfigclass = new ItemConfig(this);
	private final GeneratorConfig generatorconfigclass = new GeneratorConfig(this);
	private final StoreConfig storeconfigclass = new StoreConfig(this);
	private final LevelConfig levelconfigclass = new LevelConfig(this);
	private final RpgEssentialsPlayerListener playerListener = new RpgEssentialsPlayerListener(this);
	private final RpgEssentialsBlockListener blockListener = new RpgEssentialsBlockListener(this);
	private final RpgEssentialsSpoutListener spoutListener = new RpgEssentialsSpoutListener(this);
	private final RpgEssentialsScreenListener screenListener = new RpgEssentialsScreenListener(this);
	private final RpgEssentialsInputListener inputListener = new RpgEssentialsInputListener(this);
	private final RpgEssentialsFurnaceListener furnaceListener = new RpgEssentialsFurnaceListener(this);
	private final RpgEssentialsEntityListener entityListener = new RpgEssentialsEntityListener(this);
	private final RpgEssentialsInventoryListener inventoryListener = new RpgEssentialsInventoryListener(this);
	private final RpgEssentialsCommandExecutor command = new RpgEssentialsCommandExecutor(this);
	
	@Override
	public void onDisable() {
		try {
			config.save("plugins/RpgEssentials/config.yml");
			playerconfig.save("plugins/RpgEssentials/players.yml");
			blockconfig.save("plugins/RpgEssentials/blocks.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		this.loadTextures();
		getcmds();
		spoutinstalled();
		log.info("[RpgEssentials] Loading configs...");
		configclass.setconfig();
		playerconfigclass.setplayerconfig();
		blockconfigclass.setblockconfig();
		itemconfigclass.setitemconfig();
		generatorconfigclass.setgeneratorconfig();
		storeconfigclass.setstoreconfig();
		levelconfigclass.setlevelconfig();
		log.info("[RpgEssentials] Done loading configs!");	
		log.info("[RpgEssentials] Adding blocks and items...");
		Hashmaps.registerBlocks(this);
		StoreHashmaps.registerstore(this);
		log.info("[RpgEssentials] Added blocks and items!");
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
			this.log.info("[RpgEssentials] Spout will be used.");
		}else{
			this.log.info("[RpgEssentials] Spout will not be used.");
			useSpout = false;
	
		}
	}	
	
	protected void reg(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		//spout
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.spoutListener, Event.Priority.Monitor, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.screenListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.inputListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.inventoryListener, Event.Priority.Normal, this);
		//player
		pm.registerEvent(Event.Type.PLAYER_INTERACT, this.playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_FISH, this.playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener, Event.Priority.High, this);
		pm.registerEvent(Event.Type.PLAYER_QUIT, this.playerListener, Event.Priority.Normal, this);
		//block
		pm.registerEvent(Event.Type.BLOCK_BREAK, this.blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, this.blockListener, Event.Priority.Normal, this);
		//furnace
		pm.registerEvent(Event.Type.FURNACE_SMELT, this.furnaceListener, Event.Priority.Normal, this);
		//entity
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, this.entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DEATH, this.entityListener, Event.Priority.Normal, this);
	}
	protected void logmsg(boolean enable){
		PluginDescriptionFile pdfile = this.getDescription();
		
		if (enable == true) {
			this.log.info("[" + pdfile.getName() + "]" + " version: " + pdfile.getVersion() + " is now enabled !");
		} else {
			this.log.info("[" + pdfile.getName() + "]" + " is now disabled !");
		}
		
	}
	public void loadTextures() {
        ores = new Texture(this, "http://82.74.70.243/server/textures/ores.png", 256, 256, 16);
        stairs = new Texture(this, "http://82.74.70.243/server/textures/trap.png", 256, 256 ,16);
        plants = new Texture(this, "http://82.74.70.243/server/textures/plants.png", 256, 256 ,16);
        MiscTextureFile = new Texture(this, "http://dl.dropbox.com/u/19653570/Misc.png", 256, 256, 16);
	}

}
