package me.duckdoom5.RpgEssentials.config;

public class StoreConfig {
	
	public static void set(){
		//general
		if(!Configuration.store.contains("Store.Currency")){
			Configuration.store.set("Store.Currency","Dollar");
		}
		
		//food
		if(!Configuration.store.contains("Store.Food.apple.Sell Able")){
			Configuration.store.set("Store.Food.apple.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.apple.Price")){
			Configuration.store.set("Store.Food.apple.Price",15);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Sell Able")){
			Configuration.store.set("Store.Food.golden apple.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.golden apple.Price")){
			Configuration.store.set("Store.Food.golden apple.Price",50);
		}
		if(!Configuration.store.contains("Store.Food.bread.Sell Able")){
			Configuration.store.set("Store.Food.bread.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.bread.Price")){
			Configuration.store.set("Store.Food.bread.Price",10);
		}
		if(!Configuration.store.contains("Store.Food.cake.Sell Able")){
			Configuration.store.set("Store.Food.cake.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cake.Price")){
			Configuration.store.set("Store.Food.cake.Price",60);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Sell Able")){
			Configuration.store.set("Store.Food.raw beef.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw beef.Price")){
			Configuration.store.set("Store.Food.raw beef.Price",20);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Sell Able")){
			Configuration.store.set("Store.Food.cooked beef.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked beef.Price")){
			Configuration.store.set("Store.Food.cooked beef.Price",40);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Sell Able")){
			Configuration.store.set("Store.Food.raw chicken.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw chicken.Price")){
			Configuration.store.set("Store.Food.raw chicken.Price",15);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Sell Able")){
			Configuration.store.set("Store.Food.cooked chicken.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked chicken.Price")){
			Configuration.store.set("Store.Food.cooked chicken.Price",25);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Sell Able")){
			Configuration.store.set("Store.Food.raw fish.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.raw fish.Price")){
			Configuration.store.set("Store.Food.raw fish.Price",20);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Sell Able")){
			Configuration.store.set("Store.Food.cooked fish.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cooked fish.Price")){
			Configuration.store.set("Store.Food.cooked fish.Price",40);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Sell Able")){
			Configuration.store.set("Store.Food.cookie.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.cookie.Price")){
			Configuration.store.set("Store.Food.cookie.Price",15);
		}
		if(!Configuration.store.contains("Store.Food.pork.Sell Able")){
			Configuration.store.set("Store.Food.pork.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.pork.Price")){
			Configuration.store.set("Store.Food.pork.Price",20);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Sell Able")){
			Configuration.store.set("Store.Food.grilled pork.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.grilled pork.Price")){
			Configuration.store.set("Store.Food.grilled pork.Price",40);
		}
		if(!Configuration.store.contains("Store.Food.melon.Sell Able")){
			Configuration.store.set("Store.Food.melon.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.melon.Price")){
			Configuration.store.set("Store.Food.melon.Price",50);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Sell Able")){
			Configuration.store.set("Store.Food.mushroom soup.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.mushroom soup.Price")){
			Configuration.store.set("Store.Food.mushroom soup.Price",30);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Sell Able")){
			Configuration.store.set("Store.Food.rotten flesh.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.rotten flesh.Price")){
			Configuration.store.set("Store.Food.rotten flesh.Price",5);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Sell Able")){
			Configuration.store.set("Store.Food.spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Food.spider eye.Price")){
			Configuration.store.set("Store.Food.spider eye.Price",20);
		}
		
		//tools
		if(!Configuration.store.contains("Store.Tools.wood axe.Sell Able")){
			Configuration.store.set("Store.Tools.wood axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood axe.Price")){
			Configuration.store.set("Store.Tools.wood axe.Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Sell Able")){
			Configuration.store.set("Store.Tools.wood hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood hoe.Price")){
			Configuration.store.set("Store.Tools.wood hoe.Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.wood pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood pickaxe.Price")){
			Configuration.store.set("Store.Tools.wood pickaxe.Price",15);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Sell Able")){
			Configuration.store.set("Store.Tools.wood sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood sword.Price")){
			Configuration.store.set("Store.Tools.wood sword.Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Sell Able")){
			Configuration.store.set("Store.Tools.wood spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.wood spade.Price")){
			Configuration.store.set("Store.Tools.wood spade.Price",15);
		}
		
		if(!Configuration.store.contains("Store.Tools.stone axe.Sell Able")){
			Configuration.store.set("Store.Tools.stone axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone axe.Price")){
			Configuration.store.set("Store.Tools.stone axe.Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Sell Able")){
			Configuration.store.set("Store.Tools.stone hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone hoe.Price")){
			Configuration.store.set("Store.Tools.stone hoe.Price",25);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.stone pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone pickaxe.Price")){
			Configuration.store.set("Store.Tools.stone pickaxe.Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Sell Able")){
			Configuration.store.set("Store.Tools.stone sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone sword.Price")){
			Configuration.store.set("Store.Tools.stone sword.Price",35);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Sell Able")){
			Configuration.store.set("Store.Tools.stone spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stone spade.Price")){
			Configuration.store.set("Store.Tools.stone spade.Price",25);
		}
		
		if(!Configuration.store.contains("Store.Tools.iron axe.Sell Able")){
			Configuration.store.set("Store.Tools.iron axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron axe.Price")){
			Configuration.store.set("Store.Tools.iron axe.Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Sell Able")){
			Configuration.store.set("Store.Tools.iron hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron hoe.Price")){
			Configuration.store.set("Store.Tools.iron hoe.Price",45);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.iron pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron pickaxe.Price")){
			Configuration.store.set("Store.Tools.iron pickaxe.Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Sell Able")){
			Configuration.store.set("Store.Tools.iron sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron sword.Price")){
			Configuration.store.set("Store.Tools.iron sword.Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Sell Able")){
			Configuration.store.set("Store.Tools.iron spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.iron spade.Price")){
			Configuration.store.set("Store.Tools.iron spade.Price",45);
		}
		
		if(!Configuration.store.contains("Store.Tools.gold axe.Sell Able")){
			Configuration.store.set("Store.Tools.gold axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold axe.Price")){
			Configuration.store.set("Store.Tools.gold axe.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Sell Able")){
			Configuration.store.set("Store.Tools.gold hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold hoe.Price")){
			Configuration.store.set("Store.Tools.gold hoe.Price",90);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.gold pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold pickaxe.Price")){
			Configuration.store.set("Store.Tools.gold pickaxe.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Sell Able")){
			Configuration.store.set("Store.Tools.gold sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold sword.Price")){
			Configuration.store.set("Store.Tools.gold sword.Price",110);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Sell Able")){
			Configuration.store.set("Store.Tools.gold spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.gold spade.Price")){
			Configuration.store.set("Store.Tools.gold spade.Price",90);
		}
		
		if(!Configuration.store.contains("Store.Tools.diamond axe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond axe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond axe.Price")){
			Configuration.store.set("Store.Tools.diamond axe.Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond hoe.Price")){
			Configuration.store.set("Store.Tools.diamond hoe.Price",450);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Sell Able")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond pickaxe.Price")){
			Configuration.store.set("Store.Tools.diamond pickaxe.Price",500);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Sell Able")){
			Configuration.store.set("Store.Tools.diamond sword.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond sword.Price")){
			Configuration.store.set("Store.Tools.diamond sword.Price",600);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Sell Able")){
			Configuration.store.set("Store.Tools.diamond spade.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.diamond spade.Price")){
			Configuration.store.set("Store.Tools.diamond spade.Price",450);
		}
		
		if(!Configuration.store.contains("Store.Tools.minecart.Sell Able")){
			Configuration.store.set("Store.Tools.minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.minecart.Price")){
			Configuration.store.set("Store.Tools.minecart.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.powerd minecart.Sell Able")){
			Configuration.store.set("Store.Tools.powerd minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.powerd minecart.Price")){
			Configuration.store.set("Store.Tools.powerd minecart.Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Sell Able")){
			Configuration.store.set("Store.Tools.storage minecart.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.storage minecart.Price")){
			Configuration.store.set("Store.Tools.storage minecart.Price",150);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Sell Able")){
			Configuration.store.set("Store.Tools.compass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.compass.Price")){
			Configuration.store.set("Store.Tools.compass.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Sell Able")){
			Configuration.store.set("Store.Tools.watch.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.watch.Price")){
			Configuration.store.set("Store.Tools.watch.Price",120);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Sell Able")){
			Configuration.store.set("Store.Tools.arrow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.arrow.Price")){
			Configuration.store.set("Store.Tools.arrow.Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Sell Able")){
			Configuration.store.set("Store.Tools.bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bucket.Price")){
			Configuration.store.set("Store.Tools.bucket.Price",50);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Sell Able")){
			Configuration.store.set("Store.Tools.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.water bucket.Price")){
			Configuration.store.set("Store.Tools.water bucket.Price",55);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Sell Able")){
			Configuration.store.set("Store.Tools.lava bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.lava bucket.Price")){
			Configuration.store.set("Store.Tools.lava bucket.Price",70);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Sell Able")){
			Configuration.store.set("Store.Tools.milk bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.milk bucket.Price")){
			Configuration.store.set("Store.Tools.milk bucket.Price",60);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Sell Able")){
			Configuration.store.set("Store.Tools.bow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bow.Price")){
			Configuration.store.set("Store.Tools.bow.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Sell Able")){
			Configuration.store.set("Store.Tools.boat.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.boat.Price")){
			Configuration.store.set("Store.Tools.boat.Price",100);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Sell Able")){
			Configuration.store.set("Store.Tools.saddle.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.saddle.Price")){
			Configuration.store.set("Store.Tools.saddle.Price",200);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Sell Able")){
			Configuration.store.set("Store.Tools.fishing rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.fishing rod.Price")){
			Configuration.store.set("Store.Tools.fishing rod.Price",30);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Sell Able")){
			Configuration.store.set("Store.Tools.shears.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.shears.Price")){
			Configuration.store.set("Store.Tools.shears.Price",60);
		}
		
		if(!Configuration.store.contains("Store.Tools.flint and steel.Sell Able")){
			Configuration.store.set("Store.Tools.flint and steel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.flint and steel.Price")){
			Configuration.store.set("Store.Tools.flint and steel.Price",40);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Sell Able")){
			Configuration.store.set("Store.Tools.bowl.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.bowl.Price")){
			Configuration.store.set("Store.Tools.bowl.Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Sell Able")){
			Configuration.store.set("Store.Tools.stick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.stick.Price")){
			Configuration.store.set("Store.Tools.stick.Price",10);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Sell Able")){
			Configuration.store.set("Store.Tools.snow ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.snow ball.Price")){
			Configuration.store.set("Store.Tools.snow ball.Price",20);
		}
		if(!Configuration.store.contains("Store.Tools.map.Sell Able")){
			Configuration.store.set("Store.Tools.map.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Tools.map.Price")){
			Configuration.store.set("Store.Tools.map.Price",300);
		}
		
		//Armour
		
		if(!Configuration.store.contains("Store.Armour.leather helmet.Sell Able")){
			Configuration.store.set("Store.Armour.leather helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather helmet.Price")){
			Configuration.store.set("Store.Armour.leather helmet.Price",20);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.leather chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather chestplate.Price")){
			Configuration.store.set("Store.Armour.leather chestplate.Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Sell Able")){
			Configuration.store.set("Store.Armour.leather leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather leggings.Price")){
			Configuration.store.set("Store.Armour.leather leggings.Price",30);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Sell Able")){
			Configuration.store.set("Store.Armour.leather boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.leather boots.Price")){
			Configuration.store.set("Store.Armour.leather boots.Price",20);
		}
		
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail helmet.Price")){
			Configuration.store.set("Store.Armour.chainmail helmet.Price",50);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail chestplate.Price")){
			Configuration.store.set("Store.Armour.chainmail chestplate.Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail leggings.Price")){
			Configuration.store.set("Store.Armour.chainmail leggings.Price",70);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Sell Able")){
			Configuration.store.set("Store.Armour.chainmail boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.chainmail boots.Price")){
			Configuration.store.set("Store.Armour.chainmail boots.Price",50);
		}
		
		if(!Configuration.store.contains("Store.Armour.iron helmet.Sell Able")){
			Configuration.store.set("Store.Armour.iron helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron helmet.Price")){
			Configuration.store.set("Store.Armour.iron helmet.Price",100);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.iron chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron chestplate.Price")){
			Configuration.store.set("Store.Armour.iron chestplate.Price",250);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Sell Able")){
			Configuration.store.set("Store.Armour.iron leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron leggings.Price")){
			Configuration.store.set("Store.Armour.iron leggings.Price",200);
		}
		if(!Configuration.store.contains("Store.Armour.iron boots.Sell Able")){
			Configuration.store.set("Store.Armour.iron boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.iron boots.Price")){
			Configuration.store.set("Store.Armour.iron boots.Price",100);
		}
		
		if(!Configuration.store.contains("Store.Armour.gold helmet.Sell Able")){
			Configuration.store.set("Store.Armour.gold helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold helmet.Price")){
			Configuration.store.set("Store.Armour.gold helmet.Price",250);
		}
		if(!Configuration.store.contains("Store.Armour.gold chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.gold chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold chestplate.Price")){
			Configuration.store.set("Store.Armour.gold chestplate.Price",500);
		}
		if(!Configuration.store.contains("Store.Armour.gold leggings.Sell Able")){
			Configuration.store.set("Store.Armour.gold leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold leggings.Price")){
			Configuration.store.set("Store.Armour.gold leggings.Price",350);
		}
		if(!Configuration.store.contains("Store.Armour.gold boots.Sell Able")){
			Configuration.store.set("Store.Armour.gold boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.gold boots.Price")){
			Configuration.store.set("Store.Armour.gold boots.Price",250);
		}
		
		if(!Configuration.store.contains("Store.Armour.diamond helmet.Sell Able")){
			Configuration.store.set("Store.Armour.diamond helmet.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond helmet.Price")){
			Configuration.store.set("Store.Armour.diamond helmet.Price",500);
		}
		if(!Configuration.store.contains("Store.Armour.diamond chestplate.Sell Able")){
			Configuration.store.set("Store.Armour.diamond chestplate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond chestplate.Price")){
			Configuration.store.set("Store.Armour.diamond chestplate.Price",1000);
		}
		if(!Configuration.store.contains("Store.Armour.diamond leggings.Sell Able")){
			Configuration.store.set("Store.Armour.diamond leggings.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond leggings.Price")){
			Configuration.store.set("Store.Armour.diamond leggings.Price",700);
		}
		if(!Configuration.store.contains("Store.Armour.diamond boots.Sell Able")){
			Configuration.store.set("Store.Armour.diamond boots.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Armour.diamond boots.Price")){
			Configuration.store.set("Store.Armour.diamond boots.Price",500);
		}
		
		//mechanisms
		
		if(!Configuration.store.contains("Store.Mechanisms.redstone.Sell Able")){
			Configuration.store.set("Store.Mechanisms.redstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone.Price")){
			Configuration.store.set("Store.Mechanisms.redstone.Price",5);
		}
		if(!Configuration.store.contains("Store.Mechanisms.diode.Sell Able")){
			Configuration.store.set("Store.Mechanisms.diode.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.diode.Price")){
			Configuration.store.set("Store.Mechanisms.diode.Price",20);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston base.Sell Able")){
			Configuration.store.set("Store.Mechanisms.piston base.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston base.Price")){
			Configuration.store.set("Store.Mechanisms.piston base.Price",70);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston sticky base.Sell Able")){
			Configuration.store.set("Store.Mechanisms.piston sticky base.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.piston sticky base.Price")){
			Configuration.store.set("Store.Mechanisms.piston sticky base.Price",100);
		}
		if(!Configuration.store.contains("Store.Mechanisms.lever.Sell Able")){
			Configuration.store.set("Store.Mechanisms.lever.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.lever.Price")){
			Configuration.store.set("Store.Mechanisms.lever.Price",10);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood plate.Sell Able")){
			Configuration.store.set("Store.Mechanisms.wood plate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood plate.Price")){
			Configuration.store.set("Store.Mechanisms.wood plate.Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone plate.Sell Able")){
			Configuration.store.set("Store.Mechanisms.stone plate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone plate.Price")){
			Configuration.store.set("Store.Mechanisms.stone plate.Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.note block.Sell Able")){
			Configuration.store.set("Store.Mechanisms.note block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.note block.Price")){
			Configuration.store.set("Store.Mechanisms.note block.Price",150);
		}
		if(!Configuration.store.contains("Store.Mechanisms.detector rail.Sell Able")){
			Configuration.store.set("Store.Mechanisms.detector rail.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.detector rail.Price")){
			Configuration.store.set("Store.Mechanisms.detector rail.Price",40);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone torch off.Sell Able")){
			Configuration.store.set("Store.Mechanisms.redstone torch off.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.redstone torch off.Price")){
			Configuration.store.set("Store.Mechanisms.redstone torch off.Price",15);
		}
		if(!Configuration.store.contains("Store.Mechanisms.powered rail.Sell Able")){
			Configuration.store.set("Store.Mechanisms.powered rail.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.powered rail.Price")){
			Configuration.store.set("Store.Mechanisms.powered rail.Price",60);
		}
		if(!Configuration.store.contains("Store.Mechanisms.rails.Sell Able")){
			Configuration.store.set("Store.Mechanisms.rails.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.rails.Price")){
			Configuration.store.set("Store.Mechanisms.rails.Price",30);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.wood door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.wood door.Price")){
			Configuration.store.set("Store.Mechanisms.wood door.Price",40);
		}
		if(!Configuration.store.contains("Store.Mechanisms.iron door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.iron door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.iron door.Price")){
			Configuration.store.set("Store.Mechanisms.iron door.Price",60);
		}
		if(!Configuration.store.contains("Store.Mechanisms.dispenser.Sell Able")){
			Configuration.store.set("Store.Mechanisms.dispenser.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.dispenser.Price")){
			Configuration.store.set("Store.Mechanisms.dispenser.Price",150);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone button.Sell Able")){
			Configuration.store.set("Store.Mechanisms.stone button.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.stone button.Price")){
			Configuration.store.set("Store.Mechanisms.stone button.Price",10);
		}
		if(!Configuration.store.contains("Store.Mechanisms.trap door.Sell Able")){
			Configuration.store.set("Store.Mechanisms.trap door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.trap door.Price")){
			Configuration.store.set("Store.Mechanisms.trap door.Price",50);
		}
		if(!Configuration.store.contains("Store.Mechanisms.tnt.Sell Able")){
			Configuration.store.set("Store.Mechanisms.tnt.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mechanisms.tnt.Price")){
			Configuration.store.set("Store.Mechanisms.tnt.Price",150);
		}
		
		//gardening
		
		if(!Configuration.store.contains("Store.Gardening.wood hoe.Sell Able")){
			Configuration.store.set("Store.Gardening.wood hoe.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wood hoe.Price")){
			Configuration.store.set("Store.Gardening.wood hoe.Price",10);
		}
		if(!Configuration.store.contains("Store.Gardening.bucket.Sell Able")){
			Configuration.store.set("Store.Gardening.bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.bucket.Price")){
			Configuration.store.set("Store.Gardening.bucket.Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.water bucket.Sell Able")){
			Configuration.store.set("Store.Gardening.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water bucket.Price")){
			Configuration.store.set("Store.Gardening.water bucket.Price",55);
		}
		if(!Configuration.store.contains("Store.Gardening.brown mushroom.Sell Able")){
			Configuration.store.set("Store.Gardening.brown mushroom.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.brown mushroom.Price")){
			Configuration.store.set("Store.Gardening.brown mushroom.Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.red mushroom.Sell Able")){
			Configuration.store.set("Store.Gardening.red mushroom.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red mushroom.Price")){
			Configuration.store.set("Store.Gardening.red mushroom.Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.red rose.Sell Able")){
			Configuration.store.set("Store.Gardening.red rose.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.red rose.Price")){
			Configuration.store.set("Store.Gardening.red rose.Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.yellow flower.Sell Able")){
			Configuration.store.set("Store.Gardening.yellow flower.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.yellow flower.Price")){
			Configuration.store.set("Store.Gardening.yellow flower.Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.cactus.Sell Able")){
			Configuration.store.set("Store.Gardening.cactus.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.cactus.Price")){
			Configuration.store.set("Store.Gardening.cactus.Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.sapling.Sell Able")){
			Configuration.store.set("Store.Gardening.sapling.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sapling.Price")){
			Configuration.store.set("Store.Gardening.sapling.Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.seeds.Price")){
			Configuration.store.set("Store.Gardening.seeds.Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.sugar cane.Sell Able")){
			Configuration.store.set("Store.Gardening.sugar cane.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.sugar cane.Price")){
			Configuration.store.set("Store.Gardening.sugar cane.Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.wheat.Sell Able")){
			Configuration.store.set("Store.Gardening.wheat.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.wheat.Price")){
			Configuration.store.set("Store.Gardening.wheat.Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.melon seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.melon seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon seeds.Price")){
			Configuration.store.set("Store.Gardening.melon seeds.Price",500);
		}
		if(!Configuration.store.contains("Store.Gardening.melon block.Sell Able")){
			Configuration.store.set("Store.Gardening.melon block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.melon block.Price")){
			Configuration.store.set("Store.Gardening.melon block.Price",250);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin seeds.Sell Able")){
			Configuration.store.set("Store.Gardening.pumpkin seeds.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin seeds.Price")){
			Configuration.store.set("Store.Gardening.pumpkin seeds.Price",500);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin.Sell Able")){
			Configuration.store.set("Store.Gardening.pumpkin.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.pumpkin.Price")){
			Configuration.store.set("Store.Gardening.pumpkin.Price",250);
		}
		if(!Configuration.store.contains("Store.Gardening.soil.Sell Able")){
			Configuration.store.set("Store.Gardening.soil.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Gardening.soil.Price")){
			Configuration.store.set("Store.Gardening.soil.Price",20);
		}
		if(!Configuration.store.contains("Store.Gardening.long grass.Sell Able")){
			Configuration.store.set("Store.Gardening.long grass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.long grass.Price")){
			Configuration.store.set("Store.Gardening.long grass.Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.dead bush.Sell Able")){
			Configuration.store.set("Store.Gardening.dead bush.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.dead bush.Price")){
			Configuration.store.set("Store.Gardening.dead bush.Price",15);
		}
		if(!Configuration.store.contains("Store.Gardening.vine.Sell Able")){
			Configuration.store.set("Store.Gardening.vine.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.vine.Price")){
			Configuration.store.set("Store.Gardening.vine.Price",50);
		}
		if(!Configuration.store.contains("Store.Gardening.water lily.Sell Able")){
			Configuration.store.set("Store.Gardening.water lily.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.water lily.Price")){
			Configuration.store.set("Store.Gardening.water lily.Price",30);
		}
		if(!Configuration.store.contains("Store.Gardening.nether warts.Sell Able")){
			Configuration.store.set("Store.Gardening.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Gardening.nether warts.Price")){
			Configuration.store.set("Store.Gardening.nether warts.Price",60);
		}
		
		//furniture
		
		if(!Configuration.store.contains("Store.Furniture.bed.Sell Able")){
			Configuration.store.set("Store.Furniture.bed.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bed.Price")){
			Configuration.store.set("Store.Furniture.bed.Price",250);
		}
		if(!Configuration.store.contains("Store.Furniture.bookshelf.Sell Able")){
			Configuration.store.set("Store.Furniture.bookshelf.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.bookshelf.Price")){
			Configuration.store.set("Store.Furniture.bookshelf.Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.brewing stand item.Sell Able")){
			Configuration.store.set("Store.Furniture.brewing stand item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brewing stand item.Price")){
			Configuration.store.set("Store.Furniture.brewing stand item.Price",200);
		}
		if(!Configuration.store.contains("Store.Furniture.brick stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.brick stairs.Price")){
			Configuration.store.set("Store.Furniture.brick stairs.Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.cauldron item.Sell Able")){
			Configuration.store.set("Store.Furniture.cauldron item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cauldron item.Price")){
			Configuration.store.set("Store.Furniture.cauldron item.Price",200);
		}
		if(!Configuration.store.contains("Store.Furniture.workbench.Sell Able")){
			Configuration.store.set("Store.Furniture.workbench.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.workbench.Price")){
			Configuration.store.set("Store.Furniture.workbench.Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.chest.Sell Able")){
			Configuration.store.set("Store.Furniture.chest.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.chest.Price")){
			Configuration.store.set("Store.Furniture.chest.Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.cobblestone stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.cobblestone stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.cobblestone stairs.Price")){
			Configuration.store.set("Store.Furniture.cobblestone stairs.Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.dispenser.Sell Able")){
			Configuration.store.set("Store.Furniture.dispenser.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.dispenser.Price")){
			Configuration.store.set("Store.Furniture.dispenser.Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.enchantment table.Sell Able")){
			Configuration.store.set("Store.Furniture.enchantment table.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.enchantment table.Price")){
			Configuration.store.set("Store.Furniture.enchantment table.Price",300);
		}
		if(!Configuration.store.contains("Store.Furniture.fence.Sell Able")){
			Configuration.store.set("Store.Furniture.fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence.Price")){
			Configuration.store.set("Store.Furniture.fence.Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.fence gate.Sell Able")){
			Configuration.store.set("Store.Furniture.fence gate.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.fence gate.Price")){
			Configuration.store.set("Store.Furniture.fence gate.Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.furnace.Sell Able")){
			Configuration.store.set("Store.Furniture.furnace.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.furnace.Price")){
			Configuration.store.set("Store.Furniture.furnace.Price",60);
		}
		if(!Configuration.store.contains("Store.Furniture.jukebox.Sell Able")){
			Configuration.store.set("Store.Furniture.jukebox.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jukebox.Price")){
			Configuration.store.set("Store.Furniture.jukebox.Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.jack o lantern.Sell Able")){
			Configuration.store.set("Store.Furniture.jack o lantern.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.jack o lantern.Price")){
			Configuration.store.set("Store.Furniture.jack o lantern.Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.ladder.Sell Able")){
			Configuration.store.set("Store.Furniture.ladder.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.ladder.Price")){
			Configuration.store.set("Store.Furniture.ladder.Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.nether brick stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.nether brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether brick stairs.Price")){
			Configuration.store.set("Store.Furniture.nether brick stairs.Price",80);
		}
		if(!Configuration.store.contains("Store.Furniture.nether fence.Sell Able")){
			Configuration.store.set("Store.Furniture.nether fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.nether fence.Price")){
			Configuration.store.set("Store.Furniture.nether fence.Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.note block.Sell Able")){
			Configuration.store.set("Store.Furniture.note block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.note block.Price")){
			Configuration.store.set("Store.Furniture.note block.Price",150);
		}
		if(!Configuration.store.contains("Store.Furniture.painting.Sell Able")){
			Configuration.store.set("Store.Furniture.painting.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.painting.Price")){
			Configuration.store.set("Store.Furniture.painting.Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.sign.Sell Able")){
			Configuration.store.set("Store.Furniture.sign.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.sign.Price")){
			Configuration.store.set("Store.Furniture.sign.Price",20);
		}
		if(!Configuration.store.contains("Store.Furniture.wood door.Sell Able")){
			Configuration.store.set("Store.Furniture.wood door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood door.Price")){
			Configuration.store.set("Store.Furniture.wood door.Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.iron door.Sell Able")){
			Configuration.store.set("Store.Furniture.iron door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron door.Price")){
			Configuration.store.set("Store.Furniture.iron door.Price",60);
		}
		if(!Configuration.store.contains("Store.Furniture.torch.Sell Able")){
			Configuration.store.set("Store.Furniture.torch.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.torch.Price")){
			Configuration.store.set("Store.Furniture.torch.Price",30);
		}
		if(!Configuration.store.contains("Store.Furniture.trap door.Sell Able")){
			Configuration.store.set("Store.Furniture.trap door.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.trap door.Price")){
			Configuration.store.set("Store.Furniture.trap door.Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.wood stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.wood stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.wood stairs.Price")){
			Configuration.store.set("Store.Furniture.wood stairs.Price",40);
		}
		if(!Configuration.store.contains("Store.Furniture.smooth stairs.Sell Able")){
			Configuration.store.set("Store.Furniture.smooth stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.smooth stairs.Price")){
			Configuration.store.set("Store.Furniture.smooth stairs.Price",70);
		}
		if(!Configuration.store.contains("Store.Furniture.iron fence.Sell Able")){
			Configuration.store.set("Store.Furniture.iron fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.iron fence.Price")){
			Configuration.store.set("Store.Furniture.iron fence.Price",50);
		}
		if(!Configuration.store.contains("Store.Furniture.thin glass.Sell Able")){
			Configuration.store.set("Store.Furniture.thin glass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Furniture.thin glass.Price")){
			Configuration.store.set("Store.Furniture.thin glass.Price",40);
		}
		
		
		//materials
		
		if(!Configuration.store.contains("Store.Materials.stone.Sell Able")){
			Configuration.store.set("Store.Materials.stone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.stone.Price")){
			Configuration.store.set("Store.Materials.stone.Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.grass.Sell Able")){
			Configuration.store.set("Store.Materials.grass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.grass.Price")){
			Configuration.store.set("Store.Materials.grass.Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.dirt.Sell Able")){
			Configuration.store.set("Store.Materials.dirt.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.dirt.Price")){
			Configuration.store.set("Store.Materials.dirt.Price",5);
		}
		if(!Configuration.store.contains("Store.Materials.cobblestone.Sell Able")){
			Configuration.store.set("Store.Materials.cobblestone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.cobblestone.Price")){
			Configuration.store.set("Store.Materials.cobblestone.Price",5);
		}
		if(!Configuration.store.contains("Store.Materials.wood.Sell Able")){
			Configuration.store.set("Store.Materials.wood.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.wood.Price")){
			Configuration.store.set("Store.Materials.wood.Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.bedrock.Sell Able")){
			Configuration.store.set("Store.Materials.bedrock.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.bedrock.Price")){
			Configuration.store.set("Store.Materials.bedrock.Price",10000);
		}
		if(!Configuration.store.contains("Store.Materials.water.Sell Able")){
			Configuration.store.set("Store.Materials.water.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.water.Price")){
			Configuration.store.set("Store.Materials.water.Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.stationary water.Sell Able")){
			Configuration.store.set("Store.Materials.stationary water.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.stationary water.Price")){
			Configuration.store.set("Store.Materials.stationary water.Price",200);
		}
		if(!Configuration.store.contains("Store.Materials.lava.Sell Able")){
			Configuration.store.set("Store.Materials.lava.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.lava.Price")){
			Configuration.store.set("Store.Materials.lava.Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.stationary lava.Sell Able")){
			Configuration.store.set("Store.Materials.stationary lava.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.stationary lava.Price")){
			Configuration.store.set("Store.Materials.stationary lava.Price",200);
		}
		if(!Configuration.store.contains("Store.Materials.sand.Sell Able")){
			Configuration.store.set("Store.Materials.sand.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sand.Price")){
			Configuration.store.set("Store.Materials.sand.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.gravel.Sell Able")){
			Configuration.store.set("Store.Materials.gravel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.gravel.Price")){
			Configuration.store.set("Store.Materials.gravel.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.log.Sell Able")){
			Configuration.store.set("Store.Materials.log.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.log.Price")){
			Configuration.store.set("Store.Materials.log.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.leaves.Sell Able")){
			Configuration.store.set("Store.Materials.leaves.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.leaves.Price")){
			Configuration.store.set("Store.Materials.leaves.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.sponge.Sell Able")){
			Configuration.store.set("Store.Materials.sponge.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sponge.Price")){
			Configuration.store.set("Store.Materials.sponge.Price",50);
		}
		if(!Configuration.store.contains("Store.Materials.glass.Sell Able")){
			Configuration.store.set("Store.Materials.glass.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.glass.Price")){
			Configuration.store.set("Store.Materials.glass.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.sandstone.Sell Able")){
			Configuration.store.set("Store.Materials.sandstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.sandstone.Price")){
			Configuration.store.set("Store.Materials.sandstone.Price",25);
		}
		if(!Configuration.store.contains("Store.Materials.double step.Sell Able")){
			Configuration.store.set("Store.Materials.double step.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Materials.double step.Price")){
			Configuration.store.set("Store.Materials.double step.Price",15);
		}
		if(!Configuration.store.contains("Store.Materials.step.Sell Able")){
			Configuration.store.set("Store.Materials.step.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.step.Price")){
			Configuration.store.set("Store.Materials.step.Price",10);
		}
		if(!Configuration.store.contains("Store.Materials.brick.Sell Able")){
			Configuration.store.set("Store.Materials.brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.brick.Price")){
			Configuration.store.set("Store.Materials.brick.Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.mossy cobblestone.Sell Able")){
			Configuration.store.set("Store.Materials.mossy cobblestone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mossy cobblestone.Price")){
			Configuration.store.set("Store.Materials.mossy cobblestone.Price",35);
		}
		if(!Configuration.store.contains("Store.Materials.obsidian.Sell Able")){
			Configuration.store.set("Store.Materials.obsidian.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.obsidian.Price")){
			Configuration.store.set("Store.Materials.obsidian.Price",100);
		}
		if(!Configuration.store.contains("Store.Materials.snow.Sell Able")){
			Configuration.store.set("Store.Materials.snow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow.Price")){
			Configuration.store.set("Store.Materials.snow.Price",20);
		}
		if(!Configuration.store.contains("Store.Materials.ice.Sell Able")){
			Configuration.store.set("Store.Materials.ice.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ice.Price")){
			Configuration.store.set("Store.Materials.ice.Price",40);
		}
		if(!Configuration.store.contains("Store.Materials.snow block.Sell Able")){
			Configuration.store.set("Store.Materials.snow block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.snow block.Price")){
			Configuration.store.set("Store.Materials.snow block.Price",30);
		}
		if(!Configuration.store.contains("Store.Materials.clay.Sell Able")){
			Configuration.store.set("Store.Materials.clay.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.clay.Price")){
			Configuration.store.set("Store.Materials.clay.Price",35);
		}
		if(!Configuration.store.contains("Store.Materials.smooth brick.Sell Able")){
			Configuration.store.set("Store.Materials.smooth brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.smooth brick.Price")){
			Configuration.store.set("Store.Materials.smooth brick.Price",110);
		}
		if(!Configuration.store.contains("Store.Materials.mycel.Sell Able")){
			Configuration.store.set("Store.Materials.mycel.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.mycel.Price")){
			Configuration.store.set("Store.Materials.mycel.Price",150);
		}
		if(!Configuration.store.contains("Store.Materials.ender stone.Sell Able")){
			Configuration.store.set("Store.Materials.ender stone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Materials.ender stone.Price")){
			Configuration.store.set("Store.Materials.ender stone.Price",30);
		}
		
		
		//rawmaterials
		
		if(!Configuration.store.contains("Store.Raw Materials.coal.Sell Able")){
			Configuration.store.set("Store.Raw Materials.coal.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.coal.Price")){
			Configuration.store.set("Store.Raw Materials.coal.Price",40);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron ingot.Sell Able")){
			Configuration.store.set("Store.Raw Materials.iron ingot.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.iron ingot.Price")){
			Configuration.store.set("Store.Raw Materials.iron ingot.Price",60);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold ingot.Sell Able")){
			Configuration.store.set("Store.Raw Materials.gold ingot.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.gold ingot.Price")){
			Configuration.store.set("Store.Raw Materials.gold ingot.Price",100);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond.Sell Able")){
			Configuration.store.set("Store.Raw Materials.diamond.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.diamond.Price")){
			Configuration.store.set("Store.Raw Materials.diamond.Price",400);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay ball.Sell Able")){
			Configuration.store.set("Store.Raw Materials.clay ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay ball.Price")){
			Configuration.store.set("Store.Raw Materials.clay ball.Price",30);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay brick.Sell Able")){
			Configuration.store.set("Store.Raw Materials.clay brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.clay brick.Price")){
			Configuration.store.set("Store.Raw Materials.clay brick.Price",60);
		}
		if(!Configuration.store.contains("Store.Raw Materials.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Raw Materials.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.glowstone dust.Price")){
			Configuration.store.set("Store.Raw Materials.glowstone dust.Price",20);
		}
		if(!Configuration.store.contains("Store.Raw Materials.flint.Sell Able")){
			Configuration.store.set("Store.Raw Materials.flint.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.flint.Price")){
			Configuration.store.set("Store.Raw Materials.flint.Price",15);
		}
		if(!Configuration.store.contains("Store.Raw Materials.paper.Sell Able")){
			Configuration.store.set("Store.Raw Materials.paper.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.paper.Price")){
			Configuration.store.set("Store.Raw Materials.paper.Price",40);
		}
		if(!Configuration.store.contains("Store.Raw Materials.book.Sell Able")){
			Configuration.store.set("Store.Raw Materials.book.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.book.Price")){
			Configuration.store.set("Store.Raw Materials.book.Price",50);
		}
		if(!Configuration.store.contains("Store.Raw Materials.snow ball.Sell Able")){
			Configuration.store.set("Store.Raw Materials.snow ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.snow ball.Price")){
			Configuration.store.set("Store.Raw Materials.snow ball.Price",20);
		}
		if(!Configuration.store.contains("Store.Raw Materials.sugar.Sell Able")){
			Configuration.store.set("Store.Raw Materials.sugar.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Raw Materials.sugar.Price")){
			Configuration.store.set("Store.Raw Materials.sugar.Price",30);
		}
		
		//minerals
		
		if(!Configuration.store.contains("Store.Minerals.diamond block.Sell Able")){
			Configuration.store.set("Store.Minerals.diamond block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Minerals.diamond block.Price")){
			Configuration.store.set("Store.Minerals.diamond block.Price",17500);
		}
		if(!Configuration.store.contains("Store.Minerals.iron block.Sell Able")){
			Configuration.store.set("Store.Minerals.iron block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Minerals.iron block.Price")){
			Configuration.store.set("Store.Minerals.iron block.Price",2250);
		}
		if(!Configuration.store.contains("Store.Minerals.gold block.Sell Able")){
			Configuration.store.set("Store.Minerals.gold block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Minerals.gold block.Price")){
			Configuration.store.set("Store.Minerals.gold block.Price",4500);
		}
		if(!Configuration.store.contains("Store.Minerals.lapis block.Sell Able")){
			Configuration.store.set("Store.Minerals.lapis block.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Minerals.lapis block.Price")){
			Configuration.store.set("Store.Minerals.lapis block.Price",1000);
		}
		
		
		//ores
		
		if(!Configuration.store.contains("Store.Ores.gold ore.Sell Able")){
			Configuration.store.set("Store.Ores.gold ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.gold ore.Price")){
			Configuration.store.set("Store.Ores.gold ore.Price",500);
		}
		if(!Configuration.store.contains("Store.Ores.diamond ore.Sell Able")){
			Configuration.store.set("Store.Ores.diamond ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.diamond ore.Price")){
			Configuration.store.set("Store.Ores.diamond ore.Price",2000);
		}
		if(!Configuration.store.contains("Store.Ores.redstone ore.Sell Able")){
			Configuration.store.set("Store.Ores.redstone ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.redstone ore.Price")){
			Configuration.store.set("Store.Ores.redstone ore.Price",300);
		}
		if(!Configuration.store.contains("Store.Ores.iron ore.Sell Able")){
			Configuration.store.set("Store.Ores.iron ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.iron ore.Price")){
			Configuration.store.set("Store.Ores.iron ore.Price",250);
		}
		if(!Configuration.store.contains("Store.Ores.coal ore.Sell Able")){
			Configuration.store.set("Store.Ores.coal ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.coal ore.Price")){
			Configuration.store.set("Store.Ores.coal ore.Price",100);
		}
		if(!Configuration.store.contains("Store.Ores.lapis ore.Sell Able")){
			Configuration.store.set("Store.Ores.lapis ore.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Ores.lapis ore.Price")){
			Configuration.store.set("Store.Ores.lapis ore.Price",150);
		}
		
		//mobdrops
		
		if(!Configuration.store.contains("Store.Mob Drops.string.Sell Able")){
			Configuration.store.set("Store.Mob Drops.string.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.string.Price")){
			Configuration.store.set("Store.Mob Drops.string.Price",15);
		}
		if(!Configuration.store.contains("Store.Mob Drops.leather.Sell Able")){
			Configuration.store.set("Store.Mob Drops.leather.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.leather.Price")){
			Configuration.store.set("Store.Mob Drops.leather.Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.feather.Sell Able")){
			Configuration.store.set("Store.Mob Drops.feather.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.feather.Price")){
			Configuration.store.set("Store.Mob Drops.feather.Price",40);
		}
		if(!Configuration.store.contains("Store.Mob Drops.arrow.Sell Able")){
			Configuration.store.set("Store.Mob Drops.arrow.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.arrow.Price")){
			Configuration.store.set("Store.Mob Drops.arrow.Price",10);
		}
		if(!Configuration.store.contains("Store.Mob Drops.egg.Sell Able")){
			Configuration.store.set("Store.Mob Drops.egg.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.egg.Price")){
			Configuration.store.set("Store.Mob Drops.egg.Price",20);
		}
		if(!Configuration.store.contains("Store.Mob Drops.blaze rod.Sell Able")){
			Configuration.store.set("Store.Mob Drops.blaze rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.blaze rod.Price")){
			Configuration.store.set("Store.Mob Drops.blaze rod.Price",50);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ghast tear.Sell Able")){
			Configuration.store.set("Store.Mob Drops.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ghast tear.Price")){
			Configuration.store.set("Store.Mob Drops.ghast tear.Price",80);
		}
		if(!Configuration.store.contains("Store.Mob Drops.gold nugget.Sell Able")){
			Configuration.store.set("Store.Mob Drops.gold nugget.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.gold nugget.Price")){
			Configuration.store.set("Store.Mob Drops.gold nugget.Price",70);
		}
		if(!Configuration.store.contains("Store.Mob Drops.rotten flesh.Sell Able")){
			Configuration.store.set("Store.Mob Drops.rotten flesh.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.rotten flesh.Price")){
			Configuration.store.set("Store.Mob Drops.rotten flesh.Price",5);
		}
		if(!Configuration.store.contains("Store.Mob Drops.bone.Sell Able")){
			Configuration.store.set("Store.Mob Drops.bone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.bone.Price")){
			Configuration.store.set("Store.Mob Drops.bone.Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.sulphur.Sell Able")){
			Configuration.store.set("Store.Mob Drops.sulphur.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.sulphur.Price")){
			Configuration.store.set("Store.Mob Drops.sulphur.Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.spider eye.Sell Able")){
			Configuration.store.set("Store.Mob Drops.spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.spider eye.Price")){
			Configuration.store.set("Store.Mob Drops.spider eye.Price",30);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ender pearl.Sell Able")){
			Configuration.store.set("Store.Mob Drops.ender pearl.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.ender pearl.Price")){
			Configuration.store.set("Store.Mob Drops.ender pearl.Price",50);
		}
		if(!Configuration.store.contains("Store.Mob Drops.slime ball.Sell Able")){
			Configuration.store.set("Store.Mob Drops.slime ball.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.slime ball.Price")){
			Configuration.store.set("Store.Mob Drops.slime ball.Price",60);
		}
		if(!Configuration.store.contains("Store.Mob Drops.magma cream.Sell Able")){
			Configuration.store.set("Store.Mob Drops.magma cream.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Mob Drops.magma cream.Price")){
			Configuration.store.set("Store.Mob Drops.magma cream.Price",80);
		}
		
		//brewing
		
		if(!Configuration.store.contains("Store.Brewing.brewing stand item.Sell Able")){
			Configuration.store.set("Store.Brewing.brewing stand item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.brewing stand item.Price")){
			Configuration.store.set("Store.Brewing.brewing stand item.Price",200);
		}
		if(!Configuration.store.contains("Store.Brewing.cauldron item.Sell Able")){
			Configuration.store.set("Store.Brewing.cauldron item.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.cauldron item.Price")){
			Configuration.store.set("Store.Brewing.cauldron item.Price",200);
		}
		if(!Configuration.store.contains("Store.Brewing.water bucket.Sell Able")){
			Configuration.store.set("Store.Brewing.water bucket.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.water bucket.Price")){
			Configuration.store.set("Store.Brewing.water bucket.Price",55);
		}
		if(!Configuration.store.contains("Store.Brewing.blaze powder.Sell Able")){
			Configuration.store.set("Store.Brewing.blaze powder.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.blaze powder.Price")){
			Configuration.store.set("Store.Brewing.blaze powder.Price",90);
		}
		if(!Configuration.store.contains("Store.Brewing.nether warts.Sell Able")){
			Configuration.store.set("Store.Brewing.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.nether warts.Price")){
			Configuration.store.set("Store.Brewing.nether warts.Price",50);
		}
		if(!Configuration.store.contains("Store.Brewing.potion.Sell Able")){
			Configuration.store.set("Store.Brewing.potion.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.potion.Price")){
			Configuration.store.set("Store.Brewing.potion.Price",30);
		}
		if(!Configuration.store.contains("Store.Brewing.glass bottle.Sell Able")){
			Configuration.store.set("Store.Brewing.glass bottle.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glass bottle.Price")){
			Configuration.store.set("Store.Brewing.glass bottle.Price",10);
		}
		if(!Configuration.store.contains("Store.Brewing.fermented spider eye.Sell Able")){
			Configuration.store.set("Store.Brewing.fermented spider eye.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.fermented spider eye.Price")){
			Configuration.store.set("Store.Brewing.fermented spider eye.Price",40);
		}
		if(!Configuration.store.contains("Store.Brewing.magma cream.Sell Able")){
			Configuration.store.set("Store.Brewing.magma cream.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.magma cream.Price")){
			Configuration.store.set("Store.Brewing.magma cream.Price",80);
		}
		if(!Configuration.store.contains("Store.Brewing.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Brewing.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.glowstone dust.Price")){
			Configuration.store.set("Store.Brewing.glowstone dust.Price",40);
		}
		if(!Configuration.store.contains("Store.Brewing.redstone.Sell Able")){
			Configuration.store.set("Store.Brewing.redstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.redstone.Price")){
			Configuration.store.set("Store.Brewing.redstone.Price",20);
		}
		if(!Configuration.store.contains("Store.Brewing.sugar.Sell Able")){
			Configuration.store.set("Store.Brewing.sugar.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sugar.Price")){
			Configuration.store.set("Store.Brewing.sugar.Price",20);
		}
		if(!Configuration.store.contains("Store.Brewing.speckled melon.Sell Able")){
			Configuration.store.set("Store.Brewing.speckled melon.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.speckled melon.Price")){
			Configuration.store.set("Store.Brewing.speckled melon.Price",100);
		}
		if(!Configuration.store.contains("Store.Brewing.ghast tear.Sell Able")){
			Configuration.store.set("Store.Brewing.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.ghast tear.Price")){
			Configuration.store.set("Store.Brewing.ghast tear.Price",80);
		}
		if(!Configuration.store.contains("Store.Brewing.sulphur.Sell Able")){
			Configuration.store.set("Store.Brewing.sulphur.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Brewing.sulphur.Price")){
			Configuration.store.set("Store.Brewing.sulphur.Price",30);
		}
		
		//painting
	
		if(!Configuration.store.contains("Store.Painting.wool.Sell Able")){
			Configuration.store.set("Store.Painting.wool.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.wool.Price")){
			Configuration.store.set("Store.Painting.wool.Price",25);
		}
		if(!Configuration.store.contains("Store.Painting.ink sack.Sell Able")){
			Configuration.store.set("Store.Painting.ink sack.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Painting.ink sack.Price")){
			Configuration.store.set("Store.Painting.ink sack.Price",30);
		}
		
		//nether
		
		if(!Configuration.store.contains("Store.Nether.netherrack.Sell Able")){
			Configuration.store.set("Store.Nether.netherrack.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.netherrack.Price")){
			Configuration.store.set("Store.Nether.netherrack.Price",50);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick.Sell Able")){
			Configuration.store.set("Store.Nether.nether brick.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick.Price")){
			Configuration.store.set("Store.Nether.nether brick.Price",60);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick stairs.Sell Able")){
			Configuration.store.set("Store.Nether.nether brick stairs.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether brick stairs.Price")){
			Configuration.store.set("Store.Nether.nether brick stairs.Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether fence.Sell Able")){
			Configuration.store.set("Store.Nether.nether fence.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether fence.Price")){
			Configuration.store.set("Store.Nether.nether fence.Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether stalk.Sell Able")){
			Configuration.store.set("Store.Nether.nether stalk.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether stalk.Price")){
			Configuration.store.set("Store.Nether.nether stalk.Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.nether warts.Sell Able")){
			Configuration.store.set("Store.Nether.nether warts.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.nether warts.Price")){
			Configuration.store.set("Store.Nether.nether warts.Price",50);
		}
		if(!Configuration.store.contains("Store.Nether.blaze rod.Sell Able")){
			Configuration.store.set("Store.Nether.blaze rod.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.blaze rod.Price")){
			Configuration.store.set("Store.Nether.blaze rod.Price",70);
		}
		if(!Configuration.store.contains("Store.Nether.ghast tear.Sell Able")){
			Configuration.store.set("Store.Nether.ghast tear.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.ghast tear.Price")){
			Configuration.store.set("Store.Nether.ghast tear.Price",80);
		}
		if(!Configuration.store.contains("Store.Nether.gold nugget.Sell Able")){
			Configuration.store.set("Store.Nether.gold nugget.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.gold nugget.Price")){
			Configuration.store.set("Store.Nether.gold nugget.Price",40);
		}
		if(!Configuration.store.contains("Store.Nether.soul sand.Sell Able")){
			Configuration.store.set("Store.Nether.soul sand.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.soul sand.Price")){
			Configuration.store.set("Store.Nether.soul sand.Price",60);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone dust.Sell Able")){
			Configuration.store.set("Store.Nether.glowstone dust.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone dust.Price")){
			Configuration.store.set("Store.Nether.glowstone dust.Price",40);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone.Sell Able")){
			Configuration.store.set("Store.Nether.glowstone.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Nether.glowstone.Price")){
			Configuration.store.set("Store.Nether.glowstone.Price",60);
		}
		
		//music
		
		if(!Configuration.store.contains("Store.Music.jukebox.Sell Able")){
			Configuration.store.set("Store.Music.jukebox.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.jukebox.Price")){
			Configuration.store.set("Store.Music.jukebox.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.gold record.Sell Able")){
			Configuration.store.set("Store.Music.gold record.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.gold record.Price")){
			Configuration.store.set("Store.Music.gold record.Price",100);
		}
		if(!Configuration.store.contains("Store.Music.green record.Sell Able")){
			Configuration.store.set("Store.Music.green record.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.green record.Price")){
			Configuration.store.set("Store.Music.green record.Price",100);
		}
		if(!Configuration.store.contains("Store.Music.record 3.Sell Able")){
			Configuration.store.set("Store.Music.record 3.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 3.Price")){
			Configuration.store.set("Store.Music.record 3.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 4.Sell Able")){
			Configuration.store.set("Store.Music.record 4.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 4.Price")){
			Configuration.store.set("Store.Music.record 4.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 5.Sell Able")){
			Configuration.store.set("Store.Music.record 5.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 5.Price")){
			Configuration.store.set("Store.Music.record 5.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 6.Sell Able")){
			Configuration.store.set("Store.Music.record 6.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 6.Price")){
			Configuration.store.set("Store.Music.record 6.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 7.Sell Able")){
			Configuration.store.set("Store.Music.record 7.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 7.Price")){
			Configuration.store.set("Store.Music.record 7.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 8.Sell Able")){
			Configuration.store.set("Store.Music.record 8.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 8.Price")){
			Configuration.store.set("Store.Music.record 8.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 9.Sell Able")){
			Configuration.store.set("Store.Music.record 9.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 9.Price")){
			Configuration.store.set("Store.Music.record 9.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 10.Sell Able")){
			Configuration.store.set("Store.Music.record 10.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 10.Price")){
			Configuration.store.set("Store.Music.record 10.Price",150);
		}
		if(!Configuration.store.contains("Store.Music.record 11.Sell Able")){
			Configuration.store.set("Store.Music.record 11.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Music.record 11.Price")){
			Configuration.store.set("Store.Music.record 11.Price",150);
		}
		
		//misc
		
		if(!Configuration.store.contains("Store.Miscellaneous.web.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.web.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.web.Price")){
			Configuration.store.set("Store.Miscellaneous.web.Price",80);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.fire.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.fire.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.fire.Price")){
			Configuration.store.set("Store.Miscellaneous.fire.Price",60);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.portal.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.portal.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.portal.Price")){
			Configuration.store.set("Store.Miscellaneous.portal.Price",70);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.ender portal frame.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.ender portal frame.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.ender portal frame.Price")){
			Configuration.store.set("Store.Miscellaneous.ender portal frame.Price",70);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.dragon egg.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.dragon egg.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.dragon egg.Price")){
			Configuration.store.set("Store.Miscellaneous.dragon egg.Price",200);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster egg.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.monster egg.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster egg.Price")){
			Configuration.store.set("Store.Miscellaneous.monster egg.Price",150);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster eggs.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.monster eggs.Sell Able",false);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.monster eggs.Price")){
			Configuration.store.set("Store.Miscellaneous.monster eggs.Price",60);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.mob spawner.Sell Able")){
			Configuration.store.set("Store.Miscellaneous.mob spawner.Sell Able",true);
		}
		if(!Configuration.store.contains("Store.Miscellaneous.mob spawner.Price")){
			Configuration.store.set("Store.Miscellaneous.mob spawner.Price",250);
		}

	}
}
