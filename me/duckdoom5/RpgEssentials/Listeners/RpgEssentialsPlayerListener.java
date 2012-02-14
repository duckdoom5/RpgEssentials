package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.levels.Farming;
import me.duckdoom5.RpgEssentials.levels.Firemaking;
import me.duckdoom5.RpgEssentials.levels.Fishing;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.player.RenderDistance;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RpgEssentialsPlayerListener implements Listener{
	
    public static RpgEssentials plugin;
    public final Logger log = Logger.getLogger("Minecraft");
	private int currentlevel;
	private String skilltype;
	private int addexp;
    
    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	Player player = event.getPlayer();
    	Block block = event.getClickedBlock();
    	Action action = event.getAction();
    	ItemStack inhand = player.getItemInHand();
    	if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL){
	    		if(action == Action.RIGHT_CLICK_BLOCK){
	    			Firemaking.check(inhand, block, player, plugin);
		    		Farming.soil(block, player, inhand, plugin, event);
		    	}
	    	}
    	}else{
    		if(action == Action.RIGHT_CLICK_BLOCK){
    			Firemaking.check(inhand, block, player, plugin);
	    		Farming.soil(block, player, inhand, plugin, event);
	    	}
    	}
    	if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR){
    		for(GenericCustomFood material:Hashmaps.customfoodmap.values()){
    			if(inhand.getDurability() == material.getCustomId()){
        		}
    		}
    	}
    }
    
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){
    	Fishing.check(event, plugin);
    }
    
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
    	Player player = event.getPlayer();
    	SpoutPlayer splayer = (SpoutPlayer) player;
    	ItemStack pickedup = event.getItem().getItemStack();
    	int amount = pickedup.getAmount();
    	
    	if(pickedup.getDurability() == Hashmaps.customitemsmap.get("Bronze Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (1 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://82.74.70.243/server/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == Hashmaps.customitemsmap.get("Silver Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (5 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://82.74.70.243/server/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == Hashmaps.customitemsmap.get("Gold Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (10 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://82.74.70.243/server/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}
    }
    
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
    	
    	ItemStack droped = event.getItemDrop().getItemStack();
    	
    	if(droped.getDurability() == Hashmaps.customitemsmap.get("Bronze Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}else if(droped.getDurability() == Hashmaps.customitemsmap.get("Silver Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}else if(droped.getDurability() == Hashmaps.customitemsmap.get("Gold Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	
    	Player player = event.getPlayer();
    	
    	//set playername to config
    	ConfigAdd.addplayer(player);
    	if(!plugin.useSpout){	
    		player.sendMessage(Configuration.config.getString("spout.join.message"));
    	} else {
        	Player onplayer[];
            int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
            for(int i = 0; i < j; i++){
                Player joining = onplayer[i];
                SpoutPlayer sPlayer = (SpoutPlayer)joining;
                if(player.getName().length() > 26){
                    this.log.info(ChatColor.RED + "Player name is too long");
                } else {
                    sPlayer.sendNotification(player.getName(), "has joined the game", Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
                }
            }
    	}
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
    	Player player = event.getPlayer();
    	Player onplayer[];
        int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for(int i = 0; i < j; i++){
            Player leaveing = onplayer[i];
            SpoutPlayer sPlayer = (SpoutPlayer)leaveing;
            if(player.getName().length() > 26){
                this.log.info(ChatColor.RED + "Player name is too long");
            } else {
                sPlayer.sendNotification(player.getName(), "has left the game", Material.getMaterial(Configuration.config.getInt("spout.leave.messageicon")));
            }
        }
    }
    HashMap<Player, Vector> playerLoc = new HashMap<Player, Vector>();
    HashMap<LocalPlayer, String> inregion = new LinkedHashMap<LocalPlayer, String>();
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	if(event.isCancelled())
            return;
    	
    	Player player = event.getPlayer();
    	SpoutPlayer splayer = (SpoutPlayer)player;
    	
    	Vector position = new Vector(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
    	if(!playerLoc.containsKey(player))
        {
            playerLoc.put(player, position);
            return;
        }
        if(!((Vector)playerLoc.get(player)).equals(position))
        {
        	playerLoc.put(player, position);
	        WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
	        LocalPlayer localplayer = worldguard.wrapPlayer(event.getPlayer());
	        Vector curpos = localplayer.getPosition();
	        Location to = event.getTo();
	        World world = to.getWorld();
	        RegionManager rm = worldguard.getRegionManager(world);
	        ApplicableRegionSet regions = rm.getApplicableRegions(curpos);
	        
	        if(regions.size() == 0){
	        	if(inregion.containsKey(localplayer)){
	        		SpoutManager.getSoundManager().stopMusic(splayer);
	        	}
	        	inregion.remove(localplayer);
	            return;
	        }
	        
	        String regionname = "";
	        for(Iterator iterator = regions.iterator(); iterator.hasNext();)
	        {
	            ProtectedRegion protectedregion = (ProtectedRegion)iterator.next();
	            regionname = protectedregion.getId();
	        }
	        
	        if(inregion.containsKey(localplayer) && inregion.get(localplayer).equals(regionname))
                return;
	        
	        inregion.put(localplayer, regionname);
	        
	        String message = Configuration.region.getString("Regions." + inregion.get(localplayer) + ".message");
	        String sub = Configuration.region.getString("Regions." + inregion.get(localplayer) + ".submessage");
	        int icon = Configuration.region.getInt("Regions." + inregion.get(localplayer) + ".iconId");
	        String music = Configuration.region.getString("Regions." + inregion.get(localplayer) + ".music");
	        String command = Configuration.region.getString("Regions." + inregion.get(localplayer) + ".command");
	        String fog = Configuration.region.getString("Regions." + inregion.get(localplayer) + "fog");
	        
	        if(message != null && sub != null && icon != 0)
	            if(message.length() <= 26 && sub.length() <= 26)
	                splayer.sendNotification(message, sub, Material.getMaterial(icon));
	            else
	                System.out.println("A region message is greater than 26 chars");
	        if(music != null){
	        	SpoutManager.getSoundManager().stopMusic(splayer);
	            SpoutManager.getSoundManager().playCustomMusic(plugin, splayer, music, false);
	        }
	        if(command != null){
	        	splayer.performCommand(command);
	        }
	        if(fog != null && fog.equalsIgnoreCase("tiny")){
	            splayer.setRenderDistance(RenderDistance.TINY);
	        }else if(fog != null && fog.equalsIgnoreCase("short")){
	            splayer.setRenderDistance(RenderDistance.SHORT);
	        }else if(fog != null && fog.equalsIgnoreCase("normal")){
	            splayer.setRenderDistance(RenderDistance.NORMAL);
	        }else if(fog != null && fog.equalsIgnoreCase("far")){
	            splayer.setRenderDistance(RenderDistance.FAR);
	        }
        }
    }
    
    //onPlayerPortal,onPlayerLogin,onPlayerRespawn,onPlayerTeleport,onPlayerKick


}
