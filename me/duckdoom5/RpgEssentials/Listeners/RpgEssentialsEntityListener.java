package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.levels.LevelingSystem;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

public class RpgEssentialsEntityListener extends EntityListener{

	public static RpgEssentials plugin;
	static YamlConfiguration playerconfig = new YamlConfiguration();
    static YamlConfiguration levelconfig = new YamlConfiguration();
	private int currentlevel;
	private int addexp;
	String skilltype;
	
	public RpgEssentialsEntityListener(RpgEssentials instance) {
        plugin = instance; 
    }

	public void onEntityDamage(EntityDamageEvent event){
		if(event.isCancelled()){
			return;
		}
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
			playerconfig.load("plugins/RpgEssentials/players.yml");
		} catch (Exception e) {
		}
		if(event instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent event1 = (EntityDamageByEntityEvent)event;
			LivingEntity defender = (LivingEntity) event1.getEntity();
			Entity attacker = event1.getDamager();
			if(attacker instanceof Player){
				skilltype = "Attack";
				Player player = (Player) attacker;
				ItemStack inhand = player.getItemInHand();
				DamageCause cause = event1.getCause();
				player.sendMessage(cause.toString());
				if(cause == DamageCause.PROJECTILE){
					player.sendMessage("test");
					/*addexp = levelconfig.getInt("Exp." + "Ranged");
					LevelingSystem.addexp(player, "Ranged", addexp);*/
				}
				currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
				if((currentlevel >= 5 && currentlevel < 10) && inhand.getType() == Material.WOOD_SWORD){
    				getEntity(defender, player);
				}else if((currentlevel >= 10 && currentlevel < 20) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD)){
					getEntity(defender, player);
    			}else if((currentlevel >= 20 && currentlevel < 35) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD)){
    				getEntity(defender, player);
    			}else if((currentlevel >= 35 && currentlevel < 60) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD)){
    				getEntity(defender, player);
    			}else if(currentlevel >= 60 && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD)){
    				getEntity(defender, player);
    				
    			}else if((currentlevel > 0 && currentlevel < 5) && inhand.getType() == Material.WOOD_AXE){
    				getEntity(defender, player);
				}else if((currentlevel >= 5 && currentlevel < 15) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE)){
					getEntity(defender, player);
    			}else if((currentlevel >= 15 && currentlevel < 25) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE)){
    				getEntity(defender, player);
    			}else if((currentlevel >= 25 && currentlevel < 50) && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE)){
    				getEntity(defender, player);
    			}else if(currentlevel >= 50 && (inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE)){
    				getEntity(defender, player);
    				
    			}else if(inhand.getType() == Material.AIR){
    				getEntity(defender, player);
    				
    			}else if(inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD || inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
    				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
    				event.setCancelled(true);
	    		}
			}else if (attacker instanceof Projectile || attacker instanceof Snowball || attacker instanceof Egg) {
				skilltype = "Attack";
				Projectile x = (Projectile) attacker;
				LivingEntity shooter = x.getShooter();
				if(shooter instanceof Player){
					Player player = (Player) shooter;
					addexp = levelconfig.getInt("Exp." + skilltype + ".Arrow Shoot");
					LevelingSystem.addexp(player, skilltype, addexp);
				}
	        }
			if(defender instanceof Player){
				skilltype = "Defence";
				Player player = (Player) defender;
				DamageCause cause = event1.getCause();
				if(cause == DamageCause.ENTITY_ATTACK){
					addexp = levelconfig.getInt("Exp." + skilltype + ".Entity Attack");
				}else if(cause == DamageCause.BLOCK_EXPLOSION){
					addexp = levelconfig.getInt("Exp." + skilltype + ".Block Explosion");
				}else if(cause == DamageCause.ENTITY_EXPLOSION){
					addexp = levelconfig.getInt("Exp." + skilltype + ".Entity Explosion");
				}else if(cause == DamageCause.PROJECTILE){
					addexp = levelconfig.getInt("Exp." + skilltype + ".Projectile");
				}
				LevelingSystem.addexp(player, skilltype, addexp);
			}
		}
		
	}
	
	public void onEntityDeath(EntityDeathEvent event){
		Location droplocation = event.getEntity().getLocation();
		
		ItemStack drop = new ItemStack(Material.SNOW_BALL, 1);
		
		droplocation.getWorld().dropItemNaturally(droplocation, drop);
	}
	
	public void getEntity(LivingEntity entity, Player player){
		skilltype = "Attack";
		try {
			levelconfig.load("plugins/RpgEssentials/Leveling.yml");
		} catch (Exception e) {
		}
		if(entity instanceof Creeper){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Creeper");
		}else if(entity instanceof Zombie){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Zombie");
		}else if(entity instanceof PigZombie){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pig Zombie");
		}else if(entity instanceof Skeleton){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Skeleton");
		}else if(entity instanceof Enderman){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Enderman");
		}else if(entity instanceof EnderDragon){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Ender Dragon");
		}else if(entity instanceof Ghast){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Ghast");
		}else if(entity instanceof Blaze){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Blaze");
		}else if(entity instanceof Slime){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Slime");
		}else if(entity instanceof MagmaCube){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Magma Cube");
		}else if(entity instanceof Spider){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Spider");
		}else if(entity instanceof CaveSpider){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cave Spider");
		}else if(entity instanceof Silverfish){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Silverfish");
		}else if(entity instanceof Giant){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Giant");
		}else if(entity instanceof Pig){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Pig");
		}else if(entity instanceof Chicken){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Chicken");
		}else if(entity instanceof Villager){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Villager");
		}else if(entity instanceof Sheep){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Sheep");
		}else if(entity instanceof Cow){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Cow");
		}else if(entity instanceof MushroomCow){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Mooshroom");
		}else if(entity instanceof Squid){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Squid");
		}else if(entity instanceof Wolf){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Wolf");
		}else if(entity instanceof Snowman){
			addexp = levelconfig.getInt("Exp." + skilltype + ".Snow Golem");
		}else if(entity instanceof Player){
			if(player.getWorld().getPVP() == true){
				addexp = levelconfig.getInt("Exp." + skilltype + ".Player");
			}
		}
		LevelingSystem.addexp(player, skilltype, addexp);
	}
}
