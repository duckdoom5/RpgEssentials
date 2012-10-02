package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Music;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.EntitySkinType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsEntityListener implements Listener{
	
	public static Map<Player, ItemStack> drops = new HashMap<Player, ItemStack>();
	
	//natural
	public static HashMap<UUID, Chicken> chickens = new LinkedHashMap<UUID, Chicken>();
	public static HashMap<UUID, Cow> cows = new LinkedHashMap<UUID, Cow>();
	public static HashMap<UUID, Wolf> wolfs = new LinkedHashMap<UUID, Wolf>();
	public static HashMap<UUID, Squid> squids = new LinkedHashMap<UUID, Squid>();
	
	//monsters
	public static HashMap<UUID, Zombie> zombies = new LinkedHashMap<UUID, Zombie>();
	public static HashMap<UUID, Skeleton> skeletons = new LinkedHashMap<UUID, Skeleton>();
	public static HashMap<UUID, Creeper> creepers = new LinkedHashMap<UUID, Creeper>();
	public static HashMap<UUID, Spider> spiders = new LinkedHashMap<UUID, Spider>();
	public static HashMap<UUID, Blaze> blazes = new LinkedHashMap<UUID, Blaze>();
	public static HashMap<UUID, MagmaCube> magmacubes = new LinkedHashMap<UUID, MagmaCube>();
	public static HashMap<UUID, Slime> slimes = new LinkedHashMap<UUID, Slime>();
	public static HashMap<UUID, Enderman> endermans = new LinkedHashMap<UUID, Enderman>();
	public static HashMap<UUID, EnderDragon> enderdragons = new LinkedHashMap<UUID, EnderDragon>();
	
	public static RpgEssentials plugin;
	String skilltype;
	
	public RpgEssentialsEntityListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
			if(event.getEntity() instanceof LivingEntity){
				LivingEntity defender = (LivingEntity) event.getEntity();
				
				if(RpgEssentials.nm.isNPC(defender)){
					event.setCancelled(true);
					return;
				}
				
				Entity attacker = event.getDamager();
				if(attacker instanceof Player){
					if(defender.getNoDamageTicks() > 0){
						event.setCancelled(true);
						return;
					}
					Player player = (Player) attacker;
					SpoutPlayer splayer = SpoutManager.getPlayer((Player) attacker);
					
					if(RpgEssentials.battlemusic){
						if(event.getCause().equals(DamageCause.ENTITY_ATTACK)){
							Music.startBattle(plugin, defender.getUniqueId(), splayer);
						}
					}
				}
				if(defender instanceof Player){
					Player player = (Player)defender;
					if(player.getNoDamageTicks() > 0){
						event.setCancelled(true);
						return;
					}
					
					SpoutPlayer splayer = SpoutManager.getPlayer((Player) defender);
					if(RpgEssentials.battlemusic){
						if(attacker instanceof Projectile){
							Music.startBattle(plugin, defender.getUniqueId(), splayer);
						}else if(attacker instanceof Explosive){
							Music.forceStopBattle(plugin, splayer);
					    }else{
					    	Music.startBattle(plugin, defender.getUniqueId(), splayer);
					    }
					}
				}/*else{
					if(RpgPlayerManager.isRpgEntity(defender)){
						if(attacker instanceof Player){
							Player player = (Player) attacker;
							if(player.getWorld().getPVP()){
								player.sendMessage(ChatColor.RED + "You can't attack a pet in a pvp free world!");
								event.setCancelled(true);
								return;
							}
						}
						
						//TODO it's not always wolf
						
						RpgWolf rpgwolf = (RpgWolf) RpgPlayerManager.getRpgEntity(defender);
						rpgwolf.setHealth(rpgwolf.getHealth() - event.getDamage());
						event.setDamage(0);
					}
				}*/
			}
		}
	}
	
	@EventHandler
	public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event){
		if(event.getTarget() instanceof Player){
			if(RpgEssentials.nm.isNPC(event.getTarget())){
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event){ //remove eggs from custom entities
		Item item = event.getEntity();
		if(item.getItemStack().getType().equals(Material.EGG)){
			List<Entity> nearby = item.getNearbyEntities(0.01, 0.3, 0.01);
			for(int i = 0; i < nearby.size(); i++){
				if(nearby.get(i).getType().equals(EntityType.CHICKEN)){
					if(chickens.containsKey(nearby.get(i).getUniqueId())){
						event.setCancelled(true);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) throws IOException{
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
			if(Configuration.modules.getBoolean("Modules.custom mobs")){
				if(event.getEntity() instanceof Chicken){
					if(chickens.containsKey(event.getEntity().getUniqueId())){
						Location droplocation = event.getEntity().getLocation();
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Material.ICE,1));
						chickens.remove(event.getEntity().getUniqueId());
						//droplocation.getWorld().dropItemNaturally(droplocation, new ItemStack(Material.ICE,1));
					}
				}
			}
			
			if(Configuration.modules.getBoolean("Modules.battle music")){
				Music.stopBattle(plugin, event.getEntity().getUniqueId());
			}
			LivingEntity entity = event.getEntity();
			if(event.getEntity().getLastDamageCause() != null){
				DamageCause cause = event.getEntity().getLastDamageCause().getCause();
				EntityDamageEvent event1 = event.getEntity().getLastDamageCause();
				Player player = null;
				if(event1 instanceof EntityDamageByEntityEvent){
					EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent)event1;
					if(event2.getEntity() instanceof LivingEntity){
						Entity attacker = event2.getDamager();
						if(attacker instanceof Player){
							player = (Player) attacker;
						}else if(attacker instanceof Arrow){
							if(((Projectile) attacker).getShooter() instanceof Player){
								player = (Player) ((Projectile) attacker).getShooter();
							}
						}
					}
				}
				if(player != null){
					SpoutPlayer splayer = SpoutManager.getPlayer(player);
					if(player.getGameMode() == GameMode.SURVIVAL && !entity.hasMetadata("spawner")){
						Location droplocation = event.getEntity().getLocation();
						Random rand = new Random();
						int bronzeamount = rand.nextInt(50);
						int silveramount = rand.nextInt(50);
						int goldamount = rand.nextInt(50);
						if(bronzeamount < 10){
							ItemStack bronzedrop = new SpoutItemStack(RpgEssentials.mm.getItemByName("Bronze Coin"), bronzeamount + 1);
							drops.put(player, bronzedrop);
							event.getDrops().add(bronzedrop);
						}else{
							ItemStack bronzedrop = new SpoutItemStack(RpgEssentials.mm.getItemByName("Bronze Coin"), 1);
							drops.put(player, bronzedrop);
							event.getDrops().add(bronzedrop);
						}
						if(silveramount < 5){
							ItemStack silverdrop = new SpoutItemStack(RpgEssentials.mm.getItemByName("Silver Coin"), silveramount + 1);
							drops.put(player, silverdrop);
							event.getDrops().add(silverdrop);
						}
						if(goldamount < 1){
							ItemStack golddrop = new SpoutItemStack(RpgEssentials.mm.getItemByName("Gold Coin"), goldamount + 1);
							drops.put(player, golddrop);
							event.getDrops().add(golddrop);
						}
					}
				}
			}
		}
		/*if(event.getEntity() instanceof Wolf){
			Wolf wolf = (Wolf) event.getEntity();
    		if(RpgPlayerManager.isRpgEntity(wolf)){
    			RpgWolf rpgwolf = (RpgWolf) RpgPlayerManager.getRpgEntity(wolf);
    			Player player = (Player) rpgwolf.getOwner();
    			int time = 30;
    			player.sendMessage(ChatColor.RED + "Your wolf will respawn in " + time + " seconds");
    			rpgwolf.respawn(time);
    		}
		}*/
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){
		EntityType type = event.getEntityType();
		if(event.getSpawnReason() == SpawnReason.NATURAL){
			if(type == EntityType.CHICKEN){
				Biome biome = event.getEntity().getLocation().getBlock().getBiome();
				if(biome.equals(Biome.TAIGA) || biome.equals(Biome.FROZEN_OCEAN) || biome.equals(Biome.FROZEN_RIVER) || biome.equals(Biome.ICE_MOUNTAINS) || biome.equals(Biome.ICE_PLAINS) || biome.equals(Biome.TAIGA_HILLS)){
					Entity entity = event.getEntity();
					UUID id = entity.getUniqueId();
					SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
					for(int i = 0; i < onplayers.length; i++){
						onplayers[i].setEntitySkin((LivingEntity) entity, "http://dl.dropbox.com/u/62672791/mobs/chicken.png", EntitySkinType.DEFAULT);
					}
					chickens.put(id, (Chicken) entity);
				}
				//Random random = new Random();
				//if(random.nextInt(100) < 100){
				//}	
			}else if(type == EntityType.PIG){
				
			}
		}else if(event.getSpawnReason() == SpawnReason.SPAWNER || event.getSpawnReason() == SpawnReason.SPAWNER_EGG){
			event.getEntity().setMetadata("spawner", new FixedMetadataValue(plugin, true));
		}
	}
}
