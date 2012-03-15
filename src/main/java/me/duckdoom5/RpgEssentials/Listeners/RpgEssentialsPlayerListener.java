package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.banking.Bank;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.handelers.Music;
import me.duckdoom5.RpgEssentials.handelers.Quests;
import me.duckdoom5.RpgEssentials.levels.Farming;
import me.duckdoom5.RpgEssentials.levels.Firemaking;
import me.duckdoom5.RpgEssentials.levels.Fishing;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutChest;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.player.RenderDistance;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;
import com.topcat.npclib.nms.NPCEntity;

public class RpgEssentialsPlayerListener implements Listener{
	
    public static RpgEssentials plugin;
    public final Logger log = Logger.getLogger("Minecraft");
    private final static NpcHashmaps npc = new NpcHashmaps();
	private String skilltype;
	private int currentlevel, addexp, taskId, taskId2;
	
	public static Map<Location, Player> protect = new HashMap<Location, Player>();
	public static Map<Location, Player> protect2 = new HashMap<Location, Player>();
	public static Map<Player, Integer> timeleft = new HashMap<Player, Integer>();
	public static Map<SpoutPlayer, Widget> timerwidget = new HashMap<SpoutPlayer, Widget>();
	
    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
    	final Player player = event.getEntity();
    	final SpoutPlayer splayer = (SpoutPlayer) player;
    	Music.forceStop(plugin, (SpoutPlayer) player);
    	if(Configuration.modules.getBoolean("Modules.death chest")){
    		event.getDrops().clear();
	    	if(!Methods.isInventoryEmpty(player)){
	    		
	    		//make sure to place the chest on the ground
	    		int x = player.getLocation().getBlockX();
	    		int y;
	    		int z = player.getLocation().getBlockZ();
	    		for (y = player.getLocation().getBlockY(); player.getWorld().getBlockAt(x,y,z).getType() == Material.AIR; --y);
	    		
	    		//place the chest
	    		final Location droplocation = new Location(player.getWorld(), x, y + 1, z);
		        
		    	droplocation.getBlock().setType(Material.CHEST);
		    	protect.put(droplocation, player);
		    	protect2.put(droplocation, player);
		    	
		    	Location temp;
				//place the second chest
		    	if(droplocation.getBlock().getRelative(BlockFace.NORTH).getType().equals(Material.AIR)){
		    		temp = droplocation.getBlock().getRelative(BlockFace.NORTH).getLocation();
		    	}else if(droplocation.getBlock().getRelative(BlockFace.EAST).getType().equals(Material.AIR)){
		    		temp = droplocation.getBlock().getRelative(BlockFace.EAST).getLocation();
		    	}else if(droplocation.getBlock().getRelative(BlockFace.SOUTH).getType().equals(Material.AIR)){
		    		temp = droplocation.getBlock().getRelative(BlockFace.SOUTH).getLocation();
		    	}else if(droplocation.getBlock().getRelative(BlockFace.WEST).getType().equals(Material.AIR)){
		    		temp = droplocation.getBlock().getRelative(BlockFace.WEST).getLocation();
		    	}else{
		    		//There is no place for another chest, (place it in a wall for now)
		    		player.sendMessage(droplocation.getBlock().getRelative(BlockFace.WEST).getType().toString());
		    		temp = droplocation.getBlock().getRelative(BlockFace.NORTH).getLocation();
		    	}
		    	final Location droplocation2 = temp;
		        
		    	droplocation2.getBlock().setType(Material.CHEST);
		    	protect.put(droplocation2, player);
		    	protect2.put(droplocation2, player);
		    	
		    	
		    	Chest bc = (Chest)droplocation.getBlock().getState();
		    	
		    	SpoutChest chest = (SpoutChest) bc;
		    	
		    	ItemStack[] toadd = player.getInventory().getContents();
		    	for(int i = 0; i < toadd.length; i++){
		    		if(toadd[i] != null){
		    			chest.getLargestInventory().setItem(i, toadd[i]);
		    		}
		    	}
		    	
	    		bc.update(true);
	    		
	    		
	    		//run timer
	    		
	    		int protecttime = Configuration.config.getInt("deathchest.protect time in minutes");
	    		int unprotecttime = Configuration.config.getInt("deathchest.unprotect time in minutes");
	    		
	    		
				//run after time
				Long protime = (long) ((protecttime * 60) * 20);
				Long unprotime = (long) ((unprotecttime * 60) * 20);
				Long totaltime = protime + unprotime;
				
				int protimeleft = protecttime * 60;
				int unprotimeleft = unprotecttime * 60;
				int totaltimeleft = protimeleft + unprotimeleft;
				
				timeleft.put(player, totaltimeleft);
				
				int min = 5;
				int sec = 5;
				final Widget time = new GenericLabel("Time left:" + min + ":" + sec).setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.TOP_RIGHT).shiftXPos(-20).shiftYPos(-10);
				splayer.getMainScreen().attachWidget(plugin, time);
				
				//update timer
				taskId = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
				    public void run() {
				    	int oldtime = timeleft.get(player);
				    	timeleft.put(player, oldtime - 1);
				    }
				}, 20L, 20L);
				
				//remove protection
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	protect.remove(droplocation);
				    	protect.remove(droplocation2);
				    	player.sendMessage(ChatColor.RED + "Your chest is no longer protected!");
				    }
				}, protime);
				
				//remove chest
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	plugin.getServer().getScheduler().cancelTask(taskId);
				    	
				    	Chest bc = (Chest)droplocation.getBlock().getState();
				    	SpoutChest chest = (SpoutChest) bc;
				    	
				    	chest.getLargestInventory().clear();
				    	
				    	droplocation.getBlock().setType(Material.AIR);
				    	droplocation2.getBlock().setType(Material.AIR);
				    	
				    	protect2.remove(droplocation);
				    	protect2.remove(droplocation2);
				    	
				    	player.sendMessage(ChatColor.RED + "Your chest has disapeared!");
				    }
				}, totaltime);
	    	}
    	}
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	final Player player = event.getPlayer();
    	final SpoutPlayer splayer = (SpoutPlayer) player;
    	if(timeleft.containsKey(player)){
    		
    		//update timer
			taskId2 = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
			    public void run() {
			    	int time = timeleft.get(player);
			    	
					int min = time / 60;
					int sec = time % 60;
					
					Widget timer;
					if(!timerwidget.containsKey(splayer)){
						timer = new GenericLabel("Time left: " + min + ":" + sec).setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.TOP_RIGHT).shiftXPos(-75).shiftYPos(+10);
						timerwidget.put(splayer, timer);
					}else{
						timer = timerwidget.get(splayer);
						if(min <= 5){
							if(sec < 10){
								((GenericLabel) timer).setText("Time left: " + min + ":0" + sec).setTextColor(new Color(1.0F, 0, 0, 1.0F));
							}else{
								((GenericLabel) timer).setText("Time left: " + min + ":" + sec).setTextColor(new Color(1.0F, 0, 0, 1.0F));
							}
						}else{
							if(sec < 10){
								((GenericLabel) timer).setText("Time left: " + min + ":0" + sec);
							}else{
								((GenericLabel) timer).setText("Time left: " + min + ":" + sec);
							}
						}
					}
					
					splayer.getMainScreen().attachWidget(plugin, timer);
			    }
			}, 20L, 20L);
			
			Long time = (long) (timeleft.get(player) * 20);
			//remove timer
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			    public void run() {
			    	plugin.getServer().getScheduler().cancelTask(taskId2);
			    	splayer.getMainScreen().removeWidget(timerwidget.get(splayer));
			    	timerwidget.remove(splayer);
			    }
			}, time);
    	}
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Player player = event.getPlayer();
	    	Block block = event.getClickedBlock();
	    	Action action = event.getAction();
	    	ItemStack inhand = player.getItemInHand();
	    	if(Configuration.modules.getBoolean("Modules.leveling")){
		    	if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
			    	if(player.getGameMode() == GameMode.SURVIVAL){
			    		if(action == Action.RIGHT_CLICK_BLOCK){
			    			if(block.getType().equals(Material.LONG_GRASS) || block.getType().equals(Material.FENCE) || block.getType().equals(Material.DEAD_BUSH) || block.getType().equals(Material.VINE) || block.getType().equals(Material.GLASS)){
			    				event.setCancelled(true);
			    				return;
			    			}
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
	    	}
	    	if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR){
	    		for(GenericCustomFood material:Hashmaps.customfood){
	    			if(inhand.getDurability() == material.getCustomId()){
	    				int restore = 0;
	    				int heal = 0;
	    				if(Configuration.items.contains("Custom Food." + material.getName() + ".restore")){
	    					restore = Configuration.items.getInt("Custom Food." + material.getName() + ".restore");
	    				}
	    				if(Configuration.items.contains("Custom Food." + material.getName() + ".heal")){
	    					restore = Configuration.items.getInt("Custom Food." + material.getName() + ".heal");
	    				}
	    				player.getInventory().removeItem(new ItemStack(inhand.getType(),1,inhand.getDurability()));
						player.setFoodLevel(player.getFoodLevel() + restore);
						player.sendMessage(player.getHealth() + "");
						player.setHealth(player.getHealth() + heal);
	        		}
	    		}
	    	}
	    	if(action == Action.RIGHT_CLICK_BLOCK){
	    		if(block.getType().equals(Material.CHEST)){
    				if(protect.containsKey(block.getLocation())){
    					if(player != protect.get(block.getLocation())){
    						player.sendMessage(ChatColor.RED + "This chest is still protected.");
    						event.setCancelled(true);
    					}
    				}
    			}
	    		if(block.getType().equals(Material.SNOW)){
		    		if(inhand.getDurability() == Hashmaps.customitemsmap.get("Snow Wand").getCustomId()){
		    			Byte data = block.getData();
		    			block.setData((byte) (data + 1));
		    		}
	    		}
	    	}
    	}
    }
    
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){
    	if(Configuration.modules.getBoolean("Modules.leveling") && RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
    		Fishing.check(event, plugin);
    	}
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
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.dropbox.com/u/62672791/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == Hashmaps.customitemsmap.get("Silver Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (5 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.dropbox.com/u/62672791/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == Hashmaps.customitemsmap.get("Gold Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (10 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.dropbox.com/u/62672791/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
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
    	if(Configuration.modules.getBoolean("Modules.regions") && RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	if(event.isCancelled())
	            return;
	    	if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
		    	
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
			        String fog = Configuration.region.getString("Regions." + inregion.get(localplayer) + ".fog");
			        
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
    	}
    }
    
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Entity clicked = event.getRightClicked();
	    	Player player = event.getPlayer();
	    	SpoutPlayer splayer = SpoutManager.getPlayer(player);
	    	ItemStack inhand = player.getItemInHand();
	    	
	    	if(plugin.m.isNPC(clicked)){
	    		String id = plugin.m.getNPCIdFromEntity(clicked);
				NPC np = plugin.m.getNPC(id);
	    		HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
	    		String type = Configuration.npc.getString("Npc." + id + ".type");
	    		if(inhand.getDurability() == Hashmaps.customitemsmap.get("NPC Wand").getCustomId()){
	    			humannpc.lookAtPoint(player.getEyeLocation());
	    			npc.select(plugin, player,id);
	    			//save pitch/yaw
	    			Configuration.npc.set("Npc." + id + ".pitch", np.getBukkitEntity().getLocation().getPitch());
	    			Configuration.npc.set("Npc." + id + ".yaw", np.getBukkitEntity().getLocation().getYaw());
	    			try {
	    				Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		}else{
	    			humannpc.lookAtPoint(player.getEyeLocation());
	    			//save pitch/yaw
	    			Configuration.npc.set("Npc." + id + ".pitch", np.getBukkitEntity().getLocation().getPitch());
	    			Configuration.npc.set("Npc." + id + ".yaw", np.getBukkitEntity().getLocation().getYaw());
	    			try {
	    				Configuration.npc.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    			if(type.equalsIgnoreCase("banker")){
		    			Bank.Clicked(plugin, splayer);
		    			
					}else if(type.equalsIgnoreCase("quester")){
						Quests.Clicked(plugin, player, splayer, id);
						
	    			}else{//type == default
	        			String [] text = {Configuration.npc.getString("Npc." + id + ".text")};
	        			String [] buttons = {"Close"};
	        			TextSelectMenu.open(plugin, splayer, "Hello", text, buttons);
	    			}
	    		}
	    	}
    	}
    }
    //onPlayerPortal,onPlayerLogin,onPlayerRespawn,onPlayerTeleport,onPlayerKick
}
