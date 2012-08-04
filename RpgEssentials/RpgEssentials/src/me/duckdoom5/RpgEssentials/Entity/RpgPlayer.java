package me.duckdoom5.RpgEssentials.Entity;

import java.io.Serializable;
import java.util.HashMap;

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
	
	private OfflinePlayer player;
	private String title;
	
	private int attackExp;
	private int attackLvl;
	private int combatLvl;
	private int constructionExp;
	private int constructionLvl;
	private int cookingExp;
	private int cookingLvl;
	private int defenseExp;
	private int defenseLvl;
	private int excavationLvl;
	private int excavationExp;
	private int farmingExp;
	private int farmingLvl;
	private int firemakingExp;
	private int firemakingLvl;
	private int fishingExp;
	private int fishingLvl;
	private int miningExp;
	private int miningLvl;
	private int questingExp;
	private int questingLvl;
	private int rangedExp;
	private int rangedLvl;
	private int smithingExp;
	private int smithingLvl;
	private int woodcuttingExp;
	private int woodcuttingLvl;
	private int SP;
	private HashMap<World, String> texturepack = new HashMap<World, String>();
	
	public RpgPlayer(Player player) {
		this.player = player;
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
			this.texturepack.put(world, Configuration.players.getString("players." + player.getName() + "." + world.getName() + ".texturepack", "null"));
		}
		
		check();
		
		RpgEssentials.pm.addPlayer(player, this);
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
			if(this.texturepack.get(world) == null){
				this.texturepack.put(world, "null");
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
		return player;
	}
	
	public String getTexturepack(World world){
		return texturepack.get(world);
	}
	
	public void setTexturepack(World world, String texturepack){
		this.texturepack.put(world, texturepack);
		save();
	}
	
	public int getLvl(Skill skill){
		if(skill == Skill.ATTACK){
			return attackLvl;
		}else if(skill == Skill.COMBAT){
			return combatLvl;
		}else if(skill == Skill.CONSTRUCTION){
			return constructionLvl;
		}else if(skill == Skill.COOKING){
			return cookingLvl;
		}else if(skill == Skill.DEFENSE){
			return defenseLvl;
		}else if(skill == Skill.EXCAVATION){
			return excavationLvl;
		}else if(skill == Skill.FARMING){
			return farmingLvl;
		}else if(skill == Skill.FIREMAKING){
			return firemakingLvl;
		}else if(skill == Skill.FISHING){
			return fishingLvl;
		}else if(skill == Skill.MAGIC){
			return 1; //no magic lvl yet
		}else if(skill == Skill.MINING){
			return miningLvl;
		}else if(skill == Skill.PRAYER){
			return 1; //no prayer lvl yet
		}else if(skill == Skill.QUESTING){
			return questingLvl;
		}else if(skill == Skill.RANGED){
			return rangedLvl;
		}else if(skill == Skill.SMITHING){
			return smithingLvl;
		}else if(skill == Skill.WOODCUTTING){
			return woodcuttingLvl;
		}
		return 0;
	}
	public void setLvl(Skill skill, int lvl){
		if(skill == Skill.ATTACK){
			this.attackLvl = lvl;
		}else if(skill == Skill.COMBAT){
			this.combatLvl = lvl;
		}else if(skill == Skill.CONSTRUCTION){
			this.constructionLvl = lvl;
		}else if(skill == Skill.COOKING){
			this.cookingLvl = lvl;
		}else if(skill == Skill.DEFENSE){
			this.defenseLvl = lvl;
		}else if(skill == Skill.EXCAVATION){
			this.excavationLvl = lvl;
		}else if(skill == Skill.FARMING){
			this.farmingLvl = lvl;
		}else if(skill == Skill.FIREMAKING){
			this.firemakingLvl = lvl;;
		}else if(skill == Skill.FISHING){
			this.fishingLvl = lvl;
		}else if(skill == Skill.MAGIC){
			//this.magicLvl; //no magic lvl yet
		}else if(skill == Skill.MINING){
			this.miningLvl = lvl;
		}else if(skill == Skill.PRAYER){
			//this.prayerLvl; //no prayer lvl yet
		}else if(skill == Skill.QUESTING){
			this.questingLvl = lvl;
		}else if(skill == Skill.RANGED){
			this.rangedLvl = lvl;
		}else if(skill == Skill.SMITHING){
			this.smithingLvl = lvl;
		}else if(skill == Skill.WOODCUTTING){
			this.woodcuttingLvl = lvl;
		}
		save();
	}
	
	public int getExp(Skill skill){
		if(skill == Skill.ATTACK){
			return attackExp;
		}else if(skill == Skill.CONSTRUCTION){
			return constructionExp;
		}else if(skill == Skill.COOKING){
			return cookingExp;
		}else if(skill == Skill.DEFENSE){
			return defenseExp;
		}else if(skill == Skill.EXCAVATION){
			return excavationExp;
		}else if(skill == Skill.FARMING){
			return farmingExp;
		}else if(skill == Skill.FIREMAKING){
			return firemakingExp;
		}else if(skill == Skill.FISHING){
			return fishingExp;
		}else if(skill == Skill.MAGIC){
			return 0; //no magic lvl yet
		}else if(skill == Skill.MINING){
			return miningExp;
		}else if(skill == Skill.PRAYER){
			return 0; //no prayer lvl yet
		}else if(skill == Skill.QUESTING){
			return questingExp;
		}else if(skill == Skill.RANGED){
			return rangedExp;
		}else if(skill == Skill.SMITHING){
			return smithingExp;
		}else if(skill == Skill.WOODCUTTING){
			return woodcuttingExp;
		}
		return 0;
	}
	public void setExp(Skill skill, int exp){
		if(skill == Skill.ATTACK){
			this.attackExp = exp;
		}else if(skill == Skill.CONSTRUCTION){
			this.constructionExp = exp;
		}else if(skill == Skill.COOKING){
			this.cookingExp = exp;
		}else if(skill == Skill.DEFENSE){
			this.defenseExp = exp;
		}else if(skill == Skill.EXCAVATION){
			this.excavationExp= exp;
		}else if(skill == Skill.FARMING){
			this.farmingExp = exp;
		}else if(skill == Skill.FIREMAKING){
			this.firemakingExp = exp;;
		}else if(skill == Skill.FISHING){
			this.fishingExp = exp;
		}else if(skill == Skill.MAGIC){
			//this.magicExp = exp; //no magic lvl yet
		}else if(skill == Skill.MINING){
			this.miningExp = exp;
		}else if(skill == Skill.PRAYER){
			//this.prayerExp = exp; //no prayer lvl yet
		}else if(skill == Skill.QUESTING){
			this.questingExp = exp;
		}else if(skill == Skill.RANGED){
			this.rangedExp = exp;
		}else if(skill == Skill.SMITHING){
			this.smithingExp = exp;
		}else if(skill == Skill.WOODCUTTING){
			this.woodcuttingExp = exp;
		}
		save();
	}
	
	private void save(){
		try {
			Configuration.save(this, "plugins/RpgEssentials/Temp/players/" + player.getPlayer().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void save2(){
		Configuration.players.set("players." + player.getName() + ".title", this.title);
		
		Configuration.players.set("players." + player.getName() + ".Attack.exp", this.attackExp);
		Configuration.players.set("players." + player.getName() + ".Attack.level", this.attackLvl);
		Configuration.players.set("players." + player.getName() + ".combatlvl", this.combatLvl);
		Configuration.players.set("players." + player.getName() + ".Construction.exp", this.constructionExp);
		Configuration.players.set("players." + player.getName() + ".Construction.level", this.constructionLvl);
		Configuration.players.set("players." + player.getName() + ".Cooking.exp", this.cookingExp);
		Configuration.players.set("players." + player.getName() + ".Cooking.level", this.cookingLvl);
		Configuration.players.set("players." + player.getName() + ".Defense.exp", this.defenseExp);
		Configuration.players.set("players." + player.getName() + ".Defense.level", this.defenseLvl);
		Configuration.players.set("players." + player.getName() + ".Excavation.exp", this.excavationExp);
		Configuration.players.set("players." + player.getName() + ".Excavation.level", this.excavationLvl);
		Configuration.players.set("players." + player.getName() + ".Farming.exp", this.farmingExp);
		Configuration.players.set("players." + player.getName() + ".Farming.level", this.farmingLvl);
		Configuration.players.set("players." + player.getName() + ".Firemaking.exp", this.firemakingExp);
		Configuration.players.set("players." + player.getName() + ".Firemaking.level", this.firemakingLvl);
		Configuration.players.set("players." + player.getName() + ".Fishing.exp", this.fishingExp);
		Configuration.players.set("players." + player.getName() + ".Fishing.level", this.fishingLvl);
		Configuration.players.set("players." + player.getName() + ".Mining.exp", this.miningExp);
		Configuration.players.set("players." + player.getName() + ".Mining.level", this.miningLvl);
		Configuration.players.set("players." + player.getName() + ".Questing.exp", this.questingExp);
		Configuration.players.set("players." + player.getName() + ".Questing.level", this.questingLvl);
		Configuration.players.set("players." + player.getName() + ".Ranged.exp", this.rangedExp);
		Configuration.players.set("players." + player.getName() + ".Ranged.level", this.rangedLvl);
		Configuration.players.set("players." + player.getName() + ".Smithing.exp", this.smithingExp);
		Configuration.players.set("players." + player.getName() + ".Smithing.level", this.smithingLvl);
		Configuration.players.set("players." + player.getName() + ".Woodcutting.exp", this.woodcuttingExp);
		Configuration.players.set("players." + player.getName() + ".Woodcutting.level", this.woodcuttingLvl);
		Configuration.players.set("players." + player.getName() + ".SP", this.SP);
		for(World world:Bukkit.getWorlds()){
			Configuration.players.set("players." + player.getName() +  "." + world.getName() + ".texturepack", this.texturepack.get(world));
		}
		
		try {
			Configuration.players.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
