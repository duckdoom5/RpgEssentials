package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import com.topcat.npclib.entity.NPC;

public class Reward{
	private RewardType type;
	private NPC rewardGiver;
	
	public Reward(RewardType type, NPC rewardGiver){
		this.type = type;
		this.rewardGiver = rewardGiver;
	}
	
	public NPC getRewardGiver(){
		return rewardGiver;
	}
	
	public RewardType getType(){
		return type;
	}
	
	public enum RewardType{
		XP, MONEY, MATERIAL;
	}
}
