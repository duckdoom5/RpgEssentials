package me.duckdoom5.RpgEssentials.config;

public class GeneratorConfig {

	public static void set(){
		//biomes
		
		if(!Configuration.generator.contains("Generator.world.height")){
			Configuration.generator.set("Generator.world.height",8);
		}
		if(!Configuration.generator.contains("Generator.world.spread")){
			Configuration.generator.set("Generator.world.spread",128);
		}
		
		if(!Configuration.generator.contains("Generator.bedrock.frequency")){
			Configuration.generator.set("Generator.bedrock.frequency",40);
		}
		if(!Configuration.generator.contains("Generator.grass.frequency")){
			Configuration.generator.set("Generator.grass.frequency",60);
		}
		if(!Configuration.generator.contains("Generator.grass.generate")){
			Configuration.generator.set("Generator.grass.generate",true);
		}
		if(!Configuration.generator.contains("Generator.flowers.frequency")){
			Configuration.generator.set("Generator.flowers.frequency",10);
		}
		if(!Configuration.generator.contains("Generator.flowers.generate")){
			Configuration.generator.set("Generator.flowers.generate",true);
		}
		if(!Configuration.generator.contains("Generator.cacti.frequency")){
			Configuration.generator.set("Generator.cacti.frequency",10);
		}
		if(!Configuration.generator.contains("Generator.cacti.generate")){
			Configuration.generator.set("Generator.cacti.generate",true);
		}
		if(!Configuration.generator.contains("Generator.pumpkins and melons.frequency")){
			Configuration.generator.set("Generator.pumpkins and melons.frequency",5);
		}
		if(!Configuration.generator.contains("Generator.pumpkins and melons.generate")){
			Configuration.generator.set("Generator.pumpkins and melons.generate",true);
		}
		if(!Configuration.generator.contains("Generator.sugar cane.frequency")){
			Configuration.generator.set("Generator.sugar cane.frequency",15);
		}
		if(!Configuration.generator.contains("Generator.sugar cane.generate")){
			Configuration.generator.set("Generator.sugar cane.generate",true);
		}
		if(!Configuration.generator.contains("Generator.trees.frequency")){
			Configuration.generator.set("Generator.trees.frequency",60);
		}
		if(!Configuration.generator.contains("Generator.trees.generate")){
			Configuration.generator.set("Generator.trees.generate",true);
		}
		if(!Configuration.generator.contains("Generator.mushrooms.frequency")){
			Configuration.generator.set("Generator.mushrooms.frequency",8);
		}
		if(!Configuration.generator.contains("Generator.mushrooms.generate")){
			Configuration.generator.set("Generator.mushrooms.generate",true);
		}
		
		if(!Configuration.generator.contains("Generator.sea.level")){
			Configuration.generator.set("Generator.sea.level",64);
		}
		if(!Configuration.generator.contains("Generator.sea.generate")){
			Configuration.generator.set("Generator.sea.generate",true);
		}
		if(!Configuration.generator.contains("Generator.desert.generate")){
			Configuration.generator.set("Generator.desert.generate",true);
		}
		if(!Configuration.generator.contains("Generator.beach.generate")){
			Configuration.generator.set("Generator.beach.generate",true);
		}
		if(!Configuration.generator.contains("Generator.mushroom island.generate")){
			Configuration.generator.set("Generator.mushroom island.generate",true);
		}
		
		//structures
		if(!Configuration.generator.contains("Generator.Structures.caves")){
			Configuration.generator.set("Generator.Structures.caves",true);
		}
		if(!Configuration.generator.contains("Generator.Structures.caves.frequency")){
			Configuration.generator.set("Generator.Structures.caves.frequency",300);
		}
		
		if(!Configuration.generator.contains("Generator.Structures.dungeons")){
			Configuration.generator.set("Generator.Structures.dungeons",true);
		}
		if(!Configuration.generator.contains("Generator.Structures.dungeons.frequency")){
			Configuration.generator.set("Generator.Structures.dungeons.frequency",1);
		}
		
		//ores
		if(!Configuration.generator.contains("Generator.Ores.Custom")){
			Configuration.generator.set("Generator.Ores.Custom",true);
		}
		if(!Configuration.generator.contains("Generator.Ores.Original")){
			Configuration.generator.set("Generator.Ores.Original",true);
		}
	}
}