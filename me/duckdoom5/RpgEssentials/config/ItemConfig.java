package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class ItemConfig {
	public static RpgEssentials plugin;
	YamlConfiguration itemconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public ItemConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setitemconfig(){
		try {
			itemconfig.load("plugins/RpgEssentials/items.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating items config...");
		}
		
		//Custom Items
		
		if(!itemconfig.contains("Custom Items.Adamantine Ingot.texture url")){
			itemconfig.set("Custom Items.Adamantine Ingot.texture url","http://82.74.70.243/server/items/ingots/Adamantineingot.png");
		}
		if(!itemconfig.contains("Custom Items.Adamantine Ingot.furnace recipe1.amount")){
			itemconfig.set("Custom Items.Adamantine Ingot.furnace recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Items.Adamantine Ingot.furnace recipe1.ingredient")){
			itemconfig.set("Custom Items.Adamantine Ingot.furnace recipe1.ingredient", "Adamantine Ore");
		}
		//Custom Tools
		//Adamantine Sword
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.texture url")){
			itemconfig.set("Custom Tools.Adamantine Sword.texture url","http://82.74.70.243/server/items/tools/Adamantinesword.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.durability")){
			itemconfig.set("Custom Tools.Adamantine Sword.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,Adamantine Ingot,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","Adamantine Ingot,-,-","280,-,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe3.amount")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe3.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Sword.shaped recipe3.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Sword.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,Adamantine Ingot","-,-,280"));
		}
		//Adamantine Shovel
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.texture url")){
			itemconfig.set("Custom Tools.Adamantine Shovel.texture url","http://82.74.70.243/server/items/tools/Adamantineshovel.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.durability")){
			itemconfig.set("Custom Tools.Adamantine Shovel.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe1.ingredients", Arrays.asList("-,Adamantine Ingot,-","-,280,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe2.ingredients", Arrays.asList("Adamantine Ingot,-,-","280,-,-","280,-,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe3.amount")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe3.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Shovel.shaped recipe3.ingredients", Arrays.asList("-,-,Adamantine Ingot","-,-,280","-,-,280"));
		}
		/*//Adamantine Axe
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.texture url")){
			itemconfig.set("Custom Tools.Adamantine Axe.texture url","http://82.74.70.243/server/items/tools/Adamantineaxe.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.durability")){
			itemconfig.set("Custom Tools.Adamantine Axe.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","Adamantine Ingot,280,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Axe.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Axe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,Adamantine Ingot","-,280,-"));
		}
		//Adamantine Hoe
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.texture url")){
			itemconfig.set("Custom Tools.Adamantine Hoe.texture url","http://82.74.70.243/server/items/tools/Adamantinehoe.png");
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.durability")){
			itemconfig.set("Custom Tools.Adamantine Hoe.durability",20);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe1.amount")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe1.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe1.ingredients", Arrays.asList("Adamantine Ingot,Adamantine Ingot,-","-,280,-","-,280,-"));
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe2.amount")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe2.amount", 1);
		}
		if(!itemconfig.contains("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients")){
			itemconfig.set("Custom Tools.Adamantine Hoe.shaped recipe2.ingredients", Arrays.asList("-,Adamantine Ingot,Adamantine Ingot","-,280,-","-,280,-"));
		}*/
		try {
			itemconfig.save("plugins/RpgEssentials/items.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
