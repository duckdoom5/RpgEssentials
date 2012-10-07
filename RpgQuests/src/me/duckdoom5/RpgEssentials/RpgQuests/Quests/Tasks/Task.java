package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.io.Serializable;

public class Task implements Serializable{
	private static final long serialVersionUID = 6271132498453001320L;
	private TaskType type;
	private String taskGiver = null;
	private String taskEnder = null;
	private int id;
	
	public Task(int id, TaskType type){
		this.id = id;
		this.type = type;
	}
	
	public Task(int id, TaskType type, String taskGiver, String taskEnder){
		this.type = type;
		this.id = id;
		this.taskGiver = taskGiver;
		this.taskEnder = taskEnder;
	}
	
	public String getTaskGiver(){
		return taskGiver;
	}
	
	public String getTaskEnder(){
		return taskEnder;
	}
	
	public void setTaskGiver(String taskGiver){
		this.taskGiver = taskGiver;
	}
	
	public void setTaskEnder(String taskEnder){
		this.taskEnder = taskEnder;
	}
	
	public TaskType getType(){
		return type;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public enum TaskType{
		BREAK, PLACE, DELIVER, CRAFT, SMELT, KILL, ESCORT, TALKTO;
	}
}
