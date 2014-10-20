package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Attack;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.massivecraft.factions.listeners.FactionsListenerMain;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class EntityListener implements Listener {
    public static RpgLeveling plugin;
    private final FactionsListenerMain fel;
    private boolean factionsEnabled;
    
    public EntityListener(RpgLeveling rpgLeveling) {
        BlockListener.plugin = rpgLeveling;
        factionsEnabled = Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("Factions"));
        if(factionsEnabled){
            fel = FactionsListenerMain.get();
        }else{
            fel = null;
        }
        
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }
        // if(RpgEssentials.wl.worlds.get(event.getEntity().getWorld())){
        if (event.getEntity() instanceof LivingEntity) {
            final LivingEntity defender = (LivingEntity) event.getEntity();
            final Entity attacker = event.getDamager();
            if (attacker instanceof Player) {
                if (defender.getNoDamageTicks() > 0) {
                    event.setCancelled(true);
                    return;
                }
                if (factionsEnabled) {
                    if (!fel.canCombatDamageHappen(event, false)) {
                        event.setCancelled(true);
                        return;
                    }
                }

                final Player player = (Player) attacker;
                final SpoutPlayer splayer = SpoutManager.getPlayer((Player) attacker);

                for (final GenericCustomItem t : RpgeManager.getInstance().getMaterialManager().getTools()) {
                    if (splayer.getItemInHand().getDurability() == t.getCustomId() && me.duckdoom5.RpgEssentials.config.Configuration.items.contains("Custom Tools." + t.getName() + ".damage")) {
                        final int damage = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Tools." + t.getName() + ".damage");
                        event.setDamage(damage);
                    }
                }

                if (Attack.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()))) {
                    final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.ATTACK, event.getDamage());
                    Bukkit.getServer().getPluginManager().callEvent(callevent);
                } else {
                    event.setCancelled(true);
                    return;
                }

            } else if (attacker instanceof Projectile) {
                final Projectile projectile = (Projectile) attacker;
                if (projectile.getShooter() instanceof Player) {
                    if (defender.getNoDamageTicks() > 0) {
                        event.setCancelled(true);
                        return;
                    }
                    if (defender instanceof Player) {
                        final Player player = (Player) defender;
                        if (Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))) {
                            final WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
                            if (worldguard.getGlobalStateManager().hasGodMode(player) || player.getGameMode().equals(GameMode.CREATIVE)) {
                                event.setCancelled(true);
                                return;
                            }
                        }
                    }
                    final Player shooter = (Player) projectile.getShooter();
                    if (projectile.hasMetadata("custom")) {
                        // String bolt = projectile.getMetadata("custom").get(0).asString();
                        final PlayerExpGainEvent callevent = new PlayerExpGainEvent(shooter, SkillType.RANGED, event.getDamage());
                        Bukkit.getServer().getPluginManager().callEvent(callevent);
                    } else {
                        final PlayerExpGainEvent callevent = new PlayerExpGainEvent(shooter, SkillType.RANGED, event.getDamage());
                        Bukkit.getServer().getPluginManager().callEvent(callevent);
                    }
                }
            }
            if (defender instanceof Player) {
                if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().isNPC(defender)) {
                    event.setCancelled(true);
                    return;
                }
                final Player player = (Player) defender;
                if (Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))) {
                    final WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
                    if (worldguard.getGlobalStateManager().hasGodMode(player) || player.getGameMode().equals(GameMode.CREATIVE)) {
                        event.setCancelled(true);
                        return;
                    }
                }

                if (player.getNoDamageTicks() > 0) {
                    event.setCancelled(true);
                    return;
                }

                final DamageCause cause = event.getCause();
                if (cause == DamageCause.ENTITY_ATTACK || cause == DamageCause.BLOCK_EXPLOSION || cause == DamageCause.ENTITY_EXPLOSION || cause == DamageCause.PROJECTILE) {
                    final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.DEFENSE, event.getDamage());
                    Bukkit.getServer().getPluginManager().callEvent(callevent);
                }
            }
        }
        // }
    }
}
