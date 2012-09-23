package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

import java.io.Serializable;

import com.topcat.npclib.entity.NPC;

public class Task implements Serializable{
	private static final long serialVersionUID = 6271132498453001320L;
	private TaskType type;
	private NPC taskGiver = null;
	private NPC taskEnder = null;
	private int id;
	
	public Task(int id, TaskType type){
		this.id = id;
		this.type = type;
	}
	
	public Task(int id, TaskType type, NPC taskGiver, NPC taskEnder){
		this.type = type;
		this.id = id;
		this.taskGiver = taskGiver;
		this.taskEnder = taskEnder;
	}
	
	public NPC getTaskGiver(){
		return taskGiver;
	}
	
	public NPC getTaskEnder(){
		return taskEnder;
	}
	
	public void setTaskGiver(NPC taskGiver){
		this.taskGiver = taskGiver;
	}
	
	public void setTaskEnder(NPC taskEnder){
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
