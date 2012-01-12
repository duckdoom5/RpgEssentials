package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class StoreConfig {
	public static RpgEssentials plugin;
	YamlConfiguration storeconfig = new YamlConfiguration();
	public final Logger log = Logger.getLogger("Minecraft");
	
	public StoreConfig(RpgEssentials instance) {
        plugin = instance; 
    }
	
	public void setstoreconfig(){
		try {
			storeconfig.load("plugins/RpgEssentials/Store.yml");
		} catch (Exception e) {
			log.info("[RpgEssentials] Creating store config...");
		}
		//general
		if(!storeconfig.contains("Store.Currency")){
			storeconfig.set("Store.Currency","Dollar");
		}
		
		//food
		if(!storeconfig.contains("Store.Food.apple.Sell Able")){
			storeconfig.set("Store.Food.apple.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.apple.Price")){
			storeconfig.set("Store.Food.apple.Price",10);
		}
		if(!storeconfig.contains("Store.Food.golden apple.Sell Able")){
			storeconfig.set("Store.Food.golden apple.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.golden apple.Price")){
			storeconfig.set("Store.Food.golden apple.Price",10);
		}
		if(!storeconfig.contains("Store.Food.bread.Sell Able")){
			storeconfig.set("Store.Food.bread.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.bread.Price")){
			storeconfig.set("Store.Food.bread.Price",10);
		}
		if(!storeconfig.contains("Store.Food.cake.Sell Able")){
			storeconfig.set("Store.Food.cake.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.cake.Price")){
			storeconfig.set("Store.Food.cake.Price",10);
		}
		if(!storeconfig.contains("Store.Food.raw beef.Sell Able")){
			storeconfig.set("Store.Food.raw beef.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.raw beef.Price")){
			storeconfig.set("Store.Food.raw beef.Price",10);
		}
		if(!storeconfig.contains("Store.Food.cooked beef.Sell Able")){
			storeconfig.set("Store.Food.cooked beef.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.cooked beef.Price")){
			storeconfig.set("Store.Food.cooked beef.Price",10);
		}
		if(!storeconfig.contains("Store.Food.raw chicken.Sell Able")){
			storeconfig.set("Store.Food.raw chicken.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.raw chicken.Price")){
			storeconfig.set("Store.Food.raw chicken.Price",10);
		}
		if(!storeconfig.contains("Store.Food.cooked chicken.Sell Able")){
			storeconfig.set("Store.Food.cooked chicken.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.cooked chicken.Price")){
			storeconfig.set("Store.Food.cooked chicken.Price",10);
		}
		if(!storeconfig.contains("Store.Food.raw fish.Sell Able")){
			storeconfig.set("Store.Food.raw fish.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.raw fish.Price")){
			storeconfig.set("Store.Food.raw fish.Price",10);
		}
		if(!storeconfig.contains("Store.Food.cooked fish.Sell Able")){
			storeconfig.set("Store.Food.cooked fish.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.cooked fish.Price")){
			storeconfig.set("Store.Food.cooked fish.Price",10);
		}
		if(!storeconfig.contains("Store.Food.cookie.Sell Able")){
			storeconfig.set("Store.Food.cookie.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.cookie.Price")){
			storeconfig.set("Store.Food.cookie.Price",10);
		}
		if(!storeconfig.contains("Store.Food.pork.Sell Able")){
			storeconfig.set("Store.Food.pork.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.pork.Price")){
			storeconfig.set("Store.Food.pork.Price",10);
		}
		if(!storeconfig.contains("Store.Food.grilled pork.Sell Able")){
			storeconfig.set("Store.Food.grilled pork.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.grilled pork.Price")){
			storeconfig.set("Store.Food.grilled pork.Price",10);
		}
		if(!storeconfig.contains("Store.Food.melon.Sell Able")){
			storeconfig.set("Store.Food.melon.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.melon.Price")){
			storeconfig.set("Store.Food.melon.Price",10);
		}
		if(!storeconfig.contains("Store.Food.mushroom soup.Sell Able")){
			storeconfig.set("Store.Food.mushroom soup.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.mushroom soup.Price")){
			storeconfig.set("Store.Food.mushroom soup.Price",10);
		}
		if(!storeconfig.contains("Store.Food.rotten flesh.Sell Able")){
			storeconfig.set("Store.Food.rotten flesh.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.rotten flesh.Price")){
			storeconfig.set("Store.Food.rotten flesh.Price",10);
		}
		if(!storeconfig.contains("Store.Food.spider eye.Sell Able")){
			storeconfig.set("Store.Food.spider eye.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Food.spider eye.Price")){
			storeconfig.set("Store.Food.spider eye.Price",10);
		}
		
		//tools
		if(!storeconfig.contains("Store.Tools.wood axe.Sell Able")){
			storeconfig.set("Store.Tools.wood axe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.wood axe.Price")){
			storeconfig.set("Store.Tools.wood axe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.wood hoe.Sell Able")){
			storeconfig.set("Store.Tools.wood hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.wood hoe.Price")){
			storeconfig.set("Store.Tools.wood hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.wood pickaxe.Sell Able")){
			storeconfig.set("Store.Tools.wood pickaxe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.wood pickaxe.Price")){
			storeconfig.set("Store.Tools.wood pickaxe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.wood sword.Sell Able")){
			storeconfig.set("Store.Tools.wood sword.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.wood sword.Price")){
			storeconfig.set("Store.Tools.wood sword.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.wood spade.Sell Able")){
			storeconfig.set("Store.Tools.wood spade.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.wood spade.Price")){
			storeconfig.set("Store.Tools.wood spade.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.stone axe.Sell Able")){
			storeconfig.set("Store.Tools.stone axe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stone axe.Price")){
			storeconfig.set("Store.Tools.stone axe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.stone hoe.Sell Able")){
			storeconfig.set("Store.Tools.stone hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stone hoe.Price")){
			storeconfig.set("Store.Tools.stone hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.stone pickaxe.Sell Able")){
			storeconfig.set("Store.Tools.stone pickaxe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stone pickaxe.Price")){
			storeconfig.set("Store.Tools.stone pickaxe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.stone sword.Sell Able")){
			storeconfig.set("Store.Tools.stone sword.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stone sword.Price")){
			storeconfig.set("Store.Tools.stone sword.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.stone spade.Sell Able")){
			storeconfig.set("Store.Tools.stone spade.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stone spade.Price")){
			storeconfig.set("Store.Tools.stone spade.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.iron axe.Sell Able")){
			storeconfig.set("Store.Tools.iron axe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.iron axe.Price")){
			storeconfig.set("Store.Tools.iron axe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.iron hoe.Sell Able")){
			storeconfig.set("Store.Tools.iron hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.iron hoe.Price")){
			storeconfig.set("Store.Tools.iron hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.iron pickaxe.Sell Able")){
			storeconfig.set("Store.Tools.iron pickaxe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.iron pickaxe.Price")){
			storeconfig.set("Store.Tools.iron pickaxe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.iron sword.Sell Able")){
			storeconfig.set("Store.Tools.iron sword.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.iron sword.Price")){
			storeconfig.set("Store.Tools.iron sword.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.iron spade.Sell Able")){
			storeconfig.set("Store.Tools.iron spade.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.iron spade.Price")){
			storeconfig.set("Store.Tools.iron spade.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.gold axe.Sell Able")){
			storeconfig.set("Store.Tools.gold axe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.gold axe.Price")){
			storeconfig.set("Store.Tools.gold axe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.gold hoe.Sell Able")){
			storeconfig.set("Store.Tools.gold hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.gold hoe.Price")){
			storeconfig.set("Store.Tools.gold hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.gold pickaxe.Sell Able")){
			storeconfig.set("Store.Tools.gold pickaxe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.gold pickaxe.Price")){
			storeconfig.set("Store.Tools.gold pickaxe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.gold sword.Sell Able")){
			storeconfig.set("Store.Tools.gold sword.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.gold sword.Price")){
			storeconfig.set("Store.Tools.gold sword.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.gold spade.Sell Able")){
			storeconfig.set("Store.Tools.gold spade.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.gold spade.Price")){
			storeconfig.set("Store.Tools.gold spade.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.diamond axe.Sell Able")){
			storeconfig.set("Store.Tools.diamond axe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.diamond axe.Price")){
			storeconfig.set("Store.Tools.diamond axe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.diamond hoe.Sell Able")){
			storeconfig.set("Store.Tools.diamond hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.diamond hoe.Price")){
			storeconfig.set("Store.Tools.diamond hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.diamond pickaxe.Sell Able")){
			storeconfig.set("Store.Tools.diamond pickaxe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.diamond pickaxe.Price")){
			storeconfig.set("Store.Tools.diamond pickaxe.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.diamond sword.Sell Able")){
			storeconfig.set("Store.Tools.diamond sword.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.diamond sword.Price")){
			storeconfig.set("Store.Tools.diamond sword.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.diamond spade.Sell Able")){
			storeconfig.set("Store.Tools.diamond spade.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.diamond spade.Price")){
			storeconfig.set("Store.Tools.diamond spade.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.minecart.Sell Able")){
			storeconfig.set("Store.Tools.minecart.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.minecart.Price")){
			storeconfig.set("Store.Tools.minecart.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.powerd minecart.Sell Able")){
			storeconfig.set("Store.Tools.powerd minecart.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.powerd minecart.Price")){
			storeconfig.set("Store.Tools.powerd minecart.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.storage minecart.Sell Able")){
			storeconfig.set("Store.Tools.storage minecart.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.storage minecart.Price")){
			storeconfig.set("Store.Tools.storage minecart.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.compass.Sell Able")){
			storeconfig.set("Store.Tools.compass.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.compass.Price")){
			storeconfig.set("Store.Tools.compass.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.watch.Sell Able")){
			storeconfig.set("Store.Tools.watch.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.arrow.Price")){
			storeconfig.set("Store.Tools.arrow.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.arrow.Sell Able")){
			storeconfig.set("Store.Tools.arrow.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.arrow.Price")){
			storeconfig.set("Store.Tools.arrow.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.bucket.Sell Able")){
			storeconfig.set("Store.Tools.bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.bucket.Price")){
			storeconfig.set("Store.Tools.bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.water bucket.Sell Able")){
			storeconfig.set("Store.Tools.water bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.water bucket.Price")){
			storeconfig.set("Store.Tools.water bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.lava bucket.Sell Able")){
			storeconfig.set("Store.Tools.lava bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.lava bucket.Price")){
			storeconfig.set("Store.Tools.lava bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.milk bucket.Sell Able")){
			storeconfig.set("Store.Tools.milk bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.milk bucket.Price")){
			storeconfig.set("Store.Tools.milk bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.bow.Sell Able")){
			storeconfig.set("Store.Tools.bow.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.bow.Price")){
			storeconfig.set("Store.Tools.bow.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.boat.Sell Able")){
			storeconfig.set("Store.Tools.boat.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.boat.Price")){
			storeconfig.set("Store.Tools.boat.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.saddle.Sell Able")){
			storeconfig.set("Store.Tools.saddle.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.saddle.Price")){
			storeconfig.set("Store.Tools.saddle.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.fishing rod.Sell Able")){
			storeconfig.set("Store.Tools.fishing rod.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.fishing rod.Price")){
			storeconfig.set("Store.Tools.fishing rod.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.shears.Sell Able")){
			storeconfig.set("Store.Tools.shears.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.shears.Price")){
			storeconfig.set("Store.Tools.shears.Price",10);
		}
		
		if(!storeconfig.contains("Store.Tools.flint and steel.Sell Able")){
			storeconfig.set("Store.Tools.flint and steel.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.flint and steel.Price")){
			storeconfig.set("Store.Tools.flint and steel.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.bowl.Sell Able")){
			storeconfig.set("Store.Tools.bowl.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.bowl.Price")){
			storeconfig.set("Store.Tools.bowl.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.stick.Sell Able")){
			storeconfig.set("Store.Tools.stick.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.stick.Price")){
			storeconfig.set("Store.Tools.stick.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.snow ball.Sell Able")){
			storeconfig.set("Store.Tools.snow ball.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.snow ball.Price")){
			storeconfig.set("Store.Tools.snow ball.Price",10);
		}
		if(!storeconfig.contains("Store.Tools.map.Sell Able")){
			storeconfig.set("Store.Tools.map.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Tools.map.Price")){
			storeconfig.set("Store.Tools.map.Price",10);
		}
		
		//Armour
		
		if(!storeconfig.contains("Store.Armour.leather helmet.Sell Able")){
			storeconfig.set("Store.Armour.leather helmet.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.leather helmet.Price")){
			storeconfig.set("Store.Armour.leather helmet.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.leather chestplate.Sell Able")){
			storeconfig.set("Store.Armour.leather chestplate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.leather chestplate.Price")){
			storeconfig.set("Store.Armour.leather chestplate.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.leather leggings.Sell Able")){
			storeconfig.set("Store.Armour.leather leggings.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.leather leggings.Price")){
			storeconfig.set("Store.Armour.leather leggings.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.leather boots.Sell Able")){
			storeconfig.set("Store.Armour.leather boots.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.leather boots.Price")){
			storeconfig.set("Store.Armour.leather boots.Price",10);
		}
		
		if(!storeconfig.contains("Store.Armour.chainmail helmet.Sell Able")){
			storeconfig.set("Store.Armour.chainmail helmet.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.chainmail helmet.Price")){
			storeconfig.set("Store.Armour.chainmail helmet.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.chainmail chestplate.Sell Able")){
			storeconfig.set("Store.Armour.chainmail chestplate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.chainmail chestplate.Price")){
			storeconfig.set("Store.Armour.chainmail chestplate.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.chainmail leggings.Sell Able")){
			storeconfig.set("Store.Armour.chainmail leggings.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.chainmail leggings.Price")){
			storeconfig.set("Store.Armour.chainmail leggings.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.chainmail boots.Sell Able")){
			storeconfig.set("Store.Armour.chainmail boots.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.chainmail boots.Price")){
			storeconfig.set("Store.Armour.chainmail boots.Price",10);
		}
		
		if(!storeconfig.contains("Store.Armour.iron helmet.Sell Able")){
			storeconfig.set("Store.Armour.iron helmet.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.iron helmet.Price")){
			storeconfig.set("Store.Armour.iron helmet.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.iron chestplate.Sell Able")){
			storeconfig.set("Store.Armour.iron chestplate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.iron chestplate.Price")){
			storeconfig.set("Store.Armour.iron chestplate.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.iron leggings.Sell Able")){
			storeconfig.set("Store.Armour.iron leggings.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.iron leggings.Price")){
			storeconfig.set("Store.Armour.iron leggings.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.iron boots.Sell Able")){
			storeconfig.set("Store.Armour.iron boots.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.iron boots.Price")){
			storeconfig.set("Store.Armour.iron boots.Price",10);
		}
		
		if(!storeconfig.contains("Store.Armour.gold helmet.Sell Able")){
			storeconfig.set("Store.Armour.gold helmet.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.gold helmet.Price")){
			storeconfig.set("Store.Armour.gold helmet.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.gold chestplate.Sell Able")){
			storeconfig.set("Store.Armour.gold chestplate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.gold chestplate.Price")){
			storeconfig.set("Store.Armour.gold chestplate.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.gold leggings.Sell Able")){
			storeconfig.set("Store.Armour.gold leggings.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.gold leggings.Price")){
			storeconfig.set("Store.Armour.gold leggings.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.gold boots.Sell Able")){
			storeconfig.set("Store.Armour.gold boots.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.gold boots.Price")){
			storeconfig.set("Store.Armour.gold boots.Price",10);
		}
		
		if(!storeconfig.contains("Store.Armour.diamond helmet.Sell Able")){
			storeconfig.set("Store.Armour.diamond helmet.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.diamond helmet.Price")){
			storeconfig.set("Store.Armour.diamond helmet.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.diamond chestplate.Sell Able")){
			storeconfig.set("Store.Armour.diamond chestplate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.diamond chestplate.Price")){
			storeconfig.set("Store.Armour.diamond chestplate.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.diamond leggings.Sell Able")){
			storeconfig.set("Store.Armour.diamond leggings.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.diamond leggings.Price")){
			storeconfig.set("Store.Armour.diamond leggings.Price",10);
		}
		if(!storeconfig.contains("Store.Armour.diamond boots.Sell Able")){
			storeconfig.set("Store.Armour.diamond boots.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Armour.diamond boots.Price")){
			storeconfig.set("Store.Armour.diamond boots.Price",10);
		}
		
		//mechanisms
		
		if(!storeconfig.contains("Store.Mechanisms.Mechanisms.Sell Able")){
			storeconfig.set("Store.Mechanisms.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.Mechanisms.Price")){
			storeconfig.set("Store.Mechanisms.Mechanisms.Price",10);
		}
		
		//gardening
		
		if(!storeconfig.contains("Store.Gardening.Mechanisms.Sell Able")){
			storeconfig.set("Store.Gardening.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.Mechanisms.Price")){
			storeconfig.set("Store.Gardening.Mechanisms.Price",10);
		}
		
		//furniture
		
		if(!storeconfig.contains("Store.Furniture.Mechanisms.Sell Able")){
			storeconfig.set("Store.Furniture.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.Mechanisms.Price")){
			storeconfig.set("Store.Furniture.Mechanisms.Price",10);
		}
		
		//materials
		
		if(!storeconfig.contains("Store.Materials.Mechanisms.Sell Able")){
			storeconfig.set("Store.Materials.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.Mechanisms.Price")){
			storeconfig.set("Store.Materials.Mechanisms.Price",10);
		}
		
		//rawmaterials
		
		if(!storeconfig.contains("Store.Raw Materials.Mechanisms.Sell Able")){
			storeconfig.set("Store.Raw Materials.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.Mechanisms.Price")){
			storeconfig.set("Store.Raw Materials.Mechanisms.Price",10);
		}
		
		//minerals
		
		if(!storeconfig.contains("Store.Minerals.diamond block.Sell Able")){
			storeconfig.set("Store.Minerals.diamond block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.diamond block.Price")){
			storeconfig.set("Store.Minerals.diamond block.Price",10);
		}
		if(!storeconfig.contains("Store.Minerals.iron block.Sell Able")){
			storeconfig.set("Store.Minerals.iron block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.iron block.Price")){
			storeconfig.set("Store.Minerals.iron block.Price",10);
		}
		if(!storeconfig.contains("Store.Minerals.gold block.Sell Able")){
			storeconfig.set("Store.Minerals.gold block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.gold block.Price")){
			storeconfig.set("Store.Minerals.gold block.Price",10);
		}
		if(!storeconfig.contains("Store.Minerals.lapis block.Sell Able")){
			storeconfig.set("Store.Minerals.lapis block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.lapis block.Price")){
			storeconfig.set("Store.Minerals.lapis block.Price",10);
		}
		
		
		//ores
		
		if(!storeconfig.contains("Store.Ores.gold ore.Sell Able")){
			storeconfig.set("Store.Ores.gold ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.gold ore.Price")){
			storeconfig.set("Store.Ores.gold ore.Price",10);
		}
		if(!storeconfig.contains("Store.Ores.diamond ore.Sell Able")){
			storeconfig.set("Store.Ores.diamond ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.diamond ore.Price")){
			storeconfig.set("Store.Ores.diamond ore.Price",10);
		}
		if(!storeconfig.contains("Store.Ores.redstone ore.Sell Able")){
			storeconfig.set("Store.Ores.redstone ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.redstone ore.Price")){
			storeconfig.set("Store.Ores.redstone ore.Price",10);
		}
		if(!storeconfig.contains("Store.Ores.iron ore.Sell Able")){
			storeconfig.set("Store.Ores.iron ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.iron ore.Price")){
			storeconfig.set("Store.Ores.iron ore.Price",10);
		}
		if(!storeconfig.contains("Store.Ores.coal ore.Sell Able")){
			storeconfig.set("Store.Ores.coal ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.coal ore.Price")){
			storeconfig.set("Store.Ores.coal ore.Price",10);
		}
		if(!storeconfig.contains("Store.Ores.lapis ore.Sell Able")){
			storeconfig.set("Store.Ores.lapis ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.lapis ore.Price")){
			storeconfig.set("Store.Ores.lapis ore.Price",10);
		}
		
		//mobdrops
		
		if(!storeconfig.contains("Store.Mob Drops.Mechanisms.Sell Able")){
			storeconfig.set("Store.Mob Drops.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.Mechanisms.Price")){
			storeconfig.set("Store.Mob Drops.Mechanisms.Price",10);
		}
		
		//brewing
		
		if(!storeconfig.contains("Store.Brewing.Mechanisms.Sell Able")){
			storeconfig.set("Store.Brewing.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.Mechanisms.Price")){
			storeconfig.set("Store.Brewing.Mechanisms.Price",10);
		}
		
		//painting
	
		if(!storeconfig.contains("Store.Painting.Mechanisms.Sell Able")){
			storeconfig.set("Store.Painting.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Painting.Mechanisms.Price")){
			storeconfig.set("Store.Painting.Mechanisms.Price",10);
		}
		
		//nether
		
		if(!storeconfig.contains("Store.Nether.Mechanisms.Sell Able")){
			storeconfig.set("Store.Nether.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.Mechanisms.Price")){
			storeconfig.set("Store.Nether.Mechanisms.Price",10);
		}
		
		//music
		
		if(!storeconfig.contains("Store.Music.Mechanisms.Sell Able")){
			storeconfig.set("Store.Music.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.Mechanisms.Price")){
			storeconfig.set("Store.Music.Mechanisms.Price",10);
		}
		
		//misc
		
		if(!storeconfig.contains("Store.Misc.Mechanisms.Sell Able")){
			storeconfig.set("Store.Misc.Mechanisms.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Misc.Mechanisms.Price")){
			storeconfig.set("Store.Misc.Mechanisms.Price",10);
		}
		
		try {
			storeconfig.save("plugins/RpgEssentials/Store.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
