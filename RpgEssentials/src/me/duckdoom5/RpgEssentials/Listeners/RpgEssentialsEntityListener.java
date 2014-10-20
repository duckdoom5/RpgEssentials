package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class RpgEssentialsEntityListener implements Listener {

    public static Map<Player, ItemStack> drops = new HashMap<>();

    public RpgEssentials plugin;
    String skilltype;

    public RpgEssentialsEntityListener(RpgEssentials instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        // if(RpgEssentials.wl.worlds.get(event.getEntity().getWorld())){
        if (event.getEntity() instanceof LivingEntity) {
            final LivingEntity defender = (LivingEntity) event.getEntity();

            if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().isNPC(defender)) {
                event.setCancelled(true);
                return;
            }

            final Entity attacker = event.getDamager();
            if (attacker instanceof Player) {
                if (defender.getNoDamageTicks() > 0) {
                    event.setCancelled(true);
                    return;
                }

                /*
                 * if(RpgEssentials.battlemusic){
                 * if(event.getCause().equals(DamageCause.ENTITY_ATTACK)){
                 * Music.startBattle(plugin, defender.getUniqueId(), splayer); }
                 * }
                 */
            }

            if (defender instanceof Player) {
                final Player player = (Player) defender;
                if (player.getNoDamageTicks() > 0) {
                    event.setCancelled(true);
                    return;
                }

                /*
                 * if(RpgeManager.getInstance().battlemusic){ if(attacker
                 * instanceof Projectile){ Music.startBattle(plugin,
                 * defender.getUniqueId(), splayer); }else if(attacker
                 * instanceof Explosive){ Music.forceStopBattle(plugin,
                 * splayer); }else{ Music.startBattle(plugin,
                 * defender.getUniqueId(), splayer); } }
                 */
            }/*
              * else{ if(RpgPlayerManager.isRpgEntity(defender)){ if(attacker
              * instanceof Player){ Player player = (Player) attacker;
              * if(player.getWorld().getPVP()){ player.sendMessage(ChatColor.RED
              * + "You can't attack a pet in a pvp free world!");
              * event.setCancelled(true); return; } }
              * 
              * //TODO it's not always wolf
              * 
              * RpgWolf rpgwolf = (RpgWolf)
              * RpgPlayerManager.getRpgEntity(defender);
              * rpgwolf.setHealth(rpgwolf.getHealth() - event.getDamage());
              * event.setDamage(0); } }
              */
        }
        // }
    }

    @EventHandler
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event) {
        if (event.getTarget() instanceof Player) {
            if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().isNPC(event.getTarget())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // if(RpgEssentials.wl.worlds.get(event.getEntity().getWorld())){
        /*
         * if(RpgEssentials.battlemusic){ Music.stopBattle(plugin,
         * event.getEntity().getUniqueId()); }
         */

        if (event.getEntity().getLastDamageCause() != null) {
            final EntityDamageEvent event1 = event.getEntity().getLastDamageCause();
            if (event1 instanceof EntityDamageByEntityEvent) {
                final EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent) event1;
                if (event2.getEntity() instanceof LivingEntity) {
                    final Entity attacker = event2.getDamager();
                    if (attacker instanceof Player) {
                    } else if (attacker instanceof Arrow) {
                        if (((Projectile) attacker).getShooter() instanceof Player) {
                        }
                    }
                }
            }

            // TODO make a config list with all mobs and there coin properties

            /*
             * if(player != null && RpgEssentials.coindrop){ SpoutPlayer splayer
             * = SpoutManager.getPlayer(player); if(player.getGameMode() ==
             * GameMode.SURVIVAL && !entity.hasMetadata("spawner")){ Location
             * droplocation = event.getEntity().getLocation(); Random rand = new
             * Random();
             * 
             * int bronzeamount = rand.nextInt(50); int silveramount =
             * rand.nextInt(50); int goldamount = rand.nextInt(50);
             * 
             * if(bronzeamount < 10){ ItemStack bronzedrop = new
             * SpoutItemStack(RpgEssentials.mm.getItemByName("Bronze Coin"),
             * bronzeamount + 1); drops.put(player, bronzedrop);
             * event.getDrops().add(bronzedrop); }else{ ItemStack bronzedrop =
             * new SpoutItemStack(RpgEssentials.mm.getItemByName("Bronze Coin"),
             * 1); drops.put(player, bronzedrop);
             * event.getDrops().add(bronzedrop); } if(silveramount < 5){
             * ItemStack silverdrop = new
             * SpoutItemStack(RpgEssentials.mm.getItemByName("Silver Coin"),
             * silveramount + 1); drops.put(player, silverdrop);
             * event.getDrops().add(silverdrop); } if(goldamount < 1){ ItemStack
             * golddrop = new
             * SpoutItemStack(RpgEssentials.mm.getItemByName("Gold Coin"),
             * goldamount + 1); drops.put(player, golddrop);
             * event.getDrops().add(golddrop); } } }
             */
            // }
        }
        /*
         * if(event.getEntity() instanceof Wolf){ Wolf wolf = (Wolf)
         * event.getEntity(); if(RpgPlayerManager.isRpgEntity(wolf)){ RpgWolf
         * rpgwolf = (RpgWolf) RpgPlayerManager.getRpgEntity(wolf); Player
         * player = (Player) rpgwolf.getOwner(); int time = 30;
         * player.sendMessage(ChatColor.RED + "Your wolf will respawn in " +
         * time + " seconds"); rpgwolf.respawn(time); } }
         */
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == SpawnReason.SPAWNER || event.getSpawnReason() == SpawnReason.SPAWNER_EGG) {
            event.getEntity().setMetadata("spawner",
                    new FixedMetadataValue(plugin, true));
        }
    }
}
