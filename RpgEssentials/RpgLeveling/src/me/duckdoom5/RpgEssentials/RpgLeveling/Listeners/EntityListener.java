package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Listeners.RpgEssentialsWorldListener;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Attack;

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

import com.massivecraft.factions.P;
import com.massivecraft.factions.listeners.FactionsEntityListener;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class EntityListener implements Listener{
public static RpgLeveling plugin;
	
	public EntityListener(RpgLeveling rpgLeveling) {
		BlockListener.plugin = rpgLeveling;
	}
	
	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
		if(event.isCancelled()){
			return;
		}
		if(RpgEssentialsWorldListener.worlds.get(event.getEntity().getWorld())){
			if(event.getEntity() instanceof LivingEntity){
				LivingEntity defender = (LivingEntity) event.getEntity();
				Entity attacker = event.getDamager();
				if(attacker instanceof Player){
					if(defender.getNoDamageTicks() > 0){
						event.setCancelled(true);
						return;
					}
					if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("Factions"))){
						P factions = (P) Bukkit.getPluginManager().getPlugin("Factions");
						
						FactionsEntityListener fel = new FactionsEntityListener(factions);
						if (!fel.canDamagerHurtDamagee(event, false)){
							event.setCancelled(true);
							return;
						}
					}
					
					
					Player player = (Player) attacker;
					SpoutPlayer splayer = SpoutManager.getPlayer((Player) attacker);
					
					for(GenericCustomItem t : RpgEssentials.mm.getTools()){
	                    if(splayer.getItemInHand().getDurability() == t.getCustomId() && me.duckdoom5.RpgEssentials.config.Configuration.items.contains("Custom Tools." + t.getName() + ".damage")){
	                        int damage = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Tools." + t.getName() + ".damage");
	                        event.setDamage(damage);
	                    }
	                }
					
					if(Attack.canUse(RpgEssentials.pm.getRpgPlayer(player))){
						PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.ATTACK, event.getDamage());
						Bukkit.getServer().getPluginManager().callEvent(callevent);
					}else{
						event.setCancelled(true);
						return;
					}
					
				}else if (attacker instanceof Projectile) {
					Projectile projectile = (Projectile) attacker;
					if(projectile.getShooter() instanceof Player){
						if(defender.getNoDamageTicks() > 0){
							event.setCancelled(true);
							return;
						}
						if(defender instanceof Player){
							Player player = (Player) defender;
							if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
								WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
								if(worldguard.getGlobalStateManager().hasGodMode(player) || player.getGameMode().equals(GameMode.CREATIVE)){
									event.setCancelled(true);
									return;
								}
							}
						}
						Player shooter = (Player) projectile.getShooter();
						if(projectile.hasMetadata("custom")){
							String bolt = projectile.getMetadata("custom").get(0).asString();
							PlayerExpGainEvent callevent = new PlayerExpGainEvent(shooter, Skill.RANGED, event.getDamage());
							Bukkit.getServer().getPluginManager().callEvent(callevent);
						}else{
							PlayerExpGainEvent callevent = new PlayerExpGainEvent(shooter, Skill.RANGED, event.getDamage());
							Bukkit.getServer().getPluginManager().callEvent(callevent);
						}
					}
		        }
				if(defender instanceof Player){
					if(RpgEssentials.nm.isNPC(defender)){
						event.setCancelled(true);
						return;
					}
					Player player = (Player)defender;
					if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
						WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
						if(worldguard.getGlobalStateManager().hasGodMode(player) || player.getGameMode().equals(GameMode.CREATIVE)){
							event.setCancelled(true);
							return;
						}
					}
					
					if(player.getNoDamageTicks() > 0){
						event.setCancelled(true);
						return;
					}
					
					DamageCause cause = event.getCause();
					if(cause == DamageCause.ENTITY_ATTACK || cause == DamageCause.BLOCK_EXPLOSION || cause == DamageCause.ENTITY_EXPLOSION || cause == DamageCause.PROJECTILE){
						PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, Skill.DEFENSE, event.getDamage());
						Bukkit.getServer().getPluginManager().callEvent(callevent);
					}
					
					SpoutPlayer splayer = SpoutManager.getPlayer((Player) defender);
				}
			}
		}
	}
}
