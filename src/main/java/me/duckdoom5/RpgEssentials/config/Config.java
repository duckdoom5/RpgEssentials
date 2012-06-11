package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class Config {

	public static void set(){
		//Player
		if(!Configuration.config.contains("player.join.enabled")){
			Configuration.config.set("player.join.enabled",true);
		}
		if(!Configuration.config.contains("player.join.hideOP")){
			Configuration.config.set("player.join.hideOP",false);
		}
		if(!Configuration.config.contains("player.leave.enabled")){
			Configuration.config.set("player.leave.enabled",true);
		}
		if(!Configuration.config.contains("player.leave.hideOP")){
			Configuration.config.set("player.leave.hideOP",false);
		}
		if(!Configuration.config.contains("player.starting money")){
			Configuration.config.set("player.starting money",100);
		}
		if(!Configuration.config.contains("player.close gui on damage")){
			Configuration.config.set("player.close gui on damage",true);
		}
		
		//Deatchest
		if(!Configuration.config.contains("deathchest.protect time in minutes")){
			Configuration.config.set("deathchest.protect time in minutes", 5);
		}
		if(!Configuration.config.contains("deathchest.unprotect time in minutes")){
			Configuration.config.set("deathchest.unprotect time in minutes", 5);
		}
		
		//Worlds
		if(!Configuration.config.contains("worlds.enabled")){
			Configuration.config.set("worlds.enabled",Arrays.asList("RPG"));
		}
		
		//Store
		if(!Configuration.config.contains("store.allow")){
			Configuration.config.set("store.allow", false);
		}
		if(!Configuration.config.contains("store.key")){
			Configuration.config.set("store.key", "o");
		}
		if(!Configuration.config.contains("store.currency")){
			Configuration.config.set("store.currency","Dollar");
		}
		
		//Bank
		if(!Configuration.config.contains("bank.size.18.price")){
			Configuration.config.set("bank.size.18.price", 100);
		}
		if(!Configuration.config.contains("bank.size.27.price")){
			Configuration.config.set("bank.size.27.price", 500);
		}
		if(!Configuration.config.contains("bank.size.36.price")){
			Configuration.config.set("bank.size.36.price", 1000);
		}
		if(!Configuration.config.contains("bank.size.45.price")){
			Configuration.config.set("bank.size.45.price", 2000);
		}
		if(!Configuration.config.contains("bank.size.54.price")){
			Configuration.config.set("bank.size.54.price", 5000);
		}
		if(!Configuration.config.contains("bank.bankers.openbank")){
			Configuration.config.set("bank.bankers.openbank", false);
		}
		
		//Stats
		if(!Configuration.config.contains("stats.allow")){
			Configuration.config.set("stats.allow", true);
		}
		if(!Configuration.config.contains("stats.key")){
			Configuration.config.set("stats.key", "l");
		}
		
		//Spout
		if(!Configuration.config.contains("spout.leave.messageicon")){
			Configuration.config.set("spout.leave.messageicon",260);
		}
		if(!Configuration.config.contains("spout.join.messageicon")){
			Configuration.config.set("spout.join.messageicon",322);
		}
		if(!Configuration.config.contains("spout.join.message")){
			Configuration.config.set("spout.join.message","Welcome to the server!");
		}
		if(!Configuration.config.contains("spout.join.submessage")){
			Configuration.config.set("spout.join.submessage","Have a good time");
		}
		if(!Configuration.config.contains("spout.precache")){
			Configuration.config.set("spout.precache", Arrays.asList(
				"https://dl.dropbox.com/u/37984176/RpgEssentials/misc.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/plants.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/plants.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/blocks.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/stairs.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantineaxe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantinehoe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantinepick.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantineingot.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantineshovel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantinesword.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumaxe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumhoe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumingot.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumnugget.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumpick.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumshovel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Iridiumsword.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilaxe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilhoe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilingot.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilpick.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilshovel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Mithrilsword.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/npcwand.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Adamantinesword.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/snowwand.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/spawnerwand.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditeaxe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditehoe.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditeingot.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditepick.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditeshovel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Verditesword.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/wholemeal.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/bg.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/hamburger.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/goldcoin.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/batteredsos.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/battermix.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/borderbg.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/borderbottom.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/bordertop.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/breadbun.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/bronzecoin.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/butter.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/caveeel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cavetrout.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/chain.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cheese.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cheeseomlette.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cheesepizza.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/churn.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cookedbacon.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cookedcaveeel.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/cookedcavetrout.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Dough.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/flour.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/meatpizza.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/minefish.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/oil.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/omlette.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/pancake.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/pizzabase.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/pufferfish.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/rawbacon.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/salad.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/saladbowl.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/Sausage.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/tomato.png", 
				"https://dl.dropbox.com/u/37984176/RpgEssentials/silvercoin.png"));
		}
		if(!Configuration.config.contains("texturepack.default")){
			Configuration.config.set("texturepack.default","http://dl.dropbox.com/u/62672791/textures/XXMrPiggyCompanyXX.zip");
		}
		if(!Configuration.config.contains("texturepack.worldname")){
			Configuration.config.set("texturepack.worldname","http://dl.dropbox.com/u/62672791/textures/XXMrPiggyCompanyXX.zip");
		}
	}
}