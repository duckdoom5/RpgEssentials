package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;

import com.topcat.npclib.entity.NPC;

public class Quest implements Serializable{
	private static final long serialVersionUID = -8500295442279652229L;
	private String id;
	private String name;
	private String startText;
	private String taskText;
	private String betweenText;
	private String completeText;
	private String doneText;
	private NPC questGiver;
	private NPC questEnder;
	
	private Set<Task> tasks = new LinkedHashSet<Task>();
	private Set<Reward> rewards = new LinkedHashSet<Reward>();
	
	public Quest(String id, String name, NPC questGiver, NPC questEnder){
		this.id = id;
		this.name = name;
		this.questGiver = questGiver;
		this.questEnder = questEnder;
	}
	
	public NPC getQuestGiver(){
		return questGiver;
	}
	
	public NPC getQuestEnder(){
		return questEnder;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStartText() {
		return startText;
	}

	public String getBetweenText() {
		return betweenText;
	}

	public String getCompleteText() {
		return completeText;
	}

	public String getDoneText() {
		return doneText;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}

	public void setCompleteText(String completeText) {
		this.completeText = completeText;
	}

	public void setBetweenText(String betweenText) {
		this.betweenText = betweenText;
	}

	public void setStartText(String startText) {
		this.startText = startText;
	}

	public Task[] getTasks(){
		return (Task[]) tasks.toArray();
	}
	
	public Reward[] getRewards(){
		return (Reward[]) rewards.toArray();
	}
	
	public Quest addTask(Task task){
		tasks.add(task);
		
		return this;
	}
	
	public Quest addReward(Reward reward){
		rewards.add(reward);
		
		return this;
	}
}
