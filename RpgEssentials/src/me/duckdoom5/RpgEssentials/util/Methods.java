package me.duckdoom5.RpgEssentials.util;

import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Methods {

    public static void addWaypoint(String name, Vector loc, SpoutPlayer splayer) {
        splayer.addWaypoint(name, loc.getX(), loc.getY(), loc.getZ());

    }

    public static void addPublicWaypoint(String name, Vector loc) {
        final SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
        for (final SpoutPlayer onplayer : onplayers) {
            onplayer.addWaypoint(name, loc.getX(), loc.getX(), loc.getZ());
        }
    }

    public static boolean isInventoryEmpty(Player player) {
        final ItemStack[] contents = player.getInventory().getContents();
        for (final ItemStack content : contents) {
            if (content != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInventoryEmpty(ItemStack[] contents) {
        for (final ItemStack content : contents) {
            if (content != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInventoryFull(ItemStack[] contents) {
        for (final ItemStack content : contents) {
            if (content == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDataMaterial(Material material) {
        if (material.equals(Material.WOOL) || material.equals(Material.COAL) || material.equals(Material.SAPLING) || material.equals(Material.LOG) || material.equals(Material.WOOD) || material.equals(Material.LEAVES) || material.equals(Material.SANDSTONE) || material.equals(Material.STEP) || material.equals(Material.SMOOTH_BRICK) || material.equals(Material.DOUBLE_STEP) || material.equals(Material.LONG_GRASS) || material.equals(Material.MONSTER_EGG) || material.equals(Material.MOB_SPAWNER) || material.equals(Material.INK_SACK) || material.equals(Material.SAND) || material.equals(Material.DIRT) || material.equals(Material.STAINED_CLAY) || material.equals(Material.CARPET) || material.equals(Material.COBBLE_WALL) || material.equals(Material.SKULL_ITEM) || material.equals(Material.MONSTER_EGG) || material.equals(Material.MONSTER_EGGS) || material.equals(Material.QUARTZ_BLOCK) || material.equals(Material.RAW_FISH) || material.equals(Material.POTION) || material.equals(Material.GOLDEN_APPLE)) {
            return true;
        }
        return false;
    }

    public static String getDataName(Material material, Short data) {
        String name2 = material.toString().toLowerCase().replace("_", " ");
        if (name2.equals("wool")) {
            name2 = getWoolColor(data) + " wool";
        } else if (name2.equals("stained clay")) {
            name2 = getWoolColor(data) + " clay";
        } else if (name2.equals("carpet")) {
            name2 = getWoolColor(data) + " carpet";
        } else if (name2.equals("stained glass")) {
            name2 = getWoolColor(data) + " glass";
        } else if (name2.equals("ink sack")) {
            name2 = getInkName(data);
        } else if (name2.equals("coal")) {
            if (data == 0) {
                name2 = "coal";
            } else {
                name2 = "charcoal";
            }
        } else if (name2.equals("golden apple")) {
            if (data == 0) {
                name2 = "golden apple";
            } else {
                name2 = "enchanted golden apple";
            }
        } else if (name2.equals("sand")) {
            if (data == 0) {
                name2 = "sand";
            } else {
                name2 = "red sand";
            }
        } else if (name2.equals("sapling")) {
            name2 = getWood(data) + " sapling";
        } else if (name2.equals("dirt")) {
            if (data == 0) {
                name2 = "dirt";
            } else if (data == 1) {
                name2 = "grassless dirt";
            } else if (data == 2) {
                name2 = "podzol";
            } else {
                name2 = "podzol";
            }
        } else if (name2.equals("skull item")) {
            if (data == 0) {
                name2 = "skeleton skull";
            } else if (data == 1) {
                name2 = "wither skeleton skull";
            } else if (data == 2) {
                name2 = "zombie skull";
            } else if (data == 3) {
                name2 = "human skull";
            } else {
                name2 = "creeper skull";
            }
        } else if (name2.equals("log")) {
            name2 = getWood(data) + " log";
        } else if (name2.equals("wood")) {
            name2 = getWood(data) + " planks";
        } else if (name2.equals("sandstone")) {
            if (data == 0) {
                name2 = "sandstone";
            } else if (data == 2) {
                name2 = "creeper sandstone";
            } else {
                name2 = "smooth sandstone";
            }
        } else if (name2.equals("step")) {
            name2 = getSlab(data) + " slab";
        } else if (name2.equals("double step")) {
            name2 = getSlab(data) + " double slab";
        } else if (name2.equals("wood step")) {
            name2 = getWood(data) + " wood slab";
        } else if (name2.equals("long grass")) {
            if (data == 0) {
                name2 = "dead scrub";
            } else if (data == 1) {
                name2 = "tall grass";
            } else {
                name2 = "fern";
            }
        } else if (name2.equals("quartz")) {
            if (data == 0) {
                name2 = "quartz block";
            } else if (data == 1) {
                name2 = "chiseled quartz";
            } else {
                name2 = "quartz pillar";
            }
        } else if (name2.equals("raw fish")) {
            if (data == 0) {
                name2 = "fish";
            } else if (data == 1) {
                name2 = "salmon";
            } else if (data == 1) {
                name2 = "clownfish";
            } else {
                name2 = "pufferfish";
            }
        } else if (name2.equals("smooth brick")) {
            if (data == 0) {
                name2 = "smooth brick";
            } else if (data == 1) {
                name2 = "mossy brick";
            } else if (data == 2) {
                name2 = "cracked brick";
            } else {
                name2 = "circle brick";
            }
        } else if (name2.equals("monster eggs")) {
            if (data == 0) {
                name2 = "stone monster egg";
            } else if (data == 1) {
                name2 = "cobblestone monster egg";
            } else if (data == 2) {
                name2 = "smooth brick monster egg";
            } else if (data == 3) {
                name2 = "mossy brick monster egg";
            } else if (data == 3) {
                name2 = "cracked brick monster egg";
            } else {
                name2 = "circle brick monster egg";
            }
        } else if (name2.equals("monster egg")) {
            name2 = getMob(data) + " egg";
        } else if (name2.equals("mob spawner")) {
            name2 = getMob(data) + " spawner";
        } else if (name2.equals("potion")) {
            name2 = getPotion(data);
        }
        return name2;
    }

    public static String getWoolColor(Short data) {
        String color = "white";
        if (data == 0) {
            color = "white";
        } else if (data == 1) {
            color = "orange";
        } else if (data == 2) {
            color = "magenta";
        } else if (data == 3) {
            color = "light blue";
        } else if (data == 4) {
            color = "yellow";
        } else if (data == 5) {
            color = "lime";
        } else if (data == 6) {
            color = "pink";
        } else if (data == 7) {
            color = "gray";
        } else if (data == 8) {
            color = "light gray";
        } else if (data == 9) {
            color = "cyan";
        } else if (data == 10) {
            color = "purple";
        } else if (data == 11) {
            color = "blue";
        } else if (data == 12) {
            color = "brown";
        } else if (data == 13) {
            color = "green";
        } else if (data == 14) {
            color = "red";
        } else if (data == 15) {
            color = "black";
        }
        return color;
    }

    public static String getInkColor(Short data) {
        String color = "black";
        if (data == 0) {
            color = "black";
        } else if (data == 1) {
            color = "red";
        } else if (data == 2) {
            color = "green";
        } else if (data == 3) {
            color = "brown";
        } else if (data == 4) {
            color = "blue";
        } else if (data == 5) {
            color = "purple";
        } else if (data == 6) {
            color = "cyan";
        } else if (data == 7) {
            color = "light gray";
        } else if (data == 8) {
            color = "gray";
        } else if (data == 9) {
            color = "pink";
        } else if (data == 10) {
            color = "lime";
        } else if (data == 11) {
            color = "yellow";
        } else if (data == 12) {
            color = "light blue";
        } else if (data == 13) {
            color = "magenta";
        } else if (data == 14) {
            color = "orange";
        } else if (data == 15) {
            color = "white";
        }
        return color;
    }

    public static String getInkName(Short data) {
        String color = "ink sac";
        if (data == 0) {
            color = "ink sac";
        } else if (data == 1) {
            color = "rose red";
        } else if (data == 2) {
            color = "cactus green";
        } else if (data == 3) {
            color = "cocoa beans";
        } else if (data == 4) {
            color = "lapis lazuli";
        } else if (data == 5) {
            color = "purple dye";
        } else if (data == 6) {
            color = "cyan dye";
        } else if (data == 7) {
            color = "light gray dye";
        } else if (data == 8) {
            color = "gray dye";
        } else if (data == 9) {
            color = "pink dye";
        } else if (data == 10) {
            color = "lime dye";
        } else if (data == 11) {
            color = "dandelion yellow";
        } else if (data == 12) {
            color = "light blue dye";
        } else if (data == 13) {
            color = "magenta dye";
        } else if (data == 14) {
            color = "orange dye";
        } else if (data == 15) {
            color = "bone meal";
        }
        return color;
    }

    public static String getMob(Short data) {
        String type = "creeper";
        if (data == 50) {
            type = "creeper";
        } else if (data == 51) {
            type = "skeleton";
        } else if (data == 52) {
            type = "spider";
        } else if (data == 53) {
            type = "giant";
        } else if (data == 54) {
            type = "zombie";
        } else if (data == 55) {
            type = "slime";
        } else if (data == 56) {
            type = "ghast";
        } else if (data == 57) {
            type = "pig-zombie";
        } else if (data == 58) {
            type = "enderman";
        } else if (data == 59) {
            type = "cave spider";
        } else if (data == 60) {
            type = "silverfish";
        } else if (data == 61) {
            type = "blaze";
        } else if (data == 62) {
            type = "magma cube";
        } else if (data == 63) {
            type = "enderdragon";
        } else if (data == 90) {
            type = "pig";
        } else if (data == 91) {
            type = "sheep";
        } else if (data == 92) {
            type = "cow";
        } else if (data == 93) {
            type = "chicken";
        } else if (data == 94) {
            type = "squid";
        } else if (data == 95) {
            type = "wolf";
        } else if (data == 96) {
            type = "mooshroom";
        } else if (data == 97) {
            type = "snow golem";
        } else if (data == 98) {
            type = "ocelot";
        } else if (data == 99) {
            type = "iron golem";
        } else if (data == 100) {
            type = "horse";
        } else if (data == 120) {
            type = "villager";
        } else {
            type = "mob";
        }
        return type;
    }

    public static String getWood(Short data) {
        String type = "oak";
        if (data == 0) {
            type = "oak";
        } else if (data == 1) {
            type = "spruce";
        } else if (data == 2) {
            type = "birch";
        } else if (data == 3) {
            type = "jungle";
        } else if (data == 4) {
            type = "acacia";
        } else if (data == 5) {
            type = "dark oak";
        }
        return type;
    }

    public static String getSlab(Short data) {
        String type = "stone";
        if (data == 0) {
            type = "stone";
        } else if (data == 1) {
            type = "sandstone";
        } else if (data == 2) {
            type = "wooden";
        } else if (data == 3) {
            type = "cobblestone";
        } else if (data == 4) {
            type = "brick";
        } else if (data == 5) {
            type = "smooth brick";
        } else if (data == 5) {
            type = "nether brick";
        } else if (data == 5) {
            type = "quartz";
        }
        return type;
    }

    public static String getPotion(Short data) {
        String type = "water";
        if (data == 0) {
            type = "water bottle";
        } else if (data == 16) {
            type = "awkward potion";
        } else if (data == 32) {
            type = "thick potion";
        } else if (data == 64) {
            type = "mundane potion (extended)";
        } else if (data == 8192) {
            type = "mundane potion";
        } else if (data == 8193) {
            type = "potion of regeneration";
        } else if (data == 8257) {
            type = "potion of regeneration (extended)";
        } else if (data == 8225) {
            type = "potion of regeneration II";
        } else if (data == 8194) {
            type = "potion of swiftness";
        } else if (data == 8258) {
            type = "potion of swiftness (extended)";
        } else if (data == 8226) {
            type = "potion of swiftness II";
        } else if (data == 8195) {
            type = "potion of fire resistance";
        } else if (data == 8259) {
            type = "potion of fire resistance (extended)";
        } else if (data == 8197) {
            type = "potion of healing";
        } else if (data == 8229) {
            type = "potion of healing II";
        } else if (data == 8198) {
            type = "potion of night vision";
        } else if (data == 8262) {
            type = "potion of night vision (extended)";
        } else if (data == 8201) {
            type = "potion of strength";
        } else if (data == 8265) {
            type = "potion of strength (extended)";
        } else if (data == 8233) {
            type = "potion of strength II";
        } else if (data == 8206) {
            type = "potion of invisibility";
        } else if (data == 8270) {
            type = "potion of invisibility (extended)";
        } else if (data == 8205) {
            type = "potion of water breathing";
        } else if (data == 8269) {
            type = "potion of water breathing (extended)";
        } else if (data == 8196) {
            type = "potion of poison";
        } else if (data == 8260) {
            type = "potion of poison (extended)";
        } else if (data == 8228) {
            type = "potion of poison II";
        } else if (data == 8200) {
            type = "potion of weakness";
        } else if (data == 8264) {
            type = "potion of weakness (extended)";
        } else if (data == 8202) {
            type = "potion of slowness";
        } else if (data == 8266) {
            type = "potion of slowness (extended)";
        } else if (data == 8204) {
            type = "potion of harming";
        } else if (data == 8236) {
            type = "potion of harming II";

        } else if (data == 16385) {
            type = "splash potion of regeneration";
        } else if (data == 16449) {
            type = "splash potion of regeneration (extended)";
        } else if (data == 16417) {
            type = "splash potion of regeneration II";
        } else if (data == 16386) {
            type = "splash potion of swiftness";
        } else if (data == 16450) {
            type = "splash potion of swiftness (extended)";
        } else if (data == 16418) {
            type = "splash potion of swiftness II";
        } else if (data == 16387) {
            type = "splash potion of fire resistance";
        } else if (data == 16451) {
            type = "splash potion of fire resistance (extended)";
        } else if (data == 16389) {
            type = "splash potion of instant health";
        } else if (data == 16421) {
            type = "splash potion of instant health II";
        } else if (data == 16390) {
            type = "splash potion of night vision";
        } else if (data == 16454) {
            type = "splash potion of night vision (extended)";
        } else if (data == 16393) {
            type = "splash potion of strength";
        } else if (data == 16425) {
            type = "splash potion of strength (extended)";
        } else if (data == 16457) {
            type = "splash potion of strength II";
        } else if (data == 16398) {
            type = "splash potion of invisibility";
        } else if (data == 16462) {
            type = "splash potion of invisibility (extended)";
        } else if (data == 16397) {
            type = "splash potion of water breathing";
        } else if (data == 16461) {
            type = "splash potion of water breathing (extended)";
        } else if (data == 16388) {
            type = "splash potion of poison";
        } else if (data == 16452) {
            type = "splash potion of poison (extended)";
        } else if (data == 16420) {
            type = "splash potion of poison II";
        } else if (data == 16392) {
            type = "splash potion of weakness";
        } else if (data == 16456) {
            type = "splash potion of weakness (extended)";
        } else if (data == 16394) {
            type = "splash potion of slowness";
        } else if (data == 16458) {
            type = "splash potion of slowness (extended)";
        } else if (data == 16396) {
            type = "splash potion of harming";
        } else if (data == 16428) {
            type = "splash potion of harming II";
        }
        return type;
    }

    public static Direction getdir(Player player, boolean multi) {
        double rot = (player.getLocation().getYaw() - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        if (multi == true) {
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

    public static enum Direction {
        NORTH(), NORTHEAST(), EAST(), NORTHWEST(), SOUTH(), SOUTHEAST(), WEST(), SOUTHWEST();
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
        if (type.equals(Material.WOOD_AXE) || type.equals(Material.WOOD_HOE) || type.equals(Material.WOOD_PICKAXE) || type.equals(Material.WOOD_SPADE) || type.equals(Material.WOOD_SWORD) || type.equals(Material.STONE_AXE) || type.equals(Material.STONE_HOE) || type.equals(Material.STONE_PICKAXE) || type.equals(Material.STONE_SPADE) || type.equals(Material.STONE_SWORD) || type.equals(Material.IRON_AXE) || type.equals(Material.IRON_HOE) || type.equals(Material.IRON_PICKAXE) || type.equals(Material.IRON_SPADE) || type.equals(Material.IRON_SWORD) || type.equals(Material.GOLD_AXE) || type.equals(Material.GOLD_HOE) || type.equals(Material.GOLD_PICKAXE) || type.equals(Material.GOLD_SPADE) || type.equals(Material.GOLD_SWORD) || type.equals(Material.DIAMOND_AXE) || type.equals(Material.DIAMOND_HOE) || type.equals(Material.DIAMOND_PICKAXE) || type.equals(Material.DIAMOND_SPADE) || type.equals(Material.DIAMOND_SWORD)) {
            return true;
        }
        return false;
    }

    public static boolean isLeatherArmor(Material type) {
        if (type.equals(Material.LEATHER_HELMET) || type.equals(Material.LEATHER_CHESTPLATE) || type.equals(Material.LEATHER_LEGGINGS) || type.equals(Material.LEATHER_BOOTS)) {
            return true;
        }
        return false;
    }

    public static boolean isChainArmor(Material type) {
        if (type.equals(Material.CHAINMAIL_HELMET) || type.equals(Material.CHAINMAIL_CHESTPLATE) || type.equals(Material.CHAINMAIL_LEGGINGS) || type.equals(Material.CHAINMAIL_BOOTS)) {
            return true;
        }
        return false;
    }

    public static boolean isIronArmor(Material type) {
        if (type.equals(Material.IRON_HELMET) || type.equals(Material.IRON_CHESTPLATE) || type.equals(Material.IRON_LEGGINGS) || type.equals(Material.IRON_BOOTS)) {
            return true;
        }
        return false;
    }

    public static boolean isGoldArmor(Material type) {
        if (type.equals(Material.GOLD_HELMET) || type.equals(Material.GOLD_CHESTPLATE) || type.equals(Material.GOLD_LEGGINGS) || type.equals(Material.GOLD_BOOTS)) {
            return true;
        }
        return false;
    }

    public static boolean isDiamondArmor(Material type) {
        if (type.equals(Material.DIAMOND_HELMET) || type.equals(Material.DIAMOND_CHESTPLATE) || type.equals(Material.DIAMOND_LEGGINGS) || type.equals(Material.DIAMOND_BOOTS)) {
            return true;
        }
        return false;
    }

    public static boolean isArmor(Material type) {
        if (type.toString().contains("HELMET") || type.toString().contains("CHESTPLATE") || type.toString().contains("LEGGINGS") || type.toString().contains("BOOTS")) {
            return true;
        }
        return false;
    }

    public static int getDataAmount(Material material) {
        if (material.equals(Material.POTION)) {
            return 61;
        } else if (material.equals(Material.MONSTER_EGG)) {
            return 25;
        } else if (material.equals(Material.WOOL) || material.equals(Material.INK_SACK) || material.equals(Material.STAINED_CLAY) || material.equals(Material.CARPET)) {
            return 16;
        } else if (material.equals(Material.STEP) || material.equals(Material.DOUBLE_STEP)) {
            return 8;
        } else if (material.equals(Material.MONSTER_EGGS)) {
            return 6;
        } else if (material.equals(Material.SKULL_ITEM)) {
            return 5;
        } else if (material.equals(Material.RAW_FISH) || material.equals(Material.LOG) || material.equals(Material.LEAVES) || material.equals(Material.SAPLING) || material.equals(Material.WOOD) || material.equals(Material.WOOD_STEP) || material.equals(Material.SMOOTH_BRICK)) {
            return 4;
        } else if (material.equals(Material.LONG_GRASS) || material.equals(Material.SANDSTONE) || material.equals(Material.DIRT) || material.equals(Material.QUARTZ_BLOCK)) {
            return 3;
        } else if (material.equals(Material.COAL) || material.equals(Material.SAND) || material.equals(Material.COBBLE_WALL)) {
            return 2;
        }
        return 0;
    }

    public static SkillType getSkill(Material material) {
        if (material.toString().contains("HELMET") || material.toString().contains("CHESTPLATE") || material.toString().contains("LEGGINGS") || material.toString().contains("BOOTS")) {
            return SkillType.DEFENSE;
        } else if (material.toString().contains("PICKAXE")) {
            return SkillType.MINING;
        } else if (material.toString().contains("AXE")) {
            return SkillType.WOODCUTTING;
        } else if (material.toString().contains("SPADE")) {
            return SkillType.EXCAVATION;
        } else if (material.toString().contains("HOE")) {
            return SkillType.FARMING;
        } else if (material.toString().contains("SWORD")) {
            return SkillType.ATTACK;
        }
        return null;
    }

    public static SkillType getCustomSkill(org.getspout.spoutapi.material.Material material) {
        if (material.getName().contains("Crossbow")) {
            // return Skill.RANGED;
        }
        return null;
    }
}
