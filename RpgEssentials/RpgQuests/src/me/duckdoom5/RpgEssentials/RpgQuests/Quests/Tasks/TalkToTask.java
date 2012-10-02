package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks;

public class TalkToTask extends Task{
	private static final long serialVersionUID = -5657034567850167694L;
	private String talkTo;
	private String text;
	private int id;
	
	public TalkToTask(int id, String talkTo, String text, String taskGiver, String taskEnder) {
		super(id, TaskType.TALKTO, taskGiver, taskEnder);
		this.text = text;
		this.id = id;
		this.talkTo = talkTo;
	}
	
	public String getNpcToTalkTo(){
		return talkTo;
	}
	
	public String getText(){
		return text;
	}
	
	public int getId(){
		return id;
	}

	public void setNpcToTalkTo(String talkTo) {
		this.talkTo = talkTo;
	}

	public void setText(String text) {
		this.text = text;
	}
}
