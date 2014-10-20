package me.duckdoom5.RpgEssentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.Entity.RpgNpc;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.topcat.npclib.NPCManager;
import com.topcat.npclib.entity.NPC;

public class RpgNpcManager {
    private final HashMap<String, RpgNpc> npcs = new LinkedHashMap<>();
    private final HashMap<Player, String> selected = new LinkedHashMap<>();
    private final NPCManager nm;

    public RpgNpcManager(JavaPlugin plugin) {
        nm = new NPCManager(plugin);
        loadNpcs();
    }

    public void loadNpcs() {
        final File dir = new File("plugins/RpgEssentials/Temp/npcs/");
        final String[] names = dir.list();
        if (names != null) {
            for (final String name : names) {
                try {
                    final RpgNpc npc = (RpgNpc) Configuration.load("plugins/RpgEssentials/Temp/npcs/" + name);
                    addNPC(npc.getId(), npc);
                } catch (final FileNotFoundException e) {
                    RpgEssentials.getLog().info(name + " was not found.");
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveNPC(RpgNpc npc) {
        try {
            final File file = new File("plugins/RpgEssentials/Temp/npcs");
            if (!file.exists()) {
                file.mkdirs();
            }
            Configuration.save(npc, "plugins/RpgEssentials/Temp/npcs/" + npc.getId() + ".npc");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void spawnNpcsForWorld(World world) {
        // no reach
        for (final RpgNpc npc : npcs.values()) {
            System.out.println(npc.getName());
            System.out.println(world == npc.getWorld());
            System.out.println(world.getName());
            System.out.println(npc.getWorld().getName());
            if (world == npc.getWorld()) {
                nm.addHumanNPC(npc.getName(), npc.getLocation(), npc.getId());
                npc.initialize();
            }
        }
    }

    public void saveNpcs() {
        for (final String name : npcs.keySet()) {
            saveNPC(npcs.get(name));
        }
    }

    public void deleteRpgNpc(String npcId) {
        npcs.remove(npcId);
    }

    public void deleteRpgNpc(RpgNpc npc) {
        npcs.remove(npc.getId());
    }

    public void deleteRpgNpc(NPC npc) {
        npcs.remove(getNPCManager().getNPCIdFromEntity(npc.getBukkitEntity()));
    }

    public RpgNpc getRpgNpc(NPC npc) {
        return npcs.get(getNPCManager().getNPCIdFromEntity(npc.getBukkitEntity()));
    }

    public RpgNpc getRpgNpc(String npcId) {
        return npcs.get(npcId);
    }

    public void addNPC(String name, RpgNpc npc) {
        npcs.put(name, npc);
    }

    public void select(Player player, String id) {
        if (npcs.get(id).equals(player.getName()) || RpgEssentials.hasPermission(player, "rpgessentials.npc.admin")) {
            player.sendMessage(ChatColor.GREEN + "You have selected NPC: " + ChatColor.YELLOW + id);
            selected.put(player, id);
        } else {
            player.sendMessage(ChatColor.RED + "This is not your npc!");
        }
    }

    public void deselect(Player player) {
        selected.remove(player);
        player.sendMessage(ChatColor.GREEN + "You have de-selected your npc!");
    }

    public String getSelected(Player player) {
        if (selected.containsKey(player)) {
            return selected.get(player);
        }
        player.sendMessage(ChatColor.RED + "No npc selected!");
        return null;
    }

    public NPCManager getNPCManager() {
        return nm;
    }
}
