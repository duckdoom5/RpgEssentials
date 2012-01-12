package me.duckdoom5.RpgEssentials.util;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.*;
import org.bukkit.block.Biome;


public class BO2Object {

	private HashMap<String, String> metadata = new HashMap<String, String>();
	private int minX, maxX;
	private int minY, maxY;
	private int minZ, maxZ;
	
	
	private BO2BlockData[] data;
	
	
	public BO2Object(){
	metadata.put("name", "Undefined");
	metadata.put("version", "");
	metadata.put("spawnOnBlockType", "2");
	metadata.put("spawnSunlight", "true");
	metadata.put("spawnDarkness", "false");
	metadata.put("spawnWater", "false");
	metadata.put("spawnLava", "false");
	metadata.put("underFill", "true");
	metadata.put("dig", "true");
	metadata.put("rarity", "10"); //Bound Min - 1, Max - 100
	metadata.put("collisionPercentage", "2"); //Bound Min = 1 max = 100;
	metadata.put("spawnElevationMin", "0"); //Bound Min = 1, Max 128;
	metadata.put("spawnElevationMax", "128"); //Bound Min = 1, Max 128;
	metadata.put("randomRotation", "true");
	metadata.put("groupID", "");
	metadata.put("tree", "false");
	metadata.put("branch", "false");
	metadata.put("diggingBranch", "false");
	metadata.put("groupFrequencyMin", "1"); // [Bound: Min = 1, Max = 100, Min <= Max]
	metadata.put("groupFrequencyMax", "5"); // [Bound: Min = 1, Max = 100, Max >= Min]
	metadata.put("groupSeperationMin", "0"); // [Bound: Min = 0, Max = 16, Min <= Max]
	metadata.put("groupSeperationMax", "5"); // [Bound: Min = 0, Max = 16, Max >= Min]
	metadata.put("spawnInBiome", "All"); // [Bound: Only valid Biomes and "All"]
	}
	
	public String getVersion() {
		return metadata.get("version");
	}
	
	public int getSpawnOnBlockType() {
		return Integer.parseInt(metadata.get("spawnOnBlockType"));
	}
	public boolean canSpawnOnBlock(int blockID){
		boolean rv = metadata.get("spawnOnBlockType").contains(blockID + "");
	return rv;
	}
	
	public boolean canSpawnSunlight() {
		return Boolean.valueOf(metadata.get("spawnSunlight"));
	}
	
	public boolean canSpawnDarkness() {
		return Boolean.valueOf(metadata.get("spawnDarkness"));
	}
	
	public boolean canSpawnWater() {
		return Boolean.valueOf(metadata.get("spawnWater"));
	}
	
	public boolean canSpawnLava() {
		return Boolean.valueOf(metadata.get("spawnLava"));
	}
	
	public boolean shouldUnderFill() {
		return Boolean.valueOf(metadata.get("underFill"));
	}
	
	public boolean canDig() {
		return Boolean.valueOf(metadata.get("dig"));
	}
	
	public int getRarity() {
		return Integer.parseInt(metadata.get("rarity"));
	}
	
	public int getCollisionPercentage() {
		return Integer.parseInt(metadata.get("collisionPercentage"));
	}
	
	public int getSpawnElevationMin() {
		return Integer.parseInt(metadata.get("spawnElevationMin"));
	}
	
	public int getSpawnElevationMax() {
		return Integer.parseInt(metadata.get("spawnElevationMax"));
	}
	
	public boolean canRandomRotation() {
		return Boolean.valueOf(metadata.get("randomRotation"));
	}
	
	public String getGroupID() {
		return metadata.get("groupID");
	}
	
	public boolean isTree() {
		return Boolean.valueOf(metadata.get("tree"));
	}
	
	public boolean isBranch() {
		return Boolean.valueOf(metadata.get("branch"));
	}
	
	public boolean isDiggingBranch() {
		return Boolean.valueOf(metadata.get("diggingBranch"));
	}
	
	public int getGroupFrequencyMin() {
		return Integer.parseInt(metadata.get("groupFrequencyMin"));
	}
	
	public int getGroupFrequencyMax() {
		return Integer.parseInt(metadata.get("groupFrequencyMax"));
	}
	
	public int getGroupSeperationMin() {
		return Integer.parseInt(metadata.get("groupSeperationMin"));
	}
	
	public int getGroupSeperationMax() {
		return Integer.parseInt(metadata.get("groupSeperationMax"));
	}
	
	public String[] getSpawnInBiome() {
		return metadata.get("spawnInBiome").split(",");
	}
	public boolean canSpawnInBiome(Biome biome) {
		//BO2Plugin.ConOut("Biome: " + biome.toString() + " Wants: "+ metadata.get("spawnInBiome") );
		if( metadata.get("spawnInBiome").equalsIgnoreCase("all")) return true;
		String[] biomes = getSpawnInBiome();
		for(int i= 0; i < biomes.length; i++){
			if(biomes[i].equalsIgnoreCase(biome.toString())) return true;
		}
		return false;
	}
	
	public BO2BlockData[] getData() {
		return data;
	}
	public String getName(){
		return metadata.get("name");
	
	}
	
	public void ParseMetadata(String[] data){
		for(int i = 0; i < data.length; i++){
		String[] kv = data[i].toLowerCase().split("=");
		//BO2Plugin.ConOut("[k] "+ kv[0] + " [v] " + kv[1]);
		metadata.put(kv[0].trim().toLowerCase(), kv[1].trim().toLowerCase());
		}
	}
	public void ParseBlockdata(String[] data){
	
		ArrayList<BO2BlockData> dat = new ArrayList<BO2BlockData>();
		for(int i=0; i<data.length; i++){
		String loc = data[i].toLowerCase();
		
		
		int locToken = loc.indexOf(':');
		String pos = loc.substring(0, locToken);
		String[] poses = pos.split(",");
		int X = Integer.parseInt(poses[0]);
		if(minX > X){
		minX = X;
		}
		if(maxX < X){
			maxX = X;
		}
		int Z = Integer.parseInt(poses[1]);
		if(minZ > Z){
			minZ = Z;
		}
		if(maxZ < Z){
			maxZ = Z;
		}
		int Y = Integer.parseInt(poses[2]);
		if(minY > Y){
			minY = Y;
		}
		if(maxY < Y){
			maxY = Y;
		}
	
		int MatID = 0;
	
		if(loc.contains(".")){
			MatID = Integer.parseInt(loc.substring(locToken +1, loc.indexOf('.')) );
		} else {
			MatID = Integer.parseInt(loc.substring(locToken +1) );
		}
		Material mat = Material.getMaterial(MatID);
	
		int BlockData = 0;
		if(loc.contains(".")){
			if(loc.contains("#")){
			BlockData = Integer.parseInt(loc.substring(loc.indexOf('.')+1, loc.indexOf('#')) );
			} else {
				BlockData = Integer.parseInt(loc.substring(loc.indexOf('.')+1) );
			}
		}
	
		if(loc.contains("#")){
			//BO2Plugin.ConOut("Warning: Branches Not Supported in "+ getName() + " ["+getVersion()+"]" );
		}
		BO2BlockData block = new BO2BlockData();
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
