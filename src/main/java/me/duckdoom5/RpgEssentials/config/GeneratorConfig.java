package me.duckdoom5.RpgEssentials.config;

public class GeneratorConfig {

	public static void set(){
		//biomes
		
		if(!Configuration.generator.contains("Generator.Biomes.Desert")){
			Configuration.generator.set("Generator.Biomes.Desert",true);
		}
		if(!Configuration.generator.contains("Generator.Biomes.Beach")){
			Configuration.generator.set("Generator.Biomes.Beach",true);
		}
		if(!Configuration.generator.contains("Generator.Biomes.Sea")){
			Configuration.generator.set("Generator.Biomes.Sea",true);
		}
		if(!Configuration.generator.contains("Generator.Biomes.Mushroom Island")){
			Configuration.generator.set("Generator.Biomes.Mushroom Island",true);
		}
		
		//ores
		if(!Configuration.generator.contains("Generator.Ores.Custom")){
			Configuration.generator.set("Generator.Ores.Custom",true);
		}
		if(!Configuration.generator.contains("Generator.Ores.Original")){
			Configuration.generator.set("Generator.Ores.Original",true);
		}
		//plants
		if(!Configuration.generator.contains("Generator.Plants.Grass")){
			Configuration.generator.set("Generator.Plants.Grass",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Flowers")){
			Configuration.generator.set("Generator.Plants.Flowers",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Cacti")){
			Configuration.generator.set("Generator.Plants.Cacti",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Pumpkins and Melons")){
			Configuration.generator.set("Generator.Plants.Pumpkins and Melons",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Sugar Cane")){
			Configuration.generator.set("Generator.Plants.Sugar Cane",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Trees")){
			Configuration.generator.set("Generator.Plants.Trees",true);
		}
		if(!Configuration.generator.contains("Generator.Plants.Mushrooms")){
			Configuration.generator.set("Generator.Plants.Mushrooms",true);
		}
	}
}