package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.MaterialReward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.MoneyReward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.XpReward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.BreakTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.CraftTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.DeliveryTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.EscortTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.KillTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.PlaceTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TalkToTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TaskState;
import me.duckdoom5.RpgEssentials.config.Configuration;


public class QuestManager {

	private HashMap<String,Quest> quests = new LinkedHashMap<String, Quest>();
	
	public void saveQuests(){
		for(Quest quest:quests.values()){
			try {
				Configuration.save(quest, "plugins/RpgQuests/Temp/quests/" + quest.getId() + ".quest");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadQuests(){
		File dir = new File("plugins/RpgQuests/Temp/quests/");
		String[] names = dir.list();
		if(names != null){
			for(String name:names){
				try {
					Quest quest = (Quest) Configuration.load("plugins/RpgQuests/Temp/quests/" + name + ".quest");
					addQuest(quest);
				} catch (FileNotFoundException e) {
					RpgEssentials.log.info(name + " is not found.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Quest getQuestByid(String id){
		if(quests.containsKey(id)){
			return quests.get(id);
		}
		return null;
	}
	
	public Collection<Quest> getQuests(){
		return quests.values();
	}
	
	/**
	 * Adds a new quest
	 * @param quest quest to be added
	 * @return returns false if quest exists.
	 */
	
	public boolean addQuest(Quest quest){
		if(quests.containsKey(quest.getId())){
			return false;
		}
		quests.put(quest.getId(), quest);
		return true;
	}
	
	public void updateQuest(Quest quest){
		quests.put(quest.getId(), quest);
	}
	
	public boolean removeQuest(Quest quest){
		if(!quests.containsKey(quest.getId())){
			quests.remove(quest.getId());
			return true;
		}
		return false;
	}
	
	public Quest createQuest(){
		Quest quest = new Quest("test", "The Test Quest", RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		
		Task task = new BreakTask(1, Material.STONE, 1, RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task2 = new DeliveryTask(2, Material.STONE, 1, RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task3 = new EscortTask(3, "valdren", RpgEssentials.nm.getNPC("bob2"), RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task4 = new KillTask(4, EntityType.SKELETON, 1, RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task5 = new PlaceTask(1, Material.STONE, 1, RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task6 = new TalkToTask(5, RpgEssentials.nm.getNPC("bob2"), "Hello. This should be a very long message, but the space is too short", RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		Task task7 = new CraftTask(6, Material.STONE, 1, RpgEssentials.nm.getNPC("bob"), RpgEssentials.nm.getNPC("bob"));
		
		Reward reward = new XpReward(Skill.QUESTING, 100, RpgEssentials.nm.getNPC("bob"));
		Reward reward2 = new MoneyReward(100, RpgEssentials.nm.getNPC("bob"));
		Reward reward3 = new MaterialReward(Material.CAKE, 10, RpgEssentials.nm.getNPC("bob"));
		Reward reward4 = new MaterialReward(Material.WOOD_SWORD, 1, RpgEssentials.nm.getNPC("bob"));
		
		quest.addTask(task).addTask(task2).addTask(task3).addTask(task4).addTask(task5).addTask(task6);
		quest.addReward(reward).addReward(reward2).addReward(reward3).addReward(reward4);
		
		return quest;
	}
	
	public void setState(RpgPlayer rpgplayer, Quest quest, QuestState queststate){
		rpgplayer.setQuestState(quest, queststate);
	}

	public Set<Task> orderById(Task[] tasks){
		Set<Task> set = new LinkedHashSet<Task>();
		int id = 0;
		while(set.size()!=tasks.length){
			for(Task task:tasks){
				if(id == task.getId()){
					set.add(task);
				}
			}
			id++;
		}
		
		return set;
	}
	
	public Set<Task> getCurrentTasks(Quest quest, RpgPlayer rpgplayer) {
		Set<Task> tasks = orderById(quest.getTasks());
		int id = 0;
		
		Set<Task> current = new LinkedHashSet<Task>();
		
		for(Task task:tasks){
			if(rpgplayer.getTaskState(task).equals(TaskState.UNSTARTED)){
				if(task.getId() == id){
					current.add(task);
					
				}
			}
			if(id!=task.getId()){
				id = task.getId();
			}
		}
		return current;
	}
}
