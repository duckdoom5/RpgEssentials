package me.duckdoom5.RpgEssentials.Entity;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
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
		
		this.attackExp = Configuration.players.getInt("players." + player.getName() + ".Attack.exp");
		this.attackLvl = Configuration.players.getInt("players." + player.getName() + ".Attack.level");
		this.combatLvl = Configuration.players.getInt("players." + player.getName() + ".combatlvl");
		this.constructionExp = Configuration.players.getInt("players." + player.getName() + ".Construction.exp");
		this.constructionLvl = Configuration.players.getInt("players." + player.getName() + ".Construction.level");
		this.cookingExp = Configuration.players.getInt("players." + player.getName() + ".Cooking.exp");
		this.cookingLvl = Configuration.players.getInt("players." + player.getName() + ".Cooking.level");
		this.defenseExp = Configuration.players.getInt("players." + player.getName() + ".Defense.exp");
		this.defenseLvl = Configuration.players.getInt("players." + player.getName() + ".Defense.level");
		this.excavationExp = Configuration.players.getInt("players." + player.getName() + ".Excavation.exp");
		this.excavationLvl = Configuration.players.getInt("players." + player.getName() + ".Excavation.level");
		this.farmingExp = Configuration.players.getInt("players." + player.getName() + ".Farming.exp");
		this.farmingLvl = Configuration.players.getInt("players." + player.getName() + ".Farming.level");
		this.firemakingExp = Configuration.players.getInt("players." + player.getName() + ".Firemaking.exp");
		this.firemakingLvl = Configuration.players.getInt("players." + player.getName() + ".Firemaking.level");
		this.fishingExp = Configuration.players.getInt("players." + player.getName() + ".Fishing.exp");
		this.fishingLvl = Configuration.players.getInt("players." + player.getName() + ".Fishing.level");
		this.miningExp = Configuration.players.getInt("players." + player.getName() + ".Mining.exp");
		this.miningLvl = Configuration.players.getInt("players." + player.getName() + ".Mining.level");
		this.questingExp = Configuration.players.getInt("players." + player.getName() + ".Questing.exp");
		this.questingLvl = Configuration.players.getInt("players." + player.getName() + ".Questing.level");
		this.rangedExp = Configuration.players.getInt("players." + player.getName() + ".Ranged.exp");
		this.rangedLvl = Configuration.players.getInt("players." + player.getName() + ".Ranged.level");
		this.smithingExp = Configuration.players.getInt("players." + player.getName() + ".Smithing.exp");
		this.smithingLvl = Configuration.players.getInt("players." + player.getName() + ".Smithing.level");
		this.woodcuttingExp = Configuration.players.getInt("players." + player.getName() + ".Woodcutting.exp");
		this.woodcuttingLvl = Configuration.players.getInt("players." + player.getName() + ".Woodcutting.level");
		
		this.SP = Configuration.players.getInt("players." + player.getName() + ".SP");
		for(World world :Bukkit.getWorlds()){
			this.texturepack.put(world.getName(), Configuration.players.getString("players." + player.getName() + "." + world.getName() + ".texturepack", "null"));
		}
		
		check();
		
		RpgEssentials.pm.addPlayer(playername, this);
	}
	
	public void check(){
		if(this.attackLvl == 0){
			this.attackLvl = 1;
		}
		if(this.combatLvl == 0){
			this.combatLvl = 3;
		}
		if(this.constructionLvl == 0){
			this.constructionLvl = 1;
		}
		if(this.cookingLvl == 0){
			this.cookingLvl = 1;
		}
		if(this.defenseLvl == 0){
			this.defenseLvl = 1;
		}
		if(this.excavationLvl == 0){
			this.excavationLvl = 1;
		}
		if(this.farmingLvl == 0){
			this.farmingLvl = 1;
		}
		if(this.firemakingLvl == 0){
			this.firemakingLvl = 1;
		}
		if(this.fishingLvl == 0){
			this.fishingLvl = 1;
		}
		if(this.miningLvl == 0){
			this.miningLvl = 1;
		}
		if(this.questingLvl == 0){
			this.questingLvl = 1;
		}
		if(this.rangedLvl == 0){
			this.rangedLvl = 1;
		}
		if(this.smithingLvl == 0){
			this.smithingLvl = 1;
		}
		if(this.woodcuttingLvl == 0){
			this.woodcuttingLvl = 1;
		}
		for(World world: Bukkit.getWorlds()){
			if(this.texturepack.get(world.getName()) == null){
				this.texturepack.put(world.getName(), "null");
			}
		}
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
		try {
			File file = new File("plugins/RpgEssentials/Temp/players");
			if(!file.exists()){
				file.mkdirs();
			}
			Configuration.save(this, "plugins/RpgEssentials/Temp/players/" +  playername + ".player");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
