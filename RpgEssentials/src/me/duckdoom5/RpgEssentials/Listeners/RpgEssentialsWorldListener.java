package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Generator.BO2Populator;
import me.duckdoom5.RpgEssentials.Generator.DungeonPopulator;
import me.duckdoom5.RpgEssentials.Generator.OldStuffDeleter;
import me.duckdoom5.RpgEssentials.Generator.PlantsPopulator;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;

public class RpgEssentialsWorldListener implements Listener{
	public RpgEssentials plugin;
	
	public HashMap<World, Boolean> worlds = new LinkedHashMap<World, Boolean>();
	
	public HashMap<World, Boolean> generateworlds = new LinkedHashMap<World, Boolean>();
	
	public RpgEssentialsWorldListener(RpgEssentials instance) {
        plugin = instance; 
    }
	
	@EventHandler
	public void onWorldInit(WorldInitEvent event){
		World world = event.getWorld();
		//check if world is enabled for leveling etc
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
		
		if(!Configuration.generator.contains("generator.enabled." + world.getName())){
			Configuration.generator.set("generator.enabled." + world.getName(), false);
			try {
				Configuration.generator.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			generateworlds.put(world, false);
		}else{
			generateworlds.put(world, Configuration.generator.getBoolean("generator.enabled." + world.getName()));
		}
		
		if(!Configuration.texture.contains(world.getName())){
			Configuration.texture.set(world.getName() + ".XXMrPiggyCompanyXX.url", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.zip");
			Configuration.texture.set(world.getName() + ".XXMrPiggyCompanyXX.icon", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.png");
			try {
				Configuration.texture.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Configuration.generator.set("generator.enabled." + world.getName() + ".Ores", false);
		
		if(generateworlds.get(world)) {
			if(world.getEnvironment().equals(Environment.NORMAL)) {
				//old stuff deleter
				world.getPopulators().add(new OldStuffDeleter());
				/*
				//ores
				if(Configuration.generator.getBoolean("Global.Ores.Original")){
					world.getPopulators().add(new VanillaOresPopulator());
				}
				if(Configuration.generator.getBoolean("Global.Ores.Custom")){
					world.getPopulators().add(new CustomOresPopulator());
				}*/
				
				//dungeons
				if(Configuration.generator.getBoolean("Global.Structures.dungeons")){
					world.getPopulators().add(new DungeonPopulator());
				}
				
				//BO2objects
				world.getPopulators().add(new BO2Populator());
				
				//plants
				world.getPopulators().add(new PlantsPopulator());
				
			}else if(world.getEnvironment().equals(Environment.NETHER)){
				//add nether populators
			}
		}
		
		if(Configuration.config.getBoolean("use default config")){
			if(!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 32x.url")){
				Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 32x.url", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.zip");
			}
			if(!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 32x.iconurl")){
				Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 32x.iconurl", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.png");
			}
			
			if(!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 16x.url")){
				Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 16x.url", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.zip");
			}
			if(!Configuration.texture.contains(world.getName() + "." + "xXMrPiggyCompanyXx 16x.iconurl")){
				Configuration.texture.set(world.getName() + "." + "xXMrPiggyCompanyXx 16x.iconurl", "http://dl.lynxdragon.com/rpgessentials/textures/XXMrPiggyCompanyXX.png");
			}
			try {
				Configuration.texture.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@EventHandler
	public void onWorldLoad(WorldLoadEvent event){
	 System.out.println("RPG Essentials Load World: " + event.getWorld().getName()); 
	     
	}
}
