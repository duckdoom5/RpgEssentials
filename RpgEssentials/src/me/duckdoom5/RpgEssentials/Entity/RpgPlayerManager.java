package me.duckdoom5.RpgEssentials.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.entity.Player;

public class RpgPlayerManager {
	private HashMap<String, RpgPlayer> players = new LinkedHashMap<String, RpgPlayer>();
	private HashMap<String, RpgPlayerBank> banks = new LinkedHashMap<String, RpgPlayerBank>();
	private HashMap<String, RpgPlayerQuest> quests = new LinkedHashMap<String, RpgPlayerQuest>();
	
	public void loadPlayers(){
		File dir = new File("plugins/RpgEssentials/Temp/players/");
		String[] names = dir.list();
		if(names != null){
			for(String name:names){
				try {
					RpgPlayer player = (RpgPlayer) Configuration.load("plugins/RpgEssentials/Temp/players/" + name);
					addPlayer(player.getName(), player);
					
					if(RpgEssentials.RpgBanks != null && new File("plugins/RpgBanks/Temp/players/" + name).exists()){
						RpgPlayerBank playerbank = (RpgPlayerBank) Configuration.load("plugins/RpgBanks/Temp/players/" + name);
						addPlayerBank(playerbank.getName(), playerbank);
					}
					
					if(RpgEssentials.RpgQuests != null && new File("plugins/RpgQuests/Temp/players/" + name).exists()){
						RpgPlayerQuest playerquest = (RpgPlayerQuest) Configuration.load("plugins/RpgQuests/Temp/players/" + name);
						addPlayerQuest(playerquest.getName(), playerquest);
					}
				} catch (FileNotFoundException e) {
					RpgEssentials.log.info(name + " was not found.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void savePlayer(Player player){
		savePlayer(player.getName());
	}
	
	public void savePlayer(String playername){
		try {
			File file = new File("plugins/RpgEssentials/Temp/players");
			if(!file.exists()){
				file.mkdirs();
			}
			Configuration.save(players.get(playername), "plugins/RpgEssentials/Temp/players/" + playername + ".player");
			
			if(banks.containsKey(playername)){
				File bfile = new File("plugins/RpgBanks/Temp/players");
				if(!bfile.exists()){
					bfile.mkdirs();
				}
				Configuration.save(banks.get(playername), "plugins/RpgBanks/Temp/players/" + playername + ".player");
			}
			
			if(quests.containsKey(playername)){
				File qfile = new File("plugins/RpgQuests/Temp/players");
				if(!qfile.exists()){
					qfile.mkdirs();
				}
				Configuration.save(quests.get(playername), "plugins/RpgQuests/Temp/players/" + playername + ".player");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void savePlayers(){
		for(RpgPlayer player:players.values()){
			savePlayer(player.getName());
		}
	}
	
	public void deletePlayer(Player player){
		players.remove(player);
	}
	
	public RpgPlayer getRpgPlayer(Player player){
		return players.get(player.getName());
	}
	
	public RpgPlayerBank getRpgPlayerBank(Player player){
		return banks.get(player.getName());
	}
	
	public RpgPlayerQuest getRpgPlayerQuest(Player player){
		return quests.get(player.getName());
	}
	
	public RpgPlayer getRpgPlayer(String playername){
		return players.get(playername);
	}
	
	public RpgPlayerBank getRpgPlayerBank(String playername){
		return banks.get(playername);
	}
	
	public RpgPlayerQuest getRpgPlayerQuest(String playername){
		return quests.get(playername);
	}
	
	public void addPlayer(String name, RpgPlayer rpgplayer){
		players.put(name, rpgplayer);
	}
	
	public void addPlayerBank(String name, RpgPlayerBank rpgplayer){
		banks.put(name, rpgplayer);
	}
	
	public void addPlayerQuest(String name, RpgPlayerQuest rpgplayer){
		quests.put(name, rpgplayer);
	}
	//private HashSet<OfflinePlayer> owners = new LinkedHashSet<OfflinePlayer>();
	//private static HashMap<Entity, RpgEntity> entities = new LinkedHashMap<Entity, RpgEntity>();
	
	
	//private static HashMap<String, RpgEntity2> entities2 = new LinkedHashMap<String, RpgEntity2>();
	
	/*public static RpgEntity getRpgEntity(Entity e){
		return entities.get(e);
	}*/
	
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
