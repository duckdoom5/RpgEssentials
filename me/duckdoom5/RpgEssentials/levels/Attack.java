package me.duckdoom5.RpgEssentials.levels;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
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

public class Attack {

	static YamlConfiguration levelconfig = new YamlConfiguration();
	static YamlConfiguration playerconfig = new YamlConfiguration();
	private static String skilltype;
	private static int addexp;
	public static void run(Entity attacker, EntityDamageByEntityEvent event1, LivingEntity defender, EntityDamageEvent event, RpgEssentials plugin){
		try {
    		levelconfig.load("plugins/RpgEssentials/Leveling.yml");
    		playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
		}
		skilltype = "Attack";
		Player player = (Player) attacker;
		ItemStack inhand = player.getItemInHand();
		WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
		if(levelconfig.getBoolean("Survival Gamemode Required") == true){
	    	if(player.getGameMode() == GameMode.SURVIVAL && worldguard.getGlobalStateManager().hasGodMode(player) == false){
				int currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
				if((currentlevel >= 0 && currentlevel < 10) && inhand.getType() == Material.WOOD_SWORD){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= 10 && currentlevel < 20) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD)){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= 20 && currentlevel < 35) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD)){
					getEntity(defender, player, plugin);
				}else if((currentlevel >= 35 && currentlevel < 60) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD)){
					getEntity(defender, player, plugin);
				}else if(currentlevel >= 60 && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD)){
					getEntity(defender, player, plugin);
					
				}else if(inhand.getType() == Material.AIR){
					getEntity(defender, player, plugin);
					
				}else if(inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD || inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
					player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
					player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
					event.setCancelled(true);
				}
	    	}
		}else{
			int currentlevel = playerconfig.getInt("players." + player.getName() + "." + skilltype + ".level");
			if((currentlevel >= 0 && currentlevel < 10) && inhand.getType() == Material.WOOD_SWORD){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= 10 && currentlevel < 20) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD)){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= 20 && currentlevel < 35) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD)){
				getEntity(defender, player, plugin);
			}else if((currentlevel >= 35 && currentlevel < 60) && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD)){
				getEntity(defender, player, plugin);
			}else if(currentlevel >= 60 && (inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD)){
				getEntity(defender, player, plugin);
				
			}else if(inhand.getType() == Material.AIR){
				getEntity(defender, player, plugin);
				
			}else if(inhand.getType() == Material.WOOD_SWORD || inhand.getType() == Material.STONE_SWORD || inhand.getType() == Material.IRON_SWORD || inhand.getType() == Material.GOLD_SWORD || inhand.getType() == Material.DIAMOND_SWORD || inhand.getType() == Material.WOOD_AXE || inhand.getType() == Material.STONE_AXE || inhand.getType() == Material.IRON_AXE || inhand.getType() == Material.GOLD_AXE || inhand.getType() == Material.DIAMOND_AXE){
				player.sendMessage(ChatColor.RED + "You can't use a " + inhand.getType().toString().toLowerCase().replace("_", " ") + " on level " + currentlevel);
				event.setCancelled(true);
			}
		}
	}
	public static void getEntity(LivingEntity entity, Player player, RpgEssentials plugin){
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
		LevelingSystem.addexp(player, skilltype, addexp, plugin);
	}
}
