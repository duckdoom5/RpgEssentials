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
		
		if(!storeconfig.contains("Store.Mechanisms.redstone.Sell Able")){
			storeconfig.set("Store.Mechanisms.redstone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.redstone.Price")){
			storeconfig.set("Store.Mechanisms.redstone.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.diode.Sell Able")){
			storeconfig.set("Store.Mechanisms.diode.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.diode.Price")){
			storeconfig.set("Store.Mechanisms.diode.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.piston base.Sell Able")){
			storeconfig.set("Store.Mechanisms.piston base.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.piston base.Price")){
			storeconfig.set("Store.Mechanisms.piston base.Price",70);
		}
		if(!storeconfig.contains("Store.Mechanisms.piston sticky base.Sell Able")){
			storeconfig.set("Store.Mechanisms.piston sticky base.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.piston sticky base.Price")){
			storeconfig.set("Store.Mechanisms.piston sticky base.Price",100);
		}
		if(!storeconfig.contains("Store.Mechanisms.lever.Sell Able")){
			storeconfig.set("Store.Mechanisms.lever.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.lever.Price")){
			storeconfig.set("Store.Mechanisms.lever.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.wood plate.Sell Able")){
			storeconfig.set("Store.Mechanisms.wood plate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.wood plate.Price")){
			storeconfig.set("Store.Mechanisms.wood plate.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.stone plate.Sell Able")){
			storeconfig.set("Store.Mechanisms.stone plate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.stone plate.Price")){
			storeconfig.set("Store.Mechanisms.stone plate.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.note block.Sell Able")){
			storeconfig.set("Store.Mechanisms.note block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.note block.Price")){
			storeconfig.set("Store.Mechanisms.note block.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.detector rail.Sell Able")){
			storeconfig.set("Store.Mechanisms.detector rail.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.detector rail.Price")){
			storeconfig.set("Store.Mechanisms.detector rail.Price",40);
		}
		if(!storeconfig.contains("Store.Mechanisms.redstone torch off.Sell Able")){
			storeconfig.set("Store.Mechanisms.redstone torch off.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.redstone torch off.Price")){
			storeconfig.set("Store.Mechanisms.redstone torch off.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.powered rail.Sell Able")){
			storeconfig.set("Store.Mechanisms.powered rail.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.powered rail.Price")){
			storeconfig.set("Store.Mechanisms.powered rail.Price",60);
		}
		if(!storeconfig.contains("Store.Mechanisms.rails.Sell Able")){
			storeconfig.set("Store.Mechanisms.rails.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.rails.Price")){
			storeconfig.set("Store.Mechanisms.rails.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.wood door.Sell Able")){
			storeconfig.set("Store.Mechanisms.wood door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.wood door.Price")){
			storeconfig.set("Store.Mechanisms.wood door.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.iron door.Sell Able")){
			storeconfig.set("Store.Mechanisms.iron door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.iron door.Price")){
			storeconfig.set("Store.Mechanisms.iron door.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.dispenser.Sell Able")){
			storeconfig.set("Store.Mechanisms.dispenser.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.dispenser.Price")){
			storeconfig.set("Store.Mechanisms.dispenser.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.stone button.Sell Able")){
			storeconfig.set("Store.Mechanisms.stone button.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.stone button.Price")){
			storeconfig.set("Store.Mechanisms.stone button.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.trap door.Sell Able")){
			storeconfig.set("Store.Mechanisms.trap door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.trap door.Price")){
			storeconfig.set("Store.Mechanisms.trap door.Price",10);
		}
		if(!storeconfig.contains("Store.Mechanisms.tnt.Sell Able")){
			storeconfig.set("Store.Mechanisms.tnt.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mechanisms.tnt.Price")){
			storeconfig.set("Store.Mechanisms.tnt.Price",150);
		}
		
		//gardening
		
		if(!storeconfig.contains("Store.Gardening.wood hoe.Sell Able")){
			storeconfig.set("Store.Gardening.wood hoe.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.wood hoe.Price")){
			storeconfig.set("Store.Gardening.wood hoe.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.bucket.Sell Able")){
			storeconfig.set("Store.Gardening.bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.bucket.Price")){
			storeconfig.set("Store.Gardening.bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.water bucket.Sell Able")){
			storeconfig.set("Store.Gardening.water bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.water bucket.Price")){
			storeconfig.set("Store.Gardening.water bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.brown mushroom.Sell Able")){
			storeconfig.set("Store.Gardening.brown mushroom.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.brown mushroom.Price")){
			storeconfig.set("Store.Gardening.brown mushroom.Price",30);
		}
		if(!storeconfig.contains("Store.Gardening.red mushroom.Sell Able")){
			storeconfig.set("Store.Gardening.red mushroom.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.red mushroom.Price")){
			storeconfig.set("Store.Gardening.red mushroom.Price",50);
		}
		if(!storeconfig.contains("Store.Gardening.red rose.Sell Able")){
			storeconfig.set("Store.Gardening.red rose.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.red rose.Price")){
			storeconfig.set("Store.Gardening.red rose.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.yellow flower.Sell Able")){
			storeconfig.set("Store.Gardening.yellow flower.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.yellow flower.Price")){
			storeconfig.set("Store.Gardening.yellow flower.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.cactus.Sell Able")){
			storeconfig.set("Store.Gardening.cactus.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.cactus.Price")){
			storeconfig.set("Store.Gardening.cactus.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.sapling.Sell Able")){
			storeconfig.set("Store.Gardening.sapling.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.sapling.Price")){
			storeconfig.set("Store.Gardening.sapling.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.seeds.Sell Able")){
			storeconfig.set("Store.Gardening.seeds.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.seeds.Price")){
			storeconfig.set("Store.Gardening.seeds.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.sugar cane.Sell Able")){
			storeconfig.set("Store.Gardening.sugar cane.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.sugar cane.Price")){
			storeconfig.set("Store.Gardening.sugar cane.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.wheat.Sell Able")){
			storeconfig.set("Store.Gardening.wheat.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.wheat.Price")){
			storeconfig.set("Store.Gardening.wheat.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.melon seeds.Sell Able")){
			storeconfig.set("Store.Gardening.melon seeds.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.melon seeds.Price")){
			storeconfig.set("Store.Gardening.melon seeds.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.melon block.Sell Able")){
			storeconfig.set("Store.Gardening.melon block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.melon block.Price")){
			storeconfig.set("Store.Gardening.melon block.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.pumpkin seeds.Sell Able")){
			storeconfig.set("Store.Gardening.pumpkin seeds.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.pumpkin seeds.Price")){
			storeconfig.set("Store.Gardening.pumpkin seeds.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.pumpkin.Sell Able")){
			storeconfig.set("Store.Gardening.pumpkin.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.pumpkin.Price")){
			storeconfig.set("Store.Gardening.pumpkin.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.soil.Sell Able")){
			storeconfig.set("Store.Gardening.soil.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.soil.Price")){
			storeconfig.set("Store.Gardening.soil.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.long grass.Sell Able")){
			storeconfig.set("Store.Gardening.long grass.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.long grass.Price")){
			storeconfig.set("Store.Gardening.long grass.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.dead bush.Sell Able")){
			storeconfig.set("Store.Gardening.dead bush.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.dead bush.Price")){
			storeconfig.set("Store.Gardening.dead bush.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.vine.Sell Able")){
			storeconfig.set("Store.Gardening.vine.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.vine.Price")){
			storeconfig.set("Store.Gardening.vine.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.water lily.Sell Able")){
			storeconfig.set("Store.Gardening.water lily.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.water lily.Price")){
			storeconfig.set("Store.Gardening.water lily.Price",10);
		}
		if(!storeconfig.contains("Store.Gardening.nether warts.Sell Able")){
			storeconfig.set("Store.Gardening.nether warts.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Gardening.nether warts.Price")){
			storeconfig.set("Store.Gardening.nether warts.Price",10);
		}
		
		//furniture
		
		if(!storeconfig.contains("Store.Furniture.bed.Sell Able")){
			storeconfig.set("Store.Furniture.bed.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.bed.Price")){
			storeconfig.set("Store.Furniture.bed.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.bookshelf.Sell Able")){
			storeconfig.set("Store.Furniture.bookshelf.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.bookshelf.Price")){
			storeconfig.set("Store.Furniture.bookshelf.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.brewing stand item.Sell Able")){
			storeconfig.set("Store.Furniture.brewing stand item.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.brewing stand item.Price")){
			storeconfig.set("Store.Furniture.brewing stand item.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.brick stairs.Sell Able")){
			storeconfig.set("Store.Furniture.brick stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.brick stairs.Price")){
			storeconfig.set("Store.Furniture.brick stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.cauldron item.Sell Able")){
			storeconfig.set("Store.Furniture.cauldron item.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.cauldron item.Price")){
			storeconfig.set("Store.Furniture.cauldron item.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.workbench.Sell Able")){
			storeconfig.set("Store.Furniture.workbench.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.workbench.Price")){
			storeconfig.set("Store.Furniture.workbench.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.chest.Sell Able")){
			storeconfig.set("Store.Furniture.chest.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.chest.Price")){
			storeconfig.set("Store.Furniture.chest.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.cobblestone stairs.Sell Able")){
			storeconfig.set("Store.Furniture.cobblestone stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.cobblestone stairs.Price")){
			storeconfig.set("Store.Furniture.cobblestone stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.dispenser.Sell Able")){
			storeconfig.set("Store.Furniture.dispenser.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.dispenser.Price")){
			storeconfig.set("Store.Furniture.dispenser.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.enchantment table.Sell Able")){
			storeconfig.set("Store.Furniture.enchantment table.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.enchantment table.Price")){
			storeconfig.set("Store.Furniture.enchantment table.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.fence.Sell Able")){
			storeconfig.set("Store.Furniture.fence.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.fence.Price")){
			storeconfig.set("Store.Furniture.fence.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.fence gate.Sell Able")){
			storeconfig.set("Store.Furniture.fence gate.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.fence gate.Price")){
			storeconfig.set("Store.Furniture.fence gate.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.furnace.Sell Able")){
			storeconfig.set("Store.Furniture.furnace.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.furnace.Price")){
			storeconfig.set("Store.Furniture.furnace.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.jukebox.Sell Able")){
			storeconfig.set("Store.Furniture.jukebox.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.jukebox.Price")){
			storeconfig.set("Store.Furniture.jukebox.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.jack o lantern.Sell Able")){
			storeconfig.set("Store.Furniture.jack o lantern.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.jack o lantern.Price")){
			storeconfig.set("Store.Furniture.jack o lantern.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.ladder.Sell Able")){
			storeconfig.set("Store.Furniture.ladder.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.ladder.Price")){
			storeconfig.set("Store.Furniture.ladder.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.nether brick stairs.Sell Able")){
			storeconfig.set("Store.Furniture.nether brick stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.nether brick stairs.Price")){
			storeconfig.set("Store.Furniture.nether brick stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.nether fence.Sell Able")){
			storeconfig.set("Store.Furniture.nether fence.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.nether fence.Price")){
			storeconfig.set("Store.Furniture.nether fence.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.note block.Sell Able")){
			storeconfig.set("Store.Furniture.note block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.note block.Price")){
			storeconfig.set("Store.Furniture.note block.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.painting.Sell Able")){
			storeconfig.set("Store.Furniture.painting.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.painting.Price")){
			storeconfig.set("Store.Furniture.painting.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.sign.Sell Able")){
			storeconfig.set("Store.Furniture.sign.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.sign.Price")){
			storeconfig.set("Store.Furniture.sign.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.wood door.Sell Able")){
			storeconfig.set("Store.Furniture.wood door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.wood door.Price")){
			storeconfig.set("Store.Furniture.wood door.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.iron door.Sell Able")){
			storeconfig.set("Store.Furniture.iron door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.iron door.Price")){
			storeconfig.set("Store.Furniture.iron door.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.torch.Sell Able")){
			storeconfig.set("Store.Furniture.torch.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.torch.Price")){
			storeconfig.set("Store.Furniture.torch.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.trap door.Sell Able")){
			storeconfig.set("Store.Furniture.trap door.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.trap door.Price")){
			storeconfig.set("Store.Furniture.trap door.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.wood stairs.Sell Able")){
			storeconfig.set("Store.Furniture.wood stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.wood stairs.Price")){
			storeconfig.set("Store.Furniture.wood stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.smooth stairs.Sell Able")){
			storeconfig.set("Store.Furniture.smooth stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.smooth stairs.Price")){
			storeconfig.set("Store.Furniture.smooth stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.iron fence.Sell Able")){
			storeconfig.set("Store.Furniture.iron fence.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.iron fence.Price")){
			storeconfig.set("Store.Furniture.iron fence.Price",10);
		}
		if(!storeconfig.contains("Store.Furniture.thin glass.Sell Able")){
			storeconfig.set("Store.Furniture.thin glass.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Furniture.thin glass.Price")){
			storeconfig.set("Store.Furniture.thin glass.Price",10);
		}
		
		
		//materials
		
		if(!storeconfig.contains("Store.Materials.stone.Sell Able")){
			storeconfig.set("Store.Materials.stone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.stone.Price")){
			storeconfig.set("Store.Materials.stone.Price",10);
		}
		if(!storeconfig.contains("Store.Materials.grass.Sell Able")){
			storeconfig.set("Store.Materials.grass.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.grass.Price")){
			storeconfig.set("Store.Materials.grass.Price",30);
		}
		if(!storeconfig.contains("Store.Materials.dirt.Sell Able")){
			storeconfig.set("Store.Materials.dirt.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.dirt.Price")){
			storeconfig.set("Store.Materials.dirt.Price",5);
		}
		if(!storeconfig.contains("Store.Materials.cobblestone.Sell Able")){
			storeconfig.set("Store.Materials.cobblestone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.cobblestone.Price")){
			storeconfig.set("Store.Materials.cobblestone.Price",5);
		}
		if(!storeconfig.contains("Store.Materials.wood.Sell Able")){
			storeconfig.set("Store.Materials.wood.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.wood.Price")){
			storeconfig.set("Store.Materials.wood.Price",10);
		}
		if(!storeconfig.contains("Store.Materials.bedrock.Sell Able")){
			storeconfig.set("Store.Materials.bedrock.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.bedrock.Price")){
			storeconfig.set("Store.Materials.bedrock.Price",10000);
		}
		if(!storeconfig.contains("Store.Materials.water.Sell Able")){
			storeconfig.set("Store.Materials.water.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.water.Price")){
			storeconfig.set("Store.Materials.water.Price",100);
		}
		if(!storeconfig.contains("Store.Materials.stationary water.Sell Able")){
			storeconfig.set("Store.Materials.stationary water.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.stationary water.Price")){
			storeconfig.set("Store.Materials.stationary water.Price",200);
		}
		if(!storeconfig.contains("Store.Materials.lava.Sell Able")){
			storeconfig.set("Store.Materials.lava.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.lava.Price")){
			storeconfig.set("Store.Materials.lava.Price",100);
		}
		if(!storeconfig.contains("Store.Materials.stationary lava.Sell Able")){
			storeconfig.set("Store.Materials.stationary lava.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.stationary lava.Price")){
			storeconfig.set("Store.Materials.stationary lava.Price",200);
		}
		if(!storeconfig.contains("Store.Materials.sand.Sell Able")){
			storeconfig.set("Store.Materials.sand.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.sand.Price")){
			storeconfig.set("Store.Materials.sand.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.gravel.Sell Able")){
			storeconfig.set("Store.Materials.gravel.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.gravel.Price")){
			storeconfig.set("Store.Materials.gravel.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.log.Sell Able")){
			storeconfig.set("Store.Materials.log.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.log.Price")){
			storeconfig.set("Store.Materials.log.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.leaves.Sell Able")){
			storeconfig.set("Store.Materials.leaves.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.leaves.Price")){
			storeconfig.set("Store.Materials.leaves.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.sponge.Sell Able")){
			storeconfig.set("Store.Materials.sponge.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.sponge.Price")){
			storeconfig.set("Store.Materials.sponge.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.glass.Sell Able")){
			storeconfig.set("Store.Materials.glass.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.glass.Price")){
			storeconfig.set("Store.Materials.glass.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.sandstone.Sell Able")){
			storeconfig.set("Store.Materials.sandstone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.sandstone.Price")){
			storeconfig.set("Store.Materials.sandstone.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.double step.Sell Able")){
			storeconfig.set("Store.Materials.double step.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.double step.Price")){
			storeconfig.set("Store.Materials.double step.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.step.Sell Able")){
			storeconfig.set("Store.Materials.step.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.step.Price")){
			storeconfig.set("Store.Materials.step.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.brick.Sell Able")){
			storeconfig.set("Store.Materials.brick.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.brick.Price")){
			storeconfig.set("Store.Materials.brick.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.mossy cobblestone.Sell Able")){
			storeconfig.set("Store.Materials.mossy cobblestone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.mossy cobblestone.Price")){
			storeconfig.set("Store.Materials.mossy cobblestone.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.obsidian.Sell Able")){
			storeconfig.set("Store.Materials.obsidian.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.obsidian.Price")){
			storeconfig.set("Store.Materials.obsidian.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.snow.Sell Able")){
			storeconfig.set("Store.Materials.snow.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.snow.Price")){
			storeconfig.set("Store.Materials.snow.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.ice.Sell Able")){
			storeconfig.set("Store.Materials.ice.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.ice.Price")){
			storeconfig.set("Store.Materials.ice.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.snow block.Sell Able")){
			storeconfig.set("Store.Materials.snow block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.snow block.Price")){
			storeconfig.set("Store.Materials.snow block.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.clay.Sell Able")){
			storeconfig.set("Store.Materials.clay.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.clay.Price")){
			storeconfig.set("Store.Materials.clay.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.smooth brick.Sell Able")){
			storeconfig.set("Store.Materials.smooth brick.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.smooth brick.Price")){
			storeconfig.set("Store.Materials.smooth brick.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.mycel.Sell Able")){
			storeconfig.set("Store.Materials.mycel.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.mycel.Price")){
			storeconfig.set("Store.Materials.mycel.Price",15);
		}
		if(!storeconfig.contains("Store.Materials.ender stone.Sell Able")){
			storeconfig.set("Store.Materials.ender stone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Materials.ender stone.Price")){
			storeconfig.set("Store.Materials.ender stone.Price",15);
		}
		
		
		//rawmaterials
		
		if(!storeconfig.contains("Store.Raw Materials.coal.Sell Able")){
			storeconfig.set("Store.Raw Materials.coal.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.coal.Price")){
			storeconfig.set("Store.Raw Materials.coal.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.iron ingot.Sell Able")){
			storeconfig.set("Store.Raw Materials.iron ingot.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.iron ingot.Price")){
			storeconfig.set("Store.Raw Materials.iron ingot.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.gold ingot.Sell Able")){
			storeconfig.set("Store.Raw Materials.gold ingot.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.gold ingot.Price")){
			storeconfig.set("Store.Raw Materials.gold ingot.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.diamond.Sell Able")){
			storeconfig.set("Store.Raw Materials.diamond.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.diamond.Price")){
			storeconfig.set("Store.Raw Materials.diamond.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.clay ball.Sell Able")){
			storeconfig.set("Store.Raw Materials.clay ball.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.clay ball.Price")){
			storeconfig.set("Store.Raw Materials.clay ball.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.clay brick.Sell Able")){
			storeconfig.set("Store.Raw Materials.clay brick.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.clay brick.Price")){
			storeconfig.set("Store.Raw Materials.clay brick.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.glowstone dust.Sell Able")){
			storeconfig.set("Store.Raw Materials.glowstone dust.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.glowstone dust.Price")){
			storeconfig.set("Store.Raw Materials.glowstone dust.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.flint.Sell Able")){
			storeconfig.set("Store.Raw Materials.flint.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.flint.Price")){
			storeconfig.set("Store.Raw Materials.flint.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.paper.Sell Able")){
			storeconfig.set("Store.Raw Materials.paper.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.paper.Price")){
			storeconfig.set("Store.Raw Materials.paper.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.book.Sell Able")){
			storeconfig.set("Store.Raw Materials.book.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.book.Price")){
			storeconfig.set("Store.Raw Materials.book.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.snow ball.Sell Able")){
			storeconfig.set("Store.Raw Materials.snow ball.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.snow ball.Price")){
			storeconfig.set("Store.Raw Materials.snow ball.Price",10);
		}
		if(!storeconfig.contains("Store.Raw Materials.sugar.Sell Able")){
			storeconfig.set("Store.Raw Materials.sugar.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Raw Materials.sugar.Price")){
			storeconfig.set("Store.Raw Materials.sugar.Price",10);
		}
		
		//minerals
		
		if(!storeconfig.contains("Store.Minerals.diamond block.Sell Able")){
			storeconfig.set("Store.Minerals.diamond block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.diamond block.Price")){
			storeconfig.set("Store.Minerals.diamond block.Price",17500);
		}
		if(!storeconfig.contains("Store.Minerals.iron block.Sell Able")){
			storeconfig.set("Store.Minerals.iron block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.iron block.Price")){
			storeconfig.set("Store.Minerals.iron block.Price",2250);
		}
		if(!storeconfig.contains("Store.Minerals.gold block.Sell Able")){
			storeconfig.set("Store.Minerals.gold block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.gold block.Price")){
			storeconfig.set("Store.Minerals.gold block.Price",4500);
		}
		if(!storeconfig.contains("Store.Minerals.lapis block.Sell Able")){
			storeconfig.set("Store.Minerals.lapis block.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Minerals.lapis block.Price")){
			storeconfig.set("Store.Minerals.lapis block.Price",1000);
		}
		
		
		//ores
		
		if(!storeconfig.contains("Store.Ores.gold ore.Sell Able")){
			storeconfig.set("Store.Ores.gold ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.gold ore.Price")){
			storeconfig.set("Store.Ores.gold ore.Price",500);
		}
		if(!storeconfig.contains("Store.Ores.diamond ore.Sell Able")){
			storeconfig.set("Store.Ores.diamond ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.diamond ore.Price")){
			storeconfig.set("Store.Ores.diamond ore.Price",2000);
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
			storeconfig.set("Store.Ores.iron ore.Price",250);
		}
		if(!storeconfig.contains("Store.Ores.coal ore.Sell Able")){
			storeconfig.set("Store.Ores.coal ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.coal ore.Price")){
			storeconfig.set("Store.Ores.coal ore.Price",100);
		}
		if(!storeconfig.contains("Store.Ores.lapis ore.Sell Able")){
			storeconfig.set("Store.Ores.lapis ore.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Ores.lapis ore.Price")){
			storeconfig.set("Store.Ores.lapis ore.Price",150);
		}
		
		//mobdrops
		
		if(!storeconfig.contains("Store.Mob Drops.string.Sell Able")){
			storeconfig.set("Store.Mob Drops.string.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.string.Price")){
			storeconfig.set("Store.Mob Drops.string.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.leather.Sell Able")){
			storeconfig.set("Store.Mob Drops.leather.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.leather.Price")){
			storeconfig.set("Store.Mob Drops.leather.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.feather.Sell Able")){
			storeconfig.set("Store.Mob Drops.feather.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.feather.Price")){
			storeconfig.set("Store.Mob Drops.feather.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.arrow.Sell Able")){
			storeconfig.set("Store.Mob Drops.arrow.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.arrow.Price")){
			storeconfig.set("Store.Mob Drops.arrow.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.egg.Sell Able")){
			storeconfig.set("Store.Mob Drops.egg.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.egg.Price")){
			storeconfig.set("Store.Mob Drops.egg.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.blaze rod.Sell Able")){
			storeconfig.set("Store.Mob Drops.blaze rod.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.blaze rod.Price")){
			storeconfig.set("Store.Mob Drops.blaze rod.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.ghast tear.Sell Able")){
			storeconfig.set("Store.Mob Drops.ghast tear.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.ghast tear.Price")){
			storeconfig.set("Store.Mob Drops.ghast tear.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.gold nugget.Sell Able")){
			storeconfig.set("Store.Mob Drops.gold nugget.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.gold nugget.Price")){
			storeconfig.set("Store.Mob Drops.gold nugget.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.rotten flesh.Sell Able")){
			storeconfig.set("Store.Mob Drops.rotten flesh.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.rotten flesh.Price")){
			storeconfig.set("Store.Mob Drops.rotten flesh.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.bone.Sell Able")){
			storeconfig.set("Store.Mob Drops.bone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.bone.Price")){
			storeconfig.set("Store.Mob Drops.bone.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.sulphur.Sell Able")){
			storeconfig.set("Store.Mob Drops.sulphur.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.sulphur.Price")){
			storeconfig.set("Store.Mob Drops.sulphur.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.spider eye.Sell Able")){
			storeconfig.set("Store.Mob Drops.spider eye.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.spider eye.Price")){
			storeconfig.set("Store.Mob Drops.spider eye.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.ender pearl.Sell Able")){
			storeconfig.set("Store.Mob Drops.ender pearl.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.ender pearl.Price")){
			storeconfig.set("Store.Mob Drops.ender pearl.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.slime ball.Sell Able")){
			storeconfig.set("Store.Mob Drops.slime ball.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.slime ball.Price")){
			storeconfig.set("Store.Mob Drops.slime ball.Price",10);
		}
		if(!storeconfig.contains("Store.Mob Drops.magma cream.Sell Able")){
			storeconfig.set("Store.Mob Drops.magma cream.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Mob Drops.magma cream.Price")){
			storeconfig.set("Store.Mob Drops.magma cream.Price",10);
		}
		
		//brewing
		
		if(!storeconfig.contains("Store.Brewing.brewing stand item.Sell Able")){
			storeconfig.set("Store.Brewing.brewing stand item.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.brewing stand item.Price")){
			storeconfig.set("Store.Brewing.brewing stand item.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.cauldron item.Sell Able")){
			storeconfig.set("Store.Brewing.cauldron item.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.cauldron item.Price")){
			storeconfig.set("Store.Brewing.cauldron item.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.water bucket.Sell Able")){
			storeconfig.set("Store.Brewing.water bucket.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.water bucket.Price")){
			storeconfig.set("Store.Brewing.water bucket.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.blaze powder.Sell Able")){
			storeconfig.set("Store.Brewing.blaze powder.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.blaze powder.Price")){
			storeconfig.set("Store.Brewing.blaze powder.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.nether warts.Sell Able")){
			storeconfig.set("Store.Brewing.nether warts.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.nether warts.Price")){
			storeconfig.set("Store.Brewing.nether warts.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.potion.Sell Able")){
			storeconfig.set("Store.Brewing.potion.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.potion.Price")){
			storeconfig.set("Store.Brewing.potion.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.glass bottle.Sell Able")){
			storeconfig.set("Store.Brewing.glass bottle.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.glass bottle.Price")){
			storeconfig.set("Store.Brewing.glass bottle.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.fermented spider eye.Sell Able")){
			storeconfig.set("Store.Brewing.fermented spider eye.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.fermented spider eye.Price")){
			storeconfig.set("Store.Brewing.fermented spider eye.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.magma cream.Sell Able")){
			storeconfig.set("Store.Brewing.magma cream.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.magma cream.Price")){
			storeconfig.set("Store.Brewing.magma cream.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.glowstone dust.Sell Able")){
			storeconfig.set("Store.Brewing.glowstone dust.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.glowstone dust.Price")){
			storeconfig.set("Store.Brewing.glowstone dust.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.redstone.Sell Able")){
			storeconfig.set("Store.Brewing.redstone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.redstone.Price")){
			storeconfig.set("Store.Brewing.redstone.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.sugar.Sell Able")){
			storeconfig.set("Store.Brewing.sugar.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.sugar.Price")){
			storeconfig.set("Store.Brewing.sugar.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.speckled melon.Sell Able")){
			storeconfig.set("Store.Brewing.speckled melon.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.speckled melon.Price")){
			storeconfig.set("Store.Brewing.speckled melon.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.ghast tear.Sell Able")){
			storeconfig.set("Store.Brewing.ghast tear.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.ghast tear.Price")){
			storeconfig.set("Store.Brewing.ghast tear.Price",10);
		}
		if(!storeconfig.contains("Store.Brewing.sulphur.Sell Able")){
			storeconfig.set("Store.Brewing.sulphur.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Brewing.sulphur.Price")){
			storeconfig.set("Store.Brewing.sulphur.Price",10);
		}
		
		//painting
	
		if(!storeconfig.contains("Store.Painting.wool.Sell Able")){
			storeconfig.set("Store.Painting.wool.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Painting.wool.Price")){
			storeconfig.set("Store.Painting.wool.Price",10);
		}
		if(!storeconfig.contains("Store.Painting.ink sack.Sell Able")){
			storeconfig.set("Store.Painting.ink sack.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Painting.ink sack.Price")){
			storeconfig.set("Store.Painting.ink sack.Price",10);
		}
		
		//nether
		
		if(!storeconfig.contains("Store.Nether.netherrack.Sell Able")){
			storeconfig.set("Store.Nether.netherrack.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.netherrack.Price")){
			storeconfig.set("Store.Nether.netherrack.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.nether brick.Sell Able")){
			storeconfig.set("Store.Nether.nether brick.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.nether brick.Price")){
			storeconfig.set("Store.Nether.nether brick.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.nether brick stairs.Sell Able")){
			storeconfig.set("Store.Nether.nether brick stairs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.nether brick stairs.Price")){
			storeconfig.set("Store.Nether.nether brick stairs.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.nether fence.Sell Able")){
			storeconfig.set("Store.Nether.nether fence.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.nether fence.Price")){
			storeconfig.set("Store.Nether.nether fence.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.nether stalk.Sell Able")){
			storeconfig.set("Store.Nether.nether stalk.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.nether stalk.Price")){
			storeconfig.set("Store.Nether.nether stalk.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.nether warts.Sell Able")){
			storeconfig.set("Store.Nether.nether warts.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.nether warts.Price")){
			storeconfig.set("Store.Nether.nether warts.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.blaze rod.Sell Able")){
			storeconfig.set("Store.Nether.blaze rod.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.blaze rod.Price")){
			storeconfig.set("Store.Nether.blaze rod.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.ghast tear.Sell Able")){
			storeconfig.set("Store.Nether.ghast tear.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.ghast tear.Price")){
			storeconfig.set("Store.Nether.ghast tear.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.gold nugget.Sell Able")){
			storeconfig.set("Store.Nether.gold nugget.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.gold nugget.Price")){
			storeconfig.set("Store.Nether.gold nugget.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.soul sand.Sell Able")){
			storeconfig.set("Store.Nether.soul sand.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.soul sand.Price")){
			storeconfig.set("Store.Nether.soul sand.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.glowstone dust.Sell Able")){
			storeconfig.set("Store.Nether.glowstone dust.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.glowstone dust.Price")){
			storeconfig.set("Store.Nether.glowstone dust.Price",10);
		}
		if(!storeconfig.contains("Store.Nether.glowstone.Sell Able")){
			storeconfig.set("Store.Nether.glowstone.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Nether.glowstone.Price")){
			storeconfig.set("Store.Nether.glowstone.Price",10);
		}
		
		//music
		
		if(!storeconfig.contains("Store.Music.jukebox.Sell Able")){
			storeconfig.set("Store.Music.jukebox.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.jukebox.Price")){
			storeconfig.set("Store.Music.jukebox.Price",10);
		}
		if(!storeconfig.contains("Store.Music.gold record.Sell Able")){
			storeconfig.set("Store.Music.gold record.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.gold record.Price")){
			storeconfig.set("Store.Music.gold record.Price",10);
		}
		if(!storeconfig.contains("Store.Music.green record.Sell Able")){
			storeconfig.set("Store.Music.green record.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.green record.Price")){
			storeconfig.set("Store.Music.green record.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 3.Sell Able")){
			storeconfig.set("Store.Music.record 3.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 3.Price")){
			storeconfig.set("Store.Music.record 3.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 4.Sell Able")){
			storeconfig.set("Store.Music.record 4.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 4.Price")){
			storeconfig.set("Store.Music.record 4.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 5.Sell Able")){
			storeconfig.set("Store.Music.record 5.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 5.Price")){
			storeconfig.set("Store.Music.record 5.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 6.Sell Able")){
			storeconfig.set("Store.Music.record 6.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 6.Price")){
			storeconfig.set("Store.Music.record 6.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 7.Sell Able")){
			storeconfig.set("Store.Music.record 7.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 7.Price")){
			storeconfig.set("Store.Music.record 7.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 8.Sell Able")){
			storeconfig.set("Store.Music.record 8.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 8.Price")){
			storeconfig.set("Store.Music.record 8.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 9.Sell Able")){
			storeconfig.set("Store.Music.record 9.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 9.Price")){
			storeconfig.set("Store.Music.record 9.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 10.Sell Able")){
			storeconfig.set("Store.Music.record 10.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 10.Price")){
			storeconfig.set("Store.Music.record 10.Price",10);
		}
		if(!storeconfig.contains("Store.Music.record 11.Sell Able")){
			storeconfig.set("Store.Music.record 11.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Music.record 11.Price")){
			storeconfig.set("Store.Music.record 11.Price",10);
		}
		
		//misc
		
		if(!storeconfig.contains("Store.Miscellaneous.web.Sell Able")){
			storeconfig.set("Store.Miscellaneous.web.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.web.Price")){
			storeconfig.set("Store.Miscellaneous.web.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.fire.Sell Able")){
			storeconfig.set("Store.Miscellaneous.fire.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.fire.Price")){
			storeconfig.set("Store.Miscellaneous.fire.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.portal.Sell Able")){
			storeconfig.set("Store.Miscellaneous.portal.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.portal.Price")){
			storeconfig.set("Store.Miscellaneous.portal.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.ender portal frame.Sell Able")){
			storeconfig.set("Store.Miscellaneous.ender portal frame.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.ender portal frame.Price")){
			storeconfig.set("Store.Miscellaneous.ender portal frame.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.dragon egg.Sell Able")){
			storeconfig.set("Store.Miscellaneous.dragon egg.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.dragon egg.Price")){
			storeconfig.set("Store.Miscellaneous.dragon egg.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.monster egg.Sell Able")){
			storeconfig.set("Store.Miscellaneous.monster egg.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.monster egg.Price")){
			storeconfig.set("Store.Miscellaneous.monster egg.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.monster eggs.Sell Able")){
			storeconfig.set("Store.Miscellaneous.monster eggs.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.monster eggs.Price")){
			storeconfig.set("Store.Miscellaneous.monster eggs.Price",10);
		}
		if(!storeconfig.contains("Store.Miscellaneous.mob spawner.Sell Able")){
			storeconfig.set("Store.Miscellaneous.mob spawner.Sell Able",true);
		}
		if(!storeconfig.contains("Store.Miscellaneous.mob spawner.Price")){
			storeconfig.set("Store.Miscellaneous.mob spawner.Price",10);
		}
		
		try {
			storeconfig.save("plugins/RpgEssentials/Store.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
