package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.Config.Configuration;
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_4_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.getspout.spoutapi.SpoutManager;

public class RpgEntityManager {
	//private HashMap<EntityRpg> ;
	private HashMap<EntityType, Class<? extends RpgEntity>> typeToClass = new HashMap<EntityType, Class<? extends RpgEntity>>();
	private static HashSet<EntityRpgData> entityrpgs = new LinkedHashSet<EntityRpgData>();
	
	private static HashMap<Integer, RpgEntity> entities = new LinkedHashMap<Integer, RpgEntity>();
	
	
	public RpgEntityManager(){
		loadEntityToClass();
		ConfigurationSection section = Configuration.entities.getConfigurationSection("Entities");
		Iterator<?> keys = section.getKeys(false).iterator();
		while(keys.hasNext()){
			String name = (String)keys.next();
			EntityType type = EntityType.valueOf(Configuration.entities.getString("Entities." + name + ".type").toUpperCase().replace(" ", "_"));
			String skin = Configuration.entities.getString("Entities." + name + ".skin url");
			SpoutManager.getFileManager().addToPreLoginCache(RpgEntities.plugin, skin);
			List<String> list = (List<String>) Configuration.entities.getList("Entities." + name + ".spawn mode");
			ArrayList<SpawnReason> spawnReasons = new ArrayList<SpawnReason>();
			for(String mode:list){
				spawnReasons.add(SpawnReason.valueOf(mode.toUpperCase().replace(" ", "_")));
			}
			
			List<String> list2 = (List<String>) Configuration.entities.getList("Entities." + name + ".spawn biome");
			ArrayList<Biome> biomes = new ArrayList<Biome>();
			for(String biome:list2){
				biomes.add(Biome.valueOf(biome.toUpperCase().replace(" ", "_")));
			}
			
			entityrpgs.add(new EntityRpgData(name, type, skin, spawnReasons, biomes));
			
			//register spawn
			//entity rpg / listener
			
			
			//customizable: type , name, skin
		}
	}
	
	public HashSet<EntityRpgData> getEntityRpgs(){
		return entityrpgs;
	}
	
	public void loadEntityToClass(){
		typeToClass.put(EntityType.CHICKEN, RpgChicken.class);
		typeToClass.put(EntityType.WOLF, RpgWolf.class);
		typeToClass.put(EntityType.OCELOT, RpgCat.class);
		//entityToClass.put("wolf", RpgWolf.class);
		//entityToClass.put("wolf", RpgWolf.class);
	}
	
	public void respawn(final RpgEntity e, int timeInSeconds){
		if(!e.getState().equals(RpgEntityState.DEAD))
			return;
		
		Long time = (long) (timeInSeconds * 20);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("RpgEssentials"), new Runnable() {
		    public void run() {
		    	Location l = e.getBukkitEntity().getLocation();
		    	WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
		    	world.addEntity(e.getEntity());
		    	e.setState(RpgEntityState.ALIVE);
		    }
		}, time);
	}
	
	public RpgEntity spawnRpgEntity(Location l, EntityType type) {
		int i = 0;
		while(entities.containsKey(i)) {
			i++;
		}
		return spawnRpgEntity(l, i, type);
	}
	
	public RpgEntity spawnRpgEntity(Location l, int id, EntityType type) {
		if (entities.containsKey(id)) {
			RpgEssentials.log.warning("Entity with that id already exists, existing entity returned");
			return entities.get(id);
		}
		if(type.equals(EntityType.OCELOT)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			CatRpg catRpg = new CatRpg(world);
			catRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(catRpg);
			RpgEntity cat = new RpgCat(catRpg);
			entities.put(id, cat);
			return cat;
			
		}else if(type.equals(EntityType.WOLF)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			WolfRpg wolfRpg = new WolfRpg(world);
			wolfRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(wolfRpg);
			RpgEntity wolf = new RpgWolf(wolfRpg);
			entities.put(id, wolf);
			return wolf;
		}
		return null;
	}
	
	public void despawnById(String id) {
		RpgEntity entity = entities.get(id);
		if (entity != null) {
			entities.remove(id);
			entity.removeFromWorld();
		}
	}
	
	public void despawnAll() {
		for (RpgEntity entity : entities.values()) {
			if (entity != null) {
				entity.removeFromWorld();
			}
		}
		entities.clear();
	}
	
	public RpgEntity getRpgEntity(String id) {
		return entities.get(id);
	}
	
	public boolean isRpgEntity(org.bukkit.entity.Entity e) {
		Entity entity = ((CraftEntity) e).getHandle();
		if(entity instanceof CatRpg || entity instanceof WolfRpg){
			return true;
		}
		return false;
	}
	
	public List<RpgEntity> getRpgEntities() {
		return new ArrayList<RpgEntity>(entities.values());
	}
}
