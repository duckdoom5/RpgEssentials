package me.duckdoom5.RpgEssentials.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.entity.Player;

public class RpgPlayerManager {
	//private HashSet<OfflinePlayer> owners = new LinkedHashSet<OfflinePlayer>();
	//private static HashMap<Entity, RpgEntity> entities = new LinkedHashMap<Entity, RpgEntity>();
	private HashMap<String, RpgPlayer> players = new LinkedHashMap<String, RpgPlayer>();
	
	//private static HashMap<String, RpgEntity2> entities2 = new LinkedHashMap<String, RpgEntity2>();
	
	/*public static RpgEntity getRpgEntity(Entity e){
		return entities.get(e);
	}*/
	
	public RpgPlayer getRpgPlayer(String name){
		return players.get(name);
	}
	
	/*public static RpgEntity[] getAllRpgEntities(){
		RpgEntity[] entityarray = new RpgEntity[entities.size()];
		int i = 0;
		for(RpgEntity e:entities.values()){
			entityarray[i] = e;
			i++;
		}
		return entityarray;
	}*/
	
	/*public static boolean isRpgEntity(Entity e){
		return entities.containsKey(e);
	}*/
	
	/*public boolean hasPet(OfflinePlayer owner){
		if(owners.contains(owner)){
			return true;
		}
		return false;
	}*/
	
	/*public static RpgEntity[] getPets(OfflinePlayer owner){
		RpgEntity[] entities = getAllRpgEntities();
		RpgEntity[] pets = new RpgEntity[100];
		int i = 0;
		for(RpgEntity e:entities){
			//if(//e.getOwner().equals(owner)){
				//pets[i] = e;
				//i++;
			//}
		}
		return pets;
	}*/
	
	//private static Boolean isLoaded = false;
	
	/*public static void loadPets() {
		if(!isLoaded){
			for(RpgEntityType type: RpgEntityType.values()){
				if(Configuration.pets.contains(type.toString().toLowerCase())){
					ConfigurationSection section = Configuration.pets.getConfigurationSection(type.toString().toLowerCase());
					Iterator keys = section.getKeys(false).iterator();
					while(keys.hasNext()){
						ConfigurationSection section2 = Configuration.pets.getConfigurationSection((String) keys.next());
						Iterator keys2 = section.getKeys(false).iterator();
						OfflinePlayer owner = Bukkit.getServer().getOfflinePlayer((String) keys2.next());
						
						int id = 0;
		    			for(id = 0; Configuration.pets.contains("wolf." + owner.getName() + "." + id + ".name"); id++){
		    				//addPet(owner, id);
		    			}
					}
				}else{
					RpgEssentials.log.warning("Pets doesn't contain: " + type.toString().toLowerCase());
				}
			}
			isLoaded = true;
		}
	}*/
	
	/*public static void removePet(OfflinePlayer player){
		if(hasPet(player)){
        	RpgEntity[] pets = getPets(player);
        	for(RpgEntity e:pets){
        		e.save();
    			//e.getEntity().remove();
        	}
        }
	}*/
	
	/*public static void addPet(OfflinePlayer owner, int id) {
		World world = Bukkit.getWorld(Configuration.pets.getString("wolf." + owner.getName() + "." + id + ".world"));
		org.bukkit.util.Vector vector = Configuration.pets.getVector("wolf." + owner.getName() + "." + id + ".location.vector");
		int pitch = Configuration.pets.getInt("wolf." + owner.getName() + "." + id + ".location.pitch");
		int yaw = Configuration.pets.getInt("wolf." + owner.getName() + "." + id + ".location.yaw");
		Location location = vector.toLocation(world, yaw, pitch);
		
    	Wolf wolf = (Wolf) world.spawnCreature(location, EntityType.WOLF);  
    	
		RpgWolf rwolf = new RpgWolf(owner, wolf, id, location);
		RpgEssentials.log.warning("create wolf");
	}*/
	
	public void removePlayer(Player player){
		//players.remove(player);
		//why did I even do that, this way players won't be saved
	}
	
	public void addPlayer(String name, RpgPlayer rpgplayer){
		players.put(name, rpgplayer);
	}
	
	public void loadPlayers(){
		File dir = new File("plugins/RpgEssentials/Temp/players/");
		String[] names = dir.list();
		if(names != null){
			for(String name:names){
				try {
					RpgPlayer player = (RpgPlayer) Configuration.load("plugins/RpgEssentials/Temp/players/" + name);
					addPlayer(player.getName(), player);
				} catch (FileNotFoundException e) {
					RpgEssentials.log.info(name + " is not found.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void savePlayer(Player player){
		try {
			File file = new File("plugins/RpgEssentials/Temp/players");
			if(!file.exists()){
				file.mkdirs();
			}
			Configuration.save(player, "plugins/RpgEssentials/Temp/players/" + player.getName() + ".player");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void savePlayers(){
		for(RpgPlayer player:players.values()){
			try {
				File file = new File("plugins/RpgEssentials/Temp/players");
				if(!file.exists()){
					file.mkdirs();
				}
				Configuration.save(player, "plugins/RpgEssentials/Temp/players/" + player.getName() + ".player");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public static void addPet(OfflinePlayer owner,Entity e, RpgEntity entity) {
		entities.put(e, entity);
		owners.add(owner);
	}*/
	
	/*public RpgEntity2 spawnRpgEntity(String name, Location l, RpgEntityType type) {
		int i = 0;
		String id = name;
		while(entities2.containsKey(id)) {
			
			id = name + i;
			i++;
		}
		return spawnRpgEntity(name, l, id, type);
	}*/

	/*public RpgEntity2 spawnRpgEntity(String name, Location l, String id, RpgEntityType type) {
		if (entities2.containsKey(id)) {
			RpgEssentials.log.warning("Entity with that id already exists, existing entity returned");
			return entities2.get(id);
		}
		if(type.equals(RpgEntityType.CAT)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			CatRpg catRpg = new CatRpg(world);
			catRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(catRpg);
			RpgEntity2 cat = new RpgCat(catRpg);
			entities2.put(id, cat);
			return cat;
			
		}else if(type.equals(RpgEntityType.WOLF)){
			WorldServer world = ((CraftWorld)l.getWorld()).getHandle();
			WolfRpg wolfRpg = new WolfRpg(world);
			wolfRpg.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.addEntity(wolfRpg);
			RpgEntity2 cat = new RpgCat(wolfRpg);
			entities2.put(id, cat);
			return cat;
		}
		return null;
	}*/
}
