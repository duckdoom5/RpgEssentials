package me.duckdoom5.RpgEssentials.Listeners;

import java.util.Iterator;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.util.Vector;

import com.topcat.npclib.entity.HumanNPC;

public class RpgEssentialsWorldListener implements Listener{
	public static RpgEssentials plugin;
	
	public RpgEssentialsWorldListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onWorldLoad(WorldLoadEvent event){
		World world = event.getWorld();
		System.out.println(world.getName());
		

		ConfigurationSection section = Configuration.npc.getConfigurationSection("Npc");
		if(section != null){
			Iterator keys = section.getKeys(false).iterator();
			for(int i = 0; keys.hasNext(); ++i){
				String name = (String)keys.next();
				if(world.getName().equalsIgnoreCase(Configuration.npc.getString("Npc." + name + ".world"))){
					Vector location = Configuration.npc.getVector("Npc." + name + ".location");
					float pitch = Configuration.npc.getInt("Npc." + name + ".pitch");
					float yaw = Configuration.npc.getInt("Npc." + name + ".yaw");
					Location loc = location.toLocation(world, yaw, pitch);
					HumanNPC npc = (HumanNPC) plugin.m.spawnHumanNPC(name, loc);
					if(Configuration.npc.contains("Npc." + name + ".cape")){
						if(Configuration.npc.getString("Npc." + name + ".cape").contains(".png")){
							npc.getSpoutPlayer().setCape(Configuration.npc.getString("Npc." + name + ".cape"));
						}else{
							System.out.println("[RpgEssentials] NPC cape file must be a png !");
						}
					}
					if(Configuration.npc.contains("Npc." + name + ".skin")){
						if(Configuration.npc.getString("Npc." + name + ".skin").contains(".png")){
							npc.getSpoutPlayer().setSkin(Configuration.npc.getString("Npc." + name + ".skin"));
						}else{
							System.out.println("[RpgEssentials] NPC skin file must be a png !");
						}
					}
					if(Configuration.npc.contains("Npc." + name + ".item")){
						Material material = Material.getMaterial(Configuration.npc.getInt("Npc." + name + ".item"));
						if(Configuration.npc.contains("Npc." + name + ".item data")){
							short data = (short) Configuration.npc.getInt("Npc." + name + ".item data");
							npc.setItemInHand(material, data);
						}else{
							npc.setItemInHand(material);
						}
					}
				}
			}
		}
	}
}
