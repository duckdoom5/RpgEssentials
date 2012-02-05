package me.duckdoom5.RpgEssentials.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Methodes {
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
}
