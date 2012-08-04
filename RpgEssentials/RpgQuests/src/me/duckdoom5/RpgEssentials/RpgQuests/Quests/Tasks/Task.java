package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import com.topcat.npclib.entity.NPC;

public class Task{
	private TaskType type;
	private NPC taskGiver = null;
	private NPC taskEnder = null;
	private int id;
	
	public Task(int id, TaskType type){
		this.type = type;
	}
	
	public Task(int id, TaskType type, NPC taskGiver, NPC taskEnder){
		this.type = type;
		this.taskGiver = taskGiver;
		this.taskEnder = taskEnder;
	}
	
	public NPC getTaskGiver(){
		return taskGiver;
	}
	
	public NPC getTaskEnder(){
		return taskEnder;
	}
	
	public TaskType getType(){
		return type;
	}
	
	public int getId(){
		return id;
	}
	
	public enum TaskType{
		BREAK, PLACE, DELIVER, CRAFT, SMELT, KILL, ESCORT, TALKTO;
	}
}
