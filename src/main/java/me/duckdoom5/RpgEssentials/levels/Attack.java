package me.duckdoom5.RpgEssentials.levels;

import java.util.HashMap;
import java.util.Map;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
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
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class Attack {

	public static Map<Player, Boolean> run = new HashMap<Player, Boolean>();
	private static String skilltype;
	private static int addexp;
	
	
	public static void run(Entity attacker, EntityDamageByEntityEvent event1, LivingEntity defender, EntityDamageEvent event, RpgEssentials plugin){
		skilltype = "Attack";
		Player player = (Player) attacker;
		ItemStack inhand = player.getItemInHand();
		boolean god = false;
		boolean pvp = true;
		if(Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"))){
			WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
			god = worldguard.getGlobalStateManager().hasGodMode(player);
			pvp  = worldguard.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).allows(DefaultFlag.PVP);
		}
		if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL && god == false && pvp == true){
				int currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
				if((currentlevel >= Configuration.level.getInt("UnlockLevel.Wood Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Sword")) && inhand.getType() == Material.WOOD_SWORD){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD)){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD)){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD)){
					getEntity(defender, player, plugin);
				}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Sword") && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD)){
					getEntity(defender, player, plugin);
					
				}else if(inhand.getType() == Material.AIR){
					getEntity(defender, player, plugin);
					
				}else if(inhand != null){
					if(inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD || inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
						player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
						event.setCancelled(true);
						player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
					}
				}
	    	}
		}else{
			int currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
			if((currentlevel >= Configuration.level.getInt("UnlockLevel.Wood Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Stone Sword")) && inhand.getType() == Material.WOOD_SWORD){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Stone Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Iron Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD)){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Iron Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Gold Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD)){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= Configuration.level.getInt("UnlockLevel.Gold Sword") && currentlevel < Configuration.level.getInt("UnlockLevel.Diamond Sword")) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD)){
				getEntity(defender, player, plugin);
			}else if(currentlevel >= Configuration.level.getInt("UnlockLevel.Diamond Sword") && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD)){
				getEntity(defender, player, plugin);
				
			}else if(inhand.getType() == Material.AIR){
				getEntity(defender, player, plugin);
				
			}else if(inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD || inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
				player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
				event.setCancelled(true);
			}
		}
	}
	public static void getEntity(LivingEntity entity, final Player player, RpgEssentials plugin){
		skilltype = "Attack";
		if(entity instanceof Creeper){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Creeper");
		}else if(entity instanceof Zombie){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Zombie");
		}else if(entity instanceof PigZombie){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pig Zombie");
		}else if(entity instanceof Skeleton){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Skeleton");
		}else if(entity instanceof Enderman){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Enderman");
		}else if(entity instanceof EnderDragon){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Ender Dragon");
		}else if(entity instanceof Ghast){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Ghast");
		}else if(entity instanceof Blaze){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Blaze");
		}else if(entity instanceof Slime){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Slime");
		}else if(entity instanceof MagmaCube){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Magma Cube");
		}else if(entity instanceof Spider){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Spider");
		}else if(entity instanceof CaveSpider){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cave Spider");
		}else if(entity instanceof Silverfish){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Silverfish");
		}else if(entity instanceof Giant){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Giant");
		}else if(entity instanceof Pig){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Pig");
		}else if(entity instanceof Chicken){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Chicken");
		}else if(entity instanceof Villager){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Villager");
		}else if(entity instanceof Sheep){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Sheep");
		}else if(entity instanceof Cow){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Cow");
		}else if(entity instanceof MushroomCow){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Mooshroom");
		}else if(entity instanceof Squid){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Squid");
		}else if(entity instanceof Wolf){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Wolf");
		}else if(entity instanceof Snowman){
			addexp = Configuration.level.getInt("Exp." + skilltype + ".Snow Golem");
		}else if(entity instanceof Player){
			if(player.getWorld().getPVP() == true){
				addexp = Configuration.level.getInt("Exp." + skilltype + ".Player");
			}
		}
		
		if(!run.containsKey(player)){
			run.put(player, true);
		}
		
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	run.put(player, true);
		    }
		}, 20L);
		
		if(run.get(player) == true){
			run.put(player, false);
			LevelingSystem.addexp(player, skilltype, addexp, plugin);
		}
	}
}
