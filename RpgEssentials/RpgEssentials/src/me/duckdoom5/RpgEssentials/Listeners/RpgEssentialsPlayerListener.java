package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.SpawnerWandGui;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.NPC.NpcHashmaps;
import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.config.ConfigAdd;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.handelers.Music;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;
import com.topcat.npclib.nms.NPCEntity;

public class RpgEssentialsPlayerListener implements Listener{
    public static RpgEssentials plugin;
    public static boolean warnOp = false;
    private final static NpcHashmaps npc = new NpcHashmaps();
    
    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance; 
    }
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
    	final Player player = event.getEntity();
    	final SpoutPlayer splayer = SpoutManager.getPlayer(player);
    	Music.forceStopBattle(plugin, splayer);
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Player player = event.getPlayer();
	    	Block block = event.getClickedBlock();
	    	Action action = event.getAction();
	    	ItemStack inhand = player.getItemInHand();
	    	if(action == Action.RIGHT_CLICK_BLOCK){
	    		if(block.getType().equals(Material.SNOW)){
		    		if(inhand.getDurability() == RpgEssentials.mm.getItemByName("Snow Wand").getCustomId()){
		    			Byte data = block.getData();
		    			block.setData((byte) (data + 1));
		    		}
	    		}else if(block.getType().equals(Material.MOB_SPAWNER)){
		    		if(inhand.getDurability() == RpgEssentials.mm.getItemByName("Spawner Wand").getCustomId()){
		    			CreatureSpawner spawner = (CreatureSpawner) block.getState();
		    			SpawnerWandGui gui = new SpawnerWandGui(plugin, (SpoutPlayer) player, spawner);
		    		}
	    		}
	    	}
    	}
    }
    
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
    	Player player = event.getPlayer();
    	SpoutPlayer splayer = SpoutManager.getPlayer(player);
    	ItemStack pickedup = event.getItem().getItemStack();
    	int amount = pickedup.getAmount();
    	
    	//TODO change this
    	
    	if(pickedup.getDurability() == RpgEssentials.mm.getItemByName("Bronze Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (1 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == RpgEssentials.mm.getItemByName("Silver Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (5 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}else if(pickedup.getDurability() == RpgEssentials.mm.getItemByName("Gold Coin").getCustomId()){
    		double money = PlayerConfig.getMoney(splayer.getName());
    		PlayerConfig.setMoney(splayer.getName(), money + (10 * amount));
    		event.getItem().teleport(player.getLocation());
    		SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav", false, splayer.getLocation(), 0, 100);
    		event.getItem().remove();
    		event.setCancelled(true);
    	}
    }
    
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
    	
    	ItemStack droped = event.getItemDrop().getItemStack();
    	
    	if(droped.getDurability() == RpgEssentials.mm.getItemByName("Bronze Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}else if(droped.getDurability() == RpgEssentials.mm.getItemByName("Silver Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}else if(droped.getDurability() == RpgEssentials.mm.getItemByName("Gold Coin").getCustomId()){
    		event.getItemDrop().remove();
    	}
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	Player player = event.getPlayer();
    	
    	if(RpgEssentials.pm.getRpgPlayer(player.getName()) == null){
    		RpgEssentials.log.info(player.getName());
    		RpgPlayer rplayer = new RpgPlayer(player);
    		RpgEssentials.pm.addPlayer(player.getName(), rplayer);
    	}
    	
    	if(warnOp){
    		if(player.isOp()){
    			player.sendMessage(ChatColor.YELLOW + "**ALERT** " + ChatColor.GREEN + "There is a new version of RpgEssentials available!");
    		}
    	}
    	
    	//set playername to config
    	ConfigAdd.addPlayer(player);
    	
    	Player onplayer[];
        int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for(int i = 0; i < j; i++){
            Player joining = onplayer[i];
            SpoutPlayer sPlayer = SpoutManager.getPlayer(joining);
            if(player.getName().length() > 26){
                RpgEssentials.log.info(ChatColor.RED + "Player name is too long");
            } else {
                sPlayer.sendNotification(player.getName(), "has joined the game", Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
            }
        }
        
        /*for(RpgEntityType type: RpgEntityType.values()){
			if(Configuration.pets.contains(type.toString().toLowerCase())){
				ConfigurationSection section = Configuration.pets.getConfigurationSection(type.toString().toLowerCase());
				Iterator<?> keys = section.getKeys(false).iterator();
				while(keys.hasNext()){
					ConfigurationSection section2 = Configuration.pets.getConfigurationSection((String) keys.next());
					Iterator<?> keys2 = section.getKeys(false).iterator();
					OfflinePlayer owner = Bukkit.getServer().getOfflinePlayer((String) keys2.next());
					if(owner.getName().equals(player.getName())){
						int id = 0;
		    			for(id = 0; Configuration.pets.contains("wolf." + player.getName() + "." + id + ".name"); id++){
		    				World world = Bukkit.getWorld(Configuration.pets.getString("wolf." + player.getName() + "." + id + ".world"));
		    				org.bukkit.util.Vector vector = Configuration.pets.getVector("wolf." + player.getName() + "." + id + ".location.vector");
		    				int pitch = Configuration.pets.getInt("wolf." + player.getName() + "." + id + ".location.pitch");
		    				int yaw = Configuration.pets.getInt("wolf." + player.getName() + "." + id + ".location.yaw");
		    				Location location = vector.toLocation(world, yaw, pitch);
		    				
		    		    	Wolf wolf = (Wolf) world.spawnEntity(location, EntityType.WOLF);  
		    		    	
		        			RpgWolf rwolf = new RpgWolf(player, wolf, id, location);
		    			}
					}
				}
			}else{
				RpgEssentials.log.warning("Pets doesn't contain: " + type.toString().toLowerCase());
			}
		}*/
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
    	Player player = event.getPlayer();
    	RpgEssentials.pm.removePlayer(player);
    	Player onplayer[];
        int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for(int i = 0; i < j; i++){
            Player leaveing = onplayer[i];
            SpoutPlayer sPlayer = SpoutManager.getPlayer(leaveing);
            if(player.getName().length() > 26){
                RpgEssentials.log.info(ChatColor.RED + "Player name is too long");
            } else {
                sPlayer.sendNotification(player.getName(), "has left the game", Material.getMaterial(Configuration.config.getInt("spout.leave.messageicon")));
            }
        }
        
        //RpgPlayerManager.removePet(player);
    }
    
	@EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) throws IOException{
    	if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
	    	Entity clicked = event.getRightClicked();
	    	Player player = event.getPlayer();
	    	RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player.getName());
	    	SpoutPlayer splayer = SpoutManager.getPlayer(player);
	    	ItemStack inhand = player.getItemInHand();
	    	
	    	if(RpgEssentials.nm.isNPC(clicked)){
	    		String id = RpgEssentials.nm.getNPCIdFromEntity(clicked);
				NPC np = RpgEssentials.nm.getNPC(id);
	    		HumanNPC humannpc = new HumanNPC((NPCEntity) np.getEntity());
	    		String type = Configuration.npc.getString("Npc." + id + ".type");
	    		if(inhand.getDurability() == RpgEssentials.mm.getItemByName("NPC Wand").getCustomId()){
	    			humannpc.lookAtPoint(player.getEyeLocation());
	    			npc.select(plugin, player,id);
	    			//save pitch/yaw
	    			Configuration.npc.set("Npc." + id + ".pitch", np.getBukkitEntity().getLocation().getPitch());
	    			Configuration.npc.set("Npc." + id + ".yaw", np.getBukkitEntity().getLocation().getYaw());
	    			Configuration.npc.save();
	    		}else{
	    			humannpc.lookAtPoint(player.getEyeLocation());
	    			//save pitch/yaw
	    			Configuration.npc.set("Npc." + id + ".pitch", np.getBukkitEntity().getLocation().getPitch());
	    			Configuration.npc.set("Npc." + id + ".yaw", np.getBukkitEntity().getLocation().getYaw());
	    			Configuration.npc.save();
	    			
	    			if(type.equalsIgnoreCase("banker")){
	    				if(RpgEssentials.RpgBanks != null){
	    					Bank.Clicked((RpgBanks) RpgEssentials.RpgBanks, splayer);
	    				}else{
	    					player.sendMessage(ChatColor.RED + "RpgBank plugin is not enabled!");
	    				}
		    			
					}else if(type.equalsIgnoreCase("quester")){
						RpgQuests.qh.npcRightClicked(np, rpgplayer);
						
	    				/*NPC questgiver = quest.getQuestGiver();
	    				NPC questEnder = quest.getQuestEnder();
	    				if(np.equals(questgiver)){
	    					quester = true;
	    				}else if(np.equals(questEnder)){
	    					quester = true;
	    				}*/
						
	    			}else{
	        			String text = Configuration.npc.getString("Npc." + id + ".text");
	        			String [] buttons = {"Close"};
	        			TextSelectMenu menu = new TextSelectMenu(plugin, splayer, "Hello", MessageUtils.TextMenuSplit(text), buttons, EntityType.PLAYER);
	    			}
	    		}
	    	}/*else if(RpgPlayerManager.isRpgEntity(clicked)){
    			RpgWolf rpgwolf = (RpgWolf) RpgPlayerManager.getRpgEntity(clicked);
    			if(inhand.getType().equals(Material.INK_SACK)){
    				rpgwolf.setBeltColor(RpgWolf.BeltColor.getBeltColor(Methods.getInkColor(inhand.getDurability())));
    				if(player.getGameMode().equals(GameMode.SURVIVAL)){
    					if(inhand.getAmount() > 1){
    						inhand.setAmount(inhand.getAmount()- 1);
    					}else{
    						player.getInventory().remove(inhand);
    					}
    				}
    				event.setCancelled(true);
    			}
    		}else if(inhand.getDurability() == RpgEssentials.mm.getItemByName("Pet Wand").getCustomId()){
		    	if(clicked instanceof Wolf){
	    			Wolf wolf = (Wolf)clicked;
	    			if(wolf.isTamed() && wolf.getOwner().equals(player)){
		    			int id = 0;
		    			for(id = 0; Configuration.pets.contains("wolf." + player.getName() + "." + id + ".name"); id++);
		    			RpgWolf rpgwolf = new RpgWolf(player, wolf, id);
		    			event.setCancelled(true);
	    			}
	    		}
	    	}*/
    	}
    }
}
