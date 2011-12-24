package me.duckdoom5.RpgEssentials;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.GUI.RpgEssentialsScreenListener;
import me.duckdoom5.RpgEssentials.Generator.Generator;
import me.duckdoom5.RpgEssentials.commands.RpgEssentialsCommandExecutor;
import me.duckdoom5.RpgEssentials.config.BlockConfig;
import me.duckdoom5.RpgEssentials.config.Config;
import me.duckdoom5.RpgEssentials.config.ItemConfig;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;

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
	YamlConfiguration config = new YamlConfiguration();
	YamlConfiguration playerconfig = new YamlConfiguration();
	static YamlConfiguration blockconfig = new YamlConfiguration();
	//classes
	private final Config configclass = new Config();
	private final PlayerConfig playerconfigclass = new PlayerConfig();
	private final BlockConfig blockconfigclass = new BlockConfig();
	private final ItemConfig itemconfigclass = new ItemConfig();
	private final RpgEssentialsPlayerListener playerListener = new RpgEssentialsPlayerListener(this);
	private final RpgEssentialsSpoutListener spoutListener = new RpgEssentialsSpoutListener();
	private final RpgEssentialsScreenListener screenListener = new RpgEssentialsScreenListener(this);
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
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://82.74.70.243/server/texturepacks/XXMrPiggyCompanyXX.zip");
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://82.74.70.243/server/shop/bg.png");
		this.loadTextures();
		this.logmsg(true);
		getcmds();
		spoutinstalled();
		log.info("[RpgEssentials] Loading configs...");
		configclass.setconfig();
		playerconfigclass.setplayerconfig();
		blockconfigclass.setblockconfig();
		itemconfigclass.setitemconfig();
		log.info("[RpgEssentials] Done loading configs!");	
		log.info("[RpgEssentials] Adding blocks and items...");
		Hashmaps.registerBlocks(this);
		log.info("[RpgEssentials] Added blocks and items!");
		reg();
		logmsg(true);
	    
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
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.spoutListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, this.screenListener, Event.Priority.Normal, this);
		//player
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_QUIT, this.playerListener, Event.Priority.Normal, this);
		//block
		//entity
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
