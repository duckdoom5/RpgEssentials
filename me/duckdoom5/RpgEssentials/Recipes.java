package me.duckdoom5.RpgEssentials;

import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.blocks.ores.CustomOresDesign;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;

public class Recipes {
	
	static YamlConfiguration blockconfig = new YamlConfiguration();
	static YamlConfiguration itemconfig = new YamlConfiguration();
	
	public static void addItemShapedRecipe(RpgEssentials plugin){
		try {
			blockconfig.load("plugins/RpgEssentials/blocks.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (GenericCustomItem item:Hashmaps.customitems) {
			for(int rpc = 1; rpc < 10; ++rpc){
				if(itemconfig.contains("Custom Items." + item.getName() + ".shaped recipe"+ rpc)){
					System.out.println("Adding shaped recipe"+ rpc +" for: " + item.getName());
					int amount = itemconfig.getInt("Custom Items." + item.getName() + ".shaped recipe"+ rpc +".amount");
					List list = itemconfig.getList("Custom Items." + item.getName() + ".shaped recipe"+ rpc +".ingredients");
					int customId = 0;
					Iterator keys = list.iterator();
					String[] row1 = keys.next().toString().split(",");
					String[] row2 = keys.next().toString().split(",");
					String[] row3 = keys.next().toString().split(",");
					
					
					ItemStack result = new SpoutItemStack(item, amount);
					SpoutShapedRecipe recipe = new SpoutShapedRecipe(result);
					recipe.shape("ghi", "def", "abc");
					//TODO add recipe types
					//TODO add block drop to config and script.
					char letter = 0;
					for(int rowi = 0; rowi<3; ++rowi){
						if(rowi == 0){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'a';
								}else if(i == 1){
									letter = 'b';
								}else if(i == 2){
									letter = 'c';
								}
								if(row1[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem itemcheck:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(itemcheck.getName().equals(row1[i])){
														customId = itemcheck.getCustomId();
													} else if(block.getName().equals(row1[i])){
														customId = block.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}else if(rowi == 1){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'd';
								}else if(i == 1){
									letter = 'e';
								}else if(i == 2){
									letter = 'f';
								}
								if(row2[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem itemcheck:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(itemcheck.getName().equals(row2[i])){
														customId = itemcheck.getCustomId();
													} else if(block.getName().equals(row2[i])){
														customId = block.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}else if(rowi == 2){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'g';
								}else if(i == 1){
									letter = 'h';
								}else if(i == 2){
									letter = 'i';
								}
								if(row3[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem itemcheck:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(itemcheck.getName().equals(row3[i])){
														customId = itemcheck.getCustomId();
													} else if(block.getName().equals(row3[i])){
														customId = block.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}
					}
					SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
					System.out.println("Added recipe for: " + item.getName());
				}
				if(itemconfig.contains("Custom Items." + item.getName() + ".furnace recipe"+ rpc)){
					int amount = itemconfig.getInt("Custom Items." + item.getName() + ".furnace recipe"+ rpc +".amount");
					String ingredient = itemconfig.getString("Custom Items." + item.getName() + ".furnace recipe"+ rpc +".ingredient");
					int customId = 0;
					ItemStack result = new SpoutItemStack(item, amount);
					FurnaceRecipe fr;
					try{
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getMaterial(Integer.parseInt(ingredient)));
					}catch(NumberFormatException e){
						for (GenericCustomItem itemcheck:Hashmaps.customitems) {
							for (CustomOresDesign block:Hashmaps.customores) {
								for (GenericCustomTool toolcheck:Hashmaps.customtools) {
									if(itemcheck.getName().equals(ingredient)){
										customId = itemcheck.getCustomId();
									} else if(block.getName().equals(ingredient)){
										customId = block.getCustomId();
									} else if(toolcheck.getName().equals(ingredient)){
										customId = toolcheck.getCustomId();
									}
								}
							}
						}
						
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getCustomItem(customId));
					}
					Bukkit.getServer().addRecipe(fr);
				}
			}
		}
	}
	public static void addBlockShapedRecipe(RpgEssentials plugin){
		try {
			blockconfig.load("plugins/RpgEssentials/blocks.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (CustomOresDesign block:Hashmaps.customores) {
			for(int rpc = 1; rpc < 10; ++rpc){
				if(blockconfig.contains("Custom Blocks." + block.getName() + ".shaped recipe"+rpc)){
					System.out.println("Adding shaped recipe"+ rpc +" for: " + block.getName());
					int amount = blockconfig.getInt("Custom Blocks." + block.getName() + ".shaped recipe"+ rpc +".amount");
					List list = blockconfig.getList("Custom Blocks." + block.getName() + ".shaped recipe"+ rpc +".ingredients");
					int customId = 0;
					Iterator keys = list.iterator();
					String[] row1 = keys.next().toString().split(",");
					String[] row2 = keys.next().toString().split(",");
					String[] row3 = keys.next().toString().split(",");
					
					
					ItemStack result = new SpoutItemStack(block, amount);
					SpoutShapedRecipe recipe = new SpoutShapedRecipe(result);
					recipe.shape("ghi", "def", "abc");
					char letter = 0;
					for(int rowi = 0; rowi<3; ++rowi){
						if(rowi == 0){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'a';
								}else if(i == 1){
									letter = 'b';
								}else if(i == 2){
									letter = 'c';
								}
								if(row1[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem item:Hashmaps.customitems) {
											for (CustomOresDesign blockcheck:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(item.getName().equals(row1[i])){
														customId = item.getCustomId();
													} else if(blockcheck.getName().equals(row1[i])){
														customId = blockcheck.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}else if(rowi == 1){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'd';
								}else if(i == 1){
									letter = 'e';
								}else if(i == 2){
									letter = 'f';
								}
								if(row2[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem item:Hashmaps.customitems) {
											for (CustomOresDesign blockcheck:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(item.getName().equals(row2[i])){
														customId = item.getCustomId();
													} else if(blockcheck.getName().equals(row2[i])){
														customId = blockcheck.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}else if(rowi == 2){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'g';
								}else if(i == 1){
									letter = 'h';
								}else if(i == 2){
									letter = 'i';
								}
								if(row3[i] != "-"){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
									}catch(NumberFormatException e){
										for (GenericCustomItem item:Hashmaps.customitems) {
											for (CustomOresDesign blockcheck:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(item.getName().equals(row3[i])){
														customId = item.getCustomId();
													} else if(blockcheck.getName().equals(row3[i])){
														customId = blockcheck.getCustomId();
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									recipe.setIngredient(letter, MaterialData.air);
								}
								++i;
							}
						}
					}
					SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
					System.out.println("Added recipe for: " + block.getName());
				}
				if(blockconfig.contains("Custom Blocks." + block.getName() + ".furnace recipe"+ rpc)){
					int amount = blockconfig.getInt("Custom Blocks." + block.getName() + ".furnace recipe"+ rpc +".amount");
					String ingredient = blockconfig.getString("Custom Blocks." + block.getName() + ".furnace recipe"+ rpc +".ingredient");
					int customId = 0;
					ItemStack result = new SpoutItemStack(block, amount);
					FurnaceRecipe fr;
					try{
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getMaterial(Integer.parseInt(ingredient)));
					}catch(NumberFormatException e){
						for (GenericCustomItem itemcheck:Hashmaps.customitems) {
							for (CustomOresDesign blockcheck:Hashmaps.customores) {
								for (GenericCustomTool toolcheck:Hashmaps.customtools) {
									if(itemcheck.getName().equals(ingredient)){
										customId = itemcheck.getCustomId();
									} else if(blockcheck.getName().equals(ingredient)){
										customId = blockcheck.getCustomId();
									} else if(toolcheck.getName().equals(ingredient)){
										customId = toolcheck.getCustomId();
									}
								}
							}
						}
						
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getCustomItem(customId));
					}
					Bukkit.getServer().addRecipe(fr);
				}
			}
		}
	}
	public static void addToolShapedRecipe(RpgEssentials plugin){
		try {
			blockconfig.load("plugins/RpgEssentials/blocks.yml");
			itemconfig.load("plugins/RpgEssentials/items.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (GenericCustomTool tool:Hashmaps.customtools) {
			for(int rpc = 1; rpc < 10; ++rpc){
				if(itemconfig.contains("Custom Tools." + tool.getName() + ".shaped recipe"+rpc)){
					System.out.println("Adding shaped recipe"+ rpc +" for: " + tool.getName());
					int amount = itemconfig.getInt("Custom Tools." + tool.getName() + ".shaped recipe"+ rpc + ".amount");
					List list = itemconfig.getList("Custom Tools." + tool.getName() + ".shaped recipe"+ rpc +".ingredients");
					int customId = 0;
					Iterator keys = list.iterator();
					String[] row1 = keys.next().toString().split(",");
					String[] row2 = keys.next().toString().split(",");
					String[] row3 = keys.next().toString().split(",");
					String srow1 = "";
					String srow2 = "";
					String srow3 = "";
					int counter = 0;
					
					
					ItemStack result = new SpoutItemStack(tool, amount);
					SpoutShapedRecipe recipe = new SpoutShapedRecipe(result);
					recipe.shape("ghi", "def", "abc");
					char letter = 0;
					String rowletter = null;
					for(int rowi = 0; rowi<3; ++rowi){
						if(rowi == 0){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'a';
									rowletter = "a";
								}else if(i == 1){
									letter = 'b';
									rowletter = "b";
								}else if(i == 2){
									letter = 'c';
									rowletter = "c";
								}
								if(!row1[i].equals("-")){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row1[i])));
										srow1 = srow1 + rowletter;
									}catch(NumberFormatException e){
										for (GenericCustomItem item:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(item.getName().equals(row1[i])){
														customId = item.getCustomId();
														if(counter == 0){srow1 = srow1 + rowletter; ++counter;}
													} else if(block.getName().equals(row1[i])){
														customId = block.getCustomId();
														if(counter == 0){srow1 = srow1 + rowletter; ++counter;}
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
														if(counter == 0){srow1 = srow1 + rowletter; ++counter;}
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									srow1 = srow1 + " ";
								}
								++i;
							}
						}else if(rowi == 1){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'd';
									rowletter = "d";
								}else if(i == 1){
									letter = 'e';
									rowletter = "e";
								}else if(i == 2){
									letter = 'f';
									rowletter = "f";
								}
								if(!row2[i].equals("-")){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row2[i])));
										srow2 = srow2 + rowletter;
									}catch(NumberFormatException e){
										for (GenericCustomItem itemcheck:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(itemcheck.getName().equals(row2[i])){
														customId = itemcheck.getCustomId();
														if(counter == 1){srow2 = srow2 + rowletter; ++counter;}
													} else if(block.getName().equals(row2[i])){
														customId = block.getCustomId();
														if(counter == 1){srow2 = srow2 + rowletter; ++counter;}
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
														if(counter == 1){srow2 = srow2 + rowletter; ++counter;}
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									srow2 = srow2 + " ";
								}
								++i;
							}
						}else if(rowi == 2){
							for(int i = 0; i<3;){
								if(i == 0){
									letter = 'g';
									rowletter = "g";
								}else if(i == 1){
									letter = 'h';
									rowletter = "h";
								}else if(i == 2){
									letter = 'i';
									rowletter = "i";
								}
								if(!row3[i].equals("-")){
									try{
										recipe.setIngredient(letter, MaterialData.getMaterial(Integer.parseInt(row3[i])));
										srow3 = srow3 + rowletter;
									}catch(NumberFormatException e){
										for (GenericCustomItem itemcheck:Hashmaps.customitems) {
											for (CustomOresDesign block:Hashmaps.customores) {
												for (GenericCustomTool toolcheck:Hashmaps.customtools) {
													if(itemcheck.getName().equals(row3[i])){
														customId = itemcheck.getCustomId();
														if(counter == 1){srow3 = srow3 + rowletter; ++counter;}
													} else if(block.getName().equals(row3[i])){
														customId = block.getCustomId();
														if(counter == 1){srow3 = srow3 + rowletter; ++counter;}
													} else if(toolcheck.getName().equals(row1[i])){
														customId = toolcheck.getCustomId();
														if(counter == 1){srow3 = srow3 + rowletter; ++counter;}
													}
												}
											}
										}
										recipe.setIngredient(letter, MaterialData.getCustomItem(customId));
									}
								} else {
									srow3 = srow3 + " ";
								}
								++i;
							}
						}
					}
					recipe.shape(srow1, srow2, srow3);
					SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
					System.out.println("Added recipe for: " + tool.getName());
					
				}
				if(itemconfig.contains("Custom Tools." + tool.getName() + ".furnace recipe"+ rpc)){
					int amount = itemconfig.getInt("Custom Tools." + tool.getName() + ".furnace recipe"+ rpc +".amount");
					String ingredient = itemconfig.getString("Custom Tools." + tool.getName() + ".furnace recipe"+ rpc +".ingredient");
					int customId = 0;
					ItemStack result = new SpoutItemStack(tool, amount);
					FurnaceRecipe fr;
					try{
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getMaterial(Integer.parseInt(ingredient)));
					}catch(NumberFormatException e){
						for (GenericCustomItem itemcheck:Hashmaps.customitems) {
							for (CustomOresDesign block:Hashmaps.customores) {
								for (GenericCustomTool toolcheck:Hashmaps.customtools) {
									if(itemcheck.getName().equals(ingredient)){
										customId = itemcheck.getCustomId();
									} else if(block.getName().equals(ingredient)){
										customId = block.getCustomId();
									} else if(toolcheck.getName().equals(ingredient)){
										customId = toolcheck.getCustomId();
									}
								}
							}
						}
						
						fr = new FurnaceRecipe(result, (org.bukkit.material.MaterialData) MaterialData.getCustomItem(customId));
					}
					Bukkit.getServer().addRecipe(fr);
				}
			}
		}
	}
}
