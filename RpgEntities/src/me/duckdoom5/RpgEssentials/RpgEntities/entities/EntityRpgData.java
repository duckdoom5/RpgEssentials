package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import java.util.ArrayList;

import me.duckdoom5.RpgEssentials.RpgEntities.Listeners.EntityListener;

import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class EntityRpgData {
	private String name;
	private String skinUrl;
	private EntityType type;
	private ArrayList<SpawnReason> spawnReasons;
	private ArrayList<Biome> biomes;
	
	public EntityRpgData(String name, EntityType type, String skinUrl, ArrayList<SpawnReason> spawnReasons, ArrayList<Biome> biomes){
		this.name = name;
		this.type = type;
		this.skinUrl = skinUrl;
		this.spawnReasons = spawnReasons;
		this.biomes = biomes;
		
		EntityListener.registerEntity(this);
	}

	public EntityType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getSkinUrl() {
		return skinUrl;
	}

	public ArrayList<SpawnReason> getSpawnReasons() {
		return spawnReasons;
	}

	public ArrayList<Biome> getBiomes() {
		return biomes;
	}
}
