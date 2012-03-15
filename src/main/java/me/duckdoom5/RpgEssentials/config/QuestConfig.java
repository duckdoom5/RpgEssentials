package me.duckdoom5.RpgEssentials.config;

public class QuestConfig {
	public static void set(){
		if(!Configuration.quests.contains("Quests.test.text.name")){
			Configuration.quests.set("Quests.test.text.name","The test quest.");
		}
		if(!Configuration.quests.contains("Quests.test.text.welcome")){
			Configuration.quests.set("Quests.test.text.welcome","Hello.");
		}
		if(!Configuration.quests.contains("Quests.test.text.between")){
			Configuration.quests.set("Quests.test.text.between","This quest is accepted but doesn't meet the requirements.");
		}
		if(!Configuration.quests.contains("Quests.test.text.end")){
			Configuration.quests.set("Quests.test.text.end","Congrats, you have finished the test quest.");
		}
		if(!Configuration.quests.contains("Quests.test.text.task")){
			Configuration.quests.set("Quests.test.text.task","Bake a cake and bring it here.");
		}
	}
}
