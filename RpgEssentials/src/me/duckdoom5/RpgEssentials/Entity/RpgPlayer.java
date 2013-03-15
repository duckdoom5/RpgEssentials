package me.duckdoom5.RpgEssentials.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.QuestState;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TaskState;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgPlayer implements Serializable{
	private static final long serialVersionUID = 786344759340289923L;
	
	private HashMap<Quest, QuestState> quests = new HashMap<Quest, QuestState>();
	private HashMap<Task, TaskState> tasks = new HashMap<Task, TaskState>();
	
	private String playername;
	private String title;
	
	private int attackExp, attackLvl;
	private int combatLvl;
	private int constructionExp, constructionLvl;
	private int cookingExp, cookingLvl;
	private int defenseExp, defenseLvl;
	private int excavationLvl, excavationExp;
	private int farmingExp, farmingLvl;
	private int firemakingExp, firemakingLvl;
	private int fishingExp, fishingLvl;
	private int miningExp, miningLvl;
	private int questingExp, questingLvl;
	private int rangedExp, rangedLvl;
	private int smithingExp, smithingLvl;
	private int woodcuttingExp, woodcuttingLvl;
	
	private int SP;
	
	private HashMap<String, String> texturepack = new HashMap<String, String>();
	
	public RpgPlayer(Player player) {
		this.playername = player.getName();
		this.title = Configuration.players.getString("players." + player.getName() + ".title");
		
		this.attackLvl = 1;
		this.combatLvl = 3;
		this.constructionLvl = 1;
		this.cookingLvl = 1;
		this.defenseLvl = 1;
		this.excavationLvl = 1;
		this.farmingLvl = 1;
		this.firemakingLvl = 1;
		this.fishingLvl = 1;
		this.miningLvl = 1;
		this.questingLvl = 1;
		this.rangedLvl = 1;
		this.smithingLvl = 1;
		this.woodcuttingLvl = 1;
		
		this.SP = Configuration.players.getInt("players." + player.getName() + ".SP");
		
		for(World world: Bukkit.getWorlds()){
			if(this.texturepack.get(world.getName()) == null){
				this.texturepack.put(world.getName(), "null");
			}
		}
		
		RpgEssentials.pm.addPlayer(playername, this);
	}
	
	public Bank getBank(){
		return RpgEssentials.pm.getRpgPlayerBank(playername).getBank();
	}
	
	public QuestState getQuestState(Quest quest){
		if(!quests.containsKey(quest)){
			quests.put(quest, QuestState.UNSTARTED);
			return QuestState.UNSTARTED;
		}
		return quests.get(quest);
	}
	
	public void setQuestState(Quest quest, QuestState queststate){
		quests.put(quest, queststate);
	}
	
	public TaskState getTaskState(Task task){
		if(!tasks.containsKey(task)){
			tasks.put(task, TaskState.UNSTARTED);
			return TaskState.UNSTARTED;
		}
		return tasks.get(task);
	}
	
	public void setTaskState(Task task, TaskState taskstate){
		tasks.put(task, taskstate);
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
		save();
	}
	
	public Integer getSkillPoints(){
		return SP;
	}
	
	public void setSkillPoints(int SP){
		this.SP = SP;
		save();
	}
	
	public OfflinePlayer getPlayer(){
		return Bukkit.getOfflinePlayer(playername);
	}
	
	public SpoutPlayer getSpoutPlayer(){
		if(getPlayer().isOnline()){
			return SpoutManager.getPlayer((Player)getPlayer());
		}
		return null;
	}
	
	public String getName() {
		return playername;
	}
	
	public String getTexturepack(World world){
		return texturepack.get(world.getName());
	}
	
	public void setTexturepack(World world, String texturepack){
		this.texturepack.put(world.getName(), texturepack);
		save();
	}
	
	public Quest[] getStartedQuests(){
		List<Quest> started = new ArrayList<Quest>();
		
		for(Quest quest:quests.keySet()){
			if(quests.get(quest) == QuestState.STARTED){
				started.add(quest);
			}
		}
		return started.toArray(new Quest[started.size()]);
	}
	
	public int getLvl(Skill skill){
		switch(skill){
		case ATTACK:
			return attackLvl;
		case COMBAT:
			return combatLvl;
		case CONSTRUCTION:
			return constructionLvl;
		case COOKING:
			return cookingLvl;
		case DEFENSE:
			return defenseLvl;
		case EXCAVATION:
			return excavationLvl;
		case FARMING:
			return farmingLvl;
		case FIREMAKING:
			return firemakingLvl;
		case FISHING:
			return fishingLvl;
		case MAGIC:
			return 1; //no magic lvl yet
		case MINING:
			return miningLvl;
		case PRAYER:
			return 1; //no prayer lvl yet
		case QUESTING:
			return questingLvl;
		case RANGED:
			return rangedLvl;
		case SMITHING:
			return smithingLvl;
		case WOODCUTTING:
			return woodcuttingLvl;
		case STRENGTH:
			return 1;
		default:
			return 0;
		}
	}
	public void setLvl(Skill skill, int lvl){
		switch(skill){
		case ATTACK:
			this.attackLvl = lvl;
			break;
		case COMBAT:
			this.combatLvl = lvl;
			break;
		case CONSTRUCTION:
			this.constructionLvl = lvl;
			break;
		case COOKING:
			this.cookingLvl = lvl;
			break;
		case DEFENSE:
			this.defenseLvl = lvl;
			break;
		case EXCAVATION:
			this.excavationLvl = lvl;
			break;
		case FARMING:
			this.farmingLvl = lvl;
			break;
		case FIREMAKING:
			this.firemakingLvl = lvl;
			break;
		case FISHING:
			this.fishingLvl = lvl;
			break;
		case MAGIC:
			//this.magicLvl; //no magic lvl yet
			break;
		case MINING:
			this.miningLvl = lvl;
			break;
		case PRAYER:
			//this.prayerLvl; //no prayer lvl yet
			break;
		case QUESTING:
			this.questingLvl = lvl;
			break;
		case RANGED:
			this.rangedLvl = lvl;
			break;
		case SMITHING:
			this.smithingLvl = lvl;
			break;
		case WOODCUTTING:
			this.woodcuttingLvl = lvl;
			break;
		case STRENGTH:
			break;
		default:
			break;
		}
		save();
	}
	
	public int getExp(Skill skill){
		switch(skill){
		case ATTACK:
			return attackExp;
		case CONSTRUCTION:
			return constructionExp;
		case COOKING:
			return cookingExp;
		case DEFENSE:
			return defenseExp;
		case EXCAVATION:
			return excavationExp;
		case FARMING:
			return farmingExp;
		case FIREMAKING:
			return firemakingExp;
		case FISHING:
			return fishingExp;
		case MAGIC:
			return 0; //no magic lvl yet
		case MINING:
			return miningExp;
		case PRAYER:
			return 0; //no prayer lvl yet
		case QUESTING:
			return questingExp;
		case RANGED:
			return rangedExp;
		case SMITHING:
			return smithingExp;
		case WOODCUTTING:
			return woodcuttingExp;
		case COMBAT:
			return 0;
		case STRENGTH:
			return 0;
		default:
			return 0;
		}
	}
	public void setExp(Skill skill, int exp){
		switch(skill){
		case ATTACK:
			this.attackExp = exp;
			break;
		case CONSTRUCTION:
			this.constructionExp = exp;
			break;
		case COOKING:
			this.cookingExp = exp;
			break;
		case DEFENSE:
			this.defenseExp = exp;
			break;
		case EXCAVATION:
			this.excavationExp= exp;
			break;
		case FARMING:
			this.farmingExp = exp;
			break;
		case FIREMAKING:
			this.firemakingExp = exp;
			break;
		case FISHING:
			this.fishingExp = exp;
			break;
		case MAGIC:
			//this.magicExp = exp; //no magic lvl yet
			break;
		case MINING:
			this.miningExp = exp;
			break;
		case PRAYER:
			//this.prayerExp = exp; //no prayer lvl yet
			break;
		case QUESTING:
			this.questingExp = exp;
			break;
		case RANGED:
			this.rangedExp = exp;
			break;
		case SMITHING:
			this.smithingExp = exp;
			break;
		case WOODCUTTING:
			this.woodcuttingExp = exp;
			break;
		case COMBAT:
			break;
		case STRENGTH:
			break;
		default:
			break;
		}
		save();
	}
	
	private void save(){
		RpgEssentials.pm.savePlayer(playername);
	}
}
