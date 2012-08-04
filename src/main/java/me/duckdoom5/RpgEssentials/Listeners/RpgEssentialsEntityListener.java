package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Music;
import me.duckdoom5.RpgEssentials.handelers.Quests;
import me.duckdoom5.RpgEssentials.levels.Attack;
import me.duckdoom5.RpgEssentials.levels.Defense;
import me.duckdoom5.RpgEssentials.levels.Ranged;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsEntityListener implements Listener{

	//health checker
	public static HashMap<UUID, Integer> health = new LinkedHashMap<UUID, Integer>();
	
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
	private int currentlevel;
	private int addexp;
	String skilltype;
	
	public RpgEssentialsEntityListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		Quests.EntityDamage(event);
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
			if(event.isCancelled()){
				return;
			}
			if(event instanceof EntityDamageByEntityEvent){
				EntityDamageByEntityEvent event1 = (EntityDamageByEntityEvent)event;
				if(event1.getEntity() instanceof LivingEntity){
					LivingEntity defender = (LivingEntity) event1.getEntity();
					Entity attacker = event1.getDamager();
					if(attacker instanceof Player){
						SpoutPlayer splayer = SpoutManager.getPlayer((Player) attacker);
						
						if(Configuration.modules.getBoolean("Modules.battle music")){
							if(event1.getCause().equals(DamageCause.ENTITY_ATTACK)){
								Music.start(plugin, defender.getUniqueId(), splayer);
							}
						}
						
						if(Configuration.modules.getBoolean("Modules.leveling")){
							if(health.containsKey(defender.getUniqueId())){
								int oldhealth = health.get(defender.getUniqueId());
								if(defender.getHealth() != oldhealth){
									health.put(defender.getUniqueId(), defender.getHealth());
									Attack.run(attacker, event1, defender, event, plugin);
								}
							}else{
								health.put(defender.getUniqueId(), defender.getHealth());
								Attack.run(attacker, event1, defender, event, plugin);
							}
						}
					}else if (attacker instanceof Arrow || attacker instanceof Snowball || attacker instanceof Egg) {
						if(Configuration.modules.getBoolean("Modules.leveling")){
							Ranged.check(attacker, plugin);
						}
			        }
					if(defender instanceof Player){
						if(plugin.m.isNPC(defender)){
							event.setCancelled(true);
							return;
						}
						
						SpoutPlayer splayer = SpoutManager.getPlayer((Player) defender);
						
						if(Configuration.config.getBoolean("player.close gui on damage")){
							if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
								try {
									splayer.getMainScreen().getActivePopup().close();
								} catch (Exception e) {
								}
							}
							lookAtPoint(attacker.getLocation(), defender);
						}
						
						if(attacker instanceof Projectile){
							if(Configuration.modules.getBoolean("Modules.battle music")){
								Music.start(plugin, defender.getUniqueId(), splayer);
							}
						}else if(attacker instanceof Explosive){
							
						}else{
							if(Configuration.modules.getBoolean("Modules.battle music")){
								Music.start(plugin, defender.getUniqueId(), splayer);
							}
						}
						
						if(Configuration.modules.getBoolean("Modules.leveling")){
							Defense.check(defender, plugin, event1);
						}
					}
				}
			}
		}
	}
	
	public void lookAtPoint(Location point, Entity entity) {
		if(entity.getWorld() != point.getWorld()) {
			return;
		}
		Location npcLoc = ((LivingEntity) entity).getEyeLocation();
		double xDiff = point.getX() - npcLoc.getX();
		double yDiff = point.getY() - npcLoc.getY();
		double zDiff = point.getZ() - npcLoc.getZ();
		double DistanceXZ = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		double DistanceY = Math.sqrt(DistanceXZ * DistanceXZ + yDiff * yDiff);
		double newYaw = Math.acos(xDiff / DistanceXZ) * 180 / Math.PI;
		double newPitch = Math.acos(yDiff / DistanceY) * 180 / Math.PI - 90;
		if (zDiff < 0.0) {
			newYaw = newYaw + Math.abs(180 - newYaw) * 2;
		}
		entity.getLocation().setYaw((float) (newYaw - 90));
		entity.getLocation().setPitch((float) newPitch);
	}
	
	public static Map<Player, ItemStack> drops = new HashMap<Player, ItemStack>();
	
	@EventHandler
	public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event){
		if(event.getTarget() instanceof Player){
			if(plugin.m.isNPC(event.getTarget())){
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		Quests.EntityDeath(event);
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
			/*if(Configuration.modules.getBoolean("Modules.custom mobs")){
				if(event.getEntity() instanceof Chicken){
					plugin.getServer().broadcastMessage("test");
					if(chickens.containsKey(event.getEntity().getUniqueId())){
						plugin.getServer().broadcastMessage("test2");
						Chicken chicken = chickens.get(event.getEntity().getUniqueId());
						Location droplocation = event.getEntity().getLocation();
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(Material.ICE,1));
						//droplocation.getWorld().dropItemNaturally(droplocation, new ItemStack(Material.ICE,1));
					}
				}
			}*/
			
			if(Configuration.modules.getBoolean("Modules.battle music")){
				Music.stop(plugin, event.getEntity().getUniqueId());
			}
			
			if(health.containsKey(event.getEntity().getUniqueId())){
				health.remove(event.getEntity().getUniqueId());
			}
			if(event.getEntity().getLastDamageCause().getCause() != null){
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
					if(player.getGameMode() == GameMode.SURVIVAL){
						Location droplocation = event.getEntity().getLocation();
						Random rand = new Random();
						int bronzeamount = rand.nextInt(50);
						int silveramount = rand.nextInt(50);
						int goldamount = rand.nextInt(50);
						if(bronzeamount < 10){
							ItemStack bronzedrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Bronze Coin"), bronzeamount + 1);
							drops.put(player, bronzedrop);
							droplocation.getWorld().dropItemNaturally(droplocation, bronzedrop);
						}else{
							ItemStack bronzedrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Bronze Coin"), 1);
							drops.put(player, bronzedrop);
							droplocation.getWorld().dropItemNaturally(droplocation, bronzedrop);
						}
						if(silveramount < 5){
							ItemStack silverdrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Silver Coin"), silveramount + 1);
							drops.put(player, silverdrop);
							droplocation.getWorld().dropItemNaturally(droplocation, silverdrop);
						}
						if(goldamount < 1){
							ItemStack golddrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Gold Coin"), goldamount + 1);
							drops.put(player, golddrop);
							droplocation.getWorld().dropItemNaturally(droplocation, golddrop);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){
		//if(event.getSpawnReason() == SpawnReason.NATURAL){
			/*if(event.getCreatureType() == CreatureType.CHICKEN){
				
				Random random = new Random();
				if(random.nextInt(100) < 100){
					Entity entity = event.getEntity();
					UUID id = entity.getUniqueId();
					SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
					for(int i = 0; i < onplayers.length; i++){
						onplayers[i].setEntitySkin((LivingEntity) entity, "http://dl.dropbox.com/u/62672791/mobs/chicken.png", EntitySkinType.DEFAULT);
					}
					chickens.put(id, (Chicken) entity);
				}	
			}*/
		//}
	}
}
