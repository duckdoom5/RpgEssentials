package me.duckdoom5.RpgEssentials.RpgPets.pets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import net.minecraft.server.v1_4_6.Entity;
import net.minecraft.server.v1_4_6.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_4_6.CraftWorld;
import org.bukkit.craftbukkit.v1_4_6.entity.CraftEntity;

public class RpgEntityManager {
	private static HashMap<Integer, RpgEntity> entities = new LinkedHashMap<Integer, RpgEntity>();
	
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
	
	public RpgEntity spawnRpgEntity(String name, Location l, OfflinePlayer owner, RpgEntityType type) {
		int i = 0;
		while(entities.containsKey(i)) {
			i++;
		}
		return spawnRpgEntity(name, l, i, owner, type);
	}
	
	public RpgEntity spawnRpgEntity(String name, Location l, int id, OfflinePlayer owner, RpgEntityType type) {
		if (entities.containsKey(id)) {
			RpgEssentials.log.warning("Entity with that id already exists, existing entity returned");
			return entities.get(id);
		}
		if(type.equals(RpgEntityType.CAT)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			CatRpg catRpg = new CatRpg(world);
			catRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(catRpg);
			RpgEntity cat = new RpgCat(catRpg, owner, id);
			entities.put(id, cat);
			return cat;
			
		}else if(type.equals(RpgEntityType.WOLF)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			WolfRpg wolfRpg = new WolfRpg(world);
			wolfRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(wolfRpg);
			RpgEntity wolf = new RpgWolf(wolfRpg, owner, id);
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
