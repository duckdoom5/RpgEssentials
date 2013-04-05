package me.duckdoom5.RpgEssentials.RpgEntities.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.ChickenRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.EntityRpgData;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.RpgChicken;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.RpgEntity;
import me.duckdoom5.RpgEssentials.config.Configuration;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_4_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

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
	
	
	
	public static void registerEntity(EntityRpgData er){
		
	}
	
	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event){ //remove chicken eggs from custom entities
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
	
	boolean checked = false;
	
	@EventHandler
	public void onplayerInteract(PlayerInteractEvent event){
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(event.getItem().getTypeId() == Material.STICK.getId()){
				Location l = event.getClickedBlock().getLocation().add(0, 1, 0);
				RpgEntities.em.spawnRpgEntity(l, EntityType.WOLF);
			}
		}
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){
		if (event.isCancelled()) return;
		
		Location location = event.getLocation();
		Entity entity = event.getEntity();
		EntityType type = event.getEntityType();
		World world = location.getWorld();
		SpawnReason reason = event.getSpawnReason();
		 
		WorldServer mcWorld = ((CraftWorld) world).getHandle();
		net.minecraft.server.v1_4_R1.Entity mcEntity = (((CraftEntity) entity).getHandle());
		 
		if(reason == SpawnReason.EGG && !(entity instanceof RpgEntity)){
			ChickenRpg chickenrpg = new ChickenRpg(mcWorld);
			RpgChicken rpgchicken = new RpgChicken(chickenrpg);
			 
			chickenrpg.setPosition(location.getX(), location.getY(), location.getZ());
			chickenrpg.setBukkitEntity(rpgchicken);
			
			mcWorld.removeEntity(mcEntity);
			mcWorld.addEntity(chickenrpg, SpawnReason.CUSTOM);
			
			Bukkit.broadcastMessage("A pengin has spawned!");
			return;
		}
		
		
		/*if(!checked){
			System.out.println("check");
			for(EntityRpgData er :RpgEntities.em.getEntityRpgs()){
				if(type == er.getType()){
					Bukkit.broadcastMessage("A " + type.getName() + " has spawned!");
					if(er.getSpawnReasons().contains(spawnReason)){
						Bukkit.broadcastMessage("A " + er.getName() + " has this spawn reason!");
						Biome biome = entity.getLocation().getBlock().getBiome();
						if(er.getBiomes().contains(biome)){
							Bukkit.broadcastMessage("A " + er.getName() + " has this biome!");
							
							//EntityLiving entityliving = new EntityChicken(world);
							//EntityLiving entityliving = (EntityLiving) EntityTypes.a(93, world);
							
							RpgChicken chicken = new RpgChicken(new ChickenRpg(world));
							EntityLiving entityliving = (EntityLiving) chicken.getEntity();
							((EntityRpg)entityliving).setBukkitEntity(chicken);
							
							
							entityliving.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
		                    entityliving.az = entityliving.yaw;
		                    entityliving.ax = entityliving.yaw;
		                    //entityliving.bG();
							world.removeEntity(((CraftEntity)entity).getHandle());
							world.addEntity(entityliving);
							
							int i = MathHelper.floor(entityliving.locX / 16.0D);
					        int j = MathHelper.floor(entityliving.locZ / 16.0D);
							world.getChunkAt(i, j).a(entityliving);
							world.entityList.add(entityliving);
							Method m;
							try {
								m = world.getClass().getDeclaredMethod("a", net.minecraft.server.v1_4_R1.Entity.class);
								m.setAccessible(true);
								m.invoke(world, entityliving);
							} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
							entityliving.aO();
							
							WolfRpg wolfRpg = new WolfRpg(world);
							wolfRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
							world.addEntity(wolfRpg);
							RpgEntity wolf = new RpgWolf(wolfRpg);
							
							if(entityliving.getBukkitEntity() instanceof RpgEntity){
								System.out.println("true");
							}
							
							SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
							for(int k = 0; k < onplayers.length; k++){
								onplayers[k].setEntitySkin((LivingEntity) entityliving.getBukkitEntity(), "http://dl.lynxdragon.com/rpgessentials/mobs/penguin.png", EntitySkinType.DEFAULT);
							}
							
							UUID id = entity.getUniqueId();
							chickens.put(id, (Chicken) entity);
							
							Bukkit.broadcastMessage("A " + er.getName() + " has spawned!");
							checked = true;
						}
					}
				}
			}
		}*/
		
		/*if(event.getSpawnReason() == SpawnReason.NATURAL || event.getSpawnReason() == SpawnReason.SPAWNER || event.getSpawnReason() == SpawnReason.SPAWNER_EGG){
			if(type == EntityType.CHICKEN){
				Biome biome = event.getEntity().getLocation().getBlock().getBiome();
				if(biome.equals(Biome.TAIGA) || biome.equals(Biome.FROZEN_OCEAN) || biome.equals(Biome.FROZEN_RIVER) || biome.equals(Biome.ICE_MOUNTAINS) || biome.equals(Biome.ICE_PLAINS) || biome.equals(Biome.TAIGA_HILLS)){
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
		}*/
	}
}
