package me.duckdoom5.RpgEssentials.RpgStores.Config;

public class CustomStoreConfig {
	
	public static void set(){
		if(!Configuration.customstores.contains("Bakery.297.Sell Able")){
			Configuration.customstores.set("Bakery.297.Sell Able",true);
		}
		if(!Configuration.customstores.contains("Bakery.297.Buy Able")){
			Configuration.customstores.set("Bakery.297.Buy Able",true);
		}
		if(!Configuration.customstores.contains("Bakery.297.Buy Price")){
			Configuration.customstores.set("Bakery.297.Buy Price",10);
		}
		if(!Configuration.customstores.contains("Bakery.297.Sell Price")){
			Configuration.customstores.set("Bakery.297.Sell Price",5);
		}
	}
}
