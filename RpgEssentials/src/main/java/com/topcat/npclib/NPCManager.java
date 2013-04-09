package com.topcat.npclib;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;
import com.topcat.npclib.nms.BServer;
import com.topcat.npclib.nms.BWorld;
import com.topcat.npclib.nms.NPCEntity;
import com.topcat.npclib.nms.NPCNetworkManager;
import net.minecraft.server.v1_4_R1.Entity;
import net.minecraft.server.v1_4_R1.PlayerInteractManager;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_4_R1.entity.CraftEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author martin
 */
public class NPCManager {

	private class SL implements Listener {
		@EventHandler
		public void onPluginDisable(final PluginDisableEvent event) {
			if (event.getPlugin() == plugin) {
				despawnAll();
				Bukkit.getServer().getScheduler().cancelTask(taskid);
			}
		}
	}

	private class WL implements Listener {
		@EventHandler
		public void onChunkLoad(final ChunkLoadEvent event) {
			for (final NPC npc : npcs.values()) {
				if (npc != null && event.getChunk() == npc.getBukkitEntity().getLocation().getBlock().getChunk()) {
					final BWorld world = getBWorld(event.getWorld());
					world.getWorldServer().addEntity(npc.getEntity());
				}
			}
		}
	}

	private final HashMap<String, NPC>	npcs	= new HashMap<String, NPC>();
	private final BServer				server;
	private final int					taskid;
	private final Map<World, BWorld>	bworlds	= new HashMap<World, BWorld>();

	private NPCNetworkManager			npcNetworkManager;

	public static JavaPlugin			plugin;

	public NPCManager(final JavaPlugin plugin) {
		server = BServer.getInstance();

		try {
			npcNetworkManager = new NPCNetworkManager();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		NPCManager.plugin = plugin;
		taskid = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				final HashSet<String> toRemove = new HashSet<String>();
				for (final String i : npcs.keySet()) {
					final Entity j = npcs.get(i).getEntity();
					j.y();
					if (j.dead) {
						toRemove.add(i);
					}
				}
				for (final String n : toRemove) {
					npcs.remove(n);
				}
			}
		}, 1L, 1L);
		Bukkit.getServer().getPluginManager().registerEvents(new SL(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new WL(), plugin);
	}

	public void despawnAll() {
		for (final NPC npc : npcs.values()) {
			if (npc != null) {
				npc.removeFromWorld();
			}
		}
		npcs.clear();
	}

	public void despawnById(final String id) {
		final NPC npc = npcs.get(id);
		if (npc != null) {
			npcs.remove(id);
			npc.removeFromWorld();
		}
	}

	public void despawnHumanByName(String npcName) {
		if (npcName.length() > 16) {
			npcName = npcName.substring(0, 16); //Ensure you can still despawn
		}
		final HashSet<String> toRemove = new HashSet<String>();
		for (final String n : npcs.keySet()) {
			final NPC npc = npcs.get(n);
			if (npc instanceof HumanNPC) {
				if (npc != null && ((HumanNPC) npc).getName().equals(npcName)) {
					toRemove.add(n);
					npc.removeFromWorld();
				}
			}
		}
		for (final String n : toRemove) {
			npcs.remove(n);
		}
	}

	public BWorld getBWorld(final World world) {
		BWorld bworld = bworlds.get(world);
		if (bworld != null) {
			return bworld;
		}
		bworld = new BWorld(world);
		bworlds.put(world, bworld);
		return bworld;
	}

	public List<NPC> getHumanNPCByName(final String name) {
		final List<NPC> ret = new ArrayList<NPC>();
		final Collection<NPC> i = npcs.values();
		for (final NPC e : i) {
			if (e instanceof HumanNPC) {
				if (((HumanNPC) e).getName().equalsIgnoreCase(name)) {
					ret.add(e);
				}
			}
		}
		return ret;
	}

	public NPC getNPC(final String id) {
		return npcs.get(id);
	}

	public String getNPCIdFromEntity(final org.bukkit.entity.Entity e) {
		if (e instanceof HumanEntity) {
			for (final String i : npcs.keySet()) {
				if (npcs.get(i).getBukkitEntity().getEntityId() == ((HumanEntity) e).getEntityId()) {
					return i;
				}
			}
		}
		return null;
	}
	
	public NPC getNPCFromEntity(final org.bukkit.entity.Entity e) {
		if (e instanceof HumanEntity) {
			for (final String i : npcs.keySet()) {
				if (npcs.get(i).getBukkitEntity().getEntityId() == ((HumanEntity) e).getEntityId()) {
					return npcs.get(i);
				}
			}
		}
		return null;
	}

	public NPCNetworkManager getNPCNetworkManager() {
		return npcNetworkManager;
	}

	public List<NPC> getNPCs() {
		return new ArrayList<NPC>(npcs.values());
	}

	public BServer getServer() {
		return server;
	}

	public boolean isNPC(final org.bukkit.entity.Entity e) {
		return ((CraftEntity) e).getHandle() instanceof NPCEntity;
	}
	
	public void rename(String id, String name) {
        if (name.length() > 16) { // Check and nag if name is too long, spawn NPC anyway with shortened name.
            String tmp = name.substring(0, 16);
            server.getLogger().log(Level.WARNING, "NPCs can't have names longer than 16 characters,");
            server.getLogger().log(Level.WARNING, name + " has been shortened to " + tmp);
            name = tmp;
        }
        HumanNPC npc = (HumanNPC) getNPC(id);
        npc.setName(name);
        BWorld b = getBWorld(npc.getBukkitEntity().getLocation().getWorld());
        WorldServer s = b.getWorldServer();
        try {
            Method m = s.getClass().getDeclaredMethod("b", new Class[] {Entity.class});
            m.setAccessible(true);
            m.invoke(s, npc.getEntity());
            m = s.getClass().getDeclaredMethod("a", new Class[] {Entity.class});
            m.setAccessible(true);
            m.invoke(s, npc.getEntity());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        s.everyoneSleeping();
    }

	public NPC spawnHumanNPC(final String name, final Location l) {
		int i = 0;
		String id = name;
		while (npcs.containsKey(id)) {
			i++;
			id = name + i;
		}
		return spawnHumanNPC(name, l, id);
	}

	public NPC spawnHumanNPC(String name, final Location l, final String id) {
		if (npcs.containsKey(id)) {
			server.getLogger().log(Level.WARNING, "NPC with that id already exists, existing NPC returned");
			return npcs.get(id);
		} else {
			if (name.length() > 16) { // Check and nag if name is too long, spawn NPC anyway with shortened name.
				final String tmp = name.substring(0, 16);
				server.getLogger().log(Level.WARNING, "NPCs can't have names longer than 16 characters,");
				server.getLogger().log(Level.WARNING, name + " has been shortened to " + tmp);
				name = tmp;
			}
			final BWorld world = getBWorld(l.getWorld());
			final NPCEntity npcEntity = new NPCEntity(this, world, name, new PlayerInteractManager(world.getWorldServer()));
			npcEntity.setPositionRotation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
			world.getWorldServer().addEntity(npcEntity); //the right way
			final NPC npc = new HumanNPC(npcEntity);
			npcs.put(id, npc);
			return npc;
		}
	}

}