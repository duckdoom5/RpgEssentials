package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.levels.Attack;
import me.duckdoom5.RpgEssentials.levels.Defence;
import me.duckdoom5.RpgEssentials.levels.Ranged;
import me.duckdoom5.RpgEssentials.util.Hashmaps;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;

public class RpgEssentialsEntityListener implements Listener{

	public static RpgEssentials plugin;
    static YamlConfiguration levelconfig = new YamlConfiguration();
    YamlConfiguration entityconfig = new YamlConfiguration();
	private int currentlevel;
	private int addexp;
	String skilltype;
	
	public RpgEssentialsEntityListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		if(event.isCancelled()){
			return;
		}
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		if(event instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event1 = (EntityDamageByEntityEvent)event;
			if(event1.getEntity() instanceof LivingEntity){
				LivingEntity defender = (LivingEntity) event1.getEntity();
				Entity attacker = event1.getDamager();
				if(attacker instanceof Player){
					Attack.run(attacker, event1, defender, event, plugin);
				}else if (attacker instanceof Arrow || attacker instanceof Snowball || attacker instanceof Egg) {
					Ranged.check(attacker, plugin);
		        }
				if(defender instanceof Player){
					Defence.check(defender, plugin, event1);
				}
			}
		}
		
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		DamageCause cause = event.getEntity().getLastDamageCause().getCause();
		EntityDamageEvent event1 = event.getEntity().getLastDamageCause();
		Player player = null;
		if(event1 instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent)event1;
			if(event2.getEntity() instanceof LivingEntity){
				Entity attacker = event2.getDamager();
				if(attacker instanceof Player){
					player = (Player) attacker;
				}else if(attacker instanceof Arrow){
					player = (Player) ((Projectile) attacker).getShooter();
				}
			}
		}
		if(player != null){
			if(player.getGameMode() == GameMode.SURVIVAL){
				Location droplocation = event.getEntity().getLocation();
				Random rand = new Random();
				int bronzeamount = rand.nextInt(50);
				int silveramount = rand.nextInt(50);
				int goldamount = rand.nextInt(50);
				if(bronzeamount < 10){
					ItemStack bronzedrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Bronze Coin"), bronzeamount + 1);
					droplocation.getWorld().dropItemNaturally(droplocation, bronzedrop);
				}else{
					ItemStack bronzedrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Bronze Coin"), 1);
					droplocation.getWorld().dropItemNaturally(droplocation, bronzedrop);
				}
				if(silveramount < 5){
					ItemStack silverdrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Silver Coin"), silveramount + 1);
					droplocation.getWorld().dropItemNaturally(droplocation, silverdrop);
				}
				if(goldamount < 1){
					ItemStack golddrop = new SpoutItemStack(Hashmaps.customitemsmap.get("Gold Coin"), goldamount + 1);
					droplocation.getWorld().dropItemNaturally(droplocation, golddrop);
				}
			}
		}
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){
		
		if(event.getSpawnReason() == SpawnReason.NATURAL){
			try {
				entityconfig.load("plugins/RpgEssentials/Entitys.yml");
			} catch (Exception e) {
			}
			
			if(event.getCreatureType() == CreatureType.CHICKEN){
				Random random = new Random();
				if(random.nextInt() < 70){
					Entity entity = event.getEntity();
					UUID id = entity.getUniqueId();
					List<Object> oldids = entityconfig.getList("Entitys.Chickens");
					entityconfig.set("Entitys.Chickens", Arrays.asList(oldids, id));
					//SpoutPlayer.setEntitySkin(LivingEntity target, "URLHERE", EntitySkinType.DEFAULT);
				}	
			}
			
			try {
				entityconfig.save("plugins/RpgEssentials/Entitys.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
