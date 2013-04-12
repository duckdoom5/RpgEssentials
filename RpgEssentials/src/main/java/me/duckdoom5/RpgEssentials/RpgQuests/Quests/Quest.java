package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards.Reward;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;

public class Quest implements Serializable{
	private static final long serialVersionUID = -8500295442279652229L;
	private String id;
	private String name;
	private String startText = "default text";
	private String taskText = "do this task";
	private String betweenText = "between";
	private String completeText = "completed!";
	private String doneText = "done!";
	private String questGiver;
	private String questEnder;
	
	private Set<Task> tasks = new LinkedHashSet<Task>();
	private Set<Reward> rewards = new LinkedHashSet<Reward>();
	
	public Quest(String id, String name, String questGiver, String questEnder, String startText, String taskText, String betweenText, String completeText, String doneText){
		this.id = id;
		this.name = name;
		this.questGiver = questGiver;
		this.questEnder = questEnder;
		this.startText = startText;
		this.taskText = taskText;
		this.betweenText = betweenText;
		this.completeText = completeText;
		this.doneText = doneText;
	}
	
	public String getQuestGiver(){
		return questGiver;
	}
	
	public String getQuestEnder(){
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
		return tasks.toArray(new Task[tasks.size()]);
	}
	
	public Reward[] getRewards(){
		return rewards.toArray(new Reward[rewards.size()]);
	}
	
	public Quest addTask(Task task){
		tasks.add(task);
		
		return this;
	}
	
	public Quest addReward(Reward reward){
		rewards.add(reward);
		
		return this;
	}

	public boolean hasTask() {
		return !tasks.isEmpty();
	}
	
	public boolean hasReward() {
		return !rewards.isEmpty();
	}

	public Quest setId(String id) {
		this.id = id;
		return this;
	}

	public Quest setName(String name) {
		this.name = name;
		return this;
	}

	public Quest setQuestGiver(String questGiver) {
		this.questGiver = questGiver;
		return this;
	}

	public Quest setQuestEnder(String questEnder) {
		this.questEnder = questEnder;
		return this;
	}

	public void removeTask(Task task) {
		tasks.remove(task);
	}
	
	public void removeReward(Reward reward) {
		rewards.remove(reward);
	}
}
