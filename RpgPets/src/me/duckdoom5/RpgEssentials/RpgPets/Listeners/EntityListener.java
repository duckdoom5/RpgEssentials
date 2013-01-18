package me.duckdoom5.RpgEssentials.RpgPets.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.player.EntitySkinType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class EntityListener implements Listener{
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
		if(RpgEssentials.wl.worlds.get(event.getEntity().getWorld())){
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
		}
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
		}
	}
}
