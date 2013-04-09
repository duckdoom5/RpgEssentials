package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.getspout.spoutapi.player.SpoutPlayer;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.config.Configuration;


public class QuestManager {

	private HashMap<String,Quest> quests = new LinkedHashMap<String, Quest>();
	
	public HashMap<SpoutPlayer,Quest> createQuest = new LinkedHashMap<SpoutPlayer, Quest>();
	
	public HashMap<SpoutPlayer,Quest> editQuest = new LinkedHashMap<SpoutPlayer, Quest>();
	
	public HashMap<SpoutPlayer,Task> editTask = new LinkedHashMap<SpoutPlayer, Task>();
	
	public Set<SpoutPlayer> isCreating = new HashSet<SpoutPlayer>();
	
	public void saveQuests(){
		for(Quest quest:quests.values()){
			try {
				File file = new File("plugins/RpgQuests/Temp/quests");
				if(!file.exists()){
					file.mkdirs();
				}
				Configuration.save(quest, "plugins/RpgQuests/Temp/quests/" + quest.getId() + ".quest");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadQuests(){
		File dir = new File("plugins/RpgQuests/Temp/quests");
		String[] names = dir.list();
		if(names != null){
			for(String name:names){
				RpgQuests.log.info(name);
				try {
					Quest quest = (Quest) Configuration.load("plugins/RpgQuests/Temp/quests/" + name);
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
	
	public Quest[] getQuests(){
		return quests.values().toArray(new Quest[quests.values().size()]);
	}
	
	public boolean containsQuest(String questname){
		return quests.containsKey(questname);
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
		saveQuests();
		return true;
	}
	
	public void updateQuest(Quest quest){
		quests.put(quest.getId(), quest);
	}
	
	public boolean removeQuest(Quest quest){
		if(!quests.containsKey(quest.getId())){
			return false;
		}
		quests.remove(quest.getId());
		File file = new File("plugins/RpgQuests/Temp/quests/" + quest.getId() + ".quest");
		file.delete();
		return true;
	}
	
	public void setState(RpgPlayer rpgplayer, Quest quest, QuestState queststate){
		//rpgplayer.setQuestState(quest, queststate);
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
			/*if(rpgplayer.getTaskState(task).equals(TaskState.UNSTARTED)){
				if(task.getId() == id){
					current.add(task);
					
				}
			}*/
			if(id!=task.getId()){
				id = task.getId();
			}
		}
		return current;
	}
}
