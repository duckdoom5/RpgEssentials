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
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.commands.RpgEssentialsCommandExecutor;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.BO2ObjectManager;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.topcat.npclib.NPCManager;
import com.topcat.npclib.entity.NPC;


public class RpgEssentials extends JavaPlugin{
	
	public static RpgEssentials plugin;
	public Texture ores, plants, stairs, misc, blocks;
	
	public static final Logger log = Logger.getLogger("Minecraft");
	public static final String ln = "[RpgEssentials] ";
	File bo2file;
	
	//classes
	private final RpgEssentialsCommandExecutor command = new RpgEssentialsCommandExecutor(this);
	
	public NPCManager m = null;
	
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
		saveNpcs();
		logmsg(false);
		
	}

	private void saveNpcs() {
		List<NPC> list = m.getNPCs();
		for(NPC npc:list){
			String id = m.getNPCIdFromEntity(npc.getBukkitEntity());
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
		this.m = new NPCManager(this);
		
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
		log.info("[RpgEssentials] Loading configs...");
		Configuration.start();
		log.info("[RpgEssentials] loaded configs!");	
		getcmds();
		precache();
		this.loadTextures();
		log.info("[RpgEssentials] Adding blocks and items...");
		Hashmaps.registerBlocks(this);
		StoreHashmaps.registerstore(this);
		log.info("[RpgEssentials] Added blocks and items!");
		log.info("[RpgEssentials] Hooking into Vault...");
		if(getServer().getPluginManager().getPlugin("Vault") != null){
			if(!setupEconomy())
				log.warning("[RpgEssentials] Can't find an economy plugin; Using built-in.");
			else
				log.info("[RpgEssentials] Found economy via Vault!");
		}else{
			log.warning("[RpgEssentials] Can't find Vault plugin; Using built-in.");
		}
		reg();
		pex();
		logmsg(true);
	    checkversion();
	}

	private void checkversion() {
		PluginDescriptionFile pdfile = this.getDescription();
		
		try {
			URI baseURI = new URI("http://forums.bukkit.org/threads/59033/");
			HttpURLConnection con = (HttpURLConnection) baseURI.toURL()
			.openConnection();
			con.setInstanceFollowRedirects(false);
			if (con.getHeaderField("Location") == null) {
				log.warning("Couldn't connect to RpgEssentials thread to check for updates.");
				return;
			}
			String url = new URI(con.getHeaderField("Location")).toString();
			if (!url.contains(pdfile.getVersion().replace(".", "-"))) {
				log.warning(ChatColor.YELLOW + "**ALERT** " + ChatColor.GREEN + "There is a new version of RpgEssentials available!");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void precache(){
		List<?> list = Configuration.config.getList("spout.precache");
		Object[] arraylist = list.toArray();
		for(int pos = 0; pos < arraylist.length; pos++){
			SpoutManager.getFileManager().addToPreLoginCache(this, arraylist[pos].toString());
		}
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
		getCommand("npc").setExecutor(command);
	}
	
	protected void reg(){
		PluginManager pm = this.getServer().getPluginManager();
		//world
		pm.registerEvents(new RpgEssentialsWorldListener(this), this);
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
        ores = new Texture(this, Configuration.texture.getString("Ores Texture"), 256, 256, 16);
        blocks = new Texture(this, Configuration.texture.getString("Blocks Texture"), 256, 256, 16);
        //stairs = new Texture(this, Configuration.texture.getString("Stairs Texture"), 256, 256 ,16);
        plants = new Texture(this, Configuration.texture.getString("Plants Texture"), 256, 256 ,16);
        misc = new Texture(this, Configuration.texture.getString("Misc Texture"), 256, 256 ,16);
	}
	
	private Boolean setupEconomy(){
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			PlayerConfig.economy = economyProvider.getProvider();
		}
		return (PlayerConfig.economy != null);
	}
	
	static PermissionManager pex;
    static boolean usingPex = false;
    
    public void pex() {
        if (this.getServer().getPluginManager().isPluginEnabled("PermissionsEx")) //need PEX to be enabled
        {
            pex = PermissionsEx.getPermissionManager();
            usingPex = true; //so we know we can use PEX
        }
        else
        {
            pex = null;
        }
    }
    
    public static boolean hasPermission(Player player, String permissionNode)
    {
        boolean hasPerm; //does the person have permission?
        if(usingPex)
            hasPerm = pex.has(player, permissionNode); //asking PEX is he does
        else
            hasPerm = player.hasPermission(permissionNode); //asking Bukkit if he does
        return hasPerm;
    }
}
