package me.duckdoom5.RpgEssentials.NPC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.LivingEntity;

public class Create {

	public Create(World world, Location location){
		LivingEntity npc = Bukkit.getWorld(world.getName()).spawnCreature(location, CreatureType.VILLAGER);
		
	}
}
