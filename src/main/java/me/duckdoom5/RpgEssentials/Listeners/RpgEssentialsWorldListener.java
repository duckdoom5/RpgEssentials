package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;

public class RpgEssentialsWorldListener implements Listener{
	public static RpgEssentials plugin;
	
	public static HashMap<World, Boolean> worlds = new LinkedHashMap<World, Boolean>();
	
	public RpgEssentialsWorldListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onWorldLoad(WorldLoadEvent event){
		World world = event.getWorld();
		
		if(!Configuration.config.contains("worlds.enabled." + world.getName())){
			Configuration.config.set("worlds.enabled." + world.getName(), true);
			try {
				Configuration.config.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			worlds.put(world, true);
		}else{
			worlds.put(world, Configuration.config.getBoolean("worlds.enabled." + world.getName()));
		}
		
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
					NPC pc = plugin.m.spawnHumanNPC(name, loc);
					HumanNPC npc = (HumanNPC) pc;
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
					if(Configuration.npc.contains("Npc." + name + ".helmet")){
						Material material = Material.getMaterial(Configuration.npc.getInt("Npc." + name + ".helmet"));
						npc.getInventory().setHelmet(new ItemStack(material));
					}
					if(Configuration.npc.contains("Npc." + name + ".chestplate")){
						Material material = Material.getMaterial(Configuration.npc.getInt("Npc." + name + ".chestplate"));
						npc.getInventory().setChestplate(new ItemStack(material));
					}
					if(Configuration.npc.contains("Npc." + name + ".leggings")){
						Material material = Material.getMaterial(Configuration.npc.getInt("Npc." + name + ".leggings"));
						npc.getInventory().setLeggings(new ItemStack(material));
					}
					if(Configuration.npc.contains("Npc." + name + ".boots")){
						Material material = Material.getMaterial(Configuration.npc.getInt("Npc." + name + ".boots"));
						npc.getInventory().setBoots(new ItemStack(material));
					}
				}
			}
		}
	}
}
