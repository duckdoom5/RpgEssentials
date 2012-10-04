package me.duckdoom5.RpgEssentials.util;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Methods {
	
	public static void addWaypoint(String name, Vector loc, SpoutPlayer splayer){
		splayer.addWaypoint(name, loc.getX(), loc.getY(), loc.getZ());
		
	}
	
	public static void addPublicWaypoint(String name, Vector loc){
		SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
		for(int count = 0; count < onplayers.length; count++){
			onplayers[count].addWaypoint(name, loc.getX(), loc.getX(), loc.getZ());
		}
	}
	
	public static boolean isInventoryEmpty(Player player){
	    ItemStack[] contents = player.getInventory().getContents();
	    for(ItemStack content : contents){
	        if(content != null){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isInventoryEmpty(ItemStack[] contents){
	    for(ItemStack content : contents){
	        if(content != null){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isInventoryFull(ItemStack[] contents){
	    for(ItemStack content : contents){
	        if(content == null){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isDataMaterial(Material material){
		if(material.equals(Material.WOOL) || material.equals(Material.COAL) || material.equals(Material.SAPLING) || material.equals(Material.LOG) || material.equals(Material.WOOD) || material.equals(Material.SANDSTONE) || material.equals(Material.STEP) || material.equals(Material.SMOOTH_BRICK) || material.equals(Material.DOUBLE_STEP) || material.equals(Material.LONG_GRASS) || material.equals(Material.MONSTER_EGG) || material.equals(Material.MOB_SPAWNER) || material.equals(Material.INK_SACK)){
			return true;
		}
		return false;
	}
	
	public static String getDataName(Material material, Short data){
		String name2 = material.toString().toLowerCase().replace("_", " ");
		if(name2.equals("wool")){
			name2 = getWoolColor(data) + " wool";
		}else if(name2.equals("ink sack")){
			name2 = getInkName(data);
		}else if(name2.equals("coal")){
			if(data == 0){
				name2 = "coal";
			}else{
				name2 = "charcoal";
			}
		}else if(name2.equals("sapling")){
			if(data == 0){
				name2 = "oak sapling";
			}else if(data == 1){
				name2 = "pine sapling";
			}else if(data == 2){
				name2 = "birch sapling";
			}else{
				name2 = "jungle sapling";
			}
		}else if(name2.equals("log")){
			if(data == 0){
				name2 = "oak log";
			}else if(data == 1){
				name2 = "pine log";
			}else if(data == 2){
				name2 = "birch log";
			}else{
				name2 = "jungle log";
			}
		}else if(name2.equals("wood")){
			if(data == 0){
				name2 = "oak planks";
			}else if(data == 1){
				name2 = "pine planks";
			}else if(data == 2){
				name2 = "birch planks";
			}else{
				name2 = "jungle planks";
			}
		}else if(name2.equals("sandstone")){
			if(data == 0){
				name2 = "sandstone";
			}else if(data == 2){
				name2 = "creeper sandstone";
			}else{
				name2 = "smooth sandstone";
			}
		}else if(name2.equals("step")){
			name2 = getSlab(data) + " slab";
		}else if(name2.equals("double step")){
			name2 = getSlab(data) + " double slab";
		}else if(name2.equals("long grass")){
			if(data == 0){
				name2 = "dead scrub";
			}else if(data == 1){
				name2 = "tall grass";
			}else{
				name2 = "fern";
			}
		}else if(name2.equals("smooth brick")){
			if(data == 0){
				name2 = "smooth brick";
			}else if(data == 1){
				name2 = "mossy brick";
			}else if(data == 2){
				name2 = "cracked brick";
			}else{
				name2 = "circle brick";
			}
		}else if(name2.equals("monster egg")){
			if(data == 50){
				name2 = "creeper egg";
			}else if(data == 51){
				name2 = "skeleton egg";
			}else if(data == 52){
				name2 = "spider egg";
			}else if(data == 53){
				name2 = "giant egg";
			}else if(data == 54){
				name2 = "zombie egg";
			}else if(data == 55){
				name2 = "slime egg";
			}else if(data == 56){
				name2 = "ghast egg";
			}else if(data == 57){
				name2 = "pig-zombie egg";
			}else if(data == 58){
				name2 = "enderman egg";
			}else if(data == 59){
				name2 = "cave spider egg";
			}else if(data == 60){
				name2 = "silverfish egg";
			}else if(data == 61){
				name2 = "blaze egg";
			}else if(data == 62){
				name2 = "magma cube egg";
			}else if(data == 63){
				name2 = "enderdragon egg";
			}else if(data == 90){
				name2 = "pig egg";
			}else if(data == 91){
				name2 = "sheep egg";
			}else if(data == 92){
				name2 = "cow egg";
			}else if(data == 93){
				name2 = "chicken egg";
			}else if(data == 94){
				name2 = "squid egg";
			}else if(data == 95){
				name2 = "wolf egg";
			}else if(data == 96){
				name2 = "mooshroom egg";
			}else if(data == 97){
				name2 = "snow golem egg";
			}else if(data == 98){
				name2 = "ocelot egg";
			}else if(data == 99){
				name2 = "iron golem egg";
			}else if(data == 120){
				name2 = "villager egg";
			}else{
				name2 = "mob egg";
			}
		}else if(name2.equals("mob spawner")){
			if(data == 50){
				name2 = "creeper spawner";
			}else if(data == 51){
				name2 = "skeleton spawner";
			}else if(data == 52){
				name2 = "spider spawner";
			}else if(data == 53){
				name2 = "giant spawner";
			}else if(data == 54){
				name2 = "zombie spawner";
			}else if(data == 55){
				name2 = "slime spawner";
			}else if(data == 56){
				name2 = "ghast spawner";
			}else if(data == 57){
				name2 = "pig-zombie spawner";
			}else if(data == 58){
				name2 = "enderman spawner";
			}else if(data == 59){
				name2 = "cave spider spawner";
			}else if(data == 60){
				name2 = "silverfish spawner";
			}else if(data == 61){
				name2 = "blaze spawner";
			}else if(data == 62){
				name2 = "magma cube spawner";
			}else if(data == 63){
				name2 = "enderdragon spawner";
			}else if(data == 90){
				name2 = "pig spawner";
			}else if(data == 91){
				name2 = "sheep spawner";
			}else if(data == 92){
				name2 = "cow spawner";
			}else if(data == 93){
				name2 = "chicken spawner";
			}else if(data == 94){
				name2 = "squid spawner";
			}else if(data == 95){
				name2 = "wolf egg";
			}else if(data == 96){
				name2 = "mooshroom spawner";
			}else if(data == 97){
				name2 = "snow golem spawner";
			}else if(data == 98){
				name2 = "ocelot spawner";
			}else if(data == 120){
				name2 = "villager spawner";
			}else{
				name2 = "mob spawner";
			}
		}
		return name2;
	}
	
	public static String getWoolColor(Short data){
		String color = "white";
		if(data == 0){
			color = "white";
		}else if(data == 1){
			color = "orange";
		}else if(data == 2){
			color = "magenta";
		}else if(data == 3){
			color = "light blue";
		}else if(data == 4){
			color = "yellow";
		}else if(data == 5){
			color = "lime";
		}else if(data == 6){
			color = "pink";
		}else if(data == 7){
			color = "gray";
		}else if(data == 8){
			color = "light gray";
		}else if(data == 9){
			color = "cyan";
		}else if(data == 10){
			color = "purple";
		}else if(data == 11){
			color = "blue";
		}else if(data == 12){
			color = "brown";
		}else if(data == 13){
			color = "green";
		}else if(data == 14){
			color = "red";
		}else if(data == 15){
			color = "black";
		}
		return color;
	}
	
	public static String getInkColor(Short data){
		String color = "black";
		if(data == 0){
			color = "black";
		}else if(data == 1){
			color = "red";
		}else if(data == 2){
			color = "green";
		}else if(data == 3){
			color = "brown";
		}else if(data == 4){
			color = "blue";
		}else if(data == 5){
			color = "purple";
		}else if(data == 6){
			color = "cyan";
		}else if(data == 7){
			color = "light gray";
		}else if(data == 8){
			color = "gray";
		}else if(data == 9){
			color = "pink";
		}else if(data == 10){
			color = "lime";
		}else if(data == 11){
			color = "yellow";
		}else if(data == 12){
			color = "light blue";
		}else if(data == 13){
			color = "magenta";
		}else if(data == 14){
			color = "orange";
		}else if(data == 15){
			color = "white";
		}
		return color;
	}
	
	public static String getInkName(Short data){
		String color = "ink sac";
		if(data == 0){
			color = "ink sac";
		}else if(data == 1){
			color = "rose red";
		}else if(data == 2){
			color = "cactus green";
		}else if(data == 3){
			color = "cocoa beans";
		}else if(data == 4){
			color = "lapis lazuli";
		}else if(data == 5){
			color = "purple dye";
		}else if(data == 6){
			color = "cyan dye";
		}else if(data == 7){
			color = "light gray dye";
		}else if(data == 8){
			color = "gray dye";
		}else if(data == 9){
			color = "pink dye";
		}else if(data == 10){
			color = "lime dye";
		}else if(data == 11){
			color = "dandelion yellow";
		}else if(data == 12){
			color = "light blue dye";
		}else if(data == 13){
			color = "magenta dye";
		}else if(data == 14){
			color = "orange dye";
		}else if(data == 15){
			color = "bone meal";
		}
		return color;
	}
	
	public static String getSlab(Short data){
		String type = "stone";
		if(data == 0){
			type = "stone";
		}else if(data == 1){
			type = "sandstone";
		}else if(data == 2){
			type = "wooden";
		}else if(data == 3){
			type = "cobblestone";
		}else if(data == 4){
			type = "brick";
		}else if(data == 5){
			type = "smooth brick";
		}
		return type;
	}
	
	public static Direction getdir(Player player, boolean multi) {
	    double rot = (player.getLocation().getYaw() - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        if(multi == true){
        	return getMultiDirection(rot);
        }
        return getDirection(rot);
	}
	private static Direction getDirection(double rot) {
		if (0 <= rot && rot < 45) {
            return Direction.WEST;
        } else if (45 <= rot && rot < 135) {
            return Direction.NORTH;
        } else if (135 <= rot && rot < 225) {
            return Direction.EAST;
        } else if (225 <= rot && rot < 315) {
            return Direction.SOUTH;
        } else if (315 <= rot && rot < 360) {
            return Direction.WEST;
        } else {
            return null;
        }
	}
	
	public static enum Direction{
		NORTH(),
		NORTHEAST(),
		EAST(),
		NORTHWEST(),
		SOUTH(),
		SOUTHEAST(),
		WEST(),
		SOUTHWEST();
	}
	
	private static Direction getMultiDirection(double rot) {
        if (0 <= rot && rot < 22.5) {
            return Direction.WEST;
        } else if (22.5 <= rot && rot < 67.5) {
            return Direction.NORTHWEST;
        } else if (67.5 <= rot && rot < 112.5) {
            return Direction.NORTH;
        } else if (112.5 <= rot && rot < 157.5) {
            return Direction.NORTHEAST;
        } else if (157.5 <= rot && rot < 202.5) {
            return Direction.EAST;
        } else if (202.5 <= rot && rot < 247.5) {
            return Direction.SOUTHEAST;
        } else if (247.5 <= rot && rot < 292.5) {
            return Direction.SOUTH;
        } else if (292.5 <= rot && rot < 337.5) {
            return Direction.SOUTHWEST;
        } else if (337.5 <= rot && rot < 360.0) {
            return Direction.WEST;
        } else {
            return null;
        }
	}
	
	public static boolean isTool(Material type) {
		if(type.equals(Material.WOOD_AXE) || type.equals(Material.WOOD_HOE) || type.equals(Material.WOOD_PICKAXE) || type.equals(Material.WOOD_SPADE) || type.equals(Material.WOOD_SWORD) || 
				type.equals(Material.STONE_AXE) || type.equals(Material.STONE_HOE) || type.equals(Material.STONE_PICKAXE) || type.equals(Material.STONE_SPADE) || type.equals(Material.STONE_SWORD) ||
				type.equals(Material.IRON_AXE) || type.equals(Material.IRON_HOE) || type.equals(Material.IRON_PICKAXE) || type.equals(Material.IRON_SPADE) || type.equals(Material.IRON_SWORD) || 
				type.equals(Material.GOLD_AXE) || type .equals(Material.GOLD_HOE) || type.equals(Material.GOLD_PICKAXE) || type .equals(Material.GOLD_SPADE) || type.equals(Material.GOLD_SWORD) ||
				type .equals(Material.DIAMOND_AXE) || type.equals(Material.DIAMOND_HOE) || type.equals(Material.DIAMOND_PICKAXE) || type .equals(Material.DIAMOND_SPADE) || type.equals(Material.DIAMOND_SWORD)){
			return true;
		}
		return false;
	}
	
	public static boolean isLeatherArmor(Material type) {
		if(type.equals(Material.LEATHER_HELMET) || type.equals(Material.LEATHER_CHESTPLATE) || type.equals(Material.LEATHER_LEGGINGS) || type.equals(Material.LEATHER_BOOTS)){
			return true;
		}
		return false;
	}
	
	public static boolean isChainArmor(Material type) {
		if(type.equals(Material.CHAINMAIL_HELMET) || type.equals(Material.CHAINMAIL_CHESTPLATE) || type.equals(Material.CHAINMAIL_LEGGINGS) || type.equals(Material.CHAINMAIL_BOOTS)){
			return true;
		}
		return false;
	}
	
	public static boolean isIronArmor(Material type) {
		if(type.equals(Material.IRON_HELMET) || type.equals(Material.IRON_CHESTPLATE) || type.equals(Material.IRON_LEGGINGS) || type.equals(Material.IRON_BOOTS)){
			return true;
		}
		return false;
	}
	
	public static boolean isGoldArmor(Material type) {
		if(type.equals(Material.GOLD_HELMET) || type.equals(Material.GOLD_CHESTPLATE) || type.equals(Material.GOLD_LEGGINGS) || type.equals(Material.GOLD_BOOTS)){
			return true;
		}
		return false;
	}
	
	public static boolean isDiamondArmor(Material type) {
		if(type.equals(Material.DIAMOND_HELMET) || type.equals(Material.DIAMOND_CHESTPLATE) || type.equals(Material.DIAMOND_LEGGINGS) || type.equals(Material.DIAMOND_BOOTS)){
			return true;
		}
		return false;
	}
	
	public static boolean isArmor(Material type){
		if(type.toString().contains("HELMET") || type.toString().contains("CHESTPLATE") || type.toString().contains("LEGGINGS") || type.toString().contains("BOOTS")){
			return true;
		}
		return false;
	}

	public static int getDataAmount(Material material) {
		if(material.equals(Material.MONSTER_EGG)){
			return 25;
		}else if(material.equals(Material.WOOL) || material.equals(Material.INK_SACK)){
			return 16;
		}else if(material.equals(Material.STEP) || material.equals(Material.DOUBLE_STEP)){
			return 6;
		}else if(material.equals(Material.LOG) || material.equals(Material.WOOD) || material.equals(Material.LEAVES) || material.equals(Material.SMOOTH_BRICK)){
			return 4;
		}else if(material.equals(Material.SAPLING) || material.equals(Material.LONG_GRASS) || material.equals(Material.SANDSTONE)){
			return 3;
		}else if(material.equals(Material.COAL)){
			return 2;
		}
		return 0;
	}

	public static Skill getSkill(Material material) {
		if(material.toString().contains("HELMET") || material.toString().contains("CHESTPLATE") || material.toString().contains("LEGGINGS") || material.toString().contains("BOOTS")){
			return Skill.DEFENSE;
		}else if(material.toString().contains("PICKAXE")){
			return Skill.MINING;
		}else if(material.toString().contains("AXE")){
			return Skill.WOODCUTTING;
		}else if(material.toString().contains("SPADE")){
			return Skill.EXCAVATION;
		}else if(material.toString().contains("HOE")){
			return Skill.FARMING;
		}else if(material.toString().contains("SWORD")){
			return Skill.ATTACK;
		}
		return null;
	}

	public static Skill getCustomSkill(org.getspout.spoutapi.material.Material material) {
		//if(material.getName().contains("Crossbow")){
			//return Skill.RANGED;
		//}
		return null;
	}
}
