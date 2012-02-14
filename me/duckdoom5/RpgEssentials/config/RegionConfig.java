package me.duckdoom5.RpgEssentials.config;

public class RegionConfig {
	
	public static void set(){
		
		if(!Configuration.region.contains("Regions.examplename.message")){
			Configuration.region.set("Regions.examplename.message","message");
		}
		if(!Configuration.region.contains("Regions.examplename.submessage")){
			Configuration.region.set("Regions.examplename.submessage","submessage");
		}
		if(!Configuration.region.contains("Regions.examplename.iconId")){
			Configuration.region.set("Regions.examplename.iconId", 264);
		}
		if(!Configuration.region.contains("Regions.examplename.music")){
			Configuration.region.set("Regions.examplename.music", "http://exampleurl.com");
		}
		if(!Configuration.region.contains("Regions.examplename.command")){
			Configuration.region.set("Regions.examplename.command", "rpg help");
		}
		if(!Configuration.region.contains("Regions.examplename.fog")){
			Configuration.region.set("Regions.examplename.fog", "far");
		}
		
	}
}
