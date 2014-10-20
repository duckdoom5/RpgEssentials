package me.duckdoom5.RpgEssentials.RpgQuests.Config;

public class QuestConfig {
    public static void set() {
        if (!Configuration.quests.contains("Quests.test.text.name")) {
            Configuration.quests.set("Quests.test.text.name", "The test quest.");
        }
        if (!Configuration.quests.contains("Quests.test.text.welcome")) {
            Configuration.quests.set("Quests.test.text.welcome", "Hello.");
        }
        if (!Configuration.quests.contains("Quests.test.text.between")) {
            Configuration.quests.set("Quests.test.text.between", "This quest is accepted but doesn't meet the requirements.");
        }
        if (!Configuration.quests.contains("Quests.test.text.end")) {
            Configuration.quests.set("Quests.test.text.end", "Congrats, you have finished \"The test quest\".");
        }
        if (!Configuration.quests.contains("Quests.test.text.task")) {
            Configuration.quests.set("Quests.test.text.task", "Break a stone block, place a stone block and kill a zombie.");
        }
        if (!Configuration.quests.contains("Quests.test.repeatable")) {
            Configuration.quests.set("Quests.test.repeatable", true);
        }
        if (!Configuration.quests.contains("Quests.test.task.place.1.amount")) {
            Configuration.quests.set("Quests.test.task.place.1.amount", 1);
        }
        if (!Configuration.quests.contains("Quests.test.task.break.1.amount")) {
            Configuration.quests.set("Quests.test.task.break.1.amount", 1);
        }
        if (!Configuration.quests.contains("Quests.test.task.kill.zombie.amount")) {
            Configuration.quests.set("Quests.test.task.kill.zombie.amount", 1);
        }
        if (!Configuration.quests.contains("Quests.test.reward.354.amount")) {
            Configuration.quests.set("Quests.test.reward.354.amount", 10);
        }
        if (!Configuration.quests.contains("Quests.test.reward.xp")) {
            Configuration.quests.set("Quests.test.reward.xp", 100);
        }

        if (!Configuration.quests.contains("Quests.test2.text.name")) {
            Configuration.quests.set("Quests.test2.text.name", "The test quest 2.");
        }
        if (!Configuration.quests.contains("Quests.test2.text.welcome")) {
            Configuration.quests.set("Quests.test2.text.welcome", "Welcome back.");
        }
        if (!Configuration.quests.contains("Quests.test2.text.between")) {
            Configuration.quests.set("Quests.test2.text.between", "You didn't kill 20 zombies yet.");
        }
        if (!Configuration.quests.contains("Quests.test2.text.end")) {
            Configuration.quests.set("Quests.test2.text.end", "Congrats, you have finished \"The test quest 2\".");
        }
        if (!Configuration.quests.contains("Quests.test2.text.task")) {
            Configuration.quests.set("Quests.test2.text.task", "kill 20 zombies.");
        }
        if (!Configuration.quests.contains("Quests.test2.requires.quest")) {
            Configuration.quests.set("Quests.test2.requires.quest", "test");
        }
        if (!Configuration.quests.contains("Quests.test2.requires.level.questing")) {
            Configuration.quests.set("Quests.test2.requires.level.questing", 2);
        }
        if (!Configuration.quests.contains("Quests.test2.repeatable")) {
            Configuration.quests.set("Quests.test2.repeatable", false);
        }
        if (!Configuration.quests.contains("Quests.test2.task.kill.zombie.amount")) {
            Configuration.quests.set("Quests.test2.task.kill.zombie.amount", 20);
        }
        if (!Configuration.quests.contains("Quests.test.reward.Snow Wand.amount")) {
            Configuration.quests.set("Quests.test.reward.Snow Wand.amount", 1);
        }
        if (!Configuration.quests.contains("Quests.test2.reward.money")) {
            Configuration.quests.set("Quests.test2.reward.money", 200);
        }
        if (!Configuration.quests.contains("Quests.test2.reward.xp")) {
            Configuration.quests.set("Quests.test2.reward.xp", 1000);
        }
    }
}
