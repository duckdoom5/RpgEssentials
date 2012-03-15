package me.duckdoom5.RpgEssentials.Listeners;

import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Quests;
import me.duckdoom5.RpgEssentials.levels.Construction;
import me.duckdoom5.RpgEssentials.levels.Excavation;
import me.duckdoom5.RpgEssentials.levels.Farming;
import me.duckdoom5.RpgEssentials.levels.Mining;
import me.duckdoom5.RpgEssentials.levels.Woodcutting;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.commons.ChatColor;

public class RpgEssentialsBlockListener implements Listener{

	public static RpgEssentials plugin;
	public static boolean blockuse = false;
	private static String skilltype;
	private static int currentlevel;
	
	public static HashMap<Player, Material> destroyed = new LinkedHashMap<Player, Material>();
	public static HashMap<Location, Player> placed = new LinkedHashMap<Location, Player>();
	
	public RpgEssentialsBlockListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Quests.BlockPlace(event);
		if(Configuration.modules.getBoolean("Modules.leveling") && RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
			Block block = event.getBlock();
			Player player = event.getPlayer();
			if(placed.containsKey(block.getLocation())){
				if(!placed.get(block.getLocation()).equals(player)){
					//player didn't place a block on this location
					placed.put(block.getLocation(), player);
					if(!destroyed.get(player).equals(block.getType())){
						//player didn't just destroyed a block of the same type
						givePlaceExp(player, block);
					}
				}else{
					placed.put(block.getLocation(), player);
				}
			}else{//player didn't place a block on this location
				if(destroyed.containsKey(player)){
					if(!destroyed.get(player).equals(block.getType())){
						placed.put(block.getLocation(), player);
						givePlaceExp(player, block);
					}
				}else{
					placed.put(block.getLocation(), player);
					givePlaceExp(player, block);
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		if(block.getType().equals(Material.CHEST)){
			if(RpgEssentialsPlayerListener.protect2.containsKey(block.getLocation())){
				player.sendMessage(ChatColor.RED + "You can't destroy a death chest");
				event.setCancelled(true);
			}
		}
		
		Quests.BlockBreak(event);
		if(Configuration.modules.getBoolean("Modules.leveling") && RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
			ItemStack inhand = player.getItemInHand();
			if(placed.containsKey(block.getLocation())){
				if(!placed.get(block.getLocation()).equals(player)){
					//player didn't place a block on this location
					if(destroyed.containsKey(player)){
						if(!destroyed.get(player).equals(block.getType())){
							//player didn't just destroyed a block of the same type
							destroyed.put(player, block.getType());
							giveBreakExp(player,block,inhand,event);
						}
					}else{
						destroyed.put(player, block.getType());
						giveBreakExp(player,block,inhand,event);
					}
				}else{
					destroyed.put(player, block.getType());
				}
			}else{
				if(destroyed.containsKey(player)){
					if(!destroyed.get(player).equals(block.getType())){
						//player didn't just destroyed a block of the same type
						destroyed.put(player, block.getType());
						giveBreakExp(player,block,inhand,event);
					}
				}else{
					destroyed.put(player, block.getType());
					giveBreakExp(player,block,inhand,event);
				}
			}
		}
	}
	
	private static void givePlaceExp(Player player, Block block){
		if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
			if(player.getGameMode() == GameMode.SURVIVAL){
				if(getPlace(block) == "Farming"){
					Farming.blockplacecheck(block, player, plugin);
				}else if(getPlace(block) == "Construction"){
					Construction.blockplacecheck(block, player, plugin);
				}
			}
		}else{
			if(getPlace(block) == "Farming"){
				Farming.blockplacecheck(block, player, plugin);
			}else if(getPlace(block) == "Construction"){
				Construction.blockplacecheck(block, player, plugin);
			}
		}
	}
	
	private static void giveBreakExp(Player player, Block block, ItemStack inhand, BlockBreakEvent event){
		if(Configuration.level.getBoolean("Survival Gamemode Required") == true){
			if(player.getGameMode() == GameMode.SURVIVAL){
				if(getBreak(block) == "Mining"){
					currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
					Mining.canuse(currentlevel, block, player, plugin, inhand, event);
				}else if(getBreak(block) == "Woodcutting"){
					currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
					Woodcutting.canuse(currentlevel, block, player, plugin, inhand, event);
				}else if(getBreak(block) == "Excavation"){
					currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
					Excavation.canuse(currentlevel, block, player, plugin, inhand, event);
				}else if(getPlace(block) == "Farming"){
					Farming.blockcheck(block, player, plugin);
				}
			}
		}else{
			if(getBreak(block) == "Mining"){
				currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
				Mining.canuse(currentlevel, block, player, plugin, inhand, event);
			}else if(getBreak(block) == "Woodcutting"){
				currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
				Woodcutting.canuse(currentlevel, block, player, plugin, inhand, event);
			}else if(getBreak(block) == "Excavation"){
				currentlevel = Configuration.players.getInt("players." + player.getName() + "." + skilltype + ".level");
				Excavation.canuse(currentlevel, block, player, plugin, inhand, event);
			}else if(getPlace(block) == "Farming"){
				Farming.blockcheck(block, player, plugin);
			}
		}
	}
	
	private static boolean checkcanuse(ItemStack inhand, String skilltype) {
		if(skilltype == "Mining"){
			if((inhand.getType() == Material.WOOD_PICKAXE) || (inhand.getType() == Material.STONE_PICKAXE) || (inhand.getType() == Material.IRON_PICKAXE) || (inhand.getType() == Material.GOLD_PICKAXE) || (inhand.getType() == Material.DIAMOND_PICKAXE)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	private static String getPlace(Block block){
		if((block.getType() == Material.YELLOW_FLOWER) || (block.getType() == Material.RED_ROSE)  || (block.getType() == Material.CACTUS) || (block.getType() == Material.PUMPKIN) || (block.getType() == Material.PUMPKIN_STEM) || (block.getType() == Material.MELON_BLOCK) || (block.getType() == Material.PUMPKIN_STEM) || (block.getType() == Material.RED_MUSHROOM) || (block.getType() == Material.BROWN_MUSHROOM) || (block.getType() == Material.HUGE_MUSHROOM_1) || (block.getType() == Material.HUGE_MUSHROOM_2) || (block.getType() == Material.LONG_GRASS) || (block.getType() == Material.getMaterial(59)) || (block.getType() == Material.VINE) || (block.getType() == Material.WATER_LILY) || (block.getType() == Material.LEAVES) || (block.getType() == Material.DEAD_BUSH)){
			skilltype = "Farming";
		}else if((block.getType() == Material.LOG) || (block.getType() == Material.GLASS) || (block.getType() == Material.DISPENSER) || (block.getType() == Material.NOTE_BLOCK) || (block.getType() == Material.BED) || (block.getType() == Material.PISTON_STICKY_BASE) || (block.getType() == Material.PISTON_BASE) || (block.getType() == Material.WOOL) || (block.getType() == Material.BOOKSHELF) || (block.getType() == Material.CHEST) || (block.getType() == Material.WORKBENCH) || (block.getType() == Material.FURNACE) || (block.getType() == Material.JUKEBOX) || (block.getType() == Material.FENCE) || (block.getType() == Material.THIN_GLASS) || (block.getType() == Material.IRON_FENCE) || (block.getType() == Material.ENCHANTMENT_TABLE) || (block.getType() == Material.WOOD) || (block.getType() == Material.WOOD_STAIRS) || (block.getType() == Material.FENCE) || (block.getType() == Material.STONE) || (block.getType() == Material.COBBLESTONE) || (block.getType() == Material.MOSSY_COBBLESTONE) || (block.getType() == Material.COBBLESTONE_STAIRS) || (block.getType() == Material.SMOOTH_BRICK) || (block.getType() == Material.SMOOTH_STAIRS) || (block.getType() == Material.BRICK) || (block.getType() == Material.ENDER_STONE) || (block.getType() == Material.BRICK_STAIRS) || (block.getType() == Material.IRON_BLOCK) || (block.getType() == Material.DIAMOND_BLOCK) || (block.getType() == Material.LAPIS_BLOCK) || (block.getType() == Material.GOLD_BLOCK) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.OBSIDIAN) || (block.getType() == Material.NETHER_BRICK) || (block.getType() == Material.NETHER_FENCE) || (block.getType() == Material.NETHER_BRICK_STAIRS) || (block.getType() == Material.STEP) || (block.getType() == Material.DOUBLE_STEP)){
			skilltype = "Construction";
		}
		return skilltype;
	}
	private static String getBreak(Block block){
		if((block.getType() == Material.STONE) || (block.getType() == Material.COBBLESTONE) || (block.getType() == Material.MOSSY_COBBLESTONE) || (block.getType() == Material.COBBLESTONE_STAIRS) || (block.getType() == Material.SMOOTH_BRICK) || (block.getType() == Material.SMOOTH_STAIRS) || (block.getType() == Material.BRICK) || (block.getType() == Material.ENDER_STONE) || (block.getType() == Material.BRICK_STAIRS) || (block.getType() == Material.IRON_BLOCK) || (block.getType() == Material.DIAMOND_BLOCK) || (block.getType() == Material.LAPIS_BLOCK) || (block.getType() == Material.GOLD_BLOCK) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.COAL_ORE) || (block.getType() == Material.IRON_ORE) || (block.getType() == Material.GOLD_ORE) || (block.getType() == Material.LAPIS_ORE) || (block.getType() == Material.OBSIDIAN) || (block.getType() == Material.NETHERRACK) || (block.getType() == Material.GLOWSTONE) || (block.getType() == Material.NETHER_BRICK) || (block.getType() == Material.NETHER_BRICK_STAIRS) || (block.getType() == Material.REDSTONE_ORE) || (block.getType() == Material.DIAMOND_ORE) || ( (block.getType() == Material.STEP)&&(block.getData() != (byte) 2) ) || ( (block.getType() == Material.DOUBLE_STEP)&&(block.getData() != (byte) 2) ) ){
			skilltype = "Mining";
		}else if((block.getType() == Material.LOG) || (block.getType() == Material.WOOD) || (block.getType() == Material.WOOD_STAIRS) || (block.getType() == Material.FENCE) || ( (block.getType() == Material.STEP)&&(block.getData() == (byte) 2) ) || ( (block.getType() == Material.DOUBLE_STEP)&&(block.getData() == (byte) 2) ) ){
			skilltype = "Woodcutting";
		}else if((block.getType() == Material.DIRT) || (block.getType() == Material.GRASS) || (block.getType() == Material.CLAY) || (block.getType() == Material.SAND) || (block.getType() == Material.SOUL_SAND) || (block.getType() == Material.SOIL) || (block.getType() == Material.SNOW_BLOCK) || (block.getType() == Material.SNOW)){
			skilltype = "Excavation";
		}
		return skilltype;
		
	}
}
