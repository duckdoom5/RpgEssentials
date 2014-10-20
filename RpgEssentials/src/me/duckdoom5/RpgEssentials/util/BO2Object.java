package me.duckdoom5.RpgEssentials.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Biome;

public class BO2Object {

    private final HashMap<String, String> metadata = new HashMap<>();
    private int minX, maxX;
    private int minY, maxY;
    private int minZ, maxZ;

    private BO2BlockData[] data;

    public BO2Object() {
        metadata.put("name", "Undefined");
        metadata.put("version", "");
        metadata.put("spawnonblocktype", "2");
        metadata.put("spawnsunlight", "true");
        metadata.put("spawndarkness", "false");
        metadata.put("spawnwater", "false");
        metadata.put("spawnlava", "false");
        metadata.put("underfill", "true");
        metadata.put("dig", "true");
        metadata.put("rarity", "10"); // Bound Min - 1, Max - 100
        metadata.put("collisionpercentage", "2"); // Bound Min = 1 max = 100;
        metadata.put("spawnelevationmin", "0"); // Bound Min = 1, Max 128;
        metadata.put("spawnelevationmax", "128"); // Bound Min = 1, Max 128;
        metadata.put("randomrotation", "true");
        metadata.put("groupid", "");
        metadata.put("tree", "false");
        metadata.put("branch", "false");
        metadata.put("diggingbranch", "false");
        metadata.put("groupfrequencymin", "1"); // [Bound: Min = 1, Max = 100,
                                                // Min <= Max]
        metadata.put("groupfrequencymax", "5"); // [Bound: Min = 1, Max = 100,
                                                // Max >= Min]
        metadata.put("groupseperationmin", "0"); // [Bound: Min = 0, Max = 16,
                                                 // Min <= Max]
        metadata.put("groupseperationmax", "5"); // [Bound: Min = 0, Max = 16,
                                                 // Max >= Min]
        metadata.put("spawninbiome", "all"); // [Bound: Only valid Biomes and
                                             // "All"]
    }

    public String getVersion() {
        return metadata.get("version");
    }

    public int getSpawnOnBlockType() {
        return Integer.parseInt(metadata.get("spawnonblocktype"));
    }

    public boolean canSpawnOnBlock(int blockID) {
        final boolean rv = metadata.get("spawnonblocktype").contains(
                blockID + "");
        return rv;
    }

    public boolean canSpawnSunlight() {
        return Boolean.valueOf(metadata.get("spawnsunlight"));
    }

    public boolean canSpawnDarkness() {
        return Boolean.valueOf(metadata.get("spawndarkness"));
    }

    public boolean canSpawnWater() {
        return Boolean.valueOf(metadata.get("spawnwater"));
    }

    public boolean canSpawnLava() {
        return Boolean.valueOf(metadata.get("spawnlava"));
    }

    public boolean shouldUnderFill() {
        return Boolean.valueOf(metadata.get("underfill"));
    }

    public boolean canDig() {
        return Boolean.valueOf(metadata.get("dig"));
    }

    public int getRarity() {
        return Integer.parseInt(metadata.get("rarity"));
    }

    public int getCollisionPercentage() {
        return Integer.parseInt(metadata.get("collisionpercentage"));
    }

    public int getSpawnElevationMin() {
        return Integer.parseInt(metadata.get("spawnelevationmin"));
    }

    public int getSpawnElevationMax() {
        return Integer.parseInt(metadata.get("spawnelevationmax"));
    }

    public boolean canRandomRotation() {
        return Boolean.valueOf(metadata.get("randomrotation"));
    }

    public String getGroupID() {
        return metadata.get("groupid");
    }

    public boolean isTree() {
        return Boolean.valueOf(metadata.get("tree"));
    }

    public boolean isBranch() {
        return Boolean.valueOf(metadata.get("branch"));
    }

    public boolean isDiggingBranch() {
        return Boolean.valueOf(metadata.get("diggingbranch"));
    }

    public int getGroupFrequencyMin() {
        return Integer.parseInt(metadata.get("groupfrequencymin"));
    }

    public int getGroupFrequencyMax() {
        return Integer.parseInt(metadata.get("groupfrequencymax"));
    }

    public int getGroupSeperationMin() {
        return Integer.parseInt(metadata.get("groupseperationmin"));
    }

    public int getGroupSeperationMax() {
        return Integer.parseInt(metadata.get("groupseperationmax"));
    }

    public String[] getSpawnInBiome() {
        return metadata.get("spawninbiome").split(",");
    }

    public boolean canSpawnInBiome(Biome biome) {
        if (metadata.get("spawninbiome").equalsIgnoreCase("all")) {
            return true;
        }
        final String[] biomes = getSpawnInBiome();
        for (final String biome2 : biomes) {
            if (biome2.equalsIgnoreCase(biome.toString())) {
                return true;
            }
        }
        return false;
    }

    public BO2BlockData[] getData() {
        return data;
    }

    public String getName() {
        return metadata.get("name");
    }

    public void ParseMetadata(String[] data) {
        for (final String element : data) {
            final String[] kv = element.toLowerCase().split("=");

            // System.out.println("[key] "+ kv[0] + " [value] " + kv[1]);
            metadata.put(kv[0].trim().toLowerCase(), kv[1].trim().toLowerCase());
        }
    }

    public void ParseBlockdata(String[] data) {

        final ArrayList<BO2BlockData> dat = new ArrayList<>();
        for (final String element : data) {
            final String loc = element.toLowerCase();

            final int locToken = loc.indexOf(':');
            final String pos = loc.substring(0, locToken);
            final String[] poses = pos.split(",");
            final int X = Integer.parseInt(poses[0]);
            if (minX > X) {
                minX = X;
            }
            if (maxX < X) {
                maxX = X;
            }
            final int Z = Integer.parseInt(poses[1]);
            if (minZ > Z) {
                minZ = Z;
            }
            if (maxZ < Z) {
                maxZ = Z;
            }
            final int Y = Integer.parseInt(poses[2]);
            if (minY > Y) {
                minY = Y;
            }
            if (maxY < Y) {
                maxY = Y;
            }

            int MatID = 0;

            if (loc.contains(".")) {
                MatID = Integer.parseInt(loc.substring(locToken + 1,
                        loc.indexOf('.')));
            } else {
                MatID = Integer.parseInt(loc.substring(locToken + 1));
            }
            final Material mat = Material.getMaterial(MatID);

            int BlockData = 0;
            if (loc.contains(".")) {
                if (loc.contains("#")) {
                    BlockData = Integer.parseInt(loc.substring(
                            loc.indexOf('.') + 1, loc.indexOf('#')));
                } else {
                    BlockData = Integer.parseInt(loc.substring(loc.indexOf('.') + 1));

                }
            }

            // if(loc.contains("#")){
            // }
            final BO2BlockData block = new BO2BlockData();
            block.x = X;
            block.y = Y;
            block.z = Z;
            block.type = mat;
            block.data = BlockData;
            dat.add(block);

        }
        this.data = dat.toArray(new BO2BlockData[1]);

    }

    public HashMap<String, String> getMetadata() {
        return metadata;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinZ() {
        return minZ;
    }

    public int getMaxZ() {
        return maxZ;
    }
}