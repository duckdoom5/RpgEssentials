package me.duckdoom5.RpgEssentials.config;

public class ModulesConfig {
	public static void set(){
		if(!Configuration.modules.contains("Modules.store")){
			Configuration.modules.set("Modules.store",true);
		}
		if(!Configuration.modules.contains("Modules.leveling")){
			Configuration.modules.set("Modules.leveling",true);
		}
		if(!Configuration.modules.contains("Modules.banking")){
			Configuration.modules.set("Modules.banking",true);
		}
		if(!Configuration.modules.contains("Modules.mailing")){
			Configuration.modules.set("Modules.mailing",true);
		}
		if(!Configuration.modules.contains("Modules.regions")){
			Configuration.modules.set("Modules.regions",true);
		}
		if(!Configuration.modules.contains("Modules.texturepack")){
			Configuration.modules.set("Modules.texturepack",true);
		}
		if(!Configuration.modules.contains("Modules.custom mobs")){
			Configuration.modules.set("Modules.custom mobs",true);
		}
		if(!Configuration.modules.contains("Modules.battle music")){
			Configuration.modules.set("Modules.battle music",true);
		}
		if(!Configuration.modules.contains("Modules.death chest")){
			Configuration.modules.set("Modules.death chest",true);
		}
		if(!Configuration.modules.contains("Modules.npcs")){
			Configuration.modules.set("Modules.npcs",true);
		}
	}
}
