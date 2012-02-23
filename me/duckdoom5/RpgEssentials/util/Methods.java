package me.duckdoom5.RpgEssentials.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Methods {
	public static String getDataName(Material material, Short data){
		String name2 = material.toString().toLowerCase().replace("_", " ");
		if(name2.equals("wool")){
			name2 = getWoolColor(data) + " wool";
		}else if(name2.equals("ink sack")){
			name2 = getInkColor(data);
		}else if(name2.equals("coal")){
			if(data == 1){
				name2 = "charcoal";
			}else{
				name2 = "coal";
			}
		}else if(name2.equals("sapling")){
			if(data == 1){
				name2 = "spruce sapling";
			}else if(data == 2){
				name2 = "birch sapling";
			}else{
				name2 = "oak sapling";
			}
		}else if(name2.equals("log")){
			if(data == 1){
				name2 = "spruce log";
			}else if(data == 2){
				name2 = "birch log";
			}else{
				name2 = "oak log";
			}
		}else if(name2.equals("slab")){
			name2 = getSlab(data) + " slab";
		}else if(name2.equals("double slab")){
			name2 = getSlab(data) + " double slab";
		}else if(name2.equals("long grass")){
			if(data == 1){
				name2 = "tall grass";
			}else if(data == 1){
				name2 = "fern";
			}else{
				name2 = "dead scrub";
			}
		}else if(name2.equals("smooth brick")){
			if(data == 1){
				name2 = "smooth brick";
			}else if(data == 1){
				name2 = "mossy brick";
			}else{
				name2 = "cracked brick";
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
	
	public static String getdir(Player player, boolean multi) {
	    double rot = (player.getLocation().getYaw() - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        if(multi == true){
        	return getMultiDirection(rot);
        }else{
        	return getDirection(rot);
        }
	}
	private static String getDirection(double rot) {
		if (0 <= rot && rot < 45) {
            return "North";
        } else if (45 <= rot && rot < 135) {
            return "East";
        } else if (135 <= rot && rot < 225) {
            return "South";
        } else if (225 <= rot && rot < 315) {
            return "West";
        } else if (315 <= rot && rot < 360) {
            return "North";
        } else {
            return null;
        }
	}
	private static String getMultiDirection(double rot) {
        if (0 <= rot && rot < 22.5) {
            return "North";
        } else if (22.5 <= rot && rot < 67.5) {
            return "Northeast";
        } else if (67.5 <= rot && rot < 112.5) {
            return "East";
        } else if (112.5 <= rot && rot < 157.5) {
            return "Southeast";
        } else if (157.5 <= rot && rot < 202.5) {
            return "South";
        } else if (202.5 <= rot && rot < 247.5) {
            return "Southwest";
        } else if (247.5 <= rot && rot < 292.5) {
            return "West";
        } else if (292.5 <= rot && rot < 337.5) {
            return "Northwest";
        } else if (337.5 <= rot && rot < 360.0) {
            return "North";
        } else {
            return null;
        }
	}
	
	public static boolean isTool(Material type) {
		if(type == Material.WOOD_AXE || type == Material.WOOD_HOE || type == Material.WOOD_PICKAXE || type == Material.WOOD_SPADE || type == Material.WOOD_SWORD || 
				type == Material.STONE_AXE || type == Material.STONE_HOE || type == Material.STONE_PICKAXE || type == Material.STONE_SPADE || type == Material.STONE_SWORD ||
				type == Material.IRON_AXE || type == Material.IRON_HOE || type == Material.IRON_PICKAXE || type == Material.IRON_SPADE || type == Material.IRON_SWORD || 
				type == Material.GOLD_AXE || type == Material.GOLD_HOE || type == Material.GOLD_PICKAXE || type == Material.GOLD_SPADE || type == Material.GOLD_SWORD ||
				type == Material.DIAMOND_AXE || type == Material.DIAMOND_HOE || type == Material.DIAMOND_PICKAXE || type == Material.DIAMOND_SPADE || type == Material.DIAMOND_SWORD){
			return true;
		}
		return false;
	}
}
