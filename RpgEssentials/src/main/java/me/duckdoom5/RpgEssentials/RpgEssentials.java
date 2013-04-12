package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayerManager;
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
import me.duckdoom5.RpgEssentials.commands.CommandManager;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.BO2ObjectManager;
import me.duckdoom5.RpgEssentials.util.MaterialManager;
import me.duckdoom5.RpgEssentials.util.RecipeManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;

import com.topcat.npclib.NPCManager;
import com.topcat.npclib.entity.NPC;

public class RpgEssentials extends JavaPlugin{
	public static RpgEssentials plugin;
	public Texture ores, plants, stairs, misc, blocks, signs;
	private Boolean isDevVersion = false;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static final String ln = "[RpgEssentials] ";
	File bo2file, design;
	
	public static boolean battlemusic = true, coindrop = true, texturepack = true;
	
	public static Plugin RpgStores = null, RpgRegions = null, RpgLeveling = null, RpgDeaths = null, RpgQuests = null, RpgBanks = null, WorldGuard = null, WorldEdit = null;
	
	private CommandManager command;
	public static NPCManager nm = null;
	public static MaterialManager mm = null;
	public static RpgPlayerManager pm = null;
	public static RecipeManager rm = null;
	public static RpgEssentialsWorldListener wl = null;
	
	@Override
	public void onDisable() {
		saveNpcs();
		logmsg(false);
		pm.savePlayers();
	}

	private void saveNpcs() {
		List<NPC> list = nm.getNPCs();
		for(NPC npc:list){
			String id = nm.getNPCIdFromEntity(npc.getBukkitEntity());
			Configuration.npc.set("Npc." + id + ".location", npc.getBukkitEntity().getLocation().toVector());
			Configuration.npc.set("Npc." + id + ".world", npc.getBukkitEntity().getWorld().getName());
			Configuration.npc.set("Npc." + id + ".pitch", npc.getBukkitEntity().getLocation().getPitch());
			Configuration.npc.set("Npc." + id + ".yaw", npc.getBukkitEntity().getLocation().getYaw());
		}
		try {
			Configuration.npc.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onEnable() {
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
		command = new CommandManager();
		nm = new NPCManager(this);
		pm = new RpgPlayerManager();
		
		installBO2s();
		
		//Load BO2 files
		try {
			BO2ObjectManager.ReadBO2Files(this.getDataFolder() + "/BO2Objects/");
		} catch (FileNotFoundException e) {
		}
		
		installDesigns();
		
		Configuration.start();
		
		loadModules();
		getcmds();
		precache();
		loadTextures();
		
		log.info("[RpgEssentials] Adding blocks and items...");
		mm = new MaterialManager(this);
		
		log.info("[RpgEssentials] Added blocks and items!");
		rm = new RecipeManager(this);
		
		pm.loadPlayers();
		
		log.info("[RpgEssentials] Hooking into Vault...");
		if(getServer().getPluginManager().getPlugin("Vault") != null){
			if(!setupEconomy())
				log.warning("[RpgEssentials] Can't find an economy plugin; Using built-in.");
			else
				log.info("[RpgEssentials] Found economy via Vault!");
			if(!setupPermissions())
				log.warning("[RpgEssentials] Can't find an permissions plugin.");
			else
				log.info("[RpgEssentials] Found permissions plugin via Vault!");
		}else{
			log.warning("[RpgEssentials] Can't find Vault plugin.");
		}
		
		reg();
		logmsg(true);
		if(!isDevVersion && Configuration.config.getBoolean("allow version check", true)){
			checkversion();
		}
	}
	
	private void installBO2s(){
		//Install BO2 files
		String path = this.getDataFolder() + "/BO2Objects/";
		new File(path).mkdirs();
		String[] names = {"palm", "prettypine", "deadoak1", "oak1", "smallhut"};
		for(int a = 0; a < names.length; ++a){
			bo2file = new File(path, names[a] + ".bo2");
			copy(getResource("resources/" + names[a] + ".bo2"), bo2file);
		}
	}

	private void installDesigns(){
		//Install designs
		String path = this.getDataFolder() + "/Designs/";
		new File(path).mkdirs();
		String[] names = {"anvil", "barrel", "bush", "flower", "pole", "rails", "sign", "slab"};
		for(int a = 0; a < names.length; ++a){
			design = new File(path, names[a] + ".yml");
			copy(getResource("designs/" + names[a] + ".yml"), design);
		}
	}
	
	private void loadModules() {
		if(getServer().getPluginManager().getPlugin("WorldEdit") != null){
			WorldEdit = Bukkit.getPluginManager().getPlugin("WorldEdit");
		}else{
			log.warning("[RpgEssentials] Can't find WorldEdit plugin.");
			//TODO disable RpgRegions in RpgRegions plugin
		}
		
		if(getServer().getPluginManager().getPlugin("WorldGuard") != null){
			WorldGuard = Bukkit.getPluginManager().getPlugin("WorldGuard");
		}else{
			log.warning("[RpgEssentials] Can't find WorldGuard plugin.");
			//TODO disable RpgRegions in RpgRegions plugin
		}
		
		if(getServer().getPluginManager().getPlugin("RpgStores") != null){
			RpgStores = Bukkit.getPluginManager().getPlugin("RpgStores");
		}else{
			log.warning("[RpgEssentials] Can't find RpgStores plugin.");
		}
		
		if(getServer().getPluginManager().getPlugin("RpgRegions") != null){
			if(WorldEdit != null && WorldGuard != null){
				RpgRegions = Bukkit.getPluginManager().getPlugin("RpgRegions");
			}
		}else{
			log.warning("[RpgEssentials] Can't find RpgRegions plugin.");
		}
		
		if(getServer().getPluginManager().getPlugin("RpgLeveling") != null){
			RpgLeveling = Bukkit.getPluginManager().getPlugin("RpgLeveling");
		}else{
			log.warning("[RpgEssentials] Can't find RpgLeveling plugin.");
		}
		
		if(getServer().getPluginManager().getPlugin("RpgBanks") != null){
			RpgBanks = Bukkit.getPluginManager().getPlugin("RpgBanks");
		}else{
			log.warning("[RpgEssentials] Can't find RpgBanks plugin.");
		}
		
		if(getServer().getPluginManager().getPlugin("RpgDeaths") != null){
			RpgDeaths = Bukkit.getPluginManager().getPlugin("RpgDeaths");
		}else{
			log.warning("[RpgEssentials] Can't find RpgDeaths plugin.");
		}
		
		if(getServer().getPluginManager().getPlugin("RpgQuests") != null){
			RpgQuests = Bukkit.getPluginManager().getPlugin("RpgQuests");
		}else{
			log.warning("[RpgEssentials] Can't find RpgQuests plugin.");
		}
		
		battlemusic = Configuration.modules.getBoolean("Modules.battle music");
		coindrop = Configuration.modules.getBoolean("Modules.drop coins");
		texturepack = Configuration.modules.getBoolean("Modules.texturepack");
	}

	private void checkversion() {
		PluginDescriptionFile pdfile = this.getDescription();
		
		try {
			URI baseURI = new URI("http://forums.bukkit.org/threads/59033/");
			HttpURLConnection con = (HttpURLConnection) baseURI.toURL().openConnection();
			con.setInstanceFollowRedirects(false);
			if (con.getHeaderField("Location") == null) {
				log.warning("Couldn't connect to RpgEssentials thread to check for updates.");
				return;
			}
			String url = new URI(con.getHeaderField("Location")).toString();
			if (!url.contains(pdfile.getVersion().replace(".", "-"))) {
				RpgEssentialsPlayerListener.warnOp = true;
				log.warning("---------------ALERT--------------- \n \n There is a new version of RpgEssentials available! \n \n ----------------------------------- \n");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void precache(){
		List<String> list = (List<String>) Configuration.config.getList("spout.precache");
		SpoutManager.getFileManager().addToPreLoginCache(this, list);
		
		//for(RpgWolf.BeltColor bc: RpgWolf.BeltColor.values()){
		//	SpoutManager.getFileManager().addToPreLoginCache(this, bc.getUrl());
		//}
		
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Ores Texture.url"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Blocks Texture.url"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Stairs Texture.url"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Plants Texture.url"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Misc Texture.url"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Sign Texture.url"));
		
		if(RpgStores != null){
			if(me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration.config.contains("Background")){
				SpoutManager.getFileManager().addToPreLoginCache(this, me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration.config.getString("Background"));
			}
		}
		if(RpgLeveling != null){
			if(me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.config.contains("Background")){
				SpoutManager.getFileManager().addToPreLoginCache(this, me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.config.getString("Background"));
			}
		}
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Quests Background"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Chatbox Background"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Chatbox Bottom"));
		SpoutManager.getFileManager().addToPreLoginCache(this, Configuration.texture.getString("Chatbox Top"));
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
	
	public ChunkGenerator getDefaultWorldGenerator(String worldname, String uid) {
		RpgEssentials.log.info(Configuration.generator.getString("Global.world.type"));
		if (Configuration.generator.getString("Global.world.type").equals("RpgEssentials")) {
			RpgEssentials.log.info("Loading rpg");
			return new Generator(this);
		} else if (Configuration.generator.getString("Global.world.type").equals("RpgNormal")) {
			/*RpgEssentials.log.info("Loading normal");
			return new NormalWorldGenerator();
			try {
				net.minecraft.server.v1_4_6.World mworld = ((CraftWorld)this.getServer().getWorld(worldname)).getHandle();
				MinecraftWorld wgen = new MinecraftWorld(mworld, 123456789, true);
				RpgEssentials.log.info(wgen.toString() + wgen.getName());
				return wgen;
			} catch(Exception ex) {
				ex.printStackTrace();
				return new MinecraftWorld(null, 123456789, true);
				if (this.getServer().getWorld(worldname) == null) {
					RpgEssentials.log.info("creating the world");
					Environment environment = Environment.NORMAL;
					WorldCreator worldcreator = new WorldCreator(worldname);
					worldcreator.environment(environment);
					this.getServer().createWorld(worldcreator);
					net.minecraft.server.v1_4_6.World mworld = ((CraftWorld)this.getServer().getWorld(worldname)).getHandle();
					worldcreator.generator(new MinecraftWorld(null, 123456789, true));
					this.getServer().createWorld(worldcreator);
					for (World w : this.getServer().getWorlds()) {
						RpgEssentials.log.info(w.getName());
					}
					return new MinecraftWorld(mworld, 123456789, true);
				} else {
					RpgEssentials.log.info("Else");
				}
			}*/
			//return new NormalWorldGenerator(((CraftWorld)this.getServer().getWorld(worldname)).getHandle());
		}
		RpgEssentials.log.info("Loading default");
		return null;
	}
	
	private void getcmds() {
		getCommand("rpg").setExecutor(command);
		if(Configuration.modules.getBoolean("Modules.npcs")){
				getCommand("rnpc").setExecutor(command);
		}
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		//world
		pm.registerEvents(wl = new RpgEssentialsWorldListener(this), this);
		//player
		pm.registerEvents(new RpgEssentialsPlayerListener(this), this);
		//inventory
		pm.registerEvents(new RpgEssentialsInventoryListener(this), this);
		//block
		pm.registerEvents(new RpgEssentialsBlockListener(this), this);
		//entity
		pm.registerEvents(new RpgEssentialsEntityListener(this), this);
		pm.registerEvents(new RpgEssentialsVehicleListener(this), this);
		//spout
		pm.registerEvents(new RpgEssentialsSpoutListener(this), this);
		pm.registerEvents(new RpgEssentialsScreenListener(this), this);
		pm.registerEvents(new RpgEssentialsInputListener(this), this);
	}
	protected void logmsg(boolean enable){
		PluginDescriptionFile pdfile = this.getDescription();
		if(enable){
			RpgEssentials.log.info("[" + pdfile.getName() + "]" + " version: " + pdfile.getVersion() + " is now enabled !");
		}else{
			RpgEssentials.log.info("[" + pdfile.getName() + "]" + " is now disabled !");
		}
		
	}
	public void loadTextures() {
		int osize = Configuration.texture.getInt("Ores Texture.size");
		int bsize = Configuration.texture.getInt("Blocks Texture.size");
		int ssize = Configuration.texture.getInt("Stairs Texture.size");
		int psize = Configuration.texture.getInt("Plants Texture.size");
		int msize = Configuration.texture.getInt("Misc Texture.size");
		
        ores = new Texture(this, Configuration.texture.getString("Ores Texture.url"), 16*osize, 16*osize, osize);
        blocks = new Texture(this, Configuration.texture.getString("Blocks Texture.url"), 16*bsize, 16*bsize, bsize);
        stairs = new Texture(this, Configuration.texture.getString("Stairs Texture.url"), 16*ssize, 16*ssize ,ssize);
        plants = new Texture(this, Configuration.texture.getString("Plants Texture.url"), 16*psize, 16*psize ,psize);
        misc = new Texture(this, Configuration.texture.getString("Misc Texture.url"), 16*msize, 16*msize ,msize);
        signs = new Texture(this, Configuration.texture.getString("Signs Texture.url"), 16*msize, 16*msize ,msize);
	}
	
	private Boolean setupEconomy(){
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			PlayerConfig.economy = economyProvider.getProvider();
		}
		return (PlayerConfig.economy != null);
	}
	
	public static Permission permission = null;
	private boolean setupPermissions(){
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
    
    public static boolean hasPermission(Player player, String permissionNode){
    	if(player != null){
	    	if (permission != null){
	    		return permission.has(player, permissionNode);
	    	}
	    	return player.hasPermission(permissionNode);
    	}
    	return true;
    }
}
